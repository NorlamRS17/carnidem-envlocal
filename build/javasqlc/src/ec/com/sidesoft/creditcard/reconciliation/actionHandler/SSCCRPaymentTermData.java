//Sqlc generated V1.O00-1
package ec.com.sidesoft.creditcard.reconciliation.actionHandler;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;

class SSCCRPaymentTermData implements FieldProvider {
static Logger log4j = Logger.getLogger(SSCCRPaymentTermData.class);
  private String InitRecordNumber="0";
  public String cPaymenttermId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static String paymentterm(ConnectionProvider connectionProvider, String strCardsTypesId, String strTypesOfCreditId, String strDate)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT c_paymentterm_id" +
      "      FROM ssccr_cardmatchingconf scmc" +
      "        JOIN ssccr_cardmatchingconfline scmcl ON scmcl.ssccr_cardmatchingconf_id = scmc.ssccr_cardmatchingconf_id" +
      "      WHERE scmcl.ssccr_cards_types_id = ?" +
      "      AND scmcl.ssccr_types_of_credit_id = ?" +
      "      AND TO_DATE(?,'YYYY-MM-DD') BETWEEN scmcl.from_validity AND scmcl.valid_up";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strCardsTypesId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strTypesOfCreditId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, strDate);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_paymentterm_id");
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
    return(strReturn);
  }
}
