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
package ec.com.sidesoft.production;

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
import org.openbravo.model.materialmgmt.onhandquantity.StorageDetail;
/**
 * Entity class for entity ssprod_product_lot_v (stored in table ssprod_product_lot_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsprodProductLotView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssprod_product_lot_v";
    public static final String ENTITY_NAME = "ssprod_product_lot_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE = "attributesetinstance";
    public static final String PROPERTY_LOT = "lot";
    public static final String PROPERTY_GUARANTEEDATE = "guaranteedate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_STOCK = "stock";
    public static final String PROPERTY_ISGUARANTEEDATE = "isguaranteedate";
    public static final String PROPERTY_GUARANTEEDAYS = "guaranteedays";
    public static final String PROPERTY_STORAGEDETAIL = "storageDetail";
    public static final String PROPERTY_UOM = "uom";

    public SsprodProductLotView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISGUARANTEEDATE, false);
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public AttributeSetInstance getAttributesetinstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributesetinstance(AttributeSetInstance attributesetinstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributesetinstance);
    }

    public String getLot() {
        return (String) get(PROPERTY_LOT);
    }

    public void setLot(String lot) {
        set(PROPERTY_LOT, lot);
    }

    public Date getGuaranteedate() {
        return (Date) get(PROPERTY_GUARANTEEDATE);
    }

    public void setGuaranteedate(Date guaranteedate) {
        set(PROPERTY_GUARANTEEDATE, guaranteedate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Long getStock() {
        return (Long) get(PROPERTY_STOCK);
    }

    public void setStock(Long stock) {
        set(PROPERTY_STOCK, stock);
    }

    public Boolean isGuaranteedate() {
        return (Boolean) get(PROPERTY_ISGUARANTEEDATE);
    }

    public void setGuaranteedate(Boolean isguaranteedate) {
        set(PROPERTY_ISGUARANTEEDATE, isguaranteedate);
    }

    public Long getGuaranteedays() {
        return (Long) get(PROPERTY_GUARANTEEDAYS);
    }

    public void setGuaranteedays(Long guaranteedays) {
        set(PROPERTY_GUARANTEEDAYS, guaranteedays);
    }

    public StorageDetail getStorageDetail() {
        return (StorageDetail) get(PROPERTY_STORAGEDETAIL);
    }

    public void setStorageDetail(StorageDetail storageDetail) {
        set(PROPERTY_STORAGEDETAIL, storageDetail);
    }

    public UOM getUom() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUom(UOM uom) {
        set(PROPERTY_UOM, uom);
    }

}
