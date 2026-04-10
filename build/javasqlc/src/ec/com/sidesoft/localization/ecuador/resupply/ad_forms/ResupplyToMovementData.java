//Sqlc generated V1.O00-1
package ec.com.sidesoft.localization.ecuador.resupply.ad_forms;

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

class ResupplyToMovementData implements FieldProvider {
static Logger log4j = Logger.getLogger(ResupplyToMovementData.class);
  private String InitRecordNumber="0";
  public String mRequisitionlineId;
  public String reqqty;
  public String matchedqty;
  public String qtytoorder;
  public String mPricelistId;
  public String needbydate;
  public String pricelist;
  public String price;
  public String mProductId;
  public String mAttributesetinstanceId;
  public String vendorId;
  public String vendor;
  public String product;
  public String attribute;
  public String requester;
  public String pricelistid;
  public String vendorpricelist;
  public String lockedby;
  public String lockqty;
  public String lockprice;
  public String adOrgId;
  public String org;
  public String invoicerule;
  public String deliveryrule;
  public String freightcostrule;
  public String deliveryviarule;
  public String paymentrulepo;
  public String poPaymenttermId;
  public String description;
  public String cUomId;
  public String quantityorder;
  public String mProductUomId;
  public String pricelimit;
  public String priceactual;
  public String discount;
  public String tax;
  public String cOrderlineId;
  public String padre;
  public String id;
  public String name;
  public String pricestd;
  public String toClose;
  public String uomname;
  public String secuomname;
  public String poPaymentmethodId;
  public String grossUnit;
  public String grossAmt;
  public String ssrsResupplylineId;
  public String ssrsResupplyId;
  public String documentno;
  public String adorgname;
  public String productcod;
  public String mproductid;
  public String mLocatorId;
  public String adOrgIdVal;
  public String adOrgIdGroup;
  public String emSsrsMLocatortrnId;
  public String emSsrsMLocatorrcpId;
  public String cero;
  public String stockact;
  public String stockres;
  public String emSsrsMWarehouseId;
  public String mLocatorIdVal2;
  public String guaranteedate;
  public String mLocatorIdVal1;
  public String mStorageDetailId;
  public String stockdis;
  public String line;
  public String orderedqty;
  public String lockqtyconversion;
  public String adOrgIdReq;
  public String cer0conversion;
  public String orgDoctypefrom;
  public String orgDoctypeto;
  public String orgDoctypefromreq;
  public String orgDoctypetoreq;
  public String emSsrsCDoctypefromId;
  public String emSsrsCDoctypetoId;
  public String docnosequenceIdFromSend;
  public String docnosequenceIdToSend;
  public String docnosequenceIdFromReception;
  public String docnosequenceIdToReception;
  public String rownum;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("m_requisitionline_id") || fieldName.equals("mRequisitionlineId"))
      return mRequisitionlineId;
    else if (fieldName.equalsIgnoreCase("reqqty"))
      return reqqty;
    else if (fieldName.equalsIgnoreCase("matchedqty"))
      return matchedqty;
    else if (fieldName.equalsIgnoreCase("qtytoorder"))
      return qtytoorder;
    else if (fieldName.equalsIgnoreCase("m_pricelist_id") || fieldName.equals("mPricelistId"))
      return mPricelistId;
    else if (fieldName.equalsIgnoreCase("needbydate"))
      return needbydate;
    else if (fieldName.equalsIgnoreCase("pricelist"))
      return pricelist;
    else if (fieldName.equalsIgnoreCase("price"))
      return price;
    else if (fieldName.equalsIgnoreCase("m_product_id") || fieldName.equals("mProductId"))
      return mProductId;
    else if (fieldName.equalsIgnoreCase("m_attributesetinstance_id") || fieldName.equals("mAttributesetinstanceId"))
      return mAttributesetinstanceId;
    else if (fieldName.equalsIgnoreCase("vendor_id") || fieldName.equals("vendorId"))
      return vendorId;
    else if (fieldName.equalsIgnoreCase("vendor"))
      return vendor;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("attribute"))
      return attribute;
    else if (fieldName.equalsIgnoreCase("requester"))
      return requester;
    else if (fieldName.equalsIgnoreCase("pricelistid"))
      return pricelistid;
    else if (fieldName.equalsIgnoreCase("vendorpricelist"))
      return vendorpricelist;
    else if (fieldName.equalsIgnoreCase("lockedby"))
      return lockedby;
    else if (fieldName.equalsIgnoreCase("lockqty"))
      return lockqty;
    else if (fieldName.equalsIgnoreCase("lockprice"))
      return lockprice;
    else if (fieldName.equalsIgnoreCase("ad_org_id") || fieldName.equals("adOrgId"))
      return adOrgId;
    else if (fieldName.equalsIgnoreCase("org"))
      return org;
    else if (fieldName.equalsIgnoreCase("invoicerule"))
      return invoicerule;
    else if (fieldName.equalsIgnoreCase("deliveryrule"))
      return deliveryrule;
    else if (fieldName.equalsIgnoreCase("freightcostrule"))
      return freightcostrule;
    else if (fieldName.equalsIgnoreCase("deliveryviarule"))
      return deliveryviarule;
    else if (fieldName.equalsIgnoreCase("paymentrulepo"))
      return paymentrulepo;
    else if (fieldName.equalsIgnoreCase("po_paymentterm_id") || fieldName.equals("poPaymenttermId"))
      return poPaymenttermId;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("c_uom_id") || fieldName.equals("cUomId"))
      return cUomId;
    else if (fieldName.equalsIgnoreCase("quantityorder"))
      return quantityorder;
    else if (fieldName.equalsIgnoreCase("m_product_uom_id") || fieldName.equals("mProductUomId"))
      return mProductUomId;
    else if (fieldName.equalsIgnoreCase("pricelimit"))
      return pricelimit;
    else if (fieldName.equalsIgnoreCase("priceactual"))
      return priceactual;
    else if (fieldName.equalsIgnoreCase("discount"))
      return discount;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("c_orderline_id") || fieldName.equals("cOrderlineId"))
      return cOrderlineId;
    else if (fieldName.equalsIgnoreCase("padre"))
      return padre;
    else if (fieldName.equalsIgnoreCase("id"))
      return id;
    else if (fieldName.equalsIgnoreCase("name"))
      return name;
    else if (fieldName.equalsIgnoreCase("pricestd"))
      return pricestd;
    else if (fieldName.equalsIgnoreCase("to_close") || fieldName.equals("toClose"))
      return toClose;
    else if (fieldName.equalsIgnoreCase("uomname"))
      return uomname;
    else if (fieldName.equalsIgnoreCase("secuomname"))
      return secuomname;
    else if (fieldName.equalsIgnoreCase("po_paymentmethod_id") || fieldName.equals("poPaymentmethodId"))
      return poPaymentmethodId;
    else if (fieldName.equalsIgnoreCase("gross_unit") || fieldName.equals("grossUnit"))
      return grossUnit;
    else if (fieldName.equalsIgnoreCase("gross_amt") || fieldName.equals("grossAmt"))
      return grossAmt;
    else if (fieldName.equalsIgnoreCase("ssrs_resupplyline_id") || fieldName.equals("ssrsResupplylineId"))
      return ssrsResupplylineId;
    else if (fieldName.equalsIgnoreCase("ssrs_resupply_id") || fieldName.equals("ssrsResupplyId"))
      return ssrsResupplyId;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("adorgname"))
      return adorgname;
    else if (fieldName.equalsIgnoreCase("productcod"))
      return productcod;
    else if (fieldName.equalsIgnoreCase("mproductid"))
      return mproductid;
    else if (fieldName.equalsIgnoreCase("m_locator_id") || fieldName.equals("mLocatorId"))
      return mLocatorId;
    else if (fieldName.equalsIgnoreCase("ad_org_id_val") || fieldName.equals("adOrgIdVal"))
      return adOrgIdVal;
    else if (fieldName.equalsIgnoreCase("ad_org_id_group") || fieldName.equals("adOrgIdGroup"))
      return adOrgIdGroup;
    else if (fieldName.equalsIgnoreCase("em_ssrs_m_locatortrn_id") || fieldName.equals("emSsrsMLocatortrnId"))
      return emSsrsMLocatortrnId;
    else if (fieldName.equalsIgnoreCase("em_ssrs_m_locatorrcp_id") || fieldName.equals("emSsrsMLocatorrcpId"))
      return emSsrsMLocatorrcpId;
    else if (fieldName.equalsIgnoreCase("cero"))
      return cero;
    else if (fieldName.equalsIgnoreCase("stockact"))
      return stockact;
    else if (fieldName.equalsIgnoreCase("stockres"))
      return stockres;
    else if (fieldName.equalsIgnoreCase("em_ssrs_m_warehouse_id") || fieldName.equals("emSsrsMWarehouseId"))
      return emSsrsMWarehouseId;
    else if (fieldName.equalsIgnoreCase("m_locator_id_val2") || fieldName.equals("mLocatorIdVal2"))
      return mLocatorIdVal2;
    else if (fieldName.equalsIgnoreCase("guaranteedate"))
      return guaranteedate;
    else if (fieldName.equalsIgnoreCase("m_locator_id_val1") || fieldName.equals("mLocatorIdVal1"))
      return mLocatorIdVal1;
    else if (fieldName.equalsIgnoreCase("m_storage_detail_id") || fieldName.equals("mStorageDetailId"))
      return mStorageDetailId;
    else if (fieldName.equalsIgnoreCase("stockdis"))
      return stockdis;
    else if (fieldName.equalsIgnoreCase("line"))
      return line;
    else if (fieldName.equalsIgnoreCase("orderedqty"))
      return orderedqty;
    else if (fieldName.equalsIgnoreCase("lockqtyconversion"))
      return lockqtyconversion;
    else if (fieldName.equalsIgnoreCase("ad_org_id_req") || fieldName.equals("adOrgIdReq"))
      return adOrgIdReq;
    else if (fieldName.equalsIgnoreCase("cer0conversion"))
      return cer0conversion;
    else if (fieldName.equalsIgnoreCase("org_doctypefrom") || fieldName.equals("orgDoctypefrom"))
      return orgDoctypefrom;
    else if (fieldName.equalsIgnoreCase("org_doctypeto") || fieldName.equals("orgDoctypeto"))
      return orgDoctypeto;
    else if (fieldName.equalsIgnoreCase("org_doctypefromreq") || fieldName.equals("orgDoctypefromreq"))
      return orgDoctypefromreq;
    else if (fieldName.equalsIgnoreCase("org_doctypetoreq") || fieldName.equals("orgDoctypetoreq"))
      return orgDoctypetoreq;
    else if (fieldName.equalsIgnoreCase("em_ssrs_c_doctypefrom_id") || fieldName.equals("emSsrsCDoctypefromId"))
      return emSsrsCDoctypefromId;
    else if (fieldName.equalsIgnoreCase("em_ssrs_c_doctypeto_id") || fieldName.equals("emSsrsCDoctypetoId"))
      return emSsrsCDoctypetoId;
    else if (fieldName.equalsIgnoreCase("docnosequence_id_from_send") || fieldName.equals("docnosequenceIdFromSend"))
      return docnosequenceIdFromSend;
    else if (fieldName.equalsIgnoreCase("docnosequence_id_to_send") || fieldName.equals("docnosequenceIdToSend"))
      return docnosequenceIdToSend;
    else if (fieldName.equalsIgnoreCase("docnosequence_id_from_reception") || fieldName.equals("docnosequenceIdFromReception"))
      return docnosequenceIdFromReception;
    else if (fieldName.equalsIgnoreCase("docnosequence_id_to_reception") || fieldName.equals("docnosequenceIdToReception"))
      return docnosequenceIdToReception;
    else if (fieldName.equals("rownum"))
      return rownum;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static ResupplyToMovementData[] select(ConnectionProvider connectionProvider)    throws ServletException {
    return select(connectionProvider, 0, 0);
  }

  public static ResupplyToMovementData[] select(ConnectionProvider connectionProvider, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT '' AS M_REQUISITIONLINE_ID, '' AS REQQTY, '' AS MATCHEDQTY, '' AS QTYTOORDER, " +
      "          '' AS M_PRICELIST_ID, '' AS NEEDBYDATE, '' AS PRICELIST, '' AS PRICE," +
      "          '' AS M_PRODUCT_ID, '' AS M_ATTRIBUTESETINSTANCE_ID, '' AS VENDOR_ID, '' AS VENDOR, " +
      "          '' AS PRODUCT, '' AS ATTRIBUTE, ''  AS REQUESTER, '' AS PRICELISTID, '' AS VENDORPRICELIST," +
      "          '' AS LOCKEDBY, '' AS LOCKQTY, '' AS LOCKPRICE, '' AS AD_ORG_ID, '' AS ORG, " +
      "          '' AS InvoiceRule, '' AS DeliveryRule, '' AS FreightCostRule, '' AS DeliveryViaRule," +
      "          '' AS PaymentRulePO, '' AS PO_PaymentTerm_ID, '' AS DESCRIPTION, '' AS C_UOM_ID, '' AS QUANTITYORDER, '' AS M_PRODUCT_UOM_ID," +
      "          '' AS PRICELIMIT, '' AS PRICEACTUAL, '' AS DISCOUNT, '' AS TAX, '' AS C_ORDERLINE_ID," +
      "          '' AS PADRE, '' AS ID, '' AS NAME, '' AS PRICESTD, '' AS TO_CLOSE, '' AS UOMNAME, '' AS SECUOMNAME, '' AS PO_PAYMENTMETHOD_ID," +
      "          '' as GROSS_UNIT, '' AS GROSS_AMT," +
      "          '' AS SSRS_RESUPPLYLINE_ID," +
      "          '' AS SSRS_RESUPPLY_ID," +
      "          '' AS DOCUMENTNO," +
      "          '' AS ADORGNAME," +
      "          '' AS PRODUCTCOD," +
      "          '' AS MPRODUCTID," +
      "          '' AS M_LOCATOR_ID," +
      "          '' AS AD_ORG_ID_VAL," +
      "          '' AS AD_ORG_ID_GROUP," +
      "          '' AS EM_SSRS_M_LOCATORTRN_ID," +
      "          '' AS EM_SSRS_M_LOCATORRCP_ID," +
      "          '' AS CERO," +
      "          '' AS STOCKACT," +
      "          '' AS STOCKRES," +
      "          '' AS EM_SSRS_M_WAREHOUSE_ID," +
      "          '' AS M_LOCATOR_ID_VAL2," +
      "          '' AS GUARANTEEDATE," +
      "          '' AS M_LOCATOR_ID_VAL1," +
      "          '' AS M_STORAGE_DETAIL_ID," +
      "          '' AS STOCKDIS," +
      "          '' AS LINE," +
      "          '' AS ORDEREDQTY," +
      "          '' AS LOCKQTYCONVERSION," +
      "          '' AS AD_ORG_ID_REQ," +
      "          '' AS CER0CONVERSION," +
      "          '' AS ORG_DOCTYPEFROM," +
      "          '' AS ORG_DOCTYPETO," +
      "          '' AS ORG_DOCTYPEFROMREQ," +
      "          '' AS ORG_DOCTYPETOREQ," +
      "          '' AS EM_SSRS_C_DOCTYPEFROM_ID," +
      "          '' AS EM_SSRS_C_DOCTYPETO_ID," +
      "          '' AS DOCNOSEQUENCE_ID_FROM_SEND," +
      "          '' AS DOCNOSEQUENCE_ID_TO_SEND," +
      "          '' AS DOCNOSEQUENCE_ID_FROM_RECEPTION," +
      "          '' AS DOCNOSEQUENCE_ID_TO_RECEPTION" +
      "        FROM DUAL";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.mRequisitionlineId = UtilSql.getValue(result, "m_requisitionline_id");
        objectResupplyToMovementData.reqqty = UtilSql.getValue(result, "reqqty");
        objectResupplyToMovementData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectResupplyToMovementData.qtytoorder = UtilSql.getValue(result, "qtytoorder");
        objectResupplyToMovementData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectResupplyToMovementData.needbydate = UtilSql.getValue(result, "needbydate");
        objectResupplyToMovementData.pricelist = UtilSql.getValue(result, "pricelist");
        objectResupplyToMovementData.price = UtilSql.getValue(result, "price");
        objectResupplyToMovementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectResupplyToMovementData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectResupplyToMovementData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectResupplyToMovementData.vendor = UtilSql.getValue(result, "vendor");
        objectResupplyToMovementData.product = UtilSql.getValue(result, "product");
        objectResupplyToMovementData.attribute = UtilSql.getValue(result, "attribute");
        objectResupplyToMovementData.requester = UtilSql.getValue(result, "requester");
        objectResupplyToMovementData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectResupplyToMovementData.vendorpricelist = UtilSql.getValue(result, "vendorpricelist");
        objectResupplyToMovementData.lockedby = UtilSql.getValue(result, "lockedby");
        objectResupplyToMovementData.lockqty = UtilSql.getValue(result, "lockqty");
        objectResupplyToMovementData.lockprice = UtilSql.getValue(result, "lockprice");
        objectResupplyToMovementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectResupplyToMovementData.org = UtilSql.getValue(result, "org");
        objectResupplyToMovementData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectResupplyToMovementData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectResupplyToMovementData.freightcostrule = UtilSql.getValue(result, "freightcostrule");
        objectResupplyToMovementData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectResupplyToMovementData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectResupplyToMovementData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectResupplyToMovementData.description = UtilSql.getValue(result, "description");
        objectResupplyToMovementData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectResupplyToMovementData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectResupplyToMovementData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectResupplyToMovementData.pricelimit = UtilSql.getValue(result, "pricelimit");
        objectResupplyToMovementData.priceactual = UtilSql.getValue(result, "priceactual");
        objectResupplyToMovementData.discount = UtilSql.getValue(result, "discount");
        objectResupplyToMovementData.tax = UtilSql.getValue(result, "tax");
        objectResupplyToMovementData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectResupplyToMovementData.padre = UtilSql.getValue(result, "padre");
        objectResupplyToMovementData.id = UtilSql.getValue(result, "id");
        objectResupplyToMovementData.name = UtilSql.getValue(result, "name");
        objectResupplyToMovementData.pricestd = UtilSql.getValue(result, "pricestd");
        objectResupplyToMovementData.toClose = UtilSql.getValue(result, "to_close");
        objectResupplyToMovementData.uomname = UtilSql.getValue(result, "uomname");
        objectResupplyToMovementData.secuomname = UtilSql.getValue(result, "secuomname");
        objectResupplyToMovementData.poPaymentmethodId = UtilSql.getValue(result, "po_paymentmethod_id");
        objectResupplyToMovementData.grossUnit = UtilSql.getValue(result, "gross_unit");
        objectResupplyToMovementData.grossAmt = UtilSql.getValue(result, "gross_amt");
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.ssrsResupplyId = UtilSql.getValue(result, "ssrs_resupply_id");
        objectResupplyToMovementData.documentno = UtilSql.getValue(result, "documentno");
        objectResupplyToMovementData.adorgname = UtilSql.getValue(result, "adorgname");
        objectResupplyToMovementData.productcod = UtilSql.getValue(result, "productcod");
        objectResupplyToMovementData.mproductid = UtilSql.getValue(result, "mproductid");
        objectResupplyToMovementData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectResupplyToMovementData.adOrgIdVal = UtilSql.getValue(result, "ad_org_id_val");
        objectResupplyToMovementData.adOrgIdGroup = UtilSql.getValue(result, "ad_org_id_group");
        objectResupplyToMovementData.emSsrsMLocatortrnId = UtilSql.getValue(result, "em_ssrs_m_locatortrn_id");
        objectResupplyToMovementData.emSsrsMLocatorrcpId = UtilSql.getValue(result, "em_ssrs_m_locatorrcp_id");
        objectResupplyToMovementData.cero = UtilSql.getValue(result, "cero");
        objectResupplyToMovementData.stockact = UtilSql.getValue(result, "stockact");
        objectResupplyToMovementData.stockres = UtilSql.getValue(result, "stockres");
        objectResupplyToMovementData.emSsrsMWarehouseId = UtilSql.getValue(result, "em_ssrs_m_warehouse_id");
        objectResupplyToMovementData.mLocatorIdVal2 = UtilSql.getValue(result, "m_locator_id_val2");
        objectResupplyToMovementData.guaranteedate = UtilSql.getValue(result, "guaranteedate");
        objectResupplyToMovementData.mLocatorIdVal1 = UtilSql.getValue(result, "m_locator_id_val1");
        objectResupplyToMovementData.mStorageDetailId = UtilSql.getValue(result, "m_storage_detail_id");
        objectResupplyToMovementData.stockdis = UtilSql.getValue(result, "stockdis");
        objectResupplyToMovementData.line = UtilSql.getValue(result, "line");
        objectResupplyToMovementData.orderedqty = UtilSql.getValue(result, "orderedqty");
        objectResupplyToMovementData.lockqtyconversion = UtilSql.getValue(result, "lockqtyconversion");
        objectResupplyToMovementData.adOrgIdReq = UtilSql.getValue(result, "ad_org_id_req");
        objectResupplyToMovementData.cer0conversion = UtilSql.getValue(result, "cer0conversion");
        objectResupplyToMovementData.orgDoctypefrom = UtilSql.getValue(result, "org_doctypefrom");
        objectResupplyToMovementData.orgDoctypeto = UtilSql.getValue(result, "org_doctypeto");
        objectResupplyToMovementData.orgDoctypefromreq = UtilSql.getValue(result, "org_doctypefromreq");
        objectResupplyToMovementData.orgDoctypetoreq = UtilSql.getValue(result, "org_doctypetoreq");
        objectResupplyToMovementData.emSsrsCDoctypefromId = UtilSql.getValue(result, "em_ssrs_c_doctypefrom_id");
        objectResupplyToMovementData.emSsrsCDoctypetoId = UtilSql.getValue(result, "em_ssrs_c_doctypeto_id");
        objectResupplyToMovementData.docnosequenceIdFromSend = UtilSql.getValue(result, "docnosequence_id_from_send");
        objectResupplyToMovementData.docnosequenceIdToSend = UtilSql.getValue(result, "docnosequence_id_to_send");
        objectResupplyToMovementData.docnosequenceIdFromReception = UtilSql.getValue(result, "docnosequence_id_from_reception");
        objectResupplyToMovementData.docnosequenceIdToReception = UtilSql.getValue(result, "docnosequence_id_to_reception");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] set()    throws ServletException {
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[1];
    objectResupplyToMovementData[0] = new ResupplyToMovementData();
    objectResupplyToMovementData[0].mRequisitionlineId = "";
    objectResupplyToMovementData[0].reqqty = "";
    objectResupplyToMovementData[0].matchedqty = "";
    objectResupplyToMovementData[0].qtytoorder = "";
    objectResupplyToMovementData[0].mPricelistId = "";
    objectResupplyToMovementData[0].needbydate = "";
    objectResupplyToMovementData[0].pricelist = "";
    objectResupplyToMovementData[0].price = "";
    objectResupplyToMovementData[0].mProductId = "";
    objectResupplyToMovementData[0].mAttributesetinstanceId = "";
    objectResupplyToMovementData[0].vendorId = "";
    objectResupplyToMovementData[0].vendor = "";
    objectResupplyToMovementData[0].product = "";
    objectResupplyToMovementData[0].attribute = "";
    objectResupplyToMovementData[0].requester = "";
    objectResupplyToMovementData[0].pricelistid = "";
    objectResupplyToMovementData[0].vendorpricelist = "";
    objectResupplyToMovementData[0].lockedby = "";
    objectResupplyToMovementData[0].lockqty = "";
    objectResupplyToMovementData[0].lockprice = "";
    objectResupplyToMovementData[0].adOrgId = "";
    objectResupplyToMovementData[0].org = "";
    objectResupplyToMovementData[0].invoicerule = "";
    objectResupplyToMovementData[0].deliveryrule = "";
    objectResupplyToMovementData[0].freightcostrule = "";
    objectResupplyToMovementData[0].deliveryviarule = "";
    objectResupplyToMovementData[0].paymentrulepo = "";
    objectResupplyToMovementData[0].poPaymenttermId = "";
    objectResupplyToMovementData[0].description = "";
    objectResupplyToMovementData[0].cUomId = "";
    objectResupplyToMovementData[0].quantityorder = "";
    objectResupplyToMovementData[0].mProductUomId = "";
    objectResupplyToMovementData[0].pricelimit = "";
    objectResupplyToMovementData[0].priceactual = "";
    objectResupplyToMovementData[0].discount = "";
    objectResupplyToMovementData[0].tax = "";
    objectResupplyToMovementData[0].cOrderlineId = "";
    objectResupplyToMovementData[0].padre = "";
    objectResupplyToMovementData[0].id = "";
    objectResupplyToMovementData[0].name = "";
    objectResupplyToMovementData[0].pricestd = "";
    objectResupplyToMovementData[0].toClose = "";
    objectResupplyToMovementData[0].uomname = "";
    objectResupplyToMovementData[0].secuomname = "";
    objectResupplyToMovementData[0].poPaymentmethodId = "";
    objectResupplyToMovementData[0].grossUnit = "";
    objectResupplyToMovementData[0].grossAmt = "";
    objectResupplyToMovementData[0].ssrsResupplylineId = "";
    objectResupplyToMovementData[0].ssrsResupplyId = "";
    objectResupplyToMovementData[0].documentno = "";
    objectResupplyToMovementData[0].adorgname = "";
    objectResupplyToMovementData[0].productcod = "";
    objectResupplyToMovementData[0].mproductid = "";
    objectResupplyToMovementData[0].mLocatorId = "";
    objectResupplyToMovementData[0].adOrgIdVal = "";
    objectResupplyToMovementData[0].adOrgIdGroup = "";
    objectResupplyToMovementData[0].emSsrsMLocatortrnId = "";
    objectResupplyToMovementData[0].emSsrsMLocatorrcpId = "";
    objectResupplyToMovementData[0].cero = "";
    objectResupplyToMovementData[0].stockact = "";
    objectResupplyToMovementData[0].stockres = "";
    objectResupplyToMovementData[0].emSsrsMWarehouseId = "";
    objectResupplyToMovementData[0].mLocatorIdVal2 = "";
    objectResupplyToMovementData[0].guaranteedate = "";
    objectResupplyToMovementData[0].mLocatorIdVal1 = "";
    objectResupplyToMovementData[0].mStorageDetailId = "";
    objectResupplyToMovementData[0].stockdis = "";
    objectResupplyToMovementData[0].line = "";
    objectResupplyToMovementData[0].orderedqty = "";
    objectResupplyToMovementData[0].lockqtyconversion = "";
    objectResupplyToMovementData[0].adOrgIdReq = "";
    objectResupplyToMovementData[0].cer0conversion = "";
    objectResupplyToMovementData[0].orgDoctypefrom = "";
    objectResupplyToMovementData[0].orgDoctypeto = "";
    objectResupplyToMovementData[0].orgDoctypefromreq = "";
    objectResupplyToMovementData[0].orgDoctypetoreq = "";
    objectResupplyToMovementData[0].emSsrsCDoctypefromId = "";
    objectResupplyToMovementData[0].emSsrsCDoctypetoId = "";
    objectResupplyToMovementData[0].docnosequenceIdFromSend = "";
    objectResupplyToMovementData[0].docnosequenceIdToSend = "";
    objectResupplyToMovementData[0].docnosequenceIdFromReception = "";
    objectResupplyToMovementData[0].docnosequenceIdToReception = "";
    return objectResupplyToMovementData;
  }

  public static ResupplyToMovementData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parProduct, String parRequester, String parVendorInc, String parVendor, String parDocumentNoFrom, String parDocumentNoTo)    throws ServletException {
    return selectLines(connectionProvider, language, adUserClient, adOrgId, parDateFrom, parDateTo, parProduct, parRequester, parVendorInc, parVendor, parDocumentNoFrom, parDocumentNoTo, 0, 0);
  }

  public static ResupplyToMovementData[] selectLines(ConnectionProvider connectionProvider, String language, String adUserClient, String adOrgId, String parDateFrom, String parDateTo, String parProduct, String parRequester, String parVendorInc, String parVendor, String parDocumentNoFrom, String parDocumentNoTo, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT SSRS_RESUPPLYLINE_ID, " +
      "                SSRS_RESUPPLY.DOCUMENTNO," +
      "                AD_ORG.NAME AS ADORGNAME," +
      "                ROUND((SSRS_RESUPPLYLINE.QTY - SSRS_RESUPPLYLINE.ORDEREDQTY) / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS QTYTOORDER," +
      "                C_UOM1.NAME AS SECUOMNAME, " +
      "                C_UOM.NAME AS UOMNAME," +
      "                M_PRODUCT.VALUE AS PRODUCTCOD," +
      "                SSRS_RESUPPLYLINE.NEEDBYDATE," +
      "                AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID)), ?) AS VENDOR," +
      "                AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(SSRS_RESUPPLYLINE.M_PRODUCT_ID), ?) AS PRODUCT," +
      "                AD_COLUMN_IDENTIFIER(to_char('AD_User'), to_char(SSRS_RESUPPLY.AD_USER_ID), ?) AS REQUESTER" +
      "         FROM SSRS_RESUPPLY " +
      "               inner join SSRS_RESUPPLYLINE on SSRS_RESUPPLY.SSRS_RESUPPLY_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLY_ID" +
      "               LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = SSRS_RESUPPLYLINE.C_UOM_ID" +
      "               LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = SSRS_RESUPPLYLINE.M_PRODUCT_UOM_ID" +
      "               LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID " +
      "               LEFT JOIN AD_ORG ON SSRS_RESUPPLY.AD_ORG_ID = AD_ORG.AD_ORG_ID    " +
      "               LEFT JOIN C_UOM_CONVERSION ON C_UOM1.C_UOM_ID  = C_UOM_CONVERSION.C_UOM_ID AND SSRS_RESUPPLYLINE.C_UOM_ID = C_UOM_CONVERSION.C_UOM_TO_ID" +
      "               LEFT JOIN M_PRODUCT ON SSRS_RESUPPLYLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID                     " +
      "        WHERE SSRS_RESUPPLY.ISACTIVE = 'Y'" +
      "          AND SSRS_RESUPPLYLINE.ISACTIVE = 'Y'" +
      "          AND SSRS_RESUPPLY.DOCSTATUS = 'CO'" +
      "          AND SSRS_RESUPPLYLINE.REQSTATUS = 'O'" +
      "          AND SSRS_RESUPPLYLINE.QTY > SSRS_RESUPPLYLINE.ORDEREDQTY" +
      "          AND (SSRS_RESUPPLYLINE.LOCKEDBY IS NULL OR COALESCE (SSRS_RESUPPLYLINE.LOCKDATE, TO_DATE('01-01-1900', 'DD-MM-YYYY')) < (now()-3))" +
      "          AND SSRS_RESUPPLY.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "          AND SSRS_RESUPPLY.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND 1=1";
    strSql = strSql + ((parDateFrom==null || parDateFrom.equals(""))?"":"  AND SSRS_RESUPPLYLINE.NEEDBYDATE >= TO_DATE(?) ");
    strSql = strSql + ((parDateTo==null || parDateTo.equals(""))?"":"  AND SSRS_RESUPPLYLINE.NEEDBYDATE < TO_DATE(?) ");
    strSql = strSql + ((parProduct==null || parProduct.equals(""))?"":"  AND SSRS_RESUPPLYLINE.M_PRODUCT_ID = TO_CHAR(?) ");
    strSql = strSql + ((parRequester==null || parRequester.equals(""))?"":"  AND SSRS_RESUPPLY.AD_USER_ID = TO_CHAR(?) ");
    strSql = strSql + ((parVendorInc==null || parVendorInc.equals(""))?"":"  AND (COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID,'-1') = TO_CHAR(?) OR (SSRS_RESUPPLYLINE.C_BPARTNER_ID IS NULL AND SSRS_RESUPPLY.C_BPARTNER_ID IS NULL)) ");
    strSql = strSql + ((parVendor==null || parVendor.equals(""))?"":"  AND COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID,'-1') = TO_CHAR(?) ");
    strSql = strSql + ((parDocumentNoFrom==null || parDocumentNoFrom.equals(""))?"":"  AND SSRS_RESUPPLY.DOCUMENTNO >= TO_CHAR(?) ");
    strSql = strSql + ((parDocumentNoTo==null || parDocumentNoTo.equals(""))?"":"  AND SSRS_RESUPPLY.DOCUMENTNO <= TO_CHAR(?) ");
    strSql = strSql + 
      "        ORDER BY SSRS_RESUPPLY.DOCUMENTNO,SSRS_RESUPPLYLINE.LINE,SSRS_RESUPPLYLINE.NEEDBYDATE, SSRS_RESUPPLYLINE.M_PRODUCT_ID, SSRS_RESUPPLYLINE.M_ATTRIBUTESETINSTANCE_ID";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (parDateFrom != null && !(parDateFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateFrom);
      }
      if (parDateTo != null && !(parDateTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDateTo);
      }
      if (parProduct != null && !(parProduct.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parProduct);
      }
      if (parRequester != null && !(parRequester.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parRequester);
      }
      if (parVendorInc != null && !(parVendorInc.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendorInc);
      }
      if (parVendor != null && !(parVendor.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parVendor);
      }
      if (parDocumentNoFrom != null && !(parDocumentNoFrom.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDocumentNoFrom);
      }
      if (parDocumentNoTo != null && !(parDocumentNoTo.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, parDocumentNoTo);
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.documentno = UtilSql.getValue(result, "documentno");
        objectResupplyToMovementData.adorgname = UtilSql.getValue(result, "adorgname");
        objectResupplyToMovementData.qtytoorder = UtilSql.getValue(result, "qtytoorder");
        objectResupplyToMovementData.secuomname = UtilSql.getValue(result, "secuomname");
        objectResupplyToMovementData.uomname = UtilSql.getValue(result, "uomname");
        objectResupplyToMovementData.productcod = UtilSql.getValue(result, "productcod");
        objectResupplyToMovementData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectResupplyToMovementData.vendor = UtilSql.getValue(result, "vendor");
        objectResupplyToMovementData.product = UtilSql.getValue(result, "product");
        objectResupplyToMovementData.requester = UtilSql.getValue(result, "requester");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectSelected(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId)    throws ServletException {
    return selectSelected(connectionProvider, language, adUserId, adUserClient, adOrgId, 0, 0);
  }

  public static ResupplyToMovementData[] selectSelected(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID, " +
      "                 SSRS_RESUPPLYLINE.NEEDBYDATE, " +
      "                 SSRS_RESUPPLY.DOCUMENTNO," +
      "                 SSRS_RESUPPLY.AD_ORG_ID," +
      "                 AD_ORG.NAME AS ADORGNAME," +
      "                 AD_ORG.NAME AS ADORGNAME," +
      "                 M_PRODUCT.VALUE AS PRODUCTCOD," +
      "                 QUANTITYORDER, " +
      "                 ROUND(SSRS_RESUPPLYLINE.QTY / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS REQQTY," +
      "                 ROUND(SSRS_RESUPPLYLINE.ORDEREDQTY / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS MATCHEDQTY," +
      "                 ROUND(COALESCE(LOCKQTY, QTY-ORDEREDQTY) / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS LOCKQTY," +
      "                 C_UOM1.NAME AS SECUOMNAME, " +
      "                 C_UOM.NAME AS UOMNAME," +
      "                 COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID, '-1') AS VENDOR_ID," +
      "                 AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID)), ?) AS VENDOR," +
      "                 AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(SSRS_RESUPPLYLINE.M_PRODUCT_ID), ?) AS PRODUCT," +
      "                 AD_COLUMN_IDENTIFIER(to_char('M_AttributeSetInstance'), to_char(SSRS_RESUPPLYLINE.M_ATTRIBUTESETINSTANCE_ID), ?) AS ATTRIBUTE," +
      "                 TO_NUMBER(CASE WHEN STOCKACT IS NULL THEN 0 ELSE STOCKACT END) AS STOCKACT," +
      "                 TO_NUMBER(CASE WHEN STOCKRES IS NULL THEN 0 ELSE STOCKRES END) AS STOCKRES," +
      "                 TRUNC((TO_NUMBER(CASE WHEN STOCKACT IS NULL THEN 0 ELSE STOCKACT END) + TO_NUMBER(CASE WHEN STOCKRES IS NULL THEN 0 ELSE STOCKRES END))  " +
      "                 / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),0) AS STOCKDIS," +
      "                 SSRS_RESUPPLYLINE.LINE" +
      "        FROM SSRS_RESUPPLY " +
      "                 inner join SSRS_RESUPPLYLINE on SSRS_RESUPPLY.SSRS_RESUPPLY_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLY_ID " +
      "                 LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = SSRS_RESUPPLYLINE.C_UOM_ID" +
      "                 LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = SSRS_RESUPPLYLINE.M_PRODUCT_UOM_ID" +
      "                 LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "                 LEFT JOIN AD_ORG ON SSRS_RESUPPLY.AD_ORG_ID = AD_ORG.AD_ORG_ID    " +
      "                 LEFT JOIN C_UOM_CONVERSION ON C_UOM1.C_UOM_ID  = C_UOM_CONVERSION.C_UOM_ID AND SSRS_RESUPPLYLINE.C_UOM_ID = C_UOM_CONVERSION.C_UOM_TO_ID" +
      "                 LEFT JOIN M_PRODUCT ON SSRS_RESUPPLYLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "                 LEFT JOIN (SELECT M_LOCATOR.M_WAREHOUSE_ID,M_STORAGE_DETAIL.M_PRODUCT_ID," +
      "                               SUM(M_STORAGE_DETAIL.QTYONHAND) AS STOCKACT," +
      "                               SUM(M_STORAGE_DETAIL.PREQTYONHAND) AS STOCKRES" +
      "                            FROM M_LOCATOR " +
      "                            LEFT JOIN M_STORAGE_DETAIL ON M_STORAGE_DETAIL.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID " +
      "                            LEFT JOIN M_ATTRIBUTESETINSTANCE ON M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID = M_STORAGE_DETAIL.M_ATTRIBUTESETINSTANCE_ID" +
      "                            GROUP BY M_LOCATOR.M_WAREHOUSE_ID, M_STORAGE_DETAIL.M_PRODUCT_ID) STOCK ON STOCK.M_PRODUCT_ID = SSRS_RESUPPLYLINE.M_PRODUCT_ID " +
      "                                                                                                    AND STOCK.M_WAREHOUSE_ID =  M_PRODUCT.EM_SSRS_M_WAREHOUSE_ID          " +
      "        WHERE SSRS_RESUPPLY.ISACTIVE = 'Y'" +
      "                  AND SSRS_RESUPPLYLINE.ISACTIVE = 'Y'" +
      "                  AND SSRS_RESUPPLY.DOCSTATUS = 'CO'" +
      "                  AND SSRS_RESUPPLYLINE.REQSTATUS = 'O'" +
      "                  AND SSRS_RESUPPLYLINE.LOCKEDBY = ?" +
      "                  AND SSRS_RESUPPLYLINE.LOCKDATE >= (now()-3)" +
      "                  AND SSRS_RESUPPLY.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                  AND SSRS_RESUPPLY.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")                  " +
      "        ORDER BY SSRS_RESUPPLY.AD_ORG_ID,SSRS_RESUPPLY.DOCUMENTNO,SSRS_RESUPPLYLINE.LINE";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectResupplyToMovementData.documentno = UtilSql.getValue(result, "documentno");
        objectResupplyToMovementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectResupplyToMovementData.adorgname = UtilSql.getValue(result, "adorgname");
        objectResupplyToMovementData.adorgname = UtilSql.getValue(result, "adorgname");
        objectResupplyToMovementData.productcod = UtilSql.getValue(result, "productcod");
        objectResupplyToMovementData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectResupplyToMovementData.reqqty = UtilSql.getValue(result, "reqqty");
        objectResupplyToMovementData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectResupplyToMovementData.lockqty = UtilSql.getValue(result, "lockqty");
        objectResupplyToMovementData.secuomname = UtilSql.getValue(result, "secuomname");
        objectResupplyToMovementData.uomname = UtilSql.getValue(result, "uomname");
        objectResupplyToMovementData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectResupplyToMovementData.vendor = UtilSql.getValue(result, "vendor");
        objectResupplyToMovementData.product = UtilSql.getValue(result, "product");
        objectResupplyToMovementData.attribute = UtilSql.getValue(result, "attribute");
        objectResupplyToMovementData.stockact = UtilSql.getValue(result, "stockact");
        objectResupplyToMovementData.stockres = UtilSql.getValue(result, "stockres");
        objectResupplyToMovementData.stockdis = UtilSql.getValue(result, "stockdis");
        objectResupplyToMovementData.line = UtilSql.getValue(result, "line");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] linesToOrder(ConnectionProvider connectionProvider, String adOrgId, String parRequisitionLines)    throws ServletException {
    return linesToOrder(connectionProvider, adOrgId, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] linesToOrder(ConnectionProvider connectionProvider, String adOrgId, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT SSRS_RESUPPLYLINE.M_PRODUCT_ID, " +
      "              M_PRODUCT.M_ATTRIBUTESETINSTANCE_ID, " +
      "              SSRS_RESUPPLYLINE.LOCKQTY," +
      "              SSRS_RESUPPLYLINE.ORDEREDQTY," +
      "              SSRS_RESUPPLYLINE.ORDEREDQTY * 0 AS CERO, " +
      "              SSRS_RESUPPLYLINE.DESCRIPTION, " +
      "              SSRS_RESUPPLYLINE.C_UOM_ID," +
      "              SSRS_RESUPPLYLINE.QUANTITYORDER, " +
      "              SSRS_RESUPPLYLINE.M_PRODUCT_UOM_ID," +
      "              SSRS_RESUPPLYLINE_ID, " +
      "              '' AS C_ORDERLINE_ID," +
      "              CASE WHEN SSRS_RESUPPLYLINE.ORDEREDQTY IS NULL OR SSRS_RESUPPLYLINE.ORDEREDQTY <= 0 THEN 'N' ELSE 'Y' END AS TO_CLOSE," +
      "              SSRS_RESUPPLYLINE.needbydate," +
      "              M_PRODUCT.M_LOCATOR_ID," +
      "              SSRS_RESUPPLY.AD_ORG_ID AS AD_ORG_ID_VAL," +
      "              AD_ORG.EM_SSRS_M_LOCATORTRN_ID," +
      "              AD_ORG.EM_SSRS_M_LOCATORRCP_ID," +
      "              M_PRODUCT.EM_SSRS_M_WAREHOUSE_ID," +
      "              SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID," +
      "              SSRS_RESUPPLY.SSRS_RESUPPLY_ID," +
      "              SSRS_RESUPPLYLINE.LOCKQTYCONVERSION," +
      "              SSRS_RESUPPLYLINE.LOCKQTYCONVERSION * 0 AS CER0CONVERSION" +
      "        FROM SSRS_RESUPPLYLINE " +
      "        INNER JOIN SSRS_RESUPPLY ON SSRS_RESUPPLY.SSRS_RESUPPLY_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLY_ID" +
      "        INNER JOIN M_PRODUCT ON M_PRODUCT.M_PRODUCT_ID = SSRS_RESUPPLYLINE.M_PRODUCT_ID" +
      "        INNER JOIN AD_ORG ON AD_ORG.AD_ORG_ID = SSRS_RESUPPLY.AD_ORG_ID" +
      "        WHERE SSRS_RESUPPLY.AD_ORG_ID = ?" +
      "              AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":"  AND SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectResupplyToMovementData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectResupplyToMovementData.lockqty = UtilSql.getValue(result, "lockqty");
        objectResupplyToMovementData.orderedqty = UtilSql.getValue(result, "orderedqty");
        objectResupplyToMovementData.cero = UtilSql.getValue(result, "cero");
        objectResupplyToMovementData.description = UtilSql.getValue(result, "description");
        objectResupplyToMovementData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectResupplyToMovementData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectResupplyToMovementData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectResupplyToMovementData.toClose = UtilSql.getValue(result, "to_close");
        objectResupplyToMovementData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectResupplyToMovementData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectResupplyToMovementData.adOrgIdVal = UtilSql.getValue(result, "ad_org_id_val");
        objectResupplyToMovementData.emSsrsMLocatortrnId = UtilSql.getValue(result, "em_ssrs_m_locatortrn_id");
        objectResupplyToMovementData.emSsrsMLocatorrcpId = UtilSql.getValue(result, "em_ssrs_m_locatorrcp_id");
        objectResupplyToMovementData.emSsrsMWarehouseId = UtilSql.getValue(result, "em_ssrs_m_warehouse_id");
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.ssrsResupplyId = UtilSql.getValue(result, "ssrs_resupply_id");
        objectResupplyToMovementData.lockqtyconversion = UtilSql.getValue(result, "lockqtyconversion");
        objectResupplyToMovementData.cer0conversion = UtilSql.getValue(result, "cer0conversion");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] linesToOrderHead(ConnectionProvider connectionProvider, String parRequisitionLinesHead)    throws ServletException {
    return linesToOrderHead(connectionProvider, parRequisitionLinesHead, 0, 0);
  }

  public static ResupplyToMovementData[] linesToOrderHead(ConnectionProvider connectionProvider, String parRequisitionLinesHead, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT SSRS_RESUPPLY.AD_ORG_ID AS AD_ORG_ID_GROUP,SSRS_RESUPPLY.AD_ORG_ID_REQ,SSRS_RESUPPLY.SSRS_RESUPPLY_ID" +
      "       FROM SSRS_RESUPPLYLINE " +
      "            INNER JOIN SSRS_RESUPPLY ON SSRS_RESUPPLY.SSRS_RESUPPLY_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLY_ID" +
      "       WHERE 1=1";
    strSql = strSql + ((parRequisitionLinesHead==null || parRequisitionLinesHead.equals(""))?"":"  AND SSRS_RESUPPLYLINE_ID IN" + parRequisitionLinesHead);
    strSql = strSql + 
      "       GROUP BY SSRS_RESUPPLY.AD_ORG_ID,SSRS_RESUPPLY.AD_ORG_ID_REQ,SSRS_RESUPPLY.SSRS_RESUPPLY_ID";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRequisitionLinesHead != null && !(parRequisitionLinesHead.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.adOrgIdGroup = UtilSql.getValue(result, "ad_org_id_group");
        objectResupplyToMovementData.adOrgIdReq = UtilSql.getValue(result, "ad_org_id_req");
        objectResupplyToMovementData.ssrsResupplyId = UtilSql.getValue(result, "ssrs_resupply_id");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectVendor(ConnectionProvider connectionProvider, String parRequisitionLines)    throws ServletException {
    return selectVendor(connectionProvider, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] selectVendor(ConnectionProvider connectionProvider, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT DISTINCT COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID) AS VENDOR_ID" +
      "      FROM M_REQUISITIONLINE, M_REQUISITION" +
      "      WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "        AND COALESCE(M_REQUISITIONLINE.C_BPARTNER_ID, M_REQUISITION.C_BPARTNER_ID) IS NOT NULL" +
      "        AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRequisitionLines)    throws ServletException {
    return selectPriceList(connectionProvider, language, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] selectPriceList(ConnectionProvider connectionProvider, String language, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID) AS M_PRICELIST_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_PriceList'), to_char(COALESCE(M_REQUISITIONLINE.M_PRICELIST_ID, M_REQUISITION.M_PRICELIST_ID)), ?) AS PRICELISTID" +
      "        FROM M_REQUISITIONLINE, M_REQUISITION" +
      "        WHERE M_REQUISITION.M_REQUISITION_ID = M_REQUISITIONLINE.M_REQUISITION_ID" +
      "          AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.mPricelistId = UtilSql.getValue(result, "m_pricelist_id");
        objectResupplyToMovementData.pricelistid = UtilSql.getValue(result, "pricelistid");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRequisitionLines)    throws ServletException {
    return selectOrg(connectionProvider, language, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] selectOrg(ConnectionProvider connectionProvider, String language, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT AD_ORG_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('AD_Org'), to_char(AD_ORG_ID), ?) AS ORG" +
      "        FROM SSRS_RESUPPLYLINE" +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND SSRS_RESUPPLYLINE_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectResupplyToMovementData.org = UtilSql.getValue(result, "org");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectNoPrice(ConnectionProvider connectionProvider, String language, String pricelistversion, String parRequisitionLines)    throws ServletException {
    return selectNoPrice(connectionProvider, language, pricelistversion, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] selectNoPrice(ConnectionProvider connectionProvider, String language, String pricelistversion, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT DISTINCT M_PRODUCT_ID," +
      "          AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(M_REQUISITIONLINE.M_PRODUCT_ID), ?) AS PRODUCT" +
      "        FROM M_REQUISITIONLINE" +
      "        WHERE NOT EXISTS ( SELECT 1 FROM M_PRODUCTPRICE" +
      "                           WHERE M_REQUISITIONLINE.M_PRODUCT_ID = M_PRODUCTPRICE.M_PRODUCT_ID" +
      "                           AND M_PRODUCTPRICE.M_PRICELIST_VERSION_ID = ? )" +
      "          AND LOCKPRICE IS NULL" +
      "          AND 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":"  AND M_RequisitionLine_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, pricelistversion);
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectResupplyToMovementData.product = UtilSql.getValue(result, "product");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String clientid, String adOrgId, String adclient)    throws ServletException {
    return selectWarehouseDouble(connectionProvider, clientid, adOrgId, adclient, 0, 0);
  }

  public static ResupplyToMovementData[] selectWarehouseDouble(ConnectionProvider connectionProvider, String clientid, String adOrgId, String adclient, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG.AD_ORG_ID AS PADRE, M_WAREHOUSE.M_WAREHOUSE_ID AS ID, M_WAREHOUSE.NAME AS NAME" +
      "        FROM M_WAREHOUSE, AD_ORG" +
      "        WHERE (AD_ISORGINCLUDED(M_WAREHOUSE.AD_ORG_ID, AD_ORG.AD_ORG_ID, ?) <> -1" +
      "          OR AD_ISORGINCLUDED(AD_ORG.AD_ORG_ID, M_WAREHOUSE.AD_ORG_ID, ?) <> -1)" +
      "          AND AD_ORG.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")" +
      "          AND M_WAREHOUSE.AD_CLIENT_ID IN (";
    strSql = strSql + ((adclient==null || adclient.equals(""))?"":adclient);
    strSql = strSql + 
      ")" +
      "        ORDER BY PADRE, NAME";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, clientid);
      if (adOrgId != null && !(adOrgId.equals(""))) {
        }
      if (adclient != null && !(adclient.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.padre = UtilSql.getValue(result, "padre");
        objectResupplyToMovementData.id = UtilSql.getValue(result, "id");
        objectResupplyToMovementData.name = UtilSql.getValue(result, "name");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectVendorData(ConnectionProvider connectionProvider, String cBpartnerId)    throws ServletException {
    return selectVendorData(connectionProvider, cBpartnerId, 0, 0);
  }

  public static ResupplyToMovementData[] selectVendorData(ConnectionProvider connectionProvider, String cBpartnerId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "      SELECT p.InvoiceRule, p.DeliveryRule, DeliveryViaRule," +
      "        p.PaymentRulePO, p.PO_PaymentTerm_ID, p.PO_PaymentMethod_ID" +
      "      FROM C_BPartner p" +
      "      WHERE p.C_BPartner_ID = ?";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.invoicerule = UtilSql.getValue(result, "invoicerule");
        objectResupplyToMovementData.deliveryrule = UtilSql.getValue(result, "deliveryrule");
        objectResupplyToMovementData.deliveryviarule = UtilSql.getValue(result, "deliveryviarule");
        objectResupplyToMovementData.paymentrulepo = UtilSql.getValue(result, "paymentrulepo");
        objectResupplyToMovementData.poPaymenttermId = UtilSql.getValue(result, "po_paymentterm_id");
        objectResupplyToMovementData.poPaymentmethodId = UtilSql.getValue(result, "po_paymentmethod_id");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static String bPartnerDescription(ConnectionProvider connectionProvider, String partnerid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(?), to_char(?)) AS VENDOR" +
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
        strReturn = UtilSql.getValue(result, "vendor");
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

  public static String mProductDescription(ConnectionProvider connectionProvider, String productid, String language)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(?), to_char(?)) AS PRODUCT" +
      "        FROM DUAL";

    ResultSet result;
    String strReturn = null;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, productid);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "product");
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

  public static String getPricelistVersion(ConnectionProvider connectionProvider, String pricelist, String orderdate)    throws ServletException {
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
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orderdate);

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

  public static String cDoctypeTarget(Connection conn, ConnectionProvider connectionProvider, String adClientId, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_GET_DOCTYPE(?, ?, 'POO', null) FROM DUAL";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
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

  public static int unlock(ConnectionProvider connectionProvider, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSRS_RESUPPLYLINE" +
      "        SET LOCKEDBY = null," +
      "            LOCKPRICE = null," +
      "            LOCKQTY = null," +
      "            LOCKDATE = null," +
      "            LOCKCAUSE = null" +
      "        WHERE SSRS_RESUPPLYLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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

  public static int lock(ConnectionProvider connectionProvider, String userId, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSRS_RESUPPLYLINE" +
      "        SET LOCKEDBY = ?," +
      "            LOCKDATE = now()," +
      "            LOCKQTY = null," +
      "            LOCKPRICE = null," +
      "            LOCKCAUSE = 'M'" +
      "        WHERE SSRS_RESUPPLYLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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

  public static int updateLock(ConnectionProvider connectionProvider, String lockQty, String lockQtyconversion, String lockPrice, String ssrsResupplylineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSRS_RESUPPLYLINE" +
      "        SET LOCKQTY = to_number(?) *(SELECT  C_UOM_CONVERSION.MULTIPLYRATE " +
      "                                                  FROM SSRS_RESUPPLYLINE SR" +
      "                                                  LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = SR.C_UOM_ID" +
      "                                                  LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = SR.M_PRODUCT_UOM_ID" +
      "                                                  LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "                                                  LEFT JOIN C_UOM_CONVERSION ON ( C_UOM1.C_UOM_ID  = C_UOM_CONVERSION.C_UOM_ID AND SR.C_UOM_ID = C_UOM_CONVERSION.C_UOM_TO_ID)" +
      "                                                  WHERE SR.M_PRODUCT_ID = SSRS_RESUPPLYLINE.M_PRODUCT_ID" +
      "                                                        AND SR.SSRS_RESUPPLYLINE_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID )," +
      "            LOCKQTYCONVERSION = to_number(?),                                     " +
      "            LOCKPRICE = to_number(?)" +
      "        WHERE SSRS_RESUPPLYLINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockQtyconversion);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, lockPrice);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssrsResupplylineId);

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

  public static int insertCMovement(Connection conn, ConnectionProvider connectionProvider, String m_movement_id, String adClientId, String adOrgId, String user, String movementdate, String documentNo, String emSsrsResupplyId, String emSsrsIsResupply, String emSsrsTypeResupply, String emSsrsCDoctypeId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       INSERT INTO M_MOVEMENT(M_MOVEMENT_ID,AD_CLIENT_ID,AD_ORG_ID,CREATED,CREATEDBY,UPDATED,UPDATEDBY" +
      "       ,NAME,DESCRIPTION,MOVEMENTDATE,POSTED,PROCESSED,PROCESSING,MOVE_FROMTO_LOCATOR,DOCUMENTNO,EM_SSRS_RESUPPLY_ID," +
      "       EM_SSRS_ISRESUPPLY,EM_SSRS_TYPERESUPPLY,EM_SSRS_C_DOCTYPE_ID)" +
      "       VALUES(?,?,?,now(),?,now(),?,'Reaprovisionamiento','Reaprovisionamiento',TO_DATE(?),'N','N','N','N',?,?,?,?,?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_movement_id);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementdate);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, documentNo);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emSsrsResupplyId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emSsrsIsResupply);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emSsrsTypeResupply);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emSsrsCDoctypeId);

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

  public static int insertCOrderline(Connection conn, ConnectionProvider connectionProvider, String cOrderlineId, String adClientId, String adOrgId, String user, String cOrderId, String mLocatorId, String mLocatorToId, String mProductId, String line, String movementQty, String mAttributeSetInstanceId, String cUomId, String mProductcUomId, String quantityOrder, String emSsrsResupplyId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_MOVEMENTLINE(M_MOVEMENTLINE_ID,AD_CLIENT_ID,AD_ORG_ID,CREATED,CREATEDBY,UPDATED,UPDATEDBY," +
      "        M_MOVEMENT_ID,M_LOCATOR_ID,M_LOCATORTO_ID,M_PRODUCT_ID,LINE,MOVEMENTQTY,M_ATTRIBUTESETINSTANCE_ID,C_UOM_ID,M_PRODUCT_UOM_ID," +
      "        QUANTITYORDER,EM_SSRS_RESUPPLY_ID)" +
      "        VALUES(?,?,?,now(),?,now(),?," +
      "               ?,?,?,?,TO_NUMBER(?),TO_NUMBER(?),?,?,?,TO_NUMBER(?),?)";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderlineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mLocatorToId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, line);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, movementQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mAttributeSetInstanceId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductcUomId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, quantityOrder);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, emSsrsResupplyId);

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

  public static int insertRequisitionOrder(Connection conn, ConnectionProvider connectionProvider, String mRequisitionOrderId, String adClientId, String adOrgId, String user, String mRequisitionLineId, String cOrderLineId, String qty)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        INSERT INTO M_REQUISITIONORDER (M_REQUISITIONORDER_ID, AD_CLIENT_ID, AD_ORG_ID, CREATED, CREATEDBY, UPDATED, UPDATEDBY, ISACTIVE," +
      "        M_REQUISITIONLINE_ID, C_ORDERLINE_ID, QTY)" +
      "        VALUES (?,?,?,now(),?,now(),?,'Y'," +
      "        ?,?,TO_NUMBER(?))";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionOrderId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adClientId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, user);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mRequisitionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, cOrderLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, qty);

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

  public static ResupplyToMovementData cOrderPost0(Connection conn, ConnectionProvider connectionProvider, String adPinstanceId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL C_Order_Post(?)";

    ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
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
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData resupplyStatus(Connection conn, ConnectionProvider connectionProvider, String requisitionLineId, String userId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        CALL ssrs_resupplyline_status(null, ?, ?)";

    ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
    CallableStatement st = null;
    if (connectionProvider.getRDBMS().equalsIgnoreCase("ORACLE")) {

    int iParameter = 0;
    try {
      st = connectionProvider.getCallableStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, requisitionLineId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);

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
      parametersData.addElement(requisitionLineId);
      parametersTypes.addElement("in");
      parametersData.addElement(userId);
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
    return(objectResupplyToMovementData);
  }

  public static int deleteResupply(ConnectionProvider connectionProvider, String requisitionlinesdelete)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSRS_RESUPPLYLINE" +
      "        SET ISACTIVE = 'N'" +
      "        WHERE SSRS_RESUPPLYLINE_ID IN ";
    strSql = strSql + ((requisitionlinesdelete==null || requisitionlinesdelete.equals(""))?"":requisitionlinesdelete);

    int updateCount = 0;
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (requisitionlinesdelete != null && !(requisitionlinesdelete.equals(""))) {
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

  public static int updateOrderedQty(ConnectionProvider connectionProvider, String OrderedQty, String updatedBy, String ssrsResupplylineId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSRS_RESUPPLYLINE" +
      "        SET ORDEREDQTY =  COALESCE(TO_NUMBER(?)) *(SELECT  C_UOM_CONVERSION.MULTIPLYRATE " +
      "                                                  FROM SSRS_RESUPPLYLINE SR" +
      "                                                  LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = SR.C_UOM_ID" +
      "                                                  LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = SR.M_PRODUCT_UOM_ID" +
      "                                                  LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "                                                  LEFT JOIN C_UOM_CONVERSION ON ( C_UOM1.C_UOM_ID  = C_UOM_CONVERSION.C_UOM_ID AND SR.C_UOM_ID = C_UOM_CONVERSION.C_UOM_TO_ID)" +
      "                                                  WHERE SR.M_PRODUCT_ID = SSRS_RESUPPLYLINE.M_PRODUCT_ID" +
      "                                                        AND SR.SSRS_RESUPPLYLINE_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID )," +
      "         REQSTATUS = 'C'," +
      "         Updated = TO_DATE(NOW())," +
      "         UpdatedBy = ?" +
      "        WHERE SSRS_RESUPPLYLINE_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, OrderedQty);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, updatedBy);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, ssrsResupplylineId);

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

  public static ResupplyToMovementData[] stockStorageDetail(ConnectionProvider connectionProvider, String mProductId, String mWarehouseId)    throws ServletException {
    return stockStorageDetail(connectionProvider, mProductId, mWarehouseId, 0, 0);
  }

  public static ResupplyToMovementData[] stockStorageDetail(ConnectionProvider connectionProvider, String mProductId, String mWarehouseId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT * FROM (SELECT M_STORAGE_DETAIL.M_STORAGE_DETAIL_ID," +
      "       M_LOCATOR.M_LOCATOR_ID AS M_LOCATOR_ID_VAL1," +
      "       M_STORAGE_DETAIL.M_ATTRIBUTESETINSTANCE_ID," +
      "       M_STORAGE_DETAIL.M_LOCATOR_ID AS M_LOCATOR_ID_VAL2, " +
      "       M_STORAGE_DETAIL.M_PRODUCT_ID,  " +
      "       M_STORAGE_DETAIL.C_UOM_ID, " +
      "       (SUM(M_STORAGE_DETAIL.QTYONHAND) + SUM(M_STORAGE_DETAIL.PREQTYONHAND)) AS STOCKDIS," +
      "       M_ATTRIBUTESETINSTANCE.GUARANTEEDATE" +
      "       FROM M_LOCATOR " +
      "       LEFT JOIN M_STORAGE_DETAIL ON M_STORAGE_DETAIL.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID " +
      "                 AND M_STORAGE_DETAIL.M_PRODUCT_ID = ?" +
      "       LEFT JOIN M_ATTRIBUTESETINSTANCE ON M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID = M_STORAGE_DETAIL.M_ATTRIBUTESETINSTANCE_ID" +
      "       WHERE M_LOCATOR.M_WAREHOUSE_ID = ?" +
      "       GROUP BY M_STORAGE_DETAIL.M_STORAGE_DETAIL_ID, M_LOCATOR.M_LOCATOR_ID, M_STORAGE_DETAIL.M_ATTRIBUTESETINSTANCE_ID,M_STORAGE_DETAIL.M_LOCATOR_ID , M_STORAGE_DETAIL.M_PRODUCT_ID,  M_STORAGE_DETAIL.C_UOM_ID,M_ATTRIBUTESETINSTANCE.GUARANTEEDATE" +
      "       ORDER BY M_ATTRIBUTESETINSTANCE.GUARANTEEDATE) RESUPPLY WHERE STOCKDIS > 0";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mProductId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mWarehouseId);

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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.mStorageDetailId = UtilSql.getValue(result, "m_storage_detail_id");
        objectResupplyToMovementData.mLocatorIdVal1 = UtilSql.getValue(result, "m_locator_id_val1");
        objectResupplyToMovementData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectResupplyToMovementData.mLocatorIdVal2 = UtilSql.getValue(result, "m_locator_id_val2");
        objectResupplyToMovementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectResupplyToMovementData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectResupplyToMovementData.stockdis = UtilSql.getValue(result, "stockdis");
        objectResupplyToMovementData.guaranteedate = UtilSql.getDateValue(result, "guaranteedate", "dd-MM-yyyy");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] codSsrsResupplyId(ConnectionProvider connectionProvider, String parRequisitionLines)    throws ServletException {
    return codSsrsResupplyId(connectionProvider, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] codSsrsResupplyId(ConnectionProvider connectionProvider, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SSRS_RESUPPLY_ID" +
      "        FROM SSRS_RESUPPLYLINE" +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND SSRS_RESUPPLYLINE_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.ssrsResupplyId = UtilSql.getValue(result, "ssrs_resupply_id");
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static ResupplyToMovementData[] selectSelectedValidation(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId)    throws ServletException {
    return selectSelectedValidation(connectionProvider, language, adUserId, adUserClient, adOrgId, 0, 0);
  }

  public static ResupplyToMovementData[] selectSelectedValidation(ConnectionProvider connectionProvider, String language, String adUserId, String adUserClient, String adOrgId, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT SSRS_RESUPPLY.SSRS_RESUPPLY_ID," +
      "        SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID, " +
      "                 SSRS_RESUPPLYLINE.NEEDBYDATE, " +
      "                 SSRS_RESUPPLY.DOCUMENTNO," +
      "                 SSRS_RESUPPLY.AD_ORG_ID," +
      "                 AD_ORG.NAME AS ADORGNAME," +
      "                 AD_ORG.NAME AS ADORGNAME," +
      "                 M_PRODUCT.VALUE AS PRODUCTCOD," +
      "                 QUANTITYORDER, " +
      "                 ROUND(SSRS_RESUPPLYLINE.QTY / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS REQQTY," +
      "                 ROUND(SSRS_RESUPPLYLINE.ORDEREDQTY / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS MATCHEDQTY," +
      "                 ROUND(COALESCE(LOCKQTY, QTY-ORDEREDQTY) / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "                 ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),C_UOM.STDPRECISION) AS LOCKQTY," +
      "                 C_UOM1.NAME AS SECUOMNAME, " +
      "                 C_UOM.NAME AS UOMNAME," +
      "                 COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID, '-1') AS VENDOR_ID," +
      "                 AD_COLUMN_IDENTIFIER(to_char('C_BPartner'), to_char(COALESCE(SSRS_RESUPPLYLINE.C_BPARTNER_ID, SSRS_RESUPPLY.C_BPARTNER_ID)), ?) AS VENDOR," +
      "                 AD_COLUMN_IDENTIFIER(to_char('M_Product'), to_char(SSRS_RESUPPLYLINE.M_PRODUCT_ID), ?) AS PRODUCT," +
      "                 AD_COLUMN_IDENTIFIER(to_char('M_AttributeSetInstance'), to_char(SSRS_RESUPPLYLINE.M_ATTRIBUTESETINSTANCE_ID), ?) AS ATTRIBUTE" +
      "        FROM SSRS_RESUPPLY " +
      "                 inner join SSRS_RESUPPLYLINE on SSRS_RESUPPLY.SSRS_RESUPPLY_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLY_ID " +
      "                 LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = SSRS_RESUPPLYLINE.C_UOM_ID" +
      "                 LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = SSRS_RESUPPLYLINE.M_PRODUCT_UOM_ID" +
      "                 LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "                 LEFT JOIN AD_ORG ON SSRS_RESUPPLY.AD_ORG_ID = AD_ORG.AD_ORG_ID    " +
      "                 LEFT JOIN C_UOM_CONVERSION ON C_UOM1.C_UOM_ID  = C_UOM_CONVERSION.C_UOM_ID AND SSRS_RESUPPLYLINE.C_UOM_ID = C_UOM_CONVERSION.C_UOM_TO_ID" +
      "                 LEFT JOIN M_PRODUCT ON SSRS_RESUPPLYLINE.M_PRODUCT_ID = M_PRODUCT.M_PRODUCT_ID" +
      "        WHERE SSRS_RESUPPLY.ISACTIVE = 'Y'" +
      "                  AND SSRS_RESUPPLYLINE.ISACTIVE = 'Y'" +
      "                  AND SSRS_RESUPPLY.DOCSTATUS = 'CO'" +
      "                  AND SSRS_RESUPPLYLINE.REQSTATUS = 'O'" +
      "                  AND SSRS_RESUPPLYLINE.LOCKEDBY = ?" +
      "                  AND SSRS_RESUPPLYLINE.LOCKDATE >= (now()-3)" +
      "                  AND SSRS_RESUPPLY.AD_CLIENT_ID IN (";
    strSql = strSql + ((adUserClient==null || adUserClient.equals(""))?"":adUserClient);
    strSql = strSql + 
      ")" +
      "                  AND SSRS_RESUPPLY.AD_ORG_ID IN (";
    strSql = strSql + ((adOrgId==null || adOrgId.equals(""))?"":adOrgId);
    strSql = strSql + 
      ")                  " +
      "        ORDER BY SSRS_RESUPPLY.AD_ORG_ID";

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, language);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adUserId);
      if (adUserClient != null && !(adUserClient.equals(""))) {
        }
      if (adOrgId != null && !(adOrgId.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.ssrsResupplyId = UtilSql.getValue(result, "ssrs_resupply_id");
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectResupplyToMovementData.documentno = UtilSql.getValue(result, "documentno");
        objectResupplyToMovementData.adOrgId = UtilSql.getValue(result, "ad_org_id");
        objectResupplyToMovementData.adorgname = UtilSql.getValue(result, "adorgname");
        objectResupplyToMovementData.adorgname = UtilSql.getValue(result, "adorgname");
        objectResupplyToMovementData.productcod = UtilSql.getValue(result, "productcod");
        objectResupplyToMovementData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectResupplyToMovementData.reqqty = UtilSql.getValue(result, "reqqty");
        objectResupplyToMovementData.matchedqty = UtilSql.getValue(result, "matchedqty");
        objectResupplyToMovementData.lockqty = UtilSql.getValue(result, "lockqty");
        objectResupplyToMovementData.secuomname = UtilSql.getValue(result, "secuomname");
        objectResupplyToMovementData.uomname = UtilSql.getValue(result, "uomname");
        objectResupplyToMovementData.vendorId = UtilSql.getValue(result, "vendor_id");
        objectResupplyToMovementData.vendor = UtilSql.getValue(result, "vendor");
        objectResupplyToMovementData.product = UtilSql.getValue(result, "product");
        objectResupplyToMovementData.attribute = UtilSql.getValue(result, "attribute");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static int lockvalidation(ConnectionProvider connectionProvider, String userId, String requisition, String requisitionlines)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE SSRS_RESUPPLYLINE" +
      "        SET LOCKEDBY = ?," +
      "            LOCKDATE = now()," +
      "            LOCKQTY = null," +
      "            LOCKPRICE = null," +
      "            LOCKCAUSE = 'M'" +
      "        WHERE SSRS_RESUPPLY_ID = ?" +
      "            AND SSRS_RESUPPLYLINE_ID IN ";
    strSql = strSql + ((requisitionlines==null || requisitionlines.equals(""))?"":requisitionlines);

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, userId);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, requisition);
      if (requisitionlines != null && !(requisitionlines.equals(""))) {
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

  public static int updateStockReserve(ConnectionProvider connectionProvider, String preQtyonHand, String mStorageDetailId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        UPDATE M_STORAGE_DETAIL" +
      "        SET PREQTYONHAND = TO_NUMBER(?)" +
      "        WHERE M_STORAGE_DETAIL_ID = ?";

    int updateCount = 0;
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, preQtyonHand);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, mStorageDetailId);

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

  public static ResupplyToMovementData[] linesToOrderValidate(ConnectionProvider connectionProvider, String parRequisitionLines)    throws ServletException {
    return linesToOrderValidate(connectionProvider, parRequisitionLines, 0, 0);
  }

  public static ResupplyToMovementData[] linesToOrderValidate(ConnectionProvider connectionProvider, String parRequisitionLines, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       SELECT SSRS_RESUPPLY.SSRS_RESUPPLY_ID," +
      "              SSRS_RESUPPLY.DOCUMENTNO," +
      "              SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID," +
      "              SSRS_RESUPPLYLINE.M_PRODUCT_ID, " +
      "              M_PRODUCT.M_ATTRIBUTESETINSTANCE_ID, " +
      "              SSRS_RESUPPLYLINE.LOCKQTY," +
      "              SSRS_RESUPPLYLINE.ORDEREDQTY * 0 AS CERO, " +
      "              SSRS_RESUPPLYLINE.DESCRIPTION, " +
      "              SSRS_RESUPPLYLINE.C_UOM_ID," +
      "              SSRS_RESUPPLYLINE.QUANTITYORDER, " +
      "              SSRS_RESUPPLYLINE.M_PRODUCT_UOM_ID," +
      "              SSRS_RESUPPLYLINE_ID, " +
      "              '' AS C_ORDERLINE_ID," +
      "              CASE WHEN SSRS_RESUPPLYLINE.LOCKQTY < (SSRS_RESUPPLYLINE.QTY - SSRS_RESUPPLYLINE.ORDEREDQTY) THEN 'N' ELSE 'Y' END AS TO_CLOSE," +
      "              SSRS_RESUPPLYLINE.needbydate," +
      "              M_PRODUCT.M_LOCATOR_ID," +
      "              SSRS_RESUPPLY.AD_ORG_ID AS AD_ORG_ID_VAL," +
      "              AD_ORG.EM_SSRS_M_LOCATORTRN_ID," +
      "              AD_ORG.EM_SSRS_M_LOCATORRCP_ID," +
      "              M_PRODUCT.EM_SSRS_M_WAREHOUSE_ID," +
      "              TO_NUMBER(CASE WHEN STOCKACT IS NULL THEN 0 ELSE STOCKACT END) AS STOCKACT," +
      "              TO_NUMBER(CASE WHEN STOCKRES IS NULL THEN 0 ELSE STOCKRES END) AS STOCKRES," +
      "              TRUNC((TO_NUMBER(CASE WHEN STOCKACT IS NULL THEN 0 ELSE STOCKACT END) + TO_NUMBER(CASE WHEN STOCKRES IS NULL THEN 0 ELSE STOCKRES END))  " +
      "              / TO_NUMBER(CASE WHEN C_UOM_CONVERSION.MULTIPLYRATE = 0 OR C_UOM_CONVERSION.MULTIPLYRATE IS NULL THEN 1" +
      "              ELSE C_UOM_CONVERSION.MULTIPLYRATE END ),0) AS STOCKDIS," +
      "              SSRS_RESUPPLYLINE.LINE," +
      "              AD_ORG.EM_SSRS_C_DOCTYPEFROM_ID AS ORG_DOCTYPEFROM, " +
      "              AD_ORG.EM_SSRS_C_DOCTYPETO_ID AS ORG_DOCTYPETO," +
      "              ORG_REQ.EM_SSRS_C_DOCTYPEFROM_ID AS ORG_DOCTYPEFROMREQ," +
      "              ORG_REQ.EM_SSRS_C_DOCTYPETO_ID  AS ORG_DOCTYPETOREQ," +
      "              C_DOCTYPE1.DOCNOSEQUENCE_ID AS DOCNOSEQUENCE_ID_FROM_SEND," +
      "              C_DOCTYPE2.DOCNOSEQUENCE_ID AS DOCNOSEQUENCE_ID_TO_SEND," +
      "              C_DOCTYPE3.DOCNOSEQUENCE_ID AS DOCNOSEQUENCE_ID_FROM_RECEPTION," +
      "              C_DOCTYPE4.DOCNOSEQUENCE_ID AS DOCNOSEQUENCE_ID_TO_RECEPTION" +
      "        FROM SSRS_RESUPPLYLINE " +
      "        INNER JOIN SSRS_RESUPPLY ON SSRS_RESUPPLY.SSRS_RESUPPLY_ID = SSRS_RESUPPLYLINE.SSRS_RESUPPLY_ID" +
      "        INNER JOIN M_PRODUCT ON M_PRODUCT.M_PRODUCT_ID = SSRS_RESUPPLYLINE.M_PRODUCT_ID" +
      "        INNER JOIN AD_ORG ON AD_ORG.AD_ORG_ID = SSRS_RESUPPLY.AD_ORG_ID" +
      "        INNER JOIN AD_ORG  ORG_REQ ON ORG_REQ.AD_ORG_ID = SSRS_RESUPPLY.AD_ORG_ID_REQ" +
      "        LEFT JOIN C_UOM ON C_UOM.C_UOM_ID = SSRS_RESUPPLYLINE.C_UOM_ID" +
      "        LEFT JOIN M_PRODUCT_UOM ON M_PRODUCT_UOM.M_PRODUCT_UOM_ID = SSRS_RESUPPLYLINE.M_PRODUCT_UOM_ID" +
      "        LEFT JOIN C_UOM C_UOM1 ON M_PRODUCT_UOM.C_UOM_ID = C_UOM1.C_UOM_ID" +
      "        LEFT JOIN C_UOM_CONVERSION ON C_UOM1.C_UOM_ID  = C_UOM_CONVERSION.C_UOM_ID AND SSRS_RESUPPLYLINE.C_UOM_ID = C_UOM_CONVERSION.C_UOM_TO_ID" +
      "        LEFT JOIN C_DOCTYPE C_DOCTYPE1 ON C_DOCTYPE1.C_DOCTYPE_ID = ORG_REQ.EM_SSRS_C_DOCTYPEFROM_ID" +
      "        LEFT JOIN C_DOCTYPE C_DOCTYPE2 ON C_DOCTYPE2.C_DOCTYPE_ID = ORG_REQ.EM_SSRS_C_DOCTYPETO_ID" +
      "        LEFT JOIN C_DOCTYPE C_DOCTYPE3 ON C_DOCTYPE3.C_DOCTYPE_ID = AD_ORG.EM_SSRS_C_DOCTYPEFROM_ID" +
      "        LEFT JOIN C_DOCTYPE C_DOCTYPE4 ON C_DOCTYPE4.C_DOCTYPE_ID = AD_ORG.EM_SSRS_C_DOCTYPETO_ID" +
      "        LEFT JOIN (SELECT M_LOCATOR.M_WAREHOUSE_ID,M_STORAGE_DETAIL.M_PRODUCT_ID," +
      "                               SUM(M_STORAGE_DETAIL.QTYONHAND) AS STOCKACT," +
      "                               SUM(M_STORAGE_DETAIL.PREQTYONHAND) AS STOCKRES" +
      "                            FROM M_LOCATOR " +
      "                            LEFT JOIN M_STORAGE_DETAIL ON M_STORAGE_DETAIL.M_LOCATOR_ID = M_LOCATOR.M_LOCATOR_ID " +
      "                            LEFT JOIN M_ATTRIBUTESETINSTANCE ON M_ATTRIBUTESETINSTANCE.M_ATTRIBUTESETINSTANCE_ID = M_STORAGE_DETAIL.M_ATTRIBUTESETINSTANCE_ID" +
      "                            GROUP BY M_LOCATOR.M_WAREHOUSE_ID, M_STORAGE_DETAIL.M_PRODUCT_ID) STOCK ON STOCK.M_PRODUCT_ID = SSRS_RESUPPLYLINE.M_PRODUCT_ID " +
      "                                                                                                    AND STOCK.M_WAREHOUSE_ID =  M_PRODUCT.EM_SSRS_M_WAREHOUSE_ID" +
      "        WHERE 1=1";
    strSql = strSql + ((parRequisitionLines==null || parRequisitionLines.equals(""))?"":" AND SSRS_RESUPPLYLINE.SSRS_RESUPPLYLINE_ID IN" + parRequisitionLines);

    ResultSet result;
    Vector<ResupplyToMovementData> vector = new Vector<ResupplyToMovementData>(0);
    PreparedStatement st = null;

    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      if (parRequisitionLines != null && !(parRequisitionLines.equals(""))) {
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
        ResupplyToMovementData objectResupplyToMovementData = new ResupplyToMovementData();
        objectResupplyToMovementData.ssrsResupplyId = UtilSql.getValue(result, "ssrs_resupply_id");
        objectResupplyToMovementData.documentno = UtilSql.getValue(result, "documentno");
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.mProductId = UtilSql.getValue(result, "m_product_id");
        objectResupplyToMovementData.mAttributesetinstanceId = UtilSql.getValue(result, "m_attributesetinstance_id");
        objectResupplyToMovementData.lockqty = UtilSql.getValue(result, "lockqty");
        objectResupplyToMovementData.cero = UtilSql.getValue(result, "cero");
        objectResupplyToMovementData.description = UtilSql.getValue(result, "description");
        objectResupplyToMovementData.cUomId = UtilSql.getValue(result, "c_uom_id");
        objectResupplyToMovementData.quantityorder = UtilSql.getValue(result, "quantityorder");
        objectResupplyToMovementData.mProductUomId = UtilSql.getValue(result, "m_product_uom_id");
        objectResupplyToMovementData.ssrsResupplylineId = UtilSql.getValue(result, "ssrs_resupplyline_id");
        objectResupplyToMovementData.cOrderlineId = UtilSql.getValue(result, "c_orderline_id");
        objectResupplyToMovementData.toClose = UtilSql.getValue(result, "to_close");
        objectResupplyToMovementData.needbydate = UtilSql.getDateValue(result, "needbydate", "dd-MM-yyyy");
        objectResupplyToMovementData.mLocatorId = UtilSql.getValue(result, "m_locator_id");
        objectResupplyToMovementData.adOrgIdVal = UtilSql.getValue(result, "ad_org_id_val");
        objectResupplyToMovementData.emSsrsMLocatortrnId = UtilSql.getValue(result, "em_ssrs_m_locatortrn_id");
        objectResupplyToMovementData.emSsrsMLocatorrcpId = UtilSql.getValue(result, "em_ssrs_m_locatorrcp_id");
        objectResupplyToMovementData.emSsrsMWarehouseId = UtilSql.getValue(result, "em_ssrs_m_warehouse_id");
        objectResupplyToMovementData.stockact = UtilSql.getValue(result, "stockact");
        objectResupplyToMovementData.stockres = UtilSql.getValue(result, "stockres");
        objectResupplyToMovementData.stockdis = UtilSql.getValue(result, "stockdis");
        objectResupplyToMovementData.line = UtilSql.getValue(result, "line");
        objectResupplyToMovementData.orgDoctypefrom = UtilSql.getValue(result, "org_doctypefrom");
        objectResupplyToMovementData.orgDoctypeto = UtilSql.getValue(result, "org_doctypeto");
        objectResupplyToMovementData.orgDoctypefromreq = UtilSql.getValue(result, "org_doctypefromreq");
        objectResupplyToMovementData.orgDoctypetoreq = UtilSql.getValue(result, "org_doctypetoreq");
        objectResupplyToMovementData.docnosequenceIdFromSend = UtilSql.getValue(result, "docnosequence_id_from_send");
        objectResupplyToMovementData.docnosequenceIdToSend = UtilSql.getValue(result, "docnosequence_id_to_send");
        objectResupplyToMovementData.docnosequenceIdFromReception = UtilSql.getValue(result, "docnosequence_id_from_reception");
        objectResupplyToMovementData.docnosequenceIdToReception = UtilSql.getValue(result, "docnosequence_id_to_reception");
        objectResupplyToMovementData.rownum = Long.toString(countRecord);
        objectResupplyToMovementData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectResupplyToMovementData);
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
    ResupplyToMovementData objectResupplyToMovementData[] = new ResupplyToMovementData[vector.size()];
    vector.copyInto(objectResupplyToMovementData);
    return(objectResupplyToMovementData);
  }

  public static String Documenttransactionsend(Connection conn, ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG.EM_SSRS_C_DOCTYPEFROM_ID" +
      "        FROM AD_ORG " +
      "            LEFT JOIN C_DOCTYPE ON C_DOCTYPE.C_DOCTYPE_ID = AD_ORG.EM_SSRS_C_DOCTYPEFROM_ID" +
      "            LEFT JOIN C_DOCTYPE C_DOCTYPETO ON C_DOCTYPETO.C_DOCTYPE_ID = AD_ORG.EM_SSRS_C_DOCTYPETO_ID" +
      "            LEFT JOIN AD_SEQUENCE ON AD_SEQUENCE.AD_SEQUENCE_ID = C_DOCTYPE.DOCNOSEQUENCE_ID" +
      "        WHERE AD_ORG.AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "em_ssrs_c_doctypefrom_id");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static String Documenttransactionreception(Connection conn, ConnectionProvider connectionProvider, String adOrgId)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        SELECT AD_ORG.EM_SSRS_C_DOCTYPETO_ID" +
      "        FROM AD_ORG " +
      "            LEFT JOIN C_DOCTYPE ON C_DOCTYPE.C_DOCTYPE_ID = AD_ORG.EM_SSRS_C_DOCTYPEFROM_ID" +
      "            LEFT JOIN C_DOCTYPE C_DOCTYPETO ON C_DOCTYPETO.C_DOCTYPE_ID = AD_ORG.EM_SSRS_C_DOCTYPETO_ID" +
      "            LEFT JOIN AD_SEQUENCE ON AD_SEQUENCE.AD_SEQUENCE_ID = C_DOCTYPE.DOCNOSEQUENCE_ID" +
      "        WHERE AD_ORG.AD_ORG_ID = ?";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(conn, strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, adOrgId);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "em_ssrs_c_doctypeto_id");
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
        connectionProvider.releaseTransactionalPreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }
}
