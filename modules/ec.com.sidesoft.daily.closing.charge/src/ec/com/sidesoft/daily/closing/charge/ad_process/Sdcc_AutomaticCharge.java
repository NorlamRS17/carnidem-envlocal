package ec.com.sidesoft.daily.closing.charge.ad_process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.daily.closing.charge.SdccDailyClossing;

public class Sdcc_AutomaticCharge extends DalBaseProcess {
  private final Logger logger = Logger.getLogger(Sdcc_AutoCharge.class);

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    // TODO Auto-generated method stub
    OBError msg = new OBError();
    VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
    ConnectionProvider con = new DalConnectionProvider(false);
    OBContext.setAdminMode(true);
    List<String> invoiceIds = new ArrayList<>();
    BigDecimal minAmount = BigDecimal.ZERO;
    BigDecimal maxAmount = BigDecimal.ZERO;
    List<FIN_PaymentScheduleDetail> scheduleDetails = new ArrayList<>();

    final String recordId = (String) bundle.getParams().get("Sdcc_Daily_Clossing_ID");

    try {
      SdccDailyClossing dailyCharge = OBDal.getInstance().get(SdccDailyClossing.class, recordId);
      if (dailyCharge == null) {
        throw new OBException("No se encontró el registro de cierre diario.");
      }
      minAmount = dailyCharge.getValuefrom();
      maxAmount = dailyCharge.getValueto();

      // SQL para seleccionar facturas dentro de un rango de montos y fechas
      String strSQL = "SELECT ci.c_invoice_id FROM c_invoice ci "
          + "JOIN FIN_Payment_Schedule fps ON ci.c_invoice_id = fps.c_invoice_id "
          + "WHERE ci.issotrx = 'Y' " + "AND (ci.OutstandingAmt >= ? AND ci.OutstandingAmt <= ?) "
          + "AND ci.OutstandingAmt <> 0.00 "
          + "AND (TRUNC(ci.DateInvoiced) BETWEEN TO_DATE(?, 'YYYY-MM-DD') AND TO_DATE(?, 'YYYY-MM-DD')) "
          + ";";

      PreparedStatement preparedStatement = con.getPreparedStatement(strSQL);
      preparedStatement.setBigDecimal(1, minAmount);
      preparedStatement.setBigDecimal(2, maxAmount);
      preparedStatement.setString(3, dailyCharge.getStartingDate().toString());
      preparedStatement.setString(4, dailyCharge.getEndingDate().toString());

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        invoiceIds.add(resultSet.getString("c_invoice_id"));
      }

      // Obtener todas las facturas
      List<Invoice> invoices = new ArrayList<>();
      for (String invoiceId : invoiceIds) {
        invoices.add(OBDal.getInstance().get(Invoice.class, invoiceId));
      }

      // Calcular el monto total a cobrar
      BigDecimal totalOutstandingAmount = BigDecimal.ZERO;
      for (Invoice invoice : invoices) {
        totalOutstandingAmount = totalOutstandingAmount.add(invoice.getOutstandingAmount());
      }

      final AdvPaymentMngtDao dao = new AdvPaymentMngtDao();
      final HashMap<String, BigDecimal> paidAmounts = new HashMap<>();

      for (Invoice invoice : invoices) {

        List<FIN_PaymentScheduleDetail> invoiceDetails = dao
            .getInvoicePendingScheduledPaymentDetails(invoice);

        for (FIN_PaymentScheduleDetail item : invoiceDetails) {
          scheduleDetails.add(item);
        }
      }

      // Verificar el tipo de documento para el pago
      final DocumentType documentType = dailyCharge.getDoctypePayment();
      if (documentType == null) {
        throw new OBException("No se encontró un tipo de documento para el pago.");
      }
      // Generar el número de pago
      final String paymentNo = Utility.getDocumentNo(con.getConnection(), con, vars, "",
          "FIN_Payment", documentType.getId(), documentType.getId(), false, true);
      BigDecimal amountToProcess = totalOutstandingAmount.setScale(2, RoundingMode.HALF_UP);

      final FIN_Payment newPayment = FIN_AddPayment.savePayment(null,
          invoices.get(0).isSalesTransaction(), documentType, paymentNo,
          dailyCharge.getBusinessPartner(), dailyCharge.getPaymentMethod(),
          dailyCharge.getFinancialAccount(), amountToProcess.toString(),
          dailyCharge.getPaymentDate(), dailyCharge.getOrganization(), null, scheduleDetails,
          paidAmounts, false, false);

      // Generar JSON con la estructura solicitada
      JSONObject json = new JSONObject();
      json.put("Fin_Payment_ID", newPayment.getId());

      JSONObject params = new JSONObject();
      params.put("fin_paymentmethod_id", dailyCharge.getPaymentMethod().getId());
      params.put("fin_financial_account_id", dailyCharge.getFinancialAccount().getId());

      JSONArray selectionArray = new JSONArray();
      for (Invoice invoice : invoices) {
        JSONObject invoiceJson = new JSONObject();
        invoiceJson.put("writeoff", false);
        invoiceJson.put("id", invoice.getId());
        selectionArray.put(invoiceJson);
      }

      JSONObject orderInvoice = new JSONObject();
      orderInvoice.put("_selection", selectionArray);
      params.put("order_invoice", orderInvoice);

      json.put("_params", params);

      logger.info("JSON generado: " + json.toString());

    } catch (Exception e) {
      // TODO: handle exception
      logger.error("Error en Sdcc_AutoCharge: ", e);
      msg.setType("Error");
      msg.setMessage(
          "Se produjo un error en el proceso con el ID: " + recordId + " - " + e.getMessage());

    } finally {
      OBContext.setAdminMode(false);
      bundle.setResult(msg);
    }
  }

}
