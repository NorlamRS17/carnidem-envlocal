package ec.com.sidesoft.pos.custom.print.models;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.master.BusinessPartner;

/**
 * ModelExtension to add eEIEmail field to BusinessPartner synchronization
 * This ensures the email field is available when Business Partners are loaded
 * in the POS client, making it accessible in print templates via order.get('bp').get('eEIEmail')
 */
@Qualifier(BusinessPartner.businessPartnerPropertyExtension)
public class BusinessPartnerEmailExtension extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      private static final long serialVersionUID = 1L;
      {
        add(new HQLProperty("bp.eEIEmail", "eEIEmail"));
      }
    };
    return list;
  }
}


