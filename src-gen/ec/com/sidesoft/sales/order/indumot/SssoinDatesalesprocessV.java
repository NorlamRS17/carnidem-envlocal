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
package ec.com.sidesoft.sales.order.indumot;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
/**
 * Entity class for entity sssoin_datesalesprocess_v (stored in table sssoin_datesalesprocess_v).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SssoinDatesalesprocessV extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sssoin_datesalesprocess_v";
    public static final String ENTITY_NAME = "sssoin_datesalesprocess_v";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_DOCTYPETARGET = "doctypetarget";
    public static final String PROPERTY_ORDDOCMENTNO = "orddocmentno";
    public static final String PROPERTY_ORDDATE = "orddate";
    public static final String PROPERTY_ORDDISCREQ = "orddiscreq";
    public static final String PROPERTY_ORDDISCAPP = "orddiscapp";
    public static final String PROPERTY_ORDCREDREQ = "ordcredreq";
    public static final String PROPERTY_ORDCREDAPP = "ordcredapp";
    public static final String PROPERTY_ORDCOMPLETE = "ordcomplete";
    public static final String PROPERTY_INVDOCUMENTNO = "invdocumentno";
    public static final String PROPERTY_INVDATE = "invdate";
    public static final String PROPERTY_INVCOMPLETE = "invcomplete";
    public static final String PROPERTY_ALBDOCUMENTNO = "albdocumentno";
    public static final String PROPERTY_ALBDATE = "albdate";
    public static final String PROPERTY_MIOCOMPLETE = "miocomplete";
    public static final String PROPERTY_DELIVERYCONFIRM = "deliveryconfirm";

    public SssoinDatesalesprocessV() {
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

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
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

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public DocumentType getDoctypetarget() {
        return (DocumentType) get(PROPERTY_DOCTYPETARGET);
    }

    public void setDoctypetarget(DocumentType doctypetarget) {
        set(PROPERTY_DOCTYPETARGET, doctypetarget);
    }

    public String getOrddocmentno() {
        return (String) get(PROPERTY_ORDDOCMENTNO);
    }

    public void setOrddocmentno(String orddocmentno) {
        set(PROPERTY_ORDDOCMENTNO, orddocmentno);
    }

    public Date getOrddate() {
        return (Date) get(PROPERTY_ORDDATE);
    }

    public void setOrddate(Date orddate) {
        set(PROPERTY_ORDDATE, orddate);
    }

    public Date getOrddiscreq() {
        return (Date) get(PROPERTY_ORDDISCREQ);
    }

    public void setOrddiscreq(Date orddiscreq) {
        set(PROPERTY_ORDDISCREQ, orddiscreq);
    }

    public Date getOrddiscapp() {
        return (Date) get(PROPERTY_ORDDISCAPP);
    }

    public void setOrddiscapp(Date orddiscapp) {
        set(PROPERTY_ORDDISCAPP, orddiscapp);
    }

    public Date getOrdcredreq() {
        return (Date) get(PROPERTY_ORDCREDREQ);
    }

    public void setOrdcredreq(Date ordcredreq) {
        set(PROPERTY_ORDCREDREQ, ordcredreq);
    }

    public Date getOrdcredapp() {
        return (Date) get(PROPERTY_ORDCREDAPP);
    }

    public void setOrdcredapp(Date ordcredapp) {
        set(PROPERTY_ORDCREDAPP, ordcredapp);
    }

    public Date getOrdcomplete() {
        return (Date) get(PROPERTY_ORDCOMPLETE);
    }

    public void setOrdcomplete(Date ordcomplete) {
        set(PROPERTY_ORDCOMPLETE, ordcomplete);
    }

    public String getInvdocumentno() {
        return (String) get(PROPERTY_INVDOCUMENTNO);
    }

    public void setInvdocumentno(String invdocumentno) {
        set(PROPERTY_INVDOCUMENTNO, invdocumentno);
    }

    public Date getInvdate() {
        return (Date) get(PROPERTY_INVDATE);
    }

    public void setInvdate(Date invdate) {
        set(PROPERTY_INVDATE, invdate);
    }

    public Date getInvcomplete() {
        return (Date) get(PROPERTY_INVCOMPLETE);
    }

    public void setInvcomplete(Date invcomplete) {
        set(PROPERTY_INVCOMPLETE, invcomplete);
    }

    public String getAlbdocumentno() {
        return (String) get(PROPERTY_ALBDOCUMENTNO);
    }

    public void setAlbdocumentno(String albdocumentno) {
        set(PROPERTY_ALBDOCUMENTNO, albdocumentno);
    }

    public Date getAlbdate() {
        return (Date) get(PROPERTY_ALBDATE);
    }

    public void setAlbdate(Date albdate) {
        set(PROPERTY_ALBDATE, albdate);
    }

    public Date getMiocomplete() {
        return (Date) get(PROPERTY_MIOCOMPLETE);
    }

    public void setMiocomplete(Date miocomplete) {
        set(PROPERTY_MIOCOMPLETE, miocomplete);
    }

    public Date getDeliveryconfirm() {
        return (Date) get(PROPERTY_DELIVERYCONFIRM);
    }

    public void setDeliveryconfirm(Date deliveryconfirm) {
        set(PROPERTY_DELIVERYCONFIRM, deliveryconfirm);
    }

}
