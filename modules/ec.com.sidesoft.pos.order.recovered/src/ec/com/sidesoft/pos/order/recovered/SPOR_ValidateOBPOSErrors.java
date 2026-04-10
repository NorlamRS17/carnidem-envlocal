package ec.com.sidesoft.pos.order.recovered;

import javax.servlet.ServletException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.retail.posterminal.JSONProcessSimple;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.json.JsonConstants;

public class SPOR_ValidateOBPOSErrors extends JSONProcessSimple {
	 @Override
	  public JSONObject exec(JSONObject jsonsent) throws JSONException, ServletException {
	    JSONObject result = new JSONObject();
	    Boolean containError = false; 
	    String orderid = jsonsent.getString("orderid");
	    ConnectionProvider conn = new DalConnectionProvider(false);
	      SPORValidateOBPOSErrorsData[] obposErrors = SPORValidateOBPOSErrorsData.select(conn);
	      
	    	  for(SPORValidateOBPOSErrorsData obError : obposErrors ) {
	    		  
	    		  if(obError.json.contains("\"id\":"+ "\"" + orderid + "\"") ||
	    		     obError.json.contains("\"id\": "+ "\"" + orderid + "\"") ||
	    			 obError.json.contains("\"orderId\":" + "\"" + orderid + "\"") ||
	    			 obError.json.contains("\"orderId\": " + "\"" + orderid + "\"")
	    			 ) {
	    			  containError = true;
	    			  break;
	    		  }
	    	  }
	      
	      result.put(JsonConstants.RESPONSE_STATUS, JsonConstants.RPCREQUEST_STATUS_SUCCESS);
	      result.put("data", containError);
	      result.put("result", "0");

	    return result;
	  }
	  

}
