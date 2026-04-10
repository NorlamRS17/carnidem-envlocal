/*
 * ************************************************************************ The
 * contents of this file are subject to the Openbravo Public License Version 1.1
 * (the "License"), being the Mozilla Public License Version 1.1 with a
 * permitted attribution clause; you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * http://www.openbravo.com/legal/license.html Software distributed under the
 * License is distributed on an "AS IS" basis, WITHOUT WARRANTY OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing rights and limitations under the License. The Original Code is
 * Openbravo ERP. The Initial Developer of the Original Code is Openbravo SLU All
 * portions are Copyright (C) 2001-2010 Openbravo SLU All Rights Reserved.
 * Contributor(s): ______________________________________.
 * ***********************************************************************
 */
package ec.com.sidesoft.texticom.reports.ad_process;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.dal.service.OBDal;

//Models
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.manufacturing.transaction.WorkRequirementOperation;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;

@SuppressWarnings("serial")
public class Rpt_WorkRequirement extends HttpSecureAppServlet {
  private static Logger log4j = Logger.getLogger(Rpt_WorkRequirement.class);

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
          .getSessionValue("C6FF17AB1F6E41499D21CD2F37389F48|MA_WorkRequirement_ID");

      // normalize the string of ids to a comma separated list
      strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
      if (strDocumentId.length() == 0)
        throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

      if (log4j.isDebugEnabled())
        log4j.debug("strDocumentId: " + strDocumentId);
      printPagePDF(response, vars, strDocumentId);
    } else {
      pageError(response);
    }
  }

  private void printPagePDF(HttpServletResponse response, VariablesSecureApp vars,
      String strDocumentId) throws IOException, ServletException {

    if (log4j.isDebugEnabled())
      log4j.debug("Output: Rpt_QuoteFromOpportunity - pdf");

    String production_id = "";
    WorkRequirement workRequirement = OBDal.getInstance().get(WorkRequirement.class, strDocumentId);
    WorkRequirementOperation workRequirementOperation = workRequirement
        .getManufacturingWorkRequirementOperationList().get(0);

    if (workRequirementOperation != null
        && workRequirementOperation.getMaterialMgmtProductionPlanList().size() > 0) {
      ProductionPlan productionPlan = workRequirementOperation.getMaterialMgmtProductionPlanList()
          .get(0);
      production_id = productionPlan.getProduction().getId();
    }

    HashMap<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("document_id", workRequirement.getId().toString());
    parameters.put("m_production_id", (workRequirementOperation != null ? production_id : null));

    // Map<Object, Object> exportParameters = new HashMap<Object, Object>();
    // exportParameters.put("Is One Page per Sheet", false);

    String strReportPath = "@basedesign@/ec/com/sidesoft/texticom/reports/ad_Reports/workRequirement/Rpt_work_requirement_general.jrxml";
    // String strReportName = "testexcel";
    // renderJR(vars, response, strReportPath, strReportName, "xls", parameters, null,
    // exportParameters, false);
    renderJR(vars, response, strReportPath, null, "xls", parameters, null, null, false);
  }

  public String getServletInfo() {
    return "Servlet that processes the print action";
  } // End of getServletInfo() method
}
