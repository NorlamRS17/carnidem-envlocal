package ec.com.sidesoft.carnidem.breakdown.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;

import ec.com.sidesoft.carnidem.breakdown.BreakdownLineUsdCalculator;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown_line;

public class GetInfoForBreakdownLine extends SimpleCallout{

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// TODO Auto-generated method stub
		String headerId = info.getStringParameter("inpecscbBreakdownId", null);
		Boolean isNewLine = false;
		String lineId = info.getStringParameter("inpecscbBreakdownLineId", null);
		if (lineId == null || lineId.isEmpty()) {
			isNewLine = true;
		}
		
		//Recuperar la precision de la moneda de la organización para redondear los cálculos
		String inpadOrgId = info.getStringParameter("inpadOrgId", null);
		Organization objOrganization = OBDal.getInstance().get(Organization.class, inpadOrgId);
		int scale = BreakdownLineUsdCalculator.currencyScale(objOrganization);
		
		ecscb_breakdown objHeader = OBDal.getInstance().get(ecscb_breakdown.class, headerId);
		
		String inpmProductId = info.getStringParameter("inpmProductId", null);
		Product objProduct = OBDal.getInstance().get(Product.class, inpmProductId);
		if(objProduct != null) {
			info.addResult("inpcUom", objProduct.getUOM().getId());
		}
		
		BigDecimal inpmass = info.getBigDecimalParameter("inpmass");
		if (inpmass == null) {
			inpmass = BigDecimal.ZERO.setScale(scale);
		}
		
		//sumLinesMass
		BigDecimal sumLinesMass = BigDecimal.ZERO.setScale(scale);
		sumLinesMass = objHeader.getTotalMass();
		BigDecimal inppercentageQualityTotal = BigDecimal.ZERO.setScale(scale);
		for(ecscb_breakdown_line lines : objHeader.getEcscbBreakdownLineList() ) {
			//sumLinesMass = sumLinesMass.add(lines.getMass() != null ? lines.getMass() : BigDecimal.ZERO.setScale(scale));
			inppercentageQualityTotal = inppercentageQualityTotal.add(lines.getPercentageQuality() != null ? lines.getPercentageQuality() : BigDecimal.ZERO);
			
		}
		
		if(isNewLine) {
			//sumLinesMass = sumLinesMass.add(inpmass);
			inppercentageQualityTotal = inppercentageQualityTotal
					.add(info.getBigDecimalParameter("inppercentageQuality") != null
							? info.getBigDecimalParameter("inppercentageQuality")
							: BigDecimal.ZERO.setScale(scale));
		}
		
		//inppercentageTotalMass = (inpmass / sumLinesMass) * 100
		BigDecimal inppercentageTotalMass = BreakdownLineUsdCalculator.computePercentageTotalMass(inpmass,
				sumLinesMass, scale);
		if (inppercentageTotalMass.compareTo(BigDecimal.ZERO) > 0) {
			info.addResult("inppercentageTotalMass", inppercentageTotalMass);
		} else {
			info.addResult("inppercentageTotalMass", BigDecimal.ZERO.setScale(scale));
		}
		
		//inpreferencePrice
		BigDecimal inpreferencePrice = info.getBigDecimalParameter("inpreferencePrice");
		if (inpreferencePrice == null) {
			inpreferencePrice = BigDecimal.ZERO.setScale(scale);
		}
		
		//inppercentageQuality = (inppercentageTotalMass * inpreferencePrice) / 100
		BigDecimal inppercentageQuality = BreakdownLineUsdCalculator.computePercentageQuality(inppercentageTotalMass,
				inpreferencePrice, inpmass, scale);
		if (inppercentageQuality.compareTo(BigDecimal.ZERO) > 0) {
			info.addResult("inppercentageQuality", inppercentageQuality);
		} else {
			info.addResult("inppercentageQuality", BigDecimal.ZERO.setScale(scale));
		}
		
		
		// inpvalueUsd = (inppercentageQuality * inppercentageQualityTotal) * 100
		BigDecimal inpvalueUsdCalculated = BreakdownLineUsdCalculator.computeValueUsd(inppercentageQuality,
				inppercentageQualityTotal, inpmass, scale);
		info.addResult("inpvalueUsd", inpvalueUsdCalculated);
		
		//inpusdKg coherente con el valor USD calculado en esta misma ejecución
		BigDecimal inpusdKg = BreakdownLineUsdCalculator.computeUsdKg(inpvalueUsdCalculated, inpmass, scale);
		info.addResult("inpusdKg", inpusdKg);
		
		
		
	}

}
