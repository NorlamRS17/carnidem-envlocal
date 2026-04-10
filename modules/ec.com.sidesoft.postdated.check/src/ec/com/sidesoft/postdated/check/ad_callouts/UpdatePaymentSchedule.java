package ec.com.sidesoft.postdated.check.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.dal.core.OBContext;

public class UpdatePaymentSchedule extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    OBContext.setAdminMode(true);
    // Recuperamos el plan de pagos seleccionado
    String paymentScheduleId = info.getStringParameter("inpfinPaymentScheduleId", null);
    FIN_PaymentSchedule paymentSchedule = OBDal.getInstance().get(FIN_PaymentSchedule.class,
        paymentScheduleId);
    // Validamos el plan de pagos seleccionado
    if (paymentSchedule != null) {
      // No. de la factura
      info.addResult("inpdocumentno", (paymentSchedule.getInvoice().getDocumentNo().isEmpty() ? ""
          : paymentSchedule.getInvoice().getDocumentNo()));
      // No. de cuota del plan de pago
      info.addResult("inpshareno", (paymentSchedule.getSsppiShareno().toString().isEmpty() ? ""
          : paymentSchedule.getSsppiShareno().toString()));
      // Monto de la cuota del plan de pago
      info.addResult("inpamountPayment", (paymentSchedule.getAmount().toString().isEmpty() ? ""
          : paymentSchedule.getAmount().toString()));
    }
  }
}
