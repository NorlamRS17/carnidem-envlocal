//Sqlc generated V1.O00-1
package com.atrums.ventas.factores.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ATVEFPaymenttermData implements FieldProvider {
static Logger log4j = Logger.getLogger(ATVEFPaymenttermData.class);
  private String InitRecordNumber="0";
  public String netdays;
  public String finPaymentmethodId;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("netdays"))
      return netdays;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ATVEFPaymenttermData[] select(ConnectionProvider connectionProvider, String cPaymenttermId)    throws ServletException {
    return select(connectionProvider, cPaymenttermId, 0, 0);
  }

  public static ATVEFPaymenttermData[] select(ConnectionProvider connectionProvider, String cPaymenttermId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.netdays, '' as fin_paymentmethod_id, '' as name" +
      "        from c_paymentterm p" +
      "        where p.c_paymentterm_id = ?  ";

    ResultSet result;
    Vector<ATVEFPaymenttermData> vector = new Vector<ATVEFPaymenttermData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);

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
        ATVEFPaymenttermData objectATVEFPaymenttermData = new ATVEFPaymenttermData();
        objectATVEFPaymenttermData.netdays = UtilSql.getValue(result, "netdays");
        objectATVEFPaymenttermData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectATVEFPaymenttermData.name = UtilSql.getValue(result, "name");
        objectATVEFPaymenttermData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATVEFPaymenttermData);
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
    ATVEFPaymenttermData objectATVEFPaymenttermData[] = new ATVEFPaymenttermData[vector.size()];
    vector.copyInto(objectATVEFPaymenttermData);
    return(objectATVEFPaymenttermData);
  }

  public static ATVEFPaymenttermData[] selectmetodos(ConnectionProvider connectionProvider, String name)    throws ServletException {
    return selectmetodos(connectionProvider, name, 0, 0);
  }

  public static ATVEFPaymenttermData[] selectmetodos(ConnectionProvider connectionProvider, String name, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select fin_paymentmethod_id, name " +
      "        from fin_paymentmethod " +
      "        where name like ? ";

    ResultSet result;
    Vector<ATVEFPaymenttermData> vector = new Vector<ATVEFPaymenttermData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

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
        ATVEFPaymenttermData objectATVEFPaymenttermData = new ATVEFPaymenttermData();
        objectATVEFPaymenttermData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectATVEFPaymenttermData.name = UtilSql.getValue(result, "name");
        objectATVEFPaymenttermData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATVEFPaymenttermData);
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
    ATVEFPaymenttermData objectATVEFPaymenttermData[] = new ATVEFPaymenttermData[vector.size()];
    vector.copyInto(objectATVEFPaymenttermData);
    return(objectATVEFPaymenttermData);
  }
}
