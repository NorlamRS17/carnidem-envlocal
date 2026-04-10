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
package ec.com.sidesoft.workorder.consult;

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import com.atrums.indumoto.postventa.data.atindpo_postventalinea;

import java.math.BigDecimal;
import java.util.Date;

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
/**
 * Entity class for entity sswcl_work_orderline_v (stored in table sswcl_work_orderline_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSWCLWorkOrderLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sswcl_work_orderline_v";
    public static final String ENTITY_NAME = "sswcl_work_orderline_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ATINDPOPOSTVENTALINEA = "atindpoPostventalinea";
    public static final String PROPERTY_SSWCLWORKORDERV = "sswclWorkOrderV";
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
    public static final String PROPERTY_PRECIOUNITARIO = "precioUnitario";
    public static final String PROPERTY_PRECIOTARIFA = "precioTarifa";
    public static final String PROPERTY_VALORTOTALLNEA = "valorTotalLnea";
    public static final String PROPERTY_DESCUENTO = "descuento";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_ATINDPOVALDESCUENTO = "atindpoValdescuento";
    public static final String PROPERTY_ATINDPOIVA = "atindpoIva";
    public static final String PROPERTY_ATINDPOTOTAL = "atindpoTotal";
    public static final String PROPERTY_SSWCLINDSUPTIPO = "sswclIndsupTipo";
    public static final String PROPERTY_SSWCLINDSUPCAT = "sswclIndsupCat";
    public static final String PROPERTY_SSWCLSSWOSTRANSFER = "sswclSswosTransfer";
    public static final String PROPERTY_SSWCLSSWOSIDENTIFIER = "sswclSswosIdentifier";
    public static final String PROPERTY_SSWCLSSWOSTRANSFERPARTSRETURN = "sswclSswosTransferpartsreturn";

    public SSWCLWorkOrderLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ENTREGADO, false);
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

    public atindpo_postventalinea getAtindpoPostventalinea() {
        return (atindpo_postventalinea) get(PROPERTY_ATINDPOPOSTVENTALINEA);
    }

    public void setAtindpoPostventalinea(atindpo_postventalinea atindpoPostventalinea) {
        set(PROPERTY_ATINDPOPOSTVENTALINEA, atindpoPostventalinea);
    }

    public SSWCLWorkOrder getSswclWorkOrderV() {
        return (SSWCLWorkOrder) get(PROPERTY_SSWCLWORKORDERV);
    }

    public void setSswclWorkOrderV(SSWCLWorkOrder sswclWorkOrderV) {
        set(PROPERTY_SSWCLWORKORDERV, sswclWorkOrderV);
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

    public Long getPrecioUnitario() {
        return (Long) get(PROPERTY_PRECIOUNITARIO);
    }

    public void setPrecioUnitario(Long precioUnitario) {
        set(PROPERTY_PRECIOUNITARIO, precioUnitario);
    }

    public Long getPrecioTarifa() {
        return (Long) get(PROPERTY_PRECIOTARIFA);
    }

    public void setPrecioTarifa(Long precioTarifa) {
        set(PROPERTY_PRECIOTARIFA, precioTarifa);
    }

    public Long getValorTotalLnea() {
        return (Long) get(PROPERTY_VALORTOTALLNEA);
    }

    public void setValorTotalLnea(Long valorTotalLnea) {
        set(PROPERTY_VALORTOTALLNEA, valorTotalLnea);
    }

    public Long getDescuento() {
        return (Long) get(PROPERTY_DESCUENTO);
    }

    public void setDescuento(Long descuento) {
        set(PROPERTY_DESCUENTO, descuento);
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

    public Long getAtindpoValdescuento() {
        return (Long) get(PROPERTY_ATINDPOVALDESCUENTO);
    }

    public void setAtindpoValdescuento(Long atindpoValdescuento) {
        set(PROPERTY_ATINDPOVALDESCUENTO, atindpoValdescuento);
    }

    public Long getAtindpoIva() {
        return (Long) get(PROPERTY_ATINDPOIVA);
    }

    public void setAtindpoIva(Long atindpoIva) {
        set(PROPERTY_ATINDPOIVA, atindpoIva);
    }

    public Long getAtindpoTotal() {
        return (Long) get(PROPERTY_ATINDPOTOTAL);
    }

    public void setAtindpoTotal(Long atindpoTotal) {
        set(PROPERTY_ATINDPOTOTAL, atindpoTotal);
    }

    public String getSswclIndsupTipo() {
        return (String) get(PROPERTY_SSWCLINDSUPTIPO);
    }

    public void setSswclIndsupTipo(String sswclIndsupTipo) {
        set(PROPERTY_SSWCLINDSUPTIPO, sswclIndsupTipo);
    }

    public ProductCategory getSswclIndsupCat() {
        return (ProductCategory) get(PROPERTY_SSWCLINDSUPCAT);
    }

    public void setSswclIndsupCat(ProductCategory sswclIndsupCat) {
        set(PROPERTY_SSWCLINDSUPCAT, sswclIndsupCat);
    }

    public BigDecimal getSswclSswosTransfer() {
        return (BigDecimal) get(PROPERTY_SSWCLSSWOSTRANSFER);
    }

    public void setSswclSswosTransfer(BigDecimal sswclSswosTransfer) {
        set(PROPERTY_SSWCLSSWOSTRANSFER, sswclSswosTransfer);
    }

    public String getSswclSswosIdentifier() {
        return (String) get(PROPERTY_SSWCLSSWOSIDENTIFIER);
    }

    public void setSswclSswosIdentifier(String sswclSswosIdentifier) {
        set(PROPERTY_SSWCLSSWOSIDENTIFIER, sswclSswosIdentifier);
    }

    public String getSswclSswosTransferpartsreturn() {
        return (String) get(PROPERTY_SSWCLSSWOSTRANSFERPARTSRETURN);
    }

    public void setSswclSswosTransferpartsreturn(String sswclSswosTransferpartsreturn) {
        set(PROPERTY_SSWCLSSWOSTRANSFERPARTSRETURN, sswclSswosTransferpartsreturn);
    }

}
