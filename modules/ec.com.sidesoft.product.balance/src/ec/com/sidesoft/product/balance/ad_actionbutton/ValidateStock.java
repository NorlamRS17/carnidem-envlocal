package ec.com.sidesoft.product.balance.ad_actionbutton;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.common.enterprise.Locator;



public class ValidateStock extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(ValidateStock.class);

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();

	    try {
	    	JSONObject jsonData = new JSONObject(content);
	    	
	    	String lineID = jsonData.has("lineID")? jsonData.getString("lineID"): "";
		    String productID = jsonData.has("productID")? jsonData.getString("productID"): "";
		    String storageId = jsonData.has("storageId")? jsonData.getString("storageId"): "";
		    BigDecimal quantity = jsonData.has("quantity")? new BigDecimal(jsonData.getString("quantity")) : BigDecimal.ZERO; 
		    //jsonData = getTransaction(transactionID, barcode, productCode, productName);
		    InternalMovementLine objLine = OBDal.getInstance().get(InternalMovementLine.class, lineID);
			Product objProd = OBDal.getInstance().get(Product.class, productID);
			Locator objStorage = OBDal.getInstance().get(Locator.class, storageId);
			if(objLine != null && objProd != null && objStorage != null) {
				Boolean stock= validateStock(objStorage, objProd, objLine.getAttributeSetValue(), quantity);
				if(!stock) {
					throw new OBException("Verificar el stock del almacen seleccionado.");
				}
			}else {
				throw new OBException("Verificar la informacion cargada del producto.");
			}
	        result.put("success", true);
	        result.put("data", jsonData);
	    } catch (Exception e) {
	        log.debug("Error comprobando stock", e);
	        try {
	            result.put("success", false);
	            result.put("message", e.getMessage());
	        } catch (Exception ignore) {}
	    }

	    return result;
	}
	
	public Boolean validateStock(Locator objLocator, Product objProd, AttributeSetInstance objLote, BigDecimal qtyMov) {
		DalConnectionProvider conn = new DalConnectionProvider(false);
		
		Boolean response = false;

		String sql = "SELECT COUNT(*) AS records " + 
				"FROM M_Storage_Detail s " + 
				"WHERE s.M_Locator_ID = ? " + 
				"AND s.M_Product_ID = ? " + 
				"AND s.QtyOnHand >= ? " ;
		if(objLote != null) {
			sql = sql + "AND s.M_AttributeSetInstance_ID = ?";
		}

		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.getPreparedStatement(sql);
			st.setString(1, objLocator.getId());
			st.setString(2, objProd.getId());
			st.setBigDecimal(3, qtyMov);
			if(objLote != null) {
				st.setString(4, objLote.getId());
			}

			QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
			rs = st.executeQuery();

			if (rs.next()) {
				response = rs.getInt("records") > 0;
			}
		} catch (Exception e) {
			log.debug("Error al validar stock: " + e.getMessage(), e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} catch (Exception e) {
				log.debug("Error al cerrar recursos: " + e.getMessage(), e);
			}
		}

		return response;
	}

}
