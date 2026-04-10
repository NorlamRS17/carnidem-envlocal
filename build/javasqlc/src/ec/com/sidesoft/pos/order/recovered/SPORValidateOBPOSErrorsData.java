//Sqlc generated V1.O00-1
package ec.com.sidesoft.pos.order.recovered;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SPORValidateOBPOSErrorsData implements FieldProvider {
static Logger log4j = Logger.getLogger(SPORValidateOBPOSErrorsData.class);
  private String InitRecordNumber="0";
  public String json;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("json"))
      return json;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SPORValidateOBPOSErrorsData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static SPORValidateOBPOSErrorsData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select obe.jsoninfo as json from obpos_errors obe";

    ResultSet result;
    Vector<SPORValidateOBPOSErrorsData> vector = new Vector<SPORValidateOBPOSErrorsData>(0);
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
        SPORValidateOBPOSErrorsData objectSPORValidateOBPOSErrorsData = new SPORValidateOBPOSErrorsData();
        objectSPORValidateOBPOSErrorsData.json = UtilSql.getValue(result, "json");
        objectSPORValidateOBPOSErrorsData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSPORValidateOBPOSErrorsData);
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
    SPORValidateOBPOSErrorsData objectSPORValidateOBPOSErrorsData[] = new SPORValidateOBPOSErrorsData[vector.size()];
    vector.copyInto(objectSPORValidateOBPOSErrorsData);
    return(objectSPORValidateOBPOSErrorsData);
  }
}
