package ec.com.sidesoft.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.ComponentProvider;

@ApplicationScoped
@ComponentProvider.Qualifier(Ssprj_ComponentProvider.QUALIFIER)
public class Ssprj_ComponentProvider extends BaseComponentProvider {
	public static final String QUALIFIER = "Ssprj_ComponentProvider";

	@Override
	public Component getComponent(String componentId, Map<String, Object> parameters) {
		throw new IllegalArgumentException("Component id " + componentId + " not supported.");
	}

	@Override
	public List<ComponentResource> getGlobalComponentResources() {

		final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
		final String prefix = "web/ec.com.sidesoft.projects";

		globalResources.add(createStaticResource(prefix + "/js/OB_SSPRJ.js", false));

		return globalResources;
	}

}