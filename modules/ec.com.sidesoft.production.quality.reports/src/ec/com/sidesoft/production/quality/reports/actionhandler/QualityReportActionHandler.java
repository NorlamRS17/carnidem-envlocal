package ec.com.sidesoft.production.quality.reports.actionhandler;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.application.ApplicationConstants;
import org.openbravo.client.application.ReportDefinition;
import org.openbravo.client.application.process.ResponseActionsBuilder.MessageType;
import org.openbravo.client.application.report.BaseReportActionHandler;
import org.openbravo.client.application.report.ReportingUtils.ExportType;
import org.openbravo.dal.core.OBContext;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QualityReportActionHandler extends BaseReportActionHandler {

  private static final Logger log = LoggerFactory.getLogger(QualityReportActionHandler.class);
  private static final String REPORT_FILE_EXT_pdf = ExportType.PDF.getExtension();
  private static final String REPORT_FILE_EXT_xls = ExportType.XLS.getExtension();

  @Override
  protected void addAdditionalParameters(ReportDefinition process, JSONObject jsonContent,
      Map<String, Object> parameters) {
    try {
      String documentId = (String) jsonContent.get("MA_Measure_Shift_ID");
      parameters.put("DOCUMENT_ID", documentId);
      parameters.put("LANGUAGE", OBContext.getOBContext().getLanguage().getLanguage());

    } catch (Exception e) {
      log.debug(e.getMessage());
    }
    super.addAdditionalParameters(process, jsonContent, parameters);
  }

  @Override
  protected JSONObject doExecute(Map<String, Object> parameters, String content) {

    try {
      parameters.replace("reportId", "8B324197DAF747319A9DBCD43E438A80");

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
      return getResponseBuilder().retryExecution().showResultsInProcessView().showMsgInProcessView(
          MessageType.ERROR, OBMessageUtils.translateError(e.getMessage()).getMessage()).build();
    }
  }
}
