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
package ec.com.sidesoft.inventory.blind.register;

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
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.common.uom.UOM;
/**
 * Entity class for entity Siblr_Physical_InvtLines (stored in table Siblr_Physical_InvtLines).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SiblrPhysicalInvtLines extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Siblr_Physical_InvtLines";
    public static final String ENTITY_NAME = "Siblr_Physical_InvtLines";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DIFFERENCE = "difference";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QUANTITYCOUNT = "quantityCount";
    public static final String PROPERTY_QTYTEORY = "qtyteory";
    public static final String PROPERTY_PHYSICALINVENTORYBLIND = "physicalInventoryBlind";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_PRODUCTCODE = "productCode";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";

    public SiblrPhysicalInvtLines() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DIFFERENCE, false);
        setDefaultValue(PROPERTY_QUANTITYCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTYTEORY, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESSING, false);
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

    public Boolean isDifference() {
        return (Boolean) get(PROPERTY_DIFFERENCE);
    }

    public void setDifference(Boolean difference) {
        set(PROPERTY_DIFFERENCE, difference);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQuantityCount() {
        return (BigDecimal) get(PROPERTY_QUANTITYCOUNT);
    }

    public void setQuantityCount(BigDecimal quantityCount) {
        set(PROPERTY_QUANTITYCOUNT, quantityCount);
    }

    public BigDecimal getQtyteory() {
        return (BigDecimal) get(PROPERTY_QTYTEORY);
    }

    public void setQtyteory(BigDecimal qtyteory) {
        set(PROPERTY_QTYTEORY, qtyteory);
    }

    public SiblrPhysicalInventory getPhysicalInventoryBlind() {
        return (SiblrPhysicalInventory) get(PROPERTY_PHYSICALINVENTORYBLIND);
    }

    public void setPhysicalInventoryBlind(SiblrPhysicalInventory physicalInventoryBlind) {
        set(PROPERTY_PHYSICALINVENTORYBLIND, physicalInventoryBlind);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public String getProductCode() {
        return (String) get(PROPERTY_PRODUCTCODE);
    }

    public void setProductCode(String productCode) {
        set(PROPERTY_PRODUCTCODE, productCode);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

}
