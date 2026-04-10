package ec.com.sidesoft.crm.visitplan.ad_actions;

import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;

import ec.com.sidesoft.crm.visitplan.helpers.CreateRoute;

public class RecalculateRouteActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject response = new JSONObject();

    try {
      final JSONObject jsonData = new JSONObject(data);
      final JSONArray rows = jsonData.getJSONArray("rows");
      System.out.println(rows.getString(0));

      // CreateRoute createRoute = new CreateRoute();
      //
      // createRoute.recordId = rows.getString(0);
      // System.out.println(createRoute.recordId);
      // createRoute.createRoute();

      response.put("status", "OK");
    } catch (Exception e) {
      System.out.println("RecalculateRouteActionHandler: " + e.getMessage());
      try {
        response.put("status", "ERROR");
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    }
    OBContext.setAdminMode(false);
    return response;
  }

}
