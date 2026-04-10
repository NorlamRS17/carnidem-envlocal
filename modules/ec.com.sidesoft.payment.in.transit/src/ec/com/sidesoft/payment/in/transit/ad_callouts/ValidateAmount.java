package ec.com.sidesoft.payment.in.transit.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;

public class ValidateAmount extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		try {
			String strPaymentScheduleId = info.getStringParameter("inpfinPaymentScheduleId", null);
			String strAmount = info.getStringParameter("inpamount", null);

			if (strAmount != null && !strAmount.isEmpty()) {
				FIN_PaymentSchedule paymentSchedule = OBDal.getInstance().get(FIN_PaymentSchedule.class,
						strPaymentScheduleId);
				BigDecimal amount = new BigDecimal(strAmount.replace(",", ""));
				if (amount.compareTo(paymentSchedule.getOutstandingAmount()) > 0) {
					info.addResult("inpamount", paymentSchedule.getOutstandingAmount());
					info.addResult("ERROR", "El monto no puede ser mayor al valor pendiente de la cuota");
				} else if (amount.compareTo(paymentSchedule.getOutstandingAmount()) <= 0) {
					info.addResult("inpamount", null);
					info.addResult("ERROR", "El monto debe ser mayor a 0");
				}
			}
		} catch (Exception e) {
			System.out.println("ValidateAmount: " + e.getMessage());
		}

	}
}
