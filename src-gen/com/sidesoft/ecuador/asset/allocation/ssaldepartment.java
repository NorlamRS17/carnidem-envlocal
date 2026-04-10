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
package com.sidesoft.ecuador.asset.allocation;

import ec.com.sidesoft.asset.transfer.SsatrAssetDetail;
import ec.com.sidesoft.asset.transfer.SsatrAssetTransfer;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaCustodian;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaCustodianLine;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaInventoryTakingLine;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
/**
 * Entity class for entity ssal_department (stored in table ssal_department).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssaldepartment extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssal_department";
    public static final String ENTITY_NAME = "ssal_department";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSALDEPARTMENTIDLIST = "financialMgmtAssetEMSsalDepartmentIDList";
    public static final String PROPERTY_CSAAACUSTODIANDEPARTMENTLIST = "csaaaCustodianDepartmentList";
    public static final String PROPERTY_CSAAACUSTODIANLINEDEPARTMENTIDLIST = "csaaaCustodianlineDepartmentIDList";
    public static final String PROPERTY_CSAAACUSTODIANLINEDEPARTMENT2IDLIST = "csaaaCustodianlineDepartment2IDList";
    public static final String PROPERTY_CSAAAINVTTKGLINEDEPARTMENTIDLIST = "csaaaInvtTkgLineDepartmentIDList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";
    public static final String PROPERTY_SSATRASSETDETAILEMSSALDEPARTMENTIDLIST = "ssatrAssetDetailEMSsalDepartmentIDList";
    public static final String PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTIDLIST = "ssatrAssetTransferEMSsalDepartmentIDList";
    public static final String PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTDESTIDLIST = "ssatrAssetTransferEMSsalDepartmentDestIDList";

    public ssaldepartment() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSALDEPARTMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANDEPARTMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEDEPARTMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEDEPARTMENT2IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAAINVTTKGLINEDEPARTMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETDETAILEMSSALDEPARTMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTDESTIDLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
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

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsalDepartmentIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSALDEPARTMENTIDLIST);
    }

    public void setFinancialMgmtAssetEMSsalDepartmentIDList(List<Asset> financialMgmtAssetEMSsalDepartmentIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSALDEPARTMENTIDLIST, financialMgmtAssetEMSsalDepartmentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodian> getCsaaaCustodianDepartmentList() {
      return (List<CsaaaCustodian>) get(PROPERTY_CSAAACUSTODIANDEPARTMENTLIST);
    }

    public void setCsaaaCustodianDepartmentList(List<CsaaaCustodian> csaaaCustodianDepartmentList) {
        set(PROPERTY_CSAAACUSTODIANDEPARTMENTLIST, csaaaCustodianDepartmentList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineDepartmentIDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEDEPARTMENTIDLIST);
    }

    public void setCsaaaCustodianlineDepartmentIDList(List<CsaaaCustodianLine> csaaaCustodianlineDepartmentIDList) {
        set(PROPERTY_CSAAACUSTODIANLINEDEPARTMENTIDLIST, csaaaCustodianlineDepartmentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineDepartment2IDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEDEPARTMENT2IDLIST);
    }

    public void setCsaaaCustodianlineDepartment2IDList(List<CsaaaCustodianLine> csaaaCustodianlineDepartment2IDList) {
        set(PROPERTY_CSAAACUSTODIANLINEDEPARTMENT2IDLIST, csaaaCustodianlineDepartment2IDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTakingLine> getCsaaaInvtTkgLineDepartmentIDList() {
      return (List<CsaaaInventoryTakingLine>) get(PROPERTY_CSAAAINVTTKGLINEDEPARTMENTIDLIST);
    }

    public void setCsaaaInvtTkgLineDepartmentIDList(List<CsaaaInventoryTakingLine> csaaaInvtTkgLineDepartmentIDList) {
        set(PROPERTY_CSAAAINVTTKGLINEDEPARTMENTIDLIST, csaaaInvtTkgLineDepartmentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalActiveMain> getSsalActiveMainList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINLIST);
    }

    public void setSsalActiveMainList(List<SsalActiveMain> ssalActiveMainList) {
        set(PROPERTY_SSALACTIVEMAINLIST, ssalActiveMainList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINELIST);
    }

    public void setSsalAssetReturnlineList(List<ssalassetreturnline> ssalAssetReturnlineList) {
        set(PROPERTY_SSALASSETRETURNLINELIST, ssalAssetReturnlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetDetail> getSsatrAssetDetailEMSsalDepartmentIDList() {
      return (List<SsatrAssetDetail>) get(PROPERTY_SSATRASSETDETAILEMSSALDEPARTMENTIDLIST);
    }

    public void setSsatrAssetDetailEMSsalDepartmentIDList(List<SsatrAssetDetail> ssatrAssetDetailEMSsalDepartmentIDList) {
        set(PROPERTY_SSATRASSETDETAILEMSSALDEPARTMENTIDLIST, ssatrAssetDetailEMSsalDepartmentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferEMSsalDepartmentIDList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTIDLIST);
    }

    public void setSsatrAssetTransferEMSsalDepartmentIDList(List<SsatrAssetTransfer> ssatrAssetTransferEMSsalDepartmentIDList) {
        set(PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTIDLIST, ssatrAssetTransferEMSsalDepartmentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferEMSsalDepartmentDestIDList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTDESTIDLIST);
    }

    public void setSsatrAssetTransferEMSsalDepartmentDestIDList(List<SsatrAssetTransfer> ssatrAssetTransferEMSsalDepartmentDestIDList) {
        set(PROPERTY_SSATRASSETTRANSFEREMSSALDEPARTMENTDESTIDLIST, ssatrAssetTransferEMSsalDepartmentDestIDList);
    }

}
