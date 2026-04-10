package ec.com.sidesoft.marlon.test.ad_callouts;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

/**
 * Callout para calcular Subtotal = Quantity * Price en líneas de Matriz de Configuración.
 * Valida que Quantity y Price sean mayores a 0.
 * Se ejecuta al cambiar Quantity o Price.
 */
public class EsmpMatrizConfigLineSubtotal extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String strQty = info.getStringParameter("inpquantity", null);
    String strPrice = info.getStringParameter("inpprice", null);

    BigDecimal qty = BigDecimal.ZERO;
    BigDecimal price = BigDecimal.ZERO;

    try {
      if (strQty != null && !strQty.isEmpty()) {
        qty = new BigDecimal(strQty);
      }
    } catch (NumberFormatException e) {
      info.addResult("ERROR", "Cantidad debe ser un número válido");
      return;
    }

    try {
      if (strPrice != null && !strPrice.isEmpty()) {
        price = new BigDecimal(strPrice);
      }
    } catch (NumberFormatException e) {
      info.addResult("ERROR", "Precio debe ser un número válido");
      return;
    }

    if (qty.compareTo(BigDecimal.ZERO) <= 0) {
      info.addResult("ERROR", "Cantidad debe ser mayor a 0");
      return;
    }

    if (price.compareTo(BigDecimal.ZERO) <= 0) {
      info.addResult("ERROR", "Precio debe ser mayor a 0");
      return;
    }

    BigDecimal subtotal = qty.multiply(price).setScale(6, RoundingMode.HALF_UP);
    info.addResult("inpsubtotal", subtotal.toString());
  }
}
