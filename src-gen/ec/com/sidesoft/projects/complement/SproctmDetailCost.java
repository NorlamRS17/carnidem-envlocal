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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sproctm_detail_cost (stored in table sproctm_detail_cost).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SproctmDetailCost extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sproctm_detail_cost";
    public static final String ENTITY_NAME = "sproctm_detail_cost";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_RECORDID = "recordID";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_HOURS = "hours";
    public static final String PROPERTY_DATE = "date";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_TOTALPAYMENT = "totalPayment";
    public static final String PROPERTY_ALERTSTATUS = "alertStatus";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_SETTLEMENT = "settlement";
    public static final String PROPERTY_COMPLETE = "complete";
    public static final String PROPERTY_TAB = "tab";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_PROCESSING = "processing";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED2 = "posted2";
    public static final String PROPERTY_SPROCTMACCTDETAILRECORDIDLIST = "sproctmAcctDetailRecordIDList";
    public static final String PROPERTY_SPROCTMSETTLCOSTLNLIST = "sproctmSettlCostLnList";

    public SproctmDetailCost() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_HOURS, new BigDecimal(0));
        setDefaultValue(PROPERTY_COST, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTALPAYMENT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ALERTSTATUS, "DR");
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_SETTLEMENT, false);
        setDefaultValue(PROPERTY_COMPLETE, "DR");
        setDefaultValue(PROPERTY_PROCESSING, false);
        setDefaultValue(PROPERTY_PROCESSED, true);
        setDefaultValue(PROPERTY_POSTED2, "Y");
        setDefaultValue(PROPERTY_SPROCTMACCTDETAILRECORDIDLIST, new ArrayList<Object>());
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

    public String getRecordID() {
        return (String) get(PROPERTY_RECORDID);
    }

    public void setRecordID(String recordID) {
        set(PROPERTY_RECORDID, recordID);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public BigDecimal getHours() {
        return (BigDecimal) get(PROPERTY_HOURS);
    }

    public void setHours(BigDecimal hours) {
        set(PROPERTY_HOURS, hours);
    }

    public Date getDate() {
        return (Date) get(PROPERTY_DATE);
    }

    public void setDate(Date date) {
        set(PROPERTY_DATE, date);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public BigDecimal getTotalPayment() {
        return (BigDecimal) get(PROPERTY_TOTALPAYMENT);
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        set(PROPERTY_TOTALPAYMENT, totalPayment);
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

    public Boolean isSettlement() {
        return (Boolean) get(PROPERTY_SETTLEMENT);
    }

    public void setSettlement(Boolean settlement) {
        set(PROPERTY_SETTLEMENT, settlement);
    }

    public String getComplete() {
        return (String) get(PROPERTY_COMPLETE);
    }

    public void setComplete(String complete) {
        set(PROPERTY_COMPLETE, complete);
    }

    public String getTab() {
        return (String) get(PROPERTY_TAB);
    }

    public void setTab(String tab) {
        set(PROPERTY_TAB, tab);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public Boolean isProcessing() {
        return (Boolean) get(PROPERTY_PROCESSING);
    }

    public void setProcessing(Boolean processing) {
        set(PROPERTY_PROCESSING, processing);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted2() {
        return (String) get(PROPERTY_POSTED2);
    }

    public void setPosted2(String posted2) {
        set(PROPERTY_POSTED2, posted2);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmAcctDetail> getSproctmAcctDetailRecordIDList() {
      return (List<SproctmAcctDetail>) get(PROPERTY_SPROCTMACCTDETAILRECORDIDLIST);
    }

    public void setSproctmAcctDetailRecordIDList(List<SproctmAcctDetail> sproctmAcctDetailRecordIDList) {
        set(PROPERTY_SPROCTMACCTDETAILRECORDIDLIST, sproctmAcctDetailRecordIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmSettlCostLn> getSproctmSettlCostLnList() {
      return (List<SproctmSettlCostLn>) get(PROPERTY_SPROCTMSETTLCOSTLNLIST);
    }

    public void setSproctmSettlCostLnList(List<SproctmSettlCostLn> sproctmSettlCostLnList) {
        set(PROPERTY_SPROCTMSETTLCOSTLNLIST, sproctmSettlCostLnList);
    }

}
