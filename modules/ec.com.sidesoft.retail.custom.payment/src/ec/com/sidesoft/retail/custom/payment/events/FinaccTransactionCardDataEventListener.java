package ec.com.sidesoft.retail.custom.payment.events;

import javax.enterprise.event.Observes;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityPersistenceEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.creditcard.reconciliation.SsccrCardsTypes;
import ec.com.sidesoft.creditcard.reconciliation.SsccrProcessorBanck;
import ec.com.sidesoft.creditcard.reconciliation.SsccrTypesOfCredit;

public class FinaccTransactionCardDataEventListener extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(FIN_FinaccTransaction.ENTITY_NAME) };
  protected Logger logger = Logger.getLogger(this.getClass());

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    updateCardData(event);
  }

  private void updateCardData(final EntityPersistenceEvent event) {
    final Entity transactionEntity = ModelProvider.getInstance()
        .getEntity(FIN_FinaccTransaction.ENTITY_NAME);
    FIN_FinaccTransaction finAccTrx = (FIN_FinaccTransaction) event.getTargetInstance();
    final String lot = (String) event
        .getCurrentState(transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_SSCCRLOT));
    final FIN_Payment payment = (FIN_Payment) event
        .getCurrentState(transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_FINPAYMENT));
    if (payment != null) {
      logger.info("FinaccTransactionCardDataEventListener.....lot is null");

      if (payment.getSsposLote() != null) {
        event.setCurrentState(
            transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_SSCCRLOT),
            payment.getSsposLote());
      }
      if (payment.getSsposOwneracc() != null) {
        finAccTrx.setSsccrSsfiBanktransfer(getBankEmisor(payment.getSsposOwneracc()));
        event.setCurrentState(
            transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_SSCCRSSFIBANKTRANSFER),
            payment.getEcscapBanktransfer());
      }
      if (payment.getSSPOSOwnerAccount() != null) {
        event.setCurrentState(
            transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_SSCCRPROCESSORBANCK),
            getBankProcesador(payment.getSSPOSOwnerAccount()));
      }
      if (payment.getSrcpTarjeta() != null) {
        event.setCurrentState(
            transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_SSCCRCARDSTYPES),
            getTarjeta(payment.getSrcpTarjeta()));
      }

      if (payment.getSrcpTypecredit() != null) {
        event.setCurrentState(
            transactionEntity.getProperty(FIN_FinaccTransaction.PROPERTY_SSCCRTYPESOFCREDIT),
            getTypeCredit(payment.getSrcpTypecredit()));
      }

    }
  }

  private ssfiBanktransfer getBankEmisor(String ssposOwneracc) {
    OBCriteria<ssfiBanktransfer> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(ssfiBanktransfer.class);
    finAccTransactionCriteria
        .add(Restrictions.eq(ssfiBanktransfer.PROPERTY_COMMERCIALNAME, ssposOwneracc));
    finAccTransactionCriteria.setMaxResults(1);
    return (ssfiBanktransfer) finAccTransactionCriteria.uniqueResult();
  }

  private SsccrProcessorBanck getBankProcesador(String ssposOwneracc2) {
    OBCriteria<SsccrProcessorBanck> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(SsccrProcessorBanck.class);
    finAccTransactionCriteria
        .add(Restrictions.eq(SsccrProcessorBanck.PROPERTY_NAME, ssposOwneracc2));
    finAccTransactionCriteria.setMaxResults(1);
    return (SsccrProcessorBanck) finAccTransactionCriteria.uniqueResult();
  }

  private SsccrTypesOfCredit getTypeCredit(String typeCredit) {
    OBCriteria<SsccrTypesOfCredit> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(SsccrTypesOfCredit.class);
    finAccTransactionCriteria.add(Restrictions.eq(SsccrTypesOfCredit.PROPERTY_NAME, typeCredit));
    finAccTransactionCriteria.setMaxResults(1);
    return (SsccrTypesOfCredit) finAccTransactionCriteria.uniqueResult();
  }

  private SsccrCardsTypes getTarjeta(String tarjeta) {
    OBCriteria<SsccrCardsTypes> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(SsccrCardsTypes.class);
    finAccTransactionCriteria.add(Restrictions.eq(SsccrCardsTypes.PROPERTY_NAME, tarjeta));
    finAccTransactionCriteria.setMaxResults(1);
    return (SsccrCardsTypes) finAccTransactionCriteria.uniqueResult();
  }
}
