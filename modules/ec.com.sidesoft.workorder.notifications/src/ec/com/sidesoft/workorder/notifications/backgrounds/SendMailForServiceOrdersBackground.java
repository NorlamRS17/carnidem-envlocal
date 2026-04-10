package ec.com.sidesoft.workorder.notifications.backgrounds;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.businessUtility.TabAttachments;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;

import com.atrums.indumoto.postventa.data.atindpo_postventa;

import ec.com.sidesoft.workorder.notifications.SSWONConfig;
import ec.com.sidesoft.workorder.notifications.SSWONStatusReport;
import ec.com.sidesoft.workorder.notifications.utils.Helper;

public class SendMailForServiceOrdersBackground extends DalBaseProcess implements KillableProcess {

  private static final Logger log4j = Logger.getLogger(SendMailForServiceOrdersBackground.class);
  private static ProcessLogger logger;
  private boolean killProcess = false;
  private EmailServerConfiguration emailServerConfig = null;
  private SSWONConfig emailConfig = null;
  private final String tableId = "EADABF583490439FAEAA2E1050AE3A1B";
  private String sourcePath;
  private String attachPath;
  private String contextName;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    try {
      OBContext.setAdminMode(true);
      logger = bundle.getLogger();
      sourcePath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("source.path");
      attachPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("attach.path");
      contextName = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("context.name");

      // Consultamos si existe configuracion para enviar correos
      emailServerConfig = Helper.getEmailServerConfig();
      if (emailServerConfig == null) {
        throw new OBException("No existe configuracion del servidor para envio de email");
      }

      // Consultamos si existe configuracion del correo
      emailConfig = Helper.getEmailConfig();
      if (emailConfig == null) {
        throw new OBException("No existe configuracion para el email");
      }

      String dateFrom = new SimpleDateFormat("yyyy-MM-dd").format(emailConfig.getDateFrom());

      // Consultamos si existen ordenes de servicio por enviar correos
      List<atindpo_postventa> serviceOrdes = Helper.getServiceOrders(dateFrom);
      for (int i = 0; i < serviceOrdes.size(); i++) {
        if (killProcess) {
          throw new OBException("Process killed");
        }

        atindpo_postventa serviceOrder = serviceOrdes.get(i);
        String addressee = serviceOrder.getEmail().replace(" ", "");

        // Consultamos los reportes que se deben enviar en el estado de la orden de servicio
        List<SSWONStatusReport> statusReport = Helper.getStatusReport(emailConfig,
            serviceOrder.getDocumentStatus());
        // Si existen reportes configurados los adjuntamos
        List<File> attachments = new ArrayList<File>();
        File file;
        for (int j = 0; j < statusReport.size(); j++) {
          String filePath = TabAttachments.getAttachmentDirectoryForNewAttachments(tableId,
              serviceOrder.getId());
          file = Helper.createReport(serviceOrder.getId(), sourcePath, attachPath, filePath,
              statusReport.get(j));
          if (file != null)
            attachments.add(file);
        }

        // Preparamos el correo
        String subject = emailConfig.getSubject().trim();
        String body = emailConfig.getBody().trim();
        body = body.replace("[cliente]",
            serviceOrder.getCliente().getName() == null ? "" : serviceOrder.getCliente().getName());
        body = body.replace("[placa]",
            serviceOrder.getPlaca() == null ? "" : serviceOrder.getPlaca());
        body = body.replace("[modelo]",
            serviceOrder.getModelo() == null ? "" : serviceOrder.getModelo());
        body = body.replace("[documento]",
            serviceOrder.getDocumentNo() == null ? "" : serviceOrder.getDocumentNo());
        String footer = emailConfig.getFooter().trim();

        System.out.println("Enviando email orden de servicio...");
        try {
          Helper.sendEmail(emailServerConfig, subject, body, footer, attachments, addressee);
          logger.logln("Email enviado con exito. Documento Nro. " + serviceOrder.getDocumentNo());
          System.out
              .println("Email enviado con exito. Documento Nro. " + serviceOrder.getDocumentNo());

          // Actualizamos la bitacora
          Helper.updateBinnacle(serviceOrder);
        } catch (Exception e) {
          logger.logln("Error al enviar el email. Documento Nro. " + serviceOrder.getDocumentNo()
              + ". " + e.getMessage());
          System.out.println("Error al enviar el email. Documento Nro. "
              + serviceOrder.getDocumentNo() + ". " + e.getMessage());
        }
      }

      // Consultamos si existen facturas de ordenes de servicio por enviar correos
      List<Invoice> invoices = Helper.getInvoices(dateFrom);

      for (int i = 0; i < invoices.size(); i++) {
        if (killProcess) {
          throw new OBException("Process killed");
        }

        Invoice invoice = invoices.get(i);
        String addressee = invoice.getBusinessPartner().getEEIEmail().replace(" ", "");

        // Preparamos el correo
        String subject = emailConfig.getSubject1().trim();
        String body = emailConfig.getBody1().trim();
        body = body.replace("[cliente]", invoice.getBusinessPartner().getName() == null ? ""
            : invoice.getBusinessPartner().getName());
        body = body.replace("[documento]",
            invoice.getDocumentNo() == null ? "" : invoice.getDocumentNo());
        String footer = emailConfig.getFooter1().trim();

        List<File> attachments = new ArrayList<File>();

        System.out.println("Enviando email factura de orden de servicio...");
        try {
          Helper.sendEmail(emailServerConfig, subject, body, footer, attachments, addressee);

          logger.logln("Email enviado con exito. NroDocumento " + invoice.getDocumentNo());
          System.out.println("Email enviado con exito. NroDocumento " + invoice.getDocumentNo());

          invoice.setSswonSentEmail(true);
          OBDal.getInstance().save(invoice);
          OBDal.getInstance().flush();
        } catch (Exception e) {
          logger.logln("Error al enviar el email. NroDocumento " + invoice.getDocumentNo() + ". "
              + e.getMessage());
          System.out.println("Error al enviar el email. NroDocumento " + invoice.getDocumentNo()
              + ". " + e.getMessage());
        }
      }
      // OBDal.getInstance().commitAndClose();
    } catch (Exception e) {
      // OBDal.getInstance().rollbackAndClose();
      logger.logln("SendMailForServiceOrdersBackground: " + e.getMessage());
      System.out.println("SendMailForServiceOrdersBackground: " + e.getMessage());
    } finally {
      OBContext.setAdminMode(false);
    }
  }

  @Override
  public void kill(ProcessBundle processBundle) throws Exception {
    System.out.println("kill");
    OBDal.getInstance().flush();
    this.killProcess = true;
  }

}
