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
package org.openbravo.model.mrp;

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
/**
 * Entity class for entity MRPSalesForecast (stored in table MRP_SalesForecast).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SalesForecast extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "MRP_SalesForecast";
    public static final String ENTITY_NAME = "MRPSalesForecast";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTDATE = "documentDate";
    public static final String PROPERTY_SCMFTYPESALESFORECAST = "scmfTypesalesforecast";
    public static final String PROPERTY_SCMFHISTORYMONTH = "scmfHistorymonth";
    public static final String PROPERTY_SCMFYEARSNUMBER = "scmfYearsnumber";
    public static final String PROPERTY_SCMFHISTORYDAYS = "scmfHistorydays";
    public static final String PROPERTY_SCMFDAYFORECAST = "scmfDayforecast";
    public static final String PROPERTY_SCMFPROCESSFORECAST = "scmfProcessforecast";
    public static final String PROPERTY_CSCMDELETELINES = "cscmDeletelines";
    public static final String PROPERTY_SSMRPAPPROVEFORECASTS = "ssmrpApproveforecasts";
    public static final String PROPERTY_SSMRPDOCSTATUS = "ssmrpDocstatus";
    public static final String PROPERTY_MRPSALESFORECASTLINELIST = "mRPSalesForecastLineList";

    public SalesForecast() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_SCMFPROCESSFORECAST, false);
        setDefaultValue(PROPERTY_CSCMDELETELINES, false);
        setDefaultValue(PROPERTY_SSMRPAPPROVEFORECASTS, "APF");
        setDefaultValue(PROPERTY_SSMRPDOCSTATUS, "DR");
        setDefaultValue(PROPERTY_MRPSALESFORECASTLINELIST, new ArrayList<Object>());
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

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Date getDocumentDate() {
        return (Date) get(PROPERTY_DOCUMENTDATE);
    }

    public void setDocumentDate(Date documentDate) {
        set(PROPERTY_DOCUMENTDATE, documentDate);
    }

    public String getScmfTypesalesforecast() {
        return (String) get(PROPERTY_SCMFTYPESALESFORECAST);
    }

    public void setScmfTypesalesforecast(String scmfTypesalesforecast) {
        set(PROPERTY_SCMFTYPESALESFORECAST, scmfTypesalesforecast);
    }

    public String getScmfHistorymonth() {
        return (String) get(PROPERTY_SCMFHISTORYMONTH);
    }

    public void setScmfHistorymonth(String scmfHistorymonth) {
        set(PROPERTY_SCMFHISTORYMONTH, scmfHistorymonth);
    }

    public Long getScmfYearsnumber() {
        return (Long) get(PROPERTY_SCMFYEARSNUMBER);
    }

    public void setScmfYearsnumber(Long scmfYearsnumber) {
        set(PROPERTY_SCMFYEARSNUMBER, scmfYearsnumber);
    }

    public Long getScmfHistorydays() {
        return (Long) get(PROPERTY_SCMFHISTORYDAYS);
    }

    public void setScmfHistorydays(Long scmfHistorydays) {
        set(PROPERTY_SCMFHISTORYDAYS, scmfHistorydays);
    }

    public String getScmfDayforecast() {
        return (String) get(PROPERTY_SCMFDAYFORECAST);
    }

    public void setScmfDayforecast(String scmfDayforecast) {
        set(PROPERTY_SCMFDAYFORECAST, scmfDayforecast);
    }

    public Boolean isScmfProcessforecast() {
        return (Boolean) get(PROPERTY_SCMFPROCESSFORECAST);
    }

    public void setScmfProcessforecast(Boolean scmfProcessforecast) {
        set(PROPERTY_SCMFPROCESSFORECAST, scmfProcessforecast);
    }

    public Boolean isCscmDeletelines() {
        return (Boolean) get(PROPERTY_CSCMDELETELINES);
    }

    public void setCscmDeletelines(Boolean cscmDeletelines) {
        set(PROPERTY_CSCMDELETELINES, cscmDeletelines);
    }

    public String getSsmrpApproveforecasts() {
        return (String) get(PROPERTY_SSMRPAPPROVEFORECASTS);
    }

    public void setSsmrpApproveforecasts(String ssmrpApproveforecasts) {
        set(PROPERTY_SSMRPAPPROVEFORECASTS, ssmrpApproveforecasts);
    }

    public String getSsmrpDocstatus() {
        return (String) get(PROPERTY_SSMRPDOCSTATUS);
    }

    public void setSsmrpDocstatus(String ssmrpDocstatus) {
        set(PROPERTY_SSMRPDOCSTATUS, ssmrpDocstatus);
    }

    @SuppressWarnings("unchecked")
    public List<SalesForecastLine> getMRPSalesForecastLineList() {
      return (List<SalesForecastLine>) get(PROPERTY_MRPSALESFORECASTLINELIST);
    }

    public void setMRPSalesForecastLineList(List<SalesForecastLine> mRPSalesForecastLineList) {
        set(PROPERTY_MRPSALESFORECASTLINELIST, mRPSalesForecastLineList);
    }

}
