package ec.com.sidesoft.debit.collection.ad_process;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.advpaymentmngt.process.FIN_PaymentProcess;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.debit.collection.SdcDebitcollect;
import ec.com.sidesoft.debit.collection.utils.SDC_Helper;

public class SdcGeneratePayments extends DalBaseProcess {
  private final Logger logger = Logger.getLogger(SdcGeneratePayments.class);
  private String msgError = "";

  @Override
  public void doExecute(ProcessBundle bundle) throws Exception {
    OBError msg = new OBError();
    msg.setType("Success");
    msg.setTitle(OBMessageUtils.messageBD("Success"));
    StringBuilder sb = new StringBuilder();
    String ref = "";
    // Parametros
    final String recordId = (String) bundle.getParams().get("SDC_Debitcollect_ID");
    SdcDebitcollect head = OBDal.getInstance().get(SdcDebitcollect.class, recordId);
    List<String> references = head.getTypeload().equals("RPH")
        ? getDetailReferenceReconcile(head.getId())
        : getReferenceReconcile(head.getId());

    for (String reference : references) {
      ref = reference;
      List<String> psdid = head.getTypeload().equals("RPH")
          ? getReferenceScheduleDetail(head.getId(), reference)
          : getReferenceSchedule(head.getId(), reference);
      try {
        msgError = generatePayment(head, psdid, reference);
      } finally {
        // TODO: handle finally clause
        logger.error("Exception found in SdcGeneratePayments process: " + msgError);
      }
    }

    if (msgError.toLowerCase().contains("error")) {
      msg.setTitle(OBMessageUtils.messageBD("Error"));
      msg.setType("Error");
      msgError = "Revisar en las lineas no cobradas el detalle de error.";
    }
    validPayment(head.getId());

    msg.setMessage(msgError);
    bundle.setResult(msg);

  }

  public String generatePayment(SdcDebitcollect head, List<String> lines, String referenceNo)
      throws Exception {
    String message = "";
    String statusPayment = "";
    String msgFinal = "";
    boolean continueProcess = true;
    boolean saveStatus = true;

    try {
      OBContext.setAdminMode(true);

      // Obtenemos la secuencia del documento del cobro
      String strPaymentDocumentNo = FIN_Utility.getDocumentNo(head.getDocumentType(),
          "FIN_Payment");

      // Obtenemoms las lineas del plan de pagos conciliados
      List<FIN_PaymentScheduleDetail> psds = getPaymentScheduleDetails(lines);
      FIN_PaymentSchedule ps = OBDal.getInstance().get(FIN_PaymentSchedule.class,
          psds.get(0).getInvoicePaymentSchedule().getId());
      Invoice inv = ps.getInvoice();
      BusinessPartner bp = inv.getBusinessPartner();
      FIN_Payment payment = null;
      // Generamos la cabecera del cobro
      try {
        payment = (new AdvPaymentMngtDao()).getNewPayment(true, head.getOrganization(),
            head.getDocumentType(), strPaymentDocumentNo, bp, head.getPaymentMethod(),
            head.getFinancialAccount(), "0", head.getTransacDate(), referenceNo, bp.getCurrency(),
            BigDecimal.ZERO, BigDecimal.ZERO, null);
        OBDal.getInstance().flush();
      } catch (Exception e) {
        // TODO: handle exception
        OBDal.getInstance().rollbackAndClose();
        continueProcess = false;
        saveStatus = false;
        msgFinal = "Error: " + referenceNo + " - " + SDC_Helper.getErrorMessage(e);
        updateStatus("N", referenceNo, msgFinal, head.getId(), head.getTypeload());
      }
      if (continueProcess) {
        payment.setCostCenter(head.getCostCenter());
        payment.setStDimension(head.getStDimension());
        payment.setDescription("Generate by: Cobros Debitos");

        BigDecimal collectionExpenses = BigDecimal.ZERO;
        BigDecimal collectionExpensesTotal = BigDecimal.ZERO;

        BigDecimal interestLatePayment = BigDecimal.ZERO;
        BigDecimal interestLatePaymentTotal = BigDecimal.ZERO;

        BigDecimal amountLine = BigDecimal.ZERO;
        BigDecimal amountBalance = BigDecimal.ZERO;

        // Agregamos las lineas del plan al detalle del pago
        for (FIN_PaymentScheduleDetail psd : psds) {
          collectionExpenses = BigDecimal.ZERO;
          interestLatePayment = BigDecimal.ZERO;

          amountBalance = getAmountbyReferenceNo(head.getId(), referenceNo,
              psd.getInvoicePaymentSchedule().getId());

          amountLine = head.getTypeload().equals("RPH") ? amountBalance : psd.getAmount();

          collectionExpenses = collectionExpenses.add(psd.getInvoicePaymentSchedule() != null
              && psd.getInvoicePaymentSchedule()
                  .getSSDNIDTCollectionInterestfForCollection() != null
              && psd.getAmount().compareTo(amountLine) <= 0
                  ? psd.getInvoicePaymentSchedule().getSSDNIDTCollectionInterestfForCollection()
                  : BigDecimal.ZERO);
          collectionExpensesTotal = collectionExpensesTotal.add(collectionExpenses);

          interestLatePayment = interestLatePayment.add(psd.getInvoicePaymentSchedule() != null
              && psd.getInvoicePaymentSchedule()
                  .getSSDNIDTInterestCollectionForLatePayment() != null
              && psd.getAmount().compareTo(amountLine) <= 0
                  ? psd.getInvoicePaymentSchedule().getSSDNIDTInterestCollectionForLatePayment()
                  : BigDecimal.ZERO);
          interestLatePaymentTotal = interestLatePaymentTotal.add(interestLatePayment);

          if (head.getTypeload().equals("RPH") && amountBalance != null
              && amountBalance.compareTo(psd.getAmount()) > 0) {
            // Subtract Values special
            amountLine = amountLine.subtract(collectionExpenses).subtract(interestLatePayment);
          }
          try {
            FIN_AddPayment.updatePaymentDetail(psd, payment, amountLine, false);
          } catch (Exception e) {
            // TODO: handle exception
            OBDal.getInstance().rollbackAndClose();
            continueProcess = false;
            saveStatus = false;
            msgFinal = "Error: " + referenceNo + " - " + SDC_Helper.getErrorMessage(e);
            updateStatus("N", referenceNo, msgFinal, head.getId(), head.getTypeload());
          }
        }
        if (continueProcess) {
          // Procesamos el cobro
          OBError messagePayment = processPayment(payment, "PRD", null, null, null, null, "",
              collectionExpensesTotal, interestLatePaymentTotal);
          String msgStr = "";
          if (messagePayment.getType().equals("Error")) {
            msgStr = SDC_Helper.stripExtraInformation(messagePayment.getMessage());
          }
          statusPayment = messagePayment.getType().equals("Error") ? "N" : "Y";
          msgFinal = messagePayment.getType().equals("Error") ? "Error:" + msgStr
              : messagePayment.getMessage();
          updateStatus(statusPayment, referenceNo, msgFinal, head.getId(), head.getTypeload());
        }
      }
      return msgFinal;
    } catch (Exception e) {
      // TODO: handle exception
      message = e.getMessage();
      message = SDC_Helper.getErrorMessage(e);
      message = "error:" + referenceNo + "-" + StringUtils.replace(message, "@", "");
      statusPayment = "N";
      if (saveStatus) {
        message = OBMessageUtils.parseTranslation("@" + message + "@");
      } else {
        message = msgFinal;
      }
      updateStatus(statusPayment, referenceNo, message, head.getId(), head.getTypeload());

      logger.info("Error generatePayment: " + message);
    } finally {
      OBContext.restorePreviousMode();
    }
    return message;
  }

  public List<String> getReferenceReconcile(String recordid) {
    final StringBuilder hqlString = new StringBuilder();
    final List<String> referenceslt = new ArrayList<String>();

    hqlString.append(" SELECT referenceNo");
    hqlString.append(" FROM sdc_dc_propocollect");
    hqlString.append(" WHERE isreconciled='Y'");
    hqlString.append(" AND sdc_debitcollect_id = :recordId");
    hqlString.append(" AND referenceNo IS NOT NULL");
    hqlString.append(" AND paymentComplete = 'N'");
    hqlString.append(" GROUP BY referenceNo");
    hqlString.append(" ORDER BY referenceNo");

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hqlString.toString());
    query.setParameter("recordId", recordid);
    for (Object resultObject : query.list()) {
      if (resultObject != null) {
        referenceslt.add(resultObject.toString());
      }
    }
    return referenceslt;
  }

  public List<String> getDetailReferenceReconcile(String recordid) {
    final StringBuilder hqlString = new StringBuilder();
    final List<String> referenceslt = new ArrayList<String>();

    hqlString.append(" SELECT COALESCE(pc.referenceNo, dt.referenceNo)");
    hqlString.append(" FROM sdc_dc_detail dt");
    hqlString.append(" LEFT JOIN dt.sDCDcPropocollect as pc");
    hqlString.append(" WHERE pc.sDCDebitcollect.id = :recordId");
    hqlString.append(" AND dt.paymentComplete='N'");
    hqlString.append(" AND pc.isreconciled='Y'");
    hqlString.append(" GROUP BY COALESCE(pc.referenceNo, dt.referenceNo)");
    hqlString.append(" ORDER BY COALESCE(pc.referenceNo, dt.referenceNo)");

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hqlString.toString());
    query.setParameter("recordId", recordid);
    for (Object resultObject : query.list()) {
      if (resultObject != null) {
        referenceslt.add(resultObject.toString());
      }
    }
    return referenceslt;
  }

  public BigDecimal getAmountbyReferenceNo(String recordId, String referenceNo,
      String invoiceScheduleId) {
    final StringBuilder hqlString = new StringBuilder();

    hqlString.append(" SELECT outstandingAmount");
    hqlString.append(" FROM sdc_dc_detail");
    hqlString.append(" WHERE sdc_debitcollect_id = :recordId");
    hqlString.append(" AND referenceNo = :referenceNo");
    hqlString.append(" AND fin_payment_schedule_id = :invoiceScheduleId");
    hqlString.append(" AND referenceNo IS NOT NULL");

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hqlString.toString());
    query.setParameter("recordId", recordId);
    query.setParameter("referenceNo", referenceNo);
    query.setParameter("invoiceScheduleId", invoiceScheduleId);
    query.setMaxResults(1);

    return (BigDecimal) query.uniqueResult();
  }

  public List<String> getReferenceScheduleDetail(String recordId, String referenceNo) {
    final StringBuilder hqlString = new StringBuilder();
    final List<String> referenceslt = new ArrayList<String>();

    hqlString.append(" SELECT id ");
    hqlString.append(" FROM FIN_Payment_ScheduleDetail sd");
    hqlString.append(" WHERE  EXISTS (");
    hqlString.append(" SELECT 1");
    hqlString.append(" FROM sdc_dc_detail as p");
    hqlString.append(" JOIN p.finPaymentSchedule ps");
    hqlString.append(" WHERE sdc_debitcollect_id = :recordId");
    hqlString.append(" AND referenceNo = :reference");
    hqlString.append(" AND referenceNo IS NOT NULL");
    hqlString.append(" AND sd.invoicePaymentSchedule.id=p.finPaymentSchedule.id");
    hqlString.append(" ORDER BY ps.expectedDate");
    hqlString.append(" )");
    hqlString.append(" AND paymentDetails IS NULL");
    hqlString.append(" ORDER BY invoicePaymentSchedule.expectedDate");

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hqlString.toString());
    query.setParameter("recordId", recordId);
    query.setParameter("reference", referenceNo);

    for (Object resultObject : query.list()) {
      if (resultObject != null) {
        referenceslt.add(resultObject.toString());
      }
    }
    return referenceslt;
  }

  public List<String> getReferenceSchedule(String recordId, String referenceNo) {
    final StringBuilder hqlString = new StringBuilder();
    final List<String> referenceslt = new ArrayList<String>();

    hqlString.append(" SELECT id ");
    hqlString.append(" FROM FIN_Payment_ScheduleDetail sd");
    hqlString.append(" WHERE  EXISTS (");
    hqlString.append(" SELECT 1");
    hqlString.append(" FROM sdc_dc_propocollect as p");
    hqlString.append(" JOIN p.finPaymentSchedule ps");
    hqlString.append(" WHERE isreconciled='Y'");
    hqlString.append(" AND sdc_debitcollect_id = :recordId");
    hqlString.append(" AND referenceNo = :reference");
    hqlString.append(" AND referenceNo IS NOT NULL");
    hqlString.append(" AND sd.invoicePaymentSchedule.id=p.finPaymentSchedule.id");
    hqlString.append(" ORDER BY ps.expectedDate");
    hqlString.append(" )");
    hqlString.append(" AND paymentDetails IS NULL");
    hqlString.append(" ORDER BY invoicePaymentSchedule.expectedDate");

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hqlString.toString());
    query.setParameter("recordId", recordId);
    query.setParameter("reference", referenceNo);

    for (Object resultObject : query.list()) {
      if (resultObject != null) {
        referenceslt.add(resultObject.toString());
      }
    }
    return referenceslt;
  }

  public List<FIN_PaymentScheduleDetail> getPaymentScheduleDetails(List<String> psdSet) {
    StringBuffer where = new StringBuffer();
    where.append(" as psd");
    where.append(" where psd." + FIN_PaymentScheduleDetail.PROPERTY_ID + " in (:psdSet)");
    where.append(" order by psd." + FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAYMENTSCHEDULE
        + ".expectedDate ");
    where.append(", abs(psd." + FIN_PaymentScheduleDetail.PROPERTY_AMOUNT + ")");
    OBQuery<FIN_PaymentScheduleDetail> orderedPSDs = OBDal.getInstance()
        .createQuery(FIN_PaymentScheduleDetail.class, where.toString());
    orderedPSDs.setNamedParameter("psdSet", psdSet);
    return orderedPSDs.list();
  }

  public static OBError processPayment(FIN_Payment payment, String strAction,
      String strDifferenceAction, BigDecimal refundAmount, BigDecimal exchangeRate,
      JSONObject jsonparams, String comingFrom, BigDecimal collectionExpenses,
      BigDecimal interestLatePayment) throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(true);
    VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
    AdvPaymentMngtDao dao = new AdvPaymentMngtDao();
    BigDecimal assignedAmount = BigDecimal.ZERO;

    for (FIN_PaymentDetail paymentDetail : payment.getFINPaymentDetailList()) {
      assignedAmount = assignedAmount.add(paymentDetail.getAmount());
    }
    payment.setAmount(assignedAmount);
    //payment.setSsdnidAmountInitial(assignedAmount.add(collectionExpenses).add(interestLatePayment));

    FIN_AddPayment.setFinancialTransactionAmountAndRate(vars, payment, BigDecimal.ONE,
        BigDecimal.ZERO);
    if (assignedAmount.compareTo(payment.getAmount()) == -1) {
      FIN_PaymentScheduleDetail refundScheduleDetail = dao.getNewPaymentScheduleDetail(
          payment.getOrganization(), payment.getAmount().subtract(assignedAmount));
      dao.getNewPaymentDetail(payment, refundScheduleDetail,
          payment.getAmount().subtract(assignedAmount), BigDecimal.ZERO, false, null);
    }

    OBError message = FIN_AddPayment.processPayment(vars, conn,
        (strAction.equals("PRP") || strAction.equals("PPP")) ? "P" : "D", payment, null);
    String strNewPaymentMessage = OBMessageUtils
        .parseTranslation("@PaymentCreated@" + " " + payment.getDocumentNo()) + ".";
    if (!"Error".equalsIgnoreCase(message.getType())) {
      new FIN_PaymentProcess().executeSql("ssdnid_createdebitnote", payment.getId());
      message.setMessage(strNewPaymentMessage + " " + message.getMessage());
      message.setType(message.getType().toLowerCase());
    }

    return message;
  }

  public void updateStatus(String status, String referenceno, String description, String recordId,
      String typedata) throws ServletException, SQLException {
    try {
      OBContext.setAdminMode();
      ConnectionProvider conn = new DalConnectionProvider(false);
      String userId = OBContext.getOBContext().getUser().getId();
      String descriptionSub = StringUtils.substring(description, 0, 2000);
      if (!typedata.equals("RPH")) {
        SdcValidPaymentData.updateLine(conn, status, userId, descriptionSub, recordId, referenceno);
      } else {
        SdcValidPaymentData.updateDetailLine(conn, status, userId, descriptionSub, recordId,
            referenceno);
      }
      OBDal.getInstance().getConnection(true).commit();
    } finally {
      OBContext.restorePreviousMode();
    }

  }

  public void validPayment(String recordId) throws JSONException {

    // Ad_Process: sdc_valid_payments
    org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
        .get(org.openbravo.model.ad.ui.Process.class, "EEF702E1F1B44ACEBA7B15D8C30A8E02");

    ProcessInstance pInstance = CallProcess.getInstance().call(process, recordId, null);

    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
    String msg = oberror.getMessage();
    logger.info("validPayment: " + msg);
  }

}
