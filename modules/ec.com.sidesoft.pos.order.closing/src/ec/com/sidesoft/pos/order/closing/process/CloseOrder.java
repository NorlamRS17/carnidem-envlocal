package ec.com.sidesoft.pos.order.closing.process;

import java.util.List;

import javax.servlet.ServletException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.core.TriggerHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.order.Order;
import org.openbravo.retail.posterminal.JSONProcessSimple;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.service.json.JsonConstants;

import ec.com.sidesoft.sanfelipe.sales.SsfpsReasonsClousure;

public class CloseOrder extends JSONProcessSimple {

  @Override
  public JSONObject exec(JSONObject jsonsent) throws JSONException, ServletException {
    JSONObject result = new JSONObject();
    OBContext.setAdminMode(true);
    try {
      String orderID = jsonsent.getString("orderID");
      String closeReasonID = jsonsent.getString("closereason");

      Order order = OBDal.getInstance().get(Order.class, orderID);
      SsfpsReasonsClousure closeReason = OBDal.getInstance().get(SsfpsReasonsClousure.class,
          closeReasonID);

      TriggerHandler.getInstance().disable();

      order.setSsfpsReasonClousere(closeReason);
      order.setDocumentStatus("CL");
      
      StringBuilder whereClause = new StringBuilder();
		whereClause.append("WHERE");
		whereClause.append(" TRIM('" + orderID + "') IN (" + "c_order_id" + ")" );
		OBQuery<OrderLine> orderslines =
				(OBQuery<OrderLine>)OBDal.getInstance().createQuery((Class)OrderLine.class, whereClause.toString());
      
		List<OrderLine> linesorder = orderslines.list();

		for(OrderLine line : linesorder ) {
			line.setSsfpsQtyordered(line.getOrderedQuantity());
			line.setSsfpsQtydelivered(line.getDeliveredQuantity());
			line.setSsfpsQtyinvoiced(line.getInvoicedQuantity());
			line.setOrderedQuantity(line.getDeliveredQuantity());
			OBDal.getInstance().save(line);
			
			
		}

      OBDal.getInstance().save(order);

      result.put(JsonConstants.RESPONSE_DATA, 0);
      result.put(JsonConstants.RESPONSE_STATUS, JsonConstants.RPCREQUEST_STATUS_SUCCESS);

    } catch (Exception e) {
      throw new OBException(e.getMessage(), e);
    } finally {
      OBDal.getInstance().flush();
      TriggerHandler.getInstance().enable();
      OBContext.restorePreviousMode();
    }

    return result;
  }

}
