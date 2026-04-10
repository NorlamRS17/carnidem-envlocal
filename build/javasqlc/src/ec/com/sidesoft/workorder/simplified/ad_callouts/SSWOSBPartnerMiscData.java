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

class SSWOSBPartnerMiscData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSWOSBPartnerMiscData.class);
  private String InitRecordNumber="0";
  public String cPaymenttermId;
  public String mPricelistId;
  public String finPaymentmethodId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SSWOSBPartnerMiscData[] select(ConnectionProvider connectionProvider, String strBPartnerId)    throws ServletException {
    return select(connectionProvider, strBPartnerId, 0, 0);
  }

  public static SSWOSBPartnerMiscData[] select(ConnectionProvider connectionProvider, String strBPartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            SELECT p.C_PaymentTerm_ID, " +
      "                   p.M_PriceList_ID,p.fin_paymentmethod_id   " +
      "            FROM C_BPartner p " +
      "            WHERE p.C_BPartner_ID=? ";

    ResultSet result;
    Vector<SSWOSBPartnerMiscData> vector = new Vector<SSWOSBPartnerMiscData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strBPartnerId);

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
        SSWOSBPartnerMiscData objectSSWOSBPartnerMiscData = new SSWOSBPartnerMiscData();
        objectSSWOSBPartnerMiscData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectSSWOSBPartnerMiscData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectSSWOSBPartnerMiscData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectSSWOSBPartnerMiscData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSSWOSBPartnerMiscData);
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
    SSWOSBPartnerMiscData objectSSWOSBPartnerMiscData[] = new SSWOSBPartnerMiscData[vector.size()];
    vector.copyInto(objectSSWOSBPartnerMiscData);
    return(objectSSWOSBPartnerMiscData);
  }
}
