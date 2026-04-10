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
package ec.com.sidesoft.aftersale.machinery;

import com.atrums.indumoto.postventa.data.atindpo_postventa;

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
import org.openbravo.model.project.Project;
/**
 * Entity class for entity satmac_contract (stored in table satmac_contract).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Satmac_Contract extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "satmac_contract";
    public static final String ENTITY_NAME = "satmac_contract";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_TYPECONTRACT = "typeContract";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_MONTHS = "months";
    public static final String PROPERTY_ENDDATE = "endDate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_BTNPROCESS = "bTNProcess";
    public static final String PROPERTY_BTNREACTIVATE = "bTNReactivate";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_BTNLOADMACHINES = "bTNLoadMachines";
    public static final String PROPERTY_ATINDPOPOSTVENTAEMSATMACCONTRACTIDLIST = "atindpoPostventaEMSatmacContractIDList";
    public static final String PROPERTY_SATMACMACHINELIST = "satmacMachineList";

    public Satmac_Contract() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_BTNPROCESS, false);
        setDefaultValue(PROPERTY_BTNREACTIVATE, false);
        setDefaultValue(PROPERTY_PROCESSNOW, "N");
        setDefaultValue(PROPERTY_BTNLOADMACHINES, false);
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTAEMSATMACCONTRACTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SATMACMACHINELIST, new ArrayList<Object>());
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

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getTypeContract() {
        return (String) get(PROPERTY_TYPECONTRACT);
    }

    public void setTypeContract(String typeContract) {
        set(PROPERTY_TYPECONTRACT, typeContract);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Long getMonths() {
        return (Long) get(PROPERTY_MONTHS);
    }

    public void setMonths(Long months) {
        set(PROPERTY_MONTHS, months);
    }

    public Date getEndDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setEndDate(Date endDate) {
        set(PROPERTY_ENDDATE, endDate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Boolean isBTNProcess() {
        return (Boolean) get(PROPERTY_BTNPROCESS);
    }

    public void setBTNProcess(Boolean bTNProcess) {
        set(PROPERTY_BTNPROCESS, bTNProcess);
    }

    public Boolean isBTNReactivate() {
        return (Boolean) get(PROPERTY_BTNREACTIVATE);
    }

    public void setBTNReactivate(Boolean bTNReactivate) {
        set(PROPERTY_BTNREACTIVATE, bTNReactivate);
    }

    public String getProcessNow() {
        return (String) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(String processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isBTNLoadMachines() {
        return (Boolean) get(PROPERTY_BTNLOADMACHINES);
    }

    public void setBTNLoadMachines(Boolean bTNLoadMachines) {
        set(PROPERTY_BTNLOADMACHINES, bTNLoadMachines);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventa> getAtindpoPostventaEMSatmacContractIDList() {
      return (List<atindpo_postventa>) get(PROPERTY_ATINDPOPOSTVENTAEMSATMACCONTRACTIDLIST);
    }

    public void setAtindpoPostventaEMSatmacContractIDList(List<atindpo_postventa> atindpoPostventaEMSatmacContractIDList) {
        set(PROPERTY_ATINDPOPOSTVENTAEMSATMACCONTRACTIDLIST, atindpoPostventaEMSatmacContractIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Satmac_Machine> getSatmacMachineList() {
      return (List<Satmac_Machine>) get(PROPERTY_SATMACMACHINELIST);
    }

    public void setSatmacMachineList(List<Satmac_Machine> satmacMachineList) {
        set(PROPERTY_SATMACMACHINELIST, satmacMachineList);
    }

}
