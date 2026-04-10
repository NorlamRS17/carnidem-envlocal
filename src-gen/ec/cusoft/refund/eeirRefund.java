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
package ec.cusoft.refund;

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
import org.openbravo.model.common.invoice.Invoice;
/**
 * Entity class for entity EEIR_Refund (stored in table eeir_refund).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class eeirRefund extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "eeir_refund";
    public static final String ENTITY_NAME = "EEIR_Refund";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_EEIRBPARTNER = "eeirBpartner";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_EEIRINVOICE = "eeirInvoice";
    public static final String PROPERTY_EEIRBASE = "eeirBase";
    public static final String PROPERTY_EEIRTAX = "eeirTax";
    public static final String PROPERTY_EEIRTOTAL = "eeirTotal";
    public static final String PROPERTY_ACTIVE = "active";

    public eeirRefund() {
        setDefaultValue(PROPERTY_EEIRBASE, new BigDecimal(0));
        setDefaultValue(PROPERTY_EEIRTAX, new BigDecimal(0));
        setDefaultValue(PROPERTY_EEIRTOTAL, new BigDecimal(0));
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

    public BusinessPartner getEeirBpartner() {
        return (BusinessPartner) get(PROPERTY_EEIRBPARTNER);
    }

    public void setEeirBpartner(BusinessPartner eeirBpartner) {
        set(PROPERTY_EEIRBPARTNER, eeirBpartner);
    }

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public Invoice getEeirInvoice() {
        return (Invoice) get(PROPERTY_EEIRINVOICE);
    }

    public void setEeirInvoice(Invoice eeirInvoice) {
        set(PROPERTY_EEIRINVOICE, eeirInvoice);
    }

    public BigDecimal getEeirBase() {
        return (BigDecimal) get(PROPERTY_EEIRBASE);
    }

    public void setEeirBase(BigDecimal eeirBase) {
        set(PROPERTY_EEIRBASE, eeirBase);
    }

    public BigDecimal getEeirTax() {
        return (BigDecimal) get(PROPERTY_EEIRTAX);
    }

    public void setEeirTax(BigDecimal eeirTax) {
        set(PROPERTY_EEIRTAX, eeirTax);
    }

    public BigDecimal getEeirTotal() {
        return (BigDecimal) get(PROPERTY_EEIRTOTAL);
    }

    public void setEeirTotal(BigDecimal eeirTotal) {
        set(PROPERTY_EEIRTOTAL, eeirTotal);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

}
