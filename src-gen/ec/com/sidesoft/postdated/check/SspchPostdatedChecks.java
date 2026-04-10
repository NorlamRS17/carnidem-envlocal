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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
/**
 * Entity class for entity Sspch_Postdated_Checks (stored in table Sspch_Postdated_Checks).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SspchPostdatedChecks extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sspch_Postdated_Checks";
    public static final String ENTITY_NAME = "Sspch_Postdated_Checks";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_CHECKFROM = "checkFrom";
    public static final String PROPERTY_CHECKUP = "checkUp";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_ISDATEPAYMENTPLAN = "isdatepaymentplan";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_ACCOUNHOLDER = "accounHolder";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_LOADLINES = "loadLines";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ISMANUALREG = "ismanualreg";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_FINDOCTYPE = "fINDoctype";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_TOTALCHECKS = "totalChecks";
    public static final String PROPERTY_PAYMENTDAY = "paymentDay";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPCHPOSTDATEDCHECKSIDLIST = "fINPaymentScheduleDetailEMSspchPostdatedChecksIDList";
    public static final String PROPERTY_SSPCHINVOICELIST = "sspchInvoiceList";
    public static final String PROPERTY_SSPCHPAYMENTPLANLIST = "sspchPaymentPlanList";

    public SspchPostdatedChecks() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISDATEPAYMENTPLAN, true);
        setDefaultValue(PROPERTY_LOADLINES, false);
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_ISMANUALREG, false);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPCHPOSTDATEDCHECKSIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHPAYMENTPLANLIST, new ArrayList<Object>());
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

    public String getCheckFrom() {
        return (String) get(PROPERTY_CHECKFROM);
    }

    public void setCheckFrom(String checkFrom) {
        set(PROPERTY_CHECKFROM, checkFrom);
    }

    public String getCheckUp() {
        return (String) get(PROPERTY_CHECKUP);
    }

    public void setCheckUp(String checkUp) {
        set(PROPERTY_CHECKUP, checkUp);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Date getPaymentDate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentDate(Date paymentDate) {
        set(PROPERTY_PAYMENTDATE, paymentDate);
    }

    public Boolean isDatepaymentplan() {
        return (Boolean) get(PROPERTY_ISDATEPAYMENTPLAN);
    }

    public void setDatepaymentplan(Boolean isdatepaymentplan) {
        set(PROPERTY_ISDATEPAYMENTPLAN, isdatepaymentplan);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
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

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public Boolean isLoadLines() {
        return (Boolean) get(PROPERTY_LOADLINES);
    }

    public void setLoadLines(Boolean loadLines) {
        set(PROPERTY_LOADLINES, loadLines);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isManualreg() {
        return (Boolean) get(PROPERTY_ISMANUALREG);
    }

    public void setManualreg(Boolean ismanualreg) {
        set(PROPERTY_ISMANUALREG, ismanualreg);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public DocumentType getFINDoctype() {
        return (DocumentType) get(PROPERTY_FINDOCTYPE);
    }

    public void setFINDoctype(DocumentType fINDoctype) {
        set(PROPERTY_FINDOCTYPE, fINDoctype);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public BigDecimal getTotalChecks() {
        return (BigDecimal) get(PROPERTY_TOTALCHECKS);
    }

    public void setTotalChecks(BigDecimal totalChecks) {
        set(PROPERTY_TOTALCHECKS, totalChecks);
    }

    public Long getPaymentDay() {
        return (Long) get(PROPERTY_PAYMENTDAY);
    }

    public void setPaymentDay(Long paymentDay) {
        set(PROPERTY_PAYMENTDAY, paymentDay);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailEMSspchPostdatedChecksIDList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPCHPOSTDATEDCHECKSIDLIST);
    }

    public void setFINPaymentScheduleDetailEMSspchPostdatedChecksIDList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailEMSspchPostdatedChecksIDList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPCHPOSTDATEDCHECKSIDLIST, fINPaymentScheduleDetailEMSspchPostdatedChecksIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchInvoice> getSspchInvoiceList() {
      return (List<SspchInvoice>) get(PROPERTY_SSPCHINVOICELIST);
    }

    public void setSspchInvoiceList(List<SspchInvoice> sspchInvoiceList) {
        set(PROPERTY_SSPCHINVOICELIST, sspchInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchPaymentPlan> getSspchPaymentPlanList() {
      return (List<SspchPaymentPlan>) get(PROPERTY_SSPCHPAYMENTPLANLIST);
    }

    public void setSspchPaymentPlanList(List<SspchPaymentPlan> sspchPaymentPlanList) {
        set(PROPERTY_SSPCHPAYMENTPLANLIST, sspchPaymentPlanList);
    }

}
