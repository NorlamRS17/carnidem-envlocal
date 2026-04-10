package ec.com.sidesoft.pos.custom.print;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.BaseComponentProvider.ComponentResource.ComponentResourceType;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.ComponentProvider;
import org.openbravo.retail.posterminal.POSUtils;

/**
 * Component Provider for POS Custom Print module
 * Registers JavaScript hooks for printing customization
 */
@ApplicationScoped
@ComponentProvider.Qualifier(CustomPrintComponentProvider.QUALIFIER)
public class CustomPrintComponentProvider extends BaseComponentProvider {
  public static final String QUALIFIER = "SPCP_Main";
  public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.pos.custom.print";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final GlobalResourcesHelper grhelper = new GlobalResourcesHelper();
    
    // Customize print templates (must be loaded early)
    grhelper.add("posResources/js/customize-print-templates.js");
    
    // Extend BusinessPartner model to include eEIEmail field
    grhelper.add("posResources/js/models/BusinessPartnerEmailExtension.js");
    
    // Add the hook to add BP email before printing
    grhelper.add("posResources/js/hooks/addBpEmailPrePrintHook.js");
    
    return grhelper.getGlobalResources();
  }

  private class GlobalResourcesHelper {
    private final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    private final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/";

    public void add(String file) {
      globalResources.add(
          createComponentResource(ComponentResourceType.Static, prefix + file, POSUtils.APP_NAME));
    }

    public List<ComponentResource> getGlobalResources() {
      return globalResources;
    }
  }
}


