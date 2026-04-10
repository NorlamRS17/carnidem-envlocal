package ec.com.sidesoft.projects.complement.event;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.service.db.DalConnectionProvider;

public class SproctmProjectPhaseValEvent extends EntityPersistenceEventObserver {
  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(ProjectPhase.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final ProjectPhase pphase = (ProjectPhase) event.getTargetInstance();
    ReturnQuery(pphase);

  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final ProjectPhase pphase = (ProjectPhase) event.getTargetInstance();
    ReturnQuery(pphase);

  }

  private void ReturnQuery(ProjectPhase pphase) {

    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();

    if (pphase != null && pphase.getSproctmPrhasetype() != null
        && (pphase.getSproctmPrhasetype().equals("E")
            || pphase.getSproctmPrhasetype().equals("C"))) {
      // Verificar si existen ya registradas fases de tipo ejecucion o cotizacion
      OBContext.setAdminMode(true);
      OBCriteria<ProjectPhase> obc = OBDal.getInstance().createCriteria(ProjectPhase.class);
      obc.add(Restrictions.eq(ProjectPhase.PROPERTY_PROJECT, pphase.getProject()));
      obc.add(
          Restrictions.eq(ProjectPhase.PROPERTY_SPROCTMPRHASETYPE, pphase.getSproctmPrhasetype()));
      obc.setFilterOnReadableOrganization(false);
      obc.setMaxResults(1);
      OBContext.setAdminMode(false);
      ProjectPhase phase_row = (ProjectPhase) obc.uniqueResult();
      if (phase_row != null && (phase_row.getId() != pphase.getId())) {
        String tipe_phase = pphase.getSproctmPrhasetype().equals("E") ? "Ejecución" : "Cotización";
        throw new OBException(
            Utility.messageBD(conn, "En el proyecto :" + pphase.getProject().getName().toString()
                + " ya existe una fase de tipo: " + tipe_phase, language));
      }
    }

  }

}
