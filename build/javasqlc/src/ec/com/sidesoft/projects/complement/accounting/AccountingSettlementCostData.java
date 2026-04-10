//Sqlc generated V1.O00-1
package ec.com.sidesoft.projects.complement.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class AccountingSettlementCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountingSettlementCostData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String datedoc;
  public String cCurrencyId;
  public String cDoctypeId;
  public String documentno;
  public String posted;
  public String value;
  public String cProjectId;
  public String cProjectphaseId;
  public String cProjecttaskId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("datedoc"))
      return datedoc;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("value"))
      return value;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_projectphase_id") || fieldName.equals("cProjectphaseId"))
      return cProjectphaseId;
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountingSettlementCostData[] selectRecord(ConnectionProvider connectionProvider, String id)    throws ServletException {
    return selectRecord(connectionProvider, id, 0, 0);
  }

  public static AccountingSettlementCostData[] selectRecord(ConnectionProvider connectionProvider, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select" +
      "        ssc.AD_CLIENT_ID, ssc.AD_ORG_ID" +
      "        ,DATE AS DATEDOC, '100' AS C_CURRENCY_ID" +
      "        ,ssc.c_doctype_id  C_DOCTYPE_ID" +
      "        ,ssc.documentno AS DOCUMENTNO   " +
      "        ,POSTED,0 AS VALUE  " +
      "        ,coalesce(c_project_id,'ND') as c_project_id, coalesce(c_projectphase_id,'ND') as c_projectphase_id , coalesce(C_ProjectTask_id,'ND') as C_ProjectTask_id" +
      "        from sproctm_settlement_cost ssc   " +
      "        where ssc.sproctm_settlement_cost_id = ?              ";

    ResultSet result;
    Vector<AccountingSettlementCostData> vector = new Vector<AccountingSettlementCostData>(0);
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
        AccountingSettlementCostData objectAccountingSettlementCostData = new AccountingSettlementCostData();
        objectAccountingSettlementCostData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountingSettlementCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountingSettlementCostData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectAccountingSettlementCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAccountingSettlementCostData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectAccountingSettlementCostData.documentno = UtilSql.getValue(result, "documentno");
        objectAccountingSettlementCostData.posted = UtilSql.getValue(result, "posted");
        objectAccountingSettlementCostData.value = UtilSql.getValue(result, "value");
        objectAccountingSettlementCostData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectAccountingSettlementCostData.cProjectphaseId = UtilSql.getValue(result, "c_projectphase_id");
        objectAccountingSettlementCostData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectAccountingSettlementCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountingSettlementCostData);
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
    AccountingSettlementCostData objectAccountingSettlementCostData[] = new AccountingSettlementCostData[vector.size()];
    vector.copyInto(objectAccountingSettlementCostData);
    return(objectAccountingSettlementCostData);
  }
}
