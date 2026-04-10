package ec.com.sidesoft.pos.sales.zone.master;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.master.BPLocation;

@Qualifier(BPLocation.bpLocationPropertyExtension)
public class SalesZoneBusinessPartnerExt extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      private static final long serialVersionUID = 1L;
      {
        add(new HQLProperty("bploc.salesRegion.id", "salesRegion"));
    }
	};
    return list;
  }
}