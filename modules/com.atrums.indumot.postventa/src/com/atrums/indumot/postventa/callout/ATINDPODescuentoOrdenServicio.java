package com.atrums.indumot.postventa.callout;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.xmlEngine.XmlDocument;

public class ATINDPODescuentoOrdenServicio extends HttpSecureAppServlet {
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

      String strUnitPrice = vars.getStringParameter("inpatindpoUnitprice");
      String strPriceList = vars.getStringParameter("inpatindpoPricelist");
      String strDiscount = vars.getStringParameter("inpatindpoDiscount");
      try {
        /*
         * if ("inpAtindpoDiscount".equals(strChanged)) { // Indica que objeto requiere el callout
         * printPage(response, vars, strUnitPrice, strPriceList, strDiscount); }
         */
        printPage(response, vars, strUnitPrice, strPriceList, strDiscount);
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }// Fin doPost

  private void printPage(HttpServletResponse response, VariablesSecureApp vars,
      String strUnitPrice, String strPriceList, String strDiscount) throws IOException,
      ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "com/atrums/indumot/postventa/callout/CallOut").createXmlDocument();

    float floUnitPrice = 0;
    float floPriceList = Float.valueOf(strPriceList);
    float floDiscount = Float.valueOf(strDiscount);

    floDiscount = round((floPriceList * (floDiscount / 100)), 2);

    floUnitPrice = floPriceList - floDiscount;
    // floUnitPrice = round(floUnitPrice, 2);
    // use a buffer variable to construct the generated code
    StringBuffer result = new StringBuffer();
    result.append("var calloutName='ATINDPODescuentoOrdenServicio';\n\n");
    result.append("var respuesta = new Array(");

    result.append("new Array(\"inpatindpoUnitprice\", \"" + floUnitPrice + "\")");

    result.append(");");

    // inject the generated code
    xmlDocument.setParameter("array", result.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }// Fin printPage

  public static float round(float f, int decimalPlace) {
    BigDecimal bd = new BigDecimal(f);
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
  }

}// Fin principal
