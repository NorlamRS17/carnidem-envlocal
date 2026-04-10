/**
 * 
 */
var CardType = OB.Data.ExtensibleModel.extend({
    modelName: 'CardType',
    tableName: 'CardType',
    entityName: 'CardType',
    source: 'ec.com.sidesoft.retail.custom.payment.master.CardType',
  });

  // Add the required properties for the model Type Credit
  CardType.addProperties([{
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
  OB.Data.Registry.registerModel(CardType);
 
  // Add the model to the main Web POS window.
  // This loads the data when the main Web POS window is loaded.
  OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(CardType);
