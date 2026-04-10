saveDataInfo: function(inSender, inEvent){
        
    var me = this;
    console.log('this.$.bodyContent.$.attributes.', this.$.bodyContent.$.attributes);
    //var nuevo = '10';
    var index_ = this.$.bodyContent.$.attributes.$.line_doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo._componentNameMap;
    var temp = this.$.bodyContent.$.attributes.$.line_doubleUnitCombo.$.newAttribute.$.doubleUnitCombo.$.doubleUnitCombo;
    var convertRate = temp.$[index_[""]].value;
    var qty = this.$.bodyContent.$.attributes.$.line_operationalQty.$.newAttribute.$.operationalQty.$.inputQty.getValue();
    var newQty = convertRate * qty;
 
    console.log('ConvertionRate', convertRate);
    console.log('Cantidad Operacional', qty);   
    console.log('Nueva Cantidad', newQty); 
    
    this.conversionSet = true;
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