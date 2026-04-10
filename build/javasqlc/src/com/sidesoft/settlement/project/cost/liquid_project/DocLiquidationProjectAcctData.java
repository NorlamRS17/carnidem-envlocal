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

public class DocLiquidationProjectAcctData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLiquidationProjectAcctData.class);
  private String InitRecordNumber="0";
  public String pCogsAcct;
  public String emSstpcCostProcessProd;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("p_cogs_acct") || fieldName.equals("pCogsAcct"))
      return pCogsAcct;
    else if (fieldName.equalsIgnoreCase("em_sstpc_cost_process_prod") || fieldName.equals("emSstpcCostProcessProd"))
      return emSstpcCostProcessProd;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLiquidationProjectAcctData[] selectAcct(ConnectionProvider connectionProvider, String SSTPC_LIQUIDATION_PROJECTS_ID, String C_ACCTSCHEMA_ID)    throws ServletException {
    return selectAcct(connectionProvider, SSTPC_LIQUIDATION_PROJECTS_ID, C_ACCTSCHEMA_ID, 0, 0);
  }

  public static DocLiquidationProjectAcctData[] selectAcct(ConnectionProvider connectionProvider, String SSTPC_LIQUIDATION_PROJECTS_ID, String C_ACCTSCHEMA_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT P_COGS_ACCT, EM_SSTPC_COST_PROCESS_PROD   " +
      "        FROM SSTPC_LIQUIDATION_PROJECTS SLP  " +
      "        JOIN SSTPC_CONSUMPTION_LINE SCL ON SLP.SSTPC_LIQUIDATION_PROJECTS_ID = SCL.SSTPC_LIQUIDATION_PROJECTS_ID   " +
      "        JOIN M_PRODUCT MP ON MP.M_PRODUCT_ID = SCL.M_PRODUCT_ID   " +
      "        JOIN M_PRODUCT_ACCT MPA ON MPA.M_PRODUCT_ID = MP.M_PRODUCT_ID   " +
      "		WHERE SLP.SSTPC_LIQUIDATION_PROJECTS_ID = ?    " +
      "		AND MPA.C_ACCTSCHEMA_ID = ?    ";

    ResultSet result;
    Vector<DocLiquidationProjectAcctData> vector = new Vector<DocLiquidationProjectAcctData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SSTPC_LIQUIDATION_PROJECTS_ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, C_ACCTSCHEMA_ID);

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
        DocLiquidationProjectAcctData objectDocLiquidationProjectAcctData = new DocLiquidationProjectAcctData();
        objectDocLiquidationProjectAcctData.pCogsAcct = UtilSql.getValue(result, "p_cogs_acct");
        objectDocLiquidationProjectAcctData.emSstpcCostProcessProd = UtilSql.getValue(result, "em_sstpc_cost_process_prod");
        objectDocLiquidationProjectAcctData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLiquidationProjectAcctData);
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
    DocLiquidationProjectAcctData objectDocLiquidationProjectAcctData[] = new DocLiquidationProjectAcctData[vector.size()];
    vector.copyInto(objectDocLiquidationProjectAcctData);
    return(objectDocLiquidationProjectAcctData);
  }

  public static int updateStatusAsset(ConnectionProvider connectionProvider, String SSTPC_LIQUIDATION_PROJECTS_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSTPC_LIQUIDATION_PROJECTS   " +
      "        SET ISACTIVE = 'Y'" +
      "        WHERE SSTPC_LIQUIDATION_PROJECTS_ID = ?  ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SSTPC_LIQUIDATION_PROJECTS_ID);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
