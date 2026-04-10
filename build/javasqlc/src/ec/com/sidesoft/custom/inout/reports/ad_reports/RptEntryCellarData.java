//Sqlc generated V1.O00-1
package ec.com.sidesoft.custom.inout.reports.ad_reports;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class RptEntryCellarData implements FieldProvider {
static Logger log4j = Logger.getLogger(RptEntryCellarData.class);
  private String InitRecordNumber="0";
  public String organizationid;
  public String documentno;
  public String partner;
  public String address;
  public String phone;
  public String taxid;
  public String movementdate;
  public String formpay;
  public String conditionpay;
  public String referenceinvoice;
  public String product;
  public String productcod;
  public String movementqty;
  public String document;
  public String unitprice;
  public String amountline;
  public String tax;
  public String total;
  public String orderDocument;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("organizationid"))
      return organizationid;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("partner"))
      return partner;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("movementdate"))
      return movementdate;
    else if (fieldName.equalsIgnoreCase("formpay"))
      return formpay;
    else if (fieldName.equalsIgnoreCase("conditionpay"))
      return conditionpay;
    else if (fieldName.equalsIgnoreCase("referenceinvoice"))
      return referenceinvoice;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("productcod"))
      return productcod;
    else if (fieldName.equalsIgnoreCase("movementqty"))
      return movementqty;
    else if (fieldName.equalsIgnoreCase("document"))
      return document;
    else if (fieldName.equalsIgnoreCase("unitprice"))
      return unitprice;
    else if (fieldName.equalsIgnoreCase("amountline"))
      return amountline;
    else if (fieldName.equalsIgnoreCase("tax"))
      return tax;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("order_document") || fieldName.equals("orderDocument"))
      return orderDocument;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static RptEntryCellarData[] select(ConnectionProvider connectionProvider, String m_inout)    throws ServletException {
    return select(connectionProvider, m_inout, 0, 0);
  }

  public static RptEntryCellarData[] select(ConnectionProvider connectionProvider, String m_inout, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "         SELECT sq.organizationid,sq.documentno,sq.partner,sq.address,sq.phone,sq.taxid, sq.movementdate, " +
      "         sq.formpay,sq.conditionpay,sq.referenceinvoice,sq.product,sq.productcod,sq.movementqty, sq.document," +
      "            coalesce(sq.pricelist,sq.pricelist2, 0) as unitprice, " +
      "               round((coalesce(sq.movementqty,0) * coalesce(sq.pricelist,sq.pricelist2, 0)),2) as amountline, " +
      "               round((round((coalesce(sq.movementqty,0)*  coalesce(sq.pricelist,sq.pricelist2, 0)),2)  * coalesce(sq.rate,sq.rate2,0))/100,2) as tax, " +
      "               round((round((coalesce(sq.movementqty,0)*  coalesce(sq.pricelist,sq.pricelist2, 0)),2)  * coalesce(sq.rate,sq.rate2,0))/100,2) + " +
      "               round((coalesce(sq.movementqty,0) * coalesce(sq.pricelist,sq.pricelist2, 0)),2) as total,sq.order_document " +
      "         FROM " +
      "         ( " +
      "         select io.ad_org_id as organizationid, 'INGRESO A BODEGA No. ' || io.documentno as documentno, cb.name as partner, cbl.name as address, cbl.phone as phone, cb.taxid, to_char(io.movementdate) as movementdate, " +
      "            fp.name as formpay, cp.name as conditionpay, io.poreference as referenceinvoice, " +
      "            p.name as product, p.value as productcod, " +
      "         coalesce(iol.movementqty,0) as movementqty, " +
      "         co.pricelist, " +
      "         t.rate," +
      "        dt.name AS document," +
      "         (select coo.pricelist from c_orderline coo where coo.c_orderline_id = " +
      "         (select min(co.c_orderline_id) from c_orderline co where co.m_product_id = p.m_product_id and co.c_order_id=io.c_order_id ) " +
      "         ) as pricelist2, " +
      "         (select ct.rate from c_orderline coo " +
      "         left join c_tax ct on coo.c_tax_id = ct.c_tax_id " +
      "         where coo.c_orderline_id =  " +
      "         (select min(co.c_orderline_id) from c_orderline co where co.m_product_id = p.m_product_id and co.c_order_id=io.c_order_id ) " +
      "         ) as rate2" +
      "	,(select o.documentno from m_inout io" +
      "	left join c_order o on o.c_order_id=io.c_order_id" +
      "	where io.m_inout_id = iol.m_inout_id) as order_document " +
      "         from m_inout io " +
      "         left join m_inoutline iol on iol.m_inout_id = io.m_inout_id " +
      "         left join c_bpartner cb on cb.c_bpartner_id = io.c_bpartner_id " +
      "         left join c_bpartner_location cbl on cbl.c_bpartner_location_id = io.c_bpartner_location_id " +
      "         left join c_location cl on cl.c_location_id = cbl.c_location_id " +
      "         left join fin_paymentmethod fp on fp.fin_paymentmethod_id = cb.po_paymentmethod_id " +
      "         left join C_PaymentTerm cp on cp.C_PaymentTerm_ID = cb.PO_PaymentTerm_ID " +
      "         left join m_product p on p.m_product_id = iol.m_product_id " +
      "         left join c_orderline co on co.c_orderline_id = iol.c_orderline_id " +
      "         left join c_tax t on t.c_tax_id = co.c_tax_id " +
      "        LEFT JOIN c_doctype AS dt ON dt.c_doctype_id=io.c_doctype_id" +
      "         where io.m_inout_id = ?" +
      "         order by iol.line asc " +
      "         )sq";

    ResultSet result;
    Vector<RptEntryCellarData> vector = new Vector<RptEntryCellarData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, m_inout);

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
        RptEntryCellarData objectRptEntryCellarData = new RptEntryCellarData();
        objectRptEntryCellarData.organizationid = UtilSql.getValue(result, "organizationid");
        objectRptEntryCellarData.documentno = UtilSql.getValue(result, "documentno");
        objectRptEntryCellarData.partner = UtilSql.getValue(result, "partner");
        objectRptEntryCellarData.address = UtilSql.getValue(result, "address");
        objectRptEntryCellarData.phone = UtilSql.getValue(result, "phone");
        objectRptEntryCellarData.taxid = UtilSql.getValue(result, "taxid");
        objectRptEntryCellarData.movementdate = UtilSql.getValue(result, "movementdate");
        objectRptEntryCellarData.formpay = UtilSql.getValue(result, "formpay");
        objectRptEntryCellarData.conditionpay = UtilSql.getValue(result, "conditionpay");
        objectRptEntryCellarData.referenceinvoice = UtilSql.getValue(result, "referenceinvoice");
        objectRptEntryCellarData.product = UtilSql.getValue(result, "product");
        objectRptEntryCellarData.productcod = UtilSql.getValue(result, "productcod");
        objectRptEntryCellarData.movementqty = UtilSql.getValue(result, "movementqty");
        objectRptEntryCellarData.document = UtilSql.getValue(result, "document");
        objectRptEntryCellarData.unitprice = UtilSql.getValue(result, "unitprice");
        objectRptEntryCellarData.amountline = UtilSql.getValue(result, "amountline");
        objectRptEntryCellarData.tax = UtilSql.getValue(result, "tax");
        objectRptEntryCellarData.total = UtilSql.getValue(result, "total");
        objectRptEntryCellarData.orderDocument = UtilSql.getValue(result, "order_document");
        objectRptEntryCellarData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectRptEntryCellarData);
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
    RptEntryCellarData objectRptEntryCellarData[] = new RptEntryCellarData[vector.size()];
    vector.copyInto(objectRptEntryCellarData);
    return(objectRptEntryCellarData);
  }

  public static RptEntryCellarData[] set()    throws ServletException {
    RptEntryCellarData objectRptEntryCellarData[] = new RptEntryCellarData[1];
    objectRptEntryCellarData[0] = new RptEntryCellarData();
    objectRptEntryCellarData[0].organizationid = "";
    objectRptEntryCellarData[0].documentno = "";
    objectRptEntryCellarData[0].partner = "";
    objectRptEntryCellarData[0].address = "";
    objectRptEntryCellarData[0].phone = "";
    objectRptEntryCellarData[0].taxid = "";
    objectRptEntryCellarData[0].movementdate = "";
    objectRptEntryCellarData[0].formpay = "";
    objectRptEntryCellarData[0].conditionpay = "";
    objectRptEntryCellarData[0].referenceinvoice = "";
    objectRptEntryCellarData[0].product = "";
    objectRptEntryCellarData[0].productcod = "";
    objectRptEntryCellarData[0].movementqty = "";
    objectRptEntryCellarData[0].document = "";
    objectRptEntryCellarData[0].unitprice = "";
    objectRptEntryCellarData[0].amountline = "";
    objectRptEntryCellarData[0].tax = "";
    objectRptEntryCellarData[0].total = "";
    objectRptEntryCellarData[0].orderDocument = "";
    return objectRptEntryCellarData;
  }
}
