package ec.com.sidesoft.workorder.simplified.ad_process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

import com.atrums.indumot.supervision.data.indsupConsol;
import com.atrums.indumot.supervision.data.oindsuprg;
import com.atrums.indumoto.postventa.data.atindpo_postventa;

import au.com.bytecode.opencsv.CSVReader;

public class ProcessFileConsolidation extends DalBaseProcess {
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

  // private static Logger log4j1 = Logger.getLogger(ProcessFileConsolidation.class);

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
    String recordId = (String) bundle.getParams().get("Atindpo_Postventa_ID");
    String pathFile = getLocationFileCSV(recordId);

    if (pathFile == "") {
      typeM = "Error";
      titleM = "Error";
      messageT = "No se encontro ningún archivo de tipo <b>csv</b> en los adjuntos";
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    } else {

      atindpo_postventa record = OBDal.getInstance().get(atindpo_postventa.class, recordId);
      String validationP = "";
      String data = loadFileLines(pathFile, record);
      typeM = "Success";
      titleM = "ProcessOK";

    }
  }

  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "EADABF583490439FAEAA2E1050AE3A1B");
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

  public String loadFileLines(String filename, atindpo_postventa header)
      throws Exception, IOException {

    CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"),
        ',', '\"', '\\', 0, false, true);

    // read line by line
    String[] record = null;
    // skip header row
    reader.readNext();
    String result = "0";
    Integer count = 0;
    oindsuprg Objoindsuprg = null;
    while ((record = reader.readNext()) != null) {
      if (record.length > 1 || record[0].length() > 0) {
        OBCriteria<indsupConsol> obc = OBDal.getInstance().createCriteria(indsupConsol.class);
        obc.add(Restrictions.eq(indsupConsol.PROPERTY_ATINDPOPOSTVENTA, header));
        obc.add(Restrictions.eq(indsupConsol.PROPERTY_ORDEN, record[0]));

        OBCriteria<oindsuprg> obcOrganization = OBDal.getInstance().createCriteria(oindsuprg.class);
        obcOrganization
            .add(Restrictions.eq(oindsuprg.PROPERTY_ORGANIZATION, header.getOrganization()));

        if (obcOrganization == null || obcOrganization.list().size() == 0) {
          throw new OBException(
              "No existe en la ventana 'Organizacion Ordenes de servicio' un registro con Lo organización: "
                  + header.getOrganization().getName());
        }
        
        // New Validation Order Duplicate
        OBCriteria<indsupConsol> obcConsol = OBDal.getInstance().createCriteria(indsupConsol.class);
        obcConsol.add(Restrictions.eq(indsupConsol.PROPERTY_ATINDPOPOSTVENTA, header));
        obcConsol.add(Restrictions.eq(indsupConsol.PROPERTY_ORDEN, record[0]));
        
        int intCount = obcConsol.list().size();
        if ( intCount>0) {
            throw new OBException(
                "Error. La orden " + record[0].toString() + " se encuentra duplicada en el archivo adjunto."
                 );
          }
        

        if (obc == null | obc.list().size() == 0) {
          indsupConsol ObjsindsupConsol = OBProvider.getInstance().get(indsupConsol.class);
          ObjsindsupConsol.setOrganization(header.getOrganization());
          ObjsindsupConsol.setOrganizacion(obcOrganization.list().get(0));
          ObjsindsupConsol.setOrden(record[0]);
          ObjsindsupConsol.setAtindpoPostventa(header);
          OBDal.getInstance().save(ObjsindsupConsol);
          OBDal.getInstance().flush();
          count += 1;
        }
      }
    }
    result = count.toString();
    return result;
  }
}
