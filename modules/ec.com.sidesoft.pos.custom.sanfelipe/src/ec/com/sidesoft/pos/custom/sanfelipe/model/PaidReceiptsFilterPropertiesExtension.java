package ec.com.sidesoft.pos.custom.sanfelipe.model;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.PaidReceiptsFilter;

@Qualifier(PaidReceiptsFilter.paidReceiptsFilterPropertyExtension)
public class PaidReceiptsFilterPropertiesExtension extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      private static final long serialVersionUID = 1L;
      {
        add(new HQLProperty(
            "coalesce((select u.username from ADUser u where u.id = ord.ssdpmDispatcherUser.id ), to_char(''))",
            "dispatcher"));
        add(new HQLProperty(
            "(coalesce((select case when sum(abs(ol.orderedQuantity)) = 0 or ord.iscancelled = 'Y' "
                + "or ord.cancelledorder.id is not null then 0 else "
                + "round(coalesce(sum(abs(ol.deliveredQuantity)), 0)/sum(abs(ol.orderedQuantity)) * 100, 0) end "
                + "from OrderLine ol where ol.salesOrder.id = ord.id),0)) ",
            "deliveryStatus"));
        add(new HQLProperty(
            " (coalesce((select case when sum(abs(ol.orderedQuantity)) = 0 or ord.iscancelled = 'Y' "
                + "  or ord.cancelledorder.id is not null then 0 else "
                + " round(coalesce(sum(abs(ol.deliveredQuantity)), 0)/sum(abs(ol.orderedQuantity)) * 100, 0) end "
                + " from OrderLine ol where ol.salesOrder.id = ord.id),0)) ",
            "invoiceStatus"));
      }
    };
    return list;
  }

}
