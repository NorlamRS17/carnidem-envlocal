//Sqlc generated V1.O00-1
package ec.com.sidesoft.workorder.simplified.ad_callouts;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class SSWOSProductIDData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSWOSProductIDData.class);
  private String InitRecordNumber="0";
  public String pricelist;
  public String cTaxId;
  public String pricestd;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("c_tax_id") || fieldName.equals("cTaxId"))
      return cTaxId;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSWOSProductIDData[] select(ConnectionProvider connectionProvider, String strMProductId, String strMPricelistId)    throws ServletException {
    return select(connectionProvider, strMProductId, strMPricelistId, 0, 0);
  }

  public static SSWOSProductIDData[] select(ConnectionProvider connectionProvider, String strMProductId, String strMPricelistId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select mpp.pricelist, ct.c_tax_id, mpp.pricestd	" +
      "			from m_productprice as mpp " +
      "			join m_product as mp on (mpp.m_product_id = mp.m_product_id) " +
      "			join c_tax as ct on (mp.c_taxcategory_id = ct.c_taxcategory_id)" +
      "			where mpp.m_product_id = ?" +
      "			and mpp.m_pricelist_version_id in (select m_pricelist_version_id " +
      "											from m_pricelist_version " +
      "											where m_pricelist_id = ?" +
      "											order by validfrom desc limit 1)";

    ResultSet result;
    Vector<SSWOSProductIDData> vector = new Vector<SSWOSProductIDData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strMProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strMPricelistId);

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
        SSWOSProductIDData objectSSWOSProductIDData = new SSWOSProductIDData();
        objectSSWOSProductIDData.pricelist = UtilSql.getValue(result, "pricelist");
        objectSSWOSProductIDData.cTaxId = UtilSql.getValue(result, "c_tax_id");
        objectSSWOSProductIDData.pricestd = UtilSql.getValue(result, "pricestd");
        objectSSWOSProductIDData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSWOSProductIDData);
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
    SSWOSProductIDData objectSSWOSProductIDData[] = new SSWOSProductIDData[vector.size()];
    vector.copyInto(objectSSWOSProductIDData);
    return(objectSSWOSProductIDData);
  }
}
