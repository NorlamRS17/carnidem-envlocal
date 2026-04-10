package ec.com.sidesoft.balancing.accounts.ad_actionHandler;

import javax.enterprise.event.Observes;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.apache.log4j.Logger;
import ec.com.sidesoft.balancing.accounts.EcsbaModule;
import ec.com.sidesoft.balancing.accounts.EcsbaBreakdown;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;


public class Ecsba_ModuleValid extends EntityPersistenceEventObserver {
    
    private static final Logger log = Logger.getLogger(Ecsba_ModuleValid.class);

	private static Entity[] entities = { ModelProvider.getInstance().getEntity(EcsbaModule.ENTITY_NAME) };

	@Override
	protected Entity[] getObservedEntities() {
		return entities;
	}

    
    public void onDelete(@Observes EntityDeleteEvent event) {
		if (!isValidEvent(event)) {
			return;
		}

        final EcsbaModule module = (EcsbaModule) event.getTargetInstance();
        OBCriteria<EcsbaBreakdown> criteria = OBDal.getInstance().createCriteria(EcsbaBreakdown.class);
        criteria.add(Restrictions.eq(EcsbaBreakdown.PROPERTY_ECSBAMODULE, module));
        criteria.setMaxResults(1);
        
        if (criteria.count() > 0) {
            // Lanzamos la excepción para frenar la transacción
            throw new OBException("No se puede eliminar el módulo '" + module.getName() + "' porque tiene líneas de desglose asociadas");
        }
        
	}
}
