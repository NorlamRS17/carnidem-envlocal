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
package ec.com.sidesoft.imports.consolidation;

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
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
/**
 * Entity class for entity ssimpcn_imp_consolidation (stored in table ssimpcn_imp_consolidation).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Ssimpcn_ImpConsolidation extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssimpcn_imp_consolidation";
    public static final String ENTITY_NAME = "ssimpcn_imp_consolidation";
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
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_BTNCHARGECOSTS = "bTNChargeCosts";
    public static final String PROPERTY_BTNPROCESS = "bTNProcess";
    public static final String PROPERTY_BTNREACTIVATE = "bTNReactivate";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSSIMPCNASSOCIATEDCONSOLIDATIONLIST = "financialMgmtGLJournalLineEMSSIMPCNAssociatedConsolidationList";
    public static final String PROPERTY_INVOICELINEEMSSIMPCNIMPCONSOLIDLIST = "invoiceLineEMSsimpcnImpConsolIDList";
    public static final String PROPERTY_SSIMPCNIMPCONSOLLINELIST = "ssimpcnImpConsolLineList";
    public static final String PROPERTY_SSIMPCNIMPORTATIONCOSTLIST = "ssimpcnImportationCostList";

    public Ssimpcn_ImpConsolidation() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_BTNCHARGECOSTS, false);
        setDefaultValue(PROPERTY_BTNPROCESS, false);
        setDefaultValue(PROPERTY_BTNREACTIVATE, false);
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSSIMPCNASSOCIATEDCONSOLIDATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSIMPCNIMPCONSOLIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPCONSOLLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST, new ArrayList<Object>());
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

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isBTNChargeCosts() {
        return (Boolean) get(PROPERTY_BTNCHARGECOSTS);
    }

    public void setBTNChargeCosts(Boolean bTNChargeCosts) {
        set(PROPERTY_BTNCHARGECOSTS, bTNChargeCosts);
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

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineEMSSIMPCNAssociatedConsolidationList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSSIMPCNASSOCIATEDCONSOLIDATIONLIST);
    }

    public void setFinancialMgmtGLJournalLineEMSSIMPCNAssociatedConsolidationList(List<GLJournalLine> financialMgmtGLJournalLineEMSSIMPCNAssociatedConsolidationList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINEEMSSIMPCNASSOCIATEDCONSOLIDATIONLIST, financialMgmtGLJournalLineEMSSIMPCNAssociatedConsolidationList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsimpcnImpConsolIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSIMPCNIMPCONSOLIDLIST);
    }

    public void setInvoiceLineEMSsimpcnImpConsolIDList(List<InvoiceLine> invoiceLineEMSsimpcnImpConsolIDList) {
        set(PROPERTY_INVOICELINEEMSSIMPCNIMPCONSOLIDLIST, invoiceLineEMSsimpcnImpConsolIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImpConsolLine> getSsimpcnImpConsolLineList() {
      return (List<Ssimpcn_ImpConsolLine>) get(PROPERTY_SSIMPCNIMPCONSOLLINELIST);
    }

    public void setSsimpcnImpConsolLineList(List<Ssimpcn_ImpConsolLine> ssimpcnImpConsolLineList) {
        set(PROPERTY_SSIMPCNIMPCONSOLLINELIST, ssimpcnImpConsolLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImportationCost> getSsimpcnImportationCostList() {
      return (List<Ssimpcn_ImportationCost>) get(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST);
    }

    public void setSsimpcnImportationCostList(List<Ssimpcn_ImportationCost> ssimpcnImportationCostList) {
        set(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST, ssimpcnImportationCostList);
    }

}
