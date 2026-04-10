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

import ec.com.sidesoft.settlement.project.cost.LiquidationProjects;

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
import org.openbravo.model.common.plm.AttributeSet;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
/**
 * Entity class for entity sproctm_inventory_settl (stored in table sproctm_inventory_settl).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SproctmInventorySettl extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sproctm_inventory_settl";
    public static final String ENTITY_NAME = "sproctm_inventory_settl";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_GOODSSHIPMENT = "goodsShipment";
    public static final String PROPERTY_GOODSSHIPMENTLINE = "goodsShipmentLine";
    public static final String PROPERTY_INOUTDATE = "inoutDate";
    public static final String PROPERTY_SSTPCLIQUIDATIONPROJECTS = "sstpcLiquidationProjects";
    public static final String PROPERTY_DATELIQUIDATION = "dateLiquidation";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_ATTRIBUTESET = "attributeSet";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_QTYINOUT = "qTYInout";
    public static final String PROPERTY_PROJECTPHASE = "projectPhase";
    public static final String PROPERTY_PROJECTTASK = "projectTask";

    public SproctmInventorySettl() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QTYINOUT, new BigDecimal(0));
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

    public ShipmentInOut getGoodsShipment() {
        return (ShipmentInOut) get(PROPERTY_GOODSSHIPMENT);
    }

    public void setGoodsShipment(ShipmentInOut goodsShipment) {
        set(PROPERTY_GOODSSHIPMENT, goodsShipment);
    }

    public ShipmentInOutLine getGoodsShipmentLine() {
        return (ShipmentInOutLine) get(PROPERTY_GOODSSHIPMENTLINE);
    }

    public void setGoodsShipmentLine(ShipmentInOutLine goodsShipmentLine) {
        set(PROPERTY_GOODSSHIPMENTLINE, goodsShipmentLine);
    }

    public Date getInoutDate() {
        return (Date) get(PROPERTY_INOUTDATE);
    }

    public void setInoutDate(Date inoutDate) {
        set(PROPERTY_INOUTDATE, inoutDate);
    }

    public LiquidationProjects getSstpcLiquidationProjects() {
        return (LiquidationProjects) get(PROPERTY_SSTPCLIQUIDATIONPROJECTS);
    }

    public void setSstpcLiquidationProjects(LiquidationProjects sstpcLiquidationProjects) {
        set(PROPERTY_SSTPCLIQUIDATIONPROJECTS, sstpcLiquidationProjects);
    }

    public Date getDateLiquidation() {
        return (Date) get(PROPERTY_DATELIQUIDATION);
    }

    public void setDateLiquidation(Date dateLiquidation) {
        set(PROPERTY_DATELIQUIDATION, dateLiquidation);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public AttributeSet getAttributeSet() {
        return (AttributeSet) get(PROPERTY_ATTRIBUTESET);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        set(PROPERTY_ATTRIBUTESET, attributeSet);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getQTYInout() {
        return (BigDecimal) get(PROPERTY_QTYINOUT);
    }

    public void setQTYInout(BigDecimal qTYInout) {
        set(PROPERTY_QTYINOUT, qTYInout);
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

}
