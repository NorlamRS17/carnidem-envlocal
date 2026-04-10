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
 * Entity class for entity ssal_unit (stored in table ssal_unit).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssal_unit extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssal_unit";
    public static final String ENTITY_NAME = "ssal_unit";
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
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSALUNITIDLIST = "financialMgmtAssetEMSsalUnitIDList";
    public static final String PROPERTY_CSAAACUSTODIANUNITIDLIST = "csaaaCustodianUnitIDList";
    public static final String PROPERTY_CSAAACUSTODIANLINEUNITIDLIST = "csaaaCustodianlineUnitIDList";
    public static final String PROPERTY_CSAAACUSTODIANLINEUNIT2IDLIST = "csaaaCustodianlineUnit2IDList";
    public static final String PROPERTY_CSAAAINVTTKGLINEUNITIDLIST = "csaaaInvtTkgLineUnitIDList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";
    public static final String PROPERTY_SSATRASSETDETAILEMSSALUNITIDLIST = "ssatrAssetDetailEMSsalUnitIDList";
    public static final String PROPERTY_SSATRASSETTRANSFEREMSSALUNITIDLIST = "ssatrAssetTransferEMSsalUnitIDList";
    public static final String PROPERTY_SSATRASSETTRANSFEREMSSALUNITDESTIDLIST = "ssatrAssetTransferEMSsalUnitDestIDList";

    public ssal_unit() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSALUNITIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANUNITIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEUNITIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEUNIT2IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAAINVTTKGLINEUNITIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETDETAILEMSSALUNITIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFEREMSSALUNITIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFEREMSSALUNITDESTIDLIST, new ArrayList<Object>());
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
    public List<Asset> getFinancialMgmtAssetEMSsalUnitIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSALUNITIDLIST);
    }

    public void setFinancialMgmtAssetEMSsalUnitIDList(List<Asset> financialMgmtAssetEMSsalUnitIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSALUNITIDLIST, financialMgmtAssetEMSsalUnitIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodian> getCsaaaCustodianUnitIDList() {
      return (List<CsaaaCustodian>) get(PROPERTY_CSAAACUSTODIANUNITIDLIST);
    }

    public void setCsaaaCustodianUnitIDList(List<CsaaaCustodian> csaaaCustodianUnitIDList) {
        set(PROPERTY_CSAAACUSTODIANUNITIDLIST, csaaaCustodianUnitIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineUnitIDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEUNITIDLIST);
    }

    public void setCsaaaCustodianlineUnitIDList(List<CsaaaCustodianLine> csaaaCustodianlineUnitIDList) {
        set(PROPERTY_CSAAACUSTODIANLINEUNITIDLIST, csaaaCustodianlineUnitIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineUnit2IDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEUNIT2IDLIST);
    }

    public void setCsaaaCustodianlineUnit2IDList(List<CsaaaCustodianLine> csaaaCustodianlineUnit2IDList) {
        set(PROPERTY_CSAAACUSTODIANLINEUNIT2IDLIST, csaaaCustodianlineUnit2IDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTakingLine> getCsaaaInvtTkgLineUnitIDList() {
      return (List<CsaaaInventoryTakingLine>) get(PROPERTY_CSAAAINVTTKGLINEUNITIDLIST);
    }

    public void setCsaaaInvtTkgLineUnitIDList(List<CsaaaInventoryTakingLine> csaaaInvtTkgLineUnitIDList) {
        set(PROPERTY_CSAAAINVTTKGLINEUNITIDLIST, csaaaInvtTkgLineUnitIDList);
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
    public List<SsatrAssetDetail> getSsatrAssetDetailEMSsalUnitIDList() {
      return (List<SsatrAssetDetail>) get(PROPERTY_SSATRASSETDETAILEMSSALUNITIDLIST);
    }

    public void setSsatrAssetDetailEMSsalUnitIDList(List<SsatrAssetDetail> ssatrAssetDetailEMSsalUnitIDList) {
        set(PROPERTY_SSATRASSETDETAILEMSSALUNITIDLIST, ssatrAssetDetailEMSsalUnitIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferEMSsalUnitIDList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFEREMSSALUNITIDLIST);
    }

    public void setSsatrAssetTransferEMSsalUnitIDList(List<SsatrAssetTransfer> ssatrAssetTransferEMSsalUnitIDList) {
        set(PROPERTY_SSATRASSETTRANSFEREMSSALUNITIDLIST, ssatrAssetTransferEMSsalUnitIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferEMSsalUnitDestIDList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFEREMSSALUNITDESTIDLIST);
    }

    public void setSsatrAssetTransferEMSsalUnitDestIDList(List<SsatrAssetTransfer> ssatrAssetTransferEMSsalUnitDestIDList) {
        set(PROPERTY_SSATRASSETTRANSFEREMSSALUNITDESTIDLIST, ssatrAssetTransferEMSsalUnitDestIDList);
    }

}
