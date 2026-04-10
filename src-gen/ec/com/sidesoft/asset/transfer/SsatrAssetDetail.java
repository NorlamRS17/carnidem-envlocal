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
package ec.com.sidesoft.asset.transfer;

import com.sidesoft.ecuador.asset.allocation.ssal_unit;
import com.sidesoft.ecuador.asset.allocation.ssalbuilding;
import com.sidesoft.ecuador.asset.allocation.ssaldepartment;
import com.sidesoft.ecuador.asset.subcategory.level.SSASLSubcategory;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity ssatr_asset_detail (stored in table ssatr_asset_detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsatrAssetDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssatr_asset_detail";
    public static final String ENTITY_NAME = "ssatr_asset_detail";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ASSETTRANSFER = "assetTransfer";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_CODE = "code";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_ASSETGROUP = "assetGroup";
    public static final String PROPERTY_SSASLSUBCATEGORY = "ssaslSubcategory";
    public static final String PROPERTY_SSALBUILDING = "ssalBuilding";
    public static final String PROPERTY_SSALUNIT = "ssalUnit";
    public static final String PROPERTY_SSALDEPARTMENT = "ssalDepartment";
    public static final String PROPERTY_CUSTODIAN = "custodian";
    public static final String PROPERTY_TRANSFER = "transfer";

    public SsatrAssetDetail() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TRANSFER, false);
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

    public SsatrAssetTransfer getAssetTransfer() {
        return (SsatrAssetTransfer) get(PROPERTY_ASSETTRANSFER);
    }

    public void setAssetTransfer(SsatrAssetTransfer assetTransfer) {
        set(PROPERTY_ASSETTRANSFER, assetTransfer);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getCode() {
        return (String) get(PROPERTY_CODE);
    }

    public void setCode(String code) {
        set(PROPERTY_CODE, code);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public AssetGroup getAssetGroup() {
        return (AssetGroup) get(PROPERTY_ASSETGROUP);
    }

    public void setAssetGroup(AssetGroup assetGroup) {
        set(PROPERTY_ASSETGROUP, assetGroup);
    }

    public SSASLSubcategory getSsaslSubcategory() {
        return (SSASLSubcategory) get(PROPERTY_SSASLSUBCATEGORY);
    }

    public void setSsaslSubcategory(SSASLSubcategory ssaslSubcategory) {
        set(PROPERTY_SSASLSUBCATEGORY, ssaslSubcategory);
    }

    public ssalbuilding getSsalBuilding() {
        return (ssalbuilding) get(PROPERTY_SSALBUILDING);
    }

    public void setSsalBuilding(ssalbuilding ssalBuilding) {
        set(PROPERTY_SSALBUILDING, ssalBuilding);
    }

    public ssal_unit getSsalUnit() {
        return (ssal_unit) get(PROPERTY_SSALUNIT);
    }

    public void setSsalUnit(ssal_unit ssalUnit) {
        set(PROPERTY_SSALUNIT, ssalUnit);
    }

    public ssaldepartment getSsalDepartment() {
        return (ssaldepartment) get(PROPERTY_SSALDEPARTMENT);
    }

    public void setSsalDepartment(ssaldepartment ssalDepartment) {
        set(PROPERTY_SSALDEPARTMENT, ssalDepartment);
    }

    public BusinessPartner getCustodian() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN);
    }

    public void setCustodian(BusinessPartner custodian) {
        set(PROPERTY_CUSTODIAN, custodian);
    }

    public Boolean isTransfer() {
        return (Boolean) get(PROPERTY_TRANSFER);
    }

    public void setTransfer(Boolean transfer) {
        set(PROPERTY_TRANSFER, transfer);
    }

}
