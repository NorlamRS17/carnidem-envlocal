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
 * All portions are Copyright (C) 2014 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

package ec.com.sidesoft.creditcard.reconciliation.filterexpression;

import java.util.Map;

import org.openbravo.client.application.FilterExpression;
import org.openbravo.base.exception.OBException;
import org.codehaus.jettison.json.JSONObject;

import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.dal.service.OBDal;

public class AddPaymentDisplayLogicsExpression implements FilterExpression {
  private Map<String, String> requestMap;

  @Override
  public String getExpression(Map<String, String> _requestMap) {
    try {
      requestMap = _requestMap;
      String strIsCard = "";
      JSONObject context = new JSONObject(requestMap.get("context"));
      String paymentMethodId = context.getString("inpfinPaymentmethodId");
      FIN_PaymentMethod objFIN_PaymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
      paymentMethodId);

      if (objFIN_PaymentMethod.getSccaTypePayment() != null
      && objFIN_PaymentMethod.getSccaTypePayment().equals("CA")) {// Tarjeta
        strIsCard="Y";
      } else {
        strIsCard="N";
      }

      return strIsCard;
    } catch (Exception e) {
      throw new OBException(e);
    }
  }
}
