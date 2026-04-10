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

class SproctmMOLinesData implements FieldProvider {
static Logger log4j = Logger.getLogger(SproctmMOLinesData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String adClientId;
  public String sproctmDetailCostId;
  public String recordId;
  public String cBpartnerId;
  public String hours;
  public String date;
  public String cost;
  public String totalCost;
  public String status;
  public String posted;
  public String settlement;
  public String adTabId;
  public String salarycategoryid;
  public String cSalaryCategoryId;
  public String cCurrencyId;
  public String inProcesCElementvalueId;
  public String transferCElementvalueId;
  public String setlementCElementvalueId;
  public String ssprConceptId;
  public String emSsprCategoryAcctId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("sproctm_detail_cost_id") || fieldName.equals("sproctmDetailCostId"))
      return sproctmDetailCostId;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("hours"))
      return hours;
    else if (fieldName.equalsIgnoreCase("date"))
      return date;
    else if (fieldName.equalsIgnoreCase("cost"))
      return cost;
    else if (fieldName.equalsIgnoreCase("total_cost") || fieldName.equals("totalCost"))
      return totalCost;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("settlement"))
      return settlement;
    else if (fieldName.equalsIgnoreCase("ad_tab_id") || fieldName.equals("adTabId"))
      return adTabId;
    else if (fieldName.equalsIgnoreCase("salarycategoryid"))
      return salarycategoryid;
    else if (fieldName.equalsIgnoreCase("c_salary_category_id") || fieldName.equals("cSalaryCategoryId"))
      return cSalaryCategoryId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("in_proces_c_elementvalue_id") || fieldName.equals("inProcesCElementvalueId"))
      return inProcesCElementvalueId;
    else if (fieldName.equalsIgnoreCase("transfer_c_elementvalue_id") || fieldName.equals("transferCElementvalueId"))
      return transferCElementvalueId;
    else if (fieldName.equalsIgnoreCase("setlement_c_elementvalue_id") || fieldName.equals("setlementCElementvalueId"))
      return setlementCElementvalueId;
    else if (fieldName.equalsIgnoreCase("sspr_concept_id") || fieldName.equals("ssprConceptId"))
      return ssprConceptId;
    else if (fieldName.equalsIgnoreCase("em_sspr_category_acct_id") || fieldName.equals("emSsprCategoryAcctId"))
      return emSsprCategoryAcctId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SproctmMOLinesData[] selectline(ConnectionProvider connectionProvider, String detailCostId)    throws ServletException {
    return selectline(connectionProvider, detailCostId, 0, 0);
  }

  public static SproctmMOLinesData[] selectline(ConnectionProvider connectionProvider, String detailCostId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select dc.AD_ORG_ID, dc.ad_client_id, dc.sproctm_detail_cost_id" +
      "        , dc.record_id ,  dc.c_bpartner_id, dc.hours, dc.date , dc.cost, dc.total_cost" +
      "        , dc.status, dc.posted, dc.settlement, dc.ad_tab_id " +
      "        , cca.RECORD_ID as SalaryCategoryId, sc.C_Salary_Category_ID" +
      "        , '100' AS C_CURRENCY_ID" +
      "        , cca.in_proces_c_elementvalue_id, cca.transfer_c_elementvalue_id, cca.setlement_c_elementvalue_id" +
      "        , ssc.SSPR_CONCEPT_ID, b.EM_SSPR_CATEGORY_ACCT_ID" +
      "        from sproctm_detail_cost dc" +
      "        Inner join sproctm_task_workforce tw on tw.sproctm_task_workforce_id = record_id  " +
      "        inner join C_Salary_Category sc on sc.C_Salary_Category_id = tw.C_Salary_Category_id" +
      "        LEFT join sproctm_config_account cca on cca.RECORD_ID = sc.C_Salary_Category_id" +
      "        LEFT join c_bpartner b on b.c_bpartner_ID = dc.c_bpartner_id" +
      "        LEFT JOIN SSPR_CONCEPT SsC ON SsC.SSPR_CONCEPT_ID = B.em_sspr_concept_id" +
      "        where sproctm_detail_cost_id = ?      ";

    ResultSet result;
    Vector<SproctmMOLinesData> vector = new Vector<SproctmMOLinesData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, detailCostId);

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
        SproctmMOLinesData objectSproctmMOLinesData = new SproctmMOLinesData();
        objectSproctmMOLinesData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSproctmMOLinesData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectSproctmMOLinesData.sproctmDetailCostId = UtilSql.getValue(result, "sproctm_detail_cost_id");
        objectSproctmMOLinesData.recordId = UtilSql.getValue(result, "record_id");
        objectSproctmMOLinesData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectSproctmMOLinesData.hours = UtilSql.getValue(result, "hours");
        objectSproctmMOLinesData.date = UtilSql.getDateValue(result, "date", "dd-MM-yyyy");
        objectSproctmMOLinesData.cost = UtilSql.getValue(result, "cost");
        objectSproctmMOLinesData.totalCost = UtilSql.getValue(result, "total_cost");
        objectSproctmMOLinesData.status = UtilSql.getValue(result, "status");
        objectSproctmMOLinesData.posted = UtilSql.getValue(result, "posted");
        objectSproctmMOLinesData.settlement = UtilSql.getValue(result, "settlement");
        objectSproctmMOLinesData.adTabId = UtilSql.getValue(result, "ad_tab_id");
        objectSproctmMOLinesData.salarycategoryid = UtilSql.getValue(result, "salarycategoryid");
        objectSproctmMOLinesData.cSalaryCategoryId = UtilSql.getValue(result, "c_salary_category_id");
        objectSproctmMOLinesData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectSproctmMOLinesData.inProcesCElementvalueId = UtilSql.getValue(result, "in_proces_c_elementvalue_id");
        objectSproctmMOLinesData.transferCElementvalueId = UtilSql.getValue(result, "transfer_c_elementvalue_id");
        objectSproctmMOLinesData.setlementCElementvalueId = UtilSql.getValue(result, "setlement_c_elementvalue_id");
        objectSproctmMOLinesData.ssprConceptId = UtilSql.getValue(result, "sspr_concept_id");
        objectSproctmMOLinesData.emSsprCategoryAcctId = UtilSql.getValue(result, "em_sspr_category_acct_id");
        objectSproctmMOLinesData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSproctmMOLinesData);
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
    SproctmMOLinesData objectSproctmMOLinesData[] = new SproctmMOLinesData[vector.size()];
    vector.copyInto(objectSproctmMOLinesData);
    return(objectSproctmMOLinesData);
  }
}
