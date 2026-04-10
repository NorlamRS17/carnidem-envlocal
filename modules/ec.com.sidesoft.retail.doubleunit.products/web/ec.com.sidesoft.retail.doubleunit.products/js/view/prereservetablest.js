OB.UTIL.HookManager.registerHook('OBPOS_PreAddProductToOrder', function (args, c) {  

	console.log('OBPOS_PreAddProductToOrder: ', args);
	var productId = args.productToAdd.get('id');
	var criteria;
  
	var comm="'";
	criteria = {
		_whereClause:'where idproduct ='+comm + productId +comm,
		_orderByClause: '_identifier asc'
	};  
  
	//criteria._whereClause="where idproduct='" +productId + "'";
	OB.Dal.find(OB.Model.DoubleUnit, criteria, function (data) { 
	  
	  console.log('data: ', data);
	  if (data.models && data.models.length > 0) {
		console.log('se necesita despelgar el popup para la doble unidad');
  
		OB.MobileApp.view.$.containerWindow.showPopup('SSDUP_ModalSetInfoOrder', {
		  
		  //Parameters
		  // Receipt model is send to the popup
		  receipt: args.receipt,
		  productToAdd: args.productToAdd,
		  header: args.productToAdd.get('_identifier'),
  
		  // Callback will be invoked by the popup when all is ready.
		  // passing it through arguments
		  callback: function (cancel) {
			  console.log('entra a cancelar la cosa: ', cancel);
			if (cancel) {
		
				// se elimina el producto de la linea
				for(var i=0;args.receipt.get('lines').models.length>i;i++){
					
					var line=args.receipt.get('lines').at(i);			
					if(args.productToAdd.id===line.attributes.product.id){
						args.receipt.deleteLine(line, false);
					}
				}
				args.cancelOperation = true;			
			  	OB.UTIL.HookManager.callbackExecutor(args, c);
  
			} else {
			  
			  args.cancelOperation = false;
  
			  if(args.receipt.get('lines').models.length>0){
  
			  for(var i=0;args.receipt.get('lines').models.length>i;i++){
  
				var line=args.receipt.get('lines').at(i);
  
				if (line){
				  
				  var product=line.get("product");
  
				  var numberofcuts = line.get('numberofcuts');
				  
				  var lengthcuts   = line.get('lengthcuts');
  
				  if (!isNaN(numberofcuts) && !isNaN(lengthcuts)){
					
					if(numberofcuts!="" && lengthcuts!=""){
									  
					  OB.Data.localDB.readTransaction(function (tx) {
					
						tx.executeSql(sql, [args.productToAdd.get('dimension')], function (tr, result) {
					  
						  if (result.rows.length >0) {
  
							  preciocorteaux=(result.rows[0].preciocorte * numberofcuts).toFixed(3);
  
							  largototal = (numberofcuts*lengthcuts).toFixed(3);
  
							  preciosuma = preciocorteaux/largototal;				  				
  
							  line.set('price',product.get("standardPrice")+preciosuma);
							  args.qtyToAdd= Number(largototal);
							  line.set('qty',Number(largototal));
							  informationConfirm(args.productToAdd.get('materials'),args.productToAdd.get('dimension'),args, line);	
							
							OB.UTIL.HookManager.callbackExecutor(args, c);
						  }
						})
					  });
					}else{
					  
					  if(product.get('istypecuts')===true){
						
						args.receipt.deleteLine(line, false);	
						
					  }	else {
						
						OB.UTIL.HookManager.callbackExecutor(args, c);
					  }							
																	
					}	
				  }else{
				
				  if(product.get('istypecuts')===true){
					
					args.receipt.deleteLine(line, false);	
					
				  }	else {
					
					OB.UTIL.HookManager.callbackExecutor(args, c);
				  }
				
					}
					
				}
			  }
			}
			}
		  }
		});
		
		
	  }else{
		OB.UTIL.HookManager.callbackExecutor(args, c);
	  }
	}, function () {
	  OB.UTIL.HookManager.callbackExecutor(args, c);
	});   
	  
	OB.UTIL.HookManager.callbackExecutor(args, c);
  });


OB.UTIL.HookManager.registerHook('OBPOS_PreAddProductToOrder123123', function (args, c) {

	var flag=true;
	var alerts;
	var numSql=0;
	var comm="'";

    	
	var sqlRev= 'select reserved as contar from ReserveTables where reserved=' + comm + 'false' +comm ;
	
	OB.Data.localDB.readTransaction(function (tx) {
			
		tx.executeSql(sqlRev, null, function (tr, result) {
	
			if (result.rows.length ==0){

				numSql=1;
				args.cancelOperation = true;
				OB.UTIL.showConfirmation.display(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
				//OB.UTIL.showError("No hay mesas disponibles");
				OB.MobileApp.model.hookManager.callbackExecutor(args, c);
				
			}else{
				
				var numbline = args.receipt._previousAttributes.lines;
				var v_ValidTable = args.receipt;
				var v_c = c;
				
				if(numbline.length<1){
				
					console.log('paso por aqui');
				OB.MobileApp.view.$.containerWindow.showPopup('SSDUP_ModalSetInfoOrder',{
					//Parameters
					// Receipt model is send to the popup
					receipt: args.receipt,
					productToAdd: args.productToAdd,

					// Callback will be invoked by the popup when all is ready.
					// passing it through arguments
					callback: function (cancel) {

					if (cancel) {
					
						
						args.cancelOperation = true;
					
						OB.MobileApp.model.hookManager.callbackExecutor(args, c);

					} else {
						
						var line=args.receipt.get('lines').at(0);
						var me=args;
						
					
						args.cancelOperation = false;
						var rec = OB.MobileApp.model.receipt.documentno;
						var comm="'";
						var sql='update ReserveTables set reserved='+ comm+ 'true' + comm +' WHERE id=' + comm+  args.receipt.attributes.SLRRT_numberTables + comm;
				
						
						//Actualiza los datos del Back al 
						var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
						serverCall.exec({
								numberTable: args.receipt.attributes.SLRRT_numberTables,
								action: 'usetable',
								}, function(data) {
									if (data.exception.status.mesas==null) {
									//OB.UTIL.showLoading(false);
									OB.UTIL.showError("Modo Offline Activo");
									//flag=false;
									}
							}, function (error) {
								OB.UTIL.showLoading(false);
								args.cancelOperation = true;
								OB.MobileApp.model.hookManager.callbackExecutor(args, c);
								//statusMessage.hide();
								//OB.UTIL.showStatus(OB.I18N.getLabel('OBPOSSV_GettingStockFromServer'));
								}); // Fin del llamado al Openbravo

						OB.Data.localDB.transaction(function (tx) {
							try {
								tx.executeSql(sql, null, function () {
								// success
								//OB.info("'isbeingprocessed' has been set to 'Y' in the '" + tableName + "' table, record id: " + record.get('id'));
								//this.successCallback();
								OB.MobileApp.model.hookManager.callbackExecutor(args, c);

								}, function (txError, e) {
								// error
								//OB.error("'isbeingprocessed' has NOT been set to 'Y' in the '" + tableName + "' table, record id: " + record.get('id') + ". Error message: " + e.message);
								//  OB.error("'isbeingprocessed'");
								//errorCallback(txError, e);
								});
							} catch (e) {
								OB.error("cannot create a transaction for the '" );//+ tableName + "' table, record id: " + record.get('id') + ". Error message: " + e);
								errorCallback(null, e);
							}
							});
						
						OB.MobileApp.model.hookManager.callbackExecutor(args, c);

						}
					}/*,informationConfirm: function (materials,dimension){
						OB.UTIL.showConfirmation.display("Se incluirá el costo de corte de "+materials+" diámetro "+dimension);
							}*/
				});
				
				}
			}
		})
	});
  
	OB.MobileApp.model.hookManager.callbackExecutor(args, c);

});


/*OB.UTIL.HookManager.registerHook('OBPOS_AddProductToOrder', function (args, c) {
	//OB.MobileApp.model.hookManager.registerHook('OBPOS_GroupedProductPreCreateLine', function (args,lines, c) 
	var flag=true;
	var alerts;
	var numSql=0;
	var comm="'";
	var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
	serverCall.exec({
   		numberTable: 'ND',
        action: 'process',
   	 }, function(data) {
   		 if (data.exception.status.mesas==null) {
   			//OB.UTIL.showLoading(false);
   			OB.UTIL.showError("Modo Offline Activo");
   			//flag=false;
   		 } else {
   			 
   			//flag=true;
   			var objTables = data.exception.status.mesas;
   			
   			var idTransaction="";
   			var idIndex=0;
   			var newValue="";
   			var strIDReseved = "";
   			
   			for(var i in objTables) {
	        	  //console.log(objTables[i].id + ' - ' + objTables[i].name  + ": Actualizado");
 				strIDReseved = strIDReseved + "'" + objTables[i].id + "'" 
 				if (i<(objTables.length -1)){
 					strIDReseved = strIDReseved + ",";
 				}
 			}
 			
			var	sql="update ReserveTables set reserved='false' WHERE id in ("+ strIDReseved + ")"; 
			sql = sql;
			 window.console.log(sql);
			 OB.Data.localDB.transaction(function (tx) {
			        try {
			          tx.executeSql(sql, null, function () {
			            // success
			            //OB.info("'isbeingprocessed' has been set to 'Y' in the '" + tableName + "' table, record id: " + record.get('id'));
			            //this.successCallback();
			  			OB.MobileApp.model.hookManager.callbackExecutor(args, c);

			          }, function (txError, e) {
			            // error
			            //OB.error("'isbeingprocessed' has NOT been set to 'Y' in the '" + tableName + "' table, record id: " + record.get('id') + ". Error message: " + e.message);
			        	//  OB.error("'isbeingprocessed'");
			            //errorCallback(txError, e);
			          });
			        } catch (e) {
			          OB.error("cannot create a transaction for the '" );//+ tableName + "' table, record id: " + record.get('id') + ". Error message: " + e);
			          errorCallback(null, e);
			        }
			      });
   			
   		 }
   	}, function (error) {
        OB.UTIL.showLoading(false);
        args.cancelOperation = true;
        OB.MobileApp.model.hookManager.callbackExecutor(args, c);
        //statusMessage.hide();
        //OB.UTIL.showStatus(OB.I18N.getLabel('OBPOSSV_GettingStockFromServer'));

      }); // Fin del llamado al Openbravo
}); */