package ec.com.sidesoft.carnidem.pos.customizations.models;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.model.common.order.Order;
import org.openbravo.retail.posterminal.PaidReceipts;

@Qualifier(PaidReceipts.paidReceiptsPropertyExtension)
public class ReceiptProperty extends ModelExtension{

	@Override
	public List<HQLProperty> getHQLProperties(Object params) {
		ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
		      private static final long serialVersionUID = 1L;
		      {
		        add(new HQLProperty("ord.scheduledDeliveryDate", "scheduledDeliveryDate"));
		      }
		    };
		    return list;
	}

}
