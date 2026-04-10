/***
 * Extender el modelo de BusinessPartner para incluir el campo eEIEmail
 * Este campo se sincroniza desde el servidor usando BusinessPartnerEmailExtension.java
 * y está disponible en el modelo del cliente para ser usado en templates de impresión
 **/
OB.Model.BusinessPartner.addProperties([{
    name: 'eEIEmail',
    column: 'eEIEmail',
    type: 'TEXT'
  }]);


