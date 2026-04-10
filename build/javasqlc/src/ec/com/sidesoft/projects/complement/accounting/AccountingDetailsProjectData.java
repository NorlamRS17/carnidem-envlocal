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

class AccountingDetailsProjectData implements FieldProvider {
static Logger log4j = Logger.getLogger(AccountingDetailsProjectData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String datedoc;
  public String cCurrencyId;
  public String cDoctypeId;
  public String documentno;
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
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static AccountingDetailsProjectData[] selectRecord(ConnectionProvider connectionProvider, String id)    throws ServletException {
    return selectRecord(connectionProvider, id, 0, 0);
  }

  public static AccountingDetailsProjectData[] selectRecord(ConnectionProvider connectionProvider, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select" +
      "            spdt.AD_CLIENT_ID, spdt.AD_ORG_ID" +
      "            ,DATE AS DATEDOC, '100' AS C_CURRENCY_ID" +
      "            ,cp.em_sproctm_doctype  C_DOCTYPE_ID" +
      "            ,cp.em_sproctm_documentno AS DOCUMENTNO " +
      "            ,POSTED,0 AS VALUE" +
      "            from C_Project cp" +
      "            join C_ProjectPhase cpp on cpp.c_project_id = cp.c_project_id" +
      "            join C_ProjectTask cpt on cpt.C_ProjectPhase_id = cpp.C_ProjectPhase_id" +
      "            join sproctm_task_workforce stw on stw.C_ProjectTask_id = cpt.C_ProjectTask_id" +
      "            join sproctm_detail_cost spdt on spdt.record_id= stw.sproctm_task_workforce_id" +
      "            where spdt.sproctm_detail_cost_id = ?  " +
      "            union all" +
      "            select" +
      "            spdt.AD_CLIENT_ID, spdt.AD_ORG_ID" +
      "            ,DATE AS DATEDOC, '100' AS C_CURRENCY_ID" +
      "            ,cp.em_sproctm_doctype  C_DOCTYPE_ID" +
      "            ,cp.em_sproctm_documentno AS DOCUMENTNO " +
      "            ,POSTED,0 AS VALUE" +
      "            from C_Project cp" +
      "            join C_ProjectPhase cpp on cpp.c_project_id = cp.c_project_id" +
      "            join C_ProjectTask cpt on cpt.C_ProjectPhase_id = cpp.C_ProjectPhase_id" +
      "            join sproctm_task_cif stw on stw.C_ProjectTask_id = cpt.C_ProjectTask_id" +
      "            join sproctm_detail_cost spdt on spdt.record_id= stw.sproctm_task_cif_id" +
      "            where spdt.sproctm_detail_cost_id = ?  " +
      "            union all" +
      "            select" +
      "            spdt.AD_CLIENT_ID, spdt.AD_ORG_ID" +
      "            ,DATE AS DATEDOC, '100' AS C_CURRENCY_ID" +
      "            ,cp.em_sproctm_doctype  C_DOCTYPE_ID" +
      "            ,cp.em_sproctm_documentno AS DOCUMENTNO " +
      "            ,POSTED,0 AS VALUE" +
      "            from C_Project cp" +
      "            join C_ProjectPhase cpp on cpp.c_project_id = cp.c_project_id" +
      "            join C_ProjectTask cpt on cpt.C_ProjectPhase_id = cpp.C_ProjectPhase_id" +
      "            join sproctm_task_machine stw on stw.C_ProjectTask_id = cpt.C_ProjectTask_id" +
      "            join sproctm_detail_cost spdt on spdt.record_id= stw.sproctm_task_machine_id" +
      "            where spdt.sproctm_detail_cost_id = ? ";

    ResultSet result;
    Vector<AccountingDetailsProjectData> vector = new Vector<AccountingDetailsProjectData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);
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
        AccountingDetailsProjectData objectAccountingDetailsProjectData = new AccountingDetailsProjectData();
        objectAccountingDetailsProjectData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectAccountingDetailsProjectData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectAccountingDetailsProjectData.datedoc = UtilSql.getDateValue(result, "datedoc", "dd-MM-yyyy");
        objectAccountingDetailsProjectData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectAccountingDetailsProjectData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectAccountingDetailsProjectData.documentno = UtilSql.getValue(result, "documentno");
        objectAccountingDetailsProjectData.posted = UtilSql.getValue(result, "posted");
        objectAccountingDetailsProjectData.value = UtilSql.getValue(result, "value");
        objectAccountingDetailsProjectData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectAccountingDetailsProjectData);
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
    AccountingDetailsProjectData objectAccountingDetailsProjectData[] = new AccountingDetailsProjectData[vector.size()];
    vector.copyInto(objectAccountingDetailsProjectData);
    return(objectAccountingDetailsProjectData);
  }
}
