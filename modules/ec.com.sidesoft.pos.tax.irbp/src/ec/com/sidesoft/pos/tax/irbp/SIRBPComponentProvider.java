package ec.com.sidesoft.pos.tax.irbp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.BaseComponentProvider.ComponentResource.ComponentResourceType;
import org.openbravo.client.kernel.Component;
import org.openbravo.retail.posterminal.POSUtils;

public class SIRBPComponentProvider extends BaseComponentProvider {

  public static final String QUALIFIER = "SIRBP_Main";
  public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.pos.tax.irbp";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

    String[] resourceList = { "extension/orderDataTaxesExtension", "extension/productPropertiesExtension" };

    for (String resource : resourceList) {
      globalResources.add(createComponentResource(ComponentResourceType.Static,
          prefix + resource + ".js", POSUtils.APP_NAME));
    }

    return globalResources;
  }
}
