OB.MobileApp.model.hookManager.registerHook('OBPOS_PreCustomerSave', function (args, c) {

	var channelid= args.meObject.$.customerAttributes.$.line_bpchannelcombo.$.newAttribute.$.bpchannelcombo.$.customerCombo.getValue();

	args.meObject.$.customerAttributes.$.line_bpchannelcombo.$.newAttribute.$.bpchannelcombo.$.customerCombo.setSelectedValue(channelid,'searchKey');

//	args.meObject.$.customerAttributes.$.line_customerTaxId.$.newAttribute.$.customerTaxId.setValue([cedula]);
	args.passValidation = true;
	args.meObject.saveCustomer(args.inSender, args.inEvent);
	
	OB.MobileApp.model.hookManager.callbackExecutor(args, c);
});
