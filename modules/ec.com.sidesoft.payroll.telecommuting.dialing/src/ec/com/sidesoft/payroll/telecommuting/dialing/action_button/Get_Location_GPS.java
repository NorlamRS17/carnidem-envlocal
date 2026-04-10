package ec.com.sidesoft.payroll.telecommuting.dialing.action_button;

import java.util.Map;
import java.text.*;
import java.util.Date;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;

import ec.com.sidesoft.payroll.telecommuting.dialing.SsptdlTelecommDialing;

public class Get_Location_GPS extends BaseActionHandler {
	 
	  @Override
	  protected JSONObject execute(Map<String, Object> parameters, String data) {
	    try {
	      final JSONObject jsonData = new JSONObject(data);
	      final JSONArray orderIds = jsonData.getJSONArray("orders");
	      final String action = jsonData.getString("action");
	      final String strLatitude = jsonData.getString("gps_latitude"); 
	      final String strLongitude = jsonData.getString("gps_longitude"); 
	      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	      Date date = new Date();
	      System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

	      for (int i = 0; i < orderIds.length(); i++) {
	        final String orderId = orderIds.getString(i);
	 
	        // get the order
	        final SsptdlTelecommDialing order = OBDal.getInstance().get(SsptdlTelecommDialing.class, orderId);
/*	 
	        // and add or subtract 1
	        Long originalValue =Long.valueOf( order.getLocationMarking() );
	        if (originalValue == null) {
	          originalValue = 0L;
	        }
	 
	        Long finalValue;
	        if ("sum".equals(action)) {
	          finalValue = originalValue + 1L;
	        } else {
	          finalValue = originalValue - 1L;
	        }
	        order.setLocationMarking(finalValue.toString());
	        */
	        String strUrl = "https://www.google.com/maps/place/" + strLatitude + "," + strLongitude+"/@"+strLatitude + "," + strLongitude+ "z";
	        
	        order.setLocationMarking(strUrl);
	        order.setActionbuttom(true);
	        //order.set("entryhourM", new Date());
	        
	      }
	      
	 
	      JSONObject result = new JSONObject();
	      result.put("locationMarking", orderIds.length());
	 
	      return result;
	    } catch (Exception e) {
	      throw new OBException(e);
	    }
	  }
	}
