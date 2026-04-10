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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
/**
 * Entity class for entity ssatr_asset_transfer (stored in table ssatr_asset_transfer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsatrAssetTransfer extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssatr_asset_transfer";
    public static final String ENTITY_NAME = "ssatr_asset_transfer";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TRANSACTIONTYPE = "transactionType";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_DOCSTATUS = "docstatus";
    public static final String PROPERTY_DATETRANSFER = "datetransfer";
    public static final String PROPERTY_ASSETGROUP = "assetGroup";
    public static final String PROPERTY_SSASLSUBCATEGORY = "ssaslSubcategory";
    public static final String PROPERTY_CUSTODIAN = "custodian";
    public static final String PROPERTY_TRASFERTO = "trasferto";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_SSALBUILDING = "ssalBuilding";
    public static final String PROPERTY_SSALUNIT = "ssalUnit";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_SSALDEPARTMENT = "ssalDepartment";
    public static final String PROPERTY_LOADASSETS = "loadAssets";
    public static final String PROPERTY_SSALBUILDINGDEST = "ssalBuildingDest";
    public static final String PROPERTY_SSALUNITDEST = "ssalUnitDest";
    public static final String PROPERTY_SSALDEPARTMENTDEST = "ssalDepartmentDest";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SELECTALL = "selectAll";
    public static final String PROPERTY_SSATRASSETDETAILLIST = "ssatrAssetDetailList";

    public SsatrAssetTransfer() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TRANSACTIONTYPE, "CC");
        setDefaultValue(PROPERTY_DOCSTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_LOADASSETS, false);
        setDefaultValue(PROPERTY_SELECTALL, false);
        setDefaultValue(PROPERTY_SSATRASSETDETAILLIST, new ArrayList<Object>());
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

    public String getTransactionType() {
        return (String) get(PROPERTY_TRANSACTIONTYPE);
    }

    public void setTransactionType(String transactionType) {
        set(PROPERTY_TRANSACTIONTYPE, transactionType);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public String getDocstatus() {
        return (String) get(PROPERTY_DOCSTATUS);
    }

    public void setDocstatus(String docstatus) {
        set(PROPERTY_DOCSTATUS, docstatus);
    }

    public Date getDatetransfer() {
        return (Date) get(PROPERTY_DATETRANSFER);
    }

    public void setDatetransfer(Date datetransfer) {
        set(PROPERTY_DATETRANSFER, datetransfer);
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

    public BusinessPartner getCustodian() {
        return (BusinessPartner) get(PROPERTY_CUSTODIAN);
    }

    public void setCustodian(BusinessPartner custodian) {
        set(PROPERTY_CUSTODIAN, custodian);
    }

    public BusinessPartner getTrasferto() {
        return (BusinessPartner) get(PROPERTY_TRASFERTO);
    }

    public void setTrasferto(BusinessPartner trasferto) {
        set(PROPERTY_TRASFERTO, trasferto);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
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

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public ssaldepartment getSsalDepartment() {
        return (ssaldepartment) get(PROPERTY_SSALDEPARTMENT);
    }

    public void setSsalDepartment(ssaldepartment ssalDepartment) {
        set(PROPERTY_SSALDEPARTMENT, ssalDepartment);
    }

    public Boolean isLoadAssets() {
        return (Boolean) get(PROPERTY_LOADASSETS);
    }

    public void setLoadAssets(Boolean loadAssets) {
        set(PROPERTY_LOADASSETS, loadAssets);
    }

    public ssalbuilding getSsalBuildingDest() {
        return (ssalbuilding) get(PROPERTY_SSALBUILDINGDEST);
    }

    public void setSsalBuildingDest(ssalbuilding ssalBuildingDest) {
        set(PROPERTY_SSALBUILDINGDEST, ssalBuildingDest);
    }

    public ssal_unit getSsalUnitDest() {
        return (ssal_unit) get(PROPERTY_SSALUNITDEST);
    }

    public void setSsalUnitDest(ssal_unit ssalUnitDest) {
        set(PROPERTY_SSALUNITDEST, ssalUnitDest);
    }

    public ssaldepartment getSsalDepartmentDest() {
        return (ssaldepartment) get(PROPERTY_SSALDEPARTMENTDEST);
    }

    public void setSsalDepartmentDest(ssaldepartment ssalDepartmentDest) {
        set(PROPERTY_SSALDEPARTMENTDEST, ssalDepartmentDest);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isSelectAll() {
        return (Boolean) get(PROPERTY_SELECTALL);
    }

    public void setSelectAll(Boolean selectAll) {
        set(PROPERTY_SELECTALL, selectAll);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetDetail> getSsatrAssetDetailList() {
      return (List<SsatrAssetDetail>) get(PROPERTY_SSATRASSETDETAILLIST);
    }

    public void setSsatrAssetDetailList(List<SsatrAssetDetail> ssatrAssetDetailList) {
        set(PROPERTY_SSATRASSETDETAILLIST, ssatrAssetDetailList);
    }

}
