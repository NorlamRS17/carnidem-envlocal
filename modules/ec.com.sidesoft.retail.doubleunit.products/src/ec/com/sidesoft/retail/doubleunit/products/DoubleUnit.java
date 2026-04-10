package ec.com.sidesoft.retail.doubleunit.products;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.ModelExtension;
import org.openbravo.retail.posterminal.ProcessHQLQuery;

public class DoubleUnit extends ProcessHQLQuery {        
  public static final String adlistPropertyExtension = "OBPOS_adlistExtension";

  @Inject
  @Any
  @Qualifier(adlistPropertyExtension)
  private Instance<ModelExtension> extensions;

  @Override
  protected List<String> getQuery(JSONObject jsonsent) throws JSONException {
    List<String> adlistList = new ArrayList<String>();
    // PRODUCTOS CONFIGURADOS EN LA UNIDAD ALTERNATIVA
    adlistList.add("select doubleunit.id as id, "
        + " doubleunit.product.id as idproduct, "
        + " doubleunit.uOM.id as iduom,  "
        + " doubleunit.uOM.name as searchKey,  "
        + " doubleunit.uOM.name as _identifier,  "
        + " doubleunit.conversionRate as conversionrate, "
        + " doubleunit.sales as sales, "
        + " doubleunit.purchase as purchase, "
        + " doubleunit.logistics as logistics, "
        + " 'false' as ismain "
        + " from  ProductAUM doubleunit ");

    // UNIDAD PRINCIPAL DEL PRODUCTO
    adlistList.add("SELECT id as id, "
        + " id as idproduct, "
        + " uOM.id as iduom,  "
        + " uOM.name as searchKey,  "
        + " uOM.name as _identifier,  "
        + " 1 as conversionrate, "
        + " 'S' as sales, "
        + " 'S' as purchase, "
        + " 'S' as logistics, "
        + " 'true' as ismain "
        + " FROM Product "
        + " WHERE id IN ( SELECT product.id FROM ProductAUM) ");
    
    return adlistList;
  }

}
