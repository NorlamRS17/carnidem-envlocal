//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.early.payment.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchivePaymentFortnightTXTData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchivePaymentFortnightTXTData.class);
  private String InitRecordNumber="0";
  public String codigoorientacion;
  public String cuentaempresa;
  public String secuencialpago;
  public String comprobantepago;
  public String contrapartida;
  public String moneda;
  public String valor;
  public String formapago;
  public String codigoinstfin;
  public String tipocuenta;
  public String numerocuenta;
  public String tipoidbeneficiario;
  public String idbeneficiario;
  public String nombrebenef;
  public String direccionbenef;
  public String ciudadbenef;
  public String telefonobenef;
  public String localidadpago;
  public String referencia;
  public String refadicional;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("codigoorientacion"))
      return codigoorientacion;
    else if (fieldName.equalsIgnoreCase("cuentaempresa"))
      return cuentaempresa;
    else if (fieldName.equalsIgnoreCase("secuencialpago"))
      return secuencialpago;
    else if (fieldName.equalsIgnoreCase("comprobantepago"))
      return comprobantepago;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("formapago"))
      return formapago;
    else if (fieldName.equalsIgnoreCase("codigoinstfin"))
      return codigoinstfin;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("numerocuenta"))
      return numerocuenta;
    else if (fieldName.equalsIgnoreCase("tipoidbeneficiario"))
      return tipoidbeneficiario;
    else if (fieldName.equalsIgnoreCase("idbeneficiario"))
      return idbeneficiario;
    else if (fieldName.equalsIgnoreCase("nombrebenef"))
      return nombrebenef;
    else if (fieldName.equalsIgnoreCase("direccionbenef"))
      return direccionbenef;
    else if (fieldName.equalsIgnoreCase("ciudadbenef"))
      return ciudadbenef;
    else if (fieldName.equalsIgnoreCase("telefonobenef"))
      return telefonobenef;
    else if (fieldName.equalsIgnoreCase("localidadpago"))
      return localidadpago;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("refadicional"))
      return refadicional;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchivePaymentFortnightTXTData[] select(ConnectionProvider connectionProvider, String documentno)    throws ServletException {
    return select(connectionProvider, documentno, 0, 0);
  }

  public static ArchivePaymentFortnightTXTData[] select(ConnectionProvider connectionProvider, String documentno, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT TO_CHAR('PA') AS CODIGOORIENTACION,LPAD(BA.ACCOUNTNO,11,'0') AS CUENTAEMPRESA ," +
      "TO_NUMBER(ROW_NUMBER() OVER (ORDER BY PY.created NULLS LAST )) " +
      " AS SECUENCIALPAGO ,TO_CHAR(' ') AS COMPROBANTEPAGO, CA.ACCOUNTNO AS CONTRAPARTIDA, UPPER(CC.ISO_CODE) AS MONEDA " +
      " , ROUND(PT.amount,2) AS VALOR, TO_CHAR('CTA') AS FORMAPAGO, " +
      " BT.CODE AS CODIGOINSTFIN,CASE WHEN UPPER(TRIM(CA.BankAccountType))= 'S' THEN TO_CHAR('AHO') ELSE TO_CHAR('CTE') END AS TIPOCUENTA, " +
      "   LPAD(CA.ACCOUNTNO,11,'0') AS NUMEROCUENTA," +
      " CASE WHEN UPPER(TRIM(CB.EM_SSPR_Documenttype)) ='NI' THEN TO_CHAR('C')  " +
      " WHEN UPPER(TRIM(CB.EM_SSPR_Documenttype)) ='SRT' THEN TO_CHAR('R')  " +
      " WHEN UPPER(TRIM(CB.EM_SSPR_Documenttype)) = 'P'THEN TO_CHAR('P') END AS TIPOIDBENEFICIARIO," +
      " CB.TAXID AS IDBENEFICIARIO, TO_CHAR(UPPER(CB.NAME)) AS NOMBREBENEF, TO_CHAR(' ')  AS DIRECCIONBENEF ,TO_CHAR(' ')  AS CIUDADBENEF , TO_CHAR(' ')  AS TELEFONOBENEF, " +
      " TO_CHAR(' ') AS LOCALIDADPAGO, UPPER(PY.OBSERVATION) AS REFERENCIA" +
      " , TO_CHAR(' ') AS REFADICIONAL " +
      " FROM spep_advance_payment PY  " +
      "LEFT JOIN spep_advance_paymentline PT ON PY.spep_advance_payment_id = PT.spep_advance_payment_id " +
      "LEFT JOIN C_BPARTNER CB ON PT.C_BPARTNER_id = CB.C_BPARTNER_id    " +
      "LEFT JOIN AD_ORG AO ON PY.AD_ORG_ID = AO.AD_ORG_ID  " +
      "LEFT JOIN AD_ORGINFO AR ON AO.AD_ORG_ID = AR.AD_ORG_ID  " +
      "LEFT JOIN C_BPARTNER CP ON AR.C_BPARTNER_ID = CP.C_BPARTNER_ID  " +
      "LEFT JOIN C_BP_BANKACCOUNT BA ON CP.C_BPARTNER_ID = BA.C_BPARTNER_ID  " +
      "LEFT JOIN C_BP_BANKACCOUNT CA ON CB.C_BPARTNER_ID = CA.C_BPARTNER_ID  " +
      "LEFT JOIN ssfi_banktransfer BT ON CA.em_ssfi_banktransfer_id = BT.ssfi_banktransfer_id   " +
      "LEFT JOIN AD_CLIENT AC ON PY.AD_CLIENT_ID = AC.AD_CLIENT_ID   " +
      "LEFT JOIN C_CURRENCY CC ON AC.C_CURRENCY_ID = CC.C_CURRENCY_ID   " +
      "WHERE CB.isemployee ='Y' " +
      "AND PY.DOCUMENTNO = ?" +
      "AND CB.EM_SSPR_TYPEOFINCOME = 'D'   ";

    ResultSet result;
    Vector<ArchivePaymentFortnightTXTData> vector = new Vector<ArchivePaymentFortnightTXTData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);

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
        ArchivePaymentFortnightTXTData objectArchivePaymentFortnightTXTData = new ArchivePaymentFortnightTXTData();
        objectArchivePaymentFortnightTXTData.codigoorientacion = UtilSql.getValue(result, "codigoorientacion");
        objectArchivePaymentFortnightTXTData.cuentaempresa = UtilSql.getValue(result, "cuentaempresa");
        objectArchivePaymentFortnightTXTData.secuencialpago = UtilSql.getValue(result, "secuencialpago");
        objectArchivePaymentFortnightTXTData.comprobantepago = UtilSql.getValue(result, "comprobantepago");
        objectArchivePaymentFortnightTXTData.contrapartida = UtilSql.getValue(result, "contrapartida");
        objectArchivePaymentFortnightTXTData.moneda = UtilSql.getValue(result, "moneda");
        objectArchivePaymentFortnightTXTData.valor = UtilSql.getValue(result, "valor");
        objectArchivePaymentFortnightTXTData.formapago = UtilSql.getValue(result, "formapago");
        objectArchivePaymentFortnightTXTData.codigoinstfin = UtilSql.getValue(result, "codigoinstfin");
        objectArchivePaymentFortnightTXTData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectArchivePaymentFortnightTXTData.numerocuenta = UtilSql.getValue(result, "numerocuenta");
        objectArchivePaymentFortnightTXTData.tipoidbeneficiario = UtilSql.getValue(result, "tipoidbeneficiario");
        objectArchivePaymentFortnightTXTData.idbeneficiario = UtilSql.getValue(result, "idbeneficiario");
        objectArchivePaymentFortnightTXTData.nombrebenef = UtilSql.getValue(result, "nombrebenef");
        objectArchivePaymentFortnightTXTData.direccionbenef = UtilSql.getValue(result, "direccionbenef");
        objectArchivePaymentFortnightTXTData.ciudadbenef = UtilSql.getValue(result, "ciudadbenef");
        objectArchivePaymentFortnightTXTData.telefonobenef = UtilSql.getValue(result, "telefonobenef");
        objectArchivePaymentFortnightTXTData.localidadpago = UtilSql.getValue(result, "localidadpago");
        objectArchivePaymentFortnightTXTData.referencia = UtilSql.getValue(result, "referencia");
        objectArchivePaymentFortnightTXTData.refadicional = UtilSql.getValue(result, "refadicional");
        objectArchivePaymentFortnightTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchivePaymentFortnightTXTData);
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
    ArchivePaymentFortnightTXTData objectArchivePaymentFortnightTXTData[] = new ArchivePaymentFortnightTXTData[vector.size()];
    vector.copyInto(objectArchivePaymentFortnightTXTData);
    return(objectArchivePaymentFortnightTXTData);
  }
}
