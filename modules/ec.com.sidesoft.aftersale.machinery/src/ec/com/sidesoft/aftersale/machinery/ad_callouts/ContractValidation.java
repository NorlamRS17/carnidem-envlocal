package ec.com.sidesoft.aftersale.machinery.ad_callouts;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.project.Project;

import ec.com.sidesoft.aftersale.machinery.Satmac_Contract;

public class ContractValidation extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		String strLastChanged = info.getLastFieldChanged();
		String contractId = info.getStringParameter("inpemSatmacContractId");
		String projectId = info.getStringParameter("inpemSatmacProjectId");
		String typeService = info.getStringParameter("inplstiposervicio", null);
		projectId = projectId == null ? "" : projectId;

		if (contractId != null) {
			Satmac_Contract contract = OBDal.getInstance().get(Satmac_Contract.class, contractId);

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = df.format(new Date());
			String endDate = df.format(contract.getEndDate());

		       if ((typeService.equals("SATMAC_MC") || typeService.equals("G")) & (contract != null)) {
			        info.addResult("inpcBpartnerId", contract.getBusinessPartner().getId());
		       }

			if (currentDate.compareTo(endDate) > 0) {
				info.addResult("ERROR", "El contrato " + contract.getDocumentNo() + " finalizó la fecha " + endDate);
				info.addResult("inpemSatmacContractId", null);
				clearInputs(info);
				return;
			}

		      Project contractProject = (contract.getProject() != null) ? contract.getProject() : null;
		      if (contractProject == null && !projectId.isEmpty()) {
			clearInputs(info);
			info.addResult("inpemSatmacProjectId",
			    (contractProject != null) ? contractProject.getId() : null);
		      }

		      if ((contractProject != null && projectId != null)
			  && !contractProject.getId().equals(projectId)) {
			clearInputs(info);
			info.addResult("inpemSatmacProjectId",
			    (contractProject != null) ? contractProject.getId() : null);
		      }
		}
	}

	static public void clearInputs(CalloutInfo info) {
		info.addResult("inpemSatmacMachineTypeId", null);
		info.addResult("inpmarca", null);
		info.addResult("inpemSswosMBrandId", null);
		info.addResult("inpmodelo", null);
		info.addResult("inpemSswosSsfiModelProdId", null);
		info.addResult("inpanio", null);
		info.addResult("inpemSswosYearId", null);
		info.addResult("inpnumerochasis", null);
		info.addResult("inpemSatmacSalesrepId", null);
		info.addResult("inpemSatmacProjectId", null);
	}
}
