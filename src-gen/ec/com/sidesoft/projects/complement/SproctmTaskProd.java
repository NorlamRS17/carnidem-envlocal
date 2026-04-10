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
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package ec.com.sidesoft.projects.complement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.project.ProjectTask;
/**
 * Entity class for entity sproctm_task_prod (stored in table sproctm_task_prod).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SproctmTaskProd extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sproctm_task_prod";
    public static final String ENTITY_NAME = "sproctm_task_prod";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECTTASK = "projectTask";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_REQUIREMENTSDATE = "requirementsDate";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_COSTTOTAL = "costTotal";
    public static final String PROPERTY_ISMACHINE = "ismachine";
    public static final String PROPERTY_ISIMPORTED = "isimported";
    public static final String PROPERTY_CREATEREQUISITION = "createRequisition";
    public static final String PROPERTY_VALUESEARCHKEY = "valueSearchKey";
    public static final String PROPERTY_QTYREQUIREMENT = "qTYRequirement";
    public static final String PROPERTY_REQSTATUS = "reqstatus";
    public static final String PROPERTY_SSPRJQTYTRANSFERRED = "ssprjQtyTransferred";
    public static final String PROPERTY_SSPRJQTYCONSUMED = "ssprjQtyConsumed";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSPRJTASKPRODIDLIST = "materialMgmtInternalMovementLineEMSsprjTaskProdIDList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSSPRJPROJECTPRODUCTLIST = "materialMgmtShipmentInOutLineEMSSPRJProjectProductList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMTASKPRODIDLIST = "procurementRequisitionLineEMSproctmTaskProdIDList";

    public SproctmTaskProd() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, new BigDecimal(0));
        setDefaultValue(PROPERTY_COST, new BigDecimal(0));
        setDefaultValue(PROPERTY_COSTTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISMACHINE, false);
        setDefaultValue(PROPERTY_ISIMPORTED, false);
        setDefaultValue(PROPERTY_CREATEREQUISITION, false);
        setDefaultValue(PROPERTY_SSPRJQTYTRANSFERRED, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSPRJQTYCONSUMED, new BigDecimal(0));
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSPRJTASKPRODIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSSPRJPROJECTPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMTASKPRODIDLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public ProjectTask getProjectTask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjectTask(ProjectTask projectTask) {
        set(PROPERTY_PROJECTTASK, projectTask);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Date getRequirementsDate() {
        return (Date) get(PROPERTY_REQUIREMENTSDATE);
    }

    public void setRequirementsDate(Date requirementsDate) {
        set(PROPERTY_REQUIREMENTSDATE, requirementsDate);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public BigDecimal getCostTotal() {
        return (BigDecimal) get(PROPERTY_COSTTOTAL);
    }

    public void setCostTotal(BigDecimal costTotal) {
        set(PROPERTY_COSTTOTAL, costTotal);
    }

    public Boolean isMachine() {
        return (Boolean) get(PROPERTY_ISMACHINE);
    }

    public void setMachine(Boolean ismachine) {
        set(PROPERTY_ISMACHINE, ismachine);
    }

    public Boolean isImported() {
        return (Boolean) get(PROPERTY_ISIMPORTED);
    }

    public void setImported(Boolean isimported) {
        set(PROPERTY_ISIMPORTED, isimported);
    }

    public Boolean isCreateRequisition() {
        return (Boolean) get(PROPERTY_CREATEREQUISITION);
    }

    public void setCreateRequisition(Boolean createRequisition) {
        set(PROPERTY_CREATEREQUISITION, createRequisition);
    }

    public String getValueSearchKey() {
        return (String) get(PROPERTY_VALUESEARCHKEY);
    }

    public void setValueSearchKey(String valueSearchKey) {
        set(PROPERTY_VALUESEARCHKEY, valueSearchKey);
    }

    public BigDecimal getQTYRequirement() {
        return (BigDecimal) get(PROPERTY_QTYREQUIREMENT);
    }

    public void setQTYRequirement(BigDecimal qTYRequirement) {
        set(PROPERTY_QTYREQUIREMENT, qTYRequirement);
    }

    public String getReqstatus() {
        return (String) get(PROPERTY_REQSTATUS);
    }

    public void setReqstatus(String reqstatus) {
        set(PROPERTY_REQSTATUS, reqstatus);
    }

    public BigDecimal getSsprjQtyTransferred() {
        return (BigDecimal) get(PROPERTY_SSPRJQTYTRANSFERRED);
    }

    public void setSsprjQtyTransferred(BigDecimal ssprjQtyTransferred) {
        set(PROPERTY_SSPRJQTYTRANSFERRED, ssprjQtyTransferred);
    }

    public BigDecimal getSsprjQtyConsumed() {
        return (BigDecimal) get(PROPERTY_SSPRJQTYCONSUMED);
    }

    public void setSsprjQtyConsumed(BigDecimal ssprjQtyConsumed) {
        set(PROPERTY_SSPRJQTYCONSUMED, ssprjQtyConsumed);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineEMSsprjTaskProdIDList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSPRJTASKPRODIDLIST);
    }

    public void setMaterialMgmtInternalMovementLineEMSsprjTaskProdIDList(List<InternalMovementLine> materialMgmtInternalMovementLineEMSsprjTaskProdIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSPRJTASKPRODIDLIST, materialMgmtInternalMovementLineEMSsprjTaskProdIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineEMSSPRJProjectProductList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSSPRJPROJECTPRODUCTLIST);
    }

    public void setMaterialMgmtShipmentInOutLineEMSSPRJProjectProductList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineEMSSPRJProjectProductList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINEEMSSPRJPROJECTPRODUCTLIST, materialMgmtShipmentInOutLineEMSSPRJProjectProductList);
    }

    @SuppressWarnings("unchecked")
    public List<RequisitionLine> getProcurementRequisitionLineEMSproctmTaskProdIDList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMTASKPRODIDLIST);
    }

    public void setProcurementRequisitionLineEMSproctmTaskProdIDList(List<RequisitionLine> procurementRequisitionLineEMSproctmTaskProdIDList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINEEMSPROCTMTASKPRODIDLIST, procurementRequisitionLineEMSproctmTaskProdIDList);
    }

}
