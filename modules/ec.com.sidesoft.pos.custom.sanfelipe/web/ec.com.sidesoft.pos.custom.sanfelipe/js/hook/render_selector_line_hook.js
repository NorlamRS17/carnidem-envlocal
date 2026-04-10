/*global OB */

(function () {
  OB.UTIL.HookManager.registerHook(
    'OBPOS_RenderSelectorLine',
    function (args, callbacks) {
      const model = args.selectorLine.model;
      args.selectorLine.$.delivered.setContent(
        `Entregado ${model.get('deliveryStatus')} %`
      );
      args.selectorLine.$.distpatcher.setContent(model.get('dispatcher'));
      args.selectorLine.$.invoiced.setContent(
        `Facturado ${model.get('invoiceStatus')} %`
      );
      OB.UTIL.HookManager.callbackExecutor(args, callbacks);
    }
  );
})();
