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
package ec.com.sidesoft.closecash.sales.order;

import ec.com.sidesoft.custom.closecash.ScccCashClousure;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
/**
 * Entity class for entity Ssccso_Cash_Inc_Exp (stored in table Ssccso_Cash_Inc_Exp).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsccsoCashIncExp extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssccso_Cash_Inc_Exp";
    public static final String ENTITY_NAME = "Ssccso_Cash_Inc_Exp";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_TYPEOFOPERATION = "typeOfOperation";
    public static final String PROPERTY_FINANCIALACCOUNT = "financialAccount";
    public static final String PROPERTY_DATEACTUAL = "dateactual";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_GLITEM = "gLItem";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DEPOSITAMOUNT = "depositAmount";
    public static final String PROPERTY_REFUNDAMOUNT = "refundAmount";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_ISRECONCILED = "isreconciled";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_FINANCIALACCOUNTTRANSACTION = "financialAccountTransaction";
    public static final String PROPERTY_SCCCCASHCLOUSURE = "scccCashClousure";

    public SsccsoCashIncExp() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DEPOSITAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_REFUNDAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_STATUS, "DR");
        setDefaultValue(PROPERTY_ISRECONCILED, false);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getTypeOfOperation() {
        return (String) get(PROPERTY_TYPEOFOPERATION);
    }

    public void setTypeOfOperation(String typeOfOperation) {
        set(PROPERTY_TYPEOFOPERATION, typeOfOperation);
    }

    public FIN_FinancialAccount getFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINANCIALACCOUNT);
    }

    public void setFinancialAccount(FIN_FinancialAccount financialAccount) {
        set(PROPERTY_FINANCIALACCOUNT, financialAccount);
    }

    public Date getDateactual() {
        return (Date) get(PROPERTY_DATEACTUAL);
    }

    public void setDateactual(Date dateactual) {
        set(PROPERTY_DATEACTUAL, dateactual);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public GLItem getGLItem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGLItem(GLItem gLItem) {
        set(PROPERTY_GLITEM, gLItem);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getDepositAmount() {
        return (BigDecimal) get(PROPERTY_DEPOSITAMOUNT);
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        set(PROPERTY_DEPOSITAMOUNT, depositAmount);
    }

    public BigDecimal getRefundAmount() {
        return (BigDecimal) get(PROPERTY_REFUNDAMOUNT);
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        set(PROPERTY_REFUNDAMOUNT, refundAmount);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isReconciled() {
        return (Boolean) get(PROPERTY_ISRECONCILED);
    }

    public void setReconciled(Boolean isreconciled) {
        set(PROPERTY_ISRECONCILED, isreconciled);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public FIN_FinaccTransaction getFinancialAccountTransaction() {
        return (FIN_FinaccTransaction) get(PROPERTY_FINANCIALACCOUNTTRANSACTION);
    }

    public void setFinancialAccountTransaction(FIN_FinaccTransaction financialAccountTransaction) {
        set(PROPERTY_FINANCIALACCOUNTTRANSACTION, financialAccountTransaction);
    }

    public ScccCashClousure getScccCashClousure() {
        return (ScccCashClousure) get(PROPERTY_SCCCCASHCLOUSURE);
    }

    public void setScccCashClousure(ScccCashClousure scccCashClousure) {
        set(PROPERTY_SCCCCASHCLOUSURE, scccCashClousure);
    }

}
