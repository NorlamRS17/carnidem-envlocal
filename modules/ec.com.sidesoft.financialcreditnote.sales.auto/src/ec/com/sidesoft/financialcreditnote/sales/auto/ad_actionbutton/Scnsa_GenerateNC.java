package ec.com.sidesoft.financialcreditnote.sales.auto.ad_actionbutton;

import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.dal.core.OBContext;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.ad.utility.Sequence;
import java.util.Date;

import org.openbravo.erpCommon.utility.Utility;

public class Scnsa_GenerateNC extends DalBaseProcess {

	private final Logger logger = Logger.getLogger(Scnsa_GenerateNC.class);

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		OBContext.setAdminMode(true);

		OBError msg = new OBError();
		ConnectionProvider conn = bundle.getConnection();
		VariablesSecureApp vars = bundle.getContext().toVars();
		String successMessage = null;

		String strDocumetnNoSec = "";
		String strDescriptionConcatNC = "";

		String strInvoiceId = (String) bundle.getParams().get("C_Invoice_ID");

		// Pre Punto de Extencion 
		PreGenerateNCExtensionsPoint(strInvoiceId);
		
		try {
			String strDescriptionConcat = "";
			Date currentDate = new Date();

//			Recuperar la Configuración del Tipo de documento de la Factura Original
			Invoice sourceInvoice = OBDal.getInstance().get(Invoice.class, strInvoiceId);
			String strDocTypeTargetID = sourceInvoice.getTransactionDocument().getId().toString();
			String strDocumetnNoOriginalInvoice = sourceInvoice.getDocumentNo().toString();

			DocumentType sourceDocTypeID = OBDal.getInstance().get(DocumentType.class, strDocTypeTargetID);
			String strCategoryName = sourceDocTypeID.getGLCategory().getName().toString();
			String strDocBaseType = sourceDocTypeID.getDocumentCategory().toString();
			if (!"AR Invoice".equals(strCategoryName) || !"ARI".equals(strDocBaseType)) {
				throw new OBException("@scnsa_notconfiginit_generate_nc@");
			}

			OBCriteria<InvoiceLine> ObjInvLineList = OBDal.getInstance().createCriteria(InvoiceLine.class);
			ObjInvLineList.add(Restrictions.eq(InvoiceLine.PROPERTY_INVOICE, sourceInvoice));

			if (ObjInvLineList.count() > 0) {
				for (InvoiceLine invLine : ObjInvLineList.list()) {
					Product product = invLine.getProduct();
					boolean stock = product.isStocked();
					if (stock) {
						throw new OBException("@scnsa_nc_generation_product@");
					}
				}
			}

//			Recuperamos los datos con los que se quiere generar 
//			La nota de credito con la información de la factura original
			boolean isautomatic = sourceDocTypeID.isScnsaAutomaticGenerateNc();

			if (!isautomatic) {
				throw new OBException("@scnsa_notconfig_generation_nc@");
			}

			String strDocNCAutomaticID = sourceDocTypeID.getScnsaDocNcAutomatic().getId().toString();
			String NCDescription = sourceDocTypeID.getScnsaDescription() != null ? sourceDocTypeID.getScnsaDescription()
					: "";

//			Tipo de Documento con los que se quiere generar la nota de credito
			DocumentType sourceDocTypeNCAutomaticID = OBDal.getInstance().get(DocumentType.class, strDocNCAutomaticID);
			String nameDocTypeNCAutomatic = sourceDocTypeNCAutomaticID.getName().toString();
//			Recuperar la secuencial del tipo de documento configurado
			Sequence sequence = sourceDocTypeNCAutomaticID.getDocumentSequence();

			OBCriteria<Invoice> ObjInvoiceList = OBDal.getInstance().createCriteria(Invoice.class);
			ObjInvoiceList.add(Restrictions.eq(Invoice.PROPERTY_SCNRINVOICE, sourceInvoice));
			if (ObjInvoiceList.count() > 0) {
				for (Invoice inv : ObjInvoiceList.list()) {
					String creditnoteNum = inv.getDocumentNo().toString();
					throw new OBException(Utility
							.messageBD(new DalConnectionProvider(), "scnsa_nc_relation_invoice",
									OBContext.getOBContext().getLanguage().getLanguage())
							.replaceAll("%1", creditnoteNum));
				}
			}

			if (sequence != null) {
				String prefix = sequence.getPrefix() != null ? sequence.getPrefix() : "";
				String nextNumber = sequence.getNextAssignedNumber() != null
						? sequence.getNextAssignedNumber().toString()
						: "";
				String suffix = sequence.getSuffix() != null ? sequence.getSuffix() : "";

				strDocumetnNoSec = prefix + nextNumber + suffix;
				sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
				OBDal.getInstance().save(sequence);
				OBDal.getInstance().flush();
			}

			strDescriptionConcat = NCDescription + " " + strDocumetnNoOriginalInvoice;
			strDescriptionConcatNC = NCDescription + " " + strDocumetnNoSec;


			OBError messageInvoice = createInvoice(vars, sourceInvoice, sourceDocTypeNCAutomaticID, strDocumetnNoSec,
					strDescriptionConcat, currentDate, conn);

			sourceInvoice.setScnsaGeneratenc("DS");
			sourceInvoice.setDescription(strDescriptionConcatNC);
			OBDal.getInstance().save(sourceInvoice);
			OBDal.getInstance().flush();

			successMessage = OBMessageUtils.messageBD(Utility
					.messageBD(new DalConnectionProvider(), "scnsa_success_generation_nc",
							OBContext.getOBContext().getLanguage().getLanguage())
					.replaceAll("%1", NCDescription).replaceAll("%2", nameDocTypeNCAutomatic)
					.replaceAll("%3", strDocumetnNoSec));

			msg.setType("Success");
			msg.setTitle(OBMessageUtils.messageBD("Success"));
			msg.setMessage(successMessage);

		} catch (final Exception e) {
			OBDal.getInstance().rollbackAndClose();
			logger.error("Exception found in Scnsa_GenerateNC: ", e);
			Throwable throwable = DbUtility.getUnderlyingSQLException(e);
			String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setType("Error");
			msg.setMessage(message);

			Invoice invoice = OBDal.getInstance().get(Invoice.class, strInvoiceId);
			OBDal.getInstance().save(invoice);
			OBDal.getInstance().flush();
			OBDal.getInstance().commitAndClose();
		} finally {
			OBContext.setAdminMode(false);
			bundle.setResult(msg);
		}
		
		// Pos Punto de Extencion 
		PosGenerateNCExtensionsPoint(strInvoiceId);

	}

	private String PosGenerateNCExtensionsPoint(String strInvoiceId) {
		// TODO Auto-generated method stub
		org.openbravo.model.ad.ui.Process proccess = OBDal.getInstance().get(org.openbravo.model.ad.ui.Process.class,"56B55FEF8D014E599499C46E92620EA0");
		ProcessInstance pInstance = CallProcess.getInstance().call(proccess, strInvoiceId, null);
		OBError error = OBMessageUtils.getProcessInstanceMessage(pInstance);
		String msg = error.getMessage();
		
		if(pInstance.getResult() == 0) {
			throw new OBException(msg);
		}
		return msg; 
	}

	private String PreGenerateNCExtensionsPoint(String strInvoiceId) {
		// TODO Auto-generated method stub
		org.openbravo.model.ad.ui.Process proccess = OBDal.getInstance().get(org.openbravo.model.ad.ui.Process.class,"DA24D1ADE0B84618A630FC12002E7495");
		ProcessInstance pInstance = CallProcess.getInstance().call(proccess, strInvoiceId, null);
		OBError error = OBMessageUtils.getProcessInstanceMessage(pInstance);
		String msg = error.getMessage();
		
		if(pInstance.getResult() == 0) {
			throw new OBException(msg);
		}
		return msg;
	}

	private OBError createInvoice(VariablesSecureApp vars, Invoice sourceInvoice,
			DocumentType sourceDocTypeNCAutomaticID, String strDocumetnNoSec, String strDescriptionConcat,
			Date currentDate, ConnectionProvider conn) throws SQLException {
		// TODO Auto-generated method stub
		OBError myError = new OBError();
		try {
			// Crear la nota de credito en base a la informacion de la factura original
			Invoice newcreditnote = OBProvider.getInstance().get(Invoice.class);

			newcreditnote.setOrganization(sourceInvoice.getOrganization());
			newcreditnote.setSalesTransaction(true);
			newcreditnote.setOrganization(sourceInvoice.getOrganization());
			newcreditnote.setClient(sourceInvoice.getClient());
			newcreditnote.setProcessed(false);
			newcreditnote.setProcessNow(false);
			newcreditnote.setDocumentStatus("DR");
			newcreditnote.setDocumentAction("CO");
			newcreditnote.setDocumentType(sourceDocTypeNCAutomaticID);
			newcreditnote.setTransactionDocument(sourceDocTypeNCAutomaticID);
			newcreditnote.setBusinessPartner(sourceInvoice.getBusinessPartner());
			newcreditnote.setPartnerAddress(sourceInvoice.getPartnerAddress());
			newcreditnote.setCurrency(sourceInvoice.getCurrency());
			newcreditnote.setPaymentTerms(sourceInvoice.getPaymentTerms());
			newcreditnote.setPriceList(sourceInvoice.getPriceList());
			newcreditnote.setDescription(strDescriptionConcat);
			newcreditnote.setInvoiceDate(currentDate);
			newcreditnote.setAccountingDate(currentDate);
			newcreditnote.setSswhDateendinvoice(currentDate);
			newcreditnote.setDocumentNo(strDocumetnNoSec);
			newcreditnote.setPaymentMethod(sourceInvoice.getPaymentMethod());
			newcreditnote.setCostcenter(sourceInvoice.getCostcenter());
			newcreditnote.setSpincoTaxid(sourceInvoice.getSpincoTaxid());

			newcreditnote.setScnrIsrefInv(true);
			newcreditnote.setScnrInvoice(sourceInvoice);

			OBDal.getInstance().save(newcreditnote);
			OBDal.getInstance().flush();

			// Copiar líneas de la factura original
			for (InvoiceLine originalLine : sourceInvoice.getInvoiceLineList()) {
				InvoiceLine newLine = OBProvider.getInstance().get(InvoiceLine.class);

				newLine.setInvoice(newcreditnote);
				newLine.setClient(originalLine.getClient());
				newLine.setOrganization(originalLine.getOrganization());
				newLine.setLineNo(originalLine.getLineNo());
				newLine.setProduct(originalLine.getProduct());
				newLine.setSprliIdentifier(originalLine.getSprliIdentifier());
				newLine.setUOM(originalLine.getUOM());
				newLine.setInvoicedQuantity(originalLine.getInvoicedQuantity());
				newLine.setUnitPrice(originalLine.getUnitPrice());
				newLine.setStandardPrice(originalLine.getStandardPrice());
				newLine.setLineNetAmount(originalLine.getLineNetAmount());
				newLine.setListPrice(originalLine.getListPrice());
				newLine.setTaxAmount(originalLine.getTaxAmount());
				newLine.setTax(originalLine.getTax());
				newLine.setSsbodDiscountRate(originalLine.getSsbodDiscountRate());
				newLine.setSseedDiscount(originalLine.getSseedDiscount());
				newLine.setCostcenter(originalLine.getCostcenter());
				newLine.setStDimension(originalLine.getStDimension());
				OBDal.getInstance().save((Object) newLine);
				OBDal.getInstance().save(newLine);
				OBDal.getInstance().flush();
			}

			myError.setType("Success");
			myError.setTitle("Success");
			myError.setMessage("Invoice created successfully.");

		} catch (Exception e) {
			myError.setType("Error");
			myError.setTitle("Error");
			myError.setMessage("Error creating invoice: " + e.getMessage());
		}

		return myError;
	}

}
