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
package ec.com.sidesoft.localization.withholding.control;

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
import org.openbravo.model.common.invoice.Invoice;
/**
 * Entity class for entity ecswc_withholding_cancel (stored in table ecswc_withholding_cancel).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class withholdingcancel extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ecswc_withholding_cancel";
    public static final String ENTITY_NAME = "ecswc_withholding_cancel";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_STATUSDOC = "statusDoc";
    public static final String PROPERTY_WITHHOLDINGDATE = "withholdingDate";
    public static final String PROPERTY_WITHHOLDINGDATECANCEL = "withholdingDateCancel";
    public static final String PROPERTY_KEYACCESS = "kEYAccess";
    public static final String PROPERTY_KEYACCESSAUTH = "kEYAccessAuth";
    public static final String PROPERTY_URLXML = "urlxml";
    public static final String PROPERTY_URLXMLRIDE = "urlxmlRide";
    public static final String PROPERTY_TOTALWITHHOLDINGVAT = "totalwithholdingvat";
    public static final String PROPERTY_TOTALWITHHOLDINGINCOME = "totalwithholdingincome";

    public withholdingcancel() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TOTALWITHHOLDINGVAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALWITHHOLDINGINCOME, new BigDecimal(0));
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getStatusDoc() {
        return (String) get(PROPERTY_STATUSDOC);
    }

    public void setStatusDoc(String statusDoc) {
        set(PROPERTY_STATUSDOC, statusDoc);
    }

    public Date getWithholdingDate() {
        return (Date) get(PROPERTY_WITHHOLDINGDATE);
    }

    public void setWithholdingDate(Date withholdingDate) {
        set(PROPERTY_WITHHOLDINGDATE, withholdingDate);
    }

    public Date getWithholdingDateCancel() {
        return (Date) get(PROPERTY_WITHHOLDINGDATECANCEL);
    }

    public void setWithholdingDateCancel(Date withholdingDateCancel) {
        set(PROPERTY_WITHHOLDINGDATECANCEL, withholdingDateCancel);
    }

    public String getKEYAccess() {
        return (String) get(PROPERTY_KEYACCESS);
    }

    public void setKEYAccess(String kEYAccess) {
        set(PROPERTY_KEYACCESS, kEYAccess);
    }

    public String getKEYAccessAuth() {
        return (String) get(PROPERTY_KEYACCESSAUTH);
    }

    public void setKEYAccessAuth(String kEYAccessAuth) {
        set(PROPERTY_KEYACCESSAUTH, kEYAccessAuth);
    }

    public String getUrlxml() {
        return (String) get(PROPERTY_URLXML);
    }

    public void setUrlxml(String urlxml) {
        set(PROPERTY_URLXML, urlxml);
    }

    public String getUrlxmlRide() {
        return (String) get(PROPERTY_URLXMLRIDE);
    }

    public void setUrlxmlRide(String urlxmlRide) {
        set(PROPERTY_URLXMLRIDE, urlxmlRide);
    }

    public BigDecimal getTotalwithholdingvat() {
        return (BigDecimal) get(PROPERTY_TOTALWITHHOLDINGVAT);
    }

    public void setTotalwithholdingvat(BigDecimal totalwithholdingvat) {
        set(PROPERTY_TOTALWITHHOLDINGVAT, totalwithholdingvat);
    }

    public BigDecimal getTotalwithholdingincome() {
        return (BigDecimal) get(PROPERTY_TOTALWITHHOLDINGINCOME);
    }

    public void setTotalwithholdingincome(BigDecimal totalwithholdingincome) {
        set(PROPERTY_TOTALWITHHOLDINGINCOME, totalwithholdingincome);
    }

}
