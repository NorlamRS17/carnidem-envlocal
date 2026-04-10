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

public class BankTransfer extends ProcessHQLQuery {

  public static final String bankTransferPropertyExtension = "OBPOS_bankTransferExtension";

  @Inject
  @Any
  @Qualifier(bankTransferPropertyExtension)
  private Instance<ModelExtension> extensions;

  @Override
  protected List<String> getQuery(JSONObject jsonsent) throws JSONException {

    List<String> hqlQueries = new ArrayList<String>();

    HQLPropertyList bankTransferHQLProperties = ModelExtensionUtils
        .getPropertyExtensions(extensions);

    hqlQueries.add("select " + bankTransferHQLProperties.getHqlSelect()
        + "from ssfi_banktransfer sbt " + "where active='Y' AND "
        + "sbt.$readableSimpleClientCriteria AND " + "sbt.$naturalOrgCriteria AND "
        + "(sbt.$incrementalUpdateCriteria) " + " order by sbt.commercialName");

    return hqlQueries;
  }

}
