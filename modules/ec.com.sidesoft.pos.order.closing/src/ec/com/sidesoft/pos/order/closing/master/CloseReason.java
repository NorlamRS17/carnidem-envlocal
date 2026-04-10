package ec.com.sidesoft.pos.order.closing.master;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class CloseReason extends ProcessHQLQuery {
  public static final String closeReasonPropertyExtension = "SSFOC_CloseReasonExtension";

  @Inject
  @Any
  @Qualifier(closeReasonPropertyExtension)
  private Instance<ModelExtension> extensions;

  @Override
  protected List<HQLPropertyList> getHqlProperties(JSONObject jsonsent) {
    List<HQLPropertyList> propertiesList = new ArrayList<HQLPropertyList>();
    Map<String, Object> args = new HashMap<String, Object>();
    HQLPropertyList hQLProperties = ModelExtensionUtils.getPropertyExtensions(extensions, args);
    propertiesList.add(hQLProperties);

    return propertiesList;
  }

  @Override
  protected List<String> getQuery(JSONObject jsonsent) throws JSONException {
    HQLPropertyList hQLProperties = ModelExtensionUtils.getPropertyExtensions(extensions);
    String hql = "SELECT " + hQLProperties.getHqlSelect() //
        + "FROM SSFPS_reasons_clousure AS cr " //
        + "WHERE cr.$incrementalUpdateCriteria " //
        + " AND cr.$readableSimpleClientCriteria " //
        + " AND cr.$naturalOrgCriteria " //
        + " AND cr.active = 'Y' " //
        + "ORDER BY cr.commercialName ";

    return Arrays.asList(new String[] { hql });
  }

  @Override
  protected boolean bypassPreferenceCheck() {
    return true;
  }

}
