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
package ec.com.sidesoft.debitnote.interest.due;

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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxRate;
/**
 * Entity class for entity ssdnid_calcinterestsetting (stored in table ssdnid_calcinterestsetting).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsdnidCalcInterestSetting extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssdnid_calcinterestsetting";
    public static final String ENTITY_NAME = "ssdnid_calcinterestsetting";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_RATE = "rate";
    public static final String PROPERTY_DAYSOFGRACE = "daysOfGrace";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_FACTOR = "factor";
    public static final String PROPERTY_DEFAULTSURCHARGEVALUE = "defaultSurchargeValue";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_MINIMUMVALUE = "minimumvalue";
    public static final String PROPERTY_FINPAYMENTMETHOD2 = "fINPaymentmethod2";
    public static final String PROPERTY_SSDNIDPRODUCTLIST = "ssdnidProductList";
    public static final String PROPERTY_SSDNIDTABLESICLIST = "ssdnidTablesicList";

    public SsdnidCalcInterestSetting() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SSDNIDPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDNIDTABLESICLIST, new ArrayList<Object>());
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

    public BigDecimal getRate() {
        return (BigDecimal) get(PROPERTY_RATE);
    }

    public void setRate(BigDecimal rate) {
        set(PROPERTY_RATE, rate);
    }

    public Long getDaysOfGrace() {
        return (Long) get(PROPERTY_DAYSOFGRACE);
    }

    public void setDaysOfGrace(Long daysOfGrace) {
        set(PROPERTY_DAYSOFGRACE, daysOfGrace);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public BigDecimal getFactor() {
        return (BigDecimal) get(PROPERTY_FACTOR);
    }

    public void setFactor(BigDecimal factor) {
        set(PROPERTY_FACTOR, factor);
    }

    public BigDecimal getDefaultSurchargeValue() {
        return (BigDecimal) get(PROPERTY_DEFAULTSURCHARGEVALUE);
    }

    public void setDefaultSurchargeValue(BigDecimal defaultSurchargeValue) {
        set(PROPERTY_DEFAULTSURCHARGEVALUE, defaultSurchargeValue);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public BigDecimal getMinimumvalue() {
        return (BigDecimal) get(PROPERTY_MINIMUMVALUE);
    }

    public void setMinimumvalue(BigDecimal minimumvalue) {
        set(PROPERTY_MINIMUMVALUE, minimumvalue);
    }

    public FIN_PaymentMethod getFINPaymentmethod2() {
        return (FIN_PaymentMethod) get(PROPERTY_FINPAYMENTMETHOD2);
    }

    public void setFINPaymentmethod2(FIN_PaymentMethod fINPaymentmethod2) {
        set(PROPERTY_FINPAYMENTMETHOD2, fINPaymentmethod2);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidProduct> getSsdnidProductList() {
      return (List<SsdnidProduct>) get(PROPERTY_SSDNIDPRODUCTLIST);
    }

    public void setSsdnidProductList(List<SsdnidProduct> ssdnidProductList) {
        set(PROPERTY_SSDNIDPRODUCTLIST, ssdnidProductList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidTableSIC> getSsdnidTablesicList() {
      return (List<SsdnidTableSIC>) get(PROPERTY_SSDNIDTABLESICLIST);
    }

    public void setSsdnidTablesicList(List<SsdnidTableSIC> ssdnidTablesicList) {
        set(PROPERTY_SSDNIDTABLESICLIST, ssdnidTablesicList);
    }

}
