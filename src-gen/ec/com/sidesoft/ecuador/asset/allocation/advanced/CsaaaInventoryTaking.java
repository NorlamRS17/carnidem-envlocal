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
package ec.com.sidesoft.ecuador.asset.allocation.advanced;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
/**
 * Entity class for entity csaaa_inventory_taking (stored in table csaaa_inventory_taking).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class CsaaaInventoryTaking extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "csaaa_inventory_taking";
    public static final String ENTITY_NAME = "csaaa_inventory_taking";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_DOCUMENTNO = "documentno";
    public static final String PROPERTY_CUSTODIUM = "custodium";
    public static final String PROPERTY_DATEINVTAK = "dateInvTak";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_BARCADE = "barcade";
    public static final String PROPERTY_LOADACTIVES = "loadActives";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_RECONCILE = "reconcile";
    public static final String PROPERTY_SCANASSETS = "scanAssets";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_CSAAAINVTTKGLINELIST = "csaaaInvtTkgLineList";

    public CsaaaInventoryTaking() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_LOADACTIVES, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_RECONCILE, false);
        setDefaultValue(PROPERTY_STATUS, false);
        setDefaultValue(PROPERTY_CSAAAINVTTKGLINELIST, new ArrayList<Object>());
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

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public String getDocumentno() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentno(String documentno) {
        set(PROPERTY_DOCUMENTNO, documentno);
    }

    public BusinessPartner getCustodium() {
        return (BusinessPartner) get(PROPERTY_CUSTODIUM);
    }

    public void setCustodium(BusinessPartner custodium) {
        set(PROPERTY_CUSTODIUM, custodium);
    }

    public Date getDateInvTak() {
        return (Date) get(PROPERTY_DATEINVTAK);
    }

    public void setDateInvTak(Date dateInvTak) {
        set(PROPERTY_DATEINVTAK, dateInvTak);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getBarcade() {
        return (String) get(PROPERTY_BARCADE);
    }

    public void setBarcade(String barcade) {
        set(PROPERTY_BARCADE, barcade);
    }

    public Boolean isLoadActives() {
        return (Boolean) get(PROPERTY_LOADACTIVES);
    }

    public void setLoadActives(Boolean loadActives) {
        set(PROPERTY_LOADACTIVES, loadActives);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isReconcile() {
        return (Boolean) get(PROPERTY_RECONCILE);
    }

    public void setReconcile(Boolean reconcile) {
        set(PROPERTY_RECONCILE, reconcile);
    }

    public String getScanAssets() {
        return (String) get(PROPERTY_SCANASSETS);
    }

    public void setScanAssets(String scanAssets) {
        set(PROPERTY_SCANASSETS, scanAssets);
    }

    public Boolean isStatus() {
        return (Boolean) get(PROPERTY_STATUS);
    }

    public void setStatus(Boolean status) {
        set(PROPERTY_STATUS, status);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTakingLine> getCsaaaInvtTkgLineList() {
      return (List<CsaaaInventoryTakingLine>) get(PROPERTY_CSAAAINVTTKGLINELIST);
    }

    public void setCsaaaInvtTkgLineList(List<CsaaaInventoryTakingLine> csaaaInvtTkgLineList) {
        set(PROPERTY_CSAAAINVTTKGLINELIST, csaaaInvtTkgLineList);
    }

}
