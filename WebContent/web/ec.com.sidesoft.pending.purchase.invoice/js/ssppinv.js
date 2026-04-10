isc.defineClass('SSPPINV_Confirm', isc.OBPopup);
isc.SSPPINV_Confirm.addProperties({
  width: 320,
  height: 200,
  title: null,
  showMinimizeButton: false,
  showMaximizeButton: false,

  view: null,
  params: null,
  actionHandler: null,

  mainform: null,
  okButton: null,
  cancelButton: null,

  initWidget: function () {
    this.mainform = isc.Label.create({
      height: 1,
      width: 300,
      overflow: 'visible',
      align: "center",
      valign: "center",
      contents: '¿Desea generar la propuesta de pago? '
    });

    this.okButton = isc.OBFormButton.create({
      title: 'Aceptar',
      popup: this,
      action: function () {
        var callback = function (rpcResponse, data, rpcRequest) {

          if (data.status == 'OK') {
            isc.say('Propuesta de pago generada con éxito');
          } else {
            isc.say('Error al intentar generar la propuesta de pago<br>' + data.message);
          }

          rpcRequest.clientContext.popup.closeClick();
          rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
        };

        OB.RemoteCallManager.call(this.popup.actionHandler, {
          rows: this.popup.rows,
        }, {}, callback, { popup: this.popup });
      }
    });

    this.cancelButton = isc.OBFormButton.create({
      title: 'Cancelar',
      popup: this,
      action: function () {
        this.popup.closeClick();
      }
    });

    this.items = [
      isc.VLayout.create({
        defaultLayoutAlign: "center",
        align: "center",
        width: "100%",
        layoutMargin: 10,
        membersMargin: 6,
        members: [
          isc.HLayout.create({
            defaultLayoutAlign: "center",
            align: "center",
            layoutMargin: 30,
            membersMargin: 6,
            members: this.mainform
          }),
          isc.HLayout.create({
            defaultLayoutAlign: "center",
            align: "center",
            membersMargin: 10,
            members: [this.okButton, this.cancelButton]
          })
        ]
      })
    ];

    this.Super('initWidget', arguments);
  }
});

OB.OBEXAPP = OB.OBEXAPP || {};

OB.OBEXAPP.SSPPINV = {
  passSelected: function (params, view) {
    var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
      rows = [],
      callback;

    callback = function (rpcResponse, data, rpcRequest) {
      params.button.contextView.viewGrid.refreshGrid();
    };

    for (i = 0; i < selection.length; i++) {
      rows.push(selection[i][OB.Constants.ID]);
    };

    OB.RemoteCallManager.call('ec.com.sidesoft.pending.purchase.invoice.ad_actions.PassSelectedActionHandler', {
      rows: rows,
    }, {}, callback);
  },

  onPassSelected: function (params, view) {
    OB.OBEXAPP.SSPPINV.passSelected(params, view);
  },

  onGeneratePaymentProposal: function (params, view) {
    var i, selection = params.button.contextView.viewGrid.getSelectedRecords(), rows = [];

    for (i = 0; i < selection.length; i++) {
      rows.push(selection[i][OB.Constants.ID]);
    };

    isc.SSPPINV_Confirm.create({
      view: view,
      params: params,
      actionHandler: 'ec.com.sidesoft.pending.purchase.invoice.ad_actions.GeneratePaymentProposalActionHandler',
      rows: rows,
    }).show();
  },
};
