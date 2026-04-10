package ec.com.sidesoft.pos.consumidorfinal.fe.model;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.master.BusinessPartner;

@Qualifier(BusinessPartner.businessPartnerPropertyExtension)
public class BusinessPartnerPropertiesExtension extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      private static final long serialVersionUID = 1L;
      {
        add(new HQLProperty("bp.sswhTaxidtype", "taxIdType"));
        add(new HQLProperty("coalesce(bp.sbpcInvoiceLimitAmount, 0)", "invoiceLimitAmount"));
      }
    };
    return list;
  }

}
