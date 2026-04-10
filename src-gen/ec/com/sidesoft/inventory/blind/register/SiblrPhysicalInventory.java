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
package ec.com.sidesoft.inventory.blind.register;

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
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
/**
 * Entity class for entity Siblr_Physical_Inventory (stored in table Siblr_Physical_Inventory).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SiblrPhysicalInventory extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Siblr_Physical_Inventory";
    public static final String ENTITY_NAME = "Siblr_Physical_Inventory";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_COMMERCIALNAME = "commercialName";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_ACTIONCREATELINES = "actioncreatelines";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_NEWDOCACTION = "nEWDocaction";
    public static final String PROPERTY_ISPRINT = "isprint";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_SIBLRCOLLABORATORSLIST = "siblrCollaboratorsList";
    public static final String PROPERTY_SIBLRPHYSICALINVTLINESLIST = "siblrPhysicalInvtLinesList";

    public SiblrPhysicalInventory() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_ACTIONCREATELINES, false);
        setDefaultValue(PROPERTY_NEWDOCACTION, "ND");
        setDefaultValue(PROPERTY_ISPRINT, false);
        setDefaultValue(PROPERTY_SIBLRCOLLABORATORSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIBLRPHYSICALINVTLINESLIST, new ArrayList<Object>());
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

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getCommercialName() {
        return (String) get(PROPERTY_COMMERCIALNAME);
    }

    public void setCommercialName(String commercialName) {
        set(PROPERTY_COMMERCIALNAME, commercialName);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public Date getMovementDate() {
        return (Date) get(PROPERTY_MOVEMENTDATE);
    }

    public void setMovementDate(Date movementDate) {
        set(PROPERTY_MOVEMENTDATE, movementDate);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Warehouse getWarehouse() {
        return (Warehouse) get(PROPERTY_WAREHOUSE);
    }

    public void setWarehouse(Warehouse warehouse) {
        set(PROPERTY_WAREHOUSE, warehouse);
    }

    public Boolean isActioncreatelines() {
        return (Boolean) get(PROPERTY_ACTIONCREATELINES);
    }

    public void setActioncreatelines(Boolean actioncreatelines) {
        set(PROPERTY_ACTIONCREATELINES, actioncreatelines);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public String getNEWDocaction() {
        return (String) get(PROPERTY_NEWDOCACTION);
    }

    public void setNEWDocaction(String nEWDocaction) {
        set(PROPERTY_NEWDOCACTION, nEWDocaction);
    }

    public Boolean isPrint() {
        return (Boolean) get(PROPERTY_ISPRINT);
    }

    public void setPrint(Boolean isprint) {
        set(PROPERTY_ISPRINT, isprint);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    @SuppressWarnings("unchecked")
    public List<SiblrCollaborators> getSiblrCollaboratorsList() {
      return (List<SiblrCollaborators>) get(PROPERTY_SIBLRCOLLABORATORSLIST);
    }

    public void setSiblrCollaboratorsList(List<SiblrCollaborators> siblrCollaboratorsList) {
        set(PROPERTY_SIBLRCOLLABORATORSLIST, siblrCollaboratorsList);
    }

    @SuppressWarnings("unchecked")
    public List<SiblrPhysicalInvtLines> getSiblrPhysicalInvtLinesList() {
      return (List<SiblrPhysicalInvtLines>) get(PROPERTY_SIBLRPHYSICALINVTLINESLIST);
    }

    public void setSiblrPhysicalInvtLinesList(List<SiblrPhysicalInvtLines> siblrPhysicalInvtLinesList) {
        set(PROPERTY_SIBLRPHYSICALINVTLINESLIST, siblrPhysicalInvtLinesList);
    }

}
