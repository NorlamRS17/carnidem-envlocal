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
package ec.com.sidesoft.debit.collection;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
/**
 * Entity class for entity sdc_dc_propocollect (stored in table sdc_dc_propocollect).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SdcDcPropocollect extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sdc_dc_propocollect";
    public static final String ENTITY_NAME = "sdc_dc_propocollect";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DUEDATE = "dueDate";
    public static final String PROPERTY_SDCDEBITCOLLECT = "sDCDebitcollect";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_FINPAYMENTSCHEDULE = "finPaymentSchedule";
    public static final String PROPERTY_ISRECONCILED = "isreconciled";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_REFERENCENO = "referenceNo";
    public static final String PROPERTY_SHARENO = "shareno";
    public static final String PROPERTY_OUTSTANDINGAMOUNT = "outstandingAmount";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_AMOUNTPAID = "amountPaid";
    public static final String PROPERTY_PAYMENTCOMPLETE = "paymentComplete";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SDCDCDETAILLIST = "sdcDcDetailList";

    public SdcDcPropocollect() {
        setDefaultValue(PROPERTY_ISRECONCILED, false);
        setDefaultValue(PROPERTY_OUTSTANDINGAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNTPAID, new BigDecimal(0));
        setDefaultValue(PROPERTY_PAYMENTCOMPLETE, false);
        setDefaultValue(PROPERTY_SDCDCDETAILLIST, new ArrayList<Object>());
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

    public Date getDueDate() {
        return (Date) get(PROPERTY_DUEDATE);
    }

    public void setDueDate(Date dueDate) {
        set(PROPERTY_DUEDATE, dueDate);
    }

    public SdcDebitcollect getSDCDebitcollect() {
        return (SdcDebitcollect) get(PROPERTY_SDCDEBITCOLLECT);
    }

    public void setSDCDebitcollect(SdcDebitcollect sDCDebitcollect) {
        set(PROPERTY_SDCDEBITCOLLECT, sDCDebitcollect);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public FIN_PaymentSchedule getFinPaymentSchedule() {
        return (FIN_PaymentSchedule) get(PROPERTY_FINPAYMENTSCHEDULE);
    }

    public void setFinPaymentSchedule(FIN_PaymentSchedule finPaymentSchedule) {
        set(PROPERTY_FINPAYMENTSCHEDULE, finPaymentSchedule);
    }

    public Boolean isReconciled() {
        return (Boolean) get(PROPERTY_ISRECONCILED);
    }

    public void setReconciled(Boolean isreconciled) {
        set(PROPERTY_ISRECONCILED, isreconciled);
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

    public Long getShareno() {
        return (Long) get(PROPERTY_SHARENO);
    }

    public void setShareno(Long shareno) {
        set(PROPERTY_SHARENO, shareno);
    }

    public BigDecimal getOutstandingAmount() {
        return (BigDecimal) get(PROPERTY_OUTSTANDINGAMOUNT);
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        set(PROPERTY_OUTSTANDINGAMOUNT, outstandingAmount);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public BigDecimal getAmountPaid() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAID);
    }

    public void setAmountPaid(BigDecimal amountPaid) {
        set(PROPERTY_AMOUNTPAID, amountPaid);
    }

    public Boolean isPaymentComplete() {
        return (Boolean) get(PROPERTY_PAYMENTCOMPLETE);
    }

    public void setPaymentComplete(Boolean paymentComplete) {
        set(PROPERTY_PAYMENTCOMPLETE, paymentComplete);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    @SuppressWarnings("unchecked")
    public List<SdcDcDetail> getSdcDcDetailList() {
      return (List<SdcDcDetail>) get(PROPERTY_SDCDCDETAILLIST);
    }

    public void setSdcDcDetailList(List<SdcDcDetail> sdcDcDetailList) {
        set(PROPERTY_SDCDCDETAILLIST, sdcDcDetailList);
    }

}
