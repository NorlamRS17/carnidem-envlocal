package ec.com.sidesoft.product.balance.master;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.Component;

public class ComponentsProvider extends BaseComponentProvider {
	public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.product.balance";

	@Override
	public Component getComponent(String componentId, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComponentResource> getGlobalComponentResources() {
		final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
		String[] staticResources = { "formBalanceProducts.js", "formBalanceProductsForMovements.js"};
		final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

		for (String resource : staticResources) {
			globalResources.add(createStaticResource(prefix + resource, false));
		}
		return globalResources;
	}

	@Override
	public List<String> getTestResources() {
		return Collections.emptyList();
	}

}
