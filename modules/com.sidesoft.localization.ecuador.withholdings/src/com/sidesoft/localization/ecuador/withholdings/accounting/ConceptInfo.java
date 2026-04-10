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
 * Contributions are Copyright (C) 2001-2012 Openbravo S.L.U.
 ******************************************************************************
 */
package com.sidesoft.localization.ecuador.withholdings.accounting;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctSchema;

public class ConceptInfo {
  static Logger log4jConceptInfo = Logger.getLogger(ConceptInfo.class);

  /**
   * Constructor
   */
  public ConceptInfo(String SSWH_Withh_Card_Credit_ID, ConnectionProvider conn) {
    init(SSWH_Withh_Card_Credit_ID, conn);
  } // ConceptInfo

  public static final BigDecimal ZERO = new BigDecimal("0");
  /** The Concept Key */
  public String m_SSWH_Withh_Card_Credit_ID = "";
  // Concept Info
  public String m_AD_Client_ID = "";
  public String m_AD_Org_ID = "";

  public String m_withhRent = "";
  public String m_withhVat = "";
  public String m_closing = "";

  /**
   * Get Concept Info (Service, Revenue Recognition). automatically called by constructor
   * 
   * @param SSPR_Concept_ID
   *          Concept
   */
  private void init(String SSPR_Concept_ID, ConnectionProvider conn) {
    m_SSWH_Withh_Card_Credit_ID = SSPR_Concept_ID;
    if (m_SSWH_Withh_Card_Credit_ID != null && m_SSWH_Withh_Card_Credit_ID.equals(""))
      return;

    ConceptInfoData[] data = null;
    try {
      data = ConceptInfoData.selectDefaultAcct(conn, m_SSWH_Withh_Card_Credit_ID);
      if (data.length == 1) {
        m_withhRent = data[0].cWithhrent;
        m_withhVat = data[0].cWithhvat;
        m_closing = data[0].cClosing;
      }
    } catch (ServletException e) {
      log4jConceptInfo.warn(e);
    }
  } // init

  /**
   * Account from Accounting Schema defaults
   * 
   * @param AcctType
   *          see ACCTTYPE_* (1..8)
   * @param as
   *          accounting schema
   * @return Requested Concept Account
   */
  public static Account getAccountDefault(String AcctType, AcctSchema as, ConnectionProvider conn) {
    if (Integer.parseInt(AcctType) < 1 || Integer.parseInt(AcctType) > 8)
      return null;
    ConceptInfoData[] data = null;
    Account acct = null;
    try {
      data = ConceptInfoData.selectDefaultAcct(conn, as.getC_AcctSchema_ID());
      String validCombination_ID = "";
      switch (Integer.parseInt(AcctType)) {
      case 1:
        validCombination_ID = data[0].cWithhrent;
        break;
      case 2:
        validCombination_ID = data[0].cWithhvat;
        break;
      case 3:
        validCombination_ID = data[0].cClosing;
        break;
      }
      if (validCombination_ID.equals(""))
        return null;
      acct = Account.getAccount(conn, validCombination_ID);
    } catch (ServletException e) {
      log4jConceptInfo.warn(e);
    }
    return acct;
  } // getAccountDefault

  /** Concept C_Debit Acct */
  public static final String ACCTTYPE_C_Debit = "1";
  /** Concept C_Credit Acct */
  public static final String ACCTTYPE_C_Credit = "2";
  /** Concept C_Closing Acct */
  public static final String ACCTTYPE_C_Closing = "3";

} // ConceptInfo
