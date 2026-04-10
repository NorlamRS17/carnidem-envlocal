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
package org.openbravo.retail.discounts.combo;

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
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;
/**
 * Entity class for entity OBCOMBO_Family (stored in table OBCOMBO_Family).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ComboProductFamily extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "OBCOMBO_Family";
    public static final String ENTITY_NAME = "OBCOMBO_Family";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRICEADJUSTMENT = "priceAdjustment";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DISCOUNTTYPE = "discountType";
    public static final String PROPERTY_FIXEDPRICE = "fixedPrice";
    public static final String PROPERTY_PERCENTAGE = "percentage";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_FIXEDDISCOUNT = "fixedDiscount";
    public static final String PROPERTY_OBCOMBOFAMILYTRLLIST = "oBCOMBOFamilyTrlList";
    public static final String PROPERTY_OBCOMBOPRODUCTLIST = "oBCOMBOProductList";

    public ComboProductFamily() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, (long) 1);
        setDefaultValue(PROPERTY_OBCOMBOFAMILYTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBCOMBOPRODUCTLIST, new ArrayList<Object>());
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

    public PriceAdjustment getPriceAdjustment() {
        return (PriceAdjustment) get(PROPERTY_PRICEADJUSTMENT);
    }

    public void setPriceAdjustment(PriceAdjustment priceAdjustment) {
        set(PROPERTY_PRICEADJUSTMENT, priceAdjustment);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDiscountType() {
        return (String) get(PROPERTY_DISCOUNTTYPE);
    }

    public void setDiscountType(String discountType) {
        set(PROPERTY_DISCOUNTTYPE, discountType);
    }

    public BigDecimal getFixedPrice() {
        return (BigDecimal) get(PROPERTY_FIXEDPRICE);
    }

    public void setFixedPrice(BigDecimal fixedPrice) {
        set(PROPERTY_FIXEDPRICE, fixedPrice);
    }

    public BigDecimal getPercentage() {
        return (BigDecimal) get(PROPERTY_PERCENTAGE);
    }

    public void setPercentage(BigDecimal percentage) {
        set(PROPERTY_PERCENTAGE, percentage);
    }

    public Long getQuantity() {
        return (Long) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(Long quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public BigDecimal getFixedDiscount() {
        return (BigDecimal) get(PROPERTY_FIXEDDISCOUNT);
    }

    public void setFixedDiscount(BigDecimal fixedDiscount) {
        set(PROPERTY_FIXEDDISCOUNT, fixedDiscount);
    }

    @SuppressWarnings("unchecked")
    public List<ComboProductFamilyTrl> getOBCOMBOFamilyTrlList() {
      return (List<ComboProductFamilyTrl>) get(PROPERTY_OBCOMBOFAMILYTRLLIST);
    }

    public void setOBCOMBOFamilyTrlList(List<ComboProductFamilyTrl> oBCOMBOFamilyTrlList) {
        set(PROPERTY_OBCOMBOFAMILYTRLLIST, oBCOMBOFamilyTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ComboProduct> getOBCOMBOProductList() {
      return (List<ComboProduct>) get(PROPERTY_OBCOMBOPRODUCTLIST);
    }

    public void setOBCOMBOProductList(List<ComboProduct> oBCOMBOProductList) {
        set(PROPERTY_OBCOMBOPRODUCTLIST, oBCOMBOProductList);
    }

}
