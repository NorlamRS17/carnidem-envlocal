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
package ec.com.sidesoft.payroll.overtime;

import com.sidesoft.ecuador.humanResources.sshrDepartment;

import java.math.BigDecimal;
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
import org.openbravo.model.common.geography.City;
/**
 * Entity class for entity sprov_overtime (stored in table sprov_overtime).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sprovovertime extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sprov_overtime";
    public static final String ENTITY_NAME = "sprov_overtime";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DATEMOVEMENT = "datemovement";
    public static final String PROPERTY_SSHRDEPARTMENT = "sshrDepartment";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_CITY = "city";
    public static final String PROPERTY_HOURSAUTH = "hoursAuth";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_LOADBIOMETRIC = "loadBiometric";
    public static final String PROPERTY_AUTHORIZATIONPROCESS = "authorizationProcess";
    public static final String PROPERTY_SPROVOVERTIMELINELIST = "sprovOvertimeLineList";

    public sprovovertime() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_HOURSAUTH, new BigDecimal(0));
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_LOADBIOMETRIC, "LB");
        setDefaultValue(PROPERTY_AUTHORIZATIONPROCESS, "DR");
        setDefaultValue(PROPERTY_SPROVOVERTIMELINELIST, new ArrayList<Object>());
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDatemovement() {
        return (Date) get(PROPERTY_DATEMOVEMENT);
    }

    public void setDatemovement(Date datemovement) {
        set(PROPERTY_DATEMOVEMENT, datemovement);
    }

    public sshrDepartment getSshrDepartment() {
        return (sshrDepartment) get(PROPERTY_SSHRDEPARTMENT);
    }

    public void setSshrDepartment(sshrDepartment sshrDepartment) {
        set(PROPERTY_SSHRDEPARTMENT, sshrDepartment);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public City getCity() {
        return (City) get(PROPERTY_CITY);
    }

    public void setCity(City city) {
        set(PROPERTY_CITY, city);
    }

    public BigDecimal getHoursAuth() {
        return (BigDecimal) get(PROPERTY_HOURSAUTH);
    }

    public void setHoursAuth(BigDecimal hoursAuth) {
        set(PROPERTY_HOURSAUTH, hoursAuth);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public String getLoadBiometric() {
        return (String) get(PROPERTY_LOADBIOMETRIC);
    }

    public void setLoadBiometric(String loadBiometric) {
        set(PROPERTY_LOADBIOMETRIC, loadBiometric);
    }

    public String getAuthorizationProcess() {
        return (String) get(PROPERTY_AUTHORIZATIONPROCESS);
    }

    public void setAuthorizationProcess(String authorizationProcess) {
        set(PROPERTY_AUTHORIZATIONPROCESS, authorizationProcess);
    }

    @SuppressWarnings("unchecked")
    public List<sprovovertimeline> getSprovOvertimeLineList() {
      return (List<sprovovertimeline>) get(PROPERTY_SPROVOVERTIMELINELIST);
    }

    public void setSprovOvertimeLineList(List<sprovovertimeline> sprovOvertimeLineList) {
        set(PROPERTY_SPROVOVERTIMELINELIST, sprovOvertimeLineList);
    }

}
