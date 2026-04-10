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

class DocLineProjecxtTaskData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineProjecxtTaskData.class);
  private String InitRecordNumber="0";
  public String sproctmTaskWorkforceId;
  public String adOrgId;
  public String line;
  public String description;
  public String amount;
  public String cCurrencyId;
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;
  public String cBpartnerId;
  public String accountId;
  public String isbalance;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sproctm_task_workforce_id") || fieldName.equals("sproctmTaskWorkforceId"))
      return sproctmTaskWorkforceId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("account_id") || fieldName.equals("accountId"))
      return accountId;
    else if (fieldName.equalsIgnoreCase("isbalance"))
      return isbalance;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineProjecxtTaskData[] select(ConnectionProvider connectionProvider, String TaskWorkForceID)    throws ServletException {
    return select(connectionProvider, TaskWorkForceID, 0, 0);
  }

  public static DocLineProjecxtTaskData[] select(ConnectionProvider connectionProvider, String TaskWorkForceID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select" +
      "	sproctm_task_workforce_id, stw.ad_org_id" +
      "	,10 as line, '' as description, round(sdc.total_cost,2) as amount" +
      "	, '100' as c_currency_id, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID" +
      "	, BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID " +
      "	, BP.C_BPARTNER_ID ,  act.account_id,act.isbalance  " +
      "	from sproctm_task_workforce stw" +
      "	join (" +
      "		select " +
      "		in_proces_c_elementvalue_id as account_id" +
      "		,'Y' as isbalance, record_id as c_salary_category_id" +
      "		from sproctm_config_account" +
      "		union all" +
      "		select " +
      "		transfer_c_elementvalue_id" +
      "		,'N' as isbalance, record_id as c_salary_category_id" +
      "		from sproctm_config_account" +
      "	) act on act.c_salary_category_id = stw.c_salary_category_id" +
      "	join sproctm_detail_cost sdc on sdc.record_id = stw.sproctm_task_workforce_id" +
      "	join c_bpartner bp on bp.c_bpartner_id = sdc.c_bpartner_id" +
      "	where sdc.sproctm_detail_cost_id = ?  " +
      "	union all" +
      "	select" +
      "	sproctm_task_cif_id, stw.ad_org_id" +
      "	,10 as line, '' as description, round(sdc.total_cost,2) as amount" +
      "	, '100' as c_currency_id, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID" +
      "	, BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID " +
      "	, BP.C_BPARTNER_ID ,  act.account_id,act.isbalance  " +
      "	from sproctm_task_cif stw" +
      "	join (" +
      "		select " +
      "		in_proces_c_elementvalue_id as account_id" +
      "		,'Y' as isbalance, record_id as c_salary_category_id" +
      "		from sproctm_config_account" +
      "		union all" +
      "		select " +
      "		transfer_c_elementvalue_id" +
      "		,'N' as isbalance, record_id as c_salary_category_id" +
      "		from sproctm_config_account" +
      "	) act on act.c_salary_category_id = stw.MA_Indirect_Cost_id" +
      "	join sproctm_detail_cost sdc on sdc.record_id = stw.sproctm_task_cif_id" +
      "	join c_bpartner bp on bp.c_bpartner_id = sdc.c_bpartner_id" +
      "	where sdc.sproctm_detail_cost_id = ?   " +
      "	union all" +
      "	select" +
      "	C_ProjectTask_id, stw.ad_org_id" +
      "	,10 as line, '' as description, round(sdc.total_cost,2) as amount" +
      "	, '100' as c_currency_id, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID" +
      "	, BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID " +
      "	, BP.C_BPARTNER_ID ,  act.account_id,act.isbalance  " +
      "	from sproctm_task_machine stw" +
      "	join (" +
      "		select " +
      "		in_proces_c_elementvalue_id as account_id" +
      "		,'Y' as isbalance, record_id as c_salary_category_id" +
      "		from sproctm_config_account" +
      "		union all" +
      "		select " +
      "		transfer_c_elementvalue_id" +
      "		,'N' as isbalance, record_id as c_salary_category_id" +
      "		from sproctm_config_account" +
      "	) act on act.c_salary_category_id = stw.MA_Machine_id" +
      "	join sproctm_detail_cost sdc on sdc.record_id = stw.sproctm_task_machine_id" +
      "	join c_bpartner bp on bp.c_bpartner_id = sdc.c_bpartner_id" +
      "	where sdc.sproctm_detail_cost_id = ?  ";

    ResultSet result;
    Vector<DocLineProjecxtTaskData> vector = new Vector<DocLineProjecxtTaskData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TaskWorkForceID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TaskWorkForceID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, TaskWorkForceID);

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
        DocLineProjecxtTaskData objectDocLineProjecxtTaskData = new DocLineProjecxtTaskData();
        objectDocLineProjecxtTaskData.sproctmTaskWorkforceId = UtilSql.getValue(result, "sproctm_task_workforce_id");
        objectDocLineProjecxtTaskData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineProjecxtTaskData.line = UtilSql.getValue(result, "line");
        objectDocLineProjecxtTaskData.description = UtilSql.getValue(result, "description");
        objectDocLineProjecxtTaskData.amount = UtilSql.getValue(result, "amount");
        objectDocLineProjecxtTaskData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineProjecxtTaskData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineProjecxtTaskData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineProjecxtTaskData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineProjecxtTaskData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineProjecxtTaskData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineProjecxtTaskData.isbalance = UtilSql.getValue(result, "isbalance");
        objectDocLineProjecxtTaskData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineProjecxtTaskData);
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
    DocLineProjecxtTaskData objectDocLineProjecxtTaskData[] = new DocLineProjecxtTaskData[vector.size()];
    vector.copyInto(objectDocLineProjecxtTaskData);
    return(objectDocLineProjecxtTaskData);
  }
}
