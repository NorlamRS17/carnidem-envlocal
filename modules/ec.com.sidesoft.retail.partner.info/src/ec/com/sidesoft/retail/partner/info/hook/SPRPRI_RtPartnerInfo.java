package ec.com.sidesoft.retail.partner.info.hook;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.retail.posterminal.CustomerLoaderHook;
import org.openbravo.model.common.businesspartner.Location;

public class SPRPRI_RtPartnerInfo implements CustomerLoaderHook {

	@Override
	public void exec(JSONObject jsonCustomer, BusinessPartner customer) throws Exception {
		// TODO Auto-generated method stub
		try {
			String phone = jsonCustomer.getString("phone");
			List<Location> locations = customer.getBusinessPartnerLocationList();
			
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
			
			//actualizacion de identificador de tercero
			String searchKey = customer.getSearchKey();
			String identifier = jsonCustomer.getString("taxID");
			if(!customer.getSearchKey().equals(identifier)) {
				customer.setSearchKey(identifier);
				OBDal.getInstance().save(customer);			
			}
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
