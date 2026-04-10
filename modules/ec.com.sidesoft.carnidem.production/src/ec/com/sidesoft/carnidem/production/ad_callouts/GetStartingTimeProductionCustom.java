package ec.com.sidesoft.carnidem.production.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;

public class GetStartingTimeProductionCustom extends SimpleCallout {
  private static final long serialVersionUID = 3653617759010780960L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String productionTransactionId = info.getStringParameter("inpemSpqulyWorkeffortId", null);
    ProductionTransaction productionTrx = OBDal.getInstance().get(ProductionTransaction.class,
        productionTransactionId);
    System.out.println("productionTransactionId :: " + productionTransactionId);
    if (productionTrx != null) {
      System.out.println("starting time :: " + productionTrx.getStartingTime());
      info.addResult("inpemSpqulyStarttime", productionTrx.getStartingTime());
      info.addResult("inpemSpqulyEndtime", productionTrx.getEndingTime());
    }
  }

}
