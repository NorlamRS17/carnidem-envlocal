package ec.com.sidesoft.workorder.simplified.report.ad_actions;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.businessUtility.TabAttachments;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.service.db.DalConnectionProvider;

import com.atrums.indumoto.postventa.data.atindpo_postventa;

import ec.com.sidesoft.workorder.simplified.SswosSetting;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class PrintDocumentsActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject result = new JSONObject();

    try {
      final JSONObject jsonData = new JSONObject(data);
      final String customerType = jsonData.getString("customerType");
      final JSONArray rows = jsonData.getJSONArray("rows");

      final String sourcePath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("source.path");
      final String attachPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("attach.path");
      final String contextName = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("context.name");

      final String rowId = rows.getString(0);
      final String tableId = "EADABF583490439FAEAA2E1050AE3A1B"; // atindpo_postventa
      final Table table = OBDal.getInstance().get(Table.class, tableId);
      String moduleName = "";
      String reportName = "";
      String reportPath = "";
      String reporttemplate = "";
      // Obtenemos la cotizacion
      atindpo_postventa quotation = OBDal.getInstance().get(atindpo_postventa.class, rowId);

      // Organizacion padre
      Organization parentOrg = OBDal.getInstance().get(Organization.class, "0");
      // Traer configuracion
      OBCriteria<SswosSetting> settingList = OBDal.getInstance().createCriteria(SswosSetting.class);
      settingList.add(Restrictions.eq(SswosSetting.PROPERTY_ACTIVE, true));
      if (settingList.list().size() == 0) {
        throw new OBException("No existe configuracion para Reportes Orden Servicio.");
      }

      // Consultar attachments del registro y eliminar
      deleteAttachments(attachPath, tableId, rowId);

      // Generar reporte, crear attachments
      List<JSONObject> files = new ArrayList<JSONObject>();
      for (int i = 0; i < settingList.list().size(); i++) {
        SswosSetting setting = settingList.list().get(i);
        String filePath = TabAttachments.getAttachmentDirectoryForNewAttachments(tableId, rowId);
        moduleName = setting.getModuleName();
        reportName = setting.getCommercialName();
        reportPath = setting.getTemplatePath();
        reporttemplate = setting.getTemplateName();

        createReport(rowId, sourcePath, attachPath, filePath, moduleName, reportName, reportPath,
            reporttemplate);
        insertAttachment(quotation, reportName + ".pdf", tableId, filePath);
        files.add(new JSONObject().put("name", reportName).put("path", filePath));

      }

      result.put("status", "OK");
      result.put("files", files);
      result.put("contextName", contextName);
    } catch (Exception e) {
      System.out.println("PrintDocumentsActionHandler: " + e.getMessage());
      try {
        result.put("status", "ERROR");
        result.put("message", e.getMessage());
      } catch (Exception ex) {
      }
    }
    OBContext.setAdminMode(false);
    return result;
  }

  private void deleteAttachments(String attachPath, String tableId, String recordId) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    try {
      String sql = "SELECT f.c_file_id, f.name, f.path " + "FROM c_file AS f "
          + "WHERE f.ad_table_id=? AND f.ad_record_id=? ";
      PreparedStatement st = null;
      st = conn.getPreparedStatement(sql);
      st.setString(1, tableId);
      st.setString(2, recordId);

      ResultSet resultSet = st.executeQuery();

      String fileId, fileName, filePath;
      File file;
      while (resultSet.next()) {
        fileId = resultSet.getString("c_file_id");
        fileName = resultSet.getString("name");
        filePath = resultSet.getString("path");
        file = new File(attachPath + File.separator + filePath + File.separator + fileName);
        if (file.exists()) {
          if (!file.delete()) {
            throw new OBException("Error al intentar eliminar el archivo " + fileName);
          }
        }
        Attachment attachment = OBDal.getInstance().get(Attachment.class, fileId);
        OBDal.getInstance().remove(attachment);
        OBDal.getInstance().flush();
      }
    } catch (Exception e) {
      throw new OBException("deleteAttachments: " + e.getMessage());
    }
  }

  public void createReport(String recordId, String sourcePath, String attachPath, String filePath,
      String moduleName, String reportName, String reportPath, String reporttemplate) {
    try {
      final ConnectionProvider conn = new DalConnectionProvider(false);
      final Connection connDB = conn.getTransactionConnection();
      User user = OBContext.getOBContext().getUser();
      final String baseDesign = sourcePath + "/modules/" + moduleName + "/src";

      // Path del attachment
      final String path = attachPath + File.separator + filePath;
      final String outputFile = path + File.separator + reportName + ".pdf";

      File file = new File(path);
      if (!file.exists()) {
        if (!file.mkdirs()) {
          throw new OBException("Error al intentar crear el directorio " + file.getAbsolutePath());
        }
      }

      String templateFullPath = baseDesign + reportPath + reporttemplate;

      HashMap<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("DOCUMENT_ID", recordId);
      parameters.put("AD_USER_ID", user.getId());
      parameters.put("BASE_DESIGN", baseDesign);
      parameters.put("REPORT_CONNECTION", connDB);
      parameters.put("SOURCE_PATH", attachPath);

      JasperReport report = JasperCompileManager.compileReport(templateFullPath);
      JasperPrint print = JasperFillManager.fillReport(report, parameters, connDB);
      JasperExportManager.exportReportToPdfFile(print, outputFile);

      connDB.close();
      conn.destroy();
    } catch (Exception e) {
      throw new OBException("createReport: " + e.getMessage());
    }
  }

  private boolean insertAttachment(atindpo_postventa quotation, String fileName, String tableId,
      String path) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    boolean result = false;
    try {
      final Attachment att_file = OBProvider.getInstance().get(Attachment.class);
      att_file.setName(fileName);
      att_file.setDataType("application/pdf");
      Table tableInv = OBDal.getInstance().get(Table.class, tableId);
      att_file.setTable(tableInv);
      att_file.setRecord(quotation.getId());
      att_file.setPath(path);
      final OBCriteria<Attachment> critRF = OBDal.getInstance().createCriteria(Attachment.class);
      critRF.add(Restrictions.eq("record", quotation.getId()));
      int iRF = critRF.list().size();
      att_file.setSequenceNumber(Long.parseLong(String.valueOf((iRF + 1) * 10)));

      OBDal.getInstance().save(att_file);
      OBDal.getInstance().flush();
      result = true;
    } catch (Exception e) {
      System.out.println("insertAttachment: " + e.getMessage());
    }
    return result;
  }

}
