package ec.com.sidesoft.product.balance.ad_actionbutton;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.materialmgmt.UOMUtil;
import org.openbravo.base.exception.OBException;


public class Transform extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(Transform.class);

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		try {
			result.put("success", false);
			JSONObject jsonData = new JSONObject(content);
		    String productID = jsonData.has("productID")? jsonData.getString("productID"):null;
		    String uomMain = jsonData.has("uomMain")? jsonData.getString("uomMain"):null;
		    String uom = jsonData.has("uom")? jsonData.getString("uom"):null;
		    String quantity = jsonData.has("quantity")? jsonData.getString("quantity"):null;
		    
		    result.put("data", transformQty(quantity, uom, uomMain, productID));
		    result.put("success", true);
		}catch(Exception e) {
			log.debug("Error convirtiendo unidad. "+ e);
		}
	    
	    return result;
	}
	
	public JSONObject transformQty(String quantity, String uom, String uomMain, String productID  ) throws Exception {
		JSONObject result = new JSONObject();
		
		BigDecimal qty = BigDecimal.ZERO;
	    if(quantity != null) {
	    	qty = new BigDecimal(quantity);
	    }
	    
	    String strOperativeUOM = uom;
	    String strBaseUOM = uomMain;
	    String productId = productID;
	    String tableId = "";
	    try {
	      OBContext.setAdminMode();
	      if (UOMUtil.isUomManagementEnabled()) {
	        if (strOperativeUOM == null || strOperativeUOM.isEmpty()) {
	          qty = null;
	        } else if (!strOperativeUOM.equals(strBaseUOM)) {
	          qty = UOMUtil.getConvertedQty(productId, qty, strOperativeUOM);
	        }
	      }
	      result.put("qty", qty);
	    } catch (OBException e) {
	      log.error("Error while converting UOM. ", e);
	      qty = null;
	    } finally {
	      OBContext.restorePreviousMode();
	    }
		
		return result;
	}

}
