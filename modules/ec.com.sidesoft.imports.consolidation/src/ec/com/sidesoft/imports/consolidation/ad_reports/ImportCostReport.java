package ec.com.sidesoft.imports.consolidation.ad_reports;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
//import org.openbravo.base.model.Table;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.ui.Window;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.Replace;
import org.openbravo.base.session.OBPropertiesProvider;

@SuppressWarnings("serial")
public class ImportCostReport extends HttpSecureAppServlet {

  private String strSessionValue = "";
  private String StrWindowdID = "";
  private String StrTableID = "";
  private String strADUSerID = "";

  private static Logger log4j1 = Logger.getLogger(ImportCostReport.class);

  public void init(ServletConfig config) {
    super.init(config);
    boolHist = false;
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    strSessionValue = "181|SSIP_COSTIMPORT_ID";
    StrWindowdID = "67C3F5060FE3451681828B742B3715A2";
    StrTableID = "B9AA966B759748ACBAB9E5D9552A6659";

    VariablesSecureApp vars = new VariablesSecureApp(request);

    if (vars.commandIn("DEFAULT")) {
      String strDocumentId = vars.getSessionValue(strSessionValue);

      strADUSerID = vars.getUser().toString();

      // normalize the string of id to a comma separated list
      strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
      if (strDocumentId.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

      if (log4j1.isDebugEnabled())
        log4j1.debug("strDocumentId: " + strDocumentId);
      printPagePDF(response, vars, strDocumentId,strADUSerID);
    } else {
      pageError(response);

    }
  }

  void printPagePDF(HttpServletResponse response, VariablesSecureApp vars, String id,String user_id)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled())
      log4j.debug("Output: PrintReport - pdf");

    String strReportName = "@basedesign@/ec/com/sidesoft/imports/consolidation/ad_reports/Rpt_ImportCost.jrxml";
    response.setHeader("Content-disposition", "inline; filename=PrintReport.pdf");

    HashMap<String, Object> parameters = new HashMap<String, Object>();

    parameters.put("costimport_id", id);
    parameters.put("AD_USER_ID", user_id);

    renderJR(vars, response, strReportName, "xls", parameters, null, null);
  }

  public String getServletInfo() {
    return "Servlet that processes the print action";
  } // End of getServletInfo() method
}
