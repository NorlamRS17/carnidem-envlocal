/*
 ******************************************************************************
 * The contents of this file are subject to the   Compiere License  Version 1.1
 * ("License"); You may not use this file except in compliance with the License
 * You may obtain a copy of the License at http://www.compiere.org/license.html
 * Software distributed under the License is distributed on an  "AS IS"  basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * The Original Code is                  Compiere  ERP & CRM  Business Solution
 * The Initial Developer of the Original Code is Jorg Janke  and ComPiere, Inc.
 * Portions created by Jorg Janke are Copyright (C) 1999-2001 Jorg Janke, parts
 * created by ComPiere are Copyright (C) ComPiere, Inc.;   All Rights Reserved.
 * Contributor(s): Openbravo SLU
 * Contributions are Copyright (C) 2001-2010 Openbravo S.L.U.
 ******************************************************************************
 */
package com.sidesoft.localization.ecuador.withholdings.accounting;

import org.openbravo.erpCommon.ad_forms.DocLine;

public class DocLine_SswhWithhCardCredit extends DocLine {

  public DocLine_SswhWithhCardCredit(String DocumentType, String TrxHeader_ID, String TrxLine_ID) {
    super(DocumentType, TrxHeader_ID, TrxLine_ID);
  }

  // Amounts
  public String m_withhRent = ZERO.toString();
  public String m_withhVat = ZERO.toString();
  public String m_total = ZERO.toString();

  public String getM_withhRent() {
    return m_withhRent;
  }

  public void setM_withhRent(String m_withhRent) {
    this.m_withhRent = m_withhRent;
  }

  public String getM_withhVat() {
    return m_withhVat;
  }

  public void setM_withhVat(String m_withhVat) {
    this.m_withhVat = m_withhVat;
  }

  public String getM_total() {
    return m_total;
  }

  public void setM_total(String m_total) {
    this.m_total = m_total;
  }

  public String getServletInfo() {
    return "Servlet for the accounting";
  } // end of getServletInfo() method
}
