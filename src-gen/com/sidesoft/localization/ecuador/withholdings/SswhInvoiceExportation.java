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
package com.sidesoft.localization.ecuador.withholdings;

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
 * Entity class for entity sswh_inv_exportation (stored in table sswh_inv_exportation).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SswhInvoiceExportation extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sswh_inv_exportation";
    public static final String ENTITY_NAME = "sswh_inv_exportation";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_CLIENTTYPE = "clientType";
    public static final String PROPERTY_CLIENTIDENTIF = "clientIdentif";
    public static final String PROPERTY_RELATIONPART = "relationPart";
    public static final String PROPERTY_IDENTIFIERTYPE = "identifierType";
    public static final String PROPERTY_DENOCLI = "denoCli";
    public static final String PROPERTY_CLIENTNAME = "clientName";
    public static final String PROPERTY_REGIMENTYPE = "regimenType";
    public static final String PROPERTY_EFECPAYMGENERAL = "efecPaymGeneral";
    public static final String PROPERTY_EXPORTFROM = "exportFrom";
    public static final String PROPERTY_TYPEINGEXT = "typeIngExt";
    public static final String PROPERTY_INGEXTGRAVOTHCOUNTRY = "iNGExtGravOthCountry";
    public static final String PROPERTY_VOUCHERTYPE = "voucherType";
    public static final String PROPERTY_SHIPPINGDATE = "shippingDate";
    public static final String PROPERTY_VALUEFOB = "valueFob";
    public static final String PROPERTY_VALUEFOBCOMPROBANTE = "valueFobComprobante";
    public static final String PROPERTY_ESTABLISHMENT = "establishment";
    public static final String PROPERTY_POINTEMISION = "pointEmision";
    public static final String PROPERTY_SECUENCE = "secuence";
    public static final String PROPERTY_INVAUTHORIZATION = "iNVAuthorization";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_COUNTRYPAYMENT = "countryPayment";

    public SswhInvoiceExportation() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_POSTED, "N");
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public String getClientType() {
        return (String) get(PROPERTY_CLIENTTYPE);
    }

    public void setClientType(String clientType) {
        set(PROPERTY_CLIENTTYPE, clientType);
    }

    public String getClientIdentif() {
        return (String) get(PROPERTY_CLIENTIDENTIF);
    }

    public void setClientIdentif(String clientIdentif) {
        set(PROPERTY_CLIENTIDENTIF, clientIdentif);
    }

    public String getRelationPart() {
        return (String) get(PROPERTY_RELATIONPART);
    }

    public void setRelationPart(String relationPart) {
        set(PROPERTY_RELATIONPART, relationPart);
    }

    public String getIdentifierType() {
        return (String) get(PROPERTY_IDENTIFIERTYPE);
    }

    public void setIdentifierType(String identifierType) {
        set(PROPERTY_IDENTIFIERTYPE, identifierType);
    }

    public String getDenoCli() {
        return (String) get(PROPERTY_DENOCLI);
    }

    public void setDenoCli(String denoCli) {
        set(PROPERTY_DENOCLI, denoCli);
    }

    public String getClientName() {
        return (String) get(PROPERTY_CLIENTNAME);
    }

    public void setClientName(String clientName) {
        set(PROPERTY_CLIENTNAME, clientName);
    }

    public String getRegimenType() {
        return (String) get(PROPERTY_REGIMENTYPE);
    }

    public void setRegimenType(String regimenType) {
        set(PROPERTY_REGIMENTYPE, regimenType);
    }

    public String getEfecPaymGeneral() {
        return (String) get(PROPERTY_EFECPAYMGENERAL);
    }

    public void setEfecPaymGeneral(String efecPaymGeneral) {
        set(PROPERTY_EFECPAYMGENERAL, efecPaymGeneral);
    }

    public String getExportFrom() {
        return (String) get(PROPERTY_EXPORTFROM);
    }

    public void setExportFrom(String exportFrom) {
        set(PROPERTY_EXPORTFROM, exportFrom);
    }

    public String getTypeIngExt() {
        return (String) get(PROPERTY_TYPEINGEXT);
    }

    public void setTypeIngExt(String typeIngExt) {
        set(PROPERTY_TYPEINGEXT, typeIngExt);
    }

    public String getINGExtGravOthCountry() {
        return (String) get(PROPERTY_INGEXTGRAVOTHCOUNTRY);
    }

    public void setINGExtGravOthCountry(String iNGExtGravOthCountry) {
        set(PROPERTY_INGEXTGRAVOTHCOUNTRY, iNGExtGravOthCountry);
    }

    public String getVoucherType() {
        return (String) get(PROPERTY_VOUCHERTYPE);
    }

    public void setVoucherType(String voucherType) {
        set(PROPERTY_VOUCHERTYPE, voucherType);
    }

    public Date getShippingDate() {
        return (Date) get(PROPERTY_SHIPPINGDATE);
    }

    public void setShippingDate(Date shippingDate) {
        set(PROPERTY_SHIPPINGDATE, shippingDate);
    }

    public String getValueFob() {
        return (String) get(PROPERTY_VALUEFOB);
    }

    public void setValueFob(String valueFob) {
        set(PROPERTY_VALUEFOB, valueFob);
    }

    public String getValueFobComprobante() {
        return (String) get(PROPERTY_VALUEFOBCOMPROBANTE);
    }

    public void setValueFobComprobante(String valueFobComprobante) {
        set(PROPERTY_VALUEFOBCOMPROBANTE, valueFobComprobante);
    }

    public String getEstablishment() {
        return (String) get(PROPERTY_ESTABLISHMENT);
    }

    public void setEstablishment(String establishment) {
        set(PROPERTY_ESTABLISHMENT, establishment);
    }

    public String getPointEmision() {
        return (String) get(PROPERTY_POINTEMISION);
    }

    public void setPointEmision(String pointEmision) {
        set(PROPERTY_POINTEMISION, pointEmision);
    }

    public String getSecuence() {
        return (String) get(PROPERTY_SECUENCE);
    }

    public void setSecuence(String secuence) {
        set(PROPERTY_SECUENCE, secuence);
    }

    public String getINVAuthorization() {
        return (String) get(PROPERTY_INVAUTHORIZATION);
    }

    public void setINVAuthorization(String iNVAuthorization) {
        set(PROPERTY_INVAUTHORIZATION, iNVAuthorization);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

    public String getCountryPayment() {
        return (String) get(PROPERTY_COUNTRYPAYMENT);
    }

    public void setCountryPayment(String countryPayment) {
        set(PROPERTY_COUNTRYPAYMENT, countryPayment);
    }

}
