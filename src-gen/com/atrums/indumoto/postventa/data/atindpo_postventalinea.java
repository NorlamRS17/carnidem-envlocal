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
package com.atrums.indumoto.postventa.data;

import com.sidesoft.localization.productSubcategory.SlpsProductCategory;

import ec.com.sidesoft.workorder.consult.SSWCLWorkOrderLine;
import ec.com.sidesoft.workorder.simplified.SswosTransfer;

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
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
/**
 * Entity class for entity atindpo_postventalinea (stored in table atindpo_postventalinea).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class atindpo_postventalinea extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "atindpo_postventalinea";
    public static final String ENTITY_NAME = "atindpo_postventalinea";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ATINDPOPOSTVENTA = "atindpoPostventa";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_CANTIDAD = "cantidad";
    public static final String PROPERTY_DESCRIPCION = "descripcion";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_ENTREGADO = "entregado";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_ATINDPOUNITPRICE = "atindpoUnitprice";
    public static final String PROPERTY_ATINDPOPRICELIST = "atindpoPricelist";
    public static final String PROPERTY_ATINDPOLINENETAMT = "atindpoLinenetamt";
    public static final String PROPERTY_ATINDPODISCOUNT = "atindpoDiscount";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_ATINDPOVALDESCUENTO = "atindpoValdescuento";
    public static final String PROPERTY_ATINDPOIVA = "atindpoIva";
    public static final String PROPERTY_INDSUPTIPO = "indsupTipo";
    public static final String PROPERTY_ATINDPOTOTAL = "atindpoTotal";
    public static final String PROPERTY_INDSUPCAT = "indsupCat";
    public static final String PROPERTY_SSWOSTRANSFER = "sswosTransfer";
    public static final String PROPERTY_SSWOSIDENTIFIER = "sswosIdentifier";
    public static final String PROPERTY_SSWOSTRANSFERPARTSRETURN = "sSWOSTransferPartsReturn";
    public static final String PROPERTY_INDSUPPRODUCTCATEGORY = "indsupProductCategory";
    public static final String PROPERTY_SPSMVATTRANSFERSTATUS = "spsmvatTransferStatus";
    public static final String PROPERTY_SATMACINVOICE = "satmacInvoice";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSPSMVATPVLIDLIST = "materialMgmtInternalMovementLineEMSpsmvatPvlIDList";
    public static final String PROPERTY_SSWOSTRANSFERLIST = "sswosTransferList";
    public static final String PROPERTY_SSWCLWORKORDERLINEVLIST = "sswclWorkOrderlineVList";

    public atindpo_postventalinea() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CANTIDAD, new BigDecimal(1));
        setDefaultValue(PROPERTY_ENTREGADO, false);
        setDefaultValue(PROPERTY_ATINDPOUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATINDPOPRICELIST, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATINDPOLINENETAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATINDPODISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATINDPOVALDESCUENTO, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATINDPOIVA, new BigDecimal(0));
        setDefaultValue(PROPERTY_ATINDPOTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSWOSTRANSFER, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSWOSTRANSFERPARTSRETURN, false);
        setDefaultValue(PROPERTY_SATMACINVOICE, true);
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSPSMVATPVLIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSTRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERLINEVLIST, new ArrayList<Object>());
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

    public atindpo_postventa getAtindpoPostventa() {
        return (atindpo_postventa) get(PROPERTY_ATINDPOPOSTVENTA);
    }

    public void setAtindpoPostventa(atindpo_postventa atindpoPostventa) {
        set(PROPERTY_ATINDPOPOSTVENTA, atindpoPostventa);
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

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getCantidad() {
        return (BigDecimal) get(PROPERTY_CANTIDAD);
    }

    public void setCantidad(BigDecimal cantidad) {
        set(PROPERTY_CANTIDAD, cantidad);
    }

    public String getDescripcion() {
        return (String) get(PROPERTY_DESCRIPCION);
    }

    public void setDescripcion(String descripcion) {
        set(PROPERTY_DESCRIPCION, descripcion);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public Boolean isEntregado() {
        return (Boolean) get(PROPERTY_ENTREGADO);
    }

    public void setEntregado(Boolean entregado) {
        set(PROPERTY_ENTREGADO, entregado);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public BigDecimal getAtindpoUnitprice() {
        return (BigDecimal) get(PROPERTY_ATINDPOUNITPRICE);
    }

    public void setAtindpoUnitprice(BigDecimal atindpoUnitprice) {
        set(PROPERTY_ATINDPOUNITPRICE, atindpoUnitprice);
    }

    public BigDecimal getAtindpoPricelist() {
        return (BigDecimal) get(PROPERTY_ATINDPOPRICELIST);
    }

    public void setAtindpoPricelist(BigDecimal atindpoPricelist) {
        set(PROPERTY_ATINDPOPRICELIST, atindpoPricelist);
    }

    public BigDecimal getAtindpoLinenetamt() {
        return (BigDecimal) get(PROPERTY_ATINDPOLINENETAMT);
    }

    public void setAtindpoLinenetamt(BigDecimal atindpoLinenetamt) {
        set(PROPERTY_ATINDPOLINENETAMT, atindpoLinenetamt);
    }

    public BigDecimal getAtindpoDiscount() {
        return (BigDecimal) get(PROPERTY_ATINDPODISCOUNT);
    }

    public void setAtindpoDiscount(BigDecimal atindpoDiscount) {
        set(PROPERTY_ATINDPODISCOUNT, atindpoDiscount);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public BigDecimal getAtindpoValdescuento() {
        return (BigDecimal) get(PROPERTY_ATINDPOVALDESCUENTO);
    }

    public void setAtindpoValdescuento(BigDecimal atindpoValdescuento) {
        set(PROPERTY_ATINDPOVALDESCUENTO, atindpoValdescuento);
    }

    public BigDecimal getAtindpoIva() {
        return (BigDecimal) get(PROPERTY_ATINDPOIVA);
    }

    public void setAtindpoIva(BigDecimal atindpoIva) {
        set(PROPERTY_ATINDPOIVA, atindpoIva);
    }

    public String getIndsupTipo() {
        return (String) get(PROPERTY_INDSUPTIPO);
    }

    public void setIndsupTipo(String indsupTipo) {
        set(PROPERTY_INDSUPTIPO, indsupTipo);
    }

    public BigDecimal getAtindpoTotal() {
        return (BigDecimal) get(PROPERTY_ATINDPOTOTAL);
    }

    public void setAtindpoTotal(BigDecimal atindpoTotal) {
        set(PROPERTY_ATINDPOTOTAL, atindpoTotal);
    }

    public ProductCategory getIndsupCat() {
        return (ProductCategory) get(PROPERTY_INDSUPCAT);
    }

    public void setIndsupCat(ProductCategory indsupCat) {
        set(PROPERTY_INDSUPCAT, indsupCat);
    }

    public BigDecimal getSswosTransfer() {
        return (BigDecimal) get(PROPERTY_SSWOSTRANSFER);
    }

    public void setSswosTransfer(BigDecimal sswosTransfer) {
        set(PROPERTY_SSWOSTRANSFER, sswosTransfer);
    }

    public String getSswosIdentifier() {
        return (String) get(PROPERTY_SSWOSIDENTIFIER);
    }

    public void setSswosIdentifier(String sswosIdentifier) {
        set(PROPERTY_SSWOSIDENTIFIER, sswosIdentifier);
    }

    public Boolean isSSWOSTransferPartsReturn() {
        return (Boolean) get(PROPERTY_SSWOSTRANSFERPARTSRETURN);
    }

    public void setSSWOSTransferPartsReturn(Boolean sSWOSTransferPartsReturn) {
        set(PROPERTY_SSWOSTRANSFERPARTSRETURN, sSWOSTransferPartsReturn);
    }

    public SlpsProductCategory getIndsupProductCategory() {
        return (SlpsProductCategory) get(PROPERTY_INDSUPPRODUCTCATEGORY);
    }

    public void setIndsupProductCategory(SlpsProductCategory indsupProductCategory) {
        set(PROPERTY_INDSUPPRODUCTCATEGORY, indsupProductCategory);
    }

    public String getSpsmvatTransferStatus() {
        return (String) get(PROPERTY_SPSMVATTRANSFERSTATUS);
    }

    public void setSpsmvatTransferStatus(String spsmvatTransferStatus) {
        set(PROPERTY_SPSMVATTRANSFERSTATUS, spsmvatTransferStatus);
    }

    public Boolean isSatmacInvoice() {
        return (Boolean) get(PROPERTY_SATMACINVOICE);
    }

    public void setSatmacInvoice(Boolean satmacInvoice) {
        set(PROPERTY_SATMACINVOICE, satmacInvoice);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineEMSpsmvatPvlIDList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSPSMVATPVLIDLIST);
    }

    public void setMaterialMgmtInternalMovementLineEMSpsmvatPvlIDList(List<InternalMovementLine> materialMgmtInternalMovementLineEMSpsmvatPvlIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINEEMSPSMVATPVLIDLIST, materialMgmtInternalMovementLineEMSpsmvatPvlIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosTransfer> getSswosTransferList() {
      return (List<SswosTransfer>) get(PROPERTY_SSWOSTRANSFERLIST);
    }

    public void setSswosTransferList(List<SswosTransfer> sswosTransferList) {
        set(PROPERTY_SSWOSTRANSFERLIST, sswosTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrderLine> getSswclWorkOrderlineVList() {
      return (List<SSWCLWorkOrderLine>) get(PROPERTY_SSWCLWORKORDERLINEVLIST);
    }

    public void setSswclWorkOrderlineVList(List<SSWCLWorkOrderLine> sswclWorkOrderlineVList) {
        set(PROPERTY_SSWCLWORKORDERLINEVLIST, sswclWorkOrderlineVList);
    }

}
