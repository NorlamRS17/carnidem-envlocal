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

public class RptRequestLoanAdvancedData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptRequestLoanAdvancedData.class);
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
  public String area;
  public String centrodecosto;
  public String fechaimpresion;
  public String username;

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
    else if (fieldName.equalsIgnoreCase("area"))
      return area;
    else if (fieldName.equalsIgnoreCase("centrodecosto"))
      return centrodecosto;
    else if (fieldName.equalsIgnoreCase("fechaimpresion"))
      return fechaimpresion;
    else if (fieldName.equalsIgnoreCase("username"))
      return username;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptRequestLoanAdvancedData[] select(ConnectionProvider connectionProvider, String AD_USER_ID, String sspr_loans_id)    throws ServletException {
    return select(connectionProvider, AD_USER_ID, sspr_loans_id, 0, 0);
  }

  public static RptRequestLoanAdvancedData[] select(ConnectionProvider connectionProvider, String AD_USER_ID, String sspr_loans_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	    select sspr_loans.ad_org_id as organizationid," +
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
      "	sspr_line_loans.amount as valorletra," +
      "    ar.name as area," +
      "    cc.name as centrodecosto," +
      "    now() as fechaimpresion," +
      "    (select coalesce(cb.name,au.name) from ad_user au left join c_bpartner cb on cb.c_bpartner_id = au.c_bpartner_id where au.ad_user_id in (?) and au.ad_user_id <> '0') as username" +
      "	from sspr_loans" +
      "	left join sspr_line_loans on sspr_line_loans.sspr_loans_id = sspr_loans.sspr_loans_id" +
      "	left join c_bpartner on c_bpartner.c_bpartner_id = sspr_loans.c_bpartner_id" +
      "	left join C_BPartner_Location on C_BPartner_Location.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "	left join c_doctype on c_doctype.c_doctype_id = sspr_loans.em_sfpr_c_doctype_id" +
      "	left join c_bp_bankaccount on c_bp_bankaccount.c_bpartner_id = c_bpartner.c_bpartner_id" +
      "	left join ssfi_banktransfer on ssfi_banktransfer.ssfi_banktransfer_id = c_bp_bankaccount.em_ssfi_banktransfer_id" +
      "    left join c_costcenter on c_costcenter.c_costcenter_id = c_bpartner.em_sspr_costcenter_id" +
      "    left join Sprbi_Area ar on c_bpartner.em_Sprbi_Area_id = ar.Sprbi_Area_id" +
      "    left join c_costcenter cc on c_bpartner.EM_Sspr_Costcenter_ID = cc.c_costcenter_id" +
      "	where sspr_loans.sspr_loans_id = ? " +
      "	and (sspr_loans.status = 'ap' or sspr_loans.status = 'dr')";

    ResultSet result;
    Vector<RptRequestLoanAdvancedData> vector = new Vector<RptRequestLoanAdvancedData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, AD_USER_ID);
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
        RptRequestLoanAdvancedData objectRptRequestLoanAdvancedData = new RptRequestLoanAdvancedData();
        objectRptRequestLoanAdvancedData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptRequestLoanAdvancedData.nombreempleado = UtilSql.getValue(result, "nombreempleado");
        objectRptRequestLoanAdvancedData.fechasolicitud = UtilSql.getValue(result, "fechasolicitud");
        objectRptRequestLoanAdvancedData.tipodocumento = UtilSql.getValue(result, "tipodocumento");
        objectRptRequestLoanAdvancedData.nodocumento = UtilSql.getValue(result, "nodocumento");
        objectRptRequestLoanAdvancedData.primerpago = UtilSql.getValue(result, "primerpago");
        objectRptRequestLoanAdvancedData.montototal = UtilSql.getValue(result, "montototal");
        objectRptRequestLoanAdvancedData.ci = UtilSql.getValue(result, "ci");
        objectRptRequestLoanAdvancedData.numerocuotas = UtilSql.getValue(result, "numerocuotas");
        objectRptRequestLoanAdvancedData.nombrebanco = UtilSql.getValue(result, "nombrebanco");
        objectRptRequestLoanAdvancedData.nocuenta = UtilSql.getValue(result, "nocuenta");
        objectRptRequestLoanAdvancedData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectRptRequestLoanAdvancedData.descripcion = UtilSql.getValue(result, "descripcion");
        objectRptRequestLoanAdvancedData.gerencia = UtilSql.getValue(result, "gerencia");
        objectRptRequestLoanAdvancedData.direccion = UtilSql.getValue(result, "direccion");
        objectRptRequestLoanAdvancedData.telefono = UtilSql.getValue(result, "telefono");
        objectRptRequestLoanAdvancedData.fechaingreso = UtilSql.getValue(result, "fechaingreso");
        objectRptRequestLoanAdvancedData.ultimosueldo = UtilSql.getValue(result, "ultimosueldo");
        objectRptRequestLoanAdvancedData.numerolinea = UtilSql.getValue(result, "numerolinea");
        objectRptRequestLoanAdvancedData.diapago = UtilSql.getValue(result, "diapago");
        objectRptRequestLoanAdvancedData.valorletra = UtilSql.getValue(result, "valorletra");
        objectRptRequestLoanAdvancedData.area = UtilSql.getValue(result, "area");
        objectRptRequestLoanAdvancedData.centrodecosto = UtilSql.getValue(result, "centrodecosto");
        objectRptRequestLoanAdvancedData.fechaimpresion = UtilSql.getDateValue(result, "fechaimpresion", "dd-MM-yyyy");
        objectRptRequestLoanAdvancedData.username = UtilSql.getValue(result, "username");
        objectRptRequestLoanAdvancedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptRequestLoanAdvancedData);
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
    RptRequestLoanAdvancedData objectRptRequestLoanAdvancedData[] = new RptRequestLoanAdvancedData[vector.size()];
    vector.copyInto(objectRptRequestLoanAdvancedData);
    return(objectRptRequestLoanAdvancedData);
  }

  public static RptRequestLoanAdvancedData[] set()    throws ServletException {
    RptRequestLoanAdvancedData objectRptRequestLoanAdvancedData[] = new RptRequestLoanAdvancedData[1];
    objectRptRequestLoanAdvancedData[0] = new RptRequestLoanAdvancedData();
    objectRptRequestLoanAdvancedData[0].organizationid = "";
    objectRptRequestLoanAdvancedData[0].nombreempleado = "";
    objectRptRequestLoanAdvancedData[0].fechasolicitud = "";
    objectRptRequestLoanAdvancedData[0].tipodocumento = "";
    objectRptRequestLoanAdvancedData[0].nodocumento = "";
    objectRptRequestLoanAdvancedData[0].primerpago = "";
    objectRptRequestLoanAdvancedData[0].montototal = "";
    objectRptRequestLoanAdvancedData[0].ci = "";
    objectRptRequestLoanAdvancedData[0].numerocuotas = "";
    objectRptRequestLoanAdvancedData[0].nombrebanco = "";
    objectRptRequestLoanAdvancedData[0].nocuenta = "";
    objectRptRequestLoanAdvancedData[0].tipocuenta = "";
    objectRptRequestLoanAdvancedData[0].descripcion = "";
    objectRptRequestLoanAdvancedData[0].gerencia = "";
    objectRptRequestLoanAdvancedData[0].direccion = "";
    objectRptRequestLoanAdvancedData[0].telefono = "";
    objectRptRequestLoanAdvancedData[0].fechaingreso = "";
    objectRptRequestLoanAdvancedData[0].ultimosueldo = "";
    objectRptRequestLoanAdvancedData[0].numerolinea = "";
    objectRptRequestLoanAdvancedData[0].diapago = "";
    objectRptRequestLoanAdvancedData[0].valorletra = "";
    objectRptRequestLoanAdvancedData[0].area = "";
    objectRptRequestLoanAdvancedData[0].centrodecosto = "";
    objectRptRequestLoanAdvancedData[0].fechaimpresion = "";
    objectRptRequestLoanAdvancedData[0].username = "";
    return objectRptRequestLoanAdvancedData;
  }
}
