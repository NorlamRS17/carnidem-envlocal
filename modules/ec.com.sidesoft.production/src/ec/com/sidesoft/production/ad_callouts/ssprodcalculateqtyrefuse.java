package ec.com.sidesoft.production.ad_callouts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class ssprodcalculateqtyrefuse extends SimpleCallout {

  private static final long serialVersionUID = 1L;
  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    // TODO Auto-generated method stub
    // inpcDoctypeId
    // inpnoCertificate
	    String qtySecondaryreject = info.getStringParameter("inpemSsprodQtysecrech", null);
	    String ratio = info.getStringParameter("inpconversionrate", null);
	    BigDecimal secQty = new BigDecimal(qtySecondaryreject);
		BigDecimal convRate = new BigDecimal(ratio);
	    BigDecimal qtycalculate = BigDecimal.ZERO;
		qtycalculate = secQty.divide(convRate, 4, RoundingMode.CEILING);
	    info.addResult("inprejectedquantity", qtycalculate.toString());
  }

}
