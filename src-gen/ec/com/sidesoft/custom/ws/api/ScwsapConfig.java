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
package ec.com.sidesoft.custom.ws.api;

import com.sidesoft.localization.ecuador.withholdings.Taxpayer;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.Category;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.pricing.pricelist.PriceList;
/**
 * Entity class for entity scwsap_config (stored in table scwsap_config).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScwsapConfig extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scwsap_config";
    public static final String ENTITY_NAME = "scwsap_config";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SERVICESCONTEXT = "servicesContext";
    public static final String PROPERTY_BUSINESSPARTNERCATEGORY = "businessPartnerCategory";
    public static final String PROPERTY_CUSTOMER = "customer";
    public static final String PROPERTY_VENDOR = "vendor";
    public static final String PROPERTY_EMPLOYEE = "employee";
    public static final String PROPERTY_ISSALESREPRESENTATIVE = "isSalesRepresentative";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_PARTNERNAME = "partnerName";
    public static final String PROPERTY_PARTNERTAXIDTYPE = "partnerTaxidtype";
    public static final String PROPERTY_PARTNERTAXPAYER = "partnerTaxpayer";

    public ScwsapConfig() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CUSTOMER, true);
        setDefaultValue(PROPERTY_VENDOR, false);
        setDefaultValue(PROPERTY_EMPLOYEE, false);
        setDefaultValue(PROPERTY_ISSALESREPRESENTATIVE, false);
        setDefaultValue(PROPERTY_PARTNERTAXIDTYPE, "D");
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

    public String getServicesContext() {
        return (String) get(PROPERTY_SERVICESCONTEXT);
    }

    public void setServicesContext(String servicesContext) {
        set(PROPERTY_SERVICESCONTEXT, servicesContext);
    }

    public Category getBusinessPartnerCategory() {
        return (Category) get(PROPERTY_BUSINESSPARTNERCATEGORY);
    }

    public void setBusinessPartnerCategory(Category businessPartnerCategory) {
        set(PROPERTY_BUSINESSPARTNERCATEGORY, businessPartnerCategory);
    }

    public Boolean isCustomer() {
        return (Boolean) get(PROPERTY_CUSTOMER);
    }

    public void setCustomer(Boolean customer) {
        set(PROPERTY_CUSTOMER, customer);
    }

    public Boolean isVendor() {
        return (Boolean) get(PROPERTY_VENDOR);
    }

    public void setVendor(Boolean vendor) {
        set(PROPERTY_VENDOR, vendor);
    }

    public Boolean isEmployee() {
        return (Boolean) get(PROPERTY_EMPLOYEE);
    }

    public void setEmployee(Boolean employee) {
        set(PROPERTY_EMPLOYEE, employee);
    }

    public Boolean isSalesRepresentative() {
        return (Boolean) get(PROPERTY_ISSALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(Boolean isSalesRepresentative) {
        set(PROPERTY_ISSALESREPRESENTATIVE, isSalesRepresentative);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public String getPartnerName() {
        return (String) get(PROPERTY_PARTNERNAME);
    }

    public void setPartnerName(String partnerName) {
        set(PROPERTY_PARTNERNAME, partnerName);
    }

    public String getPartnerTaxidtype() {
        return (String) get(PROPERTY_PARTNERTAXIDTYPE);
    }

    public void setPartnerTaxidtype(String partnerTaxidtype) {
        set(PROPERTY_PARTNERTAXIDTYPE, partnerTaxidtype);
    }

    public Taxpayer getPartnerTaxpayer() {
        return (Taxpayer) get(PROPERTY_PARTNERTAXPAYER);
    }

    public void setPartnerTaxpayer(Taxpayer partnerTaxpayer) {
        set(PROPERTY_PARTNERTAXPAYER, partnerTaxpayer);
    }

}
