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
package ec.com.sidesoft.balance.performance;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.SalesRegion;
/**
 * Entity class for entity sbprf_fact_acct_aggd_doc (stored in table sbprf_fact_acct_aggd_doc).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SbprfFactAcctAggdDoc extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sbprf_fact_acct_aggd_doc";
    public static final String ENTITY_NAME = "sbprf_fact_acct_aggd_doc";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_ACCTSCHEMA = "acctschema";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMTSOURCEDR = "amtsourcedr";
    public static final String PROPERTY_AMTSOURCECR = "amtsourcecr";
    public static final String PROPERTY_AMTACCTDR = "amtacctdr";
    public static final String PROPERTY_AMTACCTCR = "amtacctcr";
    public static final String PROPERTY_SALESREGION = "salesregion";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_FACTACCTTYPE = "factaccttype";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_RECORD = "record";

    public SbprfFactAcctAggdDoc() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMTSOURCEDR, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTSOURCECR, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTACCTDR, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTACCTCR, new BigDecimal(0));
        setDefaultValue(PROPERTY_FACTACCTTYPE, "N");
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

    public AcctSchema getAcctschema() {
        return (AcctSchema) get(PROPERTY_ACCTSCHEMA);
    }

    public void setAcctschema(AcctSchema acctschema) {
        set(PROPERTY_ACCTSCHEMA, acctschema);
    }

    public ElementValue getAccount() {
        return (ElementValue) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(ElementValue account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public Date getDateacct() {
        return (Date) get(PROPERTY_DATEACCT);
    }

    public void setDateacct(Date dateacct) {
        set(PROPERTY_DATEACCT, dateacct);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public BigDecimal getAmtsourcedr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCEDR);
    }

    public void setAmtsourcedr(BigDecimal amtsourcedr) {
        set(PROPERTY_AMTSOURCEDR, amtsourcedr);
    }

    public BigDecimal getAmtsourcecr() {
        return (BigDecimal) get(PROPERTY_AMTSOURCECR);
    }

    public void setAmtsourcecr(BigDecimal amtsourcecr) {
        set(PROPERTY_AMTSOURCECR, amtsourcecr);
    }

    public BigDecimal getAmtacctdr() {
        return (BigDecimal) get(PROPERTY_AMTACCTDR);
    }

    public void setAmtacctdr(BigDecimal amtacctdr) {
        set(PROPERTY_AMTACCTDR, amtacctdr);
    }

    public BigDecimal getAmtacctcr() {
        return (BigDecimal) get(PROPERTY_AMTACCTCR);
    }

    public void setAmtacctcr(BigDecimal amtacctcr) {
        set(PROPERTY_AMTACCTCR, amtacctcr);
    }

    public SalesRegion getSalesregion() {
        return (SalesRegion) get(PROPERTY_SALESREGION);
    }

    public void setSalesregion(SalesRegion salesregion) {
        set(PROPERTY_SALESREGION, salesregion);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Campaign getCampaign() {
        return (Campaign) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(Campaign campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public UserDimension1 getUser1() {
        return (UserDimension1) get(PROPERTY_USER1);
    }

    public void setUser1(UserDimension1 user1) {
        set(PROPERTY_USER1, user1);
    }

    public UserDimension2 getUser2() {
        return (UserDimension2) get(PROPERTY_USER2);
    }

    public void setUser2(UserDimension2 user2) {
        set(PROPERTY_USER2, user2);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public String getFactaccttype() {
        return (String) get(PROPERTY_FACTACCTTYPE);
    }

    public void setFactaccttype(String factaccttype) {
        set(PROPERTY_FACTACCTTYPE, factaccttype);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public String getRecord() {
        return (String) get(PROPERTY_RECORD);
    }

    public void setRecord(String record) {
        set(PROPERTY_RECORD, record);
    }

}
