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

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity Ssccr_Finacc_Trans_V (stored in table Ssccr_Finacc_Trans_V).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsccrFinaccTransV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssccr_Finacc_Trans_V";
    public static final String ENTITY_NAME = "Ssccr_Finacc_Trans_V";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_FINANCIALACCOUNTTRANSACTION = "financialAccountTransaction";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_PROCESSORBANCK = "processorBanck";
    public static final String PROPERTY_TYPESOFCREDIT = "typesOfCredit";
    public static final String PROPERTY_SSCCREXPIRATIONDATE = "ssccrExpirationDate";
    public static final String PROPERTY_CARDSTYPES = "cardsTypes";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_TRANSACTIONDATE = "transactionDate";
    public static final String PROPERTY_DEPOSITAMOUNT = "depositAmount";
    public static final String PROPERTY_IMPUESTO = "impuesto";
    public static final String PROPERTY_SUMMEDLINEAMOUNT = "summedLineAmount";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_RECONCILED = "reconciled";

    public SsccrFinaccTransV() {
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public FIN_FinaccTransaction getFinancialAccountTransaction() {
        return (FIN_FinaccTransaction) get(PROPERTY_FINANCIALACCOUNTTRANSACTION);
    }

    public void setFinancialAccountTransaction(FIN_FinaccTransaction financialAccountTransaction) {
        set(PROPERTY_FINANCIALACCOUNTTRANSACTION, financialAccountTransaction);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public ssfiBanktransfer getSsfiBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_SSFIBANKTRANSFER);
    }

    public void setSsfiBanktransfer(ssfiBanktransfer ssfiBanktransfer) {
        set(PROPERTY_SSFIBANKTRANSFER, ssfiBanktransfer);
    }

    public SsccrProcessorBanck getProcessorBanck() {
        return (SsccrProcessorBanck) get(PROPERTY_PROCESSORBANCK);
    }

    public void setProcessorBanck(SsccrProcessorBanck processorBanck) {
        set(PROPERTY_PROCESSORBANCK, processorBanck);
    }

    public SsccrTypesOfCredit getTypesOfCredit() {
        return (SsccrTypesOfCredit) get(PROPERTY_TYPESOFCREDIT);
    }

    public void setTypesOfCredit(SsccrTypesOfCredit typesOfCredit) {
        set(PROPERTY_TYPESOFCREDIT, typesOfCredit);
    }

    public Date getSsccrExpirationDate() {
        return (Date) get(PROPERTY_SSCCREXPIRATIONDATE);
    }

    public void setSsccrExpirationDate(Date ssccrExpirationDate) {
        set(PROPERTY_SSCCREXPIRATIONDATE, ssccrExpirationDate);
    }

    public SsccrCardsTypes getCardsTypes() {
        return (SsccrCardsTypes) get(PROPERTY_CARDSTYPES);
    }

    public void setCardsTypes(SsccrCardsTypes cardsTypes) {
        set(PROPERTY_CARDSTYPES, cardsTypes);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public Date getTransactionDate() {
        return (Date) get(PROPERTY_TRANSACTIONDATE);
    }

    public void setTransactionDate(Date transactionDate) {
        set(PROPERTY_TRANSACTIONDATE, transactionDate);
    }

    public BigDecimal getDepositAmount() {
        return (BigDecimal) get(PROPERTY_DEPOSITAMOUNT);
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        set(PROPERTY_DEPOSITAMOUNT, depositAmount);
    }

    public Long getImpuesto() {
        return (Long) get(PROPERTY_IMPUESTO);
    }

    public void setImpuesto(Long impuesto) {
        set(PROPERTY_IMPUESTO, impuesto);
    }

    public Long getSummedLineAmount() {
        return (Long) get(PROPERTY_SUMMEDLINEAMOUNT);
    }

    public void setSummedLineAmount(Long summedLineAmount) {
        set(PROPERTY_SUMMEDLINEAMOUNT, summedLineAmount);
    }

    public Long getGrandTotalAmount() {
        return (Long) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(Long grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getReconciled() {
        return (String) get(PROPERTY_RECONCILED);
    }

    public void setReconciled(String reconciled) {
        set(PROPERTY_RECONCILED, reconciled);
    }

}
