package ec.com.sidesoft.pos.sales.zone;

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
@ComponentProvider.Qualifier(SalesZonePosProvider.QUALIFIER)
public class SalesZonePosProvider extends BaseComponentProvider {
  public static final String QUALIFIER = "SPSZ_Main";
  public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.pos.sales.zone";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final GlobalResourcesHelper grhelper = new GlobalResourcesHelper();
    // Add all the javascript source files needed in our module

    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

    String[] resourceList = {
    		"posResources/models/PosSalesZoneSelector",
        "posResources/models/BPlocationExtSZ",
        "posResources/components/businessPartnerExt",
        "posResources/components/businessPartnerLocationExt",
        "posResources/hooks/Extension_CustomerSave",
        "posResources/hooks/Extension_CustomerAddrSave",
        "posResources/view/renderCustomerSalesZone",
        "posResources/view/loadCustomerSalesZone",
    };

    for (String resource : resourceList) {
      globalResources.add(createComponentResource(ComponentResourceType.Static, prefix + resource
          + ".js", POSUtils.APP_NAME));
    }

    return globalResources;
  }

  private class GlobalResourcesHelper {

    private final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    private final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

    public void add(String file) {
      globalResources.add(createComponentResource(ComponentResourceType.Static, prefix + file,
          POSUtils.APP_NAME));
    }

    public List<ComponentResource> getGlobalResources() {
      return globalResources;
    }
  }
}
