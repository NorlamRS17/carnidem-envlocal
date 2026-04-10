package ec.com.sidesoft.carnidem.inventtory.reports.ad_actionhandler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import ec.com.sidesoft.production.quality.reports.actionhandler.QualityReportActionHandler;

public class InventoryRptActionHandler extends BaseReportActionHandler {

  private static final Logger log = LoggerFactory.getLogger(InventoryRptActionHandler.class);
  private static final String REPORT_FILE_EXT_pdf = ExportType.PDF.getExtension();
  private static final String REPORT_FILE_EXT_xls = ExportType.XLS.getExtension();
  private static final String REPORT_FILE_EXT_html = ExportType.HTML.getExtension();

  @Override
  protected void addAdditionalParameters(ReportDefinition process, JSONObject jsonContent,
      Map<String, Object> parameters) {
    try {
      String documentId = (String) jsonContent.get("M_Inventory_ID");
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
	      parameters.replace("reportId", "EEB5D975F0694DB8BDFBCCCC528BF75A");
	      JSONObject cont = new JSONObject(content);
	      JSONObject para = (JSONObject) cont.get("_params");
	      String dateFrom = para.getString("DateFrom");
	      String dateTo = para.getString("DateTo");
	      
	      DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	          LocalDate from = LocalDate.parse(dateFrom, fmt);
	          LocalDate to   = LocalDate.parse(dateTo,   fmt);
	          LocalDate today = LocalDate.now();

	          if (from.isAfter(to)) {
	              throw new IllegalArgumentException(
	                  "La 'Fecha Desde' no puede ser posterior a 'Fecha Hasta'");
	          }
	          if (to.isAfter(today)) {
	              throw new IllegalArgumentException(
	                  "La 'Fecha Hasta' no puede ser posterior a la fecha actual");
	          }

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
