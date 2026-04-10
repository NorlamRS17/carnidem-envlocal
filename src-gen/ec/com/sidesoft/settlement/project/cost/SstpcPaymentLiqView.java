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
package ec.com.sidesoft.settlement.project.cost;

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
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
/**
 * Entity class for entity sstpc_payment_liq_v (stored in table sstpc_payment_liq_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SstpcPaymentLiqView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sstpc_payment_liq_v";
    public static final String ENTITY_NAME = "sstpc_payment_liq_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAIL = "fINPaymentScheduledetail";
    public static final String PROPERTY_FINPAYMENT = "fINPayment";
    public static final String PROPERTY_PAGO = "pago";
    public static final String PROPERTY_TIPODOCUMENTO = "tipoDocumento";
    public static final String PROPERTY_FACTURA = "factura";
    public static final String PROPERTY_CONCEPTOCONTABLE = "conceptoContable";
    public static final String PROPERTY_ANTICIPO = "anticipo";
    public static final String PROPERTY_MONTO = "monto";
    public static final String PROPERTY_ISLIQUIDATED = "isliquidated";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_PAYMENTDATE = "paymentdate";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_FINFINANCIALACCOUNT = "fINFinancialAccount";

    public SstpcPaymentLiqView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISLIQUIDATED, false);
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

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
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

    public FIN_PaymentScheduleDetail getFINPaymentScheduledetail() {
        return (FIN_PaymentScheduleDetail) get(PROPERTY_FINPAYMENTSCHEDULEDETAIL);
    }

    public void setFINPaymentScheduledetail(FIN_PaymentScheduleDetail fINPaymentScheduledetail) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAIL, fINPaymentScheduledetail);
    }

    public FIN_Payment getFINPayment() {
        return (FIN_Payment) get(PROPERTY_FINPAYMENT);
    }

    public void setFINPayment(FIN_Payment fINPayment) {
        set(PROPERTY_FINPAYMENT, fINPayment);
    }

    public String getPago() {
        return (String) get(PROPERTY_PAGO);
    }

    public void setPago(String pago) {
        set(PROPERTY_PAGO, pago);
    }

    public String getTipoDocumento() {
        return (String) get(PROPERTY_TIPODOCUMENTO);
    }

    public void setTipoDocumento(String tipoDocumento) {
        set(PROPERTY_TIPODOCUMENTO, tipoDocumento);
    }

    public String getFactura() {
        return (String) get(PROPERTY_FACTURA);
    }

    public void setFactura(String factura) {
        set(PROPERTY_FACTURA, factura);
    }

    public GLItem getConceptoContable() {
        return (GLItem) get(PROPERTY_CONCEPTOCONTABLE);
    }

    public void setConceptoContable(GLItem conceptoContable) {
        set(PROPERTY_CONCEPTOCONTABLE, conceptoContable);
    }

    public BigDecimal getAnticipo() {
        return (BigDecimal) get(PROPERTY_ANTICIPO);
    }

    public void setAnticipo(BigDecimal anticipo) {
        set(PROPERTY_ANTICIPO, anticipo);
    }

    public BigDecimal getMonto() {
        return (BigDecimal) get(PROPERTY_MONTO);
    }

    public void setMonto(BigDecimal monto) {
        set(PROPERTY_MONTO, monto);
    }

    public Boolean isLiquidated() {
        return (Boolean) get(PROPERTY_ISLIQUIDATED);
    }

    public void setLiquidated(Boolean isliquidated) {
        set(PROPERTY_ISLIQUIDATED, isliquidated);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public Date getPaymentdate() {
        return (Date) get(PROPERTY_PAYMENTDATE);
    }

    public void setPaymentdate(Date paymentdate) {
        set(PROPERTY_PAYMENTDATE, paymentdate);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public FIN_FinancialAccount getFINFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINFINANCIALACCOUNT);
    }

    public void setFINFinancialAccount(FIN_FinancialAccount fINFinancialAccount) {
        set(PROPERTY_FINFINANCIALACCOUNT, fINFinancialAccount);
    }

}
