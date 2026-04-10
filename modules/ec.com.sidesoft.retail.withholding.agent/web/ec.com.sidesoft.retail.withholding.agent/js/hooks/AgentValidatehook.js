OB.UTIL.HookManager.registerHook('OBPOS_CheckPaymentApproval', function (args, c) {

	var partnerAgent = args.context.attributes.order.attributes.bp.attributes.ssfpfiswithholdingagent;

	if (partnerAgent){
		OB.POS.terminal.$.containerWindow.getRoot().doShowPopup({
            popup: 'OB_UI_MessageDialog',
            args: {
              message: OB.I18N.getLabel('SREWHA_Error_WithholdingAgent')
            }
          });
		  args.cancellation = true;
		  OB.UTIL.HookManager.callbackExecutor(args, c);
		  //OB.MobileApp.model.hookManager.callbackExecutor(args, c);
	}else{
		args.cancellation = false;
		OB.UTIL.HookManager.callbackExecutor(args, c);
	}

	//OB.UTIL.HookManager.callbackExecutor(args, c);
});
