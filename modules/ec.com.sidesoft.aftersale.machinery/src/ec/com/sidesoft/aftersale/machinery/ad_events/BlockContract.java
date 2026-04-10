package ec.com.sidesoft.aftersale.machinery.ad_events;

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
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.aftersale.machinery.Satmac_Contract;
import ec.com.sidesoft.aftersale.machinery.Satmac_Machine;
import ec.com.sidesoft.aftersale.machinery.Satmac_MaintenancePlan;

public class BlockContract extends EntityPersistenceEventObserver {
	private static Entity[] entities = { ModelProvider.getInstance().getEntity(Satmac_Contract.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(Satmac_Machine.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(Satmac_MaintenancePlan.ENTITY_NAME) };

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

		try {
			Satmac_Machine machine = null;
			Satmac_Contract contract = null;
			Satmac_MaintenancePlan maintenancePlan = null;
			switch (event.getTargetInstance().getEntityName()) {
			case Satmac_Machine.ENTITY_NAME:
				machine = (Satmac_Machine) event.getTargetInstance();
				contract = machine.getSatmacContract();
				if (!contract.getDocumentStatus().equals("DR")) {
					throw new OBException("@DocumentProcessed@");
				}
				break;
			case Satmac_MaintenancePlan.ENTITY_NAME:
				maintenancePlan = (Satmac_MaintenancePlan) event.getTargetInstance();
				machine = maintenancePlan.getSatmacMachine();
				contract = machine.getSatmacContract();
				if (!contract.getDocumentStatus().equals("DR")) {
					throw new OBException("@DocumentProcessed@");
				}
				break;
			}
		} catch (Exception e) {
			String message = Utility.messageBD(conn, e.getMessage(), language);
			try {
				conn.destroy();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			throw new OBException(message);

		}
	}

	public void onUpdate(@Observes EntityUpdateEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
	}

	public void onDelete(@Observes EntityDeleteEvent event) {
		if (!isValidEvent(event)) {
			return;
		}

		try {
			Satmac_Machine machine = null;
			Satmac_Contract contract = null;
			Satmac_MaintenancePlan maintenancePlan = null;
			switch (event.getTargetInstance().getEntityName()) {
			case Satmac_Contract.ENTITY_NAME:
				contract = (Satmac_Contract) event.getTargetInstance();
				if (!contract.getDocumentStatus().equals("DR")) {
					throw new OBException("@DocumentProcessed@");
				}
				break;
			case Satmac_Machine.ENTITY_NAME:
				machine = (Satmac_Machine) event.getTargetInstance();
				contract = machine.getSatmacContract();
				if (!contract.getDocumentStatus().equals("DR")) {
					throw new OBException("@DocumentProcessed@");
				}
				break;
			case Satmac_MaintenancePlan.ENTITY_NAME:
				maintenancePlan = (Satmac_MaintenancePlan) event.getTargetInstance();
				machine = maintenancePlan.getSatmacMachine();
				contract = machine.getSatmacContract();
				if (!contract.getDocumentStatus().equals("DR")) {
					throw new OBException("@DocumentProcessed@");
				}
				break;
			}
		} catch (Exception e) {
			String message = Utility.messageBD(conn, e.getMessage(), language);
			try {
				conn.destroy();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			throw new OBException(message);

		}
	}

}
