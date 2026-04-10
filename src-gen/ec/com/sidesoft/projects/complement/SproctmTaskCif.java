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
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.manufacturing.cost.IndirectCost;
import org.openbravo.model.project.ProjectTask;
/**
 * Entity class for entity sproctm_task_cif (stored in table sproctm_task_cif).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SproctmTaskCif extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sproctm_task_cif";
    public static final String ENTITY_NAME = "sproctm_task_cif";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PROJECTTASK = "projectTask";
    public static final String PROPERTY_INDIRECTCOST = "indirectCost";
    public static final String PROPERTY_COSTUOM = "costUOM";
    public static final String PROPERTY_QTYBUDGET = "qTYBudget";
    public static final String PROPERTY_COSTUNITSTANDAR = "costUnitStandar";
    public static final String PROPERTY_TOTALCOSTBUDGET = "totalCostBudget";
    public static final String PROPERTY_UOMCOSTEXECUTED = "uomcostExecuted";
    public static final String PROPERTY_UNITCOSTEXECUTED = "unitCostExecuted";
    public static final String PROPERTY_TOTALCOSTEXECUTED = "totalCostExecuted";
    public static final String PROPERTY_COMPLETEDETAILS = "completeDetails";

    public SproctmTaskCif() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QTYBUDGET, new BigDecimal(0));
        setDefaultValue(PROPERTY_COSTUNITSTANDAR, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALCOSTBUDGET, new BigDecimal(0));
        setDefaultValue(PROPERTY_UOMCOSTEXECUTED, new BigDecimal(0));
        setDefaultValue(PROPERTY_UNITCOSTEXECUTED, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALCOSTEXECUTED, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMPLETEDETAILS, false);
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

    public IndirectCost getIndirectCost() {
        return (IndirectCost) get(PROPERTY_INDIRECTCOST);
    }

    public void setIndirectCost(IndirectCost indirectCost) {
        set(PROPERTY_INDIRECTCOST, indirectCost);
    }

    public String getCostUOM() {
        return (String) get(PROPERTY_COSTUOM);
    }

    public void setCostUOM(String costUOM) {
        set(PROPERTY_COSTUOM, costUOM);
    }

    public BigDecimal getQTYBudget() {
        return (BigDecimal) get(PROPERTY_QTYBUDGET);
    }

    public void setQTYBudget(BigDecimal qTYBudget) {
        set(PROPERTY_QTYBUDGET, qTYBudget);
    }

    public BigDecimal getCostUnitStandar() {
        return (BigDecimal) get(PROPERTY_COSTUNITSTANDAR);
    }

    public void setCostUnitStandar(BigDecimal costUnitStandar) {
        set(PROPERTY_COSTUNITSTANDAR, costUnitStandar);
    }

    public BigDecimal getTotalCostBudget() {
        return (BigDecimal) get(PROPERTY_TOTALCOSTBUDGET);
    }

    public void setTotalCostBudget(BigDecimal totalCostBudget) {
        set(PROPERTY_TOTALCOSTBUDGET, totalCostBudget);
    }

    public BigDecimal getUomcostExecuted() {
        return (BigDecimal) get(PROPERTY_UOMCOSTEXECUTED);
    }

    public void setUomcostExecuted(BigDecimal uomcostExecuted) {
        set(PROPERTY_UOMCOSTEXECUTED, uomcostExecuted);
    }

    public BigDecimal getUnitCostExecuted() {
        return (BigDecimal) get(PROPERTY_UNITCOSTEXECUTED);
    }

    public void setUnitCostExecuted(BigDecimal unitCostExecuted) {
        set(PROPERTY_UNITCOSTEXECUTED, unitCostExecuted);
    }

    public BigDecimal getTotalCostExecuted() {
        return (BigDecimal) get(PROPERTY_TOTALCOSTEXECUTED);
    }

    public void setTotalCostExecuted(BigDecimal totalCostExecuted) {
        set(PROPERTY_TOTALCOSTEXECUTED, totalCostExecuted);
    }

    public Boolean isCompleteDetails() {
        return (Boolean) get(PROPERTY_COMPLETEDETAILS);
    }

    public void setCompleteDetails(Boolean completeDetails) {
        set(PROPERTY_COMPLETEDETAILS, completeDetails);
    }

}
