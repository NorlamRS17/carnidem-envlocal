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
 * All portions are Copyright (C) 2010-2012 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

// create some globals
// NOTE: not using var before the declaration as this code is executed
// within a function, so it would create a local var instead of a global one
OB.AEMAPP = OB.AEMAPP || {};
OB.AEMAPP.OnChangeFunctions = {};

OB.AEMAPP.OnChangeFunctions.tabl = function (item, view, form, grid) {
  var tabId = item.getValue(tabId);
  console.log('OnChangeFunctions.tabl');
  console.log({ form, grid, tabId, item, view });

  if (tabId) {
    var callback = function (response, data, request) {
      form.setItemValue('table', data.tableId);
    };

    // do a server side call and on return call the callback
    OB.RemoteCallManager.call(
      'ec.com.sidesoft.email.onChange.OnchangeQueue',
      { value: tabId },
      {},
      callback
    );
  }

};