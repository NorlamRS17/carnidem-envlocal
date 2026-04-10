package ec.com.sidesoft.payment.in.transit.ad_actions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.access.User;
import org.openbravo.service.db.DalConnectionProvider;

public class ProcessCollectionTransitActionHandler extends BaseActionHandler {

	private User user;

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String data) {
		JSONObject response = new JSONObject();
		try {
			// Usuario Logueado
			user = OBContext.getOBContext().getUser();

			final JSONObject jsonData = new JSONObject(data);
			final JSONArray rows = jsonData.getJSONArray("rows");

			for (int i = 0; i < rows.length(); i++) {
				String result = createPayment(rows.getString(i), user.getId());
				System.out.println(result);
				if (!result.equals("OK")) {
					throw new OBException(result);
				}
			}

			response.put("status", "OK");
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("@")) {
				msg = OBMessageUtils.translateError(msg).getMessage();
			}
			System.out.println("ProcessCollectionTransitActionHandler: " + msg);
			try {
				response.put("status", "ERROR");
				response.put("message", msg);
			} catch (Exception e2) {
			}
		}
		return response;
	}

	private String createPayment(String recordId, String userId) {
		String result = null;
		ConnectionProvider conn = new DalConnectionProvider(false);
		PreparedStatement st = null;
		try {
			String sql = "SELECT sspitra_createpayment(?,?) AS result";
			st = conn.getPreparedStatement(sql);
			st.setString(1, recordId);
			st.setString(2, userId);
			ResultSet resultSet = st.executeQuery();

			while (resultSet.next()) {
				result = resultSet.getString("result");
			}
			resultSet.close();
			st.close();
		} catch (Exception e) {
			throw new OBException("createPayment: " + e.getMessage());
		} finally {
			try {
				conn.releasePreparedStatement(st);
				conn.destroy();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		return result;
	}

}
