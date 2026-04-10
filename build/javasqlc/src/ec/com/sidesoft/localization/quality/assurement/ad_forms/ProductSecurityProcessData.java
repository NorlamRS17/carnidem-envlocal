//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.quality.assurement.ad_forms;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;
import org.openbravo.database.RDBMSIndependent;
import org.openbravo.exception.*;

class ProductSecurityProcessData implements FieldProvider {
static Logger log4j = Logger.getLogger(ProductSecurityProcessData.class);
  private String InitRecordNumber="0";
  public String slqsPrdSafetyVId;
  public String adOrgId;
  public String adClientId;
  public String mProductId;
  public String code;
  public String cUomId;
  public String mAttributesetinstanceId;
  public String mProductionplanId;
  public String maCostcenterVersionId;
  public String movementqty;
  public String starttime;
  public String endtime;
  public String mProductionId;
  public String datePartWork;
  public String startPartWork;
  public String endPartWork;
  public String mLocatorId;
  public String emSlqsStatus;
  public String mProductionlineId;
  public String maPeriodicControlId;
  public String description;
  public String qtyinvoiced;
  public String cInvoiceId;
  public String grandtotal;
  public String discount;
  public String tax;
  public String customerId;
  public String mPricelistId;
  public String pricelistid;
  public String org;
  public String paymentrule;
  public String cPaymenttermId;
  public String finPaymentmethodId;
  public String docPartWork;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("slqs_prd_safety_v_id") || fieldName.equals("slqsPrdSafetyVId"))
      return slqsPrdSafetyVId;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("ad_client_id") || fieldName.equals("adClientId"))
      return adClientId;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("code"))
      return code;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("m_productionplan_id") || fieldName.equals("mProductionplanId"))
      return mProductionplanId;
    else if (fieldName.equalsIgnoreCase("ma_costcenter_version_id") || fieldName.equals("maCostcenterVersionId"))
      return maCostcenterVersionId;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("starttime"))
      return starttime;
    else if (fieldName.equalsIgnoreCase("endtime"))
      return endtime;
    else if (fieldName.equalsIgnoreCase("m_production_id") || fieldName.equals("mProductionId"))
      return mProductionId;
    else if (fieldName.equalsIgnoreCase("date_part_work") || fieldName.equals("datePartWork"))
      return datePartWork;
    else if (fieldName.equalsIgnoreCase("start_part_work") || fieldName.equals("startPartWork"))
      return startPartWork;
    else if (fieldName.equalsIgnoreCase("end_part_work") || fieldName.equals("endPartWork"))
      return endPartWork;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("em_slqs_status") || fieldName.equals("emSlqsStatus"))
      return emSlqsStatus;
    else if (fieldName.equalsIgnoreCase("m_productionline_id") || fieldName.equals("mProductionlineId"))
      return mProductionlineId;
    else if (fieldName.equalsIgnoreCase("ma_periodic_control_id") || fieldName.equals("maPeriodicControlId"))
      return maPeriodicControlId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("qtyinvoiced"))
      return qtyinvoiced;
    else if (fieldName.equalsIgnoreCase("c_invoice_id") || fieldName.equals("cInvoiceId"))
      return cInvoiceId;
    else if (fieldName.equalsIgnoreCase("grandtotal"))
      return grandtotal;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("customer_id") || fieldName.equals("customerId"))
      return customerId;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("pricelistid"))
      return pricelistid;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("paymentrule"))
      return paymentrule;
    else if (fieldName.equalsIgnoreCase("c_paymentterm_id") || fieldName.equals("cPaymenttermId"))
      return cPaymenttermId;
    else if (fieldName.equalsIgnoreCase("fin_paymentmethod_id") || fieldName.equals("finPaymentmethodId"))
      return finPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("doc_part_work") || fieldName.equals("docPartWork"))
      return docPartWork;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ProductSecurityProcessData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ProductSecurityProcessData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select    " +
      "            '' AS SLQS_PRD_SAFETY_V_ID" +
      "            ,'' AS AD_ORG_ID" +
      "            ,'' AS AD_CLIENT_ID" +
      "            ,'' AS M_PRODUCT_ID" +
      "            ,'' AS CODE" +
      "            ,'' AS C_UOM_ID" +
      "            ,'' AS M_ATTRIBUTESETINSTANCE_ID" +
      "            ,'' AS M_PRODUCTIONPLAN_ID" +
      "            ,'' AS MA_COSTCENTER_VERSION_ID" +
      "            ,0 AS MOVEMENTQTY" +
      "            ,'' AS STARTTIME" +
      "            ,'' AS ENDTIME" +
      "            ,'' AS M_PRODUCTION_ID" +
      "            ,'' AS DATE_PART_WORK" +
      "            ,'' AS START_PART_WORK" +
      "            ,'' AS END_PART_WORK" +
      "            ,'' AS M_LOCATOR_ID" +
      "            ,'' AS EM_SLQS_STATUS" +
      "            ,'' AS M_PRODUCTIONLINE_ID" +
      "            ,'' AS MA_PERIODIC_CONTROL_ID" +
      "            , '' as DESCRIPTION  " +
      "            ,0 AS QTYINVOICED" +
      "            , '' AS C_INVOICE_ID" +
      "            , '' AS GRANDTOTAL" +
      "            , '' AS DISCOUNT" +
      "            , '' AS TAX" +
      "            , '' AS CUSTOMER_ID" +
      "            , '' AS M_PRICELIST_ID" +
      "            , '' AS PRICELISTID" +
      "            , '' AS ORG" +
      "            , '' AS PAYMENTRULE" +
      "            , '' AS C_PAYMENTTERM_ID" +
      "            ,'' AS FIN_PAYMENTMETHOD_ID " +
      "            ,'' AS DOC_PART_WORK             " +
      "            from DUAL";

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.slqsPrdSafetyVId = UtilSql.getValue(result, "slqs_prd_safety_v_id");
        objectProductSecurityProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductSecurityProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductSecurityProcessData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductSecurityProcessData.code = UtilSql.getValue(result, "code");
        objectProductSecurityProcessData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductSecurityProcessData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductSecurityProcessData.mProductionplanId = UtilSql.getValue(result, "m_productionplan_id");
        objectProductSecurityProcessData.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectProductSecurityProcessData.movementqty = UtilSql.getValue(result, "movementqty");
        objectProductSecurityProcessData.starttime = UtilSql.getValue(result, "starttime");
        objectProductSecurityProcessData.endtime = UtilSql.getValue(result, "endtime");
        objectProductSecurityProcessData.mProductionId = UtilSql.getValue(result, "m_production_id");
        objectProductSecurityProcessData.datePartWork = UtilSql.getValue(result, "date_part_work");
        objectProductSecurityProcessData.startPartWork = UtilSql.getValue(result, "start_part_work");
        objectProductSecurityProcessData.endPartWork = UtilSql.getValue(result, "end_part_work");
        objectProductSecurityProcessData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductSecurityProcessData.emSlqsStatus = UtilSql.getValue(result, "em_slqs_status");
        objectProductSecurityProcessData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectProductSecurityProcessData.maPeriodicControlId = UtilSql.getValue(result, "ma_periodic_control_id");
        objectProductSecurityProcessData.description = UtilSql.getValue(result, "description");
        objectProductSecurityProcessData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectProductSecurityProcessData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectProductSecurityProcessData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectProductSecurityProcessData.discount = UtilSql.getValue(result, "discount");
        objectProductSecurityProcessData.tax = UtilSql.getValue(result, "tax");
        objectProductSecurityProcessData.customerId = UtilSql.getValue(result, "customer_id");
        objectProductSecurityProcessData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectProductSecurityProcessData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectProductSecurityProcessData.org = UtilSql.getValue(result, "org");
        objectProductSecurityProcessData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectProductSecurityProcessData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectProductSecurityProcessData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectProductSecurityProcessData.docPartWork = UtilSql.getValue(result, "doc_part_work");
        objectProductSecurityProcessData.rownum = Long.toString(countRecord);
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] set()    throws ServletException {
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[1];
    objectProductSecurityProcessData[0] = new ProductSecurityProcessData();
    objectProductSecurityProcessData[0].slqsPrdSafetyVId = "";
    objectProductSecurityProcessData[0].adOrgId = "";
    objectProductSecurityProcessData[0].adClientId = "";
    objectProductSecurityProcessData[0].mProductId = "";
    objectProductSecurityProcessData[0].code = "";
    objectProductSecurityProcessData[0].cUomId = "";
    objectProductSecurityProcessData[0].mAttributesetinstanceId = "";
    objectProductSecurityProcessData[0].mProductionplanId = "";
    objectProductSecurityProcessData[0].maCostcenterVersionId = "";
    objectProductSecurityProcessData[0].movementqty = "";
    objectProductSecurityProcessData[0].starttime = "";
    objectProductSecurityProcessData[0].endtime = "";
    objectProductSecurityProcessData[0].mProductionId = "";
    objectProductSecurityProcessData[0].datePartWork = "";
    objectProductSecurityProcessData[0].startPartWork = "";
    objectProductSecurityProcessData[0].endPartWork = "";
    objectProductSecurityProcessData[0].mLocatorId = "";
    objectProductSecurityProcessData[0].emSlqsStatus = "";
    objectProductSecurityProcessData[0].mProductionlineId = "";
    objectProductSecurityProcessData[0].maPeriodicControlId = "";
    objectProductSecurityProcessData[0].description = "";
    objectProductSecurityProcessData[0].qtyinvoiced = "";
    objectProductSecurityProcessData[0].cInvoiceId = "";
    objectProductSecurityProcessData[0].grandtotal = "";
    objectProductSecurityProcessData[0].discount = "";
    objectProductSecurityProcessData[0].tax = "";
    objectProductSecurityProcessData[0].customerId = "";
    objectProductSecurityProcessData[0].mPricelistId = "";
    objectProductSecurityProcessData[0].pricelistid = "";
    objectProductSecurityProcessData[0].org = "";
    objectProductSecurityProcessData[0].paymentrule = "";
    objectProductSecurityProcessData[0].cPaymenttermId = "";
    objectProductSecurityProcessData[0].finPaymentmethodId = "";
    objectProductSecurityProcessData[0].docPartWork = "";
    return objectProductSecurityProcessData;
  }

  public static ProductSecurityProcessData[] selectLines(ConnectionProvider connectionProvider, String language, String documentno, String code, String productid, String startdate, String enddate)    throws ServletException {
    return selectLines(connectionProvider, language, documentno, code, productid, startdate, enddate, 0, 0);
  }

  public static ProductSecurityProcessData[] selectLines(ConnectionProvider connectionProvider, String language, String documentno, String code, String productid, String startdate, String enddate, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select SLQS_PRD_SAFETY_V_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('AD_ORG'), to_char(sps.AD_ORG_ID), ?) AS AD_ORG_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('AD_CLIENT'), to_char(sps.AD_CLIENT_ID), ?) AS AD_CLIENT_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCT'), to_char(sps.M_PRODUCT_ID), ?) AS M_PRODUCT_ID" +
      "    ,CODE" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('C_UOM'), to_char(sps.C_UOM_ID), ?) AS C_UOM_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_ATTRIBUTESETINSTANCE'), to_char(sps.M_ATTRIBUTESETINSTANCE_ID), ?) AS M_ATTRIBUTESETINSTANCE_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCTIONPLAN'), to_char(sps.M_PRODUCTIONPLAN_ID), ?) AS M_PRODUCTIONPLAN_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('MA_COSTCENTER_VERSION'), to_char(sps.MA_COSTCENTER_VERSION_ID), ?) AS MA_COSTCENTER_VERSION_ID" +
      "    ,MOVEMENTQTY" +
      "    ,STARTTIME" +
      "    ,ENDTIME" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCTION'), to_char(sps.M_PRODUCTION_ID), ?) AS M_PRODUCTION_ID" +
      "    ,DATE_PART_WORK" +
      "    ,START_PART_WORK" +
      "    ,END_PART_WORK" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_LOCATOR'), to_char(sps.M_LOCATOR_ID), ?) AS M_LOCATOR_ID" +
      "    ,sub.name as EM_SLQS_STATUS" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCTIONLINE'), to_char(sps.M_PRODUCTIONLINE_ID), ?) AS M_PRODUCTIONLINE_ID" +
      "    ,DOC_PART_WORK  " +
      "    from slqs_prd_safety_v sps" +
      "    left join (" +
      "    select adrlt.name, arl.value" +
      "    from ad_reference ar" +
      "    join ad_ref_list arl on ar.ad_reference_id = arl.ad_reference_id" +
      "    join ad_ref_list_trl adrlt on adrlt.ad_ref_list_id = arl.ad_ref_list_id" +
      "    where ar.ad_reference_id = 'C4EDFC20013D401B8C03789EC74B408A'" +
      "    and adrlt.ad_language = 'es_ES') sub on sub.value = sps.EM_SLQS_STATUS" +
      "    where (sps.DOC_PART_WORK like ? or ? is null)     " +
      "    and (sps.CODE like ? or ? is null)   " +
      "    and (sps.M_PRODUCT_ID = ? or ? is null)   " +
      "    and (to_date(to_char(sps.DATE_PART_WORK,'dd-MM-yyyy')) between ? and ?)   ";

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, code);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, code);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, startdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, enddate);

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.slqsPrdSafetyVId = UtilSql.getValue(result, "slqs_prd_safety_v_id");
        objectProductSecurityProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductSecurityProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductSecurityProcessData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductSecurityProcessData.code = UtilSql.getValue(result, "code");
        objectProductSecurityProcessData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductSecurityProcessData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductSecurityProcessData.mProductionplanId = UtilSql.getValue(result, "m_productionplan_id");
        objectProductSecurityProcessData.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectProductSecurityProcessData.movementqty = UtilSql.getValue(result, "movementqty");
        objectProductSecurityProcessData.starttime = UtilSql.getDateValue(result, "starttime", "dd-MM-yyyy");
        objectProductSecurityProcessData.endtime = UtilSql.getDateValue(result, "endtime", "dd-MM-yyyy");
        objectProductSecurityProcessData.mProductionId = UtilSql.getValue(result, "m_production_id");
        objectProductSecurityProcessData.datePartWork = UtilSql.getDateValue(result, "date_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.startPartWork = UtilSql.getDateValue(result, "start_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.endPartWork = UtilSql.getDateValue(result, "end_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductSecurityProcessData.emSlqsStatus = UtilSql.getValue(result, "em_slqs_status");
        objectProductSecurityProcessData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectProductSecurityProcessData.docPartWork = UtilSql.getValue(result, "doc_part_work");
        objectProductSecurityProcessData.rownum = Long.toString(countRecord);
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] selectSelected(ConnectionProvider connectionProvider, String language)    throws ServletException {
    return selectSelected(connectionProvider, language, 0, 0);
  }

  public static ProductSecurityProcessData[] selectSelected(ConnectionProvider connectionProvider, String language, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    select SLQS_PRD_SAFETY_V_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('AD_ORG'), to_char(sps.AD_ORG_ID), ?) AS AD_ORG_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('AD_CLIENT'), to_char(sps.AD_CLIENT_ID), ?) AS AD_CLIENT_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCT'), to_char(sps.M_PRODUCT_ID), ?) AS M_PRODUCT_ID" +
      "    ,CODE" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('C_UOM'), to_char(sps.C_UOM_ID), ?) AS C_UOM_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_ATTRIBUTESETINSTANCE'), to_char(sps.M_ATTRIBUTESETINSTANCE_ID), ?) AS M_ATTRIBUTESETINSTANCE_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCTIONPLAN'), to_char(sps.M_PRODUCTIONPLAN_ID), ?) AS M_PRODUCTIONPLAN_ID" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('MA_COSTCENTER_VERSION'), to_char(sps.MA_COSTCENTER_VERSION_ID), ?) AS MA_COSTCENTER_VERSION_ID" +
      "    ,MOVEMENTQTY" +
      "    ,STARTTIME" +
      "    ,ENDTIME" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCTION'), to_char(sps.M_PRODUCTION_ID), ?) AS M_PRODUCTION_ID" +
      "    ,DATE_PART_WORK" +
      "    ,START_PART_WORK" +
      "    ,END_PART_WORK" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_LOCATOR'), to_char(sps.M_LOCATOR_ID), ?) AS M_LOCATOR_ID" +
      "    ,sub.name as EM_SLQS_STATUS" +
      "    ,AD_COLUMN_IDENTIFIER(to_char('M_PRODUCTIONLINE'), to_char(sps.M_PRODUCTIONLINE_ID), ?) AS M_PRODUCTIONLINE_ID" +
      "    , DOC_PART_WORK    " +
      "    from slqs_prd_safety_v sps" +
      "    left join (" +
      "    select adrlt.name, arl.value" +
      "    from ad_reference ar" +
      "    join ad_ref_list arl on ar.ad_reference_id = arl.ad_reference_id" +
      "    join ad_ref_list_trl adrlt on adrlt.ad_ref_list_id = arl.ad_ref_list_id" +
      "    where ar.ad_reference_id = 'C4EDFC20013D401B8C03789EC74B408A'" +
      "    and adrlt.ad_language = 'es_ES') sub on sub.value = sps.EM_SLQS_STATUS  ";

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.slqsPrdSafetyVId = UtilSql.getValue(result, "slqs_prd_safety_v_id");
        objectProductSecurityProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductSecurityProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductSecurityProcessData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductSecurityProcessData.code = UtilSql.getValue(result, "code");
        objectProductSecurityProcessData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductSecurityProcessData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductSecurityProcessData.mProductionplanId = UtilSql.getValue(result, "m_productionplan_id");
        objectProductSecurityProcessData.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectProductSecurityProcessData.movementqty = UtilSql.getValue(result, "movementqty");
        objectProductSecurityProcessData.starttime = UtilSql.getDateValue(result, "starttime", "dd-MM-yyyy");
        objectProductSecurityProcessData.endtime = UtilSql.getDateValue(result, "endtime", "dd-MM-yyyy");
        objectProductSecurityProcessData.mProductionId = UtilSql.getValue(result, "m_production_id");
        objectProductSecurityProcessData.datePartWork = UtilSql.getDateValue(result, "date_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.startPartWork = UtilSql.getDateValue(result, "start_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.endPartWork = UtilSql.getDateValue(result, "end_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductSecurityProcessData.emSlqsStatus = UtilSql.getValue(result, "em_slqs_status");
        objectProductSecurityProcessData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectProductSecurityProcessData.docPartWork = UtilSql.getValue(result, "doc_part_work");
        objectProductSecurityProcessData.rownum = Long.toString(countRecord);
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] select(ConnectionProvider connectionProvider, String slqs_prd_safety_v_id)    throws ServletException {
    return select(connectionProvider, slqs_prd_safety_v_id, 0, 0);
  }

  public static ProductSecurityProcessData[] select(ConnectionProvider connectionProvider, String slqs_prd_safety_v_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "            select " +
      "             SLQS_PRD_SAFETY_V_ID" +
      "            ,  AD_ORG_ID" +
      "            ,  AD_CLIENT_ID" +
      "            ,  M_PRODUCT_ID" +
      "            ,  CODE" +
      "            ,  C_UOM_ID" +
      "            ,  M_ATTRIBUTESETINSTANCE_ID" +
      "            ,  M_PRODUCTIONPLAN_ID" +
      "            ,  MA_COSTCENTER_VERSION_ID" +
      "            ,MOVEMENTQTY" +
      "            ,  STARTTIME" +
      "            ,  ENDTIME" +
      "            ,  M_PRODUCTION_ID" +
      "            ,  DATE_PART_WORK" +
      "            ,  START_PART_WORK" +
      "            ,  END_PART_WORK" +
      "            ,  M_LOCATOR_ID" +
      "            ,  EM_SLQS_STATUS" +
      "            ,  M_PRODUCTIONLINE_ID" +
      "            ,  MA_PERIODIC_CONTROL_ID" +
      "            ,  DOC_PART_WORK   " +
      "            from slqs_prd_safety_v" +
      "            where slqs_prd_safety_v_id = ?      " +
      "            and M_PRODUCTIONLINE_ID IS NULL   ";

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, slqs_prd_safety_v_id);

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.slqsPrdSafetyVId = UtilSql.getValue(result, "slqs_prd_safety_v_id");
        objectProductSecurityProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductSecurityProcessData.adClientId = UtilSql.getValue(result, "ad_client_id");
        objectProductSecurityProcessData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductSecurityProcessData.code = UtilSql.getValue(result, "code");
        objectProductSecurityProcessData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductSecurityProcessData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductSecurityProcessData.mProductionplanId = UtilSql.getValue(result, "m_productionplan_id");
        objectProductSecurityProcessData.maCostcenterVersionId = UtilSql.getValue(result, "ma_costcenter_version_id");
        objectProductSecurityProcessData.movementqty = UtilSql.getValue(result, "movementqty");
        objectProductSecurityProcessData.starttime = UtilSql.getDateValue(result, "starttime", "dd-MM-yyyy");
        objectProductSecurityProcessData.endtime = UtilSql.getDateValue(result, "endtime", "dd-MM-yyyy");
        objectProductSecurityProcessData.mProductionId = UtilSql.getValue(result, "m_production_id");
        objectProductSecurityProcessData.datePartWork = UtilSql.getDateValue(result, "date_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.startPartWork = UtilSql.getDateValue(result, "start_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.endPartWork = UtilSql.getDateValue(result, "end_part_work", "dd-MM-yyyy");
        objectProductSecurityProcessData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectProductSecurityProcessData.emSlqsStatus = UtilSql.getValue(result, "em_slqs_status");
        objectProductSecurityProcessData.mProductionlineId = UtilSql.getValue(result, "m_productionline_id");
        objectProductSecurityProcessData.maPeriodicControlId = UtilSql.getValue(result, "ma_periodic_control_id");
        objectProductSecurityProcessData.docPartWork = UtilSql.getValue(result, "doc_part_work");
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static String selectDoctype(ConnectionProvider connectionProvider, String adTableId, String docbase)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_DOCTYPE_ID   " +
      "        FROM C_DOCTYPE   " +
      "        WHERE AD_TABLE_ID = ? AND  docbasetype= ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adTableId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docbase);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_doctype_id");
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

  public static ProductSecurityProcessData[] linesToInvoice(ConnectionProvider connectionProvider, String invoicedate, String org, String warehouse, String billto, String shipto, String parRefundLines)    throws ServletException {
    return linesToInvoice(connectionProvider, invoicedate, org, warehouse, billto, shipto, parRefundLines, 0, 0);
  }

  public static ProductSecurityProcessData[] linesToInvoice(ConnectionProvider connectionProvider, String invoicedate, String org, String warehouse, String billto, String shipto, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT mp.M_PRODUCT_ID," +
      "               mp.C_UOM_ID," +
      "               mp.M_ATTRIBUTESETINSTANCE_ID," +
      "               ci.DESCRIPTION," +
      "               0  AS QTYINVOICED," +
      "               ci.C_INVOICE_ID," +
      "               (GRANDTOTAL - EM_SSWH_TOTALWITHHOLDINGINCOME - EM_SSWH_TOTALWITHHOLDINGVAT) AS GRANDTOTAL," +
      "               0 AS DISCOUNT," +
      "               C_GetTax(mp.M_PRODUCT_ID, to_date(?), ?, ?, ?, ?, null, 'N') AS TAX" +
      "        FROM C_INVOICE ci left join c_invoiceline cil on cil.c_invoice_id = ci.c_invoice_id  " +
      "             LEFT JOIN M_PRODUCT mp ON mp.M_PRODUCT_ID = cil.M_PRODUCT_ID" +
      "        WHERE 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":"  AND C_INVOICE_ID IN" + parRefundLines);
    strSql = strSql + 
      "              AND ci.AD_CLIENT_ID = cil.AD_CLIENT_ID" +
      "              AND ci.AD_ORG_ID = cil.AD_ORG_ID" +
      "        ORDER BY DOCUMENTNO";

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, org);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, warehouse);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, billto);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, shipto);
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectProductSecurityProcessData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectProductSecurityProcessData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectProductSecurityProcessData.description = UtilSql.getValue(result, "description");
        objectProductSecurityProcessData.qtyinvoiced = UtilSql.getValue(result, "qtyinvoiced");
        objectProductSecurityProcessData.cInvoiceId = UtilSql.getValue(result, "c_invoice_id");
        objectProductSecurityProcessData.grandtotal = UtilSql.getValue(result, "grandtotal");
        objectProductSecurityProcessData.discount = UtilSql.getValue(result, "discount");
        objectProductSecurityProcessData.tax = UtilSql.getValue(result, "tax");
        objectProductSecurityProcessData.rownum = Long.toString(countRecord);
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] selectCustomer(ConnectionProvider connectionProvider, String parRefundLines)    throws ServletException {
    return selectCustomer(connectionProvider, parRefundLines, 0, 0);
  }

  public static ProductSecurityProcessData[] selectCustomer(ConnectionProvider connectionProvider, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT C_BPARTNER_ID AS CUSTOMER_ID" +
      "      FROM C_INVOICE" +
      "      WHERE C_BPARTNER_ID IS NOT NULL" +
      "        AND 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":" AND C_INVOICE_ID IN" + parRefundLines);

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.customerId = UtilSql.getValue(result, "customer_id");
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRefundLines)    throws ServletException {
    return selectPriceList(connectionProvider, language, parRefundLines, 0, 0);
  }

  public static ProductSecurityProcessData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT C_BPARTNER.M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(C_BPARTNER.M_PRICELIST_ID), ?) AS PRICELISTID" +
      "        FROM C_INVOICE, C_BPARTNER" +
      "        WHERE 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":"  C_INVOICE_ID IN" + parRefundLines);

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectProductSecurityProcessData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRefundLines)    throws ServletException {
    return selectOrg(connectionProvider, language, parRefundLines, 0, 0);
  }

  public static ProductSecurityProcessData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRefundLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT AD_ORG_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_Org'), to_char(AD_ORG_ID), ?) AS ORG" +
      "        FROM C_INVOICE" +
      "        WHERE 1=1";
    strSql = strSql + ((parRefundLines==null || parRefundLines.equals(""))?"":" AND C_INVOICE_ID IN" + parRefundLines);

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRefundLines != null && !(parRefundLines.equals(""))) {
        }

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectProductSecurityProcessData.org = UtilSql.getValue(result, "org");
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static ProductSecurityProcessData[] selectCustomerData(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectCustomerData(connectionProvider, cBpartnerId, 0, 0);
  }

  public static ProductSecurityProcessData[] selectCustomerData(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT PaymentRule, C_PaymentTerm_ID, FIN_PaymentMethod_ID" +
      "      FROM C_BPartner" +
      "      WHERE C_BPartner_ID = ?";

    ResultSet result;
    Vector<ProductSecurityProcessData> vector = new Vector<ProductSecurityProcessData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

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
        ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
        objectProductSecurityProcessData.paymentrule = UtilSql.getValue(result, "paymentrule");
        objectProductSecurityProcessData.cPaymenttermId = UtilSql.getValue(result, "c_paymentterm_id");
        objectProductSecurityProcessData.finPaymentmethodId = UtilSql.getValue(result, "fin_paymentmethod_id");
        objectProductSecurityProcessData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectProductSecurityProcessData);
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
    ProductSecurityProcessData objectProductSecurityProcessData[] = new ProductSecurityProcessData[vector.size()];
    vector.copyInto(objectProductSecurityProcessData);
    return(objectProductSecurityProcessData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String partnerid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(?), to_char(?)) AS CUSTOMER" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, partnerid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "customer");
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

  public static String getPricelistVersion(ConnectionProvider connectionProvider, String pricelist, String invoicedate)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT M_GET_PRICELIST_VERSION(?, to_date(?)) AS PRICELISTID" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, invoicedate);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "pricelistid");
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

  public static String treeOrg(ConnectionProvider connectionProvider, String client)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_TREE_ORG_ID FROM AD_CLIENTINFO" +
      "        WHERE AD_CLIENT_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, client);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_tree_org_id");
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

  public static String cDoctypeTarget(ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_GET_DOCTYPE(?, ?, 'ARI', null) FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "ad_get_doctype");
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

  public static String cBPartnerLocationId(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE C_BPARTNER_ID = ?" +
      "        AND C_BPartner_Location.IsActive='Y'";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String billto(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT MAX(C_BPARTNER_LOCATION_ID) FROM C_BPARTNER_LOCATION" +
      "        WHERE  C_BPartner_Location.IsBillTo='Y'" +
      "        AND C_BPartner_Location.IsActive='Y'" +
      "        AND C_BPARTNER_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "max");
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

  public static String selectCurrency(ConnectionProvider connectionProvider, String mPricelistId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT C_CURRENCY_ID" +
      "        FROM M_PRICELIST" +
      "        WHERE  M_PRICELIST_ID = ?";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "c_currency_id");
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

  public static int unlock(ConnectionProvider connectionProvider, String refundlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_INVOICE  " +
      "        SET isactive ='Y'  " +
      "        WHERE C_INVOICE_ID IN ";
    strSql = strSql + ((refundlines==null || refundlines.equals(""))?"":refundlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (refundlines != null && !(refundlines.equals(""))) {
        }

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

  public static int lock(ConnectionProvider connectionProvider, String refundlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_INVOICE  " +
      "        SET isactive ='Y'  " +
      "        WHERE C_INVOICE_ID IN ";
    strSql = strSql + ((refundlines==null || refundlines.equals(""))?"":refundlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (refundlines != null && !(refundlines.equals(""))) {
        }

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

  public static int insertMaPcCase(Connection conn, ConnectionProvider connectionProvider, String maPcCaseId, String adClientId, String adOrgId, String user, String control, String productId, String attributeId, String name, String launched, String uomId, String referenceId, String DocTypeId, String documentno)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    INSERT INTO MA_PC_CASE(MA_PC_CASE_ID, AD_CLIENT_ID, AD_ORG_ID, ISACTIVE, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "               MA_PERIODIC_CONTROL_ID, M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID, NAME, STARTDATE, ENDDATE, LAUNCHED, EM_SLQS_UOM_ID," +
      "               EM_SLQS_M_PROD_LINE_ID, EM_SLQS_DOCUMENT_TYPE, EM_SLQS_DOCUMENTNO, EM_SLQS_STATUS, EM_SLQS_PROCESSED)" +
      "            VALUES(?, ?, ?, 'Y', now(), ?, now(), ?," +
      "               ?, ?, ?, ?, now(), now(), ?, ?," +
      "               ?,  ?, ?, null, 'N');   ";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, maPcCaseId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, control);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, attributeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, name);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, launched);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, uomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, referenceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, DocTypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentno);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertCInvoice(Connection conn, ConnectionProvider connectionProvider, String cInvoiceId, String adClientId, String adOrgId, String user, String documentNo, String docStatus, String docAction, String cDoctypeId, String cDoctypetargetId, String dateinvoiced, String dateacct, String cBpartnerId, String cBpartnerLocationId, String cCurrencyId, String paymentrule, String cPaymenttermId, String mPricelistId, String cProjectId, String cActivityId, String cCampaignId, String finPaymentMethodId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICE (C_INVOICE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, DOCUMENTNO," +
      "        DOCSTATUS, DOCACTION, C_DOCTYPE_ID, C_DOCTYPETARGET_ID," +
      "        DATEINVOICED, DATEACCT, C_BPARTNER_ID, C_BPARTNER_LOCATION_ID, C_CURRENCY_ID, " +
      "        PAYMENTRULE, C_PAYMENTTERM_ID, M_PRICELIST_ID, " +
      "        C_PROJECT_ID, C_ACTIVITY_ID, C_CAMPAIGN_ID, ISSOTRX," +
      "        FIN_PAYMENTMETHOD_ID)" +
      "        VALUES (?,?,?,now(),?,now(),?,?,?,?,?,?,TO_DATE(?),TO_DATE(?),?,?,?,?,?,?,?,?,?,'Y',?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docStatus);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, docAction);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypeId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cDoctypetargetId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, dateacct);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerLocationId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCurrencyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, paymentrule);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cPaymenttermId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mPricelistId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cProjectId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cActivityId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cCampaignId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, finPaymentMethodId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static int insertCInvoiceline(Connection conn, ConnectionProvider connectionProvider, String cInvoicelineId, String adClientId, String adOrgId, String user, String cInvoiceId, String line, String cBpartnerId, String description, String mProductId, String mAttributeSetInstanceId, String cUomId, String qtyinvoiced, String pricelist, String priceactual, String linenetamt, String taxamt, String taxbaseamt, String pricelimit, String cTaxId, String sResourceassignmentId, String pricestd)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO C_INVOICELINE (C_INVOICELINE_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY," +
      "        C_INVOICE_ID, LINE, C_BPARTNER_ID, DESCRIPTION, " +
      "        M_PRODUCT_ID, M_ATTRIBUTESETINSTANCE_ID," +
      "        C_UOM_ID, QTYINVOICED, PRICELIST, " +
      "        PRICEACTUAL, " +
      "        LINENETAMT," +
      "        TAXAMT," +
      "        TAXBASEAMT, PRICELIMIT, C_TAX_ID, S_RESOURCEASSIGNMENT_ID, PRICESTD)" +
      "        VALUES (?,?,?,now(),?,now(),?," +
      "        ?,TO_NUMBER(?),?,?," +
      "        ?,?," +
      "        ?,TO_NUMBER(?),TO_NUMBER(?)," +
      "        TO_NUMBER(?), " +
      "        TO_NUMBER(?)," +
      "        TO_NUMBER(?), " +
      "        TO_NUMBER(?), TO_NUMBER(?),?,?,TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoicelineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cBpartnerId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, description);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qtyinvoiced);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelist);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, priceactual);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, linenetamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, taxbaseamt);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelimit);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cTaxId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, sResourceassignmentId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricestd);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }

  public static ProductSecurityProcessData cInvoicePost0(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Invoice_Post0(?)";

    ProductSecurityProcessData objectProductSecurityProcessData = new ProductSecurityProcessData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adPinstanceId);

      SessionInfo.saveContextInfoIntoDB(conn);
      st.execute();
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    }
    else {
      Vector<String> parametersData = new Vector<String>();
      Vector<String> parametersTypes = new Vector<String>();
      parametersData.addElement(adPinstanceId);
      parametersTypes.addElement("in");
      try {
      RDBMSIndependent.getCallableResult(conn, connectionProvider, strSql, parametersData, parametersTypes, 0);
      } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
        throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
      } catch(NoConnectionAvailableException ec){
        log4j.error("Connection error in query: " + strSql + "Exception:"+ ec);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(PoolNotFoundException ep){
        log4j.error("Pool error in query: " + strSql + "Exception:"+ ep);
        throw new ServletException("@CODE=NoConnectionAvailable");
      } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
        throw new ServletException("@CODE=@" + ex.getMessage());
      }
    }
    return(objectProductSecurityProcessData);
  }

  public static int refunded(Connection conn, ConnectionProvider connectionProvider, String userId, String cInvoiceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE C_Invoice" +
      "        SET isactive = 'Y'," +
      "            Updated = TO_DATE(NOW())," +
      "            UpdatedBy = ?" +
      "            WHERE C_Invoice_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cInvoiceId);

      SessionInfo.saveContextInfoIntoDB(conn);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(updateCount);
  }
}
