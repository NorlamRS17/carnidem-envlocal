package ec.com.sidesoft.retail.custom.payment.master;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;

@Qualifier(BankTransfer.bankTransferPropertyExtension)
public class BankTransferProperties extends ModelExtension {

  @Override
  public List<HQLProperty> getHQLProperties(Object params) {
    ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
      {
        add(new HQLProperty("sbt.id", "id"));
        add(new HQLProperty("sbt.commercialName", "name"));
        add(new HQLProperty("sbt.commercialName", "_identifier"));
      }
    };
    return list;
  }

}