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
package ec.com.sidesoft.custom.closecash;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity Sccc_Payment_Method (stored in table sccc_payment_method).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScccPaymentMethod extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sccc_payment_method";
    public static final String ENTITY_NAME = "Sccc_Payment_Method";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_ORDERNUMBER = "orderNumber";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_TYPEACCOUNT = "typeaccount";
    public static final String PROPERTY_SCCCSETUP = "scccSetup";
    public static final String PROPERTY_BLIND = "blind";
    public static final String PROPERTY_SSCRCCDETAILED = "sscrccDetailed";
    public static final String PROPERTY_SSCCCINDIFFERENCE = "sscccinDifference";
    public static final String PROPERTY_ISSHOWREPORT = "isshowreport";
    public static final String PROPERTY_SSCCCINVALDEPOSIT = "sscccinValdeposit";
    public static final String PROPERTY_SSCCCINVALFINACC = "sscccinValfinacc";

    public ScccPaymentMethod() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_BLIND, true);
        setDefaultValue(PROPERTY_SSCRCCDETAILED, false);
        setDefaultValue(PROPERTY_SSCCCINDIFFERENCE, false);
        setDefaultValue(PROPERTY_ISSHOWREPORT, false);
        setDefaultValue(PROPERTY_SSCCCINVALDEPOSIT, false);
        setDefaultValue(PROPERTY_SSCCCINVALFINACC, false);
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

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public Long getOrderNumber() {
        return (Long) get(PROPERTY_ORDERNUMBER);
    }

    public void setOrderNumber(Long orderNumber) {
        set(PROPERTY_ORDERNUMBER, orderNumber);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public String getTypeaccount() {
        return (String) get(PROPERTY_TYPEACCOUNT);
    }

    public void setTypeaccount(String typeaccount) {
        set(PROPERTY_TYPEACCOUNT, typeaccount);
    }

    public ScccSetup getScccSetup() {
        return (ScccSetup) get(PROPERTY_SCCCSETUP);
    }

    public void setScccSetup(ScccSetup scccSetup) {
        set(PROPERTY_SCCCSETUP, scccSetup);
    }

    public Boolean isBlind() {
        return (Boolean) get(PROPERTY_BLIND);
    }

    public void setBlind(Boolean blind) {
        set(PROPERTY_BLIND, blind);
    }

    public Boolean isSscrccDetailed() {
        return (Boolean) get(PROPERTY_SSCRCCDETAILED);
    }

    public void setSscrccDetailed(Boolean sscrccDetailed) {
        set(PROPERTY_SSCRCCDETAILED, sscrccDetailed);
    }

    public Boolean isSscccinDifference() {
        return (Boolean) get(PROPERTY_SSCCCINDIFFERENCE);
    }

    public void setSscccinDifference(Boolean sscccinDifference) {
        set(PROPERTY_SSCCCINDIFFERENCE, sscccinDifference);
    }

    public Boolean isShowreport() {
        return (Boolean) get(PROPERTY_ISSHOWREPORT);
    }

    public void setShowreport(Boolean isshowreport) {
        set(PROPERTY_ISSHOWREPORT, isshowreport);
    }

    public Boolean isSscccinValdeposit() {
        return (Boolean) get(PROPERTY_SSCCCINVALDEPOSIT);
    }

    public void setSscccinValdeposit(Boolean sscccinValdeposit) {
        set(PROPERTY_SSCCCINVALDEPOSIT, sscccinValdeposit);
    }

    public Boolean isSscccinValfinacc() {
        return (Boolean) get(PROPERTY_SSCCCINVALFINACC);
    }

    public void setSscccinValfinacc(Boolean sscccinValfinacc) {
        set(PROPERTY_SSCCCINVALFINACC, sscccinValfinacc);
    }

}
