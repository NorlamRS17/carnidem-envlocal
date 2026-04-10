package ec.com.sidesoft.payment.in.transit.helpers;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.payment.in.transit.SspitraCollectionTransit;
import ec.com.sidesoft.payment.in.transit.SspitraCtDetail;
import ec.com.sidesoft.payment.in.transit.Sspitra_Config;

abstract public class Utils {

	static public Sspitra_Config getConfig() {
		Sspitra_Config config = null;
		try {
			OBCriteria<Sspitra_Config> query = OBDal.getInstance().createCriteria(Sspitra_Config.class);
			query.add(Restrictions.eq(Sspitra_Config.PROPERTY_ACTIVE, true));
			query.uniqueResult();
			if (query.list().size() == 0) {
				throw new OBException("No existe configuracion para el WS");
			}
			config = query.list().get(0);
		} catch (Exception e) {
			System.out.println("getConfig: " + e.getMessage());
			throw new OBException(e.getMessage());
		}
		return config;
	}

	static public SspitraCollectionTransit createPayment(Organization org, BusinessPartner bPartner,
			FIN_PaymentMethod paymentMethod, ssfiBanktransfer bank, BusinessPartner seller, String reference,
			String check, String documentNo, String deposit, String description, Date paymentDate,
			FIN_FinancialAccount financialAccount, Currency currency) {
		SspitraCollectionTransit payment = null;
		try {
			payment = OBProvider.getInstance().get(SspitraCollectionTransit.class);
			payment.setNewOBObject(true);
			payment.setOrganization(org);
			payment.setClient(org.getClient());
			payment.setPaymentDocumentno(documentNo);
			payment.setReferenceNo(reference);
			payment.setPaymentDate(paymentDate);
			payment.setBusinessPartner(bPartner);
			payment.setChargedBy(seller);
			payment.setSsfiBanktransfer(bank);
			payment.setDeposit(deposit);
			payment.setPaymentMethod(paymentMethod);
			payment.setFinancialAccount(financialAccount);
			payment.setCurrency(currency);
			payment.setDescription(description);
			payment.setCheckAccount(check);

			OBDal.getInstance().save(payment);
			// OBDal.getInstance().flush();
		} catch (Exception e) {
			System.out.println("createPayment: " + e.getMessage());
			throw new OBException(e.getMessage());
		}
		return payment;
	}

	static public void createDetail(SspitraCollectionTransit payment, String documentNo, BusinessPartner bPartner,
			BigDecimal amount, String paymentScheduleId) {
		SspitraCtDetail detail = null;
		try {
			if (amount.compareTo(BigDecimal.ZERO) <= 0) {
				throw new OBException("El monto debe ser mayor a 0");
			}

			OBCriteria<Invoice> query = OBDal.getInstance().createCriteria(Invoice.class);
			query.add(Restrictions.eq(Invoice.PROPERTY_DOCUMENTNO, documentNo));
			query.add(Restrictions.eq(Invoice.PROPERTY_BUSINESSPARTNER, bPartner));
			if (query.list().size() == 0) {
				throw new OBException(
						"La factura " + documentNo + " no existe o no pertenece al tercero" + bPartner.getName());
			}
			Invoice invoice = query.list().get(0);

			if (invoice.getOutstandingAmount().compareTo(BigDecimal.ZERO) <= 0) {
				throw new OBException("La factura " + documentNo + " no tiene monto pendiente");
			}

			if (invoice.getOutstandingAmount().compareTo(amount) < 0) {
				throw new OBException("El monto (" + amount.toString() + ") supera el total pendiente ("
						+ invoice.getOutstandingAmount().toString() + ") de la factura " + documentNo);
			}

			FIN_PaymentSchedule paymentSchedule = OBDal.getInstance().get(FIN_PaymentSchedule.class, paymentScheduleId);
			if (paymentSchedule == null) {
				throw new OBException("Error al intentar obtener la cuota de la factura " + invoice.getDocumentNo());
			}

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = df.format(paymentSchedule.getDueDate());
			if (paymentSchedule.getOutstandingAmount().compareTo(BigDecimal.ZERO) <= 0) {
				throw new OBException("La cuota (" + strDate + ") de la factura " + invoice.getDocumentNo()
						+ " no tiene monto pendiente");
			}

			if (paymentSchedule.getOutstandingAmount().compareTo(amount) < 0) {
				throw new OBException("El monto (" + amount.toString() + ") supera el total pendiente ("
						+ paymentSchedule.getOutstandingAmount().toString() + ") de la cuota " + strDate
						+ " de la factura " + documentNo);
			}

			detail = OBProvider.getInstance().get(SspitraCtDetail.class);
			detail.setNewOBObject(true);
			detail.setOrganization(payment.getOrganization());
			detail.setClient(payment.getOrganization().getClient());
			detail.setSspitraCollectiontransit(payment);
			detail.setInvoice(invoice);
			detail.setGrandTotalAmount(paymentSchedule.getAmount());
			detail.setTotalPaid(paymentSchedule.getPaidAmount());
			detail.setOutstandingAmount(paymentSchedule.getOutstandingAmount());
			detail.setAmount(amount);
			detail.setFinPaymentSchedule(paymentSchedule);

			OBDal.getInstance().save(detail);

			payment.setAmount(payment.getAmount().add(amount));

			OBDal.getInstance().save(payment);
		} catch (Exception e) {
			System.out.println("createDetail: " + e.getMessage());
			throw new OBException(e.getMessage());
		}
	}
}
