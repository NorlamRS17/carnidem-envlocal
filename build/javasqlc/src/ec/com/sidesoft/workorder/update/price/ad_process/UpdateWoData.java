//Sqlc generated V1.O00-1
package ec.com.sidesoft.workorder.update.price.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class UpdateWoData implements FieldProvider {
static Logger log4j = Logger.getLogger(UpdateWoData.class);
  private String InitRecordNumber="0";
  public String orden;
  public String total;
  public String iva;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("orden"))
      return orden;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("iva"))
      return iva;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static UpdateWoData[] totalWorkOrder(ConnectionProvider connectionProvider, String bpartner, String documentno)    throws ServletException {
    return totalWorkOrder(connectionProvider, bpartner, documentno, 0, 0);
  }

  public static UpdateWoData[] totalWorkOrder(ConnectionProvider connectionProvider, String bpartner, String documentno, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          SELECT pvl.atindpo_postventa_id as orden" +
      "            , sum(pvl.atindpo_linenetamt) as total" +
      "            , sum(pvl.atindpo_total) as iva" +
      "          From atindpo_postventa pv" +
      "            Join c_bpartner bp on bp.c_bpartner_id = pv.c_bpartner_id" +
      "            Join atindpo_postventalinea pvl on pvl.atindpo_postventa_id = pv.atindpo_postventa_id" +
      "          WHERE pv.c_bpartner_id = ? AND pv.documentno =?" +
      "          GROUP BY orden ";

    ResultSet result;
    Vector<UpdateWoData> vector = new Vector<UpdateWoData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, bpartner);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);

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
        UpdateWoData objectUpdateWoData = new UpdateWoData();
        objectUpdateWoData.orden = UtilSql.getValue(result, "orden");
        objectUpdateWoData.total = UtilSql.getValue(result, "total");
        objectUpdateWoData.iva = UtilSql.getValue(result, "iva");
        objectUpdateWoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUpdateWoData);
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
    UpdateWoData objectUpdateWoData[] = new UpdateWoData[vector.size()];
    vector.copyInto(objectUpdateWoData);
    return(objectUpdateWoData);
  }

  public static int updateTotalWorkOrder(ConnectionProvider connectionProvider, String totalLines, String grandTotal, String atindpoPostventaId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          UPDATE atindpo_postventa set " +
      "            totallines = ? ::numeric" +
      "            ,grandtotal = ? ::numeric" +
      "            ,updated=TO_DATE(NOW())" +
      "          WHERE atindpo_postventa_id = ?;";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, totalLines);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, grandTotal);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, atindpoPostventaId);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
