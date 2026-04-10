/**
 * 
 */
var ProcessorBank = OB.Data.ExtensibleModel.extend({
    modelName: 'ProcessorBank',
    tableName: 'ProcessorBank',
    entityName: 'ProcessorBank',
    source: 'ec.com.sidesoft.retail.custom.payment.master.ProcessorBank',
  });

  // Add the required properties for the model Type Credit
  ProcessorBank.addProperties([{
    name: 'id',
    column: 'id',
    primaryKey: true,
    type: 'TEXT'
  }, {
    name: 'name',
    column: 'name',
    type: 'TEXT'
  }, {
    name: '_identifier',
    column: '_identifier',
    type: 'TEXT'
  }]);

  // Register the model in the application
  OB.Data.Registry.registerModel(ProcessorBank);
 
  // Add the model to the main Web POS window.
  // This loads the data when the main Web POS window is loaded.
  OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(ProcessorBank);
