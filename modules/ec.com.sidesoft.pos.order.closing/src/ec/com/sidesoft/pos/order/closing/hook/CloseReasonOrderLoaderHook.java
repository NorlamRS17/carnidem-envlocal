package ec.com.sidesoft.pos.order.closing.hook;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.retail.posterminal.OrderLoaderModifiedHook;

import ec.com.sidesoft.sanfelipe.sales.SsfpsReasonsClousure;

public class CloseReasonOrderLoaderHook extends OrderLoaderModifiedHook {

  @Override
  public void exec(JSONObject jsonorder, Order order, ShipmentInOut shipment, Invoice invoice)
      throws Exception {
    if (jsonorder.has("closereason")) {
      SsfpsReasonsClousure reason = OBDal.getInstance().get(SsfpsReasonsClousure.class,
          jsonorder.getString("closereason"));
      order.setSsfpsReasonClousere(reason);
      order.setDocumentStatus("CL");
      OBDal.getInstance().save(order);
    }
  }
}
