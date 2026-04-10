package ec.com.sidesoft.imports.ad_events;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.order.Order;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.imports.SSIPCostimport;

public class BlockCostImport extends EntityPersistenceEventObserver {
	private static Entity[] entities = { ModelProvider.getInstance().getEntity(SSIPCostimport.ENTITY_NAME), };

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
		SSIPCostimport costImport = (SSIPCostimport) event.getTargetInstance();
		validate(costImport);
	}

	public void onUpdate(@Observes EntityUpdateEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
		SSIPCostimport costImport = (SSIPCostimport) event.getTargetInstance();
		validate(costImport);
	}

	public void onDelete(@Observes EntityDeleteEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
		SSIPCostimport costImport = (SSIPCostimport) event.getTargetInstance();
		validate(costImport);
	}

	private void validate(SSIPCostimport costImport) {
		Order order = costImport.getOrder();
		if (order.getSsipImportstatus().equals("LL")) {
			String message = Utility.messageBD(conn, "SSIP_SettledDocument", language);
			try {
				conn.destroy();
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw new OBException(message);
		}
	}
}
