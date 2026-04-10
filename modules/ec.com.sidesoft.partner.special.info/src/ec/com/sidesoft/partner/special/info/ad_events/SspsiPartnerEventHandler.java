package ec.com.sidesoft.partner.special.info.ad_events;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.plm.AttributeSet;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.plm.Attribute;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPartner;

public class SspsiPartnerEventHandler extends EntityPersistenceEventObserver {
  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(BusinessPartner.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final BusinessPartner bp = (BusinessPartner) event.getTargetInstance();

    OBCriteria<ImdlvPartner> bpConfig = OBDal.getInstance().createCriteria(ImdlvPartner.class);
    bpConfig.setMaxResults(1);
    ImdlvPartner config = (ImdlvPartner) bpConfig.uniqueResult();
    if (config != null && bp.getPaymentTerms() == null) {
      final Entity parnertEntity = ModelProvider.getInstance()
          .getEntity(BusinessPartner.ENTITY_NAME);
      final Property parnertTermsProperty = parnertEntity
          .getProperty(BusinessPartner.PROPERTY_PAYMENTTERMS);
      event.setCurrentState(parnertTermsProperty, config.getPaymentterm());
    }

  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

  }

}
