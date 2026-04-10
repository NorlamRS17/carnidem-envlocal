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

public class BankProcessedSelectorFilterExpression implements FilterExpression {
  private Map<String, String> requestMap;

  @Override
  public String getExpression(Map<String, String> requestMap) {
    StringBuilder whereClause = new StringBuilder();
    
    String strSsccrTypesOfCreditId = requestMap.get("ssccr_types_of_credit_id");
    String strSsccrCardsTypesId = requestMap.get("Ssccr_Cards_Types_ID");
    
    /*
    whereClause
        .append(" e.id = (select a.ssccrProcessorBanck.id from Ssccr_Cards_Types a where a.id = '"
            + strSsccrCardsTypesId + "') ");
    */
    whereClause
        .append("e.id = (SELECT DISTINCT cmc.processorBanck.id " +
            "FROM Ssccr_CardMatchingConfLine AS cmcl " +
            "RIGHT JOIN cmcl.ssccrCardmatchingconf AS cmc " +
            "WHERE cmcl.typesOfCredit.id='" + strSsccrTypesOfCreditId + "' " +
            "AND cmcl.ssccrCardsTypes.id='" + strSsccrCardsTypesId + "')");
    
    return whereClause.toString();
  }
}
