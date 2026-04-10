(function () {
	
	OB.UTIL.HookManager.registerHook('OBPOS_PreOrderSave', function (args, c) {
		
		function formatDateLocal(dateStr) {
		  if (typeof dateStr === 'string' && dateStr.includes('T')) {
		    return dateStr.split('T')[0];
		  }
		  
		  if (dateStr instanceof Date) {
		    return dateStr.getFullYear() + '-' +
		           String(dateStr.getMonth() + 1).padStart(2, '0') + '-' +
		           String(dateStr.getDate()).padStart(2, '0');
		  }

		  return dateStr;
		}

		var currentDate = new Date();
		var fecha0 = formatDateLocal(currentDate);

		var scheduledDeliveryDate = OB.MobileApp.model.receipt.get('scheduledDeliveryDate');
		var fecha1 = scheduledDeliveryDate ? formatDateLocal(scheduledDeliveryDate) : null;

		
		var isLayaway= OB.MobileApp.model.receipt.get('isLayaway');

		if (OB.MobileApp.model.receipt.get('isLayaway2') && !OB.MobileApp.model.receipt.get('isLayaway3') && (fecha0 === fecha1) && !isLayaway) {
		  args.cancellation = true;
		  OB.UTIL.showConfirmation.display(
		    OB.I18N.getLabel('CPOSC_DeliveyDate'),
		    OB.I18N.getLabel('CPOSC_WannaContinue'),
		    [
		      {
		        label: OB.I18N.getLabel('CPOSC_Continue'),
		        action: function () {
					OB.MobileApp.model.receipt.set('isLayaway3',true);
					var layawayaction = OB.MobileApp.view.$.containerWindow.$.pointOfSale.$.multiColumn.$.rightPanel.$.toolbarpane.$.payment.$.paymentTabContent.$.layawayaction;
					layawayaction.tap();
				    return true;
		        }
		      },
		      {
		        label: OB.I18N.getLabel('OBMOBC_LblCancel'),
		        action: function () {
					  var detail = OB.MobileApp.view.$.containerWindow.$.pointOfSale.$.multiColumn.$.leftPanel.$.receiptview.$.receiptheader.$.receiptLabels.$.orderdetails;
			          if (detail) {
			            detail.tap();
			          }
			          return true;
		        }
		      }
		    ]
		  );
		}
	
		
	OB.UTIL.HookManager.callbackExecutor(args, c);
	}); 
	
	
	OB.OBPOSPointOfSale.UI.LayawayButton.extend({
		tap: function () {
		    var receipt = this.owner.receipt,
		        negativeLines, me = this,
		        myModel = this.owner.model,
		        payments;
				receipt.set('isLayaway2', true);
		    if (!_.isNull(this.model.get('order').get('bp')) && _.isNull(myModel.get('order').get('bp').get('locId'))) {
		      OB.UTIL.showConfirmation.display(OB.I18N.getLabel('OBPOS_InformationTitle'), OB.I18N.getLabel('OBPOS_EmptyAddrBillToText'), [{
		        label: OB.I18N.getLabel('OBPOS_LblOk')
		      }]);
		      return;
		    }

		    this.allowOpenDrawer = false;

		    if (receipt.get('bp').id === OB.MobileApp.model.get('terminal').businessPartner && !OB.MobileApp.model.get('terminal').layaway_anonymouscustomer) {
		      OB.UTIL.showConfirmation.display(OB.I18N.getLabel('OBMOBC_Error'), OB.I18N.getLabel('OBPOS_layawaysOrdersWithAnonimousCust'));
		      return;
		    }

		    if (!this.showing || this.disabled) {
		      return true;
		    }

		    if (myModel.get('leftColumnViewManager').isOrder()) {
		      payments = this.owner.receipt.get('payments');
		    } else {
		      payments = this.owner.model.get('multiOrders').get('payments');
		    }

		    payments.each(function (payment) {
		      if (payment.get('allowOpenDrawer') || payment.get('isCash')) {
		        me.allowOpenDrawer = true;
		      }
		    });
		    if (receipt) {
		      negativeLines = _.find(receipt.get('lines').models, function (line) {
		        return line.get('qty') < 0;
		      });
		      if (negativeLines) {
		        OB.UTIL.showWarning(OB.I18N.getLabel('OBPOS_layawaysOrdersWithReturnsNotAllowed'));
		        return true;
		      }
		      if (receipt.get('generateInvoice')) {
		        OB.UTIL.showWarning(OB.I18N.getLabel('OBPOS_noInvoiceIfLayaway'));
		        receipt.set('generateInvoice', false);
		      }
		    }
		    this.setDisabled(true);
		    enyo.$.scrim.show();
		    receipt.trigger('paymentDone', me.allowOpenDrawer);
		  }
	});	
	
	
  
})();