package ec.com.sidesoft.email.event;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.erpCommon.utility.OBMessageUtils;

import ec.com.sidesoft.email.AemCondition;
import ec.com.sidesoft.email.AemEmailQueue;
import ec.com.sidesoft.email.AemTemplateVariable;

@ApplicationScoped
public class EmailQueueEventHandler extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(AemTemplateVariable.ENTITY_NAME),
      ModelProvider.getInstance().getEntity(AemCondition.ENTITY_NAME) };
  private static final String STATUS_DRAFT = "DR";
  private static final String MSG_ALREADY_POSTED = "AlreadyPosted";

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event))
      return;
    validateParentStatus(event);
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event))
      return;
    validateParentStatus(event);
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    validateParentStatus(event);
  }

  /**
   * Método privado centralizado para validar el estado del padre. Evita duplicidad de código y
   * reduce puntos de fallo.
   */
  private void validateParentStatus(EntityPersistenceEvent event) {
    BaseOBObject bob = event.getTargetInstance();
    String currentStatus = null;

    if (bob instanceof AemTemplateVariable) {
      AemEmailQueue header = ((AemTemplateVariable) bob).getAEMEmailQueue();
      if (header != null)
        currentStatus = header.getAlertStatus();

    } else if (bob instanceof AemCondition) {
      AemEmailQueue header = ((AemCondition) bob).getAEMEmailQueue();
      if (header != null)
        currentStatus = header.getAlertStatus();

    }

    if (currentStatus != null && !STATUS_DRAFT.equals(currentStatus)) {
      String message = OBMessageUtils.messageBD(MSG_ALREADY_POSTED);
      throw new OBException(message);
    }
  }

}