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
package ec.com.sidesoft.hrm.payroll.payment.rol;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSPRPR_Config (stored in table ssprpr_config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSPRPRConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssprpr_config";
    public static final String ENTITY_NAME = "SSPRPR_Config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BODY = "body";
    public static final String PROPERTY_FOOTER = "footer";
    public static final String PROPERTY_SUBJECT = "subject";
    public static final String PROPERTY_REPORTFORMAT = "reportformat";
    public static final String PROPERTY_SSPRPRFBODY = "ssprprfBody";
    public static final String PROPERTY_SSPRPRFFOOTER = "ssprprfFooter";
    public static final String PROPERTY_SSPRPRFSUBJECT = "ssprprfSubject";

    public SSPRPRConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
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

    public String getBody() {
        return (String) get(PROPERTY_BODY);
    }

    public void setBody(String body) {
        set(PROPERTY_BODY, body);
    }

    public String getFooter() {
        return (String) get(PROPERTY_FOOTER);
    }

    public void setFooter(String footer) {
        set(PROPERTY_FOOTER, footer);
    }

    public String getSubject() {
        return (String) get(PROPERTY_SUBJECT);
    }

    public void setSubject(String subject) {
        set(PROPERTY_SUBJECT, subject);
    }

    public String getReportformat() {
        return (String) get(PROPERTY_REPORTFORMAT);
    }

    public void setReportformat(String reportformat) {
        set(PROPERTY_REPORTFORMAT, reportformat);
    }

    public String getSsprprfBody() {
        return (String) get(PROPERTY_SSPRPRFBODY);
    }

    public void setSsprprfBody(String ssprprfBody) {
        set(PROPERTY_SSPRPRFBODY, ssprprfBody);
    }

    public String getSsprprfFooter() {
        return (String) get(PROPERTY_SSPRPRFFOOTER);
    }

    public void setSsprprfFooter(String ssprprfFooter) {
        set(PROPERTY_SSPRPRFFOOTER, ssprprfFooter);
    }

    public String getSsprprfSubject() {
        return (String) get(PROPERTY_SSPRPRFSUBJECT);
    }

    public void setSsprprfSubject(String ssprprfSubject) {
        set(PROPERTY_SSPRPRFSUBJECT, ssprprfSubject);
    }

}
