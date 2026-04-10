/*OB.UTIL.HookManager.registerHook('OBPOS_PreCustomerSave', function (args, callbacks) {
	// Extension to the customer save process
	var salesZoneSelected = args.meObject.$.customerAttributes.$.line_customerSalesZone.$.newAttribute.$.customerSalesZone.getValue();

	if (salesZoneSelected === "0" || salesZoneSelected == null) {
		args.passValidation = false;
		OB.UTIL.showConfirmation.display('El campo Zona de Venta no puede quedar vac\u00EDo');
	} else {
		localStorage.setItem("salesRegion", salesZoneSelected);
		args.passValidation = true;
	}

	OB.UTIL.HookManager.callbackExecutor(args, callbacks);
});*/

OB.UTIL.HookManager.registerHook('OBPOS_OrderDetailContentHook', function (args, callbacks) {
	const renderSalesZoneSelector = OB.MobileApp.view.$.containerWindow.$.pointOfSale.$.customerCreateAndEdit.$.body.$.edit_createcustomers_impl;
	renderSalesZoneSelector?.loadSalesZones();

	const renderSalesZoneSelectorAddr = OB.MobileApp.view.$.containerWindow.$.pointOfSale.$.customerAddrCreateAndEdit.$.body.$.edit_createcustomers_impl;
	renderSalesZoneSelectorAddr?.loadSalesZones();

	OB.UTIL.HookManager.callbackExecutor(args, callbacks);
});
