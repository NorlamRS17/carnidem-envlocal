package ec.com.sidesoft.aftersale.machinery.ad_callouts;

import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

import ec.com.sidesoft.aftersale.machinery.Satmac_Contract;
import ec.com.sidesoft.aftersale.machinery.Satmac_Machine;
import ec.com.sidesoft.workorder.simplified.SswosVehicle;
import ec.com.sidesoft.workorder.simplified.SswosVehicleRecall;

public class PostVentaMachine extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {

		String strLastChanged = info.getLastFieldChanged();
		String strnumerochasis = info.getStringParameter("inpnumerochasis", null);
		strnumerochasis = strnumerochasis == null ? "" : strnumerochasis;
		String contractId = info.getStringParameter("inpemSatmacContractId");
		contractId = contractId == null ? "" : contractId;
		String tipoServicio = info.getStringParameter("inplstiposervicio");
		tipoServicio = tipoServicio == null ? "" : tipoServicio;
		String isNew = info.getStringParameter("inpemSswosNew");

		boolean contractValidation = false;
		if (tipoServicio.equals("G") || tipoServicio.equals("SATMAC_MC")) {
			contractValidation = true;
		}

		if (strLastChanged.equals("inpnumerochasis")) {
			OBCriteria<SswosVehicleRecall> LstObjSswosVehicleRecall = OBDal.getInstance()
					.createCriteria(SswosVehicleRecall.class);
			LstObjSswosVehicleRecall.add(Restrictions.eq(SswosVehicleRecall.PROPERTY_CHASSISNUMBER, strnumerochasis));
			if (LstObjSswosVehicleRecall.count() != 0) {
				info.addResult("WARNING", "Alerta: Vehículo con Recall pendiente.");
			}

			OBCriteria<SswosVehicle> machineList = OBDal.getInstance().createCriteria(SswosVehicle.class);
			machineList.add(Restrictions.eq(SswosVehicle.PROPERTY_CHASSISNUMBER, strnumerochasis));
			List<SswosVehicle> machines = machineList.list();
			if (machines.size() > 0) {
				SswosVehicle machine = machines.get(0);
				if (contractValidation && !contractId.isEmpty()) {
					Satmac_Contract contract = OBDal.getInstance().get(Satmac_Contract.class, contractId);
					if (contract.getProject() != null && !contract.getProject().getId()
							.equals(machine.getSatmacProject() != null ? machine.getSatmacProject().getId() : "")) {
						info.addResult("ERROR", "El número de serie " + strnumerochasis
								+ " pertenece a un proyecto diferente al del contrato seleccionado");
						clearInputs(info);
						return;
					}

					OBCriteria<Satmac_Machine> contractMachineList = OBDal.getInstance()
							.createCriteria(Satmac_Machine.class);
					contractMachineList.add(Restrictions.eq(Satmac_Machine.PROPERTY_SSWOSVEHICLE, machine));

					if (contractMachineList.list().size() == 0) {
						info.addResult("ERROR", "El número de serie " + strnumerochasis
								+ " no esta relacionado al contrato seleccionado");
						clearInputs(info);
						return;
					}
				}

				info.addResult("inpemSatmacName", machine.getSatmacName());
				info.addResult("inpemSatmacMachineTypeId",
						machine.getSatmacMachineType() != null ? machine.getSatmacMachineType().getId() : null);
				if (machine.getBrand() != null) {
					info.addResult("inpmarca", machine.getBrand().getName());
					info.addResult("inpemSswosMBrandId", machine.getBrand().getId());
				} else {
					info.addResult("inpmarca", null);
					info.addResult("inpemSswosMBrandId", null);
				}
				if (machine.getModel() != null) {
					info.addResult("inpmodelo", machine.getModel().getName());
					info.addResult("inpemSswosSsfiModelProdId", machine.getModel().getId());
				} else {
					info.addResult("inpmodelo", null);
					info.addResult("inpemSswosSsfiModelProdId", null);
				}
				if (machine.getSswosYear() != null) {
					info.addResult("inpanio", machine.getSswosYear().getName());
					info.addResult("inpemSswosYearId", machine.getSswosYear().getId());
				} else {
					info.addResult("inpanio", null);
					info.addResult("inpemSswosYearId", null);
				}
				// info.addResult("inpnumerochasis", machine.getChassisNumber());
				info.addResult("inpemSatmacSalesrepId",
						machine.getSatmacSalesRep() != null ? machine.getSatmacSalesRep().getId() : null);
				info.addResult("inpemSatmacProjectId",
						machine.getSatmacProject() != null ? machine.getSatmacProject().getId() : null);
			} else if (!strnumerochasis.isEmpty() && isNew.equals("N") && machines.size() == 0) {
				info.addResult("ERROR",
						"El número de serie " + strnumerochasis + " no coincide con ninguna máquina registrada");
				clearInputs(info);
				return;
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
		info.addResult("inpemSatmacSalesrepId", null);
		info.addResult("inpemSatmacProjectId", null);
	}
}
