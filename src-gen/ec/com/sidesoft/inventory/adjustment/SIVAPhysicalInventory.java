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
package ec.com.sidesoft.inventory.adjustment;

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
 * Entity class for entity SIVA_Physical_Inventory (stored in table SIVA_Physical_Inventory).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SIVAPhysicalInventory extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SIVA_Physical_Inventory";
    public static final String ENTITY_NAME = "SIVA_Physical_Inventory";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_MOVEMENTDATE = "movementDate";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_WAREHOUSE = "warehouse";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_GENERATECODE = "generateCode";
    public static final String PROPERTY_CODEAUTHORIZATION = "codeAuthorization";
    public static final String PROPERTY_CREATECODEDATE = "createcodedate";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_COSTCENTER = "costCenter";
    public static final String PROPERTY_SIVAPHYSICALINVTLINESLIST = "sIVAPhysicalInvtlinesList";

    public SIVAPhysicalInventory() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_GENERATECODE, "N");
        setDefaultValue(PROPERTY_PROCESS, false);
        setDefaultValue(PROPERTY_SIVAPHYSICALINVTLINESLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
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

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public String getGenerateCode() {
        return (String) get(PROPERTY_GENERATECODE);
    }

    public void setGenerateCode(String generateCode) {
        set(PROPERTY_GENERATECODE, generateCode);
    }

    public String getCodeAuthorization() {
        return (String) get(PROPERTY_CODEAUTHORIZATION);
    }

    public void setCodeAuthorization(String codeAuthorization) {
        set(PROPERTY_CODEAUTHORIZATION, codeAuthorization);
    }

    public Date getCreatecodedate() {
        return (Date) get(PROPERTY_CREATECODEDATE);
    }

    public void setCreatecodedate(Date createcodedate) {
        set(PROPERTY_CREATECODEDATE, createcodedate);
    }

    public Boolean isProcess() {
        return (Boolean) get(PROPERTY_PROCESS);
    }

    public void setProcess(Boolean process) {
        set(PROPERTY_PROCESS, process);
    }

    public Costcenter getCostCenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostCenter(Costcenter costCenter) {
        set(PROPERTY_COSTCENTER, costCenter);
    }

    @SuppressWarnings("unchecked")
    public List<SIVAPhysicalInvtlines> getSIVAPhysicalInvtlinesList() {
      return (List<SIVAPhysicalInvtlines>) get(PROPERTY_SIVAPHYSICALINVTLINESLIST);
    }

    public void setSIVAPhysicalInvtlinesList(List<SIVAPhysicalInvtlines> sIVAPhysicalInvtlinesList) {
        set(PROPERTY_SIVAPHYSICALINVTLINESLIST, sIVAPhysicalInvtlinesList);
    }

}
