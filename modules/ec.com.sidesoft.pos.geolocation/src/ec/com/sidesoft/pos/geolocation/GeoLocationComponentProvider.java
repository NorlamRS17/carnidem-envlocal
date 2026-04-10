package ec.com.sidesoft.pos.geolocation;

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
@ComponentProvider.Qualifier(GeoLocationComponentProvider.QUALIFIER)
public class GeoLocationComponentProvider extends BaseComponentProvider{
	
	public static final String QUALIFIER = "Geolocation_Main";
	public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.pos.geolocation";
	
	@Override
	public Component getComponent(String componentId, Map<String, Object> parameters) {
		throw new IllegalArgumentException("Component id" + componentId + " not supported");
	}
	
	@Override
	public List<ComponentResource> getGlobalComponentResources() {
		    
		GlobalResourceHelper grhelper = new GlobalResourceHelper();
		    grhelper.add("components/geolocActions.js");
		    grhelper.add("models/bpLocationPropertiesExtension.js");		    	    
		    
		    return grhelper.getGlobalResource();
	}
	
	private class GlobalResourceHelper {
		final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
		private final String prefix = "web/" + MODULE_JAVA_PACKAGE + "/js/";
		
		public void add(String file) {
			globalResources.add(createComponentResource(ComponentResourceType.Static, prefix + file, POSUtils.APP_NAME));
		}
		
		public List<ComponentResource> getGlobalResource() {
			return globalResources;
		}
	
	}

}
