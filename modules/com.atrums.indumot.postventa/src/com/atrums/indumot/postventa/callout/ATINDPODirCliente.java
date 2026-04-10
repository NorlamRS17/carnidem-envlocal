package com.atrums.indumot.postventa.callout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.xmlEngine.XmlDocument;

public class ATINDPODirCliente extends HttpSecureAppServlet {
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

      String strBPartnerId = vars.getStringParameter("inpcBpartnerId");
      String strOrgId = vars.getStringParameter("inpadOrgId");
      try {
        if ("inpcBpartnerId".equals(strChanged)) { // Indica que objeto requiere el callout
          printPage(response, vars, strBPartnerId, strOrgId);
        }
      } catch (ServletException ex) {
        pageErrorCallOut(response);
      }
    } else
      pageError(response);
  }// Fin doPost

  private void printPage(HttpServletResponse response, VariablesSecureApp vars,
      String strBPartnerId, String strOrgId) throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: dataSheet");
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "com/atrums/indumot/postventa/callout/CallOut").createXmlDocument(); // Esto es el callour
                                                                             // copiado
    BusinessPartner ObjPartner = OBDal.getInstance().get(BusinessPartner.class, strBPartnerId);

    // Entrega las direcciones de facturación
    ATINDPODirClienteData[] data = ATINDPODirClienteData.select(this, strBPartnerId);
    AtindpoBPartnerMiscData[] data1 = AtindpoBPartnerMiscData.select(this, strBPartnerId);

    // use a buffer variable to construct the generated code
    StringBuffer result = new StringBuffer();
    result.append("var calloutName='ATINDPODirCliente';\n\n");
    result.append("var respuesta = new Array(");
    if (ObjPartner.getEEIEmail() != null) {
      result.append("new Array(\"inpemail\", \"" + ObjPartner.getEEIEmail() + "\"), ");
    }
    if (data != null && data.length > 0) {
      result.append("new Array(\"inpcBpartnerLocationId\",new Array(");
      for (int i = 0; i < data.length; i++) {
        result.append("new Array(\"" + data[i].getField("cBpartnerLocationId") + "\",\""
            + FormatUtilities.replaceJS(data[i].getField("name")) + "\",\""
            + (data[i].getField("isbillto").equalsIgnoreCase("Y") ? "true" : "false") + "\")");
        if (i < data.length - 1)
          result.append(",\n");
      }
      result.append(")),");
    } else {
      result.append("new Array(\"inpcBpartnerLocationId\",null),");
    }

    String strFinPaymentMethodId = "";
    String strPriceList = "";
    String PaymentTerm = "";
    if (data1 != null && data1.length > 0) {
      strFinPaymentMethodId = data1[0].finPaymentmethodId;
      strPriceList = data1[0].mPricelistId;
      PaymentTerm = data1[0].cPaymenttermId;
      result.append("new Array(\"inpfinPaymentmethodId\", \"" + strFinPaymentMethodId + "\"),");
      result.append("new Array(\"inpcPaymenttermId\", \"" + PaymentTerm + "\"),");
      if (strPriceList.equals("")) {
        result.append("new Array('ERROR', \""
            + "El cliente no tiene configurada una lista de precios" + "\")");
      } else {
        result.append("new Array(\"inpmPricelistId\", \"" + strPriceList + "\")");
      }

    }

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
