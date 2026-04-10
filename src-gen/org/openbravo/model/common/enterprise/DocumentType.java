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
package org.openbravo.model.common.enterprise;

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import com.sidesoft.ecuador.asset.allocation.SsalActiveMain;
import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.SsalAssetReturn;
import com.sidesoft.ecuador.asset.changetranslation.SeactAssetSetup;
import com.sidesoft.ecuador.asset.move.ssamalienate;
import com.sidesoft.hrm.payroll.Payroll;
import com.sidesoft.hrm.payroll.Sspr_OtherTaxIncome;
import com.sidesoft.hrm.payroll.advanced.SfprMovementType;
import com.sidesoft.hrm.payroll.early.payment.SPEPAdvancePayment;
import com.sidesoft.hrm.payroll.sspr_settlement;
import com.sidesoft.hrm.payroll.sspremployeesettlement;
import com.sidesoft.hrm.payroll.ssprleaveemp;
import com.sidesoft.hrm.payroll.ssprloans;
import com.sidesoft.hrm.payroll.ssprpayrollpayment;
import com.sidesoft.hrm.payroll.tenth.SSPHTenthSettlement;
import com.sidesoft.localization.ecuador.finances.SsfiFinancialUser;
import com.sidesoft.localization.ecuador.withholdings.Authorization;
import com.sidesoft.localization.ecuador.withholdings.CsspidSalesTickets;
import com.sidesoft.localization.ecuador.withholdings.Receipt;
import com.sidesoft.localization.ecuador.withholdings.SSWHPos;
import com.sidesoft.localization.ecuador.withholdings.SswhWithhCardCredit;
import com.sidesoft.localization.ecuador.withholdings.SswhWithholdingsVoided;
import com.sidesoft.localization.ecuador.withholdings.sswhtypereceipt;

import ec.com.sidesoft.aftersale.machinery.Satmac_Contract;
import ec.com.sidesoft.aftersale.machinery.satmac_SOTransferLine;
import ec.com.sidesoft.app.production.quality.Ssapq_AppParamMovil;
import ec.com.sidesoft.asset.transfer.SsatrAssetTransfer;
import ec.com.sidesoft.assets.changes.SSACHModifyAsset;
import ec.com.sidesoft.backoffice.discount.SssbodOfferDoc;
import ec.com.sidesoft.balance.performance.SbprfFactAcctAggdDoc;
import ec.com.sidesoft.carnidem.breakdown.ecscb_TypeBreakdown;
import ec.com.sidesoft.carnidem.breakdown.ecscb_breakdown;
import ec.com.sidesoft.carnidem.production.quality.crprqy_paramsSafetyQly;
import ec.com.sidesoft.cash.flow.SscflwExpensivePayoutView;
import ec.com.sidesoft.closecash.indumot.SscccinInvoiceDoctype;
import ec.com.sidesoft.closecash.sales.order.SsccsoCashIncExp;
import ec.com.sidesoft.closecash.sales.order.SsccsoTypeOfDocument;
import ec.com.sidesoft.contract.ssctcontract;
import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRec;
import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadTransaction;
import ec.com.sidesoft.custom.advpaymentmngt.Ecscap_GeneralProcess;
import ec.com.sidesoft.custom.closecash.ScccSetup;
import ec.com.sidesoft.custom.mrp.forecast.ScmfSeasonProduct;
import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTS;
import ec.com.sidesoft.custom.payroll.reports.sscprreportcertificate;
import ec.com.sidesoft.custom.reports.SescrTemplateReport;
import ec.com.sidesoft.custom.signature.SCSDCSignaturesperdoc;
import ec.com.sidesoft.daily.closing.charge.SdccDailyClossing;
import ec.com.sidesoft.debit.collection.SdcDebitcollect;
import ec.com.sidesoft.debitnote.interest.due.SsdnidPayment;
import ec.com.sidesoft.discount.quota.salesinvoices.QuotaDetail;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaCustodian;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaInventoryTaking;
import ec.com.sidesoft.financialaccount.document.type.sfadt_acc_sequences;
import ec.com.sidesoft.importdata.payments.Simppys_PaymentDataUpload;
import ec.com.sidesoft.importdata.payments.Simppys_PaymentDetail;
import ec.com.sidesoft.imports.consolidation.Ssimpcn_ImpConsolDetail;
import ec.com.sidesoft.imports.consolidation.Ssimpcn_ImpConsolidation;
import ec.com.sidesoft.imports.consolidation.Ssimpcn_ImportationCost;
import ec.com.sidesoft.imports.ice.SsipiceRateIce;
import ec.com.sidesoft.imports.pricelist.ImportProductPl;
import ec.com.sidesoft.imports.simulation.Simpsim_ImportSimulation;
import ec.com.sidesoft.inventory.adjustment.SIVAPhysicalInventory;
import ec.com.sidesoft.inventory.blind.register.SiblrPhysicalInventory;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_Config;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_PartialDispatch;
import ec.com.sidesoft.localization.adjustment.inventory.pdv.SsipdvDocumentType;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSConfig;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SswsAdvancePayment;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPurchaseIinvoice;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvPurchaseimpData;
import ec.com.sidesoft.localization.importdata.loadvouchers.ImdlvVoucherData;
import ec.com.sidesoft.localization.inventoryaccounting.SliaInventoryParamsLine;
import ec.com.sidesoft.modify.accounting.SsmaactAccounting;
import ec.com.sidesoft.modify.accounting.SsmaactAudit;
import ec.com.sidesoft.mrp.simulation.SsmrpsAsimulationProd;
import ec.com.sidesoft.payroll.events.SPEVRegisterNews;
import ec.com.sidesoft.payroll.overtime.SprovPeriod;
import ec.com.sidesoft.payroll.overtime.sprovovertime;
import ec.com.sidesoft.pending.purchase.invoice.SsppinvSetting;
import ec.com.sidesoft.postdated.check.SspchPaymentPlan;
import ec.com.sidesoft.postdated.check.SspchPostdatedChecks;
import ec.com.sidesoft.projects.complement.SproctmSettlementCost;
import ec.com.sidesoft.report.salesinvoice.SRSISalesInvoiceV;
import ec.com.sidesoft.saleorder.relations.ssorel_invoiceorder_v;
import ec.com.sidesoft.sales.order.indumot.SssoinDatesalesprocessV;
import ec.com.sidesoft.sales.order.pos.SsoposPosSoConf;
import ec.com.sidesoft.sales.order.validation.SssovlConfiglines;
import ec.com.sidesoft.settlement.project.cost.LiquidationProjects;
import ec.com.sidesoft.settlement.project.cost.SstpcConsumptionView;
import ec.com.sidesoft.settlement.project.cost.SstpcLiquidationProjectsInvoiceView;
import ec.com.sidesoft.settlement.project.cost.SstpcMatConProjView;
import ec.com.sidesoft.settlement.project.cost.SstpcMatProjVoidView;
import ec.com.sidesoft.settlement.project.cost.SstpcPaymentLiqView;
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedCosts;
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedRevenue;
import ec.com.sidesoft.transaction.reversal.AccountingReversal;
import ec.com.sidesoft.transfer.authorization.StatUserDoc;
import ec.com.sidesoft.web.services.log.swblConfig;
import ec.com.sidesoft.workorder.consult.SSWCLWorkOrder;
import ec.com.sidesoft.workorder.simplified.SswosSOTransfer;
import ec.com.sidesoft.workorder.update.price.UpdatePriceWO;
import ec.com.sidesoft.ws.ordercreate.data.SWSOCConfig;
import ec.com.sidesoft.ws.paymentscreate.SWSPCConfig;

import it.openia.crm.Opcrmcase;
import it.openia.crm.Opcrmopportunities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Reconciliation_v;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceV2;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.assetmgmt.Amortization;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.payment.DPManagement;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatement;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentProposal;
import org.openbravo.model.financialmgmt.payment.FIN_Reconciliation;
import org.openbravo.model.financialmgmt.payment.Settlement;
import org.openbravo.model.financialmgmt.tax.TaxRegisterTypeLines;
import org.openbravo.model.manufacturing.quality.Case;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.manufacturing.transaction.WorkRequirement;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.CostAdjustment;
import org.openbravo.model.materialmgmt.cost.InventoryAmountUpdate;
import org.openbravo.model.materialmgmt.cost.LandedCost;
import org.openbravo.model.materialmgmt.cost.LandedCostCost;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pos.ExternalPOS;
import org.openbravo.model.project.Project;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.retail.posterminal.TerminalType;
import org.openbravo.retail.posterminal.TerminalTypePaymentMethod;
/**
 * Entity class for entity DocumentType (stored in table C_DocType).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class DocumentType extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_DocType";
    public static final String ENTITY_NAME = "DocumentType";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_PRINTTEXT = "printText";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_DOCUMENTCATEGORY = "documentCategory";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_SOSUBTYPE = "sOSubType";
    public static final String PROPERTY_DOCUMENTTYPEFORSHIPMENT = "documentTypeForShipment";
    public static final String PROPERTY_DOCUMENTTYPEFORINVOICE = "documentTypeForInvoice";
    public static final String PROPERTY_SEQUENCEDDOCUMENT = "sequencedDocument";
    public static final String PROPERTY_DOCUMENTSEQUENCE = "documentSequence";
    public static final String PROPERTY_GLCATEGORY = "gLCategory";
    public static final String PROPERTY_COMMENTS = "comments";
    public static final String PROPERTY_DEFAULT = "default";
    public static final String PROPERTY_NUMBEROFCOPIES = "numberOfCopies";
    public static final String PROPERTY_TABLE = "table";
    public static final String PROPERTY_FILTERBYORGANIZATION = "filterByOrganization";
    public static final String PROPERTY_DOCUMENTCANCELLED = "documentCancelled";
    public static final String PROPERTY_EXPENSE = "expense";
    public static final String PROPERTY_REVERSAL = "reversal";
    public static final String PROPERTY_RETURN = "return";
    public static final String PROPERTY_DOCUMENTTYPEFORORDER = "documentTypeForOrder";
    public static final String PROPERTY_SSWHIMPLEMENTAUTORIZA = "sswhImplementautoriza";
    public static final String PROPERTY_SSWHISWITHHOLDING = "sswhIswithholding";
    public static final String PROPERTY_SSWHISCLIENT = "sswhIsclient";
    public static final String PROPERTY_SSWHISWITHHOLDINGSALE = "sswhIswithholdingsale";
    public static final String PROPERTY_SSRSDEFAULT = "ssrsDefault";
    public static final String PROPERTY_SSWHTYPERECEIPT = "sswhTypereceipt";
    public static final String PROPERTY_SSWHDOCTYPE = "sswhDoctype";
    public static final String PROPERTY_SSWHAFECTEDZONE = "sswhAfectedZone";
    public static final String PROPERTY_SSIPISIMPORTS = "ssipIsimports";
    public static final String PROPERTY_SSWHCODE = "sswhCode";
    public static final String PROPERTY_SSWHPERCENTAGE = "sSWHPercentage";
    public static final String PROPERTY_EEIEDOCTYPE = "eeiEdocType";
    public static final String PROPERTY_EEIISEDOC = "eeiIsEdoc";
    public static final String PROPERTY_EEIREMISSIONFORSALES = "eeiRemissionForSales";
    public static final String PROPERTY_SSWHEXTWITHH = "sswhExtWithh";
    public static final String PROPERTY_SSFIISCROSSING = "ssfiIscrossing";
    public static final String PROPERTY_SSWHWITHHCODE = "sswhWithhCode";
    public static final String PROPERTY_SDINAPPLYDINARDAP = "sdinApplydinardap";
    public static final String PROPERTY_STATTRANSAUTHORIZATION = "statTransAuthorization";
    public static final String PROPERTY_EEIKEYACCESSGENERATED = "eeiKeyAccessGenerated";
    public static final String PROPERTY_SIBLRTYPEINVENTORY = "siblrTypeInventory";
    public static final String PROPERTY_SCRTLACONTROLASSETS = "scrtlaControlAssets";
    public static final String PROPERTY_EEIDESCRIPTIONFIELDS = "eeiDescriptionfields";
    public static final String PROPERTY_EEIISREFUND = "eeiIsrefund";
    public static final String PROPERTY_SSWOSSERVICEORDER = "sswosServiceorder";
    public static final String PROPERTY_EEIREFUNDCODE = "eeiRefundCode";
    public static final String PROPERTY_SSACISASSETPURCHASE = "ssacIsassetpurchase";
    public static final String PROPERTY_SSDNIDINTERESTDEBITNOTE = "ssdnidInterestdebitnote";
    public static final String PROPERTY_SPDNSEQUENCE = "spdnSequence";
    public static final String PROPERTY_SSIMPCNCONSOLIDATEDIMP = "ssimpcnConsolidatedImp";
    public static final String PROPERTY_SSORRESINVOICERULE = "ssorresInvoiceRule";
    public static final String PROPERTY_SATHNCAUTHREQUIRED = "sathncAuthRequired";
    public static final String PROPERTY_EEICOMERCIALINV = "eeiComercialInv";
    public static final String PROPERTY_SSDNIDINTERESTDEBITNOTEDOC = "ssdnidInterestdebitnotedoc";
    public static final String PROPERTY_SCNSAAUTOMATICGENERATENC = "scnsaAutomaticGenerateNc";
    public static final String PROPERTY_SSDNIDCDOCTYPE = "ssdnidCDoctype";
    public static final String PROPERTY_EEINOREFERENCEINVOICE = "eeiNoReferenceInvoice";
    public static final String PROPERTY_SCNSADESCRIPTION = "scnsaDescription";
    public static final String PROPERTY_SSWHDIVIDENDS = "sswhDividends";
    public static final String PROPERTY_SCNSADOCNCAUTOMATIC = "scnsaDocNcAutomatic";
    public static final String PROPERTY_SSFCCOSTCENTER = "ssfcCostcenter";
    public static final String PROPERTY_SSSOVLINVOICERULE = "sssovlInvoicerule";
    public static final String PROPERTY_APRMRECONCILIATIONLIST = "aPRMReconciliationList";
    public static final String PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST = "businessPartnerEMOpcrmDoctypeIDList";
    public static final String PROPERTY_COSTADJUSTMENTLIST = "costAdjustmentList";
    public static final String PROPERTY_DOCUMENTTEMPLATELIST = "documentTemplateList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST = "documentTypeDocumentTypeForShipmentList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST = "documentTypeDocumentTypeForInvoiceList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST = "documentTypeDocumentCancelledList";
    public static final String PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST = "documentTypeDocumentTypeForOrderList";
    public static final String PROPERTY_DOCUMENTTYPEEMSSDNIDCDOCTYPEIDLIST = "documentTypeEMSsdnidCDoctypeIDList";
    public static final String PROPERTY_DOCUMENTTYPEEMSCNSADOCNCAUTOMATICLIST = "documentTypeEMScnsaDocNcAutomaticList";
    public static final String PROPERTY_DOCUMENTTYPETRLLIST = "documentTypeTrlList";
    public static final String PROPERTY_EXTERNALPOSLIST = "externalPOSList";
    public static final String PROPERTY_FINBANKSTATEMENTLIST = "fINBankStatementList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINFINACCTRANSACTIONEMSFADTCDOCTYPEIDLIST = "fINFinaccTransactionEMSfadtCDoctypeIDList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTMETHODEMSSPITRADOCTYPEIDLIST = "fINPaymentMethodEMSspitraDoctypeIDList";
    public static final String PROPERTY_FINPAYMENTPROPOSALLIST = "fINPaymentProposalList";
    public static final String PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST = "fINPaymentProposalEMSlppPaymentDoctypeIDList";
    public static final String PROPERTY_FINRECONCILIATIONLIST = "fINReconciliationList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLIST = "financialMgmtAmortizationList";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST = "financialMgmtAssetEMSsalCDoctypeIDList";
    public static final String PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST = "financialMgmtDPManagementList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTSETTLEMENTLIST = "financialMgmtSettlementList";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST = "financialMgmtTaxRegisterTypeLinesList";
    public static final String PROPERTY_INVENTORYAMOUNTUPDATELIST = "inventoryAmountUpdateList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICETRANSACTIONDOCUMENTLIST = "invoiceTransactionDocumentList";
    public static final String PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST = "invoiceEMSswhCDoctypeIDList";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST = "invoiceV2TransactionDocumentList";
    public static final String PROPERTY_LANDEDCOSTLIST = "landedCostList";
    public static final String PROPERTY_LANDEDCOSTCOSTLIST = "landedCostCostList";
    public static final String PROPERTY_MANUFACTURINGCASEEMSLQSDOCUMENTTYPELIST = "manufacturingCaseEMSlqsDocumentTypeList";
    public static final String PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODCDOCTYPETARGETIDLIST = "manufacturingMeasureShiftEMCrprodCDoctypetargetIDList";
    public static final String PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST = "manufacturingWorkRequirementList";
    public static final String PROPERTY_MARKETINGCAMPAIGNEMSSIMPDTCDOCTYPEIDLIST = "marketingCampaignEMSsimpdtCDocTypeIDList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSRSCDOCTYPEIDLIST = "materialMgmtInternalMovementEMSsrsCDoctypeIDList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSINDOCTYPEIDLIST = "materialMgmtInternalMovementEMSsinDoctypeIDList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTEMSSINDOCTYPEIDLIST = "materialMgmtInventoryCountEMSsinDoctypeIDList";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPDAIDOCUMENTTYPELIST = "materialMgmtProductionTransactionEMSpdaiDocumentTypeList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPELIST = "oBPOSAppPaymentTypeList";
    public static final String PROPERTY_OBPOSTERMINALTYPELIST = "oBPOSTerminalTypeList";
    public static final String PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRETURNSLIST = "oBPOSTerminalTypeDocumentTypeForReturnsList";
    public static final String PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRECONCILIATIONSLIST = "oBPOSTerminalTypeDocumentTypeForReconciliationsList";
    public static final String PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORQUOTATIONSLIST = "oBPOSTerminalTypeDocumentTypeForQuotationsList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERTRANSACTIONDOCUMENTLIST = "orderTransactionDocumentList";
    public static final String PROPERTY_ORGANIZATIONEMSSRSCDOCTYPEFROMIDLIST = "organizationEMSsrsCDoctypefromIDList";
    public static final String PROPERTY_ORGANIZATIONEMSSRSCDOCTYPETOIDLIST = "organizationEMSsrsCDoctypetoIDList";
    public static final String PROPERTY_ORGANIZATIONEMSSFORCDOCTYPETARGETIDLIST = "organizationEMSsforCDoctypetargetIDList";
    public static final String PROPERTY_PROJECTEMSPROCTMDOCTYPELIST = "projectEMSproctmDoctypeList";
    public static final String PROPERTY_SCSDCSIGNATURESPERDOCLIST = "sCSDCSignaturesperdocList";
    public static final String PROPERTY_SIVAPHYSICALINVENTORYLIST = "sIVAPhysicalInventoryList";
    public static final String PROPERTY_SPEPADVANCEPAYMENTLIST = "sPEPAdvancePaymentList";
    public static final String PROPERTY_SPEVREGISTERNEWSCDOCTYPETARGETIDLIST = "sPEVRegisterNewsCDoctypetargetIDList";
    public static final String PROPERTY_SRSISALESINVOICEVLIST = "sRSISalesInvoiceVList";
    public static final String PROPERTY_SSDQSIQUOTADETAILLIST = "sSDQSIQuotaDetailList";
    public static final String PROPERTY_SSDQSIQUOTADETAILTIPEDOCUMENTCOLLECTIONSLIST = "sSDQSIQuotaDetailTipeDocumentCollectionsList";
    public static final String PROPERTY_SSPHTENTHSETTLEMENTLIST = "sSPHTenthSettlementList";
    public static final String PROPERTY_SSPPPAYMENTSLIST = "sSPPPAYMENTSList";
    public static final String PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST = "sSPPPAYMENTSCDoctypePaymentIDList";
    public static final String PROPERTY_SSPRLEAVEEMPLIST = "sSPRLeaveEmpList";
    public static final String PROPERTY_SSPRPAYROLLLIST = "sSPRPayrollList";
    public static final String PROPERTY_SSWHAUTHORIZATIONLIST = "sSWHAuthorizationList";
    public static final String PROPERTY_SSWHPOSLIST = "sSWHPosList";
    public static final String PROPERTY_SSWHRECEIPTLIST = "sSWHReceiptList";
    public static final String PROPERTY_SSWSCONFIGLIST = "sSWSConfigList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELIST = "sSWSWithholdingSaleList";
    public static final String PROPERTY_STXREVFINANCIALLACCOUNTINGLIST = "sTXREVFinanciallAccountingList";
    public static final String PROPERTY_SWSOCCONFIGLIST = "sWSOCConfigList";
    public static final String PROPERTY_SCCCSETUPCDOCTYPESALESIDLIST = "scccSetupCDoctypeSalesIDList";
    public static final String PROPERTY_SCCCSETUPCDOCTYPECREDITNOTESIDLIST = "scccSetupCDoctypeCreditNotesIDList";
    public static final String PROPERTY_SCCCSETUPCDOCTYPEREVERSEDIDLIST = "scccSetupCDoctypeReversedIDList";
    public static final String PROPERTY_SIBLRPHYSICALINVENTORYLIST = "siblrPhysicalInventoryList";
    public static final String PROPERTY_SSBODOFFERDOCLIST = "ssbodOfferDocList";
    public static final String PROPERTY_SSCCRPOSCARDRECLIST = "ssccrPosCardRecList";
    public static final String PROPERTY_SSCCSOCASHINCEXPLIST = "ssccsoCashIncExpList";
    public static final String PROPERTY_SSCCSOTYPEOFDOCUMENTLIST = "ssccsoTypeOfDocumentList";
    public static final String PROPERTY_SSMAACTACCOUNTINGLIST = "ssmaactAccountingList";
    public static final String PROPERTY_SSMAACTAUDITLIST = "ssmaactAuditList";
    public static final String PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDSALESLIST = "ssoposPosSoConfCDoctypeIdSalesList";
    public static final String PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDRETURNLIST = "ssoposPosSoConfCDoctypeIdReturnList";
    public static final String PROPERTY_SSPCHPAYMENTPLANLIST = "sspchPaymentPlanList";
    public static final String PROPERTY_SSPCHPOSTDATEDCHECKSLIST = "sspchPostdatedChecksList";
    public static final String PROPERTY_SSPCHPOSTDATEDCHECKSFINDOCTYPEIDLIST = "sspchPostdatedChecksFINDoctypeIDList";
    public static final String PROPERTY_SSSOVLCONFIGLINESLIST = "sssovlConfiglinesList";
    public static final String PROPERTY_SSWOSSOTRANSFERLIST = "sswosSOTransferList";
    public static final String PROPERTY_SSWOSSOTRANSFERCDOCTYPEIDORDERLIST = "sswosSOTransferCDoctypeIdOrderList";
    public static final String PROPERTY_STATUSERDOCLIST = "statUserDocList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCDOCTYPEIDLIST = "timeAndExpenseSheetEMSproctmCDoctypeIDList";
    public static final String PROPERTY_ATINDPOPOSTVENTALIST = "atindpoPostventaList";
    public static final String PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETIDLIST = "atindpoPostventaEMSswosCDoctypetargetIDList";
    public static final String PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETSIDLIST = "atindpoPostventaEMSswosCDoctypetargetsIDList";
    public static final String PROPERTY_CRPRQYPARAMSSAFETYQLYTRANSACTIONDOCUMENTLIST = "crprqyParamsSafetyQlyTransactionDocumentList";
    public static final String PROPERTY_CSAAACUSTODIANLIST = "csaaaCustodianList";
    public static final String PROPERTY_CSAAAINVENTORYTAKINGLIST = "csaaaInventoryTakingList";
    public static final String PROPERTY_ECSCAPGENERALPROCESSLIST = "ecscapGeneralProcessList";
    public static final String PROPERTY_ECSCBBREAKDOWNTRANSACTIONDOCUMENTLIST = "ecscbBreakdownTransactionDocumentList";
    public static final String PROPERTY_ECSCBTYPEBREAKDOWNINVENTORYTYPELIST = "ecscbTypeBreakdownInventoryTypeList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEPURCHASEIDLIST = "imdlvPurchaseInvoiceDoctypePurchaseIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHSUPPORTIDLIST = "imdlvPurchaseInvoiceDoctypeWithSupportIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHOUTSUPPORTIDLIST = "imdlvPurchaseInvoiceDoctypeWithoutSupportIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHHOLDINGIDLIST = "imdlvPurchaseInvoiceDoctypeWithholdingIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICECWSDOCTYPEIDLIST = "imdlvPurchaseInvoiceCWsdoctypeIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICECCNDOCTYPEIDLIST = "imdlvPurchaseInvoiceCCndoctypeIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICECCDDODCTYPEIDLIST = "imdlvPurchaseInvoiceCCddodctypeIDList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEORDERLIST = "imdlvPurchaseInvoiceDoctypeOrderList";
    public static final String PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEINOUTLIST = "imdlvPurchaseInvoiceDoctypeInoutList";
    public static final String PROPERTY_IMDLVPURCHASEIMPDATALIST = "imdlvPurchaseimpDataList";
    public static final String PROPERTY_IMDLVVOUCHERPURCHASELIST = "imdlvVoucherPurchaseList";
    public static final String PROPERTY_OPCRMCASESEMSSCCESCDOCTYPETARGETIDLIST = "opcrmCasesEMSsccesCDoctypetargetIDList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESEMSCMECUDOCTYPEIDLIST = "opcrmOpportunitiesEMScmecuDoctypeIDList";
    public static final String PROPERTY_SATMACCONTRACTLIST = "satmacContractList";
    public static final String PROPERTY_SATMACSOTRANSFERLINELIST = "satmacSoTransferLineList";
    public static final String PROPERTY_SBPRFFACTACCTAGGDDOCLIST = "sbprfFactAcctAggdDocList";
    public static final String PROPERTY_SCCRTCARDLOADTRANSACTIONLIST = "sccrtCardLoadTransactionList";
    public static final String PROPERTY_SCMFSEASONPRODUCTLIST = "scmfSeasonProductList";
    public static final String PROPERTY_SDCDEBITCOLLECTLIST = "sdcDebitcollectList";
    public static final String PROPERTY_SDCCDAILYCLOSSINGLIST = "sdccDailyClossingList";
    public static final String PROPERTY_SDCCDAILYCLOSSINGCDOCTYPEPAYMENTIDLIST = "sdccDailyClossingCDoctypePaymentIDList";
    public static final String PROPERTY_SEACTASSETSETUPLIST = "seactAssetSetupList";
    public static final String PROPERTY_SESCRTEMPLATEREPORTLIST = "sescrTemplateReportList";
    public static final String PROPERTY_SFADTACCSEQUENCESLIST = "sfadtAccSequencesList";
    public static final String PROPERTY_SFPRMOVEMENTTYPELIST = "sfprMovementTypeList";
    public static final String PROPERTY_SIMPPYSPAYMENTDETAILPAYMENTDOCTYPELIST = "simppysPaymentDetailPaymentDocTypeList";
    public static final String PROPERTY_SIMPPYSPAYMENTDATAUPLOADLIST = "simppysPaymentdatauploadList";
    public static final String PROPERTY_SIMPSIMIMPORTSIMULATIONLIST = "simpsimImportSimulationList";
    public static final String PROPERTY_SLIAINVPARMLINELIST = "sliaInvParmlineList";
    public static final String PROPERTY_SPROCTMSETTLEMENTCOSTLIST = "sproctmSettlementCostList";
    public static final String PROPERTY_SPROVOVERTIMELIST = "sprovOvertimeList";
    public static final String PROPERTY_SPROVPERIODLIST = "sprovPeriodList";
    public static final String PROPERTY_SSACHMODIFYASSETLIST = "ssachModifyAssetList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALACTIVEMAINDOCTYPERETURNLIST = "ssalActiveMainDoctypeReturnList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST = "ssalApplActiveCDoctypeIdReturnList";
    public static final String PROPERTY_SSALASSETRETURNLIST = "ssalAssetReturnList";
    public static final String PROPERTY_SSAMALIENATELIST = "ssamAlienateList";
    public static final String PROPERTY_SSAPQAPPPARAMMOVILLIST = "ssapqAppParamMovilList";
    public static final String PROPERTY_SSATRASSETTRANSFERLIST = "ssatrAssetTransferList";
    public static final String PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPESALESIDLIST = "sscccinInvoiceDoctypeCDoctypeSalesIDList";
    public static final String PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPECREDITNOTESIDLIST = "sscccinInvoiceDoctypeCDoctypeCreditNotesIDList";
    public static final String PROPERTY_SSCCCININVOICEDOCTYPEDOCUMENTCANCELLEDLIST = "sscccinInvoiceDoctypeDocumentCancelledList";
    public static final String PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST = "sscflwExpensivePayoutVList";
    public static final String PROPERTY_SSCPRREPORTCERTIFICATELIST = "sscprReportcertificateList";
    public static final String PROPERTY_SSCTCONTRACTLIST = "ssctContractList";
    public static final String PROPERTY_SSDNIDPAYMENTLIST = "ssdnidPaymentList";
    public static final String PROPERTY_SSFIFINANCIALUSERLIST = "ssfiFinancialUserList";
    public static final String PROPERTY_SSIMPCNIMPCONSOLDETAILLIST = "ssimpcnImpConsolDetailList";
    public static final String PROPERTY_SSIMPCNIMPCONSOLIDATIONLIST = "ssimpcnImpConsolidationList";
    public static final String PROPERTY_SSIMPCNIMPORTATIONCOSTLIST = "ssimpcnImportationCostList";
    public static final String PROPERTY_SSIPDVDOCTYPELIST = "ssipdvDoctypeList";
    public static final String PROPERTY_SSIPICERATEICELIST = "ssipiceRateIceList";
    public static final String PROPERTY_SSIPOTMCONFIGINOUTDOCTYPEIDLIST = "ssipotmConfigInoutDoctypeIDList";
    public static final String PROPERTY_SSIPOTMCONFIGINVOICEDOCTYPEIDLIST = "ssipotmConfigInvoiceDoctypeIDList";
    public static final String PROPERTY_SSIPOTMPARTIALDISPATCHLIST = "ssipotmPartialDispatchList";
    public static final String PROPERTY_SSMRPSASIMULATIONPRODLIST = "ssmrpsAsimulationProdList";
    public static final String PROPERTY_SSORELINVOICEORDERVLIST = "ssorelInvoiceorderVList";
    public static final String PROPERTY_SSORELINVOICEORDERVTRANSACTIONDOCUMENTLIST = "ssorelInvoiceorderVTransactionDocumentList";
    public static final String PROPERTY_SSPIMPLIMPORTPRODUCTPLLIST = "sspimplImportProductPlList";
    public static final String PROPERTY_SSPPINVSETTINGLIST = "ssppinvSettingList";
    public static final String PROPERTY_SSPPINVSETTINGPAYMENTDOCTYPEIDLIST = "ssppinvSettingPaymentDoctypeIDList";
    public static final String PROPERTY_SSPREMPLOYEESETTLEMENTLIST = "ssprEmployeesettlementList";
    public static final String PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST = "ssprLoansEMSfprCDoctypeIDList";
    public static final String PROPERTY_SSPROTHERTAXINCOMELIST = "ssprOtherTaxIncomeList";
    public static final String PROPERTY_SSPRPAYROLLPAYMENTLIST = "ssprPayrollpaymentList";
    public static final String PROPERTY_SSPRSETTLEMENTLIST = "ssprSettlementList";
    public static final String PROPERTY_SSSOINDATESALESPROCESSVCDOCTYPETARGETIDLIST = "sssoinDatesalesprocessVCDoctypetargetIDList";
    public static final String PROPERTY_SSTPCLIQPRJINVVLIST = "sstpcLiqPrjInvVList";
    public static final String PROPERTY_SSTPCLIQUIDATIONPROJECTSLIST = "sstpcLiquidationProjectsList";
    public static final String PROPERTY_SSTPCMATCONPROJVLIST = "sstpcMatConProjVList";
    public static final String PROPERTY_SSTPCMATPROJVOIDVLIST = "sstpcMatProjVoidVList";
    public static final String PROPERTY_SSTPCPAYMENTLIQVLIST = "sstpcPaymentLiqVList";
    public static final String PROPERTY_SSTPCPRELIQVLIST = "sstpcPreliqVList";
    public static final String PROPERTY_SSTPCRELATEDCOSTSLIST = "sstpcRelatedCostsList";
    public static final String PROPERTY_SSTPCRELATEDREVENUELIST = "sstpcRelatedRevenueList";
    public static final String PROPERTY_SSWCLWORKORDERVLIST = "sswclWorkOrderVList";
    public static final String PROPERTY_SSWCLWORKORDERVSSWOSCDOCTYPETARGETSIDLIST = "sswclWorkOrderVSswosCDoctypetargetsIDList";
    public static final String PROPERTY_SSWHSALESTICKETSLIST = "sswhSalesticketsList";
    public static final String PROPERTY_SSWHWITHHCARDCREDITLIST = "sswhWithhCardCreditList";
    public static final String PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST = "sswhWithholdingsVoidedList";
    public static final String PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST = "sswhWithholdingsVoidedCDoctype2IDList";
    public static final String PROPERTY_SSWOUPUPDATEPRICEWOLIST = "sswoupUpdatePriceWoList";
    public static final String PROPERTY_SSWSADVANCEPAYMENTLIST = "sswsAdvancePaymentList";
    public static final String PROPERTY_SWBLCONFIGLIST = "swblConfigList";
    public static final String PROPERTY_SWSPCCONFIGLIST = "swspcConfigList";
    public static final String PROPERTY_SWSPCCONFIGCDOCTYPEPAYMENTINIDLIST = "swspcConfigCDoctypePaymentInIDList";

    public DocumentType() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SALESTRANSACTION, false);
        setDefaultValue(PROPERTY_SEQUENCEDDOCUMENT, true);
        setDefaultValue(PROPERTY_DEFAULT, false);
        setDefaultValue(PROPERTY_NUMBEROFCOPIES, (long) 1);
        setDefaultValue(PROPERTY_FILTERBYORGANIZATION, false);
        setDefaultValue(PROPERTY_EXPENSE, false);
        setDefaultValue(PROPERTY_REVERSAL, false);
        setDefaultValue(PROPERTY_RETURN, false);
        setDefaultValue(PROPERTY_SSWHIMPLEMENTAUTORIZA, false);
        setDefaultValue(PROPERTY_SSWHISWITHHOLDING, false);
        setDefaultValue(PROPERTY_SSWHISCLIENT, false);
        setDefaultValue(PROPERTY_SSWHISWITHHOLDINGSALE, false);
        setDefaultValue(PROPERTY_SSRSDEFAULT, false);
        setDefaultValue(PROPERTY_SSWHAFECTEDZONE, false);
        setDefaultValue(PROPERTY_SSIPISIMPORTS, false);
        setDefaultValue(PROPERTY_EEIEDOCTYPE, "01");
        setDefaultValue(PROPERTY_EEIISEDOC, false);
        setDefaultValue(PROPERTY_EEIREMISSIONFORSALES, false);
        setDefaultValue(PROPERTY_SSWHEXTWITHH, false);
        setDefaultValue(PROPERTY_SSFIISCROSSING, false);
        setDefaultValue(PROPERTY_SDINAPPLYDINARDAP, false);
        setDefaultValue(PROPERTY_STATTRANSAUTHORIZATION, false);
        setDefaultValue(PROPERTY_EEIKEYACCESSGENERATED, false);
        setDefaultValue(PROPERTY_SCRTLACONTROLASSETS, false);
        setDefaultValue(PROPERTY_EEIDESCRIPTIONFIELDS, "DEDA");
        setDefaultValue(PROPERTY_EEIISREFUND, false);
        setDefaultValue(PROPERTY_SSACISASSETPURCHASE, false);
        setDefaultValue(PROPERTY_SSDNIDINTERESTDEBITNOTE, false);
        setDefaultValue(PROPERTY_SSIMPCNCONSOLIDATEDIMP, false);
        setDefaultValue(PROPERTY_SATHNCAUTHREQUIRED, false);
        setDefaultValue(PROPERTY_EEICOMERCIALINV, false);
        setDefaultValue(PROPERTY_SSDNIDINTERESTDEBITNOTEDOC, false);
        setDefaultValue(PROPERTY_SCNSAAUTOMATICGENERATENC, false);
        setDefaultValue(PROPERTY_EEINOREFERENCEINVOICE, false);
        setDefaultValue(PROPERTY_SSWHDIVIDENDS, false);
        setDefaultValue(PROPERTY_APRMRECONCILIATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_COSTADJUSTMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTEMPLATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEEMSSDNIDCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPEEMSCNSADOCNCAUTOMATICLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_DOCUMENTTYPETRLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EXTERNALPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONEMSFADTCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTMETHODEMSSPITRADOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVENTORYAMOUNTUPDATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGCASEEMSLQSDOCUMENTTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODCDOCTYPETARGETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MARKETINGCAMPAIGNEMSSIMPDTCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSRSCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSINDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTEMSSINDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPDAIDOCUMENTTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSTERMINALTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRETURNSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRECONCILIATIONSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORQUOTATIONSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSSRSCDOCTYPEFROMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSSRSCDOCTYPETOIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSSFORCDOCTYPETARGETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PROJECTEMSPROCTMDOCTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCSDCSIGNATURESPERDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIVAPHYSICALINVENTORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEPADVANCEPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEVREGISTERNEWSCDOCTYPETARGETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDQSIQUOTADETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDQSIQUOTADETAILTIPEDOCUMENTCOLLECTIONSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPHTENTHSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLEAVEEMPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHAUTHORIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHPOSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSOCCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCSETUPCDOCTYPESALESIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCSETUPCDOCTYPECREDITNOTESIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCSETUPCDOCTYPEREVERSEDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIBLRPHYSICALINVENTORYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSBODOFFERDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRPOSCARDRECLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOCASHINCEXPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOTYPEOFDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTAUDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDSALESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHPAYMENTPLANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHPOSTDATEDCHECKSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHPOSTDATEDCHECKSFINDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSSOVLCONFIGLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSSOTRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSSOTRANSFERCDOCTYPEIDORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STATUSERDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETSIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CRPRQYPARAMSSAFETYQLYTRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAAINVENTORYTAKINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCAPGENERALPROCESSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBBREAKDOWNTRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSCBTYPEBREAKDOWNINVENTORYTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEPURCHASEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHSUPPORTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHOUTSUPPORTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHHOLDINGIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICECWSDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICECCNDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICECCDDODCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVPURCHASEIMPDATALIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVVOUCHERPURCHASELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMCASESEMSSCCESCDOCTYPETARGETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESEMSCMECUDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SATMACCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SATMACSOTRANSFERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPRFFACTACCTAGGDDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCRTCARDLOADTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCMFSEASONPRODUCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCDEBITCOLLECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGCDOCTYPEPAYMENTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SEACTASSETSETUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SESCRTEMPLATEREPORTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFADTACCSEQUENCESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SFPRMOVEMENTTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPPYSPAYMENTDETAILPAYMENTDOCTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPPYSPAYMENTDATAUPLOADLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPSIMIMPORTSIMULATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SLIAINVPARMLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMSETTLEMENTCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROVOVERTIMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROVPERIODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACHMODIFYASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINDOCTYPERETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAPQAPPPARAMMOVILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPESALESIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPECREDITNOTESIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCCININVOICEDOCTYPEDOCUMENTCANCELLEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCPRREPORTCERTIFICATELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDNIDPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINANCIALUSERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPCONSOLDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPCONSOLIDATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPDVDOCTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPICERATEICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMCONFIGINOUTDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMCONFIGINVOICEDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMRPSASIMULATIONPRODLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSORELINVOICEORDERVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSORELINVOICEORDERVTRANSACTIONDOCUMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPIMPLIMPORTPRODUCTPLLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPINVSETTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPINVSETTINGPAYMENTDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPREMPLOYEESETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPROTHERTAXINCOMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSSOINDATESALESPROCESSVCDOCTYPETARGETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCLIQPRJINVVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCLIQUIDATIONPROJECTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMATCONPROJVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCMATPROJVOIDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPAYMENTLIQVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPRELIQVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDCOSTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDREVENUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWCLWORKORDERVSSWOSCDOCTYPETARGETSIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHSALESTICKETSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHCARDCREDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOUPUPDATEPRICEWOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSADVANCEPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWBLCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSPCCONFIGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSPCCONFIGCDOCTYPEPAYMENTINIDLIST, new ArrayList<Object>());
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

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public String getPrintText() {
        return (String) get(PROPERTY_PRINTTEXT);
    }

    public void setPrintText(String printText) {
        set(PROPERTY_PRINTTEXT, printText);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getDocumentCategory() {
        return (String) get(PROPERTY_DOCUMENTCATEGORY);
    }

    public void setDocumentCategory(String documentCategory) {
        set(PROPERTY_DOCUMENTCATEGORY, documentCategory);
    }

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getSOSubType() {
        return (String) get(PROPERTY_SOSUBTYPE);
    }

    public void setSOSubType(String sOSubType) {
        set(PROPERTY_SOSUBTYPE, sOSubType);
    }

    public DocumentType getDocumentTypeForShipment() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORSHIPMENT);
    }

    public void setDocumentTypeForShipment(DocumentType documentTypeForShipment) {
        set(PROPERTY_DOCUMENTTYPEFORSHIPMENT, documentTypeForShipment);
    }

    public DocumentType getDocumentTypeForInvoice() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORINVOICE);
    }

    public void setDocumentTypeForInvoice(DocumentType documentTypeForInvoice) {
        set(PROPERTY_DOCUMENTTYPEFORINVOICE, documentTypeForInvoice);
    }

    public Boolean isSequencedDocument() {
        return (Boolean) get(PROPERTY_SEQUENCEDDOCUMENT);
    }

    public void setSequencedDocument(Boolean sequencedDocument) {
        set(PROPERTY_SEQUENCEDDOCUMENT, sequencedDocument);
    }

    public Sequence getDocumentSequence() {
        return (Sequence) get(PROPERTY_DOCUMENTSEQUENCE);
    }

    public void setDocumentSequence(Sequence documentSequence) {
        set(PROPERTY_DOCUMENTSEQUENCE, documentSequence);
    }

    public GLCategory getGLCategory() {
        return (GLCategory) get(PROPERTY_GLCATEGORY);
    }

    public void setGLCategory(GLCategory gLCategory) {
        set(PROPERTY_GLCATEGORY, gLCategory);
    }

    public String getComments() {
        return (String) get(PROPERTY_COMMENTS);
    }

    public void setComments(String comments) {
        set(PROPERTY_COMMENTS, comments);
    }

    public Boolean isDefault() {
        return (Boolean) get(PROPERTY_DEFAULT);
    }

    public void setDefault(Boolean deflt) {
        set(PROPERTY_DEFAULT, deflt);
    }

    public Long getNumberOfCopies() {
        return (Long) get(PROPERTY_NUMBEROFCOPIES);
    }

    public void setNumberOfCopies(Long numberOfCopies) {
        set(PROPERTY_NUMBEROFCOPIES, numberOfCopies);
    }

    public Table getTable() {
        return (Table) get(PROPERTY_TABLE);
    }

    public void setTable(Table table) {
        set(PROPERTY_TABLE, table);
    }

    public Boolean isFilterByOrganization() {
        return (Boolean) get(PROPERTY_FILTERBYORGANIZATION);
    }

    public void setFilterByOrganization(Boolean filterByOrganization) {
        set(PROPERTY_FILTERBYORGANIZATION, filterByOrganization);
    }

    public DocumentType getDocumentCancelled() {
        return (DocumentType) get(PROPERTY_DOCUMENTCANCELLED);
    }

    public void setDocumentCancelled(DocumentType documentCancelled) {
        set(PROPERTY_DOCUMENTCANCELLED, documentCancelled);
    }

    public Boolean isExpense() {
        return (Boolean) get(PROPERTY_EXPENSE);
    }

    public void setExpense(Boolean expense) {
        set(PROPERTY_EXPENSE, expense);
    }

    public Boolean isReversal() {
        return (Boolean) get(PROPERTY_REVERSAL);
    }

    public void setReversal(Boolean reversal) {
        set(PROPERTY_REVERSAL, reversal);
    }

    public Boolean isReturn() {
        return (Boolean) get(PROPERTY_RETURN);
    }

    public void setReturn(Boolean rturn) {
        set(PROPERTY_RETURN, rturn);
    }

    public DocumentType getDocumentTypeForOrder() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPEFORORDER);
    }

    public void setDocumentTypeForOrder(DocumentType documentTypeForOrder) {
        set(PROPERTY_DOCUMENTTYPEFORORDER, documentTypeForOrder);
    }

    public Boolean isSswhImplementautoriza() {
        return (Boolean) get(PROPERTY_SSWHIMPLEMENTAUTORIZA);
    }

    public void setSswhImplementautoriza(Boolean sswhImplementautoriza) {
        set(PROPERTY_SSWHIMPLEMENTAUTORIZA, sswhImplementautoriza);
    }

    public Boolean isSswhIswithholding() {
        return (Boolean) get(PROPERTY_SSWHISWITHHOLDING);
    }

    public void setSswhIswithholding(Boolean sswhIswithholding) {
        set(PROPERTY_SSWHISWITHHOLDING, sswhIswithholding);
    }

    public Boolean isSswhIsclient() {
        return (Boolean) get(PROPERTY_SSWHISCLIENT);
    }

    public void setSswhIsclient(Boolean sswhIsclient) {
        set(PROPERTY_SSWHISCLIENT, sswhIsclient);
    }

    public Boolean isSswhIswithholdingsale() {
        return (Boolean) get(PROPERTY_SSWHISWITHHOLDINGSALE);
    }

    public void setSswhIswithholdingsale(Boolean sswhIswithholdingsale) {
        set(PROPERTY_SSWHISWITHHOLDINGSALE, sswhIswithholdingsale);
    }

    public Boolean isSsrsDefault() {
        return (Boolean) get(PROPERTY_SSRSDEFAULT);
    }

    public void setSsrsDefault(Boolean ssrsDefault) {
        set(PROPERTY_SSRSDEFAULT, ssrsDefault);
    }

    public sswhtypereceipt getSswhTypereceipt() {
        return (sswhtypereceipt) get(PROPERTY_SSWHTYPERECEIPT);
    }

    public void setSswhTypereceipt(sswhtypereceipt sswhTypereceipt) {
        set(PROPERTY_SSWHTYPERECEIPT, sswhTypereceipt);
    }

    public String getSswhDoctype() {
        return (String) get(PROPERTY_SSWHDOCTYPE);
    }

    public void setSswhDoctype(String sswhDoctype) {
        set(PROPERTY_SSWHDOCTYPE, sswhDoctype);
    }

    public Boolean isSswhAfectedZone() {
        return (Boolean) get(PROPERTY_SSWHAFECTEDZONE);
    }

    public void setSswhAfectedZone(Boolean sswhAfectedZone) {
        set(PROPERTY_SSWHAFECTEDZONE, sswhAfectedZone);
    }

    public Boolean isSsipIsimports() {
        return (Boolean) get(PROPERTY_SSIPISIMPORTS);
    }

    public void setSsipIsimports(Boolean ssipIsimports) {
        set(PROPERTY_SSIPISIMPORTS, ssipIsimports);
    }

    public String getSswhCode() {
        return (String) get(PROPERTY_SSWHCODE);
    }

    public void setSswhCode(String sswhCode) {
        set(PROPERTY_SSWHCODE, sswhCode);
    }

    public Long getSSWHPercentage() {
        return (Long) get(PROPERTY_SSWHPERCENTAGE);
    }

    public void setSSWHPercentage(Long sSWHPercentage) {
        set(PROPERTY_SSWHPERCENTAGE, sSWHPercentage);
    }

    public String getEeiEdocType() {
        return (String) get(PROPERTY_EEIEDOCTYPE);
    }

    public void setEeiEdocType(String eeiEdocType) {
        set(PROPERTY_EEIEDOCTYPE, eeiEdocType);
    }

    public Boolean isEeiIsEdoc() {
        return (Boolean) get(PROPERTY_EEIISEDOC);
    }

    public void setEeiIsEdoc(Boolean eeiIsEdoc) {
        set(PROPERTY_EEIISEDOC, eeiIsEdoc);
    }

    public Boolean isEeiRemissionForSales() {
        return (Boolean) get(PROPERTY_EEIREMISSIONFORSALES);
    }

    public void setEeiRemissionForSales(Boolean eeiRemissionForSales) {
        set(PROPERTY_EEIREMISSIONFORSALES, eeiRemissionForSales);
    }

    public Boolean isSswhExtWithh() {
        return (Boolean) get(PROPERTY_SSWHEXTWITHH);
    }

    public void setSswhExtWithh(Boolean sswhExtWithh) {
        set(PROPERTY_SSWHEXTWITHH, sswhExtWithh);
    }

    public Boolean isSsfiIscrossing() {
        return (Boolean) get(PROPERTY_SSFIISCROSSING);
    }

    public void setSsfiIscrossing(Boolean ssfiIscrossing) {
        set(PROPERTY_SSFIISCROSSING, ssfiIscrossing);
    }

    public String getSswhWithhCode() {
        return (String) get(PROPERTY_SSWHWITHHCODE);
    }

    public void setSswhWithhCode(String sswhWithhCode) {
        set(PROPERTY_SSWHWITHHCODE, sswhWithhCode);
    }

    public Boolean isSdinApplydinardap() {
        return (Boolean) get(PROPERTY_SDINAPPLYDINARDAP);
    }

    public void setSdinApplydinardap(Boolean sdinApplydinardap) {
        set(PROPERTY_SDINAPPLYDINARDAP, sdinApplydinardap);
    }

    public Boolean isStatTransAuthorization() {
        return (Boolean) get(PROPERTY_STATTRANSAUTHORIZATION);
    }

    public void setStatTransAuthorization(Boolean statTransAuthorization) {
        set(PROPERTY_STATTRANSAUTHORIZATION, statTransAuthorization);
    }

    public Boolean isEeiKeyAccessGenerated() {
        return (Boolean) get(PROPERTY_EEIKEYACCESSGENERATED);
    }

    public void setEeiKeyAccessGenerated(Boolean eeiKeyAccessGenerated) {
        set(PROPERTY_EEIKEYACCESSGENERATED, eeiKeyAccessGenerated);
    }

    public String getSiblrTypeInventory() {
        return (String) get(PROPERTY_SIBLRTYPEINVENTORY);
    }

    public void setSiblrTypeInventory(String siblrTypeInventory) {
        set(PROPERTY_SIBLRTYPEINVENTORY, siblrTypeInventory);
    }

    public Boolean isScrtlaControlAssets() {
        return (Boolean) get(PROPERTY_SCRTLACONTROLASSETS);
    }

    public void setScrtlaControlAssets(Boolean scrtlaControlAssets) {
        set(PROPERTY_SCRTLACONTROLASSETS, scrtlaControlAssets);
    }

    public String getEeiDescriptionfields() {
        return (String) get(PROPERTY_EEIDESCRIPTIONFIELDS);
    }

    public void setEeiDescriptionfields(String eeiDescriptionfields) {
        set(PROPERTY_EEIDESCRIPTIONFIELDS, eeiDescriptionfields);
    }

    public Boolean isEeiIsrefund() {
        return (Boolean) get(PROPERTY_EEIISREFUND);
    }

    public void setEeiIsrefund(Boolean eeiIsrefund) {
        set(PROPERTY_EEIISREFUND, eeiIsrefund);
    }

    public String getSswosServiceorder() {
        return (String) get(PROPERTY_SSWOSSERVICEORDER);
    }

    public void setSswosServiceorder(String sswosServiceorder) {
        set(PROPERTY_SSWOSSERVICEORDER, sswosServiceorder);
    }

    public Long getEeiRefundCode() {
        return (Long) get(PROPERTY_EEIREFUNDCODE);
    }

    public void setEeiRefundCode(Long eeiRefundCode) {
        set(PROPERTY_EEIREFUNDCODE, eeiRefundCode);
    }

    public Boolean isSsacIsassetpurchase() {
        return (Boolean) get(PROPERTY_SSACISASSETPURCHASE);
    }

    public void setSsacIsassetpurchase(Boolean ssacIsassetpurchase) {
        set(PROPERTY_SSACISASSETPURCHASE, ssacIsassetpurchase);
    }

    public Boolean isSsdnidInterestdebitnote() {
        return (Boolean) get(PROPERTY_SSDNIDINTERESTDEBITNOTE);
    }

    public void setSsdnidInterestdebitnote(Boolean ssdnidInterestdebitnote) {
        set(PROPERTY_SSDNIDINTERESTDEBITNOTE, ssdnidInterestdebitnote);
    }

    public Sequence getSpdnSequence() {
        return (Sequence) get(PROPERTY_SPDNSEQUENCE);
    }

    public void setSpdnSequence(Sequence spdnSequence) {
        set(PROPERTY_SPDNSEQUENCE, spdnSequence);
    }

    public Boolean isSsimpcnConsolidatedImp() {
        return (Boolean) get(PROPERTY_SSIMPCNCONSOLIDATEDIMP);
    }

    public void setSsimpcnConsolidatedImp(Boolean ssimpcnConsolidatedImp) {
        set(PROPERTY_SSIMPCNCONSOLIDATEDIMP, ssimpcnConsolidatedImp);
    }

    public String getSsorresInvoiceRule() {
        return (String) get(PROPERTY_SSORRESINVOICERULE);
    }

    public void setSsorresInvoiceRule(String ssorresInvoiceRule) {
        set(PROPERTY_SSORRESINVOICERULE, ssorresInvoiceRule);
    }

    public Boolean isSathncAuthRequired() {
        return (Boolean) get(PROPERTY_SATHNCAUTHREQUIRED);
    }

    public void setSathncAuthRequired(Boolean sathncAuthRequired) {
        set(PROPERTY_SATHNCAUTHREQUIRED, sathncAuthRequired);
    }

    public Boolean isEeiComercialInv() {
        return (Boolean) get(PROPERTY_EEICOMERCIALINV);
    }

    public void setEeiComercialInv(Boolean eeiComercialInv) {
        set(PROPERTY_EEICOMERCIALINV, eeiComercialInv);
    }

    public Boolean isSsdnidInterestdebitnotedoc() {
        return (Boolean) get(PROPERTY_SSDNIDINTERESTDEBITNOTEDOC);
    }

    public void setSsdnidInterestdebitnotedoc(Boolean ssdnidInterestdebitnotedoc) {
        set(PROPERTY_SSDNIDINTERESTDEBITNOTEDOC, ssdnidInterestdebitnotedoc);
    }

    public Boolean isScnsaAutomaticGenerateNc() {
        return (Boolean) get(PROPERTY_SCNSAAUTOMATICGENERATENC);
    }

    public void setScnsaAutomaticGenerateNc(Boolean scnsaAutomaticGenerateNc) {
        set(PROPERTY_SCNSAAUTOMATICGENERATENC, scnsaAutomaticGenerateNc);
    }

    public DocumentType getSsdnidCDoctype() {
        return (DocumentType) get(PROPERTY_SSDNIDCDOCTYPE);
    }

    public void setSsdnidCDoctype(DocumentType ssdnidCDoctype) {
        set(PROPERTY_SSDNIDCDOCTYPE, ssdnidCDoctype);
    }

    public Boolean isEeiNoReferenceInvoice() {
        return (Boolean) get(PROPERTY_EEINOREFERENCEINVOICE);
    }

    public void setEeiNoReferenceInvoice(Boolean eeiNoReferenceInvoice) {
        set(PROPERTY_EEINOREFERENCEINVOICE, eeiNoReferenceInvoice);
    }

    public String getScnsaDescription() {
        return (String) get(PROPERTY_SCNSADESCRIPTION);
    }

    public void setScnsaDescription(String scnsaDescription) {
        set(PROPERTY_SCNSADESCRIPTION, scnsaDescription);
    }

    public Boolean isSswhDividends() {
        return (Boolean) get(PROPERTY_SSWHDIVIDENDS);
    }

    public void setSswhDividends(Boolean sswhDividends) {
        set(PROPERTY_SSWHDIVIDENDS, sswhDividends);
    }

    public DocumentType getScnsaDocNcAutomatic() {
        return (DocumentType) get(PROPERTY_SCNSADOCNCAUTOMATIC);
    }

    public void setScnsaDocNcAutomatic(DocumentType scnsaDocNcAutomatic) {
        set(PROPERTY_SCNSADOCNCAUTOMATIC, scnsaDocNcAutomatic);
    }

    public Costcenter getSsfcCostcenter() {
        return (Costcenter) get(PROPERTY_SSFCCOSTCENTER);
    }

    public void setSsfcCostcenter(Costcenter ssfcCostcenter) {
        set(PROPERTY_SSFCCOSTCENTER, ssfcCostcenter);
    }

    public String getSssovlInvoicerule() {
        return (String) get(PROPERTY_SSSOVLINVOICERULE);
    }

    public void setSssovlInvoicerule(String sssovlInvoicerule) {
        set(PROPERTY_SSSOVLINVOICERULE, sssovlInvoicerule);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_Reconciliation_v> getAPRMReconciliationList() {
      return (List<APRM_Reconciliation_v>) get(PROPERTY_APRMRECONCILIATIONLIST);
    }

    public void setAPRMReconciliationList(List<APRM_Reconciliation_v> aPRMReconciliationList) {
        set(PROPERTY_APRMRECONCILIATIONLIST, aPRMReconciliationList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMOpcrmDoctypeIDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST);
    }

    public void setBusinessPartnerEMOpcrmDoctypeIDList(List<BusinessPartner> businessPartnerEMOpcrmDoctypeIDList) {
        set(PROPERTY_BUSINESSPARTNEREMOPCRMDOCTYPEIDLIST, businessPartnerEMOpcrmDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CostAdjustment> getCostAdjustmentList() {
      return (List<CostAdjustment>) get(PROPERTY_COSTADJUSTMENTLIST);
    }

    public void setCostAdjustmentList(List<CostAdjustment> costAdjustmentList) {
        set(PROPERTY_COSTADJUSTMENTLIST, costAdjustmentList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTemplate> getDocumentTemplateList() {
      return (List<DocumentTemplate>) get(PROPERTY_DOCUMENTTEMPLATELIST);
    }

    public void setDocumentTemplateList(List<DocumentTemplate> documentTemplateList) {
        set(PROPERTY_DOCUMENTTEMPLATELIST, documentTemplateList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForShipmentList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST);
    }

    public void setDocumentTypeDocumentTypeForShipmentList(List<DocumentType> documentTypeDocumentTypeForShipmentList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORSHIPMENTLIST, documentTypeDocumentTypeForShipmentList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForInvoiceList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST);
    }

    public void setDocumentTypeDocumentTypeForInvoiceList(List<DocumentType> documentTypeDocumentTypeForInvoiceList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORINVOICELIST, documentTypeDocumentTypeForInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentCancelledList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST);
    }

    public void setDocumentTypeDocumentCancelledList(List<DocumentType> documentTypeDocumentCancelledList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTCANCELLEDLIST, documentTypeDocumentCancelledList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeDocumentTypeForOrderList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST);
    }

    public void setDocumentTypeDocumentTypeForOrderList(List<DocumentType> documentTypeDocumentTypeForOrderList) {
        set(PROPERTY_DOCUMENTTYPEDOCUMENTTYPEFORORDERLIST, documentTypeDocumentTypeForOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeEMSsdnidCDoctypeIDList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEEMSSDNIDCDOCTYPEIDLIST);
    }

    public void setDocumentTypeEMSsdnidCDoctypeIDList(List<DocumentType> documentTypeEMSsdnidCDoctypeIDList) {
        set(PROPERTY_DOCUMENTTYPEEMSSDNIDCDOCTYPEIDLIST, documentTypeEMSsdnidCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentType> getDocumentTypeEMScnsaDocNcAutomaticList() {
      return (List<DocumentType>) get(PROPERTY_DOCUMENTTYPEEMSCNSADOCNCAUTOMATICLIST);
    }

    public void setDocumentTypeEMScnsaDocNcAutomaticList(List<DocumentType> documentTypeEMScnsaDocNcAutomaticList) {
        set(PROPERTY_DOCUMENTTYPEEMSCNSADOCNCAUTOMATICLIST, documentTypeEMScnsaDocNcAutomaticList);
    }

    @SuppressWarnings("unchecked")
    public List<DocumentTypeTrl> getDocumentTypeTrlList() {
      return (List<DocumentTypeTrl>) get(PROPERTY_DOCUMENTTYPETRLLIST);
    }

    public void setDocumentTypeTrlList(List<DocumentTypeTrl> documentTypeTrlList) {
        set(PROPERTY_DOCUMENTTYPETRLLIST, documentTypeTrlList);
    }

    @SuppressWarnings("unchecked")
    public List<ExternalPOS> getExternalPOSList() {
      return (List<ExternalPOS>) get(PROPERTY_EXTERNALPOSLIST);
    }

    public void setExternalPOSList(List<ExternalPOS> externalPOSList) {
        set(PROPERTY_EXTERNALPOSLIST, externalPOSList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatement> getFINBankStatementList() {
      return (List<FIN_BankStatement>) get(PROPERTY_FINBANKSTATEMENTLIST);
    }

    public void setFINBankStatementList(List<FIN_BankStatement> fINBankStatementList) {
        set(PROPERTY_FINBANKSTATEMENTLIST, fINBankStatementList);
    }

    @SuppressWarnings("unchecked")
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionEMSfadtCDoctypeIDList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONEMSFADTCDOCTYPEIDLIST);
    }

    public void setFINFinaccTransactionEMSfadtCDoctypeIDList(List<FIN_FinaccTransaction> fINFinaccTransactionEMSfadtCDoctypeIDList) {
        set(PROPERTY_FINFINACCTRANSACTIONEMSFADTCDOCTYPEIDLIST, fINFinaccTransactionEMSfadtCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentMethod> getFINPaymentMethodEMSspitraDoctypeIDList() {
      return (List<FIN_PaymentMethod>) get(PROPERTY_FINPAYMENTMETHODEMSSPITRADOCTYPEIDLIST);
    }

    public void setFINPaymentMethodEMSspitraDoctypeIDList(List<FIN_PaymentMethod> fINPaymentMethodEMSspitraDoctypeIDList) {
        set(PROPERTY_FINPAYMENTMETHODEMSSPITRADOCTYPEIDLIST, fINPaymentMethodEMSspitraDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALLIST);
    }

    public void setFINPaymentProposalList(List<FIN_PaymentProposal> fINPaymentProposalList) {
        set(PROPERTY_FINPAYMENTPROPOSALLIST, fINPaymentProposalList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentProposal> getFINPaymentProposalEMSlppPaymentDoctypeIDList() {
      return (List<FIN_PaymentProposal>) get(PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST);
    }

    public void setFINPaymentProposalEMSlppPaymentDoctypeIDList(List<FIN_PaymentProposal> fINPaymentProposalEMSlppPaymentDoctypeIDList) {
        set(PROPERTY_FINPAYMENTPROPOSALEMSLPPPAYMENTDOCTYPEIDLIST, fINPaymentProposalEMSlppPaymentDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_Reconciliation> getFINReconciliationList() {
      return (List<FIN_Reconciliation>) get(PROPERTY_FINRECONCILIATIONLIST);
    }

    public void setFINReconciliationList(List<FIN_Reconciliation> fINReconciliationList) {
        set(PROPERTY_FINRECONCILIATIONLIST, fINReconciliationList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<Amortization> getFinancialMgmtAmortizationList() {
      return (List<Amortization>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST);
    }

    public void setFinancialMgmtAmortizationList(List<Amortization> financialMgmtAmortizationList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST, financialMgmtAmortizationList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsalCDoctypeIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST);
    }

    public void setFinancialMgmtAssetEMSsalCDoctypeIDList(List<Asset> financialMgmtAssetEMSsalCDoctypeIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSALCDOCTYPEIDLIST, financialMgmtAssetEMSsalCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<DPManagement> getFinancialMgmtDPManagementList() {
      return (List<DPManagement>) get(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST);
    }

    public void setFinancialMgmtDPManagementList(List<DPManagement> financialMgmtDPManagementList) {
        set(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, financialMgmtDPManagementList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournal> getFinancialMgmtGLJournalList() {
      return (List<GLJournal>) get(PROPERTY_FINANCIALMGMTGLJOURNALLIST);
    }

    public void setFinancialMgmtGLJournalList(List<GLJournal> financialMgmtGLJournalList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLIST, financialMgmtGLJournalList);
    }

    @SuppressWarnings("unchecked")
    public List<Settlement> getFinancialMgmtSettlementList() {
      return (List<Settlement>) get(PROPERTY_FINANCIALMGMTSETTLEMENTLIST);
    }

    public void setFinancialMgmtSettlementList(List<Settlement> financialMgmtSettlementList) {
        set(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, financialMgmtSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegisterTypeLines> getFinancialMgmtTaxRegisterTypeLinesList() {
      return (List<TaxRegisterTypeLines>) get(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST);
    }

    public void setFinancialMgmtTaxRegisterTypeLinesList(List<TaxRegisterTypeLines> financialMgmtTaxRegisterTypeLinesList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELINESLIST, financialMgmtTaxRegisterTypeLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryAmountUpdate> getInventoryAmountUpdateList() {
      return (List<InventoryAmountUpdate>) get(PROPERTY_INVENTORYAMOUNTUPDATELIST);
    }

    public void setInventoryAmountUpdateList(List<InventoryAmountUpdate> inventoryAmountUpdateList) {
        set(PROPERTY_INVENTORYAMOUNTUPDATELIST, inventoryAmountUpdateList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceTransactionDocumentList() {
      return (List<Invoice>) get(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST);
    }

    public void setInvoiceTransactionDocumentList(List<Invoice> invoiceTransactionDocumentList) {
        set(PROPERTY_INVOICETRANSACTIONDOCUMENTLIST, invoiceTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSswhCDoctypeIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST);
    }

    public void setInvoiceEMSswhCDoctypeIDList(List<Invoice> invoiceEMSswhCDoctypeIDList) {
        set(PROPERTY_INVOICEEMSSWHCDOCTYPEIDLIST, invoiceEMSswhCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2TransactionDocumentList() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST);
    }

    public void setInvoiceV2TransactionDocumentList(List<InvoiceV2> invoiceV2TransactionDocumentList) {
        set(PROPERTY_INVOICEV2TRANSACTIONDOCUMENTLIST, invoiceV2TransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCost> getLandedCostList() {
      return (List<LandedCost>) get(PROPERTY_LANDEDCOSTLIST);
    }

    public void setLandedCostList(List<LandedCost> landedCostList) {
        set(PROPERTY_LANDEDCOSTLIST, landedCostList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostCost> getLandedCostCostList() {
      return (List<LandedCostCost>) get(PROPERTY_LANDEDCOSTCOSTLIST);
    }

    public void setLandedCostCostList(List<LandedCostCost> landedCostCostList) {
        set(PROPERTY_LANDEDCOSTCOSTLIST, landedCostCostList);
    }

    @SuppressWarnings("unchecked")
    public List<Case> getManufacturingCaseEMSlqsDocumentTypeList() {
      return (List<Case>) get(PROPERTY_MANUFACTURINGCASEEMSLQSDOCUMENTTYPELIST);
    }

    public void setManufacturingCaseEMSlqsDocumentTypeList(List<Case> manufacturingCaseEMSlqsDocumentTypeList) {
        set(PROPERTY_MANUFACTURINGCASEEMSLQSDOCUMENTTYPELIST, manufacturingCaseEMSlqsDocumentTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<MeasureShift> getManufacturingMeasureShiftEMCrprodCDoctypetargetIDList() {
      return (List<MeasureShift>) get(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODCDOCTYPETARGETIDLIST);
    }

    public void setManufacturingMeasureShiftEMCrprodCDoctypetargetIDList(List<MeasureShift> manufacturingMeasureShiftEMCrprodCDoctypetargetIDList) {
        set(PROPERTY_MANUFACTURINGMEASURESHIFTEMCRPRODCDOCTYPETARGETIDLIST, manufacturingMeasureShiftEMCrprodCDoctypetargetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<WorkRequirement> getManufacturingWorkRequirementList() {
      return (List<WorkRequirement>) get(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST);
    }

    public void setManufacturingWorkRequirementList(List<WorkRequirement> manufacturingWorkRequirementList) {
        set(PROPERTY_MANUFACTURINGWORKREQUIREMENTLIST, manufacturingWorkRequirementList);
    }

    @SuppressWarnings("unchecked")
    public List<Campaign> getMarketingCampaignEMSsimpdtCDocTypeIDList() {
      return (List<Campaign>) get(PROPERTY_MARKETINGCAMPAIGNEMSSIMPDTCDOCTYPEIDLIST);
    }

    public void setMarketingCampaignEMSsimpdtCDocTypeIDList(List<Campaign> marketingCampaignEMSsimpdtCDocTypeIDList) {
        set(PROPERTY_MARKETINGCAMPAIGNEMSSIMPDTCDOCTYPEIDLIST, marketingCampaignEMSsimpdtCDocTypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovement> getMaterialMgmtInternalMovementEMSsrsCDoctypeIDList() {
      return (List<InternalMovement>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSRSCDOCTYPEIDLIST);
    }

    public void setMaterialMgmtInternalMovementEMSsrsCDoctypeIDList(List<InternalMovement> materialMgmtInternalMovementEMSsrsCDoctypeIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSRSCDOCTYPEIDLIST, materialMgmtInternalMovementEMSsrsCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovement> getMaterialMgmtInternalMovementEMSsinDoctypeIDList() {
      return (List<InternalMovement>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSINDOCTYPEIDLIST);
    }

    public void setMaterialMgmtInternalMovementEMSsinDoctypeIDList(List<InternalMovement> materialMgmtInternalMovementEMSsinDoctypeIDList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTEMSSINDOCTYPEIDLIST, materialMgmtInternalMovementEMSsinDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCount> getMaterialMgmtInventoryCountEMSsinDoctypeIDList() {
      return (List<InventoryCount>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTEMSSINDOCTYPEIDLIST);
    }

    public void setMaterialMgmtInventoryCountEMSsinDoctypeIDList(List<InventoryCount> materialMgmtInventoryCountEMSsinDoctypeIDList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTEMSSINDOCTYPEIDLIST, materialMgmtInventoryCountEMSsinDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionTransaction> getMaterialMgmtProductionTransactionEMSpdaiDocumentTypeList() {
      return (List<ProductionTransaction>) get(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPDAIDOCUMENTTYPELIST);
    }

    public void setMaterialMgmtProductionTransactionEMSpdaiDocumentTypeList(List<ProductionTransaction> materialMgmtProductionTransactionEMSpdaiDocumentTypeList) {
        set(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPDAIDOCUMENTTYPELIST, materialMgmtProductionTransactionEMSpdaiDocumentTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPELIST);
    }

    public void setOBPOSAppPaymentTypeList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPELIST, oBPOSAppPaymentTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalType> getOBPOSTerminalTypeList() {
      return (List<TerminalType>) get(PROPERTY_OBPOSTERMINALTYPELIST);
    }

    public void setOBPOSTerminalTypeList(List<TerminalType> oBPOSTerminalTypeList) {
        set(PROPERTY_OBPOSTERMINALTYPELIST, oBPOSTerminalTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalType> getOBPOSTerminalTypeDocumentTypeForReturnsList() {
      return (List<TerminalType>) get(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRETURNSLIST);
    }

    public void setOBPOSTerminalTypeDocumentTypeForReturnsList(List<TerminalType> oBPOSTerminalTypeDocumentTypeForReturnsList) {
        set(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRETURNSLIST, oBPOSTerminalTypeDocumentTypeForReturnsList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalType> getOBPOSTerminalTypeDocumentTypeForReconciliationsList() {
      return (List<TerminalType>) get(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRECONCILIATIONSLIST);
    }

    public void setOBPOSTerminalTypeDocumentTypeForReconciliationsList(List<TerminalType> oBPOSTerminalTypeDocumentTypeForReconciliationsList) {
        set(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORRECONCILIATIONSLIST, oBPOSTerminalTypeDocumentTypeForReconciliationsList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalType> getOBPOSTerminalTypeDocumentTypeForQuotationsList() {
      return (List<TerminalType>) get(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORQUOTATIONSLIST);
    }

    public void setOBPOSTerminalTypeDocumentTypeForQuotationsList(List<TerminalType> oBPOSTerminalTypeDocumentTypeForQuotationsList) {
        set(PROPERTY_OBPOSTERMINALTYPEDOCUMENTTYPEFORQUOTATIONSLIST, oBPOSTerminalTypeDocumentTypeForQuotationsList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderTransactionDocumentList() {
      return (List<Order>) get(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST);
    }

    public void setOrderTransactionDocumentList(List<Order> orderTransactionDocumentList) {
        set(PROPERTY_ORDERTRANSACTIONDOCUMENTLIST, orderTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMSsrsCDoctypefromIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSSRSCDOCTYPEFROMIDLIST);
    }

    public void setOrganizationEMSsrsCDoctypefromIDList(List<Organization> organizationEMSsrsCDoctypefromIDList) {
        set(PROPERTY_ORGANIZATIONEMSSRSCDOCTYPEFROMIDLIST, organizationEMSsrsCDoctypefromIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMSsrsCDoctypetoIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSSRSCDOCTYPETOIDLIST);
    }

    public void setOrganizationEMSsrsCDoctypetoIDList(List<Organization> organizationEMSsrsCDoctypetoIDList) {
        set(PROPERTY_ORGANIZATIONEMSSRSCDOCTYPETOIDLIST, organizationEMSsrsCDoctypetoIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMSsforCDoctypetargetIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSSFORCDOCTYPETARGETIDLIST);
    }

    public void setOrganizationEMSsforCDoctypetargetIDList(List<Organization> organizationEMSsforCDoctypetargetIDList) {
        set(PROPERTY_ORGANIZATIONEMSSFORCDOCTYPETARGETIDLIST, organizationEMSsforCDoctypetargetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Project> getProjectEMSproctmDoctypeList() {
      return (List<Project>) get(PROPERTY_PROJECTEMSPROCTMDOCTYPELIST);
    }

    public void setProjectEMSproctmDoctypeList(List<Project> projectEMSproctmDoctypeList) {
        set(PROPERTY_PROJECTEMSPROCTMDOCTYPELIST, projectEMSproctmDoctypeList);
    }

    @SuppressWarnings("unchecked")
    public List<SCSDCSignaturesperdoc> getSCSDCSignaturesperdocList() {
      return (List<SCSDCSignaturesperdoc>) get(PROPERTY_SCSDCSIGNATURESPERDOCLIST);
    }

    public void setSCSDCSignaturesperdocList(List<SCSDCSignaturesperdoc> sCSDCSignaturesperdocList) {
        set(PROPERTY_SCSDCSIGNATURESPERDOCLIST, sCSDCSignaturesperdocList);
    }

    @SuppressWarnings("unchecked")
    public List<SIVAPhysicalInventory> getSIVAPhysicalInventoryList() {
      return (List<SIVAPhysicalInventory>) get(PROPERTY_SIVAPHYSICALINVENTORYLIST);
    }

    public void setSIVAPhysicalInventoryList(List<SIVAPhysicalInventory> sIVAPhysicalInventoryList) {
        set(PROPERTY_SIVAPHYSICALINVENTORYLIST, sIVAPhysicalInventoryList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEPAdvancePayment> getSPEPAdvancePaymentList() {
      return (List<SPEPAdvancePayment>) get(PROPERTY_SPEPADVANCEPAYMENTLIST);
    }

    public void setSPEPAdvancePaymentList(List<SPEPAdvancePayment> sPEPAdvancePaymentList) {
        set(PROPERTY_SPEPADVANCEPAYMENTLIST, sPEPAdvancePaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVRegisterNews> getSPEVRegisterNewsCDoctypetargetIDList() {
      return (List<SPEVRegisterNews>) get(PROPERTY_SPEVREGISTERNEWSCDOCTYPETARGETIDLIST);
    }

    public void setSPEVRegisterNewsCDoctypetargetIDList(List<SPEVRegisterNews> sPEVRegisterNewsCDoctypetargetIDList) {
        set(PROPERTY_SPEVREGISTERNEWSCDOCTYPETARGETIDLIST, sPEVRegisterNewsCDoctypetargetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVLIST);
    }

    public void setSRSISalesInvoiceVList(List<SRSISalesInvoiceV> sRSISalesInvoiceVList) {
        set(PROPERTY_SRSISALESINVOICEVLIST, sRSISalesInvoiceVList);
    }

    @SuppressWarnings("unchecked")
    public List<QuotaDetail> getSSDQSIQuotaDetailList() {
      return (List<QuotaDetail>) get(PROPERTY_SSDQSIQUOTADETAILLIST);
    }

    public void setSSDQSIQuotaDetailList(List<QuotaDetail> sSDQSIQuotaDetailList) {
        set(PROPERTY_SSDQSIQUOTADETAILLIST, sSDQSIQuotaDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<QuotaDetail> getSSDQSIQuotaDetailTipeDocumentCollectionsList() {
      return (List<QuotaDetail>) get(PROPERTY_SSDQSIQUOTADETAILTIPEDOCUMENTCOLLECTIONSLIST);
    }

    public void setSSDQSIQuotaDetailTipeDocumentCollectionsList(List<QuotaDetail> sSDQSIQuotaDetailTipeDocumentCollectionsList) {
        set(PROPERTY_SSDQSIQUOTADETAILTIPEDOCUMENTCOLLECTIONSLIST, sSDQSIQuotaDetailTipeDocumentCollectionsList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPHTenthSettlement> getSSPHTenthSettlementList() {
      return (List<SSPHTenthSettlement>) get(PROPERTY_SSPHTENTHSETTLEMENTLIST);
    }

    public void setSSPHTenthSettlementList(List<SSPHTenthSettlement> sSPHTenthSettlementList) {
        set(PROPERTY_SSPHTENTHSETTLEMENTLIST, sSPHTenthSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTS> getSSPPPAYMENTSList() {
      return (List<SSPPPAYMENTS>) get(PROPERTY_SSPPPAYMENTSLIST);
    }

    public void setSSPPPAYMENTSList(List<SSPPPAYMENTS> sSPPPAYMENTSList) {
        set(PROPERTY_SSPPPAYMENTSLIST, sSPPPAYMENTSList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPPPAYMENTS> getSSPPPAYMENTSCDoctypePaymentIDList() {
      return (List<SSPPPAYMENTS>) get(PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST);
    }

    public void setSSPPPAYMENTSCDoctypePaymentIDList(List<SSPPPAYMENTS> sSPPPAYMENTSCDoctypePaymentIDList) {
        set(PROPERTY_SSPPPAYMENTSCDOCTYPEPAYMENTIDLIST, sSPPPAYMENTSCDoctypePaymentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprleaveemp> getSSPRLeaveEmpList() {
      return (List<ssprleaveemp>) get(PROPERTY_SSPRLEAVEEMPLIST);
    }

    public void setSSPRLeaveEmpList(List<ssprleaveemp> sSPRLeaveEmpList) {
        set(PROPERTY_SSPRLEAVEEMPLIST, sSPRLeaveEmpList);
    }

    @SuppressWarnings("unchecked")
    public List<Payroll> getSSPRPayrollList() {
      return (List<Payroll>) get(PROPERTY_SSPRPAYROLLLIST);
    }

    public void setSSPRPayrollList(List<Payroll> sSPRPayrollList) {
        set(PROPERTY_SSPRPAYROLLLIST, sSPRPayrollList);
    }

    @SuppressWarnings("unchecked")
    public List<Authorization> getSSWHAuthorizationList() {
      return (List<Authorization>) get(PROPERTY_SSWHAUTHORIZATIONLIST);
    }

    public void setSSWHAuthorizationList(List<Authorization> sSWHAuthorizationList) {
        set(PROPERTY_SSWHAUTHORIZATIONLIST, sSWHAuthorizationList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHPos> getSSWHPosList() {
      return (List<SSWHPos>) get(PROPERTY_SSWHPOSLIST);
    }

    public void setSSWHPosList(List<SSWHPos> sSWHPosList) {
        set(PROPERTY_SSWHPOSLIST, sSWHPosList);
    }

    @SuppressWarnings("unchecked")
    public List<Receipt> getSSWHReceiptList() {
      return (List<Receipt>) get(PROPERTY_SSWHRECEIPTLIST);
    }

    public void setSSWHReceiptList(List<Receipt> sSWHReceiptList) {
        set(PROPERTY_SSWHRECEIPTLIST, sSWHReceiptList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSConfig> getSSWSConfigList() {
      return (List<SSWSConfig>) get(PROPERTY_SSWSCONFIGLIST);
    }

    public void setSSWSConfigList(List<SSWSConfig> sSWSConfigList) {
        set(PROPERTY_SSWSCONFIGLIST, sSWSConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSale> getSSWSWithholdingSaleList() {
      return (List<SSWSWithholdingSale>) get(PROPERTY_SSWSWITHHOLDINGSALELIST);
    }

    public void setSSWSWithholdingSaleList(List<SSWSWithholdingSale> sSWSWithholdingSaleList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELIST, sSWSWithholdingSaleList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingReversal> getSTXREVFinanciallAccountingList() {
      return (List<AccountingReversal>) get(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST);
    }

    public void setSTXREVFinanciallAccountingList(List<AccountingReversal> sTXREVFinanciallAccountingList) {
        set(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, sTXREVFinanciallAccountingList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSOCConfig> getSWSOCConfigList() {
      return (List<SWSOCConfig>) get(PROPERTY_SWSOCCONFIGLIST);
    }

    public void setSWSOCConfigList(List<SWSOCConfig> sWSOCConfigList) {
        set(PROPERTY_SWSOCCONFIGLIST, sWSOCConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccSetup> getScccSetupCDoctypeSalesIDList() {
      return (List<ScccSetup>) get(PROPERTY_SCCCSETUPCDOCTYPESALESIDLIST);
    }

    public void setScccSetupCDoctypeSalesIDList(List<ScccSetup> scccSetupCDoctypeSalesIDList) {
        set(PROPERTY_SCCCSETUPCDOCTYPESALESIDLIST, scccSetupCDoctypeSalesIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccSetup> getScccSetupCDoctypeCreditNotesIDList() {
      return (List<ScccSetup>) get(PROPERTY_SCCCSETUPCDOCTYPECREDITNOTESIDLIST);
    }

    public void setScccSetupCDoctypeCreditNotesIDList(List<ScccSetup> scccSetupCDoctypeCreditNotesIDList) {
        set(PROPERTY_SCCCSETUPCDOCTYPECREDITNOTESIDLIST, scccSetupCDoctypeCreditNotesIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccSetup> getScccSetupCDoctypeReversedIDList() {
      return (List<ScccSetup>) get(PROPERTY_SCCCSETUPCDOCTYPEREVERSEDIDLIST);
    }

    public void setScccSetupCDoctypeReversedIDList(List<ScccSetup> scccSetupCDoctypeReversedIDList) {
        set(PROPERTY_SCCCSETUPCDOCTYPEREVERSEDIDLIST, scccSetupCDoctypeReversedIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SiblrPhysicalInventory> getSiblrPhysicalInventoryList() {
      return (List<SiblrPhysicalInventory>) get(PROPERTY_SIBLRPHYSICALINVENTORYLIST);
    }

    public void setSiblrPhysicalInventoryList(List<SiblrPhysicalInventory> siblrPhysicalInventoryList) {
        set(PROPERTY_SIBLRPHYSICALINVENTORYLIST, siblrPhysicalInventoryList);
    }

    @SuppressWarnings("unchecked")
    public List<SssbodOfferDoc> getSsbodOfferDocList() {
      return (List<SssbodOfferDoc>) get(PROPERTY_SSBODOFFERDOCLIST);
    }

    public void setSsbodOfferDocList(List<SssbodOfferDoc> ssbodOfferDocList) {
        set(PROPERTY_SSBODOFFERDOCLIST, ssbodOfferDocList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrPosCardRec> getSsccrPosCardRecList() {
      return (List<SsccrPosCardRec>) get(PROPERTY_SSCCRPOSCARDRECLIST);
    }

    public void setSsccrPosCardRecList(List<SsccrPosCardRec> ssccrPosCardRecList) {
        set(PROPERTY_SSCCRPOSCARDRECLIST, ssccrPosCardRecList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoCashIncExp> getSsccsoCashIncExpList() {
      return (List<SsccsoCashIncExp>) get(PROPERTY_SSCCSOCASHINCEXPLIST);
    }

    public void setSsccsoCashIncExpList(List<SsccsoCashIncExp> ssccsoCashIncExpList) {
        set(PROPERTY_SSCCSOCASHINCEXPLIST, ssccsoCashIncExpList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoTypeOfDocument> getSsccsoTypeOfDocumentList() {
      return (List<SsccsoTypeOfDocument>) get(PROPERTY_SSCCSOTYPEOFDOCUMENTLIST);
    }

    public void setSsccsoTypeOfDocumentList(List<SsccsoTypeOfDocument> ssccsoTypeOfDocumentList) {
        set(PROPERTY_SSCCSOTYPEOFDOCUMENTLIST, ssccsoTypeOfDocumentList);
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
    public List<SsoposPosSoConf> getSsoposPosSoConfCDoctypeIdSalesList() {
      return (List<SsoposPosSoConf>) get(PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDSALESLIST);
    }

    public void setSsoposPosSoConfCDoctypeIdSalesList(List<SsoposPosSoConf> ssoposPosSoConfCDoctypeIdSalesList) {
        set(PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDSALESLIST, ssoposPosSoConfCDoctypeIdSalesList);
    }

    @SuppressWarnings("unchecked")
    public List<SsoposPosSoConf> getSsoposPosSoConfCDoctypeIdReturnList() {
      return (List<SsoposPosSoConf>) get(PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDRETURNLIST);
    }

    public void setSsoposPosSoConfCDoctypeIdReturnList(List<SsoposPosSoConf> ssoposPosSoConfCDoctypeIdReturnList) {
        set(PROPERTY_SSOPOSPOSSOCONFCDOCTYPEIDRETURNLIST, ssoposPosSoConfCDoctypeIdReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchPaymentPlan> getSspchPaymentPlanList() {
      return (List<SspchPaymentPlan>) get(PROPERTY_SSPCHPAYMENTPLANLIST);
    }

    public void setSspchPaymentPlanList(List<SspchPaymentPlan> sspchPaymentPlanList) {
        set(PROPERTY_SSPCHPAYMENTPLANLIST, sspchPaymentPlanList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchPostdatedChecks> getSspchPostdatedChecksList() {
      return (List<SspchPostdatedChecks>) get(PROPERTY_SSPCHPOSTDATEDCHECKSLIST);
    }

    public void setSspchPostdatedChecksList(List<SspchPostdatedChecks> sspchPostdatedChecksList) {
        set(PROPERTY_SSPCHPOSTDATEDCHECKSLIST, sspchPostdatedChecksList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchPostdatedChecks> getSspchPostdatedChecksFINDoctypeIDList() {
      return (List<SspchPostdatedChecks>) get(PROPERTY_SSPCHPOSTDATEDCHECKSFINDOCTYPEIDLIST);
    }

    public void setSspchPostdatedChecksFINDoctypeIDList(List<SspchPostdatedChecks> sspchPostdatedChecksFINDoctypeIDList) {
        set(PROPERTY_SSPCHPOSTDATEDCHECKSFINDOCTYPEIDLIST, sspchPostdatedChecksFINDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SssovlConfiglines> getSssovlConfiglinesList() {
      return (List<SssovlConfiglines>) get(PROPERTY_SSSOVLCONFIGLINESLIST);
    }

    public void setSssovlConfiglinesList(List<SssovlConfiglines> sssovlConfiglinesList) {
        set(PROPERTY_SSSOVLCONFIGLINESLIST, sssovlConfiglinesList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosSOTransfer> getSswosSOTransferList() {
      return (List<SswosSOTransfer>) get(PROPERTY_SSWOSSOTRANSFERLIST);
    }

    public void setSswosSOTransferList(List<SswosSOTransfer> sswosSOTransferList) {
        set(PROPERTY_SSWOSSOTRANSFERLIST, sswosSOTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosSOTransfer> getSswosSOTransferCDoctypeIdOrderList() {
      return (List<SswosSOTransfer>) get(PROPERTY_SSWOSSOTRANSFERCDOCTYPEIDORDERLIST);
    }

    public void setSswosSOTransferCDoctypeIdOrderList(List<SswosSOTransfer> sswosSOTransferCDoctypeIdOrderList) {
        set(PROPERTY_SSWOSSOTRANSFERCDOCTYPEIDORDERLIST, sswosSOTransferCDoctypeIdOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<StatUserDoc> getStatUserDocList() {
      return (List<StatUserDoc>) get(PROPERTY_STATUSERDOCLIST);
    }

    public void setStatUserDocList(List<StatUserDoc> statUserDocList) {
        set(PROPERTY_STATUSERDOCLIST, statUserDocList);
    }

    @SuppressWarnings("unchecked")
    public List<Sheet> getTimeAndExpenseSheetEMSproctmCDoctypeIDList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCDOCTYPEIDLIST);
    }

    public void setTimeAndExpenseSheetEMSproctmCDoctypeIDList(List<Sheet> timeAndExpenseSheetEMSproctmCDoctypeIDList) {
        set(PROPERTY_TIMEANDEXPENSESHEETEMSPROCTMCDOCTYPEIDLIST, timeAndExpenseSheetEMSproctmCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventa> getAtindpoPostventaList() {
      return (List<atindpo_postventa>) get(PROPERTY_ATINDPOPOSTVENTALIST);
    }

    public void setAtindpoPostventaList(List<atindpo_postventa> atindpoPostventaList) {
        set(PROPERTY_ATINDPOPOSTVENTALIST, atindpoPostventaList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventa> getAtindpoPostventaEMSswosCDoctypetargetIDList() {
      return (List<atindpo_postventa>) get(PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETIDLIST);
    }

    public void setAtindpoPostventaEMSswosCDoctypetargetIDList(List<atindpo_postventa> atindpoPostventaEMSswosCDoctypetargetIDList) {
        set(PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETIDLIST, atindpoPostventaEMSswosCDoctypetargetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<atindpo_postventa> getAtindpoPostventaEMSswosCDoctypetargetsIDList() {
      return (List<atindpo_postventa>) get(PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETSIDLIST);
    }

    public void setAtindpoPostventaEMSswosCDoctypetargetsIDList(List<atindpo_postventa> atindpoPostventaEMSswosCDoctypetargetsIDList) {
        set(PROPERTY_ATINDPOPOSTVENTAEMSSWOSCDOCTYPETARGETSIDLIST, atindpoPostventaEMSswosCDoctypetargetsIDList);
    }

    @SuppressWarnings("unchecked")
    public List<crprqy_paramsSafetyQly> getCrprqyParamsSafetyQlyTransactionDocumentList() {
      return (List<crprqy_paramsSafetyQly>) get(PROPERTY_CRPRQYPARAMSSAFETYQLYTRANSACTIONDOCUMENTLIST);
    }

    public void setCrprqyParamsSafetyQlyTransactionDocumentList(List<crprqy_paramsSafetyQly> crprqyParamsSafetyQlyTransactionDocumentList) {
        set(PROPERTY_CRPRQYPARAMSSAFETYQLYTRANSACTIONDOCUMENTLIST, crprqyParamsSafetyQlyTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodian> getCsaaaCustodianList() {
      return (List<CsaaaCustodian>) get(PROPERTY_CSAAACUSTODIANLIST);
    }

    public void setCsaaaCustodianList(List<CsaaaCustodian> csaaaCustodianList) {
        set(PROPERTY_CSAAACUSTODIANLIST, csaaaCustodianList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTaking> getCsaaaInventoryTakingList() {
      return (List<CsaaaInventoryTaking>) get(PROPERTY_CSAAAINVENTORYTAKINGLIST);
    }

    public void setCsaaaInventoryTakingList(List<CsaaaInventoryTaking> csaaaInventoryTakingList) {
        set(PROPERTY_CSAAAINVENTORYTAKINGLIST, csaaaInventoryTakingList);
    }

    @SuppressWarnings("unchecked")
    public List<Ecscap_GeneralProcess> getEcscapGeneralProcessList() {
      return (List<Ecscap_GeneralProcess>) get(PROPERTY_ECSCAPGENERALPROCESSLIST);
    }

    public void setEcscapGeneralProcessList(List<Ecscap_GeneralProcess> ecscapGeneralProcessList) {
        set(PROPERTY_ECSCAPGENERALPROCESSLIST, ecscapGeneralProcessList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_breakdown> getEcscbBreakdownTransactionDocumentList() {
      return (List<ecscb_breakdown>) get(PROPERTY_ECSCBBREAKDOWNTRANSACTIONDOCUMENTLIST);
    }

    public void setEcscbBreakdownTransactionDocumentList(List<ecscb_breakdown> ecscbBreakdownTransactionDocumentList) {
        set(PROPERTY_ECSCBBREAKDOWNTRANSACTIONDOCUMENTLIST, ecscbBreakdownTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<ecscb_TypeBreakdown> getEcscbTypeBreakdownInventoryTypeList() {
      return (List<ecscb_TypeBreakdown>) get(PROPERTY_ECSCBTYPEBREAKDOWNINVENTORYTYPELIST);
    }

    public void setEcscbTypeBreakdownInventoryTypeList(List<ecscb_TypeBreakdown> ecscbTypeBreakdownInventoryTypeList) {
        set(PROPERTY_ECSCBTYPEBREAKDOWNINVENTORYTYPELIST, ecscbTypeBreakdownInventoryTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceDoctypePurchaseIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEPURCHASEIDLIST);
    }

    public void setImdlvPurchaseInvoiceDoctypePurchaseIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceDoctypePurchaseIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEPURCHASEIDLIST, imdlvPurchaseInvoiceDoctypePurchaseIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceDoctypeWithSupportIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHSUPPORTIDLIST);
    }

    public void setImdlvPurchaseInvoiceDoctypeWithSupportIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceDoctypeWithSupportIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHSUPPORTIDLIST, imdlvPurchaseInvoiceDoctypeWithSupportIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceDoctypeWithoutSupportIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHOUTSUPPORTIDLIST);
    }

    public void setImdlvPurchaseInvoiceDoctypeWithoutSupportIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceDoctypeWithoutSupportIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHOUTSUPPORTIDLIST, imdlvPurchaseInvoiceDoctypeWithoutSupportIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceDoctypeWithholdingIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHHOLDINGIDLIST);
    }

    public void setImdlvPurchaseInvoiceDoctypeWithholdingIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceDoctypeWithholdingIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEWITHHOLDINGIDLIST, imdlvPurchaseInvoiceDoctypeWithholdingIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceCWsdoctypeIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICECWSDOCTYPEIDLIST);
    }

    public void setImdlvPurchaseInvoiceCWsdoctypeIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceCWsdoctypeIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICECWSDOCTYPEIDLIST, imdlvPurchaseInvoiceCWsdoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceCCndoctypeIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICECCNDOCTYPEIDLIST);
    }

    public void setImdlvPurchaseInvoiceCCndoctypeIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceCCndoctypeIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICECCNDOCTYPEIDLIST, imdlvPurchaseInvoiceCCndoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceCCddodctypeIDList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICECCDDODCTYPEIDLIST);
    }

    public void setImdlvPurchaseInvoiceCCddodctypeIDList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceCCddodctypeIDList) {
        set(PROPERTY_IMDLVPURCHASEINVOICECCDDODCTYPEIDLIST, imdlvPurchaseInvoiceCCddodctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceDoctypeOrderList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEORDERLIST);
    }

    public void setImdlvPurchaseInvoiceDoctypeOrderList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceDoctypeOrderList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEORDERLIST, imdlvPurchaseInvoiceDoctypeOrderList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseIinvoice> getImdlvPurchaseInvoiceDoctypeInoutList() {
      return (List<ImdlvPurchaseIinvoice>) get(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEINOUTLIST);
    }

    public void setImdlvPurchaseInvoiceDoctypeInoutList(List<ImdlvPurchaseIinvoice> imdlvPurchaseInvoiceDoctypeInoutList) {
        set(PROPERTY_IMDLVPURCHASEINVOICEDOCTYPEINOUTLIST, imdlvPurchaseInvoiceDoctypeInoutList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvPurchaseimpData> getImdlvPurchaseimpDataList() {
      return (List<ImdlvPurchaseimpData>) get(PROPERTY_IMDLVPURCHASEIMPDATALIST);
    }

    public void setImdlvPurchaseimpDataList(List<ImdlvPurchaseimpData> imdlvPurchaseimpDataList) {
        set(PROPERTY_IMDLVPURCHASEIMPDATALIST, imdlvPurchaseimpDataList);
    }

    @SuppressWarnings("unchecked")
    public List<ImdlvVoucherData> getImdlvVoucherPurchaseList() {
      return (List<ImdlvVoucherData>) get(PROPERTY_IMDLVVOUCHERPURCHASELIST);
    }

    public void setImdlvVoucherPurchaseList(List<ImdlvVoucherData> imdlvVoucherPurchaseList) {
        set(PROPERTY_IMDLVVOUCHERPURCHASELIST, imdlvVoucherPurchaseList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmcase> getOpcrmCasesEMSsccesCDoctypetargetIDList() {
      return (List<Opcrmcase>) get(PROPERTY_OPCRMCASESEMSSCCESCDOCTYPETARGETIDLIST);
    }

    public void setOpcrmCasesEMSsccesCDoctypetargetIDList(List<Opcrmcase> opcrmCasesEMSsccesCDoctypetargetIDList) {
        set(PROPERTY_OPCRMCASESEMSSCCESCDOCTYPETARGETIDLIST, opcrmCasesEMSsccesCDoctypetargetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesEMScmecuDoctypeIDList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESEMSCMECUDOCTYPEIDLIST);
    }

    public void setOpcrmOpportunitiesEMScmecuDoctypeIDList(List<Opcrmopportunities> opcrmOpportunitiesEMScmecuDoctypeIDList) {
        set(PROPERTY_OPCRMOPPORTUNITIESEMSCMECUDOCTYPEIDLIST, opcrmOpportunitiesEMScmecuDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Satmac_Contract> getSatmacContractList() {
      return (List<Satmac_Contract>) get(PROPERTY_SATMACCONTRACTLIST);
    }

    public void setSatmacContractList(List<Satmac_Contract> satmacContractList) {
        set(PROPERTY_SATMACCONTRACTLIST, satmacContractList);
    }

    @SuppressWarnings("unchecked")
    public List<satmac_SOTransferLine> getSatmacSoTransferLineList() {
      return (List<satmac_SOTransferLine>) get(PROPERTY_SATMACSOTRANSFERLINELIST);
    }

    public void setSatmacSoTransferLineList(List<satmac_SOTransferLine> satmacSoTransferLineList) {
        set(PROPERTY_SATMACSOTRANSFERLINELIST, satmacSoTransferLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SbprfFactAcctAggdDoc> getSbprfFactAcctAggdDocList() {
      return (List<SbprfFactAcctAggdDoc>) get(PROPERTY_SBPRFFACTACCTAGGDDOCLIST);
    }

    public void setSbprfFactAcctAggdDocList(List<SbprfFactAcctAggdDoc> sbprfFactAcctAggdDocList) {
        set(PROPERTY_SBPRFFACTACCTAGGDDOCLIST, sbprfFactAcctAggdDocList);
    }

    @SuppressWarnings("unchecked")
    public List<SccrtCardLoadTransaction> getSccrtCardLoadTransactionList() {
      return (List<SccrtCardLoadTransaction>) get(PROPERTY_SCCRTCARDLOADTRANSACTIONLIST);
    }

    public void setSccrtCardLoadTransactionList(List<SccrtCardLoadTransaction> sccrtCardLoadTransactionList) {
        set(PROPERTY_SCCRTCARDLOADTRANSACTIONLIST, sccrtCardLoadTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<ScmfSeasonProduct> getScmfSeasonProductList() {
      return (List<ScmfSeasonProduct>) get(PROPERTY_SCMFSEASONPRODUCTLIST);
    }

    public void setScmfSeasonProductList(List<ScmfSeasonProduct> scmfSeasonProductList) {
        set(PROPERTY_SCMFSEASONPRODUCTLIST, scmfSeasonProductList);
    }

    @SuppressWarnings("unchecked")
    public List<SdcDebitcollect> getSdcDebitcollectList() {
      return (List<SdcDebitcollect>) get(PROPERTY_SDCDEBITCOLLECTLIST);
    }

    public void setSdcDebitcollectList(List<SdcDebitcollect> sdcDebitcollectList) {
        set(PROPERTY_SDCDEBITCOLLECTLIST, sdcDebitcollectList);
    }

    @SuppressWarnings("unchecked")
    public List<SdccDailyClossing> getSdccDailyClossingList() {
      return (List<SdccDailyClossing>) get(PROPERTY_SDCCDAILYCLOSSINGLIST);
    }

    public void setSdccDailyClossingList(List<SdccDailyClossing> sdccDailyClossingList) {
        set(PROPERTY_SDCCDAILYCLOSSINGLIST, sdccDailyClossingList);
    }

    @SuppressWarnings("unchecked")
    public List<SdccDailyClossing> getSdccDailyClossingCDoctypePaymentIDList() {
      return (List<SdccDailyClossing>) get(PROPERTY_SDCCDAILYCLOSSINGCDOCTYPEPAYMENTIDLIST);
    }

    public void setSdccDailyClossingCDoctypePaymentIDList(List<SdccDailyClossing> sdccDailyClossingCDoctypePaymentIDList) {
        set(PROPERTY_SDCCDAILYCLOSSINGCDOCTYPEPAYMENTIDLIST, sdccDailyClossingCDoctypePaymentIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SeactAssetSetup> getSeactAssetSetupList() {
      return (List<SeactAssetSetup>) get(PROPERTY_SEACTASSETSETUPLIST);
    }

    public void setSeactAssetSetupList(List<SeactAssetSetup> seactAssetSetupList) {
        set(PROPERTY_SEACTASSETSETUPLIST, seactAssetSetupList);
    }

    @SuppressWarnings("unchecked")
    public List<SescrTemplateReport> getSescrTemplateReportList() {
      return (List<SescrTemplateReport>) get(PROPERTY_SESCRTEMPLATEREPORTLIST);
    }

    public void setSescrTemplateReportList(List<SescrTemplateReport> sescrTemplateReportList) {
        set(PROPERTY_SESCRTEMPLATEREPORTLIST, sescrTemplateReportList);
    }

    @SuppressWarnings("unchecked")
    public List<sfadt_acc_sequences> getSfadtAccSequencesList() {
      return (List<sfadt_acc_sequences>) get(PROPERTY_SFADTACCSEQUENCESLIST);
    }

    public void setSfadtAccSequencesList(List<sfadt_acc_sequences> sfadtAccSequencesList) {
        set(PROPERTY_SFADTACCSEQUENCESLIST, sfadtAccSequencesList);
    }

    @SuppressWarnings("unchecked")
    public List<SfprMovementType> getSfprMovementTypeList() {
      return (List<SfprMovementType>) get(PROPERTY_SFPRMOVEMENTTYPELIST);
    }

    public void setSfprMovementTypeList(List<SfprMovementType> sfprMovementTypeList) {
        set(PROPERTY_SFPRMOVEMENTTYPELIST, sfprMovementTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<Simppys_PaymentDetail> getSimppysPaymentDetailPaymentDocTypeList() {
      return (List<Simppys_PaymentDetail>) get(PROPERTY_SIMPPYSPAYMENTDETAILPAYMENTDOCTYPELIST);
    }

    public void setSimppysPaymentDetailPaymentDocTypeList(List<Simppys_PaymentDetail> simppysPaymentDetailPaymentDocTypeList) {
        set(PROPERTY_SIMPPYSPAYMENTDETAILPAYMENTDOCTYPELIST, simppysPaymentDetailPaymentDocTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<Simppys_PaymentDataUpload> getSimppysPaymentdatauploadList() {
      return (List<Simppys_PaymentDataUpload>) get(PROPERTY_SIMPPYSPAYMENTDATAUPLOADLIST);
    }

    public void setSimppysPaymentdatauploadList(List<Simppys_PaymentDataUpload> simppysPaymentdatauploadList) {
        set(PROPERTY_SIMPPYSPAYMENTDATAUPLOADLIST, simppysPaymentdatauploadList);
    }

    @SuppressWarnings("unchecked")
    public List<Simpsim_ImportSimulation> getSimpsimImportSimulationList() {
      return (List<Simpsim_ImportSimulation>) get(PROPERTY_SIMPSIMIMPORTSIMULATIONLIST);
    }

    public void setSimpsimImportSimulationList(List<Simpsim_ImportSimulation> simpsimImportSimulationList) {
        set(PROPERTY_SIMPSIMIMPORTSIMULATIONLIST, simpsimImportSimulationList);
    }

    @SuppressWarnings("unchecked")
    public List<SliaInventoryParamsLine> getSliaInvParmlineList() {
      return (List<SliaInventoryParamsLine>) get(PROPERTY_SLIAINVPARMLINELIST);
    }

    public void setSliaInvParmlineList(List<SliaInventoryParamsLine> sliaInvParmlineList) {
        set(PROPERTY_SLIAINVPARMLINELIST, sliaInvParmlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SproctmSettlementCost> getSproctmSettlementCostList() {
      return (List<SproctmSettlementCost>) get(PROPERTY_SPROCTMSETTLEMENTCOSTLIST);
    }

    public void setSproctmSettlementCostList(List<SproctmSettlementCost> sproctmSettlementCostList) {
        set(PROPERTY_SPROCTMSETTLEMENTCOSTLIST, sproctmSettlementCostList);
    }

    @SuppressWarnings("unchecked")
    public List<sprovovertime> getSprovOvertimeList() {
      return (List<sprovovertime>) get(PROPERTY_SPROVOVERTIMELIST);
    }

    public void setSprovOvertimeList(List<sprovovertime> sprovOvertimeList) {
        set(PROPERTY_SPROVOVERTIMELIST, sprovOvertimeList);
    }

    @SuppressWarnings("unchecked")
    public List<SprovPeriod> getSprovPeriodList() {
      return (List<SprovPeriod>) get(PROPERTY_SPROVPERIODLIST);
    }

    public void setSprovPeriodList(List<SprovPeriod> sprovPeriodList) {
        set(PROPERTY_SPROVPERIODLIST, sprovPeriodList);
    }

    @SuppressWarnings("unchecked")
    public List<SSACHModifyAsset> getSsachModifyAssetList() {
      return (List<SSACHModifyAsset>) get(PROPERTY_SSACHMODIFYASSETLIST);
    }

    public void setSsachModifyAssetList(List<SSACHModifyAsset> ssachModifyAssetList) {
        set(PROPERTY_SSACHMODIFYASSETLIST, ssachModifyAssetList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalActiveMain> getSsalActiveMainList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINLIST);
    }

    public void setSsalActiveMainList(List<SsalActiveMain> ssalActiveMainList) {
        set(PROPERTY_SSALACTIVEMAINLIST, ssalActiveMainList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalActiveMain> getSsalActiveMainDoctypeReturnList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINDOCTYPERETURNLIST);
    }

    public void setSsalActiveMainDoctypeReturnList(List<SsalActiveMain> ssalActiveMainDoctypeReturnList) {
        set(PROPERTY_SSALACTIVEMAINDOCTYPERETURNLIST, ssalActiveMainDoctypeReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveCDoctypeIdReturnList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST);
    }

    public void setSsalApplActiveCDoctypeIdReturnList(List<SsalApplActive> ssalApplActiveCDoctypeIdReturnList) {
        set(PROPERTY_SSALAPPLACTIVECDOCTYPEIDRETURNLIST, ssalApplActiveCDoctypeIdReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalAssetReturn> getSsalAssetReturnList() {
      return (List<SsalAssetReturn>) get(PROPERTY_SSALASSETRETURNLIST);
    }

    public void setSsalAssetReturnList(List<SsalAssetReturn> ssalAssetReturnList) {
        set(PROPERTY_SSALASSETRETURNLIST, ssalAssetReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATELIST);
    }

    public void setSsamAlienateList(List<ssamalienate> ssamAlienateList) {
        set(PROPERTY_SSAMALIENATELIST, ssamAlienateList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssapq_AppParamMovil> getSsapqAppParamMovilList() {
      return (List<Ssapq_AppParamMovil>) get(PROPERTY_SSAPQAPPPARAMMOVILLIST);
    }

    public void setSsapqAppParamMovilList(List<Ssapq_AppParamMovil> ssapqAppParamMovilList) {
        set(PROPERTY_SSAPQAPPPARAMMOVILLIST, ssapqAppParamMovilList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFERLIST);
    }

    public void setSsatrAssetTransferList(List<SsatrAssetTransfer> ssatrAssetTransferList) {
        set(PROPERTY_SSATRASSETTRANSFERLIST, ssatrAssetTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<SscccinInvoiceDoctype> getSscccinInvoiceDoctypeCDoctypeSalesIDList() {
      return (List<SscccinInvoiceDoctype>) get(PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPESALESIDLIST);
    }

    public void setSscccinInvoiceDoctypeCDoctypeSalesIDList(List<SscccinInvoiceDoctype> sscccinInvoiceDoctypeCDoctypeSalesIDList) {
        set(PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPESALESIDLIST, sscccinInvoiceDoctypeCDoctypeSalesIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SscccinInvoiceDoctype> getSscccinInvoiceDoctypeCDoctypeCreditNotesIDList() {
      return (List<SscccinInvoiceDoctype>) get(PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPECREDITNOTESIDLIST);
    }

    public void setSscccinInvoiceDoctypeCDoctypeCreditNotesIDList(List<SscccinInvoiceDoctype> sscccinInvoiceDoctypeCDoctypeCreditNotesIDList) {
        set(PROPERTY_SSCCCININVOICEDOCTYPECDOCTYPECREDITNOTESIDLIST, sscccinInvoiceDoctypeCDoctypeCreditNotesIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SscccinInvoiceDoctype> getSscccinInvoiceDoctypeDocumentCancelledList() {
      return (List<SscccinInvoiceDoctype>) get(PROPERTY_SSCCCININVOICEDOCTYPEDOCUMENTCANCELLEDLIST);
    }

    public void setSscccinInvoiceDoctypeDocumentCancelledList(List<SscccinInvoiceDoctype> sscccinInvoiceDoctypeDocumentCancelledList) {
        set(PROPERTY_SSCCCININVOICEDOCTYPEDOCUMENTCANCELLEDLIST, sscccinInvoiceDoctypeDocumentCancelledList);
    }

    @SuppressWarnings("unchecked")
    public List<SscflwExpensivePayoutView> getSscflwExpensivePayoutVList() {
      return (List<SscflwExpensivePayoutView>) get(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST);
    }

    public void setSscflwExpensivePayoutVList(List<SscflwExpensivePayoutView> sscflwExpensivePayoutVList) {
        set(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, sscflwExpensivePayoutVList);
    }

    @SuppressWarnings("unchecked")
    public List<sscprreportcertificate> getSscprReportcertificateList() {
      return (List<sscprreportcertificate>) get(PROPERTY_SSCPRREPORTCERTIFICATELIST);
    }

    public void setSscprReportcertificateList(List<sscprreportcertificate> sscprReportcertificateList) {
        set(PROPERTY_SSCPRREPORTCERTIFICATELIST, sscprReportcertificateList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctcontract> getSsctContractList() {
      return (List<ssctcontract>) get(PROPERTY_SSCTCONTRACTLIST);
    }

    public void setSsctContractList(List<ssctcontract> ssctContractList) {
        set(PROPERTY_SSCTCONTRACTLIST, ssctContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidPayment> getSsdnidPaymentList() {
      return (List<SsdnidPayment>) get(PROPERTY_SSDNIDPAYMENTLIST);
    }

    public void setSsdnidPaymentList(List<SsdnidPayment> ssdnidPaymentList) {
        set(PROPERTY_SSDNIDPAYMENTLIST, ssdnidPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiFinancialUser> getSsfiFinancialUserList() {
      return (List<SsfiFinancialUser>) get(PROPERTY_SSFIFINANCIALUSERLIST);
    }

    public void setSsfiFinancialUserList(List<SsfiFinancialUser> ssfiFinancialUserList) {
        set(PROPERTY_SSFIFINANCIALUSERLIST, ssfiFinancialUserList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImpConsolDetail> getSsimpcnImpConsolDetailList() {
      return (List<Ssimpcn_ImpConsolDetail>) get(PROPERTY_SSIMPCNIMPCONSOLDETAILLIST);
    }

    public void setSsimpcnImpConsolDetailList(List<Ssimpcn_ImpConsolDetail> ssimpcnImpConsolDetailList) {
        set(PROPERTY_SSIMPCNIMPCONSOLDETAILLIST, ssimpcnImpConsolDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImpConsolidation> getSsimpcnImpConsolidationList() {
      return (List<Ssimpcn_ImpConsolidation>) get(PROPERTY_SSIMPCNIMPCONSOLIDATIONLIST);
    }

    public void setSsimpcnImpConsolidationList(List<Ssimpcn_ImpConsolidation> ssimpcnImpConsolidationList) {
        set(PROPERTY_SSIMPCNIMPCONSOLIDATIONLIST, ssimpcnImpConsolidationList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssimpcn_ImportationCost> getSsimpcnImportationCostList() {
      return (List<Ssimpcn_ImportationCost>) get(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST);
    }

    public void setSsimpcnImportationCostList(List<Ssimpcn_ImportationCost> ssimpcnImportationCostList) {
        set(PROPERTY_SSIMPCNIMPORTATIONCOSTLIST, ssimpcnImportationCostList);
    }

    @SuppressWarnings("unchecked")
    public List<SsipdvDocumentType> getSsipdvDoctypeList() {
      return (List<SsipdvDocumentType>) get(PROPERTY_SSIPDVDOCTYPELIST);
    }

    public void setSsipdvDoctypeList(List<SsipdvDocumentType> ssipdvDoctypeList) {
        set(PROPERTY_SSIPDVDOCTYPELIST, ssipdvDoctypeList);
    }

    @SuppressWarnings("unchecked")
    public List<SsipiceRateIce> getSsipiceRateIceList() {
      return (List<SsipiceRateIce>) get(PROPERTY_SSIPICERATEICELIST);
    }

    public void setSsipiceRateIceList(List<SsipiceRateIce> ssipiceRateIceList) {
        set(PROPERTY_SSIPICERATEICELIST, ssipiceRateIceList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_Config> getSsipotmConfigInoutDoctypeIDList() {
      return (List<Ssipotm_Config>) get(PROPERTY_SSIPOTMCONFIGINOUTDOCTYPEIDLIST);
    }

    public void setSsipotmConfigInoutDoctypeIDList(List<Ssipotm_Config> ssipotmConfigInoutDoctypeIDList) {
        set(PROPERTY_SSIPOTMCONFIGINOUTDOCTYPEIDLIST, ssipotmConfigInoutDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_Config> getSsipotmConfigInvoiceDoctypeIDList() {
      return (List<Ssipotm_Config>) get(PROPERTY_SSIPOTMCONFIGINVOICEDOCTYPEIDLIST);
    }

    public void setSsipotmConfigInvoiceDoctypeIDList(List<Ssipotm_Config> ssipotmConfigInvoiceDoctypeIDList) {
        set(PROPERTY_SSIPOTMCONFIGINVOICEDOCTYPEIDLIST, ssipotmConfigInvoiceDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_PartialDispatch> getSsipotmPartialDispatchList() {
      return (List<Ssipotm_PartialDispatch>) get(PROPERTY_SSIPOTMPARTIALDISPATCHLIST);
    }

    public void setSsipotmPartialDispatchList(List<Ssipotm_PartialDispatch> ssipotmPartialDispatchList) {
        set(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, ssipotmPartialDispatchList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmrpsAsimulationProd> getSsmrpsAsimulationProdList() {
      return (List<SsmrpsAsimulationProd>) get(PROPERTY_SSMRPSASIMULATIONPRODLIST);
    }

    public void setSsmrpsAsimulationProdList(List<SsmrpsAsimulationProd> ssmrpsAsimulationProdList) {
        set(PROPERTY_SSMRPSASIMULATIONPRODLIST, ssmrpsAsimulationProdList);
    }

    @SuppressWarnings("unchecked")
    public List<ssorel_invoiceorder_v> getSsorelInvoiceorderVList() {
      return (List<ssorel_invoiceorder_v>) get(PROPERTY_SSORELINVOICEORDERVLIST);
    }

    public void setSsorelInvoiceorderVList(List<ssorel_invoiceorder_v> ssorelInvoiceorderVList) {
        set(PROPERTY_SSORELINVOICEORDERVLIST, ssorelInvoiceorderVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssorel_invoiceorder_v> getSsorelInvoiceorderVTransactionDocumentList() {
      return (List<ssorel_invoiceorder_v>) get(PROPERTY_SSORELINVOICEORDERVTRANSACTIONDOCUMENTLIST);
    }

    public void setSsorelInvoiceorderVTransactionDocumentList(List<ssorel_invoiceorder_v> ssorelInvoiceorderVTransactionDocumentList) {
        set(PROPERTY_SSORELINVOICEORDERVTRANSACTIONDOCUMENTLIST, ssorelInvoiceorderVTransactionDocumentList);
    }

    @SuppressWarnings("unchecked")
    public List<ImportProductPl> getSspimplImportProductPlList() {
      return (List<ImportProductPl>) get(PROPERTY_SSPIMPLIMPORTPRODUCTPLLIST);
    }

    public void setSspimplImportProductPlList(List<ImportProductPl> sspimplImportProductPlList) {
        set(PROPERTY_SSPIMPLIMPORTPRODUCTPLLIST, sspimplImportProductPlList);
    }

    @SuppressWarnings("unchecked")
    public List<SsppinvSetting> getSsppinvSettingList() {
      return (List<SsppinvSetting>) get(PROPERTY_SSPPINVSETTINGLIST);
    }

    public void setSsppinvSettingList(List<SsppinvSetting> ssppinvSettingList) {
        set(PROPERTY_SSPPINVSETTINGLIST, ssppinvSettingList);
    }

    @SuppressWarnings("unchecked")
    public List<SsppinvSetting> getSsppinvSettingPaymentDoctypeIDList() {
      return (List<SsppinvSetting>) get(PROPERTY_SSPPINVSETTINGPAYMENTDOCTYPEIDLIST);
    }

    public void setSsppinvSettingPaymentDoctypeIDList(List<SsppinvSetting> ssppinvSettingPaymentDoctypeIDList) {
        set(PROPERTY_SSPPINVSETTINGPAYMENTDOCTYPEIDLIST, ssppinvSettingPaymentDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<sspremployeesettlement> getSsprEmployeesettlementList() {
      return (List<sspremployeesettlement>) get(PROPERTY_SSPREMPLOYEESETTLEMENTLIST);
    }

    public void setSsprEmployeesettlementList(List<sspremployeesettlement> ssprEmployeesettlementList) {
        set(PROPERTY_SSPREMPLOYEESETTLEMENTLIST, ssprEmployeesettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprloans> getSsprLoansEMSfprCDoctypeIDList() {
      return (List<ssprloans>) get(PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST);
    }

    public void setSsprLoansEMSfprCDoctypeIDList(List<ssprloans> ssprLoansEMSfprCDoctypeIDList) {
        set(PROPERTY_SSPRLOANSEMSFPRCDOCTYPEIDLIST, ssprLoansEMSfprCDoctypeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Sspr_OtherTaxIncome> getSsprOtherTaxIncomeList() {
      return (List<Sspr_OtherTaxIncome>) get(PROPERTY_SSPROTHERTAXINCOMELIST);
    }

    public void setSsprOtherTaxIncomeList(List<Sspr_OtherTaxIncome> ssprOtherTaxIncomeList) {
        set(PROPERTY_SSPROTHERTAXINCOMELIST, ssprOtherTaxIncomeList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollpayment> getSsprPayrollpaymentList() {
      return (List<ssprpayrollpayment>) get(PROPERTY_SSPRPAYROLLPAYMENTLIST);
    }

    public void setSsprPayrollpaymentList(List<ssprpayrollpayment> ssprPayrollpaymentList) {
        set(PROPERTY_SSPRPAYROLLPAYMENTLIST, ssprPayrollpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<sspr_settlement> getSsprSettlementList() {
      return (List<sspr_settlement>) get(PROPERTY_SSPRSETTLEMENTLIST);
    }

    public void setSsprSettlementList(List<sspr_settlement> ssprSettlementList) {
        set(PROPERTY_SSPRSETTLEMENTLIST, ssprSettlementList);
    }

    @SuppressWarnings("unchecked")
    public List<SssoinDatesalesprocessV> getSssoinDatesalesprocessVCDoctypetargetIDList() {
      return (List<SssoinDatesalesprocessV>) get(PROPERTY_SSSOINDATESALESPROCESSVCDOCTYPETARGETIDLIST);
    }

    public void setSssoinDatesalesprocessVCDoctypetargetIDList(List<SssoinDatesalesprocessV> sssoinDatesalesprocessVCDoctypetargetIDList) {
        set(PROPERTY_SSSOINDATESALESPROCESSVCDOCTYPETARGETIDLIST, sssoinDatesalesprocessVCDoctypetargetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcLiquidationProjectsInvoiceView> getSstpcLiqPrjInvVList() {
      return (List<SstpcLiquidationProjectsInvoiceView>) get(PROPERTY_SSTPCLIQPRJINVVLIST);
    }

    public void setSstpcLiqPrjInvVList(List<SstpcLiquidationProjectsInvoiceView> sstpcLiqPrjInvVList) {
        set(PROPERTY_SSTPCLIQPRJINVVLIST, sstpcLiqPrjInvVList);
    }

    @SuppressWarnings("unchecked")
    public List<LiquidationProjects> getSstpcLiquidationProjectsList() {
      return (List<LiquidationProjects>) get(PROPERTY_SSTPCLIQUIDATIONPROJECTSLIST);
    }

    public void setSstpcLiquidationProjectsList(List<LiquidationProjects> sstpcLiquidationProjectsList) {
        set(PROPERTY_SSTPCLIQUIDATIONPROJECTSLIST, sstpcLiquidationProjectsList);
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
    public List<SstpcPaymentLiqView> getSstpcPaymentLiqVList() {
      return (List<SstpcPaymentLiqView>) get(PROPERTY_SSTPCPAYMENTLIQVLIST);
    }

    public void setSstpcPaymentLiqVList(List<SstpcPaymentLiqView> sstpcPaymentLiqVList) {
        set(PROPERTY_SSTPCPAYMENTLIQVLIST, sstpcPaymentLiqVList);
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
    public List<SstpcRelatedRevenue> getSstpcRelatedRevenueList() {
      return (List<SstpcRelatedRevenue>) get(PROPERTY_SSTPCRELATEDREVENUELIST);
    }

    public void setSstpcRelatedRevenueList(List<SstpcRelatedRevenue> sstpcRelatedRevenueList) {
        set(PROPERTY_SSTPCRELATEDREVENUELIST, sstpcRelatedRevenueList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrder> getSswclWorkOrderVList() {
      return (List<SSWCLWorkOrder>) get(PROPERTY_SSWCLWORKORDERVLIST);
    }

    public void setSswclWorkOrderVList(List<SSWCLWorkOrder> sswclWorkOrderVList) {
        set(PROPERTY_SSWCLWORKORDERVLIST, sswclWorkOrderVList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWCLWorkOrder> getSswclWorkOrderVSswosCDoctypetargetsIDList() {
      return (List<SSWCLWorkOrder>) get(PROPERTY_SSWCLWORKORDERVSSWOSCDOCTYPETARGETSIDLIST);
    }

    public void setSswclWorkOrderVSswosCDoctypetargetsIDList(List<SSWCLWorkOrder> sswclWorkOrderVSswosCDoctypetargetsIDList) {
        set(PROPERTY_SSWCLWORKORDERVSSWOSCDOCTYPETARGETSIDLIST, sswclWorkOrderVSswosCDoctypetargetsIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsspidSalesTickets> getSswhSalesticketsList() {
      return (List<CsspidSalesTickets>) get(PROPERTY_SSWHSALESTICKETSLIST);
    }

    public void setSswhSalesticketsList(List<CsspidSalesTickets> sswhSalesticketsList) {
        set(PROPERTY_SSWHSALESTICKETSLIST, sswhSalesticketsList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithhCardCredit> getSswhWithhCardCreditList() {
      return (List<SswhWithhCardCredit>) get(PROPERTY_SSWHWITHHCARDCREDITLIST);
    }

    public void setSswhWithhCardCreditList(List<SswhWithhCardCredit> sswhWithhCardCreditList) {
        set(PROPERTY_SSWHWITHHCARDCREDITLIST, sswhWithhCardCreditList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithholdingsVoided> getSswhWithholdingsVoidedList() {
      return (List<SswhWithholdingsVoided>) get(PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST);
    }

    public void setSswhWithholdingsVoidedList(List<SswhWithholdingsVoided> sswhWithholdingsVoidedList) {
        set(PROPERTY_SSWHWITHHOLDINGSVOIDEDLIST, sswhWithholdingsVoidedList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhWithholdingsVoided> getSswhWithholdingsVoidedCDoctype2IDList() {
      return (List<SswhWithholdingsVoided>) get(PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST);
    }

    public void setSswhWithholdingsVoidedCDoctype2IDList(List<SswhWithholdingsVoided> sswhWithholdingsVoidedCDoctype2IDList) {
        set(PROPERTY_SSWHWITHHOLDINGSVOIDEDCDOCTYPE2IDLIST, sswhWithholdingsVoidedCDoctype2IDList);
    }

    @SuppressWarnings("unchecked")
    public List<UpdatePriceWO> getSswoupUpdatePriceWoList() {
      return (List<UpdatePriceWO>) get(PROPERTY_SSWOUPUPDATEPRICEWOLIST);
    }

    public void setSswoupUpdatePriceWoList(List<UpdatePriceWO> sswoupUpdatePriceWoList) {
        set(PROPERTY_SSWOUPUPDATEPRICEWOLIST, sswoupUpdatePriceWoList);
    }

    @SuppressWarnings("unchecked")
    public List<SswsAdvancePayment> getSswsAdvancePaymentList() {
      return (List<SswsAdvancePayment>) get(PROPERTY_SSWSADVANCEPAYMENTLIST);
    }

    public void setSswsAdvancePaymentList(List<SswsAdvancePayment> sswsAdvancePaymentList) {
        set(PROPERTY_SSWSADVANCEPAYMENTLIST, sswsAdvancePaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<swblConfig> getSwblConfigList() {
      return (List<swblConfig>) get(PROPERTY_SWBLCONFIGLIST);
    }

    public void setSwblConfigList(List<swblConfig> swblConfigList) {
        set(PROPERTY_SWBLCONFIGLIST, swblConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSPCConfig> getSwspcConfigList() {
      return (List<SWSPCConfig>) get(PROPERTY_SWSPCCONFIGLIST);
    }

    public void setSwspcConfigList(List<SWSPCConfig> swspcConfigList) {
        set(PROPERTY_SWSPCCONFIGLIST, swspcConfigList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSPCConfig> getSwspcConfigCDoctypePaymentInIDList() {
      return (List<SWSPCConfig>) get(PROPERTY_SWSPCCONFIGCDOCTYPEPAYMENTINIDLIST);
    }

    public void setSwspcConfigCDoctypePaymentInIDList(List<SWSPCConfig> swspcConfigCDoctypePaymentInIDList) {
        set(PROPERTY_SWSPCCONFIGCDOCTYPEPAYMENTINIDLIST, swspcConfigCDoctypePaymentInIDList);
    }

}
