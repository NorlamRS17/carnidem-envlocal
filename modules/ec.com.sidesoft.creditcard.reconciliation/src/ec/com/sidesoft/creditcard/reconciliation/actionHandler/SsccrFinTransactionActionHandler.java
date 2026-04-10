package ec.com.sidesoft.creditcard.reconciliation.actionHandler;

import java.math.BigDecimal;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;

import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRec;
import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRecLine;
import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRecSum;

public class SsccrFinTransactionActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    JSONObject response = new JSONObject();

    try {
      OBContext.setAdminMode(true);
    	
      final JSONObject jsonData = new JSONObject(data);
      final String id = jsonData.getString("id");
      String type = "";
      BigDecimal deposit = new BigDecimal("0");
      BigDecimal deposit2 = new BigDecimal("0");
      boolean hasTransaction = true;

      // Obtenemos la oportunidad
      FIN_FinaccTransaction transaction = OBDal.getInstance().get(FIN_FinaccTransaction.class, id);

      if (transaction.getSsccrRecSumLine() != null) {
        hasTransaction = false;
        SsccrPosCardRecLine line = OBDal.getInstance().get(SsccrPosCardRecLine.class,
            transaction.getSsccrRecSumLine().trim());
        type = line.getType();
        if (transaction.getTransactionType().equals("BPD") && !type.equals("B")
            && line.getDepositAmount().compareTo(transaction.getDepositAmount()) != 0) {
          line.setDepositAmount(transaction.getDepositAmount());
        }
        if (transaction.getTransactionType().equals("BPW") && !type.equals("B")
            && line.getDepositAmount().compareTo(transaction.getPaymentAmount()) != 0) {
          line.setDepositAmount(transaction.getPaymentAmount());
        }
      } else {
        OBCriteria<FIN_FinaccTransaction> transactionList = OBDal.getInstance()
            .createCriteria(FIN_FinaccTransaction.class);
        transactionList.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_SSCCRRECONCILIATIONNO,
            transaction.getSsccrReconciliationNo()));
        transactionList
            .add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_ACCOUNT, transaction.getAccount()));
        transactionList.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_TRANSACTIONTYPE,
            transaction.getTransactionType()));
        for (FIN_FinaccTransaction transactionline : transactionList.list()) {
          if (transactionline.getTransactionType().equals("BPD")) {
            deposit2 = deposit2.add(transactionline.getDepositAmount());
          }
          if (transactionline.getTransactionType().equals("BPW")) {
            deposit2 = deposit2.add(transactionline.getPaymentAmount());
          }
        }
      }

      OBCriteria<SsccrPosCardRec> posCardRecList = OBDal.getInstance()
          .createCriteria(SsccrPosCardRec.class);
      posCardRecList.add(Restrictions.eq(SsccrPosCardRec.PROPERTY_DOCUMENTNO,
          transaction.getSsccrReconciliationNo()));
      SsccrPosCardRec posCardRec;
      if (posCardRecList.list().size() > 0) {
        posCardRec = posCardRecList.list().get(0);
        for (SsccrPosCardRecLine posCardLine : posCardRec.getSsccrPosCardRecLineList()) {
          if (posCardLine.getType().equals(type) && !posCardLine.getType().equals("B")) {
            deposit = deposit.add(posCardLine.getDepositAmount());
          }
        }

        for (SsccrPosCardRecSum posCardRecSum : posCardRec.getSsccrPosCardRecSumList()) {
          if (posCardRecSum.getWarehouseRuleType().equals(type)
              && !posCardRecSum.getWarehouseRuleType().equals("B")) {

            if (deposit.compareTo(BigDecimal.ZERO) != 0) {
              posCardRecSum.setDepositAmount(deposit);
            }
          }
          if (posCardRecSum.getWarehouseRuleType().equals("B")
              && transaction.getSscccinReference() != null) {
            posCardRecSum.setConfirmationNo(transaction.getSscccinReference());
            transaction.setDescription(transaction.getSscccinReference() + " "
                + posCardRecSum.getProcessorBanck().getName());

            if (transaction.getTransactionType().equals("BPD") && !hasTransaction) {
              posCardRecSum.setDepositAmount(transaction.getDepositAmount());
            }
            if (transaction.getTransactionType().equals("BPD") && hasTransaction) {
              posCardRecSum.setDepositAmount(deposit2);
            }
          }
        }
      }

      response.put("status", "OK");
    } catch (Exception e) {
      System.out.println("UpdateReferenceActionHandler: " + e.getMessage());
      try {
        response.put("status", "ERROR");
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    } finally {
    	OBContext.restorePreviousMode();;
        return response;
    }
    
  }
}
