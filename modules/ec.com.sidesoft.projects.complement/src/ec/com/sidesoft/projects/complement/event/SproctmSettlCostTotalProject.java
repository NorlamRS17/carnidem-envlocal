package ec.com.sidesoft.projects.complement.event;

import javax.enterprise.event.Observes;
import javax.servlet.ServletException;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.projects.complement.SproctmSettlCostLn;

public class SproctmSettlCostTotalProject extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(SproctmSettlCostLn.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final SproctmSettlCostLn lineSproctmSettlCostLn = (SproctmSettlCostLn) event
        .getTargetInstance();

    ReturnQuery(lineSproctmSettlCostLn);

  }

  public void onUpdate(@Observes EntityUpdateEvent event) throws ServletException {
    if (!isValidEvent(event)) {
      return;
    }

    final SproctmSettlCostLn lineSproctmSettlCostLn = (SproctmSettlCostLn) event
        .getTargetInstance();

    ReturnQuery(lineSproctmSettlCostLn);
  }

  private void ReturnQuery(SproctmSettlCostLn StrSproctmSettlCostLn) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    // String vSettlementCost = StrSproctmSettlCostLn.getSproctmSettlementCost().getId();
    String vSproctmDetailCost = (StrSproctmSettlCostLn.getSproctmDetailCost() == null) ? null
        : StrSproctmSettlCostLn.getSproctmDetailCost().getId().toString();
    if (vSproctmDetailCost == null) {
      throw new OBException(Utility.messageBD(conn,
          "Se requiere el detalle de la liquidación de costo del proyecto.", language));
    }

  }

}
