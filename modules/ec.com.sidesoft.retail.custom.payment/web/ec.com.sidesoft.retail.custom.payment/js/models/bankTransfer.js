/**
 * 
 */
var BankTransfer = OB.Data.ExtensibleModel.extend({
    modelName: 'BankTransfer',
    tableName: 'BankTransfer',
    entityName: 'BankTransfer',
    source: 'ec.com.sidesoft.retail.custom.payment.master.BankTransfer',
  });

  // Add the required properties for the model Type Credit
  BankTransfer.addProperties([{
    name: 'id',
    column: 'id',
    primaryKey: true,
    type: 'TEXT'
  }, {
    name: 'name',
    column: 'commercialName',
    type: 'TEXT'
  }, {
    name: '_identifier',
    column: '_identifier',
    type: 'TEXT'
  }]);

  // Register the model in the application
  OB.Data.Registry.registerModel(BankTransfer);
 
  // Add the model to the main Web POS window.
  // This loads the data when the main Web POS window is loaded.
  OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(BankTransfer);
