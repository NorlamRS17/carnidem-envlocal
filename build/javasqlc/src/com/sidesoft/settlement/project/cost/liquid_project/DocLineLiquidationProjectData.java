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

class DocLineLiquidationProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineLiquidationProjectData.class);
  private String InitRecordNumber="0";
  public String sstpcConsumptionLineId;
  public String sstpcLiquidationProjectsId;
  public String adOrgId;
  public String line;
  public String description;
  public String cCurrencyId;
  public String cCostcenterId;
  public String pCogsAcct;
  public String emSstpcCostProcessProd;
  public String amount;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sstpc_consumption_line_id") || fieldName.equals("sstpcConsumptionLineId"))
      return sstpcConsumptionLineId;
    else if (fieldName.equalsIgnoreCase("sstpc_liquidation_projects_id") || fieldName.equals("sstpcLiquidationProjectsId"))
      return sstpcLiquidationProjectsId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("p_cogs_acct") || fieldName.equals("pCogsAcct"))
      return pCogsAcct;
    else if (fieldName.equalsIgnoreCase("em_sstpc_cost_process_prod") || fieldName.equals("emSstpcCostProcessProd"))
      return emSstpcCostProcessProd;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineLiquidationProjectData[] select(ConnectionProvider connectionProvider, String SSTPC_LIQUIDATION_PROJECTS_ID)    throws ServletException {
    return select(connectionProvider, SSTPC_LIQUIDATION_PROJECTS_ID, 0, 0);
  }

  public static DocLineLiquidationProjectData[] select(ConnectionProvider connectionProvider, String SSTPC_LIQUIDATION_PROJECTS_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SCL.SSTPC_CONSUMPTION_LINE_ID, SLP.SSTPC_LIQUIDATION_PROJECTS_ID, SLP.AD_ORG_ID, SCL.LINE, TO_CHAR(' -' ) AS DESCRIPTION, TO_CHAR('100') AS C_CURRENCY_ID," +
      "        SLP.C_COSTCENTER_ID, COALESCE(MPA.EM_SSTPC_PROJECT_COSTS, MPA.P_COGS_ACCT) P_COGS_ACCT, MPA.EM_SSTPC_COST_PROCESS_PROD, COSTCONSUMPTION AS AMOUNT" +
      "        FROM SSTPC_LIQUIDATION_PROJECTS SLP   " +
      "        JOIN SSTPC_CONSUMPTION_LINE SCL ON SLP.SSTPC_LIQUIDATION_PROJECTS_ID = SCL.SSTPC_LIQUIDATION_PROJECTS_ID   " +
      "        JOIN M_PRODUCT MP ON MP.M_PRODUCT_ID = SCL.M_PRODUCT_ID   " +
      "        JOIN M_PRODUCT_ACCT MPA ON MPA.M_PRODUCT_ID = MP.M_PRODUCT_ID   " +
      "        WHERE SLP.SSTPC_LIQUIDATION_PROJECTS_ID = ?";

    ResultSet result;
    Vector<DocLineLiquidationProjectData> vector = new Vector<DocLineLiquidationProjectData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, SSTPC_LIQUIDATION_PROJECTS_ID);

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
        DocLineLiquidationProjectData objectDocLineLiquidationProjectData = new DocLineLiquidationProjectData();
        objectDocLineLiquidationProjectData.sstpcConsumptionLineId = UtilSql.getValue(result, "sstpc_consumption_line_id");
        objectDocLineLiquidationProjectData.sstpcLiquidationProjectsId = UtilSql.getValue(result, "sstpc_liquidation_projects_id");
        objectDocLineLiquidationProjectData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineLiquidationProjectData.line = UtilSql.getValue(result, "line");
        objectDocLineLiquidationProjectData.description = UtilSql.getValue(result, "description");
        objectDocLineLiquidationProjectData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineLiquidationProjectData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineLiquidationProjectData.pCogsAcct = UtilSql.getValue(result, "p_cogs_acct");
        objectDocLineLiquidationProjectData.emSstpcCostProcessProd = UtilSql.getValue(result, "em_sstpc_cost_process_prod");
        objectDocLineLiquidationProjectData.amount = UtilSql.getValue(result, "amount");
        objectDocLineLiquidationProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineLiquidationProjectData);
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
    DocLineLiquidationProjectData objectDocLineLiquidationProjectData[] = new DocLineLiquidationProjectData[vector.size()];
    vector.copyInto(objectDocLineLiquidationProjectData);
    return(objectDocLineLiquidationProjectData);
  }
}
