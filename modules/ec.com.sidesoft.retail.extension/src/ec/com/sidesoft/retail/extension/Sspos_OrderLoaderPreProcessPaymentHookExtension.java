package ec.com.sidesoft.retail.extension;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.retail.posterminal.OrderLoaderPreProcessPaymentHook;

@ApplicationScoped
public class Sspos_OrderLoaderPreProcessPaymentHookExtension
    extends OrderLoaderPreProcessPaymentHook {

  @Override
  public void exec(JSONObject jsonorder, Order order, JSONObject jsonpayment, FIN_Payment payment)
      throws Exception {

    if (jsonpayment.has("paymentData")) {

      try {

        // Obtener datos de los metodos de pago
        JSONObject jsonPayment = jsonpayment.getJSONObject("paymentData");

        String strOwner1 = null;

        try {
          strOwner1 = jsonPayment.getString("POwner") == null ? ""
              : jsonPayment.getString("POwner");
        } catch (Exception e) {
        }

        String value = null;
        Date date1 = null;

        try {
          value = jsonPayment.getString("ExpDate") == null ? "" : jsonPayment.getString("ExpDate");
          // String sDate1 = "31/12/1998";
          // date1 = new SimpleDateFormat("dd/MM/yyyy").parse(value);

        } catch (Exception e2) {

        }

        payment.setSsposOwneracc(strOwner1);

        if (value != null) {
          payment.setSsposLote(value);
          payment.setDescription(
              (payment.getDescription() == null ? "" : payment.getDescription()) + "Lote:" + value);
        }

        String strCheckNo = jsonPayment.getString("NoCheck") == null ? "ND"
            : jsonPayment.getString("NoCheck");

        if (!strCheckNo.equals("ND")) {
          payment.setSsposOwneracc(null);
          String strOwner2 = null;
          String strPhone = null;
          String strBank = null;

          try {
            strOwner2 = jsonPayment.getString("POwner") == null ? ""
                : jsonPayment.getString("POwner");

          } catch (Exception e3) {

          }
          try {
            strPhone = jsonPayment.getString("NoPhone") == null ? ""
                : jsonPayment.getString("NoPhone");
          } catch (Exception e4) {

          }
          try {
            strBank = jsonPayment.getString("Bank") == null ? "" : jsonPayment.getString("Bank");

          } catch (Exception e5) {

          }

          payment.setSsposPhoneno(strPhone);

          payment.setSsposBank(strBank);
          payment.setSSPOSOwnerAccount(strOwner2);
          payment.setSsposNoaccount(strCheckNo);

        }
      } catch (Exception e6) {
      }

    }

    // } finally {
    // OBContext.restorePreviousMode();
    // }//
  }
}
