/*
 **************************************************************************
 *EL CONTENIDO DE ESTE ARCHIVO ES PROPIEDAD INTELECTUAL DE ATRUMS-IT Y ESTA
 *SUJETA A LA LICENCIA: MOZILLA   PUBLIC  LICENSE
 **************************************************************************
 */
package com.atrums.indumot.postventa.erpCommon.ad_actionButton;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.filter.IsPositiveIntFilter;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.utils.Replace;
import org.openbravo.xmlEngine.XmlDocument;

public class CopyFromOrdenServicio extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  private static final BigDecimal ZERO = BigDecimal.ZERO;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strWindowId = vars.getStringParameter("inpwindowId");
      String strSOTrx = Utility.getContext(this, vars, "isSOTrx", strWindowId);
      String strKey = vars.getGlobalVariable("inpcInvoiceId", strWindowId + "|C_Invoice_ID");
      String strTabId = vars.getStringParameter("inpTabId");
      String strBpartner = vars.getStringParameter("inpcBpartnerId");
      String strmPricelistId = vars.getStringParameter("inpmPricelistId");
      printPageDataSheet(response, vars, strKey, strWindowId, strTabId, strSOTrx, strBpartner,
          strmPricelistId);
    } else if (vars.commandIn("SAVE")) {
      String strRownum = null;
      try {
        strRownum = vars.getRequiredInStringParameter("inpRownumId", IsPositiveIntFilter.instance);
      } catch (ServletException e) {
        log4j.error("Error captured: ", e);
        throw new ServletException(OBMessageUtils.messageBD("@JS1@"));
      }
      String strKey = vars.getRequiredStringParameter("inpcOrderId");
      String strTabId = vars.getStringParameter("inpTabId");
      if (strRownum.startsWith("(")) {
        strRownum = strRownum.substring(1, strRownum.length() - 1);
      }
      strRownum = Replace.replace(strRownum, "'", "");
      OBError myError = copyLines(vars, strRownum, strKey);

      String strWindowPath = Utility.getTabURL(strTabId, "R", true);
      if (strWindowPath.equals(""))
        strWindowPath = strDefaultServlet;

      vars.setMessage(strTabId, myError);
      printPageClosePopUp(response, vars, strWindowPath);
    } else
      pageErrorPopUp(response);
  }

  private OBError copyLines(VariablesSecureApp vars, String strRownums, String strKey)
      throws IOException, ServletException {

    OBError myError = null;
    int count = 0;

    if (strRownums.equals("")) { // return "";
      myError = OBMessageUtils.translateError(this, vars, vars.getLanguage(), "ProcessRunError");
      return myError;
    }

    /*
     * Connection conn = null; try { conn = getTransactionConnection(); StringTokenizer st = new
     * StringTokenizer(strRownums, ",", false); CopyFromOrdenServicioRecordData[] orderData =
     * CopyFromOrdenServicioRecordData.select(this, strKey); Order order =
     * OBDal.getInstance().get(Order.class, strKey);
     * 
     * BigDecimal discount, priceActual, priceList, netPriceList, grossPriceList, priceStd,
     * priceLimit, priceGross, amtGross, pricestdgross; while (st.hasMoreTokens()) { String
     * strRownum = st.nextToken().trim(); String strmProductId =
     * vars.getStringParameter("inpmProductId" + strRownum); String strmAttributesetinstanceId =
     * vars.getStringParameter("inpmAttributesetinstanceId" + strRownum); String strLastpriceso =
     * vars.getNumericParameter("inpLastpriceso" + strRownum); String strQty =
     * vars.getNumericParameter("inpquantity" + strRownum); String strcTaxId =
     * vars.getStringParameter("inpcTaxId" + strRownum); String strcUOMId =
     * vars.getStringParameter("inpcUOMId" + strRownum); String strCOrderlineID =
     * SequenceIdData.getUUID(); priceStd = new
     * BigDecimal(CopyFromOrdenServicioData.getOffersStdPrice(this, orderData[0].cBpartnerId,
     * strLastpriceso, strmProductId, orderData[0].dateinvoiced, strQty, orderData[0].mPricelistId,
     * strKey)); ProductPrice prices = FinancialUtils.getProductPrice(
     * OBDal.getInstance().get(Product.class, strmProductId), order.getOrderDate(),
     * order.isSalesTransaction(), order.getPriceList(), false); if (prices != null) { priceLimit =
     * prices.getPriceLimit(); priceList = prices.getListPrice(); pricestdgross =
     * prices.getStandardPrice(); } else { priceLimit = BigDecimal.ZERO; priceList =
     * BigDecimal.ZERO; pricestdgross = BigDecimal.ZERO; }
     * 
     * int stdPrecision = 2; int pricePrecision = 2; OBContext.setAdminMode(true); try {
     * stdPrecision = order.getCurrency().getStandardPrecision().intValue(); pricePrecision =
     * order.getCurrency().getPricePrecision().intValue(); } finally {
     * OBContext.restorePreviousMode(); }
     * 
     * if (order.getPriceList().isPriceIncludesTax()) { BigDecimal qty = new BigDecimal(strQty);
     * priceGross = (strLastpriceso.equals("") ? ZERO : new BigDecimal(strLastpriceso)); amtGross =
     * priceGross.multiply(qty).setScale(stdPrecision, BigDecimal.ROUND_HALF_UP); priceActual =
     * FinancialUtils.calculateNetFromGross(strcTaxId, amtGross, pricePrecision, amtGross, qty);
     * priceLimit = priceActual; netPriceList = priceActual; grossPriceList = priceList; } else {
     * priceActual = (strLastpriceso.equals("") ? ZERO : new BigDecimal(strLastpriceso));
     * netPriceList = priceList; priceGross = BigDecimal.ZERO; amtGross = BigDecimal.ZERO;
     * grossPriceList = BigDecimal.ZERO; }
     * 
     * if (priceList.compareTo(BigDecimal.ZERO) == 0) { discount = ZERO; } else {
     * log4j.debug("pricelist:" + priceList.toString()); log4j.debug("priceActual:" +
     * priceActual.toString()); BigDecimal unitPrice; if (order.getPriceList().isPriceIncludesTax())
     * { unitPrice = pricestdgross; } else { unitPrice = priceActual; } // (PL-UP)/PL * 100 discount
     * = ((priceList.subtract(unitPrice)).multiply(new BigDecimal("100")).divide( priceList,
     * stdPrecision, BigDecimal.ROUND_HALF_UP)); } log4j.debug("Discount: " + discount.toString());
     * if (priceStd.scale() > pricePrecision) { priceStd = priceStd.setScale(pricePrecision,
     * BigDecimal.ROUND_HALF_UP); }
     * 
     * try { CopyFromOrdenServicioData.insertCOrderline(conn, this, strCOrderlineID,
     * orderData[0].adClientId, orderData[0].adOrgId, vars.getUser(), strKey,
     * orderData[0].cBpartnerId, orderData[0].cBpartnerLocationId, orderData[0].dateinvoiced,
     * orderData[0].dateinvoiced, strmProductId, orderData[0].mWarehouseId.equals("") ?
     * vars.getWarehouse() : orderData[0].mWarehouseId, strcUOMId, strQty, orderData[0].cCurrencyId,
     * netPriceList.toString(), priceActual.toString(), priceLimit.toString(), priceStd .toString(),
     * discount.toString(), strcTaxId, strmAttributesetinstanceId, grossPriceList.toString(),
     * priceGross.toString(), amtGross.toString(), pricestdgross .toString()); } catch
     * (ServletException ex) { myError = OBMessageUtils.translateError(this, vars,
     * vars.getLanguage(), ex.getMessage()); releaseRollbackConnection(conn); return myError; }
     * count++; }
     * 
     * releaseCommitConnection(conn); myError = new OBError(); myError.setType("Success");
     * myError.setTitle(OBMessageUtils.messageBD("Success"));
     * myError.setMessage(OBMessageUtils.messageBD("RecordsCopied") + " " + count); } catch
     * (Exception e) { try { releaseRollbackConnection(conn); } catch (Exception ignored) { }
     * e.printStackTrace(); log4j.warn("Rollback in transaction"); myError =
     * OBMessageUtils.translateError(this, vars, vars.getLanguage(), "ProcessRunError"); }
     */
    return myError;
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars,
      String strKey, String strWindowId, String strTabId, String strSOTrx, String strBpartner,
      String strmPricelistId) throws IOException, ServletException {
    log4j.debug("Output: Shipment");

    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "com/atrums/indumot/postventa/erpCommon/ad_actionButton/CopyFromOrdeSevicio")
        .createXmlDocument();
    CopyFromOrdenServicioRecordData[] dataOrder = CopyFromOrdenServicioRecordData.select(this,
        strKey);
    Invoice invoice = OBDal.getInstance().get(Invoice.class, strKey);
    CopyFromOrdenServicioData[] data = CopyFromOrdenServicioData.select(this, strBpartner);
    xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("theme", vars.getTheme());
    xmlDocument.setParameter("key", strKey);
    xmlDocument.setParameter("windowId", strWindowId);
    xmlDocument.setParameter("tabId", strTabId);
    xmlDocument.setParameter("sotrx", strSOTrx);
    xmlDocument.setParameter("orgname", dataOrder[0].orgname);
    String strInvoicing = CopyFromOrdenServicioRecordData.invoicing(this, strSOTrx, strBpartner,
        dataOrder[0].adOrgId, dataOrder[0].adClientId);
    String strTotal = CopyFromOrdenServicioRecordData.invoicingTotal(this, strSOTrx,
        dataOrder[0].adOrgId, dataOrder[0].adClientId);
    xmlDocument.setParameter("bpartnername", dataOrder[0].bpartnername);

    xmlDocument.setData("reportM_Pricelist_ID", "liststructure",
        CopyFromOrdenServicioListaPreciosData.select(this,
            Utility.getContext(this, vars, "#AccessibleOrgTree", "GeneralAccountingReports"),
            Utility.getContext(this, vars, "#User_Client", "GeneralAccountingReports")));

    xmlDocument.setData("structure1", data);
    xmlDocument.setData("structure2", dataOrder);
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();

  }

  public String getServletInfo() {
    return "Servlet Copy from order";
  } // end of getServletInfo() method
}
