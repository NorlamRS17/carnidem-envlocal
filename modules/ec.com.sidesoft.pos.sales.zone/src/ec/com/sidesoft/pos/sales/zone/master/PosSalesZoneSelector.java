package ec.com.sidesoft.pos.sales.zone.master;

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

public class PosSalesZoneSelector extends ProcessHQLQuery {

	public static final String posSalesZoneSelector = "SPSZ_SalesRegion";
	

	@Inject
	@Any
	@Qualifier(posSalesZoneSelector)
	private Instance<ModelExtension> extensions;

	@Override
	protected List<String> getQuery(JSONObject jsonsent) throws JSONException {
		List<String> hqlQueries = new ArrayList<String>();

		HQLPropertyList regularApprobalyHQLProperties = ModelExtensionUtils.getPropertyExtensions(extensions);

		hqlQueries.add("select " + regularApprobalyHQLProperties.getHqlSelect() + "from SalesRegion sl "
				+ "where " + "sl.$readableSimpleClientCriteria AND " + "sl.$naturalOrgCriteria AND "
				+ "(sl.$incrementalUpdateCriteria) " + " AND sl.active = true " 
				+ " ORDER BY sl.name asc");

		return hqlQueries;
	}
	
	
	@Override
	  protected boolean bypassPreferenceCheck() {
	    return true;
	  }

}
