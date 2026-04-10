//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.early.payment.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchPayrAdvPayRuminahuiBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPayrAdvPayRuminahuiBankData.class);
  private String InitRecordNumber="0";
  public String servicecode;
  public String ci;
  public String currency;
  public String amount;
  public String bankaccount;
  public String bankacctype;
  public String accountno;
  public String observation;
  public String typeid;
  public String name;
  public String code;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("servicecode"))
      return servicecode;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("currency"))
      return currency;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("bankaccount"))
      return bankaccount;
    else if (fieldName.equalsIgnoreCase("bankacctype"))
      return bankacctype;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("observation"))
      return observation;
    else if (fieldName.equalsIgnoreCase("typeid"))
      return typeid;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("code"))
      return code;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchPayrAdvPayRuminahuiBankData[] select(ConnectionProvider connectionProvider, String documentno, String typeofincome)    throws ServletException {
    return select(connectionProvider, documentno, typeofincome, 0, 0);
  }

  public static ArchPayrAdvPayRuminahuiBankData[] select(ConnectionProvider connectionProvider, String documentno, String typeofincome, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select  'PA' as servicecode," +
      "                bp.em_sspr_documentno as ci," +
      "                'USD' as currency," +
      "                round(papl.amount,2) as amount," +
      "                'CTA' as bankaccount," +
      "                case bpba.bankaccounttype when 'S' then 'AHO' when 'C' then 'CTE' else '' end as bankacctype," +
      "                bpba.accountno," +
      "                pap.observation," +
      "                case bp.em_sspr_documenttype when 'NI' then 'C' when 'SRT' then 'R' else '' end as typeid," +
      "                bp.name," +
      "                bt.code" +
      "        from spep_advance_paymentline papl" +
      "        join spep_advance_payment pap on pap.spep_advance_payment_id = papl.spep_advance_payment_id" +
      "        join c_bpartner bp on papl.c_bpartner_id = bp.c_bpartner_id" +
      "        left join c_bp_bankaccount bpba on bpba.c_bpartner_id = bp.c_bpartner_id and bpba.em_sspr_ispayroll = 'Y'" +
      "        left join ssfi_banktransfer bt on bpba.em_ssfi_banktransfer_id = bt.ssfi_banktransfer_id" +
      "        where pap.documentno = ?" +
      "          and (? is null or papl.typeofincome = ?)";

    ResultSet result;
    Vector<ArchPayrAdvPayRuminahuiBankData> vector = new Vector<ArchPayrAdvPayRuminahuiBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofincome);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, typeofincome);

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
        ArchPayrAdvPayRuminahuiBankData objectArchPayrAdvPayRuminahuiBankData = new ArchPayrAdvPayRuminahuiBankData();
        objectArchPayrAdvPayRuminahuiBankData.servicecode = UtilSql.getValue(result, "servicecode");
        objectArchPayrAdvPayRuminahuiBankData.ci = UtilSql.getValue(result, "ci");
        objectArchPayrAdvPayRuminahuiBankData.currency = UtilSql.getValue(result, "currency");
        objectArchPayrAdvPayRuminahuiBankData.amount = UtilSql.getValue(result, "amount");
        objectArchPayrAdvPayRuminahuiBankData.bankaccount = UtilSql.getValue(result, "bankaccount");
        objectArchPayrAdvPayRuminahuiBankData.bankacctype = UtilSql.getValue(result, "bankacctype");
        objectArchPayrAdvPayRuminahuiBankData.accountno = UtilSql.getValue(result, "accountno");
        objectArchPayrAdvPayRuminahuiBankData.observation = UtilSql.getValue(result, "observation");
        objectArchPayrAdvPayRuminahuiBankData.typeid = UtilSql.getValue(result, "typeid");
        objectArchPayrAdvPayRuminahuiBankData.name = UtilSql.getValue(result, "name");
        objectArchPayrAdvPayRuminahuiBankData.code = UtilSql.getValue(result, "code");
        objectArchPayrAdvPayRuminahuiBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPayrAdvPayRuminahuiBankData);
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
    ArchPayrAdvPayRuminahuiBankData objectArchPayrAdvPayRuminahuiBankData[] = new ArchPayrAdvPayRuminahuiBankData[vector.size()];
    vector.copyInto(objectArchPayrAdvPayRuminahuiBankData);
    return(objectArchPayrAdvPayRuminahuiBankData);
  }
}
