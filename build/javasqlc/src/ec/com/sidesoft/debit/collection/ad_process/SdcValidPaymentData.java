//Sqlc generated V1.O00-1
package ec.com.sidesoft.debit.collection.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

public class SdcValidPaymentData implements FieldProvider {
static Logger log4j = Logger.getLogger(SdcValidPaymentData.class);
  private String InitRecordNumber="0";
  public String pa;
  public String contrapartida;
  public String moneda;
  public String valor;
  public String formacobro;
  public String tipocuenta;
  public String cuenta;
  public String referencia;
  public String tipoidcliente;
  public String numidcliente;
  public String tercero;
  public String code;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pa"))
      return pa;
    else if (fieldName.equalsIgnoreCase("contrapartida"))
      return contrapartida;
    else if (fieldName.equalsIgnoreCase("moneda"))
      return moneda;
    else if (fieldName.equalsIgnoreCase("valor"))
      return valor;
    else if (fieldName.equalsIgnoreCase("formacobro"))
      return formacobro;
    else if (fieldName.equalsIgnoreCase("tipocuenta"))
      return tipocuenta;
    else if (fieldName.equalsIgnoreCase("cuenta"))
      return cuenta;
    else if (fieldName.equalsIgnoreCase("referencia"))
      return referencia;
    else if (fieldName.equalsIgnoreCase("tipoidcliente"))
      return tipoidcliente;
    else if (fieldName.equalsIgnoreCase("numidcliente"))
      return numidcliente;
    else if (fieldName.equalsIgnoreCase("tercero"))
      return tercero;
    else if (fieldName.equalsIgnoreCase("code"))
      return code;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static int updateLine(ConnectionProvider connectionProvider, String status, String user_id, String description, String sdc_debitcollect_id, String referenceno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				UPDATE" +
      "					sdc_dc_propocollect" +
      "				SET" +
      "					ispaid = ?," +
      "					updatedby = ?," +
      "					updated = TO_DATE(NOW())," +
      "					description = TRIM(?)" +
      "				WHERE" +
      "					sdc_debitcollect_id = ?" +
      "					AND isreconciled = 'Y'" +
      "					AND TRIM(referenceno) = TRIM(?);";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sdc_debitcollect_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);

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

  public static int updateDetailLine(ConnectionProvider connectionProvider, String status, String user_id, String description, String sdc_debitcollect_id, String referenceno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				UPDATE" +
      "					sdc_dc_detail" +
      "				SET" +
      "					ispaid = ?," +
      "					updatedby = ?," +
      "					updated = TO_DATE(NOW())," +
      "					description = TRIM(?)" +
      "				WHERE" +
      "					sdc_debitcollect_id = ?" +
      "					AND TRIM(referenceno) = TRIM(?);";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sdc_debitcollect_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceno);

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
