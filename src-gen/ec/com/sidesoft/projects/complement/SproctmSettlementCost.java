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
package ec.com.sidesoft.projects.complement;

import java.math.BigDecimal;
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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
/**
 * Entity class for entity sproctm_settlement_cost (stored in table sproctm_settlement_cost).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SproctmSettlementCost extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sproctm_settlement_cost";
    public static final String ENTITY_NAME = "sproctm_settlement_cost";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICETYPE = "invoiceType";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_PROJECTPHASE = "projectPhase";
    public static final String PROPERTY_PROJECTTASK = "projectTask";
    public static final String PROPERTY_ENDINGDATE = "endingDate";
    public static final String PROPERTY_TOTALMO = "totalMo";
    public static final String PROPERTY_TOTALCIF = "totalCif";
    public static final String PROPERTY_TOTALMAQ = "totalMaq";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_LOADLINES = "loadLines";
    public static final String PROPERTY_LIQUIDATE = "liquidate";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_SPROCTMSETTLCOSTLNLIST = "sproctmSettlCostLnList";

    public SproctmSettlementCost() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TOTALMO, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALCIF, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALMAQ, new BigDecimal(0));
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_LOADLINES, false);
        setDefaultValue(PROPERTY_LIQUIDATE, "N");
        setDefaultValue(PROPERTY_PROCESSED, true);
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_SPROCTMSETTLCOSTLNLIST, new ArrayList<Object>());
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

    public DocumentType getInvoiceType() {
        return (DocumentType) get(PROPERTY_INVOICETYPE);
    }

    public void setInvoiceType(DocumentType invoiceType) {
        set(PROPERTY_INVOICETYPE, invoiceType);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ProjectPhase getProjectPhase() {
        return (ProjectPhase) get(PROPERTY_PROJECTPHASE);
    }

    public void setProjectPhase(ProjectPhase projectPhase) {
        set(PROPERTY_PROJECTPHASE, projectPhase);
    }

    public ProjectTask getProjectTask() {
        return (ProjectTask) get(PROPERTY_PROJECTTASK);
    }

    public void setProjectTask(ProjectTask projectTask) {
        set(PROPERTY_PROJECTTASK, projectTask);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

    public BigDecimal getTotalMo() {
        return (BigDecimal) get(PROPERTY_TOTALMO);
    }

    public void setTotalMo(BigDecimal totalMo) {
        set(PROPERTY_TOTALMO, totalMo);
    }

    public BigDecimal getTotalCif() {
        return (BigDecimal) get(PROPERTY_TOTALCIF);
    }

    public void setTotalCif(BigDecimal totalCif) {
        set(PROPERTY_TOTALCIF, totalCif);
    }

    public BigDecimal getTotalMaq() {
        return (BigDecimal) get(PROPERTY_TOTALMAQ);
    }

    public void setTotalMaq(BigDecimal totalMaq) {
        set(PROPERTY_TOTALMAQ, totalMaq);
    }

    public String getAlertStatus() {
        return (String) get(PROPERTY_ALERTSTATUS);
    }

    public void setAlertStatus(String alertStatus) {
        set(PROPERTY_ALERTSTATUS, alertStatus);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public Boolean isLoadLines() {
        return (Boolean) get(PROPERTY_LOADLINES);
    }

    public void setLoadLines(Boolean loadLines) {
        set(PROPERTY_LOADLINES, loadLines);
    }

    public String getLiquidate() {
        return (String) get(PROPERTY_LIQUIDATE);
    }

    public void setLiquidate(String liquidate) {
        set(PROPERTY_LIQUIDATE, liquidate);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmSettlCostLn> getSproctmSettlCostLnList() {
      return (List<SproctmSettlCostLn>) get(PROPERTY_SPROCTMSETTLCOSTLNLIST);
    }

    public void setSproctmSettlCostLnList(List<SproctmSettlCostLn> sproctmSettlCostLnList) {
        set(PROPERTY_SPROCTMSETTLCOSTLNLIST, sproctmSettlCostLnList);
    }

}
