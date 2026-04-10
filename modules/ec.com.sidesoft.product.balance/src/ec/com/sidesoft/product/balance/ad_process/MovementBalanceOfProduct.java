package ec.com.sidesoft.product.balance.ad_process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;

import ec.com.sidesoft.product.balance.ad_actionbutton.ValidateStock;

public class MovementBalanceOfProduct extends BaseActionHandler{
	private static final Logger log = Logger.getLogger(MovementBalanceOfProduct.class);

	@Override
	protected JSONObject execute(Map<String, Object> parameters, String content) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();

	    try {
	    	JSONObject jsonData = new JSONObject(content);
	    	jsonData = groupData(jsonData);
	    	availableStockAndProcess(jsonData);
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
	
	public void availableStockAndProcess(JSONObject jsonData) throws JSONException {
		ValidateStock classValidator = new ValidateStock();
		JSONArray dataArray = jsonData.getJSONArray("groupedDataStock");
		if(dataArray.length() <= 0) {
			throw new OBException("Debe capturar al menos una línea antes de confirmar.");
		}
		String lineID = jsonData.has("lineID") ? jsonData.getString("lineID") : "";
        String productID = jsonData.has("productID") ? jsonData.getString("productID") : "";
        InternalMovementLine objLine = OBDal.getInstance().get(InternalMovementLine.class, lineID);
        objLine = searchLine(jsonData, objLine);
		Product objProd = OBDal.getInstance().get(Product.class, productID);
        if(objLine != null && objProd != null) {
        	for (int i = 0; i < dataArray.length(); i++) {
                JSONObject item = dataArray.getJSONObject(i);
    		    String storageId = item.has("origen")? item.getString("origen"): "";
    		    Locator objLocator = OBDal.getInstance().get(Locator.class, storageId);
    		    BigDecimal quantity = item.has("quantity")? new BigDecimal(item.getString("quantity")) : BigDecimal.ZERO;
    		    if(quantity.compareTo(BigDecimal.ZERO) <= 0) {
    		    	throw new OBException("El valor de peso debe ser mayor que cero.");
    		    }
    		    if(objLocator == null) {
    		    	throw new OBException("No se ha encontrado la informacion del local de origen. "+ storageId);
    		    }
    		    Boolean stock = classValidator.validateStock(objLocator, objProd, objLine.getAttributeSetValue(), quantity);
    		    if(!stock) {
    		    	throw new OBException("No se ha encontrado suficiente stock. "+ objLocator.getSearchKey()+ " : "+objProd.getSearchKey());
    		    }
            }
        }else {
        	throw new OBException("Producto no relacionado al documento seleccionado.");
        }
        
        createMovementLines(jsonData, objLine, objProd);
	}
	
	public void createMovementLines(JSONObject jsonData, InternalMovementLine objLine, Product objProd) throws JSONException {
		JSONArray dataArray = jsonData.getJSONArray("groupedData");
		if(dataArray.length() <= 0) {
			throw new OBException("Debe capturar al menos una línea antes de confirmar.");
		}
		
		Boolean update = false;
		for (int i = 0; i < dataArray.length(); i++) {
            JSONObject item = dataArray.getJSONObject(i);
		    BigDecimal operativeQty = item.has("operativeQty")? new BigDecimal(item.getString("operativeQty")) : BigDecimal.ZERO;
		    String operativeUOM = item.has("uom")? item.getString("uom"): "";
		    String uomMain = item.has("uomMain")? item.getString("uomMain"): "";
		    BigDecimal quantity = item.has("quantity")? new BigDecimal(item.getString("quantity")) : BigDecimal.ZERO;
		    String lot = item.getString("lot");
		    String origenId = item.has("origen")? item.getString("origen"): "";
		    String destinoId = item.has("destino")? item.getString("destino"): "";
		    Locator objOrigen= OBDal.getInstance().get(Locator.class, origenId);
		    Locator objDestino = OBDal.getInstance().get(Locator.class, destinoId);
		    if(objOrigen == null || objDestino == null) {
		    	throw new OBException("No se ha encontrado los almacenes.");
		    }
		    
		    InternalMovementLine newLine = OBProvider.getInstance().get(InternalMovementLine.class);
		    String SprliIdentifier = objLine.getSprliIdentifier();
		    newLine.setClient(objLine.getClient());
            newLine.setOrganization(objLine.getOrganization());
            newLine.setMovement(objLine.getMovement());
            newLine.setLineNo(getSequenceNumber(objLine.getMovement(), i));
            newLine.setStorageBin(objOrigen);
            newLine.setNewStorageBin(objDestino);
            newLine.setProduct(objProd);
            newLine.setMovementQuantity(quantity);
            newLine.setSprliIdentifier(SprliIdentifier);
            newLine.setDescription(objLine.getDescription() != null ? objLine.getDescription() : "");
            newLine.setOperativeQuantity(operativeQty);
            
            UOM objUOM = OBDal.getInstance().get(UOM.class, operativeUOM);
        	if(objUOM != null) {
        		newLine.setAlternativeUOM(objUOM);
        	}
        	UOM objUomMain = OBDal.getInstance().get(UOM.class, uomMain);
        	if(objUOM != null) {
        		newLine.setUOM(objUomMain);
        	}
        	
        	if(objLine.getAttributeSetValue() != null) {
        		newLine.setAttributeSetValue(objLine.getAttributeSetValue());
        	}
            
            newLine.setSmvaiIsreceived(objLine.isSmvaiIsreceived());
            if(lot != null) {
	        	AttributeSetInstance objLote = OBDal.getInstance().get(AttributeSetInstance.class, lot);
		        if(objLote != null) {
		        	newLine.setAttributeSetValue(objLote);
		        }
	        }
            if(newLine.getStockReservation() != null) {
            	newLine.setStockReservation(newLine.getStockReservation());
            }
            newLine.setEcspbConfirm(true);
            
            try {
            	OBDal.getInstance().save(newLine);
                OBDal.getInstance().flush();
                update = true;
            }catch(Exception e) {
            	throw new OBException("No se pudo insertar las líneas confirmadas. Vuelva a intentar o Contacte al administrador.");
            }
            
        }
		
		updateLines(update, objLine);
		
	}
	
	public void updateLines(Boolean validator, InternalMovementLine objLine) {
		try {
			InternalMovement objHeader = objLine.getMovement();
			objHeader.getMaterialMgmtInternalMovementLineList().remove(objLine);
			OBDal.getInstance().remove(objLine);
			OBDal.getInstance().flush();

			List<InternalMovementLine> listLines = new ArrayList<>(objHeader.getMaterialMgmtInternalMovementLineList());
			listLines.sort(Comparator.comparing(InternalMovementLine::getCreationDate));
			long lineNumber = 10L;
			for (InternalMovementLine line : listLines) {
				line.setLineNo(lineNumber);
				OBDal.getInstance().save(line);
				lineNumber += 10;
			}
			OBDal.getInstance().flush();
		} catch (Exception e) {
			throw new OBException("No se pudo insertar las líneas confirmadas. Vuelva a intentar o Contacte al administrador.");
		}
	}
	
	public JSONObject groupData(JSONObject jsonData) throws JSONException {
		JSONArray dataArray = jsonData.getJSONArray("data");
		
		if(dataArray.length() <= 0) {
			throw new OBException("Debe capturar al menos una línea antes de confirmar.");
		}

        // Mapa para agrupar por clave compuesta
        Map<String, JSONObject> groupedMap = new LinkedHashMap<>();
        
        // Mapa para agrupar por clave compuesta - Stock
        Map<String, JSONObject> groupedMapStock = new LinkedHashMap<>();

        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject item = dataArray.getJSONObject(i);

            // Clave de los campos agrupadores
            String key = item.getString("uom") + "|" +
                         item.getString("uomMain") + "|" +
                         item.getString("origen") + "|" +
                         item.getString("destino") + "|" +
                         item.optString("lot", "");
            
            // Clave de los campos agrupadores Stock
            String key2 = item.getString("uomMain") + "|" +
                         item.getString("origen") + "|" +
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
            
            if (groupedMapStock.containsKey(key2)) {
                JSONObject existing = groupedMapStock.get(key2);
                
                // Quantity
                double totalQty = existing.getDouble("quantity") + item.getDouble("quantity");
                existing.put("quantity", totalQty);

            } else {
                JSONObject clone = new JSONObject(item.toString());
                groupedMapStock.put(key2, clone);
            }
            
        }

        // Crear nuevo JSONArray con los objetos agrupados
        JSONArray groupedData = new JSONArray();
        for (JSONObject obj : groupedMap.values()) {
            groupedData.put(obj);
        }
        jsonData.put("groupedData", groupedData);
        
        // Crear nuevo JSONArray con los objetos agrupados - Stock
        JSONArray groupedDataStock = new JSONArray();
        for (JSONObject obj : groupedMapStock.values()) {
        	groupedDataStock.put(obj);
        }
        jsonData.put("groupedDataStock", groupedDataStock);
        
        
		return jsonData;
	}
	
	public Long getSequenceNumber(InternalMovement objMovement, int line) throws OBException {
		OBCriteria<InternalMovementLine> obc = OBDal.getInstance().createCriteria(InternalMovementLine.class);
		obc.add(Restrictions.eq(InternalMovementLine.PROPERTY_MOVEMENT, objMovement));
		obc.addOrderBy(InternalMovementLine.PROPERTY_LINENO, false);
		obc.setFilterOnReadableOrganization(false);
		
		List<InternalMovementLine> lines = obc.list();
	    return (lines.size() + (long)line) * 10L;
	}
	
	public InternalMovementLine searchLine(JSONObject jsonData, InternalMovementLine objLine) throws JSONException {
		if (jsonData.has("formData")) {
			JSONObject formData = jsonData.getJSONObject("formData");
			if (formData.has("lot") && !formData.getString("lot").equals("")) {
				String strLote = formData.getString("lot");
				InternalMovement objHeader = objLine.getMovement();
				for (InternalMovementLine line : objHeader.getMaterialMgmtInternalMovementLineList()) {
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
