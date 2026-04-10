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
package org.openbravo.model.financialmgmt.payment;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;
import com.sidesoft.localization.ecuador.finances.ssfiFin_payment_detail_v;

import ec.com.sidesoft.cash.flow.SscflwExpensivePayoutView;
import ec.com.sidesoft.contract.ssctpayment;
import ec.com.sidesoft.creditcard.reconciliation.SsccrFinaccTransV;
import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRecLine;
import ec.com.sidesoft.creditcard.reconciliation.Ssccr_CardRecDetailV;
import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTSLINE;
import ec.com.sidesoft.debitnote.interest.due.SsdnidPendingInterest;
import ec.com.sidesoft.localization.checkbook.SlcbCheckBook;
import ec.com.sidesoft.localization.checkbook.SlcbCheckBookLine;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.modify.accounting.SsmaactModifyAcct;
import ec.com.sidesoft.payment.in.transit.SspitraCollectionTransit;
import ec.com.sidesoft.settlement.project.cost.SstpcPaymentLiqView;
import ec.cusoft.facturaec.EeiPaymentDetailV;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRMPendingPaymentFromInvoice;
import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BankAccount;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.ConversionRateDoc;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceTaxCashVAT_V;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.tax.TaxPayment;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardInst;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardTrans;
/**
 * Entity class for entity FIN_Payment (stored in table FIN_Payment).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class FIN_Payment extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "FIN_Payment";
    public static final String ENTITY_NAME = "FIN_Payment";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_RECEIPT = "receipt";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_WRITEOFFAMOUNT = "writeoffAmount";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_GENERATEDCREDIT = "generatedCredit";
    public static final String PROPERTY_USEDCREDIT = "usedCredit";
    public static final String PROPERTY_CREATEDBYALGORITHM = "createdByAlgorithm";
    public static final String PROPERTY_FINANCIALTRANSACTIONCONVERTRATE = "financialTransactionConvertRate";
    public static final String PROPERTY_FINANCIALTRANSACTIONAMOUNT = "financialTransactionAmount";
    public static final String PROPERTY_APRMPROCESSPAYMENT = "aPRMProcessPayment";
    public static final String PROPERTY_REVERSEDPAYMENT = "reversedPayment";
    public static final String PROPERTY_APRMRECONCILEPAYMENT = "aPRMReconcilePayment";
    public static final String PROPERTY_APRMADDSCHEDULEDPAYMENTS = "aPRMAddScheduledpayments";
    public static final String PROPERTY_APRMEXECUTEPAYMENT = "aprmExecutepayment";
    public static final String PROPERTY_APRMREVERSEPAYMENT = "aPRMReversePayment";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_OBPOSPAYMENTDATA = "obposPaymentdata";
    public static final String PROPERTY_ATECDPDEPOSITO = "atecdpDeposito";
    public static final String PROPERTY_SSIORDETAILREPORT = "ssiorDetailreport";
    public static final String PROPERTY_SSPACCHECKACC = "sspacCheckacc";
    public static final String PROPERTY_SSPOSNOACCOUNT = "ssposNoaccount";
    public static final String PROPERTY_SSPACCBPARTNER = "sspacCBpartner";
    public static final String PROPERTY_SSPOSOWNERACC = "ssposOwneracc";
    public static final String PROPERTY_SSWHBPBANKACCOUNT = "sswhBpBankaccount";
    public static final String PROPERTY_SESCRNAME = "sescrName";
    public static final String PROPERTY_SSPOSPHONENO = "ssposPhoneno";
    public static final String PROPERTY_SSPOSBANK = "ssposBank";
    public static final String PROPERTY_SSWHBANKNAME = "sswhBankName";
    public static final String PROPERTY_SSPOSEXPIREDATE = "ssposExpiredate";
    public static final String PROPERTY_SSPIVANNULMENT = "sspivAnnulment";
    public static final String PROPERTY_SWHPIWITHHOLDINGSALE = "swhpiWithholdingsale";
    public static final String PROPERTY_SWHPIWITHRETENTION = "swhpiWithretention";
    public static final String PROPERTY_ECSCAPBANKTRANSFER = "ecscapBanktransfer";
    public static final String PROPERTY_SSPOSLOTE = "ssposLote";
    public static final String PROPERTY_ECSCAPDEPOSIT = "ecscapDeposit";
    public static final String PROPERTY_SSPOSOWNERACCOUNT = "sSPOSOwnerAccount";
    public static final String PROPERTY_ECSCAPACCOUNTHOLDER = "ecscapAccountHolder";
    public static final String PROPERTY_SSFIDESCRIPTION = "ssfiDescription";
    public static final String PROPERTY_ECSCAPNOCHECK = "ecscapNoCheck";
    public static final String PROPERTY_ECSCAPEFFECTIVEDATE = "ecscapEffectiveDate";
    public static final String PROPERTY_SESCRPAYMENTDATE = "sescrPaymentdate";
    public static final String PROPERTY_SSPCHCHECKNO = "sspchCheckno";
    public static final String PROPERTY_SLCBCHECKBOOKLINE = "slcbCheckbookline";
    public static final String PROPERTY_SSPCHACCOUNTHOLDER = "sspchAccountHolder";
    public static final String PROPERTY_SLCBCHECKBOOK = "slcbCheckbook";
    public static final String PROPERTY_SLCBOLDDESCRIPTION = "slcbOldDescription";
    public static final String PROPERTY_SSDRDATEDEPOSIT = "ssdrDatedeposit";
    public static final String PROPERTY_SRCPTARJETA = "srcpTarjeta";
    public static final String PROPERTY_SRCPTYPECREDIT = "srcpTypecredit";
    public static final String PROPERTY_SLCBISCHECKBOOK = "slcbIscheckbook";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_APRMPENDINGPAYMENTINVOICELIST = "aPRMPendingPaymentInvoiceList";
    public static final String PROPERTY_INVOICETAXCASHVATVLIST = "invoiceTaxCashVATVList";
    public static final String PROPERTY_CURRENCYCONVERSIONRATEDOCLIST = "currencyConversionRateDocList";
    public static final String PROPERTY_FINBANKSTATEMENTLINEEMSSDRFINPAYMENTIDLIST = "fINBankStatementLineEMSsdrFinPaymentIDList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINFINACCTRANSACTIONEMSSCCRFINPAYMENTIDLIST = "fINFinaccTransactionEMSsccrFinPaymentIDList";
    public static final String PROPERTY_FINPAYMENTREVERSEDPAYMENTLIST = "fINPaymentReversedPaymentList";
    public static final String PROPERTY_FINPAYMENTCREDITLIST = "fINPaymentCreditList";
    public static final String PROPERTY_FINPAYMENTCREDITCREDITPAYMENTUSEDLIST = "fINPaymentCreditCreditPaymentUsedList";
    public static final String PROPERTY_FINPAYMENTDETAILLIST = "fINPaymentDetailList";
    public static final String PROPERTY_FINPAYMENTDETAILVLIST = "fINPaymentDetailVList";
    public static final String PROPERTY_FINPAYMENTPROPDETAILVLIST = "fINPaymentPropDetailVList";
    public static final String PROPERTY_FINRECONCILIATIONLINETEMPLIST = "fINReconciliationLineTempList";
    public static final String PROPERTY_FINRECONCILIATIONLINEVLIST = "fINReconciliationLineVList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTPAYMENTEXECUTIONHISTORYVLIST = "financialMgmtPaymentExecutionHistoryVList";
    public static final String PROPERTY_FINANCIALMGMTPAYMENTRUNPAYMENTLIST = "financialMgmtPaymentRunPaymentList";
    public static final String PROPERTY_FINANCIALMGMTTAXPAYMENTLIST = "financialMgmtTaxPaymentList";
    public static final String PROPERTY_GCNVGIFTCARDINSTLIST = "gCNVGiftCardInstList";
    public static final String PROPERTY_GCNVGIFTCARDTRANSLIST = "gCNVGiftCardTransList";
    public static final String PROPERTY_SSPPPAYMENTSLINELIST = "sSPPPAYMENTSLINEList";
    public static final String PROPERTY_SSCCRFINACCTRANSVLIST = "ssccrFinaccTransVList";
    public static final String PROPERTY_SSCCRPOSCARDRECLINELIST = "ssccrPosCardRecLineList";
    public static final String PROPERTY_SSMAACTMODIFYACCTLIST = "ssmaactModifyAcctList";
    public static final String PROPERTY_EEIPAYMENTDETAILVLIST = "eeiPaymentDetailVList";
    public static final String PROPERTY_SLCBCHECKBOOKLINELIST = "slcbCheckbooklineList";
    public static final String PROPERTY_SSCCRCARDRECDETAILVLIST = "ssccrCardRecDetailVList";
    public static final String PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST = "sscflwExpensivePayoutVList";
    public static final String PROPERTY_SSCTPAYMENTLIST = "ssctPaymentList";
    public static final String PROPERTY_SSDNIDPENDINGINTERESTLIST = "ssdnidPendinginterestList";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILVLIST = "ssfiFinPaymentDetailVList";
    public static final String PROPERTY_SSPITRACOLLECTIONTRANSITLIST = "sspitraCollectiontransitList";
    public static final String PROPERTY_SSTPCPAYMENTLIQVLIST = "sstpcPaymentLiqVList";

    public FIN_Payment() {
        setDefaultValue(PROPERTY_CREATIONDATE, new Date());
        setDefaultValue(PROPERTY_UPDATED, new Date());
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_WRITEOFFAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_STATUS, "RPAP");
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_GENERATEDCREDIT, new BigDecimal(0));
        setDefaultValue(PROPERTY_USEDCREDIT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CREATEDBYALGORITHM, false);
        setDefaultValue(PROPERTY_FINANCIALTRANSACTIONCONVERTRATE, new BigDecimal(1.0));
        setDefaultValue(PROPERTY_APRMPROCESSPAYMENT, "P");
        setDefaultValue(PROPERTY_APRMRECONCILEPAYMENT, false);
        setDefaultValue(PROPERTY_APRMADDSCHEDULEDPAYMENTS, false);
        setDefaultValue(PROPERTY_APRMEXECUTEPAYMENT, false);
        setDefaultValue(PROPERTY_APRMREVERSEPAYMENT, false);
        setDefaultValue(PROPERTY_SSIORDETAILREPORT, false);
        setDefaultValue(PROPERTY_SSPIVANNULMENT, false);
        setDefaultValue(PROPERTY_SWHPIWITHRETENTION, false);
        setDefaultValue(PROPERTY_SLCBISCHECKBOOK, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMPENDINGPAYMENTINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXCASHVATVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CURRENCYCONVERSIONRATEDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLINEEMSSDRFINPAYMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONEMSSCCRFINPAYMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTREVERSEDPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTCREDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTCREDITCREDITPAYMENTUSEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLINETEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPAYMENTEXECUTIONHISTORYVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTPAYMENTRUNPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDINSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDTRANSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRFINACCTRANSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRPOSCARDRECLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTMODIFYACCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLCBCHECKBOOKLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRCARDRECDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDNIDPENDINGINTERESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPITRACOLLECTIONTRANSITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPAYMENTLIQVLIST, new ArrayList<Object>());
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

    public Boolean isReceipt() {
        return (Boolean) get(PROPERTY_RECEIPT);
    }

    public void setReceipt(Boolean receipt) {
        set(PROPERTY_RECEIPT, receipt);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getWriteoffAmount() {
        return (BigDecimal) get(PROPERTY_WRITEOFFAMOUNT);
    }

    public void setWriteoffAmount(BigDecimal writeoffAmount) {
        set(PROPERTY_WRITEOFFAMOUNT, writeoffAmount);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getReferenceNo() {
        return (String) get(PROPERTY_REFERENCENO);
    }

    public void setReferenceNo(String referenceNo) {
        set(PROPERTY_REFERENCENO, referenceNo);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public FIN_FinancialAccount getAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(FIN_FinancialAccount account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public BigDecimal getGeneratedCredit() {
        return (BigDecimal) get(PROPERTY_GENERATEDCREDIT);
    }

    public void setGeneratedCredit(BigDecimal generatedCredit) {
        set(PROPERTY_GENERATEDCREDIT, generatedCredit);
    }

    public BigDecimal getUsedCredit() {
        return (BigDecimal) get(PROPERTY_USEDCREDIT);
    }

    public void setUsedCredit(BigDecimal usedCredit) {
        set(PROPERTY_USEDCREDIT, usedCredit);
    }

    public Boolean isCreatedByAlgorithm() {
        return (Boolean) get(PROPERTY_CREATEDBYALGORITHM);
    }

    public void setCreatedByAlgorithm(Boolean createdByAlgorithm) {
        set(PROPERTY_CREATEDBYALGORITHM, createdByAlgorithm);
    }

    public BigDecimal getFinancialTransactionConvertRate() {
        return (BigDecimal) get(PROPERTY_FINANCIALTRANSACTIONCONVERTRATE);
    }

    public void setFinancialTransactionConvertRate(BigDecimal financialTransactionConvertRate) {
        set(PROPERTY_FINANCIALTRANSACTIONCONVERTRATE, financialTransactionConvertRate);
    }

    public BigDecimal getFinancialTransactionAmount() {
        return (BigDecimal) get(PROPERTY_FINANCIALTRANSACTIONAMOUNT);
    }

    public void setFinancialTransactionAmount(BigDecimal financialTransactionAmount) {
        set(PROPERTY_FINANCIALTRANSACTIONAMOUNT, financialTransactionAmount);
    }

    public String getAPRMProcessPayment() {
        return (String) get(PROPERTY_APRMPROCESSPAYMENT);
    }

    public void setAPRMProcessPayment(String aPRMProcessPayment) {
        set(PROPERTY_APRMPROCESSPAYMENT, aPRMProcessPayment);
    }

    public FIN_Payment getReversedPayment() {
        return (FIN_Payment) get(PROPERTY_REVERSEDPAYMENT);
    }

    public void setReversedPayment(FIN_Payment reversedPayment) {
        set(PROPERTY_REVERSEDPAYMENT, reversedPayment);
    }

    public Boolean isAPRMReconcilePayment() {
        return (Boolean) get(PROPERTY_APRMRECONCILEPAYMENT);
    }

    public void setAPRMReconcilePayment(Boolean aPRMReconcilePayment) {
        set(PROPERTY_APRMRECONCILEPAYMENT, aPRMReconcilePayment);
    }

    public Boolean isAPRMAddScheduledpayments() {
        return (Boolean) get(PROPERTY_APRMADDSCHEDULEDPAYMENTS);
    }

    public void setAPRMAddScheduledpayments(Boolean aPRMAddScheduledpayments) {
        set(PROPERTY_APRMADDSCHEDULEDPAYMENTS, aPRMAddScheduledpayments);
    }

    public Boolean isAprmExecutepayment() {
        return (Boolean) get(PROPERTY_APRMEXECUTEPAYMENT);
    }

    public void setAprmExecutepayment(Boolean aprmExecutepayment) {
        set(PROPERTY_APRMEXECUTEPAYMENT, aprmExecutepayment);
    }

    public Boolean isAPRMReversePayment() {
        return (Boolean) get(PROPERTY_APRMREVERSEPAYMENT);
    }

    public void setAPRMReversePayment(Boolean aPRMReversePayment) {
        set(PROPERTY_APRMREVERSEPAYMENT, aPRMReversePayment);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public String getObposPaymentdata() {
        return (String) get(PROPERTY_OBPOSPAYMENTDATA);
    }

    public void setObposPaymentdata(String obposPaymentdata) {
        set(PROPERTY_OBPOSPAYMENTDATA, obposPaymentdata);
    }

    public String getAtecdpDeposito() {
        return (String) get(PROPERTY_ATECDPDEPOSITO);
    }

    public void setAtecdpDeposito(String atecdpDeposito) {
        set(PROPERTY_ATECDPDEPOSITO, atecdpDeposito);
    }

    public Boolean isSsiorDetailreport() {
        return (Boolean) get(PROPERTY_SSIORDETAILREPORT);
    }

    public void setSsiorDetailreport(Boolean ssiorDetailreport) {
        set(PROPERTY_SSIORDETAILREPORT, ssiorDetailreport);
    }

    public String getSspacCheckacc() {
        return (String) get(PROPERTY_SSPACCHECKACC);
    }

    public void setSspacCheckacc(String sspacCheckacc) {
        set(PROPERTY_SSPACCHECKACC, sspacCheckacc);
    }

    public String getSsposNoaccount() {
        return (String) get(PROPERTY_SSPOSNOACCOUNT);
    }

    public void setSsposNoaccount(String ssposNoaccount) {
        set(PROPERTY_SSPOSNOACCOUNT, ssposNoaccount);
    }

    public BusinessPartner getSspacCBpartner() {
        return (BusinessPartner) get(PROPERTY_SSPACCBPARTNER);
    }

    public void setSspacCBpartner(BusinessPartner sspacCBpartner) {
        set(PROPERTY_SSPACCBPARTNER, sspacCBpartner);
    }

    public String getSsposOwneracc() {
        return (String) get(PROPERTY_SSPOSOWNERACC);
    }

    public void setSsposOwneracc(String ssposOwneracc) {
        set(PROPERTY_SSPOSOWNERACC, ssposOwneracc);
    }

    public BankAccount getSswhBpBankaccount() {
        return (BankAccount) get(PROPERTY_SSWHBPBANKACCOUNT);
    }

    public void setSswhBpBankaccount(BankAccount sswhBpBankaccount) {
        set(PROPERTY_SSWHBPBANKACCOUNT, sswhBpBankaccount);
    }

    public String getSescrName() {
        return (String) get(PROPERTY_SESCRNAME);
    }

    public void setSescrName(String sescrName) {
        set(PROPERTY_SESCRNAME, sescrName);
    }

    public String getSsposPhoneno() {
        return (String) get(PROPERTY_SSPOSPHONENO);
    }

    public void setSsposPhoneno(String ssposPhoneno) {
        set(PROPERTY_SSPOSPHONENO, ssposPhoneno);
    }

    public String getSsposBank() {
        return (String) get(PROPERTY_SSPOSBANK);
    }

    public void setSsposBank(String ssposBank) {
        set(PROPERTY_SSPOSBANK, ssposBank);
    }

    public String getSswhBankName() {
        return (String) get(PROPERTY_SSWHBANKNAME);
    }

    public void setSswhBankName(String sswhBankName) {
        set(PROPERTY_SSWHBANKNAME, sswhBankName);
    }

    public Date getSsposExpiredate() {
        return (Date) get(PROPERTY_SSPOSEXPIREDATE);
    }

    public void setSsposExpiredate(Date ssposExpiredate) {
        set(PROPERTY_SSPOSEXPIREDATE, ssposExpiredate);
    }

    public Boolean isSspivAnnulment() {
        return (Boolean) get(PROPERTY_SSPIVANNULMENT);
    }

    public void setSspivAnnulment(Boolean sspivAnnulment) {
        set(PROPERTY_SSPIVANNULMENT, sspivAnnulment);
    }

    public SSWSWithholdingSale getSwhpiWithholdingsale() {
        return (SSWSWithholdingSale) get(PROPERTY_SWHPIWITHHOLDINGSALE);
    }

    public void setSwhpiWithholdingsale(SSWSWithholdingSale swhpiWithholdingsale) {
        set(PROPERTY_SWHPIWITHHOLDINGSALE, swhpiWithholdingsale);
    }

    public Boolean isSwhpiWithretention() {
        return (Boolean) get(PROPERTY_SWHPIWITHRETENTION);
    }

    public void setSwhpiWithretention(Boolean swhpiWithretention) {
        set(PROPERTY_SWHPIWITHRETENTION, swhpiWithretention);
    }

    public ssfiBanktransfer getEcscapBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_ECSCAPBANKTRANSFER);
    }

    public void setEcscapBanktransfer(ssfiBanktransfer ecscapBanktransfer) {
        set(PROPERTY_ECSCAPBANKTRANSFER, ecscapBanktransfer);
    }

    public String getSsposLote() {
        return (String) get(PROPERTY_SSPOSLOTE);
    }

    public void setSsposLote(String ssposLote) {
        set(PROPERTY_SSPOSLOTE, ssposLote);
    }

    public String getEcscapDeposit() {
        return (String) get(PROPERTY_ECSCAPDEPOSIT);
    }

    public void setEcscapDeposit(String ecscapDeposit) {
        set(PROPERTY_ECSCAPDEPOSIT, ecscapDeposit);
    }

    public String getSSPOSOwnerAccount() {
        return (String) get(PROPERTY_SSPOSOWNERACCOUNT);
    }

    public void setSSPOSOwnerAccount(String sSPOSOwnerAccount) {
        set(PROPERTY_SSPOSOWNERACCOUNT, sSPOSOwnerAccount);
    }

    public String getEcscapAccountHolder() {
        return (String) get(PROPERTY_ECSCAPACCOUNTHOLDER);
    }

    public void setEcscapAccountHolder(String ecscapAccountHolder) {
        set(PROPERTY_ECSCAPACCOUNTHOLDER, ecscapAccountHolder);
    }

    public String getSsfiDescription() {
        return (String) get(PROPERTY_SSFIDESCRIPTION);
    }

    public void setSsfiDescription(String ssfiDescription) {
        set(PROPERTY_SSFIDESCRIPTION, ssfiDescription);
    }

    public String getEcscapNoCheck() {
        return (String) get(PROPERTY_ECSCAPNOCHECK);
    }

    public void setEcscapNoCheck(String ecscapNoCheck) {
        set(PROPERTY_ECSCAPNOCHECK, ecscapNoCheck);
    }

    public Date getEcscapEffectiveDate() {
        return (Date) get(PROPERTY_ECSCAPEFFECTIVEDATE);
    }

    public void setEcscapEffectiveDate(Date ecscapEffectiveDate) {
        set(PROPERTY_ECSCAPEFFECTIVEDATE, ecscapEffectiveDate);
    }

    public Date getSescrPaymentdate() {
        return (Date) get(PROPERTY_SESCRPAYMENTDATE);
    }

    public void setSescrPaymentdate(Date sescrPaymentdate) {
        set(PROPERTY_SESCRPAYMENTDATE, sescrPaymentdate);
    }

    public String getSspchCheckno() {
        return (String) get(PROPERTY_SSPCHCHECKNO);
    }

    public void setSspchCheckno(String sspchCheckno) {
        set(PROPERTY_SSPCHCHECKNO, sspchCheckno);
    }

    public SlcbCheckBookLine getSlcbCheckbookline() {
        return (SlcbCheckBookLine) get(PROPERTY_SLCBCHECKBOOKLINE);
    }

    public void setSlcbCheckbookline(SlcbCheckBookLine slcbCheckbookline) {
        set(PROPERTY_SLCBCHECKBOOKLINE, slcbCheckbookline);
    }

    public String getSspchAccountHolder() {
        return (String) get(PROPERTY_SSPCHACCOUNTHOLDER);
    }

    public void setSspchAccountHolder(String sspchAccountHolder) {
        set(PROPERTY_SSPCHACCOUNTHOLDER, sspchAccountHolder);
    }

    public SlcbCheckBook getSlcbCheckbook() {
        return (SlcbCheckBook) get(PROPERTY_SLCBCHECKBOOK);
    }

    public void setSlcbCheckbook(SlcbCheckBook slcbCheckbook) {
        set(PROPERTY_SLCBCHECKBOOK, slcbCheckbook);
    }

    public String getSlcbOldDescription() {
        return (String) get(PROPERTY_SLCBOLDDESCRIPTION);
    }

    public void setSlcbOldDescription(String slcbOldDescription) {
        set(PROPERTY_SLCBOLDDESCRIPTION, slcbOldDescription);
    }

    public Date getSsdrDatedeposit() {
        return (Date) get(PROPERTY_SSDRDATEDEPOSIT);
    }

    public void setSsdrDatedeposit(Date ssdrDatedeposit) {
        set(PROPERTY_SSDRDATEDEPOSIT, ssdrDatedeposit);
    }

    public String getSrcpTarjeta() {
        return (String) get(PROPERTY_SRCPTARJETA);
    }

    public void setSrcpTarjeta(String srcpTarjeta) {
        set(PROPERTY_SRCPTARJETA, srcpTarjeta);
    }

    public String getSrcpTypecredit() {
        return (String) get(PROPERTY_SRCPTYPECREDIT);
    }

    public void setSrcpTypecredit(String srcpTypecredit) {
        set(PROPERTY_SRCPTYPECREDIT, srcpTypecredit);
    }

    public Boolean isSlcbIscheckbook() {
        return (Boolean) get(PROPERTY_SLCBISCHECKBOOK);
    }

    public void setSlcbIscheckbook(Boolean slcbIscheckbook) {
        set(PROPERTY_SLCBISCHECKBOOK, slcbIscheckbook);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_FinaccTransactionV> getAPRMFinaccTransactionVList() {
      return (List<APRM_FinaccTransactionV>) get(PROPERTY_APRMFINACCTRANSACTIONVLIST);
    }

    public void setAPRMFinaccTransactionVList(List<APRM_FinaccTransactionV> aPRMFinaccTransactionVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONVLIST, aPRMFinaccTransactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRMPendingPaymentFromInvoice> getAPRMPendingPaymentInvoiceList() {
      return (List<APRMPendingPaymentFromInvoice>) get(PROPERTY_APRMPENDINGPAYMENTINVOICELIST);
    }

    public void setAPRMPendingPaymentInvoiceList(List<APRMPendingPaymentFromInvoice> aPRMPendingPaymentInvoiceList) {
        set(PROPERTY_APRMPENDINGPAYMENTINVOICELIST, aPRMPendingPaymentInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT_V> getInvoiceTaxCashVATVList() {
      return (List<InvoiceTaxCashVAT_V>) get(PROPERTY_INVOICETAXCASHVATVLIST);
    }

    public void setInvoiceTaxCashVATVList(List<InvoiceTaxCashVAT_V> invoiceTaxCashVATVList) {
        set(PROPERTY_INVOICETAXCASHVATVLIST, invoiceTaxCashVATVList);
    }

    @SuppressWarnings("unchecked")
    public List<ConversionRateDoc> getCurrencyConversionRateDocList() {
      return (List<ConversionRateDoc>) get(PROPERTY_CURRENCYCONVERSIONRATEDOCLIST);
    }

    public void setCurrencyConversionRateDocList(List<ConversionRateDoc> currencyConversionRateDocList) {
        set(PROPERTY_CURRENCYCONVERSIONRATEDOCLIST, currencyConversionRateDocList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatementLine> getFINBankStatementLineEMSsdrFinPaymentIDList() {
      return (List<FIN_BankStatementLine>) get(PROPERTY_FINBANKSTATEMENTLINEEMSSDRFINPAYMENTIDLIST);
    }

    public void setFINBankStatementLineEMSsdrFinPaymentIDList(List<FIN_BankStatementLine> fINBankStatementLineEMSsdrFinPaymentIDList) {
        set(PROPERTY_FINBANKSTATEMENTLINEEMSSDRFINPAYMENTIDLIST, fINBankStatementLineEMSsdrFinPaymentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONLIST);
    }

    public void setFINFinaccTransactionList(List<FIN_FinaccTransaction> fINFinaccTransactionList) {
        set(PROPERTY_FINFINACCTRANSACTIONLIST, fINFinaccTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionEMSsccrFinPaymentIDList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONEMSSCCRFINPAYMENTIDLIST);
    }

    public void setFINFinaccTransactionEMSsccrFinPaymentIDList(List<FIN_FinaccTransaction> fINFinaccTransactionEMSsccrFinPaymentIDList) {
        set(PROPERTY_FINFINACCTRANSACTIONEMSSCCRFINPAYMENTIDLIST, fINFinaccTransactionEMSsccrFinPaymentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentReversedPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTREVERSEDPAYMENTLIST);
    }

    public void setFINPaymentReversedPaymentList(List<FIN_Payment> fINPaymentReversedPaymentList) {
        set(PROPERTY_FINPAYMENTREVERSEDPAYMENTLIST, fINPaymentReversedPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment_Credit> getFINPaymentCreditList() {
      return (List<FIN_Payment_Credit>) get(PROPERTY_FINPAYMENTCREDITLIST);
    }

    public void setFINPaymentCreditList(List<FIN_Payment_Credit> fINPaymentCreditList) {
        set(PROPERTY_FINPAYMENTCREDITLIST, fINPaymentCreditList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment_Credit> getFINPaymentCreditCreditPaymentUsedList() {
      return (List<FIN_Payment_Credit>) get(PROPERTY_FINPAYMENTCREDITCREDITPAYMENTUSEDLIST);
    }

    public void setFINPaymentCreditCreditPaymentUsedList(List<FIN_Payment_Credit> fINPaymentCreditCreditPaymentUsedList) {
        set(PROPERTY_FINPAYMENTCREDITCREDITPAYMENTUSEDLIST, fINPaymentCreditCreditPaymentUsedList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetail> getFINPaymentDetailList() {
      return (List<FIN_PaymentDetail>) get(PROPERTY_FINPAYMENTDETAILLIST);
    }

    public void setFINPaymentDetailList(List<FIN_PaymentDetail> fINPaymentDetailList) {
        set(PROPERTY_FINPAYMENTDETAILLIST, fINPaymentDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetailV> getFINPaymentDetailVList() {
      return (List<FIN_PaymentDetailV>) get(PROPERTY_FINPAYMENTDETAILVLIST);
    }

    public void setFINPaymentDetailVList(List<FIN_PaymentDetailV> fINPaymentDetailVList) {
        set(PROPERTY_FINPAYMENTDETAILVLIST, fINPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentPropDetailV> getFINPaymentPropDetailVList() {
      return (List<FIN_PaymentPropDetailV>) get(PROPERTY_FINPAYMENTPROPDETAILVLIST);
    }

    public void setFINPaymentPropDetailVList(List<FIN_PaymentPropDetailV> fINPaymentPropDetailVList) {
        set(PROPERTY_FINPAYMENTPROPDETAILVLIST, fINPaymentPropDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_ReconciliationLineTemp> getFINReconciliationLineTempList() {
      return (List<FIN_ReconciliationLineTemp>) get(PROPERTY_FINRECONCILIATIONLINETEMPLIST);
    }

    public void setFINReconciliationLineTempList(List<FIN_ReconciliationLineTemp> fINReconciliationLineTempList) {
        set(PROPERTY_FINRECONCILIATIONLINETEMPLIST, fINReconciliationLineTempList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_ReconciliationLine_v> getFINReconciliationLineVList() {
      return (List<FIN_ReconciliationLine_v>) get(PROPERTY_FINRECONCILIATIONLINEVLIST);
    }

    public void setFINReconciliationLineVList(List<FIN_ReconciliationLine_v> fINReconciliationLineVList) {
        set(PROPERTY_FINRECONCILIATIONLINEVLIST, fINReconciliationLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PaymentExecutionHistoryV> getFinancialMgmtPaymentExecutionHistoryVList() {
      return (List<PaymentExecutionHistoryV>) get(PROPERTY_FINANCIALMGMTPAYMENTEXECUTIONHISTORYVLIST);
    }

    public void setFinancialMgmtPaymentExecutionHistoryVList(List<PaymentExecutionHistoryV> financialMgmtPaymentExecutionHistoryVList) {
        set(PROPERTY_FINANCIALMGMTPAYMENTEXECUTIONHISTORYVLIST, financialMgmtPaymentExecutionHistoryVList);
    }

    @SuppressWarnings("unchecked")
    public List<PaymentRunPayment> getFinancialMgmtPaymentRunPaymentList() {
      return (List<PaymentRunPayment>) get(PROPERTY_FINANCIALMGMTPAYMENTRUNPAYMENTLIST);
    }

    public void setFinancialMgmtPaymentRunPaymentList(List<PaymentRunPayment> financialMgmtPaymentRunPaymentList) {
        set(PROPERTY_FINANCIALMGMTPAYMENTRUNPAYMENTLIST, financialMgmtPaymentRunPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxPayment> getFinancialMgmtTaxPaymentList() {
      return (List<TaxPayment>) get(PROPERTY_FINANCIALMGMTTAXPAYMENTLIST);
    }

    public void setFinancialMgmtTaxPaymentList(List<TaxPayment> financialMgmtTaxPaymentList) {
        set(PROPERTY_FINANCIALMGMTTAXPAYMENTLIST, financialMgmtTaxPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardInst> getGCNVGiftCardInstList() {
      return (List<GiftCardInst>) get(PROPERTY_GCNVGIFTCARDINSTLIST);
    }

    public void setGCNVGiftCardInstList(List<GiftCardInst> gCNVGiftCardInstList) {
        set(PROPERTY_GCNVGIFTCARDINSTLIST, gCNVGiftCardInstList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardTrans> getGCNVGiftCardTransList() {
      return (List<GiftCardTrans>) get(PROPERTY_GCNVGIFTCARDTRANSLIST);
    }

    public void setGCNVGiftCardTransList(List<GiftCardTrans> gCNVGiftCardTransList) {
        set(PROPERTY_GCNVGIFTCARDTRANSLIST, gCNVGiftCardTransList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTSLINE> getSSPPPAYMENTSLINEList() {
      return (List<SSPPPAYMENTSLINE>) get(PROPERTY_SSPPPAYMENTSLINELIST);
    }

    public void setSSPPPAYMENTSLINEList(List<SSPPPAYMENTSLINE> sSPPPAYMENTSLINEList) {
        set(PROPERTY_SSPPPAYMENTSLINELIST, sSPPPAYMENTSLINEList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrFinaccTransV> getSsccrFinaccTransVList() {
      return (List<SsccrFinaccTransV>) get(PROPERTY_SSCCRFINACCTRANSVLIST);
    }

    public void setSsccrFinaccTransVList(List<SsccrFinaccTransV> ssccrFinaccTransVList) {
        set(PROPERTY_SSCCRFINACCTRANSVLIST, ssccrFinaccTransVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrPosCardRecLine> getSsccrPosCardRecLineList() {
      return (List<SsccrPosCardRecLine>) get(PROPERTY_SSCCRPOSCARDRECLINELIST);
    }

    public void setSsccrPosCardRecLineList(List<SsccrPosCardRecLine> ssccrPosCardRecLineList) {
        set(PROPERTY_SSCCRPOSCARDRECLINELIST, ssccrPosCardRecLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmaactModifyAcct> getSsmaactModifyAcctList() {
      return (List<SsmaactModifyAcct>) get(PROPERTY_SSMAACTMODIFYACCTLIST);
    }

    public void setSsmaactModifyAcctList(List<SsmaactModifyAcct> ssmaactModifyAcctList) {
        set(PROPERTY_SSMAACTMODIFYACCTLIST, ssmaactModifyAcctList);
    }

    @SuppressWarnings("unchecked")
    public List<EeiPaymentDetailV> getEeiPaymentDetailVList() {
      return (List<EeiPaymentDetailV>) get(PROPERTY_EEIPAYMENTDETAILVLIST);
    }

    public void setEeiPaymentDetailVList(List<EeiPaymentDetailV> eeiPaymentDetailVList) {
        set(PROPERTY_EEIPAYMENTDETAILVLIST, eeiPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SlcbCheckBookLine> getSlcbCheckbooklineList() {
      return (List<SlcbCheckBookLine>) get(PROPERTY_SLCBCHECKBOOKLINELIST);
    }

    public void setSlcbCheckbooklineList(List<SlcbCheckBookLine> slcbCheckbooklineList) {
        set(PROPERTY_SLCBCHECKBOOKLINELIST, slcbCheckbooklineList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssccr_CardRecDetailV> getSsccrCardRecDetailVList() {
      return (List<Ssccr_CardRecDetailV>) get(PROPERTY_SSCCRCARDRECDETAILVLIST);
    }

    public void setSsccrCardRecDetailVList(List<Ssccr_CardRecDetailV> ssccrCardRecDetailVList) {
        set(PROPERTY_SSCCRCARDRECDETAILVLIST, ssccrCardRecDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SscflwExpensivePayoutView> getSscflwExpensivePayoutVList() {
      return (List<SscflwExpensivePayoutView>) get(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST);
    }

    public void setSscflwExpensivePayoutVList(List<SscflwExpensivePayoutView> sscflwExpensivePayoutVList) {
        set(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, sscflwExpensivePayoutVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctpayment> getSsctPaymentList() {
      return (List<ssctpayment>) get(PROPERTY_SSCTPAYMENTLIST);
    }

    public void setSsctPaymentList(List<ssctpayment> ssctPaymentList) {
        set(PROPERTY_SSCTPAYMENTLIST, ssctPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidPendingInterest> getSsdnidPendinginterestList() {
      return (List<SsdnidPendingInterest>) get(PROPERTY_SSDNIDPENDINGINTERESTLIST);
    }

    public void setSsdnidPendinginterestList(List<SsdnidPendingInterest> ssdnidPendinginterestList) {
        set(PROPERTY_SSDNIDPENDINGINTERESTLIST, ssdnidPendinginterestList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfiFin_payment_detail_v> getSsfiFinPaymentDetailVList() {
      return (List<ssfiFin_payment_detail_v>) get(PROPERTY_SSFIFINPAYMENTDETAILVLIST);
    }

    public void setSsfiFinPaymentDetailVList(List<ssfiFin_payment_detail_v> ssfiFinPaymentDetailVList) {
        set(PROPERTY_SSFIFINPAYMENTDETAILVLIST, ssfiFinPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SspitraCollectionTransit> getSspitraCollectiontransitList() {
      return (List<SspitraCollectionTransit>) get(PROPERTY_SSPITRACOLLECTIONTRANSITLIST);
    }

    public void setSspitraCollectiontransitList(List<SspitraCollectionTransit> sspitraCollectiontransitList) {
        set(PROPERTY_SSPITRACOLLECTIONTRANSITLIST, sspitraCollectiontransitList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcPaymentLiqView> getSstpcPaymentLiqVList() {
      return (List<SstpcPaymentLiqView>) get(PROPERTY_SSTPCPAYMENTLIQVLIST);
    }

    public void setSstpcPaymentLiqVList(List<SstpcPaymentLiqView> sstpcPaymentLiqVList) {
        set(PROPERTY_SSTPCPAYMENTLIQVLIST, sstpcPaymentLiqVList);
    }

}
