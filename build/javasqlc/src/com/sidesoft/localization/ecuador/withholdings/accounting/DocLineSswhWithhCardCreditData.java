//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLineSswhWithhCardCreditData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineSswhWithhCardCreditData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String sswhWithhCardCreditId;
  public String withhVat;
  public String withhRent;
  public String total;
  public String line;
  public String cCurrencyId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("sswh_withh_card_credit_id") || fieldName.equals("sswhWithhCardCreditId"))
      return sswhWithhCardCreditId;
    else if (fieldName.equalsIgnoreCase("withh_vat") || fieldName.equals("withhVat"))
      return withhVat;
    else if (fieldName.equalsIgnoreCase("withh_rent") || fieldName.equals("withhRent"))
      return withhRent;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineSswhWithhCardCreditData[] select(ConnectionProvider connectionProvider, String id)    throws ServletException {
    return select(connectionProvider, id, 0, 0);
  }

  public static DocLineSswhWithhCardCreditData[] select(ConnectionProvider connectionProvider, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT ad_org_id, sswh_withh_card_credit_id, withh_vat, withh_rent, (withh_rent + withh_vat) as total" +
      "        , 10 as line, '100' AS C_CURRENCY_ID" +
      "        FROM sswh_withh_card_credit  " +
      "        WHERE sswh_withh_card_credit_id = ?";

    ResultSet result;
    Vector<DocLineSswhWithhCardCreditData> vector = new Vector<DocLineSswhWithhCardCreditData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        DocLineSswhWithhCardCreditData objectDocLineSswhWithhCardCreditData = new DocLineSswhWithhCardCreditData();
        objectDocLineSswhWithhCardCreditData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineSswhWithhCardCreditData.sswhWithhCardCreditId = UtilSql.getValue(result, "sswh_withh_card_credit_id");
        objectDocLineSswhWithhCardCreditData.withhVat = UtilSql.getValue(result, "withh_vat");
        objectDocLineSswhWithhCardCreditData.withhRent = UtilSql.getValue(result, "withh_rent");
        objectDocLineSswhWithhCardCreditData.total = UtilSql.getValue(result, "total");
        objectDocLineSswhWithhCardCreditData.line = UtilSql.getValue(result, "line");
        objectDocLineSswhWithhCardCreditData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineSswhWithhCardCreditData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineSswhWithhCardCreditData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    DocLineSswhWithhCardCreditData objectDocLineSswhWithhCardCreditData[] = new DocLineSswhWithhCardCreditData[vector.size()];
    vector.copyInto(objectDocLineSswhWithhCardCreditData);
    return(objectDocLineSswhWithhCardCreditData);
  }
}
