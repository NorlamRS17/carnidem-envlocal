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

public class UpdatePriceWoData implements FieldProvider {
static Logger log4j = Logger.getLogger(UpdatePriceWoData.class);
  private String InitRecordNumber="0";
  public String linea;
  public String preciotarifa;
  public String preciounitario;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("linea"))
      return linea;
    else if (fieldName.equalsIgnoreCase("preciotarifa"))
      return preciotarifa;
    else if (fieldName.equalsIgnoreCase("preciounitario"))
      return preciounitario;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static UpdatePriceWoData[] linesWorkOrder(ConnectionProvider connectionProvider, String bpartner, String documentno)    throws ServletException {
    return linesWorkOrder(connectionProvider, bpartner, documentno, 0, 0);
  }

  public static UpdatePriceWoData[] linesWorkOrder(ConnectionProvider connectionProvider, String bpartner, String documentno, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT pvl.atindpo_postventalinea_id as linea" +
      "          , coalesce(pp.pricelist,0) as preciotarifa" +
      "          , coalesce(round(pp.pricelist - (pp.pricelist * coalesce(atindpo_discount,0)/100),4),0) as preciounitario" +
      "          FROM atindpo_postventa pv" +
      "          Join c_bpartner bp on bp.c_bpartner_id = pv.c_bpartner_id" +
      "          Join atindpo_postventalinea pvl on pvl.atindpo_postventa_id = pv.atindpo_postventa_id" +
      "          Join m_product p on p.m_product_id = pvl.m_product_id" +
      "          left Join  m_pricelist_version plv on " +
      "           plv.m_pricelist_id = bp.m_pricelist_id" +
      "          left Join m_productprice pp on pp.m_product_id = p.m_product_id " +
      "          AND pp.m_pricelist_version_id=plv.m_pricelist_version_id" +
      "          WHERE pv.c_bpartner_id = ? AND pv.documentno =?" +
      "          AND plv.m_pricelist_version_id =  m_get_pricelist_version(bp.m_pricelist_id,now()::date) ";

    ResultSet result;
    Vector<UpdatePriceWoData> vector = new Vector<UpdatePriceWoData>(0);
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
        UpdatePriceWoData objectUpdatePriceWoData = new UpdatePriceWoData();
        objectUpdatePriceWoData.linea = UtilSql.getValue(result, "linea");
        objectUpdatePriceWoData.preciotarifa = UtilSql.getValue(result, "preciotarifa");
        objectUpdatePriceWoData.preciounitario = UtilSql.getValue(result, "preciounitario");
        objectUpdatePriceWoData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectUpdatePriceWoData);
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
    UpdatePriceWoData objectUpdatePriceWoData[] = new UpdatePriceWoData[vector.size()];
    vector.copyInto(objectUpdatePriceWoData);
    return(objectUpdatePriceWoData);
  }

  public static int updateLinesWorkOrder(ConnectionProvider connectionProvider, String preciounitario, String preciotarifa, String punitario, String linea)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "          UPDATE atindpo_postventalinea set " +
      "            atindpo_unitprice = ? ::numeric" +
      "            ,Atindpo_Pricelist = ? ::numeric" +
      "            ,atindpo_linenetamt = cantidad * ? ::numeric" +
      "            ,updated=TO_DATE(NOW())" +
      "          WHERE atindpo_postventalinea_id = ?;";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preciounitario);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preciotarifa);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, punitario);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linea);

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
