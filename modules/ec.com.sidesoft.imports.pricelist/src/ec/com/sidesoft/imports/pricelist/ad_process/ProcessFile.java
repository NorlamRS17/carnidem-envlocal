package ec.com.sidesoft.imports.pricelist.ad_process;

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

import ec.com.sidesoft.imports.pricelist.ad_model.*;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import ec.com.sidesoft.imports.pricelist.ImportPriceList;
import org.openbravo.model.pricing.pricelist.*;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.apache.log4j.Logger;

public class ProcessFile extends DalBaseProcess {
	private OBError message;
	private OBError messageP;
    private ConnectionProvider conn;
    private VariablesSecureApp vars;
    private String language;
    public PriceListVersion newPriceListVersion = null;
    public String listProduct;
	public String listPrices;
    public int productCount;
    public int priceCount;

	final String attachmentFolderPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
			.getProperty("attach.path");

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception, IOException {

		OBContext.setAdminMode(true);
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
			OBContext.restorePreviousMode();
			
			try {
				conn.destroy();
			} catch (Exception e) {
				
			}
			bundle.setResult(message);
		}
	}

	public void processRequest(ProcessBundle bundle) throws Exception {

		List<Temp> data;
		listProduct = "No se encontraron los productos con los siguientes codigos : ";
		listPrices = "Hay valores no numericos en los precios de los siguientes codigos : ";
		String messageT = "";
		String typeM = "";
		String titleM = "";
		productCount = 0;
		priceCount = 0;
		String recordId = (String) bundle.getParams().get("Sspimpl_Import_Price_List_ID");
		String pathFile = getLocationFileCSV(recordId);

		if (pathFile == "" || pathFile.isEmpty()) {
			typeM = "Error";
			titleM = "Error";
			messageT = "No se encontro ningún archivo de tipo <b>csv</b> en los adjuntos";
			message.setMessage(messageT);
			message.setTitle(Utility.messageBD(conn, titleM, language));
			message.setType(typeM);
		} else {
				ImportPriceList record = OBDal.getInstance().get(ImportPriceList.class, recordId);
				
				PriceListVersion priceListF = loadFileLines(pathFile, record);
				typeM = "Success";
				titleM = "ProcessOK";
				if (productCount > 0 || priceCount > 0 ) {
					typeM = "info";
					titleM = "Information";
					messageT = "La importación no se completó. Los siguientes productos dieron error: <br>";
					if(productCount > 0)
						messageT = messageT
						+ listProduct;
				
					if(priceCount > 0 )
						messageT = ((messageT != null) ? messageT + "<br>" : "")
								+ listPrices;
					
					OBDal.getInstance().rollbackAndClose();
					setMessage(typeM,Utility.messageBD(conn, titleM, language),messageT);
					return;
				} else if (productCount == 0 && priceCount == 0 
						&& record.isOverwrite() && record.getPriceListVersion() != null) {
					messageT = "La lista de precios <b>" + record.getPriceListVersion().getName()
							+ "</b> se actualizó correctamente.";
					
					record.setAlertStatus("SSPIMPL_PR");
					OBDal.getInstance().flush();
					
					setMessage(typeM,Utility.messageBD(conn, titleM, language),messageT);
				} else if (productCount == 0 && priceCount == 0 
						&& !record.isOverwrite()) {
					messageT = "La lista de precios <b>" + priceListF.getName()
							+ "</b> se creo/actualizó correctamente.";
					record.setAlertStatus("SSPIMPL_PR");
					OBDal.getInstance().flush();
					
					setMessage(typeM,Utility.messageBD(conn, titleM, language),messageT);
				} else {
					typeM = "Error";
					titleM = "Error";
					messageT = "No se puede proceder con la importación se requiere seleccionar una versión de tarifa al sobrescribir.";
					setMessage(typeM,Utility.messageBD(conn, titleM, language),messageT);
				}
			}
	}

	public String getLocationFileCSV(String recordId) throws OBException {
		OBContext.setAdminMode(true);
		OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
		final Table table = OBDal.getInstance().get(Table.class, "DBB7E9547159434682EF8953590D10A9");
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

	public PriceListVersion loadFileLines(String filename, ImportPriceList recordPL) throws Exception, IOException {
		
		PriceListVersion priceListVersion = null;
		CSVReader reader = null;
		
		if(!recordPL.isOverwrite()) {
			priceListVersion = createListPriceV(recordPL);
		} else
		{
			priceListVersion = OBDal.getInstance().get(PriceListVersion.class, recordPL.getPriceListVersion().getId());
		}
		
		boolean existProduct;
	
		boolean numericPrices;

		List<Temp> emps = new ArrayList<Temp>();
		// read line by line
		String[] record = null;
		// skip header row
		
		try {
			reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '\"', '\\',
				0, false, true);
		
			reader.readNext();

			while ((record = reader.readNext()) != null) {
				if (record.length > 1 || record[0].length() > 0) {
					existProduct = true;
					numericPrices = true;
				
					//Validar que el producto exista
					OBCriteria<Product> obc = OBDal.getInstance().createCriteria(Product.class);
					obc.add(Restrictions.eq(Product.PROPERTY_SEARCHKEY, record[0]));
					obc.setMaxResults(1);
					Product attach = (Product) obc.uniqueResult();
				
					if (attach == null) {
						//Producto no existe
						productCount++;
						existProduct = false;
						listProduct = listProduct + "<b>" + record[0] + "</b>" + " / ";
					}
					
					//Validar que los precios sean numericos 0.00
					String poe = (String) record[1];
					String pvp = (String) record[2];
					
					if (!poe.matches("-?\\d+(\\.\\d+)?") || !pvp.matches("-?\\d+(\\.\\d+)?")) {
						priceCount++;
						numericPrices = false;
						listPrices = listPrices + "<b>" + record[0] + "</b>" + " / ";
					}
						
					if(existProduct && numericPrices) {
						
						OBCriteria<ProductPrice> obcI = OBDal.getInstance().createCriteria(ProductPrice.class);
						obcI.add(Restrictions.eq(ProductPrice.PROPERTY_PRICELISTVERSION, priceListVersion));
						obcI.add(Restrictions.eq(ProductPrice.PROPERTY_PRODUCT, attach));
						obcI.setMaxResults(1);
						ProductPrice attachPl = (ProductPrice) obcI.uniqueResult();
						
						if (attachPl == null) {
							ProductPrice newProductPrice = OBProvider.getInstance().get(ProductPrice.class);
							newProductPrice.setPriceListVersion(priceListVersion);
							newProductPrice.setProduct(attach);
							newProductPrice.setStandardPrice(new BigDecimal(record[1]));
							newProductPrice.setListPrice(new BigDecimal(record[2]));
							newProductPrice.setOrganization(priceListVersion.getOrganization());
							OBDal.getInstance().save(newProductPrice);
							
						} else {
							attachPl.setStandardPrice(new BigDecimal(record[1]));
							attachPl.setListPrice(new BigDecimal(record[2]));
						}
					}
				}
			}
			
		} catch (Exception e) {
			OBDal.getInstance().rollbackAndClose();
			throw new OBException(e.getMessage());
		} finally {
			reader.close();
		}
		return priceListVersion;
	}

	public PriceListVersion createListPriceV(ImportPriceList record) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		String f_date = format.format(now);
		PriceList priceList = record.getPriceList();
		OBCriteria<PriceListVersion> obc = OBDal.getInstance().createCriteria(PriceListVersion.class);
		obc.add(Restrictions.eq(PriceListVersion.PROPERTY_NAME, priceList.getName() + " - " + f_date));
		obc.add(Restrictions.eq(PriceListVersion.PROPERTY_PRICELIST, priceList));
		obc.setMaxResults(1);
		PriceListVersion priceListVersion = (PriceListVersion) obc.uniqueResult();

		if (priceListVersion == null) {

			OBCriteria<PriceListSchema> ob = OBDal.getInstance().createCriteria(PriceListSchema.class);
			ob.add(Restrictions.eq(PriceListSchema.PROPERTY_NAME, "Estándar"));
			ob.setMaxResults(1);
			PriceListSchema priceListSchema = (PriceListSchema) ob.uniqueResult();			
			newPriceListVersion = OBProvider.getInstance().get(PriceListVersion.class);
			newPriceListVersion.setName(priceList.getName() + " - " + f_date);
			newPriceListVersion.setValidFromDate(now);
			newPriceListVersion.setPriceList(priceList);
			newPriceListVersion.setPriceListSchema(priceListSchema);
			if(record.isAllorganization()) {
				Organization all = OBDal.getInstance().get(Organization.class, "0");
				newPriceListVersion.setOrganization(all);
			}
			OBDal.getInstance().save(newPriceListVersion);
			
			return newPriceListVersion;
		}
		return priceListVersion;
	}
	
	private void setMessage(String type, String title, String msg) {
        message.setType(type);
        message.setTitle(Utility.messageBD(conn, title, language));
        message.setMessage(msg);
    }
}