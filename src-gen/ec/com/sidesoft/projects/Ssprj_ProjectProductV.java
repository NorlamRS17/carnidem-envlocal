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
package ec.com.sidesoft.projects;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
/**
 * Entity class for entity ssprj_project_product_v (stored in table ssprj_project_product_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Ssprj_ProjectProductV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssprj_project_product_v";
    public static final String ENTITY_NAME = "ssprj_project_product_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectPhase";
    public static final String PROPERTY_PROJECTTASK = "projectTask";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_QUANTITYONHAND = "quantityOnHand";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_QTYREQUIRED = "qTYRequired";
    public static final String PROPERTY_QTYTRANSFERRED = "qTYTransferred";
    public static final String PROPERTY_QTYCONSUMED = "qTYConsumed";
    public static final String PROPERTY_QTYDELIVER = "qTYDeliver";
    public static final String PROPERTY_QTYCONSUME = "qTYConsume";

    public Ssprj_ProjectProductV() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectPhase getProjectPhase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        set(PROPERTY_PROJECTPHASE, projectPhase);
    }

    public ProjectTask getProjectTask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjectTask(ProjectTask projectTask) {
        set(PROPERTY_PROJECTTASK, projectTask);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public BigDecimal getQuantityOnHand() {
        return (BigDecimal) get(PROPERTY_QUANTITYONHAND);
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        set(PROPERTY_QUANTITYONHAND, quantityOnHand);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public BigDecimal getQTYRequired() {
        return (BigDecimal) get(PROPERTY_QTYREQUIRED);
    }

    public void setQTYRequired(BigDecimal qTYRequired) {
        set(PROPERTY_QTYREQUIRED, qTYRequired);
    }

    public BigDecimal getQTYTransferred() {
        return (BigDecimal) get(PROPERTY_QTYTRANSFERRED);
    }

    public void setQTYTransferred(BigDecimal qTYTransferred) {
        set(PROPERTY_QTYTRANSFERRED, qTYTransferred);
    }

    public BigDecimal getQTYConsumed() {
        return (BigDecimal) get(PROPERTY_QTYCONSUMED);
    }

    public void setQTYConsumed(BigDecimal qTYConsumed) {
        set(PROPERTY_QTYCONSUMED, qTYConsumed);
    }

    public BigDecimal getQTYDeliver() {
        return (BigDecimal) get(PROPERTY_QTYDELIVER);
    }

    public void setQTYDeliver(BigDecimal qTYDeliver) {
        set(PROPERTY_QTYDELIVER, qTYDeliver);
    }

    public BigDecimal getQTYConsume() {
        return (BigDecimal) get(PROPERTY_QTYCONSUME);
    }

    public void setQTYConsume(BigDecimal qTYConsume) {
        set(PROPERTY_QTYCONSUME, qTYConsume);
    }

}
