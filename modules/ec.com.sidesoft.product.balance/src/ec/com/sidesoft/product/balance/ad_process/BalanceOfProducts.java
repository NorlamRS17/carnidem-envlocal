package ec.com.sidesoft.product.balance.ad_process;

import java.util.Map;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.hibernate.criterion.Restrictions;

public class BalanceOfProducts extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(BalanceOfProducts.class);

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();

	    try {
	    	JSONObject jsonData = new JSONObject(content);
	    	confirmScale(jsonData);
	        result.put("success", true);
	        result.put("data", jsonData);
	    } catch (Exception e) {
	        log.error("Error confirmando peso de la balanza", e);
	        try {
	            result.put("success", false);
	            result.put("message", e.getMessage());
	        } catch (Exception ignore) {}
	    }

	    return result;
	}
	
	public JSONObject confirmScale(JSONObject jsonData) throws JSONException {
		String lineID = jsonData.has("lineID")? jsonData.getString("lineID"):null;
		String productID = jsonData.has("productID")? jsonData.getString("productID"):null;
		if(lineID != null && productID != null) {
			ShipmentInOutLine objLine = OBDal.getInstance().get(ShipmentInOutLine.class, lineID);
			objLine = searchLine(jsonData, objLine);
			if(objLine != null && jsonData.has("data") && jsonData.getJSONArray("data").length()>0) {
				jsonData = groupData(jsonData);
				JSONArray dataArray = jsonData.getJSONArray("groupedData");
				JSONArray dataArrayHeavy = jsonData.getJSONArray("data");
				Long heavyUnits = (long) dataArrayHeavy.length();
				if(heavyUnits <= 0) {
					throw new OBException("Debe capturar al menos una línea antes de confirmar.");
				}
				Boolean update = false;
				for (int i = 0; i < dataArray.length(); i++) {
					JSONObject item = dataArray.getJSONObject(i);
					BigDecimal operativeQty = item.has("operativeQty")? new BigDecimal(item.getString("operativeQty")) : BigDecimal.ZERO;
					BigDecimal quantity = item.has("quantity")? new BigDecimal(item.getString("quantity")) : BigDecimal.ZERO;
					if(quantity.compareTo(BigDecimal.ZERO) <= 0) {
	    		    	throw new OBException("El valor de peso debe ser mayor que cero.");
	    		    }
					String operativeUOM = item.getString("uom");
					String lot = item.getString("lot");
					
					ShipmentInOutLine shipmentInOutLine = OBProvider.getInstance().get(ShipmentInOutLine.class);
					Long lineno = getSequenceNumber(objLine.getShipmentReceipt(), i);
					shipmentInOutLine.setLineNo(lineno);
					shipmentInOutLine.setOrganization(objLine.getOrganization());
					shipmentInOutLine.setClient(objLine.getClient());
					if(objLine.getShipmentReceipt() != null) {
						shipmentInOutLine.setShipmentReceipt(objLine.getShipmentReceipt());
					}
			        shipmentInOutLine.setProduct(objLine.getProduct());
			        shipmentInOutLine.setSprliIdentifier(objLine.getProduct().getSearchKey());
			        shipmentInOutLine.setUOM(objLine.getUOM());
			        if(lot != null) {
			        	AttributeSetInstance objLote = OBDal.getInstance().get(AttributeSetInstance.class, lot);
				        if(objLote != null) {
				        	shipmentInOutLine.setAttributeSetValue(objLote);
				        }
			        }
			        if(objLine.getStorageBin() != null) {
			        	shipmentInOutLine.setStorageBin(objLine.getStorageBin());
			        }
			        if(objLine.getSalesOrderLine() != null) {
			        	shipmentInOutLine.setSalesOrderLine(objLine.getSalesOrderLine()	);
			        }
			        if(objLine.getBusinessPartner() != null) {
			        	shipmentInOutLine.setBusinessPartner(objLine.getBusinessPartner());
			        }
			        if(operativeUOM != null ) {
			        	UOM objUOM = OBDal.getInstance().get(UOM.class, operativeUOM);
			        	if(objUOM != null) {
				        	shipmentInOutLine.setOperativeUOM(objUOM);
			        	}
			        }
			        if(objLine.getDescription() != null) {
			        	shipmentInOutLine.setDescription(objLine.getDescription());
			        }
			        if(objLine.getProject() != null) {
			        	shipmentInOutLine.setProject(objLine.getProject());
			        }
			        if(objLine.getCostcenter() != null) {
			        	shipmentInOutLine.setCostcenter(objLine.getCostcenter());
			        }
			        if(objLine.getStDimension() != null) {
			        	shipmentInOutLine.setStDimension(objLine.getStDimension());
			        }
			        if(objLine.getNdDimension() != null) {
			        	shipmentInOutLine.setNdDimension(objLine.getNdDimension());
			        }
			        shipmentInOutLine.setEcspbConfirm(true);
			        shipmentInOutLine.setEcspbHeavyunits(heavyUnits);
			        shipmentInOutLine.setOperativeQuantity(operativeQty);
			        shipmentInOutLine.setMovementQuantity(quantity);
			        shipmentInOutLine.setManagePrereservation(objLine.isManagePrereservation());
			        
			        try {
			        	OBDal.getInstance().save(shipmentInOutLine);
				        OBDal.getInstance().flush();
				        update = true;
			        }catch(Exception e) {
						throw new OBException("No se pudo insertar las líneas confirmadas. Vuelva a intentar o Contacte al administrador.");
			        }
				}
				
				updateLines(update, objLine);
			}
		}else {
			throw new OBException("No se ha encontrado la informacion del producto cargado.");
		}
		
		return jsonData;
	}
	
	public void updateLines(Boolean validator, ShipmentInOutLine objLine) {
		try {
			ShipmentInOut objHeader = objLine.getShipmentReceipt();
			objHeader.getMaterialMgmtShipmentInOutLineList().remove(objLine);
	        OBDal.getInstance().remove(objLine);
	        OBDal.getInstance().flush();
	        
	        List<ShipmentInOutLine> listLines = new ArrayList<>(objHeader.getMaterialMgmtShipmentInOutLineList());
	        listLines.sort(Comparator.comparing(ShipmentInOutLine::getCreationDate));
	        long lineNumber = 10L;
	        for (ShipmentInOutLine line : listLines) {
	            line.setLineNo(lineNumber);
	            OBDal.getInstance().save(line);
	            lineNumber += 10;
	        }
	        OBDal.getInstance().flush();
		}catch (Exception e) {
			throw new OBException("No se pudo insertar las líneas confirmadas. Vuelva a intentar o Contacte al administrador.");
		}
	}
	
	public JSONObject groupData(JSONObject jsonData) throws JSONException {
		JSONArray dataArray = jsonData.getJSONArray("data");

        // Mapa para agrupar por clave compuesta
        Map<String, JSONObject> groupedMap = new LinkedHashMap<>();

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject item = dataArray.getJSONObject(i);

            // Clave de los campos agrupadores
            String key = item.getString("uom") + "|" +
                         item.getString("uomMain") + "|" +
                         item.optString("lot", "");

            if (groupedMap.containsKey(key)) {
                JSONObject existing = groupedMap.get(key);
                
                // OperativeQty
                double totalOperativeQty = existing.getDouble("operativeQty") + item.getDouble("operativeQty");
                existing.put("operativeQty", totalOperativeQty);

                // Quantity
                double totalQty = existing.getDouble("quantity") + item.getDouble("quantity");
                existing.put("quantity", totalQty);

            } else {
                JSONObject clone = new JSONObject(item.toString());
                groupedMap.put(key, clone);
            }
        }

        // Crear nuevo JSONArray con los objetos agrupados
        JSONArray groupedData = new JSONArray();
        for (JSONObject obj : groupedMap.values()) {
            groupedData.put(obj);
        }

        jsonData.put("groupedData", groupedData);
		return jsonData;
	}
	
	public Long getSequenceNumber(ShipmentInOut shipmentInOut, int line) throws OBException {
		OBCriteria<ShipmentInOutLine> obc = OBDal.getInstance().createCriteria(ShipmentInOutLine.class);
		obc.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_SHIPMENTRECEIPT, shipmentInOut));
		obc.addOrderBy(ShipmentInOutLine.PROPERTY_LINENO, false);
		obc.setFilterOnReadableOrganization(false);
		
		List<ShipmentInOutLine> lines = obc.list();
	    return (lines.size() + (long)line) * 10L;
	}
	
	public ShipmentInOutLine searchLine(JSONObject jsonData, ShipmentInOutLine objLine) throws JSONException {
		if (jsonData.has("formData")) {
			JSONObject formData = jsonData.getJSONObject("formData");
			if (formData.has("lot") && !formData.getString("lot").equals("")) {
				String strLote = formData.getString("lot");
				ShipmentInOut objHeader = objLine.getShipmentReceipt();
				for (ShipmentInOutLine line : objHeader.getMaterialMgmtShipmentInOutLineList()) {
					if (line.getProduct() != null && !line.isEcspbConfirm()) {
						Product objProductOrigin = objLine.getProduct();
						Product objProduct = line.getProduct();
						if ((objProductOrigin.getId().equals(objProduct.getId()))
								&& (line.getAttributeSetValue() != null)) {
							if (strLote.equals(line.getAttributeSetValue().getId())) {
								objLine = line;
								break;
							}
						}
					}
				}
			}
		}
		return objLine;
	}

}
