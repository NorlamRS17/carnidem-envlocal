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
package ec.com.sidesoft.carnidem.breakdown;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
/**
 * Entity class for entity ecscb_breakdown_line (stored in table ecscb_breakdown_line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ecscb_breakdown_line extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ecscb_breakdown_line";
    public static final String ENTITY_NAME = "ecscb_breakdown_line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ECSCBBREAKDOWN = "ecscbBreakdown";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_MASS = "mass";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_PERCENTAGETOTALMASS = "percentageTotalMass";
    public static final String PROPERTY_PERCENTAGEQUALITY = "percentageQuality";
    public static final String PROPERTY_REFERENCEPRICE = "referencePrice";
    public static final String PROPERTY_USDKG = "uSDKg";
    public static final String PROPERTY_VALUEUSD = "valueUsd";
    public static final String PROPERTY_NOTESOBSERVATIONS = "notesObservations";

    public ecscb_breakdown_line() {
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

    public ecscb_breakdown getEcscbBreakdown() {
        return (ecscb_breakdown) get(PROPERTY_ECSCBBREAKDOWN);
    }

    public void setEcscbBreakdown(ecscb_breakdown ecscbBreakdown) {
        set(PROPERTY_ECSCBBREAKDOWN, ecscbBreakdown);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getMass() {
        return (BigDecimal) get(PROPERTY_MASS);
    }

    public void setMass(BigDecimal mass) {
        set(PROPERTY_MASS, mass);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public BigDecimal getPercentageTotalMass() {
        return (BigDecimal) get(PROPERTY_PERCENTAGETOTALMASS);
    }

    public void setPercentageTotalMass(BigDecimal percentageTotalMass) {
        set(PROPERTY_PERCENTAGETOTALMASS, percentageTotalMass);
    }

    public BigDecimal getPercentageQuality() {
        return (BigDecimal) get(PROPERTY_PERCENTAGEQUALITY);
    }

    public void setPercentageQuality(BigDecimal percentageQuality) {
        set(PROPERTY_PERCENTAGEQUALITY, percentageQuality);
    }

    public BigDecimal getReferencePrice() {
        return (BigDecimal) get(PROPERTY_REFERENCEPRICE);
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        set(PROPERTY_REFERENCEPRICE, referencePrice);
    }

    public BigDecimal getUSDKg() {
        return (BigDecimal) get(PROPERTY_USDKG);
    }

    public void setUSDKg(BigDecimal uSDKg) {
        set(PROPERTY_USDKG, uSDKg);
    }

    public BigDecimal getValueUsd() {
        return (BigDecimal) get(PROPERTY_VALUEUSD);
    }

    public void setValueUsd(BigDecimal valueUsd) {
        set(PROPERTY_VALUEUSD, valueUsd);
    }

    public String getNotesObservations() {
        return (String) get(PROPERTY_NOTESOBSERVATIONS);
    }

    public void setNotesObservations(String notesObservations) {
        set(PROPERTY_NOTESOBSERVATIONS, notesObservations);
    }

}
