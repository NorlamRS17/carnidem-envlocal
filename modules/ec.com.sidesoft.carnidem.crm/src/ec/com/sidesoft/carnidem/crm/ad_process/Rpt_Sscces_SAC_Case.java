package ec.com.sidesoft.carnidem.crm.ad_process;

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

@SuppressWarnings("serial")
public class Rpt_Sscces_SAC_Case extends HttpSecureAppServlet {

    // ID de la ventana CRM (ajústalo según tu sistema)
    private static final String STR_SESSION_VALUE = "55E422BBDE1841FA8086FD522A7678C5|Opcrm_Cases_ID";

    public void init(ServletConfig config) {
        super.init(config);
        boolHist = false;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        VariablesSecureApp vars = new VariablesSecureApp(request);

        if (vars.commandIn("DEFAULT")) {

            // Obtiene el ID del caso desde la sesión
            String strCaseId = vars.getSessionValue(STR_SESSION_VALUE);
            if (strCaseId == null || strCaseId.trim().isEmpty()) {
                throw new ServletException("No se encontró el ID del caso.");
            }

            strCaseId = strCaseId.replaceAll("\\(|\\)|'", ""); // normaliza
            printPage(response, vars, strCaseId);
        } else {
            pageError(response);
        }
    }

    private void printPage(HttpServletResponse response, VariablesSecureApp vars, String strCaseId)
            throws IOException, ServletException {

        String strMainReportName = "@basedesign@/ec/com/sidesoft/carnidem/crm/ad_reports/Rpt_Sscces_SAC_Case.jrxml";

        HashMap<String, Object> parameters = new HashMap<>();
        try {
            OBContext.setAdminMode(true);

            String sourcepath = OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");

            parameters.put("CASES_ID", strCaseId);
            parameters.put("SOURCE_PATH", sourcepath);

            response.setContentType("text/html; charset=UTF-8");

            renderJR(vars, response, strMainReportName, "pdf", parameters, null, null);

        } catch (Exception e) {
            throw new ServletException("Error al generar el reporte SAC: " + e.getMessage(), e);
        } finally {
            OBContext.restorePreviousMode();
        }
    }

    public String getServletInfo() {
        return "Reporte SAC para CRM";
    }
}
