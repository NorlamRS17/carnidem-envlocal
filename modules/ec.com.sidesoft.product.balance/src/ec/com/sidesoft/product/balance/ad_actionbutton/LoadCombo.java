package ec.com.sidesoft.product.balance.ad_actionbutton;

import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;

public class LoadCombo extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(LoadCombo.class);

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
		JSONObject result = new JSONObject();

	    try {
	    	JSONObject jsonData = new JSONObject(content);
	    	
			String transactionID = jsonData.getString("transactionId");
			String typeTrx = jsonData.getString("typeTrx");
		    jsonData = getTransaction(transactionID, typeTrx);
	        result.put("data", jsonData);
	        result.put("success", true);
	    } catch (Exception e) {
	        log.debug("Error cargando informacion de los productos", e);
	        try {
	            result.put("success", false);
	            result.put("message", e.getMessage());
	        } catch (Exception ignore) {}
	    }

	    return result;
	}
	
	public JSONObject getTransaction (String transactionID, String typeTrx) throws JSONException {
		JSONObject JSONProd = new JSONObject();
		JSONArray JSONData = new JSONArray();
		JSONObject firstItem = new JSONObject();
		firstItem.put("code", "");
		firstItem.put("name", "");
		JSONData.put(firstItem);
		if(typeTrx.equals("A")) {
			ShipmentInOut objTransaction = OBDal.getInstance().get(ShipmentInOut.class, transactionID);
			JSONProd.put("transactionId", transactionID);
			for(ShipmentInOutLine line : objTransaction.getMaterialMgmtShipmentInOutLineList()){
				if(line.getProduct() != null && !line.isEcspbConfirm()) {
					Product objProd = line.getProduct();
					String prodID = objProd.getId();
					JSONObject prod = new JSONObject();
					prod.put("lineID", line.getId());
					prod.put("lineNo", line.getLineNo());
					prod.put("prodID", prodID);
					prod.put("code", objProd.getSearchKey());
					prod.put("name", objProd.getName());
					JSONData.put(prod);
				}
			}
		} else if(typeTrx.equals("M")) {
			InternalMovement objTransaction = OBDal.getInstance().get(InternalMovement.class, transactionID);
			JSONProd.put("transactionId", transactionID);
			for(InternalMovementLine line : objTransaction.getMaterialMgmtInternalMovementLineList()){
				if(line.getProduct() != null && !line.isEcspbConfirm()) {
					Product objProd = line.getProduct();
					String prodID = objProd.getId();
					JSONObject prod = new JSONObject();
					prod.put("lineID", line.getId());
					prod.put("lineNo", line.getLineNo());
					prod.put("prodID", prodID);
					prod.put("code", objProd.getSearchKey());
					prod.put("name", objProd.getName());
					JSONData.put(prod);
				}
			}
		}
		JSONProd.put("data", JSONData);
		
		return JSONProd;
	}

}
