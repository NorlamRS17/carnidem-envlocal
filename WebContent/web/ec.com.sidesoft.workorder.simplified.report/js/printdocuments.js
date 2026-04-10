OB.OBEXAPP = OB.OBEXAPP || {};
OB.OBEXAPP.PrintDocuments = {
  execute: function (params, view) {
    var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
      rows = [],
      callback;

    callback = function (rpcResponse, data, rpcRequest) {
      let result = '';

      // show result
      if (data.status == 'OK') {
        result += '<ul class="sscfre">';
        for (i = 0; i < data.files.length; i++) {
          const path = data.files[i].path + '/' + data.files[i].name + ".pdf";
          const uri = encodeURI(data.contextName + '/attachments/' + path);
          const a = '<a href="/' + uri + '" class="sscfre" target="_blank" onClick="window.open(this.href, this.target, \'width=600, height=750\'); return false;">' + data.files[i].name + '</a>'
          result += '<li class="sscfre">' + a + '</li>';
        }
        result += '</ul>';
      } else {
        result += data.message;
      }
      isc.say(result);
      // close process to refresh current view
      params.button.closeProcessPopup();
    };

    for (i = 0; i < selection.length; i++) {
      rows.push(selection[i][OB.Constants.ID]);
    };

    OB.RemoteCallManager.call('ec.com.sidesoft.workorder.simplified.report.ad_actions.PrintDocumentsActionHandler', {
      rows: rows,
      customerType: params.customerType
    }, {}, callback);
  },

  printdocuments: function (params, view) {
    params.customerType = 'R';
    OB.OBEXAPP.PrintDocuments.execute(params, view);
  },
};