package ec.com.sidesoft.email.utils;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.utility.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.email.AemSmtpConfig;
import ec.com.sidesoft.email.AemTemplate;

public class EmailManager {
  private static final Logger log = LoggerFactory.getLogger(EmailManager.class);

  public static void sendUsingTemplate(AemSmtpConfig config, String templateId,
      BaseOBObject dataObject, String forcedRecipient) throws Exception {

    if (config == null)
      throw new Exception("Configuración SMTP no proporcionada.");
    if (templateId == null || templateId.isEmpty())
      throw new Exception("ID de Plantilla no proporcionado.");
    if (dataObject == null)
      throw new Exception("Objeto de datos es nulo.");

    String recipient = forcedRecipient;

    AemTemplate template = OBDal.getInstance().get(AemTemplate.class, templateId);
    if (template == null) {
      throw new Exception("No se encontró la plantilla con ID: " + templateId);
    }

    log.info("Procesando plantilla '{}' para objeto {}", template.getIdentifier(),
        dataObject.getIdentifier());

    String rawSubject = template.getSubject();
    String rawBody = template.getBodyContent();

    String finalSubject = EmailParserUtils.parse(rawSubject, template, dataObject);
    String finalBody = EmailParserUtils.parse(rawBody, template, dataObject);

    if (recipient == null || recipient.isEmpty()) {
      if (dataObject.getEntity().hasProperty("email")) {
        Object mailObj = dataObject.get("email");
        if (mailObj != null)
          recipient = mailObj.toString();
      }
    }

    if (recipient == null || recipient.isEmpty()) {
      throw new Exception("No se pudo determinar el destinatario para el correo.");
    }

    Image logoImage = template.getLogoImage();

    EmailConnectionUtils.send(config, recipient, null, finalSubject, finalBody, logoImage);

    log.info("Manager: Correo enviado exitosamente a {}", recipient);
  }
}