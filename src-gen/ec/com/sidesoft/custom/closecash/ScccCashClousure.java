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
package ec.com.sidesoft.custom.closecash;

import ec.com.sidesoft.closecash.sales.order.SsccsoCashIncExp;
import ec.com.sidesoft.custom.closecash.advanced.SccaCashClousureline2;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
/**
 * Entity class for entity Sccc_Cash_Closure (stored in table sccc_cash_clousure).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScccCashClousure extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sccc_cash_clousure";
    public static final String ENTITY_NAME = "Sccc_Cash_Closure";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_CLOSINGDATE = "closingdate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_TOTALINCOME = "totalincome";
    public static final String PROPERTY_TOTALEXPENSES = "totalexpenses";
    public static final String PROPERTY_TOTALSALES = "totalsales";
    public static final String PROPERTY_LOADLINES = "loadLines";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DIFFERENCE = "difference";
    public static final String PROPERTY_RECORD = "record";
    public static final String PROPERTY_SCCCSETUP = "scccSetup";
    public static final String PROPERTY_SSCCCINTOGGLEDOCSTATUS = "sscccinToggledocstatus";
    public static final String PROPERTY_SSCCCINPROCESSED = "sscccinProcessed";
    public static final String PROPERTY_SSCCCINPROCESING = "sscccinProcesing";
    public static final String PROPERTY_PROCESSDATE = "processDate";
    public static final String PROPERTY_UNPROCESS = "unprocess";
    public static final String PROPERTY_FINFINACCTRANSACTIONEMSCCCCASHCLOUSUREIDLIST = "fINFinaccTransactionEMScccCashClousureIDList";
    public static final String PROPERTY_SCCCCASHCLOUSURELINELIST = "scccCashClousurelineList";
    public static final String PROPERTY_SSCCSOCASHINCEXPLIST = "ssccsoCashIncExpList";
    public static final String PROPERTY_SCCACASHCLOUSURELINE2LIST = "sccaCashClousureline2List";

    public ScccCashClousure() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_TOTALINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALEXPENSES, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALSALES, new BigDecimal(0));
        setDefaultValue(PROPERTY_LOADLINES, "SCCC_LL");
        setDefaultValue(PROPERTY_PROCESS, "PR");
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_DIFFERENCE, new BigDecimal(0));
        setDefaultValue(PROPERTY_RECORD, "SCCC_RE");
        setDefaultValue(PROPERTY_SSCCCINTOGGLEDOCSTATUS, "R");
        setDefaultValue(PROPERTY_SSCCCINPROCESSED, false);
        setDefaultValue(PROPERTY_SSCCCINPROCESING, false);
        setDefaultValue(PROPERTY_UNPROCESS, false);
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONEMSCCCCASHCLOUSUREIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCCASHCLOUSURELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOCASHINCEXPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCACASHCLOUSURELINE2LIST, new ArrayList<Object>());
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

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Date getClosingdate() {
        return (Date) get(PROPERTY_CLOSINGDATE);
    }

    public void setClosingdate(Date closingdate) {
        set(PROPERTY_CLOSINGDATE, closingdate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public BigDecimal getTotalincome() {
        return (BigDecimal) get(PROPERTY_TOTALINCOME);
    }

    public void setTotalincome(BigDecimal totalincome) {
        set(PROPERTY_TOTALINCOME, totalincome);
    }

    public BigDecimal getTotalexpenses() {
        return (BigDecimal) get(PROPERTY_TOTALEXPENSES);
    }

    public void setTotalexpenses(BigDecimal totalexpenses) {
        set(PROPERTY_TOTALEXPENSES, totalexpenses);
    }

    public BigDecimal getTotalsales() {
        return (BigDecimal) get(PROPERTY_TOTALSALES);
    }

    public void setTotalsales(BigDecimal totalsales) {
        set(PROPERTY_TOTALSALES, totalsales);
    }

    public String getLoadLines() {
        return (String) get(PROPERTY_LOADLINES);
    }

    public void setLoadLines(String loadLines) {
        set(PROPERTY_LOADLINES, loadLines);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public BigDecimal getDifference() {
        return (BigDecimal) get(PROPERTY_DIFFERENCE);
    }

    public void setDifference(BigDecimal difference) {
        set(PROPERTY_DIFFERENCE, difference);
    }

    public String getRecord() {
        return (String) get(PROPERTY_RECORD);
    }

    public void setRecord(String record) {
        set(PROPERTY_RECORD, record);
    }

    public ScccSetup getScccSetup() {
        return (ScccSetup) get(PROPERTY_SCCCSETUP);
    }

    public void setScccSetup(ScccSetup scccSetup) {
        set(PROPERTY_SCCCSETUP, scccSetup);
    }

    public String getSscccinToggledocstatus() {
        return (String) get(PROPERTY_SSCCCINTOGGLEDOCSTATUS);
    }

    public void setSscccinToggledocstatus(String sscccinToggledocstatus) {
        set(PROPERTY_SSCCCINTOGGLEDOCSTATUS, sscccinToggledocstatus);
    }

    public Boolean isSscccinProcessed() {
        return (Boolean) get(PROPERTY_SSCCCINPROCESSED);
    }

    public void setSscccinProcessed(Boolean sscccinProcessed) {
        set(PROPERTY_SSCCCINPROCESSED, sscccinProcessed);
    }

    public Boolean isSscccinProcesing() {
        return (Boolean) get(PROPERTY_SSCCCINPROCESING);
    }

    public void setSscccinProcesing(Boolean sscccinProcesing) {
        set(PROPERTY_SSCCCINPROCESING, sscccinProcesing);
    }

    public Date getProcessDate() {
        return (Date) get(PROPERTY_PROCESSDATE);
    }

    public void setProcessDate(Date processDate) {
        set(PROPERTY_PROCESSDATE, processDate);
    }

    public Boolean isUnprocess() {
        return (Boolean) get(PROPERTY_UNPROCESS);
    }

    public void setUnprocess(Boolean unprocess) {
        set(PROPERTY_UNPROCESS, unprocess);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionEMScccCashClousureIDList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONEMSCCCCASHCLOUSUREIDLIST);
    }

    public void setFINFinaccTransactionEMScccCashClousureIDList(List<FIN_FinaccTransaction> fINFinaccTransactionEMScccCashClousureIDList) {
        set(PROPERTY_FINFINACCTRANSACTIONEMSCCCCASHCLOUSUREIDLIST, fINFinaccTransactionEMScccCashClousureIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccCashClousureline> getScccCashClousurelineList() {
      return (List<ScccCashClousureline>) get(PROPERTY_SCCCCASHCLOUSURELINELIST);
    }

    public void setScccCashClousurelineList(List<ScccCashClousureline> scccCashClousurelineList) {
        set(PROPERTY_SCCCCASHCLOUSURELINELIST, scccCashClousurelineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoCashIncExp> getSsccsoCashIncExpList() {
      return (List<SsccsoCashIncExp>) get(PROPERTY_SSCCSOCASHINCEXPLIST);
    }

    public void setSsccsoCashIncExpList(List<SsccsoCashIncExp> ssccsoCashIncExpList) {
        set(PROPERTY_SSCCSOCASHINCEXPLIST, ssccsoCashIncExpList);
    }

    @SuppressWarnings("unchecked")
    public List<SccaCashClousureline2> getSccaCashClousureline2List() {
      return (List<SccaCashClousureline2>) get(PROPERTY_SCCACASHCLOUSURELINE2LIST);
    }

    public void setSccaCashClousureline2List(List<SccaCashClousureline2> sccaCashClousureline2List) {
        set(PROPERTY_SCCACASHCLOUSURELINE2LIST, sccaCashClousureline2List);
    }

}
