package ec.com.sidesoft.carnidem.breakdown.ad_process;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import ec.com.sidesoft.carnidem.breakdown.ecscb_TypeBreakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_TypeBreakdownLine;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown_line;
import org.openbravo.model.materialmgmt.onhandquantity.ProductStockView;
import org.openbravo.dal.service.OBCriteria;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DocActionCreateInventory extends DalBaseProcess{

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		OBError msg = new OBError();
		try {
			String headerId = (String) bundle.getParams().get("Ecscb_Breakdown_ID");
			ecscb_breakdown objHeader = OBDal.getInstance().get(ecscb_breakdown.class, headerId);
			ConnectionProvider conn = bundle.getConnection();
			//ConnectionProvider conn = new DalConnectionProvider(false);
			
			List<ecscb_breakdown_line> lines = objHeader.getEcscbBreakdownLineList();
			
			if (lines.size() == 0) {
				msg.setType("Error");
				msg.setTitle(OBMessageUtils.messageBD("Error"));
				msg.setMessage("No se pueden crear los conteos de inventario porque el desglose no tiene líneas. Por favor, revise los datos.");
			} else {
				//Crear Inventario Fisico		
				createInventoryCount(objHeader, lines, conn);
				msg.setType("Success");
				msg.setTitle(OBMessageUtils.messageBD("Success"));
				msg.setMessage("Se ha completado la operación con éxito");
			}
		} catch (final Exception e) {
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage(" No se logró completar la operación");
		} finally {
			bundle.setResult(msg);
		}
	}
	
	public void createInventoryCount(ecscb_breakdown objHeader, List<ecscb_breakdown_line> lines, ConnectionProvider conn) throws Exception {
		// Lógica para crear un conteo de inventario fisico en base al despiece
		if(lines.size() > 0) {
			DocumentType doctype  = objHeader.getRecordType() != null && objHeader.getRecordType().getInventoryType()!= null ? objHeader.getRecordType().getInventoryType() : objHeader.getTransactionDocument();;
			
			ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Guayaquil"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSXXX");
			String formattedDate = now.format(formatter);
			String name = formattedDate + " - " + objHeader.getDocumentNo();
			
			Warehouse warehouse = objHeader.getStorageBin().getWarehouse();
			
			VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
			String newInventoryNo = Utility.getDocumentNo(conn.getConnection(), conn, vars, "",
					InventoryCount.ENTITY_NAME, doctype.getId(), doctype.getId(), false, false);
			
			InventoryCount newInventory = OBProvider.getInstance().get(InventoryCount.class);
			newInventory.setClient(objHeader.getClient());
			newInventory.setOrganization(objHeader.getOrganization());
			newInventory.setMovementDate(new Date());
			newInventory.setSsinDoctype(doctype);
			newInventory.setWarehouse(warehouse);
			newInventory.setName(name);
			newInventory.setSsinDocumentno(newInventoryNo);
			newInventory.setEcscbBreakdown(objHeader);
			OBDal.getInstance().save(newInventory);
			
			Long lineNo = 0L;
			for(ecscb_breakdown_line line : lines) {
				InventoryCountLine newInvLine = OBProvider.getInstance().get(InventoryCountLine.class);
				AttributeSetInstance attributeSetInstance = line.getAttributeSetValue() != null ? line.getAttributeSetValue() : null;
				newInvLine.setClient(line.getClient());
				newInvLine.setOrganization(line.getOrganization());
				newInvLine.setPhysInventory(newInventory);
				newInvLine.setLineNo(lineNo += 10L);
				newInvLine.setProduct(line.getProduct());
				if (attributeSetInstance != null) {
					newInvLine.setAttributeSetValue(attributeSetInstance);
				}
				newInvLine.setStorageBin(objHeader.getStorageBin());
				if (line.getNotesObservations() != null) {
					newInvLine.setDescription(line.getNotesObservations());
				}
				BigDecimal Quantity = retrivalQtyOnHand(line.getProduct(), warehouse, attributeSetInstance);
				BigDecimal qtyMass = line.getMass() != null ? line.getMass() : BigDecimal.ZERO;
				newInvLine.setQuantityCount(Quantity.add(qtyMass));
				newInvLine.setUOM(line.getUOM());
				newInvLine.setBookQuantity(Quantity);
				newInvLine.setCost(line.getUSDKg());
				OBDal.getInstance().save(newInvLine);
			}
			
			OBDal.getInstance().flush();
		}
	
	}
	
	public BigDecimal retrivalQtyOnHand(Product product, Warehouse warehouse, AttributeSetInstance attributeSetInstance) {
	  BigDecimal qtyOnHand = BigDecimal.ZERO;
		
      OBCriteria<ProductStockView> obcWarehouse = OBDal.getInstance().createCriteria(ProductStockView.class);
      if (attributeSetInstance != null) {
    	  obcWarehouse.add(Restrictions.eq(ProductStockView.PROPERTY_ATTRIBUTESETVALUE, attributeSetInstance));
      }
      obcWarehouse.add(Restrictions.eq(ProductStockView.PROPERTY_PRODUCT, product));
      obcWarehouse.add(Restrictions.eq(ProductStockView.PROPERTY_WAREHOUSE, warehouse));
      obcWarehouse.add(Restrictions.eq(ProductStockView.PROPERTY_STOCKED, true));
      List<ProductStockView> objProductStockView = obcWarehouse.list();
      
		if (objProductStockView.size() > 0) {
			try {
				OBContext.setAdminMode(true);
				for(ProductStockView stockView : objProductStockView) {
					BigDecimal qtyOnHandTemp = stockView.getQuantityOnHand() != null
							? stockView.getQuantityOnHand()
							: BigDecimal.ZERO;
					
					qtyOnHand = qtyOnHand.add(qtyOnHandTemp);
				}
			}finally {
				OBContext.restorePreviousMode();
			}
		}
    
		return qtyOnHand;
	}

}
