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

import java.math.BigDecimal;
import java.sql.Timestamp;
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
/**
 * Entity class for entity sprov_overtime_line (stored in table sprov_overtime_line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class sprovovertimeline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sprov_overtime_line";
    public static final String ENTITY_NAME = "sprov_overtime_line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_EXITSHIFT2 = "exitShift2";
    public static final String PROPERTY_EXITMARKING2 = "exitMarking2";
    public static final String PROPERTY_AUTHORIZEDTIME = "authorizedTime";
    public static final String PROPERTY_GENERATEDTIME = "generatedTime";
    public static final String PROPERTY_SPROVEXTRAREASONMAINT = "sprovExtraReasonMaint";
    public static final String PROPERTY_SPROVOVERTIME = "sprovOvertime";

    public sprovovertimeline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_GENERATEDTIME, new BigDecimal(0));
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

    public Timestamp getExitShift2() {
        return (Timestamp) get(PROPERTY_EXITSHIFT2);
    }

    public void setExitShift2(Timestamp exitShift2) {
        set(PROPERTY_EXITSHIFT2, exitShift2);
    }

    public Timestamp getExitMarking2() {
        return (Timestamp) get(PROPERTY_EXITMARKING2);
    }

    public void setExitMarking2(Timestamp exitMarking2) {
        set(PROPERTY_EXITMARKING2, exitMarking2);
    }

    public Timestamp getAuthorizedTime() {
        return (Timestamp) get(PROPERTY_AUTHORIZEDTIME);
    }

    public void setAuthorizedTime(Timestamp authorizedTime) {
        set(PROPERTY_AUTHORIZEDTIME, authorizedTime);
    }

    public BigDecimal getGeneratedTime() {
        return (BigDecimal) get(PROPERTY_GENERATEDTIME);
    }

    public void setGeneratedTime(BigDecimal generatedTime) {
        set(PROPERTY_GENERATEDTIME, generatedTime);
    }

    public SPROVExtraReasonMaint getSprovExtraReasonMaint() {
        return (SPROVExtraReasonMaint) get(PROPERTY_SPROVEXTRAREASONMAINT);
    }

    public void setSprovExtraReasonMaint(SPROVExtraReasonMaint sprovExtraReasonMaint) {
        set(PROPERTY_SPROVEXTRAREASONMAINT, sprovExtraReasonMaint);
    }

    public sprovovertime getSprovOvertime() {
        return (sprovovertime) get(PROPERTY_SPROVOVERTIME);
    }

    public void setSprovOvertime(sprovovertime sprovOvertime) {
        set(PROPERTY_SPROVOVERTIME, sprovOvertime);
    }

}
