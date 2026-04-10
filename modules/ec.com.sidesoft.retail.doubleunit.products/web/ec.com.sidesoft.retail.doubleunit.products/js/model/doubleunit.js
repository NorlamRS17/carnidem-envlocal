// Creamos el modelo de la tabla Sqllite
var DoubleUnit = OB.Data.ExtensibleModel.extend({
  modelName: 'DoubleUnit',
  tableName: 'DoubleUnit',
  entityName: 'DoubleUnit',
  modelFunc: 'DoubleUnit',
  source: 'ec.com.sidesoft.retail.doubleunit.products.DoubleUnit',
  dataLimit: 300
  //dataLimit: OB.Dal.DATALIMIT,
  //local: false,  
});

// Añadimos las propiedades para el modelo Serve Option
DoubleUnit.addProperties([{
  name: 'id',
  column: 'id',
  primaryKey: true,
  type: 'TEXT'
}, {
    name: 'idproduct',
    column: 'idproduct',
    primaryKey: false,
    type: 'TEXT'
}, {
    name: 'iduom',
    column: 'iduom',
    primaryKey: false,
    type: 'TEXT'
}, {
    name: 'searchKey',
    column: 'searchKey',
    primaryKey: false,
    type: 'TEXT'
}, {
    name: '_identifier',
    column: '_identifier',
    primaryKey: false,
    type: 'TEXT'
}, {
    name: 'conversionrate',
    primaryKey: false,
    column: 'conversionrate',
    type: 'NUMERIC'
}, {
    name: 'sales',
    column: 'sales',
    primaryKey: false,
    type: 'TEXT'
}, {
  name: 'purchase',
  column: 'purchase',
  primaryKey: false,
  type: 'TEXT'
}, {
  name: 'logistics',
  column: 'logistics',
  primaryKey: false,
  type: 'TEXT'
}, {
  name: 'ismain',
  column: 'ismain',
  primaryKey: false,
  type: 'TEXT'
}

]);

// Registro del modelo en el POS (Sqllite)
OB.Data.Registry.registerModel(DoubleUnit);

//Añade el modedlo al ventana principal del Web POS
OB.OBPOSPointOfSale.Model.PointOfSale.prototype.models.push(DoubleUnit);