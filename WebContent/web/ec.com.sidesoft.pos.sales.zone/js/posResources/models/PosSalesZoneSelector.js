/**
 *  Model PosSalesZone
 */

var PosSalesZone = OB.Data.ExtensibleModel.extend({
  modelName: 'PosSalesZone',
  tableName: 'PosSalesZone',
  entityName: 'PosSalesZone',
  source: 'ec.com.sidesoft.pos.sales.zone.master.PosSalesZoneSelector'
});

PosSalesZone.addProperties([
  {
    name: 'id',
    column: 'id',
    primaryKey: true,
    type: 'TEXT',
  },
  {
    name: 'searchKey',
    column: 'searchKey',
    type: 'TEXT',
  },
  {
    name: 'name',
    column: 'name',
    type: 'TEXT',
  },
  {
    name: '_identifier',
    column: '_identifier',
    filter: true,
    type: 'TEXT',
  },
]);

PosSalesZone.addIndex([
  {
    name: 'spsz_identifier_idx',
    columns: [
      {
        name: '_identifier',
        sort: 'asc',
      },
    ],
  },
]);

OB.Data.Registry.registerModel(PosSalesZone);
OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(PosSalesZone);
