package ec.com.sidesoft.retail.custom.payment.master;

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

public class TypeCredit extends ProcessHQLQuery {

  public static final String typeCreditPropertyExtension = "OBPOS_typeCreditExtension";

  @Inject
  @Any
  @Qualifier(typeCreditPropertyExtension)
  private Instance<ModelExtension> extensions;

  @Override
  protected List<String> getQuery(JSONObject jsonsent) throws JSONException {

    List<String> hqlQueries = new ArrayList<String>();

    HQLPropertyList typeCreditHQLProperties = ModelExtensionUtils.getPropertyExtensions(extensions);

    hqlQueries.add("select " + typeCreditHQLProperties.getHqlSelect()
        + "from Ssccr_Types_Of_Credit stc " + "where active='Y' AND "
        + "stc.$readableSimpleClientCriteria AND " + "stc.$naturalOrgCriteria AND "
        + "(stc.$incrementalUpdateCriteria) " + " order by stc.name");

    return hqlQueries;
  }

}
