package ec.com.sidesoft.product.balance.ad_actionbutton;

import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductAUM;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.hibernate.Query;
import org.openbravo.database.SessionInfo;
import org.openbravo.service.db.DalConnectionProvider;


public class LoadMovement extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(LoadMovement.class);

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();

	    try {
	    	JSONObject jsonData = new JSONObject(content);
	    	
			String transactionID = jsonData.getString("transactionId");
		    String barcode = jsonData.has("barcode")? jsonData.getString("barcode"): null;
		    String productCode = jsonData.has("productCode")? jsonData.getString("productCode"):null;
		    String productName = jsonData.has("productName")? jsonData.getString("productName"):null;
		    jsonData = getTransaction(transactionID, barcode, productCode, productName);
		    if (isEmptyData(jsonData, "transactionId")) {
		        result.put("success", false);
		    } else {
		        result.put("success", true);
		    }
	        result.put("data", jsonData);
	    } catch (Exception e) {
	        log.debug("Error cargando informacion del producto", e);
	        try {
	            result.put("success", false);
	            result.put("message", e.getMessage());
	        } catch (Exception ignore) {}
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
		InternalMovement objTransaction = OBDal.getInstance().get(InternalMovement.class, transactionID);
		for(InternalMovementLine line : objTransaction.getMaterialMgmtInternalMovementLineList()){
			if(line.getProduct() != null && !line.isEcspbConfirm()) {
				JSONArray Uoms = new JSONArray();
				JSONArray Storages = new JSONArray();
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
					JSONProd.put("origenID", line.getStorageBin() != null ? line.getStorageBin().getId() : "");
					JSONProd.put("origen", line.getStorageBin() != null ? line.getStorageBin().getSearchKey() : "");
					JSONProd.put("destinoID", line.getNewStorageBin() != null ? line.getNewStorageBin().getId() : "");
					JSONProd.put("destino", line.getNewStorageBin() != null ? line.getNewStorageBin().getSearchKey() : "");
					for(ProductAUM alternativeAUM : objProd.getProductAUMList()) {
						JSONObject itemuom = new JSONObject();
						itemuom.put("id", alternativeAUM.getUOM().getId());
						itemuom.put("name", alternativeAUM.getUOM().getName());
						itemuom.put("rateConversion", alternativeAUM.getConversionRate());
						Uoms.put(itemuom);
					}
					JSONProd.put("Uoms", Uoms);
					JSONProd.put("storages", getLocatorsByOrgId(objTransaction.getOrganization().getId()));
					
					JSONArray lotes = new JSONArray();
					JSONObject firstItem = new JSONObject().put("id", "").put("name", "");
					lotes.put(firstItem);
					for(InternalMovementLine lineLote : objTransaction.getMaterialMgmtInternalMovementLineList()) {
						if(lineLote.getProduct() != null && !lineLote.isEcspbConfirm()) {
							Product objProdLote = lineLote.getProduct();
							if(objProd.getId().equals(objProdLote.getId()) && lineLote.getAttributeSetValue() != null ) {
								String idItem = lineLote.getAttributeSetValue().getId();
								String nameItem = lineLote.getAttributeSetValue().getDescription();
								JSONObject itemLote = new JSONObject();
								String origenID = lineLote.getStorageBin() != null ? lineLote.getStorageBin().getId() : "";
								String destinoID = lineLote.getNewStorageBin() != null ? lineLote.getNewStorageBin().getId() : "";
								itemLote.put("id", idItem);
								itemLote.put("name", nameItem);
								itemLote.put("line", lineLote.getLineNo());
								itemLote.put("qty", lineLote.getMovementQuantity());
								itemLote.put("origenID", origenID);
								itemLote.put("destinoID", destinoID);
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
	
	public static JSONArray getLocatorsByOrgId(String orgId) {
		DalConnectionProvider conn = new DalConnectionProvider(false);
		JSONArray jsonArray = new JSONArray();
	    String sql = "SELECT mw.ad_org_id, ml.m_locator_id, ml.value " +
	                 "FROM M_Locator ml " +
	                 "LEFT JOIN M_Warehouse mw ON ml.m_warehouse_id = mw.m_warehouse_id " +
	                 "WHERE mw.ad_org_id = ?";

	    PreparedStatement st = null;
	    ResultSet rs = null;

	    try {
	        st = conn.getPreparedStatement(sql);
	        st.setString(1, orgId);

	        QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
	        rs = st.executeQuery();

	        while (rs.next()) {
	            JSONObject obj = new JSONObject();
	            obj.put("ad_org_id", rs.getString("ad_org_id"));
	            obj.put("id", rs.getString("m_locator_id"));
	            obj.put("name", rs.getString("value"));
	            jsonArray.put(obj);
	        }

	    } catch (Exception e) {
	    	log.debug("Error al consultar almacenes y huecos de la orgnizacion", e);
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (st != null) st.close();
	        } catch (Exception e) {
	        	log.debug("Error al cerrar conexiones creadas para el query", e);
	        }
	    }

	    return jsonArray;
	}

}
