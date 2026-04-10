//Sqlc generated V1.O00-1
package ec.com.sidesoft.production.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProductStockData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductStockData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String mLocatorId;
  public String mAttributesetinstanceId;
  public String lot;
  public String guaranteedate;
  public String description;
  public String stock;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("lot"))
      return lot;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("stock"))
      return stock;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductStockData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ProductStockData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' as M_PRODUCT_ID, '' as M_LOCATOR_ID, '' AS M_ATTRIBUTESETINSTANCE_ID" +
      "        ,'' as LOT, '' as GUARANTEEDATE, '' as DESCRIPTION, 0 AS STOCK" +
      "        FROM DUAL";

    ResultSet result;
    Vector<ProductStockData> vector = new Vector<ProductStockData>(0);
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
        ProductStockData objectProductStockData = new ProductStockData();
        objectProductStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductStockData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductStockData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductStockData.lot = UtilSql.getValue(result, "lot");
        objectProductStockData.guaranteedate = UtilSql.getValue(result, "guaranteedate");
        objectProductStockData.description = UtilSql.getValue(result, "description");
        objectProductStockData.stock = UtilSql.getValue(result, "stock");
        objectProductStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductStockData);
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
    ProductStockData objectProductStockData[] = new ProductStockData[vector.size()];
    vector.copyInto(objectProductStockData);
    return(objectProductStockData);
  }

  public static ProductStockData[] selectproduct(ConnectionProvider connectionProvider, String productId, String locatorId)    throws ServletException {
    return selectproduct(connectionProvider, productId, locatorId, 0, 0);
  }

  public static ProductStockData[] selectproduct(ConnectionProvider connectionProvider, String productId, String locatorId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select " +
      "		mp.m_product_id, msd.m_locator_id" +
      "		, mas.m_attributesetinstance_id" +
      "		, mas.lot,  mas.guaranteedate ,  mas.description" +
      "		,CASE WHEN c.PricePrecision is not null THEN  round(msd.qtyonhand , c.PricePrecision) ELSE msd.qtyonhand END as stock" +
      "		from m_storage_detail msd" +
      "		left join m_attributesetinstance mas on mas.m_attributesetinstance_id = msd.m_attributesetinstance_id" +
      "		join m_product mp on mp.m_product_id = msd.m_product_id" +
      "		join ad_org o on o.ad_org_id = mp.ad_org_id" +
      "	        join c_currency c on c.ad_org_id = c.ad_org_id	" +
      "		where msd.m_product_id = ?" +
      "		and msd.m_locator_id = ?" +
      "		and c.c_currency_id = o.c_currency_id";

    ResultSet result;
    Vector<ProductStockData> vector = new Vector<ProductStockData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, locatorId);

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
        ProductStockData objectProductStockData = new ProductStockData();
        objectProductStockData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductStockData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductStockData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductStockData.lot = UtilSql.getValue(result, "lot");
        objectProductStockData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectProductStockData.description = UtilSql.getValue(result, "description");
        objectProductStockData.stock = UtilSql.getValue(result, "stock");
        objectProductStockData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductStockData);
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
    ProductStockData objectProductStockData[] = new ProductStockData[vector.size()];
    vector.copyInto(objectProductStockData);
    return(objectProductStockData);
  }
}
