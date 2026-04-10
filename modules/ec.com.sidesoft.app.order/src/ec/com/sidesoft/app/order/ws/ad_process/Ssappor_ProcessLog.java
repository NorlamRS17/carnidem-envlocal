package ec.com.sidesoft.app.order.ws.ad_process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.app.order.SsapporLog;
import ec.com.sidesoft.payment.in.transit.helpers.Utils;
import ec.com.sidesoft.payment.in.transit.SspitraCollectionTransit;
import ec.com.sidesoft.payment.in.transit.Sspitra_Config;
import ec.com.sidesoft.ws.ordercreate.webservices.setorderweb.OrderWebWS;
import ec.com.sidesoft.ws.ordercreate.webservices.util.ResponseWS;

public class Ssappor_ProcessLog extends DalBaseProcess {
	private final Logger log4j = Logger.getLogger(SsapporLog.class);

	private Organization org;
	private BusinessPartner bPartner;
	private FIN_PaymentMethod paymentMethod;
	private ssfiBanktransfer bank;
	private BusinessPartner seller;
	private String msgError = "";

	@Override
	public void doExecute(ProcessBundle bundle) throws Exception {
		OBContext.setAdminMode(true);
		OBError msg = new OBError();
		msg.setType("Success");
		msg.setTitle(OBMessageUtils.messageBD("Success"));

		try {
			// Parametros
			final String recordId = (String) bundle.getParams().get("Ssappor_Log_ID");

			SsapporLog log = OBDal.getInstance().get(SsapporLog.class, recordId);
			if (log.isGenerate()) {
				throw new OBException("Este registro ya fue procesado");
			}

			if (log.isProcessNow()) {
				throw new OBException("El registro esta siendo procesando");
			}

			log.setProcessNow(true);
			OBDal.getInstance().save(log);
			OBDal.getInstance().flush();
			OBDal.getInstance().getConnection().commit();

			log.setError(null);
			JsonObject json = new JsonParser().parse(log.getJsoninfo()).getAsJsonObject();
			json = json.getAsJsonObject("data");
			if (log.getType().equals("Ssappor_sales_order")) {
				try {
					OrderWebWS oWS = new OrderWebWS();
					ResponseWS res = oWS.insertSalesOrder(json);
					if (res.getStatus().equals("ERROR")) {
						throw new OBException(res.getMessage());
					}

					OBCriteria<Order> orders = OBDal.getInstance().createCriteria(Order.class);
					orders.add(Restrictions.eq(Order.PROPERTY_DOCUMENTNO, res.getDocumentNo()));

					Order order = orders.list().get(0);
					order.setSsapporLog(log);
					OBDal.getInstance().save(order);

					log.setDocumentno(res.getDocumentNo());
					log.setOrder(order);
					OBDal.getInstance().save(log);
				} catch (Exception e) {
					OBDal.getInstance().getConnection().rollback();

					log.setError(e.getMessage());
					log.setProcessNow(false);
					OBDal.getInstance().save(log);
					OBDal.getInstance().flush();
					OBDal.getInstance().getConnection().commit();

					throw e;
				}
			} else {
				try {
					JsonArray payments = json.getAsJsonArray("payments");
					JsonArray paymentsList = new JsonArray();

					for (JsonElement jsonElement : payments) {
						if (jsonElement.isJsonObject()) {

							// JsonObject optionObj = payments.get(0).getAsJsonObject();
							JsonObject optionObj = jsonElement.getAsJsonObject();

							String paymentSchedule_id = optionObj.get("payment_schedule_id").getAsString();

							FIN_PaymentSchedule paymentSchedule = OBDal.getInstance().get(FIN_PaymentSchedule.class,
									paymentSchedule_id);
							if (paymentSchedule == null) {
								throw new OBException("Cuota de la factura no encontrado");
							}
							// JsonObject payment = jsonElement.getAsJsonObject();
							optionObj.addProperty("invoice_number",
									paymentSchedule.getInvoice().getDocumentNo().toString());
							paymentsList.add(optionObj);
						}
					}
					json.add("payments", paymentsList);

					JsonObject data = new JsonObject();
					data.add("data", json);
					SspitraCollectionTransit res = createPayment(data.toString(),
							log.getCreatedBy().getBusinessPartner());
					log.setSspitraCollectiontransit(res);

					if (json.has("reference_number")) {
						String referenceNo = json.get("reference_number").isJsonNull() ? null
								: json.get("reference_number").getAsString();
						log.setDocumentno(referenceNo);
					}

					OBDal.getInstance().save(log);
					if (res == null) {
						throw new OBException(msgError);
					}
				} catch (Exception e) {
					OBDal.getInstance().getConnection().rollback();

					log.setError(e.getMessage());
					log.setProcessNow(false);
					OBDal.getInstance().save(log);
					OBDal.getInstance().flush();
					OBDal.getInstance().getConnection().commit();

					throw e;
				}
			}

			log.setGenerate(true);
			log.setProcessNow(false);
			OBDal.getInstance().save(log);
			OBDal.getInstance().flush();

			OBDal.getInstance().commitAndClose();
		} catch (final Exception e) {
			OBDal.getInstance().rollbackAndClose();

			log4j.error("Exception found in Ssappor_ProcessLog process: ", e);

			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage(e.getMessage());
		} finally {
			OBContext.restorePreviousMode();
			bundle.setResult(msg);
		}
	}

	public SspitraCollectionTransit createPayment(String json, BusinessPartner seller) {
		JSONObject res = new JSONObject();

		try {
			JSONObject data = new JSONObject(json).getJSONObject("data");

			// Validamos que exista la configuracion del WS
			Sspitra_Config config = Utils.getConfig();

			// Validamos la organizacion
			String orgId = data.getString("org_id");
			Organization org = OBDal.getInstance().get(Organization.class, orgId);
			if (org == null) {
				throw new OBException("El ID " + orgId + " de la organizacion es incorrecto");
			}

			// Validamos el tercero
			String bPartnerId = data.getString("bpartner_id");
			BusinessPartner bPartner = OBDal.getInstance().get(BusinessPartner.class, bPartnerId);
			if (bPartner == null) {
				throw new OBException("El ID " + bPartnerId + " del tercero es incorrecto");
			}

			// Validamos el metodo de pago
			String paymentMethodId = data.getString("payment_method_id");
			FIN_PaymentMethod paymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class, paymentMethodId);
			if (paymentMethod == null) {
				throw new OBException("El ID " + paymentMethodId + " del metodo de pago es incorrecto");
			}

			// Validamos el banco
			String bankId = data.getString("bank_id");
			ssfiBanktransfer bank = null;
			if (bankId != null && !bankId.isEmpty()) {
				bank = OBDal.getInstance().get(ssfiBanktransfer.class, bankId);
				if (bank == null) {
					throw new OBException("El ID " + bankId + " del banco es incorrecto");
				}
			}

			// Otros campos
			String reference = data.getString("reference_number");
			String check = data.getString("check_number");
			String documentNo = data.getString("documentno");
			String deposit = data.getString("deposit_number");
			String description = data.getString("description");

			// Fecha
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String strPaymentDate = data.getString("payment_date");
			Date paymentDate = new Date();
			if (strPaymentDate != null && !strPaymentDate.equals("")) {
				paymentDate = df.parse(strPaymentDate);
			}

			// Cuenta financiera
			FIN_FinancialAccount financialAccount = null;
			if (data.has("financial_account") && !data.isNull("financial_account")) {
				financialAccount = OBDal.getInstance().get(FIN_FinancialAccount.class,
						data.getString("financial_account"));
			} else {
				financialAccount = config.getDepositIn();
			}

			Currency currency = null;
			if (data.has("currency") && !data.isNull("currency")) {
				currency = OBDal.getInstance().get(Currency.class, data.getString("currency"));
			} else {
				currency = config.getCurrency();
			}

			SspitraCollectionTransit payment = Utils.createPayment(org, bPartner, paymentMethod, bank, seller,
					reference, check, documentNo, deposit, description, paymentDate, financialAccount, currency);

			int precision = config.getCurrency().getStandardPrecision().intValue();

			JSONArray items = data.getJSONArray("payments");
			for (int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				String invoice = item.getString("invoice_number");
				String payment_schedule_id = item.getString("payment_schedule_id");
				BigDecimal amount = new BigDecimal(item.getString("amount")).setScale(precision, RoundingMode.HALF_UP);
				Utils.createDetail(payment, invoice, bPartner, amount, payment_schedule_id);
			}

			OBDal.getInstance().commitAndClose();

			return payment;
		} catch (Exception e) {
			OBDal.getInstance().rollbackAndClose();

			try {
				res.put("status", "ERROR");
				res.put("message", "Error al insertar el pago. " + e.getMessage());
				msgError = "Error al insertar el pago. " + e.getMessage();
			} catch (Exception e2) {
			}
		}

		return null;
	}

}
