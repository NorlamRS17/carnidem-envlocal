//Sqlc generated V1.O00-1
package com.sidesoft.localization.ecuador.withholdings.accounting; ;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ConceptInfoData implements FieldProvider {
static Logger log4j = Logger.getLogger(ConceptInfoData.class);
  private String InitRecordNumber="0";
  public String cWithhrent;
  public String cWithhvat;
  public String cClosing;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_withhrent") || fieldName.equals("cWithhrent"))
      return cWithhrent;
    else if (fieldName.equalsIgnoreCase("c_withhvat") || fieldName.equals("cWithhvat"))
      return cWithhvat;
    else if (fieldName.equalsIgnoreCase("c_closing") || fieldName.equals("cClosing"))
      return cClosing;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ConceptInfoData[] selectDefaultAcct(ConnectionProvider connectionProvider, String AcctSchema)    throws ServletException {
    return selectDefaultAcct(connectionProvider, AcctSchema, 0, 0);
  }

  public static ConceptInfoData[] selectDefaultAcct(ConnectionProvider connectionProvider, String AcctSchema, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT em_sswh_wh_income_acct as C_withhRent, em_sswh_wh_iva_acct as C_withhVat, em_sswh_wh_transit_acct as C_Closing" +
      "        FROM c_acctschema_default" +
      "        WHERE C_AcctSchema_ID=?";

    ResultSet result;
    Vector<ConceptInfoData> vector = new Vector<ConceptInfoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AcctSchema);

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
        ConceptInfoData objectConceptInfoData = new ConceptInfoData();
        objectConceptInfoData.cWithhrent = UtilSql.getValue(result, "c_withhrent");
        objectConceptInfoData.cWithhvat = UtilSql.getValue(result, "c_withhvat");
        objectConceptInfoData.cClosing = UtilSql.getValue(result, "c_closing");
        objectConceptInfoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectConceptInfoData);
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
    ConceptInfoData objectConceptInfoData[] = new ConceptInfoData[vector.size()];
    vector.copyInto(objectConceptInfoData);
    return(objectConceptInfoData);
  }
}
