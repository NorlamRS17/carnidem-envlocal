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
package ec.com.sidesoft.modify.accounting;

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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Location;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.SalesRegion;
/**
 * Entity class for entity Ssmaact_Audit (stored in table ssmaact_audit).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsmaactAudit extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "ssmaact_audit";
    public static final String ENTITY_NAME = "Ssmaact_Audit";
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
    public static final String PROPERTY_DATETRX = "datetrx";
    public static final String PROPERTY_DATEACCT = "dateacct";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_RECORD = "record";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_LOCATOR = "locator";
    public static final String PROPERTY_POSTINGTYPE = "postingtype";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_AMTSOURCEDR = "amtsourcedr";
    public static final String PROPERTY_AMTSOURCECR = "amtsourcecr";
    public static final String PROPERTY_AMTACCTDR = "amtacctdr";
    public static final String PROPERTY_AMTACCTCR = "amtacctcr";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_QTY = "qty";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_ORGTRX = "orgtrx";
    public static final String PROPERTY_LOCFROM = "locfrom";
    public static final String PROPERTY_LOCTO = "locto";
    public static final String PROPERTY_SALESREGION = "salesregion";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_FACTACCTGROUP = "factAcctGroup";
    public static final String PROPERTY_SEQNO = "seqno";
    public static final String PROPERTY_FACTACCTTYPE = "factaccttype";
    public static final String PROPERTY_DOCBASETYPE = "docbasetype";
    public static final String PROPERTY_ACCTVALUE = "acctvalue";
    public static final String PROPERTY_ACCTDESCRIPTION = "acctdescription";
    public static final String PROPERTY_RECORDID2 = "recordId2";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_DOCTYPE = "doctype";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_ISMODIFY = "ismodify";
    public static final String PROPERTY_DATEBALANCED = "datebalanced";
    public static final String PROPERTY_FACTACCT = "factAcct";
    public static final String PROPERTY_MODIFYACCOUNTING = "modifyAccounting";

    public SsmaactAudit() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMTSOURCEDR, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTSOURCECR, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTACCTDR, new BigDecimal(0));
        setDefaultValue(PROPERTY_AMTACCTCR, new BigDecimal(0));
        setDefaultValue(PROPERTY_QTY, new BigDecimal(0));
        setDefaultValue(PROPERTY_FACTACCTTYPE, "N");
        setDefaultValue(PROPERTY_ISMODIFY, false);
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

    public Date getDatetrx() {
        return (Date) get(PROPERTY_DATETRX);
    }

    public void setDatetrx(Date datetrx) {
        set(PROPERTY_DATETRX, datetrx);
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

    public String getLine() {
        return (String) get(PROPERTY_LINE);
    }

    public void setLine(String line) {
        set(PROPERTY_LINE, line);
    }

    public GLCategory getCategory() {
        return (GLCategory) get(PROPERTY_CATEGORY);
    }

    public void setCategory(GLCategory category) {
        set(PROPERTY_CATEGORY, category);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Locator getLocator() {
        return (Locator) get(PROPERTY_LOCATOR);
    }

    public void setLocator(Locator locator) {
        set(PROPERTY_LOCATOR, locator);
    }

    public String getPostingtype() {
        return (String) get(PROPERTY_POSTINGTYPE);
    }

    public void setPostingtype(String postingtype) {
        set(PROPERTY_POSTINGTYPE, postingtype);
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

    public UOM getUom() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUom(UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public BigDecimal getQty() {
        return (BigDecimal) get(PROPERTY_QTY);
    }

    public void setQty(BigDecimal qty) {
        set(PROPERTY_QTY, qty);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public Organization getOrgtrx() {
        return (Organization) get(PROPERTY_ORGTRX);
    }

    public void setOrgtrx(Organization orgtrx) {
        set(PROPERTY_ORGTRX, orgtrx);
    }

    public Location getLocfrom() {
        return (Location) get(PROPERTY_LOCFROM);
    }

    public void setLocfrom(Location locfrom) {
        set(PROPERTY_LOCFROM, locfrom);
    }

    public Location getLocto() {
        return (Location) get(PROPERTY_LOCTO);
    }

    public void setLocto(Location locto) {
        set(PROPERTY_LOCTO, locto);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getFactAcctGroup() {
        return (String) get(PROPERTY_FACTACCTGROUP);
    }

    public void setFactAcctGroup(String factAcctGroup) {
        set(PROPERTY_FACTACCTGROUP, factAcctGroup);
    }

    public Long getSeqno() {
        return (Long) get(PROPERTY_SEQNO);
    }

    public void setSeqno(Long seqno) {
        set(PROPERTY_SEQNO, seqno);
    }

    public String getFactaccttype() {
        return (String) get(PROPERTY_FACTACCTTYPE);
    }

    public void setFactaccttype(String factaccttype) {
        set(PROPERTY_FACTACCTTYPE, factaccttype);
    }

    public String getDocbasetype() {
        return (String) get(PROPERTY_DOCBASETYPE);
    }

    public void setDocbasetype(String docbasetype) {
        set(PROPERTY_DOCBASETYPE, docbasetype);
    }

    public String getAcctvalue() {
        return (String) get(PROPERTY_ACCTVALUE);
    }

    public void setAcctvalue(String acctvalue) {
        set(PROPERTY_ACCTVALUE, acctvalue);
    }

    public String getAcctdescription() {
        return (String) get(PROPERTY_ACCTDESCRIPTION);
    }

    public void setAcctdescription(String acctdescription) {
        set(PROPERTY_ACCTDESCRIPTION, acctdescription);
    }

    public String getRecordId2() {
        return (String) get(PROPERTY_RECORDID2);
    }

    public void setRecordId2(String recordId2) {
        set(PROPERTY_RECORDID2, recordId2);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public DocumentType getDoctype() {
        return (DocumentType) get(PROPERTY_DOCTYPE);
    }

    public void setDoctype(DocumentType doctype) {
        set(PROPERTY_DOCTYPE, doctype);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public Boolean isModify() {
        return (Boolean) get(PROPERTY_ISMODIFY);
    }

    public void setModify(Boolean ismodify) {
        set(PROPERTY_ISMODIFY, ismodify);
    }

    public Date getDatebalanced() {
        return (Date) get(PROPERTY_DATEBALANCED);
    }

    public void setDatebalanced(Date datebalanced) {
        set(PROPERTY_DATEBALANCED, datebalanced);
    }

    public String getFactAcct() {
        return (String) get(PROPERTY_FACTACCT);
    }

    public void setFactAcct(String factAcct) {
        set(PROPERTY_FACTACCT, factAcct);
    }

    public SsmaactModifyAcct getModifyAccounting() {
        return (SsmaactModifyAcct) get(PROPERTY_MODIFYACCOUNTING);
    }

    public void setModifyAccounting(SsmaactModifyAcct modifyAccounting) {
        set(PROPERTY_MODIFYACCOUNTING, modifyAccounting);
    }

}
