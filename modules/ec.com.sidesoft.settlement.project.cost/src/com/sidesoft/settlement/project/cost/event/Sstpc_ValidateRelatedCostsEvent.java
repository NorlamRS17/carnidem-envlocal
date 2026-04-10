package com.sidesoft.settlement.project.cost.event;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;

import ec.com.sidesoft.settlement.project.cost.LiquidationProjects;
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedCosts;

public class Sstpc_ValidateRelatedCostsEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(SstpcRelatedCosts.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SstpcRelatedCosts sstpcRelatedCost = (SstpcRelatedCosts) event.getTargetInstance();
    validateRow(sstpcRelatedCost);
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SstpcRelatedCosts sstpcRelatedCost = (SstpcRelatedCosts) event.getTargetInstance();
    validateRow(sstpcRelatedCost);
  }

  public void validateRow(SstpcRelatedCosts sstpcRelatedCost) {
    String StrConsumptionID = sstpcRelatedCost.getSstpcLiquidationProjects().getId().toString();

    LiquidationProjects SstpcLiqProj = OBDal.getInstance().get(LiquidationProjects.class,
        StrConsumptionID);

    if (SstpcLiqProj.getDocstatuslist().equals("LQ")) {
      throw new OBException(
          "No se puede eliminar/insertar las líneas de Costos Relacionados, porque el documento esta en estado liquidado");
    }

    OBCriteria<SstpcRelatedCosts> ObjRelatedCost = OBDal.getInstance()
        .createCriteria(SstpcRelatedCosts.class);
    ObjRelatedCost
        .add(Restrictions.eq(SstpcRelatedCosts.PROPERTY_SSTPCLIQUIDATIONPROJECTS, SstpcLiqProj));
    ObjRelatedCost.add(Restrictions.ne(SstpcRelatedCosts.PROPERTY_ID, SstpcLiqProj.getId()));
    if (ObjRelatedCost.count() > 0) {
      List<SstpcRelatedCosts> ltsConsumtion = ObjRelatedCost.list();
      double bgdAcum = 0;
      for (SstpcRelatedCosts collConsumption : ltsConsumtion) {

        double dbl = Double.valueOf(collConsumption.getAmount().toString());
        bgdAcum = bgdAcum + dbl;
      }

      SstpcLiqProj.setCostTotal(new BigDecimal(bgdAcum));
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();
    } else if (ObjRelatedCost.count() == 0) {

      SstpcLiqProj.setCostTotal(BigDecimal.ZERO);
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();

    }

  }

}
