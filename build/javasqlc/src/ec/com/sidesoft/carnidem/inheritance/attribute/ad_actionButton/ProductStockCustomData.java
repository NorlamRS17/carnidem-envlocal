//Sqlc generated V1.O00-1
package ec.com.sidesoft.carnidem.inheritance.attribute.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProductStockCustomData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductStockCustomData.class);
  private String InitRecordNumber="0";
  public String mProductId;
  public String mLocatorId;
  public String mAttributesetinstanceId;
  public String lot;
  public String guaranteedate;
  public String description;
  public String stock;
  public String emCsljDatejulian;

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
    else if (fieldName.equalsIgnoreCase("em_cslj_datejulian") || fieldName.equals("emCsljDatejulian"))
      return emCsljDatejulian;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductStockCustomData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ProductStockCustomData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' as M_PRODUCT_ID, '' as M_LOCATOR_ID, '' AS M_ATTRIBUTESETINSTANCE_ID" +
      "        ,'' as LOT, '' as GUARANTEEDATE, '' as DESCRIPTION, 0 AS STOCK,'' AS EM_CSLJ_DATEJULIAN" +
      "        FROM DUAL";

    ResultSet result;
    Vector<ProductStockCustomData> vector = new Vector<ProductStockCustomData>(0);
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
        ProductStockCustomData objectProductStockCustomData = new ProductStockCustomData();
        objectProductStockCustomData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductStockCustomData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductStockCustomData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductStockCustomData.lot = UtilSql.getValue(result, "lot");
        objectProductStockCustomData.guaranteedate = UtilSql.getValue(result, "guaranteedate");
        objectProductStockCustomData.description = UtilSql.getValue(result, "description");
        objectProductStockCustomData.stock = UtilSql.getValue(result, "stock");
        objectProductStockCustomData.emCsljDatejulian = UtilSql.getValue(result, "em_cslj_datejulian");
        objectProductStockCustomData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductStockCustomData);
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
    ProductStockCustomData objectProductStockCustomData[] = new ProductStockCustomData[vector.size()];
    vector.copyInto(objectProductStockCustomData);
    return(objectProductStockCustomData);
  }

  public static ProductStockCustomData[] selectproduct(ConnectionProvider connectionProvider, String productId, String locatorId)    throws ServletException {
    return selectproduct(connectionProvider, productId, locatorId, 0, 0);
  }

  public static ProductStockCustomData[] selectproduct(ConnectionProvider connectionProvider, String productId, String locatorId, int firstRegister, int numberRegisters)    throws ServletException {
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
    Vector<ProductStockCustomData> vector = new Vector<ProductStockCustomData>(0);
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
        ProductStockCustomData objectProductStockCustomData = new ProductStockCustomData();
        objectProductStockCustomData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductStockCustomData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductStockCustomData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductStockCustomData.lot = UtilSql.getValue(result, "lot");
        objectProductStockCustomData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectProductStockCustomData.description = UtilSql.getValue(result, "description");
        objectProductStockCustomData.stock = UtilSql.getValue(result, "stock");
        objectProductStockCustomData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductStockCustomData);
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
    ProductStockCustomData objectProductStockCustomData[] = new ProductStockCustomData[vector.size()];
    vector.copyInto(objectProductStockCustomData);
    return(objectProductStockCustomData);
  }

  public static ProductStockCustomData[] attributehered(ConnectionProvider connectionProvider, String productionplanId)    throws ServletException {
    return attributehered(connectionProvider, productionplanId, 0, 0);
  }

  public static ProductStockCustomData[] attributehered(ConnectionProvider connectionProvider, String productionplanId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		SELECT " +
      "    		mat.em_cslj_datejulian" +
      "		FROM M_ProductionPlan mpp " +
      "		JOIN MA_Wrphase mpw " +
      "		    ON mpw.MA_Wrphase_ID = mpp.MA_Wrphase_ID " +
      "		JOIN MA_WorkRequirement mwk " +
      "		    ON mwk.MA_WorkRequirement_ID = mpw.MA_WorkRequirement_ID " +
      "		JOIN MA_ProcessPlan mpcp " +
      "		    ON mpcp.MA_ProcessPlan_ID = mwk.MA_ProcessPlan_ID " +
      "		JOIN MA_ProcessPlan_Version mppv " +
      "		    ON mppv.MA_ProcessPlan_ID = mpcp.MA_ProcessPlan_ID " +
      "		JOIN MA_Sequence ma " +
      "		    ON ma.MA_ProcessPlan_Version_ID = mppv.MA_ProcessPlan_Version_ID " +
      "		JOIN MA_SequenceProduct msp " +
      "		    ON msp.MA_Sequence_ID = ma.MA_Sequence_ID " +
      "		JOIN MA_SequenceProductAtt mspa " +
      "		    ON mspa.MA_SequenceProduct_ID = msp.MA_SequenceProduct_ID " +
      "		JOIN MA_SequenceProduct msp_hered " +
      "		    ON mspa.MA_SequenceProductFrom_ID = msp_hered.MA_SequenceProduct_ID " +
      "		JOIN M_Product mp " +
      "		    ON mp.M_Product_ID = msp_hered.M_Product_ID " +
      "		JOIN ( " +
      "		    SELECT DISTINCT ON (m_product_id) " +
      "		    m_storage_detail_id, " +
      "		    m_product_id, " +
      "		    created,m_attributesetinstance_id " +
      "		    FROM m_storage_detail " +
      "		    where QtyOnHand<>0 " +
      "		    ORDER BY m_product_id, created DESC " +
      "		) msd ON msd.m_product_id = mp.m_product_id " +
      "		join m_attributesetinstance mat on mat.m_attributesetinstance_id=msd.m_attributesetinstance_id " +
      "		WHERE mpp.M_ProductionPlan_ID = ?  and mspa.Isspecialatt='Y' AND mspa.isspecialatt = 'Y' " +
      "		AND msp.productiontype = '+' ";

    ResultSet result;
    Vector<ProductStockCustomData> vector = new Vector<ProductStockCustomData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productionplanId);

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
        ProductStockCustomData objectProductStockCustomData = new ProductStockCustomData();
        objectProductStockCustomData.emCsljDatejulian = UtilSql.getValue(result, "em_cslj_datejulian");
        objectProductStockCustomData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductStockCustomData);
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
    ProductStockCustomData objectProductStockCustomData[] = new ProductStockCustomData[vector.size()];
    vector.copyInto(objectProductStockCustomData);
    return(objectProductStockCustomData);
  }
}
