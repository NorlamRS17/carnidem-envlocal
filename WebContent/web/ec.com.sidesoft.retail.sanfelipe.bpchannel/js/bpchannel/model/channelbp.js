
var BpChannel = OB.Data.ExtensibleModel.extend({
    modelName: 'BpChannel',
    tableName: 'bp_channel',
    entityName: 'BpChannel',
    source: 'ec.com.sidesoft.retail.sanfelipe.bpchannel.channelproperties.BpChannel',
  });

  // Add the required properties for the model Serve Option
  BpChannel.addProperties([{
    name: 'id',
    column: 'id',
    primaryKey: true,
    type: 'TEXT'
  }, {
	name: 'searchKey',
	column: 'searchKey',
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
  OB.Data.Registry.registerModel(BpChannel);
 
  // Add the model to the main Web POS window.
  // This loads the data when the main Web POS window is loaded.
  OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(BpChannel);
