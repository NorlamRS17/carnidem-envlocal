package ec.com.sidesoft.crm.visitplan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.ComponentProvider;

@ApplicationScoped
@ComponentProvider.Qualifier(ScrvroComponentProvider.QUALIFIER)
public class ScrvroComponentProvider extends BaseComponentProvider {
  public static final String QUALIFIER = "Scrvro_ComponentProvider";

  @Override
  public Component getComponent(String componentId, Map<String, Object> parameters) {
    throw new IllegalArgumentException("Component id " + componentId + " not supported.");
  }

  @Override
  public List<ComponentResource> getGlobalComponentResources() {

    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
    final String prefix = "web/ec.com.sidesoft.crm.visitplan";

    globalResources.add(createStaticResource(prefix + "/js/scrvro.js", false));

    return globalResources;
  }

}