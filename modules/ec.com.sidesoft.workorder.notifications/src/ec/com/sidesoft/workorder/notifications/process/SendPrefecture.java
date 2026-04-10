package ec.com.sidesoft.workorder.notifications.process;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.businessUtility.TabAttachments;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DbUtility;

import com.atrums.indumoto.postventa.data.atindpo_postventa;

import ec.com.sidesoft.workorder.notifications.SSWONStatusReport;
import ec.com.sidesoft.workorder.notifications.utils.Helper;

public class SendPrefecture extends DalBaseProcess {
  private static final Logger log4j = Logger.getLogger(SendPrefecture.class);
  private static ProcessLogger logger;
  private final String tableId = "EADABF583490439FAEAA2E1050AE3A1B";

  @Override
  public void doExecute(ProcessBundle bundle) throws Exception {
    OBError msg = new OBError();
    try {
      OBContext.setAdminMode(true);
      logger = bundle.getLogger();
      String sourcePath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("source.path");
      String attachPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("attach.path");
      String contextName = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("context.name");

      final String serviceOrderId = (String) bundle.getParams().get("Atindpo_Postventa_ID");
      final String send = (String) bundle.getParams().get("send");

      if (send.equals("Y")) {

        // Consultamos si existe configuracion para enviar correos
        EmailServerConfiguration emailServerConfig = Helper.getEmailServerConfig();
        if (emailServerConfig == null) {
          throw new OBException("No existe configuracion del servidor para envio de email");
        }

        atindpo_postventa serviceOrder = OBDal.getInstance().get(atindpo_postventa.class,
            serviceOrderId);

        String addressee = serviceOrder.getEmail() != null ? serviceOrder.getEmail() : "";

        if (!addressee.isEmpty()) {
          List<File> attachments = new ArrayList<File>();
          File file;
          String filePath = TabAttachments.getAttachmentDirectoryForNewAttachments(tableId,
              serviceOrder.getId());

          SSWONStatusReport statusReport = OBProvider.getInstance().get(SSWONStatusReport.class);
          statusReport.setName("Pre-Factura");
          statusReport.setModuleName("com.atrums.indumot.postventa");
          statusReport.setTemplatePath("/com/atrums/indumot/postventa/erpCommon/ad_reports/");
          statusReport.setTemplateName("Rpt_atindpo_Prefactura.jrxml");

          file = Helper.createReport(serviceOrder.getId(), sourcePath, attachPath, filePath,
              statusReport);
          if (file != null) {
            attachments.add(file);
          }

          // Preparamos el correo
          String subject = "Pre-Factura";
          String body = "Pre-Factura de la orden de servicio #" + serviceOrder.getDocumentNo();
          String footer = "";

          System.out.println("Enviando email pre-factura...");
          try {
            Helper.sendEmail(emailServerConfig, subject, body, footer, attachments, addressee);
            logger.logln("Email enviado con exito. Documento Nro. " + serviceOrder.getDocumentNo());
            System.out
                .println("Email enviado con exito. Documento Nro. " + serviceOrder.getDocumentNo());
          } catch (Exception e) {
            logger.logln("Error al enviar el email. Documento Nro. " + serviceOrder.getDocumentNo()
                + ". " + e.getMessage());
            System.out.println("Error al enviar el email. Documento Nro. "
                + serviceOrder.getDocumentNo() + ". " + e.getMessage());
            throw new OBException("Error al enviar el email. Documento Nro. "
                + serviceOrder.getDocumentNo() + ". " + e.getMessage());
          }
        } else {
          logger.logln("El cliente no tiene email configurado");
          System.out.println("El cliente no tiene email configurado");
          throw new OBException("El cliente no tiene email configurado");
        }

        msg.setType("Success");
        msg.setTitle(OBMessageUtils.messageBD("@Success@"));
      }

    } catch (final Exception e) {
      log4j.error("SendPrefecture: ", e);
      Throwable ex = DbUtility.getUnderlyingSQLException(e);
      String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
      msg.setType("Error");
      msg.setTitle(OBMessageUtils.messageBD("Error"));
      msg.setMessage(message);
    } finally {
      bundle.setResult(msg);
    }
  }

}
