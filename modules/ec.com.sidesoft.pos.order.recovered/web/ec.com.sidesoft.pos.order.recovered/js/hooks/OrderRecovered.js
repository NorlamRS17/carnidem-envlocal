// /*global OB */

(function () {
    OB.UTIL.HookManager.registerHook('OBPOS_CheckPaymentApproval', (args, callbacks) => {
        OB.UTIL.showLoading(true);
        var cOrderId = args.context.get('order').get('id');
        var cDocNo = args.context.get('order').get('documentNo');
        var process = new OB.DS.Process('ec.com.sidesoft.pos.order.recovered.SPOR_ValidateOBPOSErrors');
        process.exec({
            orderid: cOrderId
        }, function (data) {
            if(data){
                OB.UTIL.showConfirmation.display('',OB.I18N.getLabel('SPOR_OrderContainErrors').replace('#',cDocNo),
                [{
                    label: OB.I18N.getLabel('OBMOBC_LblOk')
                }]
                );
                args.approved =  false;
            }
            OB.UTIL.HookManager.callbackExecutor(args, callbacks);
            OB.UTIL.showLoading(false);
        }, function (error) {
            OB.UTIL.showLoading(false);
            args.cancelOperation = true;
            OB.MobileApp.model.hookManager.callbackExecutor(args, c);
        }
        ) 
    });
  })();
  