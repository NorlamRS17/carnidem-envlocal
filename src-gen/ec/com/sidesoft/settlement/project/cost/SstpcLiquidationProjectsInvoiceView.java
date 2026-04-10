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
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
/**
 * Entity class for entity sstpc_liq_prj_inv_v (stored in table sstpc_liq_prj_inv_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SstpcLiquidationProjectsInvoiceView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sstpc_liq_prj_inv_v";
    public static final String ENTITY_NAME = "sstpc_liq_prj_inv_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_INVOICELINE = "invoiceline";
    public static final String PROPERTY_NUMREFERENCIA = "nUMReferencia";
    public static final String PROPERTY_TIPOFACTURA = "tipoFactura";
    public static final String PROPERTY_FACTURA = "factura";
    public static final String PROPERTY_FECHAFACTURA = "fechaFactura";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTO = "producto";
    public static final String PROPERTY_TOTALLINEA = "totalLinea";
    public static final String PROPERTY_LIQUIDAR = "liquidar";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_BPARTNER = "bpartner";

    public SstpcLiquidationProjectsInvoiceView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_LINE, (long) 10);
        setDefaultValue(PROPERTY_LIQUIDAR, false);
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

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public InvoiceLine getInvoiceline() {
        return (InvoiceLine) get(PROPERTY_INVOICELINE);
    }

    public void setInvoiceline(InvoiceLine invoiceline) {
        set(PROPERTY_INVOICELINE, invoiceline);
    }

    public String getNUMReferencia() {
        return (String) get(PROPERTY_NUMREFERENCIA);
    }

    public void setNUMReferencia(String nUMReferencia) {
        set(PROPERTY_NUMREFERENCIA, nUMReferencia);
    }

    public DocumentType getTipoFactura() {
        return (DocumentType) get(PROPERTY_TIPOFACTURA);
    }

    public void setTipoFactura(DocumentType tipoFactura) {
        set(PROPERTY_TIPOFACTURA, tipoFactura);
    }

    public String getFactura() {
        return (String) get(PROPERTY_FACTURA);
    }

    public void setFactura(String factura) {
        set(PROPERTY_FACTURA, factura);
    }

    public Date getFechaFactura() {
        return (Date) get(PROPERTY_FECHAFACTURA);
    }

    public void setFechaFactura(Date fechaFactura) {
        set(PROPERTY_FECHAFACTURA, fechaFactura);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getProducto() {
        return (String) get(PROPERTY_PRODUCTO);
    }

    public void setProducto(String producto) {
        set(PROPERTY_PRODUCTO, producto);
    }

    public BigDecimal getTotalLinea() {
        return (BigDecimal) get(PROPERTY_TOTALLINEA);
    }

    public void setTotalLinea(BigDecimal totalLinea) {
        set(PROPERTY_TOTALLINEA, totalLinea);
    }

    public Boolean isLiquidar() {
        return (Boolean) get(PROPERTY_LIQUIDAR);
    }

    public void setLiquidar(Boolean liquidar) {
        set(PROPERTY_LIQUIDAR, liquidar);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

}
