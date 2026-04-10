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

class ATVEFCalculaCuotaData implements FieldProvider {
static Logger log4j = Logger.getLogger(ATVEFCalculaCuotaData.class);
  private String InitRecordNumber="0";
  public String entrada;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("entrada"))
      return entrada;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ATVEFCalculaCuotaData[] select(ConnectionProvider connectionProvider, String mProductId)    throws ServletException {
    return select(connectionProvider, mProductId, 0, 0);
  }

  public static ATVEFCalculaCuotaData[] select(ConnectionProvider connectionProvider, String mProductId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT coalesce(entrada,0) as entrada " +
      "        FROM atvef_factor WHERE m_product_id = ? " +
      "        and isactive = 'Y' ";

    ResultSet result;
    Vector<ATVEFCalculaCuotaData> vector = new Vector<ATVEFCalculaCuotaData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

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
        ATVEFCalculaCuotaData objectATVEFCalculaCuotaData = new ATVEFCalculaCuotaData();
        objectATVEFCalculaCuotaData.entrada = UtilSql.getValue(result, "entrada");
        objectATVEFCalculaCuotaData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATVEFCalculaCuotaData);
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
    ATVEFCalculaCuotaData objectATVEFCalculaCuotaData[] = new ATVEFCalculaCuotaData[vector.size()];
    vector.copyInto(objectATVEFCalculaCuotaData);
    return(objectATVEFCalculaCuotaData);
  }
}
