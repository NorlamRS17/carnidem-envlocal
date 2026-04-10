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
import org.openbravo.model.financialmgmt.gl.GLItemAccounts;
import org.openbravo.service.db.DalConnectionProvider;

public class SsavGLItemAccountsEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(GLItemAccounts.ENTITY_NAME) };
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

    final GLItemAccounts glitemAccounts = (GLItemAccounts) event.getTargetInstance();

    ReturnQuery(glitemAccounts);

  }

  public void onUpdate(@Observes EntityUpdateEvent event) throws ServletException {
    if (!isValidEvent(event)) {
      return;
    }

    final GLItemAccounts glitemAccounts = (GLItemAccounts) event.getTargetInstance();

    ReturnQuery(glitemAccounts);
  }

  private void ReturnQuery(GLItemAccounts glitemAccounts) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ElementValue elementValueDebit = glitemAccounts.getGlitemDebitAcct() != null
        ? glitemAccounts.getGlitemDebitAcct().getAccount()
        : null;

	if (elementValueDebit != null) {
		// Debit account
		try {
			OBContext.setAdminMode(true);
			OBCriteria<ElementValue> obc = OBDal.getInstance().createCriteria(ElementValue.class);
			obc.add(Restrictions.eq(ElementValue.PROPERTY_ID, elementValueDebit.getId()));
			obc.setMaxResults(1);
			elementValueEntyti = (ElementValue) obc.uniqueResult();
			if (elementValueEntyti != null) {
				if (elementValueEntyti.isSsavIsmodule() == true) {
					throw new OBException(Utility.messageBD(conn,
							"No puede utilizar cuentas de módulo para Conceptos Contables.", language));
				}

			}
		} finally {
			OBContext.restorePreviousMode();
		}
	}

    ElementValue elementValueCredit = glitemAccounts.getGlitemCreditAcct() != null
        ? glitemAccounts.getGlitemCreditAcct().getAccount()
        : null;
    
	if (elementValueCredit != null) {
		try {
			// Credit Account
			OBContext.setAdminMode(true);
			OBCriteria<ElementValue> obcCr = OBDal.getInstance().createCriteria(ElementValue.class);
			obcCr.add(Restrictions.eq(ElementValue.PROPERTY_ID, elementValueCredit.getId()));
			obcCr.setMaxResults(1);
			elementValueEntyti = (ElementValue) obcCr.uniqueResult();
			if (elementValueEntyti != null) {
				if (elementValueEntyti.isSsavIsmodule()) {
					throw new OBException(Utility.messageBD(conn,
							"No puede utilizar cuentas de módulo para Conceptos Contables.", language));
				}

			}
		} finally {
			OBContext.restorePreviousMode();
		}
	}

  }

}
