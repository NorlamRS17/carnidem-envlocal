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
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
/**
 * Entity class for entity ssdnid_pendinginterest (stored in table ssdnid_pendinginterest).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsdnidPendingInterest extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssdnid_pendinginterest";
    public static final String ENTITY_NAME = "ssdnid_pendinginterest";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_FINPAYMENTSCHEDULE = "finPaymentSchedule";
    public static final String PROPERTY_DUEDATE = "dueDate";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_RECEIVEDAMOUNT = "receivedAmount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_LASTPAYMENTDATE = "lastPaymentDate";
    public static final String PROPERTY_SHARENO = "shareno";
    public static final String PROPERTY_INTERESTLATEPAYMENT = "interestlatepayment";
    public static final String PROPERTY_COLLECTIONEXPENSES = "collectionexpenses";
    public static final String PROPERTY_DEBITNOTE = "debitnote";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_TINTERESTLATEPAYMENT = "tInterestLatePayment";
    public static final String PROPERTY_TCOLLECTIONEXPENSES = "tCollectionExpenses";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_GENERATEDEBITNOTE = "generateDebitNote";

    public SsdnidPendingInterest() {
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public FIN_PaymentSchedule getFinPaymentSchedule() {
        return (FIN_PaymentSchedule) get(PROPERTY_FINPAYMENTSCHEDULE);
    }

    public void setFinPaymentSchedule(FIN_PaymentSchedule finPaymentSchedule) {
        set(PROPERTY_FINPAYMENTSCHEDULE, finPaymentSchedule);
    }

    public Date getDueDate() {
        return (Date) get(PROPERTY_DUEDATE);
    }

    public void setDueDate(Date dueDate) {
        set(PROPERTY_DUEDATE, dueDate);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getReceivedAmount() {
        return (BigDecimal) get(PROPERTY_RECEIVEDAMOUNT);
    }

    public void setReceivedAmount(BigDecimal receivedAmount) {
        set(PROPERTY_RECEIVEDAMOUNT, receivedAmount);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Date getLastPaymentDate() {
        return (Date) get(PROPERTY_LASTPAYMENTDATE);
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        set(PROPERTY_LASTPAYMENTDATE, lastPaymentDate);
    }

    public Long getShareno() {
        return (Long) get(PROPERTY_SHARENO);
    }

    public void setShareno(Long shareno) {
        set(PROPERTY_SHARENO, shareno);
    }

    public BigDecimal getInterestlatepayment() {
        return (BigDecimal) get(PROPERTY_INTERESTLATEPAYMENT);
    }

    public void setInterestlatepayment(BigDecimal interestlatepayment) {
        set(PROPERTY_INTERESTLATEPAYMENT, interestlatepayment);
    }

    public BigDecimal getCollectionexpenses() {
        return (BigDecimal) get(PROPERTY_COLLECTIONEXPENSES);
    }

    public void setCollectionexpenses(BigDecimal collectionexpenses) {
        set(PROPERTY_COLLECTIONEXPENSES, collectionexpenses);
    }

    public Invoice getDebitnote() {
        return (Invoice) get(PROPERTY_DEBITNOTE);
    }

    public void setDebitnote(Invoice debitnote) {
        set(PROPERTY_DEBITNOTE, debitnote);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public BigDecimal getTInterestLatePayment() {
        return (BigDecimal) get(PROPERTY_TINTERESTLATEPAYMENT);
    }

    public void setTInterestLatePayment(BigDecimal tInterestLatePayment) {
        set(PROPERTY_TINTERESTLATEPAYMENT, tInterestLatePayment);
    }

    public BigDecimal getTCollectionExpenses() {
        return (BigDecimal) get(PROPERTY_TCOLLECTIONEXPENSES);
    }

    public void setTCollectionExpenses(BigDecimal tCollectionExpenses) {
        set(PROPERTY_TCOLLECTIONEXPENSES, tCollectionExpenses);
    }

    public Boolean isGenerateDebitNote() {
        return (Boolean) get(COMPUTED_COLUMN_GENERATEDEBITNOTE);
    }

    public void setGenerateDebitNote(Boolean generateDebitNote) {
        set(COMPUTED_COLUMN_GENERATEDEBITNOTE, generateDebitNote);
    }

    public SsdnidPendingInterest_ComputedColumns get_computedColumns() {
        return (SsdnidPendingInterest_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(SsdnidPendingInterest_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_GENERATEDEBITNOTE.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().isGenerateDebitNote();
      }
    
      return super.get(propName);
    }
}
