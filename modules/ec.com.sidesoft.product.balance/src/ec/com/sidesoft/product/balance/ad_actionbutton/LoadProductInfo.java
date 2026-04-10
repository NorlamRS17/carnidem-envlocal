package ec.com.sidesoft.product.balance.ad_actionbutton;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductAUM;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class LoadProductInfo extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(LoadProductInfo.class);
	private static final long serialVersionUID = 1L;
	private String strSessionValue = "";
	
	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content)  {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		try {
			result.put("success", false);
			JSONObject jsonData = new JSONObject(content);
			String transactionID = jsonData.getString("transactionId");
			String transaction = jsonData.getString("transaction");
		    String barcode = jsonData.has("barcode")? jsonData.getString("barcode"): null;
		    String productCode = jsonData.has("productCode")? jsonData.getString("productCode"):null;
		    String line = jsonData.has("line")? jsonData.getString("line"):null;
		    String productName = jsonData.has("productName")? jsonData.getString("productName"):null;
		    String uom = jsonData.has("uom")? jsonData.getString("uom"):null;
		    String quantity = jsonData.has("quantity")? jsonData.getString("quantity"):null;
		    String lot = jsonData.has("lot")? jsonData.getString("lot"): null;
		    
		    result.put("data", getTransaction(transactionID, barcode, productCode, productName));
		    if (isEmptyData(result, "data")) {
		        result.put("success", false);
		    } else {
		        result.put("success", true);
		    }

		    
		}catch(Exception e) {
			log.debug("Error al cargar informacion del producto. "+ e);
		}
	    
	    return result;
	}
	
	public boolean isEmptyData(JSONObject json, String key) {
	    try {
	        if (!json.has(key) || json.isNull(key)) {
	            return true;
	        }
	        Object value = json.get(key);
	        if (value instanceof JSONObject) {
	            return ((JSONObject) value).length() == 0;
	        }
	        if (value instanceof String) {
	            return ((String) value).trim().isEmpty();
	        }
	    } catch (Exception e) {
	        return true;
	    }
	    return false;
	}

	
	public JSONObject getTransaction (String transactionID,String barcode, String productCode, String productName) throws JSONException {
		JSONObject JSONProd = new JSONObject();
		ShipmentInOut objTransaction = OBDal.getInstance().get(ShipmentInOut.class, transactionID);
		for(ShipmentInOutLine line : objTransaction.getMaterialMgmtShipmentInOutLineList()){
			if(line.getProduct() != null && !line.isEcspbConfirm()) {
				JSONArray Uoms = new JSONArray();
				Product objProd = line.getProduct();
				String UPCEAN = objProd.getUPCEAN();
				String SearchKey = objProd.getSearchKey();
				String name = objProd.getName();
				String uom = objProd.getUOM() != null ? objProd.getUOM().getName(): "";
				String uomID = objProd.getUOM() != null ? objProd.getUOM().getId(): "";
				String lot = line.getAttributeSetValue() != null? line.getAttributeSetValue().getDescription():"";
				String lotID = line.getAttributeSetValue() != null? line.getAttributeSetValue().getId():"";
				String prodID = objProd.getId();
				if( (UPCEAN != null && UPCEAN.equals(barcode)) || (SearchKey != null && SearchKey.equals(productCode))  || (name != null && name.equals(productName)) ) {
					JSONProd.put("transactionId", transactionID);
					JSONProd.put("lineID", line.getId());
					JSONProd.put("lineNo", line.getLineNo());
					JSONProd.put("barcode", UPCEAN != null? UPCEAN:"");
					JSONProd.put("productCode", SearchKey != null? SearchKey : "");
					JSONProd.put("productName", name != null? name : "");
					JSONProd.put("uom", uom);
					JSONProd.put("uomID", uomID);
					JSONProd.put("quantity", line.getMovementQuantity());
					JSONProd.put("lot", lot);
					JSONProd.put("lotID", lotID);
					JSONProd.put("productID", prodID);
					for(ProductAUM alternativeAUM : objProd.getProductAUMList()) {
						JSONObject itemuom = new JSONObject();
						itemuom.put("id", alternativeAUM.getUOM().getId());
						itemuom.put("name", alternativeAUM.getUOM().getName());
						itemuom.put("rateConversion", alternativeAUM.getConversionRate());
						Uoms.put(itemuom);
					}
					JSONProd.put("Uoms", Uoms);
					
					JSONArray lotes = new JSONArray();
					JSONObject firstItem = new JSONObject().put("id", "").put("name", "");
					lotes.put(firstItem);
					for(ShipmentInOutLine lineLote : objTransaction.getMaterialMgmtShipmentInOutLineList()) {
						if(lineLote.getProduct() != null && !lineLote.isEcspbConfirm()) {
							Product objProdLote = lineLote.getProduct();
							if(objProd.getId().equals(objProdLote.getId()) && lineLote.getAttributeSetValue() != null ) {
								String idItem = lineLote.getAttributeSetValue().getId();
								String nameItem = lineLote.getAttributeSetValue().getDescription();
								JSONObject itemLote = new JSONObject();
								itemLote.put("id", idItem);
								itemLote.put("name", nameItem);
								itemLote.put("line", lineLote.getLineNo());
								itemLote.put("qty", lineLote.getMovementQuantity());
								lotes.put(itemLote);
							}
						}
					}
					JSONProd.put("lotes", lotes);
					
					break;
				}
			}
		}
		
		return JSONProd;
	}

}
