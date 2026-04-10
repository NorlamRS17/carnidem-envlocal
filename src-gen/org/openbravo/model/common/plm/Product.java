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
package org.openbravo.model.common.plm;

import com.atrums.indumot.datosmaestros.data.AtimdmMarcaProducto;
import com.atrums.indumoto.postventa.data.atindpo_postventalinea;
import com.atrums.ventas.factores.data.atvefFactor;
import com.sidesoft.ecuador.asset.allocation.SsalActiveMain;
import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.SsalAssetReturn;
import com.sidesoft.inventory.movement.frominvoice.Sinvmin_SquareBill;
import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;
import com.sidesoft.localization.ecuador.finances.ssfiFin_payment_detail_v;
import com.sidesoft.localization.ecuador.invoices.Sfpsi_ReconcileSalesOrderV;
import com.sidesoft.localization.ecuador.refunds.RefundConfiguration;
import com.sidesoft.localization.ecuador.refunds.Ssre_RefundInvoiceLine;
import com.sidesoft.localization.ecuador.refunds.ssrerefundinvoice;
import com.sidesoft.localization.ecuador.withholdings.WithholdingSource;
import com.sidesoft.localization.productSubcategory.SlpsProductCategory;
import com.sidesoft.localization.productSubcategory.SlpsSubcategoryProduct;

import ec.com.sidesoft.app.production.quality.Ssapq_AppParamMovil;
import ec.com.sidesoft.backoffice.discount.SsbodGiftInvoice;
import ec.com.sidesoft.backoffice.discount.SsbodGiftOrder;
import ec.com.sidesoft.backoffice.discount.SsbodGiftTemp;
import ec.com.sidesoft.backoffice.discount.ssbodGCProduct;
import ec.com.sidesoft.carnidem.breakdown.ecscb_TypeBreakdownLine;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown_line;
import ec.com.sidesoft.cash.flow.SscflwExpensivePayoutView;
import ec.com.sidesoft.custom.mrp.forecast.ScmfForecastByMonth;
import ec.com.sidesoft.custom.mrp.forecast.ScmfMrpProdSubCategory;
import ec.com.sidesoft.custom.mrp.forecast.ScmfPendingOrdersTmp;
import ec.com.sidesoft.custom.mrp.forecast.ScmfProcessProduction;
import ec.com.sidesoft.custom.mrp.forecast.ScmfProduct;
import ec.com.sidesoft.custom.mrp.forecast.ScmfRegressionLineCalc;
import ec.com.sidesoft.custom.mrp.forecast.ScmfTransaction;
import ec.com.sidesoft.custom.mrp.forecast.ScmfTransactionBalance;
import ec.com.sidesoft.custom.mrp.forecast.ScmfTransactionBydate;
import ec.com.sidesoft.custom.mrp.forecast.ScmfTransactionV;
import ec.com.sidesoft.custom.mrp.forecast.ScmfTransbydateV;
import ec.com.sidesoft.custom.order.verifystock.SOVSLdmProd;
import ec.com.sidesoft.custom.order.verifystock.SOVSLdmTemp;
import ec.com.sidesoft.debitnote.interest.due.SsdnidProduct;
import ec.com.sidesoft.distribute.costcenter.SsdccpDistributeCostCenter;
import ec.com.sidesoft.imports.SSIP_Producttariffs;
import ec.com.sidesoft.imports.simulation.Simpsim_ImpSimCost;
import ec.com.sidesoft.imports.simulation.Simpsim_ImpSimLine;
import ec.com.sidesoft.inventory.adjustment.SIVAPhysicalInvtlines;
import ec.com.sidesoft.inventory.blind.register.SiblrPhysicalInvtLines;
import ec.com.sidesoft.inventory.partial.out.movement.SsipotmAttributeProduct;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_Accumulated;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_OrderLine;
import ec.com.sidesoft.localization.ecuador.resupply.ssrsresupplyline;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSaleLine;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPurchaseIinvoice;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvWthholdingline;
import ec.com.sidesoft.localization.importdata.loadvouchers.Imdlv_Lines;
import ec.com.sidesoft.localization.importdata.loadvouchers.imdlvHomologationProduct;
import ec.com.sidesoft.localization.production.lotautogen.SlplagKindpackage;
import ec.com.sidesoft.localization.quality.assurement.SlqsMProductStockView;
import ec.com.sidesoft.localization.quality.assurement.SlqsProductSafetyInProcessView;
import ec.com.sidesoft.marlon.test.esmpMatrizConfiguracionLine;
import ec.com.sidesoft.marlon.test.esmpTerceroProducto;
import ec.com.sidesoft.modify.accounting.SsmaactAccounting;
import ec.com.sidesoft.modify.accounting.SsmaactAudit;
import ec.com.sidesoft.mrp.SsmrpForecastLog;
import ec.com.sidesoft.mrp.SsmrpSalesForecast;
import ec.com.sidesoft.mrp.simulation.SsmrpsLinesTmp;
import ec.com.sidesoft.mrp.simulation.ssmrps_asim_lines;
import ec.com.sidesoft.payroll.events.SPEVProductCategory;
import ec.com.sidesoft.production.SsprodProductLotView;
import ec.com.sidesoft.production.auto.transfer.mp.spatmp_reference_transfer;
import ec.com.sidesoft.production.auto.transfer.mp.spatmp_transfer;
import ec.com.sidesoft.projects.complement.SproctmInventorySettl;
import ec.com.sidesoft.projects.complement.SproctmTaskProd;
import ec.com.sidesoft.sanfelipe.bi.ssfbi_commercial_category;
import ec.com.sidesoft.settlement.project.cost.ConsumptionLine;
import ec.com.sidesoft.settlement.project.cost.SstpcConsumptionView;
import ec.com.sidesoft.settlement.project.cost.SstpcLiquidationProjectsInvoiceView;
import ec.com.sidesoft.settlement.project.cost.SstpcMatConProjView;
import ec.com.sidesoft.settlement.project.cost.SstpcMatProjVoidView;
import ec.com.sidesoft.settlement.project.cost.SstpcMovementProductView;
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedCosts;
import ec.com.sidesoft.transaction.reversal.AccountingReversal;
import ec.com.sidesoft.warehouse.product.SwhpProductStockDetailV;
import ec.com.sidesoft.warehouse.product.SwhpWhProduct;
import ec.com.sidesoft.workorder.consult.SSWCLWorkOrderLine;
import ec.com.sidesoft.ws.ordercreate.data.SWSOCHomproduct;
import ec.com.sidesoft.ws.paymentscreate.SWSPCConfig;
import ec.com.sidesoft.xml.irbp.SsxmlDataXmlIbp;
import ec.cusoft.facturaec.EeiPaymentDetailV;
import ec.cusoft.facturaec.EeiProduct;

import it.openia.crm.OpcrmProductviewV;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.advpaymentmngt.APRM_Finacc_Trx_Full_Acct_V;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.client.widgets.OBWCL_StockByWarehouseView;
import org.openbravo.model.ad.access.ServiceProduct;
import org.openbravo.model.ad.access.ServiceProductCategory;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.system.ClientInformation;
import org.openbravo.model.ad.utility.Image;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.ProductTemplate;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceLineAccountingDimension;
import org.openbravo.model.common.invoice.InvoiceLineV2;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineAccountingDimension;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.BudgetLine;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchemaElement;
import org.openbravo.model.financialmgmt.assetmgmt.AmortizationLineAccountingDimension;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetailV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
import org.openbravo.model.manufacturing.processplan.OperationProduct;
import org.openbravo.model.manufacturing.processplan.ProcessPlan;
import org.openbravo.model.manufacturing.quality.Case;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.manufacturing.quality.PeriodicControl;
import org.openbravo.model.manufacturing.transaction.GlobalUse;
import org.openbravo.model.manufacturing.transaction.WorkRequirementProduct;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.materialmgmt.cost.CostingRule;
import org.openbravo.model.materialmgmt.cost.CostingRuleProductV;
import org.openbravo.model.materialmgmt.cost.InventoryAmountUpdateLine;
import org.openbravo.model.materialmgmt.cost.LandedCostType;
import org.openbravo.model.materialmgmt.cost.StockValuation;
import org.openbravo.model.materialmgmt.onhandquantity.ProductStockView;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.onhandquantity.StorageDetail;
import org.openbravo.model.materialmgmt.onhandquantity.StoragePending;
import org.openbravo.model.materialmgmt.onhandquantity.ValuedStockAggregated;
import org.openbravo.model.materialmgmt.transaction.InOutLineAccountingDimension;
import org.openbravo.model.materialmgmt.transaction.InternalConsumptionLine;
import org.openbravo.model.materialmgmt.transaction.InternalMovementLine;
import org.openbravo.model.materialmgmt.transaction.InventoryCountLine;
import org.openbravo.model.materialmgmt.transaction.MaterialTransaction;
import org.openbravo.model.materialmgmt.transaction.MaterialTransactionV;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialReceiptPickEdit;
import org.openbravo.model.materialmgmt.transaction.ReturnMaterialShipmentPickEdit;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.materialmgmt.transaction.TransactionLast;
import org.openbravo.model.mrp.Planner;
import org.openbravo.model.mrp.PlanningMethod;
import org.openbravo.model.mrp.ProductionRun;
import org.openbravo.model.mrp.ProductionRunLine;
import org.openbravo.model.mrp.PurchasingRun;
import org.openbravo.model.mrp.PurchasingRunLine;
import org.openbravo.model.mrp.SalesForecastLine;
import org.openbravo.model.pos.ExternalPOSProduct;
import org.openbravo.model.pricing.discount.Discount;
import org.openbravo.model.pricing.pricelist.PriceListSchemeLine;
import org.openbravo.model.pricing.pricelist.ProductPrice;
import org.openbravo.model.procurement.POInvoiceMatch;
import org.openbravo.model.procurement.ReceiptInvoiceMatch;
import org.openbravo.model.procurement.RequisitionLine;
import org.openbravo.model.project.ProjectIssue;
import org.openbravo.model.project.ProjectLine;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectProposalLine;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.model.project.StandardPhase;
import org.openbravo.model.project.StandardTask;
import org.openbravo.model.sales.Commission;
import org.openbravo.model.sales.CommissionLine;
import org.openbravo.model.shipping.FreightCategory;
import org.openbravo.model.timeandexpense.ExpenseType;
import org.openbravo.model.timeandexpense.Resource;
import org.openbravo.model.timeandexpense.SheetLine;
import org.openbravo.model.timeandexpense.SheetLineV;
import org.openbravo.retail.config.OBRETCOProlProduct;
import org.openbravo.retail.discounts.bytotal.org.openbravo.retail.discounts.bytotal.FreeProduct;
import org.openbravo.retail.discounts.combo.ComboProduct;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardInst;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardSummary;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardTrans;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.ProductSummary;
import org.openbravo.retail.posterminal.PrintTemplate;
/**
 * Entity class for entity Product (stored in table M_Product).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Product extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "M_Product";
    public static final String ENTITY_NAME = "Product";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_HELPCOMMENT = "helpComment";
    public static final String PROPERTY_UPCEAN = "uPCEAN";
    public static final String PROPERTY_SKU = "sKU";
    public static final String PROPERTY_UOM = "uOM";
    public static final String PROPERTY_SALESREPRESENTATIVE = "salesRepresentative";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_STOCKED = "stocked";
    public static final String PROPERTY_PURCHASE = "purchase";
    public static final String PROPERTY_SALE = "sale";
    public static final String PROPERTY_BILLOFMATERIALS = "billOfMaterials";
    public static final String PROPERTY_PRINTDETAILSONINVOICE = "printDetailsOnInvoice";
    public static final String PROPERTY_PRINTDETAILSONPICKLIST = "printDetailsOnPickList";
    public static final String PROPERTY_BOMVERIFIED = "bOMVerified";
    public static final String PROPERTY_PRODUCTCATEGORY = "productCategory";
    public static final String PROPERTY_CLASSIFICATION = "classification";
    public static final String PROPERTY_VOLUME = "volume";
    public static final String PROPERTY_WEIGHT = "weight";
    public static final String PROPERTY_SHELFWIDTH = "shelfWidth";
    public static final String PROPERTY_SHELFHEIGHT = "shelfHeight";
    public static final String PROPERTY_SHELFDEPTH = "shelfDepth";
    public static final String PROPERTY_UNITSPERPALLET = "unitsPerPallet";
    public static final String PROPERTY_TAXCATEGORY = "taxCategory";
    public static final String PROPERTY_RESOURCE = "resource";
    public static final String PROPERTY_DISCONTINUED = "discontinued";
    public static final String PROPERTY_DISCONTINUEDBY = "discontinuedBy";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_EXPENSETYPE = "expenseType";
    public static final String PROPERTY_PRODUCTTYPE = "productType";
    public static final String PROPERTY_IMAGEURL = "imageURL";
    public static final String PROPERTY_DESCRIPTIONURL = "descriptionURL";
    public static final String PROPERTY_GUARANTEEDDAYS = "guaranteedDays";
    public static final String PROPERTY_VERSIONNO = "versionNo";
    public static final String PROPERTY_ATTRIBUTESET = "attributeSet";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_DOWNLOADURL = "downloadURL";
    public static final String PROPERTY_FREIGHTCATEGORY = "freightCategory";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_IMAGE = "image";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PRINTPRICE = "printPrice";
    public static final String PROPERTY_NAME2 = "name2";
    public static final String PROPERTY_COSTTYPE = "costType";
    public static final String PROPERTY_STANDARDCOST = "standardCost";
    public static final String PROPERTY_MINIMUMSTOCK = "minimumStock";
    public static final String PROPERTY_ENFORCEATTRIBUTE = "enforceAttribute";
    public static final String PROPERTY_CALCULATED = "calculated";
    public static final String PROPERTY_PROCESSPLAN = "processPlan";
    public static final String PROPERTY_PRODUCTION = "production";
    public static final String PROPERTY_CAPACITY = "capacity";
    public static final String PROPERTY_MINIMUMLEADTIME = "minimumLeadTime";
    public static final String PROPERTY_PLANNER = "planner";
    public static final String PROPERTY_PLANNINGMETHOD = "planningMethod";
    public static final String PROPERTY_MAXQUANTITY = "maxQuantity";
    public static final String PROPERTY_MINQUANTITY = "minQuantity";
    public static final String PROPERTY_STANDARDQUANTITY = "standardQuantity";
    public static final String PROPERTY_QUANTITYTYPE = "quantityType";
    public static final String PROPERTY_SAFETYSTOCK = "safetyStock";
    public static final String PROPERTY_USEATTRIBUTESETVALUEAS = "useAttributeSetValueAs";
    public static final String PROPERTY_ISQUANTITYVARIABLE = "isquantityvariable";
    public static final String PROPERTY_DEFERREDREVENUE = "deferredRevenue";
    public static final String PROPERTY_REVENUEPLANTYPE = "revenuePlanType";
    public static final String PROPERTY_PERIODNUMBER = "periodNumber";
    public static final String PROPERTY_ISDEFERREDEXPENSE = "isdeferredexpense";
    public static final String PROPERTY_EXPPLANTYPE = "expplantype";
    public static final String PROPERTY_PERIODNUMBEREXP = "periodnumberExp";
    public static final String PROPERTY_DEFAULTPERIOD = "defaultPeriod";
    public static final String PROPERTY_DEFAULTPERIODEXPENSE = "defaultPeriodExpense";
    public static final String PROPERTY_BOOKUSINGPURCHASEORDERPRICE = "bookUsingPurchaseOrderPrice";
    public static final String PROPERTY_UOMFORWEIGHT = "uOMForWeight";
    public static final String PROPERTY_BRAND = "brand";
    public static final String PROPERTY_ATIMDMCAPACIDAD = "atimdmCapacidad";
    public static final String PROPERTY_GCNVGIFTCARDTYPE = "gcnvGiftcardtype";
    public static final String PROPERTY_ATIMDMISATRIB = "atimdmIsatrib";
    public static final String PROPERTY_GCNVAMOUNT = "gcnvAmount";
    public static final String PROPERTY_ISGENERIC = "isGeneric";
    public static final String PROPERTY_ATIMDMMARCA = "atimdmMarca";
    public static final String PROPERTY_GENERICPRODUCT = "genericProduct";
    public static final String PROPERTY_CREATEVARIANTS = "createVariants";
    public static final String PROPERTY_OPCRMUPC2 = "opcrmUpc2";
    public static final String PROPERTY_CHARACTERISTICDESCRIPTION = "characteristicDescription";
    public static final String PROPERTY_OBPOSSCALE = "obposScale";
    public static final String PROPERTY_OPCRMUPC3 = "opcrmUpc3";
    public static final String PROPERTY_GCNVALLOWPARTIALRETURN = "gcnvAllowpartialreturn";
    public static final String PROPERTY_OBPOSGROUPEDPRODUCT = "obposGroupedproduct";
    public static final String PROPERTY_UPDATEINVARIANTS = "updateInvariants";
    public static final String PROPERTY_OBPOSSHOWSTOCK = "obposShowstock";
    public static final String PROPERTY_MANAGEVARIANTS = "manageVariants";
    public static final String PROPERTY_OBPOSSHOWCHDESC = "obposShowChDesc";
    public static final String PROPERTY_SSWHWITHHOLDINGSOURCE = "sswhWithholdingSource";
    public static final String PROPERTY_INCLUDEDPRODUCTCATEGORIES = "includedProductCategories";
    public static final String PROPERTY_OBBOMAUTOGENERATEBOM = "obbomAutogeneratebom";
    public static final String PROPERTY_SSWHISREFUNDCUSTOMER = "sswhIsrefundCustomer";
    public static final String PROPERTY_INCLUDEDPRODUCTS = "includedProducts";
    public static final String PROPERTY_PRINTDESCRIPTION = "printDescription";
    public static final String PROPERTY_RETURNABLE = "returnable";
    public static final String PROPERTY_ATIMDMPORARA = "atimdmPorAra";
    public static final String PROPERTY_OBPOSALLOWANONYMOUSSALE = "oBPOSAllowAnonymousSale";
    public static final String PROPERTY_OVERDUERETURNDAYS = "overdueReturnDays";
    public static final String PROPERTY_ATIMDMPARARA = "atimdmParAra";
    public static final String PROPERTY_ISPRICERULEBASED = "ispricerulebased";
    public static final String PROPERTY_UNIQUEPERDOCUMENT = "uniquePerDocument";
    public static final String PROPERTY_RELATEPRODCATTOSERVICE = "relateprodcattoservice";
    public static final String PROPERTY_OBGCNEEXPIRATIONDAYS = "obgcneExpirationdays";
    public static final String PROPERTY_OBPGCPRINTCARD = "obpgcPrintcard";
    public static final String PROPERTY_RELATEPRODTOSERVICE = "relateprodtoservice";
    public static final String PROPERTY_OBPGCPRINTTEMPLATE = "obpgcPrinttemplate";
    public static final String PROPERTY_LINKEDTOPRODUCT = "linkedToProduct";
    public static final String PROPERTY_QUANTITYRULE = "quantityRule";
    public static final String PROPERTY_ALLOWDEFERREDSELL = "allowDeferredSell";
    public static final String PROPERTY_DEFERREDSELLMAXDAYS = "deferredSellMaxDays";
    public static final String PROPERTY_SSRSMWAREHOUSE = "ssrsMWarehouse";
    public static final String PROPERTY_OBPOSPROPOSALTYPE = "obposProposalType";
    public static final String PROPERTY_EEIALTERNATIVEIDENTIFIER = "eeiAlternativeidentifier";
    public static final String PROPERTY_OBPOSISMULTISELECTABLE = "obposIsmultiselectable";
    public static final String PROPERTY_SPATMPTRANSFERABLE = "spatmpTransferable";
    public static final String PROPERTY_SSFIMODELPROD = "ssfiModelProd";
    public static final String PROPERTY_SCRTLACONTROLASSETS = "scrtlaControlAssets";
    public static final String PROPERTY_SCMFMRPPRODSUBCAT = "scmfMrpProdsubcat";
    public static final String PROPERTY_SSCRTXTUNITSPERBOX = "sscrtxtUnitsPerBox";
    public static final String PROPERTY_PRODUCTSTATUS = "productStatus";
    public static final String PROPERTY_ECSLIMMMIN = "ecslimmMin";
    public static final String PROPERTY_ECSLIMMMAX = "ecslimmMax";
    public static final String PROPERTY_SLPSSUBCATEGORYPROD = "slpsSubcategoryProd";
    public static final String PROPERTY_SLPSPRODUCTCATEGORY = "slpsProductCategory";
    public static final String PROPERTY_OBPOSPRINTSERVICES = "obposPrintservices";
    public static final String PROPERTY_SLQSCHECKQUALITY = "slqsCheckQuality";
    public static final String PROPERTY_SLQSMPPERCTRL = "slqsMpPerCtrl";
    public static final String PROPERTY_SSIPICETAXICE = "ssipiceTaxIce";
    public static final String PROPERTY_SSIPICEPERCENTICE = "ssipicePercentIce";
    public static final String PROPERTY_SSIPICEPVPSRI = "ssipicePvpSri";
    public static final String PROPERTY_SPGIINVOICE = "spgiInvoice";
    public static final String PROPERTY_SIBLRISWAREHOUSE = "siblrIswarehouse";
    public static final String PROPERTY_SLPLAGPACKAGE = "slplagPackage";
    public static final String PROPERTY_SPEVDISCOUNTABLE = "spevDiscountable";
    public static final String PROPERTY_SLPLAGPRODCLASIF = "slplagProdclasif";
    public static final String PROPERTY_SLPLAGBRAND = "slplagBrand";
    public static final String PROPERTY_SLPLAGPRODCAP = "slplagProdcap";
    public static final String PROPERTY_SLPLAGIRBPUNIT = "slplagIrbpunit";
    public static final String PROPERTY_SLPLAGGALCOHOL = "slplagGalcohol";
    public static final String PROPERTY_SLPLAGMANTAINPACKAGE = "slplagMantainpackage";
    public static final String PROPERTY_SSFBICOMMERCIALCATEGORY = "ssfbiCommercialCategory";
    public static final String PROPERTY_SSLDMRPCOSTLDM = "ssldmrpCostLdm";
    public static final String PROPERTY_CRPRODPRODUCTACT = "crprodProductact";
    public static final String PROPERTY_SIRBPPLASTICUNITSBOM = "sirbpPlasticunitsbom";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST = "amortizationLineAccountingDimensionList";
    public static final String PROPERTY_APPROVEDVENDORLIST = "approvedVendorList";
    public static final String PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST = "businessPartnerProductTemplateList";
    public static final String PROPERTY_CLIENTINFORMATIONPRODUCTFORFREIGHTLIST = "clientInformationProductForFreightList";
    public static final String PROPERTY_COSTINGRULELIST = "costingRuleList";
    public static final String PROPERTY_COSTINGRULEPRODUCTVAPPLYPRODUCTLIST = "costingRuleProductVApplyProductList";
    public static final String PROPERTY_COSTINGRULEPRODUCTVLIST = "costingRuleProductVList";
    public static final String PROPERTY_CREATEPOLINESPELIST = "createPOLinesPEList";
    public static final String PROPERTY_DISCTFREEPRODUCTLIST = "dISCTFREEPRODUCTList";
    public static final String PROPERTY_EXTERNALPOSPRODUCTLIST = "externalPOSProductList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINPAYMENTDETAILVLIST = "fINPaymentDetailVList";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILLIST = "fINPaymentScheduleDetailList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST = "financialMgmtAccountingCombinationList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST = "financialMgmtAcctSchemaElementList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST = "financialMgmtAssetList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINEEMSCFTPRODUCTIDLIST = "financialMgmtBudgetLineEMScftProductIDList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_GCNVGIFTCARDINSTLIST = "gCNVGiftCardInstList";
    public static final String PROPERTY_GCNVGIFTCARDSUMMARYLIST = "gCNVGiftCardSummaryList";
    public static final String PROPERTY_GCNVGIFTCARDTRANSLIST = "gCNVGiftCardTransList";
    public static final String PROPERTY_GCNVPRODUCTSUMMARYLIST = "gCNVProductSummaryList";
    public static final String PROPERTY_GCNVPRODUCTSUMMARYMINCPRODUCTIDLIST = "gCNVProductSummaryMIncproductIDList";
    public static final String PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST = "inOutLineAccountingDimensionList";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELINELIST = "inventoryAmountUpdateLineList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELINEV2LIST = "invoiceLineV2List";
    public static final String PROPERTY_LANDEDCOSTTYPELIST = "landedCostTypeList";
    public static final String PROPERTY_LOTLIST = "lotList";
    public static final String PROPERTY_MRPPRODUCTIONRUNLIST = "mRPProductionRunList";
    public static final String PROPERTY_MRPPRODUCTIONRUNLINELIST = "mRPProductionRunLineList";
    public static final String PROPERTY_MRPPURCHASINGRUNLIST = "mRPPurchasingRunList";
    public static final String PROPERTY_MRPPURCHASINGRUNLINELIST = "mRPPurchasingRunLineList";
    public static final String PROPERTY_MRPSALESFORECASTLINELIST = "mRPSalesForecastLineList";
    public static final String PROPERTY_STOCKVALUATIONLIST = "stockValuationList";
    public static final String PROPERTY_MANUFACTURINGCASELIST = "manufacturingCaseList";
    public static final String PROPERTY_MANUFACTURINGGLOBALUSELIST = "manufacturingGlobalUseList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYPRODUCTIDLIST = "manufacturingMeasureShiftEMSpqulyProductIDList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYFINISHEDPRODIDLIST = "manufacturingMeasureShiftEMSpqulyFinishedprodIDList";
    public static final String PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST = "manufacturingOperationProductList";
    public static final String PROPERTY_MANUFACTURINGPRODUCTIONLINELIST = "manufacturingProductionLineList";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST = "manufacturingWorkRequirementProductList";
    public static final String PROPERTY_MATERIALMGMTCOSTINGLIST = "materialMgmtCostingList";
    public static final String PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST = "materialMgmtInternalConsumptionLineList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST = "materialMgmtInternalMovementLineList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST = "materialMgmtInventoryCountLineList";
    public static final String PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST = "materialMgmtMaterialTransactionList";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONPLANLIST = "materialMgmtProductionPlanList";
    public static final String PROPERTY_MATERIALMGMTRESERVATIONLIST = "materialMgmtReservationList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEDETAILLIST = "materialMgmtStorageDetailList";
    public static final String PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST = "materialMgmtStoragePendingList";
    public static final String PROPERTY_MATRIZCONFIGURACIONLINELIST = "matrizConfiguracionLineList";
    public static final String PROPERTY_OBCOMBOPRODUCTLIST = "oBCOMBOProductList";
    public static final String PROPERTY_OBRETCOPROLPRODUCTLIST = "oBRETCOProlProductList";
    public static final String PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST = "oBWCLStockByWarehouseViewList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEEMATVEFPRODUCT2LIST = "orderLineEmAtvefProduct2List";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_PRICINGADJUSTMENTPRODUCTLIST = "pricingAdjustmentProductList";
    public static final String PROPERTY_PRICINGDISCOUNTLIST = "pricingDiscountList";
    public static final String PROPERTY_PRICINGPRICELISTSCHEMELINELIST = "pricingPriceListSchemeLineList";
    public static final String PROPERTY_PRICINGPRODUCTPRICELIST = "pricingProductPriceList";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST = "pricingVolumeDiscountProductList";
    public static final String PROPERTY_PROCUREMENTPOINVOICEMATCHLIST = "procurementPOInvoiceMatchList";
    public static final String PROPERTY_PROCUREMENTRECEIPTINVOICEMATCHLIST = "procurementReceiptInvoiceMatchList";
    public static final String PROPERTY_PROCUREMENTREQUISITIONLINELIST = "procurementRequisitionLineList";
    public static final String PROPERTY_PRODUCTGENERICPRODUCTLIST = "productGenericProductList";
    public static final String PROPERTY_PRODUCTAUMLIST = "productAUMList";
    public static final String PROPERTY_PRODUCTACCOUNTSLIST = "productAccountsList";
    public static final String PROPERTY_PRODUCTBOMLIST = "productBOMList";
    public static final String PROPERTY_PRODUCTBOMBOMPRODUCTLIST = "productBOMBOMProductList";
    public static final String PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST = "productByPriceAndWarehouseList";
    public static final String PROPERTY_PRODUCTCHARACTERISTICLIST = "productCharacteristicList";
    public static final String PROPERTY_PRODUCTCHARACTERISTICVALUELIST = "productCharacteristicValueList";
    public static final String PROPERTY_PRODUCTCUSTOMERLIST = "productCustomerList";
    public static final String PROPERTY_PRODUCTORGLIST = "productOrgList";
    public static final String PROPERTY_PRODUCTSTOCKVIEWLIST = "productStockViewList";
    public static final String PROPERTY_PRODUCTSUBSTITUTELIST = "productSubstituteList";
    public static final String PROPERTY_PRODUCTSUBSTITUTESUBSTITUTEPRODUCTLIST = "productSubstituteSubstituteProductList";
    public static final String PROPERTY_PRODUCTTRLLIST = "productTrlList";
    public static final String PROPERTY_PRODUCTUOMLIST = "productUOMList";
    public static final String PROPERTY_PRODUCTWITHCHARACTERISTICSLIST = "productWithCharacteristicsList";
    public static final String PROPERTY_PRODUCTWITHCHARACTERISTICSGENERICPRODUCTLIST = "productWithCharacteristicsGenericProductList";
    public static final String PROPERTY_PROJECTISSUELIST = "projectIssueList";
    public static final String PROPERTY_PROJECTLINELIST = "projectLineList";
    public static final String PROPERTY_PROJECTPHASELIST = "projectPhaseList";
    public static final String PROPERTY_PROJECTPROPOSALLINELIST = "projectProposalLineList";
    public static final String PROPERTY_PROJECTSTANDARDPHASELIST = "projectStandardPhaseList";
    public static final String PROPERTY_PROJECTSTANDARDTASKLIST = "projectStandardTaskList";
    public static final String PROPERTY_PROJECTTASKLIST = "projectTaskList";
    public static final String PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST = "returnMaterialReceiptPickEditList";
    public static final String PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST = "returnMaterialShipmentPickEditList";
    public static final String PROPERTY_SIVAPHYSICALINVTLINESLIST = "sIVAPhysicalInvtlinesList";
    public static final String PROPERTY_SOVSLDMPRODLIST = "sOVSLdmProdList";
    public static final String PROPERTY_SOVSLDMTEMPLIST = "sOVSLdmTempList";
    public static final String PROPERTY_SPEVPRODUCTCATEGORYLIST = "sPEVProductCategoryList";
    public static final String PROPERTY_SSIPPRODUCTTARIFFSLIST = "sSIPProducttariffsList";
    public static final String PROPERTY_SSREREFUNDCONFIGURATIONLIST = "sSRERefundConfigurationList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELINELIST = "sSWSWithholdingSaleLineList";
    public static final String PROPERTY_STXREVFINANCIALLACCOUNTINGLIST = "sTXREVFinanciallAccountingList";
    public static final String PROPERTY_SWSOCHOMPRODUCTLIST = "sWSOCHomproductList";
    public static final String PROPERTY_SALESCOMMISSIONLIST = "salesCommissionList";
    public static final String PROPERTY_SALESCOMMISSIONLINELIST = "salesCommissionLineList";
    public static final String PROPERTY_SERVICEPRICERULEVERSIONLIST = "servicePriceRuleVersionList";
    public static final String PROPERTY_SERVICEPRODUCTLIST = "serviceProductList";
    public static final String PROPERTY_SERVICEPRODUCTMRELATEDPRODUCTIDLIST = "serviceProductMRelatedProductIDList";
    public static final String PROPERTY_SERVICEPRODUCTCATEGORYLIST = "serviceProductCategoryList";
    public static final String PROPERTY_SIBLRPHYSICALINVTLINESLIST = "siblrPhysicalInvtLinesList";
    public static final String PROPERTY_SSBODGCPRODUCTLIST = "ssbodGcProductList";
    public static final String PROPERTY_SSBODGIFTORDERLIST = "ssbodGiftOrderList";
    public static final String PROPERTY_SSBODGIFTTEMPLIST = "ssbodGiftTempList";
    public static final String PROPERTY_SSMAACTACCOUNTINGLIST = "ssmaactAccountingList";
    public static final String PROPERTY_SSMAACTAUDITLIST = "ssmaactAuditList";
    public static final String PROPERTY_TERCEROPRODUCTOLIST = "terceroProductoList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINEVLIST = "timeAndExpenseSheetLineVList";
    public static final String PROPERTY_TRANSACTIONLASTLIST = "transactionLastList";
    public static final String PROPERTY_TRANSACTIONVLIST = "transactionVList";
    public static final String PROPERTY_VALUEDSTOCKAGGREGATEDLIST = "valuedStockAggregatedList";
    public static final String PROPERTY_ATINDPOPOSTVENTALINEALIST = "atindpoPostventalineaList";
    public static final String PROPERTY_ATVEFFACTORLIST = "atvefFactorList";
    public static final String PROPERTY_ECSCBBREAKDOWNLINELIST = "ecscbBreakdownLineList";
    public static final String PROPERTY_ECSCBTYPEBREAKDOWNLINELIST = "ecscbTypeBreakdownLineList";
    public static final String PROPERTY_EEIPAYMENTDETAILVLIST = "eeiPaymentDetailVList";
    public static final String PROPERTY_EEIPRODUCTLIST = "eeiProductList";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";
    public static final String PROPERTY_IMDLVHOMOLOGATIONPRODUCTLIST = "imdlvHomologationProductList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEPRODUCTDEFAULTIDLIST = "imdlvPurchaseInvoiceProductDefaultIDList";
    public static final String PROPERTY_IMDLVWITHHOLDINGLINELIST = "imdlvWithholdinglineList";
    public static final String PROPERTY_OPCRMPRODUCTVIEWVLIST = "opcrmProductviewVList";
    public static final String PROPERTY_SCMFFORECASTBYMONTHLIST = "scmfForecastbymonthList";
    public static final String PROPERTY_SCMFPENDINGORDERSTMPLIST = "scmfPendingordersTmpList";
    public static final String PROPERTY_SCMFPROCESSPRODUCTIONLIST = "scmfProcessProductionList";
    public static final String PROPERTY_SCMFPRODUCTLIST = "scmfProductList";
    public static final String PROPERTY_SCMFREGRESSIONLINECALCLIST = "scmfRegressionlineCalcList";
    public static final String PROPERTY_SCMFTRANSACTIONLIST = "scmfTransactionList";
    public static final String PROPERTY_SCMFTRANSACTIONBALANCELIST = "scmfTransactionBalanceList";
    public static final String PROPERTY_SCMFTRANSACTIONVLIST = "scmfTransactionVList";
    public static final String PROPERTY_SCMFTRANSACTIONBYDATELIST = "scmfTransactionbydateList";
    public static final String PROPERTY_SCMFTRANSBYDATEVLIST = "scmfTransbydateVList";
    public static final String PROPERTY_SFPSIRECONCILESOVLIST = "sfpsiReconcileSoVList";
    public static final String PROPERTY_SIMPSIMIMPSIMCOSTLIST = "simpsimImpSimCostList";
    public static final String PROPERTY_SIMPSIMIMPSIMLINELIST = "simpsimImpSimLineList";
    public static final String PROPERTY_SINVMINSQUAREBILLLIST = "sinvminSquareBillList";
    public static final String PROPERTY_SLQSMPRODUCTSTOCKVLIST = "slqsMProductStockVList";
    public static final String PROPERTY_SLQSPRDSAFETYVLIST = "slqsPrdSafetyVList";
    public static final String PROPERTY_SPATMPREFERENCETRANSFERLIST = "spatmpReferenceTransferList";
    public static final String PROPERTY_SPATMPTRANSFERCODELIST = "spatmpTransferCodeList";
    public static final String PROPERTY_SPATMPTRANSFERLIST = "spatmpTransferList";
    public static final String PROPERTY_SPROCTMINVENTORYSETTLLIST = "sproctmInventorySettlList";
    public static final String PROPERTY_SPROCTMTASKPRODLIST = "sproctmTaskProdList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALASSETRETURNLIST = "ssalAssetReturnList";
    public static final String PROPERTY_SSAPQAPPPARAMMOVILLIST = "ssapqAppParamMovilList";
    public static final String PROPERTY_SSBODGIFTINVOICELIST = "ssbodGiftInvoiceList";
    public static final String PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST = "sscflwExpensivePayoutVList";
    public static final String PROPERTY_SSDCCPDISTCOSTCENTERLIST = "ssdccpDistcostcenterList";
    public static final String PROPERTY_SSDNIDPRODUCTLIST = "ssdnidProductList";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILVLIST = "ssfiFinPaymentDetailVList";
    public static final String PROPERTY_SSIPOTMACCUMULATEDLIST = "ssipotmAccumulatedList";
    public static final String PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST = "ssipotmAttributeProductList";
    public static final String PROPERTY_SSIPOTMORDERLINELIST = "ssipotmOrderlineList";
    public static final String PROPERTY_SSMRPFORECASTLOGLIST = "ssmrpForecastLogList";
    public static final String PROPERTY_SSMRPSALESFORECASTLIST = "ssmrpSalesForecastList";
    public static final String PROPERTY_SSMRPSASIMLINESPRODUCTIDLIST = "ssmrpsAsimLinesProductidList";
    public static final String PROPERTY_SSMRPSLINESTMPPRODUCTIDLIST = "ssmrpsLinesTmpProductidList";
    public static final String PROPERTY_SSPRODPRODUCTLOTVLIST = "ssprodProductLotVList";
    public static final String PROPERTY_SSREREFUNDINVOICEEMIMDLVPRODUCTIDLIST = "ssreRefundinvoiceEMImdlvProductIDList";
    public static final String PROPERTY_SSREREFUNDINVOICELINELIST = "ssreRefundinvoicelineList";
    public static final String PROPERTY_SSRSRESUPPLYLINELIST = "ssrsResupplylineList";
    public static final String PROPERTY_SSTPCCONSUMPTIONLINELIST = "sstpcConsumptionLineList";
    public static final String PROPERTY_SSTPCLIQPRJINVVLIST = "sstpcLiqPrjInvVList";
    public static final String PROPERTY_SSTPCMATCONPROJVLIST = "sstpcMatConProjVList";
    public static final String PROPERTY_SSTPCMATPROJVOIDVLIST = "sstpcMatProjVoidVList";
    public static final String PROPERTY_SSTPCMOVPRODVLIST = "sstpcMovProdVList";
    public static final String PROPERTY_SSTPCPRELIQVLIST = "sstpcPreliqVList";
    public static final String PROPERTY_SSTPCRELATEDCOSTSLIST = "sstpcRelatedCostsList";
    public static final String PROPERTY_SSWCLWORKORDERLINEVLIST = "sswclWorkOrderlineVList";
    public static final String PROPERTY_SSXMLDATAXMLIBPLIST = "ssxmlDataXmlIbpList";
    public static final String PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST = "swhpProductStockDetailVList";
    public static final String PROPERTY_SWHPWHPRODUCTLIST = "swhpWhProductList";
    public static final String PROPERTY_SWSPCCONFIGLIST = "swspcConfigList";

    public Product() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_STOCKED, true);
        setDefaultValue(PROPERTY_PURCHASE, true);
        setDefaultValue(PROPERTY_SALE, true);
        setDefaultValue(PROPERTY_BILLOFMATERIALS, false);
        setDefaultValue(PROPERTY_PRINTDETAILSONINVOICE, false);
        setDefaultValue(PROPERTY_PRINTDETAILSONPICKLIST, false);
        setDefaultValue(PROPERTY_BOMVERIFIED, false);
        setDefaultValue(PROPERTY_DISCONTINUED, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PRODUCTTYPE, "I");
        setDefaultValue(PROPERTY_PRINTPRICE, true);
        setDefaultValue(PROPERTY_ENFORCEATTRIBUTE, false);
        setDefaultValue(PROPERTY_CALCULATED, false);
        setDefaultValue(PROPERTY_PRODUCTION, false);
        setDefaultValue(PROPERTY_QUANTITYTYPE, false);
        setDefaultValue(PROPERTY_ISQUANTITYVARIABLE, false);
        setDefaultValue(PROPERTY_DEFERREDREVENUE, false);
        setDefaultValue(PROPERTY_ISDEFERREDEXPENSE, false);
        setDefaultValue(PROPERTY_BOOKUSINGPURCHASEORDERPRICE, false);
        setDefaultValue(PROPERTY_ATIMDMISATRIB, false);
        setDefaultValue(PROPERTY_ISGENERIC, false);
        setDefaultValue(PROPERTY_CREATEVARIANTS, false);
        setDefaultValue(PROPERTY_OBPOSSCALE, false);
        setDefaultValue(PROPERTY_GCNVALLOWPARTIALRETURN, false);
        setDefaultValue(PROPERTY_OBPOSGROUPEDPRODUCT, true);
        setDefaultValue(PROPERTY_UPDATEINVARIANTS, false);
        setDefaultValue(PROPERTY_OBPOSSHOWSTOCK, false);
        setDefaultValue(PROPERTY_MANAGEVARIANTS, false);
        setDefaultValue(PROPERTY_OBPOSSHOWCHDESC, true);
        setDefaultValue(PROPERTY_OBBOMAUTOGENERATEBOM, false);
        setDefaultValue(PROPERTY_SSWHISREFUNDCUSTOMER, false);
        setDefaultValue(PROPERTY_PRINTDESCRIPTION, false);
        setDefaultValue(PROPERTY_RETURNABLE, true);
        setDefaultValue(PROPERTY_OBPOSALLOWANONYMOUSSALE, true);
        setDefaultValue(PROPERTY_ISPRICERULEBASED, false);
        setDefaultValue(PROPERTY_UNIQUEPERDOCUMENT, false);
        setDefaultValue(PROPERTY_RELATEPRODCATTOSERVICE, false);
        setDefaultValue(PROPERTY_OBPGCPRINTCARD, false);
        setDefaultValue(PROPERTY_RELATEPRODTOSERVICE, false);
        setDefaultValue(PROPERTY_LINKEDTOPRODUCT, false);
        setDefaultValue(PROPERTY_ALLOWDEFERREDSELL, false);
        setDefaultValue(PROPERTY_OBPOSISMULTISELECTABLE, false);
        setDefaultValue(PROPERTY_SPATMPTRANSFERABLE, false);
        setDefaultValue(PROPERTY_SCRTLACONTROLASSETS, false);
        setDefaultValue(PROPERTY_ECSLIMMMIN, new BigDecimal(0));
        setDefaultValue(PROPERTY_ECSLIMMMAX, new BigDecimal(0));
        setDefaultValue(PROPERTY_OBPOSPRINTSERVICES, true);
        setDefaultValue(PROPERTY_SLQSCHECKQUALITY, false);
        setDefaultValue(PROPERTY_SSIPICETAXICE, false);
        setDefaultValue(PROPERTY_SPGIINVOICE, false);
        setDefaultValue(PROPERTY_SIBLRISWAREHOUSE, false);
        setDefaultValue(PROPERTY_SPEVDISCOUNTABLE, false);
        setDefaultValue(PROPERTY_SSLDMRPCOSTLDM, false);
        setDefaultValue(PROPERTY_CRPRODPRODUCTACT, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APPROVEDVENDORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CLIENTINFORMATIONPRODUCTFORFREIGHTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTINGRULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTINGRULEPRODUCTVAPPLYPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTINGRULEPRODUCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CREATEPOLINESPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DISCTFREEPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINEEMSCFTPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDINSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDSUMMARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDTRANSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVPRODUCTSUMMARYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVPRODUCTSUMMARYMINCPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LOTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPRODUCTIONRUNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPRODUCTIONRUNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPPURCHASINGRUNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MRPSALESFORECASTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STOCKVALUATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGCASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGGLOBALUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYFINISHEDPRODIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTCOSTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONPLANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTRESERVATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATRIZCONFIGURACIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBCOMBOPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBRETCOPROLPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEEMATVEFPRODUCT2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGADJUSTMENTPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGDISCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGPRICELISTSCHEMELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGPRODUCTPRICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTPOINVOICEMATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTRECEIPTINVOICEMATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROCUREMENTREQUISITIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTGENERICPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTAUMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTBOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTBOMBOMPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCHARACTERISTICLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCHARACTERISTICVALUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTCUSTOMERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTORGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSTOCKVIEWLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSUBSTITUTELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTSUBSTITUTESUBSTITUTEPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTTRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTUOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTWITHCHARACTERISTICSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRODUCTWITHCHARACTERISTICSGENERICPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTISSUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPHASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTPROPOSALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTSTANDARDPHASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTSTANDARDTASKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTTASKLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIVAPHYSICALINVTLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SOVSLDMPRODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SOVSLDMTEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEVPRODUCTCATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPPRODUCTTARIFFSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSREREFUNDCONFIGURATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSOCHOMPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SERVICEPRICERULEVERSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SERVICEPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SERVICEPRODUCTMRELATEDPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SERVICEPRODUCTCATEGORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIBLRPHYSICALINVTLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGCPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTTEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTAUDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TERCEROPRODUCTOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONLASTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_VALUEDSTOCKAGGREGATEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTALINEALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATVEFFACTORLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBBREAKDOWNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBTYPEBREAKDOWNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVHOMOLOGATIONPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEPRODUCTDEFAULTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVWITHHOLDINGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMPRODUCTVIEWVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFFORECASTBYMONTHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPENDINGORDERSTMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPROCESSPRODUCTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFREGRESSIONLINECALCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFTRANSACTIONBALANCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFTRANSACTIONBYDATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFTRANSBYDATEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPSIRECONCILESOVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPSIMIMPSIMCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPSIMIMPSIMLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SINVMINSQUAREBILLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLQSMPRODUCTSTOCKVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLQSPRDSAFETYVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPATMPREFERENCETRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPATMPTRANSFERCODELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPATMPTRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMINVENTORYSETTLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKPRODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAPQAPPPARAMMOVILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODGIFTINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDCCPDISTCOSTCENTERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDNIDPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMACCUMULATEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPFORECASTLOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPSALESFORECASTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPSASIMLINESPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPSLINESTMPPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRODPRODUCTLOTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSREREFUNDINVOICEEMIMDLVPRODUCTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSREREFUNDINVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSRSRESUPPLYLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCCONSUMPTIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCLIQPRJINVVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMATCONPROJVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMATPROJVOIDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMOVPRODVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPRELIQVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDCOSTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSXMLDATAXMLIBPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWHPWHPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSPCCONFIGLIST, new ArrayList<Object>());
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

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public String getHelpComment() {
        return (String) get(PROPERTY_HELPCOMMENT);
    }

    public void setHelpComment(String helpComment) {
        set(PROPERTY_HELPCOMMENT, helpComment);
    }

    public String getUPCEAN() {
        return (String) get(PROPERTY_UPCEAN);
    }

    public void setUPCEAN(String uPCEAN) {
        set(PROPERTY_UPCEAN, uPCEAN);
    }

    public String getSKU() {
        return (String) get(PROPERTY_SKU);
    }

    public void setSKU(String sKU) {
        set(PROPERTY_SKU, sKU);
    }

    public UOM getUOM() {
        return (UOM) get(PROPERTY_UOM);
    }

    public void setUOM(UOM uOM) {
        set(PROPERTY_UOM, uOM);
    }

    public User getSalesRepresentative() {
        return (User) get(PROPERTY_SALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(User salesRepresentative) {
        set(PROPERTY_SALESREPRESENTATIVE, salesRepresentative);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Boolean isStocked() {
        return (Boolean) get(PROPERTY_STOCKED);
    }

    public void setStocked(Boolean stocked) {
        set(PROPERTY_STOCKED, stocked);
    }

    public Boolean isPurchase() {
        return (Boolean) get(PROPERTY_PURCHASE);
    }

    public void setPurchase(Boolean purchase) {
        set(PROPERTY_PURCHASE, purchase);
    }

    public Boolean isSale() {
        return (Boolean) get(PROPERTY_SALE);
    }

    public void setSale(Boolean sale) {
        set(PROPERTY_SALE, sale);
    }

    public Boolean isBillOfMaterials() {
        return (Boolean) get(PROPERTY_BILLOFMATERIALS);
    }

    public void setBillOfMaterials(Boolean billOfMaterials) {
        set(PROPERTY_BILLOFMATERIALS, billOfMaterials);
    }

    public Boolean isPrintDetailsOnInvoice() {
        return (Boolean) get(PROPERTY_PRINTDETAILSONINVOICE);
    }

    public void setPrintDetailsOnInvoice(Boolean printDetailsOnInvoice) {
        set(PROPERTY_PRINTDETAILSONINVOICE, printDetailsOnInvoice);
    }

    public Boolean isPrintDetailsOnPickList() {
        return (Boolean) get(PROPERTY_PRINTDETAILSONPICKLIST);
    }

    public void setPrintDetailsOnPickList(Boolean printDetailsOnPickList) {
        set(PROPERTY_PRINTDETAILSONPICKLIST, printDetailsOnPickList);
    }

    public Boolean isBOMVerified() {
        return (Boolean) get(PROPERTY_BOMVERIFIED);
    }

    public void setBOMVerified(Boolean bOMVerified) {
        set(PROPERTY_BOMVERIFIED, bOMVerified);
    }

    public ProductCategory getProductCategory() {
        return (ProductCategory) get(PROPERTY_PRODUCTCATEGORY);
    }

    public void setProductCategory(ProductCategory productCategory) {
        set(PROPERTY_PRODUCTCATEGORY, productCategory);
    }

    public String getClassification() {
        return (String) get(PROPERTY_CLASSIFICATION);
    }

    public void setClassification(String classification) {
        set(PROPERTY_CLASSIFICATION, classification);
    }

    public BigDecimal getVolume() {
        return (BigDecimal) get(PROPERTY_VOLUME);
    }

    public void setVolume(BigDecimal volume) {
        set(PROPERTY_VOLUME, volume);
    }

    public BigDecimal getWeight() {
        return (BigDecimal) get(PROPERTY_WEIGHT);
    }

    public void setWeight(BigDecimal weight) {
        set(PROPERTY_WEIGHT, weight);
    }

    public BigDecimal getShelfWidth() {
        return (BigDecimal) get(PROPERTY_SHELFWIDTH);
    }

    public void setShelfWidth(BigDecimal shelfWidth) {
        set(PROPERTY_SHELFWIDTH, shelfWidth);
    }

    public BigDecimal getShelfHeight() {
        return (BigDecimal) get(PROPERTY_SHELFHEIGHT);
    }

    public void setShelfHeight(BigDecimal shelfHeight) {
        set(PROPERTY_SHELFHEIGHT, shelfHeight);
    }

    public BigDecimal getShelfDepth() {
        return (BigDecimal) get(PROPERTY_SHELFDEPTH);
    }

    public void setShelfDepth(BigDecimal shelfDepth) {
        set(PROPERTY_SHELFDEPTH, shelfDepth);
    }

    public Long getUnitsPerPallet() {
        return (Long) get(PROPERTY_UNITSPERPALLET);
    }

    public void setUnitsPerPallet(Long unitsPerPallet) {
        set(PROPERTY_UNITSPERPALLET, unitsPerPallet);
    }

    public TaxCategory getTaxCategory() {
        return (TaxCategory) get(PROPERTY_TAXCATEGORY);
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        set(PROPERTY_TAXCATEGORY, taxCategory);
    }

    public Resource getResource() {
        return (Resource) get(PROPERTY_RESOURCE);
    }

    public void setResource(Resource resource) {
        set(PROPERTY_RESOURCE, resource);
    }

    public Boolean isDiscontinued() {
        return (Boolean) get(PROPERTY_DISCONTINUED);
    }

    public void setDiscontinued(Boolean discontinued) {
        set(PROPERTY_DISCONTINUED, discontinued);
    }

    public Date getDiscontinuedBy() {
        return (Date) get(PROPERTY_DISCONTINUEDBY);
    }

    public void setDiscontinuedBy(Date discontinuedBy) {
        set(PROPERTY_DISCONTINUEDBY, discontinuedBy);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public ExpenseType getExpenseType() {
        return (ExpenseType) get(PROPERTY_EXPENSETYPE);
    }

    public void setExpenseType(ExpenseType expenseType) {
        set(PROPERTY_EXPENSETYPE, expenseType);
    }

    public String getProductType() {
        return (String) get(PROPERTY_PRODUCTTYPE);
    }

    public void setProductType(String productType) {
        set(PROPERTY_PRODUCTTYPE, productType);
    }

    public String getImageURL() {
        return (String) get(PROPERTY_IMAGEURL);
    }

    public void setImageURL(String imageURL) {
        set(PROPERTY_IMAGEURL, imageURL);
    }

    public String getDescriptionURL() {
        return (String) get(PROPERTY_DESCRIPTIONURL);
    }

    public void setDescriptionURL(String descriptionURL) {
        set(PROPERTY_DESCRIPTIONURL, descriptionURL);
    }

    public Long getGuaranteedDays() {
        return (Long) get(PROPERTY_GUARANTEEDDAYS);
    }

    public void setGuaranteedDays(Long guaranteedDays) {
        set(PROPERTY_GUARANTEEDDAYS, guaranteedDays);
    }

    public String getVersionNo() {
        return (String) get(PROPERTY_VERSIONNO);
    }

    public void setVersionNo(String versionNo) {
        set(PROPERTY_VERSIONNO, versionNo);
    }

    public AttributeSet getAttributeSet() {
        return (AttributeSet) get(PROPERTY_ATTRIBUTESET);
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        set(PROPERTY_ATTRIBUTESET, attributeSet);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public String getDownloadURL() {
        return (String) get(PROPERTY_DOWNLOADURL);
    }

    public void setDownloadURL(String downloadURL) {
        set(PROPERTY_DOWNLOADURL, downloadURL);
    }

    public FreightCategory getFreightCategory() {
        return (FreightCategory) get(PROPERTY_FREIGHTCATEGORY);
    }

    public void setFreightCategory(FreightCategory freightCategory) {
        set(PROPERTY_FREIGHTCATEGORY, freightCategory);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
    }

    public Image getImage() {
        return (Image) get(PROPERTY_IMAGE);
    }

    public void setImage(Image image) {
        set(PROPERTY_IMAGE, image);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Boolean isPrintPrice() {
        return (Boolean) get(PROPERTY_PRINTPRICE);
    }

    public void setPrintPrice(Boolean printPrice) {
        set(PROPERTY_PRINTPRICE, printPrice);
    }

    public String getName2() {
        return (String) get(PROPERTY_NAME2);
    }

    public void setName2(String name2) {
        set(PROPERTY_NAME2, name2);
    }

    public String getCostType() {
        return (String) get(PROPERTY_COSTTYPE);
    }

    public void setCostType(String costType) {
        set(PROPERTY_COSTTYPE, costType);
    }

    public BigDecimal getStandardCost() {
        return (BigDecimal) get(PROPERTY_STANDARDCOST);
    }

    public void setStandardCost(BigDecimal standardCost) {
        set(PROPERTY_STANDARDCOST, standardCost);
    }

    public BigDecimal getMinimumStock() {
        return (BigDecimal) get(PROPERTY_MINIMUMSTOCK);
    }

    public void setMinimumStock(BigDecimal minimumStock) {
        set(PROPERTY_MINIMUMSTOCK, minimumStock);
    }

    public Boolean isEnforceAttribute() {
        return (Boolean) get(PROPERTY_ENFORCEATTRIBUTE);
    }

    public void setEnforceAttribute(Boolean enforceAttribute) {
        set(PROPERTY_ENFORCEATTRIBUTE, enforceAttribute);
    }

    public Boolean isCalculated() {
        return (Boolean) get(PROPERTY_CALCULATED);
    }

    public void setCalculated(Boolean calculated) {
        set(PROPERTY_CALCULATED, calculated);
    }

    public ProcessPlan getProcessPlan() {
        return (ProcessPlan) get(PROPERTY_PROCESSPLAN);
    }

    public void setProcessPlan(ProcessPlan processPlan) {
        set(PROPERTY_PROCESSPLAN, processPlan);
    }

    public Boolean isProduction() {
        return (Boolean) get(PROPERTY_PRODUCTION);
    }

    public void setProduction(Boolean production) {
        set(PROPERTY_PRODUCTION, production);
    }

    public BigDecimal getCapacity() {
        return (BigDecimal) get(PROPERTY_CAPACITY);
    }

    public void setCapacity(BigDecimal capacity) {
        set(PROPERTY_CAPACITY, capacity);
    }

    public BigDecimal getMinimumLeadTime() {
        return (BigDecimal) get(PROPERTY_MINIMUMLEADTIME);
    }

    public void setMinimumLeadTime(BigDecimal minimumLeadTime) {
        set(PROPERTY_MINIMUMLEADTIME, minimumLeadTime);
    }

    public Planner getPlanner() {
        return (Planner) get(PROPERTY_PLANNER);
    }

    public void setPlanner(Planner planner) {
        set(PROPERTY_PLANNER, planner);
    }

    public PlanningMethod getPlanningMethod() {
        return (PlanningMethod) get(PROPERTY_PLANNINGMETHOD);
    }

    public void setPlanningMethod(PlanningMethod planningMethod) {
        set(PROPERTY_PLANNINGMETHOD, planningMethod);
    }

    public BigDecimal getMaxQuantity() {
        return (BigDecimal) get(PROPERTY_MAXQUANTITY);
    }

    public void setMaxQuantity(BigDecimal maxQuantity) {
        set(PROPERTY_MAXQUANTITY, maxQuantity);
    }

    public BigDecimal getMinQuantity() {
        return (BigDecimal) get(PROPERTY_MINQUANTITY);
    }

    public void setMinQuantity(BigDecimal minQuantity) {
        set(PROPERTY_MINQUANTITY, minQuantity);
    }

    public BigDecimal getStandardQuantity() {
        return (BigDecimal) get(PROPERTY_STANDARDQUANTITY);
    }

    public void setStandardQuantity(BigDecimal standardQuantity) {
        set(PROPERTY_STANDARDQUANTITY, standardQuantity);
    }

    public Boolean isQuantityType() {
        return (Boolean) get(PROPERTY_QUANTITYTYPE);
    }

    public void setQuantityType(Boolean quantityType) {
        set(PROPERTY_QUANTITYTYPE, quantityType);
    }

    public BigDecimal getSafetyStock() {
        return (BigDecimal) get(PROPERTY_SAFETYSTOCK);
    }

    public void setSafetyStock(BigDecimal safetyStock) {
        set(PROPERTY_SAFETYSTOCK, safetyStock);
    }

    public String getUseAttributeSetValueAs() {
        return (String) get(PROPERTY_USEATTRIBUTESETVALUEAS);
    }

    public void setUseAttributeSetValueAs(String useAttributeSetValueAs) {
        set(PROPERTY_USEATTRIBUTESETVALUEAS, useAttributeSetValueAs);
    }

    public Boolean isQuantityvariable() {
        return (Boolean) get(PROPERTY_ISQUANTITYVARIABLE);
    }

    public void setQuantityvariable(Boolean isquantityvariable) {
        set(PROPERTY_ISQUANTITYVARIABLE, isquantityvariable);
    }

    public Boolean isDeferredRevenue() {
        return (Boolean) get(PROPERTY_DEFERREDREVENUE);
    }

    public void setDeferredRevenue(Boolean deferredRevenue) {
        set(PROPERTY_DEFERREDREVENUE, deferredRevenue);
    }

    public String getRevenuePlanType() {
        return (String) get(PROPERTY_REVENUEPLANTYPE);
    }

    public void setRevenuePlanType(String revenuePlanType) {
        set(PROPERTY_REVENUEPLANTYPE, revenuePlanType);
    }

    public Long getPeriodNumber() {
        return (Long) get(PROPERTY_PERIODNUMBER);
    }

    public void setPeriodNumber(Long periodNumber) {
        set(PROPERTY_PERIODNUMBER, periodNumber);
    }

    public Boolean isDeferredexpense() {
        return (Boolean) get(PROPERTY_ISDEFERREDEXPENSE);
    }

    public void setDeferredexpense(Boolean isdeferredexpense) {
        set(PROPERTY_ISDEFERREDEXPENSE, isdeferredexpense);
    }

    public String getExpplantype() {
        return (String) get(PROPERTY_EXPPLANTYPE);
    }

    public void setExpplantype(String expplantype) {
        set(PROPERTY_EXPPLANTYPE, expplantype);
    }

    public Long getPeriodnumberExp() {
        return (Long) get(PROPERTY_PERIODNUMBEREXP);
    }

    public void setPeriodnumberExp(Long periodnumberExp) {
        set(PROPERTY_PERIODNUMBEREXP, periodnumberExp);
    }

    public String getDefaultPeriod() {
        return (String) get(PROPERTY_DEFAULTPERIOD);
    }

    public void setDefaultPeriod(String defaultPeriod) {
        set(PROPERTY_DEFAULTPERIOD, defaultPeriod);
    }

    public String getDefaultPeriodExpense() {
        return (String) get(PROPERTY_DEFAULTPERIODEXPENSE);
    }

    public void setDefaultPeriodExpense(String defaultPeriodExpense) {
        set(PROPERTY_DEFAULTPERIODEXPENSE, defaultPeriodExpense);
    }

    public Boolean isBookUsingPurchaseOrderPrice() {
        return (Boolean) get(PROPERTY_BOOKUSINGPURCHASEORDERPRICE);
    }

    public void setBookUsingPurchaseOrderPrice(Boolean bookUsingPurchaseOrderPrice) {
        set(PROPERTY_BOOKUSINGPURCHASEORDERPRICE, bookUsingPurchaseOrderPrice);
    }

    public UOM getUOMForWeight() {
        return (UOM) get(PROPERTY_UOMFORWEIGHT);
    }

    public void setUOMForWeight(UOM uOMForWeight) {
        set(PROPERTY_UOMFORWEIGHT, uOMForWeight);
    }

    public Brand getBrand() {
        return (Brand) get(PROPERTY_BRAND);
    }

    public void setBrand(Brand brand) {
        set(PROPERTY_BRAND, brand);
    }

    public Long getAtimdmCapacidad() {
        return (Long) get(PROPERTY_ATIMDMCAPACIDAD);
    }

    public void setAtimdmCapacidad(Long atimdmCapacidad) {
        set(PROPERTY_ATIMDMCAPACIDAD, atimdmCapacidad);
    }

    public String getGcnvGiftcardtype() {
        return (String) get(PROPERTY_GCNVGIFTCARDTYPE);
    }

    public void setGcnvGiftcardtype(String gcnvGiftcardtype) {
        set(PROPERTY_GCNVGIFTCARDTYPE, gcnvGiftcardtype);
    }

    public Boolean isAtimdmIsatrib() {
        return (Boolean) get(PROPERTY_ATIMDMISATRIB);
    }

    public void setAtimdmIsatrib(Boolean atimdmIsatrib) {
        set(PROPERTY_ATIMDMISATRIB, atimdmIsatrib);
    }

    public BigDecimal getGcnvAmount() {
        return (BigDecimal) get(PROPERTY_GCNVAMOUNT);
    }

    public void setGcnvAmount(BigDecimal gcnvAmount) {
        set(PROPERTY_GCNVAMOUNT, gcnvAmount);
    }

    public Boolean isGeneric() {
        return (Boolean) get(PROPERTY_ISGENERIC);
    }

    public void setGeneric(Boolean isGeneric) {
        set(PROPERTY_ISGENERIC, isGeneric);
    }

    public AtimdmMarcaProducto getAtimdmMarca() {
        return (AtimdmMarcaProducto) get(PROPERTY_ATIMDMMARCA);
    }

    public void setAtimdmMarca(AtimdmMarcaProducto atimdmMarca) {
        set(PROPERTY_ATIMDMMARCA, atimdmMarca);
    }

    public Product getGenericProduct() {
        return (Product) get(PROPERTY_GENERICPRODUCT);
    }

    public void setGenericProduct(Product genericProduct) {
        set(PROPERTY_GENERICPRODUCT, genericProduct);
    }

    public Boolean isCreateVariants() {
        return (Boolean) get(PROPERTY_CREATEVARIANTS);
    }

    public void setCreateVariants(Boolean createVariants) {
        set(PROPERTY_CREATEVARIANTS, createVariants);
    }

    public String getOpcrmUpc2() {
        return (String) get(PROPERTY_OPCRMUPC2);
    }

    public void setOpcrmUpc2(String opcrmUpc2) {
        set(PROPERTY_OPCRMUPC2, opcrmUpc2);
    }

    public String getCharacteristicDescription() {
        return (String) get(PROPERTY_CHARACTERISTICDESCRIPTION);
    }

    public void setCharacteristicDescription(String characteristicDescription) {
        set(PROPERTY_CHARACTERISTICDESCRIPTION, characteristicDescription);
    }

    public Boolean isObposScale() {
        return (Boolean) get(PROPERTY_OBPOSSCALE);
    }

    public void setObposScale(Boolean obposScale) {
        set(PROPERTY_OBPOSSCALE, obposScale);
    }

    public String getOpcrmUpc3() {
        return (String) get(PROPERTY_OPCRMUPC3);
    }

    public void setOpcrmUpc3(String opcrmUpc3) {
        set(PROPERTY_OPCRMUPC3, opcrmUpc3);
    }

    public Boolean isGcnvAllowpartialreturn() {
        return (Boolean) get(PROPERTY_GCNVALLOWPARTIALRETURN);
    }

    public void setGcnvAllowpartialreturn(Boolean gcnvAllowpartialreturn) {
        set(PROPERTY_GCNVALLOWPARTIALRETURN, gcnvAllowpartialreturn);
    }

    public Boolean isObposGroupedproduct() {
        return (Boolean) get(PROPERTY_OBPOSGROUPEDPRODUCT);
    }

    public void setObposGroupedproduct(Boolean obposGroupedproduct) {
        set(PROPERTY_OBPOSGROUPEDPRODUCT, obposGroupedproduct);
    }

    public Boolean isUpdateInvariants() {
        return (Boolean) get(PROPERTY_UPDATEINVARIANTS);
    }

    public void setUpdateInvariants(Boolean updateInvariants) {
        set(PROPERTY_UPDATEINVARIANTS, updateInvariants);
    }

    public Boolean isObposShowstock() {
        return (Boolean) get(PROPERTY_OBPOSSHOWSTOCK);
    }

    public void setObposShowstock(Boolean obposShowstock) {
        set(PROPERTY_OBPOSSHOWSTOCK, obposShowstock);
    }

    public Boolean isManageVariants() {
        return (Boolean) get(PROPERTY_MANAGEVARIANTS);
    }

    public void setManageVariants(Boolean manageVariants) {
        set(PROPERTY_MANAGEVARIANTS, manageVariants);
    }

    public Boolean isObposShowChDesc() {
        return (Boolean) get(PROPERTY_OBPOSSHOWCHDESC);
    }

    public void setObposShowChDesc(Boolean obposShowChDesc) {
        set(PROPERTY_OBPOSSHOWCHDESC, obposShowChDesc);
    }

    public WithholdingSource getSswhWithholdingSource() {
        return (WithholdingSource) get(PROPERTY_SSWHWITHHOLDINGSOURCE);
    }

    public void setSswhWithholdingSource(WithholdingSource sswhWithholdingSource) {
        set(PROPERTY_SSWHWITHHOLDINGSOURCE, sswhWithholdingSource);
    }

    public String getIncludedProductCategories() {
        return (String) get(PROPERTY_INCLUDEDPRODUCTCATEGORIES);
    }

    public void setIncludedProductCategories(String includedProductCategories) {
        set(PROPERTY_INCLUDEDPRODUCTCATEGORIES, includedProductCategories);
    }

    public Boolean isObbomAutogeneratebom() {
        return (Boolean) get(PROPERTY_OBBOMAUTOGENERATEBOM);
    }

    public void setObbomAutogeneratebom(Boolean obbomAutogeneratebom) {
        set(PROPERTY_OBBOMAUTOGENERATEBOM, obbomAutogeneratebom);
    }

    public Boolean isSswhIsrefundCustomer() {
        return (Boolean) get(PROPERTY_SSWHISREFUNDCUSTOMER);
    }

    public void setSswhIsrefundCustomer(Boolean sswhIsrefundCustomer) {
        set(PROPERTY_SSWHISREFUNDCUSTOMER, sswhIsrefundCustomer);
    }

    public String getIncludedProducts() {
        return (String) get(PROPERTY_INCLUDEDPRODUCTS);
    }

    public void setIncludedProducts(String includedProducts) {
        set(PROPERTY_INCLUDEDPRODUCTS, includedProducts);
    }

    public Boolean isPrintDescription() {
        return (Boolean) get(PROPERTY_PRINTDESCRIPTION);
    }

    public void setPrintDescription(Boolean printDescription) {
        set(PROPERTY_PRINTDESCRIPTION, printDescription);
    }

    public Boolean isReturnable() {
        return (Boolean) get(PROPERTY_RETURNABLE);
    }

    public void setReturnable(Boolean returnable) {
        set(PROPERTY_RETURNABLE, returnable);
    }

    public Long getAtimdmPorAra() {
        return (Long) get(PROPERTY_ATIMDMPORARA);
    }

    public void setAtimdmPorAra(Long atimdmPorAra) {
        set(PROPERTY_ATIMDMPORARA, atimdmPorAra);
    }

    public Boolean isOBPOSAllowAnonymousSale() {
        return (Boolean) get(PROPERTY_OBPOSALLOWANONYMOUSSALE);
    }

    public void setOBPOSAllowAnonymousSale(Boolean oBPOSAllowAnonymousSale) {
        set(PROPERTY_OBPOSALLOWANONYMOUSSALE, oBPOSAllowAnonymousSale);
    }

    public Long getOverdueReturnDays() {
        return (Long) get(PROPERTY_OVERDUERETURNDAYS);
    }

    public void setOverdueReturnDays(Long overdueReturnDays) {
        set(PROPERTY_OVERDUERETURNDAYS, overdueReturnDays);
    }

    public String getAtimdmParAra() {
        return (String) get(PROPERTY_ATIMDMPARARA);
    }

    public void setAtimdmParAra(String atimdmParAra) {
        set(PROPERTY_ATIMDMPARARA, atimdmParAra);
    }

    public Boolean isPricerulebased() {
        return (Boolean) get(PROPERTY_ISPRICERULEBASED);
    }

    public void setPricerulebased(Boolean ispricerulebased) {
        set(PROPERTY_ISPRICERULEBASED, ispricerulebased);
    }

    public Boolean isUniquePerDocument() {
        return (Boolean) get(PROPERTY_UNIQUEPERDOCUMENT);
    }

    public void setUniquePerDocument(Boolean uniquePerDocument) {
        set(PROPERTY_UNIQUEPERDOCUMENT, uniquePerDocument);
    }

    public Boolean isRelateprodcattoservice() {
        return (Boolean) get(PROPERTY_RELATEPRODCATTOSERVICE);
    }

    public void setRelateprodcattoservice(Boolean relateprodcattoservice) {
        set(PROPERTY_RELATEPRODCATTOSERVICE, relateprodcattoservice);
    }

    public Long getObgcneExpirationdays() {
        return (Long) get(PROPERTY_OBGCNEEXPIRATIONDAYS);
    }

    public void setObgcneExpirationdays(Long obgcneExpirationdays) {
        set(PROPERTY_OBGCNEEXPIRATIONDAYS, obgcneExpirationdays);
    }

    public Boolean isObpgcPrintcard() {
        return (Boolean) get(PROPERTY_OBPGCPRINTCARD);
    }

    public void setObpgcPrintcard(Boolean obpgcPrintcard) {
        set(PROPERTY_OBPGCPRINTCARD, obpgcPrintcard);
    }

    public Boolean isRelateprodtoservice() {
        return (Boolean) get(PROPERTY_RELATEPRODTOSERVICE);
    }

    public void setRelateprodtoservice(Boolean relateprodtoservice) {
        set(PROPERTY_RELATEPRODTOSERVICE, relateprodtoservice);
    }

    public PrintTemplate getObpgcPrinttemplate() {
        return (PrintTemplate) get(PROPERTY_OBPGCPRINTTEMPLATE);
    }

    public void setObpgcPrinttemplate(PrintTemplate obpgcPrinttemplate) {
        set(PROPERTY_OBPGCPRINTTEMPLATE, obpgcPrinttemplate);
    }

    public Boolean isLinkedToProduct() {
        return (Boolean) get(PROPERTY_LINKEDTOPRODUCT);
    }

    public void setLinkedToProduct(Boolean linkedToProduct) {
        set(PROPERTY_LINKEDTOPRODUCT, linkedToProduct);
    }

    public String getQuantityRule() {
        return (String) get(PROPERTY_QUANTITYRULE);
    }

    public void setQuantityRule(String quantityRule) {
        set(PROPERTY_QUANTITYRULE, quantityRule);
    }

    public Boolean isAllowDeferredSell() {
        return (Boolean) get(PROPERTY_ALLOWDEFERREDSELL);
    }

    public void setAllowDeferredSell(Boolean allowDeferredSell) {
        set(PROPERTY_ALLOWDEFERREDSELL, allowDeferredSell);
    }

    public Long getDeferredSellMaxDays() {
        return (Long) get(PROPERTY_DEFERREDSELLMAXDAYS);
    }

    public void setDeferredSellMaxDays(Long deferredSellMaxDays) {
        set(PROPERTY_DEFERREDSELLMAXDAYS, deferredSellMaxDays);
    }

    public Warehouse getSsrsMWarehouse() {
        return (Warehouse) get(PROPERTY_SSRSMWAREHOUSE);
    }

    public void setSsrsMWarehouse(Warehouse ssrsMWarehouse) {
        set(PROPERTY_SSRSMWAREHOUSE, ssrsMWarehouse);
    }

    public String getObposProposalType() {
        return (String) get(PROPERTY_OBPOSPROPOSALTYPE);
    }

    public void setObposProposalType(String obposProposalType) {
        set(PROPERTY_OBPOSPROPOSALTYPE, obposProposalType);
    }

    public String getEeiAlternativeidentifier() {
        return (String) get(PROPERTY_EEIALTERNATIVEIDENTIFIER);
    }

    public void setEeiAlternativeidentifier(String eeiAlternativeidentifier) {
        set(PROPERTY_EEIALTERNATIVEIDENTIFIER, eeiAlternativeidentifier);
    }

    public Boolean isObposIsmultiselectable() {
        return (Boolean) get(PROPERTY_OBPOSISMULTISELECTABLE);
    }

    public void setObposIsmultiselectable(Boolean obposIsmultiselectable) {
        set(PROPERTY_OBPOSISMULTISELECTABLE, obposIsmultiselectable);
    }

    public Boolean isSpatmpTransferable() {
        return (Boolean) get(PROPERTY_SPATMPTRANSFERABLE);
    }

    public void setSpatmpTransferable(Boolean spatmpTransferable) {
        set(PROPERTY_SPATMPTRANSFERABLE, spatmpTransferable);
    }

    public SsfiModelProduct getSsfiModelProd() {
        return (SsfiModelProduct) get(PROPERTY_SSFIMODELPROD);
    }

    public void setSsfiModelProd(SsfiModelProduct ssfiModelProd) {
        set(PROPERTY_SSFIMODELPROD, ssfiModelProd);
    }

    public Boolean isScrtlaControlAssets() {
        return (Boolean) get(PROPERTY_SCRTLACONTROLASSETS);
    }

    public void setScrtlaControlAssets(Boolean scrtlaControlAssets) {
        set(PROPERTY_SCRTLACONTROLASSETS, scrtlaControlAssets);
    }

    public ScmfMrpProdSubCategory getScmfMrpProdsubcat() {
        return (ScmfMrpProdSubCategory) get(PROPERTY_SCMFMRPPRODSUBCAT);
    }

    public void setScmfMrpProdsubcat(ScmfMrpProdSubCategory scmfMrpProdsubcat) {
        set(PROPERTY_SCMFMRPPRODSUBCAT, scmfMrpProdsubcat);
    }

    public Long getSscrtxtUnitsPerBox() {
        return (Long) get(PROPERTY_SSCRTXTUNITSPERBOX);
    }

    public void setSscrtxtUnitsPerBox(Long sscrtxtUnitsPerBox) {
        set(PROPERTY_SSCRTXTUNITSPERBOX, sscrtxtUnitsPerBox);
    }

    public ProductStatus getProductStatus() {
        return (ProductStatus) get(PROPERTY_PRODUCTSTATUS);
    }

    public void setProductStatus(ProductStatus productStatus) {
        set(PROPERTY_PRODUCTSTATUS, productStatus);
    }

    public BigDecimal getEcslimmMin() {
        return (BigDecimal) get(PROPERTY_ECSLIMMMIN);
    }

    public void setEcslimmMin(BigDecimal ecslimmMin) {
        set(PROPERTY_ECSLIMMMIN, ecslimmMin);
    }

    public BigDecimal getEcslimmMax() {
        return (BigDecimal) get(PROPERTY_ECSLIMMMAX);
    }

    public void setEcslimmMax(BigDecimal ecslimmMax) {
        set(PROPERTY_ECSLIMMMAX, ecslimmMax);
    }

    public SlpsSubcategoryProduct getSlpsSubcategoryProd() {
        return (SlpsSubcategoryProduct) get(PROPERTY_SLPSSUBCATEGORYPROD);
    }

    public void setSlpsSubcategoryProd(SlpsSubcategoryProduct slpsSubcategoryProd) {
        set(PROPERTY_SLPSSUBCATEGORYPROD, slpsSubcategoryProd);
    }

    public SlpsProductCategory getSlpsProductCategory() {
        return (SlpsProductCategory) get(PROPERTY_SLPSPRODUCTCATEGORY);
    }

    public void setSlpsProductCategory(SlpsProductCategory slpsProductCategory) {
        set(PROPERTY_SLPSPRODUCTCATEGORY, slpsProductCategory);
    }

    public Boolean isObposPrintservices() {
        return (Boolean) get(PROPERTY_OBPOSPRINTSERVICES);
    }

    public void setObposPrintservices(Boolean obposPrintservices) {
        set(PROPERTY_OBPOSPRINTSERVICES, obposPrintservices);
    }

    public Boolean isSlqsCheckQuality() {
        return (Boolean) get(PROPERTY_SLQSCHECKQUALITY);
    }

    public void setSlqsCheckQuality(Boolean slqsCheckQuality) {
        set(PROPERTY_SLQSCHECKQUALITY, slqsCheckQuality);
    }

    public PeriodicControl getSlqsMpPerCtrl() {
        return (PeriodicControl) get(PROPERTY_SLQSMPPERCTRL);
    }

    public void setSlqsMpPerCtrl(PeriodicControl slqsMpPerCtrl) {
        set(PROPERTY_SLQSMPPERCTRL, slqsMpPerCtrl);
    }

    public Boolean isSsipiceTaxIce() {
        return (Boolean) get(PROPERTY_SSIPICETAXICE);
    }

    public void setSsipiceTaxIce(Boolean ssipiceTaxIce) {
        set(PROPERTY_SSIPICETAXICE, ssipiceTaxIce);
    }

    public BigDecimal getSsipicePercentIce() {
        return (BigDecimal) get(PROPERTY_SSIPICEPERCENTICE);
    }

    public void setSsipicePercentIce(BigDecimal ssipicePercentIce) {
        set(PROPERTY_SSIPICEPERCENTICE, ssipicePercentIce);
    }

    public BigDecimal getSsipicePvpSri() {
        return (BigDecimal) get(PROPERTY_SSIPICEPVPSRI);
    }

    public void setSsipicePvpSri(BigDecimal ssipicePvpSri) {
        set(PROPERTY_SSIPICEPVPSRI, ssipicePvpSri);
    }

    public Boolean isSpgiInvoice() {
        return (Boolean) get(PROPERTY_SPGIINVOICE);
    }

    public void setSpgiInvoice(Boolean spgiInvoice) {
        set(PROPERTY_SPGIINVOICE, spgiInvoice);
    }

    public Boolean isSiblrIswarehouse() {
        return (Boolean) get(PROPERTY_SIBLRISWAREHOUSE);
    }

    public void setSiblrIswarehouse(Boolean siblrIswarehouse) {
        set(PROPERTY_SIBLRISWAREHOUSE, siblrIswarehouse);
    }

    public String getSlplagPackage() {
        return (String) get(PROPERTY_SLPLAGPACKAGE);
    }

    public void setSlplagPackage(String slplagPackage) {
        set(PROPERTY_SLPLAGPACKAGE, slplagPackage);
    }

    public Boolean isSpevDiscountable() {
        return (Boolean) get(PROPERTY_SPEVDISCOUNTABLE);
    }

    public void setSpevDiscountable(Boolean spevDiscountable) {
        set(PROPERTY_SPEVDISCOUNTABLE, spevDiscountable);
    }

    public String getSlplagProdclasif() {
        return (String) get(PROPERTY_SLPLAGPRODCLASIF);
    }

    public void setSlplagProdclasif(String slplagProdclasif) {
        set(PROPERTY_SLPLAGPRODCLASIF, slplagProdclasif);
    }

    public String getSlplagBrand() {
        return (String) get(PROPERTY_SLPLAGBRAND);
    }

    public void setSlplagBrand(String slplagBrand) {
        set(PROPERTY_SLPLAGBRAND, slplagBrand);
    }

    public String getSlplagProdcap() {
        return (String) get(PROPERTY_SLPLAGPRODCAP);
    }

    public void setSlplagProdcap(String slplagProdcap) {
        set(PROPERTY_SLPLAGPRODCAP, slplagProdcap);
    }

    public String getSlplagIrbpunit() {
        return (String) get(PROPERTY_SLPLAGIRBPUNIT);
    }

    public void setSlplagIrbpunit(String slplagIrbpunit) {
        set(PROPERTY_SLPLAGIRBPUNIT, slplagIrbpunit);
    }

    public String getSlplagGalcohol() {
        return (String) get(PROPERTY_SLPLAGGALCOHOL);
    }

    public void setSlplagGalcohol(String slplagGalcohol) {
        set(PROPERTY_SLPLAGGALCOHOL, slplagGalcohol);
    }

    public SlplagKindpackage getSlplagMantainpackage() {
        return (SlplagKindpackage) get(PROPERTY_SLPLAGMANTAINPACKAGE);
    }

    public void setSlplagMantainpackage(SlplagKindpackage slplagMantainpackage) {
        set(PROPERTY_SLPLAGMANTAINPACKAGE, slplagMantainpackage);
    }

    public ssfbi_commercial_category getSsfbiCommercialCategory() {
        return (ssfbi_commercial_category) get(PROPERTY_SSFBICOMMERCIALCATEGORY);
    }

    public void setSsfbiCommercialCategory(ssfbi_commercial_category ssfbiCommercialCategory) {
        set(PROPERTY_SSFBICOMMERCIALCATEGORY, ssfbiCommercialCategory);
    }

    public Boolean isSsldmrpCostLdm() {
        return (Boolean) get(PROPERTY_SSLDMRPCOSTLDM);
    }

    public void setSsldmrpCostLdm(Boolean ssldmrpCostLdm) {
        set(PROPERTY_SSLDMRPCOSTLDM, ssldmrpCostLdm);
    }

    public Boolean isCrprodProductact() {
        return (Boolean) get(PROPERTY_CRPRODPRODUCTACT);
    }

    public void setCrprodProductact(Boolean crprodProductact) {
        set(PROPERTY_CRPRODPRODUCTACT, crprodProductact);
    }

    public Long getSirbpPlasticunitsbom() {
        return (Long) get(PROPERTY_SIRBPPLASTICUNITSBOM);
    }

    public void setSirbpPlasticunitsbom(Long sirbpPlasticunitsbom) {
        set(PROPERTY_SIRBPPLASTICUNITSBOM, sirbpPlasticunitsbom);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccTransactionAccounting> getAPRMFinAccTransactionAcctVList() {
      return (List<FinAccTransactionAccounting>) get(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST);
    }

    public void setAPRMFinAccTransactionAcctVList(List<FinAccTransactionAccounting> aPRMFinAccTransactionAcctVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, aPRMFinAccTransactionAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_FinaccTransactionV> getAPRMFinaccTransactionVList() {
      return (List<APRM_FinaccTransactionV>) get(PROPERTY_APRMFINACCTRANSACTIONVLIST);
    }

    public void setAPRMFinaccTransactionVList(List<APRM_FinaccTransactionV> aPRMFinaccTransactionVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONVLIST, aPRMFinaccTransactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Finacc_Trx_Full_Acct_V> getAPRMFinaccTrxFullAcctVList() {
      return (List<APRM_Finacc_Trx_Full_Acct_V>) get(PROPERTY_APRMFINACCTRXFULLACCTVLIST);
    }

    public void setAPRMFinaccTrxFullAcctVList(List<APRM_Finacc_Trx_Full_Acct_V> aPRMFinaccTrxFullAcctVList) {
        set(PROPERTY_APRMFINACCTRXFULLACCTVLIST, aPRMFinaccTrxFullAcctVList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLineAccountingDimension> getAmortizationLineAccountingDimensionList() {
      return (List<AmortizationLineAccountingDimension>) get(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setAmortizationLineAccountingDimensionList(List<AmortizationLineAccountingDimension> amortizationLineAccountingDimensionList) {
        set(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, amortizationLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<ApprovedVendor> getApprovedVendorList() {
      return (List<ApprovedVendor>) get(PROPERTY_APPROVEDVENDORLIST);
    }

    public void setApprovedVendorList(List<ApprovedVendor> approvedVendorList) {
        set(PROPERTY_APPROVEDVENDORLIST, approvedVendorList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductTemplate> getBusinessPartnerProductTemplateList() {
      return (List<ProductTemplate>) get(PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST);
    }

    public void setBusinessPartnerProductTemplateList(List<ProductTemplate> businessPartnerProductTemplateList) {
        set(PROPERTY_BUSINESSPARTNERPRODUCTTEMPLATELIST, businessPartnerProductTemplateList);
    }

    @SuppressWarnings("unchecked")
    public List<ClientInformation> getClientInformationProductForFreightList() {
      return (List<ClientInformation>) get(PROPERTY_CLIENTINFORMATIONPRODUCTFORFREIGHTLIST);
    }

    public void setClientInformationProductForFreightList(List<ClientInformation> clientInformationProductForFreightList) {
        set(PROPERTY_CLIENTINFORMATIONPRODUCTFORFREIGHTLIST, clientInformationProductForFreightList);
    }

    @SuppressWarnings("unchecked")
    public List<CostingRule> getCostingRuleList() {
      return (List<CostingRule>) get(PROPERTY_COSTINGRULELIST);
    }

    public void setCostingRuleList(List<CostingRule> costingRuleList) {
        set(PROPERTY_COSTINGRULELIST, costingRuleList);
    }

    @SuppressWarnings("unchecked")
    public List<CostingRuleProductV> getCostingRuleProductVApplyProductList() {
      return (List<CostingRuleProductV>) get(PROPERTY_COSTINGRULEPRODUCTVAPPLYPRODUCTLIST);
    }

    public void setCostingRuleProductVApplyProductList(List<CostingRuleProductV> costingRuleProductVApplyProductList) {
        set(PROPERTY_COSTINGRULEPRODUCTVAPPLYPRODUCTLIST, costingRuleProductVApplyProductList);
    }

    @SuppressWarnings("unchecked")
    public List<CostingRuleProductV> getCostingRuleProductVList() {
      return (List<CostingRuleProductV>) get(PROPERTY_COSTINGRULEPRODUCTVLIST);
    }

    public void setCostingRuleProductVList(List<CostingRuleProductV> costingRuleProductVList) {
        set(PROPERTY_COSTINGRULEPRODUCTVLIST, costingRuleProductVList);
    }

    @SuppressWarnings("unchecked")
    public List<CreatePOLinesPE> getCreatePOLinesPEList() {
      return (List<CreatePOLinesPE>) get(PROPERTY_CREATEPOLINESPELIST);
    }

    public void setCreatePOLinesPEList(List<CreatePOLinesPE> createPOLinesPEList) {
        set(PROPERTY_CREATEPOLINESPELIST, createPOLinesPEList);
    }

    @SuppressWarnings("unchecked")
    public List<FreeProduct> getDISCTFREEPRODUCTList() {
      return (List<FreeProduct>) get(PROPERTY_DISCTFREEPRODUCTLIST);
    }

    public void setDISCTFREEPRODUCTList(List<FreeProduct> dISCTFREEPRODUCTList) {
        set(PROPERTY_DISCTFREEPRODUCTLIST, dISCTFREEPRODUCTList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOSProduct> getExternalPOSProductList() {
      return (List<ExternalPOSProduct>) get(PROPERTY_EXTERNALPOSPRODUCTLIST);
    }

    public void setExternalPOSProductList(List<ExternalPOSProduct> externalPOSProductList) {
        set(PROPERTY_EXTERNALPOSPRODUCTLIST, externalPOSProductList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONLIST);
    }

    public void setFINFinaccTransactionList(List<FIN_FinaccTransaction> fINFinaccTransactionList) {
        set(PROPERTY_FINFINACCTRANSACTIONLIST, fINFinaccTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetailV> getFINPaymentDetailVList() {
      return (List<FIN_PaymentDetailV>) get(PROPERTY_FINPAYMENTDETAILVLIST);
    }

    public void setFINPaymentDetailVList(List<FIN_PaymentDetailV> fINPaymentDetailVList) {
        set(PROPERTY_FINPAYMENTDETAILVLIST, fINPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST);
    }

    public void setFINPaymentScheduleDetailList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, fINPaymentScheduleDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingCombination> getFinancialMgmtAccountingCombinationList() {
      return (List<AccountingCombination>) get(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST);
    }

    public void setFinancialMgmtAccountingCombinationList(List<AccountingCombination> financialMgmtAccountingCombinationList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST, financialMgmtAccountingCombinationList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<AcctSchemaElement> getFinancialMgmtAcctSchemaElementList() {
      return (List<AcctSchemaElement>) get(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST);
    }

    public void setFinancialMgmtAcctSchemaElementList(List<AcctSchemaElement> financialMgmtAcctSchemaElementList) {
        set(PROPERTY_FINANCIALMGMTACCTSCHEMAELEMENTLIST, financialMgmtAcctSchemaElementList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETLIST);
    }

    public void setFinancialMgmtAssetList(List<Asset> financialMgmtAssetList) {
        set(PROPERTY_FINANCIALMGMTASSETLIST, financialMgmtAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineEMScftProductIDList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINEEMSCFTPRODUCTIDLIST);
    }

    public void setFinancialMgmtBudgetLineEMScftProductIDList(List<BudgetLine> financialMgmtBudgetLineEMScftProductIDList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINEEMSCFTPRODUCTIDLIST, financialMgmtBudgetLineEMScftProductIDList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardInst> getGCNVGiftCardInstList() {
      return (List<GiftCardInst>) get(PROPERTY_GCNVGIFTCARDINSTLIST);
    }

    public void setGCNVGiftCardInstList(List<GiftCardInst> gCNVGiftCardInstList) {
        set(PROPERTY_GCNVGIFTCARDINSTLIST, gCNVGiftCardInstList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardSummary> getGCNVGiftCardSummaryList() {
      return (List<GiftCardSummary>) get(PROPERTY_GCNVGIFTCARDSUMMARYLIST);
    }

    public void setGCNVGiftCardSummaryList(List<GiftCardSummary> gCNVGiftCardSummaryList) {
        set(PROPERTY_GCNVGIFTCARDSUMMARYLIST, gCNVGiftCardSummaryList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardTrans> getGCNVGiftCardTransList() {
      return (List<GiftCardTrans>) get(PROPERTY_GCNVGIFTCARDTRANSLIST);
    }

    public void setGCNVGiftCardTransList(List<GiftCardTrans> gCNVGiftCardTransList) {
        set(PROPERTY_GCNVGIFTCARDTRANSLIST, gCNVGiftCardTransList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductSummary> getGCNVProductSummaryList() {
      return (List<ProductSummary>) get(PROPERTY_GCNVPRODUCTSUMMARYLIST);
    }

    public void setGCNVProductSummaryList(List<ProductSummary> gCNVProductSummaryList) {
        set(PROPERTY_GCNVPRODUCTSUMMARYLIST, gCNVProductSummaryList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductSummary> getGCNVProductSummaryMIncproductIDList() {
      return (List<ProductSummary>) get(PROPERTY_GCNVPRODUCTSUMMARYMINCPRODUCTIDLIST);
    }

    public void setGCNVProductSummaryMIncproductIDList(List<ProductSummary> gCNVProductSummaryMIncproductIDList) {
        set(PROPERTY_GCNVPRODUCTSUMMARYMINCPRODUCTIDLIST, gCNVProductSummaryMIncproductIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InOutLineAccountingDimension> getInOutLineAccountingDimensionList() {
      return (List<InOutLineAccountingDimension>) get(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInOutLineAccountingDimensionList(List<InOutLineAccountingDimension> inOutLineAccountingDimensionList) {
        set(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, inOutLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryAmountUpdateLine> getInventoryAmountUpdateLineList() {
      return (List<InventoryAmountUpdateLine>) get(PROPERTY_INVENTORYAMOUNTUPDATELINELIST);
    }

    public void setInventoryAmountUpdateLineList(List<InventoryAmountUpdateLine> inventoryAmountUpdateLineList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELINELIST, inventoryAmountUpdateLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineV2> getInvoiceLineV2List() {
      return (List<InvoiceLineV2>) get(PROPERTY_INVOICELINEV2LIST);
    }

    public void setInvoiceLineV2List(List<InvoiceLineV2> invoiceLineV2List) {
        set(PROPERTY_INVOICELINEV2LIST, invoiceLineV2List);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostType> getLandedCostTypeList() {
      return (List<LandedCostType>) get(PROPERTY_LANDEDCOSTTYPELIST);
    }

    public void setLandedCostTypeList(List<LandedCostType> landedCostTypeList) {
        set(PROPERTY_LANDEDCOSTTYPELIST, landedCostTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<Lot> getLotList() {
      return (List<Lot>) get(PROPERTY_LOTLIST);
    }

    public void setLotList(List<Lot> lotList) {
        set(PROPERTY_LOTLIST, lotList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRun> getMRPProductionRunList() {
      return (List<ProductionRun>) get(PROPERTY_MRPPRODUCTIONRUNLIST);
    }

    public void setMRPProductionRunList(List<ProductionRun> mRPProductionRunList) {
        set(PROPERTY_MRPPRODUCTIONRUNLIST, mRPProductionRunList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionRunLine> getMRPProductionRunLineList() {
      return (List<ProductionRunLine>) get(PROPERTY_MRPPRODUCTIONRUNLINELIST);
    }

    public void setMRPProductionRunLineList(List<ProductionRunLine> mRPProductionRunLineList) {
        set(PROPERTY_MRPPRODUCTIONRUNLINELIST, mRPProductionRunLineList);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRun> getMRPPurchasingRunList() {
      return (List<PurchasingRun>) get(PROPERTY_MRPPURCHASINGRUNLIST);
    }

    public void setMRPPurchasingRunList(List<PurchasingRun> mRPPurchasingRunList) {
        set(PROPERTY_MRPPURCHASINGRUNLIST, mRPPurchasingRunList);
    }

    @SuppressWarnings("unchecked")
    public List<PurchasingRunLine> getMRPPurchasingRunLineList() {
      return (List<PurchasingRunLine>) get(PROPERTY_MRPPURCHASINGRUNLINELIST);
    }

    public void setMRPPurchasingRunLineList(List<PurchasingRunLine> mRPPurchasingRunLineList) {
        set(PROPERTY_MRPPURCHASINGRUNLINELIST, mRPPurchasingRunLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SalesForecastLine> getMRPSalesForecastLineList() {
      return (List<SalesForecastLine>) get(PROPERTY_MRPSALESFORECASTLINELIST);
    }

    public void setMRPSalesForecastLineList(List<SalesForecastLine> mRPSalesForecastLineList) {
        set(PROPERTY_MRPSALESFORECASTLINELIST, mRPSalesForecastLineList);
    }

    @SuppressWarnings("unchecked")
    public List<StockValuation> getStockValuationList() {
      return (List<StockValuation>) get(PROPERTY_STOCKVALUATIONLIST);
    }

    public void setStockValuationList(List<StockValuation> stockValuationList) {
        set(PROPERTY_STOCKVALUATIONLIST, stockValuationList);
    }

    @SuppressWarnings("unchecked")
    public List<Case> getManufacturingCaseList() {
      return (List<Case>) get(PROPERTY_MANUFACTURINGCASELIST);
    }

    public void setManufacturingCaseList(List<Case> manufacturingCaseList) {
        set(PROPERTY_MANUFACTURINGCASELIST, manufacturingCaseList);
    }

    @SuppressWarnings("unchecked")
    public List<GlobalUse> getManufacturingGlobalUseList() {
      return (List<GlobalUse>) get(PROPERTY_MANUFACTURINGGLOBALUSELIST);
    }

    public void setManufacturingGlobalUseList(List<GlobalUse> manufacturingGlobalUseList) {
        set(PROPERTY_MANUFACTURINGGLOBALUSELIST, manufacturingGlobalUseList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMSpqulyProductIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYPRODUCTIDLIST);
    }

    public void setManufacturingMeasureShiftEMSpqulyProductIDList(List<MeasureShift> manufacturingMeasureShiftEMSpqulyProductIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYPRODUCTIDLIST, manufacturingMeasureShiftEMSpqulyProductIDList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMSpqulyFinishedprodIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYFINISHEDPRODIDLIST);
    }

    public void setManufacturingMeasureShiftEMSpqulyFinishedprodIDList(List<MeasureShift> manufacturingMeasureShiftEMSpqulyFinishedprodIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMSPQULYFINISHEDPRODIDLIST, manufacturingMeasureShiftEMSpqulyFinishedprodIDList);
    }

    @SuppressWarnings("unchecked")
    public List<OperationProduct> getManufacturingOperationProductList() {
      return (List<OperationProduct>) get(PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST);
    }

    public void setManufacturingOperationProductList(List<OperationProduct> manufacturingOperationProductList) {
        set(PROPERTY_MANUFACTURINGOPERATIONPRODUCTLIST, manufacturingOperationProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionLine> getManufacturingProductionLineList() {
      return (List<ProductionLine>) get(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST);
    }

    public void setManufacturingProductionLineList(List<ProductionLine> manufacturingProductionLineList) {
        set(PROPERTY_MANUFACTURINGPRODUCTIONLINELIST, manufacturingProductionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirementProduct> getManufacturingWorkRequirementProductList() {
      return (List<WorkRequirementProduct>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST);
    }

    public void setManufacturingWorkRequirementProductList(List<WorkRequirementProduct> manufacturingWorkRequirementProductList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTPRODUCTLIST, manufacturingWorkRequirementProductList);
    }

    @SuppressWarnings("unchecked")
    public List<Costing> getMaterialMgmtCostingList() {
      return (List<Costing>) get(PROPERTY_MATERIALMGMTCOSTINGLIST);
    }

    public void setMaterialMgmtCostingList(List<Costing> materialMgmtCostingList) {
        set(PROPERTY_MATERIALMGMTCOSTINGLIST, materialMgmtCostingList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalConsumptionLine> getMaterialMgmtInternalConsumptionLineList() {
      return (List<InternalConsumptionLine>) get(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST);
    }

    public void setMaterialMgmtInternalConsumptionLineList(List<InternalConsumptionLine> materialMgmtInternalConsumptionLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLINELIST, materialMgmtInternalConsumptionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovementLine> getMaterialMgmtInternalMovementLineList() {
      return (List<InternalMovementLine>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST);
    }

    public void setMaterialMgmtInternalMovementLineList(List<InternalMovementLine> materialMgmtInternalMovementLineList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLINELIST, materialMgmtInternalMovementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCountLine> getMaterialMgmtInventoryCountLineList() {
      return (List<InventoryCountLine>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST);
    }

    public void setMaterialMgmtInventoryCountLineList(List<InventoryCountLine> materialMgmtInventoryCountLineList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLINELIST, materialMgmtInventoryCountLineList);
    }

    @SuppressWarnings("unchecked")
    public List<MaterialTransaction> getMaterialMgmtMaterialTransactionList() {
      return (List<MaterialTransaction>) get(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST);
    }

    public void setMaterialMgmtMaterialTransactionList(List<MaterialTransaction> materialMgmtMaterialTransactionList) {
        set(PROPERTY_MATERIALMGMTMATERIALTRANSACTIONLIST, materialMgmtMaterialTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionPlan> getMaterialMgmtProductionPlanList() {
      return (List<ProductionPlan>) get(PROPERTY_MATERIALMGMTPRODUCTIONPLANLIST);
    }

    public void setMaterialMgmtProductionPlanList(List<ProductionPlan> materialMgmtProductionPlanList) {
        set(PROPERTY_MATERIALMGMTPRODUCTIONPLANLIST, materialMgmtProductionPlanList);
    }

    @SuppressWarnings("unchecked")
    public List<Reservation> getMaterialMgmtReservationList() {
      return (List<Reservation>) get(PROPERTY_MATERIALMGMTRESERVATIONLIST);
    }

    public void setMaterialMgmtReservationList(List<Reservation> materialMgmtReservationList) {
        set(PROPERTY_MATERIALMGMTRESERVATIONLIST, materialMgmtReservationList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<StorageDetail> getMaterialMgmtStorageDetailList() {
      return (List<StorageDetail>) get(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST);
    }

    public void setMaterialMgmtStorageDetailList(List<StorageDetail> materialMgmtStorageDetailList) {
        set(PROPERTY_MATERIALMGMTSTORAGEDETAILLIST, materialMgmtStorageDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<StoragePending> getMaterialMgmtStoragePendingList() {
      return (List<StoragePending>) get(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST);
    }

    public void setMaterialMgmtStoragePendingList(List<StoragePending> materialMgmtStoragePendingList) {
        set(PROPERTY_MATERIALMGMTSTORAGEPENDINGLIST, materialMgmtStoragePendingList);
    }

    @SuppressWarnings("unchecked")
    public List<esmpMatrizConfiguracionLine> getMatrizConfiguracionLineList() {
      return (List<esmpMatrizConfiguracionLine>) get(PROPERTY_MATRIZCONFIGURACIONLINELIST);
    }

    public void setMatrizConfiguracionLineList(List<esmpMatrizConfiguracionLine> matrizConfiguracionLineList) {
        set(PROPERTY_MATRIZCONFIGURACIONLINELIST, matrizConfiguracionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ComboProduct> getOBCOMBOProductList() {
      return (List<ComboProduct>) get(PROPERTY_OBCOMBOPRODUCTLIST);
    }

    public void setOBCOMBOProductList(List<ComboProduct> oBCOMBOProductList) {
        set(PROPERTY_OBCOMBOPRODUCTLIST, oBCOMBOProductList);
    }

    @SuppressWarnings("unchecked")
    public List<OBRETCOProlProduct> getOBRETCOProlProductList() {
      return (List<OBRETCOProlProduct>) get(PROPERTY_OBRETCOPROLPRODUCTLIST);
    }

    public void setOBRETCOProlProductList(List<OBRETCOProlProduct> oBRETCOProlProductList) {
        set(PROPERTY_OBRETCOPROLPRODUCTLIST, oBRETCOProlProductList);
    }

    @SuppressWarnings("unchecked")
    public List<OBWCL_StockByWarehouseView> getOBWCLStockByWarehouseViewList() {
      return (List<OBWCL_StockByWarehouseView>) get(PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST);
    }

    public void setOBWCLStockByWarehouseViewList(List<OBWCL_StockByWarehouseView> oBWCLStockByWarehouseViewList) {
        set(PROPERTY_OBWCLSTOCKBYWAREHOUSEVIEWLIST, oBWCLStockByWarehouseViewList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineEmAtvefProduct2List() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINEEMATVEFPRODUCT2LIST);
    }

    public void setOrderLineEmAtvefProduct2List(List<OrderLine> orderLineEmAtvefProduct2List) {
        set(PROPERTY_ORDERLINEEMATVEFPRODUCT2LIST, orderLineEmAtvefProduct2List);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineAccountingDimension> getOrderLineAccountingDimensionList() {
      return (List<OrderLineAccountingDimension>) get(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setOrderLineAccountingDimensionList(List<OrderLineAccountingDimension> orderLineAccountingDimensionList) {
        set(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, orderLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.priceadjustment.Product> getPricingAdjustmentProductList() {
      return (List<org.openbravo.model.pricing.priceadjustment.Product>) get(PROPERTY_PRICINGADJUSTMENTPRODUCTLIST);
    }

    public void setPricingAdjustmentProductList(List<org.openbravo.model.pricing.priceadjustment.Product> pricingAdjustmentProductList) {
        set(PROPERTY_PRICINGADJUSTMENTPRODUCTLIST, pricingAdjustmentProductList);
    }

    @SuppressWarnings("unchecked")
    public List<Discount> getPricingDiscountList() {
      return (List<Discount>) get(PROPERTY_PRICINGDISCOUNTLIST);
    }

    public void setPricingDiscountList(List<Discount> pricingDiscountList) {
        set(PROPERTY_PRICINGDISCOUNTLIST, pricingDiscountList);
    }

    @SuppressWarnings("unchecked")
    public List<PriceListSchemeLine> getPricingPriceListSchemeLineList() {
      return (List<PriceListSchemeLine>) get(PROPERTY_PRICINGPRICELISTSCHEMELINELIST);
    }

    public void setPricingPriceListSchemeLineList(List<PriceListSchemeLine> pricingPriceListSchemeLineList) {
        set(PROPERTY_PRICINGPRICELISTSCHEMELINELIST, pricingPriceListSchemeLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductPrice> getPricingProductPriceList() {
      return (List<ProductPrice>) get(PROPERTY_PRICINGPRODUCTPRICELIST);
    }

    public void setPricingProductPriceList(List<ProductPrice> pricingProductPriceList) {
        set(PROPERTY_PRICINGPRODUCTPRICELIST, pricingProductPriceList);
    }

    @SuppressWarnings("unchecked")
    public List<org.openbravo.model.pricing.volumediscount.Product> getPricingVolumeDiscountProductList() {
      return (List<org.openbravo.model.pricing.volumediscount.Product>) get(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST);
    }

    public void setPricingVolumeDiscountProductList(List<org.openbravo.model.pricing.volumediscount.Product> pricingVolumeDiscountProductList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTPRODUCTLIST, pricingVolumeDiscountProductList);
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
    public List<RequisitionLine> getProcurementRequisitionLineList() {
      return (List<RequisitionLine>) get(PROPERTY_PROCUREMENTREQUISITIONLINELIST);
    }

    public void setProcurementRequisitionLineList(List<RequisitionLine> procurementRequisitionLineList) {
        set(PROPERTY_PROCUREMENTREQUISITIONLINELIST, procurementRequisitionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Product> getProductGenericProductList() {
      return (List<Product>) get(PROPERTY_PRODUCTGENERICPRODUCTLIST);
    }

    public void setProductGenericProductList(List<Product> productGenericProductList) {
        set(PROPERTY_PRODUCTGENERICPRODUCTLIST, productGenericProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductAUM> getProductAUMList() {
      return (List<ProductAUM>) get(PROPERTY_PRODUCTAUMLIST);
    }

    public void setProductAUMList(List<ProductAUM> productAUMList) {
        set(PROPERTY_PRODUCTAUMLIST, productAUMList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductAccounts> getProductAccountsList() {
      return (List<ProductAccounts>) get(PROPERTY_PRODUCTACCOUNTSLIST);
    }

    public void setProductAccountsList(List<ProductAccounts> productAccountsList) {
        set(PROPERTY_PRODUCTACCOUNTSLIST, productAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductBOM> getProductBOMList() {
      return (List<ProductBOM>) get(PROPERTY_PRODUCTBOMLIST);
    }

    public void setProductBOMList(List<ProductBOM> productBOMList) {
        set(PROPERTY_PRODUCTBOMLIST, productBOMList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductBOM> getProductBOMBOMProductList() {
      return (List<ProductBOM>) get(PROPERTY_PRODUCTBOMBOMPRODUCTLIST);
    }

    public void setProductBOMBOMProductList(List<ProductBOM> productBOMBOMProductList) {
        set(PROPERTY_PRODUCTBOMBOMPRODUCTLIST, productBOMBOMProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductByPriceAndWarehouse> getProductByPriceAndWarehouseList() {
      return (List<ProductByPriceAndWarehouse>) get(PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST);
    }

    public void setProductByPriceAndWarehouseList(List<ProductByPriceAndWarehouse> productByPriceAndWarehouseList) {
        set(PROPERTY_PRODUCTBYPRICEANDWAREHOUSELIST, productByPriceAndWarehouseList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristic> getProductCharacteristicList() {
      return (List<ProductCharacteristic>) get(PROPERTY_PRODUCTCHARACTERISTICLIST);
    }

    public void setProductCharacteristicList(List<ProductCharacteristic> productCharacteristicList) {
        set(PROPERTY_PRODUCTCHARACTERISTICLIST, productCharacteristicList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristicValue> getProductCharacteristicValueList() {
      return (List<ProductCharacteristicValue>) get(PROPERTY_PRODUCTCHARACTERISTICVALUELIST);
    }

    public void setProductCharacteristicValueList(List<ProductCharacteristicValue> productCharacteristicValueList) {
        set(PROPERTY_PRODUCTCHARACTERISTICVALUELIST, productCharacteristicValueList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCustomer> getProductCustomerList() {
      return (List<ProductCustomer>) get(PROPERTY_PRODUCTCUSTOMERLIST);
    }

    public void setProductCustomerList(List<ProductCustomer> productCustomerList) {
        set(PROPERTY_PRODUCTCUSTOMERLIST, productCustomerList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductOrg> getProductOrgList() {
      return (List<ProductOrg>) get(PROPERTY_PRODUCTORGLIST);
    }

    public void setProductOrgList(List<ProductOrg> productOrgList) {
        set(PROPERTY_PRODUCTORGLIST, productOrgList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductStockView> getProductStockViewList() {
      return (List<ProductStockView>) get(PROPERTY_PRODUCTSTOCKVIEWLIST);
    }

    public void setProductStockViewList(List<ProductStockView> productStockViewList) {
        set(PROPERTY_PRODUCTSTOCKVIEWLIST, productStockViewList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductSubstitute> getProductSubstituteList() {
      return (List<ProductSubstitute>) get(PROPERTY_PRODUCTSUBSTITUTELIST);
    }

    public void setProductSubstituteList(List<ProductSubstitute> productSubstituteList) {
        set(PROPERTY_PRODUCTSUBSTITUTELIST, productSubstituteList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductSubstitute> getProductSubstituteSubstituteProductList() {
      return (List<ProductSubstitute>) get(PROPERTY_PRODUCTSUBSTITUTESUBSTITUTEPRODUCTLIST);
    }

    public void setProductSubstituteSubstituteProductList(List<ProductSubstitute> productSubstituteSubstituteProductList) {
        set(PROPERTY_PRODUCTSUBSTITUTESUBSTITUTEPRODUCTLIST, productSubstituteSubstituteProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductTrl> getProductTrlList() {
      return (List<ProductTrl>) get(PROPERTY_PRODUCTTRLLIST);
    }

    public void setProductTrlList(List<ProductTrl> productTrlList) {
        set(PROPERTY_PRODUCTTRLLIST, productTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductUOM> getProductUOMList() {
      return (List<ProductUOM>) get(PROPERTY_PRODUCTUOMLIST);
    }

    public void setProductUOMList(List<ProductUOM> productUOMList) {
        set(PROPERTY_PRODUCTUOMLIST, productUOMList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristics> getProductWithCharacteristicsList() {
      return (List<ProductCharacteristics>) get(PROPERTY_PRODUCTWITHCHARACTERISTICSLIST);
    }

    public void setProductWithCharacteristicsList(List<ProductCharacteristics> productWithCharacteristicsList) {
        set(PROPERTY_PRODUCTWITHCHARACTERISTICSLIST, productWithCharacteristicsList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductCharacteristics> getProductWithCharacteristicsGenericProductList() {
      return (List<ProductCharacteristics>) get(PROPERTY_PRODUCTWITHCHARACTERISTICSGENERICPRODUCTLIST);
    }

    public void setProductWithCharacteristicsGenericProductList(List<ProductCharacteristics> productWithCharacteristicsGenericProductList) {
        set(PROPERTY_PRODUCTWITHCHARACTERISTICSGENERICPRODUCTLIST, productWithCharacteristicsGenericProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectIssue> getProjectIssueList() {
      return (List<ProjectIssue>) get(PROPERTY_PROJECTISSUELIST);
    }

    public void setProjectIssueList(List<ProjectIssue> projectIssueList) {
        set(PROPERTY_PROJECTISSUELIST, projectIssueList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectLine> getProjectLineList() {
      return (List<ProjectLine>) get(PROPERTY_PROJECTLINELIST);
    }

    public void setProjectLineList(List<ProjectLine> projectLineList) {
        set(PROPERTY_PROJECTLINELIST, projectLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectPhase> getProjectPhaseList() {
      return (List<ProjectPhase>) get(PROPERTY_PROJECTPHASELIST);
    }

    public void setProjectPhaseList(List<ProjectPhase> projectPhaseList) {
        set(PROPERTY_PROJECTPHASELIST, projectPhaseList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectProposalLine> getProjectProposalLineList() {
      return (List<ProjectProposalLine>) get(PROPERTY_PROJECTPROPOSALLINELIST);
    }

    public void setProjectProposalLineList(List<ProjectProposalLine> projectProposalLineList) {
        set(PROPERTY_PROJECTPROPOSALLINELIST, projectProposalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<StandardPhase> getProjectStandardPhaseList() {
      return (List<StandardPhase>) get(PROPERTY_PROJECTSTANDARDPHASELIST);
    }

    public void setProjectStandardPhaseList(List<StandardPhase> projectStandardPhaseList) {
        set(PROPERTY_PROJECTSTANDARDPHASELIST, projectStandardPhaseList);
    }

    @SuppressWarnings("unchecked")
    public List<StandardTask> getProjectStandardTaskList() {
      return (List<StandardTask>) get(PROPERTY_PROJECTSTANDARDTASKLIST);
    }

    public void setProjectStandardTaskList(List<StandardTask> projectStandardTaskList) {
        set(PROPERTY_PROJECTSTANDARDTASKLIST, projectStandardTaskList);
    }

    @SuppressWarnings("unchecked")
    public List<ProjectTask> getProjectTaskList() {
      return (List<ProjectTask>) get(PROPERTY_PROJECTTASKLIST);
    }

    public void setProjectTaskList(List<ProjectTask> projectTaskList) {
        set(PROPERTY_PROJECTTASKLIST, projectTaskList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialReceiptPickEdit> getReturnMaterialReceiptPickEditList() {
      return (List<ReturnMaterialReceiptPickEdit>) get(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST);
    }

    public void setReturnMaterialReceiptPickEditList(List<ReturnMaterialReceiptPickEdit> returnMaterialReceiptPickEditList) {
        set(PROPERTY_RETURNMATERIALRECEIPTPICKEDITLIST, returnMaterialReceiptPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<ReturnMaterialShipmentPickEdit> getReturnMaterialShipmentPickEditList() {
      return (List<ReturnMaterialShipmentPickEdit>) get(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST);
    }

    public void setReturnMaterialShipmentPickEditList(List<ReturnMaterialShipmentPickEdit> returnMaterialShipmentPickEditList) {
        set(PROPERTY_RETURNMATERIALSHIPMENTPICKEDITLIST, returnMaterialShipmentPickEditList);
    }

    @SuppressWarnings("unchecked")
    public List<SIVAPhysicalInvtlines> getSIVAPhysicalInvtlinesList() {
      return (List<SIVAPhysicalInvtlines>) get(PROPERTY_SIVAPHYSICALINVTLINESLIST);
    }

    public void setSIVAPhysicalInvtlinesList(List<SIVAPhysicalInvtlines> sIVAPhysicalInvtlinesList) {
        set(PROPERTY_SIVAPHYSICALINVTLINESLIST, sIVAPhysicalInvtlinesList);
    }

    @SuppressWarnings("unchecked")
    public List<SOVSLdmProd> getSOVSLdmProdList() {
      return (List<SOVSLdmProd>) get(PROPERTY_SOVSLDMPRODLIST);
    }

    public void setSOVSLdmProdList(List<SOVSLdmProd> sOVSLdmProdList) {
        set(PROPERTY_SOVSLDMPRODLIST, sOVSLdmProdList);
    }

    @SuppressWarnings("unchecked")
    public List<SOVSLdmTemp> getSOVSLdmTempList() {
      return (List<SOVSLdmTemp>) get(PROPERTY_SOVSLDMTEMPLIST);
    }

    public void setSOVSLdmTempList(List<SOVSLdmTemp> sOVSLdmTempList) {
        set(PROPERTY_SOVSLDMTEMPLIST, sOVSLdmTempList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVProductCategory> getSPEVProductCategoryList() {
      return (List<SPEVProductCategory>) get(PROPERTY_SPEVPRODUCTCATEGORYLIST);
    }

    public void setSPEVProductCategoryList(List<SPEVProductCategory> sPEVProductCategoryList) {
        set(PROPERTY_SPEVPRODUCTCATEGORYLIST, sPEVProductCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<SSIP_Producttariffs> getSSIPProducttariffsList() {
      return (List<SSIP_Producttariffs>) get(PROPERTY_SSIPPRODUCTTARIFFSLIST);
    }

    public void setSSIPProducttariffsList(List<SSIP_Producttariffs> sSIPProducttariffsList) {
        set(PROPERTY_SSIPPRODUCTTARIFFSLIST, sSIPProducttariffsList);
    }

    @SuppressWarnings("unchecked")
    public List<RefundConfiguration> getSSRERefundConfigurationList() {
      return (List<RefundConfiguration>) get(PROPERTY_SSREREFUNDCONFIGURATIONLIST);
    }

    public void setSSRERefundConfigurationList(List<RefundConfiguration> sSRERefundConfigurationList) {
        set(PROPERTY_SSREREFUNDCONFIGURATIONLIST, sSRERefundConfigurationList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSaleLine> getSSWSWithholdingSaleLineList() {
      return (List<SSWSWithholdingSaleLine>) get(PROPERTY_SSWSWITHHOLDINGSALELINELIST);
    }

    public void setSSWSWithholdingSaleLineList(List<SSWSWithholdingSaleLine> sSWSWithholdingSaleLineList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELINELIST, sSWSWithholdingSaleLineList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingReversal> getSTXREVFinanciallAccountingList() {
      return (List<AccountingReversal>) get(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST);
    }

    public void setSTXREVFinanciallAccountingList(List<AccountingReversal> sTXREVFinanciallAccountingList) {
        set(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, sTXREVFinanciallAccountingList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSOCHomproduct> getSWSOCHomproductList() {
      return (List<SWSOCHomproduct>) get(PROPERTY_SWSOCHOMPRODUCTLIST);
    }

    public void setSWSOCHomproductList(List<SWSOCHomproduct> sWSOCHomproductList) {
        set(PROPERTY_SWSOCHOMPRODUCTLIST, sWSOCHomproductList);
    }

    @SuppressWarnings("unchecked")
    public List<Commission> getSalesCommissionList() {
      return (List<Commission>) get(PROPERTY_SALESCOMMISSIONLIST);
    }

    public void setSalesCommissionList(List<Commission> salesCommissionList) {
        set(PROPERTY_SALESCOMMISSIONLIST, salesCommissionList);
    }

    @SuppressWarnings("unchecked")
    public List<CommissionLine> getSalesCommissionLineList() {
      return (List<CommissionLine>) get(PROPERTY_SALESCOMMISSIONLINELIST);
    }

    public void setSalesCommissionLineList(List<CommissionLine> salesCommissionLineList) {
        set(PROPERTY_SALESCOMMISSIONLINELIST, salesCommissionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ServicePriceRuleVersion> getServicePriceRuleVersionList() {
      return (List<ServicePriceRuleVersion>) get(PROPERTY_SERVICEPRICERULEVERSIONLIST);
    }

    public void setServicePriceRuleVersionList(List<ServicePriceRuleVersion> servicePriceRuleVersionList) {
        set(PROPERTY_SERVICEPRICERULEVERSIONLIST, servicePriceRuleVersionList);
    }

    @SuppressWarnings("unchecked")
    public List<ServiceProduct> getServiceProductList() {
      return (List<ServiceProduct>) get(PROPERTY_SERVICEPRODUCTLIST);
    }

    public void setServiceProductList(List<ServiceProduct> serviceProductList) {
        set(PROPERTY_SERVICEPRODUCTLIST, serviceProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ServiceProduct> getServiceProductMRelatedProductIDList() {
      return (List<ServiceProduct>) get(PROPERTY_SERVICEPRODUCTMRELATEDPRODUCTIDLIST);
    }

    public void setServiceProductMRelatedProductIDList(List<ServiceProduct> serviceProductMRelatedProductIDList) {
        set(PROPERTY_SERVICEPRODUCTMRELATEDPRODUCTIDLIST, serviceProductMRelatedProductIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ServiceProductCategory> getServiceProductCategoryList() {
      return (List<ServiceProductCategory>) get(PROPERTY_SERVICEPRODUCTCATEGORYLIST);
    }

    public void setServiceProductCategoryList(List<ServiceProductCategory> serviceProductCategoryList) {
        set(PROPERTY_SERVICEPRODUCTCATEGORYLIST, serviceProductCategoryList);
    }

    @SuppressWarnings("unchecked")
    public List<SiblrPhysicalInvtLines> getSiblrPhysicalInvtLinesList() {
      return (List<SiblrPhysicalInvtLines>) get(PROPERTY_SIBLRPHYSICALINVTLINESLIST);
    }

    public void setSiblrPhysicalInvtLinesList(List<SiblrPhysicalInvtLines> siblrPhysicalInvtLinesList) {
        set(PROPERTY_SIBLRPHYSICALINVTLINESLIST, siblrPhysicalInvtLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<ssbodGCProduct> getSsbodGcProductList() {
      return (List<ssbodGCProduct>) get(PROPERTY_SSBODGCPRODUCTLIST);
    }

    public void setSsbodGcProductList(List<ssbodGCProduct> ssbodGcProductList) {
        set(PROPERTY_SSBODGCPRODUCTLIST, ssbodGcProductList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftOrder> getSsbodGiftOrderList() {
      return (List<SsbodGiftOrder>) get(PROPERTY_SSBODGIFTORDERLIST);
    }

    public void setSsbodGiftOrderList(List<SsbodGiftOrder> ssbodGiftOrderList) {
        set(PROPERTY_SSBODGIFTORDERLIST, ssbodGiftOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftTemp> getSsbodGiftTempList() {
      return (List<SsbodGiftTemp>) get(PROPERTY_SSBODGIFTTEMPLIST);
    }

    public void setSsbodGiftTempList(List<SsbodGiftTemp> ssbodGiftTempList) {
        set(PROPERTY_SSBODGIFTTEMPLIST, ssbodGiftTempList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmaactAccounting> getSsmaactAccountingList() {
      return (List<SsmaactAccounting>) get(PROPERTY_SSMAACTACCOUNTINGLIST);
    }

    public void setSsmaactAccountingList(List<SsmaactAccounting> ssmaactAccountingList) {
        set(PROPERTY_SSMAACTACCOUNTINGLIST, ssmaactAccountingList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmaactAudit> getSsmaactAuditList() {
      return (List<SsmaactAudit>) get(PROPERTY_SSMAACTAUDITLIST);
    }

    public void setSsmaactAuditList(List<SsmaactAudit> ssmaactAuditList) {
        set(PROPERTY_SSMAACTAUDITLIST, ssmaactAuditList);
    }

    @SuppressWarnings("unchecked")
    public List<esmpTerceroProducto> getTerceroProductoList() {
      return (List<esmpTerceroProducto>) get(PROPERTY_TERCEROPRODUCTOLIST);
    }

    public void setTerceroProductoList(List<esmpTerceroProducto> terceroProductoList) {
        set(PROPERTY_TERCEROPRODUCTOLIST, terceroProductoList);
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
    public List<TransactionLast> getTransactionLastList() {
      return (List<TransactionLast>) get(PROPERTY_TRANSACTIONLASTLIST);
    }

    public void setTransactionLastList(List<TransactionLast> transactionLastList) {
        set(PROPERTY_TRANSACTIONLASTLIST, transactionLastList);
    }

    @SuppressWarnings("unchecked")
    public List<MaterialTransactionV> getTransactionVList() {
      return (List<MaterialTransactionV>) get(PROPERTY_TRANSACTIONVLIST);
    }

    public void setTransactionVList(List<MaterialTransactionV> transactionVList) {
        set(PROPERTY_TRANSACTIONVLIST, transactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<ValuedStockAggregated> getValuedStockAggregatedList() {
      return (List<ValuedStockAggregated>) get(PROPERTY_VALUEDSTOCKAGGREGATEDLIST);
    }

    public void setValuedStockAggregatedList(List<ValuedStockAggregated> valuedStockAggregatedList) {
        set(PROPERTY_VALUEDSTOCKAGGREGATEDLIST, valuedStockAggregatedList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventalinea> getAtindpoPostventalineaList() {
      return (List<atindpo_postventalinea>) get(PROPERTY_ATINDPOPOSTVENTALINEALIST);
    }

    public void setAtindpoPostventalineaList(List<atindpo_postventalinea> atindpoPostventalineaList) {
        set(PROPERTY_ATINDPOPOSTVENTALINEALIST, atindpoPostventalineaList);
    }

    @SuppressWarnings("unchecked")
    public List<atvefFactor> getAtvefFactorList() {
      return (List<atvefFactor>) get(PROPERTY_ATVEFFACTORLIST);
    }

    public void setAtvefFactorList(List<atvefFactor> atvefFactorList) {
        set(PROPERTY_ATVEFFACTORLIST, atvefFactorList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_breakdown_line> getEcscbBreakdownLineList() {
      return (List<ecscb_breakdown_line>) get(PROPERTY_ECSCBBREAKDOWNLINELIST);
    }

    public void setEcscbBreakdownLineList(List<ecscb_breakdown_line> ecscbBreakdownLineList) {
        set(PROPERTY_ECSCBBREAKDOWNLINELIST, ecscbBreakdownLineList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_TypeBreakdownLine> getEcscbTypeBreakdownLineList() {
      return (List<ecscb_TypeBreakdownLine>) get(PROPERTY_ECSCBTYPEBREAKDOWNLINELIST);
    }

    public void setEcscbTypeBreakdownLineList(List<ecscb_TypeBreakdownLine> ecscbTypeBreakdownLineList) {
        set(PROPERTY_ECSCBTYPEBREAKDOWNLINELIST, ecscbTypeBreakdownLineList);
    }

    @SuppressWarnings("unchecked")
    public List<EeiPaymentDetailV> getEeiPaymentDetailVList() {
      return (List<EeiPaymentDetailV>) get(PROPERTY_EEIPAYMENTDETAILVLIST);
    }

    public void setEeiPaymentDetailVList(List<EeiPaymentDetailV> eeiPaymentDetailVList) {
        set(PROPERTY_EEIPAYMENTDETAILVLIST, eeiPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<EeiProduct> getEeiProductList() {
      return (List<EeiProduct>) get(PROPERTY_EEIPRODUCTLIST);
    }

    public void setEeiProductList(List<EeiProduct> eeiProductList) {
        set(PROPERTY_EEIPRODUCTLIST, eeiProductList);
    }

    @SuppressWarnings("unchecked")
    public List<Imdlv_Lines> getImdlvLinesList() {
      return (List<Imdlv_Lines>) get(PROPERTY_IMDLVLINESLIST);
    }

    public void setImdlvLinesList(List<Imdlv_Lines> imdlvLinesList) {
        set(PROPERTY_IMDLVLINESLIST, imdlvLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<imdlvHomologationProduct> getImdlvHomologationProductList() {
      return (List<imdlvHomologationProduct>) get(PROPERTY_IMDLVHOMOLOGATIONPRODUCTLIST);
    }

    public void setImdlvHomologationProductList(List<imdlvHomologationProduct> imdlvHomologationProductList) {
        set(PROPERTY_IMDLVHOMOLOGATIONPRODUCTLIST, imdlvHomologationProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceProductDefaultIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEPRODUCTDEFAULTIDLIST);
    }

    public void setImdlvPurchaseInvoiceProductDefaultIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceProductDefaultIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEPRODUCTDEFAULTIDLIST, imdlvPurchaseInvoiceProductDefaultIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvWthholdingline> getImdlvWithholdinglineList() {
      return (List<ImdlvWthholdingline>) get(PROPERTY_IMDLVWITHHOLDINGLINELIST);
    }

    public void setImdlvWithholdinglineList(List<ImdlvWthholdingline> imdlvWithholdinglineList) {
        set(PROPERTY_IMDLVWITHHOLDINGLINELIST, imdlvWithholdinglineList);
    }

    @SuppressWarnings("unchecked")
    public List<OpcrmProductviewV> getOpcrmProductviewVList() {
      return (List<OpcrmProductviewV>) get(PROPERTY_OPCRMPRODUCTVIEWVLIST);
    }

    public void setOpcrmProductviewVList(List<OpcrmProductviewV> opcrmProductviewVList) {
        set(PROPERTY_OPCRMPRODUCTVIEWVLIST, opcrmProductviewVList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfForecastByMonth> getScmfForecastbymonthList() {
      return (List<ScmfForecastByMonth>) get(PROPERTY_SCMFFORECASTBYMONTHLIST);
    }

    public void setScmfForecastbymonthList(List<ScmfForecastByMonth> scmfForecastbymonthList) {
        set(PROPERTY_SCMFFORECASTBYMONTHLIST, scmfForecastbymonthList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfPendingOrdersTmp> getScmfPendingordersTmpList() {
      return (List<ScmfPendingOrdersTmp>) get(PROPERTY_SCMFPENDINGORDERSTMPLIST);
    }

    public void setScmfPendingordersTmpList(List<ScmfPendingOrdersTmp> scmfPendingordersTmpList) {
        set(PROPERTY_SCMFPENDINGORDERSTMPLIST, scmfPendingordersTmpList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfProcessProduction> getScmfProcessProductionList() {
      return (List<ScmfProcessProduction>) get(PROPERTY_SCMFPROCESSPRODUCTIONLIST);
    }

    public void setScmfProcessProductionList(List<ScmfProcessProduction> scmfProcessProductionList) {
        set(PROPERTY_SCMFPROCESSPRODUCTIONLIST, scmfProcessProductionList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfProduct> getScmfProductList() {
      return (List<ScmfProduct>) get(PROPERTY_SCMFPRODUCTLIST);
    }

    public void setScmfProductList(List<ScmfProduct> scmfProductList) {
        set(PROPERTY_SCMFPRODUCTLIST, scmfProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfRegressionLineCalc> getScmfRegressionlineCalcList() {
      return (List<ScmfRegressionLineCalc>) get(PROPERTY_SCMFREGRESSIONLINECALCLIST);
    }

    public void setScmfRegressionlineCalcList(List<ScmfRegressionLineCalc> scmfRegressionlineCalcList) {
        set(PROPERTY_SCMFREGRESSIONLINECALCLIST, scmfRegressionlineCalcList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfTransaction> getScmfTransactionList() {
      return (List<ScmfTransaction>) get(PROPERTY_SCMFTRANSACTIONLIST);
    }

    public void setScmfTransactionList(List<ScmfTransaction> scmfTransactionList) {
        set(PROPERTY_SCMFTRANSACTIONLIST, scmfTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfTransactionBalance> getScmfTransactionBalanceList() {
      return (List<ScmfTransactionBalance>) get(PROPERTY_SCMFTRANSACTIONBALANCELIST);
    }

    public void setScmfTransactionBalanceList(List<ScmfTransactionBalance> scmfTransactionBalanceList) {
        set(PROPERTY_SCMFTRANSACTIONBALANCELIST, scmfTransactionBalanceList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfTransactionV> getScmfTransactionVList() {
      return (List<ScmfTransactionV>) get(PROPERTY_SCMFTRANSACTIONVLIST);
    }

    public void setScmfTransactionVList(List<ScmfTransactionV> scmfTransactionVList) {
        set(PROPERTY_SCMFTRANSACTIONVLIST, scmfTransactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfTransactionBydate> getScmfTransactionbydateList() {
      return (List<ScmfTransactionBydate>) get(PROPERTY_SCMFTRANSACTIONBYDATELIST);
    }

    public void setScmfTransactionbydateList(List<ScmfTransactionBydate> scmfTransactionbydateList) {
        set(PROPERTY_SCMFTRANSACTIONBYDATELIST, scmfTransactionbydateList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfTransbydateV> getScmfTransbydateVList() {
      return (List<ScmfTransbydateV>) get(PROPERTY_SCMFTRANSBYDATEVLIST);
    }

    public void setScmfTransbydateVList(List<ScmfTransbydateV> scmfTransbydateVList) {
        set(PROPERTY_SCMFTRANSBYDATEVLIST, scmfTransbydateVList);
    }

    @SuppressWarnings("unchecked")
    public List<Sfpsi_ReconcileSalesOrderV> getSfpsiReconcileSoVList() {
      return (List<Sfpsi_ReconcileSalesOrderV>) get(PROPERTY_SFPSIRECONCILESOVLIST);
    }

    public void setSfpsiReconcileSoVList(List<Sfpsi_ReconcileSalesOrderV> sfpsiReconcileSoVList) {
        set(PROPERTY_SFPSIRECONCILESOVLIST, sfpsiReconcileSoVList);
    }

    @SuppressWarnings("unchecked")
    public List<Simpsim_ImpSimCost> getSimpsimImpSimCostList() {
      return (List<Simpsim_ImpSimCost>) get(PROPERTY_SIMPSIMIMPSIMCOSTLIST);
    }

    public void setSimpsimImpSimCostList(List<Simpsim_ImpSimCost> simpsimImpSimCostList) {
        set(PROPERTY_SIMPSIMIMPSIMCOSTLIST, simpsimImpSimCostList);
    }

    @SuppressWarnings("unchecked")
    public List<Simpsim_ImpSimLine> getSimpsimImpSimLineList() {
      return (List<Simpsim_ImpSimLine>) get(PROPERTY_SIMPSIMIMPSIMLINELIST);
    }

    public void setSimpsimImpSimLineList(List<Simpsim_ImpSimLine> simpsimImpSimLineList) {
        set(PROPERTY_SIMPSIMIMPSIMLINELIST, simpsimImpSimLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Sinvmin_SquareBill> getSinvminSquareBillList() {
      return (List<Sinvmin_SquareBill>) get(PROPERTY_SINVMINSQUAREBILLLIST);
    }

    public void setSinvminSquareBillList(List<Sinvmin_SquareBill> sinvminSquareBillList) {
        set(PROPERTY_SINVMINSQUAREBILLLIST, sinvminSquareBillList);
    }

    @SuppressWarnings("unchecked")
    public List<SlqsMProductStockView> getSlqsMProductStockVList() {
      return (List<SlqsMProductStockView>) get(PROPERTY_SLQSMPRODUCTSTOCKVLIST);
    }

    public void setSlqsMProductStockVList(List<SlqsMProductStockView> slqsMProductStockVList) {
        set(PROPERTY_SLQSMPRODUCTSTOCKVLIST, slqsMProductStockVList);
    }

    @SuppressWarnings("unchecked")
    public List<SlqsProductSafetyInProcessView> getSlqsPrdSafetyVList() {
      return (List<SlqsProductSafetyInProcessView>) get(PROPERTY_SLQSPRDSAFETYVLIST);
    }

    public void setSlqsPrdSafetyVList(List<SlqsProductSafetyInProcessView> slqsPrdSafetyVList) {
        set(PROPERTY_SLQSPRDSAFETYVLIST, slqsPrdSafetyVList);
    }

    @SuppressWarnings("unchecked")
    public List<spatmp_reference_transfer> getSpatmpReferenceTransferList() {
      return (List<spatmp_reference_transfer>) get(PROPERTY_SPATMPREFERENCETRANSFERLIST);
    }

    public void setSpatmpReferenceTransferList(List<spatmp_reference_transfer> spatmpReferenceTransferList) {
        set(PROPERTY_SPATMPREFERENCETRANSFERLIST, spatmpReferenceTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<spatmp_transfer> getSpatmpTransferCodeList() {
      return (List<spatmp_transfer>) get(PROPERTY_SPATMPTRANSFERCODELIST);
    }

    public void setSpatmpTransferCodeList(List<spatmp_transfer> spatmpTransferCodeList) {
        set(PROPERTY_SPATMPTRANSFERCODELIST, spatmpTransferCodeList);
    }

    @SuppressWarnings("unchecked")
    public List<spatmp_transfer> getSpatmpTransferList() {
      return (List<spatmp_transfer>) get(PROPERTY_SPATMPTRANSFERLIST);
    }

    public void setSpatmpTransferList(List<spatmp_transfer> spatmpTransferList) {
        set(PROPERTY_SPATMPTRANSFERLIST, spatmpTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmInventorySettl> getSproctmInventorySettlList() {
      return (List<SproctmInventorySettl>) get(PROPERTY_SPROCTMINVENTORYSETTLLIST);
    }

    public void setSproctmInventorySettlList(List<SproctmInventorySettl> sproctmInventorySettlList) {
        set(PROPERTY_SPROCTMINVENTORYSETTLLIST, sproctmInventorySettlList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmTaskProd> getSproctmTaskProdList() {
      return (List<SproctmTaskProd>) get(PROPERTY_SPROCTMTASKPRODLIST);
    }

    public void setSproctmTaskProdList(List<SproctmTaskProd> sproctmTaskProdList) {
        set(PROPERTY_SPROCTMTASKPRODLIST, sproctmTaskProdList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalActiveMain> getSsalActiveMainList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINLIST);
    }

    public void setSsalActiveMainList(List<SsalActiveMain> ssalActiveMainList) {
        set(PROPERTY_SSALACTIVEMAINLIST, ssalActiveMainList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalAssetReturn> getSsalAssetReturnList() {
      return (List<SsalAssetReturn>) get(PROPERTY_SSALASSETRETURNLIST);
    }

    public void setSsalAssetReturnList(List<SsalAssetReturn> ssalAssetReturnList) {
        set(PROPERTY_SSALASSETRETURNLIST, ssalAssetReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssapq_AppParamMovil> getSsapqAppParamMovilList() {
      return (List<Ssapq_AppParamMovil>) get(PROPERTY_SSAPQAPPPARAMMOVILLIST);
    }

    public void setSsapqAppParamMovilList(List<Ssapq_AppParamMovil> ssapqAppParamMovilList) {
        set(PROPERTY_SSAPQAPPPARAMMOVILLIST, ssapqAppParamMovilList);
    }

    @SuppressWarnings("unchecked")
    public List<SsbodGiftInvoice> getSsbodGiftInvoiceList() {
      return (List<SsbodGiftInvoice>) get(PROPERTY_SSBODGIFTINVOICELIST);
    }

    public void setSsbodGiftInvoiceList(List<SsbodGiftInvoice> ssbodGiftInvoiceList) {
        set(PROPERTY_SSBODGIFTINVOICELIST, ssbodGiftInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SscflwExpensivePayoutView> getSscflwExpensivePayoutVList() {
      return (List<SscflwExpensivePayoutView>) get(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST);
    }

    public void setSscflwExpensivePayoutVList(List<SscflwExpensivePayoutView> sscflwExpensivePayoutVList) {
        set(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, sscflwExpensivePayoutVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdccpDistributeCostCenter> getSsdccpDistcostcenterList() {
      return (List<SsdccpDistributeCostCenter>) get(PROPERTY_SSDCCPDISTCOSTCENTERLIST);
    }

    public void setSsdccpDistcostcenterList(List<SsdccpDistributeCostCenter> ssdccpDistcostcenterList) {
        set(PROPERTY_SSDCCPDISTCOSTCENTERLIST, ssdccpDistcostcenterList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidProduct> getSsdnidProductList() {
      return (List<SsdnidProduct>) get(PROPERTY_SSDNIDPRODUCTLIST);
    }

    public void setSsdnidProductList(List<SsdnidProduct> ssdnidProductList) {
        set(PROPERTY_SSDNIDPRODUCTLIST, ssdnidProductList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfiFin_payment_detail_v> getSsfiFinPaymentDetailVList() {
      return (List<ssfiFin_payment_detail_v>) get(PROPERTY_SSFIFINPAYMENTDETAILVLIST);
    }

    public void setSsfiFinPaymentDetailVList(List<ssfiFin_payment_detail_v> ssfiFinPaymentDetailVList) {
        set(PROPERTY_SSFIFINPAYMENTDETAILVLIST, ssfiFinPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_Accumulated> getSsipotmAccumulatedList() {
      return (List<Ssipotm_Accumulated>) get(PROPERTY_SSIPOTMACCUMULATEDLIST);
    }

    public void setSsipotmAccumulatedList(List<Ssipotm_Accumulated> ssipotmAccumulatedList) {
        set(PROPERTY_SSIPOTMACCUMULATEDLIST, ssipotmAccumulatedList);
    }

    @SuppressWarnings("unchecked")
    public List<SsipotmAttributeProduct> getSsipotmAttributeProductList() {
      return (List<SsipotmAttributeProduct>) get(PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST);
    }

    public void setSsipotmAttributeProductList(List<SsipotmAttributeProduct> ssipotmAttributeProductList) {
        set(PROPERTY_SSIPOTMATTRIBUTEPRODUCTLIST, ssipotmAttributeProductList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_OrderLine> getSsipotmOrderlineList() {
      return (List<Ssipotm_OrderLine>) get(PROPERTY_SSIPOTMORDERLINELIST);
    }

    public void setSsipotmOrderlineList(List<Ssipotm_OrderLine> ssipotmOrderlineList) {
        set(PROPERTY_SSIPOTMORDERLINELIST, ssipotmOrderlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpForecastLog> getSsmrpForecastLogList() {
      return (List<SsmrpForecastLog>) get(PROPERTY_SSMRPFORECASTLOGLIST);
    }

    public void setSsmrpForecastLogList(List<SsmrpForecastLog> ssmrpForecastLogList) {
        set(PROPERTY_SSMRPFORECASTLOGLIST, ssmrpForecastLogList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpSalesForecast> getSsmrpSalesForecastList() {
      return (List<SsmrpSalesForecast>) get(PROPERTY_SSMRPSALESFORECASTLIST);
    }

    public void setSsmrpSalesForecastList(List<SsmrpSalesForecast> ssmrpSalesForecastList) {
        set(PROPERTY_SSMRPSALESFORECASTLIST, ssmrpSalesForecastList);
    }

    @SuppressWarnings("unchecked")
    public List<ssmrps_asim_lines> getSsmrpsAsimLinesProductidList() {
      return (List<ssmrps_asim_lines>) get(PROPERTY_SSMRPSASIMLINESPRODUCTIDLIST);
    }

    public void setSsmrpsAsimLinesProductidList(List<ssmrps_asim_lines> ssmrpsAsimLinesProductidList) {
        set(PROPERTY_SSMRPSASIMLINESPRODUCTIDLIST, ssmrpsAsimLinesProductidList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpsLinesTmp> getSsmrpsLinesTmpProductidList() {
      return (List<SsmrpsLinesTmp>) get(PROPERTY_SSMRPSLINESTMPPRODUCTIDLIST);
    }

    public void setSsmrpsLinesTmpProductidList(List<SsmrpsLinesTmp> ssmrpsLinesTmpProductidList) {
        set(PROPERTY_SSMRPSLINESTMPPRODUCTIDLIST, ssmrpsLinesTmpProductidList);
    }

    @SuppressWarnings("unchecked")
    public List<SsprodProductLotView> getSsprodProductLotVList() {
      return (List<SsprodProductLotView>) get(PROPERTY_SSPRODPRODUCTLOTVLIST);
    }

    public void setSsprodProductLotVList(List<SsprodProductLotView> ssprodProductLotVList) {
        set(PROPERTY_SSPRODPRODUCTLOTVLIST, ssprodProductLotVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssrerefundinvoice> getSsreRefundinvoiceEMImdlvProductIDList() {
      return (List<ssrerefundinvoice>) get(PROPERTY_SSREREFUNDINVOICEEMIMDLVPRODUCTIDLIST);
    }

    public void setSsreRefundinvoiceEMImdlvProductIDList(List<ssrerefundinvoice> ssreRefundinvoiceEMImdlvProductIDList) {
        set(PROPERTY_SSREREFUNDINVOICEEMIMDLVPRODUCTIDLIST, ssreRefundinvoiceEMImdlvProductIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssre_RefundInvoiceLine> getSsreRefundinvoicelineList() {
      return (List<Ssre_RefundInvoiceLine>) get(PROPERTY_SSREREFUNDINVOICELINELIST);
    }

    public void setSsreRefundinvoicelineList(List<Ssre_RefundInvoiceLine> ssreRefundinvoicelineList) {
        set(PROPERTY_SSREREFUNDINVOICELINELIST, ssreRefundinvoicelineList);
    }

    @SuppressWarnings("unchecked")
    public List<ssrsresupplyline> getSsrsResupplylineList() {
      return (List<ssrsresupplyline>) get(PROPERTY_SSRSRESUPPLYLINELIST);
    }

    public void setSsrsResupplylineList(List<ssrsresupplyline> ssrsResupplylineList) {
        set(PROPERTY_SSRSRESUPPLYLINELIST, ssrsResupplylineList);
    }

    @SuppressWarnings("unchecked")
    public List<ConsumptionLine> getSstpcConsumptionLineList() {
      return (List<ConsumptionLine>) get(PROPERTY_SSTPCCONSUMPTIONLINELIST);
    }

    public void setSstpcConsumptionLineList(List<ConsumptionLine> sstpcConsumptionLineList) {
        set(PROPERTY_SSTPCCONSUMPTIONLINELIST, sstpcConsumptionLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcLiquidationProjectsInvoiceView> getSstpcLiqPrjInvVList() {
      return (List<SstpcLiquidationProjectsInvoiceView>) get(PROPERTY_SSTPCLIQPRJINVVLIST);
    }

    public void setSstpcLiqPrjInvVList(List<SstpcLiquidationProjectsInvoiceView> sstpcLiqPrjInvVList) {
        set(PROPERTY_SSTPCLIQPRJINVVLIST, sstpcLiqPrjInvVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcMatConProjView> getSstpcMatConProjVList() {
      return (List<SstpcMatConProjView>) get(PROPERTY_SSTPCMATCONPROJVLIST);
    }

    public void setSstpcMatConProjVList(List<SstpcMatConProjView> sstpcMatConProjVList) {
        set(PROPERTY_SSTPCMATCONPROJVLIST, sstpcMatConProjVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcMatProjVoidView> getSstpcMatProjVoidVList() {
      return (List<SstpcMatProjVoidView>) get(PROPERTY_SSTPCMATPROJVOIDVLIST);
    }

    public void setSstpcMatProjVoidVList(List<SstpcMatProjVoidView> sstpcMatProjVoidVList) {
        set(PROPERTY_SSTPCMATPROJVOIDVLIST, sstpcMatProjVoidVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcMovementProductView> getSstpcMovProdVList() {
      return (List<SstpcMovementProductView>) get(PROPERTY_SSTPCMOVPRODVLIST);
    }

    public void setSstpcMovProdVList(List<SstpcMovementProductView> sstpcMovProdVList) {
        set(PROPERTY_SSTPCMOVPRODVLIST, sstpcMovProdVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcConsumptionView> getSstpcPreliqVList() {
      return (List<SstpcConsumptionView>) get(PROPERTY_SSTPCPRELIQVLIST);
    }

    public void setSstpcPreliqVList(List<SstpcConsumptionView> sstpcPreliqVList) {
        set(PROPERTY_SSTPCPRELIQVLIST, sstpcPreliqVList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcRelatedCosts> getSstpcRelatedCostsList() {
      return (List<SstpcRelatedCosts>) get(PROPERTY_SSTPCRELATEDCOSTSLIST);
    }

    public void setSstpcRelatedCostsList(List<SstpcRelatedCosts> sstpcRelatedCostsList) {
        set(PROPERTY_SSTPCRELATEDCOSTSLIST, sstpcRelatedCostsList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrderLine> getSswclWorkOrderlineVList() {
      return (List<SSWCLWorkOrderLine>) get(PROPERTY_SSWCLWORKORDERLINEVLIST);
    }

    public void setSswclWorkOrderlineVList(List<SSWCLWorkOrderLine> sswclWorkOrderlineVList) {
        set(PROPERTY_SSWCLWORKORDERLINEVLIST, sswclWorkOrderlineVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsxmlDataXmlIbp> getSsxmlDataXmlIbpList() {
      return (List<SsxmlDataXmlIbp>) get(PROPERTY_SSXMLDATAXMLIBPLIST);
    }

    public void setSsxmlDataXmlIbpList(List<SsxmlDataXmlIbp> ssxmlDataXmlIbpList) {
        set(PROPERTY_SSXMLDATAXMLIBPLIST, ssxmlDataXmlIbpList);
    }

    @SuppressWarnings("unchecked")
    public List<SwhpProductStockDetailV> getSwhpProductStockDetailVList() {
      return (List<SwhpProductStockDetailV>) get(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST);
    }

    public void setSwhpProductStockDetailVList(List<SwhpProductStockDetailV> swhpProductStockDetailVList) {
        set(PROPERTY_SWHPPRODUCTSTOCKDETAILVLIST, swhpProductStockDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SwhpWhProduct> getSwhpWhProductList() {
      return (List<SwhpWhProduct>) get(PROPERTY_SWHPWHPRODUCTLIST);
    }

    public void setSwhpWhProductList(List<SwhpWhProduct> swhpWhProductList) {
        set(PROPERTY_SWHPWHPRODUCTLIST, swhpWhProductList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSPCConfig> getSwspcConfigList() {
      return (List<SWSPCConfig>) get(PROPERTY_SWSPCCONFIGLIST);
    }

    public void setSwspcConfigList(List<SWSPCConfig> swspcConfigList) {
        set(PROPERTY_SWSPCCONFIGLIST, swspcConfigList);
    }

}
