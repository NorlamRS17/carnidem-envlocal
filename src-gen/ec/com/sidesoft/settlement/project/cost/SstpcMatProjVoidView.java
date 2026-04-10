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
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
/**
 * Entity class for entity sstpc_mat_proj_void_v (stored in table sstpc_mat_proj_void_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SstpcMatProjVoidView extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sstpc_mat_proj_void_v";
    public static final String ENTITY_NAME = "sstpc_mat_proj_void_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ROWNUMB = "rOWNumb";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ALBARAN = "albaran";
    public static final String PROPERTY_UNIDADMEDIDA = "unidadMedida";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_CENTROCOSTOS = "centroCostos";
    public static final String PROPERTY_CANTIDAD = "cantidad";
    public static final String PROPERTY_COSTO = "costo";
    public static final String PROPERTY_CODIGO = "codigo";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_PRODUCTO = "producto";
    public static final String PROPERTY_TOTALLINEA = "totalLinea";
    public static final String PROPERTY_FECHAACTUAL = "fechaActual";
    public static final String PROPERTY_LIQUIDADO = "liquidado";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_USER = "user";
    public static final String PROPERTY_INOUTLINE = "inoutline";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_LINEAALBARAN = "lineaAlbaran";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_COSTOTOTAL = "costoTotal";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";

    public SstpcMatProjVoidView() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_LIQUIDADO, false);
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

    public Long getROWNumb() {
        return (Long) get(PROPERTY_ROWNUMB);
    }

    public void setROWNumb(Long rOWNumb) {
        set(PROPERTY_ROWNUMB, rOWNumb);
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

    public String getAlbaran() {
        return (String) get(PROPERTY_ALBARAN);
    }

    public void setAlbaran(String albaran) {
        set(PROPERTY_ALBARAN, albaran);
    }

    public String getUnidadMedida() {
        return (String) get(PROPERTY_UNIDADMEDIDA);
    }

    public void setUnidadMedida(String unidadMedida) {
        set(PROPERTY_UNIDADMEDIDA, unidadMedida);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    public String getCentroCostos() {
        return (String) get(PROPERTY_CENTROCOSTOS);
    }

    public void setCentroCostos(String centroCostos) {
        set(PROPERTY_CENTROCOSTOS, centroCostos);
    }

    public BigDecimal getCantidad() {
        return (BigDecimal) get(PROPERTY_CANTIDAD);
    }

    public void setCantidad(BigDecimal cantidad) {
        set(PROPERTY_CANTIDAD, cantidad);
    }

    public BigDecimal getCosto() {
        return (BigDecimal) get(PROPERTY_COSTO);
    }

    public void setCosto(BigDecimal costo) {
        set(PROPERTY_COSTO, costo);
    }

    public String getCodigo() {
        return (String) get(PROPERTY_CODIGO);
    }

    public void setCodigo(String codigo) {
        set(PROPERTY_CODIGO, codigo);
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

    public String getFechaActual() {
        return (String) get(PROPERTY_FECHAACTUAL);
    }

    public void setFechaActual(String fechaActual) {
        set(PROPERTY_FECHAACTUAL, fechaActual);
    }

    public Boolean isLiquidado() {
        return (Boolean) get(PROPERTY_LIQUIDADO);
    }

    public void setLiquidado(Boolean liquidado) {
        set(PROPERTY_LIQUIDADO, liquidado);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public User getUser() {
        return (User) get(PROPERTY_USER);
    }

    public void setUser(User user) {
        set(PROPERTY_USER, user);
    }

    public ShipmentInOutLine getInoutline() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInoutline(ShipmentInOutLine inoutline) {
        set(PROPERTY_INOUTLINE, inoutline);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Long getLineaAlbaran() {
        return (Long) get(PROPERTY_LINEAALBARAN);
    }

    public void setLineaAlbaran(Long lineaAlbaran) {
        set(PROPERTY_LINEAALBARAN, lineaAlbaran);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public BigDecimal getCostoTotal() {
        return (BigDecimal) get(PROPERTY_COSTOTOTAL);
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        set(PROPERTY_COSTOTOTAL, costoTotal);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

}
