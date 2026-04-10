//Sqlc generated V1.O00-1
package ec.com.sidesoft.deposit.reconciliation.ad_backgrounds;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class DepositReconciliationData implements FieldProvider {
static Logger log4j = Logger.getLogger(DepositReconciliationData.class);
  private String InitRecordNumber="0";
  public String finPaymentId;
  public String finBankstatementlineId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("fin_payment_id") || fieldName.equals("finPaymentId"))
      return finPaymentId;
    else if (fieldName.equalsIgnoreCase("fin_bankstatementline_id") || fieldName.equals("finBankstatementlineId"))
      return finBankstatementlineId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DepositReconciliationData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DepositReconciliationData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT fin_payment_id,fin_bankstatementline_id " +
      "	FROM fin_payment p" +
      "	JOIN fin_bankstatementline bl on p.referenceno = COALESCE(bl.em_ssdr_referenceno,bl.referenceno) " +
      "	WHERE p.status = 'RPAE' " +
      "	AND bl.em_ssdr_fin_payment_id is null " +
      "	AND TO_DATE(bl.datetrx) = TO_DATE(p.paymentdate)" +
      "	AND COALESCE(bl.cramount,0) = COALESCE(p.amount,0)" +
      "	ORDER BY p.paymentdate,p.referenceno,p.documentno";

    ResultSet result;
    Vector<DepositReconciliationData> vector = new Vector<DepositReconciliationData>(0);
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
        DepositReconciliationData objectDepositReconciliationData = new DepositReconciliationData();
        objectDepositReconciliationData.finPaymentId = UtilSql.getValue(result, "fin_payment_id");
        objectDepositReconciliationData.finBankstatementlineId = UtilSql.getValue(result, "fin_bankstatementline_id");
        objectDepositReconciliationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDepositReconciliationData);
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
    DepositReconciliationData objectDepositReconciliationData[] = new DepositReconciliationData[vector.size()];
    vector.copyInto(objectDepositReconciliationData);
    return(objectDepositReconciliationData);
  }
}
