//Sqlc generated V1.O00-1
package com.sidesoft.settlement.project.cost.liquid_project;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLiquidationProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLiquidationProjectData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String documentno;
  public String datedoc;
  public String cPeriodId;
  public String cCurrencyId;
  public String cDoctypeId;
  public String posted;
  public String value;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_period_id") || fieldName.equals("cPeriodId"))
      return cPeriodId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLiquidationProjectData[] selectRecord(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRecord(connectionProvider, client, id, 0, 0);
  }

  public static DocLiquidationProjectData[] selectRecord(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                SELECT SLP.AD_CLIENT_ID, SLP.AD_ORG_ID, SLP.DOCUMENTNO,SLP.DATEDOC," +
      "                CP.C_PERIOD_ID" +
      "                , '100' AS C_CURRENCY_ID, SLP.C_DOCTYPE_ID, SLP.POSTED, 0 AS VALUE   " +
      "                FROM SSTPC_LIQUIDATION_PROJECTS SLP    " +
      "                JOIN C_PERIOD CP ON SLP.DATEDOC BETWEEN  CP.STARTDATE AND CP.ENDDATE   " +
      "                WHERE SLP.AD_Client_ID=?  " +
      "                AND  SLP.SSTPC_LIQUIDATION_PROJECTS_ID = ?   ";

    ResultSet result;
    Vector<DocLiquidationProjectData> vector = new Vector<DocLiquidationProjectData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
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
        DocLiquidationProjectData objectDocLiquidationProjectData = new DocLiquidationProjectData();
        objectDocLiquidationProjectData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocLiquidationProjectData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLiquidationProjectData.documentno = UtilSql.getValue(result, "documentno");
        objectDocLiquidationProjectData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectDocLiquidationProjectData.cPeriodId = UtilSql.getValue(result, "c_period_id");
        objectDocLiquidationProjectData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLiquidationProjectData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocLiquidationProjectData.posted = UtilSql.getValue(result, "posted");
        objectDocLiquidationProjectData.value = UtilSql.getValue(result, "value");
        objectDocLiquidationProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLiquidationProjectData);
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
    DocLiquidationProjectData objectDocLiquidationProjectData[] = new DocLiquidationProjectData[vector.size()];
    vector.copyInto(objectDocLiquidationProjectData);
    return(objectDocLiquidationProjectData);
  }
}
