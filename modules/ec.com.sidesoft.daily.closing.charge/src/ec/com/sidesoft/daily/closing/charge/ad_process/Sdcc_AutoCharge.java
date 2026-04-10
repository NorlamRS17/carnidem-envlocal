package ec.com.sidesoft.daily.closing.charge.ad_process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.daily.closing.charge.SdccDailyClossing;
import ec.com.sidesoft.daily.closing.charge.SdccDailyClossingPayment;
import ec.com.sidesoft.daily.closing.charge.Sdcc_DailyClossingLine;

public class Sdcc_AutoCharge extends DalBaseProcess {
  private final Logger logger = Logger.getLogger(Sdcc_AutoCharge.class);

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
    ConnectionProvider conn = new DalConnectionProvider(false);
    OBError msg = new OBError();
    OBContext.setAdminMode(true);
    final String recordId = (String) bundle.getParams().get("Sdcc_Daily_Clossing_ID");
    // List<FIN_PaymentScheduleDetail> scheduleDetails = new ArrayList<>();
    String msg_payment = "";
    try {
      SdccDailyClossing dailyCharge = OBDal.getInstance().get(SdccDailyClossing.class, recordId);
      if (dailyCharge == null) {
        throw new OBException("No se encontró el registro de cierre diario.");
      }

      if (dailyCharge.getExecutepayment().equals("LL")) {
        generatelines(recordId);
      } else {
        msg_payment = process_lines(dailyCharge, conn, vars);
        dailyCharge.setAlertStatus("CO");
      }

      msg.setType("Success");
      msg.setMessage(msg_payment);

    } catch (final Exception e) {
      logger.error("Error en Sdcc_AutoCharge: ", e);
      msg.setType("Error");
      msg.setMessage("Se produjo un error en el proceso - " + e.getMessage());
    } finally {
      OBContext.setAdminMode(false);
      bundle.setResult(msg);
    }
  }

  public String process_lines(SdccDailyClossing dailyCharge, ConnectionProvider conn,
      VariablesSecureApp vars) throws Exception {
    BigDecimal totalOutstandingAmount = BigDecimal.ZERO;
    // Verificar el tipo de documento para el pago
    final DocumentType documentType = dailyCharge.getDoctypePayment();
    if (documentType == null) {
      throw new OBException("No se encontró un tipo de documento para el pago.");
    }
    List<String> psdid = getReferenceScheduleDetail(dailyCharge);

    if (psdid.isEmpty()) {
      throw new OBException("No se selecciono ninguna transacción para realizar el cobro.");
    }
    List<FIN_PaymentScheduleDetail> scheduleDetails = getPaymentScheduleDetails(psdid);
    final HashMap<String, BigDecimal> paidAmounts = new HashMap<>();
    for (FIN_PaymentScheduleDetail item : scheduleDetails) {
      paidAmounts.put(item.getId(), item.getAmount());
      totalOutstandingAmount = totalOutstandingAmount.add(item.getAmount());
    }

    // Generar el número de pago
    final String paymentNo = Utility.getDocumentNo(conn.getConnection(), conn, vars, "",
        "FIN_Payment", documentType.getId(), documentType.getId(), false, true);

    // Crear el pago único
    BigDecimal amountToProcess = dailyCharge.getGLItem() == null
        ? totalOutstandingAmount.setScale(2, RoundingMode.HALF_UP)
        : BigDecimal.ZERO;
    final FIN_Payment newPayment = FIN_AddPayment.savePayment(null, true, documentType, paymentNo,
        dailyCharge.getBusinessPartner(), dailyCharge.getPaymentMethod(),
        dailyCharge.getFinancialAccount(), amountToProcess.toString(), dailyCharge.getPaymentDate(),
        dailyCharge.getOrganization(), dailyCharge.getReferenceNo(), scheduleDetails, paidAmounts,
        false, false);

    if (dailyCharge.getGLItem() != null) {
      generatePaymentGLItems(newPayment,
          totalOutstandingAmount.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(-1)),
          dailyCharge.getGLItem().getId(), dailyCharge.getBusinessPartner());
    }
    newPayment
        .setDescription("Generate by: Cobro de cierre diario No." + dailyCharge.getDocumentNo());
    newPayment.setCostCenter(dailyCharge.getCostCenter());
    newPayment.setStDimension(dailyCharge.getStDimension());

    OBError message = FIN_AddPayment.processPayment(vars, conn, "P", newPayment, null, "");
    String strNewPaymentMessage = OBMessageUtils
        .parseTranslation("@PaymentCreated@" + " " + newPayment.getDocumentNo()) + ".";

    if ("Error".equalsIgnoreCase(message.getType())) {
      throw new OBException(message.getMessage());
    }
    // Generamos la linea de detalle del cobro
    SdccDailyClossingPayment line = OBProvider.getInstance().get(SdccDailyClossingPayment.class);
    line.setLineNo(10L);
    line.setDocumentNo(paymentNo);
    line.setAmount(totalOutstandingAmount);
    line.setSdccDailyClossing(dailyCharge);
    OBDal.getInstance().save(line);

    return strNewPaymentMessage;
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

  public List<String> getReferenceScheduleDetail(SdccDailyClossing dailyCharge) {
    final List<String> referenceslt = new ArrayList<String>();
    OBCriteria<Sdcc_DailyClossingLine> crtlines = OBDal.getInstance()
        .createCriteria(Sdcc_DailyClossingLine.class);
    crtlines.add(Restrictions.eq(Sdcc_DailyClossingLine.PROPERTY_PROCESS, true));
    crtlines.add(Restrictions.eq(Sdcc_DailyClossingLine.PROPERTY_SDCCDAILYCLOSSING, dailyCharge));

    for (Sdcc_DailyClossingLine line : crtlines.list()) {
      referenceslt.add(line.getDetailtrx().toString());

    }
    return referenceslt;
  }

  public void generatelines(String recordId) {
    org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
        .get(org.openbravo.model.ad.ui.Process.class, "86E19D7D7079442AB90BA96019CDA9E4");

    final ProcessInstance pInstance = CallProcess.getInstance().call(process, recordId, null);

    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
    String msg = oberror.getMessage();
    if (pInstance.getResult() == 0) {
      throw new OBException(msg);
    }

  }

  private void generatePaymentGLItems(FIN_Payment paymentGLI, BigDecimal glItemAmt,
      String strGLItemId, BusinessPartner businessPartnerGLItem) {
    FIN_AddPayment.saveGLItem(paymentGLI, glItemAmt,
        OBDal.getInstance().get(GLItem.class, strGLItemId), businessPartnerGLItem, null, null, null,
        null, null, null, null, null);
  }

}