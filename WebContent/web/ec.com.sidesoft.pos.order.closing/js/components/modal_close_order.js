/*global OB, enyo */

(function () {
  enyo.kind({
    kind: 'OB.UI.ModalDialogButton',
    name: 'OB.UI.ReceiptPropertiesDialogCloseOrder',
    closereason: '',
    tap: function () {
      const closePopup = () => {
        if (
          this.owner.owner.args.callbackFn &&
          this.owner.owner.args.callbackFn instanceof Function
        ) {
          this.owner.owner.args.callbackFn();
        }
        this.doHideThisPopup();
        this.hide();
        OB.UTIL.showLoading(false);
      };
      if (!OB.UTIL.isNullOrUndefined(this.closereason)) {
        OB.UTIL.showLoading(true);
        const receipt = this.owner.owner.model,
          process = new OB.DS.Process(
            'ec.com.sidesoft.pos.order.closing.process.CloseOrder'
          );
        process.exec(
          {
            orderID: receipt.get('id'),
            closereason: this.closereason,
          },
          closePopup,
          closePopup
        );
      } else {
        closePopup();
      }
    },
    initComponents: function () {
      this.inherited(arguments);
      this.setContent(OB.I18N.getLabel('SSFOC_LblCerrar'));
      this.hide();
    },
    setCloseReason: function (reason) {
      this.closereason = reason;
    },
  });

  enyo.kind({
    kind: 'OB.UI.ModalDialogButton',
    name: 'OB.UI.ReceiptPropertiesDialogCancelCloseOrder',
    tap: function () {
      if (
        this.owner.owner.args.callbackFn &&
        this.owner.owner.args.callbackFn instanceof Function
      ) {
        this.owner.owner.args.callbackFn();
      }
      this.doHideThisPopup();
    },
    initComponents: function () {
      this.inherited(arguments);
      this.setContent(OB.I18N.getLabel('OBMOBC_LblCancel'));
    },
  });

  enyo.kind({
    name: 'OB.UI.ModalReceiptCloseReason',
    kind: 'OB.UI.ModalReceiptProperties',
    handlers: {
      onCloseCancelSelector: 'closeCancelSelector',
    },
    bodyButtons: {
      components: [
        {
          kind: 'OB.UI.ReceiptPropertiesDialogCloseOrder',
        },
        {
          kind: 'OB.UI.ReceiptPropertiesDialogCancelCloseOrder',
        },
      ],
    },
    newAttributes: [
      {
        kind: 'OB.UI.renderComboProperty',
        name: 'closeReceiptBox1',
        modelProperty: 'closereason',
        i18nLabel: 'SSFOC_CloseReason',
        retrievedPropertyForValue: 'id',
        retrievedPropertyForText: '_identifier',
        handlers: {
          onchange: 'selectChanged',
        },
        init: function (model) {
          this.collection = new OB.Collection.CloseReasonList();
          this.model = model;
          this.doLoadValueNeeded = true;
          this.fetchDataFunction();
        },
        loadValue: function () {
          if (this.doLoadValueNeeded) {
            OB.UI.renderComboProperty.prototype.loadValue.apply(
              this,
              arguments
            );
          }
        },
        fetchDataFunction: function (args) {
          var me = this;
          if (this.collection.length === 0) {
            OB.Dal.find(
              OB.Model.CloseReason,
              null,
              function (data) {
                if (me.destroyed) {
                  return;
                }
                data.unshift({
                  id: null,
                  _identifier: null,
                });
                me.dataReadyFunction(data, args);
              },
              function () {
                me.dataReadyFunction(null, args);
              },
              args
            );
          } else {
            me.dataReadyFunction(this.collection, args);
          }
        },
        selectChanged: function (inSender, inEvent) {
          const id = inSender.getValue();
          if (OB.UTIL.isNullOrUndefined(id) || id === '') {
            this.owner.owner.owner.owner.owner.$.bodyButtons.$.receiptPropertiesDialogCloseOrder.hide();
          } else {
            this.owner.owner.owner.owner.owner.$.bodyButtons.$.receiptPropertiesDialogCloseOrder.show();
          }
          this.owner.owner.owner.owner.owner.$.bodyButtons.$.receiptPropertiesDialogCloseOrder.setCloseReason(
            id
          );
        },
      },
    ],
    init: function (model) {
      this.setHeader(OB.I18N.getLabel('SSFOC_CloseReceiptTitle'));
      this.model = model.get('order');
      this.model.on(
        'change',
        function () {
          this.loadValue('closereason');
        },
        this
      );
    },
    executeOnShow: function () {
      this.$.bodyButtons.$.receiptPropertiesDialogCloseOrder.hide();
    }
  });

  OB.UI.WindowView.registerPopup('OB.OBPOSPointOfSale.UI.PointOfSale', {
    kind: 'OB.UI.ModalReceiptCloseReason',
    name: 'OB_UI_ModalReceiptCloseReason',
  });
})();
