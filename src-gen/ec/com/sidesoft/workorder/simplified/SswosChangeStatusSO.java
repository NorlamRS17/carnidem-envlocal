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
package ec.com.sidesoft.workorder.simplified;

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
 * Entity class for entity Sswos_Change_Status_SO (stored in table Sswos_Change_Status_SO).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswosChangeStatusSO extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswos_Change_Status_SO";
    public static final String ENTITY_NAME = "Sswos_Change_Status_SO";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_ACTIONPROCESS = "actionProcess";
    public static final String PROPERTY_DATEPROCESS = "dateProcess";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROVIDER = "provider";
    public static final String PROPERTY_ACTIONLOAD = "actionLoad";
    public static final String PROPERTY_SSWOSCHANGESTATUSSOLINELIST = "sswosChangeStatusSOLineList";

    public SswosChangeStatusSO() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_ACTIONPROCESS, false);
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_ACTIONLOAD, false);
        setDefaultValue(PROPERTY_SSWOSCHANGESTATUSSOLINELIST, new ArrayList<Object>());
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

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Boolean isActionProcess() {
        return (Boolean) get(PROPERTY_ACTIONPROCESS);
    }

    public void setActionProcess(Boolean actionProcess) {
        set(PROPERTY_ACTIONPROCESS, actionProcess);
    }

    public Date getDateProcess() {
        return (Date) get(PROPERTY_DATEPROCESS);
    }

    public void setDateProcess(Date dateProcess) {
        set(PROPERTY_DATEPROCESS, dateProcess);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public BusinessPartner getProvider() {
        return (BusinessPartner) get(PROPERTY_PROVIDER);
    }

    public void setProvider(BusinessPartner provider) {
        set(PROPERTY_PROVIDER, provider);
    }

    public Boolean isActionLoad() {
        return (Boolean) get(PROPERTY_ACTIONLOAD);
    }

    public void setActionLoad(Boolean actionLoad) {
        set(PROPERTY_ACTIONLOAD, actionLoad);
    }

    @SuppressWarnings("unchecked")
    public List<SswosChangeStatusSOLine> getSswosChangeStatusSOLineList() {
      return (List<SswosChangeStatusSOLine>) get(PROPERTY_SSWOSCHANGESTATUSSOLINELIST);
    }

    public void setSswosChangeStatusSOLineList(List<SswosChangeStatusSOLine> sswosChangeStatusSOLineList) {
        set(PROPERTY_SSWOSCHANGESTATUSSOLINELIST, sswosChangeStatusSOLineList);
    }

}
