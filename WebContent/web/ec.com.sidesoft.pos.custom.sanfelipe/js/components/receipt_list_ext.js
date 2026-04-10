OB.UI.ReceiptsList.extend({
  searchAction: function (inSender, inEvent) {
    var me = this;

    function errorCallback(tx, error) {
      me.$.renderLoading.hide();
      me.receiptList.reset();
      me.$.openreceiptslistitemprinter.$.tempty.show();
      me.doHideSelector();
      var i, message, tokens;

      function getProperty(property) {
        return OB.Model.OrderFilter.getProperties().find(function (prop) {
          return prop.name === property || prop.sortName === property;
        });
      }

      // Generate a generic message if error is not defined
      if (
        OB.UTIL.isNullOrUndefined(error) ||
        OB.UTIL.isNullOrUndefined(error.message)
      ) {
        error = {
          message: OB.I18N.getLabel('OBMOBC_MsgApplicationServerNotAvailable'),
        };
      }

      if (error.message.startsWith('###')) {
        tokens = error.message.split('###');
        message = [];
        for (i = 0; i < tokens.length; i++) {
          if (tokens[i] !== '') {
            if (
              tokens[i] === 'OBMOBC_FilteringNotAllowed' ||
              tokens[i] === 'OBMOBC_SortingNotAllowed'
            ) {
              message.push({
                content: OB.I18N.getLabel(tokens[i]),
                style: 'text-align: left; padding-left: 8px;',
              });
            } else {
              var property = getProperty(tokens[i]);
              if (property) {
                message.push({
                  content: OB.I18N.getLabel(property.caption),
                  style: 'text-align: left; padding-left: 8px;',
                  tag: 'li',
                });
              }
            }
          }
        }
      } else {
        message = error.message;
      }

      OB.UTIL.showConfirmation.display(
        OB.I18N.getLabel('OBMOBC_Error'),
        message,
        null,
        {
          onHideFunction: function () {
            me.doShowSelector();
          },
        }
      );
    }

    function successCallback(data) {
      me.$.renderLoading.hide();
      if (data && data.length > 0) {
        me.receiptList.reset(data.models);
        me.$.openreceiptslistitemprinter.$.tbody.show();
      } else {
        me.receiptList.reset();
        me.$.openreceiptslistitemprinter.$.tempty.show();
      }
    }
    this.$.openreceiptslistitemprinter.$.tempty.hide();
    this.$.openreceiptslistitemprinter.$.tbody.hide();
    this.$.openreceiptslistitemprinter.$.tlimit.hide();
    this.$.renderLoading.show();

    var criteria = {};

    if (inEvent.orderby) {
      criteria._orderByProperties = [
        {
          property: inEvent.orderby.sortName
            ? inEvent.orderby.sortName
            : inEvent.orderby.name,
          sorting: inEvent.orderby.direction,
        },
      ];
    } else {
      criteria._orderByClause = 'orderDateFrom desc, documentNo desc';
    }

    criteria.forceRemote = true;

    if (OB.MobileApp.model.hasPermission('OBPOS_orderLimit', true)) {
      criteria._limit = OB.DEC.abs(
        OB.MobileApp.model.hasPermission('OBPOS_orderLimit', true)
      );
    }

    criteria.remoteFilters = [];

    inEvent.filters.forEach(function (flt) {
      var fullFlt = _.find(
        OB.Model.OrderFilter.getProperties(),
        function (col) {
          return col.column === flt.column;
        }
      );

      if (flt.hqlFilter) {
        criteria.remoteFilters.push({
          value: flt.hqlFilter,
          columns: [fullFlt.name],
          operator: OB.Dal.FILTER,
          params: [flt.value],
        });
      } else {
        criteria.remoteFilters.push({
          value: flt.value,
          columns: [fullFlt.name],
          operator: flt.operator || OB.Dal.STARTSWITH,
          isId: flt.column === 'orderType' || flt.isId,
        });
      }
      if (flt.column === 'orderType' && flt.value === 'QT') {
        //When filtering by quotations, use the specific documentType filter
        criteria.remoteFilters.push({
          value:
            OB.MobileApp.model.get('terminal').terminalType
              .documentTypeForQuotations,
          columns: ['documentTypeId'],
          operator: '=',
          isId: true,
        });
      }
    });

    criteria.remoteFilters.push({
      value: OB.POS.modelterminal.get('terminal').isdomicilie || false,
      columns: ['domicilie'],
      params: 'domicilie',
    });

    OB.Dal.find(
      OB.Model.OrderFilter,
      criteria,
      function (data) {
        if (data) {
          successCallback(data);
        } else {
          errorCallback();
        }
      },
      errorCallback
    );
  },
});
