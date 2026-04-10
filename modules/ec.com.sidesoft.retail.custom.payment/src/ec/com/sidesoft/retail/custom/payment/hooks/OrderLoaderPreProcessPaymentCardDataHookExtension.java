package ec.com.sidesoft.retail.custom.payment.hooks;

import javax.enterprise.context.ApplicationScoped;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.retail.posterminal.OrderLoaderPreProcessPaymentHook;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.creditcard.reconciliation.SsccrCardsTypes;
import ec.com.sidesoft.creditcard.reconciliation.SsccrProcessorBanck;
import ec.com.sidesoft.creditcard.reconciliation.SsccrTypesOfCredit;

@ApplicationScoped
public class OrderLoaderPreProcessPaymentCardDataHookExtension
    extends OrderLoaderPreProcessPaymentHook {

  @Override
  public void exec(JSONObject jsonorder, Order order, JSONObject jsonpayment, FIN_Payment payment)
      throws Exception {
    if (jsonpayment.has("paymentData")) {

      try {

        // Obtener datos de los metodos de pago
        JSONObject jsonPayment = jsonpayment.getJSONObject("paymentData");

        String typeCreditId = "", ownerAccount2Id = null, tarjetaId = "", bancoEmisorId = "";

        try {
          typeCreditId = jsonPayment.getString("TypeCredit") == null ? ""
              : jsonPayment.getString("TypeCredit");
          ownerAccount2Id = jsonPayment.getString("BancoProcesador") == null ? ""
              : jsonPayment.getString("BancoProcesador");
          tarjetaId = jsonPayment.getString("Tarjeta") == null ? ""
              : jsonPayment.getString("Tarjeta");
          bancoEmisorId = jsonPayment.getString("POwner") == null ? ""
              : jsonPayment.getString("POwner");
        } catch (Exception e) {
        }
        SsccrTypesOfCredit typeCredit = getTypeCredit(typeCreditId);
        SsccrProcessorBanck processorBank = getBankProcesador(ownerAccount2Id);
        SsccrCardsTypes tarjeta = getTarjeta(tarjetaId);
        ssfiBanktransfer bancoEmisor = getBankEmisor(bancoEmisorId);

        payment.setSrcpTypecredit(typeCredit.getName());
        payment.setSSPOSOwnerAccount(processorBank.getName());
        payment.setSrcpTarjeta(tarjeta.getName());
        payment.setEcscapBanktransfer(bancoEmisor);

      } catch (Exception e) {
      }
    }

  }

  private SsccrTypesOfCredit getTypeCredit(String typeCreditId) {
    System.out.println("typeCreditId :: " + typeCreditId);
    OBCriteria<SsccrTypesOfCredit> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(SsccrTypesOfCredit.class);
    finAccTransactionCriteria.add(Restrictions.eq(SsccrTypesOfCredit.PROPERTY_ID, typeCreditId));
    finAccTransactionCriteria.setMaxResults(1);
    return (SsccrTypesOfCredit) finAccTransactionCriteria.uniqueResult();
  }

  private SsccrProcessorBanck getBankProcesador(String ssposOwneracc2) {
    OBCriteria<SsccrProcessorBanck> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(SsccrProcessorBanck.class);
    finAccTransactionCriteria.add(Restrictions.eq(SsccrProcessorBanck.PROPERTY_ID, ssposOwneracc2));
    finAccTransactionCriteria.setMaxResults(1);
    return (SsccrProcessorBanck) finAccTransactionCriteria.uniqueResult();
  }

  private ssfiBanktransfer getBankEmisor(String ssposOwneracc) {
    OBCriteria<ssfiBanktransfer> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(ssfiBanktransfer.class);
    finAccTransactionCriteria.add(Restrictions.eq(ssfiBanktransfer.PROPERTY_ID, ssposOwneracc));
    finAccTransactionCriteria.setMaxResults(1);
    return (ssfiBanktransfer) finAccTransactionCriteria.uniqueResult();
  }

  private SsccrCardsTypes getTarjeta(String tarjeta) {
    OBCriteria<SsccrCardsTypes> finAccTransactionCriteria = OBDal.getInstance()
        .createCriteria(SsccrCardsTypes.class);
    finAccTransactionCriteria.add(Restrictions.eq(SsccrCardsTypes.PROPERTY_ID, tarjeta));
    finAccTransactionCriteria.setMaxResults(1);
    return (SsccrCardsTypes) finAccTransactionCriteria.uniqueResult();
  }

}
