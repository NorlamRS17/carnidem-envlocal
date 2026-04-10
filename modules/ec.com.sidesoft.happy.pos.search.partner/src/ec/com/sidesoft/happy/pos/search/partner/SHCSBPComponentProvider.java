package ec.com.sidesoft.happy.pos.search.partner;

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
@ComponentProvider.Qualifier(SHCSBPComponentProvider.QUALIFIER)
public class SHCSBPComponentProvider extends BaseComponentProvider {
  public static final String QUALIFIER = "Main_SHCSBP";
  public static final String JAVA_PACKAGE = "ec.com.sidesoft.happy.pos.search.partner";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {
    final GlobalResourcesHelper grhelper = new GlobalResourcesHelper();

    grhelper.add("model/bp_filter_ext.js");
    grhelper.add("component/view_edit_customer_modal.js");

    return grhelper.getGlobalResources();
  }

  private class GlobalResourcesHelper {
    private final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    private final String prefix = "web/" + JAVA_PACKAGE + "/js/";

    public void add(String file) {
      globalResources.add(
          createComponentResource(ComponentResourceType.Static, prefix + file, POSUtils.APP_NAME));
    }

    public List<ComponentResource> getGlobalResources() {
      return globalResources;
    }
  }
}
