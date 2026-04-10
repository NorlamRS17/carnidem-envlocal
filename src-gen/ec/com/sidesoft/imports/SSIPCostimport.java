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
package ec.com.sidesoft.imports;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
/**
 * Entity class for entity SSIP_Costimport (stored in table SSIP_Costimport).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SSIPCostimport extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSIP_Costimport";
    public static final String ENTITY_NAME = "SSIP_Costimport";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_TRANSACTIONDATE = "transactionDate";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_DOCUMENTNUMBER = "documentNumber";
    public static final String PROPERTY_ORDER = "order";
    public static final String PROPERTY_POREFERENCE = "poreference";
    public static final String PROPERTY_ADDITIONALCOSTS = "additionalCosts";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_NETAMOUNT = "netAmount";

    public SSIPCostimport() {
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

    public Date getTransactionDate() {
        return (Date) get(PROPERTY_TRANSACTIONDATE);
    }

    public void setTransactionDate(Date transactionDate) {
        set(PROPERTY_TRANSACTIONDATE, transactionDate);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public String getDocumentType() {
        return (String) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(String documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public String getDocumentNumber() {
        return (String) get(PROPERTY_DOCUMENTNUMBER);
    }

    public void setDocumentNumber(String documentNumber) {
        set(PROPERTY_DOCUMENTNUMBER, documentNumber);
    }

    public Order getOrder() {
        return (Order) get(PROPERTY_ORDER);
    }

    public void setOrder(Order order) {
        set(PROPERTY_ORDER, order);
    }

    public String getPoreference() {
        return (String) get(PROPERTY_POREFERENCE);
    }

    public void setPoreference(String poreference) {
        set(PROPERTY_POREFERENCE, poreference);
    }

    public SSIPAdditionalcosts getAdditionalCosts() {
        return (SSIPAdditionalcosts) get(PROPERTY_ADDITIONALCOSTS);
    }

    public void setAdditionalCosts(SSIPAdditionalcosts additionalCosts) {
        set(PROPERTY_ADDITIONALCOSTS, additionalCosts);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getNetAmount() {
        return (BigDecimal) get(PROPERTY_NETAMOUNT);
    }

    public void setNetAmount(BigDecimal netAmount) {
        set(PROPERTY_NETAMOUNT, netAmount);
    }

}
