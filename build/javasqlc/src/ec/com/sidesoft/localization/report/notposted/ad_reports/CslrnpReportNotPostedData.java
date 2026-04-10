//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.report.notposted.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

/**
Class ReportNotPostedData
 */
class CslrnpReportNotPostedData implements FieldProvider {
static Logger log4j = Logger.getLogger(CslrnpReportNotPostedData.class);
  private String InitRecordNumber="0";
  public String documentno;
  public String dateacct;
  public String description;
  public String amount;
  public String doctype;
  public String id;
  public String tabId;
  public String docbasetype;
  public String recordId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("amount"))
      return amount;
    else if (fieldName.equalsIgnoreCase("doctype"))
      return doctype;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("tab_id") || fieldName.equals("tabId"))
      return tabId;
    else if (fieldName.equalsIgnoreCase("docbasetype"))
      return docbasetype;
    else if (fieldName.equalsIgnoreCase("record_id") || fieldName.equals("recordId"))
      return recordId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

/**
Select for relation
 */
  public static CslrnpReportNotPostedData[] select(ConnectionProvider connectionProvider, String adLanguage, String client, String parDateFrom, String parDateTo, String processid)    throws ServletException {
    return select(connectionProvider, adLanguage, client, parDateFrom, parDateTo, processid, 0, 0);
  }

/**
Select for relation
 */
  public static CslrnpReportNotPostedData[] select(ConnectionProvider connectionProvider, String adLanguage, String client, String parDateFrom, String parDateTo, String processid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select documentno, dateacct, substr(ad_column_identifier(tablename, cbpid, ?) ||(CASE WHEN description IS NULL THEN '' ELSE ' (' || DESCRIPTION || ')' END),0,90) as description, " +
      "        GRANDTOTAL as amount, documentno2 as doctype, cbpid as id, tab_id, docbasetype, record_id" +
      "        from cslrnp_data_notposted" +
      "        where ad_client_id = ?" +
      "        and 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":" AND DATEACCT >= TO_DATE(?)  ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":" AND DATEACCT <= TO_DATE(?)  ");
    strSql = strSql + 
      "        and processid=?" +
      "        order by  documentno2, dateacct, description";

    ResultSet result;
    Vector<CslrnpReportNotPostedData> vector = new Vector<CslrnpReportNotPostedData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, processid);

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
        CslrnpReportNotPostedData objectCslrnpReportNotPostedData = new CslrnpReportNotPostedData();
        objectCslrnpReportNotPostedData.documentno = UtilSql.getValue(result, "documentno");
        objectCslrnpReportNotPostedData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectCslrnpReportNotPostedData.description = UtilSql.getValue(result, "description");
        objectCslrnpReportNotPostedData.amount = UtilSql.getValue(result, "amount");
        objectCslrnpReportNotPostedData.doctype = UtilSql.getValue(result, "doctype");
        objectCslrnpReportNotPostedData.id = UtilSql.getValue(result, "id");
        objectCslrnpReportNotPostedData.tabId = UtilSql.getValue(result, "tab_id");
        objectCslrnpReportNotPostedData.docbasetype = UtilSql.getValue(result, "docbasetype");
        objectCslrnpReportNotPostedData.recordId = UtilSql.getValue(result, "record_id");
        objectCslrnpReportNotPostedData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCslrnpReportNotPostedData);
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
    CslrnpReportNotPostedData objectCslrnpReportNotPostedData[] = new CslrnpReportNotPostedData[vector.size()];
    vector.copyInto(objectCslrnpReportNotPostedData);
    return(objectCslrnpReportNotPostedData);
  }
}
