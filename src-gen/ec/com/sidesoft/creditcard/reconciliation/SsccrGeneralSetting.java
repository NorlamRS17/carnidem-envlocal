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
package ec.com.sidesoft.creditcard.reconciliation;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.Element;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
/**
 * Entity class for entity Ssccr_General_Setting (stored in table Ssccr_General_Setting).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsccrGeneralSetting extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssccr_General_Setting";
    public static final String ENTITY_NAME = "Ssccr_General_Setting";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_AGRUP = "agrup";
    public static final String PROPERTY_SCCRTTRANSITVALUE = "sccrtTransitvalue";
    public static final String PROPERTY_SCCRTIVARETENTION = "sccrtIvaretention";
    public static final String PROPERTY_SCCRTRENTRETENTION = "sccrtRentretention";

    public SsccrGeneralSetting() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_AGRUP, false);
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

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Boolean isAgrup() {
        return (Boolean) get(PROPERTY_AGRUP);
    }

    public void setAgrup(Boolean agrup) {
        set(PROPERTY_AGRUP, agrup);
    }

    public Element getSccrtTransitvalue() {
        return (Element) get(PROPERTY_SCCRTTRANSITVALUE);
    }

    public void setSccrtTransitvalue(Element sccrtTransitvalue) {
        set(PROPERTY_SCCRTTRANSITVALUE, sccrtTransitvalue);
    }

    public Element getSccrtIvaretention() {
        return (Element) get(PROPERTY_SCCRTIVARETENTION);
    }

    public void setSccrtIvaretention(Element sccrtIvaretention) {
        set(PROPERTY_SCCRTIVARETENTION, sccrtIvaretention);
    }

    public Element getSccrtRentretention() {
        return (Element) get(PROPERTY_SCCRTRENTRETENTION);
    }

    public void setSccrtRentretention(Element sccrtRentretention) {
        set(PROPERTY_SCCRTRENTRETENTION, sccrtRentretention);
    }

}
