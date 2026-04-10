package ec.com.sidesoft.workorder.update.price.ad_process;

import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;

import java.sql.BatchUpdateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import org.openbravo.base.secureApp.VariablesSecureApp;

import org.openbravo.client.kernel.RequestContext;
import org.openbravo.client.application.attachment.AttachImplementationManager;
import org.openbravo.client.application.attachment.AttachmentAH;
import org.openbravo.client.application.attachment.AttachmentUtils;
import org.openbravo.client.application.attachment.CoreAttachImplementation;
import org.openbravo.base.session.OBPropertiesProvider;

import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.ad.datamodel.Table;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import ec.com.sidesoft.workorder.update.price.UpdatePriceWO;
import ec.com.sidesoft.workorder.update.price.UpdatePriceLineWO;
import org.openbravo.model.pricing.pricelist.*;
import org.openbravo.model.common.plm.Product;
import org.apache.log4j.Logger;

public class ValidateLine extends DalBaseProcess {
  OBError message;
  private boolean insert = false;
  private int processed;
  private int notprocessed;
  private int rejected;
  private boolean cancelled;
  protected ConnectionProvider conn;
  protected VariablesSecureApp vars;
  protected String language;
  public UpdatePriceLineWO line = null;

  // private static Logger log4j1 = Logger.getLogger(ValidateLine.class);

  final String attachmentFolderPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
      .getProperty("attach.path");

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception, IOException {

    VariablesSecureApp vars = bundle.getContext().toVars();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    this.conn = conn;
    this.vars = vars;
    this.language = language;

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      // log4j1.info("exeption" + e);
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      bundle.setResult(message);
    }
  }

  public void processRequest(ProcessBundle bundle) throws Exception {

    List<String> data;
    String messageT = "";
    String typeM = "";
    String titleM = "";
    String recordId = (String) bundle.getParams().get("Sswoup_Update_Price_Wo_ID");

    UpdatePriceWO record = OBDal.getInstance().get(UpdatePriceWO.class, recordId);

    typeM = "Success";
    titleM = "ProcessOK";
    boolean status = validateLines(record);

    if (status != false) {
      messageT = "La lineas se cargaron correctamente sin observaciones.";
      record.setAlertStatus("SSWOUP_AP");
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    } else {
      typeM = "info";
      titleM = "Information";
      messageT = "Revisar las observaciones en las lineas para continuar con el proceso.";
      //record.setAlertStatus("SSWOUP_AP");
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    }
  }

  public boolean validateLines(UpdatePriceWO record) throws OBException {
    boolean status = true;
    OBCriteria<UpdatePriceLineWO> obc = OBDal.getInstance().createCriteria(UpdatePriceLineWO.class);
    obc.add(Restrictions.eq(UpdatePriceLineWO.PROPERTY_SSWOUPUPDATEPRICEWO, record));

    for (UpdatePriceLineWO line : obc.list()) {
      String msg_ob = "";
      OBCriteria<atindpo_postventa> wo = OBDal.getInstance()
          .createCriteria(atindpo_postventa.class);
      wo.add(Restrictions.eq(atindpo_postventa.PROPERTY_DOCUMENTNO, line.getWorkorderNo()));
      if (!(record.getOrganization().getName().equals("INDUMOT"))) {
        wo.add(Restrictions.eq(atindpo_postventa.PROPERTY_ORGANIZATION, record.getOrganization()));
      }

      if (wo.count() == 0) {
        msg_ob += "No existe la O/Servicio,";
        status = false;
      } else {
        for (atindpo_postventa row : wo.list()) {

          if (row.getCliente().getId() != record.getSSWOUP().getId()) {
            msg_ob += "La O/Servicio no pertenece al Tercero, ";
            status = false;
          }
          if (row.getDocumentStatus().equals("ET")) {
            msg_ob += "La O/Servicio se encuentra en estado Entregado, ";
            status = false;
          }
          if (row.getDocumentStatus().equals("SSWOS_F")) {
            msg_ob += "La O/Servicio se encuentra en estado Facturado, ";
            status = false;
          }
        }
      }
      line.setComments((msg_ob != "") ? msg_ob : "OK!");
      OBDal.getInstance().save(line);
    }

    return status;
  }
}
