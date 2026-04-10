/*global OB */

(function () {
    OB.UTIL.HookManager.registerHook('OBPOS_PostCustomerSave', (args, callbacks) => {
        var json = args.bpToSave.get('json'); 
        var process = new OB.DS.Process('ec.com.sidesoft.retail.partner.info.process.SPRPRI_RetailPartnerInfoProcess');
        setTimeout(() => {
            process.exec({
                json: json
            }, function (data) {
                if(data){
                    OB.UTIL.showError('Ocurrio un error al sincronizar los datos del celular.');
                }
            }, function (error) {
                OB.UTIL.showError('Ocurrio un error al sincronizar los datos del celular.');
                console.error(error);
            }
            )
        },1500);

        OB.MobileApp.model.hookManager.callbackExecutor(args, callbacks);

    });
  })();