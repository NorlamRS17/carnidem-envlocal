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
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedRevenue;

public class Sstpc_ValidateRelatedRevenueEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(SstpcRelatedRevenue.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SstpcRelatedRevenue sstpcRaletedRevenue = (SstpcRelatedRevenue) event.getTargetInstance();
    validateRow(sstpcRaletedRevenue);
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final SstpcRelatedRevenue sstpcRaletedRevenue = (SstpcRelatedRevenue) event.getTargetInstance();
    validateRow(sstpcRaletedRevenue);
  }

  public void validateRow(SstpcRelatedRevenue sstpcRaletedRevenue) {
    String StrConsumptionID = sstpcRaletedRevenue.getLiquidationProjects().getId().toString();

    LiquidationProjects SstpcLiqProj = OBDal.getInstance().get(LiquidationProjects.class,
        StrConsumptionID);

    if (SstpcLiqProj.getDocstatuslist().equals("LQ")) {
      throw new OBException(
          "No se puede eliminar/insertar las líneas de Ingresos Relacionados, porque el documento esta en estado liquidado");
    }

    OBCriteria<SstpcRelatedRevenue> ObjRelatedRevenue = OBDal.getInstance()
        .createCriteria(SstpcRelatedRevenue.class);
    ObjRelatedRevenue
        .add(Restrictions.eq(SstpcRelatedRevenue.PROPERTY_LIQUIDATIONPROJECTS, SstpcLiqProj));
    ObjRelatedRevenue.add(Restrictions.ne(SstpcRelatedRevenue.PROPERTY_ID, SstpcLiqProj.getId()));
    if (ObjRelatedRevenue.count() > 0) {
      List<SstpcRelatedRevenue> ltsConsumtion = ObjRelatedRevenue.list();
      double bgdAcum = 0;
      for (SstpcRelatedRevenue collConsumption : ltsConsumtion) {

        double dbl = Double.valueOf(collConsumption.getAmount().toString());
        bgdAcum = bgdAcum + dbl;
      }

      SstpcLiqProj.setTotalPaymentin(new BigDecimal(bgdAcum));
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();
    } else if (ObjRelatedRevenue.count() == 0) {

      SstpcLiqProj.setTotalPaymentin(BigDecimal.ZERO);
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();

    }

  }

}
