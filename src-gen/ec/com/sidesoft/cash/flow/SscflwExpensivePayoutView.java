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
package ec.com.sidesoft.cash.flow;

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
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity sscflw_expensive_payout_v (stored in table sscflw_expensive_payout_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SscflwExpensivePayoutView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sscflw_expensive_payout_v";
    public static final String ENTITY_NAME = "sscflw_expensive_payout_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CUENTAFINANCIERA = "cuentaFinanciera";
    public static final String PROPERTY_FECHA = "fecha";
    public static final String PROPERTY_AMOUNTPAY = "amountPay";
    public static final String PROPERTY_FINPAYMENT = "fINPayment";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODNAME = "prodname";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_ELEMENTVALUE = "elementvalue";
    public static final String PROPERTY_CUENTA = "cuenta";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_FINFINANCIALACCOUNT = "fINFinancialAccount";

    public SscflwExpensivePayoutView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public String getCuentaFinanciera() {
        return (String) get(PROPERTY_CUENTAFINANCIERA);
    }

    public void setCuentaFinanciera(String cuentaFinanciera) {
        set(PROPERTY_CUENTAFINANCIERA, cuentaFinanciera);
    }

    public Date getFecha() {
        return (Date) get(PROPERTY_FECHA);
    }

    public void setFecha(Date fecha) {
        set(PROPERTY_FECHA, fecha);
    }

    public BigDecimal getAmountPay() {
        return (BigDecimal) get(PROPERTY_AMOUNTPAY);
    }

    public void setAmountPay(BigDecimal amountPay) {
        set(PROPERTY_AMOUNTPAY, amountPay);
    }

    public FIN_Payment getFINPayment() {
        return (FIN_Payment) get(PROPERTY_FINPAYMENT);
    }

    public void setFINPayment(FIN_Payment fINPayment) {
        set(PROPERTY_FINPAYMENT, fINPayment);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProdname() {
        return (String) get(PROPERTY_PRODNAME);
    }

    public void setProdname(String prodname) {
        set(PROPERTY_PRODNAME, prodname);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public ElementValue getElementvalue() {
        return (ElementValue) get(PROPERTY_ELEMENTVALUE);
    }

    public void setElementvalue(ElementValue elementvalue) {
        set(PROPERTY_ELEMENTVALUE, elementvalue);
    }

    public String getCuenta() {
        return (String) get(PROPERTY_CUENTA);
    }

    public void setCuenta(String cuenta) {
        set(PROPERTY_CUENTA, cuenta);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public FIN_FinancialAccount getFINFinancialAccount() {
        return (FIN_FinancialAccount) get(PROPERTY_FINFINANCIALACCOUNT);
    }

    public void setFINFinancialAccount(FIN_FinancialAccount fINFinancialAccount) {
        set(PROPERTY_FINFINANCIALACCOUNT, fINFinancialAccount);
    }

}
