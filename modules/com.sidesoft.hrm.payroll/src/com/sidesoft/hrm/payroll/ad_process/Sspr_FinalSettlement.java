package com.sidesoft.hrm.payroll.ad_process;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.ad.ui.Window;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.utils.Replace;

import ec.com.sidesoft.custom.reports.SescrTemplateReport;

@SuppressWarnings("serial")
public class Sspr_FinalSettlement extends HttpSecureAppServlet {

	private String strSessionValue = "";
	private String StrWindowdID = "";
	private String StrTableID = "";
	private String strADUSerID = "";

	private static Logger log4j1 = Logger.getLogger(Sspr_FinalSettlement.class);

	public void init(ServletConfig config) {
		super.init(config);
		boolHist = false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		strSessionValue = "3F0BFA1E7F2643CD84E05BA6BDA8220D|Fact_Acct_ID";
		StrWindowdID = "3F0BFA1E7F2643CD84E05BA6BDA8220D";
		StrTableID = "270";

		VariablesSecureApp vars = new VariablesSecureApp(request);

		if (vars.commandIn("DEFAULT")) {
			String strDocumentId = vars.getSessionValue(strSessionValue);
			String strDocumentTempId = "";

			strADUSerID = vars.getUser().toString();

			// normalize the string of id to a comma separated list
			strDocumentId = strDocumentId.replaceAll("\\(|\\)|'", "");
			final AccountingFact ObjAccFact= OBDal.getInstance().get(AccountingFact.class, strDocumentId);
			strDocumentTempId = ObjAccFact.getRecordID();
			
			if (strDocumentId.length() == 0)
				throw new ServletException(Utility.messageBD(this, "NoDocument", vars.getLanguage()));

			if (log4j1.isDebugEnabled())
				log4j1.debug("strDocumentId: " + strDocumentTempId);
			printPagePDF(response, vars, strDocumentTempId);
		} else {
			pageError(response);

		}
	}

	private void printPagePDF(HttpServletResponse response, VariablesSecureApp vars, String strDocumentId)
			throws IOException, ServletException {
		ConnectionProvider conn = new DalConnectionProvider(false);
		String language = OBContext.getOBContext().getLanguage().getLanguage();

		// Type Formulary
		Window ADWindow = OBDal.getInstance().get(Window.class, StrWindowdID);
		Table ADTable = OBDal.getInstance().get(Table.class, StrTableID);

		OBCriteria<SescrTemplateReport> PrintWithh = OBDal.getInstance().createCriteria(SescrTemplateReport.class);
		PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_WINDOW, ADWindow));
		PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_TABLE, ADTable));
		// PrintWithh.add(Restrictions.eq(SescrTemplateReport.PROPERTY_ORGANIZATION,
		// ADOrg)); optional

		List<SescrTemplateReport> LstTemplate = PrintWithh.list();
		int ICountTemplate;
		ICountTemplate = LstTemplate.size();

		if (ICountTemplate == 0) {

			throw new OBException(Utility.messageBD(conn, "@Template no Found..@", language));

		}
		if (LstTemplate.get(0).getWindow().getId().equals(StrWindowdID)) {

			String StrRutaReport = LstTemplate.get(0).getTemplateDir();

			String strReportName = StrRutaReport + "/" + LstTemplate.get(0).getNameReport();

			final String strAttach = globalParameters.strFTPDirectory + "/284-" + classInfo.id;

			final String strLanguage = vars.getLanguage();

			final String strBaseDesign = getBaseDesignPath(strLanguage);

			strReportName = Replace.replace(Replace.replace(strReportName, "@basedesign@", strBaseDesign), "@attach@",
					strAttach);

			if (log4j1.isDebugEnabled())
				log4j1.debug("Output: Multiphase Project - pdf");
			String sourcepath = OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("DOCUMENT_ID", strDocumentId);
			String StrBaseWeb = getBaseDesignPath(strLanguage);
			parameters.put("BASE_WEB", StrBaseWeb);
			parameters.put("AD_USER_ID", strADUSerID);
			parameters.put("SOURCE_PATH", sourcepath);
			// String StrNameReport = LstTemplate.get(0).getTitle().replace(" ", "_") +
			// ".jrxml";

			renderJR(vars, response, strReportName, "pdf", parameters, null, null);

		}

	}
}
