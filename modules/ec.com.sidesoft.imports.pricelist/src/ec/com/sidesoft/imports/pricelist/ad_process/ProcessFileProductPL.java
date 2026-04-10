package ec.com.sidesoft.imports.pricelist.ad_process;

import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
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
import java.io.FileReader;

import au.com.bytecode.opencsv.CSVReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ec.com.sidesoft.imports.pricelist.ad_model.*;
import ec.com.sidesoft.imports.pricelist.ImportProductPl;
import org.openbravo.model.pricing.pricelist.*;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;

public class ProcessFileProductPL extends DalBaseProcess {
  OBError message;
  private boolean insert = false;
  private int processed;
  private int notprocessed;
  private int rejected;
  private String formatdate = "dd/MM/yyyy";
  private boolean cancelled;
  protected ConnectionProvider conn;
  protected VariablesSecureApp vars;
  protected String language;
  public PriceListVersion newPriceListVersion = null;

  private static Logger log4j1 = LogManager.getLogger(ProcessFileProductPL.class);

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
      log4j1.info("exeption" + e);
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      OBContext.restorePreviousMode();
      bundle.setResult(message);
    }
  }

  public void processRequest(ProcessBundle bundle) throws Exception {

    List<TempProductPL> data;
    String messageT = "";
    String typeM = "";
    String titleM = "";
    String recordId = (String) bundle.getParams().get("Sspimpl_Import_Product_Pl_ID");
    String pathFile = getLocationFileCSV(recordId);

    if (pathFile == "") {
      typeM = "Error";
      titleM = "Error";
      messageT = "No se encontro ningún archivo de tipo <b>csv</b> en los adjuntos";
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    } else {
      ImportProductPl record = OBDal.getInstance().get(ImportProductPl.class, recordId);
      String validation = validateDataFileLines(record.isOverwrite(), pathFile);

      if (!validation.isEmpty()) {
        typeM = "info";
        titleM = "Information";
        messageT = validation;

        message.setMessage(messageT);
        message.setTitle(Utility.messageBD(conn, titleM, language));
        message.setType(typeM);

      } else {
        data = loadFileLines(pathFile);
        typeM = "Success";
        titleM = "ProcessOK";
        messageT = "La listas de precios se actualizaron correctamente.";
        updateListPriceV(record.isOverwrite(), data);
        record.setAlertStatus("SSPIMPL_PR");
        message.setMessage(messageT);
        message.setTitle(Utility.messageBD(conn, titleM, language));
        message.setType(typeM);
      }
    }
  }

  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "43BEBCB674FB4EACB45ECD1D64925937");
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

  public List<TempProductPL> loadFileLines(String filename) throws Exception, IOException {

    CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"),
        ',', '\"', '\\', 0, false, true);

    List<TempProductPL> emps = new ArrayList<TempProductPL>();
    // read line by line
    String[] record = null;
    // skip header row
    reader.readNext();

    while ((record = reader.readNext()) != null) {
      if (record.length > 1 || record[0].length() > 0) {
        TempProductPL emp = new TempProductPL();
        Date datepl = new SimpleDateFormat(formatdate).parse(record[1]);

        // OBTENEMOS LA VERSION DE LA TAFIFA
        OBCriteria<PriceListVersion> obcpl = OBDal.getInstance()
            .createCriteria(PriceListVersion.class);
        obcpl.add(Restrictions.eq(PriceListVersion.PROPERTY_NAME, record[0]));
        obcpl.add(Restrictions.eq(PriceListVersion.PROPERTY_VALIDFROMDATE, datepl));
        obcpl.setMaxResults(1);
        PriceListVersion attachpl = (PriceListVersion) obcpl.uniqueResult();

        // IBTENEMOS EL PRODUCTO
        OBCriteria<Product> obc = OBDal.getInstance().createCriteria(Product.class);
        obc.add(Restrictions.eq(Product.PROPERTY_SEARCHKEY, record[2]));
        obc.setMaxResults(1);
        Product attach = (Product) obc.uniqueResult();

        if (attach != null && attachpl != null) {
          emp.setPriceListVersion(attachpl);
          emp.setProducto(attach);
          emp.setPrecioPOE(new BigDecimal(record[3]));
          emp.setPrecioPVP(new BigDecimal(record[4]));
          emps.add(emp);
        }
      }
    }
    reader.close();
    return emps;
  }

  public String validateDataFileLines(boolean overwrite, String filename)
      throws Exception, IOException {

    String p = "";
    int line = 2;
    try {
      CSVReader reader = new CSVReader(
          new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '\"', '\\', 0, false,
          true);

      List<String> validationDt = new ArrayList<String>();
      // read line by line
      String[] record = null;
      StringBuffer buffer = new StringBuffer(); // default size 16
      // skip header row
      reader.readNext();
      while ((record = reader.readNext()) != null) {
        if (record.length > 1 || record[0].length() > 0) {
          String val = "";
          String val_pl = (String) record[0];
          String val_date = (String) record[1];
          String val_p = (String) record[2];
          String val_poe = (String) record[3];
          String val_pvp = (String) record[4];

          if (isValidDate(val_date)) {
            // VALIDACION VERSION EXISTENTE EXISTENTE
            Date datepl = new SimpleDateFormat(formatdate).parse(val_date);
            // OBTENEMOS LA VERSION DE LA TAFIFA
            OBCriteria<PriceListVersion> obcpl = OBDal.getInstance()
                .createCriteria(PriceListVersion.class);
            obcpl.add(Restrictions.eq(PriceListVersion.PROPERTY_NAME, val_pl));
            obcpl.add(Restrictions.eq(PriceListVersion.PROPERTY_VALIDFROMDATE, datepl));
            obcpl.setMaxResults(1);
            if (obcpl.count() < 1) {
              val = val.concat("La version de tarifa <b>" + val_pl + "</b>, Valido desde: <b>"
                  + val_date + "</b> no existe, ");
            }

            // VALIDACION PRODUCTO EXISTENTE
            OBCriteria<Product> obc = OBDal.getInstance().createCriteria(Product.class);
            obc.add(Restrictions.eq(Product.PROPERTY_SEARCHKEY, val_p));
            obc.setMaxResults(1);

            if (obc.count() < 1) {
              val = val.concat("El producto <b>" + val_p + "</b> no existe, ");
            }
            PriceListVersion plv = (PriceListVersion) obcpl.uniqueResult();
            Product pdt = (Product) obc.uniqueResult();
            // VALIDACION PRODUCTO EXISTENTE EN EL TARIFA
            if (overwrite == false && plv != null && pdt != null) {
              OBCriteria<ProductPrice> obcpp = OBDal.getInstance()
                  .createCriteria(ProductPrice.class);
              obcpp.add(Restrictions.eq(ProductPrice.PROPERTY_PRICELISTVERSION, plv));
              obcpp.add(Restrictions.eq(ProductPrice.PROPERTY_PRODUCT, pdt));
              obcpp.setMaxResults(1);
              ProductPrice attach = (ProductPrice) obcpp.uniqueResult();
              if (attach != null) {
                val = val.concat("El producto <b>" + val_p
                    + "</b> ya tiene asignada una lista de precios en <b>" + val_pl + "</b>.");
              }
            }

          } else {
            val = val.concat("La fecha no tiene el formato valido <b>dd/mm/yyyy</b>, ");
          }

          // VALIDACION COLUMNAS DE PRECIOS
          if (!isValidNumeber(val_poe) || !isValidNumeber(val_pvp)) {
            val = val.concat("Hay valores no numéricos en las columnas de precios");
          }
          if (!val.isEmpty()) {
            validationDt.add("<b>Fila " + line + "</b>: " + val);
          }
        }
        line = line + 1;
      }
      reader.close();

      if (validationDt.size() > 0) {
        for (String text : validationDt) {
          buffer.append(text + "<br>");
        }
        return buffer.toString();
      }
      return p;

    } catch (Exception e) {
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
      return p;
    }
  }

  public void updateListPriceV(boolean overwrite, List<TempProductPL> data) throws Exception {

    OBContext.setAdminMode(true);

    for (TempProductPL temp : data) {
      Product product = OBDal.getInstance().get(Product.class, temp.getProducto().getId());
      PriceListVersion plVersion = OBDal.getInstance().get(PriceListVersion.class,
          temp.getPriceListVersion().getId());

      OBCriteria<ProductPrice> obc = OBDal.getInstance().createCriteria(ProductPrice.class);
      obc.add(Restrictions.eq(ProductPrice.PROPERTY_PRICELISTVERSION, plVersion));
      obc.add(Restrictions.eq(ProductPrice.PROPERTY_PRODUCT, product));
      obc.setMaxResults(1);
      ProductPrice attach = (ProductPrice) obc.uniqueResult();

      if (attach != null && overwrite) {
        attach.setStandardPrice(temp.getPrecioPOE());
        attach.setListPrice(temp.getPrecioPVP());
      } else {
        ProductPrice newProductPrice = OBProvider.getInstance().get(ProductPrice.class);
        newProductPrice.setPriceListVersion(plVersion);
        newProductPrice.setProduct(product);
        newProductPrice.setStandardPrice(temp.getPrecioPOE());
        newProductPrice.setListPrice(temp.getPrecioPVP());
        newProductPrice.setOrganization(plVersion.getOrganization());
        OBDal.getInstance().save(newProductPrice);
        OBDal.getInstance().flush();
      }
      plVersion.setUpdated(new Date());
      plVersion.setUpdatedBy(OBContext.getOBContext().getUser());
      plVersion.getPriceList().setUpdated(new Date());
      plVersion.getPriceList().setUpdatedBy(OBContext.getOBContext().getUser());
    }
    OBContext.restorePreviousMode();
  }

  public boolean isValidDate(String dateStr) {
    DateFormat sdf = new SimpleDateFormat(formatdate);
    sdf.setLenient(false);
    try {
      sdf.parse(dateStr);
    } catch (ParseException e) {
      return false;
    }
    return true;
  }

  public boolean isValidNumeber(String numberStr) {
    return numberStr.matches("-?\\d+(\\.\\d+)?");
  }
}
