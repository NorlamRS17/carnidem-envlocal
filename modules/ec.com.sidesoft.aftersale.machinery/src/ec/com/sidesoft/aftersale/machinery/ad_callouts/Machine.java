/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2001-2017 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.aftersale.machinery.ad_callouts;

import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;

public class Machine extends SimpleCallout {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// Parameters
		String strLastChanged = info.getLastFieldChanged();
		String inpOrigin = info.getStringParameter("inpemSatmacOrigin");
		String inpProjectId = info.getStringParameter("inpemSatmacProjectId");
		String inpInvoiceId = info.getStringParameter("inpemSatmacInvoiceId");
		String inpInvoiceLineId = info.getStringParameter("inpemSatmacInvoicelineId");
		String inpChassisNo = info.getStringParameter("inpchassisNumber");

		if (strLastChanged.equals("inpemSatmacOrigin")) {
			if (inpOrigin.equals("O")) {
				info.addResult("inpemSatmacProjectId", null);
				info.addResult("inpemSatmacInvoiceId", null);
				info.addResult("inpemSatmacInvoicelineId", null);
				info.addResult("inpchassisNumber", null);
				info.addResult("inpemSatmacMachineTypeId", "");
				info.addResult("inpemSatmacName", null);
				info.addResult("inpmBrandId", "");
				info.addResult("inpssfiModelProdId", "");
				info.addResult("inpsswosYearId", "");
			} else if (inpOrigin.equals("P")) {
				info.addResult("inpemSatmacProjectId", "");
				info.addResult("inpemSatmacInvoiceId", null);
				info.addResult("inpemSatmacInvoicelineId", null);
				info.addResult("inpchassisNumber", null);
				info.addResult("inpemSatmacMachineTypeId", null);
				info.addResult("inpemSatmacName", null);
				info.addResult("inpmBrandId", null);
				info.addResult("inpssfiModelProdId", null);
				info.addResult("inpsswosYearId", null);
			} else if (inpOrigin.equals("I")) {
				info.addResult("inpemSatmacProjectId", null);
				info.addResult("inpemSatmacInvoiceId", "");
				info.addResult("inpemSatmacInvoicelineId", "");
				info.addResult("inpchassisNumber", null);
				info.addResult("inpemSatmacMachineTypeId", "");
				info.addResult("inpemSatmacName", null);
				info.addResult("inpmBrandId", null);
				info.addResult("inpssfiModelProdId", null);
				info.addResult("inpsswosYearId", "");
			}
		} else {
			if (inpOrigin.equals("P")) {
				if (strLastChanged.equals("inpemSatmacProjectId")) {
					info.addResult("inpchassisNumber", null);
					info.addResult("inpemSatmacMachineTypeId", null);
					info.addResult("inpemSatmacName", null);
					info.addResult("inpmBrandId", null);
					info.addResult("inpssfiModelProdId", null);
					info.addResult("inpsswosYearId", null);
				} else if (strLastChanged.equals("inpchassisNumber")) {
					try {
						Project project = OBDal.getInstance().get(Project.class, inpProjectId);

						OBCriteria<ProjectPhase> projectPhaseQuery = OBDal.getInstance()
								.createCriteria(ProjectPhase.class);
						projectPhaseQuery.add(Restrictions.eq(ProjectPhase.PROPERTY_PROJECT, project));
						projectPhaseQuery.add(Restrictions.eq(ProjectPhase.PROPERTY_SPROCTMPRHASETYPE, "E"));
						List<ProjectPhase> projectPhaseList = projectPhaseQuery.list();
						ProjectPhase projectPhase = null;
						if (projectPhaseList.size() > 0) {
							projectPhase = projectPhaseList.get(0);
						} else {
							throw new OBException("Fase de ejecución no encontrada");
						}

						OBCriteria<ProjectTask> projectTaskQuery = OBDal.getInstance()
								.createCriteria(ProjectTask.class);
						projectTaskQuery.add(Restrictions.eq(ProjectTask.PROPERTY_SATMACCHASSISNUMBER, inpChassisNo));
						projectTaskQuery.add(Restrictions.eq(ProjectTask.PROPERTY_PROJECTPHASE, projectPhase));
						List<ProjectTask> projectTaskList = projectTaskQuery.list();
						if (projectTaskList.size() == 0) {
							throw new OBException("No se encontraron coincidencias");
						}
						ProjectTask projectTask = projectTaskList.get(0);
						info.addResult("inpemSatmacMachineTypeId", projectTask.getSATMACMachineType().getId());
						info.addResult("inpemSatmacName", projectTask.getName());
						info.addResult("inpmBrandId", projectTask.getSatmacBrand().getId());
						info.addResult("inpssfiModelProdId", projectTask.getSatmacModelProd().getId());
						info.addResult("inpsswosYearId", projectTask.getSatmacYear().getId());
					} catch (Exception e) {
						info.addResult("inpemSatmacMachineTypeId", null);
						info.addResult("inpemSatmacName", null);
						info.addResult("inpmBrandId", null);
						info.addResult("inpssfiModelProdId", null);
						info.addResult("inpsswosYearId", null);
						info.addResult("ERROR", e.getMessage());
					}

				}
			} else if (inpOrigin.equals("I")) {
				if (strLastChanged.equals("inpemSatmacInvoiceId")) {
					info.addResult("inpemSatmacInvoicelineId", "");
					info.addResult("inpchassisNumber", null);
					info.addResult("inpemSatmacMachineTypeId", "");
					info.addResult("inpemSatmacName", null);
					info.addResult("inpmBrandId", null);
					info.addResult("inpssfiModelProdId", null);
					info.addResult("inpsswosYearId", "");
				} else if (strLastChanged.equals("inpemSatmacInvoicelineId")) {
					InvoiceLine invoiceLine = OBDal.getInstance().get(InvoiceLine.class, inpInvoiceLineId);

					Product product = invoiceLine.getProduct();
					info.addResult("inpemSatmacName", product.getName());
					info.addResult("inpmBrandId", product.getBrand() != null ? product.getBrand().getId() : null);
					info.addResult("inpssfiModelProdId",
							product.getSsfiModelProd() != null ? product.getSsfiModelProd().getId() : null);

					ShipmentInOutLine inOutLine = invoiceLine.getGoodsShipmentLine();
					if (inOutLine == null) {
						info.addResult("ERROR", "Despacho no encontrado");
					}

					AttributeSetInstance attributeSetInstance = inOutLine.getAttributeSetValue();
					if (attributeSetInstance == null) {
						info.addResult("ERROR", "Valor de atributo no encontrado");
					} else {
						info.addResult("inpchassisNumber", attributeSetInstance.getDescription());
					}
				}
			}
		}
	}
}
