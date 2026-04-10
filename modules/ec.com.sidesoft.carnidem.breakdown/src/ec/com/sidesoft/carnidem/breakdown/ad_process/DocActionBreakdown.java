package ec.com.sidesoft.carnidem.breakdown.ad_process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import ec.com.sidesoft.carnidem.breakdown.BreakdownLineUsdCalculator;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown_line;

public class DocActionBreakdown extends DalBaseProcess {

	/**
	 * Recalcula % masa, % calidad, valor USD y USD/kg de cada línea con la misma lógica que el
	 * callout, usando ya todas las líneas definitivas (suma global de percentageQuality correcta).
	 */
	private void recalculateLineAmountsForComplete(ecscb_breakdown header) {
		int scale = BreakdownLineUsdCalculator.currencyScale(header.getOrganization());
		BigDecimal headerTotalMass = header.getTotalMass();
		List<ecscb_breakdown_line> lines = new ArrayList<>(header.getEcscbBreakdownLineList());
		int n = lines.size();
		BigDecimal[] pctTotalMass = new BigDecimal[n];
		BigDecimal[] pctQuality = new BigDecimal[n];
		BigDecimal sumPercentageQuality = BigDecimal.ZERO;
		for (int i = 0; i < n; i++) {
			ecscb_breakdown_line line = lines.get(i);
			BigDecimal mass = line.getMass() != null ? line.getMass() : BigDecimal.ZERO;
			BigDecimal refPrice = line.getReferencePrice() != null ? line.getReferencePrice() : BigDecimal.ZERO;
			pctTotalMass[i] = BreakdownLineUsdCalculator.computePercentageTotalMass(mass, headerTotalMass, scale);
			pctQuality[i] = BreakdownLineUsdCalculator.computePercentageQuality(pctTotalMass[i], refPrice, mass, scale);
			sumPercentageQuality = sumPercentageQuality.add(pctQuality[i]);
		}
		for (int i = 0; i < n; i++) {
			ecscb_breakdown_line line = lines.get(i);
			BigDecimal mass = line.getMass() != null ? line.getMass() : BigDecimal.ZERO;
			BigDecimal valueUsd = BreakdownLineUsdCalculator.computeValueUsd(pctQuality[i], sumPercentageQuality, mass,
					scale);
			BigDecimal usdKg = BreakdownLineUsdCalculator.computeUsdKg(valueUsd, mass, scale);
			line.setPercentageTotalMass(pctTotalMass[i]);
			line.setPercentageQuality(pctQuality[i]);
			line.setValueUsd(valueUsd);
			line.setUSDKg(usdKg);
			OBDal.getInstance().save(line);
		}
	}

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		OBError msg = new OBError();
		try {
			String headerId = (String) bundle.getParams().get("Ecscb_Breakdown_ID");
			ecscb_breakdown objHeader = OBDal.getInstance().get(ecscb_breakdown.class, headerId);
			BigDecimal totalMass = objHeader.getTotalMass();
			BigDecimal sumLinesMass = BigDecimal.ZERO;
			
			Boolean needAttributeSetValue = false;
			String errorMessage = "";
			for (ecscb_breakdown_line line : objHeader.getEcscbBreakdownLineList()) {
				sumLinesMass = sumLinesMass.add(line.getMass() != null ? line.getMass() : BigDecimal.ZERO);
				if(line.getProduct() != null && line.getProduct().getAttributeSet() != null && line.getAttributeSetValue() == null) {
					needAttributeSetValue = true;
					errorMessage = "El producto " + line.getProduct().getName() + " requiere que se ingrese un valor de atributo. Por favor, revise los datos.";
				}
			}

			// Lanzar un error si la compracion entre los toales es mas de 0.001
			BigDecimal difference = totalMass.subtract(sumLinesMass).abs();
			if (difference.compareTo(BigDecimal.valueOf(0.001)) > 0) {
				msg.setType("Error");
				msg.setTitle(OBMessageUtils.messageBD("Error"));
				msg.setMessage("La suma de las masas de las líneas no coincide con la masa total del desglose. Por favor, revise los datos.");
			} else if (needAttributeSetValue) {
				msg.setType("Error");
				msg.setTitle(OBMessageUtils.messageBD("Error"));
				msg.setMessage(errorMessage);
			} else {
				recalculateLineAmountsForComplete(objHeader);
				objHeader.setDocumentStatus("CO");
				OBDal.getInstance().save(objHeader);
				OBDal.getInstance().flush();

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

}
