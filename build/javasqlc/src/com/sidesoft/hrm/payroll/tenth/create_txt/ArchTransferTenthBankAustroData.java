//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.tenth.create_txt;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ArchTransferTenthBankAustroData implements FieldProvider {
static Logger log4j = Logger.getLogger(ArchTransferTenthBankAustroData.class);
  private String InitRecordNumber="0";
  public String entidad;
  public String empleado;
  public String cedula;
  public String cuenta;
  public String valor;
  public String codigo;
  public String formapago;
  public String tipocuenta;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("entidad"))
      return entidad;
    else if (fieldName.equalsIgnoreCase("empleado"))
      return empleado;
    else if (fieldName.equalsIgnoreCase("cedula"))
      return cedula;
    else if (fieldName.equalsIgnoreCase("cuenta"))
      return cuenta;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("codigo"))
      return codigo;
    else if (fieldName.equalsIgnoreCase("formapago"))
      return formapago;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ArchTransferTenthBankAustroData[] select(ConnectionProvider connectionProvider, String documentno, String ssfiBanktransferId)    throws ServletException {
    return select(connectionProvider, documentno, ssfiBanktransferId, 0, 0);
  }

  public static ArchTransferTenthBankAustroData[] select(ConnectionProvider connectionProvider, String documentno, String ssfiBanktransferId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT " +
      "      (SELECT cp.name from AD_ORG AO " +
      "      LEFT JOIN AD_ORGTYPE AOT ON AO.AD_ORGTYPE_id = AOT.AD_ORGTYPE_id  " +
      "      LEFT JOIN AD_ORGINFO AR ON AO.AD_ORG_ID = AR.AD_ORG_ID  " +
      "      LEFT JOIN C_BPARTNER CP ON AR.C_BPARTNER_ID = CP.C_BPARTNER_ID" +
      "      WHERE AOT.islegalentity='Y' AND AOT.isacctlegalentity='Y') as entidad,	  " +
      "	  cb.name as empleado, cb.EM_SSPR_DocumentNo as cedula," +
      "      cbk.AccountNo as cuenta,tsl.Adjustedamt as valor," +
      "      sb.code as codigo, sb.Paymentmethod as formapago," +
      "      CASE WHEN UPPER(cbk.BankAccountType) ='C' THEN 'C'  " +
      "      WHEN UPPER(cbk.BankAccountType) ='S' THEN 'A' END AS tipocuenta" +
      "      FROM SSPH_Tenth_Settlement ts  " +
      "      LEFT JOIN SSPH_Tenth_Settlement_Line tsl ON tsl.SSPH_Tenth_Settlement_id = ts.SSPH_Tenth_Settlement_id" +
      "      LEFT JOIN C_BPARTNER CB ON CB.C_BPARTNER_id = tsl.C_BPARTNER_id" +
      "      LEFT JOIN C_BP_BankAccount CBK ON CB.C_BPARTNER_id = CBK.C_BPARTNER_id" +
      "      LEFT JOIN ssfi_banktransfer sb ON sb.ssfi_banktransfer_id = cbk.em_ssfi_banktransfer_id" +
      "      WHERE CB.isemployee ='Y' AND CB.EM_SSPR_TYPEOFINCOME ='D'  AND ts.documentno=? AND cbk.em_ssfi_banktransfer_id=?" +
      "      ORDER BY cb.name  ";

    ResultSet result;
    Vector<ArchTransferTenthBankAustroData> vector = new Vector<ArchTransferTenthBankAustroData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssfiBanktransferId);

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
        ArchTransferTenthBankAustroData objectArchTransferTenthBankAustroData = new ArchTransferTenthBankAustroData();
        objectArchTransferTenthBankAustroData.entidad = UtilSql.getValue(result, "entidad");
        objectArchTransferTenthBankAustroData.empleado = UtilSql.getValue(result, "empleado");
        objectArchTransferTenthBankAustroData.cedula = UtilSql.getValue(result, "cedula");
        objectArchTransferTenthBankAustroData.cuenta = UtilSql.getValue(result, "cuenta");
        objectArchTransferTenthBankAustroData.valor = UtilSql.getValue(result, "valor");
        objectArchTransferTenthBankAustroData.codigo = UtilSql.getValue(result, "codigo");
        objectArchTransferTenthBankAustroData.formapago = UtilSql.getValue(result, "formapago");
        objectArchTransferTenthBankAustroData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectArchTransferTenthBankAustroData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectArchTransferTenthBankAustroData);
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
    ArchTransferTenthBankAustroData objectArchTransferTenthBankAustroData[] = new ArchTransferTenthBankAustroData[vector.size()];
    vector.copyInto(objectArchTransferTenthBankAustroData);
    return(objectArchTransferTenthBankAustroData);
  }
}
