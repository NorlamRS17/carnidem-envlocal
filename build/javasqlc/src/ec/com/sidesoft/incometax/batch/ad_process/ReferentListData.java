//Sqlc generated V1.O00-1
package ec.com.sidesoft.incometax.batch.ad_process;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class ReferentListData implements FieldProvider {
static Logger log4j = Logger.getLogger(ReferentListData.class);
  private String InitRecordNumber="0";
  public String value;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("value"))
      return value;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ReferentListData[] select(ConnectionProvider connectionProvider, String name)    throws ServletException {
    return select(connectionProvider, name, 0, 0);
  }

  public static ReferentListData[] select(ConnectionProvider connectionProvider, String name, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select rl.value as value from ad_ref_list  rl" +
      "	left join ad_ref_list_trl rlt ON rl.ad_ref_list_id=rlt.ad_ref_list_id" +
      "	where ad_reference_id  ='EAC3DD423B0E4ADDACCBBD4F8B216592' " +
      "	AND rlt.name=?";

    ResultSet result;
    Vector<ReferentListData> vector = new Vector<ReferentListData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);

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
        ReferentListData objectReferentListData = new ReferentListData();
        objectReferentListData.value = UtilSql.getValue(result, "value");
        objectReferentListData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectReferentListData);
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
    ReferentListData objectReferentListData[] = new ReferentListData[vector.size()];
    vector.copyInto(objectReferentListData);
    return(objectReferentListData);
  }
}
