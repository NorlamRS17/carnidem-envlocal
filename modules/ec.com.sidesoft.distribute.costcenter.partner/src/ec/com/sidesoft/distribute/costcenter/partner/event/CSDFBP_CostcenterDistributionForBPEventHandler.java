package ec.com.sidesoft.distribute.costcenter.partner.event;

import java.math.BigDecimal;
import java.util.List;

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
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.distribute.costcenter.partner.CSDFBP_CostcenterDistributionForBP;

public class CSDFBP_CostcenterDistributionForBPEventHandler extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(CSDFBP_CostcenterDistributionForBP.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final CSDFBP_CostcenterDistributionForBP costCenterDistXBP = (CSDFBP_CostcenterDistributionForBP) event
        .getTargetInstance();
    checkPercentage(costCenterDistXBP, true);
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final CSDFBP_CostcenterDistributionForBP costCenterDistXBP = (CSDFBP_CostcenterDistributionForBP) event
        .getTargetInstance();
    checkPercentage(costCenterDistXBP, false);
  }

  private void checkPercentage(final CSDFBP_CostcenterDistributionForBP costCenterDistXBP,
      boolean isNew) {
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);

    OBCriteria<CSDFBP_CostcenterDistributionForBP> costCenterDistPercentage = OBDal.getInstance()
        .createCriteria(CSDFBP_CostcenterDistributionForBP.class);

    costCenterDistPercentage
        .add(Restrictions.eq(CSDFBP_CostcenterDistributionForBP.PROPERTY_BUSINESSPARTNER,
            costCenterDistXBP.getBusinessPartner()));
    costCenterDistPercentage
        .add(Restrictions.eq(CSDFBP_CostcenterDistributionForBP.PROPERTY_ACTIVE, true));
    List<CSDFBP_CostcenterDistributionForBP> costCenterDistPercentageList = costCenterDistPercentage
        .list();

    
    BigDecimal percentageSum = BigDecimal.ZERO;
     for (CSDFBP_CostcenterDistributionForBP csdfbp_CostcenterDistributionForBP : costCenterDistPercentageList) {
    	 percentageSum = percentageSum.add(csdfbp_CostcenterDistributionForBP.getPercentage());
	}
//    costCenterDistXBP.getPercentage().compareTo(new BigDecimal("100"));
//    
//    
//    if (isNew) {
//      percentageSum = percentageSum.add(costCenterDistXBP.getPercentage());
//    }

    if (percentageSum.compareTo(new BigDecimal(100)) > 0) {
      throw new OBException(Utility.messageBD(conn, "@csdfbp_porcDistNotAllowed@", language));
    }
 }

}
