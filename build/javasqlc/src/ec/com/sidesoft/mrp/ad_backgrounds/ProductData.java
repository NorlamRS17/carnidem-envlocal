//Sqlc generated V1.O00-1
package ec.com.sidesoft.mrp.ad_backgrounds;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ProductData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductData.class);
  private String InitRecordNumber="0";
  public String id;
  public String key;
  public String name;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("key"))
      return key;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductData[] select(ConnectionProvider connectionProvider, String category)    throws ServletException {
    return select(connectionProvider, category, 0, 0);
  }

  public static ProductData[] select(ConnectionProvider connectionProvider, String category, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT p.m_product_id as id,trim(value) as key, trim(name) as name " +
      "    FROM m_product p" +
      "    JOIN (SELECT m_product_id" +
      "    FROM m_transaction" +
      "    GROUP BY m_product_id) t on p.m_product_id=t.m_product_id" +
      "    WHERE isactive ='Y' " +
      "    AND m_product_category_id = ? " +
      "    AND producttype <> 'S' ";

    ResultSet result;
    Vector<ProductData> vector = new Vector<ProductData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, category);

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
        ProductData objectProductData = new ProductData();
        objectProductData.id = UtilSql.getValue(result, "id");
        objectProductData.key = UtilSql.getValue(result, "key");
        objectProductData.name = UtilSql.getValue(result, "name");
        objectProductData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductData);
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
    ProductData objectProductData[] = new ProductData[vector.size()];
    vector.copyInto(objectProductData);
    return(objectProductData);
  }
}
