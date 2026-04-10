package ec.com.sidesoft.production.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;

public class ssprodcalculateqtySecondrefuse extends SimpleCallout {

  private static final long serialVersionUID = 1L;
  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    // TODO Auto-generated method stub
    // inpcDoctypeId
    // inpnoCertificate
	    String qtyreject = info.getStringParameter("inprejectedquantity", null);
	    String ratio = info.getStringParameter("inpconversionrate", null);
	    BigDecimal qtycalculate = BigDecimal.ZERO;
		qtycalculate = (new BigDecimal(qtyreject).multiply(new BigDecimal(ratio))).setScale(4, BigDecimal.ROUND_HALF_UP);
	    info.addResult("inpemSsprodQtysecrech", qtycalculate.toString());
  }

}
