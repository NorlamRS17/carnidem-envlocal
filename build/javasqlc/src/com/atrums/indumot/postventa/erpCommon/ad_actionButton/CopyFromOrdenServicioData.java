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

class CopyFromOrdenServicioData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromOrdenServicioData.class);
  private String InitRecordNumber="0";
  public String atindpoPostventaId;
  public String docnoordersrv;
  public String fechaordersvr;
  public String line;
  public String producto;
  public String description;
  public String unidad;
  public String cantidad;
  public String docnoguia;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("atindpo_postventa_id") || fieldName.equals("atindpoPostventaId"))
      return atindpoPostventaId;
    else if (fieldName.equalsIgnoreCase("docnoordersrv"))
      return docnoordersrv;
    else if (fieldName.equalsIgnoreCase("fechaordersvr"))
      return fechaordersvr;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("producto"))
      return producto;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("unidad"))
      return unidad;
    else if (fieldName.equalsIgnoreCase("cantidad"))
      return cantidad;
    else if (fieldName.equalsIgnoreCase("docnoguia"))
      return docnoguia;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromOrdenServicioData[] select(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return select(connectionProvider, cBpartnerId, 0, 0);
  }

  public static CopyFromOrdenServicioData[] select(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select pv.atindpo_postventa_id," +
      "                   pv.documentno as docnoOrderSrv, " +
      "                   pv.fechaventa as fechaOrdersvr," +
      "                   pvl.line, " +
      "                   p.name as producto, " +
      "                   a.description," +
      "                   u.name as unidad, " +
      "                   pvl.cantidad, " +
      "                   io.documentno as docnoGuia" +
      "            from atindpo_postventa pv" +
      "            left join atindpo_postventalinea pvl on pv.atindpo_postventa_id = pvl.atindpo_postventa_id" +
      "            left join m_product p on pvl.m_product_id = p.m_product_id" +
      "            left join c_uom u on p.c_uom_id = u.c_uom_id" +
      "            left join m_inoutline iol on iol.m_inoutline_id = iol.m_inoutline_id" +
      "            left join m_inout io on iol.m_inout_id = io.m_inout_id" +
      "            left join m_attributesetinstance a on pvl.m_attributesetinstance_id = a.m_attributesetinstance_id" +
      "            where pv.docstatus in ('TL','ET')" +
      "            and pv.c_bpartner_id = ?" +
      "            order by 1, 2, 3";

    ResultSet result;
    Vector<CopyFromOrdenServicioData> vector = new Vector<CopyFromOrdenServicioData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        CopyFromOrdenServicioData objectCopyFromOrdenServicioData = new CopyFromOrdenServicioData();
        objectCopyFromOrdenServicioData.atindpoPostventaId = UtilSql.getValue(result, "atindpo_postventa_id");
        objectCopyFromOrdenServicioData.docnoordersrv = UtilSql.getValue(result, "docnoordersrv");
        objectCopyFromOrdenServicioData.fechaordersvr = UtilSql.getDateValue(result, "fechaordersvr", "dd-MM-yyyy");
        objectCopyFromOrdenServicioData.line = UtilSql.getValue(result, "line");
        objectCopyFromOrdenServicioData.producto = UtilSql.getValue(result, "producto");
        objectCopyFromOrdenServicioData.description = UtilSql.getValue(result, "description");
        objectCopyFromOrdenServicioData.unidad = UtilSql.getValue(result, "unidad");
        objectCopyFromOrdenServicioData.cantidad = UtilSql.getValue(result, "cantidad");
        objectCopyFromOrdenServicioData.docnoguia = UtilSql.getValue(result, "docnoguia");
        objectCopyFromOrdenServicioData.rownum = Long.toString(countRecord);
        objectCopyFromOrdenServicioData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromOrdenServicioData);
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
    CopyFromOrdenServicioData objectCopyFromOrdenServicioData[] = new CopyFromOrdenServicioData[vector.size()];
    vector.copyInto(objectCopyFromOrdenServicioData);
    return(objectCopyFromOrdenServicioData);
  }

  public static CopyFromOrdenServicioData[] set()    throws ServletException {
    CopyFromOrdenServicioData objectCopyFromOrdenServicioData[] = new CopyFromOrdenServicioData[1];
    objectCopyFromOrdenServicioData[0] = new CopyFromOrdenServicioData();
    objectCopyFromOrdenServicioData[0].atindpoPostventaId = "";
    objectCopyFromOrdenServicioData[0].docnoordersrv = "";
    objectCopyFromOrdenServicioData[0].fechaordersvr = "";
    objectCopyFromOrdenServicioData[0].line = "";
    objectCopyFromOrdenServicioData[0].producto = "";
    objectCopyFromOrdenServicioData[0].description = "";
    objectCopyFromOrdenServicioData[0].unidad = "";
    objectCopyFromOrdenServicioData[0].cantidad = "";
    objectCopyFromOrdenServicioData[0].docnoguia = "";
    return objectCopyFromOrdenServicioData;
  }
}
