/*
 * Customización de templates de impresión para POS
 * Sobrescribe el template de factura para usar printinvoicedinamic.xml
 */
/*global OB */

(function () {
  'use strict';

  function customizeInvoiceTemplate() {
    if (OB.OBPOSPointOfSale && OB.OBPOSPointOfSale.Print) {
      OB.OBPOSPointOfSale.Print.ReceiptTemplateInvoice = '../ec.com.sidesoft.pos.custom.print/res/printinvoicedinamic.xml';
      OB.info('Template de factura personalizado cargado: printinvoicedinamic.xml');
    } else {
      setTimeout(customizeInvoiceTemplate, 100);
    }
  }

  customizeInvoiceTemplate();

  OB.UTIL.HookManager.registerHook('OBPOS_TerminalLoadedFromBackend', function (args, callbacks) {
    customizeInvoiceTemplate();
    OB.UTIL.HookManager.callbackExecutor(args, callbacks);
  });
}());

