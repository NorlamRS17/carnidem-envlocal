/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2014-2018 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
//OB.APRM.AddPayment = OB.APRM.AddPayment || {};


OB.APRM.AddPayment.actualPaymentMethodOnChange = function (item, view, form, grid) {
  var ordinvgrid = form.getItem('order_invoice').canvas.viewGrid,
      defaultFilter = ordinvgrid.filterEditor.getEditForm().getValues(),
      trxtype = (form.getItem('trxtype')) ? form.getItem('trxtype').getValue() : "",
      affectedParams = [];
      thisform = form;
  isc.addProperties(defaultFilter, {
    paymentMethodName: item.getElementValue()
  });
  OB.APRM.AddPayment.paymentMethodMulticurrency(view, form, true);
  OB.APRM.AddPayment.checkSingleActionAvailable(form);
  if (trxtype !== "") {
    ordinvgrid.setFilterEditorCriteria(defaultFilter);
    ordinvgrid.filterByEditor();
  }
  affectedParams.push(form.getField('c_currency_id_readonly_logic').paramId);
  OB.APRM.AddPayment.recalcDisplayLogicOrReadOnlyLogic(form, view, affectedParams);
  var callback = function(response, data, request) {
    field = thisform.getItem("iscard_display_logic");
    field.setValue(data.iscard);
    form.redraw();
    //form.setItemValue("iscard_display_logic", data.iscard);
  };

  paymentMethodId = form.getItem('fin_paymentmethod_id').getValue(),
  OB.RemoteCallManager.call('ec.com.sidesoft.creditcard.reconciliation.actionHandler.PaymentMethodMulticurrencyActionHandler', {
    paymentMethodId: paymentMethodId
  }, {}, callback);

};
