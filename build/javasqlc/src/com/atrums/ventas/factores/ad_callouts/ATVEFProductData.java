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

class ATVEFProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ATVEFProductData.class);
  private String InitRecordNumber="0";
  public String pricelist;
  public String plazo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("plazo"))
      return plazo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ATVEFProductData[] dummy(ConnectionProvider connectionProvider)    throws ServletException {
    return dummy(connectionProvider, 0, 0);
  }

  public static ATVEFProductData[] dummy(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select '' as pricelist, '' as plazo " +
      "        from dual";

    ResultSet result;
    Vector<ATVEFProductData> vector = new Vector<ATVEFProductData>(0);
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
        ATVEFProductData objectATVEFProductData = new ATVEFProductData();
        objectATVEFProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectATVEFProductData.plazo = UtilSql.getValue(result, "plazo");
        objectATVEFProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATVEFProductData);
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
    ATVEFProductData objectATVEFProductData[] = new ATVEFProductData[vector.size()];
    vector.copyInto(objectATVEFProductData);
    return(objectATVEFProductData);
  }

  public static ATVEFProductData[] select(ConnectionProvider connectionProvider, String mProductId, String mPriceListId)    throws ServletException {
    return select(connectionProvider, mProductId, mPriceListId, 0, 0);
  }

  public static ATVEFProductData[] select(ConnectionProvider connectionProvider, String mProductId, String mPriceListId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select pp.pricelist " +
      "        from m_productprice pp, m_pricelist_version pv " +
      "        where pp.m_pricelist_version_id = pv.m_pricelist_version_id " +
      "        and m_product_id = ?" +
      "        and pv.m_pricelist_id = ?        " +
      "        order by pv.validfrom desc limit 1 ";

    ResultSet result;
    Vector<ATVEFProductData> vector = new Vector<ATVEFProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPriceListId);

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
        ATVEFProductData objectATVEFProductData = new ATVEFProductData();
        objectATVEFProductData.pricelist = UtilSql.getValue(result, "pricelist");
        objectATVEFProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATVEFProductData);
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
    ATVEFProductData objectATVEFProductData[] = new ATVEFProductData[vector.size()];
    vector.copyInto(objectATVEFProductData);
    return(objectATVEFProductData);
  }

  public static ATVEFProductData[] plazo(ConnectionProvider connectionProvider, String cOrderId)    throws ServletException {
    return plazo(connectionProvider, cOrderId, 0, 0);
  }

  public static ATVEFProductData[] plazo(ConnectionProvider connectionProvider, String cOrderId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      select p.netdays as plazo " +
      "        from c_order o, c_paymentterm p " +
      "        where o.c_paymentterm_id = p.c_paymentterm_id " +
      "        and o.c_order_id = ? ";

    ResultSet result;
    Vector<ATVEFProductData> vector = new Vector<ATVEFProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);

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
        ATVEFProductData objectATVEFProductData = new ATVEFProductData();
        objectATVEFProductData.plazo = UtilSql.getValue(result, "plazo");
        objectATVEFProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATVEFProductData);
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
    ATVEFProductData objectATVEFProductData[] = new ATVEFProductData[vector.size()];
    vector.copyInto(objectATVEFProductData);
    return(objectATVEFProductData);
  }
}
