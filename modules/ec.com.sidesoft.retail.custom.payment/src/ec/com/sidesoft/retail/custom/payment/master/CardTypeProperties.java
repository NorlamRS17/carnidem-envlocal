package ec.com.sidesoft.retail.custom.payment.master;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;

@Qualifier(CardType.cardTypePropertyExtension)
public class CardTypeProperties extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      {
        add(new HQLProperty("sct.id", "id"));
        add(new HQLProperty("sct.name", "name"));
        add(new HQLProperty("sct.name", "_identifier"));
      }
    };
    return list;
  }

}