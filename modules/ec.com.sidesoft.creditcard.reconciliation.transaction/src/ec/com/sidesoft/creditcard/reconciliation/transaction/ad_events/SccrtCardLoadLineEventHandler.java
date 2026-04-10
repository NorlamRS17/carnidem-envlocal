package ec.com.sidesoft.creditcard.reconciliation.transaction.ad_events;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.erpCommon.utility.OBMessageUtils;

import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadLine;
import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadTransaction;

public class SccrtCardLoadLineEventHandler extends EntityPersistenceEventObserver {
  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(SccrtCardLoadLine.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SccrtCardLoadLine line = (SccrtCardLoadLine) event.getTargetInstance();
    SccrtCardLoadTransaction head = line.getSccrtCardLoadTransaction();
    
    Boolean Validator  = false;
    for (SccrtCardLoadLine  obj :  head.getSccrtCardLoadLineList() ) {
    	if(obj.isProcessed()) {
    		Validator = true;
    	}
    }
    
    if ( (head != null && head.getDocumentStatus().equals("CO")) || Validator) {
      throw new OBException(OBMessageUtils.messageBD("@SCCRT_CannotDeleteTrx@"));
    }
  }
}
