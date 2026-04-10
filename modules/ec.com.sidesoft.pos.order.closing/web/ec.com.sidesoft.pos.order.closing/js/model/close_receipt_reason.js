/*global OB */

(function () {

    var CloseReason = OB.Data.ExtensibleModel.extend({
      modelName: 'CloseReason',
      tableName: 'ssfps_reasons_clousure',
      entityName: 'CloseReason',
      source: 'ec.com.sidesoft.pos.order.closing.master.CloseReason',
      dataLimit: OB.Dal.DATALIMIT
    });
  
    CloseReason.addProperties([{
      name: 'id',
      column: 'ssfps_reasons_clousure_id',
      primaryKey: true,
      type: 'TEXT'
    }, {
      name: '_identifier',
      column: '_identifier',
      type: 'TEXT'
    }]);

    OB.Data.Registry.registerModel(CloseReason);

    OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(OB.Model.CloseReason);
  }());