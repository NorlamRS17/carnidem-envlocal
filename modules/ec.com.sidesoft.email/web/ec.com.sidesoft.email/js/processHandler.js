/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2012 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
OB.AEMAPP = OB.AEMAPP || {};

OB.AEMAPP.Process = {
  execute: function (params, view) {
    var i, selection = params.button.contextView.viewGrid.getSelectedRecord(),
      callback;

    callback = function (rpcResponse, data, rpcRequest) {
      // show result
      isc.say(data.preview);
      params.button.contextView.viewGrid.refreshGrid();
      // close process to refresh current view
      params.button.closeProcessPopup();
    };

    OB.RemoteCallManager.call('ec.com.sidesoft.email.actionHandler.PreviewEmailHandler', {
      reccorId: selection,
      action: params.action
    }, {}, callback);
  },
  previewMail: function (params, view) {
    OB.AEMAPP.Process.execute(params, view);
  }
};