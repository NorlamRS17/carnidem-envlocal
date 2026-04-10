package com.atrums.indumot.postventa.callout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.xmlEngine.XmlDocument;

public class ATINDPOProductID extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      String strChanged = vars.getStringParameter("inpLastFieldChanged");
      if (log4j.isDebugEnabled())
        log4j.debug("CHANGED: " + strChanged);

      String strMPricelistId = vars.getStringParameter("inpmPricelistId");
      String strMProductId = vars.getStringParameter("inpmProductId");
      String strMLocatorId = vars.getStringParameter("inpmProductId_LOC");
      try {

        printPage(response, vars, strMPricelistId, strMProductId, strMLocatorId);

        // if ("inpMProductID".equals(strChanged)) { // Indica que objeto requiere el callout
        // printPage(response, vars, strCBPartnerId, strMProductId);
        // }
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }// Fin doPost

  private void printPage(HttpServletResponse response, VariablesSecureApp vars,
      String strMPricelistId, String strMProductId, String strMLocatorId) throws IOException,
      ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "com/atrums/indumot/postventa/callout/CallOut").createXmlDocument();

    ATINDPOProductIDData[] data = ATINDPOProductIDData.select(this, strMProductId, strMPricelistId);

    StringBuffer result = new StringBuffer();
    result.append("var calloutName='ATINDPOProductID';\n\n");
    result.append("var respuesta = new Array(");

    if (data.length != 0) {
      if (data[0].pricelist != null && data[0].pricestd != null) {
        result.append("new Array(\"inpatindpoUnitprice\", \"" + data[0].pricelist + "\"),");
        result.append("new Array(\"inpatindpoPricelist\", \"" + data[0].pricestd + "\"),");
        result.append("new Array(\"inpcTaxId\", \"" + data[0].cTaxId + "\"),");
        result.append("new Array(\"inpmLocatorId\", \"" + strMLocatorId + "\")");
      } else {
        result.append("new Array(\"inpatindpoUnitprice\", \"" + 0 + "\"),");
        result.append("new Array(\"inpatindpoPricelist\", \"" + 0 + "\"),");
        result.append("new Array(\"inpmLocatorId\", \"" + strMLocatorId + "\"),");
        result.append("new Array('ERROR', \""
            + "El cliente no tiene configurada una lista de precios" + "\")");
      }
    } else {
      result.append("new Array(\"inpatindpoUnitprice\", \"" + 0 + "\"),");
      result.append("new Array(\"inpatindpoPricelist\", \"" + 0 + "\"),");
      result.append("new Array(\"inpmLocatorId\", \"" + strMLocatorId + "\"),");
      result.append("new Array('ERROR', \""
          + "El cliente no tiene configurada una lista de precios" + "\")");
    }
    // use a buffer variable to construct the generated code
    result.append(");");
    // inject the generated code
    xmlDocument.setParameter("array", result.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }// Fin printPage
}// Fin principal
