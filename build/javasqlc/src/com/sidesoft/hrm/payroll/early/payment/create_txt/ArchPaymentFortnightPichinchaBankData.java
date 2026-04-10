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

public class ArchPaymentFortnightPichinchaBankData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchPaymentFortnightPichinchaBankData.class);
  private String InitRecordNumber="0";
  public String pa;
  public String contrapartida;
  public String moneda;
  public String valor;
  public String formacobro;
  public String tipocuenta;
  public String cuenta;
  public String referencia;
  public String tipoidcliente;
  public String numidcliente;
  public String tercero;
  public String code;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pa"))
      return pa;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("formacobro"))
      return formacobro;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("cuenta"))
      return cuenta;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("tipoidcliente"))
      return tipoidcliente;
    else if (fieldName.equalsIgnoreCase("numidcliente"))
      return numidcliente;
    else if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("code"))
      return code;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchPaymentFortnightPichinchaBankData[] select(ConnectionProvider connectionProvider, String documentno, String bankid, String categoryid)    throws ServletException {
    return select(connectionProvider, documentno, bankid, categoryid, 0, 0);
  }

  public static ArchPaymentFortnightPichinchaBankData[] select(ConnectionProvider connectionProvider, String documentno, String bankid, String categoryid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT " +
      "    bt.paymentmethod as PA," +
      "    bp.em_sspr_documentno AS CONTRAPARTIDA," +
      "    C.ISO_CODE AS MONEDA," +
      "    round(papl.amount,2) AS VALOR," +
      "    'CTA' AS FORMACOBRO," +
      "    CASE WHEN bpba.bankaccounttype = 'S' THEN 'AHO' " +
      "    	 WHEN bpba.bankaccounttype = 'C' THEN 'CTE' " +
      "    END AS TIPOCUENTA," +
      "    bpba.AccountNo AS CUENTA," +
      "    pap.observation AS REFERENCIA," +
      "    CASE    WHEN bp.em_sspr_documenttype = 'NI' THEN 'C' " +
      "            WHEN bp.em_sspr_documenttype = 'SRT' THEN 'R' " +
      "            WHEN bp.em_sspr_documenttype = 'P' THEN 'P' " +
      "            ELSE 'ND' END AS TIPOIDCLIENTE,    " +
      "    bp.EM_SSPR_DocumentNo AS NUMIDCLIENTE," +
      "    bp.name AS TERCERO," +
      "    bt.CODE     " +
      "	FROM spep_advance_paymentline papl" +
      "	LEFT JOIN AD_ORG B ON papl.AD_ORG_ID = B.AD_ORG_ID     " +
      "	LEFT JOIN C_CURRENCY C ON B.C_CURRENCY_ID = C.C_CURRENCY_ID     " +
      "	JOIN spep_advance_payment pap on pap.spep_advance_payment_id = papl.spep_advance_payment_id" +
      "	JOIN c_bpartner bp on papl.c_bpartner_id = bp.c_bpartner_id" +
      "	LEFT JOIN c_bp_bankaccount bpba on bpba.c_bpartner_id = bp.c_bpartner_id and bpba.em_sspr_ispayroll = 'Y'" +
      "	LEFT JOIN ssfi_banktransfer bt on bpba.em_ssfi_banktransfer_id = bt.ssfi_banktransfer_id" +
      "	WHERE pap.documentno = ?" +
      "	AND bp.EM_SSPR_Typeofincome = 'D'" +
      "    AND bt.ssfi_banktransfer_id = ?" +
      "    AND (bp.em_sspr_category_acct_id = ? OR ? IS NULL)" +
      "    ORDER BY bp.NAME";

    ResultSet result;
    Vector<ArchPaymentFortnightPichinchaBankData> vector = new Vector<ArchPaymentFortnightPichinchaBankData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bankid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, categoryid);

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
        ArchPaymentFortnightPichinchaBankData objectArchPaymentFortnightPichinchaBankData = new ArchPaymentFortnightPichinchaBankData();
        objectArchPaymentFortnightPichinchaBankData.pa = UtilSql.getValue(result, "pa");
        objectArchPaymentFortnightPichinchaBankData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectArchPaymentFortnightPichinchaBankData.moneda = UtilSql.getValue(result, "moneda");
        objectArchPaymentFortnightPichinchaBankData.valor = UtilSql.getValue(result, "valor");
        objectArchPaymentFortnightPichinchaBankData.formacobro = UtilSql.getValue(result, "formacobro");
        objectArchPaymentFortnightPichinchaBankData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectArchPaymentFortnightPichinchaBankData.cuenta = UtilSql.getValue(result, "cuenta");
        objectArchPaymentFortnightPichinchaBankData.referencia = UtilSql.getValue(result, "referencia");
        objectArchPaymentFortnightPichinchaBankData.tipoidcliente = UtilSql.getValue(result, "tipoidcliente");
        objectArchPaymentFortnightPichinchaBankData.numidcliente = UtilSql.getValue(result, "numidcliente");
        objectArchPaymentFortnightPichinchaBankData.tercero = UtilSql.getValue(result, "tercero");
        objectArchPaymentFortnightPichinchaBankData.code = UtilSql.getValue(result, "code");
        objectArchPaymentFortnightPichinchaBankData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchPaymentFortnightPichinchaBankData);
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
    ArchPaymentFortnightPichinchaBankData objectArchPaymentFortnightPichinchaBankData[] = new ArchPaymentFortnightPichinchaBankData[vector.size()];
    vector.copyInto(objectArchPaymentFortnightPichinchaBankData);
    return(objectArchPaymentFortnightPichinchaBankData);
  }
}
