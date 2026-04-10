//Sqlc generated V1.O00-1
package com.atrums.indumot.postventa.callout;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ATINDPODirClienteData implements FieldProvider {
static Logger log4j = Logger.getLogger(ATINDPODirClienteData.class);
  private String InitRecordNumber="0";
  public String cBpartnerLocationId;
  public String name;
  public String isbillto;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("isbillto"))
      return isbillto;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ATINDPODirClienteData[] select(ConnectionProvider connectionProvider, String strBPartnerId)    throws ServletException {
    return select(connectionProvider, strBPartnerId, 0, 0);
  }

  public static ATINDPODirClienteData[] select(ConnectionProvider connectionProvider, String strBPartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT cbl.c_bpartner_location_id,cbl.name,cbl.isbillto  " +
      "            FROM c_bpartner_location  cbl " +
      "            WHERE cbl.isactive ='Y' " +
      "            AND cbl.c_bpartner_id= ? " +
      "            ORDER BY c_bpartner_location_id ASC ";

    ResultSet result;
    Vector<ATINDPODirClienteData> vector = new Vector<ATINDPODirClienteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strBPartnerId);

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
        ATINDPODirClienteData objectATINDPODirClienteData = new ATINDPODirClienteData();
        objectATINDPODirClienteData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectATINDPODirClienteData.name = UtilSql.getValue(result, "name");
        objectATINDPODirClienteData.isbillto = UtilSql.getValue(result, "isbillto");
        objectATINDPODirClienteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectATINDPODirClienteData);
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
    ATINDPODirClienteData objectATINDPODirClienteData[] = new ATINDPODirClienteData[vector.size()];
    vector.copyInto(objectATINDPODirClienteData);
    return(objectATINDPODirClienteData);
  }
}
