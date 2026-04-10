package ec.com.sidesoft.pending.purchase.invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.ComponentProvider;

@ApplicationScoped
@ComponentProvider.Qualifier(SsppinvComponentProvider.QUALIFIER)
public class SsppinvComponentProvider extends BaseComponentProvider {
  public static final String QUALIFIER = "Ssppinv_ComponentProvider";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {

    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    final String prefix = "web/ec.com.sidesoft.pending.purchase.invoice";

    globalResources.add(createStaticResource(prefix + "/js/ssppinv.js", false));

    return globalResources;
  }

}