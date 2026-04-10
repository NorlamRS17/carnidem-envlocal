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

class ProductHistoryData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductHistoryData.class);
  private String InitRecordNumber="0";
  public String id;
  public String key;
  public String qty;
  public String date;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("key"))
      return key;
    else if (fieldName.equalsIgnoreCase("qty"))
      return qty;
    else if (fieldName.equalsIgnoreCase("date"))
      return date;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductHistoryData[] select(ConnectionProvider connectionProvider, String category, String allorg, String org)    throws ServletException {
    return select(connectionProvider, category, allorg, org, 0, 0);
  }

  public static ProductHistoryData[] select(ConnectionProvider connectionProvider, String category, String allorg, String org, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT p.m_product_id as id,trim(p.value) as key, SUM(movementqty) as qty," +
      "    to_char(movementdate,'dd/MM/yyyy') as date" +
      "    FROM m_transaction t " +
      "    JOIN m_product p on t.m_product_id=p.m_product_id  " +
      "    WHERE p.m_product_category_id = ?   " +
      "    AND CASE WHEN ? ='Y' THEN 1=1 ELSE t.ad_org_id = ? END  " +
      "    GROUP BY p.m_product_id,4 " +
      "    HAVING SUM(movementqty) > 0";

    ResultSet result;
    Vector<ProductHistoryData> vector = new Vector<ProductHistoryData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, category);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, allorg);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);

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
        ProductHistoryData objectProductHistoryData = new ProductHistoryData();
        objectProductHistoryData.id = UtilSql.getValue(result, "id");
        objectProductHistoryData.key = UtilSql.getValue(result, "key");
        objectProductHistoryData.qty = UtilSql.getValue(result, "qty");
        objectProductHistoryData.date = UtilSql.getValue(result, "date");
        objectProductHistoryData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductHistoryData);
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
    ProductHistoryData objectProductHistoryData[] = new ProductHistoryData[vector.size()];
    vector.copyInto(objectProductHistoryData);
    return(objectProductHistoryData);
  }
}
