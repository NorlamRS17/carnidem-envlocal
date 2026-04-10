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
/**
 * Entity class for entity atindpo_registro_reemplazo (stored in table atindpo_registro_reemplazo).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class atindpo_registro_reemplazo extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "atindpo_registro_reemplazo";
    public static final String ENTITY_NAME = "atindpo_registro_reemplazo";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NOPARTE = "noparte";
    public static final String PROPERTY_DESCRIPCIONPIEZA = "descripcionpieza";
    public static final String PROPERTY_MARCA = "marca";
    public static final String PROPERTY_APLICACION = "aplicacion";
    public static final String PROPERTY_NOPARTEREEMPLAZO = "nopartereemplazo";
    public static final String PROPERTY_PRECIOFOB = "preciofob";
    public static final String PROPERTY_PRECIOECUADOR = "precioecuador";
    public static final String PROPERTY_PAISORIGEN = "paisorigen";
    public static final String PROPERTY_TIPOREPUESTO = "tiporepuesto";
    public static final String PROPERTY_CARGADATOS = "cargadatos";
    public static final String PROPERTY_BORRARDATOS = "borrardatos";

    public atindpo_registro_reemplazo() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_CARGADATOS, true);
        setDefaultValue(PROPERTY_BORRARDATOS, true);
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

    public String getNoparte() {
        return (String) get(PROPERTY_NOPARTE);
    }

    public void setNoparte(String noparte) {
        set(PROPERTY_NOPARTE, noparte);
    }

    public String getDescripcionpieza() {
        return (String) get(PROPERTY_DESCRIPCIONPIEZA);
    }

    public void setDescripcionpieza(String descripcionpieza) {
        set(PROPERTY_DESCRIPCIONPIEZA, descripcionpieza);
    }

    public String getMarca() {
        return (String) get(PROPERTY_MARCA);
    }

    public void setMarca(String marca) {
        set(PROPERTY_MARCA, marca);
    }

    public String getAplicacion() {
        return (String) get(PROPERTY_APLICACION);
    }

    public void setAplicacion(String aplicacion) {
        set(PROPERTY_APLICACION, aplicacion);
    }

    public String getNopartereemplazo() {
        return (String) get(PROPERTY_NOPARTEREEMPLAZO);
    }

    public void setNopartereemplazo(String nopartereemplazo) {
        set(PROPERTY_NOPARTEREEMPLAZO, nopartereemplazo);
    }

    public BigDecimal getPreciofob() {
        return (BigDecimal) get(PROPERTY_PRECIOFOB);
    }

    public void setPreciofob(BigDecimal preciofob) {
        set(PROPERTY_PRECIOFOB, preciofob);
    }

    public BigDecimal getPrecioecuador() {
        return (BigDecimal) get(PROPERTY_PRECIOECUADOR);
    }

    public void setPrecioecuador(BigDecimal precioecuador) {
        set(PROPERTY_PRECIOECUADOR, precioecuador);
    }

    public String getPaisorigen() {
        return (String) get(PROPERTY_PAISORIGEN);
    }

    public void setPaisorigen(String paisorigen) {
        set(PROPERTY_PAISORIGEN, paisorigen);
    }

    public String getTiporepuesto() {
        return (String) get(PROPERTY_TIPOREPUESTO);
    }

    public void setTiporepuesto(String tiporepuesto) {
        set(PROPERTY_TIPOREPUESTO, tiporepuesto);
    }

    public Boolean isCargadatos() {
        return (Boolean) get(PROPERTY_CARGADATOS);
    }

    public void setCargadatos(Boolean cargadatos) {
        set(PROPERTY_CARGADATOS, cargadatos);
    }

    public Boolean isBorrardatos() {
        return (Boolean) get(PROPERTY_BORRARDATOS);
    }

    public void setBorrardatos(Boolean borrardatos) {
        set(PROPERTY_BORRARDATOS, borrardatos);
    }

}
