package ec.com.sidesoft.creditcard.reconciliation.transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.Component;

public class SccrtComponentProvider extends BaseComponentProvider {
  public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.creditcard.reconciliation.transaction";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    String[] staticResources = { "uploadFile.js" };
    final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

    for (String resource : staticResources) {
      globalResources.add(createStaticResource(prefix + resource, false));
    }
    return globalResources;
  }

  // @Override
  public List<String> getTestResources() {
    return Collections.emptyList();
  }
}
