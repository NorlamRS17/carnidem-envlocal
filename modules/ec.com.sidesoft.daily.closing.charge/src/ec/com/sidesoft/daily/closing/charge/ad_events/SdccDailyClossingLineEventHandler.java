package ec.com.sidesoft.daily.closing.charge.ad_events;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.erpCommon.utility.OBMessageUtils;

import ec.com.sidesoft.daily.closing.charge.Sdcc_DailyClossingLine;

public class SdccDailyClossingLineEventHandler extends EntityPersistenceEventObserver {
  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(Sdcc_DailyClossingLine.ENTITY_NAME) };

  // ConnectionProvider conn = new DalConnectionProvider(false);
  // String language = OBContext.getOBContext().getLanguage().getLanguage();

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
    final Sdcc_DailyClossingLine line = (Sdcc_DailyClossingLine) event.getTargetInstance();
    if (line.getSdccDailyClossing().getAlertStatus().equals("CO")) {
      String msg = OBMessageUtils.translateError("@CannotDeleteTrx@").getMessage();
      throw new OBException(msg);
      // throw new OBException(Utility.messageBD(conn, language));

    }
  }
}
