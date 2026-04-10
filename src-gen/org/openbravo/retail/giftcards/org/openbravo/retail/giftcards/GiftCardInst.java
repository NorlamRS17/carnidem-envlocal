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
package org.openbravo.retail.giftcards.org.openbravo.retail.giftcards;

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
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
/**
 * Entity class for entity GCNV_GiftCardInst (stored in table gcnv_giftcard_inst).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GiftCardInst extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "gcnv_giftcard_inst";
    public static final String ENTITY_NAME = "GCNV_GiftCardInst";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_SALESORDERLINE = "salesOrderLine";
    public static final String PROPERTY_ORDERDATE = "orderDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_CURRENTAMOUNT = "currentamount";
    public static final String PROPERTY_ISCANCELLED = "iscancelled";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_PAYMENT = "payment";
    public static final String PROPERTY_GLITEM = "gLItem";
    public static final String PROPERTY_OBGCNEGCOWNER = "obgcneGCOwner";
    public static final String PROPERTY_OBGCNEEXPIRATIONDATE = "obgcneExpirationdate";
    public static final String PROPERTY_GIFTCARDCERTIFICATESTATUS = "giftCardCertificateStatus";
    public static final String PROPERTY_RETURNCORDER = "returnCOrder";
    public static final String PROPERTY_CANCELGIFTCARD = "cancelGiftCard";
    public static final String PROPERTY_SRGRCRECHARGE = "srgrcRecharge";
    public static final String PROPERTY_GCNVGIFTCARDSUMMARYLIST = "gCNVGiftCardSummaryList";
    public static final String PROPERTY_GCNVGIFTCARDTRANSLIST = "gCNVGiftCardTransList";

    public GiftCardInst() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ALERTSTATUS, "N");
        setDefaultValue(PROPERTY_ISCANCELLED, false);
        setDefaultValue(PROPERTY_TYPE, "BasedOnProductGiftCard");
        setDefaultValue(PROPERTY_CANCELGIFTCARD, false);
        setDefaultValue(PROPERTY_SRGRCRECHARGE, false);
        setDefaultValue(PROPERTY_GCNVGIFTCARDSUMMARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDTRANSLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public OrderLine getSalesOrderLine() {
        return (OrderLine) get(PROPERTY_SALESORDERLINE);
    }

    public void setSalesOrderLine(OrderLine salesOrderLine) {
        set(PROPERTY_SALESORDERLINE, salesOrderLine);
    }

    public Date getOrderDate() {
        return (Date) get(PROPERTY_ORDERDATE);
    }

    public void setOrderDate(Date orderDate) {
        set(PROPERTY_ORDERDATE, orderDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getCurrentamount() {
        return (BigDecimal) get(PROPERTY_CURRENTAMOUNT);
    }

    public void setCurrentamount(BigDecimal currentamount) {
        set(PROPERTY_CURRENTAMOUNT, currentamount);
    }

    public Boolean isCancelled() {
        return (Boolean) get(PROPERTY_ISCANCELLED);
    }

    public void setCancelled(Boolean iscancelled) {
        set(PROPERTY_ISCANCELLED, iscancelled);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public GiftcardReason getCategory() {
        return (GiftcardReason) get(PROPERTY_CATEGORY);
    }

    public void setCategory(GiftcardReason category) {
        set(PROPERTY_CATEGORY, category);
    }

    public FIN_Payment getPayment() {
        return (FIN_Payment) get(PROPERTY_PAYMENT);
    }

    public void setPayment(FIN_Payment payment) {
        set(PROPERTY_PAYMENT, payment);
    }

    public GLItem getGLItem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGLItem(GLItem gLItem) {
        set(PROPERTY_GLITEM, gLItem);
    }

    public BusinessPartner getObgcneGCOwner() {
        return (BusinessPartner) get(PROPERTY_OBGCNEGCOWNER);
    }

    public void setObgcneGCOwner(BusinessPartner obgcneGCOwner) {
        set(PROPERTY_OBGCNEGCOWNER, obgcneGCOwner);
    }

    public Date getObgcneExpirationdate() {
        return (Date) get(PROPERTY_OBGCNEEXPIRATIONDATE);
    }

    public void setObgcneExpirationdate(Date obgcneExpirationdate) {
        set(PROPERTY_OBGCNEEXPIRATIONDATE, obgcneExpirationdate);
    }

    public String getGiftCardCertificateStatus() {
        return (String) get(PROPERTY_GIFTCARDCERTIFICATESTATUS);
    }

    public void setGiftCardCertificateStatus(String giftCardCertificateStatus) {
        set(PROPERTY_GIFTCARDCERTIFICATESTATUS, giftCardCertificateStatus);
    }

    public Order getReturnCOrder() {
        return (Order) get(PROPERTY_RETURNCORDER);
    }

    public void setReturnCOrder(Order returnCOrder) {
        set(PROPERTY_RETURNCORDER, returnCOrder);
    }

    public Boolean isCancelGiftCard() {
        return (Boolean) get(PROPERTY_CANCELGIFTCARD);
    }

    public void setCancelGiftCard(Boolean cancelGiftCard) {
        set(PROPERTY_CANCELGIFTCARD, cancelGiftCard);
    }

    public Boolean isSrgrcRecharge() {
        return (Boolean) get(PROPERTY_SRGRCRECHARGE);
    }

    public void setSrgrcRecharge(Boolean srgrcRecharge) {
        set(PROPERTY_SRGRCRECHARGE, srgrcRecharge);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardSummary> getGCNVGiftCardSummaryList() {
      return (List<GiftCardSummary>) get(PROPERTY_GCNVGIFTCARDSUMMARYLIST);
    }

    public void setGCNVGiftCardSummaryList(List<GiftCardSummary> gCNVGiftCardSummaryList) {
        set(PROPERTY_GCNVGIFTCARDSUMMARYLIST, gCNVGiftCardSummaryList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardTrans> getGCNVGiftCardTransList() {
      return (List<GiftCardTrans>) get(PROPERTY_GCNVGIFTCARDTRANSLIST);
    }

    public void setGCNVGiftCardTransList(List<GiftCardTrans> gCNVGiftCardTransList) {
        set(PROPERTY_GCNVGIFTCARDTRANSLIST, gCNVGiftCardTransList);
    }

}
