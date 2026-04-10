//Sqlc generated V1.O00-1
package com.sidesoft.settlement.project.cost.acc_template;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class DocInOutTemplateData implements FieldProvider {
static Logger log4j = Logger.getLogger(DocInOutTemplateData.class);
  private String InitRecordNumber="0";
  public String mInoutId;
  public String adClientId;
  public String adOrgId;
  public String isactive;
  public String created;
  public String createdby;
  public String updated;
  public String updatedby;
  public String issotrx;
  public String documentno;
  public String docaction;
  public String docstatus;
  public String posted;
  public String processing;
  public String processed;
  public String cDoctypeId;
  public String description;
  public String cOrderId;
  public String dateordered;
  public String isprinted;
  public String movementtype;
  public String movementdate;
  public String dateacct;
  public String cBpartnerId;
  public String cBpartnerLocationId;
  public String mWarehouseId;
  public String poreference;
  public String deliveryrule;
  public String freightcostrule;
  public String freightamt;
  public String deliveryviarule;
  public String mShipperId;
  public String cChargeId;
  public String chargeamt;
  public String priorityrule;
  public String dateprinted;
  public String cInvoiceId;
  public String createfrom;
  public String generateto;
  public String sendemail;
  public String adUserId;
  public String salesrepId;
  public String nopackages;
  public String pickdate;
  public String shipdate;
  public String trackingno;
  public String adOrgtrxId;
  public String cProjectId;
  public String cCampaignId;
  public String cActivityId;
  public String user1Id;
  public String user2Id;
  public String cCostcenterId;
  public String updatelines;
  public String mCostingId;
  public String stdprecision;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_inout_id") || fieldName.equals("mInoutId"))
      return mInoutId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("isactive"))
      return isactive;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("createdby"))
      return createdby;
    else if (fieldName.equalsIgnoreCase("updated"))
      return updated;
    else if (fieldName.equalsIgnoreCase("updatedby"))
      return updatedby;
    else if (fieldName.equalsIgnoreCase("issotrx"))
      return issotrx;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("docaction"))
      return docaction;
    else if (fieldName.equalsIgnoreCase("docstatus"))
      return docstatus;
    else if (fieldName.equalsIgnoreCase("posted"))
      return posted;
    else if (fieldName.equalsIgnoreCase("processing"))
      return processing;
    else if (fieldName.equalsIgnoreCase("processed"))
      return processed;
    else if (fieldName.equalsIgnoreCase("c_doctype_id") || fieldName.equals("cDoctypeId"))
      return cDoctypeId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_order_id") || fieldName.equals("cOrderId"))
      return cOrderId;
    else if (fieldName.equalsIgnoreCase("dateordered"))
      return dateordered;
    else if (fieldName.equalsIgnoreCase("isprinted"))
      return isprinted;
    else if (fieldName.equalsIgnoreCase("movementtype"))
      return movementtype;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("dateacct"))
      return dateacct;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("freightamt"))
      return freightamt;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("m_shipper_id") || fieldName.equals("mShipperId"))
      return mShipperId;
    else if (fieldName.equalsIgnoreCase("c_charge_id") || fieldName.equals("cChargeId"))
      return cChargeId;
    else if (fieldName.equalsIgnoreCase("chargeamt"))
      return chargeamt;
    else if (fieldName.equalsIgnoreCase("priorityrule"))
      return priorityrule;
    else if (fieldName.equalsIgnoreCase("dateprinted"))
      return dateprinted;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("createfrom"))
      return createfrom;
    else if (fieldName.equalsIgnoreCase("generateto"))
      return generateto;
    else if (fieldName.equalsIgnoreCase("sendemail"))
      return sendemail;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("salesrep_id") || fieldName.equals("salesrepId"))
      return salesrepId;
    else if (fieldName.equalsIgnoreCase("nopackages"))
      return nopackages;
    else if (fieldName.equalsIgnoreCase("pickdate"))
      return pickdate;
    else if (fieldName.equalsIgnoreCase("shipdate"))
      return shipdate;
    else if (fieldName.equalsIgnoreCase("trackingno"))
      return trackingno;
    else if (fieldName.equalsIgnoreCase("ad_orgtrx_id") || fieldName.equals("adOrgtrxId"))
      return adOrgtrxId;
    else if (fieldName.equalsIgnoreCase("c_project_id") || fieldName.equals("cProjectId"))
      return cProjectId;
    else if (fieldName.equalsIgnoreCase("c_campaign_id") || fieldName.equals("cCampaignId"))
      return cCampaignId;
    else if (fieldName.equalsIgnoreCase("c_activity_id") || fieldName.equals("cActivityId"))
      return cActivityId;
    else if (fieldName.equalsIgnoreCase("user1_id") || fieldName.equals("user1Id"))
      return user1Id;
    else if (fieldName.equalsIgnoreCase("user2_id") || fieldName.equals("user2Id"))
      return user2Id;
    else if (fieldName.equalsIgnoreCase("c_costcenter_id") || fieldName.equals("cCostcenterId"))
      return cCostcenterId;
    else if (fieldName.equalsIgnoreCase("updatelines"))
      return updatelines;
    else if (fieldName.equalsIgnoreCase("m_costing_id") || fieldName.equals("mCostingId"))
      return mCostingId;
    else if (fieldName.equalsIgnoreCase("stdprecision"))
      return stdprecision;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static DocInOutTemplateData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static DocInOutTemplateData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_INOUT_ID, '' AS AD_CLIENT_ID, '' AS AD_ORG_ID, '' AS ISACTIVE, '' AS CREATED," +
      "        '' AS CREATEDBY, '' AS UPDATED, '' AS UPDATEDBY, '' AS ISSOTRX, '' AS DOCUMENTNO, '' AS DOCACTION," +
      "        '' AS DOCSTATUS, '' AS POSTED, '' AS PROCESSING, '' AS PROCESSED, '' AS C_DOCTYPE_ID, '' AS DESCRIPTION," +
      "        '' AS C_ORDER_ID, '' AS DATEORDERED, '' AS ISPRINTED, '' AS MOVEMENTTYPE, '' AS MOVEMENTDATE, '' AS DATEACCT," +
      "        '' AS C_BPARTNER_ID, '' AS C_BPARTNER_LOCATION_ID, '' AS M_WAREHOUSE_ID, '' AS POREFERENCE, '' AS DELIVERYRULE," +
      "        '' AS FREIGHTCOSTRULE, '' AS FREIGHTAMT, '' AS DELIVERYVIARULE, '' AS M_SHIPPER_ID, '' AS C_CHARGE_ID," +
      "        '' AS CHARGEAMT, '' AS PRIORITYRULE, '' AS DATEPRINTED, '' AS C_INVOICE_ID, '' AS CREATEFROM, '' AS GENERATETO," +
      "        '' AS SENDEMAIL, '' AS AD_USER_ID, '' AS SALESREP_ID, '' AS NOPACKAGES, '' AS PICKDATE, '' AS SHIPDATE," +
      "        '' AS TRACKINGNO, '' AS AD_ORGTRX_ID, '' AS C_PROJECT_ID, '' AS C_CAMPAIGN_ID, '' AS C_ACTIVITY_ID, '' AS USER1_ID," +
      "        '' AS USER2_ID, '' AS C_COSTCENTER_ID, '' AS UPDATELINES, '' AS M_COSTING_ID, '' AS stdprecision" +
      "        FROM DUAL";

    ResultSet result;
    Vector<DocInOutTemplateData> vector = new Vector<DocInOutTemplateData>(0);
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
        DocInOutTemplateData objectDocInOutTemplateData = new DocInOutTemplateData();
        objectDocInOutTemplateData.mInoutId = UtilSql.getValue(result, "m_inout_id");
        objectDocInOutTemplateData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocInOutTemplateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocInOutTemplateData.isactive = UtilSql.getValue(result, "isactive");
        objectDocInOutTemplateData.created = UtilSql.getValue(result, "created");
        objectDocInOutTemplateData.createdby = UtilSql.getValue(result, "createdby");
        objectDocInOutTemplateData.updated = UtilSql.getValue(result, "updated");
        objectDocInOutTemplateData.updatedby = UtilSql.getValue(result, "updatedby");
        objectDocInOutTemplateData.issotrx = UtilSql.getValue(result, "issotrx");
        objectDocInOutTemplateData.documentno = UtilSql.getValue(result, "documentno");
        objectDocInOutTemplateData.docaction = UtilSql.getValue(result, "docaction");
        objectDocInOutTemplateData.docstatus = UtilSql.getValue(result, "docstatus");
        objectDocInOutTemplateData.posted = UtilSql.getValue(result, "posted");
        objectDocInOutTemplateData.processing = UtilSql.getValue(result, "processing");
        objectDocInOutTemplateData.processed = UtilSql.getValue(result, "processed");
        objectDocInOutTemplateData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocInOutTemplateData.description = UtilSql.getValue(result, "description");
        objectDocInOutTemplateData.cOrderId = UtilSql.getValue(result, "c_order_id");
        objectDocInOutTemplateData.dateordered = UtilSql.getValue(result, "dateordered");
        objectDocInOutTemplateData.isprinted = UtilSql.getValue(result, "isprinted");
        objectDocInOutTemplateData.movementtype = UtilSql.getValue(result, "movementtype");
        objectDocInOutTemplateData.movementdate = UtilSql.getValue(result, "movementdate");
        objectDocInOutTemplateData.dateacct = UtilSql.getValue(result, "dateacct");
        objectDocInOutTemplateData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocInOutTemplateData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectDocInOutTemplateData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectDocInOutTemplateData.poreference = UtilSql.getValue(result, "poreference");
        objectDocInOutTemplateData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectDocInOutTemplateData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectDocInOutTemplateData.freightamt = UtilSql.getValue(result, "freightamt");
        objectDocInOutTemplateData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectDocInOutTemplateData.mShipperId = UtilSql.getValue(result, "m_shipper_id");
        objectDocInOutTemplateData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocInOutTemplateData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocInOutTemplateData.priorityrule = UtilSql.getValue(result, "priorityrule");
        objectDocInOutTemplateData.dateprinted = UtilSql.getValue(result, "dateprinted");
        objectDocInOutTemplateData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectDocInOutTemplateData.createfrom = UtilSql.getValue(result, "createfrom");
        objectDocInOutTemplateData.generateto = UtilSql.getValue(result, "generateto");
        objectDocInOutTemplateData.sendemail = UtilSql.getValue(result, "sendemail");
        objectDocInOutTemplateData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectDocInOutTemplateData.salesrepId = UtilSql.getValue(result, "salesrep_id");
        objectDocInOutTemplateData.nopackages = UtilSql.getValue(result, "nopackages");
        objectDocInOutTemplateData.pickdate = UtilSql.getValue(result, "pickdate");
        objectDocInOutTemplateData.shipdate = UtilSql.getValue(result, "shipdate");
        objectDocInOutTemplateData.trackingno = UtilSql.getValue(result, "trackingno");
        objectDocInOutTemplateData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocInOutTemplateData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocInOutTemplateData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocInOutTemplateData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocInOutTemplateData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocInOutTemplateData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocInOutTemplateData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocInOutTemplateData.updatelines = UtilSql.getValue(result, "updatelines");
        objectDocInOutTemplateData.mCostingId = UtilSql.getValue(result, "m_costing_id");
        objectDocInOutTemplateData.stdprecision = UtilSql.getValue(result, "stdprecision");
        objectDocInOutTemplateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInOutTemplateData);
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
    DocInOutTemplateData objectDocInOutTemplateData[] = new DocInOutTemplateData[vector.size()];
    vector.copyInto(objectDocInOutTemplateData);
    return(objectDocInOutTemplateData);
  }

  public static DocInOutTemplateData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id)    throws ServletException {
    return selectRegistro(connectionProvider, client, id, 0, 0);
  }

  public static DocInOutTemplateData[] selectRegistro(ConnectionProvider connectionProvider, String client, String id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT I.AD_CLIENT_ID, I.AD_ORG_ID, I.C_BPARTNER_ID, I.AD_ORGTRX_ID, I.C_PROJECT_ID," +
      "        I.C_CAMPAIGN_ID, I.C_ACTIVITY_ID, I.USER1_ID, I.USER2_ID, I.C_COSTCENTER_ID, I.DOCUMENTNO, I.DATEACCT," +
      "        I.C_DOCTYPE_ID, I.C_CHARGE_ID, I.CHARGEAMT, I.POSTED, I.MOVEMENTDATE, I.C_BPARTNER_LOCATION_ID" +
      "        FROM M_INOUT I" +
      "        WHERE AD_Client_ID=? " +
      "        AND M_INOUT_ID=?";

    ResultSet result;
    Vector<DocInOutTemplateData> vector = new Vector<DocInOutTemplateData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, id);

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
        DocInOutTemplateData objectDocInOutTemplateData = new DocInOutTemplateData();
        objectDocInOutTemplateData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectDocInOutTemplateData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectDocInOutTemplateData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectDocInOutTemplateData.adOrgtrxId = UtilSql.getValue(result, "ad_orgtrx_id");
        objectDocInOutTemplateData.cProjectId = UtilSql.getValue(result, "c_project_id");
        objectDocInOutTemplateData.cCampaignId = UtilSql.getValue(result, "c_campaign_id");
        objectDocInOutTemplateData.cActivityId = UtilSql.getValue(result, "c_activity_id");
        objectDocInOutTemplateData.user1Id = UtilSql.getValue(result, "user1_id");
        objectDocInOutTemplateData.user2Id = UtilSql.getValue(result, "user2_id");
        objectDocInOutTemplateData.cCostcenterId = UtilSql.getValue(result, "c_costcenter_id");
        objectDocInOutTemplateData.documentno = UtilSql.getValue(result, "documentno");
        objectDocInOutTemplateData.dateacct = UtilSql.getDateValue(result, "dateacct", "dd-MM-yyyy");
        objectDocInOutTemplateData.cDoctypeId = UtilSql.getValue(result, "c_doctype_id");
        objectDocInOutTemplateData.cChargeId = UtilSql.getValue(result, "c_charge_id");
        objectDocInOutTemplateData.chargeamt = UtilSql.getValue(result, "chargeamt");
        objectDocInOutTemplateData.posted = UtilSql.getValue(result, "posted");
        objectDocInOutTemplateData.movementdate = UtilSql.getDateValue(result, "movementdate", "dd-MM-yyyy");
        objectDocInOutTemplateData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectDocInOutTemplateData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectDocInOutTemplateData);
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
    DocInOutTemplateData objectDocInOutTemplateData[] = new DocInOutTemplateData[vector.size()];
    vector.copyInto(objectDocInOutTemplateData);
    return(objectDocInOutTemplateData);
  }

  public static String existsCost(ConnectionProvider connectionProvider, String date, String mProductId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT COUNT(M_COSTING_ID)" +
      "        FROM M_COSTING" +
      "        WHERE TO_DATE(?) BETWEEN DATEFROM AND DATETO" +
      "          AND COSTTYPE NOT IN ('STA', 'AVA')" +
      "          AND M_PRODUCT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "count");
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
