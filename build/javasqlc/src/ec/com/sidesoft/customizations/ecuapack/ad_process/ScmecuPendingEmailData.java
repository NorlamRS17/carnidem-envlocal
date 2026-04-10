//Sqlc generated V1.O00-1
package ec.com.sidesoft.customizations.ecuapack.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class ScmecuPendingEmailData implements FieldProvider {
static Logger log4j = Logger.getLogger(ScmecuPendingEmailData.class);
  private String InitRecordNumber="0";
  public String id;
  public String documentNo;
  public String opportunityName;
  public String salesStage;
  public String email;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("document_no") || fieldName.equals("documentNo"))
      return documentNo;
    else if (fieldName.equalsIgnoreCase("opportunity_name") || fieldName.equals("opportunityName"))
      return opportunityName;
    else if (fieldName.equalsIgnoreCase("sales_stage") || fieldName.equals("salesStage"))
      return salesStage;
    else if (fieldName.equalsIgnoreCase("email"))
      return email;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ScmecuPendingEmailData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ScmecuPendingEmailData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				SELECT oel.scmecu_oppor_email_log_id id" +
      "					, o.em_scmecu_documentno document_no" +
      "					, o.opportunity_name" +
      "					, rl.name sales_stage" +
      "					, TRIM(COALESCE(u.email,'')) email" +
      "				FROM scmecu_oppor_email_log oel" +
      "				    JOIN opcrm_opportunities o ON o.opcrm_opportunities_id = oel.opcrm_opportunities_id" +
      "				    JOIN scmecu_probability_stage ps ON ps.sales_stage = oel.current_sales_stage" +
      "				    JOIN ad_user u ON u.ad_user_id = ps.ad_user_id" +
      "				    JOIN ad_ref_list_v rl ON rl.ad_reference_id = '8AEE970AF96B4F35BB80D53205A3BBCF'" +
      "				    	AND ad_language = 'es_ES'" +
      "        				AND rl.value = oel.current_sales_stage" +
      "				WHERE oel.is_email_sent = 'N'" +
      "				ORDER BY oel.created";

    ResultSet result;
    Vector<ScmecuPendingEmailData> vector = new Vector<ScmecuPendingEmailData>(0);
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
        ScmecuPendingEmailData objectScmecuPendingEmailData = new ScmecuPendingEmailData();
        objectScmecuPendingEmailData.id = UtilSql.getValue(result, "id");
        objectScmecuPendingEmailData.documentNo = UtilSql.getValue(result, "document_no");
        objectScmecuPendingEmailData.opportunityName = UtilSql.getValue(result, "opportunity_name");
        objectScmecuPendingEmailData.salesStage = UtilSql.getValue(result, "sales_stage");
        objectScmecuPendingEmailData.email = UtilSql.getValue(result, "email");
        objectScmecuPendingEmailData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectScmecuPendingEmailData);
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
    ScmecuPendingEmailData objectScmecuPendingEmailData[] = new ScmecuPendingEmailData[vector.size()];
    vector.copyInto(objectScmecuPendingEmailData);
    return(objectScmecuPendingEmailData);
  }

  public static int update(ConnectionProvider connectionProvider, String isEmailSent, String result, String id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "				UPDATE scmecu_oppor_email_log SET is_email_sent = ?," +
      "					result = ?, updated = NOW()" +
      "				WHERE scmecu_oppor_email_log_id = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isEmailSent);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, result);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

      SessionInfo.saveContextInfoIntoDB(connectionProvider.getConnection());
      updateCount = st.executeUpdate();
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
    return(updateCount);
  }
}
