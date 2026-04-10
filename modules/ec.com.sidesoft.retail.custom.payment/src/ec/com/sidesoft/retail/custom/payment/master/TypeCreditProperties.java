package ec.com.sidesoft.retail.custom.payment.master;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;

@Qualifier(TypeCredit.typeCreditPropertyExtension)
public class TypeCreditProperties extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      {
        add(new HQLProperty("stc.id", "id"));
        add(new HQLProperty("stc.name", "name"));
        add(new HQLProperty("stc.name", "_identifier"));
      }
    };
    return list;
  }

}
