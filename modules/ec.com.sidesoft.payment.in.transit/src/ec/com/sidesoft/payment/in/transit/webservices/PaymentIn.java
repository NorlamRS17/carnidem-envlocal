package ec.com.sidesoft.payment.in.transit.webservices;

import java.io.BufferedReader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.service.web.WebService;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.payment.in.transit.SspitraCollectionTransit;
import ec.com.sidesoft.payment.in.transit.Sspitra_Config;
import ec.com.sidesoft.payment.in.transit.helpers.Utils;

public class PaymentIn implements WebService {

	private static final Logger logger = Logger.getLogger(PaymentIn.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSONObject res = new JSONObject();
		res.put("status", "OK");
		res.put("data", new ArrayList());
		res.put("message", "");

		OBContext.setAdminMode(true);

		try {
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
			}

			res = createPayment(stringBuffer.toString());
		} catch (Exception e) {
			OBDal.getInstance().rollbackAndClose();
			System.out.println("doPost: " + e.getMessage());
			res.put("status", "ERROR");
			res.put("message", "Error al insertar el pago. " + e.getMessage());
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		final Writer w = response.getWriter();
		w.write(res.toString());
		w.close();
	}

	@Override
	public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	@Override
	public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	@Override
	public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	public JSONObject createPayment(String json) {
		JSONObject res = new JSONObject();
		OBContext.setAdminMode(true);

		try {
			res.put("status", "OK");
			res.put("data", new ArrayList());
			res.put("message", "");
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

			// Validamos el vendedor
			String sellerId = data.getString("seller_id");
			BusinessPartner seller = null;
			if (sellerId != null && !sellerId.isEmpty()) {
				seller = OBDal.getInstance().get(BusinessPartner.class, sellerId);
				if (seller == null) {
					throw new OBException("El ID " + sellerId + " del vendedor es incorrecto");
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

			res.put("message", "El pago fue creado exitosamente");
		} catch (

		Exception e) {
			OBDal.getInstance().rollbackAndClose();
			System.out.println("createPayment: " + e.getMessage());
			try {
				res.put("status", "ERROR");
				res.put("message", "Error al insertar el pago. " + e.getMessage());
			} catch (Exception e2) {
			}
		}
		return res;
	}

}
