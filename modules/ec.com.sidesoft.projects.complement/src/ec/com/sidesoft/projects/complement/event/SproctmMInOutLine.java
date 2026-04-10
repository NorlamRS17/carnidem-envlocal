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
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.service.db.DalConnectionProvider;

public class SproctmMInOutLine extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(ShipmentInOutLine.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final ShipmentInOutLine lineOutInoutLine = (ShipmentInOutLine) event.getTargetInstance();

    ReturnQuery(lineOutInoutLine);

  }

  public void onUpdate(@Observes EntityUpdateEvent event) throws ServletException {
    if (!isValidEvent(event)) {
      return;
    }

    final ShipmentInOutLine lineOutInoutLine = (ShipmentInOutLine) event.getTargetInstance();

    ReturnQuery(lineOutInoutLine);
  }

  private void ReturnQuery(ShipmentInOutLine StrOutInoutLine) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    String v_project_header = (String) ((StrOutInoutLine.getShipmentReceipt().getProject() == null)
        ? null
        : StrOutInoutLine.getShipmentReceipt().getProject().getId().toString());

    if (v_project_header != null) {
      if (StrOutInoutLine.getProject() == null || StrOutInoutLine.getSproctmCProjectphase() == null
          || StrOutInoutLine.getSproctmCProjecttask() == null) {
        throw new OBException(Utility.messageBD(conn,
            "Revise la configuración de: Proyecto - Fase - Tarea.", language));

      }
    }

  }

}
