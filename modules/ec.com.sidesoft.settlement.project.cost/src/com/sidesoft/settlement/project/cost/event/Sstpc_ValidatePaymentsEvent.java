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

import ec.com.sidesoft.settlement.project.cost.LiquidationProjects;
import ec.com.sidesoft.settlement.project.cost.PaymentLiquidationProject;

public class Sstpc_ValidatePaymentsEvent extends EntityPersistenceEventObserver {

  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  public TaxRate taxRate;
  public String successMessage = null;
  public ConfigParameters cf;
  public String language;
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      PaymentLiquidationProject.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final PaymentLiquidationProject SstpcPayment = (PaymentLiquidationProject) event
        .getTargetInstance();

    String StrPaymentID = SstpcPayment.getSstpcLiquidationProjects().getId().toString();

    LiquidationProjects SstpcLiqProj = OBDal.getInstance().get(LiquidationProjects.class,
        StrPaymentID);

    if (SstpcLiqProj.getDocstatuslist().equals("LQ")) {
      throw new OBException("No se puede eliminar las líneas de pago en estado liquidado");
    }

    OBCriteria<PaymentLiquidationProject> ObjPayments = OBDal.getInstance().createCriteria(
        PaymentLiquidationProject.class);
    ObjPayments.add(Restrictions.eq(PaymentLiquidationProject.PROPERTY_SSTPCLIQUIDATIONPROJECTS,
        SstpcLiqProj));
    ObjPayments.add(Restrictions.ne(PaymentLiquidationProject.PROPERTY_ID, SstpcPayment.getId()));
    if (ObjPayments.count() > 0) {
      List<PaymentLiquidationProject> ltsPayments = ObjPayments.list();
      double bgdAcum = 0;
      for (PaymentLiquidationProject collConsumption : ltsPayments) {

        double dbl = Double.valueOf(collConsumption.getAmount().toString());
        double dbl2 = Double.valueOf(collConsumption.getIsadvanced().toString());
        bgdAcum = bgdAcum + dbl + dbl2;
      }

      SstpcLiqProj.setTotalPay(new BigDecimal(bgdAcum));
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();
    } else if (ObjPayments.count() == 0) {

      SstpcLiqProj.setTotalPay(BigDecimal.ZERO);
      OBDal.getInstance().save(SstpcLiqProj);
      OBDal.getInstance().flush();

    }
  }

}
