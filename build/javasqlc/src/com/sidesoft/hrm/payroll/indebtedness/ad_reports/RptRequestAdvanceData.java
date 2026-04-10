//Sqlc generated V1.O00-1
package com.sidesoft.hrm.payroll.indebtedness.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptRequestAdvanceData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestAdvanceData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String nombreempleado;
  public String fechasolicitud;
  public String tipodocumento;
  public String nodocumento;
  public String primerpago;
  public String montototal;
  public String ci;
  public String numerocuotas;
  public String nombrebanco;
  public String nocuenta;
  public String tipocuenta;
  public String descripcion;
  public String gerencia;
  public String direccion;
  public String telefono;
  public String fechaingreso;
  public String ultimosueldo;
  public String numerolinea;
  public String diapago;
  public String valorletra;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("nombreempleado"))
      return nombreempleado;
    else if (fieldName.equalsIgnoreCase("fechasolicitud"))
      return fechasolicitud;
    else if (fieldName.equalsIgnoreCase("tipodocumento"))
      return tipodocumento;
    else if (fieldName.equalsIgnoreCase("nodocumento"))
      return nodocumento;
    else if (fieldName.equalsIgnoreCase("primerpago"))
      return primerpago;
    else if (fieldName.equalsIgnoreCase("montototal"))
      return montototal;
    else if (fieldName.equalsIgnoreCase("ci"))
      return ci;
    else if (fieldName.equalsIgnoreCase("numerocuotas"))
      return numerocuotas;
    else if (fieldName.equalsIgnoreCase("nombrebanco"))
      return nombrebanco;
    else if (fieldName.equalsIgnoreCase("nocuenta"))
      return nocuenta;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("descripcion"))
      return descripcion;
    else if (fieldName.equalsIgnoreCase("gerencia"))
      return gerencia;
    else if (fieldName.equalsIgnoreCase("direccion"))
      return direccion;
    else if (fieldName.equalsIgnoreCase("telefono"))
      return telefono;
    else if (fieldName.equalsIgnoreCase("fechaingreso"))
      return fechaingreso;
    else if (fieldName.equalsIgnoreCase("ultimosueldo"))
      return ultimosueldo;
    else if (fieldName.equalsIgnoreCase("numerolinea"))
      return numerolinea;
    else if (fieldName.equalsIgnoreCase("diapago"))
      return diapago;
    else if (fieldName.equalsIgnoreCase("valorletra"))
      return valorletra;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestAdvanceData[] select(ConnectionProvider connectionProvider, String sspr_loans_id)    throws ServletException {
    return select(connectionProvider, sspr_loans_id, 0, 0);
  }

  public static RptRequestAdvanceData[] select(ConnectionProvider connectionProvider, String sspr_loans_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	     select sspr_loans.ad_org_id as organizationid," +
      "       c_bpartner.name as nombreempleado," +
      "       to_char(sspr_loans.requestdate) as fechasolicitud," +
      "       c_doctype.name as tipodocumento," +
      "       sspr_loans.em_sfpr_documentno as nodocumento," +
      "       to_char(sspr_loans.firstdate) as primerpago," +
      "	sspr_loans.amount as montototal," +
      "	c_bpartner.taxid as ci," +
      "	sspr_loans.time as numerocuotas," +
      "	ssfi_banktransfer.name as nombrebanco," +
      "	C_BP_BankAccount.accountno as nocuenta," +
      "	case when C_BP_BankAccount.bankaccounttype = 'S' then 'Ahorros'" +
      "	   when C_BP_BankAccount.bankaccounttype = 'C' then 'Corriente'" +
      "	end as tipocuenta," +
      "	sspr_loans.description as descripcion," +
      "	c_bpartner.name as gerencia," +
      "	C_BPartner_Location.name as direccion," +
      "	C_BPartner_Location.phone as telefono," +
      "	to_char(c_bpartner.em_sspr_entrydate) as fechaingreso," +
      "	c_bpartner.em_sspr_currentsalary as ultimosueldo," +
      "	sspr_line_loans.line as numerolinea," +
      "	to_char(sspr_line_loans.paydate) as diapago," +
      "	sspr_line_loans.amount as valorletra" +
      "	from sspr_loans" +
      "	left join sspr_line_loans on sspr_line_loans.sspr_loans_id = sspr_loans.sspr_loans_id" +
      "	left join c_bpartner on c_bpartner.c_bpartner_id = sspr_loans.c_bpartner_id" +
      "	left join C_BPartner_Location on C_BPartner_Location.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "	left join c_doctype on c_doctype.c_doctype_id = sspr_loans.em_sfpr_c_doctype_id" +
      "	left join c_bp_bankaccount on c_bp_bankaccount.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "	left join ssfi_banktransfer on ssfi_banktransfer.ssfi_banktransfer_id = c_bp_bankaccount.em_ssfi_banktransfer_id" +
      "	left join c_costcenter on c_costcenter.c_costcenter_id = c_bpartner.em_sspr_costcenter_id" +
      "	where sspr_loans.sspr_loans_id = ? " +
      "	and sspr_loans.status = 'ap'";

    ResultSet result;
    Vector<RptRequestAdvanceData> vector = new Vector<RptRequestAdvanceData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sspr_loans_id);

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
        RptRequestAdvanceData objectRptRequestAdvanceData = new RptRequestAdvanceData();
        objectRptRequestAdvanceData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptRequestAdvanceData.nombreempleado = UtilSql.getValue(result, "nombreempleado");
        objectRptRequestAdvanceData.fechasolicitud = UtilSql.getValue(result, "fechasolicitud");
        objectRptRequestAdvanceData.tipodocumento = UtilSql.getValue(result, "tipodocumento");
        objectRptRequestAdvanceData.nodocumento = UtilSql.getValue(result, "nodocumento");
        objectRptRequestAdvanceData.primerpago = UtilSql.getValue(result, "primerpago");
        objectRptRequestAdvanceData.montototal = UtilSql.getValue(result, "montototal");
        objectRptRequestAdvanceData.ci = UtilSql.getValue(result, "ci");
        objectRptRequestAdvanceData.numerocuotas = UtilSql.getValue(result, "numerocuotas");
        objectRptRequestAdvanceData.nombrebanco = UtilSql.getValue(result, "nombrebanco");
        objectRptRequestAdvanceData.nocuenta = UtilSql.getValue(result, "nocuenta");
        objectRptRequestAdvanceData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectRptRequestAdvanceData.descripcion = UtilSql.getValue(result, "descripcion");
        objectRptRequestAdvanceData.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptRequestAdvanceData.direccion = UtilSql.getValue(result, "direccion");
        objectRptRequestAdvanceData.telefono = UtilSql.getValue(result, "telefono");
        objectRptRequestAdvanceData.fechaingreso = UtilSql.getValue(result, "fechaingreso");
        objectRptRequestAdvanceData.ultimosueldo = UtilSql.getValue(result, "ultimosueldo");
        objectRptRequestAdvanceData.numerolinea = UtilSql.getValue(result, "numerolinea");
        objectRptRequestAdvanceData.diapago = UtilSql.getValue(result, "diapago");
        objectRptRequestAdvanceData.valorletra = UtilSql.getValue(result, "valorletra");
        objectRptRequestAdvanceData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestAdvanceData);
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
    RptRequestAdvanceData objectRptRequestAdvanceData[] = new RptRequestAdvanceData[vector.size()];
    vector.copyInto(objectRptRequestAdvanceData);
    return(objectRptRequestAdvanceData);
  }

  public static RptRequestAdvanceData[] set()    throws ServletException {
    RptRequestAdvanceData objectRptRequestAdvanceData[] = new RptRequestAdvanceData[1];
    objectRptRequestAdvanceData[0] = new RptRequestAdvanceData();
    objectRptRequestAdvanceData[0].organizationid = "";
    objectRptRequestAdvanceData[0].nombreempleado = "";
    objectRptRequestAdvanceData[0].fechasolicitud = "";
    objectRptRequestAdvanceData[0].tipodocumento = "";
    objectRptRequestAdvanceData[0].nodocumento = "";
    objectRptRequestAdvanceData[0].primerpago = "";
    objectRptRequestAdvanceData[0].montototal = "";
    objectRptRequestAdvanceData[0].ci = "";
    objectRptRequestAdvanceData[0].numerocuotas = "";
    objectRptRequestAdvanceData[0].nombrebanco = "";
    objectRptRequestAdvanceData[0].nocuenta = "";
    objectRptRequestAdvanceData[0].tipocuenta = "";
    objectRptRequestAdvanceData[0].descripcion = "";
    objectRptRequestAdvanceData[0].gerencia = "";
    objectRptRequestAdvanceData[0].direccion = "";
    objectRptRequestAdvanceData[0].telefono = "";
    objectRptRequestAdvanceData[0].fechaingreso = "";
    objectRptRequestAdvanceData[0].ultimosueldo = "";
    objectRptRequestAdvanceData[0].numerolinea = "";
    objectRptRequestAdvanceData[0].diapago = "";
    objectRptRequestAdvanceData[0].valorletra = "";
    return objectRptRequestAdvanceData;
  }
}
