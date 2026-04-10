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
OB.SSCCR_OCH = {};
OB.SSCCR_OCH.OnChangeFunctions = {};

OB.SSCCR_OCH.OnChangeFunctions.actualProcessorBank = function (item, view, form, grid) {
  thisform = form;
  var fieldTypeCredit = thisform.getItem("ssccr_types_of_credit_id");
  fieldTypeCredit.setValue("");
  var fieldCardsTypes = thisform.getItem("Ssccr_Cards_Types_ID");
  fieldCardsTypes.setValue("");
  form.redraw();
};
