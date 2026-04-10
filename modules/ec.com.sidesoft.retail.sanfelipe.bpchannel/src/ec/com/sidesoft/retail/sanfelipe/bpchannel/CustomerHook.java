package ec.com.sidesoft.retail.sanfelipe.bpchannel;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.retail.posterminal.CustomerLoaderHook;

public class CustomerHook implements CustomerLoaderHook {

	@Override
	public void exec(JSONObject jsonCustomer, BusinessPartner customer) throws Exception {
		// TODO Auto-generated method stub
		String strChannelID= jsonCustomer.getString("bpchannel");
		customer = getCustomer(jsonCustomer.getString("id"));

		if (strChannelID.length()>0)
		{
			UserDimension1 user1_channel = OBDal.getInstance().get(UserDimension1.class,strChannelID);
			customer.setSsfcUser1(user1_channel);
		}else {
			customer.setSsfcUser1(null);
		}
		
		OBDal.getInstance().save(customer);
		
	}
	  private BusinessPartner getCustomer(String id) {
		    BusinessPartner customer = OBDal.getInstance().get(BusinessPartner.class, id);
		    if (customer != null) {
		      return customer;
		    }
		    return new BusinessPartner();
		  }
	

}
