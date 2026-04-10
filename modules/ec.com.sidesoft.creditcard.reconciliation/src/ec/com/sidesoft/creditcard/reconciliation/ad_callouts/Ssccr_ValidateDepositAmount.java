package ec.com.sidesoft.creditcard.reconciliation.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRecLine;

public class Ssccr_ValidateDepositAmount extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		String strPosCardRecLineId = info.getStringParameter("inpssccrPosCardRecLineId", IsIDFilter.instance);
		String strDepositAmount = info.vars.getStringParameter("inpdepositAmount");

		SsccrPosCardRecLine posCardRecLine = OBDal.getInstance().get(SsccrPosCardRecLine.class, strPosCardRecLineId);
		BigDecimal depositAmountOriginal = posCardRecLine.getDepositAmountOriginal();

		String error = null;
		BigDecimal depositAmount = null;
		try {
			depositAmount = new BigDecimal(strDepositAmount);
		} catch (Exception e) {
			error = "Valor incorrecto";
		}

		if (depositAmount.compareTo(depositAmountOriginal) != 0) {
			if (depositAmount.compareTo(depositAmountOriginal) > 0) {
				error = "El Importe Depósito no puede ser mayor al valor pendiente [" + depositAmountOriginal + "]";
			} else if (depositAmount.compareTo(BigDecimal.ZERO) < 0) {
				error = "El Importe Depósito no puede ser menor a cero [0.0]";
			}
		}

		if (error != null) {
			info.addResult("inpdepositAmount", depositAmountOriginal);
			info.addResult("ERROR", error);
		} else {
			info.addResult("inpdepositAmount", depositAmount);
		}
	}

}
