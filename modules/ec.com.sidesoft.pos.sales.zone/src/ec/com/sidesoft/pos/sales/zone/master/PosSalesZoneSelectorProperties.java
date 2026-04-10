package ec.com.sidesoft.pos.sales.zone.master;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import ec.com.sidesoft.pos.sales.zone.master.PosSalesZoneSelector;


@Qualifier(PosSalesZoneSelector.posSalesZoneSelector)
public class PosSalesZoneSelectorProperties extends ModelExtension{

	@Override
	public List<HQLProperty> getHQLProperties(Object params) {
		ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
		      private static final long serialVersionUID = 1L;
		      {
		    	add(new HQLProperty("sl.id", "_identifier"));  
		        add(new HQLProperty("sl.id", "id"));
		        add(new HQLProperty("coalesce(sl.searchKey, 'X')", "searchKey"));
		        add(new HQLProperty("coalesce(sl.name, 'X')", "name"));
		      }
		    };
		    return list;
	}

}
