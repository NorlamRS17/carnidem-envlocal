package ec.com.sidesoft.carnidem.production.maintenance.ad_reports;

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
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.access.User;

public class ScmaPrintReport extends HttpSecureAppServlet {

  private static final long serialVersionUID = 1L;

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strProcessId = vars.getStringParameter("inpProcessId");
      String strWindow = vars.getStringParameter("inpWindowId");
      String strKey = vars.getStringParameter("inpmaMaintPartId");
      String strMessage = "";
      
      
      String strDocumentId = vars.getSessionValue("E052C86CC62E42C19CE097A03E178558|MA_MAINT_PART_ID");

        //printPage(response, vars, strKey, strWindow, strProcessId, strMessage, true);
    //}
   // normalize the string of ids to a comma separated list
      strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
      if (strDocumentId.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

      if (log4j.isDebugEnabled())
        log4j.debug("strDocumentId: " + strDocumentId);
      printPage(response, vars, strDocumentId);
    } else {
      pageError(response);
    }
  
  }

  private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strldtHblid)
      throws IOException, ServletException {

    String strMainReportName = "";

    HashMap<String, Object> parameters = new HashMap<String, Object>();

    if (log4j.isDebugEnabled())
      log4j.debug("Output: Reconciliation PDF report");
    try {
      strMainReportName = "@basedesign@/ec/com/sidesoft/carnidem/production/maintenance/ad_reports/scma_maintenancemain.jrxml";
      OBContext.setAdminMode(true);
      String sourcepath = OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
      User currentUser = OBContext.getOBContext().getUser();
      String userName = currentUser.getName();
      // Parameters
      parameters.put("DOCUMENT_ID", strldtHblid);
      parameters.put("SOURCE_PATH", sourcepath);
      parameters.put("USER", userName);

      response.setContentType("text/html; charset=UTF-8");
      renderJR(vars, response, strMainReportName, "pdf", parameters, null, null);

    } catch (Exception e) {
      throw new ServletException(e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
    }
  }
}
