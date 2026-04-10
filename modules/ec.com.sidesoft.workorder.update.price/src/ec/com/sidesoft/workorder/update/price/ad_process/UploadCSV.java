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

public class UploadCSV extends DalBaseProcess {
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

  // private static Logger log4j1 = Logger.getLogger(UploadCSV.class);

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
    String pathFile = getLocationFileCSV(recordId);

    if (pathFile == "") {
      typeM = "Error";
      titleM = "Error";
      messageT = "No se encontro ningún archivo de tipo <b>csv</b> en los adjuntos.";
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    } else {
      UpdatePriceWO record = OBDal.getInstance().get(UpdatePriceWO.class, recordId);

      data = loadFileLines(pathFile);
      typeM = "Success";
      titleM = "ProcessOK";
      createLine(record, data);

      messageT = "La lineas se cargaron correctamente.";
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);

    }
  }

  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "838EB518D05644CC83F9E96FE324FB7E");
    obc.add(Restrictions.eq(Attachment.PROPERTY_RECORD, recordId));
    obc.add(Restrictions.eq(Attachment.PROPERTY_TABLE, table));
    obc.add(Restrictions.eq(Attachment.PROPERTY_DATATYPE, "text/csv"));
    obc.addOrderBy(Attachment.PROPERTY_SEQUENCENUMBER, false);
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    Attachment attach = (Attachment) obc.uniqueResult();
    if (attach == null) {
      return "";
    }
    return attachmentFolderPath + "/" + attach.getPath() + '/' + attach.getName();
  }

  public List<String> loadFileLines(String filename) throws Exception, IOException {

    CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"),
        ',', '\"', '\\', 0, false, true);

    List<String> emps = new ArrayList<String>();
    // read line by line
    String[] record = null;
    // skip header row
    reader.readNext();

    while ((record = reader.readNext()) != null) {
      if (record.length > 1 || record[0].length() > 0) {
        emps.add((String) record[0]);
      }
    }
    reader.close();
    return emps;
  }

  public Long getSequenceNumber(UpdatePriceWO record) throws OBException {
    OBCriteria<UpdatePriceLineWO> obc = OBDal.getInstance().createCriteria(UpdatePriceLineWO.class);
    obc.add(Restrictions.eq(UpdatePriceLineWO.PROPERTY_SSWOUPUPDATEPRICEWO, record));
    obc.addOrderBy(UpdatePriceLineWO.PROPERTY_LINENO, false);
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    UpdatePriceLineWO attach = (UpdatePriceLineWO) obc.uniqueResult();
    if (attach == null) {
      return 10L;
    }
    return attach.getLineNo() + 10L;
  }

  public void createLine(UpdatePriceWO record, List<String> data) throws OBException {
    String msg_ob = "";
    for (String documentNo : data) {

      OBCriteria<UpdatePriceLineWO> obc = OBDal.getInstance()
          .createCriteria(UpdatePriceLineWO.class);
      obc.add(Restrictions.eq(UpdatePriceLineWO.PROPERTY_SSWOUPUPDATEPRICEWO, record));
      obc.add(Restrictions.eq(UpdatePriceLineWO.PROPERTY_WORKORDERNO, documentNo.trim()));
      obc.addOrderBy(UpdatePriceLineWO.PROPERTY_LINENO, false);
      obc.setFilterOnReadableOrganization(false);
      obc.setMaxResults(1);
      UpdatePriceLineWO attach = (UpdatePriceLineWO) obc.uniqueResult();
      if (attach == null) {
        line = OBProvider.getInstance().get(UpdatePriceLineWO.class);
        line.setLineNo(getSequenceNumber(record));
        line.setSswoupUpdatePriceWo(record);
        line.setWorkorderNo(documentNo.trim());
        OBDal.getInstance().save(line);
        OBDal.getInstance().flush();
      }
    }
  }

}
