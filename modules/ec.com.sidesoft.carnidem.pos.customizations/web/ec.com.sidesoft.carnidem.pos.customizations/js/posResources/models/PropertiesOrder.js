
OB.Model.OrderFilter.addProperties([{
    name: 'scheduledDeliveryDate',
    column: 'scheduledDeliveryDate',
    type: 'TEXT'
  }]);
  
var PropertyDateField = {
  kind: 'enyo.Input',
  name: 'fechaDocumento',
  modelProperty: 'fechaDocumento',
  i18nLabel: 'CPOSC_DeliveyDate',
  handlers: {
    onkeydown: 'keydown',
    onkeyup: 'keyup',
    onchange: 'change',
    onblur: 'blur'
  },
  attributes: {
    type: 'date'
  },
  style: 'width: 100%; box-sizing: border-box;',
  change: function(inSender, inEvent) {
    var fechaSeleccionada = inSender.getValue();    
  },
  setFecha: function(fecha) {
    this.setValue(fecha);
  },
  executeOnShow: function () {
  }

};

OB.UI.ModalReceiptPropertiesImpl.prototype.newAttributes.push(PropertyDateField);


OB.UI.ModalReceiptPropertiesImpl.extend({
	applyChanges: function (inSender, inEvent) {
		    var result = this.inherited(arguments);

			var campoFecha = this.$.bodyContent.$.attributes.$['line_fechaDocumento'].$.newAttribute.$.fechaDocumento;
			    if (campoFecha) {
					var fechaSeleccionada = campoFecha.getValue();

					if (fechaSeleccionada) {
					  var parts = fechaSeleccionada.split('-');
					  var fecha = new Date(
					    parseInt(parts[0], 10),
					    parseInt(parts[1], 10) - 1,  // mes (0-based)
					    parseInt(parts[2], 10)
					  );
					  var fechaNormalizada = OB.I18N.normalizeDate(fecha);
					  OB.MobileApp.model.receipt.set('scheduledDeliveryDate', fechaNormalizada);
					}


			    }

		    return result;
	  },
	  executeOnShow: function () {
	      var bp = this.model.get('bp');
	      if (bp && bp.get('locId') === bp.get('shipLocId')) {
	        this.$.bodyContent.$.attributes.$.line_addressshipbutton.hide();
	        this.$.bodyContent.$.attributes.$.line_addressbillbutton.$.labelLine.setContent(OB.I18N.getLabel('OBPOS_LblAddress'));
	      } else {
	        this.$.bodyContent.$.attributes.$.line_addressshipbutton.show();
	        this.$.bodyContent.$.attributes.$.line_addressbillbutton.$.labelLine.setContent(OB.I18N.getLabel('OBPOS_LblBillAddr'));
	      }
		  this.executeOnShow2();
	    },
  executeOnShow2: function () {
    //this.inherited(arguments);
    var campoFecha = this.$.bodyContent.$.attributes.$['line_fechaDocumento'].$.newAttribute.$.fechaDocumento;
    if (campoFecha) {
      var scheduledDeliveryDate = OB.MobileApp.model.receipt.get('scheduledDeliveryDate');

	  if (scheduledDeliveryDate) {
	    var parts = scheduledDeliveryDate.split('-'); // ["YYYY","MM","DD"]
	    var fecha = new Date(
	      parseInt(parts[0], 10),
	      parseInt(parts[1], 10) - 1, // mes 0-based
	      parseInt(parts[2], 10)
	    );

	    var fechaStr = fecha.getFullYear() + '-' +
	                   String(fecha.getMonth() + 1).padStart(2, '0') + '-' +
	                   String(fecha.getDate()).padStart(2, '0');

	    campoFecha.setFecha(fechaStr);
	  } else {
	    var hoy = new Date();
	    var hoyStr = hoy.getFullYear() + '-' +
	                 String(hoy.getMonth() + 1).padStart(2, '0') + '-' +
	                 String(hoy.getDate()).padStart(2, '0');

	    campoFecha.setFecha(hoyStr);
	  }

    }
  }
});


