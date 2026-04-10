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
package org.openbravo.model.common.invoice;

import com.sidesoft.ecuador.asset.move.ssamalienate;
import com.sidesoft.ecuador.asset.move.ssamalienateline;
import com.sidesoft.inventory.movement.frominvoice.Sinvmin_SquareBill;
import com.sidesoft.localization.ecuador.refunds.ssrerefund;

import ec.com.sidesoft.backoffice.discount.SsbodGiftInvoice;
import ec.com.sidesoft.commission.standard.scomst_unpaid_commission;
import ec.com.sidesoft.distribute.costcenter.SsdccpDistributeCostCenter;
import ec.com.sidesoft.imports.consolidation.Ssimpcn_ImpConsolDetail;
import ec.com.sidesoft.imports.consolidation.Ssimpcn_ImpConsolidation;
import ec.com.sidesoft.imports.consolidation.Ssimpcn_ImportationCost;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSaleLine;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvWthholdingline;
import ec.com.sidesoft.projects.complement.SproctmTaskContract;
import ec.com.sidesoft.settlement.project.cost.SstpcLiquidationProjectsInvoiceView;
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedCosts;
import ec.com.sidesoft.workorder.simplified.SswosVehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.InvoiceLineTax;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductUOM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.assetmgmt.AssetGroup;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.manufacturing.transaction.ProductionRunInvoiceLine;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.materialmgmt.cost.LCMatched;
import org.openbravo.model.materialmgmt.cost.LandedCostCost;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.pricing.priceadjustment.PriceAdjustment;
import org.openbravo.model.procurement.POInvoiceMatch;
import org.openbravo.model.procurement.ReceiptInvoiceMatch;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectLine;
import org.openbravo.model.sales.CommissionDetail;
import org.openbravo.model.timeandexpense.ResourceAssignment;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
/**
 * Entity class for entity InvoiceLine (stored in table C_InvoiceLine).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class InvoiceLine extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_InvoiceLine";
    public static final String ENTITY_NAME = "InvoiceLine";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_INVOICE = "invoice";
    public static final String PROPERTY_SALESORDERLINE = "salesOrderLine";
    public static final String PROPERTY_GOODSSHIPMENTLINE = "goodsShipmentLine";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_FINANCIALINVOICELINE = "financialInvoiceLine";
    public static final String PROPERTY_ACCOUNT = "account";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_INVOICEDQUANTITY = "invoicedQuantity";
    public static final String PROPERTY_LISTPRICE = "listPrice";
    public static final String PROPERTY_UNITPRICE = "unitPrice";
    public static final String PROPERTY_PRICELIMIT = "priceLimit";
    public static final String PROPERTY_LINENETAMOUNT = "lineNetAmount";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMOUNT = "chargeAmount";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_RESOURCEASSIGNMENT = "resourceAssignment";
    public static final String PROPERTY_TAXAMOUNT = "taxAmount";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_DESCRIPTIONONLY = "descriptionOnly";
    public static final String PROPERTY_ORDERQUANTITY = "orderQuantity";
    public static final String PROPERTY_ORDERUOM = "orderUOM";
    public static final String PROPERTY_INVOICEDISCOUNT = "invoiceDiscount";
    public static final String PROPERTY_PROJECTLINE = "projectLine";
    public static final String PROPERTY_PRICEADJUSTMENT = "priceAdjustment";
    public static final String PROPERTY_STANDARDPRICE = "standardPrice";
    public static final String PROPERTY_EXCLUDEFORWITHHOLDING = "excludeforwithholding";
    public static final String PROPERTY_EDITLINEAMOUNT = "editLineAmount";
    public static final String PROPERTY_TAXABLEAMOUNT = "taxableAmount";
    public static final String PROPERTY_GROSSAMOUNT = "grossAmount";
    public static final String PROPERTY_GROSSUNITPRICE = "grossUnitPrice";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PERIODNUMBER = "periodNumber";
    public static final String PROPERTY_BASEGROSSUNITPRICE = "baseGrossUnitPrice";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_DEFERREDPLANTYPE = "deferredPlanType";
    public static final String PROPERTY_GROSSLISTPRICE = "grossListPrice";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_DEFERRED = "deferred";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_EXPLODE = "explode";
    public static final String PROPERTY_BOMPARENT = "bOMParent";
    public static final String PROPERTY_SSAMASSET = "ssamAsset";
    public static final String PROPERTY_MATCHLCCOSTS = "matchLCCosts";
    public static final String PROPERTY_SSAMAASSET = "ssamAAsset";
    public static final String PROPERTY_OPERATIVEUOM = "operativeUOM";
    public static final String PROPERTY_SSIPIMPORTTYPE = "ssipImporttype";
    public static final String PROPERTY_OPERATIVEQUANTITY = "operativeQuantity";
    public static final String PROPERTY_SSIPCAMPAIGN = "ssipCampaign";
    public static final String PROPERTY_SSRELOCKDATE = "ssreLockdate";
    public static final String PROPERTY_SSWHINVOICETAXINCOME = "sswhInvoicetaxIncome";
    public static final String PROPERTY_SSRELOCKEDBY = "ssreLockedby";
    public static final String PROPERTY_SSWHINVOICETAXVAT = "sswhInvoicetaxVat";
    public static final String PROPERTY_SSREREFUNDED = "ssreRefunded";
    public static final String PROPERTY_SSRECBPARTNER = "ssreCBpartner";
    public static final String PROPERTY_SSREISREFUNDED = "ssreIsrefunded";
    public static final String PROPERTY_SSREREFUNDEDINVOICEREF = "ssreRefundedinvoiceRef";
    public static final String PROPERTY_SSREREFUNDEDINVLINEREF = "ssreRefundedinvlineRef";
    public static final String PROPERTY_SSTPCLIQUIDATE = "sstpcLiquidate";
    public static final String PROPERTY_SSEEDINITIALSUBTOTAL = "sseedInitialSubtotal";
    public static final String PROPERTY_SSEEDDISCOUNT = "sseedDiscount";
    public static final String PROPERTY_SSEEDINITIALUNITPRICE = "sseedInitialunitprice";
    public static final String PROPERTY_SSAMASSETALIENATE = "ssamAssetalienate";
    public static final String PROPERTY_SSAMALIENATE = "ssamAlienate";
    public static final String PROPERTY_SPRLIIDENTIFIER = "sprliIdentifier";
    public static final String PROPERTY_SSRIMPETAX = "ssrimpeTax";
    public static final String PROPERTY_IMDLVQTY = "imdlvQty";
    public static final String PROPERTY_IMDLVPRICE = "imdlvPrice";
    public static final String PROPERTY_SSBODADDGIFTS = "ssbodAddGifts";
    public static final String PROPERTY_IMDLVTOTALLINE = "imdlvTotalline";
    public static final String PROPERTY_SSIPICEIMPORTICE = "sSIPICEImportICE";
    public static final String PROPERTY_IMDLVTAXAMT = "imdlvTaxamt";
    public static final String PROPERTY_IMDLVNETPRICE = "imdlvNetprice";
    public static final String PROPERTY_SSIPREFERENCENO = "ssipReferenceno";
    public static final String PROPERTY_SSFIINITIALSUBTOTAL = "ssfiInitialSubtotal";
    public static final String PROPERTY_SSACASSETGROUP = "ssacAssetGroup";
    public static final String PROPERTY_SSACASSETTYPE = "ssacAssettype";
    public static final String PROPERTY_SSBODDISCOUNTRATE = "ssbodDiscountRate";
    public static final String PROPERTY_SSIMACCDATAIMPORT = "ssimaccDataimport";
    public static final String PROPERTY_SSORELINVLINEID = "ssorelInvlineid";
    public static final String PROPERTY_SSIMPCNTYPE = "ssimpcnType";
    public static final String PROPERTY_SSIMPCNIMPCONSOL = "ssimpcnImpConsol";
    public static final String PROPERTY_SSAMALIENATELINE = "ssamAlienateline";
    public static final String PROPERTY_INVOICELINEBOMPARENTIDLIST = "invoiceLineBOMParentIDList";
    public static final String PROPERTY_INVOICELINEEMSSREREFUNDEDINVLINEREFIDLIST = "invoiceLineEMSsreRefundedinvlineRefIDList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELINEOFFERLIST = "invoiceLineOfferList";
    public static final String PROPERTY_INVOICELINETAXLIST = "invoiceLineTaxList";
    public static final String PROPERTY_INVOICELINEV2LIST = "invoiceLineV2List";
    public static final String PROPERTY_LANDEDCOSTCOSTLIST = "landedCostCostList";
    public static final String PROPERTY_LANDEDCOSTMATCHEDLIST = "landedCostMatchedList";
    public static final String PROPERTY_MANUFACTURINGPRODUCTIONRUNINVOICELINELIST = "manufacturingProductionRunInvoiceLineList";
    public static final String PROPERTY_MATERIALMGMTCOSTINGLIST = "materialMgmtCostingList";
    public static final String PROPERTY_PROCUREMENTPOINVOICEMATCHLIST = "procurementPOInvoiceMatchList";
    public static final String PROPERTY_PROCUREMENTRECEIPTINVOICEMATCHLIST = "procurementReceiptInvoiceMatchList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELINELIST = "sSWSWithholdingSaleLineList";
    public static final String PROPERTY_SALESCOMMISSIONDETAILLIST = "salesCommissionDetailList";
    public static final String PROPERTY_SSWOSVEHICLEEMSATMACINVOICELINEIDLIST = "sswosVehicleEMSatmacInvoicelineIDList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_IMDLVWITHHOLDINGLINELIST = "imdlvWithholdinglineList";
    public static final String PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST = "scomstUnpaidCommissionList";
    public static final String PROPERTY_SINVMINSQUAREBILLLIST = "sinvminSquareBillList";
    public static final String PROPERTY_SPROCTMTASKCONTRACTLIST = "sproctmTaskContractList";
    public static final String PROPERTY_SSBODGIFTINVOICELIST = "ssbodGiftInvoiceList";
    public static final String PROPERTY_SSDCCPDISTCOSTCENTERLIST = "ssdccpDistcostcenterList";
    public static final String PROPERTY_SSIMPCNIMPCONSOLDETAILLIST = "ssimpcnImpConsolDetailList";
    public static final String PROPERTY_SSIMPCNIMPORTATIONCOSTLIST = "ssimpcnImportationCostList";
    public static final String PROPERTY_SSTPCLIQPRJINVVLIST = "sstpcLiqPrjInvVList";
    public static final String PROPERTY_SSTPCRELATEDCOSTSLIST = "sstpcRelatedCostsList";

    public InvoiceLine() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_FINANCIALINVOICELINE, false);
        setDefaultValue(PROPERTY_INVOICEDQUANTITY, new BigDecimal(1));
        setDefaultValue(PROPERTY_DESCRIPTIONONLY, false);
        setDefaultValue(PROPERTY_STANDARDPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_EXCLUDEFORWITHHOLDING, false);
        setDefaultValue(PROPERTY_EDITLINEAMOUNT, false);
        setDefaultValue(PROPERTY_GROSSAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_GROSSUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BASEGROSSUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEFERRED, false);
        setDefaultValue(PROPERTY_EXPLODE, false);
        setDefaultValue(PROPERTY_SSAMASSET, false);
        setDefaultValue(PROPERTY_MATCHLCCOSTS, false);
        setDefaultValue(PROPERTY_SSIPIMPORTTYPE, false);
        setDefaultValue(PROPERTY_SSREISREFUNDED, false);
        setDefaultValue(PROPERTY_SSTPCLIQUIDATE, false);
        setDefaultValue(PROPERTY_SSEEDINITIALSUBTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSEEDDISCOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSEEDINITIALUNITPRICE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSBODADDGIFTS, false);
        setDefaultValue(PROPERTY_SSFIINITIALSUBTOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSBODDISCOUNTRATE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSIMACCDATAIMPORT, false);
        setDefaultValue(PROPERTY_INVOICELINEBOMPARENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSREREFUNDEDINVLINEREFIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEOFFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTMATCHEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGPRODUCTIONRUNINVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTCOSTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTRECEIPTINVOICEMATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSVEHICLEEMSATMACINVOICELINEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVWITHHOLDINGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SINVMINSQUAREBILLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDCCPDISTCOSTCENTERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPCONSOLDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCLIQPRJINVVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDCOSTSLIST, new ArrayList<Object>());
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

    public OrderLine getSalesOrderLine() {
        return (OrderLine) get(PROPERTY_SALESORDERLINE);
    }

    public void setSalesOrderLine(OrderLine salesOrderLine) {
        set(PROPERTY_SALESORDERLINE, salesOrderLine);
    }

    public ShipmentInOutLine getGoodsShipmentLine() {
        return (ShipmentInOutLine) get(PROPERTY_GOODSSHIPMENTLINE);
    }

    public void setGoodsShipmentLine(ShipmentInOutLine goodsShipmentLine) {
        set(PROPERTY_GOODSSHIPMENTLINE, goodsShipmentLine);
    }

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
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

    public GLItem getAccount() {
        return (GLItem) get(PROPERTY_ACCOUNT);
    }

    public void setAccount(GLItem account) {
        set(PROPERTY_ACCOUNT, account);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public BigDecimal getInvoicedQuantity() {
        return (BigDecimal) get(PROPERTY_INVOICEDQUANTITY);
    }

    public void setInvoicedQuantity(BigDecimal invoicedQuantity) {
        set(PROPERTY_INVOICEDQUANTITY, invoicedQuantity);
    }

    public BigDecimal getListPrice() {
        return (BigDecimal) get(PROPERTY_LISTPRICE);
    }

    public void setListPrice(BigDecimal listPrice) {
        set(PROPERTY_LISTPRICE, listPrice);
    }

    public BigDecimal getUnitPrice() {
        return (BigDecimal) get(PROPERTY_UNITPRICE);
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        set(PROPERTY_UNITPRICE, unitPrice);
    }

    public BigDecimal getPriceLimit() {
        return (BigDecimal) get(PROPERTY_PRICELIMIT);
    }

    public void setPriceLimit(BigDecimal priceLimit) {
        set(PROPERTY_PRICELIMIT, priceLimit);
    }

    public BigDecimal getLineNetAmount() {
        return (BigDecimal) get(PROPERTY_LINENETAMOUNT);
    }

    public void setLineNetAmount(BigDecimal lineNetAmount) {
        set(PROPERTY_LINENETAMOUNT, lineNetAmount);
    }

    public GLCharge getCharge() {
        return (GLCharge) get(PROPERTY_CHARGE);
    }

    public void setCharge(GLCharge charge) {
        set(PROPERTY_CHARGE, charge);
    }

    public BigDecimal getChargeAmount() {
        return (BigDecimal) get(PROPERTY_CHARGEAMOUNT);
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        set(PROPERTY_CHARGEAMOUNT, chargeAmount);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public ResourceAssignment getResourceAssignment() {
        return (ResourceAssignment) get(PROPERTY_RESOURCEASSIGNMENT);
    }

    public void setResourceAssignment(ResourceAssignment resourceAssignment) {
        set(PROPERTY_RESOURCEASSIGNMENT, resourceAssignment);
    }

    public BigDecimal getTaxAmount() {
        return (BigDecimal) get(PROPERTY_TAXAMOUNT);
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        set(PROPERTY_TAXAMOUNT, taxAmount);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public Boolean isDescriptionOnly() {
        return (Boolean) get(PROPERTY_DESCRIPTIONONLY);
    }

    public void setDescriptionOnly(Boolean descriptionOnly) {
        set(PROPERTY_DESCRIPTIONONLY, descriptionOnly);
    }

    public BigDecimal getOrderQuantity() {
        return (BigDecimal) get(PROPERTY_ORDERQUANTITY);
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        set(PROPERTY_ORDERQUANTITY, orderQuantity);
    }

    public ProductUOM getOrderUOM() {
        return (ProductUOM) get(PROPERTY_ORDERUOM);
    }

    public void setOrderUOM(ProductUOM orderUOM) {
        set(PROPERTY_ORDERUOM, orderUOM);
    }

    public InvoiceDiscount getInvoiceDiscount() {
        return (InvoiceDiscount) get(PROPERTY_INVOICEDISCOUNT);
    }

    public void setInvoiceDiscount(InvoiceDiscount invoiceDiscount) {
        set(PROPERTY_INVOICEDISCOUNT, invoiceDiscount);
    }

    public ProjectLine getProjectLine() {
        return (ProjectLine) get(PROPERTY_PROJECTLINE);
    }

    public void setProjectLine(ProjectLine projectLine) {
        set(PROPERTY_PROJECTLINE, projectLine);
    }

    public PriceAdjustment getPriceAdjustment() {
        return (PriceAdjustment) get(PROPERTY_PRICEADJUSTMENT);
    }

    public void setPriceAdjustment(PriceAdjustment priceAdjustment) {
        set(PROPERTY_PRICEADJUSTMENT, priceAdjustment);
    }

    public BigDecimal getStandardPrice() {
        return (BigDecimal) get(PROPERTY_STANDARDPRICE);
    }

    public void setStandardPrice(BigDecimal standardPrice) {
        set(PROPERTY_STANDARDPRICE, standardPrice);
    }

    public Boolean isExcludeforwithholding() {
        return (Boolean) get(PROPERTY_EXCLUDEFORWITHHOLDING);
    }

    public void setExcludeforwithholding(Boolean excludeforwithholding) {
        set(PROPERTY_EXCLUDEFORWITHHOLDING, excludeforwithholding);
    }

    public Boolean isEditLineAmount() {
        return (Boolean) get(PROPERTY_EDITLINEAMOUNT);
    }

    public void setEditLineAmount(Boolean editLineAmount) {
        set(PROPERTY_EDITLINEAMOUNT, editLineAmount);
    }

    public BigDecimal getTaxableAmount() {
        return (BigDecimal) get(PROPERTY_TAXABLEAMOUNT);
    }

    public void setTaxableAmount(BigDecimal taxableAmount) {
        set(PROPERTY_TAXABLEAMOUNT, taxableAmount);
    }

    public BigDecimal getGrossAmount() {
        return (BigDecimal) get(PROPERTY_GROSSAMOUNT);
    }

    public void setGrossAmount(BigDecimal grossAmount) {
        set(PROPERTY_GROSSAMOUNT, grossAmount);
    }

    public BigDecimal getGrossUnitPrice() {
        return (BigDecimal) get(PROPERTY_GROSSUNITPRICE);
    }

    public void setGrossUnitPrice(BigDecimal grossUnitPrice) {
        set(PROPERTY_GROSSUNITPRICE, grossUnitPrice);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Long getPeriodNumber() {
        return (Long) get(PROPERTY_PERIODNUMBER);
    }

    public void setPeriodNumber(Long periodNumber) {
        set(PROPERTY_PERIODNUMBER, periodNumber);
    }

    public BigDecimal getBaseGrossUnitPrice() {
        return (BigDecimal) get(PROPERTY_BASEGROSSUNITPRICE);
    }

    public void setBaseGrossUnitPrice(BigDecimal baseGrossUnitPrice) {
        set(PROPERTY_BASEGROSSUNITPRICE, baseGrossUnitPrice);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public String getDeferredPlanType() {
        return (String) get(PROPERTY_DEFERREDPLANTYPE);
    }

    public void setDeferredPlanType(String deferredPlanType) {
        set(PROPERTY_DEFERREDPLANTYPE, deferredPlanType);
    }

    public BigDecimal getGrossListPrice() {
        return (BigDecimal) get(PROPERTY_GROSSLISTPRICE);
    }

    public void setGrossListPrice(BigDecimal grossListPrice) {
        set(PROPERTY_GROSSLISTPRICE, grossListPrice);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isDeferred() {
        return (Boolean) get(PROPERTY_DEFERRED);
    }

    public void setDeferred(Boolean deferred) {
        set(PROPERTY_DEFERRED, deferred);
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

    public UserDimension1 getStDimension() {
        return (UserDimension1) get(PROPERTY_STDIMENSION);
    }

    public void setStDimension(UserDimension1 stDimension) {
        set(PROPERTY_STDIMENSION, stDimension);
    }

    public UserDimension2 getNdDimension() {
        return (UserDimension2) get(PROPERTY_NDDIMENSION);
    }

    public void setNdDimension(UserDimension2 ndDimension) {
        set(PROPERTY_NDDIMENSION, ndDimension);
    }

    public Boolean isExplode() {
        return (Boolean) get(PROPERTY_EXPLODE);
    }

    public void setExplode(Boolean explode) {
        set(PROPERTY_EXPLODE, explode);
    }

    public InvoiceLine getBOMParent() {
        return (InvoiceLine) get(PROPERTY_BOMPARENT);
    }

    public void setBOMParent(InvoiceLine bOMParent) {
        set(PROPERTY_BOMPARENT, bOMParent);
    }

    public Boolean isSsamAsset() {
        return (Boolean) get(PROPERTY_SSAMASSET);
    }

    public void setSsamAsset(Boolean ssamAsset) {
        set(PROPERTY_SSAMASSET, ssamAsset);
    }

    public Boolean isMatchLCCosts() {
        return (Boolean) get(PROPERTY_MATCHLCCOSTS);
    }

    public void setMatchLCCosts(Boolean matchLCCosts) {
        set(PROPERTY_MATCHLCCOSTS, matchLCCosts);
    }

    public Asset getSsamAAsset() {
        return (Asset) get(PROPERTY_SSAMAASSET);
    }

    public void setSsamAAsset(Asset ssamAAsset) {
        set(PROPERTY_SSAMAASSET, ssamAAsset);
    }

    public UOM getOperativeUOM() {
        return (UOM) get(PROPERTY_OPERATIVEUOM);
    }

    public void setOperativeUOM(UOM operativeUOM) {
        set(PROPERTY_OPERATIVEUOM, operativeUOM);
    }

    public Boolean isSsipImporttype() {
        return (Boolean) get(PROPERTY_SSIPIMPORTTYPE);
    }

    public void setSsipImporttype(Boolean ssipImporttype) {
        set(PROPERTY_SSIPIMPORTTYPE, ssipImporttype);
    }

    public BigDecimal getOperativeQuantity() {
        return (BigDecimal) get(PROPERTY_OPERATIVEQUANTITY);
    }

    public void setOperativeQuantity(BigDecimal operativeQuantity) {
        set(PROPERTY_OPERATIVEQUANTITY, operativeQuantity);
    }

    public Campaign getSsipCampaign() {
        return (Campaign) get(PROPERTY_SSIPCAMPAIGN);
    }

    public void setSsipCampaign(Campaign ssipCampaign) {
        set(PROPERTY_SSIPCAMPAIGN, ssipCampaign);
    }

    public Date getSsreLockdate() {
        return (Date) get(PROPERTY_SSRELOCKDATE);
    }

    public void setSsreLockdate(Date ssreLockdate) {
        set(PROPERTY_SSRELOCKDATE, ssreLockdate);
    }

    public InvoiceTax getSswhInvoicetaxIncome() {
        return (InvoiceTax) get(PROPERTY_SSWHINVOICETAXINCOME);
    }

    public void setSswhInvoicetaxIncome(InvoiceTax sswhInvoicetaxIncome) {
        set(PROPERTY_SSWHINVOICETAXINCOME, sswhInvoicetaxIncome);
    }

    public String getSsreLockedby() {
        return (String) get(PROPERTY_SSRELOCKEDBY);
    }

    public void setSsreLockedby(String ssreLockedby) {
        set(PROPERTY_SSRELOCKEDBY, ssreLockedby);
    }

    public InvoiceTax getSswhInvoicetaxVat() {
        return (InvoiceTax) get(PROPERTY_SSWHINVOICETAXVAT);
    }

    public void setSswhInvoicetaxVat(InvoiceTax sswhInvoicetaxVat) {
        set(PROPERTY_SSWHINVOICETAXVAT, sswhInvoicetaxVat);
    }

    public ssrerefund getSsreRefunded() {
        return (ssrerefund) get(PROPERTY_SSREREFUNDED);
    }

    public void setSsreRefunded(ssrerefund ssreRefunded) {
        set(PROPERTY_SSREREFUNDED, ssreRefunded);
    }

    public BusinessPartner getSsreCBpartner() {
        return (BusinessPartner) get(PROPERTY_SSRECBPARTNER);
    }

    public void setSsreCBpartner(BusinessPartner ssreCBpartner) {
        set(PROPERTY_SSRECBPARTNER, ssreCBpartner);
    }

    public Boolean isSsreIsrefunded() {
        return (Boolean) get(PROPERTY_SSREISREFUNDED);
    }

    public void setSsreIsrefunded(Boolean ssreIsrefunded) {
        set(PROPERTY_SSREISREFUNDED, ssreIsrefunded);
    }

    public Invoice getSsreRefundedinvoiceRef() {
        return (Invoice) get(PROPERTY_SSREREFUNDEDINVOICEREF);
    }

    public void setSsreRefundedinvoiceRef(Invoice ssreRefundedinvoiceRef) {
        set(PROPERTY_SSREREFUNDEDINVOICEREF, ssreRefundedinvoiceRef);
    }

    public InvoiceLine getSsreRefundedinvlineRef() {
        return (InvoiceLine) get(PROPERTY_SSREREFUNDEDINVLINEREF);
    }

    public void setSsreRefundedinvlineRef(InvoiceLine ssreRefundedinvlineRef) {
        set(PROPERTY_SSREREFUNDEDINVLINEREF, ssreRefundedinvlineRef);
    }

    public Boolean isSstpcLiquidate() {
        return (Boolean) get(PROPERTY_SSTPCLIQUIDATE);
    }

    public void setSstpcLiquidate(Boolean sstpcLiquidate) {
        set(PROPERTY_SSTPCLIQUIDATE, sstpcLiquidate);
    }

    public BigDecimal getSseedInitialSubtotal() {
        return (BigDecimal) get(PROPERTY_SSEEDINITIALSUBTOTAL);
    }

    public void setSseedInitialSubtotal(BigDecimal sseedInitialSubtotal) {
        set(PROPERTY_SSEEDINITIALSUBTOTAL, sseedInitialSubtotal);
    }

    public BigDecimal getSseedDiscount() {
        return (BigDecimal) get(PROPERTY_SSEEDDISCOUNT);
    }

    public void setSseedDiscount(BigDecimal sseedDiscount) {
        set(PROPERTY_SSEEDDISCOUNT, sseedDiscount);
    }

    public BigDecimal getSseedInitialunitprice() {
        return (BigDecimal) get(PROPERTY_SSEEDINITIALUNITPRICE);
    }

    public void setSseedInitialunitprice(BigDecimal sseedInitialunitprice) {
        set(PROPERTY_SSEEDINITIALUNITPRICE, sseedInitialunitprice);
    }

    public String getSsamAssetalienate() {
        return (String) get(PROPERTY_SSAMASSETALIENATE);
    }

    public void setSsamAssetalienate(String ssamAssetalienate) {
        set(PROPERTY_SSAMASSETALIENATE, ssamAssetalienate);
    }

    public ssamalienate getSsamAlienate() {
        return (ssamalienate) get(PROPERTY_SSAMALIENATE);
    }

    public void setSsamAlienate(ssamalienate ssamAlienate) {
        set(PROPERTY_SSAMALIENATE, ssamAlienate);
    }

    public String getSprliIdentifier() {
        return (String) get(PROPERTY_SPRLIIDENTIFIER);
    }

    public void setSprliIdentifier(String sprliIdentifier) {
        set(PROPERTY_SPRLIIDENTIFIER, sprliIdentifier);
    }

    public TaxRate getSsrimpeTax() {
        return (TaxRate) get(PROPERTY_SSRIMPETAX);
    }

    public void setSsrimpeTax(TaxRate ssrimpeTax) {
        set(PROPERTY_SSRIMPETAX, ssrimpeTax);
    }

    public BigDecimal getImdlvQty() {
        return (BigDecimal) get(PROPERTY_IMDLVQTY);
    }

    public void setImdlvQty(BigDecimal imdlvQty) {
        set(PROPERTY_IMDLVQTY, imdlvQty);
    }

    public BigDecimal getImdlvPrice() {
        return (BigDecimal) get(PROPERTY_IMDLVPRICE);
    }

    public void setImdlvPrice(BigDecimal imdlvPrice) {
        set(PROPERTY_IMDLVPRICE, imdlvPrice);
    }

    public Boolean isSsbodAddGifts() {
        return (Boolean) get(PROPERTY_SSBODADDGIFTS);
    }

    public void setSsbodAddGifts(Boolean ssbodAddGifts) {
        set(PROPERTY_SSBODADDGIFTS, ssbodAddGifts);
    }

    public BigDecimal getImdlvTotalline() {
        return (BigDecimal) get(PROPERTY_IMDLVTOTALLINE);
    }

    public void setImdlvTotalline(BigDecimal imdlvTotalline) {
        set(PROPERTY_IMDLVTOTALLINE, imdlvTotalline);
    }

    public Campaign getSSIPICEImportICE() {
        return (Campaign) get(PROPERTY_SSIPICEIMPORTICE);
    }

    public void setSSIPICEImportICE(Campaign sSIPICEImportICE) {
        set(PROPERTY_SSIPICEIMPORTICE, sSIPICEImportICE);
    }

    public BigDecimal getImdlvTaxamt() {
        return (BigDecimal) get(PROPERTY_IMDLVTAXAMT);
    }

    public void setImdlvTaxamt(BigDecimal imdlvTaxamt) {
        set(PROPERTY_IMDLVTAXAMT, imdlvTaxamt);
    }

    public BigDecimal getImdlvNetprice() {
        return (BigDecimal) get(PROPERTY_IMDLVNETPRICE);
    }

    public void setImdlvNetprice(BigDecimal imdlvNetprice) {
        set(PROPERTY_IMDLVNETPRICE, imdlvNetprice);
    }

    public String getSsipReferenceno() {
        return (String) get(PROPERTY_SSIPREFERENCENO);
    }

    public void setSsipReferenceno(String ssipReferenceno) {
        set(PROPERTY_SSIPREFERENCENO, ssipReferenceno);
    }

    public BigDecimal getSsfiInitialSubtotal() {
        return (BigDecimal) get(PROPERTY_SSFIINITIALSUBTOTAL);
    }

    public void setSsfiInitialSubtotal(BigDecimal ssfiInitialSubtotal) {
        set(PROPERTY_SSFIINITIALSUBTOTAL, ssfiInitialSubtotal);
    }

    public AssetGroup getSsacAssetGroup() {
        return (AssetGroup) get(PROPERTY_SSACASSETGROUP);
    }

    public void setSsacAssetGroup(AssetGroup ssacAssetGroup) {
        set(PROPERTY_SSACASSETGROUP, ssacAssetGroup);
    }

    public String getSsacAssettype() {
        return (String) get(PROPERTY_SSACASSETTYPE);
    }

    public void setSsacAssettype(String ssacAssettype) {
        set(PROPERTY_SSACASSETTYPE, ssacAssettype);
    }

    public BigDecimal getSsbodDiscountRate() {
        return (BigDecimal) get(PROPERTY_SSBODDISCOUNTRATE);
    }

    public void setSsbodDiscountRate(BigDecimal ssbodDiscountRate) {
        set(PROPERTY_SSBODDISCOUNTRATE, ssbodDiscountRate);
    }

    public Boolean isSsimaccDataimport() {
        return (Boolean) get(PROPERTY_SSIMACCDATAIMPORT);
    }

    public void setSsimaccDataimport(Boolean ssimaccDataimport) {
        set(PROPERTY_SSIMACCDATAIMPORT, ssimaccDataimport);
    }

    public String getSsorelInvlineid() {
        return (String) get(PROPERTY_SSORELINVLINEID);
    }

    public void setSsorelInvlineid(String ssorelInvlineid) {
        set(PROPERTY_SSORELINVLINEID, ssorelInvlineid);
    }

    public String getSsimpcnType() {
        return (String) get(PROPERTY_SSIMPCNTYPE);
    }

    public void setSsimpcnType(String ssimpcnType) {
        set(PROPERTY_SSIMPCNTYPE, ssimpcnType);
    }

    public Ssimpcn_ImpConsolidation getSsimpcnImpConsol() {
        return (Ssimpcn_ImpConsolidation) get(PROPERTY_SSIMPCNIMPCONSOL);
    }

    public void setSsimpcnImpConsol(Ssimpcn_ImpConsolidation ssimpcnImpConsol) {
        set(PROPERTY_SSIMPCNIMPCONSOL, ssimpcnImpConsol);
    }

    public ssamalienateline getSsamAlienateline() {
        return (ssamalienateline) get(PROPERTY_SSAMALIENATELINE);
    }

    public void setSsamAlienateline(ssamalienateline ssamAlienateline) {
        set(PROPERTY_SSAMALIENATELINE, ssamAlienateline);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineBOMParentIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEBOMPARENTIDLIST);
    }

    public void setInvoiceLineBOMParentIDList(List<InvoiceLine> invoiceLineBOMParentIDList) {
        set(PROPERTY_INVOICELINEBOMPARENTIDLIST, invoiceLineBOMParentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsreRefundedinvlineRefIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSREREFUNDEDINVLINEREFIDLIST);
    }

    public void setInvoiceLineEMSsreRefundedinvlineRefIDList(List<InvoiceLine> invoiceLineEMSsreRefundedinvlineRefIDList) {
        set(PROPERTY_INVOICELINEEMSSREREFUNDEDINVLINEREFIDLIST, invoiceLineEMSsreRefundedinvlineRefIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineOffer> getInvoiceLineOfferList() {
      return (List<InvoiceLineOffer>) get(PROPERTY_INVOICELINEOFFERLIST);
    }

    public void setInvoiceLineOfferList(List<InvoiceLineOffer> invoiceLineOfferList) {
        set(PROPERTY_INVOICELINEOFFERLIST, invoiceLineOfferList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineTax> getInvoiceLineTaxList() {
      return (List<InvoiceLineTax>) get(PROPERTY_INVOICELINETAXLIST);
    }

    public void setInvoiceLineTaxList(List<InvoiceLineTax> invoiceLineTaxList) {
        set(PROPERTY_INVOICELINETAXLIST, invoiceLineTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineV2> getInvoiceLineV2List() {
      return (List<InvoiceLineV2>) get(PROPERTY_INVOICELINEV2LIST);
    }

    public void setInvoiceLineV2List(List<InvoiceLineV2> invoiceLineV2List) {
        set(PROPERTY_INVOICELINEV2LIST, invoiceLineV2List);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostCost> getLandedCostCostList() {
      return (List<LandedCostCost>) get(PROPERTY_LANDEDCOSTCOSTLIST);
    }

    public void setLandedCostCostList(List<LandedCostCost> landedCostCostList) {
        set(PROPERTY_LANDEDCOSTCOSTLIST, landedCostCostList);
    }

    @SuppressWarnings("unchecked")
    public List<LCMatched> getLandedCostMatchedList() {
      return (List<LCMatched>) get(PROPERTY_LANDEDCOSTMATCHEDLIST);
    }

    public void setLandedCostMatchedList(List<LCMatched> landedCostMatchedList) {
        set(PROPERTY_LANDEDCOSTMATCHEDLIST, landedCostMatchedList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRunInvoiceLine> getManufacturingProductionRunInvoiceLineList() {
      return (List<ProductionRunInvoiceLine>) get(PROPERTY_MANUFACTURINGPRODUCTIONRUNINVOICELINELIST);
    }

    public void setManufacturingProductionRunInvoiceLineList(List<ProductionRunInvoiceLine> manufacturingProductionRunInvoiceLineList) {
        set(PROPERTY_MANUFACTURINGPRODUCTIONRUNINVOICELINELIST, manufacturingProductionRunInvoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Costing> getMaterialMgmtCostingList() {
      return (List<Costing>) get(PROPERTY_MATERIALMGMTCOSTINGLIST);
    }

    public void setMaterialMgmtCostingList(List<Costing> materialMgmtCostingList) {
        set(PROPERTY_MATERIALMGMTCOSTINGLIST, materialMgmtCostingList);
    }

    @SuppressWarnings("unchecked")
    public List<POInvoiceMatch> getProcurementPOInvoiceMatchList() {
      return (List<POInvoiceMatch>) get(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST);
    }

    public void setProcurementPOInvoiceMatchList(List<POInvoiceMatch> procurementPOInvoiceMatchList) {
        set(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST, procurementPOInvoiceMatchList);
    }

    @SuppressWarnings("unchecked")
    public List<ReceiptInvoiceMatch> getProcurementReceiptInvoiceMatchList() {
      return (List<ReceiptInvoiceMatch>) get(PROPERTY_PROCUREMENTRECEIPTINVOICEMATCHLIST);
    }

    public void setProcurementReceiptInvoiceMatchList(List<ReceiptInvoiceMatch> procurementReceiptInvoiceMatchList) {
        set(PROPERTY_PROCUREMENTRECEIPTINVOICEMATCHLIST, procurementReceiptInvoiceMatchList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSaleLine> getSSWSWithholdingSaleLineList() {
      return (List<SSWSWithholdingSaleLine>) get(PROPERTY_SSWSWITHHOLDINGSALELINELIST);
    }

    public void setSSWSWithholdingSaleLineList(List<SSWSWithholdingSaleLine> sSWSWithholdingSaleLineList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELINELIST, sSWSWithholdingSaleLineList);
    }

    @SuppressWarnings("unchecked")
    public List<CommissionDetail> getSalesCommissionDetailList() {
      return (List<CommissionDetail>) get(PROPERTY_SALESCOMMISSIONDETAILLIST);
    }

    public void setSalesCommissionDetailList(List<CommissionDetail> salesCommissionDetailList) {
        set(PROPERTY_SALESCOMMISSIONDETAILLIST, salesCommissionDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosVehicle> getSswosVehicleEMSatmacInvoicelineIDList() {
      return (List<SswosVehicle>) get(PROPERTY_SSWOSVEHICLEEMSATMACINVOICELINEIDLIST);
    }

    public void setSswosVehicleEMSatmacInvoicelineIDList(List<SswosVehicle> sswosVehicleEMSatmacInvoicelineIDList) {
        set(PROPERTY_SSWOSVEHICLEEMSATMACINVOICELINEIDLIST, sswosVehicleEMSatmacInvoicelineIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
      return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLineV> getTimeAndExpenseSheetLineVList() {
      return (List<SheetLineV>) get(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST);
    }

    public void setTimeAndExpenseSheetLineVList(List<SheetLineV> timeAndExpenseSheetLineVList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, timeAndExpenseSheetLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvWthholdingline> getImdlvWithholdinglineList() {
      return (List<ImdlvWthholdingline>) get(PROPERTY_IMDLVWITHHOLDINGLINELIST);
    }

    public void setImdlvWithholdinglineList(List<ImdlvWthholdingline> imdlvWithholdinglineList) {
        set(PROPERTY_IMDLVWITHHOLDINGLINELIST, imdlvWithholdinglineList);
    }

    @SuppressWarnings("unchecked")
    public List<scomst_unpaid_commission> getScomstUnpaidCommissionList() {
      return (List<scomst_unpaid_commission>) get(PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST);
    }

    public void setScomstUnpaidCommissionList(List<scomst_unpaid_commission> scomstUnpaidCommissionList) {
        set(PROPERTY_SCOMSTUNPAIDCOMMISSIONLIST, scomstUnpaidCommissionList);
    }

    @SuppressWarnings("unchecked")
    public List<Sinvmin_SquareBill> getSinvminSquareBillList() {
      return (List<Sinvmin_SquareBill>) get(PROPERTY_SINVMINSQUAREBILLLIST);
    }

    public void setSinvminSquareBillList(List<Sinvmin_SquareBill> sinvminSquareBillList) {
        set(PROPERTY_SINVMINSQUAREBILLLIST, sinvminSquareBillList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskContract> getSproctmTaskContractList() {
      return (List<SproctmTaskContract>) get(PROPERTY_SPROCTMTASKCONTRACTLIST);
    }

    public void setSproctmTaskContractList(List<SproctmTaskContract> sproctmTaskContractList) {
        set(PROPERTY_SPROCTMTASKCONTRACTLIST, sproctmTaskContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftInvoice> getSsbodGiftInvoiceList() {
      return (List<SsbodGiftInvoice>) get(PROPERTY_SSBODGIFTINVOICELIST);
    }

    public void setSsbodGiftInvoiceList(List<SsbodGiftInvoice> ssbodGiftInvoiceList) {
        set(PROPERTY_SSBODGIFTINVOICELIST, ssbodGiftInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdccpDistributeCostCenter> getSsdccpDistcostcenterList() {
      return (List<SsdccpDistributeCostCenter>) get(PROPERTY_SSDCCPDISTCOSTCENTERLIST);
    }

    public void setSsdccpDistcostcenterList(List<SsdccpDistributeCostCenter> ssdccpDistcostcenterList) {
        set(PROPERTY_SSDCCPDISTCOSTCENTERLIST, ssdccpDistcostcenterList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImpConsolDetail> getSsimpcnImpConsolDetailList() {
      return (List<Ssimpcn_ImpConsolDetail>) get(PROPERTY_SSIMPCNIMPCONSOLDETAILLIST);
    }

    public void setSsimpcnImpConsolDetailList(List<Ssimpcn_ImpConsolDetail> ssimpcnImpConsolDetailList) {
        set(PROPERTY_SSIMPCNIMPCONSOLDETAILLIST, ssimpcnImpConsolDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImportationCost> getSsimpcnImportationCostList() {
      return (List<Ssimpcn_ImportationCost>) get(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST);
    }

    public void setSsimpcnImportationCostList(List<Ssimpcn_ImportationCost> ssimpcnImportationCostList) {
        set(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST, ssimpcnImportationCostList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcLiquidationProjectsInvoiceView> getSstpcLiqPrjInvVList() {
      return (List<SstpcLiquidationProjectsInvoiceView>) get(PROPERTY_SSTPCLIQPRJINVVLIST);
    }

    public void setSstpcLiqPrjInvVList(List<SstpcLiquidationProjectsInvoiceView> sstpcLiqPrjInvVList) {
        set(PROPERTY_SSTPCLIQPRJINVVLIST, sstpcLiqPrjInvVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcRelatedCosts> getSstpcRelatedCostsList() {
      return (List<SstpcRelatedCosts>) get(PROPERTY_SSTPCRELATEDCOSTSLIST);
    }

    public void setSstpcRelatedCostsList(List<SstpcRelatedCosts> sstpcRelatedCostsList) {
        set(PROPERTY_SSTPCRELATEDCOSTSLIST, sstpcRelatedCostsList);
    }

}
