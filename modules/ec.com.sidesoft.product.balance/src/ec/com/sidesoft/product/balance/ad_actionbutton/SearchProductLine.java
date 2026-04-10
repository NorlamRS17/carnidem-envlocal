package ec.com.sidesoft.product.balance.ad_actionbutton;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductAUM;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;


public class SearchProductLine extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(SearchProductLine.class);

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
		Product objProd = searchProduct(barcode, productCode, productName);
		
			if(objProd != null) {
				JSONArray Uoms = new JSONArray();
				JSONArray Storages = new JSONArray();
				String UPCEAN = objProd.getUPCEAN();
				String SearchKey = objProd.getSearchKey();
				String name = objProd.getName();
				String uom = objProd.getUOM() != null ? objProd.getUOM().getName(): "";
				String uomID = objProd.getUOM() != null ? objProd.getUOM().getId(): "";
				String prodID = objProd.getId();
				for(InternalMovementLine line : objTransaction.getMaterialMgmtInternalMovementLineList()){
					if(line.getProduct().getId().equals(prodID) && line.isEcspbConfirm() ) {
						 throw new OBException("Este documento ya ha sido confirmado. No puede volver a confirmar las mismas líneas.");
					}
				}
				
					JSONProd.put("transactionId", transactionID);
					JSONProd.put("barcode", UPCEAN != null? UPCEAN:"");
					JSONProd.put("productCode", SearchKey != null? SearchKey : "");
					JSONProd.put("productName", name != null? name : "");
					JSONProd.put("uom", uom);
					JSONProd.put("uomID", uomID);
					JSONProd.put("quantity", new BigDecimal("1"));
					JSONProd.put("productID", prodID);
					for(ProductAUM alternativeAUM : objProd.getProductAUMList()) {
						JSONObject itemuom = new JSONObject();
						itemuom.put("id", alternativeAUM.getUOM().getId());
						itemuom.put("name", alternativeAUM.getUOM().getName());
						itemuom.put("rateConversion", alternativeAUM.getConversionRate());
						Uoms.put(itemuom);
					}
					JSONProd.put("Uoms", Uoms);
					JSONProd.put("storages", getLocatorsByOrgId(objTransaction.getOrganization().getId()));
				
			}
		
		return JSONProd;
	}
	
	public Product searchProduct(String barcode, String productCode, String productName) {
	    Product objProd = null;
	    StringBuilder whereClause = new StringBuilder();
	    whereClause.append(" WHERE ");
	    whereClause.append(Product.PROPERTY_ACTIVE + " = 'Y'");
	    whereClause.append(" AND (");
	    whereClause.append(Product.PROPERTY_UPCEAN + " = :barcode");
	    whereClause.append(" OR " + Product.PROPERTY_SEARCHKEY + " = :productCode");
	    whereClause.append(" OR " + Product.PROPERTY_NAME + " = :productName");
	    whereClause.append(")");

	    OBQuery<Product> qProducts = OBDal.getInstance().createQuery(Product.class, whereClause.toString());
	    qProducts.setNamedParameter("barcode", barcode);
	    qProducts.setNamedParameter("productCode", productCode);
	    qProducts.setNamedParameter("productName", productName);

	    List<Product> results = qProducts.list();
	    if (!results.isEmpty()) {
	        objProd = results.get(0);
	    } else {
	        throw new OBException("Código de barras no reconocido. Verifique el producto o escanee nuevamente.");
	    }

	    return objProd;
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
