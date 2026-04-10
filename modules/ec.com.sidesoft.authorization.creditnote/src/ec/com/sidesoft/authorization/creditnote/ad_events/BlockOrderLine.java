package ec.com.sidesoft.authorization.creditnote.ad_events;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.service.db.DalConnectionProvider;

public class BlockOrderLine extends EntityPersistenceEventObserver {
	private static Entity[] entities = { ModelProvider.getInstance().getEntity(Order.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(OrderLine.ENTITY_NAME) };

	ConnectionProvider conn = new DalConnectionProvider(false);
	String language = OBContext.getOBContext().getLanguage().getLanguage();

	@Override
	protected Entity[] getObservedEntities() {
		return entities;
	}

	public void onSave(@Observes EntityNewEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
	}

	public void onUpdate(@Observes EntityUpdateEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
		if (event.getTargetInstance().getEntityName().equals(OrderLine.ENTITY_NAME)) {
			validateOrderLine((OrderLine) event.getTargetInstance());
		} else {
			final Entity orderEntity = ModelProvider.getInstance().getEntity(Order.ENTITY_NAME);
			String oldCode2 = (String) event.getPreviousState(orderEntity.getProperty(Order.PROPERTY_SATHNCCODE2));
			validateOrder((Order) event.getTargetInstance(), oldCode2);
		}
	}

	public void onDelete(@Observes EntityDeleteEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
		if (event.getTargetInstance().getEntityName().equals(OrderLine.ENTITY_NAME)) {
			validateOrderLine((OrderLine) event.getTargetInstance());
		}
	}

	private void validateOrder(Order order, String oldCode2) {
		if (order.isSalesTransaction()) {
			DocumentType docType = order.getTransactionDocument();
			if (docType.isSathncAuthRequired() && order.getSathncCode() != null) {
				if (order.getSathncCode2() != null && order.getSathncCode2().equals(oldCode2)) {
					String message = Utility.messageBD(conn, "@SATHNC_OperationNotAllowed@", language);
					try {
						conn.destroy();
					} catch (Exception e) {
						e.printStackTrace();
					}
					throw new OBException(message);
				}
			}
		}
	}

	private void validateOrderLine(OrderLine orderLine) {
		Order order = orderLine.getSalesOrder();
		if (order.isSalesTransaction()) {
			DocumentType docType = order.getTransactionDocument();
			if (docType.isSathncAuthRequired() && order.getSathncCode() != null) {
				String message = Utility.messageBD(conn, "@SATHNC_OperationNotAllowed@", language);
				try {
					conn.destroy();
				} catch (Exception e) {
					e.printStackTrace();
				}
				throw new OBException(message);
			}
		}
	}
}
