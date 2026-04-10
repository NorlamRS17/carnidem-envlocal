//Sqlc generated V1.O00-1
package ec.com.sidesoft.debit.collection.actionHandler;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SdcBankTXTDPHData implements FieldProvider {
static Logger log4j = Logger.getLogger(SdcBankTXTDPHData.class);
  private String InitRecordNumber="0";
  public String c1;
  public String documentno;
  public String taxid;
  public String c6;
  public String amount;
  public String c8;
  public String codebank;
  public String tipocuenta;
  public String accountno;
  public String c12;
  public String taxidbank;
  public String partnername;
  public String address;
  public String phone;
  public String ciudad;
  public String c19;
  public String c18;
  public String fecha;
  public String factura;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c1"))
      return c1;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("c6"))
      return c6;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c8"))
      return c8;
    else if (fieldName.equalsIgnoreCase("codebank"))
      return codebank;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("accountno"))
      return accountno;
    else if (fieldName.equalsIgnoreCase("c12"))
      return c12;
    else if (fieldName.equalsIgnoreCase("taxidbank"))
      return taxidbank;
    else if (fieldName.equalsIgnoreCase("partnername"))
      return partnername;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("ciudad"))
      return ciudad;
    else if (fieldName.equalsIgnoreCase("c19"))
      return c19;
    else if (fieldName.equalsIgnoreCase("c18"))
      return c18;
    else if (fieldName.equalsIgnoreCase("fecha"))
      return fecha;
    else if (fieldName.equalsIgnoreCase("factura"))
      return factura;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SdcBankTXTDPHData[] selectgeneral(ConnectionProvider connectionProvider)    throws ServletException {
    return selectgeneral(connectionProvider, 0, 0);
  }

  public static SdcBankTXTDPHData[] selectgeneral(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT 'CO' as c1,''documentno,'' taxid,'USD' as c6" +
      "	,'' as amount,'CTA' as c8,'' codebank, '' tipocuenta, '' accountno" +
      "	,'' c12,'' taxidbank,'' partnername, '' address ,'' phone,'' ciudad" +
      "	, 'CARGA' c19,'CUENCA' c18,'' fecha, '' factura" +
      "	FROM dual";

    ResultSet result;
    Vector<SdcBankTXTDPHData> vector = new Vector<SdcBankTXTDPHData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());

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
        SdcBankTXTDPHData objectSdcBankTXTDPHData = new SdcBankTXTDPHData();
        objectSdcBankTXTDPHData.c1 = UtilSql.getValue(result, "c1");
        objectSdcBankTXTDPHData.documentno = UtilSql.getValue(result, "documentno");
        objectSdcBankTXTDPHData.taxid = UtilSql.getValue(result, "taxid");
        objectSdcBankTXTDPHData.c6 = UtilSql.getValue(result, "c6");
        objectSdcBankTXTDPHData.amount = UtilSql.getValue(result, "amount");
        objectSdcBankTXTDPHData.c8 = UtilSql.getValue(result, "c8");
        objectSdcBankTXTDPHData.codebank = UtilSql.getValue(result, "codebank");
        objectSdcBankTXTDPHData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectSdcBankTXTDPHData.accountno = UtilSql.getValue(result, "accountno");
        objectSdcBankTXTDPHData.c12 = UtilSql.getValue(result, "c12");
        objectSdcBankTXTDPHData.taxidbank = UtilSql.getValue(result, "taxidbank");
        objectSdcBankTXTDPHData.partnername = UtilSql.getValue(result, "partnername");
        objectSdcBankTXTDPHData.address = UtilSql.getValue(result, "address");
        objectSdcBankTXTDPHData.phone = UtilSql.getValue(result, "phone");
        objectSdcBankTXTDPHData.ciudad = UtilSql.getValue(result, "ciudad");
        objectSdcBankTXTDPHData.c19 = UtilSql.getValue(result, "c19");
        objectSdcBankTXTDPHData.c18 = UtilSql.getValue(result, "c18");
        objectSdcBankTXTDPHData.fecha = UtilSql.getValue(result, "fecha");
        objectSdcBankTXTDPHData.factura = UtilSql.getValue(result, "factura");
        objectSdcBankTXTDPHData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSdcBankTXTDPHData);
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
    SdcBankTXTDPHData objectSdcBankTXTDPHData[] = new SdcBankTXTDPHData[vector.size()];
    vector.copyInto(objectSdcBankTXTDPHData);
    return(objectSdcBankTXTDPHData);
  }

  public static SdcBankTXTDPHData[] selectdetaill(ConnectionProvider connectionProvider, String recordid)    throws ServletException {
    return selectdetaill(connectionProvider, recordid, 0, 0);
  }

  public static SdcBankTXTDPHData[] selectdetaill(ConnectionProvider connectionProvider, String recordid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT 'CO' as c1,c.documentno,bp.taxid,'USD' as c6" +
      "	,ROUND(c.outstandingamt,2) as amount,'CTA' as c8,COALESCE(bt.code,'') AS codebank" +
      "	,CASE WHEN bpb.bankaccounttype='C' THEN 'CTE' WHEN bpb.bankaccounttype='S' THEN 'AHO' ELSE '' END AS tipocuenta" +
      "	,bpb.accountno" +
      "	,CASE WHEN LENGTH(bp.taxid)=10 THEN 'c' WHEN LENGTH(bp.taxid)=13 THEN 'r' ELSE 'p' END as c12" +
      "	,bp.taxid as taxidbank,bp.name as partnername,l.address1 as address, bpl.phone,COALESCE(ct.name,'') as ciudad" +
      "	, 'CARGA' c18,'CUENCA' c19,slci_date_name_month(TRUNC(NOW()),'es_EC') fecha, c.documentno as factura" +
      "	FROM sdc_dc_propocollect c" +
      "		JOIN c_bpartner bp ON bp.c_bpartner_id=c.c_bpartner_id" +
      "		JOIN c_invoice i ON i.c_bpartner_id=bp.c_bpartner_id AND i.documentno=c.documentno" +
      "		JOIN c_bpartner_location bpl ON bpl.c_bpartner_location_id=i.c_bpartner_location_id" +
      "		JOIN c_location l ON l.c_location_id=bpl.c_location_id" +
      "		LEFT JOIN secpm_canton ct ON ct.secpm_canton_id=bpl.em_secpm_canton_id" +
      "		JOIN c_bp_bankaccount bpb ON bpb.c_bpartner_id=bp.c_bpartner_id" +
      "		JOIN ssfi_banktransfer bt ON bt.ssfi_banktransfer_id=bpb.em_ssfi_banktransfer_id" +
      "	WHERE sdc_debitcollect_id = ?" +
      "		AND bp.em_sdc_debits='Y'" +
      "	ORDER BY c.documentno,duedate";

    ResultSet result;
    Vector<SdcBankTXTDPHData> vector = new Vector<SdcBankTXTDPHData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordid);

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
        SdcBankTXTDPHData objectSdcBankTXTDPHData = new SdcBankTXTDPHData();
        objectSdcBankTXTDPHData.c1 = UtilSql.getValue(result, "c1");
        objectSdcBankTXTDPHData.documentno = UtilSql.getValue(result, "documentno");
        objectSdcBankTXTDPHData.taxid = UtilSql.getValue(result, "taxid");
        objectSdcBankTXTDPHData.c6 = UtilSql.getValue(result, "c6");
        objectSdcBankTXTDPHData.amount = UtilSql.getValue(result, "amount");
        objectSdcBankTXTDPHData.c8 = UtilSql.getValue(result, "c8");
        objectSdcBankTXTDPHData.codebank = UtilSql.getValue(result, "codebank");
        objectSdcBankTXTDPHData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectSdcBankTXTDPHData.accountno = UtilSql.getValue(result, "accountno");
        objectSdcBankTXTDPHData.c12 = UtilSql.getValue(result, "c12");
        objectSdcBankTXTDPHData.taxidbank = UtilSql.getValue(result, "taxidbank");
        objectSdcBankTXTDPHData.partnername = UtilSql.getValue(result, "partnername");
        objectSdcBankTXTDPHData.address = UtilSql.getValue(result, "address");
        objectSdcBankTXTDPHData.phone = UtilSql.getValue(result, "phone");
        objectSdcBankTXTDPHData.ciudad = UtilSql.getValue(result, "ciudad");
        objectSdcBankTXTDPHData.c18 = UtilSql.getValue(result, "c18");
        objectSdcBankTXTDPHData.c19 = UtilSql.getValue(result, "c19");
        objectSdcBankTXTDPHData.fecha = UtilSql.getValue(result, "fecha");
        objectSdcBankTXTDPHData.factura = UtilSql.getValue(result, "factura");
        objectSdcBankTXTDPHData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSdcBankTXTDPHData);
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
    SdcBankTXTDPHData objectSdcBankTXTDPHData[] = new SdcBankTXTDPHData[vector.size()];
    vector.copyInto(objectSdcBankTXTDPHData);
    return(objectSdcBankTXTDPHData);
  }

  public static SdcBankTXTDPHData[] selectsummary(ConnectionProvider connectionProvider, String recordid)    throws ServletException {
    return selectsummary(connectionProvider, recordid, 0, 0);
  }

  public static SdcBankTXTDPHData[] selectsummary(ConnectionProvider connectionProvider, String recordid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT 'CO' as c1,i.documentno,bp.taxid,'USD' as c6" +
      "	,SUM(ROUND(c.outstandingamt,2)) as amount,'CTA' as c8,COALESCE(bt.code,'') AS codebank" +
      "	,CASE WHEN bpb.bankaccounttype='C' THEN 'CTE' WHEN bpb.bankaccounttype='S' THEN 'AHO' ELSE '' END AS tipocuenta" +
      "	,bpb.accountno" +
      "	,CASE WHEN LENGTH(bp.taxid)=10 THEN 'c' WHEN LENGTH(bp.taxid)=13 THEN 'r' ELSE 'p' END as c12" +
      "	,bp.taxid as taxidbank,bp.name as partnername,l.address1 as address, bpl.phone,COALESCE(ct.name,'') as ciudad" +
      "	, 'CARGA' c18,'CUENCA' c19,slci_date_name_month(TRUNC(NOW()),'es_EC') fecha, i.documentno as factura" +
      "	FROM sdc_dc_propocollect c" +
      "		JOIN c_bpartner bp ON bp.c_bpartner_id=c.c_bpartner_id" +
      "		JOIN c_invoice i ON i.c_bpartner_id=bp.c_bpartner_id AND i.documentno=c.documentno" +
      "		JOIN c_bpartner_location bpl ON bpl.c_bpartner_location_id=i.c_bpartner_location_id" +
      "		JOIN c_location l ON l.c_location_id=bpl.c_location_id" +
      "		LEFT JOIN secpm_canton ct ON ct.secpm_canton_id=bpl.em_secpm_canton_id" +
      "		JOIN c_bp_bankaccount bpb ON bpb.c_bpartner_id=bp.c_bpartner_id" +
      "		JOIN ssfi_banktransfer bt ON bt.ssfi_banktransfer_id=bpb.em_ssfi_banktransfer_id" +
      "	WHERE sdc_debitcollect_id = ?" +
      "		AND bp.em_sdc_debits='Y'" +
      "	GROUP BY i.c_invoice_id,bp.c_bpartner_id,bpb.c_bp_bankaccount_id,bt.ssfi_banktransfer_id," +
      "		l.c_location_id,bpl.c_bpartner_location_id,ct.name";

    ResultSet result;
    Vector<SdcBankTXTDPHData> vector = new Vector<SdcBankTXTDPHData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, recordid);

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
        SdcBankTXTDPHData objectSdcBankTXTDPHData = new SdcBankTXTDPHData();
        objectSdcBankTXTDPHData.c1 = UtilSql.getValue(result, "c1");
        objectSdcBankTXTDPHData.documentno = UtilSql.getValue(result, "documentno");
        objectSdcBankTXTDPHData.taxid = UtilSql.getValue(result, "taxid");
        objectSdcBankTXTDPHData.c6 = UtilSql.getValue(result, "c6");
        objectSdcBankTXTDPHData.amount = UtilSql.getValue(result, "amount");
        objectSdcBankTXTDPHData.c8 = UtilSql.getValue(result, "c8");
        objectSdcBankTXTDPHData.codebank = UtilSql.getValue(result, "codebank");
        objectSdcBankTXTDPHData.tipocuenta = UtilSql.getValue(result, "tipocuenta");
        objectSdcBankTXTDPHData.accountno = UtilSql.getValue(result, "accountno");
        objectSdcBankTXTDPHData.c12 = UtilSql.getValue(result, "c12");
        objectSdcBankTXTDPHData.taxidbank = UtilSql.getValue(result, "taxidbank");
        objectSdcBankTXTDPHData.partnername = UtilSql.getValue(result, "partnername");
        objectSdcBankTXTDPHData.address = UtilSql.getValue(result, "address");
        objectSdcBankTXTDPHData.phone = UtilSql.getValue(result, "phone");
        objectSdcBankTXTDPHData.ciudad = UtilSql.getValue(result, "ciudad");
        objectSdcBankTXTDPHData.c18 = UtilSql.getValue(result, "c18");
        objectSdcBankTXTDPHData.c19 = UtilSql.getValue(result, "c19");
        objectSdcBankTXTDPHData.fecha = UtilSql.getValue(result, "fecha");
        objectSdcBankTXTDPHData.factura = UtilSql.getValue(result, "factura");
        objectSdcBankTXTDPHData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSdcBankTXTDPHData);
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
    SdcBankTXTDPHData objectSdcBankTXTDPHData[] = new SdcBankTXTDPHData[vector.size()];
    vector.copyInto(objectSdcBankTXTDPHData);
    return(objectSdcBankTXTDPHData);
  }
}
