package ec.com.sidesoft.carnidem.pos.customizations.master;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.BaseComponentProvider.ComponentResource.ComponentResourceType;
import org.openbravo.retail.posterminal.POSUtils;

public class CarnidemPOSProvider extends BaseComponentProvider {
	public static final String QUALIFIER = "CUSTOMPOS_CARNIDEM";
	public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.carnidem.pos.customizations";

	@Override
	public Component getComponent(String componentId, Map<String, Object> parameters) {
		// TODO Auto-generated method stub
		throw new IllegalArgumentException("Component id " + componentId + " not supported.");
	}

	@Override
	public List<ComponentResource> getGlobalComponentResources() {
		final GlobalResourcesHelper grhelper = new GlobalResourcesHelper();
		grhelper.add("posResources/models/model-product.js");
		// Add all the javascript source files needed in our module

		final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
		final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

		String[] resourceList = { "posResources/models/PropertiesOrder",
				"posResources/hooks/OBPOS_PreOrderSave"};

		for (String resource : resourceList) {
			globalResources.add(createComponentResource(ComponentResourceType.Static, prefix + resource + ".js",
					POSUtils.APP_NAME));
		}

		return globalResources;
	}

	private class GlobalResourcesHelper {

		private final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
		private final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";

		public void add(String file) {
			globalResources
					.add(createComponentResource(ComponentResourceType.Static, prefix + file, POSUtils.APP_NAME));
		}

		public List<ComponentResource> getGlobalResources() {
			return globalResources;
		}
	}

}
