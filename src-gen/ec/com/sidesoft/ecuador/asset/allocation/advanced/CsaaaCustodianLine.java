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
package ec.com.sidesoft.ecuador.asset.allocation.advanced;

import com.sidesoft.ecuador.asset.allocation.ssal_unit;
import com.sidesoft.ecuador.asset.allocation.ssalbuilding;
import com.sidesoft.ecuador.asset.allocation.ssaldepartment;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity csaaa_custodianline (stored in table csaaa_custodianline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CsaaaCustodianLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "csaaa_custodianline";
    public static final String ENTITY_NAME = "csaaa_custodianline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CSAAACUSTODIAN = "csaaaCustodian";
    public static final String PROPERTY_CUSTODIAN = "custodian";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_BARCODE = "barcode";
    public static final String PROPERTY_DATETRANSACTION = "datetransaction";
    public static final String PROPERTY_CUSTODIAN2 = "custodian2";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_BUILDING = "building";
    public static final String PROPERTY_UNIT = "unit";
    public static final String PROPERTY_DEPARTMENT = "department";
    public static final String PROPERTY_COSTCENTER2 = "costcenter2";
    public static final String PROPERTY_USER12 = "user12";
    public static final String PROPERTY_USER22 = "user22";
    public static final String PROPERTY_BUILDING2 = "building2";
    public static final String PROPERTY_UNIT2 = "unit2";
    public static final String PROPERTY_DEPARTMENT2 = "department2";
    public static final String PROPERTY_ASSETGROUP = "assetGroup";

    public CsaaaCustodianLine() {
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

    public CsaaaCustodian getCsaaaCustodian() {
        return (CsaaaCustodian) get(PROPERTY_CSAAACUSTODIAN);
    }

    public void setCsaaaCustodian(CsaaaCustodian csaaaCustodian) {
        set(PROPERTY_CSAAACUSTODIAN, csaaaCustodian);
    }

    public BusinessPartner getCustodian() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN);
    }

    public void setCustodian(BusinessPartner custodian) {
        set(PROPERTY_CUSTODIAN, custodian);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Asset getBarcode() {
        return (Asset) get(PROPERTY_BARCODE);
    }

    public void setBarcode(Asset barcode) {
        set(PROPERTY_BARCODE, barcode);
    }

    public Date getDatetransaction() {
        return (Date) get(PROPERTY_DATETRANSACTION);
    }

    public void setDatetransaction(Date datetransaction) {
        set(PROPERTY_DATETRANSACTION, datetransaction);
    }

    public BusinessPartner getCustodian2() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN2);
    }

    public void setCustodian2(BusinessPartner custodian2) {
        set(PROPERTY_CUSTODIAN2, custodian2);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public UserDimension1 getUser1() {
        return (UserDimension1) get(PROPERTY_USER1);
    }

    public void setUser1(UserDimension1 user1) {
        set(PROPERTY_USER1, user1);
    }

    public UserDimension2 getUser2() {
        return (UserDimension2) get(PROPERTY_USER2);
    }

    public void setUser2(UserDimension2 user2) {
        set(PROPERTY_USER2, user2);
    }

    public ssalbuilding getBuilding() {
        return (ssalbuilding) get(PROPERTY_BUILDING);
    }

    public void setBuilding(ssalbuilding building) {
        set(PROPERTY_BUILDING, building);
    }

    public ssal_unit getUnit() {
        return (ssal_unit) get(PROPERTY_UNIT);
    }

    public void setUnit(ssal_unit unit) {
        set(PROPERTY_UNIT, unit);
    }

    public ssaldepartment getDepartment() {
        return (ssaldepartment) get(PROPERTY_DEPARTMENT);
    }

    public void setDepartment(ssaldepartment department) {
        set(PROPERTY_DEPARTMENT, department);
    }

    public Costcenter getCostcenter2() {
        return (Costcenter) get(PROPERTY_COSTCENTER2);
    }

    public void setCostcenter2(Costcenter costcenter2) {
        set(PROPERTY_COSTCENTER2, costcenter2);
    }

    public UserDimension1 getUser12() {
        return (UserDimension1) get(PROPERTY_USER12);
    }

    public void setUser12(UserDimension1 user12) {
        set(PROPERTY_USER12, user12);
    }

    public UserDimension2 getUser22() {
        return (UserDimension2) get(PROPERTY_USER22);
    }

    public void setUser22(UserDimension2 user22) {
        set(PROPERTY_USER22, user22);
    }

    public ssalbuilding getBuilding2() {
        return (ssalbuilding) get(PROPERTY_BUILDING2);
    }

    public void setBuilding2(ssalbuilding building2) {
        set(PROPERTY_BUILDING2, building2);
    }

    public ssal_unit getUnit2() {
        return (ssal_unit) get(PROPERTY_UNIT2);
    }

    public void setUnit2(ssal_unit unit2) {
        set(PROPERTY_UNIT2, unit2);
    }

    public ssaldepartment getDepartment2() {
        return (ssaldepartment) get(PROPERTY_DEPARTMENT2);
    }

    public void setDepartment2(ssaldepartment department2) {
        set(PROPERTY_DEPARTMENT2, department2);
    }

    public AssetGroup getAssetGroup() {
        return (AssetGroup) get(PROPERTY_ASSETGROUP);
    }

    public void setAssetGroup(AssetGroup assetGroup) {
        set(PROPERTY_ASSETGROUP, assetGroup);
    }

}
