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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
/**
 * Entity class for entity sspitra_ct_detail (stored in table sspitra_ct_detail).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SspitraCtDetail extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspitra_ct_detail";
    public static final String ENTITY_NAME = "sspitra_ct_detail";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSPITRACOLLECTIONTRANSIT = "sspitraCollectiontransit";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_TOTALPAID = "totalPaid";
    public static final String PROPERTY_FINPAYMENTSCHEDULE = "finPaymentSchedule";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPITRACTDETAILIDLIST = "fINPaymentScheduleDetailEMSspitraCtDetailIDList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_OUTSTANDINGAMOUNT = "outstandingAmount";

    public SspitraCtDetail() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPITRACTDETAILIDLIST, new ArrayList<Object>());
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

    public SspitraCollectionTransit getSspitraCollectiontransit() {
        return (SspitraCollectionTransit) get(PROPERTY_SSPITRACOLLECTIONTRANSIT);
    }

    public void setSspitraCollectiontransit(SspitraCollectionTransit sspitraCollectiontransit) {
        set(PROPERTY_SSPITRACOLLECTIONTRANSIT, sspitraCollectiontransit);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public BigDecimal getTotalPaid() {
        return (BigDecimal) get(PROPERTY_TOTALPAID);
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        set(PROPERTY_TOTALPAID, totalPaid);
    }

    public FIN_PaymentSchedule getFinPaymentSchedule() {
        return (FIN_PaymentSchedule) get(PROPERTY_FINPAYMENTSCHEDULE);
    }

    public void setFinPaymentSchedule(FIN_PaymentSchedule finPaymentSchedule) {
        set(PROPERTY_FINPAYMENTSCHEDULE, finPaymentSchedule);
    }

    public BigDecimal getOutstandingAmount() {
        return (BigDecimal) get(COMPUTED_COLUMN_OUTSTANDINGAMOUNT);
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        set(COMPUTED_COLUMN_OUTSTANDINGAMOUNT, outstandingAmount);
    }

    public SspitraCtDetail_ComputedColumns get_computedColumns() {
        return (SspitraCtDetail_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(SspitraCtDetail_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailEMSspitraCtDetailIDList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPITRACTDETAILIDLIST);
    }

    public void setFINPaymentScheduleDetailEMSspitraCtDetailIDList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailEMSspitraCtDetailIDList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILEMSSPITRACTDETAILIDLIST, fINPaymentScheduleDetailEMSspitraCtDetailIDList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_OUTSTANDINGAMOUNT.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getOutstandingAmount();
      }
    
      return super.get(propName);
    }
}
