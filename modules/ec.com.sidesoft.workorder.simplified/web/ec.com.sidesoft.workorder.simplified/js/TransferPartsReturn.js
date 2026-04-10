OB.OBEXAPP = OB.OBEXAPP || {};

OB.OBEXAPP.TransferPartsReturn = {
  execute: function (params, view) {
    var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
      rows = [],
      callback;

    callback = function (rpcResponse, data, rpcRequest) {
      console.log(data);
      console.log(data.status);
      if (data.status == 'ERROR'){
        console.log(data.message);
        isc.say(data.message);
      } else {
        isc.say('PROCESO EXITOSO!');
      }
      params.button.contextView.viewGrid.refreshGrid();
    };

    for (i = 0; i < selection.length; i++) {
      rows.push(selection[i][OB.Constants.ID]);
    };

    OB.RemoteCallManager.call('ec.com.sidesoft.workorder.simplified.ad_actions.TransferpartsreturnActionHandler', {
      rows: rows,
    }, {}, callback);
  },

  onTransferPartsReturn: function (params, view) {
    OB.OBEXAPP.TransferPartsReturn.execute(params, view);
  },
};