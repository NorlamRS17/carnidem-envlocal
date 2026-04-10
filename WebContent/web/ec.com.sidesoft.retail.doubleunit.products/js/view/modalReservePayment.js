enyo.kind({
  name: 'OB.UI.ModalAction',
  kind: 'OB.UI.ModalOrderProperties',
  newAttributes: [
		{
		name: 'operationalQty',
		modelProperty: 'operationalQty',
		kind: 'OB.UI.OperationalQtyProperty',
		i18nLabel: 'SSDUP_OperationalQty',
		style: "height: 50px !important;"
	  },	  	
	  {
	    kind: 'OB.UI.DoubleUnitComboProperty',
	    name: 'doubleUnitCombo',
	    modelProperty: 'ssdupdoubleunit',
	    modelPropertyText: 'ssdupdoubleunit_searchKey',
	    i18nLabel: 'SSDUP_Unit',
	    // Model Collection to use. This definition has been created when registering the
	    // ServeOption model
	    collection: new OB.Collection.DoubleUnitList(),
		//retrievedPropertyForValue: 'id',
		retrievedPropertyForValue: 'conversionrate',
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
	    		  //_whereClause:'where reserved ='+comm +'false' +comm,
	    		  _orderByClause: '_identifier asc'
		  };
		  window.console.log("CRITERIA: ", criteria);
		  window.console.log("ARGUMENTOS: ", args);
	      OB.Dal.find(OB.Model.DoubleUnit, criteria, function (data, args) {
				// In case of success assign the results to the property component
				window.console.log(data);   
	        	me.dataReadyFunction(data, args);
	      }, function (error) {
	        // In case of error, show an error message to the user and
	        // clean the property component
	        OB.UTIL.showError(OB.I18N.getLabel('OBCOMTR_ErrorGettingServeOptions'));
	        me.dataReadyFunction(null, args);
	      }, args);
	    }
	  },
	  {
		name: 'mainUnitProduct',
		modelProperty: 'mainUnitProduct',
		kind: 'OB.UI.ProductUomProperty',
		i18nLabel: 'SSDUP_ProductName'
	  },	  	  
	  {
		name: 'nameProduct',
		modelProperty: 'nameProduct',
		kind: 'OB.UI.ProductNameProperty',
		i18nLabel: 'SSDUP_ProductName'
	  },	  
	  {
		name: 'priceProduct',
		modelProperty: 'priceProduct',
		kind: 'OB.UI.ProductPriceProperty',
		i18nLabel: 'SSDUP_Price'
	  }

  ],

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
  saveDataInfo: function(inSender, inEvent){
	  
   var me = this;
   console.log('this.$.bodyContent.$.attributes.', this.$.bodyContent.$.attributes);
   //var nuevo = '10';
   var index_ = this.$.bodyContent.$.attributes.$.doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo._componentNameMap;
   var temp = this.$.bodyContent.$.attributes.$.doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo;
   var convertRate = temp.$[index_[""]].value;
   var qty = this.$.bodyContent.$.attributes.$.operationalQty.$.newAttribute.$.operationalQty.$.inputQty.getValue();
   var newQty = convertRate * qty;

   console.log('ConvertionRate', convertRate);
   console.log('Cantidad Operacional', qty);   
   console.log('Nueva Cantidad', newQty);   
   //var corvertion = ;
   
   /*var curAmountInt = this.$.bodyContent.$.attributes.$['line_numberPerson'].$.newAttribute.$['numberPerson'];
   var index_ = this.$.bodyContent.$.attributes.$.line_reservecombo.$.newAttribute.$.reservecombo.$.reserveTableCombo._componentNameMap;

   var curTable =  this.$.bodyContent.$.attributes.$['line_reservecombo'].$.newAttribute.$['reservecombo'].$.reserveTableCombo;//.$[index_];
   var valueTable = curTable.$[index_[""]].value;
   var tmp=curAmountInt.getValue();
   console.log("Mesa seleccionada 1:" + curTable);
   console.log("Mesa seleccionada 2:" + valueTable); 
   
   index_ = this.$.bodyContent.$.attributes.$.line_reservecombo.$.newAttribute.$.reservecombo.$.reserveTableCombo.selected;
   var valueTable_tmp = this.$.bodyContent.$.attributes.$.line_reservecombo.$.newAttribute.$.reservecombo.$.reserveTableCombo;
   var controls = valueTable_tmp.controls;
   
   var valueTable = controls[index_].attributes.value;
   
   var nameTable = controls[index_].content;
   var replacString = nameTable.replace(" ", "");
   replacString = replacString.replace(" ", "");
   replacString = replacString.replace(' ', '');
   replacString = replacString.replace(" ", "");
   
   var str = this.args.receipt.attributes.documentNo;
   var strprefix = this.args.receipt.attributes.documentnoPrefix;
   
	var v_unableTableName="ERROR";
	var repp = str;
	var res = "";
	var rec = "";
	var replacString2="";

   var objTablesAll = OB.Model.ReserveTables;
   
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
						   rep = rep.replace(replacString2, "");
					   }
					   console.log("Reemplazar: " + replacString2);

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
   
   
   var rep = str.replace(replacString+"-", "");
   console.log("REP 1:" + rep);
   var res = replacString + '-' + strprefix + str;
   console.log("RES 1:" + res);
   
   var rep =str.replace(replacString+" ", "");
   var rep2='';
   
   console.log("Mesa seleccionada new 1:" + index_);
   console.log("Mesa seleccionada new 2:" + valueTable); 

   if(curAmountInt !== null && curAmountInt.getValue()!==""){
  	 this.args.receipt.set('SLRRT_numberPerson',curAmountInt.getValue());
  	this.args.receipt.set('SLRRT_numberTables', valueTable);
  	
  	res = res.replace(" ", "");
  	console.log("Mesa sin espacios:" + res); 
  	res = res.replace(' ', '');
  	console.log("Mesa sin espacios:" + res); 
  	res = res.replace(" ", "");
  	console.log("Mesa sin espacios:" + res); 
  	res = res.replace(" ", "");
  	console.log("Mesa sin espacios:" + res); 
  	res = res.replace(' ', '');
  	console.log("Mesa sin espacios:" + res); 
  	res = res.replace(" ", "");
  	console.log("Mesa sin espacios:" + res); 
  	
  	res = res.replace("-001001","");
  	res = res.replace('-001001','');
  	
  	this.args.receipt.set('documentNo',res );  //Modifca el número de pedido
  	OB.MobileApp.model.receipt.set('documentNo', res);
  	 this.amountSet = true;
  	 this.hide();
  	 
   } */
   return true;
  },
  cancel: function(){
   this.hide();
   
  },

  bodyButtons:{
   components:[{
  	 kind:'OB.UI.ModalDialogButton',
  	 name: 'OB.OBSSPOS.confirmGuestQty',
  	 i18nContent: 'OBMOBC_LblOk',
  	 isDefaultAction: true,
  	 ontap:'saveDataInfo'
   },{
  	 kind:'OB.UI.ModalDialogButton',
  	 name: 'OB.OBSSPOS.cancelGuestQty',
  	 i18nContent: 'OBMOBC_LblCancel',
  	 ontap:'cancel'
   }]
  },
  executeBeforeHide: function(){
   var me = this;
   console.log('cerrando: ', me);
   this.args.callback(true);
   if(this.amountSet){
  	 this.amountSet = null;
     var curAmountInt = this.$.bodyContent.$.attributes.$['line_numberPerson'].$.newAttribute.$['numberPerson'];
     var tmp=curAmountInt.getValue();
     
     console.log("Mesa seleccionada 3:" + curAmountInt);
     console.log("Mesa seleccionada 4:" + tmp); 
     
     this.args.receipt.set('SLRRT_numberPerson',tmp);
       
  	 if (this.args.receipt.get('SLRRT_numberPerson') && this.args.receipt.get('SLRRT_numberPerson') > 0){
  		 
  		//this.args.callback(true);
  		
  		 this.args.callback();
  		 
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
   var me = this;
   this.$.bodyContent.guestCancel = function(){
  	 me.guestCancel();		 
   };
   this.$.bodyContent.guestCancel = function(){
  	 me.guestOK();		 
   };
   this.$.bodyButtons.saveDataInfo = function(inSender, inEvent){
  	 me.saveDataInfo(inSender, inEvent);
   };
   this.$.bodyButtons.cancel = function(){
  	 me.cancel();		 
   };
//    this.args.receipt.unset('SLRRT_numberPerson');
//    this.args.receipt.unset('SLRRT_numberTables');

console.log('args: ', this.args);
   console.log('productToAdd: ', this.args.productToAdd);
   console.log('this.$.bodyContent: ', this);
   console.log('this.$.bodyContent: ', this.$.bodyContent.$.attributes.$.priceProduct.$.newAttribute.$.priceProduct);
 
   this.$.header.setContent(OB.I18N.getLabel('SSDUP_DoubleUnit'));
   this.$.bodyContent.$.attributes.$.mainUnitProduct.$.newAttribute.$.mainUnitProduct.setValue(this.args.productToAdd.get('uOMsymbol'));
   this.$.bodyContent.$.attributes.$.nameProduct.$.newAttribute.$.nameProduct.setValue(this.args.productToAdd.get('_identifier'));
   this.$.bodyContent.$.attributes.$.priceProduct.$.newAttribute.$.priceProduct.setValue(this.args.productToAdd.get('standardPrice'));
  }
});

OB.UI.WindowView.registerPopup('OB.OBPOSPointOfSale.UI.PointOfSale',{
kind: 'OB.UI.ModalAction',
name: 'SSDUP_ModalSetInfoOrder'
});




