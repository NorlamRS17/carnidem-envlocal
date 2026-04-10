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
package ec.com.sidesoft.localization.importdata.loadvouchers;

import com.sidesoft.localization.ecuador.withholdings.SSWHCodelivelihoodt;
import com.sidesoft.localization.ecuador.withholdings.SSWHLivelihoodt;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
/**
 * Entity class for entity imdlv_purchase_invoice (stored in table imdlv_purchase_invoice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ImdlvPurchaseIinvoice extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "imdlv_purchase_invoice";
    public static final String ENTITY_NAME = "imdlv_purchase_invoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCTYPEPURCHASE = "doctypePurchase";
    public static final String PROPERTY_DOCTYPEWITHSUPPORT = "doctypeWithSupport";
    public static final String PROPERTY_DOCTYPEWITHOUTSUPPORT = "doctypeWithoutSupport";
    public static final String PROPERTY_SSWHLIVELIHOODT = "sswhLivelihoodt";
    public static final String PROPERTY_SSWHCODELIVELIHOODT = "sswhCodelivelihoodt";
    public static final String PROPERTY_DOCTYPEWITHHOLDING = "doctypeWithholding";
    public static final String PROPERTY_PRODUCTDEFAULT = "productDefault";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_TYPETRX = "typetrx";
    public static final String PROPERTY_WSDOCTYPE = "wsdoctype";
    public static final String PROPERTY_CNDOCTYPE = "cndoctype";
    public static final String PROPERTY_CDDODCTYPE = "cddodctype";
    public static final String PROPERTY_URLSRI = "uRLSri";
    public static final String PROPERTY_DOCTYPEORDER = "doctypeOrder";
    public static final String PROPERTY_DOCTYPEINOUT = "doctypeInout";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_TYPETRXXML = "typetrxxml";

    public ImdlvPurchaseIinvoice() {
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

    public DocumentType getDoctypePurchase() {
        return (DocumentType) get(PROPERTY_DOCTYPEPURCHASE);
    }

    public void setDoctypePurchase(DocumentType doctypePurchase) {
        set(PROPERTY_DOCTYPEPURCHASE, doctypePurchase);
    }

    public DocumentType getDoctypeWithSupport() {
        return (DocumentType) get(PROPERTY_DOCTYPEWITHSUPPORT);
    }

    public void setDoctypeWithSupport(DocumentType doctypeWithSupport) {
        set(PROPERTY_DOCTYPEWITHSUPPORT, doctypeWithSupport);
    }

    public DocumentType getDoctypeWithoutSupport() {
        return (DocumentType) get(PROPERTY_DOCTYPEWITHOUTSUPPORT);
    }

    public void setDoctypeWithoutSupport(DocumentType doctypeWithoutSupport) {
        set(PROPERTY_DOCTYPEWITHOUTSUPPORT, doctypeWithoutSupport);
    }

    public SSWHLivelihoodt getSswhLivelihoodt() {
        return (SSWHLivelihoodt) get(PROPERTY_SSWHLIVELIHOODT);
    }

    public void setSswhLivelihoodt(SSWHLivelihoodt sswhLivelihoodt) {
        set(PROPERTY_SSWHLIVELIHOODT, sswhLivelihoodt);
    }

    public SSWHCodelivelihoodt getSswhCodelivelihoodt() {
        return (SSWHCodelivelihoodt) get(PROPERTY_SSWHCODELIVELIHOODT);
    }

    public void setSswhCodelivelihoodt(SSWHCodelivelihoodt sswhCodelivelihoodt) {
        set(PROPERTY_SSWHCODELIVELIHOODT, sswhCodelivelihoodt);
    }

    public DocumentType getDoctypeWithholding() {
        return (DocumentType) get(PROPERTY_DOCTYPEWITHHOLDING);
    }

    public void setDoctypeWithholding(DocumentType doctypeWithholding) {
        set(PROPERTY_DOCTYPEWITHHOLDING, doctypeWithholding);
    }

    public Product getProductDefault() {
        return (Product) get(PROPERTY_PRODUCTDEFAULT);
    }

    public void setProductDefault(Product productDefault) {
        set(PROPERTY_PRODUCTDEFAULT, productDefault);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public String getTypetrx() {
        return (String) get(PROPERTY_TYPETRX);
    }

    public void setTypetrx(String typetrx) {
        set(PROPERTY_TYPETRX, typetrx);
    }

    public DocumentType getWsdoctype() {
        return (DocumentType) get(PROPERTY_WSDOCTYPE);
    }

    public void setWsdoctype(DocumentType wsdoctype) {
        set(PROPERTY_WSDOCTYPE, wsdoctype);
    }

    public DocumentType getCndoctype() {
        return (DocumentType) get(PROPERTY_CNDOCTYPE);
    }

    public void setCndoctype(DocumentType cndoctype) {
        set(PROPERTY_CNDOCTYPE, cndoctype);
    }

    public DocumentType getCddodctype() {
        return (DocumentType) get(PROPERTY_CDDODCTYPE);
    }

    public void setCddodctype(DocumentType cddodctype) {
        set(PROPERTY_CDDODCTYPE, cddodctype);
    }

    public String getURLSri() {
        return (String) get(PROPERTY_URLSRI);
    }

    public void setURLSri(String uRLSri) {
        set(PROPERTY_URLSRI, uRLSri);
    }

    public DocumentType getDoctypeOrder() {
        return (DocumentType) get(PROPERTY_DOCTYPEORDER);
    }

    public void setDoctypeOrder(DocumentType doctypeOrder) {
        set(PROPERTY_DOCTYPEORDER, doctypeOrder);
    }

    public DocumentType getDoctypeInout() {
        return (DocumentType) get(PROPERTY_DOCTYPEINOUT);
    }

    public void setDoctypeInout(DocumentType doctypeInout) {
        set(PROPERTY_DOCTYPEINOUT, doctypeInout);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public String getTypetrxxml() {
        return (String) get(PROPERTY_TYPETRXXML);
    }

    public void setTypetrxxml(String typetrxxml) {
        set(PROPERTY_TYPETRXXML, typetrxxml);
    }

}
