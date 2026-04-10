package ec.com.sidesoft.asset.revaluation.ad_process;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;

import net.sf.jasperreports.engine.JasperPrint;

public class AssetRevaluationReport extends HttpSecureAppServlet {

  private static final long serialVersionUID = 1L;

  private String strSessionValue = "";
  private String strADUserID = "";
  private String strDocumentID = "";

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    strSessionValue = "800027|Ssarv_Value_Change_ID";

    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {

      strADUserID = vars.getUser().toString();
      strDocumentID = vars.getSessionValue(strSessionValue);

      strDocumentID = strDocumentID.replaceAll("\\(|\\)|'", "");
      if (strDocumentID.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));
      printPagePartePDF(response, vars);
    } else
      pageError(response);
  }

  void printPagePartePDF(HttpServletResponse response, VariablesSecureApp vars)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: PrintReport - pdf");
    JasperPrint jasperPrint;

    String strReportName = "@basedesign@/ec/com/sidesoft/asset/revaluation/ad_reports/AssetRevaluationReport.jrxml";
    response.setHeader("Content-disposition", "inline; filename=PrintReport.pdf");

    HashMap<String, Object> parameters = new HashMap<String, Object>();

    parameters.put("DOCUMENT_ID", strDocumentID);
    parameters.put("AD_USER_ID", strADUserID);

    renderJR(vars, response, strReportName, "pdf", parameters, null, null);
  }

  public String getServletInfo() {
    return "Servlet that presents the RptMInout seeker";
  } // End of getServletInfo() method
}