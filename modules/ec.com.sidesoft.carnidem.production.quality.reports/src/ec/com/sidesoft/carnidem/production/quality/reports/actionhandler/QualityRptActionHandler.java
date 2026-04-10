package ec.com.sidesoft.carnidem.production.quality.reports.actionhandler;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.application.ApplicationConstants;
import org.openbravo.client.application.process.ResponseActionsBuilder.MessageType;
import org.openbravo.client.application.report.ReportingUtils.ExportType;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.production.quality.reports.actionhandler.QualityReportActionHandler;

public class QualityRptActionHandler extends QualityReportActionHandler {

  private static final Logger log = LoggerFactory.getLogger(QualityRptActionHandler.class);
  private static final String REPORT_FILE_EXT_pdf = ExportType.PDF.getExtension();
  private static final String REPORT_FILE_EXT_xls = ExportType.XLS.getExtension();
  private static final String REPORT_FILE_EXT_html = ExportType.HTML.getExtension();

  @Override
  protected JSONObject doExecute(Map<String, Object> parameters, String content) {
	  try {
	      parameters.replace("reportId", "8B324197DAF747319A9DBCD43E438A80");

	      final JSONObject jsonContent = new JSONObject(content);
	      if (jsonContent.has("_params")) {
	        JSONObject jsonParams = new JSONObject(jsonContent.getString("_params"));
	        if (jsonParams.has("outputType")) {
	        	String outputType = jsonParams.getString("outputType");
	        	String typeDoc = "";
	        	if(outputType.equals("pdf")) {
	        		typeDoc = REPORT_FILE_EXT_pdf;
	        	}else if(outputType.equals("xls")) {
	        		typeDoc = REPORT_FILE_EXT_xls;
	        	}else{
	        		typeDoc = REPORT_FILE_EXT_html;
	        	}
	        	
	          
	          jsonContent.put(ApplicationConstants.BUTTON_VALUE, typeDoc);
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
