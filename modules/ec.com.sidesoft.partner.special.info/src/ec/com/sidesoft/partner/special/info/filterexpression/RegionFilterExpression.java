package ec.com.sidesoft.partner.special.info.filterexpression;

import java.util.Map;

import org.openbravo.client.application.FilterExpression;

public class RegionFilterExpression implements FilterExpression {

  @Override
  public String getExpression(Map<String, String> requestMap) {
    StringBuilder whereClause = new StringBuilder();
    String strCountyID = requestMap.get("c_country_id");
    whereClause.append(" e.country.id = '" + strCountyID + "' ");
    return whereClause.toString();
  }

}
