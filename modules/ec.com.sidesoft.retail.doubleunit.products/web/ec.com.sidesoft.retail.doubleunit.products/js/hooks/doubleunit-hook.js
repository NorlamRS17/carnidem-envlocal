OB.UTIL.HookManager.registerHook('OBPOS_PreAddProductToOrder', function (args, c) {
	var isLayaway = args.receipt.get('isLayaway') || false;
	var orderType = args.receipt.get('orderType') || 0;
	var productId = args.productToAdd.get('id');
	var criteria;
	var comm = "'";
	criteria = {
		_whereClause: 'where idproduct =' + comm + productId + comm,
		_orderByClause: '_identifier asc'
	};

	OB.Dal.find(OB.Model.DoubleUnit, criteria, function (data) {

		if (data.models && data.models.length > 0) {

			// EL PRODUCTO SELECCIONADO TIENE DOBLE UNIDAD CONFIGURADA
			OB.MobileApp.view.$.containerWindow.showPopup('SSDUP_ModalSetInfoOrder', {

				//Parameters
				// Receipt model is send to the popup
				receipt: args.receipt,
				productToAdd: args.productToAdd,

				// Callback will be invoked by the popup when all is ready.
				// passing it through arguments
				callback: function (cancel) {

					if (cancel) {
						// SE ELIMINA EL PRODUCTO DE LA LINEA
						for (var j = 0; args.receipt.get('lines').models.length > j; j++) {
							var lineDeleted = args.receipt.get('lines').at(j);
							if (args.productToAdd.id === lineDeleted.attributes.product.id) {
								args.receipt.deleteLine(lineDeleted, false);
							}
						}
						args.cancelOperation = true;
						OB.UTIL.HookManager.callbackExecutor(args, c);

					} else {

						// FUNCION QUE HACE LA CONSULTA EL STOCK EN EL SERVIDOR
						function executeCallToServer(changedModel) {
							var qtyvalidate = false;
							var serverCall = new OB.DS.Process('ec.com.sidesoft.retail.custom.stockvalidation.ExtStock.ExtStockChequer');
							var statusMessage = OB.UTIL.showStatus(OB.I18N.getLabel('OBPOSSV_GettingStockFromServer'));
							serverCall.exec({
								isLayaway: isLayaway,
								orderType: orderType,
								orderLine: changedModel,
								organization: OB.POS.modelterminal.get('terminal').organization
							}, function (data, message) {
								statusMessage.hide();
								if (data.qty > 0 && data.qty < 1) {
									qtyvalidate = true;
								}

								if (data.allowSell === false) {
									OB.UTIL.showConfirmation.display(OB.I18N.getLabel('OBPOSSV_modalHeader'), OB.I18N.getLabel('SSDUP_NoEnoughStock', [data.qty, changedModel.get('qty')]), null, {
										onHideFunction: function (popup) {
											if (data.allowSell === false && data.qty > 0) {
												for (var j = 0; args.receipt.get('lines').models.length > j; j++) {
													var lineDeleted = args.receipt.get('lines').at(j);
													if (args.productToAdd.id === lineDeleted.attributes.product.id) {
														lineDeleted.set('qty', data.qty);
														args.receipt.deleteLine(lineDeleted, false);
													}
												}
											} else {
												if (data.allowSell === false && data.qty <= 0) {
													for (var j = 0; args.receipt.get('lines').models.length > j; j++) {
														var lineDeleted = args.receipt.get('lines').at(j);
														if (args.productToAdd.id === lineDeleted.attributes.product.id) {
															args.receipt.deleteLine(lineDeleted, false);
														}
													}
												}
											}
										}
									});
								}
							}, function (error) {
								statusMessage.hide();
								OB.UTIL.showError(OB.I18N.getLabel('OBPOSSV_ErrorGettingStockFromServer'));
							});
						}

						for (var j = 0; args.receipt.get('lines').models.length > j; j++) {
							var lineDeleted = args.receipt.get('lines').at(j);
							if (args.productToAdd.id === lineDeleted.attributes.product.id) {
								var convertionRate = args.productToAdd.get('convertRate');
								var operationalQty = args.productToAdd.get('operationalQty');
								var unitId = args.productToAdd.get('unitId');
								var unitName = args.productToAdd.get('unitName');
								//var cantidad = (convertionRate * operationalQty).toFixed(3);
								var cantidad = operationalQty;
								lineDeleted.set('qty', Number(cantidad));
								lineDeleted.set('unitId', unitId);
								var changedModel = lineDeleted;

								if (OB.POS.modelterminal.get('connectedToERP')) {
									// CONSULTA EL STOCK EN EL SERVIDOR
									executeCallToServer(changedModel);
								} else {
									OB.UTIL.showWarning(OB.I18N.getLabel('OBPOSSV_CannotCheckOffline'));
								}
							}
						}

						args.cancelOperation = false;

						// ***************************************************
						// VERIFICO SI EL MODELO TIENE LINEAS
						// ***************************************************
						if (args.receipt.get('lines').models.length > 0) {

							for (var i = 0; args.receipt.get('lines').models.length > i; i++) {

								var line = args.receipt.get('lines').at(i);
								if (line) {
									var product = args.productToAdd.get('id');
									if (line.get('product').id === product) {
										var convertionRate = args.productToAdd.get('convertRate');
										var operationalQty = args.productToAdd.get('operationalQty');
										var unitId = args.productToAdd.get('unitId');
										var unitName = args.productToAdd.get('unitName');
										var cantidad = (convertionRate * operationalQty).toFixed(3);
										var descripcion = operationalQty + ' ' + unitName;

										args.qtyToAdd = Number(cantidad);
										line.set('unitId', unitId);
										line.set('unitName', unitName);
										line.set('operationalQty', Number(operationalQty));
										line.set('description', descripcion);
										line.set('qty', Number(cantidad));

										OB.UTIL.HookManager.callbackExecutor(args, c);
									}
								}
							}
						}
						// ***************************************************
						// ***************************************************
					}

				}

			});

		} else {

			// EL PRODUCTO SELECCIONADO NO TIENE DOBLE UNIDAD CONFIGURADA
			function executeCallToServer(changedModel) {
				var qtyvalidate = false;

				var serverCall = new OB.DS.Process('ec.com.sidesoft.retail.custom.stockvalidation.ExtStock.ExtStockChequer');
				var statusMessage = OB.UTIL.showStatus(OB.I18N.getLabel('OBPOSSV_GettingStockFromServer'));
				serverCall.exec({
					isLayaway: isLayaway,
					orderType: orderType,
					orderLine: changedModel,
					organization: OB.POS.modelterminal.get('terminal').organization
				}, function (data, message) {
					statusMessage.hide();
					if (data.qty > 0 && data.qty < 1) {
						qtyvalidate = true;
					}
					if (data.allowSell === false) {
						OB.UTIL.showConfirmation.display(OB.I18N.getLabel('OBPOSSV_modalHeader'), OB.I18N.getLabel('SSDUP_NoEnoughStock', [data.qty, changedModel.get('qty')]), null, {
							onHideFunction: function (popup) {

								if (data.allowSell === false) {

									for (var j = 0; args.receipt.get('lines').models.length > j; j++) {
										var lineDeleted = args.receipt.get('lines').at(j);
										if (args.productToAdd.id === lineDeleted.attributes.product.id) {
											args.receipt.deleteLine(lineDeleted, false);
										}
									}

								}

							}
						});

					}
				}, function (error) {
					statusMessage.hide();
					OB.UTIL.showError(OB.I18N.getLabel('OBPOSSV_ErrorGettingStockFromServer'));
				});
			}

			for (var j = 0; args.receipt.get('lines').models.length > j; j++) {
				var lineDeleted = args.receipt.get('lines').at(j);
				if (args.productToAdd.id === lineDeleted.attributes.product.id) {

					var changedModel = lineDeleted;

					if (OB.POS.modelterminal.get('connectedToERP')) {
						executeCallToServer(changedModel);
					} else {
						OB.UTIL.showWarning(OB.I18N.getLabel('OBPOSSV_CannotCheckOffline'));
					}
				}
			}

			OB.UTIL.HookManager.callbackExecutor(args, c);
		}

	}, function () {
		OB.UTIL.HookManager.callbackExecutor(args, c);
	});

	OB.UTIL.HookManager.callbackExecutor(args, c);
});

OB.UTIL.HookManager.registerHook('OBPOS_RenderOrderLine', function (args, c) {
	var orderline = args.orderline;
	if (orderline.model.get('unitId')) {
		orderline.createComponent({
			style: 'display: block; padding-top: 4px;',
			components: [{
				content: '-- ' + orderline.model.get('operationalQty') + ' ' + orderline.model.get('unitName'),
				attributes: {
					style: 'float: left; width: 80%; font-weight: bold;font-size: 15px; clear: left;'
				}
			}, {
				style: 'clear: both;'
			}]
		});
	}
	OB.UTIL.HookManager.callbackExecutor(args, c);
});
