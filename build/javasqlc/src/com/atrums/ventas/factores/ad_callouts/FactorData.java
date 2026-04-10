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

class FactorData implements FieldProvider {
static Logger log4j = Logger.getLogger(FactorData.class);
  private String InitRecordNumber="0";
  public String entrada;
  public String recargo;
  public String financiamiento;
  public String iva;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("entrada"))
      return entrada;
    else if (fieldName.equalsIgnoreCase("recargo"))
      return recargo;
    else if (fieldName.equalsIgnoreCase("financiamiento"))
      return financiamiento;
    else if (fieldName.equalsIgnoreCase("iva"))
      return iva;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static FactorData[] select(ConnectionProvider connectionProvider, String strProductoId)    throws ServletException {
    return select(connectionProvider, strProductoId, 0, 0);
  }

  public static FactorData[] select(ConnectionProvider connectionProvider, String strProductoId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select f.entrada as entrada, " +
      "               f.recargo as recargo, " +
      "               f.financiamiento as financiamiento," +
      "               '0' as iva" +
      "          from atvef_factor f" +
      "         where case when exists (select 1 from atvef_factor af where af.m_product_id = ?)" +
      "                then f.m_product_id = ?" +
      "                when exists (select 1 from atvef_factor af where af.m_product_category_id = (select mp.m_product_category_id from m_product mp where  mp.m_product_id = ?))" +
      "                then f.m_product_category_id = (select mp.m_product_category_id from m_product mp where  mp.m_product_id = ?)" +
      "                end" +
      "        order by f.datefrom, f.m_product_id desc limit 1";

    ResultSet result;
    Vector<FactorData> vector = new Vector<FactorData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strProductoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strProductoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strProductoId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strProductoId);

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
        FactorData objectFactorData = new FactorData();
        objectFactorData.entrada = UtilSql.getValue(result, "entrada");
        objectFactorData.recargo = UtilSql.getValue(result, "recargo");
        objectFactorData.financiamiento = UtilSql.getValue(result, "financiamiento");
        objectFactorData.iva = UtilSql.getValue(result, "iva");
        objectFactorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFactorData);
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
    FactorData objectFactorData[] = new FactorData[vector.size()];
    vector.copyInto(objectFactorData);
    return(objectFactorData);
  }

  public static FactorData[] selectIva(ConnectionProvider connectionProvider, String strTaxId)    throws ServletException {
    return selectIva(connectionProvider, strTaxId, 0, 0);
  }

  public static FactorData[] selectIva(ConnectionProvider connectionProvider, String strTaxId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select rate as iva" +
      "              from c_tax " +
      "             where c_tax_id = ?";

    ResultSet result;
    Vector<FactorData> vector = new Vector<FactorData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strTaxId);

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
        FactorData objectFactorData = new FactorData();
        objectFactorData.iva = UtilSql.getValue(result, "iva");
        objectFactorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectFactorData);
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
    FactorData objectFactorData[] = new FactorData[vector.size()];
    vector.copyInto(objectFactorData);
    return(objectFactorData);
  }
}
