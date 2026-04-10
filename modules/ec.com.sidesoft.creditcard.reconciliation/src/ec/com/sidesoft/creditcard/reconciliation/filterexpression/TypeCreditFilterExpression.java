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

public class TypeCreditFilterExpression implements FilterExpression {
  private Map<String, String> requestMap;

  @Override
  public String getExpression(Map<String, String> requestMap) {
    StringBuilder whereClause = new StringBuilder();

    String strSsccr_Processor_Banck_ID = requestMap.get("Ssccr_Processor_Banck_ID");

    whereClause.append("e.id IN (SELECT typesOfCredit.id " + 
        "FROM Ssccr_CardMatchingConfLine as d " + 
        "WHERE d.ssccrCardmatchingconf.processorBanck.id = '" +strSsccr_Processor_Banck_ID+
        "' GROUP BY 1)");

    return whereClause.toString();
  }
}
