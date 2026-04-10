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
package ec.com.sidesoft.workorder.simplified;

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import com.atrums.indumoto.postventa.data.atindpo_postventalinea;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
/**
 * Entity class for entity Sswos_Transfer (stored in table Sswos_Transfer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswosTransfer extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sswos_Transfer";
    public static final String ENTITY_NAME = "Sswos_Transfer";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ATINDPOPOSTVENTA = "atindpoPostventa";
    public static final String PROPERTY_ATINDPOPOSTVENTALINEA = "atindpoPostventalinea";
    public static final String PROPERTY_TRANSFERS = "transfers";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_DATETRANSFER = "dateTransfer";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_MOVEMENT = "movement";
    public static final String PROPERTY_SPSMVATRETURNQUANTITY = "spsmvatReturnQuantity";

    public SswosTransfer() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_QUANTITY, (long) 0);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_SPSMVATRETURNQUANTITY, (long) 0);
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

    public atindpo_postventa getAtindpoPostventa() {
        return (atindpo_postventa) get(PROPERTY_ATINDPOPOSTVENTA);
    }

    public void setAtindpoPostventa(atindpo_postventa atindpoPostventa) {
        set(PROPERTY_ATINDPOPOSTVENTA, atindpoPostventa);
    }

    public atindpo_postventalinea getAtindpoPostventalinea() {
        return (atindpo_postventalinea) get(PROPERTY_ATINDPOPOSTVENTALINEA);
    }

    public void setAtindpoPostventalinea(atindpo_postventalinea atindpoPostventalinea) {
        set(PROPERTY_ATINDPOPOSTVENTALINEA, atindpoPostventalinea);
    }

    public String getTransfers() {
        return (String) get(PROPERTY_TRANSFERS);
    }

    public void setTransfers(String transfers) {
        set(PROPERTY_TRANSFERS, transfers);
    }

    public Long getQuantity() {
        return (Long) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(Long quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public Date getDateTransfer() {
        return (Date) get(PROPERTY_DATETRANSFER);
    }

    public void setDateTransfer(Date dateTransfer) {
        set(PROPERTY_DATETRANSFER, dateTransfer);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public InternalMovement getMovement() {
        return (InternalMovement) get(PROPERTY_MOVEMENT);
    }

    public void setMovement(InternalMovement movement) {
        set(PROPERTY_MOVEMENT, movement);
    }

    public Long getSpsmvatReturnQuantity() {
        return (Long) get(PROPERTY_SPSMVATRETURNQUANTITY);
    }

    public void setSpsmvatReturnQuantity(Long spsmvatReturnQuantity) {
        set(PROPERTY_SPSMVATRETURNQUANTITY, spsmvatReturnQuantity);
    }

}
