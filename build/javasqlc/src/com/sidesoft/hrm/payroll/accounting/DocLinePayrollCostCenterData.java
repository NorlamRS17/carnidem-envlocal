//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.accounting;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocLinePayrollCostCenterData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocLinePayrollCostCenterData.class);
  private String InitRecordNumber="0";
  public String ssprPayrollTicketConceptId;
  public String adOrgId;
  public String line;
  public String description;
  public String amount;
  public String cCurrencyId;
  public String cCostcenterId;
  public String user1Id;
  public String user2Id;
  public String ssprConceptId;
  public String ssprCategoryAcctId;
  public String cBpartnerId;
  public String percentage;
  public String catgAcct;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("sspr_payroll_ticket_concept_id") || fieldName.equals("ssprPayrollTicketConceptId"))
      return ssprPayrollTicketConceptId;
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
    else if (fieldName.equalsIgnoreCase("sspr_concept_id") || fieldName.equals("ssprConceptId"))
      return ssprConceptId;
    else if (fieldName.equalsIgnoreCase("sspr_category_acct_id") || fieldName.equals("ssprCategoryAcctId"))
      return ssprCategoryAcctId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("percentage"))
      return percentage;
    else if (fieldName.equalsIgnoreCase("catg_acct") || fieldName.equals("catgAcct"))
      return catgAcct;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocLinePayrollCostCenterData[] selected(ConnectionProvider connectionProvider, String payroll, String bpartner, String concept)    throws ServletException {
    return selected(connectionProvider, payroll, bpartner, concept, 0, 0);
  }

  public static DocLinePayrollCostCenterData[] selected(ConnectionProvider connectionProvider, String payroll, String bpartner, String concept, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT PRTC.SSPR_PAYROLL_TICKET_CONCEPT_ID, PRT.AD_ORG_ID, 10 AS LINE, PR.DESCRIPTION, " +
      "            (case when coalesce(dstcostcenter.percentage,0) =0 then Round(PRTC.AMOUNT,3)" +
      "            else ((TRUNC(PRTC.AMOUNT,3)*coalesce(dstcostcenter.percentage,0))/100)  " +
      "            end) as amount, '100' AS C_CURRENCY_ID, " +
      "            case when coalesce(dstcostcenter.percentage,0) =0 then BP.EM_SSPR_COSTCENTER_ID     " +
      "            else dstcostcenter.c_costcenter_id end AS C_COSTCENTER_ID, BP.EM_SSPR_USER1_ID AS USER1_ID, BP.EM_SSPR_USER2_ID AS USER2_ID, " +
      "            PRTC.SSPR_CONCEPT_ID, BP.EM_SSPR_CATEGORY_ACCT_ID AS SSPR_CATEGORY_ACCT_ID, BP.C_BPARTNER_ID" +
      "            , coalesce(dstcostcenter.percentage,0) as percentage " +
      "            , coalesce(catg_acct,BP.EM_SSPR_CATEGORY_ACCT_ID)  as catg_acct    " +
      "            FROM SSPR_PAYROLL PR    " +
      "            LEFT JOIN SSPR_PAYROLL_TICKET PRT ON PR.SSPR_PAYROLL_ID = PRT.SSPR_PAYROLL_ID    " +
      "            LEFT JOIN SSPR_PAYROLL_TICKET_CONCEPT PRTC ON PRTC.SSPR_PAYROLL_TICKET_ID = PRT.SSPR_PAYROLL_TICKET_ID    " +
      "            LEFT JOIN C_BPARTNER BP ON PRT.C_BPARTNER_ID = BP.C_BPARTNER_ID     " +
      "            LEFT JOIN   " +
      "            (   select sp.c_period_id,spe.c_bpartner_id, spc.percentage, spc.c_costcenter_id       " +
      "                ,spc.em_sspr_category_acct_id as catg_acct       " +
      "                from sspd_pctdist sp     " +
      "                join sspd_pctdist_emp spe on spe.sspd_pctdist_id = sp.sspd_pctdist_id    " +
      "                join sspd_pctdist_costcenter  spc on spe.sspd_pctdist_emp_id = spc.sspd_pctdist_emp_id    " +
      "            ) dstcostcenter ON dstcostcenter.c_period_id =pr.c_period_id and dstcostcenter.c_bpartner_id =prt.c_bpartner_id     " +
      "            WHERE PR.SSPR_PAYROLL_ID= ?    " +
      "            AND PRTC.AMOUNT <> 0    " +
      "            AND PRT.C_BPARTNER_ID = ?    " +
      "            AND PRTC.SSPR_CONCEPT_ID = ?   " +
      "            AND coalesce(dstcostcenter.percentage,0) > 0    " +
      "            ORDER BY BP.C_BPARTNER_ID, PRTC.SSPR_CONCEPT_ID ";

    ResultSet result;
    Vector<DocLinePayrollCostCenterData> vector = new Vector<DocLinePayrollCostCenterData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, payroll);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, concept);

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
        DocLinePayrollCostCenterData objectDocLinePayrollCostCenterData = new DocLinePayrollCostCenterData();
        objectDocLinePayrollCostCenterData.ssprPayrollTicketConceptId = UtilSql.getValue(result, "sspr_payroll_ticket_concept_id");
        objectDocLinePayrollCostCenterData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocLinePayrollCostCenterData.line = UtilSql.getValue(result, "line");
        objectDocLinePayrollCostCenterData.description = UtilSql.getValue(result, "description");
        objectDocLinePayrollCostCenterData.amount = UtilSql.getValue(result, "amount");
        objectDocLinePayrollCostCenterData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectDocLinePayrollCostCenterData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocLinePayrollCostCenterData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocLinePayrollCostCenterData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocLinePayrollCostCenterData.ssprConceptId = UtilSql.getValue(result, "sspr_concept_id");
        objectDocLinePayrollCostCenterData.ssprCategoryAcctId = UtilSql.getValue(result, "sspr_category_acct_id");
        objectDocLinePayrollCostCenterData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocLinePayrollCostCenterData.percentage = UtilSql.getValue(result, "percentage");
        objectDocLinePayrollCostCenterData.catgAcct = UtilSql.getValue(result, "catg_acct");
        objectDocLinePayrollCostCenterData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocLinePayrollCostCenterData);
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
    DocLinePayrollCostCenterData objectDocLinePayrollCostCenterData[] = new DocLinePayrollCostCenterData[vector.size()];
    vector.copyInto(objectDocLinePayrollCostCenterData);
    return(objectDocLinePayrollCostCenterData);
  }
}
