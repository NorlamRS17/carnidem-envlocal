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
package ec.com.sidesoft.production.auto.transfer.mp;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.manufacturing.transaction.WorkRequirementProduct;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
/**
 * Entity class for entity spatmp_reference_transfer (stored in table spatmp_reference_transfer).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class spatmp_reference_transfer extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "spatmp_reference_transfer";
    public static final String ENTITY_NAME = "spatmp_reference_transfer";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_WRPRODUCTPHASE = "wRProductPhase";
    public static final String PROPERTY_WORKREQUIREMENT = "workRequirement";
    public static final String PROPERTY_TOTALAMOUNTRECUESTED = "totalAmountRecuested";
    public static final String PROPERTY_AMOUNTTOPP = "amountToPP";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_MOVEMENTLINE = "movementLine";

    public spatmp_reference_transfer() {
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

    public WorkRequirementProduct getWRProductPhase() {
        return (WorkRequirementProduct) get(PROPERTY_WRPRODUCTPHASE);
    }

    public void setWRProductPhase(WorkRequirementProduct wRProductPhase) {
        set(PROPERTY_WRPRODUCTPHASE, wRProductPhase);
    }

    public WorkRequirement getWorkRequirement() {
        return (WorkRequirement) get(PROPERTY_WORKREQUIREMENT);
    }

    public void setWorkRequirement(WorkRequirement workRequirement) {
        set(PROPERTY_WORKREQUIREMENT, workRequirement);
    }

    public Long getTotalAmountRecuested() {
        return (Long) get(PROPERTY_TOTALAMOUNTRECUESTED);
    }

    public void setTotalAmountRecuested(Long totalAmountRecuested) {
        set(PROPERTY_TOTALAMOUNTRECUESTED, totalAmountRecuested);
    }

    public Long getAmountToPP() {
        return (Long) get(PROPERTY_AMOUNTTOPP);
    }

    public void setAmountToPP(Long amountToPP) {
        set(PROPERTY_AMOUNTTOPP, amountToPP);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public InternalMovementLine getMovementLine() {
        return (InternalMovementLine) get(PROPERTY_MOVEMENTLINE);
    }

    public void setMovementLine(InternalMovementLine movementLine) {
        set(PROPERTY_MOVEMENTLINE, movementLine);
    }

}
