package ec.com.sidesoft.payroll.telecommuting.dialing.action_button;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import org.openbravo.client.kernel.BaseComponentProvider;
import org.openbravo.client.kernel.BaseComponentProvider.ComponentResource.ComponentResourceType;
import org.openbravo.client.kernel.Component;
import org.openbravo.client.kernel.ComponentProvider;


@ApplicationScoped
@ComponentProvider.Qualifier(Ssptdl_ComponentProvider.QUALIFIER)
public class Ssptdl_ComponentProvider extends BaseComponentProvider {

	public static final String QUALIFIER = "Ssptdl_ComponentProvider";
	public static final String MODULE_JAVA_PACKAGE = "ec.com.sidesoft.payroll.telecommuting.dialing";

	@Override
	public Component getComponent(String componentId,
			Map<String, Object> parameters) {
		throw new IllegalArgumentException("Component id " + componentId
				+ " not supported.");
	}

	
	  @Override
	  public List<ComponentResource> getGlobalComponentResources() {

	    final List<ComponentResource> globalResources = new ArrayList<ComponentResource>();
	    final String prefix = "web/" + MODULE_JAVA_PACKAGE;

	    globalResources.add(createStaticResource(prefix + "/js/getlocationgps.js", false));
 

	    return globalResources;
	  }
}
