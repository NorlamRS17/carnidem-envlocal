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
package ec.com.sidesoft.localization.quality.assurement;

import java.sql.Timestamp;
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
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.manufacturing.cost.CostcenterVersion;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
/**
 * Entity class for entity slqs_prd_safety_v (stored in table slqs_prd_safety_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SlqsProductSafetyInProcessView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "slqs_prd_safety_v";
    public static final String ENTITY_NAME = "slqs_prd_safety_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CODE = "code";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE = "attributesetinstance";
    public static final String PROPERTY_PRODUCTIONPLAN = "productionplan";
    public static final String PROPERTY_COSTCENTERVERSION = "costcenterVersion";
    public static final String PROPERTY_MOVEMENTQTY = "movementqty";
    public static final String PROPERTY_STARTTIME = "starttime";
    public static final String PROPERTY_ENDTIME = "endtime";
    public static final String PROPERTY_PRODUCTION = "production";
    public static final String PROPERTY_DATEPARTWORK = "datePartWork";
    public static final String PROPERTY_STARTPARTWORK = "startPartWork";
    public static final String PROPERTY_ENDPARTWORK = "eNDPartWork";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_SLQSSTATUS = "slqsStatus";
    public static final String PROPERTY_BTNGENCTRL = "bTNGenCtrl";
    public static final String PROPERTY_PRODUCTIONLINE = "productionline";

    public SlqsProductSafetyInProcessView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BTNGENCTRL, false);
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

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getCode() {
        return (String) get(PROPERTY_CODE);
    }

    public void setCode(String code) {
        set(PROPERTY_CODE, code);
    }

    public UOM getUom() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUom(UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public AttributeSetInstance getAttributesetinstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributesetinstance(AttributeSetInstance attributesetinstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributesetinstance);
    }

    public ProductionPlan getProductionplan() {
        return (ProductionPlan) get(PROPERTY_PRODUCTIONPLAN);
    }

    public void setProductionplan(ProductionPlan productionplan) {
        set(PROPERTY_PRODUCTIONPLAN, productionplan);
    }

    public CostcenterVersion getCostcenterVersion() {
        return (CostcenterVersion) get(PROPERTY_COSTCENTERVERSION);
    }

    public void setCostcenterVersion(CostcenterVersion costcenterVersion) {
        set(PROPERTY_COSTCENTERVERSION, costcenterVersion);
    }

    public Long getMovementqty() {
        return (Long) get(PROPERTY_MOVEMENTQTY);
    }

    public void setMovementqty(Long movementqty) {
        set(PROPERTY_MOVEMENTQTY, movementqty);
    }

    public Timestamp getStarttime() {
        return (Timestamp) get(PROPERTY_STARTTIME);
    }

    public void setStarttime(Timestamp starttime) {
        set(PROPERTY_STARTTIME, starttime);
    }

    public Timestamp getEndtime() {
        return (Timestamp) get(PROPERTY_ENDTIME);
    }

    public void setEndtime(Timestamp endtime) {
        set(PROPERTY_ENDTIME, endtime);
    }

    public ProductionTransaction getProduction() {
        return (ProductionTransaction) get(PROPERTY_PRODUCTION);
    }

    public void setProduction(ProductionTransaction production) {
        set(PROPERTY_PRODUCTION, production);
    }

    public Date getDatePartWork() {
        return (Date) get(PROPERTY_DATEPARTWORK);
    }

    public void setDatePartWork(Date datePartWork) {
        set(PROPERTY_DATEPARTWORK, datePartWork);
    }

    public Date getStartPartWork() {
        return (Date) get(PROPERTY_STARTPARTWORK);
    }

    public void setStartPartWork(Date startPartWork) {
        set(PROPERTY_STARTPARTWORK, startPartWork);
    }

    public Date getENDPartWork() {
        return (Date) get(PROPERTY_ENDPARTWORK);
    }

    public void setENDPartWork(Date eNDPartWork) {
        set(PROPERTY_ENDPARTWORK, eNDPartWork);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public String getSlqsStatus() {
        return (String) get(PROPERTY_SLQSSTATUS);
    }

    public void setSlqsStatus(String slqsStatus) {
        set(PROPERTY_SLQSSTATUS, slqsStatus);
    }

    public Boolean isBTNGenCtrl() {
        return (Boolean) get(PROPERTY_BTNGENCTRL);
    }

    public void setBTNGenCtrl(Boolean bTNGenCtrl) {
        set(PROPERTY_BTNGENCTRL, bTNGenCtrl);
    }

    public ProductionLine getProductionline() {
        return (ProductionLine) get(PROPERTY_PRODUCTIONLINE);
    }

    public void setProductionline(ProductionLine productionline) {
        set(PROPERTY_PRODUCTIONLINE, productionline);
    }

}
