package ec.com.sidesoft.pos.sales.zone;

import java.math.BigDecimal;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.sales.SalesRegion;
import org.openbravo.retail.posterminal.CustomerAddrCreationHook;

public class CustomCustomerAddrLoader extends CustomerAddrCreationHook{
	private static final Logger log = Logger.getLogger(CustomerAddrCreationHook.class);
	
	@Override
	public void exec(JSONObject jsonCustomerAddr, BusinessPartner customer,
			org.openbravo.model.common.businesspartner.Location location) throws Exception {
		
		try{
			if(location != null) {
				String salesRegionId = jsonCustomerAddr.has("salesRegion") ? jsonCustomerAddr.getString("salesRegion"): null;
				
				if (salesRegionId != null) {
					SalesRegion selectedSalesRegion = OBDal.getInstance().get(SalesRegion.class, salesRegionId);
					location.setSalesRegion(selectedSalesRegion);
					OBDal.getInstance().save(location);
					OBDal.getInstance().flush();
				}
			}
			
			if(customer != null) {
				String electronicEmail = jsonCustomerAddr.has("email") ? jsonCustomerAddr.getString("email"): null;
				
				if (electronicEmail != null) {
					customer.setEEIEmail(electronicEmail);;
					OBDal.getInstance().save(customer);
					OBDal.getInstance().flush();
				}
			}
			
		} catch (Exception e){
			log.error("Quotator "+ e.getMessage()+" : "+e.getCause());
		}
		
	}

}