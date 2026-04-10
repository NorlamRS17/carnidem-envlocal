package ec.com.sidesoft.email.ad_process;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.ad.access.User;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TUS IMPORTS
import ec.com.sidesoft.email.AemSmtpConfig;
import ec.com.sidesoft.email.utils.EmailConnectionUtils;

public class TestSmtpConfigProcess extends DalBaseProcess {

  private static final Logger log = LoggerFactory.getLogger(TestSmtpConfigProcess.class);

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    OBError msg = new OBError();

    try {
      OBContext.setAdminMode(true);

      String smtpConfigId = (String) bundle.getParams().get("AEM_Smtp_Config_ID");

      if (smtpConfigId == null)
        smtpConfigId = (String) bundle.getParams().get("AemSmtpConfig_ID");
      if (smtpConfigId == null)
        smtpConfigId = (String) bundle.getParams().get("inpaemSmtpConfigId");

      if (smtpConfigId == null) {
        throw new Exception("Error técnico: No se recibió el ID del registro.");
      }

      AemSmtpConfig config = OBDal.getInstance().get(AemSmtpConfig.class, smtpConfigId);
      if (config == null)
        throw new Exception("No se encontró la configuración en BD.");

      User currentUser = OBContext.getOBContext().getUser();

      String subject = "Prueba de Conexión Exitosa - ERP";
      String finalBody = buildTestBody(config, currentUser);

      String recipient = config.getTestEmail();
      log.info("Enviando a: " + recipient);

      EmailConnectionUtils.send(config, recipient, null, subject, finalBody, null);
      config.setVerified(true);
      config.setLastTestDate(new Date());
      config.setLastTestMsg("Éxito. Conexión verificada por: " + currentUser.getName());
      OBDal.getInstance().save(config);
      OBDal.getInstance().flush();

      msg.setType("Success");
      msg.setTitle("Conexión Exitosa");
      msg.setMessage(
          "Correo de prueba enviado a " + recipient + ". Revisa los detalles de la conexión.");

    } catch (Exception e) {
      log.error("Error en test SMTP", e);
      msg.setType("Error");
      msg.setTitle("Error");
      msg.setMessage(e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
      bundle.setResult(msg);
    }
  }

  private String buildTestBody(AemSmtpConfig config, User currentUser) {
    StringBuilder sb = new StringBuilder();

    // Estructura HTML
    sb.append("<html><body style='font-family: Arial, sans-serif; padding: 20px; color: #333;'>");
    sb.append("<div style='max-width: 600px; margin: auto;'>");

    sb.append("<h1 style='color: #008000;'>¡Conexión Exitosa!</h1>");
    sb.append(
        "<p>Este es un correo automático para confirmar que su configuración SMTP en Openbravo.</p>");
    sb.append("<hr style='border: 0; border-top: 1px solid #ccc; margin: 15px 0;'>");

    sb.append("<h3>Detalles de la Configuración Probada:</h3>");
    sb.append("<ul style='list-style: disc; margin-left: 20px;'>");

    sb.append("<li><strong>Organización:</strong> ").append(config.getOrganization().getName())
        .append("</li>");
    sb.append("<li><strong>Host:</strong> ").append(config.getHost()).append("</li>");
    sb.append("<li><strong>Puerto:</strong> ").append(config.getPort()).append("</li>");
    if (StringUtils.isNotBlank(config.getSMTPServerAccount())) {
      sb.append("<li><strong>Usuario:</strong> ").append(config.getSMTPServerAccount())
          .append("</li>");
    }
    sb.append("<li><strong>Seguridad:</strong> ")
        .append(config.getSecurityConn() != null ? config.getSecurityConn() : "Ninguna")
        .append("</li>");

    sb.append("</ul>");

    sb.append(
        "<p style='font-size: 10px; color: #777; margin-top: 20px;'>Enviado desde el módulo de Gestión de Correos (AEM) por el usuario ")
        .append(currentUser.getName()).append(".</p>");

    sb.append("</div></body></html>");

    return sb.toString();
  }
}