package com.atrums.indumot.postventa.erpCommon.ad_reports;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;

public class ATINDPOImprimirPreFactura extends HttpSecureAppServlet {

  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strProcessId = vars.getStringParameter("");
      String strWindow = vars.getStringParameter("");
      String strKey = vars.getStringParameter("inpatindpoPostventaId");
      String strMessage = "";

      printPage(response, vars, strKey, strWindow, strProcessId, strMessage, true);
    }
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strldtHblid,
      String windowId, String strProcessId, String strMessage, boolean isDefault)
      throws IOException, ServletException {

    String strMainReportName = "";

    HashMap<String, Object> parameters = new HashMap<String, Object>();

    if (log4j.isDebugEnabled())
      log4j.debug("Output: Reconciliation PDF report");

    try {
      strMainReportName = "@basedesign@/com/atrums/indumot/postventa/erpCommon/ad_reports/Rpt_atindpo_Prefactura.jrxml";
      OBContext.setAdminMode(true);
      String sourcepath= OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
      // Parameters
      parameters.put("DOCUMENT_ID", strldtHblid);
      parameters.put("SOURCE_PATH", sourcepath);

      OBContext.setAdminMode(true);

      response.setContentType("text/html; charset=UTF-8");
      renderJR(vars, response, strMainReportName, "pdf", parameters, null, null);

    } catch (Exception e) {
      throw new ServletException(e.getMessage());
    }
  }
}
