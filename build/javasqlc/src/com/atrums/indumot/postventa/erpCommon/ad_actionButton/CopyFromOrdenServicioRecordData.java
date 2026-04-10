//Sqlc generated V1.O00-1
package com.atrums.indumot.postventa.erpCommon.ad_actionButton;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class CopyFromOrdenServicioRecordData implements FieldProvider {
static Logger log4j = Logger.getLogger(CopyFromOrdenServicioRecordData.class);
  private String InitRecordNumber="0";
  public String adClientId;
  public String adOrgId;
  public String orgname;
  public String documentno;
  public String poreference;
  public String cBpartnerId;
  public String bpartnername;
  public String cBpartnerLocationId;
  public String locationname;
  public String dateinvoiced;
  public String pricelistname;
  public String mWarehouseId;
  public String mPricelistId;
  public String cCurrencyId;
  public String adUserId;
  public String lastDays;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("orgname"))
      return orgname;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("poreference"))
      return poreference;
    else if (fieldName.equalsIgnoreCase("c_bpartner_id") || fieldName.equals("cBpartnerId"))
      return cBpartnerId;
    else if (fieldName.equalsIgnoreCase("bpartnername"))
      return bpartnername;
    else if (fieldName.equalsIgnoreCase("c_bpartner_location_id") || fieldName.equals("cBpartnerLocationId"))
      return cBpartnerLocationId;
    else if (fieldName.equalsIgnoreCase("locationname"))
      return locationname;
    else if (fieldName.equalsIgnoreCase("dateinvoiced"))
      return dateinvoiced;
    else if (fieldName.equalsIgnoreCase("pricelistname"))
      return pricelistname;
    else if (fieldName.equalsIgnoreCase("m_warehouse_id") || fieldName.equals("mWarehouseId"))
      return mWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("c_currency_id") || fieldName.equals("cCurrencyId"))
      return cCurrencyId;
    else if (fieldName.equalsIgnoreCase("ad_user_id") || fieldName.equals("adUserId"))
      return adUserId;
    else if (fieldName.equalsIgnoreCase("last_days") || fieldName.equals("lastDays"))
      return lastDays;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static CopyFromOrdenServicioRecordData[] select(ConnectionProvider connectionProvider, String cInvoiceId)    throws ServletException {
    return select(connectionProvider, cInvoiceId, 0, 0);
  }

  public static CopyFromOrdenServicioRecordData[] select(ConnectionProvider connectionProvider, String cInvoiceId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "                select i.AD_CLIENT_ID, " +
      "                       i.AD_ORG_ID, " +
      "                       org.NAME AS ORGNAME, " +
      "                       i.DOCUMENTNO, " +
      "                       i.POREFERENCE, " +
      "                       i.C_BPARTNER_ID, " +
      "                       bp.NAME AS BPARTNERNAME, " +
      "                       i.C_BPARTNER_LOCATION_ID, " +
      "                       bl.NAME AS LOCATIONNAME, " +
      "                       i.dateinvoiced, " +
      "                       pl.NAME AS PRICELISTNAME, " +
      "                       '' as M_WAREHOUSE_ID, " +
      "                       i.M_PRICELIST_ID, " +
      "                       i.C_CURRENCY_ID, " +
      "                       i.AD_USER_ID, " +
      "                       bp.LAST_DAYS" +
      "                from c_invoice i " +
      "                left join c_invoiceline il on il.c_invoice_id = i.c_invoice_id" +
      "                left join C_BPARTNER bp on bp.c_bpartner_id = i.c_bpartner_id" +
      "                left join M_PRICELIST pl on pl.m_pricelist_id = i.m_pricelist_id" +
      "                left join C_BPARTNER_LOCATION bl on bl.C_BPARTNER_LOCATION_ID = i.c_bpartner_location_id" +
      "                left join  AD_ORG org on org.AD_ORG_ID = i.ad_org_id" +
      "                where i.c_invoice_id =?";

    ResultSet result;
    Vector<CopyFromOrdenServicioRecordData> vector = new Vector<CopyFromOrdenServicioRecordData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

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
        CopyFromOrdenServicioRecordData objectCopyFromOrdenServicioRecordData = new CopyFromOrdenServicioRecordData();
        objectCopyFromOrdenServicioRecordData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectCopyFromOrdenServicioRecordData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectCopyFromOrdenServicioRecordData.orgname = UtilSql.getValue(result, "orgname");
        objectCopyFromOrdenServicioRecordData.documentno = UtilSql.getValue(result, "documentno");
        objectCopyFromOrdenServicioRecordData.poreference = UtilSql.getValue(result, "poreference");
        objectCopyFromOrdenServicioRecordData.cBpartnerId = UtilSql.getValue(result, "c_bpartner_id");
        objectCopyFromOrdenServicioRecordData.bpartnername = UtilSql.getValue(result, "bpartnername");
        objectCopyFromOrdenServicioRecordData.cBpartnerLocationId = UtilSql.getValue(result, "c_bpartner_location_id");
        objectCopyFromOrdenServicioRecordData.locationname = UtilSql.getValue(result, "locationname");
        objectCopyFromOrdenServicioRecordData.dateinvoiced = UtilSql.getDateValue(result, "dateinvoiced", "dd-MM-yyyy");
        objectCopyFromOrdenServicioRecordData.pricelistname = UtilSql.getValue(result, "pricelistname");
        objectCopyFromOrdenServicioRecordData.mWarehouseId = UtilSql.getValue(result, "m_warehouse_id");
        objectCopyFromOrdenServicioRecordData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectCopyFromOrdenServicioRecordData.cCurrencyId = UtilSql.getValue(result, "c_currency_id");
        objectCopyFromOrdenServicioRecordData.adUserId = UtilSql.getValue(result, "ad_user_id");
        objectCopyFromOrdenServicioRecordData.lastDays = UtilSql.getValue(result, "last_days");
        objectCopyFromOrdenServicioRecordData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectCopyFromOrdenServicioRecordData);
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
    CopyFromOrdenServicioRecordData objectCopyFromOrdenServicioRecordData[] = new CopyFromOrdenServicioRecordData[vector.size()];
    vector.copyInto(objectCopyFromOrdenServicioRecordData);
    return(objectCopyFromOrdenServicioRecordData);
  }

  public static String pendingDeliverySales(ConnectionProvider connectionProvider, String cBpartnerId, String adOrgId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(ROUND(SUM(TOTALLINES),2),0) AS SHIPMENTAMOUNTPENDING" +
      "        FROM M_INOUT_CANDIDATE_V" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND AD_ORG_ID = ?" +
      "        AND AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "shipmentamountpending");
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

  public static String pendingInvoiceSales(ConnectionProvider connectionProvider, String cBpartnerId, String adOrgId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(ROUND(SUM(NOTINVOICEDLINES),2),0) AS INVOICEAMOUNTPENDING" +
      "        FROM C_INVOICE_CANDIDATE_V" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND AD_ORG_ID = ?" +
      "        AND AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "invoiceamountpending");
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

  public static String debtPending(ConnectionProvider connectionProvider, String cBpartnerId, String adOrgId, String adClientId, String issotrx)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(ROUND(SUM(DP.AMOUNT),2),0) AS AMOUNTDEBT" +
      "        FROM C_DEBT_PAYMENT DP, C_CURRENCY" +
      "        WHERE DP.C_BPARTNER_ID = ?" +
      "        AND DP.C_CURRENCY_ID = C_CURRENCY.C_CURRENCY_ID" +
      "        AND DP.AD_ORG_ID = ?" +
      "        AND DP.AD_CLIENT_ID = ?" +
      "        AND C_DEBT_PAYMENT_STATUS(DP.C_Settlement_Cancel_ID, DP.CANCEL_PROCESSED, DP.GENERATE_PROCESSED, DP.ISPAID, DP.ISVALID, " +
      "        DP.C_CASHLINE_ID, DP.C_BANKSTATEMENTLINE_ID) = 'P'" +
      "        AND DP.ISRECEIPT=?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "amountdebt");
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

  public static String contact(ConnectionProvider connectionProvider, String adUserId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT max(coalesce(to_char(FIRSTNAME),'')||' '||coalesce(to_char(LASTNAME),'')||(case coalesce(to_char(PHONE),'') when '' then '' else ' ('||to_char(PHONE)||')' end)) AS CONTACT" +
      "        FROM AD_USER" +
      "        WHERE AD_USER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "contact");
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

  public static String invoicing(ConnectionProvider connectionProvider, String issotrx, String c_bpartnerId, String adOrgId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(SUM(ROUND(IL.LINENETAMT,2)),0) AS AMOUNTINVOICING" +
      "        FROM C_INVOICE I, C_INVOICELINE IL" +
      "        WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID" +
      "          AND I.DATEINVOICED< NOW()+1" +
      "          AND I.DATEINVOICED >= TRUNC(TO_DATE(NOW()), 'YEAR') " +
      "          AND I.PROCESSED = 'Y'" +
      "          AND I.ISSOTRX=?" +
      "          AND I.C_BPARTNER_ID = ?" +
      "          AND I.AD_ORG_ID = ?" +
      "          AND I.AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "amountinvoicing");
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

  public static String invoicingTotal(ConnectionProvider connectionProvider, String issotrx, String adOrgId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(SUM(ROUND(IL.LINENETAMT,2)),0) AS AMOUNT" +
      "        FROM C_INVOICE I, C_INVOICELINE IL" +
      "        WHERE I.C_INVOICE_ID = IL.C_INVOICE_ID" +
      "        AND I.DATEINVOICED< NOW()+1" +
      "        AND I.DATEINVOICED >= TRUNC(TO_DATE(NOW()), 'YEAR') " +
      "        AND I.PROCESSED = 'Y'" +
      "        AND I.ISSOTRX=?" +
      "        AND I.AD_ORG_ID = ?" +
      "        AND I.AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "amount");
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

  public static String maxDateinvoice(ConnectionProvider connectionProvider, String dateFormat, String cBpartnerId, String issotrx, String adOrgId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT TO_CHAR(MAX(dateinvoiced),to_char(?)) AS dateinvoiced" +
      "        FROM c_invoice" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND DOCSTATUS = 'CO' " +
      "        AND ISSOTRX = ?" +
      "        AND AD_ORG_ID = ?" +
      "        AND AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateFormat);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, issotrx);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "dateinvoiced");
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

  public static String purchasePendingInvoice(ConnectionProvider connectionProvider, String cBpartnerId, String adOrgId, String adClientId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT coalesce(SUM(A.AMOUNT),0) FROM (" +
      "        SELECT ROUND(((C_ORDERLINE.QTYORDERED - COALESCE(SUM(m.QTY),0))*PRICEACTUAL),2) AS AMOUNT" +
      "        FROM C_ORDER, C_ORDERLINE left join M_MATCHPO m on  C_ORDERLINE.C_OrderLine_ID=m.C_OrderLine_ID" +
      "                                                              and m.C_InvoiceLine_ID IS NOT NULL, C_CURRENCY" +
      "        WHERE C_ORDER.C_ORDER_ID = C_ORDERLINE.C_ORDER_ID" +
      "        AND C_ORDER.C_CURRENCY_ID = C_CURRENCY.C_CURRENCY_ID" +
      "        AND C_ORDER.ISSOTRX='N'" +
      "        AND C_ORDER.DOCSTATUS = 'CO'" +
      "        AND C_ORDER.C_BPARTNER_ID = ?" +
      "        AND C_ORDER.AD_ORG_ID = ? " +
      "        AND C_ORDER.AD_CLIENT_ID = ?" +
      "        GROUP BY C_ORDERLINE.QTYORDERED, PRICEACTUAL) A";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "coalesce");
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
