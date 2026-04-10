package ec.com.sidesoft.subaccount.validation;

import javax.enterprise.event.Observes;
import javax.servlet.ServletException;

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
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.service.db.DalConnectionProvider;

public class SsavGlJournalEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(GLJournalLine.ENTITY_NAME) };
  private ElementValue elementValueEntyti;

  @Override
  protected Entity[] getObservedEntities() {
    // TODO Auto-generated method stub
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final GLJournalLine glJournalLn = (GLJournalLine) event.getTargetInstance();

    ReturnQuery(glJournalLn);

  }

  public void onUpdate(@Observes EntityUpdateEvent event) throws ServletException {
    if (!isValidEvent(event)) {
      return;
    }

    final GLJournalLine glJournalLn = (GLJournalLine) event.getTargetInstance();

    ReturnQuery(glJournalLn);
  }

  private void ReturnQuery(GLJournalLine glJournalLn) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ElementValue elementValue = glJournalLn.getAccountingCombination() != null
        ? glJournalLn.getAccountingCombination().getAccount()
        : null;

    if (elementValue != null) {

      OBContext.setAdminMode(true);
      OBCriteria<ElementValue> obc = OBDal.getInstance().createCriteria(ElementValue.class);
      obc.add(Restrictions.eq(ElementValue.PROPERTY_ID, elementValue.getId()));
      obc.setMaxResults(1);
      OBContext.setAdminMode(false);
      elementValueEntyti = (ElementValue) obc.uniqueResult();
      if (elementValueEntyti != null) {
        if (elementValueEntyti.isSsavIsmodule() == true) {
          throw new OBException(Utility.messageBD(conn,
              "No puede utilizar cuentas de módulo en asientos manuales.", language));
        }

      }

    }

  }

}
