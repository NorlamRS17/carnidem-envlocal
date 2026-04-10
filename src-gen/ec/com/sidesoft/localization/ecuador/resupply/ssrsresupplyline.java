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
package ec.com.sidesoft.localization.ecuador.resupply;

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
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
/**
 * Entity class for entity ssrs_resupplyline (stored in table ssrs_resupplyline).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ssrsresupplyline extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssrs_resupplyline";
    public static final String ENTITY_NAME = "ssrs_resupplyline";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SSRSRESUPPLY = "ssrsResupply";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_LISTPRICE = "listPrice";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ORDERUOM = "orderUOM";
    public static final String PROPERTY_ORDERQUANTITY = "orderQuantity";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_REQUISITIONLINESTATUS = "requisitionLineStatus";
    public static final String PROPERTY_MATCHEDPOQTY = "matchedPOQty";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_CHANGESTATUS = "changeStatus";
    public static final String PROPERTY_INTERNALNOTES = "internalNotes";
    public static final String PROPERTY_NOTESFORSUPPLIER = "notesForSupplier";
    public static final String PROPERTY_PLANNEDDATE = "plannedDate";
    public static final String PROPERTY_NEEDBYDATE = "needByDate";
    public static final String PROPERTY_LOCKEDBY = "lockedBy";
    public static final String PROPERTY_LOCKQTY = "lockQty";
    public static final String PROPERTY_LOCKPRICE = "lockPrice";
    public static final String PROPERTY_LOCKDATE = "lockDate";
    public static final String PROPERTY_LOCKCAUSE = "lockCause";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_GROSSUNITPRICE = "grossUnitPrice";
    public static final String PROPERTY_GROSSAMOUNT = "grossAmount";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_LOCKQTYCONVERSION = "lockqtyconversion";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSRSRESUPPLYLINEIDLIST = "materialMgmtInternalMovementLineEMSsrsResupplylineIDList";

    public ssrsresupplyline() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ORDERQUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_REQUISITIONLINESTATUS, "O");
        setDefaultValue(PROPERTY_MATCHEDPOQTY, (long) 0);
        setDefaultValue(PROPERTY_CHANGESTATUS, false);
        setDefaultValue(PROPERTY_GROSSUNITPRICE, (long) 0);
        setDefaultValue(PROPERTY_GROSSAMOUNT, (long) 0);
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSRSRESUPPLYLINEIDLIST, new ArrayList<Object>());
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

    public ssrsresupply getSsrsResupply() {
        return (ssrsresupply) get(PROPERTY_SSRSRESUPPLY);
    }

    public void setSsrsResupply(ssrsresupply ssrsResupply) {
        set(PROPERTY_SSRSRESUPPLY, ssrsResupply);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Long getListPrice() {
        return (Long) get(PROPERTY_LISTPRICE);
    }

    public void setListPrice(Long listPrice) {
        set(PROPERTY_LISTPRICE, listPrice);
    }

    public Long getLineNetAmount() {
        return (Long) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(Long lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public ProductUOM getOrderUOM() {
        return (ProductUOM) get(PROPERTY_ORDERUOM);
    }

    public void setOrderUOM(ProductUOM orderUOM) {
        set(PROPERTY_ORDERUOM, orderUOM);
    }

    public BigDecimal getOrderQuantity() {
        return (BigDecimal) get(PROPERTY_ORDERQUANTITY);
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        set(PROPERTY_ORDERQUANTITY, orderQuantity);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public String getRequisitionLineStatus() {
        return (String) get(PROPERTY_REQUISITIONLINESTATUS);
    }

    public void setRequisitionLineStatus(String requisitionLineStatus) {
        set(PROPERTY_REQUISITIONLINESTATUS, requisitionLineStatus);
    }

    public Long getMatchedPOQty() {
        return (Long) get(PROPERTY_MATCHEDPOQTY);
    }

    public void setMatchedPOQty(Long matchedPOQty) {
        set(PROPERTY_MATCHEDPOQTY, matchedPOQty);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isChangeStatus() {
        return (Boolean) get(PROPERTY_CHANGESTATUS);
    }

    public void setChangeStatus(Boolean changeStatus) {
        set(PROPERTY_CHANGESTATUS, changeStatus);
    }

    public String getInternalNotes() {
        return (String) get(PROPERTY_INTERNALNOTES);
    }

    public void setInternalNotes(String internalNotes) {
        set(PROPERTY_INTERNALNOTES, internalNotes);
    }

    public String getNotesForSupplier() {
        return (String) get(PROPERTY_NOTESFORSUPPLIER);
    }

    public void setNotesForSupplier(String notesForSupplier) {
        set(PROPERTY_NOTESFORSUPPLIER, notesForSupplier);
    }

    public Date getPlannedDate() {
        return (Date) get(PROPERTY_PLANNEDDATE);
    }

    public void setPlannedDate(Date plannedDate) {
        set(PROPERTY_PLANNEDDATE, plannedDate);
    }

    public Date getNeedByDate() {
        return (Date) get(PROPERTY_NEEDBYDATE);
    }

    public void setNeedByDate(Date needByDate) {
        set(PROPERTY_NEEDBYDATE, needByDate);
    }

    public String getLockedBy() {
        return (String) get(PROPERTY_LOCKEDBY);
    }

    public void setLockedBy(String lockedBy) {
        set(PROPERTY_LOCKEDBY, lockedBy);
    }

    public Long getLockQty() {
        return (Long) get(PROPERTY_LOCKQTY);
    }

    public void setLockQty(Long lockQty) {
        set(PROPERTY_LOCKQTY, lockQty);
    }

    public Long getLockPrice() {
        return (Long) get(PROPERTY_LOCKPRICE);
    }

    public void setLockPrice(Long lockPrice) {
        set(PROPERTY_LOCKPRICE, lockPrice);
    }

    public Date getLockDate() {
        return (Date) get(PROPERTY_LOCKDATE);
    }

    public void setLockDate(Date lockDate) {
        set(PROPERTY_LOCKDATE, lockDate);
    }

    public String getLockCause() {
        return (String) get(PROPERTY_LOCKCAUSE);
    }

    public void setLockCause(String lockCause) {
        set(PROPERTY_LOCKCAUSE, lockCause);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Long getGrossUnitPrice() {
        return (Long) get(PROPERTY_GROSSUNITPRICE);
    }

    public void setGrossUnitPrice(Long grossUnitPrice) {
        set(PROPERTY_GROSSUNITPRICE, grossUnitPrice);
    }

    public Long getGrossAmount() {
        return (Long) get(PROPERTY_GROSSAMOUNT);
    }

    public void setGrossAmount(Long grossAmount) {
        set(PROPERTY_GROSSAMOUNT, grossAmount);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Long getLockqtyconversion() {
        return (Long) get(PROPERTY_LOCKQTYCONVERSION);
    }

    public void setLockqtyconversion(Long lockqtyconversion) {
        set(PROPERTY_LOCKQTYCONVERSION, lockqtyconversion);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineEMSsrsResupplylineIDList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSRSRESUPPLYLINEIDLIST);
    }

    public void setMaterialMgmtInternalMovementLineEMSsrsResupplylineIDList(List<InternalMovementLine> materialMgmtInternalMovementLineEMSsrsResupplylineIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSSRSRESUPPLYLINEIDLIST, materialMgmtInternalMovementLineEMSsrsResupplylineIDList);
    }

}
