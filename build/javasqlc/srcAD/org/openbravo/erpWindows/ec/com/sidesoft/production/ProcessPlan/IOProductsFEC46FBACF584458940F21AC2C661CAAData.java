//Sqlc generated V1.O00-1
package org.openbravo.erpWindows.ec.com.sidesoft.production.ProcessPlan;

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
WAD Generated class
 */
class IOProductsFEC46FBACF584458940F21AC2C661CAAData implements FieldProvider {
static Logger log4j = Logger.getLogger(IOProductsFEC46FBACF584458940F21AC2C661CAAData.class);
  private String InitRecordNumber="0";
  public String dummy;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("dummy"))
      return dummy;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static IOProductsFEC46FBACF584458940F21AC2C661CAAData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static IOProductsFEC46FBACF584458940F21AC2C661CAAData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT '' AS dummy from DUAL";

    ResultSet result;
    Vector<IOProductsFEC46FBACF584458940F21AC2C661CAAData> vector = new Vector<IOProductsFEC46FBACF584458940F21AC2C661CAAData>(0);
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
        IOProductsFEC46FBACF584458940F21AC2C661CAAData objectIOProductsFEC46FBACF584458940F21AC2C661CAAData = new IOProductsFEC46FBACF584458940F21AC2C661CAAData();
        objectIOProductsFEC46FBACF584458940F21AC2C661CAAData.dummy = UtilSql.getValue(result, "dummy");
        objectIOProductsFEC46FBACF584458940F21AC2C661CAAData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectIOProductsFEC46FBACF584458940F21AC2C661CAAData);
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
    IOProductsFEC46FBACF584458940F21AC2C661CAAData objectIOProductsFEC46FBACF584458940F21AC2C661CAAData[] = new IOProductsFEC46FBACF584458940F21AC2C661CAAData[vector.size()];
    vector.copyInto(objectIOProductsFEC46FBACF584458940F21AC2C661CAAData);
    return(objectIOProductsFEC46FBACF584458940F21AC2C661CAAData);
  }

/**
Select for auxiliar field
 */
  public static String selectActPFF8081813219E68E013219ECFE930004_Value(ConnectionProvider connectionProvider, String MA_SEQUENCEPRODUCT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT.VALUE||' - '||MA_SEQUENCE.VALUE||' - '||MA_SEQUENCE.SEQNO AS value FROM MA_SEQUENCEPRODUCT JOIN MA_SEQUENCE ON MA_SEQUENCE.MA_SEQUENCE_ID = MA_SEQUENCEPRODUCT.MA_SEQUENCE_ID LEFT JOIN M_PRODUCT ON MA_SEQUENCEPRODUCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID WHERE MA_SEQUENCEPRODUCT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_SEQUENCEPRODUCT_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "value");
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
    return(strReturn);
  }

/**
Select for auxiliar field
 */
  public static String selectActPFF8081813219E68E013219ECFE930004_Name(ConnectionProvider connectionProvider, String MA_SEQUENCEPRODUCT_ID)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_PRODUCT.NAME||' - '||MA_SEQUENCE.NAME||' - '||MA_SEQUENCE.SEQNO AS name FROM MA_SEQUENCEPRODUCT JOIN MA_SEQUENCE ON MA_SEQUENCE.MA_SEQUENCE_ID = MA_SEQUENCEPRODUCT.MA_SEQUENCE_ID LEFT JOIN M_PRODUCT ON MA_SEQUENCEPRODUCT.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID WHERE MA_SEQUENCEPRODUCT_ID = ? ";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, MA_SEQUENCEPRODUCT_ID);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "name");
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
    return(strReturn);
  }
}
