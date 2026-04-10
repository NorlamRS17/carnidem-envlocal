//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.quality.assurement.ad_actionbutton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CreateFromLocatorData implements FieldProvider {
static Logger log4j = Logger.getLogger(CreateFromLocatorData.class);
  private String InitRecordNumber="0";
  public String id;
  public String name;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CreateFromLocatorData[] selectFromLoc(ConnectionProvider connectionProvider, String adLanguage, String isactive)    throws ServletException {
    return selectFromLoc(connectionProvider, adLanguage, isactive, 0, 0);
  }

  public static CreateFromLocatorData[] selectFromLoc(ConnectionProvider connectionProvider, String adLanguage, String isactive, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT ML.M_LOCATOR_ID AS ID, Ad_Column_Identifier(to_char('M_LOCATOR_ID'), to_char(ML.M_LOCATOR_ID), to_char(?)) AS NAME " +
      "        FROM M_LOCATOR ML" +
      "        WHERE ML.ISACTIVE= ?" +
      "        ORDER BY NAME";

    ResultSet result;
    Vector<CreateFromLocatorData> vector = new Vector<CreateFromLocatorData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adLanguage);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, isactive);

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
        CreateFromLocatorData objectCreateFromLocatorData = new CreateFromLocatorData();
        objectCreateFromLocatorData.id = UtilSql.getValue(result, "id");
        objectCreateFromLocatorData.name = UtilSql.getValue(result, "name");
        objectCreateFromLocatorData.rownum = Long.toString(countRecord);
        objectCreateFromLocatorData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCreateFromLocatorData);
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
    CreateFromLocatorData objectCreateFromLocatorData[] = new CreateFromLocatorData[vector.size()];
    vector.copyInto(objectCreateFromLocatorData);
    return(objectCreateFromLocatorData);
  }
}
