package ec.com.sidesoft.production.process.ad_callouts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class Ssprodp_WorkRequirement_Conversion extends SimpleCallout {

	private static final Logger log4j = Logger.getLogger(Ssprodp_WorkRequirement_Conversion.class);

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		String strChanged = info.getLastFieldChanged();
		if (log4j.isDebugEnabled()) {
			log4j.debug("CHANGED: " + strChanged);
		}

		String strSecQty = info.vars.getNumericParameter("inpsecondaryqty");
		String strConvRate = info.vars.getNumericParameter("inpconversionrate");

		if (StringUtils.isNotEmpty(strSecQty) && StringUtils.isNotEmpty(strConvRate)) {
			BigDecimal secQty = new BigDecimal(strSecQty);
			BigDecimal convRate = new BigDecimal(strConvRate);

			if (convRate.compareTo(BigDecimal.ZERO) != 0) {
				// Escala 12 y redondeo para evitar ArithmeticException
				BigDecimal quantity = secQty.divide(convRate, 12, RoundingMode.HALF_UP);
				info.addResult("inpquantity", quantity);
			} else {
				log4j.warn("Conversion rate is zero; cannot divide.");
			}
		}
	}
}
