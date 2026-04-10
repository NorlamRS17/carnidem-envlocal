enyo.kind({
  kind: 'OB.UI.Button',
  name: 'OB.OBPOSPointOfSale.UI.customeraddr.location',
  style: 'width: 100px; margin: 0px 19px 8px 19px;',
  classes: 'btnlink-yellow btnlink btnlink-small',
  i18nLabel: 'SPGL_LblLocation',
  style: 'width: 150px;',
  events: {
    onSaveCustomerAddr: ''
  },
  handlers: {
    onDisableButton: 'disableButton'
  },
  disableButton: function (inSender, inEvent) {
    this.setDisabled(inEvent.disabled);
    if (inEvent.disabled) {
      this.addClass(this.classButtonDisabled);
    } else {
      this.removeClass(this.classButtonDisabled);
    }
  },
  tap: function () {
       var me = this;
         // Verificar si el navegador soporta geolocalización
        if ("geolocation" in navigator) {
            // Obtener la geolocalización del usuario
            navigator.geolocation.getCurrentPosition(function (position) {
                // Obtener las coordenadas de latitud y longitud
                var latitud = position.coords.latitude;
                var longitud = position.coords.longitude;
                				
		//alert('las coordenasdas son ' + latitud + ' --- ' + longitud);
		//alert('me :: '+me);
	        me.owner.owner.owner.$.customerAddrAttributes.$.line_customerAddrLatitude.$.newAttribute.$.customerAddrLatitude.setValue(latitud);
	        me.owner.owner.owner.$.customerAddrAttributes.$.line_customerAddrLongitude.$.newAttribute.$.customerAddrLongitude.setValue(longitud);			
            });
        } else {
            // Si el navegador no soporta geolocalización, mostrar un mensaje de error
            alert("Tu navegador no soporta geolocalización");
        }
  }
});

const coordinates = [
	{
    kind: 'OB.UI.CustomerAddrTextProperty',
    name: 'customerAddrLatitude',
    modelProperty: 'sspsiLatitude',
    i18nLabel: 'SPGL_LblLatitude',
    maxlength: 20,
  },
  {
    kind: 'OB.UI.CustomerAddrTextProperty',
    name: 'customerAddrLongitude',
    modelProperty: 'sspsiLongitude',
    i18nLabel: 'SPGL_LblLongitude',
    maxlength: 20,
  }
]

coordinates.forEach(element => {
	OB.OBPOSPointOfSale.UI.customeraddr.edit_createcustomers_impl.prototype.newAttributes.push(element);
})

OB.OBPOSPointOfSale.UI.customeraddr.subwindowNewCustomer_bodyheader.prototype.kindComponents[0].components[0].components.splice(1,0,{name: 'btnlocation', kind: 'OB.OBPOSPointOfSale.UI.customeraddr.location'});







