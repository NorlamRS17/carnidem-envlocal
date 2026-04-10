/*global OB */

(function () {
  OB.UTIL.HookManager.registerHook(
    'OBPOS_PreShowPane',
    function (args, callbacks) {
      const paneName = 'payment';
      if (args.tabName === paneName) {
        const receipt = args.context.model.get('order');
        const bp = receipt.get('bp');
        if (
          bp.get('taxIdType') === 'EEI_C' &&
          receipt.getGross() > bp.get('invoiceLimitAmount')
        ) {
          args.cancelOperation = true;
          OB.UTIL.showError(
            OB.I18N.getLabel('SFECFP_BP_OverInvoiceLimitAmount', [
              bp.get('invoiceLimitAmount'),
            ])
          );
        }
      }
      OB.UTIL.HookManager.callbackExecutor(args, callbacks);
    }
  );
})();
