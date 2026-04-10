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

public class SdcBankTXTData implements FieldProvider {
static Logger log4j = Logger.getLogger(SdcBankTXTData.class);
  private String InitRecordNumber="0";
  public String c1;
  public String taxid;
  public String c3;
  public String amount;
  public String c5;
  public String c6;
  public String c7;
  public String taxidbank;
  public String partnername;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c1"))
      return c1;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("c3"))
      return c3;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("c5"))
      return c5;
    else if (fieldName.equalsIgnoreCase("c6"))
      return c6;
    else if (fieldName.equalsIgnoreCase("c7"))
      return c7;
    else if (fieldName.equalsIgnoreCase("taxidbank"))
      return taxidbank;
    else if (fieldName.equalsIgnoreCase("partnername"))
      return partnername;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SdcBankTXTData[] selectgeneral(ConnectionProvider connectionProvider)    throws ServletException {
    return selectgeneral(connectionProvider, 0, 0);
  }

  public static SdcBankTXTData[] selectgeneral(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT 'CO' as c1,'' as taxid,'USD' as c3,'' as amount,'REC' as c5,'SALDOS' as c6,'' as c7" +
      "	,'' as taxidbank,'' as partnername" +
      "	FROM dual";

    ResultSet result;
    Vector<SdcBankTXTData> vector = new Vector<SdcBankTXTData>(0);
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
        SdcBankTXTData objectSdcBankTXTData = new SdcBankTXTData();
        objectSdcBankTXTData.c1 = UtilSql.getValue(result, "c1");
        objectSdcBankTXTData.taxid = UtilSql.getValue(result, "taxid");
        objectSdcBankTXTData.c3 = UtilSql.getValue(result, "c3");
        objectSdcBankTXTData.amount = UtilSql.getValue(result, "amount");
        objectSdcBankTXTData.c5 = UtilSql.getValue(result, "c5");
        objectSdcBankTXTData.c6 = UtilSql.getValue(result, "c6");
        objectSdcBankTXTData.c7 = UtilSql.getValue(result, "c7");
        objectSdcBankTXTData.taxidbank = UtilSql.getValue(result, "taxidbank");
        objectSdcBankTXTData.partnername = UtilSql.getValue(result, "partnername");
        objectSdcBankTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSdcBankTXTData);
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
    SdcBankTXTData objectSdcBankTXTData[] = new SdcBankTXTData[vector.size()];
    vector.copyInto(objectSdcBankTXTData);
    return(objectSdcBankTXTData);
  }

  public static SdcBankTXTData[] selectsummary(ConnectionProvider connectionProvider, String recordid)    throws ServletException {
    return selectsummary(connectionProvider, recordid, 0, 0);
  }

  public static SdcBankTXTData[] selectsummary(ConnectionProvider connectionProvider, String recordid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT 'CO' as c1,bp.taxid,'USD' as c3,SUM(ROUND(c.outstandingamt,2)) as amount,'REC' as c5,'SALDOS' as c6," +
      "	CASE WHEN LENGTH(bp.taxid)=10 THEN 'C' WHEN LENGTH(bp.taxid)=13 THEN 'R' ELSE 'P' END as c7" +
      "	,bp.taxid as taxidbank,bp.name as partnername" +
      "	FROM sdc_dc_propocollect c" +
      "		JOIN c_bpartner bp ON bp.c_bpartner_id=c.c_bpartner_id" +
      "		JOIN c_invoice i ON i.c_bpartner_id=bp.c_bpartner_id AND i.documentno=c.documentno" +
      "	WHERE sdc_debitcollect_id = ?" +
      "		AND bp.em_sdc_collections='Y'" +
      "	GROUP BY bp.c_bpartner_id";

    ResultSet result;
    Vector<SdcBankTXTData> vector = new Vector<SdcBankTXTData>(0);
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
        SdcBankTXTData objectSdcBankTXTData = new SdcBankTXTData();
        objectSdcBankTXTData.c1 = UtilSql.getValue(result, "c1");
        objectSdcBankTXTData.taxid = UtilSql.getValue(result, "taxid");
        objectSdcBankTXTData.c3 = UtilSql.getValue(result, "c3");
        objectSdcBankTXTData.amount = UtilSql.getValue(result, "amount");
        objectSdcBankTXTData.c5 = UtilSql.getValue(result, "c5");
        objectSdcBankTXTData.c6 = UtilSql.getValue(result, "c6");
        objectSdcBankTXTData.c7 = UtilSql.getValue(result, "c7");
        objectSdcBankTXTData.taxidbank = UtilSql.getValue(result, "taxidbank");
        objectSdcBankTXTData.partnername = UtilSql.getValue(result, "partnername");
        objectSdcBankTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSdcBankTXTData);
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
    SdcBankTXTData objectSdcBankTXTData[] = new SdcBankTXTData[vector.size()];
    vector.copyInto(objectSdcBankTXTData);
    return(objectSdcBankTXTData);
  }

  public static SdcBankTXTData[] selectdetaill(ConnectionProvider connectionProvider, String recordid)    throws ServletException {
    return selectdetaill(connectionProvider, recordid, 0, 0);
  }

  public static SdcBankTXTData[] selectdetaill(ConnectionProvider connectionProvider, String recordid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT 'CO' as c1,bp.taxid,'USD' as c3,ROUND(c.outstandingamt,2) as amount,'REC' as c5,'SALDOS' as c6," +
      "	CASE WHEN LENGTH(bp.taxid)=10 THEN 'c' WHEN LENGTH(bp.taxid)=13 THEN 'r' ELSE 'p' END as c7" +
      "	,bp.taxid as taxidbank,bp.name as partnername" +
      "	FROM sdc_dc_propocollect c" +
      "		JOIN c_bpartner bp ON bp.c_bpartner_id=c.c_bpartner_id" +
      "		JOIN c_invoice i ON i.c_bpartner_id=bp.c_bpartner_id AND i.documentno=c.documentno" +
      "	WHERE sdc_debitcollect_id = ?" +
      "		AND bp.em_sdc_collections='Y'" +
      "	ORDER BY c.documentno,duedate";

    ResultSet result;
    Vector<SdcBankTXTData> vector = new Vector<SdcBankTXTData>(0);
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
        SdcBankTXTData objectSdcBankTXTData = new SdcBankTXTData();
        objectSdcBankTXTData.c1 = UtilSql.getValue(result, "c1");
        objectSdcBankTXTData.taxid = UtilSql.getValue(result, "taxid");
        objectSdcBankTXTData.c3 = UtilSql.getValue(result, "c3");
        objectSdcBankTXTData.amount = UtilSql.getValue(result, "amount");
        objectSdcBankTXTData.c5 = UtilSql.getValue(result, "c5");
        objectSdcBankTXTData.c6 = UtilSql.getValue(result, "c6");
        objectSdcBankTXTData.c7 = UtilSql.getValue(result, "c7");
        objectSdcBankTXTData.taxidbank = UtilSql.getValue(result, "taxidbank");
        objectSdcBankTXTData.partnername = UtilSql.getValue(result, "partnername");
        objectSdcBankTXTData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSdcBankTXTData);
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
    SdcBankTXTData objectSdcBankTXTData[] = new SdcBankTXTData[vector.size()];
    vector.copyInto(objectSdcBankTXTData);
    return(objectSdcBankTXTData);
  }
}
