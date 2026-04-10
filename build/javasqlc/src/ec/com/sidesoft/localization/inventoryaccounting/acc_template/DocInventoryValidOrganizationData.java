//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.inventoryaccounting.acc_template;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocInventoryValidOrganizationData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocInventoryValidOrganizationData.class);
  private String InitRecordNumber="0";
  public String pInvacctId;
  public String contarreg;
  public String seqno;
  public String padreid;
  public String orgpadre;
  public String hijoid;
  public String orghijo;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("p_invacct_id") || fieldName.equals("pInvacctId"))
      return pInvacctId;
    else if (fieldName.equalsIgnoreCase("contarreg"))
      return contarreg;
    else if (fieldName.equalsIgnoreCase("seqno"))
      return seqno;
    else if (fieldName.equalsIgnoreCase("padreid"))
      return padreid;
    else if (fieldName.equalsIgnoreCase("orgpadre"))
      return orgpadre;
    else if (fieldName.equalsIgnoreCase("hijoid"))
      return hijoid;
    else if (fieldName.equalsIgnoreCase("orghijo"))
      return orghijo;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocInventoryValidOrganizationData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocInventoryValidOrganizationData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' as P_INVACCT_ID, 0 as CONTARREG, '' as SEQNO, '' AS PADREID" +
      "        ,'' as ORGPADRE, '' as HIJOID, '' as ORGHIJO" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocInventoryValidOrganizationData> vector = new Vector<DocInventoryValidOrganizationData>(0);
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
        DocInventoryValidOrganizationData objectDocInventoryValidOrganizationData = new DocInventoryValidOrganizationData();
        objectDocInventoryValidOrganizationData.pInvacctId = UtilSql.getValue(result, "p_invacct_id");
        objectDocInventoryValidOrganizationData.contarreg = UtilSql.getValue(result, "contarreg");
        objectDocInventoryValidOrganizationData.seqno = UtilSql.getValue(result, "seqno");
        objectDocInventoryValidOrganizationData.padreid = UtilSql.getValue(result, "padreid");
        objectDocInventoryValidOrganizationData.orgpadre = UtilSql.getValue(result, "orgpadre");
        objectDocInventoryValidOrganizationData.hijoid = UtilSql.getValue(result, "hijoid");
        objectDocInventoryValidOrganizationData.orghijo = UtilSql.getValue(result, "orghijo");
        objectDocInventoryValidOrganizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInventoryValidOrganizationData);
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
    DocInventoryValidOrganizationData objectDocInventoryValidOrganizationData[] = new DocInventoryValidOrganizationData[vector.size()];
    vector.copyInto(objectDocInventoryValidOrganizationData);
    return(objectDocInventoryValidOrganizationData);
  }

  public static String selectAccount1(ConnectionProvider connectionProvider, String organizationId, String doctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT  " +
      "	SPL.P_INVACCT_ID  " +
      "	FROM SLIA_INV_PARM SP   " +
      "	JOIN SLIA_INV_PARMLINE SPL ON SPL.SLIA_INV_PARM_ID = SP.SLIA_INV_PARM_ID  " +
      "	WHERE SP.AD_ORG_ID <>'0'  " +
      "	AND SP.AD_ORG_ID = ?  " +
      "	AND SPL.C_DOCTYPE_ID = ? ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypeId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_invacct_id");
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

  public static String selectAccount2(ConnectionProvider connectionProvider, String organizationId, String doctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT  " +
      "	SPL.P_INVACCT_ID   " +
      "	FROM SLIA_INV_PARM SP   " +
      "	JOIN SLIA_INV_PARMLINE SPL ON SPL.SLIA_INV_PARM_ID = SP.SLIA_INV_PARM_ID  " +
      "	WHERE SP.AD_ORG_ID ='0'  " +
      "	AND SP.AD_ORG_ID = ?  " +
      "	AND SPL.C_DOCTYPE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypeId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_invacct_id");
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

  public static String existsParams(ConnectionProvider connectionProvider, String doctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT  " +
      "	COUNT(*) AS CONTARREG  " +
      "	FROM SLIA_INV_PARM SP   " +
      "	JOIN SLIA_INV_PARMLINE SPL ON SPL.SLIA_INV_PARM_ID = SP.SLIA_INV_PARM_ID   " +
      "	AND SPL.C_DOCTYPE_ID = ?   ";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypeId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "contarreg");
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

  public static String selectAccounting(ConnectionProvider connectionProvider, String organizationId, String doctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	SELECT  " +
      "	SPL.P_INVACCT_ID   " +
      "	FROM SLIA_INV_PARM SP   " +
      "	JOIN SLIA_INV_PARMLINE SPL ON SPL.SLIA_INV_PARM_ID = SP.SLIA_INV_PARM_ID  " +
      "	WHERE SP.AD_ORG_ID = ?  " +
      "	AND SPL.C_DOCTYPE_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, doctypeId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "p_invacct_id");
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

  public static DocInventoryValidOrganizationData[] selectAccountOrganization(ConnectionProvider connectionProvider, String organizationId)    throws ServletException {
    return selectAccountOrganization(connectionProvider, organizationId, 0, 0);
  }

  public static DocInventoryValidOrganizationData[] selectAccountOrganization(ConnectionProvider connectionProvider, String organizationId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "		select adtn.seqno AS SEQNO" +
      "		,ao.ad_org_id as PADREID" +
      "		,ao.name as ORGPADRE" +
      "		,aon.ad_org_id as HIJOID" +
      "		,aon.name as ORGHIJO" +
      "		 from ad_treenode adtn" +
      "		join ad_org ao on ao.ad_org_id = adtn.parent_id" +
      "		join ad_org aon on aon.ad_org_id = adtn.node_id" +
      "		where aon.ad_org_id = ?  " +
      "		order by seqno asc";

    ResultSet result;
    Vector<DocInventoryValidOrganizationData> vector = new Vector<DocInventoryValidOrganizationData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, organizationId);

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
        DocInventoryValidOrganizationData objectDocInventoryValidOrganizationData = new DocInventoryValidOrganizationData();
        objectDocInventoryValidOrganizationData.seqno = UtilSql.getValue(result, "seqno");
        objectDocInventoryValidOrganizationData.padreid = UtilSql.getValue(result, "padreid");
        objectDocInventoryValidOrganizationData.orgpadre = UtilSql.getValue(result, "orgpadre");
        objectDocInventoryValidOrganizationData.hijoid = UtilSql.getValue(result, "hijoid");
        objectDocInventoryValidOrganizationData.orghijo = UtilSql.getValue(result, "orghijo");
        objectDocInventoryValidOrganizationData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInventoryValidOrganizationData);
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
    DocInventoryValidOrganizationData objectDocInventoryValidOrganizationData[] = new DocInventoryValidOrganizationData[vector.size()];
    vector.copyInto(objectDocInventoryValidOrganizationData);
    return(objectDocInventoryValidOrganizationData);
  }
}
