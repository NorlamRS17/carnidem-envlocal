package ec.com.sidesoft.project.action_handler;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.client.application.process.BaseProcessActionHandler;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;

import ec.com.sidesoft.projects.complement.SproctmTaskProd;

public class Ssprj_MovementProjectProduct extends BaseProcessActionHandler {

	private static final Logger log = Logger.getLogger(Ssprj_MovementProjectProduct.class);

	@Override
	protected JSONObject doExecute(Map<String, Object> parameters, String content) {
		JSONObject result = new JSONObject();
		try {
			JSONObject request = new JSONObject(content);
			JSONObject params = request.getJSONObject("_params");
			JSONObject window = params.getJSONObject("window");
			JSONArray selection = window.getJSONArray("_selection");

			String movementId = request.getString("M_Movement_ID");
			InternalMovement movement = OBDal.getInstance().get(InternalMovement.class, movementId);

			String locatorId = params.getString("M_Locator_ID");
			Locator locator = OBDal.getInstance().get(Locator.class, locatorId);

			String locatorToId = params.getString("M_LocatorTo_ID");
			Locator locatorTo = OBDal.getInstance().get(Locator.class, locatorToId);

			Long lineNo = new Long(10);
			OBCriteria<InternalMovementLine> qMovementLine = OBDal.getInstance()
					.createCriteria(InternalMovementLine.class);
			qMovementLine.add(Restrictions.eq(InternalMovementLine.PROPERTY_MOVEMENT, movement));
			qMovementLine.setProjection(Projections.max(InternalMovementLine.PROPERTY_LINENO));
			Long maxLineNo = (Long) qMovementLine.uniqueResult();
			if (maxLineNo != null) {
				lineNo = maxLineNo + 10;
			}
			for (int i = 0; i < selection.length(); i++) {
				JSONObject row = selection.getJSONObject(i);

				String taskProdId = row.getString("id");
				SproctmTaskProd taskProd = OBDal.getInstance().get(SproctmTaskProd.class, taskProdId);

				String pQTYDeliver = row.getString("qTYDeliver");
				BigDecimal qtyDeliver = new BigDecimal(pQTYDeliver);
				if (taskProd.getSsprjQtyTransferred().add(qtyDeliver).compareTo(taskProd.getQuantity()) > 0) {
					qtyDeliver = taskProd.getQuantity().subtract(taskProd.getSsprjQtyTransferred());
				}

				String attributeSetInstanceId = row.getString("attributeSetValue");
				AttributeSetInstance attributeSetInstance = null;
				if (attributeSetInstanceId != null && !attributeSetInstanceId.equals("0")) {
					attributeSetInstance = OBDal.getInstance().get(AttributeSetInstance.class, attributeSetInstanceId);
				}

				qMovementLine = OBDal.getInstance().createCriteria(InternalMovementLine.class);
				qMovementLine.add(Restrictions.eq(InternalMovementLine.PROPERTY_MOVEMENT, movement));
				qMovementLine.add(Restrictions.eq(InternalMovementLine.PROPERTY_SSPRJTASKPROD, taskProd));

				InternalMovementLine movementLine = null;
				if (qMovementLine.list().size() == 0) {
					movementLine = OBProvider.getInstance().get(InternalMovementLine.class);
				} else {
					movementLine = qMovementLine.list().get(0);
				}

				movementLine.setMovement(movement);
				movementLine.setClient(movement.getClient());
				movementLine.setOrganization(movement.getOrganization());
				movementLine.setLineNo(lineNo);
				movementLine.setProduct(taskProd.getProduct());
				movementLine.setSprliIdentifier(taskProd.getProduct().getSearchKey());
				movementLine.setMovementQuantity(qtyDeliver);
				movementLine.setUOM(taskProd.getProduct().getUOM());
				movementLine.setStorageBin(locator);
				movementLine.setAttributeSetValue(attributeSetInstance);
				movementLine.setAttributeSetInstanceTo(attributeSetInstance);
				movementLine.setNewStorageBin(locatorTo);
				movementLine.setSsprjTaskProd(taskProd);

				OBDal.getInstance().save(movementLine);
				OBDal.getInstance().flush();

				lineNo = lineNo + 10;
			}
			OBDal.getInstance().commitAndClose();

			return request;
		} catch (Exception e) {
			OBDal.getInstance().rollbackAndClose();
			String message = e.getMessage();
			log.error("Error Ssprj_MovementProjectProduct: " + message, e);
			try {
				JSONObject msg = new JSONObject();
				msg.put("severity", "error");
				msg.put("text", message);
				result.put("message", msg);				
			} catch (Exception e2) {
			}
		}
		return result;
	}
}