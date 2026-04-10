isc.defineClass('SPROCTM_Confirm', isc.OBPopup);
isc.SPROCTM_Confirm.addProperties({
    width: 320,
    height: 200,
    title: null,
    showMinimizeButton: false,
    showMaximizeButton: false,

    view: null,
    params: null,
    actionHandler: null,

    mainform: null,
    includeStock: null,
    cancelButton: null,

    initWidget: function() {
        this.mainform = isc.Label.create({
            height: 1,
            width: 300,
            overflow: 'visible',
            align: "center",
            valign: "center",
            contents: '¿Desea incluir productos con stock? '
        });

        this.includeStock = isc.OBFormButton.create({
            title: 'Si incluye',
            popup: this,
            action: function() {
                var callback = function(rpcResponse, data, rpcRequest) {

                    /*if (data.status == 'OK') {
                        console.log(data);
                        isc.say('Necesidad creada correctamente. SI Incluye Stock');
                    } else {
                        isc.say('Error al intentar generar la propuesta de pago<br>' + data.message);
                    }*/
                    isc.say('Respuesta: ' + data.status);

                    rpcRequest.clientContext.popup.closeClick();
                    rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
                };

                OB.RemoteCallManager.call(this.popup.actionHandler, {
                    row_id: this.popup.row_id,
                    include_stock: 'Y',
                }, {}, callback, { popup: this.popup });
            }
        });

        this.noIncludeStock = isc.OBFormButton.create({
            title: 'No incluye',
            popup: this,
            action: function() {
                var callback = function(rpcResponse, data, rpcRequest) {
                    /*
                    if (data.status == 'OK') {
                        console.log(data);
                        isc.say('Necesidad creada correctamente. NO INCLYE STOCK');
                    } else {
                        isc.say('Error al intentar generar la propuesta de pago<br>' + data.message);
                    }
                    */
                    isc.say('Respeusta del proceso: ' + data.status);

                    rpcRequest.clientContext.popup.closeClick();
                    rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
                };

                OB.RemoteCallManager.call(this.popup.actionHandler, {
                    row_id: this.popup.row_id,
                    include_stock: 'N',
                }, {}, callback, { popup: this.popup });
            }
        });


        this.cancelButton = isc.OBFormButton.create({
            title: 'Cancelar',
            popup: this,
            action: function() {
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
                        members: [this.noIncludeStock, this.includeStock, this.cancelButton]
                    })
                ]
            })
        ];

        this.Super('initWidget', arguments);
    }
});

isc.defineClass('SPROCTM_Complete', isc.OBPopup);
isc.SPROCTM_Complete.addProperties({
    width: 320,
    height: 200,
    title: null,
    showMinimizeButton: false,
    showMaximizeButton: false,

    view: null,
    params: null,
    actionHandler: null,

    mainform: null,
    includeStock: null,
    cancelButton: null,

    initWidget: function() {
        this.mainform = isc.Label.create({
            height: 1,
            width: 300,
            overflow: 'visible',
            align: "center",
            valign: "center",
            contents: '¿Desea cambiar el estado de la transacción seleccionada? '
        });

        this.includeStock = isc.OBFormButton.create({
            title: 'Aceptar',
            popup: this,
            action: function() {
                var callback = function(rpcResponse, data, rpcRequest) {
                    isc.say(data.status);

                    rpcRequest.clientContext.popup.closeClick();
                    rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
                };

                OB.RemoteCallManager.call(this.popup.actionHandler, {
                    row_id: this.popup.row_id,
                }, {}, callback, { popup: this.popup });
            }
        });

       
        this.cancelButton = isc.OBFormButton.create({
            title: 'Cancelar',
            popup: this,
            action: function() {
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
                        members: [this.noIncludeStock, this.includeStock, this.cancelButton]
                    })
                ]
            })
        ];

        this.Super('initWidget', arguments);
    }
});

isc.defineClass('SPROCTM_Posted', isc.OBPopup);
isc.SPROCTM_Posted.addProperties({
    width: 320,
    height: 200,
    title: null,
    showMinimizeButton: false,
    showMaximizeButton: false,

    view: null,
    params: null,
    actionHandler: null,

    mainform: null,
    includeStock: null,
    cancelButton: null,

    initWidget: function() {
        this.mainform = isc.Label.create({
            height: 1,
            width: 300,
            overflow: 'visible',
            align: "center",
            valign: "center",
            contents: '¿Desea ejecutar el proceso de contabilidad para esta transacción? '
        });
        
		 
        
        this.includeStock = isc.OBFormButton.create({
            title: 'Aceptar',
            popup: this,
            action: function() {
                var callback = function(rpcResponse, data, rpcRequest) {
                    isc.say(data.status);
                    rpcRequest.clientContext.popup.closeClick();
                    rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
                };
                OB.RemoteCallManager.call(this.popup.actionHandler, {
                    row_id: this.popup.row_id,
                }, {}, callback, { popup: this.popup });
            }
        });
        this.cancelButton = isc.OBFormButton.create({
            title: 'Cancelar',
            popup: this,
            action: function() {
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
                        members: [this.noIncludeStock, this.includeStock, this.cancelButton]
                    })
                ]
            })
        ];

        this.Super('initWidget', arguments);
    }
});


isc.defineClass('SPROCTM_Posted2', isc.OBPopup);
isc.SPROCTM_Posted2.addProperties({
    width: 320,
    height: 200,
    title: null,
    showMinimizeButton: false,
    showMaximizeButton: false,

    view: null,
    params: null,
    actionHandler: null,

    mainform: null,
    includeStock: null,
    cancelButton: null,

    initWidget: function() {
        this.mainform = isc.Label.create({
            height: 1,
            width: 300,
            overflow: 'visible',
            align: "center",
            valign: "center",
            contents: '¿Descontabilizar transacción? '
        });
        
		 
        
        this.includeStock = isc.OBFormButton.create({
            title: 'Aceptar',
            popup: this,
            action: function() {
                var callback = function(rpcResponse, data, rpcRequest) {
                    isc.say(data.status);
                    rpcRequest.clientContext.popup.closeClick();
                    rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
                };
                OB.RemoteCallManager.call(this.popup.actionHandler, {
                    row_id: this.popup.row_id,
                }, {}, callback, { popup: this.popup });
            }
        });
        this.cancelButton = isc.OBFormButton.create({
            title: 'Cancelar',
            popup: this,
            action: function() {
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
                        members: [this.noIncludeStock, this.includeStock, this.cancelButton]
                    })
                ]
            })
        ];

        this.Super('initWidget', arguments);
    }
});


isc.defineClass('SPROCTM_All_Complete', isc.OBPopup);
isc.SPROCTM_All_Complete.addProperties({
    width: 320,
    height: 200,
    title: null,
    showMinimizeButton: false,
    showMaximizeButton: false,

    view: null,
    params: null,
    actionHandler: null,

    mainform: null,
    includeStock: null,
    cancelButton: null,

    initWidget: function() {
        this.mainform = isc.Label.create({
            height: 1,
            width: 300,
            overflow: 'visible',
            align: "center",
            valign: "center",
            contents: '¿Desea cambiar el estado de los detalles de la transacción seleccionada? '
        });

        this.includeStock = isc.OBFormButton.create({
            title: 'Aceptar',
            popup: this,
            action: function() {
                var callback = function(rpcResponse, data, rpcRequest) {
                    isc.say(data.status);

                    rpcRequest.clientContext.popup.closeClick();
                    rpcRequest.clientContext.popup.params.button.contextView.viewGrid.refreshGrid();
                };

                OB.RemoteCallManager.call(this.popup.actionHandler, {
                    row_id: this.popup.row_id,
                }, {}, callback, { popup: this.popup });
            }
        });

       
        this.cancelButton = isc.OBFormButton.create({
            title: 'Cancelar',
            popup: this,
            action: function() {
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
                        members: [this.noIncludeStock, this.includeStock, this.cancelButton]
                    })
                ]
            })
        ];

        this.Super('initWidget', arguments);
    }
});

OB.OBEXAPP = OB.OBEXAPP || {};

OB.OBEXAPP.SPROCTM = {

    onGenerateAddRequisitionProd: function(params, view) {
        console.log(params);

        console.log('Start onGenerateAddRequisitionProd');
        var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
            row_id = [];

        /*
        for (i = 0; i < selection.length; i++) {
            row_id.push(selection[i][OB.Constants.ID]);
        };
        */
        isc.SPROCTM_Confirm.create({
            view: view,
            params: params,
            actionHandler: 'ec.com.sidesoft.projects.complement.ad_actions.SproctmAddRequestActionHandler',
            row_id: selection[0][OB.Constants.ID], //row_id,
        }).show();
    },
    
    onCompleteDetailCostProj: function(params, view) {
        console.log(params);

        console.log('Start onCompleteDetailCostProj');
        var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
            row_id = [];

        isc.SPROCTM_Complete.create({
            view: view,
            params: params,
            actionHandler: 'ec.com.sidesoft.projects.complement.ad_actions.SproctmCompleteRequestActionHandler',
            row_id: selection[0][OB.Constants.ID], //row_id,
        }).show();
    },
    
    onProcesDetailCostProj: function(params, view) {
        console.log(params);
        console.log('Start onCompleteDetailCostProj');
        var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
            row_id = [];

        isc.SPROCTM_Posted.create({
            view: view,
            params: params,
            actionHandler: 'ec.com.sidesoft.projects.complement.ad_actions.SproctmPostedDetailsActionHandler',
            row_id: selection[0][OB.Constants.ID], //row_id - MO - CIF -MAQ
        }).show();
    },
    
    onProcesDetailCostProj2: function(params, view) {
        console.log(params);
        console.log('Start onCompleteDetailCostProj');
        var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
            row_id = [];

        isc.SPROCTM_Posted2.create({
            view: view,
            params: params,
            actionHandler: 'ec.com.sidesoft.projects.complement.ad_actions.SproctmPostedDetailsActionHandler',
            row_id: selection[0][OB.Constants.ID], //row_id - MO - CIF -MAQ
        }).show();
    },
    
    onCompleteAllDetailsTab: function(params, view) { // Tabs: MO - CIF -MAQ
        console.log(params);
        
        console.log('Start onCompleteAllDetailsTab');
        var i, selection = params.button.contextView.viewGrid.getSelectedRecords(),
            row_id = [];

        isc.SPROCTM_All_Complete.create({
            view: view,
            params: params,
            actionHandler: 'ec.com.sidesoft.projects.complement.ad_actions.SproctmCompleteAllRequestActionHandler',
            row_id: selection[0][OB.Constants.ID], //row_id,
        }).show();
        
    },
    
};
