package ec.com.sidesoft.carnidem.breakdown.ad_process;

import java.math.BigDecimal;
import java.util.List;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import ec.com.sidesoft.carnidem.breakdown.ecscb_TypeBreakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_TypeBreakdownLine;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown_line;
import org.openbravo.base.provider.OBProvider;

public class DocActionTypeBreakdown extends DalBaseProcess{

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		OBError msg = new OBError();
		try {
			String headerId = (String) bundle.getParams().get("Ecscb_Breakdown_ID");
			ecscb_breakdown objHeader = OBDal.getInstance().get(ecscb_breakdown.class, headerId);
			
			List<ecscb_breakdown_line> lines = objHeader.getEcscbBreakdownLineList();
			Long lineNo = 0L;
			for (ecscb_breakdown_line line : lines) {
			    if (line.getLineNo() != null && line.getLineNo() > lineNo) {
			        lineNo = line.getLineNo();
			    }
			}
			
			String typeSelectedId = (String) bundle.getParams().get("ecscbTypeBreakdownId");
			ecscb_TypeBreakdown objTypeBreakdow = OBDal.getInstance().get(ecscb_TypeBreakdown.class, typeSelectedId);
			
			for(ecscb_TypeBreakdownLine template : objTypeBreakdow.getEcscbTypeBreakdownLineList()) {
				Boolean exists = false;
				Product templateProduct = template.getProduct();
				BigDecimal templatePrice = template.getUSDKg(); 
				UOM templateUom = template.getUOM();
				
				for (ecscb_breakdown_line line : lines) {
					if (line.getProduct() != null && line.getProduct().getId().equals(templateProduct.getId())) {
						line.setUOM(templateUom);
						line.setReferencePrice(templatePrice);
						OBDal.getInstance().save(line);
						exists = true;
					}
				}
				
				if (!exists) {
					lineNo += 10L;
					createLine(objHeader, template, lineNo);
				}
			}
			
			
			objHeader.setRecordType(objTypeBreakdow);
			OBDal.getInstance().save(objHeader);
			OBDal.getInstance().flush();
			
			msg.setType("Success");
			msg.setTitle(OBMessageUtils.messageBD("Success"));
			msg.setMessage("Se ha completado la operación con éxito");
				
		} catch (final Exception e) {
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage(e.getMessage());
		} finally {
			bundle.setResult(msg);
		}
	}
	
	public void createLine(ecscb_breakdown objHeader, ecscb_TypeBreakdownLine template, Long lineNo) {
		ecscb_breakdown_line newLine = OBProvider.getInstance().get(ecscb_breakdown_line.class);
		newLine.setClient(objHeader.getClient());
		newLine.setOrganization(objHeader.getOrganization());
		newLine.setEcscbBreakdown(objHeader);
		newLine.setProduct(template.getProduct());
		newLine.setReferencePrice(template.getUSDKg());
		newLine.setUOM(template.getUOM());
		newLine.setLineNo(lineNo);

		OBDal.getInstance().save(newLine);
		
	}

}
