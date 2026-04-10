package ec.com.sidesoft.workorder.simplified.ad_process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.pricing.pricelist.PriceListVersion;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import au.com.bytecode.opencsv.CSVReader;
import ec.com.sidesoft.workorder.simplified.SswosChangeStatusSO;
import ec.com.sidesoft.workorder.simplified.SswosChangeStatusSOLine;

public class ProcessFile extends DalBaseProcess {
  OBError message;
  private boolean insert = false;
  private int processed;
  private int notprocessed;
  private int rejected;
  private boolean cancelled;
  protected ConnectionProvider conn;
  protected VariablesSecureApp vars;
  protected String language;
  public PriceListVersion newPriceListVersion = null;

  // private static Logger log4j1 = Logger.getLogger(ProcessFile.class);

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

    String messageT = "";
    String typeM = "";
    String titleM = "";
    String recordId = (String) bundle.getParams().get("Sswos_Change_Status_So_ID");
    String pathFile = getLocationFileCSV(recordId);

    if (pathFile == "") {
      typeM = "Error";
      titleM = "Error";
      messageT = "No se encontro ningún archivo de tipo <b>csv</b> en los adjuntos";
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    } else {

      SswosChangeStatusSO record = OBDal.getInstance().get(SswosChangeStatusSO.class, recordId);
      String validationP = "";
      String data = loadFileLines(pathFile, record);
      typeM = "Success";
      titleM = "ProcessOK";

    }
  }

  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "BA5A58694F56473C9C54061E72B1183B");
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

  public String loadFileLines(String filename, SswosChangeStatusSO header)
      throws Exception, IOException {

    CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"),
        ',', '\"', '\\', 0, false, true);

    // read line by line
    String[] record = null;
    // skip header row
    reader.readNext();
    String result = "0";
    Integer count = 0;
    OBCriteria<SswosChangeStatusSOLine> obch = OBDal.getInstance()
        .createCriteria(SswosChangeStatusSOLine.class);
    obch.add(Restrictions.eq(SswosChangeStatusSOLine.PROPERTY_SSWOSCHANGESTATUSSO, header));
    Long lngLine = (long) obch.list().size();
    lngLine = (lngLine * 10) + 10;
    while ((record = reader.readNext()) != null) {
      if (record.length > 1 || record[0].length() > 0) {
        OBCriteria<SswosChangeStatusSOLine> obc = OBDal.getInstance()
            .createCriteria(SswosChangeStatusSOLine.class);
        obc.add(Restrictions.eq(SswosChangeStatusSOLine.PROPERTY_SSWOSCHANGESTATUSSO, header));
        obc.add(Restrictions.eq(SswosChangeStatusSOLine.PROPERTY_ORDERNO, record[0]));

        if (obc == null | obc.list().size() == 0) {
          SswosChangeStatusSOLine ObjsChangeStatusSOLine = OBProvider.getInstance()
              .get(SswosChangeStatusSOLine.class);
          ObjsChangeStatusSOLine.setOrganization(header.getOrganization());
          ObjsChangeStatusSOLine.setOrderNo(record[0]);
          ObjsChangeStatusSOLine.setSswosChangeStatusSo(header);
          ObjsChangeStatusSOLine.setLineNo(lngLine);
          OBDal.getInstance().save(ObjsChangeStatusSOLine);
          OBDal.getInstance().flush();
          count += 1;
          lngLine += 10;
        }
      }
    }
    result = count.toString();
    return result;
  }
}
