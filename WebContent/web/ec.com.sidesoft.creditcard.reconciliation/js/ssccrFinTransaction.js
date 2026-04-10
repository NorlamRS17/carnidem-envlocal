OB.OBPFCI = {};
OB.OBPFCI.ClientSideEventHandlers = {};
OB.OBPFCI.SSCCR_FIN_TRANSACTION_TAB = '23691259D1BD4496BCC5F32645BCA4B9';
OB.OBPFCI.ClientSideEventHandlers.ssccrFinTransaction = function (view, form, grid, extraParameters, actions) {
  var data = extraParameters.data, id, callback;
  id = data.id;
  callback = function (response, cdata, request) {
    OB.EventHandlerRegistry.callbackExecutor(view, form, grid, extraParameters, actions);
  };
  // Calling action handler
  OB.RemoteCallManager.call('ec.com.sidesoft.creditcard.reconciliation.actionHandler.SsccrFinTransactionActionHandler', {
    id: id
  }, {}, callback);
};
OB.EventHandlerRegistry.register(OB.OBPFCI.SSCCR_FIN_TRANSACTION_TAB, OB.EventHandlerRegistry.POSTSAVE, OB.OBPFCI.ClientSideEventHandlers.ssccrFinTransaction, 'SsccrFinTransaction');