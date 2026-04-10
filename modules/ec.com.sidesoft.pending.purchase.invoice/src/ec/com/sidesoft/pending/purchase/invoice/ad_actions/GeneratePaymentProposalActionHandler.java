package ec.com.sidesoft.pending.purchase.invoice.ad_actions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.ad.access.User;
import org.openbravo.service.db.DalConnectionProvider;

public class GeneratePaymentProposalActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject response = new JSONObject();

    try {
      final JSONObject jsonData = new JSONObject(data);
      final JSONArray rows = jsonData.getJSONArray("rows");

      String ids = "";
      for (int i = 0; i < rows.length(); i++) {
        if (!ids.isEmpty()) {
          ids = ids + "|";
        }
        ids = ids + rows.getString(i);
      }

      User user = OBContext.getOBContext().getUser();
      String result = process(ids, user.getId());
      if (!result.equals("OK")) {
        throw new OBException(result);
      }

      OBDal.getInstance().flush();
      response.put("status", "OK");
    } catch (Exception e) {
      System.out.println("LoadLinesActionHandler: " + e.getMessage());
      try {
        response.put("status", "ERROR");
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    }
    OBContext.setAdminMode(false);
    return response;
  }

  private String process(String ids, String userId) {
    String result = null;
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    try {
      String sql = "SELECT ssppinv_payment_proposal2(?,?) AS result";
      st = conn.getPreparedStatement(sql);
      st.setString(1, ids);
      st.setString(2, userId);
      ResultSet resultSet = st.executeQuery();

      while (resultSet.next()) {
        result = resultSet.getString("result");
      }
    } catch (Exception e) {
      throw new OBException("GeneratePaymentProposalActionHandler.process: " + e.getMessage());
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
