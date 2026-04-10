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
package ec.com.sidesoft.payment.in.transit;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.app.order.SsapporLog;

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
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity sspitra_collectiontransit (stored in table sspitra_collectiontransit).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SspitraCollectionTransit extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspitra_collectiontransit";
    public static final String ENTITY_NAME = "sspitra_collectiontransit";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PAYMENTDOCUMENTNO = "paymentDocumentno";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_PAYMENTDATE = "paymentDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_CHECKACCOUNT = "checkAccount";
    public static final String PROPERTY_CHARGEDBY = "chargedBy";
    public static final String PROPERTY_SSFIBANKTRANSFER = "ssfiBanktransfer";
    public static final String PROPERTY_DEPOSIT = "deposit";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_ONLYPAYMENT = "onlypayment";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_SSPITRACOLLECTIONUNLINK = "sspitraCollectionUnlink";
    public static final String PROPERTY_SSAPPORLOGLIST = "ssapporLogList";
    public static final String PROPERTY_SSPITRACTDETAILLIST = "sspitraCtDetailList";

    public SspitraCollectionTransit() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_STATUS, "D");
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_ONLYPAYMENT, true);
        setDefaultValue(PROPERTY_SSPITRACOLLECTIONUNLINK, false);
        setDefaultValue(PROPERTY_SSAPPORLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPITRACTDETAILLIST, new ArrayList<Object>());
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

    public String getPaymentDocumentno() {
        return (String) get(PROPERTY_PAYMENTDOCUMENTNO);
    }

    public void setPaymentDocumentno(String paymentDocumentno) {
        set(PROPERTY_PAYMENTDOCUMENTNO, paymentDocumentno);
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

    public String getCheckAccount() {
        return (String) get(PROPERTY_CHECKACCOUNT);
    }

    public void setCheckAccount(String checkAccount) {
        set(PROPERTY_CHECKACCOUNT, checkAccount);
    }

    public BusinessPartner getChargedBy() {
        return (BusinessPartner) get(PROPERTY_CHARGEDBY);
    }

    public void setChargedBy(BusinessPartner chargedBy) {
        set(PROPERTY_CHARGEDBY, chargedBy);
    }

    public ssfiBanktransfer getSsfiBanktransfer() {
        return (ssfiBanktransfer) get(PROPERTY_SSFIBANKTRANSFER);
    }

    public void setSsfiBanktransfer(ssfiBanktransfer ssfiBanktransfer) {
        set(PROPERTY_SSFIBANKTRANSFER, ssfiBanktransfer);
    }

    public String getDeposit() {
        return (String) get(PROPERTY_DEPOSIT);
    }

    public void setDeposit(String deposit) {
        set(PROPERTY_DEPOSIT, deposit);
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

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
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

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Boolean isOnlypayment() {
        return (Boolean) get(PROPERTY_ONLYPAYMENT);
    }

    public void setOnlypayment(Boolean onlypayment) {
        set(PROPERTY_ONLYPAYMENT, onlypayment);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public Boolean isSspitraCollectionUnlink() {
        return (Boolean) get(PROPERTY_SSPITRACOLLECTIONUNLINK);
    }

    public void setSspitraCollectionUnlink(Boolean sspitraCollectionUnlink) {
        set(PROPERTY_SSPITRACOLLECTIONUNLINK, sspitraCollectionUnlink);
    }

    @SuppressWarnings("unchecked")
    public List<SsapporLog> getSsapporLogList() {
      return (List<SsapporLog>) get(PROPERTY_SSAPPORLOGLIST);
    }

    public void setSsapporLogList(List<SsapporLog> ssapporLogList) {
        set(PROPERTY_SSAPPORLOGLIST, ssapporLogList);
    }

    @SuppressWarnings("unchecked")
    public List<SspitraCtDetail> getSspitraCtDetailList() {
      return (List<SspitraCtDetail>) get(PROPERTY_SSPITRACTDETAILLIST);
    }

    public void setSspitraCtDetailList(List<SspitraCtDetail> sspitraCtDetailList) {
        set(PROPERTY_SSPITRACTDETAILLIST, sspitraCtDetailList);
    }

}
