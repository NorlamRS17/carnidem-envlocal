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
package ec.com.sidesoft.custom.reports;

import com.sidesoft.localization.ecuador.withholdings.WithholdingSource;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
/**
 * Entity class for entity sescr_product_data_v (stored in table sescr_product_data_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sescrProductData_v extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sescr_product_data_v";
    public static final String ENTITY_NAME = "sescr_product_data_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_PURCHASE = "purchase";
    public static final String PROPERTY_SALE = "sale";
    public static final String PROPERTY_PRODUCTTYPE = "productType";
    public static final String PROPERTY_SSWHWITHHOLDINGSOURCE = "sswhWithholdingSource";
    public static final String PROPERTY_STOCKED = "stocked";
    public static final String PROPERTY_PRODUCTION = "production";
    public static final String PROPERTY_TAXCATEGORY = "taxCategory";
    public static final String PROPERTY_BILLOFMATERIALS = "billOfMaterials";
    public static final String PROPERTY_PRODUCTREVENUE = "productRevenue";
    public static final String PROPERTY_PRODUCTASSET = "productAsset";
    public static final String PROPERTY_PRODUCTEXPENSE = "productExpense";
    public static final String PROPERTY_PRODUCTCOGS = "productCOGS";

    public sescrProductData_v() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PURCHASE, false);
        setDefaultValue(PROPERTY_SALE, false);
        setDefaultValue(PROPERTY_STOCKED, false);
        setDefaultValue(PROPERTY_PRODUCTION, false);
        setDefaultValue(PROPERTY_BILLOFMATERIALS, false);
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

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public Boolean isPurchase() {
        return (Boolean) get(PROPERTY_PURCHASE);
    }

    public void setPurchase(Boolean purchase) {
        set(PROPERTY_PURCHASE, purchase);
    }

    public Boolean isSale() {
        return (Boolean) get(PROPERTY_SALE);
    }

    public void setSale(Boolean sale) {
        set(PROPERTY_SALE, sale);
    }

    public String getProductType() {
        return (String) get(PROPERTY_PRODUCTTYPE);
    }

    public void setProductType(String productType) {
        set(PROPERTY_PRODUCTTYPE, productType);
    }

    public WithholdingSource getSswhWithholdingSource() {
        return (WithholdingSource) get(PROPERTY_SSWHWITHHOLDINGSOURCE);
    }

    public void setSswhWithholdingSource(WithholdingSource sswhWithholdingSource) {
        set(PROPERTY_SSWHWITHHOLDINGSOURCE, sswhWithholdingSource);
    }

    public Boolean isStocked() {
        return (Boolean) get(PROPERTY_STOCKED);
    }

    public void setStocked(Boolean stocked) {
        set(PROPERTY_STOCKED, stocked);
    }

    public Boolean isProduction() {
        return (Boolean) get(PROPERTY_PRODUCTION);
    }

    public void setProduction(Boolean production) {
        set(PROPERTY_PRODUCTION, production);
    }

    public TaxCategory getTaxCategory() {
        return (TaxCategory) get(PROPERTY_TAXCATEGORY);
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        set(PROPERTY_TAXCATEGORY, taxCategory);
    }

    public Boolean isBillOfMaterials() {
        return (Boolean) get(PROPERTY_BILLOFMATERIALS);
    }

    public void setBillOfMaterials(Boolean billOfMaterials) {
        set(PROPERTY_BILLOFMATERIALS, billOfMaterials);
    }

    public AccountingCombination getProductRevenue() {
        return (AccountingCombination) get(PROPERTY_PRODUCTREVENUE);
    }

    public void setProductRevenue(AccountingCombination productRevenue) {
        set(PROPERTY_PRODUCTREVENUE, productRevenue);
    }

    public AccountingCombination getProductAsset() {
        return (AccountingCombination) get(PROPERTY_PRODUCTASSET);
    }

    public void setProductAsset(AccountingCombination productAsset) {
        set(PROPERTY_PRODUCTASSET, productAsset);
    }

    public AccountingCombination getProductExpense() {
        return (AccountingCombination) get(PROPERTY_PRODUCTEXPENSE);
    }

    public void setProductExpense(AccountingCombination productExpense) {
        set(PROPERTY_PRODUCTEXPENSE, productExpense);
    }

    public AccountingCombination getProductCOGS() {
        return (AccountingCombination) get(PROPERTY_PRODUCTCOGS);
    }

    public void setProductCOGS(AccountingCombination productCOGS) {
        set(PROPERTY_PRODUCTCOGS, productCOGS);
    }

}
