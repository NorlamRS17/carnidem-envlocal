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

class DocLineSettlementCostData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLineSettlementCostData.class);
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
  public String cProjecttaskId;
  public String linea;

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
    else if (fieldName.equalsIgnoreCase("c_projecttask_id") || fieldName.equals("cProjecttaskId"))
      return cProjecttaskId;
    else if (fieldName.equalsIgnoreCase("linea"))
      return linea;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLineSettlementCostData[] select(ConnectionProvider connectionProvider, String DateToSc, String ProjectID, String DateTo, String PhaseID, String TaskID, String DateToSc1, String Project1ID, String DateTo1, String DateToSc2, String Project2ID, String DateTo2)    throws ServletException {
    return select(connectionProvider, DateToSc, ProjectID, DateTo, PhaseID, TaskID, DateToSc1, Project1ID, DateTo1, DateToSc2, Project2ID, DateTo2, 0, 0);
  }

  public static DocLineSettlementCostData[] select(ConnectionProvider connectionProvider, String DateToSc, String ProjectID, String DateTo, String PhaseID, String TaskID, String DateToSc1, String Project1ID, String DateTo1, String DateToSc2, String Project2ID, String DateTo2, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select  " +
      "    sproctm_task_workforce_id, stw.ad_org_id" +
      "    ,10 as line, '' as description, round(sdc.total_cost,2) as amount" +
      "    , '100' as c_currency_id, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID" +
      "    , BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID " +
      "    , BP.C_BPARTNER_ID ,  act.account_id,act.isbalance  " +
      "    , stw.C_ProjectTask_id" +
      "    , 1 as linea" +
      "    from sproctm_detail_cost sdc" +
      "    join sproctm_settl_cost_ln sdcl on (sdcl.sproctm_detail_cost_id = sdc.sproctm_detail_cost_id and " +
      "    sproctm_settlement_cost_id =? )" +
      "    left join sproctm_task_workforce stw on stw.sproctm_task_workforce_id = sdc.record_id" +
      "    left join c_projecttask cpt on cpt.c_projecttask_id = stw.c_projecttask_id" +
      "    left join c_projectphase cpp on cpp.c_projectphase_id = cpt.c_projectphase_id" +
      "    left join (" +
      "        select " +
      "        setlement_c_elementvalue_id as account_id" +
      "        ,'Y' as isbalance, record_id as c_salary_category_id" +
      "        from sproctm_config_account" +
      "        union all" +
      "        select " +
      "        in_proces_c_elementvalue_id" +
      "        ,'N' as isbalance, record_id as c_salary_category_id" +
      "        from sproctm_config_account" +
      "    ) act on act.c_salary_category_id = stw.c_salary_category_id" +
      "    left join c_bpartner bp on bp.c_bpartner_id = sdc.c_bpartner_id" +
      "    where cpp.c_project_id = ?" +
      "    and sdc.date <= (select ssc.dateto from sproctm_settlement_cost ssc " +
      "                    where sproctm_settlement_cost_id =?" +
      "                   )" +
      "    AND 1=1";
    strSql = strSql + ((PhaseID==null || PhaseID.equals(""))?"":"  and  cpp.c_projectphase_id= ?  ");
    strSql = strSql + 
      "    AND 2=2";
    strSql = strSql + ((TaskID==null || TaskID.equals(""))?"":"  and  cpt.C_ProjectTask_id= ?  ");
    strSql = strSql + 
      "    union all  " +
      "    select  " +
      "    sproctm_task_cif_id, stw.ad_org_id" +
      "    ,10 as line, '' as description, round(sdc.total_cost,2) as amount" +
      "    , '100' as c_currency_id, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID" +
      "    , BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID " +
      "    , BP.C_BPARTNER_ID ,  act.account_id,act.isbalance  " +
      "    , stw.C_ProjectTask_id" +
      "    , 2 as linea" +
      "    from sproctm_detail_cost sdc" +
      "    join sproctm_settl_cost_ln sdcl on (sdcl.sproctm_detail_cost_id = sdc.sproctm_detail_cost_id and " +
      "    sproctm_settlement_cost_id =? ) " +
      "    left join sproctm_task_cif stw on stw.sproctm_task_cif_id = sdc.record_id" +
      "    left join c_projecttask cpt on cpt.c_projecttask_id = stw.c_projecttask_id" +
      "    left join c_projectphase cpp on cpp.c_projectphase_id = cpt.c_projectphase_id" +
      "    left join (" +
      "        select " +
      "        setlement_c_elementvalue_id as account_id" +
      "        ,'Y' as isbalance, record_id as c_salary_category_id" +
      "        from sproctm_config_account" +
      "        union all" +
      "        select " +
      "        in_proces_c_elementvalue_id" +
      "        ,'N' as isbalance, record_id as c_salary_category_id" +
      "        from sproctm_config_account" +
      "    ) act on act.c_salary_category_id = stw.MA_Indirect_Cost_id" +
      "    left join c_bpartner bp on bp.c_bpartner_id = sdc.c_bpartner_id" +
      "    where cpp.c_project_id = ?" +
      "    and sdc.date <= (select ssc.dateto from sproctm_settlement_cost ssc " +
      "                    where sproctm_settlement_cost_id =?" +
      "                   )" +
      "    AND 3=3";
    strSql = strSql + ((PhaseID==null || PhaseID.equals(""))?"":"  and  cpp.c_projectphase_id= ?  ");
    strSql = strSql + 
      "    AND 4=4";
    strSql = strSql + ((TaskID==null || TaskID.equals(""))?"":"  and  cpt.C_ProjectTask_id= ?  ");
    strSql = strSql + 
      "    union all  " +
      "    select  " +
      "    sproctm_task_machine_id, stw.ad_org_id" +
      "    ,10 as line, '' as description, round(sdc.total_cost,2) as amount" +
      "    , '100' as c_currency_id, BP.EM_SSPR_COSTCENTER_ID AS C_COSTCENTER_ID" +
      "    , BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID " +
      "    , BP.C_BPARTNER_ID ,  act.account_id,act.isbalance  " +
      "    , stw.C_ProjectTask_id" +
      "    , 3 as linea" +
      "    from sproctm_detail_cost sdc" +
      "    join sproctm_settl_cost_ln sdcl on (sdcl.sproctm_detail_cost_id = sdc.sproctm_detail_cost_id and " +
      "    sproctm_settlement_cost_id =? )" +
      "    left join sproctm_task_machine stw on stw.sproctm_task_machine_id = sdc.record_id" +
      "    left join c_projecttask cpt on cpt.c_projecttask_id = stw.c_projecttask_id" +
      "    left join c_projectphase cpp on cpp.c_projectphase_id = cpt.c_projectphase_id" +
      "    left join (" +
      "        select " +
      "        setlement_c_elementvalue_id as account_id" +
      "        ,'Y' as isbalance, record_id as c_salary_category_id" +
      "        from sproctm_config_account" +
      "        union all" +
      "        select " +
      "        in_proces_c_elementvalue_id" +
      "        ,'N' as isbalance, record_id as c_salary_category_id" +
      "        from sproctm_config_account" +
      "    ) act on act.c_salary_category_id = stw.MA_Machine_id" +
      "    left join c_bpartner bp on bp.c_bpartner_id = sdc.c_bpartner_id" +
      "    where cpp.c_project_id = ?" +
      "    and sdc.date <= (select ssc.dateto from sproctm_settlement_cost ssc " +
      "                    where sproctm_settlement_cost_id =?" +
      "                   )" +
      "    AND 5=5";
    strSql = strSql + ((PhaseID==null || PhaseID.equals(""))?"":"  and  cpp.c_projectphase_id= ?  ");
    strSql = strSql + 
      "    AND 6=6";
    strSql = strSql + ((TaskID==null || TaskID.equals(""))?"":"  and  cpt.C_ProjectTask_id= ?  ");

    ResultSet result;
    Vector<DocLineSettlementCostData> vector = new Vector<DocLineSettlementCostData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateToSc);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ProjectID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo);
      if (PhaseID != null && !(PhaseID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, PhaseID);
      }
      if (TaskID != null && !(TaskID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, TaskID);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateToSc1);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Project1ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo1);
      if (PhaseID != null && !(PhaseID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, PhaseID);
      }
      if (TaskID != null && !(TaskID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, TaskID);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateToSc2);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, Project2ID);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DateTo2);
      if (PhaseID != null && !(PhaseID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, PhaseID);
      }
      if (TaskID != null && !(TaskID.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, TaskID);
      }

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
        DocLineSettlementCostData objectDocLineSettlementCostData = new DocLineSettlementCostData();
        objectDocLineSettlementCostData.sproctmTaskWorkforceId = UtilSql.getValue(result, "sproctm_task_workforce_id");
        objectDocLineSettlementCostData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLineSettlementCostData.line = UtilSql.getValue(result, "line");
        objectDocLineSettlementCostData.description = UtilSql.getValue(result, "description");
        objectDocLineSettlementCostData.amount = UtilSql.getValue(result, "amount");
        objectDocLineSettlementCostData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLineSettlementCostData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLineSettlementCostData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLineSettlementCostData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLineSettlementCostData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLineSettlementCostData.accountId = UtilSql.getValue(result, "account_id");
        objectDocLineSettlementCostData.isbalance = UtilSql.getValue(result, "isbalance");
        objectDocLineSettlementCostData.cProjecttaskId = UtilSql.getValue(result, "c_projecttask_id");
        objectDocLineSettlementCostData.linea = UtilSql.getValue(result, "linea");
        objectDocLineSettlementCostData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLineSettlementCostData);
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
    DocLineSettlementCostData objectDocLineSettlementCostData[] = new DocLineSettlementCostData[vector.size()];
    vector.copyInto(objectDocLineSettlementCostData);
    return(objectDocLineSettlementCostData);
  }
}
