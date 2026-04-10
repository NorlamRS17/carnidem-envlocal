//Sqlc generated V1.O00-1
package ec.com.sidesoft.projects.complement.ad_actions;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocInfoTableData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocInfoTableData.class);
  private String InitRecordNumber="0";
  public String posted;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("posted"))
      return posted;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocInfoTableData[] selectRecord(ConnectionProvider connectionProvider, String id)    throws ServletException {
    return selectRecord(connectionProvider, id, 0, 0);
  }

  public static DocInfoTableData[] selectRecord(ConnectionProvider connectionProvider, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT sdc.posted  " +
      "		FROM sproctm_detail_cost sdc " +
      "		where sproctm_detail_cost_id = ?";

    ResultSet result;
    Vector<DocInfoTableData> vector = new Vector<DocInfoTableData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocInfoTableData objectDocInfoTableData = new DocInfoTableData();
        objectDocInfoTableData.posted = UtilSql.getValue(result, "posted");
        objectDocInfoTableData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInfoTableData);
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
    DocInfoTableData objectDocInfoTableData[] = new DocInfoTableData[vector.size()];
    vector.copyInto(objectDocInfoTableData);
    return(objectDocInfoTableData);
  }
}
