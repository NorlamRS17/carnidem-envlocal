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
package ec.com.sidesoft.localization.importdata.loadvouchers;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceDiscount;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectLine;
/**
 * Entity class for entity imdlv_Lines (stored in table imdlv_Lines).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Imdlv_Lines extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "imdlv_Lines";
    public static final String ENTITY_NAME = "imdlv_Lines";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_ORDERLINE = "orderline";
    public static final String PROPERTY_INOUTLINE = "inoutline";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_FINANCIALINVOICELINE = "financialInvoiceLine";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_QTYINVOICED = "qtyinvoiced";
    public static final String PROPERTY_PRICELIST = "pricelist";
    public static final String PROPERTY_PRICEACTUAL = "priceactual";
    public static final String PROPERTY_PRICELIMIT = "pricelimit";
    public static final String PROPERTY_LINENETAMT = "linenetamt";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMT = "chargeamt";
    public static final String PROPERTY_UOM = "uom";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_RESOURCEASSIGNMENT = "resourceAssignment";
    public static final String PROPERTY_TAXAMT = "taxamt";
    public static final String PROPERTY_ATTRIBUTESETINSTANCE = "attributesetinstance";
    public static final String PROPERTY_ISDESCRIPTION = "isdescription";
    public static final String PROPERTY_QUANTITYORDER = "quantityorder";
    public static final String PROPERTY_PRODUCTUOM = "productUom";
    public static final String PROPERTY_INVOICEDISCOUNT = "invoiceDiscount";
    public static final String PROPERTY_PROJECTLINE = "projectline";
    public static final String PROPERTY_OFFER = "offer";
    public static final String PROPERTY_PRICESTD = "pricestd";
    public static final String PROPERTY_EXCLUDEFORWITHHOLDING = "excludeforwithholding";
    public static final String PROPERTY_ISEDITLINENETAMT = "iseditlinenetamt";
    public static final String PROPERTY_TAXBASEAMT = "taxbaseamt";
    public static final String PROPERTY_LINEGROSSAMOUNT = "lineGrossAmount";
    public static final String PROPERTY_GROSSUNITPRICE = "grossUnitPrice";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_PERIODNUMBER = "periodnumber";
    public static final String PROPERTY_GROSSPRICESTD = "grosspricestd";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_DEFPLANTYPE = "defplantype";
    public static final String PROPERTY_GROSSPRICELIST = "grosspricelist";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ISDEFERRED = "isdeferred";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_USER1 = "user1";
    public static final String PROPERTY_USER2 = "user2";
    public static final String PROPERTY_EXPLODE = "explode";
    public static final String PROPERTY_BOMPARENT = "bOMParent";
    public static final String PROPERTY_MATCHLCCOSTS = "matchLccosts";
    public static final String PROPERTY_AUM = "aum";
    public static final String PROPERTY_AUMQTY = "aumqty";
    public static final String PROPERTY_LOCKDATE = "lockdate";
    public static final String PROPERTY_LOCKEDBY = "lockedby";
    public static final String PROPERTY_REFUNDED = "refunded";
    public static final String PROPERTY_ISREFUNDED = "isrefunded";
    public static final String PROPERTY_REFUNDEDINVOICEREF = "refundedinvoiceRef";
    public static final String PROPERTY_REFUNDEDINVLINEREF = "refundedinvlineRef";
    public static final String PROPERTY_INVOICETAXINCOME = "invoicetaxIncome";
    public static final String PROPERTY_INVOICETAXVAT = "invoicetaxVat";
    public static final String PROPERTY_IMPORTTYPE = "importtype";
    public static final String PROPERTY_CAMPAIGN = "campaign";
    public static final String PROPERTY_DISCOUNT2 = "discount2";
    public static final String PROPERTY_INITIALSUBTOTAL1 = "initialSubtotal1";
    public static final String PROPERTY_INITIALSUBTOTAL2 = "initialSubtotal2";
    public static final String PROPERTY_DISCOUNT = "discount";
    public static final String PROPERTY_INITIALUNITPRICE = "initialunitprice";
    public static final String PROPERTY_QTYXML = "qtyxml";
    public static final String PROPERTY_PRICEXML = "pricexml";
    public static final String PROPERTY_TOTALLINEXML = "totallinexml";
    public static final String PROPERTY_TAXAMTXML = "taxamtxml";
    public static final String PROPERTY_NETPRICEXML = "netpricexml";
    public static final String PROPERTY_IMDLVVOUCHERPURCHLINE = "imdlvVoucherpurchline";
    public static final String PROPERTY_LINEAMTVAT = "lineamtvat";
    public static final String PROPERTY_VATAMT = "vatamt";
    public static final String PROPERTY_WITHHRENT = "withhrent";
    public static final String PROPERTY_LINEAMTRENT = "lineamtrent";
    public static final String PROPERTY_CODEXML = "codexml";
    public static final String PROPERTY_CODERET = "coderet";
    public static final String PROPERTY_CODETAX = "codetax";
    public static final String PROPERTY_BASEIMP = "baseimp";
    public static final String PROPERTY_DISCAMT = "discamt";
    public static final String PROPERTY_BPARTNERREF = "bpartnerRef";
    public static final String PROPERTY_TAXREF = "tAXRef";

    public Imdlv_Lines() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FINANCIALINVOICELINE, false);
        setDefaultValue(PROPERTY_QTYINVOICED, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRICELIST, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRICEACTUAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_PRICELIMIT, new BigDecimal(0));
        setDefaultValue(PROPERTY_LINENETAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_CHARGEAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_TAXAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISDESCRIPTION, false);
        setDefaultValue(PROPERTY_PRICESTD, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXCLUDEFORWITHHOLDING, false);
        setDefaultValue(PROPERTY_ISEDITLINENETAMT, false);
        setDefaultValue(PROPERTY_LINEGROSSAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_GROSSUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_GROSSPRICESTD, new BigDecimal(0));
        setDefaultValue(PROPERTY_GROSSPRICELIST, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISDEFERRED, false);
        setDefaultValue(PROPERTY_EXPLODE, false);
        setDefaultValue(PROPERTY_MATCHLCCOSTS, false);
        setDefaultValue(PROPERTY_ISREFUNDED, false);
        setDefaultValue(PROPERTY_IMPORTTYPE, false);
        setDefaultValue(PROPERTY_DISCOUNT2, new BigDecimal(0));
        setDefaultValue(PROPERTY_INITIALSUBTOTAL1, new BigDecimal(0));
        setDefaultValue(PROPERTY_INITIALSUBTOTAL2, new BigDecimal(0));
        setDefaultValue(PROPERTY_DISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_INITIALUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_LINEAMTVAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASEIMP, new BigDecimal(0));
        setDefaultValue(PROPERTY_DISCAMT, new BigDecimal(0));
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

    public Invoice getInvoice() {
        return (Invoice) get(PROPERTY_INVOICE);
    }

    public void setInvoice(Invoice invoice) {
        set(PROPERTY_INVOICE, invoice);
    }

    public OrderLine getOrderline() {
        return (OrderLine) get(PROPERTY_ORDERLINE);
    }

    public void setOrderline(OrderLine orderline) {
        set(PROPERTY_ORDERLINE, orderline);
    }

    public ShipmentInOutLine getInoutline() {
        return (ShipmentInOutLine) get(PROPERTY_INOUTLINE);
    }

    public void setInoutline(ShipmentInOutLine inoutline) {
        set(PROPERTY_INOUTLINE, inoutline);
    }

    public Long getLine() {
        return (Long) get(PROPERTY_LINE);
    }

    public void setLine(Long line) {
        set(PROPERTY_LINE, line);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isFinancialInvoiceLine() {
        return (Boolean) get(PROPERTY_FINANCIALINVOICELINE);
    }

    public void setFinancialInvoiceLine(Boolean financialInvoiceLine) {
        set(PROPERTY_FINANCIALINVOICELINE, financialInvoiceLine);
    }

    public String getAccount() {
        return (String) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(String account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getQtyinvoiced() {
        return (BigDecimal) get(PROPERTY_QTYINVOICED);
    }

    public void setQtyinvoiced(BigDecimal qtyinvoiced) {
        set(PROPERTY_QTYINVOICED, qtyinvoiced);
    }

    public BigDecimal getPricelist() {
        return (BigDecimal) get(PROPERTY_PRICELIST);
    }

    public void setPricelist(BigDecimal pricelist) {
        set(PROPERTY_PRICELIST, pricelist);
    }

    public BigDecimal getPriceactual() {
        return (BigDecimal) get(PROPERTY_PRICEACTUAL);
    }

    public void setPriceactual(BigDecimal priceactual) {
        set(PROPERTY_PRICEACTUAL, priceactual);
    }

    public BigDecimal getPricelimit() {
        return (BigDecimal) get(PROPERTY_PRICELIMIT);
    }

    public void setPricelimit(BigDecimal pricelimit) {
        set(PROPERTY_PRICELIMIT, pricelimit);
    }

    public BigDecimal getLinenetamt() {
        return (BigDecimal) get(PROPERTY_LINENETAMT);
    }

    public void setLinenetamt(BigDecimal linenetamt) {
        set(PROPERTY_LINENETAMT, linenetamt);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeamt() {
        return (BigDecimal) get(PROPERTY_CHARGEAMT);
    }

    public void setChargeamt(BigDecimal chargeamt) {
        set(PROPERTY_CHARGEAMT, chargeamt);
    }

    public UOM getUom() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUom(UOM uom) {
        set(PROPERTY_UOM, uom);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public String getResourceAssignment() {
        return (String) get(PROPERTY_RESOURCEASSIGNMENT);
    }

    public void setResourceAssignment(String resourceAssignment) {
        set(PROPERTY_RESOURCEASSIGNMENT, resourceAssignment);
    }

    public BigDecimal getTaxamt() {
        return (BigDecimal) get(PROPERTY_TAXAMT);
    }

    public void setTaxamt(BigDecimal taxamt) {
        set(PROPERTY_TAXAMT, taxamt);
    }

    public AttributeSetInstance getAttributesetinstance() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETINSTANCE);
    }

    public void setAttributesetinstance(AttributeSetInstance attributesetinstance) {
        set(PROPERTY_ATTRIBUTESETINSTANCE, attributesetinstance);
    }

    public Boolean isDescription() {
        return (Boolean) get(PROPERTY_ISDESCRIPTION);
    }

    public void setDescription(Boolean isdescription) {
        set(PROPERTY_ISDESCRIPTION, isdescription);
    }

    public BigDecimal getQuantityorder() {
        return (BigDecimal) get(PROPERTY_QUANTITYORDER);
    }

    public void setQuantityorder(BigDecimal quantityorder) {
        set(PROPERTY_QUANTITYORDER, quantityorder);
    }

    public ProductUOM getProductUom() {
        return (ProductUOM) get(PROPERTY_PRODUCTUOM);
    }

    public void setProductUom(ProductUOM productUom) {
        set(PROPERTY_PRODUCTUOM, productUom);
    }

    public InvoiceDiscount getInvoiceDiscount() {
        return (InvoiceDiscount) get(PROPERTY_INVOICEDISCOUNT);
    }

    public void setInvoiceDiscount(InvoiceDiscount invoiceDiscount) {
        set(PROPERTY_INVOICEDISCOUNT, invoiceDiscount);
    }

    public ProjectLine getProjectline() {
        return (ProjectLine) get(PROPERTY_PROJECTLINE);
    }

    public void setProjectline(ProjectLine projectline) {
        set(PROPERTY_PROJECTLINE, projectline);
    }

    public PriceAdjustment getOffer() {
        return (PriceAdjustment) get(PROPERTY_OFFER);
    }

    public void setOffer(PriceAdjustment offer) {
        set(PROPERTY_OFFER, offer);
    }

    public BigDecimal getPricestd() {
        return (BigDecimal) get(PROPERTY_PRICESTD);
    }

    public void setPricestd(BigDecimal pricestd) {
        set(PROPERTY_PRICESTD, pricestd);
    }

    public Boolean isExcludeforwithholding() {
        return (Boolean) get(PROPERTY_EXCLUDEFORWITHHOLDING);
    }

    public void setExcludeforwithholding(Boolean excludeforwithholding) {
        set(PROPERTY_EXCLUDEFORWITHHOLDING, excludeforwithholding);
    }

    public Boolean isEditlinenetamt() {
        return (Boolean) get(PROPERTY_ISEDITLINENETAMT);
    }

    public void setEditlinenetamt(Boolean iseditlinenetamt) {
        set(PROPERTY_ISEDITLINENETAMT, iseditlinenetamt);
    }

    public BigDecimal getTaxbaseamt() {
        return (BigDecimal) get(PROPERTY_TAXBASEAMT);
    }

    public void setTaxbaseamt(BigDecimal taxbaseamt) {
        set(PROPERTY_TAXBASEAMT, taxbaseamt);
    }

    public BigDecimal getLineGrossAmount() {
        return (BigDecimal) get(PROPERTY_LINEGROSSAMOUNT);
    }

    public void setLineGrossAmount(BigDecimal lineGrossAmount) {
        set(PROPERTY_LINEGROSSAMOUNT, lineGrossAmount);
    }

    public BigDecimal getGrossUnitPrice() {
        return (BigDecimal) get(PROPERTY_GROSSUNITPRICE);
    }

    public void setGrossUnitPrice(BigDecimal grossUnitPrice) {
        set(PROPERTY_GROSSUNITPRICE, grossUnitPrice);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public BigDecimal getPeriodnumber() {
        return (BigDecimal) get(PROPERTY_PERIODNUMBER);
    }

    public void setPeriodnumber(BigDecimal periodnumber) {
        set(PROPERTY_PERIODNUMBER, periodnumber);
    }

    public BigDecimal getGrosspricestd() {
        return (BigDecimal) get(PROPERTY_GROSSPRICESTD);
    }

    public void setGrosspricestd(BigDecimal grosspricestd) {
        set(PROPERTY_GROSSPRICESTD, grosspricestd);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getDefplantype() {
        return (String) get(PROPERTY_DEFPLANTYPE);
    }

    public void setDefplantype(String defplantype) {
        set(PROPERTY_DEFPLANTYPE, defplantype);
    }

    public BigDecimal getGrosspricelist() {
        return (BigDecimal) get(PROPERTY_GROSSPRICELIST);
    }

    public void setGrosspricelist(BigDecimal grosspricelist) {
        set(PROPERTY_GROSSPRICELIST, grosspricelist);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isDeferred() {
        return (Boolean) get(PROPERTY_ISDEFERRED);
    }

    public void setDeferred(Boolean isdeferred) {
        set(PROPERTY_ISDEFERRED, isdeferred);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
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

    public Boolean isExplode() {
        return (Boolean) get(PROPERTY_EXPLODE);
    }

    public void setExplode(Boolean explode) {
        set(PROPERTY_EXPLODE, explode);
    }

    public String getBOMParent() {
        return (String) get(PROPERTY_BOMPARENT);
    }

    public void setBOMParent(String bOMParent) {
        set(PROPERTY_BOMPARENT, bOMParent);
    }

    public Boolean isMatchLccosts() {
        return (Boolean) get(PROPERTY_MATCHLCCOSTS);
    }

    public void setMatchLccosts(Boolean matchLccosts) {
        set(PROPERTY_MATCHLCCOSTS, matchLccosts);
    }

    public String getAum() {
        return (String) get(PROPERTY_AUM);
    }

    public void setAum(String aum) {
        set(PROPERTY_AUM, aum);
    }

    public BigDecimal getAumqty() {
        return (BigDecimal) get(PROPERTY_AUMQTY);
    }

    public void setAumqty(BigDecimal aumqty) {
        set(PROPERTY_AUMQTY, aumqty);
    }

    public Date getLockdate() {
        return (Date) get(PROPERTY_LOCKDATE);
    }

    public void setLockdate(Date lockdate) {
        set(PROPERTY_LOCKDATE, lockdate);
    }

    public String getLockedby() {
        return (String) get(PROPERTY_LOCKEDBY);
    }

    public void setLockedby(String lockedby) {
        set(PROPERTY_LOCKEDBY, lockedby);
    }

    public String getRefunded() {
        return (String) get(PROPERTY_REFUNDED);
    }

    public void setRefunded(String refunded) {
        set(PROPERTY_REFUNDED, refunded);
    }

    public Boolean isRefunded() {
        return (Boolean) get(PROPERTY_ISREFUNDED);
    }

    public void setRefunded(Boolean isrefunded) {
        set(PROPERTY_ISREFUNDED, isrefunded);
    }

    public String getRefundedinvoiceRef() {
        return (String) get(PROPERTY_REFUNDEDINVOICEREF);
    }

    public void setRefundedinvoiceRef(String refundedinvoiceRef) {
        set(PROPERTY_REFUNDEDINVOICEREF, refundedinvoiceRef);
    }

    public String getRefundedinvlineRef() {
        return (String) get(PROPERTY_REFUNDEDINVLINEREF);
    }

    public void setRefundedinvlineRef(String refundedinvlineRef) {
        set(PROPERTY_REFUNDEDINVLINEREF, refundedinvlineRef);
    }

    public String getInvoicetaxIncome() {
        return (String) get(PROPERTY_INVOICETAXINCOME);
    }

    public void setInvoicetaxIncome(String invoicetaxIncome) {
        set(PROPERTY_INVOICETAXINCOME, invoicetaxIncome);
    }

    public String getInvoicetaxVat() {
        return (String) get(PROPERTY_INVOICETAXVAT);
    }

    public void setInvoicetaxVat(String invoicetaxVat) {
        set(PROPERTY_INVOICETAXVAT, invoicetaxVat);
    }

    public Boolean isImporttype() {
        return (Boolean) get(PROPERTY_IMPORTTYPE);
    }

    public void setImporttype(Boolean importtype) {
        set(PROPERTY_IMPORTTYPE, importtype);
    }

    public String getCampaign() {
        return (String) get(PROPERTY_CAMPAIGN);
    }

    public void setCampaign(String campaign) {
        set(PROPERTY_CAMPAIGN, campaign);
    }

    public BigDecimal getDiscount2() {
        return (BigDecimal) get(PROPERTY_DISCOUNT2);
    }

    public void setDiscount2(BigDecimal discount2) {
        set(PROPERTY_DISCOUNT2, discount2);
    }

    public BigDecimal getInitialSubtotal1() {
        return (BigDecimal) get(PROPERTY_INITIALSUBTOTAL1);
    }

    public void setInitialSubtotal1(BigDecimal initialSubtotal1) {
        set(PROPERTY_INITIALSUBTOTAL1, initialSubtotal1);
    }

    public BigDecimal getInitialSubtotal2() {
        return (BigDecimal) get(PROPERTY_INITIALSUBTOTAL2);
    }

    public void setInitialSubtotal2(BigDecimal initialSubtotal2) {
        set(PROPERTY_INITIALSUBTOTAL2, initialSubtotal2);
    }

    public BigDecimal getDiscount() {
        return (BigDecimal) get(PROPERTY_DISCOUNT);
    }

    public void setDiscount(BigDecimal discount) {
        set(PROPERTY_DISCOUNT, discount);
    }

    public BigDecimal getInitialunitprice() {
        return (BigDecimal) get(PROPERTY_INITIALUNITPRICE);
    }

    public void setInitialunitprice(BigDecimal initialunitprice) {
        set(PROPERTY_INITIALUNITPRICE, initialunitprice);
    }

    public BigDecimal getQtyxml() {
        return (BigDecimal) get(PROPERTY_QTYXML);
    }

    public void setQtyxml(BigDecimal qtyxml) {
        set(PROPERTY_QTYXML, qtyxml);
    }

    public BigDecimal getPricexml() {
        return (BigDecimal) get(PROPERTY_PRICEXML);
    }

    public void setPricexml(BigDecimal pricexml) {
        set(PROPERTY_PRICEXML, pricexml);
    }

    public BigDecimal getTotallinexml() {
        return (BigDecimal) get(PROPERTY_TOTALLINEXML);
    }

    public void setTotallinexml(BigDecimal totallinexml) {
        set(PROPERTY_TOTALLINEXML, totallinexml);
    }

    public BigDecimal getTaxamtxml() {
        return (BigDecimal) get(PROPERTY_TAXAMTXML);
    }

    public void setTaxamtxml(BigDecimal taxamtxml) {
        set(PROPERTY_TAXAMTXML, taxamtxml);
    }

    public BigDecimal getNetpricexml() {
        return (BigDecimal) get(PROPERTY_NETPRICEXML);
    }

    public void setNetpricexml(BigDecimal netpricexml) {
        set(PROPERTY_NETPRICEXML, netpricexml);
    }

    public ImdlvVoucherDataLine getImdlvVoucherpurchline() {
        return (ImdlvVoucherDataLine) get(PROPERTY_IMDLVVOUCHERPURCHLINE);
    }

    public void setImdlvVoucherpurchline(ImdlvVoucherDataLine imdlvVoucherpurchline) {
        set(PROPERTY_IMDLVVOUCHERPURCHLINE, imdlvVoucherpurchline);
    }

    public BigDecimal getLineamtvat() {
        return (BigDecimal) get(PROPERTY_LINEAMTVAT);
    }

    public void setLineamtvat(BigDecimal lineamtvat) {
        set(PROPERTY_LINEAMTVAT, lineamtvat);
    }

    public BigDecimal getVatamt() {
        return (BigDecimal) get(PROPERTY_VATAMT);
    }

    public void setVatamt(BigDecimal vatamt) {
        set(PROPERTY_VATAMT, vatamt);
    }

    public BigDecimal getWithhrent() {
        return (BigDecimal) get(PROPERTY_WITHHRENT);
    }

    public void setWithhrent(BigDecimal withhrent) {
        set(PROPERTY_WITHHRENT, withhrent);
    }

    public BigDecimal getLineamtrent() {
        return (BigDecimal) get(PROPERTY_LINEAMTRENT);
    }

    public void setLineamtrent(BigDecimal lineamtrent) {
        set(PROPERTY_LINEAMTRENT, lineamtrent);
    }

    public String getCodexml() {
        return (String) get(PROPERTY_CODEXML);
    }

    public void setCodexml(String codexml) {
        set(PROPERTY_CODEXML, codexml);
    }

    public String getCoderet() {
        return (String) get(PROPERTY_CODERET);
    }

    public void setCoderet(String coderet) {
        set(PROPERTY_CODERET, coderet);
    }

    public BigDecimal getCodetax() {
        return (BigDecimal) get(PROPERTY_CODETAX);
    }

    public void setCodetax(BigDecimal codetax) {
        set(PROPERTY_CODETAX, codetax);
    }

    public BigDecimal getBaseimp() {
        return (BigDecimal) get(PROPERTY_BASEIMP);
    }

    public void setBaseimp(BigDecimal baseimp) {
        set(PROPERTY_BASEIMP, baseimp);
    }

    public BigDecimal getDiscamt() {
        return (BigDecimal) get(PROPERTY_DISCAMT);
    }

    public void setDiscamt(BigDecimal discamt) {
        set(PROPERTY_DISCAMT, discamt);
    }

    public String getBpartnerRef() {
        return (String) get(PROPERTY_BPARTNERREF);
    }

    public void setBpartnerRef(String bpartnerRef) {
        set(PROPERTY_BPARTNERREF, bpartnerRef);
    }

    public String getTAXRef() {
        return (String) get(PROPERTY_TAXREF);
    }

    public void setTAXRef(String tAXRef) {
        set(PROPERTY_TAXREF, tAXRef);
    }

}
