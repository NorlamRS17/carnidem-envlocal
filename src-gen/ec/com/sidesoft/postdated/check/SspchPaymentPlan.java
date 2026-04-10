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
package ec.com.sidesoft.postdated.check;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
/**
 * Entity class for entity Sspch_Payment_Plan (stored in table Sspch_Payment_Plan).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SspchPaymentPlan extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sspch_Payment_Plan";
    public static final String ENTITY_NAME = "Sspch_Payment_Plan";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSPCHINVOICE = "sspchInvoice";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_SHARENO = "shareno";
    public static final String PROPERTY_FINPAYMENTSCHEDULE = "finPaymentSchedule";
    public static final String PROPERTY_CHECKNO = "checkno";
    public static final String PROPERTY_ISADVANCE = "isadvance";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_QUOTAVALUE = "quotaValue";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_ADVANCEVALUE = "advanceValue";
    public static final String PROPERTY_AMOUNTPAYMENT = "amountPayment";
    public static final String PROPERTY_SSPCHPOSTDATEDCHECKS = "sspchPostdatedChecks";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_ACCOUNHOLDER = "accounHolder";
    public static final String PROPERTY_SEQUENCE = "sequence";
    public static final String PROPERTY_GENERALPAYMENTDATE = "generalPaymentDate";

    public SspchPaymentPlan() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISADVANCE, false);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_QUOTAVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ADVANCEVALUE, new BigDecimal(0));
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

    public SspchInvoice getSspchInvoice() {
        return (SspchInvoice) get(PROPERTY_SSPCHINVOICE);
    }

    public void setSspchInvoice(SspchInvoice sspchInvoice) {
        set(PROPERTY_SSPCHINVOICE, sspchInvoice);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getShareno() {
        return (String) get(PROPERTY_SHARENO);
    }

    public void setShareno(String shareno) {
        set(PROPERTY_SHARENO, shareno);
    }

    public FIN_PaymentSchedule getFinPaymentSchedule() {
        return (FIN_PaymentSchedule) get(PROPERTY_FINPAYMENTSCHEDULE);
    }

    public void setFinPaymentSchedule(FIN_PaymentSchedule finPaymentSchedule) {
        set(PROPERTY_FINPAYMENTSCHEDULE, finPaymentSchedule);
    }

    public String getCheckno() {
        return (String) get(PROPERTY_CHECKNO);
    }

    public void setCheckno(String checkno) {
        set(PROPERTY_CHECKNO, checkno);
    }

    public Boolean isAdvance() {
        return (Boolean) get(PROPERTY_ISADVANCE);
    }

    public void setAdvance(Boolean isadvance) {
        set(PROPERTY_ISADVANCE, isadvance);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public BigDecimal getQuotaValue() {
        return (BigDecimal) get(PROPERTY_QUOTAVALUE);
    }

    public void setQuotaValue(BigDecimal quotaValue) {
        set(PROPERTY_QUOTAVALUE, quotaValue);
    }

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public BigDecimal getAdvanceValue() {
        return (BigDecimal) get(PROPERTY_ADVANCEVALUE);
    }

    public void setAdvanceValue(BigDecimal advanceValue) {
        set(PROPERTY_ADVANCEVALUE, advanceValue);
    }

    public BigDecimal getAmountPayment() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAYMENT);
    }

    public void setAmountPayment(BigDecimal amountPayment) {
        set(PROPERTY_AMOUNTPAYMENT, amountPayment);
    }

    public SspchPostdatedChecks getSspchPostdatedChecks() {
        return (SspchPostdatedChecks) get(PROPERTY_SSPCHPOSTDATEDCHECKS);
    }

    public void setSspchPostdatedChecks(SspchPostdatedChecks sspchPostdatedChecks) {
        set(PROPERTY_SSPCHPOSTDATEDCHECKS, sspchPostdatedChecks);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public ssfiBanktransfer getSsfiBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_SSFIBANKTRANSFER);
    }

    public void setSsfiBanktransfer(ssfiBanktransfer ssfiBanktransfer) {
        set(PROPERTY_SSFIBANKTRANSFER, ssfiBanktransfer);
    }

    public String getAccount() {
        return (String) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(String account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public String getAccounHolder() {
        return (String) get(PROPERTY_ACCOUNHOLDER);
    }

    public void setAccounHolder(String accounHolder) {
        set(PROPERTY_ACCOUNHOLDER, accounHolder);
    }

    public BigDecimal getSequence() {
        return (BigDecimal) get(PROPERTY_SEQUENCE);
    }

    public void setSequence(BigDecimal sequence) {
        set(PROPERTY_SEQUENCE, sequence);
    }

    public Date getGeneralPaymentDate() {
        return (Date) get(PROPERTY_GENERALPAYMENTDATE);
    }

    public void setGeneralPaymentDate(Date generalPaymentDate) {
        set(PROPERTY_GENERALPAYMENTDATE, generalPaymentDate);
    }

}
