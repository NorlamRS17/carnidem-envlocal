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
import org.openbravo.dal.service.OBDal;
import org.openbravo.xmlEngine.XmlDocument;

import com.atrums.indumoto.postventa.data.atindpo_postventa;

public class ATINDPOCalculoValorLinea extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    if (vars.commandIn("DEFAULT")) {
      String strChanged = vars.getStringParameter("inpLastFieldChanged");
      if (log4j.isDebugEnabled())
        log4j.debug("CHANGED: " + strChanged);

      String strUnitPrice = vars.getStringParameter("inpatindpoUnitprice").replace(",", "");
      String strCantidad = vars.getStringParameter("inpcantidad").replace(",", "");
      String strDiscount = vars.getStringParameter("inpatindpoDiscount").replace(",", "");
      String strPriceList = vars.getStringParameter("inpatindpoPricelist").replace(",", "");
      String strPostventaId = vars.getStringParameter("inpatindpoPostventaId").replace(",", "");

      atindpo_postventa postventa = OBDal.getInstance().get(atindpo_postventa.class,
          strPostventaId);
      String strMProductID = vars.getStringParameter("inpmProductId");

      // Price
      String strMPricelistId = postventa.getPriceList().getId();
      ATINDPOProductIDData[] data = ATINDPOProductIDData.select(this, strMProductID,
          strMPricelistId);
      strUnitPrice = data[0].pricelist;
      strPriceList = data[0].pricestd;
      try {
        if (strChanged.equals("inpatindpoUnitprice")) {
          printPage2(response, vars, strUnitPrice, strPriceList, strCantidad, strDiscount);
        } else {
          printPage(response, vars, strUnitPrice, strPriceList, strCantidad, strDiscount);
        }
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }// Fin doPost

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strUnitPrice,
      String strPriceList, String strCantidad, String strDiscount)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine
        .readXmlTemplate("com/atrums/indumot/postventa/callout/CallOut").createXmlDocument();

    float floLinenetamt = 0;
    float floUnitPrice = Float.valueOf(strUnitPrice);
    float floCantidad = Float.valueOf(strCantidad);
    float floPriceList = Float.valueOf(strPriceList);
    float floDiscount = Float.valueOf(strDiscount);

    if (floDiscount != 0) {
      floDiscount = round((floPriceList * (floDiscount / 100)), 2);

      floUnitPrice = floPriceList - floDiscount;

      floLinenetamt = floUnitPrice * floCantidad;
    } else {
      floLinenetamt = floUnitPrice * floCantidad;
    }

    // use a buffer variable to construct the generated code
    StringBuffer result = new StringBuffer();
    result.append("var calloutName='ATINDPOCalculoValorLinea';\n\n");
    result.append("var respuesta = new Array(");

    result.append("new Array(\"inpatindpoPricelist\", \"" + strPriceList + "\"),");
    result.append("new Array(\"inpatindpoLinenetamt\", \"" + floLinenetamt + "\"),");
    result.append("new Array(\"inpatindpoUnitprice\", \"" + floUnitPrice + "\")");

    result.append(");");

    xmlDocument.setParameter("array", result.toString());
    xmlDocument.setParameter("frameName", "appFrame");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }// Fin printPage

  private void printPage2(HttpServletResponse response, VariablesSecureApp vars,
      String strUnitPrice, String strPriceList, String strCantidad, String strDiscount)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine
        .readXmlTemplate("com/atrums/indumot/postventa/callout/CallOut").createXmlDocument();
    String strChanged = vars.getStringParameter("inpLastFieldChanged");
    float floLinenetamt = 0;
    strUnitPrice = vars.getStringParameter("inpatindpoUnitprice").replace(",", "");
    strCantidad = vars.getStringParameter("inpcantidad").replace(",", "");
    strDiscount = vars.getStringParameter("inpatindpoDiscount").replace(",", "");
    strPriceList = vars.getStringParameter("inpatindpoPricelist").replace(",", "");

    float floUnitPrice = Float.valueOf(strUnitPrice);
    float floCantidad = Float.valueOf(strCantidad);
    float floPriceList = Float.valueOf(strPriceList);
    float floDiscount = Float.valueOf(strDiscount);

    if (floDiscount != 0) {
      floDiscount = round((floPriceList * (floDiscount / 100)), 2);

      floUnitPrice = floUnitPrice - floDiscount;

      floLinenetamt = floUnitPrice * floCantidad;
    } else {
      floLinenetamt = floUnitPrice * floCantidad;
    }

    // use a buffer variable to construct the generated code
    StringBuffer result = new StringBuffer();
    result.append("var calloutName='ATINDPOCalculoValorLinea';\n\n");
    result.append("var respuesta = new Array(");

    result.append("new Array(\"inpatindpoLinenetamt\", \"" + floLinenetamt + "\"),");
    result.append("new Array(\"inpatindpoUnitprice\", \"" + floUnitPrice + "\")");

    result.append(");");

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
