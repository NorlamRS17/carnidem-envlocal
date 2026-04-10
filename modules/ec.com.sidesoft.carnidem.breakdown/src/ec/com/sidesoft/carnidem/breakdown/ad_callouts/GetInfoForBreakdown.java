package ec.com.sidesoft.carnidem.breakdown.ad_callouts;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.servlet.ServletException;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;

import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBCriteria;
import org.hibernate.criterion.Restrictions;

public class GetInfoForBreakdown extends SimpleCallout{

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// TODO Auto-generated method stub
		String headerId = info.getStringParameter("inpecscbBreakdownId", null);
		String inpadOrgId = info.getStringParameter("inpadOrgId", null);
		
		//Recuperar la precision de la moneda de la organización para redondear los cálculos
		Organization objOrganization = OBDal.getInstance().get(Organization.class, inpadOrgId);
		Long currencyPrecision = new Long(2); //Valor por defecto en caso de no recuperar la organización o la moneda
		if (objOrganization != null && objOrganization.getCurrency() != null && currencyPrecision != null) {
			currencyPrecision = objOrganization.getCurrency().getCostingPrecision();
		}
		int scale = currencyPrecision.intValue();
		
		ecscb_breakdown objHeader = OBDal.getInstance().get(ecscb_breakdown.class, headerId);
		
		String inoutId = info.getStringParameter("inpmInoutId", null);
		
		ShipmentInOut objShipmentInOut = OBDal.getInstance().get(ShipmentInOut.class, inoutId);
		if(objShipmentInOut != null) {
			info.addResult("inpcBpartnerId", objShipmentInOut.getBusinessPartner().getId());
            //se obtener el primer id de producto de las lineas de la remision, para mostrarlo en el desglose
			objShipmentInOut.getMaterialMgmtShipmentInOutLineList().stream().findFirst().ifPresent(line -> {
				if (line.getAttributeSetValue() != null) {
				    info.addResult("inpmAttributesetinstanceId", line.getAttributeSetValue().getId());
				}else {
					info.addResult("inpmAttributesetinstanceId", "");
				}
				
				if (line.getStorageBin() != null) {
					info.addResult("inpmLocatorId", line.getStorageBin().getId());
				}
			});
			info.addResult("inpwarehouseEntryNo", getDocumentNo(objHeader, objShipmentInOut));
			info.addResult("inpentryDate", objShipmentInOut.getMovementDate());
			info.addResult("inpcBpartnerId", objShipmentInOut.getBusinessPartner().getId());
			info.addResult("inpcBpartnerId", objShipmentInOut.getBusinessPartner().getId());
		}
		
		BigDecimal inptotalMass = info.getBigDecimalParameter("inptotalMass");
		if (inptotalMass == null) {
		    inptotalMass = BigDecimal.ZERO;
		}

		BigDecimal inpnumberOfPieces = info.getBigDecimalParameter("inpnumberOfPieces");
		if (inpnumberOfPieces == null) {
		    inpnumberOfPieces = BigDecimal.ZERO;
		}

		
		//Comparar si es mayor a 0 los dos campos, se continua el flujo
		if(inptotalMass.compareTo(BigDecimal.ZERO) > 0 && inpnumberOfPieces.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal inpmassPerPiece = inptotalMass.divide(
				    inpnumberOfPieces, 
				    scale, 
				    RoundingMode.HALF_UP
				);
            info.addResult("inpmassPerPiece", inpmassPerPiece);
		}else {
			info.addResult("inpmassPerPiece", BigDecimal.ZERO.setScale(scale));
		}
		
		//Purchase_Value = Unit_Price * inptotalMass
		BigDecimal inpunitPrice = info.getBigDecimalParameter("inpunitPrice");
		if (inpunitPrice == null) {
		    inpunitPrice = BigDecimal.ZERO;
		}
		
		if(inpunitPrice.compareTo(BigDecimal.ZERO) > 0 && inptotalMass.compareTo(BigDecimal.ZERO) > 0) {
			BigDecimal inppurchaseValue = inpunitPrice.multiply(inptotalMass)
			        .setScale(scale, RoundingMode.HALF_UP);
			info.addResult("inppurchaseValue", inppurchaseValue);
		}else {
			info.addResult("inppurchaseValue", BigDecimal.ZERO.setScale(scale));
		}
			
	}
	
	public String getDocumentNo(ecscb_breakdown objHeader, ShipmentInOut objShipmentInOut) {
		OBCriteria<ecscb_breakdown> q = OBDal.getInstance().createCriteria(ecscb_breakdown.class);
	    q.add(Restrictions.eq(ecscb_breakdown.PROPERTY_GOODSSHIPMENT,objShipmentInOut));
	    q.add(Restrictions.ne(ecscb_breakdown.PROPERTY_ID,objHeader == null? "NEW": objHeader.getId()));
		List<ecscb_breakdown> list = q.list();
		String documentNo = objShipmentInOut.getDocumentNo()+" - "+(list.size()+1);
		return documentNo;
	}

}
