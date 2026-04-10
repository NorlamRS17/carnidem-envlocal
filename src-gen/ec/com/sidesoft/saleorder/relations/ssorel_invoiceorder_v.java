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
package ec.com.sidesoft.saleorder.relations;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentPriority;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.project.Project;
/**
 * Entity class for entity ssorel_invoiceorder_v (stored in table ssorel_invoiceorder_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssorel_invoiceorder_v extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssorel_invoiceorder_v";
    public static final String ENTITY_NAME = "ssorel_invoiceorder_v";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_TRANSACTIONDOCUMENT = "transactionDocument";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRINT = "print";
    public static final String PROPERTY_SALESREPRESENTATIVE = "salesRepresentative";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_PRINTDISCOUNT = "printDiscount";
    public static final String PROPERTY_ORDERDATE = "orderDate";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_FORMOFPAYMENT = "formOfPayment";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMOUNT = "chargeAmount";
    public static final String PROPERTY_SUMMEDLINEAMOUNT = "summedLineAmount";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICEINCLUDESTAX = "priceIncludesTax";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_CREATELINESFROM = "createLinesFrom";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_SELFSERVICE = "selfService";
    public static final String PROPERTY_TRXORGANIZATION = "trxOrganization";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_WITHHOLDINGAMOUNT = "withholdingamount";
    public static final String PROPERTY_TAXDATE = "taxDate";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_PAYMENTCOMPLETE = "paymentComplete";
    public static final String PROPERTY_TOTALPAID = "totalPaid";
    public static final String PROPERTY_OUTSTANDINGAMOUNT = "outstandingAmount";
    public static final String PROPERTY_DAYSTILLNEXTDUE = "daysTillNextDue";
    public static final String PROPERTY_DUEAMOUNT = "dueAmount";
    public static final String PROPERTY_LASTCALCULATEDONDATE = "lastCalculatedOnDate";
    public static final String PROPERTY_UPDATEPAYMENTMONITOR = "updatePaymentMonitor";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_PAYMENTPRIORITY = "paymentPriority";
    public static final String PROPERTY_FINALSETTLEMENTDATE = "finalSettlementDate";
    public static final String PROPERTY_DAYSSALESOUTSTANDING = "daysSalesOutstanding";
    public static final String PROPERTY_PERCENTAGEOVERDUE = "percentageOverdue";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_CALCULATEPROMOTIONS = "calculatePromotions";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_CASHVAT = "cashVAT";
    public static final String PROPERTY_PREPAYMENTAMOUNT = "prepaymentAmount";

    public ssorel_invoiceorder_v() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SALESTRANSACTION, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_PRINT, false);
        setDefaultValue(PROPERTY_PRINTDISCOUNT, false);
        setDefaultValue(PROPERTY_PRICEINCLUDESTAX, false);
        setDefaultValue(PROPERTY_CREATELINESFROM, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_SELFSERVICE, false);
        setDefaultValue(PROPERTY_PAYMENTCOMPLETE, false);
        setDefaultValue(PROPERTY_UPDATEPAYMENTMONITOR, false);
        setDefaultValue(PROPERTY_CASHVAT, false);
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
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

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public DocumentType getTransactionDocument() {
        return (DocumentType) get(PROPERTY_TRANSACTIONDOCUMENT);
    }

    public void setTransactionDocument(DocumentType transactionDocument) {
        set(PROPERTY_TRANSACTIONDOCUMENT, transactionDocument);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isPrint() {
        return (Boolean) get(PROPERTY_PRINT);
    }

    public void setPrint(Boolean print) {
        set(PROPERTY_PRINT, print);
    }

    public User getSalesRepresentative() {
        return (User) get(PROPERTY_SALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(User salesRepresentative) {
        set(PROPERTY_SALESREPRESENTATIVE, salesRepresentative);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
    }

    public AccountingCombination getAccountingDate() {
        return (AccountingCombination) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(AccountingCombination accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public Boolean isPrintDiscount() {
        return (Boolean) get(PROPERTY_PRINTDISCOUNT);
    }

    public void setPrintDiscount(Boolean printDiscount) {
        set(PROPERTY_PRINTDISCOUNT, printDiscount);
    }

    public Date getOrderDate() {
        return (Date) get(PROPERTY_ORDERDATE);
    }

    public void setOrderDate(Date orderDate) {
        set(PROPERTY_ORDERDATE, orderDate);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getFormOfPayment() {
        return (String) get(PROPERTY_FORMOFPAYMENT);
    }

    public void setFormOfPayment(String formOfPayment) {
        set(PROPERTY_FORMOFPAYMENT, formOfPayment);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmount() {
        return (BigDecimal) get(PROPERTY_CHARGEAMOUNT);
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        set(PROPERTY_CHARGEAMOUNT, chargeAmount);
    }

    public BigDecimal getSummedLineAmount() {
        return (BigDecimal) get(PROPERTY_SUMMEDLINEAMOUNT);
    }

    public void setSummedLineAmount(BigDecimal summedLineAmount) {
        set(PROPERTY_SUMMEDLINEAMOUNT, summedLineAmount);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isPriceIncludesTax() {
        return (Boolean) get(PROPERTY_PRICEINCLUDESTAX);
    }

    public void setPriceIncludesTax(Boolean priceIncludesTax) {
        set(PROPERTY_PRICEINCLUDESTAX, priceIncludesTax);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public Boolean isCreateLinesFrom() {
        return (Boolean) get(PROPERTY_CREATELINESFROM);
    }

    public void setCreateLinesFrom(Boolean createLinesFrom) {
        set(PROPERTY_CREATELINESFROM, createLinesFrom);
    }

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public Boolean isSelfService() {
        return (Boolean) get(PROPERTY_SELFSERVICE);
    }

    public void setSelfService(Boolean selfService) {
        set(PROPERTY_SELFSERVICE, selfService);
    }

    public Organization getTrxOrganization() {
        return (Organization) get(PROPERTY_TRXORGANIZATION);
    }

    public void setTrxOrganization(Organization trxOrganization) {
        set(PROPERTY_TRXORGANIZATION, trxOrganization);
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

    public BigDecimal getWithholdingamount() {
        return (BigDecimal) get(PROPERTY_WITHHOLDINGAMOUNT);
    }

    public void setWithholdingamount(BigDecimal withholdingamount) {
        set(PROPERTY_WITHHOLDINGAMOUNT, withholdingamount);
    }

    public Date getTaxDate() {
        return (Date) get(PROPERTY_TAXDATE);
    }

    public void setTaxDate(Date taxDate) {
        set(PROPERTY_TAXDATE, taxDate);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public Boolean isPaymentComplete() {
        return (Boolean) get(PROPERTY_PAYMENTCOMPLETE);
    }

    public void setPaymentComplete(Boolean paymentComplete) {
        set(PROPERTY_PAYMENTCOMPLETE, paymentComplete);
    }

    public BigDecimal getTotalPaid() {
        return (BigDecimal) get(PROPERTY_TOTALPAID);
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        set(PROPERTY_TOTALPAID, totalPaid);
    }

    public BigDecimal getOutstandingAmount() {
        return (BigDecimal) get(PROPERTY_OUTSTANDINGAMOUNT);
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        set(PROPERTY_OUTSTANDINGAMOUNT, outstandingAmount);
    }

    public Long getDaysTillNextDue() {
        return (Long) get(PROPERTY_DAYSTILLNEXTDUE);
    }

    public void setDaysTillNextDue(Long daysTillNextDue) {
        set(PROPERTY_DAYSTILLNEXTDUE, daysTillNextDue);
    }

    public BigDecimal getDueAmount() {
        return (BigDecimal) get(PROPERTY_DUEAMOUNT);
    }

    public void setDueAmount(BigDecimal dueAmount) {
        set(PROPERTY_DUEAMOUNT, dueAmount);
    }

    public Date getLastCalculatedOnDate() {
        return (Date) get(PROPERTY_LASTCALCULATEDONDATE);
    }

    public void setLastCalculatedOnDate(Date lastCalculatedOnDate) {
        set(PROPERTY_LASTCALCULATEDONDATE, lastCalculatedOnDate);
    }

    public Boolean isUpdatePaymentMonitor() {
        return (Boolean) get(PROPERTY_UPDATEPAYMENTMONITOR);
    }

    public void setUpdatePaymentMonitor(Boolean updatePaymentMonitor) {
        set(PROPERTY_UPDATEPAYMENTMONITOR, updatePaymentMonitor);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public PaymentPriority getPaymentPriority() {
        return (PaymentPriority) get(PROPERTY_PAYMENTPRIORITY);
    }

    public void setPaymentPriority(PaymentPriority paymentPriority) {
        set(PROPERTY_PAYMENTPRIORITY, paymentPriority);
    }

    public Date getFinalSettlementDate() {
        return (Date) get(PROPERTY_FINALSETTLEMENTDATE);
    }

    public void setFinalSettlementDate(Date finalSettlementDate) {
        set(PROPERTY_FINALSETTLEMENTDATE, finalSettlementDate);
    }

    public Long getDaysSalesOutstanding() {
        return (Long) get(PROPERTY_DAYSSALESOUTSTANDING);
    }

    public void setDaysSalesOutstanding(Long daysSalesOutstanding) {
        set(PROPERTY_DAYSSALESOUTSTANDING, daysSalesOutstanding);
    }

    public Long getPercentageOverdue() {
        return (Long) get(PROPERTY_PERCENTAGEOVERDUE);
    }

    public void setPercentageOverdue(Long percentageOverdue) {
        set(PROPERTY_PERCENTAGEOVERDUE, percentageOverdue);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public String getCalculatePromotions() {
        return (String) get(PROPERTY_CALCULATEPROMOTIONS);
    }

    public void setCalculatePromotions(String calculatePromotions) {
        set(PROPERTY_CALCULATEPROMOTIONS, calculatePromotions);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isCashVAT() {
        return (Boolean) get(PROPERTY_CASHVAT);
    }

    public void setCashVAT(Boolean cashVAT) {
        set(PROPERTY_CASHVAT, cashVAT);
    }

    public BigDecimal getPrepaymentAmount() {
        return (BigDecimal) get(PROPERTY_PREPAYMENTAMOUNT);
    }

    public void setPrepaymentAmount(BigDecimal prepaymentAmount) {
        set(PROPERTY_PREPAYMENTAMOUNT, prepaymentAmount);
    }

}
