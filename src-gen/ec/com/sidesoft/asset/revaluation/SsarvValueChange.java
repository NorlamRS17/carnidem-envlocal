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
package ec.com.sidesoft.asset.revaluation;

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
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
/**
 * Entity class for entity ssarv_value_change (stored in table ssarv_value_change).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsarvValueChange extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssarv_value_change";
    public static final String ENTITY_NAME = "ssarv_value_change";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_HVDATEPURCHASED = "hVDatepurchased";
    public static final String PROPERTY_HVAMORTIZATIONTYPE = "hVAmortizationtype";
    public static final String PROPERTY_HVAMORTIZATIONCALCTYPE = "hVAmortizationcalctype";
    public static final String PROPERTY_HVAMORTIZATIONSTARTDATE = "hVAmortizationstartdate";
    public static final String PROPERTY_HVAMORTIZATIONENDDATE = "hVAmortizationenddate";
    public static final String PROPERTY_HVASSETSCHEDULE = "hVAssetschedule";
    public static final String PROPERTY_HVUSELIFEMONTHS = "hVUselifemonths";
    public static final String PROPERTY_HVASSETVALUEAMT = "hVAssetvalueamt";
    public static final String PROPERTY_HVRESIDUALASSETVALUEAMT = "hVResidualassetvalueamt";
    public static final String PROPERTY_HVAMORTIZATIONVALUEAMT = "hVAmortizationvalueamt";
    public static final String PROPERTY_HVDEPRECIATEDPREVIOUSAMT = "hVDepreciatedpreviousamt";
    public static final String PROPERTY_HVNETWORTH = "hVNetWorth";
    public static final String PROPERTY_HVVALUEINBOOKS = "hVValueInBooks";
    public static final String PROPERTY_HVTAXCATEGORY = "hVTaxcategory";
    public static final String PROPERTY_HVTAXAMT = "hVTaxamt";
    public static final String PROPERTY_HVTOTALPURCHASEAMT = "hVTotalpurchaseamt";
    public static final String PROPERTY_NVCHANGEDATE = "nVChangedate";
    public static final String PROPERTY_NVDESCRIPTION = "nVDescription";
    public static final String PROPERTY_NVDATEPURCHASED = "nVDatepurchased";
    public static final String PROPERTY_NVAMORTIZATIONTYPE = "nVAmortizationtype";
    public static final String PROPERTY_NVAMORTIZATIONCALCTYPE = "nVAmortizationcalctype";
    public static final String PROPERTY_NVAMORTIZATIONSTARTDATE = "nVAmortizationstartdate";
    public static final String PROPERTY_NVAMORTIZATIONENDDATE = "nVAmortizationenddate";
    public static final String PROPERTY_NVASSETSCHEDULE = "nVAssetschedule";
    public static final String PROPERTY_NVUSELIFEMONTHS = "nVUselifemonths";
    public static final String PROPERTY_NVASSETVALUEAMT = "nVAssetvalueamt";
    public static final String PROPERTY_NVRESIDUALASSETVALUEAMT = "nVResidualassetvalueamt";
    public static final String PROPERTY_NVAMORTIZATIONVALUEAMT = "nVAmortizationvalueamt";
    public static final String PROPERTY_NVTAXCATEGORY = "nVTaxcategory";
    public static final String PROPERTY_NVTAXAMT = "nVTaxamt";
    public static final String PROPERTY_NVTOTALPURCHASEAMT = "nVTotalpurchaseamt";
    public static final String PROPERTY_ASSET = "asset";

    public SsarvValueChange() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_HVASSETVALUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVRESIDUALASSETVALUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVAMORTIZATIONVALUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVDEPRECIATEDPREVIOUSAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVNETWORTH, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVVALUEINBOOKS, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVTAXAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_HVTOTALPURCHASEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_NVASSETVALUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_NVRESIDUALASSETVALUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_NVAMORTIZATIONVALUEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_NVTAXAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_NVTOTALPURCHASEAMT, new BigDecimal(0));
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

    public Date getHVDatepurchased() {
        return (Date) get(PROPERTY_HVDATEPURCHASED);
    }

    public void setHVDatepurchased(Date hVDatepurchased) {
        set(PROPERTY_HVDATEPURCHASED, hVDatepurchased);
    }

    public String getHVAmortizationtype() {
        return (String) get(PROPERTY_HVAMORTIZATIONTYPE);
    }

    public void setHVAmortizationtype(String hVAmortizationtype) {
        set(PROPERTY_HVAMORTIZATIONTYPE, hVAmortizationtype);
    }

    public String getHVAmortizationcalctype() {
        return (String) get(PROPERTY_HVAMORTIZATIONCALCTYPE);
    }

    public void setHVAmortizationcalctype(String hVAmortizationcalctype) {
        set(PROPERTY_HVAMORTIZATIONCALCTYPE, hVAmortizationcalctype);
    }

    public Date getHVAmortizationstartdate() {
        return (Date) get(PROPERTY_HVAMORTIZATIONSTARTDATE);
    }

    public void setHVAmortizationstartdate(Date hVAmortizationstartdate) {
        set(PROPERTY_HVAMORTIZATIONSTARTDATE, hVAmortizationstartdate);
    }

    public Date getHVAmortizationenddate() {
        return (Date) get(PROPERTY_HVAMORTIZATIONENDDATE);
    }

    public void setHVAmortizationenddate(Date hVAmortizationenddate) {
        set(PROPERTY_HVAMORTIZATIONENDDATE, hVAmortizationenddate);
    }

    public String getHVAssetschedule() {
        return (String) get(PROPERTY_HVASSETSCHEDULE);
    }

    public void setHVAssetschedule(String hVAssetschedule) {
        set(PROPERTY_HVASSETSCHEDULE, hVAssetschedule);
    }

    public Long getHVUselifemonths() {
        return (Long) get(PROPERTY_HVUSELIFEMONTHS);
    }

    public void setHVUselifemonths(Long hVUselifemonths) {
        set(PROPERTY_HVUSELIFEMONTHS, hVUselifemonths);
    }

    public BigDecimal getHVAssetvalueamt() {
        return (BigDecimal) get(PROPERTY_HVASSETVALUEAMT);
    }

    public void setHVAssetvalueamt(BigDecimal hVAssetvalueamt) {
        set(PROPERTY_HVASSETVALUEAMT, hVAssetvalueamt);
    }

    public BigDecimal getHVResidualassetvalueamt() {
        return (BigDecimal) get(PROPERTY_HVRESIDUALASSETVALUEAMT);
    }

    public void setHVResidualassetvalueamt(BigDecimal hVResidualassetvalueamt) {
        set(PROPERTY_HVRESIDUALASSETVALUEAMT, hVResidualassetvalueamt);
    }

    public BigDecimal getHVAmortizationvalueamt() {
        return (BigDecimal) get(PROPERTY_HVAMORTIZATIONVALUEAMT);
    }

    public void setHVAmortizationvalueamt(BigDecimal hVAmortizationvalueamt) {
        set(PROPERTY_HVAMORTIZATIONVALUEAMT, hVAmortizationvalueamt);
    }

    public BigDecimal getHVDepreciatedpreviousamt() {
        return (BigDecimal) get(PROPERTY_HVDEPRECIATEDPREVIOUSAMT);
    }

    public void setHVDepreciatedpreviousamt(BigDecimal hVDepreciatedpreviousamt) {
        set(PROPERTY_HVDEPRECIATEDPREVIOUSAMT, hVDepreciatedpreviousamt);
    }

    public BigDecimal getHVNetWorth() {
        return (BigDecimal) get(PROPERTY_HVNETWORTH);
    }

    public void setHVNetWorth(BigDecimal hVNetWorth) {
        set(PROPERTY_HVNETWORTH, hVNetWorth);
    }

    public BigDecimal getHVValueInBooks() {
        return (BigDecimal) get(PROPERTY_HVVALUEINBOOKS);
    }

    public void setHVValueInBooks(BigDecimal hVValueInBooks) {
        set(PROPERTY_HVVALUEINBOOKS, hVValueInBooks);
    }

    public TaxCategory getHVTaxcategory() {
        return (TaxCategory) get(PROPERTY_HVTAXCATEGORY);
    }

    public void setHVTaxcategory(TaxCategory hVTaxcategory) {
        set(PROPERTY_HVTAXCATEGORY, hVTaxcategory);
    }

    public BigDecimal getHVTaxamt() {
        return (BigDecimal) get(PROPERTY_HVTAXAMT);
    }

    public void setHVTaxamt(BigDecimal hVTaxamt) {
        set(PROPERTY_HVTAXAMT, hVTaxamt);
    }

    public BigDecimal getHVTotalpurchaseamt() {
        return (BigDecimal) get(PROPERTY_HVTOTALPURCHASEAMT);
    }

    public void setHVTotalpurchaseamt(BigDecimal hVTotalpurchaseamt) {
        set(PROPERTY_HVTOTALPURCHASEAMT, hVTotalpurchaseamt);
    }

    public Date getNVChangedate() {
        return (Date) get(PROPERTY_NVCHANGEDATE);
    }

    public void setNVChangedate(Date nVChangedate) {
        set(PROPERTY_NVCHANGEDATE, nVChangedate);
    }

    public String getNVDescription() {
        return (String) get(PROPERTY_NVDESCRIPTION);
    }

    public void setNVDescription(String nVDescription) {
        set(PROPERTY_NVDESCRIPTION, nVDescription);
    }

    public Date getNVDatepurchased() {
        return (Date) get(PROPERTY_NVDATEPURCHASED);
    }

    public void setNVDatepurchased(Date nVDatepurchased) {
        set(PROPERTY_NVDATEPURCHASED, nVDatepurchased);
    }

    public String getNVAmortizationtype() {
        return (String) get(PROPERTY_NVAMORTIZATIONTYPE);
    }

    public void setNVAmortizationtype(String nVAmortizationtype) {
        set(PROPERTY_NVAMORTIZATIONTYPE, nVAmortizationtype);
    }

    public String getNVAmortizationcalctype() {
        return (String) get(PROPERTY_NVAMORTIZATIONCALCTYPE);
    }

    public void setNVAmortizationcalctype(String nVAmortizationcalctype) {
        set(PROPERTY_NVAMORTIZATIONCALCTYPE, nVAmortizationcalctype);
    }

    public Date getNVAmortizationstartdate() {
        return (Date) get(PROPERTY_NVAMORTIZATIONSTARTDATE);
    }

    public void setNVAmortizationstartdate(Date nVAmortizationstartdate) {
        set(PROPERTY_NVAMORTIZATIONSTARTDATE, nVAmortizationstartdate);
    }

    public Date getNVAmortizationenddate() {
        return (Date) get(PROPERTY_NVAMORTIZATIONENDDATE);
    }

    public void setNVAmortizationenddate(Date nVAmortizationenddate) {
        set(PROPERTY_NVAMORTIZATIONENDDATE, nVAmortizationenddate);
    }

    public String getNVAssetschedule() {
        return (String) get(PROPERTY_NVASSETSCHEDULE);
    }

    public void setNVAssetschedule(String nVAssetschedule) {
        set(PROPERTY_NVASSETSCHEDULE, nVAssetschedule);
    }

    public Long getNVUselifemonths() {
        return (Long) get(PROPERTY_NVUSELIFEMONTHS);
    }

    public void setNVUselifemonths(Long nVUselifemonths) {
        set(PROPERTY_NVUSELIFEMONTHS, nVUselifemonths);
    }

    public BigDecimal getNVAssetvalueamt() {
        return (BigDecimal) get(PROPERTY_NVASSETVALUEAMT);
    }

    public void setNVAssetvalueamt(BigDecimal nVAssetvalueamt) {
        set(PROPERTY_NVASSETVALUEAMT, nVAssetvalueamt);
    }

    public BigDecimal getNVResidualassetvalueamt() {
        return (BigDecimal) get(PROPERTY_NVRESIDUALASSETVALUEAMT);
    }

    public void setNVResidualassetvalueamt(BigDecimal nVResidualassetvalueamt) {
        set(PROPERTY_NVRESIDUALASSETVALUEAMT, nVResidualassetvalueamt);
    }

    public BigDecimal getNVAmortizationvalueamt() {
        return (BigDecimal) get(PROPERTY_NVAMORTIZATIONVALUEAMT);
    }

    public void setNVAmortizationvalueamt(BigDecimal nVAmortizationvalueamt) {
        set(PROPERTY_NVAMORTIZATIONVALUEAMT, nVAmortizationvalueamt);
    }

    public TaxCategory getNVTaxcategory() {
        return (TaxCategory) get(PROPERTY_NVTAXCATEGORY);
    }

    public void setNVTaxcategory(TaxCategory nVTaxcategory) {
        set(PROPERTY_NVTAXCATEGORY, nVTaxcategory);
    }

    public BigDecimal getNVTaxamt() {
        return (BigDecimal) get(PROPERTY_NVTAXAMT);
    }

    public void setNVTaxamt(BigDecimal nVTaxamt) {
        set(PROPERTY_NVTAXAMT, nVTaxamt);
    }

    public BigDecimal getNVTotalpurchaseamt() {
        return (BigDecimal) get(PROPERTY_NVTOTALPURCHASEAMT);
    }

    public void setNVTotalpurchaseamt(BigDecimal nVTotalpurchaseamt) {
        set(PROPERTY_NVTOTALPURCHASEAMT, nVTotalpurchaseamt);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

}
