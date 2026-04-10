package ec.com.sidesoft.retail.custom.payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.BaseComponentProvider.ComponentResource.ComponentResourceType;
import org.openbravo.client.kernel.Component;
import org.openbravo.retail.posterminal.POSUtils;

public class SRCPComponentProvider extends BaseComponentProvider {

  public static final String QUALIFIER = "SRCP_Main";
  public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.retail.custom.payment";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

    String[] resourceList = { "extensions/paymentmethod", "models/typeCredit",
        "models/processorBank", "models/cardType", "models/bankTransfer" };

    for (String resource : resourceList) {
      globalResources.add(createComponentResource(ComponentResourceType.Static,
          prefix + resource + ".js", POSUtils.APP_NAME));
    }

    return globalResources;
  }
}
