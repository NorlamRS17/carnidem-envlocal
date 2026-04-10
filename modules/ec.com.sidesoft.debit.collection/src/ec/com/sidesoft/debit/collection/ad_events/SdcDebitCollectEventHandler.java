package ec.com.sidesoft.debit.collection.ad_events;

import javax.enterprise.event.Observes;

import org.apache.commons.lang.StringUtils;
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

import ec.com.sidesoft.debit.collection.SdcDebitcollect;

public class SdcDebitCollectEventHandler extends EntityPersistenceEventObserver {
  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(SdcDebitcollect.ENTITY_NAME) };

  ConnectionProvider conn = new DalConnectionProvider(false);
  String language = OBContext.getOBContext().getLanguage().getLanguage();

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SdcDebitcollect head = (SdcDebitcollect) event.getTargetInstance();
    if (head.getStatus().equals("DR") && head.getSdcDcPropocollectList().isEmpty()
        && head.isBulkupload() && (StringUtils.isEmpty(head.getCondition())
            || head.getFINFinancialAccountFile() == null)) {
      throw new OBException("La condición y la Cuenta acreditar son obligatorias");
    }
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SdcDebitcollect head = (SdcDebitcollect) event.getTargetInstance();
    if (head.getStatus().equals("DR") && head.getSdcDcPropocollectList().isEmpty()
        && head.isBulkupload() && (StringUtils.isEmpty(head.getCondition())
            || head.getFINFinancialAccountFile() == null)) {
      throw new OBException("La condición y la Cuenta acreditar son obligatorias");
    }
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SdcDebitcollect head = (SdcDebitcollect) event.getTargetInstance();
    if (head.getStatus().equals("CO") || head.getStatus().equals("P")) {
      throw new OBException(Utility.messageBD(conn, "@CannotDeleteTrx@", language));
    }
  }
}
