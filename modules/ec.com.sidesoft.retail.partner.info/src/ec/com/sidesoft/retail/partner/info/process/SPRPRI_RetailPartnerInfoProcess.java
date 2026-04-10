package ec.com.sidesoft.retail.partner.info.process;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.retail.posterminal.JSONProcessSimple;
import org.openbravo.service.json.JsonConstants;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;

public class SPRPRI_RetailPartnerInfoProcess extends JSONProcessSimple {

	@Override
	public JSONObject exec(JSONObject jsonsent) throws JSONException, ServletException {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		
		try {
			OBContext.setAdminMode(true);
			JSONObject obdataDB = new JSONObject(jsonsent.getString("json"));
			String phone = obdataDB.getString("phone");
			String partnerID = obdataDB.getString("id");
			BusinessPartner partner = OBDal.getInstance().get(BusinessPartner.class,
			          partnerID);
			List<Location> locations = partner.getBusinessPartnerLocationList();
			
			if(locations.size() > 0 && !phone.equals("")) {
				Comparator<Location> comparator = new Comparator<Location>() {
					
					@Override
					public int compare(Location o1, Location o2) {
						// TODO Auto-generated method stub
						return o2.getCreationDate().compareTo(o1.getCreationDate());
					}
				};
				Collections.sort(locations, comparator);
				for(Location location : locations) {
					if(location.isActive()) {
						location.setPhone(phone);
						OBDal.getInstance().save(location);		
						break;
					}
				}
			}
			result.put(JsonConstants.RESPONSE_DATA, 0);
		    result.put(JsonConstants.RESPONSE_STATUS, JsonConstants.RPCREQUEST_STATUS_SUCCESS);
		}finally {
			OBContext.restorePreviousMode();
		}
	    
	    return result;
	}

}
