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
 * Entity class for entity ssccr_card_rec_detail_v (stored in table ssccr_card_rec_detail_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Ssccr_CardRecDetailV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssccr_card_rec_detail_v";
    public static final String ENTITY_NAME = "ssccr_card_rec_detail_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_POSCARDRECONCILIATION = "pOSCardReconciliation";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_RECAP = "recap";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_DEPOSITAMOUNT = "depositAmount";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_RECONCILED = "reconciled";
    public static final String PROPERTY_TYPESOFCREDIT = "typesOfCredit";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_CARDSTYPES = "cardsTypes";
    public static final String PROPERTY_PROCESSORBANCK = "processorBanck";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_DATESTATEMENT = "dateStatement";
    public static final String PROPERTY_CONFIRMATIONNO = "confirmationNo";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_FINANCIALACCOUNTTRANSACTION = "financialAccountTransaction";

    public Ssccr_CardRecDetailV() {
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

    public SsccrPosCardRec getPOSCardReconciliation() {
        return (SsccrPosCardRec) get(PROPERTY_POSCARDRECONCILIATION);
    }

    public void setPOSCardReconciliation(SsccrPosCardRec pOSCardReconciliation) {
        set(PROPERTY_POSCARDRECONCILIATION, pOSCardReconciliation);
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

    public String getRecap() {
        return (String) get(PROPERTY_RECAP);
    }

    public void setRecap(String recap) {
        set(PROPERTY_RECAP, recap);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getDepositAmount() {
        return (BigDecimal) get(PROPERTY_DEPOSITAMOUNT);
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        set(PROPERTY_DEPOSITAMOUNT, depositAmount);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public String getReconciled() {
        return (String) get(PROPERTY_RECONCILED);
    }

    public void setReconciled(String reconciled) {
        set(PROPERTY_RECONCILED, reconciled);
    }

    public SsccrTypesOfCredit getTypesOfCredit() {
        return (SsccrTypesOfCredit) get(PROPERTY_TYPESOFCREDIT);
    }

    public void setTypesOfCredit(SsccrTypesOfCredit typesOfCredit) {
        set(PROPERTY_TYPESOFCREDIT, typesOfCredit);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public SsccrCardsTypes getCardsTypes() {
        return (SsccrCardsTypes) get(PROPERTY_CARDSTYPES);
    }

    public void setCardsTypes(SsccrCardsTypes cardsTypes) {
        set(PROPERTY_CARDSTYPES, cardsTypes);
    }

    public SsccrProcessorBanck getProcessorBanck() {
        return (SsccrProcessorBanck) get(PROPERTY_PROCESSORBANCK);
    }

    public void setProcessorBanck(SsccrProcessorBanck processorBanck) {
        set(PROPERTY_PROCESSORBANCK, processorBanck);
    }

    public ssfiBanktransfer getSsfiBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_SSFIBANKTRANSFER);
    }

    public void setSsfiBanktransfer(ssfiBanktransfer ssfiBanktransfer) {
        set(PROPERTY_SSFIBANKTRANSFER, ssfiBanktransfer);
    }

    public Date getDateStatement() {
        return (Date) get(PROPERTY_DATESTATEMENT);
    }

    public void setDateStatement(Date dateStatement) {
        set(PROPERTY_DATESTATEMENT, dateStatement);
    }

    public String getConfirmationNo() {
        return (String) get(PROPERTY_CONFIRMATIONNO);
    }

    public void setConfirmationNo(String confirmationNo) {
        set(PROPERTY_CONFIRMATIONNO, confirmationNo);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public FIN_FinaccTransaction getFinancialAccountTransaction() {
        return (FIN_FinaccTransaction) get(PROPERTY_FINANCIALACCOUNTTRANSACTION);
    }

    public void setFinancialAccountTransaction(FIN_FinaccTransaction financialAccountTransaction) {
        set(PROPERTY_FINANCIALACCOUNTTRANSACTION, financialAccountTransaction);
    }

}
