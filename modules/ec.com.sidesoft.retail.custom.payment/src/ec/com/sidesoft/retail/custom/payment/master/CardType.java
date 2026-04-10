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

public class CardType extends ProcessHQLQuery {

  public static final String cardTypePropertyExtension = "OBPOS_cardTypeExtension";

  @Inject
  @Any
  @Qualifier(cardTypePropertyExtension)
  private Instance<ModelExtension> extensions;

  @Override
  protected List<String> getQuery(JSONObject jsonsent) throws JSONException {

    List<String> hqlQueries = new ArrayList<String>();

    HQLPropertyList cardTypeHQLProperties = ModelExtensionUtils.getPropertyExtensions(extensions);

    hqlQueries.add("select " + cardTypeHQLProperties.getHqlSelect()
        + "from Ssccr_Cards_Types sct " + "where sct.active='Y' AND "
        + "sct.$readableSimpleClientCriteria AND " + "sct.$naturalOrgCriteria AND "
        + "(sct.$incrementalUpdateCriteria) " + " order by sct.name");

    return hqlQueries;
  }

}
