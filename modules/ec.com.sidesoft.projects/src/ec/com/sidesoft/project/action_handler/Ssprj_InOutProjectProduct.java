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
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;

import ec.com.sidesoft.projects.complement.SproctmTaskProd;

public class Ssprj_InOutProjectProduct extends BaseProcessActionHandler {

	private static final Logger log = Logger.getLogger(Ssprj_InOutProjectProduct.class);

	@Override
	protected JSONObject doExecute(Map<String, Object> parameters, String content) {
		JSONObject result = new JSONObject();
		try {
			JSONObject request = new JSONObject(content);
			JSONObject params = request.getJSONObject("_params");
			JSONObject window = params.getJSONObject("window");
			JSONArray selection = window.getJSONArray("_selection");

			String inOutId = request.getString("M_InOut_ID");
			ShipmentInOut inOut = OBDal.getInstance().get(ShipmentInOut.class, inOutId);

			Long lineNo = new Long(10);
			OBCriteria<ShipmentInOutLine> qInOutLine = OBDal.getInstance().createCriteria(ShipmentInOutLine.class);
			qInOutLine.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_SHIPMENTRECEIPT, inOut));
			qInOutLine.setProjection(Projections.max(ShipmentInOutLine.PROPERTY_LINENO));
			Long maxLineNo = (Long) qInOutLine.uniqueResult();
			if (maxLineNo != null) {
				lineNo = maxLineNo + 10;
			}
			for (int i = 0; i < selection.length(); i++) {
				JSONObject row = selection.getJSONObject(i);

				String taskProdId = row.getString("id");
				SproctmTaskProd taskProd = OBDal.getInstance().get(SproctmTaskProd.class, taskProdId);

				String pQTYComsume = row.getString("qTYConsume");
				BigDecimal qtyConsume = new BigDecimal(pQTYComsume);
				if (taskProd.getSsprjQtyConsumed().add(qtyConsume).compareTo(taskProd.getQuantity()) > 0) {
					qtyConsume = taskProd.getQuantity().subtract(taskProd.getSsprjQtyConsumed());
				}

				String attributeSetInstanceId = row.getString("attributeSetValue");
				AttributeSetInstance attributeSetInstance = null;
				if (attributeSetInstanceId != null && !attributeSetInstanceId.equals("0")) {
					attributeSetInstance = OBDal.getInstance().get(AttributeSetInstance.class, attributeSetInstanceId);
				}

				String storageBin = row.getString("storageBin");
				Locator locator = OBDal.getInstance().get(Locator.class, storageBin);

				qInOutLine = OBDal.getInstance().createCriteria(ShipmentInOutLine.class);
				qInOutLine.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_SHIPMENTRECEIPT, inOut));
				qInOutLine.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_SSPRJPROJECTPRODUCT, taskProd));

				ShipmentInOutLine inOutLine = null;
				if (qInOutLine.list().size() == 0) {
					inOutLine = OBProvider.getInstance().get(ShipmentInOutLine.class);
				} else {
					inOutLine = qInOutLine.list().get(0);
				}

				inOutLine.setShipmentReceipt(inOut);
				inOutLine.setClient(inOut.getClient());
				inOutLine.setOrganization(inOut.getOrganization());
				inOutLine.setLineNo(lineNo);
				inOutLine.setProduct(taskProd.getProduct());
				inOutLine.setSprliIdentifier(taskProd.getProduct().getSearchKey());
				inOutLine.setMovementQuantity(qtyConsume);
				inOutLine.setUOM(taskProd.getProduct().getUOM());
				inOutLine.setStorageBin(locator);
				inOutLine.setAttributeSetValue(attributeSetInstance);
				inOutLine.setSSPRJProjectProduct(taskProd);
				inOutLine.setSproctmCProjecttask(taskProd.getProjectTask());
				inOutLine.setSproctmCProjectphase(taskProd.getProjectTask().getProjectPhase());
				inOutLine.setProject(taskProd.getProjectTask().getProjectPhase().getProject());

				OBDal.getInstance().save(inOutLine);
				OBDal.getInstance().flush();

				lineNo = lineNo + 10;
			}
			OBDal.getInstance().commitAndClose();

			return request;
		} catch (Exception e) {
			OBDal.getInstance().rollbackAndClose();
			String message = e.getMessage();
			log.error("Error Ssprj_InOutProjectProduct: " + message, e);
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