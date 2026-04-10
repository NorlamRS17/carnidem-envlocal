package ec.com.sidesoft.ldm.report.ad_actionbutton;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.client.application.ApplicationConstants;
import org.openbravo.client.application.ReportDefinition;
import org.openbravo.client.application.process.ResponseActionsBuilder.MessageType;
import org.openbravo.client.application.report.BaseReportActionHandler;
import org.openbravo.client.application.report.ReportingUtils.ExportType;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.plm.ProductBOM;
import org.slf4j.Logger;
import java.util.List;
import java.util.ArrayList;

import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.database.ConnectionProvider;

import org.slf4j.LoggerFactory;

public class Ssldmrp_ReportCostLDM extends BaseReportActionHandler {

	private static final Logger log = LoggerFactory.getLogger(Ssldmrp_ReportCostLDM.class);
	private static final String REPORT_FILE_EXT_pdf = ExportType.PDF.getExtension();
	private static final String REPORT_FILE_EXT_xls = ExportType.XLS.getExtension();
	OBError message;

	@Override
	protected void addAdditionalParameters(ReportDefinition process, JSONObject jsonContent,
			Map<String, Object> parameters) {
		try {

			String productId = (String) jsonContent.get("M_Product_ID");

			final String userNameCurrent = OBContext.getOBContext().getUser().getName();
			parameters.put("USERNAME", userNameCurrent);

			parameters.put("DOCUMENT_ID", productId);
			parameters.put("LANGUAGE", OBContext.getOBContext().getLanguage().getLanguage());

		} catch (Exception e) {
		      log.debug(e.getMessage());
		}
		super.addAdditionalParameters(process, jsonContent, parameters);
	}

	@Override
	protected JSONObject doExecute(Map<String, Object> parameters, String content) {

		try {
			parameters.replace("reportId", "8B324197DAF747319A9DBCD43E438DAM");

			final JSONObject jsonContent = new JSONObject(content);
			if (jsonContent.has("_params")) {
				JSONObject jsonParams = new JSONObject(jsonContent.getString("_params"));
				if (jsonParams.has("outputType")) {
					String outputType = jsonParams.getString("outputType");
					jsonContent.put(ApplicationConstants.BUTTON_VALUE,
							outputType.equals("xls") ? REPORT_FILE_EXT_xls : REPORT_FILE_EXT_pdf);
				}
			} else {
				jsonContent.put(ApplicationConstants.BUTTON_VALUE, REPORT_FILE_EXT_pdf);
			}

			return super.doExecute(parameters, jsonContent.toString());
		} catch (Exception e) {
			log.error("Error generating report id: {}", parameters.get("reportId"), e);
			return getResponseBuilder().retryExecution().showResultsInProcessView()
					.showMsgInProcessView(MessageType.ERROR, OBMessageUtils.translateError(e.getMessage()).getMessage())
					.build();
		}
	}
}
