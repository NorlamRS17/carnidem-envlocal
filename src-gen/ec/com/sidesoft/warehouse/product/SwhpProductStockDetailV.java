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
package ec.com.sidesoft.warehouse.product;

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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.common.uom.UOM;
/**
 * Entity class for entity swhp_product_stockDetail_v (stored in table swhp_product_stockDetail_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SwhpProductStockDetailV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "swhp_product_stockDetail_v";
    public static final String ENTITY_NAME = "swhp_product_stockDetail_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_QUANTITYONHAND = "quantityOnHand";
    public static final String PROPERTY_ONHANDORDERQUANTITY = "onHandOrderQuantity";
    public static final String PROPERTY_QUANTITYINDRAFTTRANSACTIONS = "quantityInDraftTransactions";
    public static final String PROPERTY_QUANTITYORDERINDRAFTTRANSACTIONS = "quantityOrderInDraftTransactions";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ORDERUOM = "orderUOM";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_STOCKED = "stocked";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_RESERVEDQTY = "reservedQty";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ALLOCATEDQUANTITY = "allocatedQuantity";
    public static final String PROPERTY_SEARCHKEY = "searchKey";

    public SwhpProductStockDetailV() {
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
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

    public Long getQuantityOnHand() {
        return (Long) get(PROPERTY_QUANTITYONHAND);
    }

    public void setQuantityOnHand(Long quantityOnHand) {
        set(PROPERTY_QUANTITYONHAND, quantityOnHand);
    }

    public Long getOnHandOrderQuantity() {
        return (Long) get(PROPERTY_ONHANDORDERQUANTITY);
    }

    public void setOnHandOrderQuantity(Long onHandOrderQuantity) {
        set(PROPERTY_ONHANDORDERQUANTITY, onHandOrderQuantity);
    }

    public Long getQuantityInDraftTransactions() {
        return (Long) get(PROPERTY_QUANTITYINDRAFTTRANSACTIONS);
    }

    public void setQuantityInDraftTransactions(Long quantityInDraftTransactions) {
        set(PROPERTY_QUANTITYINDRAFTTRANSACTIONS, quantityInDraftTransactions);
    }

    public Long getQuantityOrderInDraftTransactions() {
        return (Long) get(PROPERTY_QUANTITYORDERINDRAFTTRANSACTIONS);
    }

    public void setQuantityOrderInDraftTransactions(Long quantityOrderInDraftTransactions) {
        set(PROPERTY_QUANTITYORDERINDRAFTTRANSACTIONS, quantityOrderInDraftTransactions);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public ProductUOM getOrderUOM() {
        return (ProductUOM) get(PROPERTY_ORDERUOM);
    }

    public void setOrderUOM(ProductUOM orderUOM) {
        set(PROPERTY_ORDERUOM, orderUOM);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public String getStocked() {
        return (String) get(PROPERTY_STOCKED);
    }

    public void setStocked(String stocked) {
        set(PROPERTY_STOCKED, stocked);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Long getReservedQty() {
        return (Long) get(PROPERTY_RESERVEDQTY);
    }

    public void setReservedQty(Long reservedQty) {
        set(PROPERTY_RESERVEDQTY, reservedQty);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Long getAllocatedQuantity() {
        return (Long) get(PROPERTY_ALLOCATEDQUANTITY);
    }

    public void setAllocatedQuantity(Long allocatedQuantity) {
        set(PROPERTY_ALLOCATEDQUANTITY, allocatedQuantity);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

}
