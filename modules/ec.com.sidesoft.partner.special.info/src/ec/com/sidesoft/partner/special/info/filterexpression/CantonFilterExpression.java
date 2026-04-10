package ec.com.sidesoft.partner.special.info.filterexpression;

import java.util.Map;

import org.openbravo.client.application.FilterExpression;

public class CantonFilterExpression implements FilterExpression {

  @Override
  public String getExpression(Map<String, String> requestMap) {
    StringBuilder whereClause = new StringBuilder();
    String strRegionID = requestMap.get("c_region_id");
    whereClause.append(" e.region.id = '" + strRegionID + "' ");
    return whereClause.toString();
  }

}
