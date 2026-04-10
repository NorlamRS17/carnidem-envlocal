package ec.com.sidesoft.pending.purchase.invoice.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class ValidateAmount extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    try {
      String strPending = info.getStringParameter("inpoutstandingamt", null);
      String strAmount = info.getStringParameter("inpamount", null);

      if (strPending != null && !strAmount.isEmpty() && strAmount != null && !strAmount.isEmpty()) {
        BigDecimal pending = new BigDecimal(strPending.replace(",", ""));
        BigDecimal amount = new BigDecimal(strAmount.replace(",", ""));
        if (amount.compareTo(pending) > 0)
          info.addResult("inpamount", pending);
      }
    } catch (Exception e) {
      System.out.println("ValidateAmount: " + e.getMessage());
    }

  }
}
