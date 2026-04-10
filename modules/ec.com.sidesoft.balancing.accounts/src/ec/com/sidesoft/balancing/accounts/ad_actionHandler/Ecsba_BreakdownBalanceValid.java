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
import ec.com.sidesoft.balancing.accounts.EcsbaBreakdownBalance;
import ec.com.sidesoft.balancing.accounts.EcsbaAccountingAccounts;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;

public class Ecsba_BreakdownBalanceValid extends EntityPersistenceEventObserver {
    
    private static final Logger log = Logger.getLogger(Ecsba_BreakdownBalanceValid.class);

	private static Entity[] entities = { ModelProvider.getInstance().getEntity(EcsbaBreakdownBalance.ENTITY_NAME) };

	@Override
	protected Entity[] getObservedEntities() {
		return entities;
	}

    
    public void onDelete(@Observes EntityDeleteEvent event) {
		if (!isValidEvent(event)) {
			return;
		}
        
        final EcsbaBreakdownBalance accountParam = (EcsbaBreakdownBalance) event.getTargetInstance();
        OBCriteria<EcsbaAccountingAccounts> criteria = OBDal.getInstance().createCriteria(EcsbaAccountingAccounts.class);
        criteria.add(Restrictions.eq(EcsbaAccountingAccounts.PROPERTY_ECSBABREAKDOWNBALANCE, accountParam));
        criteria.setMaxResults(1);
        
        if (criteria.count() > 0) {
            // Lanzamos la excepción para frenar la transacción
            throw new OBException("No se puede eliminar el registro porque tiene líneas de desglose asociadas");
        }
        
	}
}
