package ec.com.sidesoft.production.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;

public class ssprodcalculateqty extends SimpleCallout {
  private static final long serialVersionUID = 3653617759010780960L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String qtyStop = info.getStringParameter("inpemSsprodSecondqtystop", null);
    String ratio = info.getStringParameter("inpconversionrate", null);
    BigDecimal qtycalculate = BigDecimal.ZERO;
	qtycalculate = (new BigDecimal(qtyStop).multiply(new BigDecimal(ratio))).setScale(4, BigDecimal.ROUND_HALF_UP);
    info.addResult("inpsecondaryqty", qtycalculate.toString());
  }

}
