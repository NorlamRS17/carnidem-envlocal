//Sqlc generated V1.O00-1
package com.atrums.indumot.postventa.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CopyFromOrdenServicioListaPreciosData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromOrdenServicioListaPreciosData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromOrdenServicioListaPreciosData[] select(ConnectionProvider connectionProvider, String srcAdOrgClient, String srcAdUserClient)    throws ServletException {
    return select(connectionProvider, srcAdOrgClient, srcAdUserClient, 0, 0);
  }

  public static CopyFromOrdenServicioListaPreciosData[] select(ConnectionProvider connectionProvider, String srcAdOrgClient, String srcAdUserClient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                    select m_pricelist.m_pricelist_id as id," +
      "                           ((CASE m_pricelist.isActive WHEN 'N' THEN '**' ELSE '' END) || m_pricelist.name) as name" +
      "                      from m_pricelist" +
      "                     WHERE issopricelist = 'Y'" +
      "                       AND m_pricelist.isActive = 'Y'" +
      "                       AND m_pricelist.AD_Org_ID IN(";
    strSql = strSql + ((srcAdOrgClient==null || srcAdOrgClient.equals(""))?"":srcAdOrgClient);
    strSql = strSql + 
      ") " +
      "                       AND m_pricelist.AD_Client_ID IN(";
    strSql = strSql + ((srcAdUserClient==null || srcAdUserClient.equals(""))?"":srcAdUserClient);
    strSql = strSql + 
      ")  " +
      "                       ORDER BY isdefault desc, name asc";

    ResultSet result;
    Vector<CopyFromOrdenServicioListaPreciosData> vector = new Vector<CopyFromOrdenServicioListaPreciosData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (srcAdOrgClient != null && !(srcAdOrgClient.equals(""))) {
        }
      if (srcAdUserClient != null && !(srcAdUserClient.equals(""))) {
        }

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
        CopyFromOrdenServicioListaPreciosData objectCopyFromOrdenServicioListaPreciosData = new CopyFromOrdenServicioListaPreciosData();
        objectCopyFromOrdenServicioListaPreciosData.id = UtilSql.getValue(result, "id");
        objectCopyFromOrdenServicioListaPreciosData.name = UtilSql.getValue(result, "name");
        objectCopyFromOrdenServicioListaPreciosData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromOrdenServicioListaPreciosData);
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
    CopyFromOrdenServicioListaPreciosData objectCopyFromOrdenServicioListaPreciosData[] = new CopyFromOrdenServicioListaPreciosData[vector.size()];
    vector.copyInto(objectCopyFromOrdenServicioListaPreciosData);
    return(objectCopyFromOrdenServicioListaPreciosData);
  }

  public static CopyFromOrdenServicioListaPreciosData[] set()    throws ServletException {
    CopyFromOrdenServicioListaPreciosData objectCopyFromOrdenServicioListaPreciosData[] = new CopyFromOrdenServicioListaPreciosData[1];
    objectCopyFromOrdenServicioListaPreciosData[0] = new CopyFromOrdenServicioListaPreciosData();
    objectCopyFromOrdenServicioListaPreciosData[0].id = "";
    objectCopyFromOrdenServicioListaPreciosData[0].name = "";
    return objectCopyFromOrdenServicioListaPreciosData;
  }
}
