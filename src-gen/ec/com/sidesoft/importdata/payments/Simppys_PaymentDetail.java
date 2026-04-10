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
package ec.com.sidesoft.importdata.payments;

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
import org.openbravo.model.common.businesspartner.BankAccount;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity simppys_payment_detail (stored in table simppys_payment_detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Simppys_PaymentDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "simppys_payment_detail";
    public static final String ENTITY_NAME = "simppys_payment_detail";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SIMPPYSPAYMENTDATAUPLOAD = "simppysPaymentDataUpload";
    public static final String PROPERTY_PAYMENTDOCTYPE = "paymentDocType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_SELLER = "seller";
    public static final String PROPERTY_PARTNERBANKACCOUNT = "partnerBankAccount";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_DUEDATE = "dueDate";
    public static final String PROPERTY_ONLYPAYMENT = "onlyPayment";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_CHECKNO = "checkno";
    public static final String PROPERTY_DEPOSITNO = "depositno";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_RESULT = "result";
    public static final String PROPERTY_ERROR = "error";
    public static final String PROPERTY_GLITEM = "gLItem";

    public Simppys_PaymentDetail() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ONLYPAYMENT, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
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

    public Simppys_PaymentDataUpload getSimppysPaymentDataUpload() {
        return (Simppys_PaymentDataUpload) get(PROPERTY_SIMPPYSPAYMENTDATAUPLOAD);
    }

    public void setSimppysPaymentDataUpload(Simppys_PaymentDataUpload simppysPaymentDataUpload) {
        set(PROPERTY_SIMPPYSPAYMENTDATAUPLOAD, simppysPaymentDataUpload);
    }

    public DocumentType getPaymentDocType() {
        return (DocumentType) get(PROPERTY_PAYMENTDOCTYPE);
    }

    public void setPaymentDocType(DocumentType paymentDocType) {
        set(PROPERTY_PAYMENTDOCTYPE, paymentDocType);
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

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public BusinessPartner getSeller() {
        return (BusinessPartner) get(PROPERTY_SELLER);
    }

    public void setSeller(BusinessPartner seller) {
        set(PROPERTY_SELLER, seller);
    }

    public BankAccount getPartnerBankAccount() {
        return (BankAccount) get(PROPERTY_PARTNERBANKACCOUNT);
    }

    public void setPartnerBankAccount(BankAccount partnerBankAccount) {
        set(PROPERTY_PARTNERBANKACCOUNT, partnerBankAccount);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Date getDueDate() {
        return (Date) get(PROPERTY_DUEDATE);
    }

    public void setDueDate(Date dueDate) {
        set(PROPERTY_DUEDATE, dueDate);
    }

    public Boolean isOnlyPayment() {
        return (Boolean) get(PROPERTY_ONLYPAYMENT);
    }

    public void setOnlyPayment(Boolean onlyPayment) {
        set(PROPERTY_ONLYPAYMENT, onlyPayment);
    }

    public ssfiBanktransfer getSsfiBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_SSFIBANKTRANSFER);
    }

    public void setSsfiBanktransfer(ssfiBanktransfer ssfiBanktransfer) {
        set(PROPERTY_SSFIBANKTRANSFER, ssfiBanktransfer);
    }

    public String getCheckno() {
        return (String) get(PROPERTY_CHECKNO);
    }

    public void setCheckno(String checkno) {
        set(PROPERTY_CHECKNO, checkno);
    }

    public String getDepositno() {
        return (String) get(PROPERTY_DEPOSITNO);
    }

    public void setDepositno(String depositno) {
        set(PROPERTY_DEPOSITNO, depositno);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
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

    public String getResult() {
        return (String) get(PROPERTY_RESULT);
    }

    public void setResult(String result) {
        set(PROPERTY_RESULT, result);
    }

    public String getError() {
        return (String) get(PROPERTY_ERROR);
    }

    public void setError(String error) {
        set(PROPERTY_ERROR, error);
    }

    public GLItem getGLItem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGLItem(GLItem gLItem) {
        set(PROPERTY_GLITEM, gLItem);
    }

}
