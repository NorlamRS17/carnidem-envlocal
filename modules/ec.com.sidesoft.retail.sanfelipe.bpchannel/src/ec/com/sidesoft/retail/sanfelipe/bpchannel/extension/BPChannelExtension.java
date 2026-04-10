package ec.com.sidesoft.retail.sanfelipe.bpchannel.extension;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.master.BusinessPartner;


/**
 * @author Carlos Chiza
 * 
 */

@Qualifier(BusinessPartner.businessPartnerPropertyExtension)
public class BPChannelExtension extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      private static final long serialVersionUID = 1L;
      {
        add(new HQLProperty("bp.ssfcUser1.id", "bpchannel"));
        add(new HQLProperty("bp.ssfcUser1.name", "bpchannel_name"));
    }
	};
    return list;
  }
}



