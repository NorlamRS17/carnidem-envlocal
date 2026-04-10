package com.sidesoft.settlement.project.cost.event;

import java.math.BigDecimal;
import java.util.List;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.financialmgmt.tax.TaxRate;

import ec.com.sidesoft.settlement.project.cost.ConsumptionLine;
import ec.com.sidesoft.settlement.project.cost.LiquidationProjects;

public class Sstpc_ValidateConsumptionEvent extends EntityPersistenceEventObserver {

  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  public TaxRate taxRate;
  public String successMessage = null;
  public ConfigParameters cf;
  public String language;
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      ConsumptionLine.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final ConsumptionLine SstpcConsumption = (ConsumptionLine) event.getTargetInstance();

    String StrConsumptionID = SstpcConsumption.getSstpcLiquidationProjects().getId().toString();

    LiquidationProjects SstpcLiqProj = OBDal.getInstance().get(LiquidationProjects.class,
        StrConsumptionID);

    if (SstpcLiqProj.getDocstatuslist().equals("LQ")) {
      throw new OBException("No se puede eliminar las líneas de Consumos en estado liquidado");
    }

    OBCriteria<ConsumptionLine> ObjConsumption = OBDal.getInstance().createCriteria(
        ConsumptionLine.class);
    ObjConsumption.add(Restrictions.eq(ConsumptionLine.PROPERTY_SSTPCLIQUIDATIONPROJECTS,
        SstpcLiqProj));
    ObjConsumption.add(Restrictions.ne(ConsumptionLine.PROPERTY_ID, SstpcConsumption.getId()));
    if (ObjConsumption.count() > 0) {
      List<ConsumptionLine> ltsConsumtion = ObjConsumption.list();
      double bgdAcum = 0;
      for (ConsumptionLine collConsumption : ltsConsumtion) {

        double dbl = Double.valueOf(collConsumption.getCostconsumption().toString());
        bgdAcum = bgdAcum + dbl;
      }

      SstpcLiqProj.setTotalCost(new BigDecimal(bgdAcum));
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();
    } else if (ObjConsumption.count() == 0) {

      SstpcLiqProj.setTotalCost(BigDecimal.ZERO);
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();

    }

  }

}
