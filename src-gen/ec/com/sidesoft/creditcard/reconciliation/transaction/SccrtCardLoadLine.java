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
package ec.com.sidesoft.creditcard.reconciliation.transaction;

import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRec;

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
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
/**
 * Entity class for entity sccrt_card_load_line (stored in table sccrt_card_load_line).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SccrtCardLoadLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sccrt_card_load_line";
    public static final String ENTITY_NAME = "sccrt_card_load_line";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEDEPOSIT = "dateDeposit";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_RECAP = "recap";
    public static final String PROPERTY_ACCREDITVALUE = "accreditValue";
    public static final String PROPERTY_COMMISIONVALUE = "commisionValue";
    public static final String PROPERTY_WITHHRENT = "withhRent";
    public static final String PROPERTY_WITHHIVA = "withhIva";
    public static final String PROPERTY_DEPOSITREFERENCE = "depositReference";
    public static final String PROPERTY_FINFINACCTRANSSACTION = "fINFinaccTranssaction";
    public static final String PROPERTY_SCCRTCARDLOADTRANSACTION = "sccrtCardLoadTransaction";
    public static final String PROPERTY_SETTLED = "settled";
    public static final String PROPERTY_IVA = "iva";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_TEXTCOSTCENTER = "textcostcenter";
    public static final String PROPERTY_TEXTUSER = "textuser";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_ISERROR = "iserror";
    public static final String PROPERTY_GROUPINGBATCH = "groupingBatch";
    public static final String PROPERTY_POSCARDRECONCILIATION = "pOSCardReconciliation";
    public static final String PROPERTY_LOGERROR = "lOGError";

    public SccrtCardLoadLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ACCREDITVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_COMMISIONVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_WITHHRENT, new BigDecimal(0));
        setDefaultValue(PROPERTY_WITHHIVA, new BigDecimal(0));
        setDefaultValue(PROPERTY_SETTLED, false);
        setDefaultValue(PROPERTY_IVA, new BigDecimal(0));
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISERROR, false);
        setDefaultValue(PROPERTY_GROUPINGBATCH, "'");
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

    public Date getDateDeposit() {
        return (Date) get(PROPERTY_DATEDEPOSIT);
    }

    public void setDateDeposit(Date dateDeposit) {
        set(PROPERTY_DATEDEPOSIT, dateDeposit);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public String getRecap() {
        return (String) get(PROPERTY_RECAP);
    }

    public void setRecap(String recap) {
        set(PROPERTY_RECAP, recap);
    }

    public BigDecimal getAccreditValue() {
        return (BigDecimal) get(PROPERTY_ACCREDITVALUE);
    }

    public void setAccreditValue(BigDecimal accreditValue) {
        set(PROPERTY_ACCREDITVALUE, accreditValue);
    }

    public BigDecimal getCommisionValue() {
        return (BigDecimal) get(PROPERTY_COMMISIONVALUE);
    }

    public void setCommisionValue(BigDecimal commisionValue) {
        set(PROPERTY_COMMISIONVALUE, commisionValue);
    }

    public BigDecimal getWithhRent() {
        return (BigDecimal) get(PROPERTY_WITHHRENT);
    }

    public void setWithhRent(BigDecimal withhRent) {
        set(PROPERTY_WITHHRENT, withhRent);
    }

    public BigDecimal getWithhIva() {
        return (BigDecimal) get(PROPERTY_WITHHIVA);
    }

    public void setWithhIva(BigDecimal withhIva) {
        set(PROPERTY_WITHHIVA, withhIva);
    }

    public String getDepositReference() {
        return (String) get(PROPERTY_DEPOSITREFERENCE);
    }

    public void setDepositReference(String depositReference) {
        set(PROPERTY_DEPOSITREFERENCE, depositReference);
    }

    public FIN_FinaccTransaction getFINFinaccTranssaction() {
        return (FIN_FinaccTransaction) get(PROPERTY_FINFINACCTRANSSACTION);
    }

    public void setFINFinaccTranssaction(FIN_FinaccTransaction fINFinaccTranssaction) {
        set(PROPERTY_FINFINACCTRANSSACTION, fINFinaccTranssaction);
    }

    public SccrtCardLoadTransaction getSccrtCardLoadTransaction() {
        return (SccrtCardLoadTransaction) get(PROPERTY_SCCRTCARDLOADTRANSACTION);
    }

    public void setSccrtCardLoadTransaction(SccrtCardLoadTransaction sccrtCardLoadTransaction) {
        set(PROPERTY_SCCRTCARDLOADTRANSACTION, sccrtCardLoadTransaction);
    }

    public Boolean isSettled() {
        return (Boolean) get(PROPERTY_SETTLED);
    }

    public void setSettled(Boolean settled) {
        set(PROPERTY_SETTLED, settled);
    }

    public BigDecimal getIva() {
        return (BigDecimal) get(PROPERTY_IVA);
    }

    public void setIva(BigDecimal iva) {
        set(PROPERTY_IVA, iva);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getTextcostcenter() {
        return (String) get(PROPERTY_TEXTCOSTCENTER);
    }

    public void setTextcostcenter(String textcostcenter) {
        set(PROPERTY_TEXTCOSTCENTER, textcostcenter);
    }

    public String getTextuser() {
        return (String) get(PROPERTY_TEXTUSER);
    }

    public void setTextuser(String textuser) {
        set(PROPERTY_TEXTUSER, textuser);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public Boolean isError() {
        return (Boolean) get(PROPERTY_ISERROR);
    }

    public void setError(Boolean iserror) {
        set(PROPERTY_ISERROR, iserror);
    }

    public String getGroupingBatch() {
        return (String) get(PROPERTY_GROUPINGBATCH);
    }

    public void setGroupingBatch(String groupingBatch) {
        set(PROPERTY_GROUPINGBATCH, groupingBatch);
    }

    public SsccrPosCardRec getPOSCardReconciliation() {
        return (SsccrPosCardRec) get(PROPERTY_POSCARDRECONCILIATION);
    }

    public void setPOSCardReconciliation(SsccrPosCardRec pOSCardReconciliation) {
        set(PROPERTY_POSCARDRECONCILIATION, pOSCardReconciliation);
    }

    public String getLOGError() {
        return (String) get(PROPERTY_LOGERROR);
    }

    public void setLOGError(String lOGError) {
        set(PROPERTY_LOGERROR, lOGError);
    }

}
