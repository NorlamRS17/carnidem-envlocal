	package ec.com.sidesoft.retail.sanfelipe.bpchannel.channelproperties;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLPropertyList;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.mobile.core.model.ModelExtensionUtils;
import org.openbravo.retail.posterminal.ProcessHQLQuery;


/**
 * @author Carlos Chiza
 * 
 */

public class BpChannel extends ProcessHQLQuery {
	public static final String channellistPropertyExtension = "UserDimension1_Extension";

	@Inject
	@Any
	@Qualifier(channellistPropertyExtension )
	private Instance<ModelExtension> extensions;

	@Override
	protected List<String> getQuery(JSONObject jsonsent) throws JSONException {
		List<String> adlistList = new ArrayList<String>();
		HQLPropertyList adlistHQLProperties = ModelExtensionUtils.getPropertyExtensions(extensions);
		adlistList.add("select "
						+ adlistHQLProperties.getHqlSelect()
						+ "from UserDimension1 ud1 "
						+ "where ud1.active=true" );
		return adlistList;
	}

}
