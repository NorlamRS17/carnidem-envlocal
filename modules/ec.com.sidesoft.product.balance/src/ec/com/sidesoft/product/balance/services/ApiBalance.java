package ec.com.sidesoft.product.balance.services;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;

import ec.com.sidesoft.product.balance.HardwareManagerConfi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ApiBalance extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(ApiBalance.class);
	
	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
	    JSONObject result = new JSONObject();
	    try {
	    	JSONObject jsonData = new JSONObject(content);
	    	String tableName = jsonData.has("tableName") ? jsonData.getString("tableName") : "";
	        JSONObject scaleData = getScaleValue(tableName);
	        result.put("success", true);
	        result.put("data", scaleData);
	    } catch (Exception e) {
	        log.error("Error obteniendo peso de la balanza", e);
	        try {
	            result.put("success", false);
	            result.put("message", e.getMessage());
	        } catch (Exception ignore) {}
	    }

	    return result;
	}
	
	public JSONObject getScaleValue(String tableName) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String apiUrl = getUrl(tableName); //"http://192.168.1.214:8090/scale";
        Request request = new Request.Builder()
                .url(apiUrl)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Unexpected code " + response.code());
            }

            String responseBody = response.body().string();
            return new JSONObject(responseBody);
        }
    }
	
	public String getUrl(String tableName) {
			List<HardwareManagerConfi> transactions = null;
			
			StringBuilder whereClause = new StringBuilder();
			whereClause.append(" WHERE ");
			whereClause.append(HardwareManagerConfi.PROPERTY_ACTIVE + " = 'Y' ");
			whereClause.append(" AND ");
		    whereClause.append(" LOWER(" + HardwareManagerConfi.PROPERTY_TABLENAME + ") = LOWER(:tableName)");
			OBQuery<HardwareManagerConfi> qUrls = OBDal.getInstance().createQuery(HardwareManagerConfi.class, whereClause.toString());
			qUrls.setNamedParameter("tableName", tableName);
			
			if (qUrls.list().size() > 0) {
				transactions = qUrls.list();
			}else {
				throw new OBException("No se ha encontrado una URL para la tabla "+ tableName);
			}

			return qUrls.list().get(0).getURL();
	}

}
