


OB.UTIL.HookManager.registerHook('OBPOS_NewReceipt', function (args, c) {
	//OB.MobileApp.model.hookManager.registerHook('OBPOS_GroupedProductPreCreateLine', function (args,lines, c) 
	OB.UTIL.showLoading(true);
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
   			var sql="";
   			var strIDReseved = "";
   			for(var i in objTables) {
	        	  //console.log(objTables[i].id + ' - ' + objTables[i].name  + ": Actualizado");
 				strIDReseved = strIDReseved + "'" + objTables[i].id + "'" 
 				if (i<(objTables.length -1)){
 					strIDReseved = strIDReseved + ",";
 				}
 			}
 			
				sql="update ReserveTables set reserved='false' WHERE id in ("+ strIDReseved + ")"; 
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
				
				OB.UTIL.showLoading(false);
   			
   		 }
   		OB.MobileApp.model.hookManager.callbackExecutor(args, c);
   	}, function (error) {
        OB.UTIL.showLoading(false);
        args.cancelOperation = true;
        OB.MobileApp.model.hookManager.callbackExecutor(args, c);
        //statusMessage.hide();
        //OB.UTIL.showStatus(OB.I18N.getLabel('OBPOSSV_GettingStockFromServer'));
      }); // Fin del llamado al Openbravo
 	OB.MobileApp.model.hookManager.callbackExecutor(args, c);
});

/*
// Generate the buttons
enyo.kind({
	name:'OB.OBPOSPointOfSale.UI.ButtonTabTest',
	kind: 'OB.UI.ToolbarButtonTab',
	tabPanel: 'test',
	i18nLabel: 'SLRRT_Nmb_Person',
	tap: function(){
		
		OB.UTIL.showLoading(true);
		var me = this;
		var flag=true;
		var alerts;
		var numSql=0;
		var comm="'";
		var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
		serverCall.exec({
	   		numberTable: 'ND',
	        action: 'process',
	   	 }, function(data) {
	   		 var DataRes =data.exception;
	   		 var Data = DataRes.status;
	   		 if (Data.mesas==null) {
	   			//OB.UTIL.showLoading(false);
	   			OB.UTIL.showError("Modo Offline Activo");
	   			//flag=false;
	   		 } else {
	   			 
	   			//flag=true;
	   			var objTables = data.exception.status.mesas;
	   			
	   			var idTransaction="";
	   			var idIndex=0;
	   			var newValue="";
	   			var sql="";
	   			
	   			for(var i in objTables) {
		        	  //console.log(objTables[i].id + ' - ' + objTables[i].name  + ": Actualizado");
	   				sql= sql +'update ReserveTables set reserved=' + comm + objTables[i].reserved + comm +' WHERE id='+ comm + objTables[i].id + comm + '; ';
	   				//sql= 'update ReserveTables set reserved=' + comm + 'hola' + comm ;
	
	   			}
	   			
				OB.Data.localDB.transaction(function (tx) {
 			        try {
 			          tx.executeSql(sql, null, function () {
 			            // success
 			            //OB.info("'isbeingprocessed' has been set to 'Y' in the '" + tableName + "' table, record id: " + record.get('id'));
 			            //this.successCallback();
 			          }, function (txError, e) {
 			            // error
 			            //OB.error("'isbeingprocessed' has NOT been set to 'Y' in the '" + tableName + "' table, record id: " + record.get('id') + ". Error message: " + e.message);
 			        	// OB.error("'isbeingprocessed'");
 			        	 //this.errorCallback(txError, e);
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
	 	 
	 	OB.UTIL.showLoading(false);
	},
	init: function (model){
		this.model = model;
	}
});


// Extend RightToolbarImpl
OB.OBPOSPointOfSale.UI.RightToolbarImpl.prototype.buttons.push({
		kind: 'OB.OBPOSPointOfSale.UI.ButtonTabTest',
		name:  'test'
});
*/


OB.UTIL.HookManager.registerHook('OBPOS_PreDeleteCurrentOrder', function (args, c) {
	//OB.MobileApp.model.hookManager.registerHook('OBPOS_GroupedProductPreCreateLine', function (args,lines, c) 
	var flag=true;
	var alerts;
	var numSql=0;
	var comm="'";
 	var res= args.receipt.attributes.SLRRT_numberTables;

	var sql='update ReserveTables set reserved='+ comm+ 'false' + comm +' WHERE id= replace(' + comm+ res  + comm+ ', ' + comm+comm+ ','+comm+')';
	window.console.log(sql);
	//Actualiza los datos del Back al 
	
	var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
	serverCall.exec({
    		numberTable: args.receipt.attributes.SLRRT_numberTables,
         action: 'removetable',
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

    
	function processResult(tx) {
		  window.console.log(tx);
		}
		 
		function processError(tx) {
		  window.console.error();
		}
	
		OB.Data.localDB.transaction(function(tx) {
		    tx.executeSql(sql,null, processResult, processError);
		});
	
	OB.MobileApp.model.hookManager.callbackExecutor(args, c);
	
});





OB.UTIL.HookManager.registerHook('OBPOS_PostSyncReceipt', function (args, c) {
	//OB.MobileApp.model.hookManager.registerHook('OBPOS_GroupedProductPreCreateLine', function (args,lines, c) 

	
	var me = this;
	var flag=true;
	var alerts;
	var numSql=0;
	var comm="'";
	var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
	serverCall.exec({
   		numberTable: 'ND',
        action: 'process',
   	 }, function(data) {
   		 var DataRes =data.exception;
   		 var Data = DataRes.status;
   		 if (Data.mesas==null) {
   			//OB.UTIL.showLoading(false);
   			OB.UTIL.showError("Modo Offline Activo");
   			//flag=false;
   		 } else {
   			 
   			//flag=true;
   			var objTables = data.exception.status.mesas;
   			
   			var idTransaction="";
   			var idIndex=0;
   			var newValue="";
   			var sql="";
   			var strIDReseved = "";
   			
   			for(var i in objTables) {
	        	  //console.log(objTables[i].id + ' - ' + objTables[i].name  + ": Actualizado");
				strIDReseved = strIDReseved + "'" + objTables[i].id + "'" 
				if (i<(objTables.length -1)){
					strIDReseved = strIDReseved + ",";
				}
			}
			
				sql="update ReserveTables set reserved='false' WHERE id in ("+ strIDReseved + ")"; 
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
	
	OB.MobileApp.model.hookManager.callbackExecutor(args, c);
	
});




OB.UTIL.HookManager.registerHook('OBPOS_PreOrderSave', function (args, c) {

	var flag=true;
	var alerts;
	var numSql=0;
	var comm="'";
 	
	var sql='update ReserveTables set reserved='+ comm+ 'false' + comm +' WHERE id=' + comm+  args.receipt.attributes.SLRRT_numberTables + comm;
	
	
	//Actualiza los datos del Back al 
	var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
	serverCall.exec({
    		numberTable: args.receipt.attributes.SLRRT_numberTables,
         action: 'removetable',
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
	
	
});




//Generate the buttons
enyo.kind({
	name:'OB.OBPOSPointOfSale.UI.ButtonTabTest',
	kind: 'OB.UI.ToolbarButtonTab',
	tabPanel: 'test',
	i18nLabel: 'SLRRT_Title',
	tap: function(args,c){
		
		OB.MobileApp.view.$.containerWindow.showPopup('OBAMOD.UI.apopup',{
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
					
					args.cancelOperation = false;
					
					OB.MobileApp.model.hookManager.callbackExecutor(args, c);
					


					
				
			  		}
			    } 
			});
			
	},
	init: function (model){
		this.model = model;
	}
});


//Extend RightToolbarImpl
OB.OBPOSPointOfSale.UI.RightToolbarImpl.prototype.buttons.push({
		kind: 'OB.OBPOSPointOfSale.UI.ButtonTabTest',
		name:  'test'
});

 


enyo.kind({
	  kind: 'OB.UI.ModalAction',
	  name: 'OBAMOD.UI.apopup',
	  //header text of the popup. Giving the SK of the label (AD_MESSAGE)
	  i18nHeader: 'SLRRT_Title',
	  //body of the popup
	  newAttributes: [{
			    kind: 'OB.UI.ReserveTableComboProperty',
			    name: 'reservecombo',
			    modelProperty: 'slrrtreserve',
			    modelPropertyText: 'slrrtreserve_name',
			    i18nLabel: 'SLRRT_Nmb_Table',
			    // Model Collection to use. This definition has been created when registering the
			    // ServeOption model
			    collection: new OB.Collection.ReserveTablesList(),
			    retrievedPropertyForValue: 'id',
			    retrievedPropertyForText: '_identifier',
			    // This function is called to determine whether the property is displayed or not
			    // This implementation shows the property only if the product has a Serve Option Category
			    // This function is called to get the serve options for the selected product.
			    // In this case we filter by the serve options category of the selected product.
			    defaultValue: function () {
			        return OB.MobileApp.model.get('terminal').defaultbp_taxidtype;
			      },
			    fetchDataFunction: function (args) {
			      // Call to client DAL functionality to query for client data for
			      // OB.Model.ServeOption filtering by field serveOptionCategory
			      var me = this,
			      criteria;
			      var comm="'";
			      criteria = {
			    		  _whereClause:'where reserved ='+comm +'false' +comm,
			    		  _orderByClause: '_identifier asc'
			      };
			      OB.Dal.find(OB.Model.ReserveTables, criteria, function (data, args) {
			               // In case of success assign the results to the property component
			        me.dataReadyFunction(data, args);
			      }, function (error) {
			        // In case of error, show an error message to the user and
			        // clean the property component
			        OB.UTIL.showError(OB.I18N.getLabel('OBCOMTR_ErrorGettingServeOptions'));
			        me.dataReadyFunction(null, args);
			      }, args);
			    }
			  },{
		      name: 'numberPerson',
		      modelProperty: 'numberPerson',
		      kind: 'OB.UI.ReservePersonTextProperty',
		      isFirstFocus: true,
		      i18nLabel: 'SLRRT_Nmb_Person'
		    }
		  ]
	  ,
	  resetProperties: function () {
		    var p, att;
		    for (p in this.newAttributes) {
		      if (this.newAttributes.hasOwnProperty(p)) {
		        att = this.$.bodyContent.$.attributes.$['line_' + this.newAttributes[p].name].$.newAttribute.$[this.newAttributes[p].name];
		        if (att && att.setValue) {
		          att.setValue('');
		        }
		      }
		    }
		  },

		  init: function (model) {
			this.setHeader(OB.I18N.getLabel('SLRRT_Title'));	
			this.model = model;
			function errorCallbackDoctors(tx, error) {
				OB.UTIL.showError("OBDAL error: " + error);
				}

		    	this.model.get('order').get('lines').on('selected', function (lineSelected) {
		     	var diff, att;
		      	this.currentLine = lineSelected;
		      	if (lineSelected) {
		  			diff = this.propertycomponents;
					for (att in diff) {
					    if (diff.hasOwnProperty(att)) {
					      this.loadValue(att);
					    }
					}
		      	}
		    }, this);

		    this.model.bind('paymentAccepted', function () {
		      this.resetProperties();
		    }, this);
		  },  
		  guestCancel: function(){
		  	var curAmountInt = this.validateGuestNumber();
		  	if (curAmountInt !== null){
		  	curAmountInt+=1;
		  	this.$.bodyContent.$.numberPerson.setValue(curAmountInt.toString());
		  	
		  }
		  return true;
		  },
		  saveDataInfos: function(inSender, inEvent){
			  

			  
		   var me = this;
		   var c = this;
		   var curAmountInt = this.$.bodyContent.$.attributes.$['line_numberPerson'].$.newAttribute.$['numberPerson'];
		   var index_ = this.$.bodyContent.$.attributes.$.line_reservecombo.$.newAttribute.$.reservecombo.$.reserveTableCombo._componentNameMap;

		   var curTable =  this.$.bodyContent.$.attributes.$['line_reservecombo'].$.newAttribute.$['reservecombo'].$.reserveTableCombo;//.$[index_];
		   var valueTable = curTable.$[index_[""]].value;
		   var tmp=curAmountInt.getValue();
		   if (tmp){
		   console.log("Mesa seleccionada R1:" + curTable);
		   console.log("Mesa seleccionada R2:" + valueTable); 
		   
		   index_ = this.$.bodyContent.$.attributes.$.line_reservecombo.$.newAttribute.$.reservecombo.$.reserveTableCombo.selected;
		   var valueTable_tmp = this.$.bodyContent.$.attributes.$.line_reservecombo.$.newAttribute.$.reservecombo.$.reserveTableCombo;
		   var controls = valueTable_tmp.controls;
		   
		   var valueTable = controls[index_].attributes.value;
		   
		   var nameTable = controls[index_].content;
		   var replacString = nameTable.replace(" ", "");
		   
		   var  orderAttributes = {};
			 
		    // add custom receipt properties at the beginning
		    //rderAttributes.unshift({
		    //  SLRRT_numberPerson:'',
		    //  SLRRT_numberTables:''
			//    });

		   //var str = this.args.receipt.attributes.documentNo;
		   //var rep = str.replace(replacString+"-", "");
		   //var res = replacString + '-' + str;
		   
		   var str = this.model.attributes.order.attributes.documentNo;
		   
		   
		   var rep =str.replace(replacString+" ", "");
		   var rep2='';
		   
		   var objTable = curTable.collection.models;
		   var v_UnabledTable="ERROR";
		   var v_UnableTableID='', v_unableTableName;
		   
		   for (var i = 0;i< objTable.length;i++){
			   var replacString2 =  (objTable[i].attributes.name).replace(" ", "");
			   replacString2 = replacString2.replace(" ", "");
			   replacString2 = replacString2.replace(" ", "");
			   replacString2 = replacString2.replace(' ', '');
			   replacString2 = replacString2 + '-' + this.model.attributes.order.attributes.documentnoPrefix;
			   
			   var unableTable = objTable[i].attributes.id;
			   
			   if (rep.includes(replacString2)){
				   v_UnableTableID=unableTable;
				   v_unableTableName= replacString2
				   console.log("Reemplazando: " + v_unableTableName);
						//OB.Dal.query(OB.Model.ReserveTables, sql, null, success, error, this);
					//OB.MobileApp.model.hookManager.callbackExecutor(args, c);
				   v_UnabledTable="OK";
				   rep = rep.replace(v_unableTableName, "");
			   }
			   console.log("Reemplazar: " + replacString2);

		   }

		   console.log("documento sin MESAS: " + rep);
			   
		   /*
		    * Habilitar mesa anterior
		    * */
		   var sqlup ='';
		   if (v_UnabledTable=="OK"){
			   
			   console.log("Habilitar Mesa: " + v_unableTableName);

				var flag=true;
				var alerts;
				var numSql=0;
				var comm="'";
			 	
				sqlup='update ReserveTables set reserved='+ comm+ 'false' + comm +' WHERE id=' + comm+  v_UnableTableID + comm;
				
				
				//Actualiza los datos del Back al 
				var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
				serverCall.exec({
			    		numberTable: v_UnableTableID,
			         action: 'removetable',
			    	 }, function(data) {
			    		 if (data.exception.status.mesas==null) {
			    			//OB.UTIL.showLoading(false);
			    			OB.UTIL.showError("Modo Offline Activo");
			    			//flag=false;
			    		 }
			    	}, function (error) {
			            OB.UTIL.showLoading(false);
			            //args.cancelOperation = true;
			            //OB.MobileApp.model.hookManager.callbackExecutor(args, c);
			            //OB.MobileApp.model.hookManager.callbackExecutor(this.args, null);
			           // OB.MobileApp.model.hookManager.callbackExecutor(args, c);
			            //statusMessage.hide();
			            OB.UTIL.showStatus(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
			          }); // Fin del llamado al Openbravo

				function processResult(tx) {
					  window.console.log(tx);
					}
					 
					function processError(tx) {
					  window.console.error();
					}
					 
					//OB.Dal.query(OB.Model.ReserveTables, sql, [], success, error, this);
					
					/*
					OB.Data.localDB.transaction(function(tx) {
					    tx.executeSql(sql,null, processResult, processError);
					});
					 
					OB.Data.localDB.transaction(function(tx) {
					    tx.executeSql('commit',null, processResult, processError);
					});*/
		   }
		   /*
		    * Fin Habilitar mesa anterior
		    * */
		   
		   var repp = str;
		   repp = repp.replace(" ", "");
		   repp = repp.replace(" ", "");
		   repp = repp.replace(' ', '');
			var res = "";
			var rec = "";
			var replacString2="";
			var strprefix = this.model.attributes.order.attributes.documentnoPrefix;

		   var sqlRev= "select replace(name, ' ' ,'') as contar, id from ReserveTables";
		   
		   OB.Data.localDB.readTransaction(function (tx) {
				  
				tx.executeSql(sqlRev, null, function (tr, result) {
		 
					if (result.rows.length ==0){

						numSql=1;
						//args.cancelOperation = true;
						//OB.UTIL.showConfirmation.display(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
						//OB.UTIL.showError("No hay mesas disponibles");
						//OB.MobileApp.model.hookManager.callbackExecutor(args, c);
						
						
						
					}else{
						
						var objTable = result.rows;
						var updTableID='';

						
						for (var i = 0;i< objTable.length;i++){
							   replacString2 =  (objTable[i].contar).replace(" ", "");
							   replacString2 = replacString2 + '-' + strprefix;
							   
							   //var unableTable = objTable[i].attributes.id;
							   
							   if (repp.includes(replacString2)){
								  // v_UnableTableID=unableTable;
								   v_unableTableName= replacString2+strprefix ;
								   v_unableTableName = v_unableTableName.replace('-001001','');
								   updTableID = objTable[i].id;
								   console.log("Reemplazando: " + v_unableTableName);
										//OB.Dal.query(OB.Model.ReserveTables, sql, null, success, error, this);
									//OB.MobileApp.model.hookManager.callbackExecutor(args, c);
								   v_UnabledTable="OK";
								   rep = rep.replace(v_unableTableName, "");
							   }
							   console.log("Reemplazar: " + v_unableTableName);

						}
						
						//var replacString2 =  result.rows["0"].contar;
						
						if (v_UnabledTable='OK'){
						   replacString2 = v_unableTableName;
						   
						   res = str;
						   rec = res.replace(replacString2,'');
						   rec = strprefix+ rec;
						   rec = rec.replace('-001001','');
						
						//args.order.attributes['documentNo']= rec;
						
						//OB.MobileApp.model.receipt.set('documentNo', rec);
						str = rec;
						var resultDoc= replacString+'-' +rec;
						resultDoc = resultDoc.replace(" ", "");
						resultDoc = resultDoc.replace(" ", "");
						resultDoc = resultDoc.replace(' ', '');
						resultDoc = resultDoc.replace(" ", "");
						resultDoc = resultDoc.replace(" ", "");
						resultDoc = resultDoc.replace(' ', '');
					 	OB.MobileApp.model.receipt.set('documentNo',resultDoc);
					 	
					 	    function processResult(tx) {
							  window.console.log(tx);
							}
							 
							function processError(tx) {
							  window.console.error();
							}
							var comm="'"; 
							var sqlupdt=  'update ReserveTables set reserved='+ comm+ 'false' + comm +' WHERE id=' + comm+ updTableID+ comm;
							OB.Data.localDB.transaction(function(tx) {
							    tx.executeSql(sqlupdt,null, processResult, processError);
							});
					 	
						
						}
						//args.cancelOperation = false;
						//OB.UTIL.showConfirmation.display(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
						//OB.UTIL.showError("No hay mesas disponibles");
						//OB.MobileApp.model.hookManager.callbackExecutor(args, c);
					}
				})
			});
		   
		   
		   
		   var res = replacString + '-' + this.model.attributes.order.attributes.documentnoPrefix +  rep;
		   
		   
		   console.log("Mesa seleccionada new R1:" + index_);
		   console.log("Mesa seleccionada new R2:" + valueTable); 

		   if(curAmountInt !== null && curAmountInt.getValue()!==""){
			   
			   orderAttributes = {SLRRT_numberPerson: curAmountInt.getValue(),SLRRT_numberTables:"'" + valueTable + "'"}
			    
			  this.args.receipt = orderAttributes;
			   
		  	// this.args.receipt.set('SLRRT_numberPerson',curAmountInt.getValue());
		  	//this.args.receipt.set('SLRRT_numberTables', valueTable);
		  	
		  	//this.args.receipt.set('documentNo', res);  //Modifca el número de pedido
			   res= res.replace(" ", "");
			   res = res.replace(" ", "");
			   res = res.replace(' ', '');
			   res = res.replace('-001001', '');
			 this.model.attributes.order.set('documentNo', res);  //Modifca el número de pedido
			 
			 var objReceipt = OB.MobileApp.model.receipt;
				var comm="'";
				var sql='';
				
				
				sql= 'update ReserveTables set reserved='+ comm+ 'true' + comm +' WHERE id=' + comm+ valueTable+ comm;
				
				if (v_UnabledTable=="OK"){
					
					function processResult(tx) {
						  window.console.log(tx);
						}
						 
						function processError(tx) {
						  window.console.error();
						}
						 
						//OB.Dal.query(OB.Model.ReserveTables, sql, [], success, error, this);
						
						/*OB.Data.localDB.readTransaction(function(tx) {
						    if (OB.Model.ReserveTables !== 'LogClient') {
						        synchId = OB.UTIL.SynchronizationHelper.busyUntilFinishes('find ' + OB.Model.ReserveTables);
						    }
						    tx.executeSql(sql, null, processResult, processError);
						});*/

						
						OB.Data.localDB.transaction(function(tx) {
						    tx.executeSql(sqlup,null, processResult, processError);
						});
				
				}
				
				//Actualiza los datos del Back al 
				var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
				serverCall.exec({
			    		numberTable: valueTable,
			         action: 'usetable',
			    	 }, function(data) {
			    		 if (data.exception.status.mesas==null) {
			    			//OB.UTIL.showLoading(false);
			    			OB.UTIL.showError("Modo Offline Activo");
			    			//flag=false;
			    		 }
			    	}, function (error) {
			            OB.UTIL.showLoading(false);
			            //args.cancelOperation = true;
			            //OB.MobileApp.model.hookManager.callbackExecutor(args, c);
			            //OB.MobileApp.model.hookManager.callbackExecutor(this.args, null);
			            //statusMessage.hide();
			            OB.UTIL.showStatus(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
			          }); // Fin del llamado al Openbravo

	        
			    
				function processResult(tx) {
					  window.console.log(tx);
					}
					 
					function processError(tx) {
					  window.console.error();
					}
					 
					//OB.Dal.query(OB.Model.ReserveTables, sql, [], success, error, this);
					
					/*OB.Data.localDB.readTransaction(function(tx) {
					    if (OB.Model.ReserveTables !== 'LogClient') {
					        synchId = OB.UTIL.SynchronizationHelper.busyUntilFinishes('find ' + OB.Model.ReserveTables);
					    }
					    tx.executeSql(sql, null, processResult, processError);
					});*/

					
					OB.Data.localDB.transaction(function(tx) {
					    tx.executeSql(sql,null, processResult, processError);
					});

			 
			 var objOrder="";
			 objOrder= this.model.attributes['order'].unset(orderAttributes);
			 
			 var replaceRight =JSON.stringify(objOrder);
			 var replaceLeft = replaceRight.substr(1,(replaceRight.length));
		     var result = '{"SLRRT_numberPerson":"' +  curAmountInt.getValue() + '","' + 'SLRRT_numberTables":"' + valueTable + '",' + replaceLeft;
		     var resultOBJ = [];
		     resultOBJ = result;
		     //console.log("resultado  R7:" + resultOBJ); 
			 //objOrder['attributes'].push("SLRRT_numberPerson");
			 //objOrder['attributes'].push("SLRRT_numberTables");
			 //this.model.attributes.order.attributes =  JSON.parse(result) ;

				
		  	
		  	 this.amountSet = true;
		  	 this.hide();
		  	 
		   }
		  }else{
			  return false;
		  }
		   return true;
		  },
		  cancel: function(){
		   this.hide();
		   
		  },

		  bodyButtons:{
		   components:[{
		  	 kind:'OB.UI.ModalDialogButton',
		  	 name: 'OB.OBSSPOS.confirmReserve',
		  	 i18nContent: 'OBMOBC_LblOk',
		  	 isDefaultAction: true,
		  	 ontap:'saveDataInfos'
		   },{
		  	 kind:'OB.UI.ModalDialogButton',
		  	 name: 'OB.OBSSPOS.cancelGuestQty',
		  	 i18nContent: 'OBMOBC_LblCancel',
		  	 ontap:'cancel'
		   }]
		  },
		  executeBeforeHide: function(){
		   var me = this;
		   if(this.amountSet){
		  	 this.amountSet = null;
		     var curAmountInt = this.$.bodyContent.$.attributes.$['line_numberPerson'].$.newAttribute.$['numberPerson'];
		     var tmp=curAmountInt.getValue();
		     
		     console.log("Mesa seleccionada R3:" + curAmountInt);
		     console.log("Mesa seleccionada R4:" + tmp); 
		     
		    // this.args.receipt.set('SLRRT_numberPerson',tmp);
		     var nmbperson= parseInt(this.args.receipt.SLRRT_numberPerson);
		     var inTable = this.args.receipt.SLRRT_numberTables;
		  	 if (nmbperson && nmbperson> 0){
		  		 
		  		 //this.args.callback(true);
		  		
		  		 //this.args.callback();
		  		 
		  		 return true;
		  		this.hide();
		  	 }else{
		  		 //this.$.bodyContent.$.warningLabel.setShowing(true);

		  		 return false;
		  	 }
		   }else{
		  	 //this.args.callback(true);
			   //this.args.callback();
		  	 return true;
		   }
		   return true;
		  },

		  executeOnShow: function(){
			  
			  /*
			   * 
			  var flag=true;
				var alerts;
				var numSql=0;
				var comm="'";
				var ogjArgs = this;
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
			   			var sql="";
			   			var strIDReseved = "";
			   			
			   			for(var i in objTables) {
				        	  //console.log(objTables[i].id + ' - ' + objTables[i].name  + ": Actualizado");
			   				strIDReseved = strIDReseved + "'" + objTables[i].id + "'" 
			   				if (i<(objTables.length -1)){
			   					strIDReseved = strIDReseved + ",";
			   				}
			   			}
			   			
		   				sql="update ReserveTables set reserved='false' WHERE id in ("+ strIDReseved + ")"; 
						sql = sql;
						 window.console.log(sql);
			   			
		   				function processResult(tx) {
							  window.console.log(tx);
							}
							 
							function processError(tx) {
							  window.console.error();
							}

							
							OB.Data.localDB.transaction(function(tx) {
							    tx.executeSql(sql,null, processResult, processError);
							});
			   			
			   			
		   			
			   		 }
			   		//OB.MobileApp.model.hookManager.callbackExecutor(args, c);
			   	}); // Fin del llamado al Openbravo
				*/
				
				/*var sql="update ReserveTables set reserved='2' WHERE id in ('2F3A00964F5D4857882B936BEFC86594')"; 
				sql = sql;
				 window.console.log(sql);
	   			
   				function processResult(tx) {
					  window.console.log(tx);
					}
					 
					function processError(tx) {
					  window.console.error();
					}

					
					OB.Data.localDB.transaction(function(tx) {
					    tx.executeSql(sql,null, processResult, processError);
					});*/
			  
		   var me = this;
		   this.$.bodyContent.guestCancel = function(){
		  	 me.guestCancel();		 
		   };
		   this.$.bodyContent.guestCancel = function(){
		  	 me.guestOK();		 
		   };
		   this.$.bodyButtons.saveDataInfos = function(inSender, inEvent){
		  	 me.saveDataInfos(inSender, inEvent);
		   };
		   this.$.bodyButtons.cancel = function(){
		  	 me.cancel();		 
		   };
		   
		   //this.args.receipt.push('SLRRT_numberPerson');
		   //this.args.receipt.push('SLRRT_numberTables');
		   this.amountSet = null;
		   //this.$.bodyContent.$.numberPerson.setValue("1");
		   //this.$.bodyContent.$.warningLabel.setContent(OB.I18N.getLabel('Swps_Title'));
		  }
	});


OB.UI.WindowView.registerPopup('OB.OBPOSPointOfSale.UI.PointOfSale', {
	  kind: 'OBAMOD.UI.apopup',
	  name: 'OBAMOD.UI.apopup'
	});

OB.UTIL.HookManager.registerHook('OBPOS_PreDeleteLine', function (args, c) {
	var flag=true;
	var alerts;
	var numSql=0;
	var comm="'";
 	var res1= args.order.attributes.SLRRT_numberTables;
 	var res = res1;
 	if (res1){
 	res = res.replace("'","");
 	
 	var lines = args.selectedLines;
 	var counlines = lines.length;
 	if (counlines=1){
 		
 		//args.cancelOperation = false;
	var sql='update ReserveTables set reserved='+ comm+ 'false' + comm +' WHERE id=' + comm+ res  + comm;
	
	//Actualiza los datos del Back al 
	
	var serverCall = new OB.DS.Process('ec.com.sidesoft.localization.retail.resources.tables.UpdateResourcesTables');
	serverCall.exec({
    		numberTable: res1,
         action: 'removetable',
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

    
	function processResult(tx) {
		  window.console.log(tx);
		}
		 
		function processError(tx) {
		  window.console.error();
		}
	
		OB.Data.localDB.transaction(function(tx) {
		    tx.executeSql(sql,null, processResult, processError);
		});
		
	    var sqlRev= "select replace(name, ' ' ,'') as contar from ReserveTables";
	    
	    OB.Data.localDB.readTransaction(function (tx) {
			  
			tx.executeSql(sqlRev, null, function (tr, result) {
	  
				if (result.rows.length ==0){
	
					numSql=1;
					args.cancelOperation = true;
					//OB.UTIL.showConfirmation.display(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
					//OB.UTIL.showError("No hay mesas disponibles");
					OB.MobileApp.model.hookManager.callbackExecutor(args, c);
					
					
					
				}else{
					
					var objTable = result.rows;
					var replacString2 = '';
					var v_unableTableName;
					var rep = args.order.attributes.documentNo;
					
					for (var i = 0;i< objTable.length;i++){
						   var replacString2 =  (objTable[i].contar).replace(" ", "");
						   replacString2 = replacString2.replace(" ", "");
						   replacString2 = replacString2.replace(" ", "");
						   replacString2 = replacString2.replace(' ', '');
						   replacString2 = replacString2 + '-' + args.order.attributes.documentnoPrefix;
						   
						   //var unableTable = objTable[i].attributes.id;
						   
						   if (rep.includes(replacString2)){
							  // v_UnableTableID=unableTable;
							   v_unableTableName= replacString2
							   console.log("Reemplazando: " + v_unableTableName);
									//OB.Dal.query(OB.Model.ReserveTables, sql, null, success, error, this);
								//OB.MobileApp.model.hookManager.callbackExecutor(args, c);
							   v_UnabledTable="OK";
							   rep = rep.replace(replacString2, "");
						   }
						   console.log("Reemplazar: " + replacString2);

					}
					
					//var replacString2 =  result.rows["0"].contar;
					   replacString2 = v_unableTableName;
					   replacString2 = replacString2.replace(" ", "");
					   replacString2 = replacString2.replace(" ", "");
					   replacString2 = replacString2.replace(' ', '');
					   
					   var res = args.order.attributes.documentNo;
					   var rec = args.order.attributes.documentnoPrefix + res.replace(replacString2,'');
					
					//args.order.attributes['documentNo']= rec;
					
					OB.MobileApp.model.receipt.set('documentNo', rec);
					
					args.cancelOperation = false;
					//OB.UTIL.showConfirmation.display(OB.I18N.getLabel('SLRRT_ErrorTablesResources'));
					//OB.UTIL.showError("No hay mesas disponibles");
					OB.MobileApp.model.hookManager.callbackExecutor(args, c);
				}
			})
		});
	    
		OB.MobileApp.model.hookManager.callbackExecutor(args, c);

		
}
}
	
 	OB.MobileApp.model.hookManager.callbackExecutor(args, c);
	
});