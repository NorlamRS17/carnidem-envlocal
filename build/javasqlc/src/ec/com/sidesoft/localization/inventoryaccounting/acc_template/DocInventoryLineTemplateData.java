//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.inventoryaccounting.acc_template;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocInventoryLineTemplateData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocInventoryLineTemplateData.class);
  private String InitRecordNumber="0";
  public String adOrgId;
  public String mProductId;
  public String line;
  public String description;
  public String cUomId;
  public String mInventorylineId;
  public String qtybook;
  public String qtycount;
  public String mLocatorId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("m_inventoryline_id") || fieldName.equals("mInventorylineId"))
      return mInventorylineId;
    else if (fieldName.equalsIgnoreCase("qtybook"))
      return qtybook;
    else if (fieldName.equalsIgnoreCase("qtycount"))
      return qtycount;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocInventoryLineTemplateData[] select(ConnectionProvider connectionProvider, String M_Inventory_ID)    throws ServletException {
    return select(connectionProvider, M_Inventory_ID, 0, 0);
  }

  public static DocInventoryLineTemplateData[] select(ConnectionProvider connectionProvider, String M_Inventory_ID, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	  SELECT IL.AD_ORG_ID, IL.M_PRODUCT_ID, IL.LINE, IL.DESCRIPTION," +
      "	  IL.C_UOM_ID, IL.M_INVENTORYLINE_ID, IL.QTYBOOK, IL.QTYCOUNT," +
      "	  IL.M_LOCATOR_ID FROM M_InventoryLine IL " +
      "	  WHERE M_Inventory_ID=?  " +
      "	  ORDER BY Line";

    ResultSet result;
    Vector<DocInventoryLineTemplateData> vector = new Vector<DocInventoryLineTemplateData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, M_Inventory_ID);

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
        DocInventoryLineTemplateData objectDocInventoryLineTemplateData = new DocInventoryLineTemplateData();
        objectDocInventoryLineTemplateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocInventoryLineTemplateData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectDocInventoryLineTemplateData.line = UtilSql.getValue(result, "line");
        objectDocInventoryLineTemplateData.description = UtilSql.getValue(result, "description");
        objectDocInventoryLineTemplateData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectDocInventoryLineTemplateData.mInventorylineId = UtilSql.getValue(result, "m_inventoryline_id");
        objectDocInventoryLineTemplateData.qtybook = UtilSql.getValue(result, "qtybook");
        objectDocInventoryLineTemplateData.qtycount = UtilSql.getValue(result, "qtycount");
        objectDocInventoryLineTemplateData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectDocInventoryLineTemplateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInventoryLineTemplateData);
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
    DocInventoryLineTemplateData objectDocInventoryLineTemplateData[] = new DocInventoryLineTemplateData[vector.size()];
    vector.copyInto(objectDocInventoryLineTemplateData);
    return(objectDocInventoryLineTemplateData);
  }
}
