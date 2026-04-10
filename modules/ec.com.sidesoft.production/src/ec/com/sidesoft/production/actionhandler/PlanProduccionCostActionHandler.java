package ec.com.sidesoft.production.actionhandler;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.application.ApplicationConstants;
import org.openbravo.client.application.ReportDefinition;
import org.openbravo.client.application.process.ResponseActionsBuilder.MessageType;
import org.openbravo.client.application.report.BaseReportActionHandler;
import org.openbravo.client.application.report.ReportingUtils.ExportType;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.manufacturing.processplan.Operation;
import org.openbravo.model.manufacturing.processplan.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanProduccionCostActionHandler extends BaseReportActionHandler {

  private static final Logger log = LoggerFactory.getLogger(PlanProduccionCostActionHandler.class);
  private static final String REPORT_FILE_EXT_pdf = ExportType.PDF.getExtension();
  private static final String REPORT_FILE_EXT_xls = ExportType.XLS.getExtension();
  private static final String REPORT_FILE_EXT_html = ExportType.HTML.getExtension();

  @Override
  protected void addAdditionalParameters(ReportDefinition process, JSONObject jsonContent,
      Map<String, Object> parameters) {
    try {
      String versionId = (String) jsonContent.get("MA_Processplan_Version_ID");
      
      parameters.put("DOCUMENT_ID", versionId);
      parameters.put("Org_ID", OBContext.getOBContext().getCurrentOrganization().getId());
      parameters.put("User_ID", OBContext.getOBContext().getUser().getId());
      parameters.put("LANGUAGE", OBContext.getOBContext().getLanguage().getLanguage());

    } catch (Exception e) {
      log.error("Error adding additional parameters: {}", e.getMessage(), e);
    }
    super.addAdditionalParameters(process, jsonContent, parameters);
  }

  @Override
  protected JSONObject doExecute(Map<String, Object> parameters, String content) {

    try {
      parameters.replace("reportId", "A154D17D653C4B40A8EFA59CB32A82C0");

      final JSONObject jsonContent = new JSONObject(content);
      String versionId = (String) jsonContent.get("MA_Processplan_Version_ID");
      
      Version version = OBDal.getInstance().get(Version.class, versionId);
      
      if (version == null) {
        return getResponseBuilder()
            .showMsgInProcessView(MessageType.ERROR, "Versión del plan de producción no encontrada.")
            .build();
      }
      
      OBCriteria<Operation> criteria = OBDal.getInstance().createCriteria(Operation.class);
      criteria.add(org.hibernate.criterion.Restrictions.eq(Operation.PROPERTY_PROCESSPLANVERSION, version));
      criteria.add(org.hibernate.criterion.Restrictions.eq(Operation.PROPERTY_ACTIVE, true));
      
      int sequenceCount = criteria.list().size();
      
      if (sequenceCount == 0) {
        return getResponseBuilder()
            .showMsgInProcessView(MessageType.WARNING, 
                "No hay secuencias definidas para esta versión del plan de producción. " +
                "Por favor, agregue al menos una secuencia antes de generar el reporte.")
            .build();
      }
      
      if (jsonContent.has("_params")) {
        JSONObject jsonParams = new JSONObject(jsonContent.getString("_params"));
        if (jsonParams.has("outputType")) {
          String outputType = jsonParams.getString("outputType");
          
          if (outputType.equals("xls")) {
            jsonContent.put(ApplicationConstants.BUTTON_VALUE, REPORT_FILE_EXT_xls);
          } else if (outputType.equals("html")) {
            jsonContent.put(ApplicationConstants.BUTTON_VALUE, REPORT_FILE_EXT_html);
          } else {
            jsonContent.put(ApplicationConstants.BUTTON_VALUE, REPORT_FILE_EXT_pdf);
          }
        }
      } else {
        jsonContent.put(ApplicationConstants.BUTTON_VALUE, REPORT_FILE_EXT_pdf);
      }

      return super.doExecute(parameters, jsonContent.toString());
      
    } catch (Exception e) {
      log.error("Error generating Plan Produccion Cost report: {}", e.getMessage(), e);
      return getResponseBuilder().retryExecution().showResultsInProcessView().showMsgInProcessView(
          MessageType.ERROR, OBMessageUtils.translateError(e.getMessage()).getMessage()).build();
    }
  }
}
