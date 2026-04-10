package ec.com.sidesoft.projects.complement.ad_process;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;

@SuppressWarnings("serial")
public class SproctmPrintTimeEsp extends HttpSecureAppServlet {
  // private static Logger log4j = Logger.getLogger(SproctmPrintTimeEsp.class);

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  @SuppressWarnings("unchecked")
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strDocumentId = vars
          .getSessionValue("4FD38F51BFE141BB8E75C8B5A149725A|S_TimeExpense_ID"); // ID Ventana - ID
                                                                                 // KEY

      // normalize the string of ids to a comma separated list
      strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
      if (strDocumentId.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

      printPagePDF(response, vars, strDocumentId);
    } else {
      pageError(response);

    }
  }

  @SuppressWarnings("resource")
  private void printPagePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strDocumentId) throws IOException, ServletException {
    String strAD_UserID = vars.getUser().toString();
    HashMap<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("AD_USER_ID", strAD_UserID);
    parameters.put("S_TimeExpense_ID", strDocumentId);

    String strReportName = "@basedesign@/ec/com/sidesoft/projects/complement/ad_reports/Sproctm_TimeExpenseProj.jrxml";
    renderJR(vars, response, strReportName, "pdf", parameters, null, null);
    /*
     * ConnectionProvider conn = new DalConnectionProvider(false); String language =
     * OBContext.getOBContext().getLanguage().getLanguage();
     * 
     * String StrWindowdID = ""; String StrTableID = ""; StrWindowdID = "191"; StrTableID = "325";
     * String StrTransactionID = vars.getSessionValue("191|M_PRODUCTION_ID"); System.out.print("K");
     */
  }

  public String getServletInfo() {
    return "Servlet that processes the print action";
  } // End of getServletInfo() method

}
