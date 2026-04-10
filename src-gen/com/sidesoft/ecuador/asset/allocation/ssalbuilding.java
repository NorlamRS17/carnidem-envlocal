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
 * Entity class for entity ssal_building (stored in table ssal_building).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssalbuilding extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssal_building";
    public static final String ENTITY_NAME = "ssal_building";
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
    public static final String PROPERTY_DIRECTION = "direction";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSALBUILDINGIDLIST = "financialMgmtAssetEMSsalBuildingIDList";
    public static final String PROPERTY_CSAAACUSTODIANBUILDINGIDLIST = "csaaaCustodianBuildingIDList";
    public static final String PROPERTY_CSAAACUSTODIANLINEBUILDINGIDLIST = "csaaaCustodianlineBuildingIDList";
    public static final String PROPERTY_CSAAACUSTODIANLINEBUILDING2IDLIST = "csaaaCustodianlineBuilding2IDList";
    public static final String PROPERTY_CSAAAINVTTKGLINEEDIFICELIST = "csaaaInvtTkgLineEdificeList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";
    public static final String PROPERTY_SSATRASSETDETAILEMSSALBUILDINGIDLIST = "ssatrAssetDetailEMSsalBuildingIDList";
    public static final String PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGIDLIST = "ssatrAssetTransferEMSsalBuildingIDList";
    public static final String PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGDESTIDLIST = "ssatrAssetTransferEMSsalBuildingDestIDList";

    public ssalbuilding() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSALBUILDINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANBUILDINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEBUILDINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEBUILDING2IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAAINVTTKGLINEEDIFICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETDETAILEMSSALBUILDINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGDESTIDLIST, new ArrayList<Object>());
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

    public String getDirection() {
        return (String) get(PROPERTY_DIRECTION);
    }

    public void setDirection(String direction) {
        set(PROPERTY_DIRECTION, direction);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsalBuildingIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSALBUILDINGIDLIST);
    }

    public void setFinancialMgmtAssetEMSsalBuildingIDList(List<Asset> financialMgmtAssetEMSsalBuildingIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSALBUILDINGIDLIST, financialMgmtAssetEMSsalBuildingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodian> getCsaaaCustodianBuildingIDList() {
      return (List<CsaaaCustodian>) get(PROPERTY_CSAAACUSTODIANBUILDINGIDLIST);
    }

    public void setCsaaaCustodianBuildingIDList(List<CsaaaCustodian> csaaaCustodianBuildingIDList) {
        set(PROPERTY_CSAAACUSTODIANBUILDINGIDLIST, csaaaCustodianBuildingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineBuildingIDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEBUILDINGIDLIST);
    }

    public void setCsaaaCustodianlineBuildingIDList(List<CsaaaCustodianLine> csaaaCustodianlineBuildingIDList) {
        set(PROPERTY_CSAAACUSTODIANLINEBUILDINGIDLIST, csaaaCustodianlineBuildingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineBuilding2IDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEBUILDING2IDLIST);
    }

    public void setCsaaaCustodianlineBuilding2IDList(List<CsaaaCustodianLine> csaaaCustodianlineBuilding2IDList) {
        set(PROPERTY_CSAAACUSTODIANLINEBUILDING2IDLIST, csaaaCustodianlineBuilding2IDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTakingLine> getCsaaaInvtTkgLineEdificeList() {
      return (List<CsaaaInventoryTakingLine>) get(PROPERTY_CSAAAINVTTKGLINEEDIFICELIST);
    }

    public void setCsaaaInvtTkgLineEdificeList(List<CsaaaInventoryTakingLine> csaaaInvtTkgLineEdificeList) {
        set(PROPERTY_CSAAAINVTTKGLINEEDIFICELIST, csaaaInvtTkgLineEdificeList);
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
    public List<SsatrAssetDetail> getSsatrAssetDetailEMSsalBuildingIDList() {
      return (List<SsatrAssetDetail>) get(PROPERTY_SSATRASSETDETAILEMSSALBUILDINGIDLIST);
    }

    public void setSsatrAssetDetailEMSsalBuildingIDList(List<SsatrAssetDetail> ssatrAssetDetailEMSsalBuildingIDList) {
        set(PROPERTY_SSATRASSETDETAILEMSSALBUILDINGIDLIST, ssatrAssetDetailEMSsalBuildingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferEMSsalBuildingIDList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGIDLIST);
    }

    public void setSsatrAssetTransferEMSsalBuildingIDList(List<SsatrAssetTransfer> ssatrAssetTransferEMSsalBuildingIDList) {
        set(PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGIDLIST, ssatrAssetTransferEMSsalBuildingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferEMSsalBuildingDestIDList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGDESTIDLIST);
    }

    public void setSsatrAssetTransferEMSsalBuildingDestIDList(List<SsatrAssetTransfer> ssatrAssetTransferEMSsalBuildingDestIDList) {
        set(PROPERTY_SSATRASSETTRANSFEREMSSALBUILDINGDESTIDLIST, ssatrAssetTransferEMSsalBuildingDestIDList);
    }

}
