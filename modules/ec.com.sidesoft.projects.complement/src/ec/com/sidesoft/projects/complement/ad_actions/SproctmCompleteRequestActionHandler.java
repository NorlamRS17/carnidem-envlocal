package ec.com.sidesoft.projects.complement.ad_actions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.service.db.DalConnectionProvider;

public class SproctmCompleteRequestActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject response = new JSONObject();
    System.out.print(parameters);
    String msg = null;
    try {
      final JSONObject jsonData = new JSONObject(data);
      final String row_id = jsonData.getString("row_id");

      User user = OBContext.getOBContext().getUser();
      Client client = OBContext.getOBContext().getCurrentClient();

      String result = process(row_id, user.getId(), client.getId());
      msg = result;

      OBDal.getInstance().flush();
      response.put("status", msg);
    } catch (Exception e) {
      System.out.println("LoadLinesActionHandler: " + e.getMessage());
      try {
        response.put("status", msg);
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    }
    OBContext.setAdminMode(false);
    return response;
  }

  private String process(String ids, String userId, String clientId) {
    String result = null;
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    try {
      String sql = "SELECT sproctm_complete_detcost_pr(?,?,?) AS result";
      st = conn.getPreparedStatement(sql);
      st.setString(1, ids);
      st.setString(2, userId);
      st.setString(3, clientId);

      ResultSet resultSet = st.executeQuery();

      while (resultSet.next()) {
        result = resultSet.getString("result");
      }
    } catch (Exception e) {
      throw new OBException("SproctmCompleteRequestActionHandler.process: " + e.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
      } catch (Exception ignore) {
        ignore.printStackTrace();
      }
    }
    return result;
  }

}
