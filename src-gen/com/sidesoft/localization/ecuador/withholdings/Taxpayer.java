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
package com.sidesoft.localization.ecuador.withholdings;

import ec.com.sidesoft.custom.ws.api.ScwsapConfig;
import ec.com.sidesoft.localization.ecuador.bpartner.complement.SBPCInfoPartnersV;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPartner;
import ec.com.sidesoft.ws.paymentscreate.SWSPCConfig;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.OrganizationInformation;
/**
 * Entity class for entity SSWH_Taxpayer (stored in table SSWH_Taxpayer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Taxpayer extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSWH_Taxpayer";
    public static final String ENTITY_NAME = "SSWH_Taxpayer";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SPECIALTAXPAYER = "specialtaxpayer";
    public static final String PROPERTY_REQUIREDACCOUNTING = "requiredaccounting";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_RELATEDPART = "relatedPart";
    public static final String PROPERTY_EEINOELECTRONIC = "eEINoElectronic";
    public static final String PROPERTY_CSWAFISPOPULAR = "cswafIspopular";
    public static final String PROPERTY_BUSINESSPARTNEREMSSWHTAXPAYERIDLIST = "businessPartnerEMSSWHTaxpayerIDList";
    public static final String PROPERTY_ORGANIZATIONINFORMATIONEMSSWHTAXPAYERIDLIST = "organizationInformationEMSswhTaxpayerIDList";
    public static final String PROPERTY_SBPCINFOPARTNERSVLIST = "sBPCInfoPartnersVList";
    public static final String PROPERTY_SSWHWITHHOLDINGLIST = "sSWHWithholdingList";
    public static final String PROPERTY_SSWHWITHHOLDINGSSWHTAXPAYERREFIDLIST = "sSWHWithholdingSswhTaxpayerRefIDList";
    public static final String PROPERTY_IMDLVPARTNERLIST = "imdlvPartnerList";
    public static final String PROPERTY_SCWSAPCONFIGPARTNERTAXPAYERIDLIST = "scwsapConfigPartnerTaxpayerIDList";
    public static final String PROPERTY_SWSPCCONFIGLIST = "swspcConfigList";

    public Taxpayer() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SPECIALTAXPAYER, false);
        setDefaultValue(PROPERTY_REQUIREDACCOUNTING, false);
        setDefaultValue(PROPERTY_RELATEDPART, false);
        setDefaultValue(PROPERTY_EEINOELECTRONIC, false);
        setDefaultValue(PROPERTY_CSWAFISPOPULAR, false);
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSWHTAXPAYERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONINFORMATIONEMSSWHTAXPAYERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPCINFOPARTNERSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGSSWHTAXPAYERREFIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPARTNERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCWSAPCONFIGPARTNERTAXPAYERIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSPCCONFIGLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isSpecialtaxpayer() {
        return (Boolean) get(PROPERTY_SPECIALTAXPAYER);
    }

    public void setSpecialtaxpayer(Boolean specialtaxpayer) {
        set(PROPERTY_SPECIALTAXPAYER, specialtaxpayer);
    }

    public Boolean isRequiredaccounting() {
        return (Boolean) get(PROPERTY_REQUIREDACCOUNTING);
    }

    public void setRequiredaccounting(Boolean requiredaccounting) {
        set(PROPERTY_REQUIREDACCOUNTING, requiredaccounting);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Boolean isRelatedPart() {
        return (Boolean) get(PROPERTY_RELATEDPART);
    }

    public void setRelatedPart(Boolean relatedPart) {
        set(PROPERTY_RELATEDPART, relatedPart);
    }

    public Boolean isEEINoElectronic() {
        return (Boolean) get(PROPERTY_EEINOELECTRONIC);
    }

    public void setEEINoElectronic(Boolean eEINoElectronic) {
        set(PROPERTY_EEINOELECTRONIC, eEINoElectronic);
    }

    public Boolean isCswafIspopular() {
        return (Boolean) get(PROPERTY_CSWAFISPOPULAR);
    }

    public void setCswafIspopular(Boolean cswafIspopular) {
        set(PROPERTY_CSWAFISPOPULAR, cswafIspopular);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSSWHTaxpayerIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSWHTAXPAYERIDLIST);
    }

    public void setBusinessPartnerEMSSWHTaxpayerIDList(List<BusinessPartner> businessPartnerEMSSWHTaxpayerIDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSWHTAXPAYERIDLIST, businessPartnerEMSSWHTaxpayerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationInformation> getOrganizationInformationEMSswhTaxpayerIDList() {
      return (List<OrganizationInformation>) get(PROPERTY_ORGANIZATIONINFORMATIONEMSSWHTAXPAYERIDLIST);
    }

    public void setOrganizationInformationEMSswhTaxpayerIDList(List<OrganizationInformation> organizationInformationEMSswhTaxpayerIDList) {
        set(PROPERTY_ORGANIZATIONINFORMATIONEMSSWHTAXPAYERIDLIST, organizationInformationEMSswhTaxpayerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SBPCInfoPartnersV> getSBPCInfoPartnersVList() {
      return (List<SBPCInfoPartnersV>) get(PROPERTY_SBPCINFOPARTNERSVLIST);
    }

    public void setSBPCInfoPartnersVList(List<SBPCInfoPartnersV> sBPCInfoPartnersVList) {
        set(PROPERTY_SBPCINFOPARTNERSVLIST, sBPCInfoPartnersVList);
    }

    @SuppressWarnings("unchecked")
    public List<Withholding> getSSWHWithholdingList() {
      return (List<Withholding>) get(PROPERTY_SSWHWITHHOLDINGLIST);
    }

    public void setSSWHWithholdingList(List<Withholding> sSWHWithholdingList) {
        set(PROPERTY_SSWHWITHHOLDINGLIST, sSWHWithholdingList);
    }

    @SuppressWarnings("unchecked")
    public List<Withholding> getSSWHWithholdingSswhTaxpayerRefIDList() {
      return (List<Withholding>) get(PROPERTY_SSWHWITHHOLDINGSSWHTAXPAYERREFIDLIST);
    }

    public void setSSWHWithholdingSswhTaxpayerRefIDList(List<Withholding> sSWHWithholdingSswhTaxpayerRefIDList) {
        set(PROPERTY_SSWHWITHHOLDINGSSWHTAXPAYERREFIDLIST, sSWHWithholdingSswhTaxpayerRefIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPartner> getImdlvPartnerList() {
      return (List<ImdlvPartner>) get(PROPERTY_IMDLVPARTNERLIST);
    }

    public void setImdlvPartnerList(List<ImdlvPartner> imdlvPartnerList) {
        set(PROPERTY_IMDLVPARTNERLIST, imdlvPartnerList);
    }

    @SuppressWarnings("unchecked")
    public List<ScwsapConfig> getScwsapConfigPartnerTaxpayerIDList() {
      return (List<ScwsapConfig>) get(PROPERTY_SCWSAPCONFIGPARTNERTAXPAYERIDLIST);
    }

    public void setScwsapConfigPartnerTaxpayerIDList(List<ScwsapConfig> scwsapConfigPartnerTaxpayerIDList) {
        set(PROPERTY_SCWSAPCONFIGPARTNERTAXPAYERIDLIST, scwsapConfigPartnerTaxpayerIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSPCConfig> getSwspcConfigList() {
      return (List<SWSPCConfig>) get(PROPERTY_SWSPCCONFIGLIST);
    }

    public void setSwspcConfigList(List<SWSPCConfig> swspcConfigList) {
        set(PROPERTY_SWSPCCONFIGLIST, swspcConfigList);
    }

}
