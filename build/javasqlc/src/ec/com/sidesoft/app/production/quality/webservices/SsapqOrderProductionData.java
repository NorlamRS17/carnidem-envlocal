//Sqlc generated V1.O00-1
package ec.com.sidesoft.app.production.quality.webservices;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

public class SsapqOrderProductionData implements FieldProvider {
static Logger log4j = Logger.getLogger(SsapqOrderProductionData.class);
  private String InitRecordNumber="0";
  public String maWrphaseId;
  public String nameOrd;
  public String adOrgId;
  public String orgName;
  public String secondaryunit;
  public String quantity;
  public String conversionrate;
  public String closed;
  public String versionCc;
  public String versionCcId;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ma_wrphase_id") || fieldName.equals("maWrphaseId"))
      return maWrphaseId;
    else if (fieldName.equalsIgnoreCase("name_ord") || fieldName.equals("nameOrd"))
      return nameOrd;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("org_name") || fieldName.equals("orgName"))
      return orgName;
    else if (fieldName.equalsIgnoreCase("secondaryunit"))
      return secondaryunit;
    else if (fieldName.equalsIgnoreCase("quantity"))
      return quantity;
    else if (fieldName.equalsIgnoreCase("conversionrate"))
      return conversionrate;
    else if (fieldName.equalsIgnoreCase("closed"))
      return closed;
    else if (fieldName.equalsIgnoreCase("version_cc") || fieldName.equals("versionCc"))
      return versionCc;
    else if (fieldName.equalsIgnoreCase("version_cc_id") || fieldName.equals("versionCcId"))
      return versionCcId;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static SsapqOrderProductionData[] allOrganization(ConnectionProvider connectionProvider, String orgid)    throws ServletException {
    return allOrganization(connectionProvider, orgid, 0, 0);
  }

  public static SsapqOrderProductionData[] allOrganization(ConnectionProvider connectionProvider, String orgid, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT" +
      "	    wp.ma_wrphase_id," +
      "	    wr.documentno || '-' || TO_CHAR(wr.launchdate, 'DD/MM/YYYY') || '-' || wp.seqno || '-' || ms.name AS name_ord," +
      "	    wp.ad_org_id," +
      "	    org.name AS org_name," +
      "	    wr.Secondaryunit," +
      "	    wp.Quantity-wp.Donequantity AS Quantity," +
      "	    wr.Conversionrate," +
      "		wr.closed," +
      "	    mcv.documentno || '-' || mc.name || '-' || TO_CHAR(mcv.ValidFrom, 'DD/MM/YYYY') AS version_cc," +
      "	    mcv.MA_Costcenter_Version_id AS version_cc_id" +
      "	FROM" +
      "	    ma_workrequirement wr" +
      "	    JOIN ma_wrphase wp ON wr.ma_workrequirement_id = wp.ma_workrequirement_id" +
      "	    JOIN MA_Sequence ms ON ms.MA_Sequence_ID = wp.MA_Sequence_ID" +
      "	    JOIN ad_org org ON org.ad_org_id = wp.ad_org_id" +
      "	    JOIN MA_Process mp ON mp.MA_Process_ID = wp.MA_Process_ID" +
      "	    JOIN MA_Costcenter mc ON mc.MA_Costcenter_ID = mp.MA_Costcenter_ID" +
      "	    JOIN MA_Costcenter_Version mcv ON mcv.MA_Costcenter_ID = mc.MA_Costcenter_ID" +
      "	WHERE" +
      "	    wp.closed = 'N' AND" +
      "		wr.closed = 'N' AND" +
      "	    wp.ad_org_id = ?" +
      "	ORDER BY" +
      "	    wr.documentno";

    ResultSet result;
    Vector<SsapqOrderProductionData> vector = new Vector<SsapqOrderProductionData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orgid);

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
        SsapqOrderProductionData objectSsapqOrderProductionData = new SsapqOrderProductionData();
        objectSsapqOrderProductionData.maWrphaseId = UtilSql.getValue(result, "ma_wrphase_id");
        objectSsapqOrderProductionData.nameOrd = UtilSql.getValue(result, "name_ord");
        objectSsapqOrderProductionData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectSsapqOrderProductionData.orgName = UtilSql.getValue(result, "org_name");
        objectSsapqOrderProductionData.secondaryunit = UtilSql.getValue(result, "secondaryunit");
        objectSsapqOrderProductionData.quantity = UtilSql.getValue(result, "quantity");
        objectSsapqOrderProductionData.conversionrate = UtilSql.getValue(result, "conversionrate");
        objectSsapqOrderProductionData.closed = UtilSql.getValue(result, "closed");
        objectSsapqOrderProductionData.versionCc = UtilSql.getValue(result, "version_cc");
        objectSsapqOrderProductionData.versionCcId = UtilSql.getValue(result, "version_cc_id");
        objectSsapqOrderProductionData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectSsapqOrderProductionData);
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
    SsapqOrderProductionData objectSsapqOrderProductionData[] = new SsapqOrderProductionData[vector.size()];
    vector.copyInto(objectSsapqOrderProductionData);
    return(objectSsapqOrderProductionData);
  }
}
