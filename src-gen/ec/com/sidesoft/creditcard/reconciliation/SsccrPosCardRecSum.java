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
package ec.com.sidesoft.creditcard.reconciliation;

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
/**
 * Entity class for entity Ssccr_Pos_Card_Rec_Sum (stored in table Ssccr_Pos_Card_Rec_Sum).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsccrPosCardRecSum extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Ssccr_Pos_Card_Rec_Sum";
    public static final String ENTITY_NAME = "Ssccr_Pos_Card_Rec_Sum";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_POSCARDRECONCILIATION = "pOSCardReconciliation";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_DEPOSITAMOUNT = "depositAmount";
    public static final String PROPERTY_WAREHOUSERULETYPE = "warehouseRuleType";
    public static final String PROPERTY_RECONCILED = "reconciled";
    public static final String PROPERTY_PROCESSORBANCK = "processorBanck";
    public static final String PROPERTY_CONFIRMATIONNO = "confirmationNo";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_FINFINACCTRANSSACTION = "fINFinaccTranssaction";

    public SsccrPosCardRecSum() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
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

    public SsccrPosCardRec getPOSCardReconciliation() {
        return (SsccrPosCardRec) get(PROPERTY_POSCARDRECONCILIATION);
    }

    public void setPOSCardReconciliation(SsccrPosCardRec pOSCardReconciliation) {
        set(PROPERTY_POSCARDRECONCILIATION, pOSCardReconciliation);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getDepositAmount() {
        return (BigDecimal) get(PROPERTY_DEPOSITAMOUNT);
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        set(PROPERTY_DEPOSITAMOUNT, depositAmount);
    }

    public String getWarehouseRuleType() {
        return (String) get(PROPERTY_WAREHOUSERULETYPE);
    }

    public void setWarehouseRuleType(String warehouseRuleType) {
        set(PROPERTY_WAREHOUSERULETYPE, warehouseRuleType);
    }

    public String getReconciled() {
        return (String) get(PROPERTY_RECONCILED);
    }

    public void setReconciled(String reconciled) {
        set(PROPERTY_RECONCILED, reconciled);
    }

    public SsccrProcessorBanck getProcessorBanck() {
        return (SsccrProcessorBanck) get(PROPERTY_PROCESSORBANCK);
    }

    public void setProcessorBanck(SsccrProcessorBanck processorBanck) {
        set(PROPERTY_PROCESSORBANCK, processorBanck);
    }

    public String getConfirmationNo() {
        return (String) get(PROPERTY_CONFIRMATIONNO);
    }

    public void setConfirmationNo(String confirmationNo) {
        set(PROPERTY_CONFIRMATIONNO, confirmationNo);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public String getFINFinaccTranssaction() {
        return (String) get(PROPERTY_FINFINACCTRANSSACTION);
    }

    public void setFINFinaccTranssaction(String fINFinaccTranssaction) {
        set(PROPERTY_FINFINACCTRANSSACTION, fINFinaccTranssaction);
    }

}
