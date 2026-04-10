package ec.com.sidesoft.retail.doubleunit.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.BaseComponentProvider.ComponentResource.ComponentResourceType;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.ComponentProvider;
import org.openbravo.retail.posterminal.POSUtils;

@ApplicationScoped
@ComponentProvider.Qualifier(SSDUPComponentProvider.QUALIFIER)
public class SSDUPComponentProvider extends BaseComponentProvider {

  public static final String QUALIFIER = "SSDUP_Main";
  public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.retail.doubleunit.products";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final GlobalResourcesHelper grhelper = new GlobalResourcesHelper();
    
    grhelper.add("model/doubleunit.js");
    grhelper.add("model/newObjectsProperties.js");
    grhelper.add("view/doubleunit-popup.js");
    grhelper.add("hooks/doubleunit-hook.js");
    
    return grhelper.getGlobalResources();
  }

  private class GlobalResourcesHelper {
    private final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    private final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

    public void add(String file) {
      globalResources.add(
          createComponentResource(ComponentResourceType.Static, prefix + file, POSUtils.APP_NAME));
    }

    public List<ComponentResource> getGlobalResources() {
      return globalResources;
    }
  }

}