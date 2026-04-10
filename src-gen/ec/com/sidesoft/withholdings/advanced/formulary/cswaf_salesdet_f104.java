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
package ec.com.sidesoft.withholdings.advanced.formulary;

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
 * Entity class for entity cswaf_salesdet_f104 (stored in table cswaf_salesdet_f104).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class cswaf_salesdet_f104 extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "cswaf_salesdet_f104";
    public static final String ENTITY_NAME = "cswaf_salesdet_f104";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CODTIPOCOMPROBANTE = "cODTipoComprobante";
    public static final String PROPERTY_BASENOIVA = "baseNoIva";
    public static final String PROPERTY_BASEIVACERO = "baseIvaCero";
    public static final String PROPERTY_BASEIVADOCE = "baseIvaDoce";
    public static final String PROPERTY_MONTOIVA = "montoIva";
    public static final String PROPERTY_PROCESS = "process";

    public cswaf_salesdet_f104() {
        setDefaultValue(PROPERTY_ACTIVE, false);
        setDefaultValue(PROPERTY_BASENOIVA, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASEIVACERO, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASEIVADOCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_MONTOIVA, new BigDecimal(0));
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

    public String getCODTipoComprobante() {
        return (String) get(PROPERTY_CODTIPOCOMPROBANTE);
    }

    public void setCODTipoComprobante(String cODTipoComprobante) {
        set(PROPERTY_CODTIPOCOMPROBANTE, cODTipoComprobante);
    }

    public BigDecimal getBaseNoIva() {
        return (BigDecimal) get(PROPERTY_BASENOIVA);
    }

    public void setBaseNoIva(BigDecimal baseNoIva) {
        set(PROPERTY_BASENOIVA, baseNoIva);
    }

    public BigDecimal getBaseIvaCero() {
        return (BigDecimal) get(PROPERTY_BASEIVACERO);
    }

    public void setBaseIvaCero(BigDecimal baseIvaCero) {
        set(PROPERTY_BASEIVACERO, baseIvaCero);
    }

    public BigDecimal getBaseIvaDoce() {
        return (BigDecimal) get(PROPERTY_BASEIVADOCE);
    }

    public void setBaseIvaDoce(BigDecimal baseIvaDoce) {
        set(PROPERTY_BASEIVADOCE, baseIvaDoce);
    }

    public BigDecimal getMontoIva() {
        return (BigDecimal) get(PROPERTY_MONTOIVA);
    }

    public void setMontoIva(BigDecimal montoIva) {
        set(PROPERTY_MONTOIVA, montoIva);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

}
