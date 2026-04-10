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

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import com.sidesoft.ecuador.asset.move.ssamalienateline;
import com.sidesoft.localization.ecuador.finances.SsfiInvoiceSummaryV;
import com.sidesoft.localization.ecuador.finances.ssfiFin_payment_detail_v;
import com.sidesoft.localization.ecuador.refunds.ssrerefund;
import com.sidesoft.localization.ecuador.refunds.ssrerefundinvoice;
import com.sidesoft.localization.ecuador.withholdings.CsspidSalesTickets;
import com.sidesoft.localization.ecuador.withholdings.Receipt;
import com.sidesoft.localization.ecuador.withholdings.SSWHCheckbookposLine;
import com.sidesoft.localization.ecuador.withholdings.SSWHCodelivelihoodt;
import com.sidesoft.localization.ecuador.withholdings.SSWHLivelihoodt;
import com.sidesoft.localization.ecuador.withholdings.SswhDcNote;
import com.sidesoft.localization.ecuador.withholdings.SswhInvoiceExportation;
import com.sidesoft.localization.ecuador.withholdings.SswhRptcPurchaseDetail;
import com.sidesoft.localization.ecuador.withholdings.SswhRptcSalesRefund;
import com.sidesoft.localization.ecuador.withholdings.SswhWithhCardCredit;

import ec.com.sidesoft.cash.flow.SscflwExpensivePayoutView;
import ec.com.sidesoft.contract.ssctpayment;
import ec.com.sidesoft.creditcard.reconciliation.SsccrFinaccTransV;
import ec.com.sidesoft.creditcard.reconciliation.SsccrPosCardRecLine;
import ec.com.sidesoft.creditcard.reconciliation.Ssccr_CardRecDetailV;
import ec.com.sidesoft.daily.closing.charge.Sdcc_DailyClossingLine;
import ec.com.sidesoft.debitnote.interest.due.SsdnidPendingInterest;
import ec.com.sidesoft.discount.quota.salesinvoices.QuotaDetailLine;
import ec.com.sidesoft.distribute.costcenter.SsdccpDistributeCostCenter;
import ec.com.sidesoft.facturaec.test.ProcessFETest;
import ec.com.sidesoft.importdata.payments.Simppys_PaymentDetail;
import ec.com.sidesoft.inventory.partial.out.movement.Ssipotm_PartialDispatch;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.localization.importdata.loadvouchers.Imdlv_Lines;
import ec.com.sidesoft.localization.withholding.control.withholdingcancel;
import ec.com.sidesoft.modify.accounting.SsmaactModifyAcct;
import ec.com.sidesoft.payment.in.transit.SspitraCtDetail;
import ec.com.sidesoft.payment.plan.info.SSPI_PaymentSchedOrdV;
import ec.com.sidesoft.pending.purchase.invoice.SsppinvSelectedInvoices;
import ec.com.sidesoft.postdated.check.SspchInvoice;
import ec.com.sidesoft.postdated.check.SspchPaymentPlan;
import ec.com.sidesoft.report.salesinvoice.SRSISalesInvoiceV;
import ec.com.sidesoft.saleorder.relations.ssorel_invoiceorder_v;
import ec.com.sidesoft.settlement.project.cost.SstpcRelatedRevenue;
import ec.com.sidesoft.workorder.simplified.SswosVehicle;
import ec.com.sidesoft.ws.paymentscreate.SWSPCLogs;
import ec.cusoft.facturaec.Contingency;
import ec.cusoft.facturaec.EEIInvoiceLog;
import ec.cusoft.facturaec.EeiPaymentDetailV;
import ec.cusoft.facturaec.eeiviewinvoice;
import ec.cusoft.refund.eeirRefund;

import it.openia.crm.Opcrminvoice;
import it.openia.crm.Opcrmopportunities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRMPendingPaymentFromInvoice;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.InvoiceLineTax;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BankAccount;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.ConversionRateDoc;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.gl.GLCharge;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.DebtPaymentCancelV;
import org.openbravo.model.financialmgmt.payment.DebtPaymentGenerateV;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedInvV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedOrdV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.Fin_OrigPaymentSchedule;
import org.openbravo.model.financialmgmt.payment.PaymentPriority;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.pricing.volumediscount.DiscountInvoice;
import org.openbravo.model.project.Project;
import org.openbravo.model.sales.CommissionRun;
import org.openbravo.model.shipping.ShippingCompany;
/**
 * Entity class for entity Invoice (stored in table C_Invoice).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Invoice extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Invoice";
    public static final String ENTITY_NAME = "Invoice";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SALESTRANSACTION = "salesTransaction";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_DOCUMENTSTATUS = "documentStatus";
    public static final String PROPERTY_DOCUMENTACTION = "documentAction";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_POSTED = "posted";
    public static final String PROPERTY_DOCUMENTTYPE = "documentType";
    public static final String PROPERTY_TRANSACTIONDOCUMENT = "transactionDocument";
    public static final String PROPERTY_SALESORDER = "salesOrder";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_PRINT = "print";
    public static final String PROPERTY_SALESREPRESENTATIVE = "salesRepresentative";
    public static final String PROPERTY_INVOICEDATE = "invoiceDate";
    public static final String PROPERTY_DATEPRINTED = "datePrinted";
    public static final String PROPERTY_ACCOUNTINGDATE = "accountingDate";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_ORDERREFERENCE = "orderReference";
    public static final String PROPERTY_PRINTDISCOUNT = "printDiscount";
    public static final String PROPERTY_ORDERDATE = "orderDate";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_FORMOFPAYMENT = "formOfPayment";
    public static final String PROPERTY_PAYMENTTERMS = "paymentTerms";
    public static final String PROPERTY_CHARGE = "charge";
    public static final String PROPERTY_CHARGEAMOUNT = "chargeAmount";
    public static final String PROPERTY_SUMMEDLINEAMOUNT = "summedLineAmount";
    public static final String PROPERTY_GRANDTOTALAMOUNT = "grandTotalAmount";
    public static final String PROPERTY_PRICELIST = "priceList";
    public static final String PROPERTY_PRICEINCLUDESTAX = "priceIncludesTax";
    public static final String PROPERTY_SALESCAMPAIGN = "salesCampaign";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_ACTIVITY = "activity";
    public static final String PROPERTY_CREATELINESFROM = "createLinesFrom";
    public static final String PROPERTY_GENERATETO = "generateTo";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_COPYFROM = "copyFrom";
    public static final String PROPERTY_SELFSERVICE = "selfService";
    public static final String PROPERTY_TRXORGANIZATION = "trxOrganization";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_WITHHOLDINGAMOUNT = "withholdingamount";
    public static final String PROPERTY_TAXDATE = "taxDate";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_PAYMENTCOMPLETE = "paymentComplete";
    public static final String PROPERTY_TOTALPAID = "totalPaid";
    public static final String PROPERTY_OUTSTANDINGAMOUNT = "outstandingAmount";
    public static final String PROPERTY_DAYSTILLDUE = "daysTillDue";
    public static final String PROPERTY_DUEAMOUNT = "dueAmount";
    public static final String PROPERTY_LASTCALCULATEDONDATE = "lastCalculatedOnDate";
    public static final String PROPERTY_UPDATEPAYMENTMONITOR = "updatePaymentMonitor";
    public static final String PROPERTY_PAYMENTMETHOD = "paymentMethod";
    public static final String PROPERTY_FINPAYMENTPRIORITY = "fINPaymentPriority";
    public static final String PROPERTY_FINALSETTLEMENTDATE = "finalSettlementDate";
    public static final String PROPERTY_DAYSSALESOUTSTANDING = "daysSalesOutstanding";
    public static final String PROPERTY_PERCENTAGEOVERDUE = "percentageOverdue";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_APRMADDPAYMENT = "aPRMAddpayment";
    public static final String PROPERTY_CALCULATEPROMOTIONS = "calculatePromotions";
    public static final String PROPERTY_APRMPROCESSINVOICE = "aPRMProcessinvoice";
    public static final String PROPERTY_ASSET = "asset";
    public static final String PROPERTY_CASHVAT = "cashVAT";
    public static final String PROPERTY_SSRELOCKDATE = "ssreLockdate";
    public static final String PROPERTY_SSRECBPARTNER = "ssreCBpartner";
    public static final String PROPERTY_SCNRISREFINV = "scnrIsrefInv";
    public static final String PROPERTY_SSREISREFUNDED = "ssreIsrefunded";
    public static final String PROPERTY_SCNRINVOICE = "scnrInvoice";
    public static final String PROPERTY_SSREREFUNDED = "ssreRefunded";
    public static final String PROPERTY_SSREISREFUND = "ssreIsrefund";
    public static final String PROPERTY_ATINDPOGENOS = "atindpoGenOs";
    public static final String PROPERTY_ATINDPOPOSTVENTA = "atindpoPostventa";
    public static final String PROPERTY_PREPAYMENTAMT = "prepaymentamt";
    public static final String PROPERTY_SSWHTOTALWITHHOLDINGINCOME = "sswhTotalwithholdingincome";
    public static final String PROPERTY_SSWHTOTALWITHHOLDINGVAT = "sswhTotalwithholdingvat";
    public static final String PROPERTY_SSWHRECEIPT = "sswhReceipt";
    public static final String PROPERTY_SSWHNROAUTHORIZATION = "sswhNroauthorization";
    public static final String PROPERTY_SSWHEXPIRATIONDATE = "sswhExpirationdate";
    public static final String PROPERTY_SSWHLIVELIHOOD = "sswhLivelihood";
    public static final String PROPERTY_SSWHCODELIVELIHOOD = "sswhCodelivelihood";
    public static final String PROPERTY_SSWHWITHHOLDINGREF = "sswhWithholdingref";
    public static final String PROPERTY_SSWHAUTHORIZATION = "sswhAuthorization";
    public static final String PROPERTY_SSWHDATEWITHHOLD = "sswhDatewithhold";
    public static final String PROPERTY_SSWHCREDITNOTE = "sswhCreditnote";
    public static final String PROPERTY_SSWHDATEENDINVOICE = "sswhDateendinvoice";
    public static final String PROPERTY_SSWHINVOICEREF = "sswhInvoiceRef";
    public static final String PROPERTY_SSWHKEYEI = "sswhKeyei";
    public static final String PROPERTY_SSWHISEINVOICE = "sswhIseinvoice";
    public static final String PROPERTY_SSWHCDOCTYPE = "sswhCDoctype";
    public static final String PROPERTY_SSWHBANKACCOUNT = "sswhBankaccount";
    public static final String PROPERTY_SSWHWITHHOLDINGMANUAL = "sswhWithholdingmanual";
    public static final String PROPERTY_EEICODIGO = "eeiCodigo";
    public static final String PROPERTY_EEINUMAUTO = "eeiNumauto";
    public static final String PROPERTY_EEIFECHAAUTO = "eeiFechaauto";
    public static final String PROPERTY_SSWHAUTHORIZATIONMANUAL = "sswhAuthorizationmanual";
    public static final String PROPERTY_EEIFECHAAUTOTEXT = "eeiFechaautotext";
    public static final String PROPERTY_EEIGENERATED = "eeiGenerated";
    public static final String PROPERTY_EEISENT = "eeiSent";
    public static final String PROPERTY_EEIEDOCUMENT = "eeiEdocument";
    public static final String PROPERTY_EEIRSIAUTHNO = "eeiRsiAuthNo";
    public static final String PROPERTY_EEICREDITNOTE = "eeiCreditnote";
    public static final String PROPERTY_EEIISINVREF = "eeiIsInvRef";
    public static final String PROPERTY_EEIREFINV = "eeiRefInv";
    public static final String PROPERTY_EEIDEBITNOTE = "eeiDebitnote";
    public static final String PROPERTY_EEIWITHHOLDINGSEND = "eeiWithholdingSend";
    public static final String PROPERTY_EEIURLXML = "eeiUrlxml";
    public static final String PROPERTY_EEIURLRIDE = "eeiUrlride";
    public static final String PROPERTY_EEISTATUS = "eeiStatus";
    public static final String PROPERTY_EEITEMPORALSEND = "eeiTemporalsend";
    public static final String PROPERTY_EEIRESENDINVOICE = "eeiResendInvoice";
    public static final String PROPERTY_SDINLAWSUIT = "sdinLawsuit";
    public static final String PROPERTY_EEIGENERATEOFFLINE = "eeiGenerateOffline";
    public static final String PROPERTY_EEIDESCRIPTION = "eeiDescription";
    public static final String PROPERTY_SSTPCLIQUIDATE = "sstpcLiquidate";
    public static final String PROPERTY_SSTPCISLIQUIDATION = "sstpcIsliquidation";
    public static final String PROPERTY_SSRELOCKEDBY = "ssreLockedby";
    public static final String PROPERTY_SPEVPROCESSED = "spevProcessed";
    public static final String PROPERTY_SPINCOTAXID = "spincoTaxid";
    public static final String PROPERTY_EEISTATUS2 = "eeiStatus2";
    public static final String PROPERTY_SLCISHIPPER = "slciShipper";
    public static final String PROPERTY_EEICODIGO2 = "eeiCodigo2";
    public static final String PROPERTY_EEIURLXML2 = "eeiUrlxml2";
    public static final String PROPERTY_EEIURLRIDE2 = "eeiUrlride2";
    public static final String PROPERTY_EEINUMAUTO2 = "eeiNumauto2";
    public static final String PROPERTY_EEIFECHAAUTOTEXT2 = "eeiFechaautotext2";
    public static final String PROPERTY_EEIGENERATEOFFLINE2 = "eeiGenerateOffline2";
    public static final String PROPERTY_EEIRESENDINVOICE2 = "eeiResendinvoice2";
    public static final String PROPERTY_IMDLVLOADLINESAUTH = "imdlvLoadLinesAuth";
    public static final String PROPERTY_SFPSIRECONCILE = "sfpsiReconcile";
    public static final String PROPERTY_SSORELREFINV = "ssorelRefinv";
    public static final String PROPERTY_SSWONSENTEMAIL = "sswonSentEmail";
    public static final String PROPERTY_SSORELISRETURN = "ssorelIsreturn";
    public static final String PROPERTY_SPDNDOCUMENTNO = "spdnDocumentno";
    public static final String PROPERTY_SSTTDEFDEFERREDCROSS = "ssttdefDeferredCross";
    public static final String PROPERTY_SSTTDEFCROSSINGDATE = "ssttdefCrossingDate";
    public static final String PROPERTY_EEIVOUCHERCODE = "eeiVoucherCode";
    public static final String PROPERTY_SSWHDIVIDENDYEAR = "sswhDividendYear";
    public static final String PROPERTY_EEIVOUCHERDATE = "eeiVoucherDate";
    public static final String PROPERTY_SSDCCPDISTCOSTCENTER = "ssdccpDistcostcenter";
    public static final String PROPERTY_EEIINVOICENUM = "eeiInvoiceNum";
    public static final String PROPERTY_SSSOINCOMPLETED = "sssoinCompleted";
    public static final String PROPERTY_SSSOINCOMPLETEDBY = "sssoinCompletedby";
    public static final String PROPERTY_SLOSPCUUNLOCKPOSTED = "slospcuUnlockPosted";
    public static final String PROPERTY_SCNSAGENERATENC = "scnsaGeneratenc";
    public static final String PROPERTY_CSDFBPDISTCOSTCENTER = "csdfbpDistcostcenter";
    public static final String PROPERTY_SSWHCREDITNOTEREFERENCE = "sswhCreditnotereference";
    public static final String PROPERTY__COMPUTEDCOLUMNS = "_computedColumns";
    public static final String PROPERTY_APRMPENDINGPAYMENTINVOICELIST = "aPRMPendingPaymentInvoiceList";
    public static final String PROPERTY_INVOICETAXCASHVATVLIST = "invoiceTaxCashVATVList";
    public static final String PROPERTY_CURRENCYCONVERSIONRATEDOCLIST = "currencyConversionRateDocList";
    public static final String PROPERTY_EEIRREFUNDLIST = "eEIRRefundList";
    public static final String PROPERTY_EEIRREFUNDEEIRINVOICEIDLIST = "eEIRRefundEeirInvoiceIDList";
    public static final String PROPERTY_EEICONTINGENCYLIST = "eEIContingencyList";
    public static final String PROPERTY_EEIINVOICELOGLIST = "eEIInvoicelogList";
    public static final String PROPERTY_FINFINACCTRANSACTIONEMSSCCRCINVOICEIDLIST = "fINFinaccTransactionEMSsccrCInvoiceIDList";
    public static final String PROPERTY_FINPAYMENTSCHEDINVVLIST = "fINPaymentSchedInvVList";
    public static final String PROPERTY_FINPAYMENTSCHEDORDVLIST = "fINPaymentSchedOrdVList";
    public static final String PROPERTY_FINPAYMENTSCHEDULELIST = "fINPaymentScheduleList";
    public static final String PROPERTY_FINORIGPAYMENTSCHEDULELIST = "finOrigPaymentScheduleList";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSAPIINVOICEIDLIST = "financialMgmtAssetEMSsapiInvoiceIDList";
    public static final String PROPERTY_FINANCIALMGMTASSETEMSSACINVOICEIDLIST = "financialMgmtAssetEMSsacInvoiceIDList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST = "financialMgmtDebtPaymentList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST = "financialMgmtDebtPaymentCancelVList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST = "financialMgmtDebtPaymentGenerateVList";
    public static final String PROPERTY_INVOICEEMSCNRINVOICEIDLIST = "invoiceEMScnrInvoiceIDList";
    public static final String PROPERTY_INVOICEEMSSWHINVOICEREFLIST = "invoiceEMSswhInvoiceRefList";
    public static final String PROPERTY_INVOICEEMEEIREFINVIDLIST = "invoiceEMEeiRefInvIDList";
    public static final String PROPERTY_INVOICEEMSSWHCREDITNOTEREFERENCELIST = "invoiceEmSswhCreditnotereferenceList";
    public static final String PROPERTY_INVOICEDISCOUNTLIST = "invoiceDiscountList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEEMSSREREFUNDEDINVOICEREFIDLIST = "invoiceLineEMSsreRefundedinvoiceRefIDList";
    public static final String PROPERTY_INVOICELINETAXLIST = "invoiceLineTaxList";
    public static final String PROPERTY_INVOICELINEV2LIST = "invoiceLineV2List";
    public static final String PROPERTY_INVOICETAXLIST = "invoiceTaxList";
    public static final String PROPERTY_INVOICEV2LIST = "invoiceV2List";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPINLCINVOICEIDLIST = "materialMgmtProductionTransactionEMSpinlCInvoiceIDList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_ORDEREMSICUSINVOICETORETURNLIST = "orderEMSICUSInvoiceToReturnList";
    public static final String PROPERTY_PRICINGVOLUMEDISCOUNTINVOICELIST = "pricingVolumeDiscountInvoiceList";
    public static final String PROPERTY_REVERSEDINVOICESLIST = "reversedInvoicesList";
    public static final String PROPERTY_REVERSEDINVOICESREVERSEDINVOICELIST = "reversedInvoicesReversedInvoiceList";
    public static final String PROPERTY_SRSISALESINVOICEVLIST = "sRSISalesInvoiceVList";
    public static final String PROPERTY_SSDQSIQUOTADETAILLINELIST = "sSDQSIQuotaDetailLineList";
    public static final String PROPERTY_SSPPIPAYMENTSCHEDORDVLIST = "sSPPIPaymentSchedOrdVList";
    public static final String PROPERTY_SSWHCHECKBOOKPOSLINELIST = "sSWHCheckbookposLineList";
    public static final String PROPERTY_SSWHRECEIPTLIST = "sSWHReceiptList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELIST = "sSWSWithholdingSaleList";
    public static final String PROPERTY_SALESCOMMISSIONRUNLIST = "salesCommissionRunList";
    public static final String PROPERTY_SSCCRFINACCTRANSVLIST = "ssccrFinaccTransVList";
    public static final String PROPERTY_SSCCRPOSCARDRECLINELIST = "ssccrPosCardRecLineList";
    public static final String PROPERTY_SSFIINVOICESUMMARYVLIST = "ssfiInvoiceSummaryVList";
    public static final String PROPERTY_SSMAACTMODIFYACCTLIST = "ssmaactModifyAcctList";
    public static final String PROPERTY_SSPCHINVOICELIST = "sspchInvoiceList";
    public static final String PROPERTY_SSPCHPAYMENTPLANLIST = "sspchPaymentPlanList";
    public static final String PROPERTY_SSWHRPTCPURCHASEDETLIST = "sswhRptcPurchaseDetList";
    public static final String PROPERTY_SSWHRPTCSALESREFUNDLIST = "sswhRptcSalesRefundList";
    public static final String PROPERTY_SSWOSVEHICLEEMSATMACINVOICEIDLIST = "sswosVehicleEMSatmacInvoiceIDList";
    public static final String PROPERTY_ECSWCWITHHOLDINGCANCELLIST = "ecswcWithholdingCancelList";
    public static final String PROPERTY_EEIPAYMENTDETAILVLIST = "eeiPaymentDetailVList";
    public static final String PROPERTY_EEIVIEWINVOICELIST = "eeiViewInvoiceList";
    public static final String PROPERTY_FETSTESTLIST = "fetsTestList";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";
    public static final String PROPERTY_OPCRMINVOICELIST = "opcrmInvoiceList";
    public static final String PROPERTY_OPCRMOPPORTUNITIESLIST = "opcrmOpportunitiesList";
    public static final String PROPERTY_SDCCDAILYCLOSSINGLINELIST = "sdccDailyClossinglineList";
    public static final String PROPERTY_SIMPPYSPAYMENTDETAILLIST = "simppysPaymentDetailList";
    public static final String PROPERTY_SSAMALIENATELINELIST = "ssamAlienatelineList";
    public static final String PROPERTY_SSCCRCARDRECDETAILVLIST = "ssccrCardRecDetailVList";
    public static final String PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST = "sscflwExpensivePayoutVList";
    public static final String PROPERTY_SSCTPAYMENTLIST = "ssctPaymentList";
    public static final String PROPERTY_SSDCCPDISTCOSTCENTERLIST = "ssdccpDistcostcenterList";
    public static final String PROPERTY_SSDNIDPENDINGINTERESTLIST = "ssdnidPendinginterestList";
    public static final String PROPERTY_SSDNIDPENDINGINTERESTDEBITNOTEIDLIST = "ssdnidPendinginterestDebitnoteIDList";
    public static final String PROPERTY_SSFIFINPAYMENTDETAILVLIST = "ssfiFinPaymentDetailVList";
    public static final String PROPERTY_SSIPOTMPARTIALDISPATCHLIST = "ssipotmPartialDispatchList";
    public static final String PROPERTY_SSORELINVOICEORDERVLIST = "ssorelInvoiceorderVList";
    public static final String PROPERTY_SSPITRACTDETAILLIST = "sspitraCtDetailList";
    public static final String PROPERTY_SSPPINVSELECTEDINVOICESLIST = "ssppinvSelectedinvoicesList";
    public static final String PROPERTY_SSREREFUNDINVOICELIST = "ssreRefundinvoiceList";
    public static final String PROPERTY_SSTPCRELATEDREVENUELIST = "sstpcRelatedRevenueList";
    public static final String PROPERTY_SSWHDCNOTELIST = "sswhDcNoteList";
    public static final String PROPERTY_SSWHINVEXPORTATIONLIST = "sswhInvExportationList";
    public static final String PROPERTY_SSWHSALESTICKETSLIST = "sswhSalesticketsList";
    public static final String PROPERTY_SSWHWITHHCARDCREDITLIST = "sswhWithhCardCreditList";
    public static final String PROPERTY_SWSPCLOGSLIST = "swspcLogsList";


    // Computed columns properties, these properties cannot be directly accessed, they need
    // to be read through _commputedColumns proxy. They cannot be directly used in HQL, OBQuery
    // nor OBCriteria. 
    public static final String COMPUTED_COLUMN_SSPPINVPASSSELECTED = "ssppinvPassSelected";
    public static final String COMPUTED_COLUMN_SFPSICANCELEDDOCUMENT = "sFPSICanceledDocument";
    public static final String COMPUTED_COLUMN_SFPSIGRANDTOTAL = "sFPSIGrandTotal";
    public static final String COMPUTED_COLUMN_SFPSIOUTSTANDINGAMT = "sFPSIOutstandingAmt";
    public static final String COMPUTED_COLUMN_SFPSITOTALDISCOUNT = "sFPSITotalDiscount";
    public static final String COMPUTED_COLUMN_SFPSITOTALLINES = "sFPSITotalLines";
    public static final String COMPUTED_COLUMN_SFPSITOTALVAT = "sFPSITotalVAT";

    public Invoice() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_DOCUMENTSTATUS, "DR");
        setDefaultValue(PROPERTY_DOCUMENTACTION, "CO");
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_POSTED, "N");
        setDefaultValue(PROPERTY_PRINT, false);
        setDefaultValue(PROPERTY_PRINTDISCOUNT, false);
        setDefaultValue(PROPERTY_FORMOFPAYMENT, "P");
        setDefaultValue(PROPERTY_PRICEINCLUDESTAX, false);
        setDefaultValue(PROPERTY_CREATELINESFROM, false);
        setDefaultValue(PROPERTY_GENERATETO, false);
        setDefaultValue(PROPERTY_COPYFROM, false);
        setDefaultValue(PROPERTY_SELFSERVICE, false);
        setDefaultValue(PROPERTY_PAYMENTCOMPLETE, false);
        setDefaultValue(PROPERTY_TOTALPAID, new BigDecimal(0));
        setDefaultValue(PROPERTY_OUTSTANDINGAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DAYSTILLDUE, (long) 0);
        setDefaultValue(PROPERTY_DUEAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_UPDATEPAYMENTMONITOR, false);
        setDefaultValue(PROPERTY_APRMADDPAYMENT, true);
        setDefaultValue(PROPERTY_CALCULATEPROMOTIONS, false);
        setDefaultValue(PROPERTY_APRMPROCESSINVOICE, "CO");
        setDefaultValue(PROPERTY_CASHVAT, false);
        setDefaultValue(PROPERTY_SCNRISREFINV, false);
        setDefaultValue(PROPERTY_SSREISREFUNDED, false);
        setDefaultValue(PROPERTY_SSREISREFUND, false);
        setDefaultValue(PROPERTY_ATINDPOGENOS, true);
        setDefaultValue(PROPERTY_PREPAYMENTAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSWHTOTALWITHHOLDINGINCOME, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSWHTOTALWITHHOLDINGVAT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSWHCREDITNOTE, false);
        setDefaultValue(PROPERTY_SSWHISEINVOICE, false);
        setDefaultValue(PROPERTY_SSWHWITHHOLDINGMANUAL, false);
        setDefaultValue(PROPERTY_SSWHAUTHORIZATIONMANUAL, false);
        setDefaultValue(PROPERTY_EEIGENERATED, false);
        setDefaultValue(PROPERTY_EEISENT, false);
        setDefaultValue(PROPERTY_EEIEDOCUMENT, false);
        setDefaultValue(PROPERTY_EEICREDITNOTE, false);
        setDefaultValue(PROPERTY_EEIISINVREF, false);
        setDefaultValue(PROPERTY_EEIDEBITNOTE, false);
        setDefaultValue(PROPERTY_EEIWITHHOLDINGSEND, true);
        setDefaultValue(PROPERTY_EEITEMPORALSEND, false);
        setDefaultValue(PROPERTY_EEIRESENDINVOICE, false);
        setDefaultValue(PROPERTY_SDINLAWSUIT, new BigDecimal(0));
        setDefaultValue(PROPERTY_EEIGENERATEOFFLINE, false);
        setDefaultValue(PROPERTY_SSTPCLIQUIDATE, false);
        setDefaultValue(PROPERTY_SSTPCISLIQUIDATION, false);
        setDefaultValue(PROPERTY_SPEVPROCESSED, false);
        setDefaultValue(PROPERTY_EEIGENERATEOFFLINE2, false);
        setDefaultValue(PROPERTY_EEIRESENDINVOICE2, false);
        setDefaultValue(PROPERTY_IMDLVLOADLINESAUTH, false);
        setDefaultValue(PROPERTY_SFPSIRECONCILE, false);
        setDefaultValue(PROPERTY_SSORELREFINV, true);
        setDefaultValue(PROPERTY_SSWONSENTEMAIL, false);
        setDefaultValue(PROPERTY_SSORELISRETURN, false);
        setDefaultValue(PROPERTY_SSTTDEFDEFERREDCROSS, false);
        setDefaultValue(PROPERTY_SSDCCPDISTCOSTCENTER, false);
        setDefaultValue(PROPERTY_SLOSPCUUNLOCKPOSTED, false);
        setDefaultValue(PROPERTY_SCNSAGENERATENC, "GNC");
        setDefaultValue(PROPERTY_CSDFBPDISTCOSTCENTER, false);
        setDefaultValue(PROPERTY_APRMPENDINGPAYMENTINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXCASHVATVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CURRENCYCONVERSIONRATEDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIRREFUNDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIRREFUNDEEIRINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEICONTINGENCYLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIINVOICELOGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONEMSSCCRCINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDINVVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDORDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINORIGPAYMENTSCHEDULELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSAPIINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETEMSSACINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSCNRINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSSWHINVOICEREFLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMEEIREFINVIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEEMSSWHCREDITNOTEREFERENCELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEDISCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSREREFUNDEDINVOICEREFIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICETAXLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICEV2LIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPINLCINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDEREMSICUSINVOICETORETURNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_PRICINGVOLUMEDISCOUNTINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REVERSEDINVOICESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_REVERSEDINVOICESREVERSEDINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SRSISALESINVOICEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDQSIQUOTADETAILLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPIPAYMENTSCHEDORDVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHCHECKBOOKPOSLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRECEIPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SALESCOMMISSIONRUNLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRFINACCTRANSVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRPOSCARDRECLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIINVOICESUMMARYVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTMODIFYACCTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPCHPAYMENTPLANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRPTCPURCHASEDETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHRPTCSALESREFUNDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWOSVEHICLEEMSATMACINVOICEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ECSWCWITHHOLDINGCANCELLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_EEIVIEWINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FETSTESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OPCRMOPPORTUNITIESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPPYSPAYMENTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRCARDRECDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDCCPDISTCOSTCENTERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDNIDPENDINGINTERESTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDNIDPENDINGINTERESTDEBITNOTEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSFIFINPAYMENTDETAILVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSORELINVOICEORDERVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPITRACTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPPINVSELECTEDINVOICESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSREREFUNDINVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCRELATEDREVENUELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHDCNOTELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHINVEXPORTATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHSALESTICKETSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWHWITHHCARDCREDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SWSPCLOGSLIST, new ArrayList<Object>());
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

    public Boolean isSalesTransaction() {
        return (Boolean) get(PROPERTY_SALESTRANSACTION);
    }

    public void setSalesTransaction(Boolean salesTransaction) {
        set(PROPERTY_SALESTRANSACTION, salesTransaction);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getDocumentStatus() {
        return (String) get(PROPERTY_DOCUMENTSTATUS);
    }

    public void setDocumentStatus(String documentStatus) {
        set(PROPERTY_DOCUMENTSTATUS, documentStatus);
    }

    public String getDocumentAction() {
        return (String) get(PROPERTY_DOCUMENTACTION);
    }

    public void setDocumentAction(String documentAction) {
        set(PROPERTY_DOCUMENTACTION, documentAction);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public String getPosted() {
        return (String) get(PROPERTY_POSTED);
    }

    public void setPosted(String posted) {
        set(PROPERTY_POSTED, posted);
    }

    public DocumentType getDocumentType() {
        return (DocumentType) get(PROPERTY_DOCUMENTTYPE);
    }

    public void setDocumentType(DocumentType documentType) {
        set(PROPERTY_DOCUMENTTYPE, documentType);
    }

    public DocumentType getTransactionDocument() {
        return (DocumentType) get(PROPERTY_TRANSACTIONDOCUMENT);
    }

    public void setTransactionDocument(DocumentType transactionDocument) {
        set(PROPERTY_TRANSACTIONDOCUMENT, transactionDocument);
    }

    public Order getSalesOrder() {
        return (Order) get(PROPERTY_SALESORDER);
    }

    public void setSalesOrder(Order salesOrder) {
        set(PROPERTY_SALESORDER, salesOrder);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isPrint() {
        return (Boolean) get(PROPERTY_PRINT);
    }

    public void setPrint(Boolean print) {
        set(PROPERTY_PRINT, print);
    }

    public User getSalesRepresentative() {
        return (User) get(PROPERTY_SALESREPRESENTATIVE);
    }

    public void setSalesRepresentative(User salesRepresentative) {
        set(PROPERTY_SALESREPRESENTATIVE, salesRepresentative);
    }

    public Date getInvoiceDate() {
        return (Date) get(PROPERTY_INVOICEDATE);
    }

    public void setInvoiceDate(Date invoiceDate) {
        set(PROPERTY_INVOICEDATE, invoiceDate);
    }

    public Date getDatePrinted() {
        return (Date) get(PROPERTY_DATEPRINTED);
    }

    public void setDatePrinted(Date datePrinted) {
        set(PROPERTY_DATEPRINTED, datePrinted);
    }

    public Date getAccountingDate() {
        return (Date) get(PROPERTY_ACCOUNTINGDATE);
    }

    public void setAccountingDate(Date accountingDate) {
        set(PROPERTY_ACCOUNTINGDATE, accountingDate);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public Location getPartnerAddress() {
        return (Location) get(PROPERTY_PARTNERADDRESS);
    }

    public void setPartnerAddress(Location partnerAddress) {
        set(PROPERTY_PARTNERADDRESS, partnerAddress);
    }

    public String getOrderReference() {
        return (String) get(PROPERTY_ORDERREFERENCE);
    }

    public void setOrderReference(String orderReference) {
        set(PROPERTY_ORDERREFERENCE, orderReference);
    }

    public Boolean isPrintDiscount() {
        return (Boolean) get(PROPERTY_PRINTDISCOUNT);
    }

    public void setPrintDiscount(Boolean printDiscount) {
        set(PROPERTY_PRINTDISCOUNT, printDiscount);
    }

    public Date getOrderDate() {
        return (Date) get(PROPERTY_ORDERDATE);
    }

    public void setOrderDate(Date orderDate) {
        set(PROPERTY_ORDERDATE, orderDate);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public String getFormOfPayment() {
        return (String) get(PROPERTY_FORMOFPAYMENT);
    }

    public void setFormOfPayment(String formOfPayment) {
        set(PROPERTY_FORMOFPAYMENT, formOfPayment);
    }

    public PaymentTerm getPaymentTerms() {
        return (PaymentTerm) get(PROPERTY_PAYMENTTERMS);
    }

    public void setPaymentTerms(PaymentTerm paymentTerms) {
        set(PROPERTY_PAYMENTTERMS, paymentTerms);
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

    public BigDecimal getSummedLineAmount() {
        return (BigDecimal) get(PROPERTY_SUMMEDLINEAMOUNT);
    }

    public void setSummedLineAmount(BigDecimal summedLineAmount) {
        set(PROPERTY_SUMMEDLINEAMOUNT, summedLineAmount);
    }

    public BigDecimal getGrandTotalAmount() {
        return (BigDecimal) get(PROPERTY_GRANDTOTALAMOUNT);
    }

    public void setGrandTotalAmount(BigDecimal grandTotalAmount) {
        set(PROPERTY_GRANDTOTALAMOUNT, grandTotalAmount);
    }

    public PriceList getPriceList() {
        return (PriceList) get(PROPERTY_PRICELIST);
    }

    public void setPriceList(PriceList priceList) {
        set(PROPERTY_PRICELIST, priceList);
    }

    public Boolean isPriceIncludesTax() {
        return (Boolean) get(PROPERTY_PRICEINCLUDESTAX);
    }

    public void setPriceIncludesTax(Boolean priceIncludesTax) {
        set(PROPERTY_PRICEINCLUDESTAX, priceIncludesTax);
    }

    public Campaign getSalesCampaign() {
        return (Campaign) get(PROPERTY_SALESCAMPAIGN);
    }

    public void setSalesCampaign(Campaign salesCampaign) {
        set(PROPERTY_SALESCAMPAIGN, salesCampaign);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public ABCActivity getActivity() {
        return (ABCActivity) get(PROPERTY_ACTIVITY);
    }

    public void setActivity(ABCActivity activity) {
        set(PROPERTY_ACTIVITY, activity);
    }

    public Boolean isCreateLinesFrom() {
        return (Boolean) get(PROPERTY_CREATELINESFROM);
    }

    public void setCreateLinesFrom(Boolean createLinesFrom) {
        set(PROPERTY_CREATELINESFROM, createLinesFrom);
    }

    public Boolean isGenerateTo() {
        return (Boolean) get(PROPERTY_GENERATETO);
    }

    public void setGenerateTo(Boolean generateTo) {
        set(PROPERTY_GENERATETO, generateTo);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Boolean isCopyFrom() {
        return (Boolean) get(PROPERTY_COPYFROM);
    }

    public void setCopyFrom(Boolean copyFrom) {
        set(PROPERTY_COPYFROM, copyFrom);
    }

    public Boolean isSelfService() {
        return (Boolean) get(PROPERTY_SELFSERVICE);
    }

    public void setSelfService(Boolean selfService) {
        set(PROPERTY_SELFSERVICE, selfService);
    }

    public Organization getTrxOrganization() {
        return (Organization) get(PROPERTY_TRXORGANIZATION);
    }

    public void setTrxOrganization(Organization trxOrganization) {
        set(PROPERTY_TRXORGANIZATION, trxOrganization);
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

    public BigDecimal getWithholdingamount() {
        return (BigDecimal) get(PROPERTY_WITHHOLDINGAMOUNT);
    }

    public void setWithholdingamount(BigDecimal withholdingamount) {
        set(PROPERTY_WITHHOLDINGAMOUNT, withholdingamount);
    }

    public Date getTaxDate() {
        return (Date) get(PROPERTY_TAXDATE);
    }

    public void setTaxDate(Date taxDate) {
        set(PROPERTY_TAXDATE, taxDate);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public Boolean isPaymentComplete() {
        return (Boolean) get(PROPERTY_PAYMENTCOMPLETE);
    }

    public void setPaymentComplete(Boolean paymentComplete) {
        set(PROPERTY_PAYMENTCOMPLETE, paymentComplete);
    }

    public BigDecimal getTotalPaid() {
        return (BigDecimal) get(PROPERTY_TOTALPAID);
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        set(PROPERTY_TOTALPAID, totalPaid);
    }

    public BigDecimal getOutstandingAmount() {
        return (BigDecimal) get(PROPERTY_OUTSTANDINGAMOUNT);
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        set(PROPERTY_OUTSTANDINGAMOUNT, outstandingAmount);
    }

    public Long getDaysTillDue() {
        return (Long) get(PROPERTY_DAYSTILLDUE);
    }

    public void setDaysTillDue(Long daysTillDue) {
        set(PROPERTY_DAYSTILLDUE, daysTillDue);
    }

    public BigDecimal getDueAmount() {
        return (BigDecimal) get(PROPERTY_DUEAMOUNT);
    }

    public void setDueAmount(BigDecimal dueAmount) {
        set(PROPERTY_DUEAMOUNT, dueAmount);
    }

    public Date getLastCalculatedOnDate() {
        return (Date) get(PROPERTY_LASTCALCULATEDONDATE);
    }

    public void setLastCalculatedOnDate(Date lastCalculatedOnDate) {
        set(PROPERTY_LASTCALCULATEDONDATE, lastCalculatedOnDate);
    }

    public Boolean isUpdatePaymentMonitor() {
        return (Boolean) get(PROPERTY_UPDATEPAYMENTMONITOR);
    }

    public void setUpdatePaymentMonitor(Boolean updatePaymentMonitor) {
        set(PROPERTY_UPDATEPAYMENTMONITOR, updatePaymentMonitor);
    }

    public FIN_PaymentMethod getPaymentMethod() {
        return (FIN_PaymentMethod) get(PROPERTY_PAYMENTMETHOD);
    }

    public void setPaymentMethod(FIN_PaymentMethod paymentMethod) {
        set(PROPERTY_PAYMENTMETHOD, paymentMethod);
    }

    public PaymentPriority getFINPaymentPriority() {
        return (PaymentPriority) get(PROPERTY_FINPAYMENTPRIORITY);
    }

    public void setFINPaymentPriority(PaymentPriority fINPaymentPriority) {
        set(PROPERTY_FINPAYMENTPRIORITY, fINPaymentPriority);
    }

    public Date getFinalSettlementDate() {
        return (Date) get(PROPERTY_FINALSETTLEMENTDATE);
    }

    public void setFinalSettlementDate(Date finalSettlementDate) {
        set(PROPERTY_FINALSETTLEMENTDATE, finalSettlementDate);
    }

    public Long getDaysSalesOutstanding() {
        return (Long) get(PROPERTY_DAYSSALESOUTSTANDING);
    }

    public void setDaysSalesOutstanding(Long daysSalesOutstanding) {
        set(PROPERTY_DAYSSALESOUTSTANDING, daysSalesOutstanding);
    }

    public Long getPercentageOverdue() {
        return (Long) get(PROPERTY_PERCENTAGEOVERDUE);
    }

    public void setPercentageOverdue(Long percentageOverdue) {
        set(PROPERTY_PERCENTAGEOVERDUE, percentageOverdue);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public Boolean isAPRMAddpayment() {
        return (Boolean) get(PROPERTY_APRMADDPAYMENT);
    }

    public void setAPRMAddpayment(Boolean aPRMAddpayment) {
        set(PROPERTY_APRMADDPAYMENT, aPRMAddpayment);
    }

    public Boolean isCalculatePromotions() {
        return (Boolean) get(PROPERTY_CALCULATEPROMOTIONS);
    }

    public void setCalculatePromotions(Boolean calculatePromotions) {
        set(PROPERTY_CALCULATEPROMOTIONS, calculatePromotions);
    }

    public String getAPRMProcessinvoice() {
        return (String) get(PROPERTY_APRMPROCESSINVOICE);
    }

    public void setAPRMProcessinvoice(String aPRMProcessinvoice) {
        set(PROPERTY_APRMPROCESSINVOICE, aPRMProcessinvoice);
    }

    public Asset getAsset() {
        return (Asset) get(PROPERTY_ASSET);
    }

    public void setAsset(Asset asset) {
        set(PROPERTY_ASSET, asset);
    }

    public Boolean isCashVAT() {
        return (Boolean) get(PROPERTY_CASHVAT);
    }

    public void setCashVAT(Boolean cashVAT) {
        set(PROPERTY_CASHVAT, cashVAT);
    }

    public Date getSsreLockdate() {
        return (Date) get(PROPERTY_SSRELOCKDATE);
    }

    public void setSsreLockdate(Date ssreLockdate) {
        set(PROPERTY_SSRELOCKDATE, ssreLockdate);
    }

    public BusinessPartner getSsreCBpartner() {
        return (BusinessPartner) get(PROPERTY_SSRECBPARTNER);
    }

    public void setSsreCBpartner(BusinessPartner ssreCBpartner) {
        set(PROPERTY_SSRECBPARTNER, ssreCBpartner);
    }

    public Boolean isScnrIsrefInv() {
        return (Boolean) get(PROPERTY_SCNRISREFINV);
    }

    public void setScnrIsrefInv(Boolean scnrIsrefInv) {
        set(PROPERTY_SCNRISREFINV, scnrIsrefInv);
    }

    public Boolean isSsreIsrefunded() {
        return (Boolean) get(PROPERTY_SSREISREFUNDED);
    }

    public void setSsreIsrefunded(Boolean ssreIsrefunded) {
        set(PROPERTY_SSREISREFUNDED, ssreIsrefunded);
    }

    public Invoice getScnrInvoice() {
        return (Invoice) get(PROPERTY_SCNRINVOICE);
    }

    public void setScnrInvoice(Invoice scnrInvoice) {
        set(PROPERTY_SCNRINVOICE, scnrInvoice);
    }

    public ssrerefund getSsreRefunded() {
        return (ssrerefund) get(PROPERTY_SSREREFUNDED);
    }

    public void setSsreRefunded(ssrerefund ssreRefunded) {
        set(PROPERTY_SSREREFUNDED, ssreRefunded);
    }

    public Boolean isSsreIsrefund() {
        return (Boolean) get(PROPERTY_SSREISREFUND);
    }

    public void setSsreIsrefund(Boolean ssreIsrefund) {
        set(PROPERTY_SSREISREFUND, ssreIsrefund);
    }

    public Boolean isAtindpoGenOs() {
        return (Boolean) get(PROPERTY_ATINDPOGENOS);
    }

    public void setAtindpoGenOs(Boolean atindpoGenOs) {
        set(PROPERTY_ATINDPOGENOS, atindpoGenOs);
    }

    public atindpo_postventa getAtindpoPostventa() {
        return (atindpo_postventa) get(PROPERTY_ATINDPOPOSTVENTA);
    }

    public void setAtindpoPostventa(atindpo_postventa atindpoPostventa) {
        set(PROPERTY_ATINDPOPOSTVENTA, atindpoPostventa);
    }

    public BigDecimal getPrepaymentamt() {
        return (BigDecimal) get(PROPERTY_PREPAYMENTAMT);
    }

    public void setPrepaymentamt(BigDecimal prepaymentamt) {
        set(PROPERTY_PREPAYMENTAMT, prepaymentamt);
    }

    public BigDecimal getSswhTotalwithholdingincome() {
        return (BigDecimal) get(PROPERTY_SSWHTOTALWITHHOLDINGINCOME);
    }

    public void setSswhTotalwithholdingincome(BigDecimal sswhTotalwithholdingincome) {
        set(PROPERTY_SSWHTOTALWITHHOLDINGINCOME, sswhTotalwithholdingincome);
    }

    public BigDecimal getSswhTotalwithholdingvat() {
        return (BigDecimal) get(PROPERTY_SSWHTOTALWITHHOLDINGVAT);
    }

    public void setSswhTotalwithholdingvat(BigDecimal sswhTotalwithholdingvat) {
        set(PROPERTY_SSWHTOTALWITHHOLDINGVAT, sswhTotalwithholdingvat);
    }

    public Receipt getSswhReceipt() {
        return (Receipt) get(PROPERTY_SSWHRECEIPT);
    }

    public void setSswhReceipt(Receipt sswhReceipt) {
        set(PROPERTY_SSWHRECEIPT, sswhReceipt);
    }

    public String getSswhNroauthorization() {
        return (String) get(PROPERTY_SSWHNROAUTHORIZATION);
    }

    public void setSswhNroauthorization(String sswhNroauthorization) {
        set(PROPERTY_SSWHNROAUTHORIZATION, sswhNroauthorization);
    }

    public Date getSswhExpirationdate() {
        return (Date) get(PROPERTY_SSWHEXPIRATIONDATE);
    }

    public void setSswhExpirationdate(Date sswhExpirationdate) {
        set(PROPERTY_SSWHEXPIRATIONDATE, sswhExpirationdate);
    }

    public SSWHLivelihoodt getSswhLivelihood() {
        return (SSWHLivelihoodt) get(PROPERTY_SSWHLIVELIHOOD);
    }

    public void setSswhLivelihood(SSWHLivelihoodt sswhLivelihood) {
        set(PROPERTY_SSWHLIVELIHOOD, sswhLivelihood);
    }

    public SSWHCodelivelihoodt getSswhCodelivelihood() {
        return (SSWHCodelivelihoodt) get(PROPERTY_SSWHCODELIVELIHOOD);
    }

    public void setSswhCodelivelihood(SSWHCodelivelihoodt sswhCodelivelihood) {
        set(PROPERTY_SSWHCODELIVELIHOOD, sswhCodelivelihood);
    }

    public String getSswhWithholdingref() {
        return (String) get(PROPERTY_SSWHWITHHOLDINGREF);
    }

    public void setSswhWithholdingref(String sswhWithholdingref) {
        set(PROPERTY_SSWHWITHHOLDINGREF, sswhWithholdingref);
    }

    public String getSswhAuthorization() {
        return (String) get(PROPERTY_SSWHAUTHORIZATION);
    }

    public void setSswhAuthorization(String sswhAuthorization) {
        set(PROPERTY_SSWHAUTHORIZATION, sswhAuthorization);
    }

    public Date getSswhDatewithhold() {
        return (Date) get(PROPERTY_SSWHDATEWITHHOLD);
    }

    public void setSswhDatewithhold(Date sswhDatewithhold) {
        set(PROPERTY_SSWHDATEWITHHOLD, sswhDatewithhold);
    }

    public Boolean isSswhCreditnote() {
        return (Boolean) get(PROPERTY_SSWHCREDITNOTE);
    }

    public void setSswhCreditnote(Boolean sswhCreditnote) {
        set(PROPERTY_SSWHCREDITNOTE, sswhCreditnote);
    }

    public Date getSswhDateendinvoice() {
        return (Date) get(PROPERTY_SSWHDATEENDINVOICE);
    }

    public void setSswhDateendinvoice(Date sswhDateendinvoice) {
        set(PROPERTY_SSWHDATEENDINVOICE, sswhDateendinvoice);
    }

    public Invoice getSswhInvoiceRef() {
        return (Invoice) get(PROPERTY_SSWHINVOICEREF);
    }

    public void setSswhInvoiceRef(Invoice sswhInvoiceRef) {
        set(PROPERTY_SSWHINVOICEREF, sswhInvoiceRef);
    }

    public String getSswhKeyei() {
        return (String) get(PROPERTY_SSWHKEYEI);
    }

    public void setSswhKeyei(String sswhKeyei) {
        set(PROPERTY_SSWHKEYEI, sswhKeyei);
    }

    public Boolean isSswhIseinvoice() {
        return (Boolean) get(PROPERTY_SSWHISEINVOICE);
    }

    public void setSswhIseinvoice(Boolean sswhIseinvoice) {
        set(PROPERTY_SSWHISEINVOICE, sswhIseinvoice);
    }

    public DocumentType getSswhCDoctype() {
        return (DocumentType) get(PROPERTY_SSWHCDOCTYPE);
    }

    public void setSswhCDoctype(DocumentType sswhCDoctype) {
        set(PROPERTY_SSWHCDOCTYPE, sswhCDoctype);
    }

    public BankAccount getSswhBankaccount() {
        return (BankAccount) get(PROPERTY_SSWHBANKACCOUNT);
    }

    public void setSswhBankaccount(BankAccount sswhBankaccount) {
        set(PROPERTY_SSWHBANKACCOUNT, sswhBankaccount);
    }

    public Boolean isSswhWithholdingmanual() {
        return (Boolean) get(PROPERTY_SSWHWITHHOLDINGMANUAL);
    }

    public void setSswhWithholdingmanual(Boolean sswhWithholdingmanual) {
        set(PROPERTY_SSWHWITHHOLDINGMANUAL, sswhWithholdingmanual);
    }

    public String getEeiCodigo() {
        return (String) get(PROPERTY_EEICODIGO);
    }

    public void setEeiCodigo(String eeiCodigo) {
        set(PROPERTY_EEICODIGO, eeiCodigo);
    }

    public String getEeiNumauto() {
        return (String) get(PROPERTY_EEINUMAUTO);
    }

    public void setEeiNumauto(String eeiNumauto) {
        set(PROPERTY_EEINUMAUTO, eeiNumauto);
    }

    public Date getEeiFechaauto() {
        return (Date) get(PROPERTY_EEIFECHAAUTO);
    }

    public void setEeiFechaauto(Date eeiFechaauto) {
        set(PROPERTY_EEIFECHAAUTO, eeiFechaauto);
    }

    public Boolean isSswhAuthorizationmanual() {
        return (Boolean) get(PROPERTY_SSWHAUTHORIZATIONMANUAL);
    }

    public void setSswhAuthorizationmanual(Boolean sswhAuthorizationmanual) {
        set(PROPERTY_SSWHAUTHORIZATIONMANUAL, sswhAuthorizationmanual);
    }

    public String getEeiFechaautotext() {
        return (String) get(PROPERTY_EEIFECHAAUTOTEXT);
    }

    public void setEeiFechaautotext(String eeiFechaautotext) {
        set(PROPERTY_EEIFECHAAUTOTEXT, eeiFechaautotext);
    }

    public Boolean isEeiGenerated() {
        return (Boolean) get(PROPERTY_EEIGENERATED);
    }

    public void setEeiGenerated(Boolean eeiGenerated) {
        set(PROPERTY_EEIGENERATED, eeiGenerated);
    }

    public Boolean isEeiSent() {
        return (Boolean) get(PROPERTY_EEISENT);
    }

    public void setEeiSent(Boolean eeiSent) {
        set(PROPERTY_EEISENT, eeiSent);
    }

    public Boolean isEeiEdocument() {
        return (Boolean) get(PROPERTY_EEIEDOCUMENT);
    }

    public void setEeiEdocument(Boolean eeiEdocument) {
        set(PROPERTY_EEIEDOCUMENT, eeiEdocument);
    }

    public String getEeiRsiAuthNo() {
        return (String) get(PROPERTY_EEIRSIAUTHNO);
    }

    public void setEeiRsiAuthNo(String eeiRsiAuthNo) {
        set(PROPERTY_EEIRSIAUTHNO, eeiRsiAuthNo);
    }

    public Boolean isEeiCreditnote() {
        return (Boolean) get(PROPERTY_EEICREDITNOTE);
    }

    public void setEeiCreditnote(Boolean eeiCreditnote) {
        set(PROPERTY_EEICREDITNOTE, eeiCreditnote);
    }

    public Boolean isEeiIsInvRef() {
        return (Boolean) get(PROPERTY_EEIISINVREF);
    }

    public void setEeiIsInvRef(Boolean eeiIsInvRef) {
        set(PROPERTY_EEIISINVREF, eeiIsInvRef);
    }

    public Invoice getEeiRefInv() {
        return (Invoice) get(PROPERTY_EEIREFINV);
    }

    public void setEeiRefInv(Invoice eeiRefInv) {
        set(PROPERTY_EEIREFINV, eeiRefInv);
    }

    public Boolean isEeiDebitnote() {
        return (Boolean) get(PROPERTY_EEIDEBITNOTE);
    }

    public void setEeiDebitnote(Boolean eeiDebitnote) {
        set(PROPERTY_EEIDEBITNOTE, eeiDebitnote);
    }

    public Boolean isEeiWithholdingSend() {
        return (Boolean) get(PROPERTY_EEIWITHHOLDINGSEND);
    }

    public void setEeiWithholdingSend(Boolean eeiWithholdingSend) {
        set(PROPERTY_EEIWITHHOLDINGSEND, eeiWithholdingSend);
    }

    public String getEeiUrlxml() {
        return (String) get(PROPERTY_EEIURLXML);
    }

    public void setEeiUrlxml(String eeiUrlxml) {
        set(PROPERTY_EEIURLXML, eeiUrlxml);
    }

    public String getEeiUrlride() {
        return (String) get(PROPERTY_EEIURLRIDE);
    }

    public void setEeiUrlride(String eeiUrlride) {
        set(PROPERTY_EEIURLRIDE, eeiUrlride);
    }

    public String getEeiStatus() {
        return (String) get(PROPERTY_EEISTATUS);
    }

    public void setEeiStatus(String eeiStatus) {
        set(PROPERTY_EEISTATUS, eeiStatus);
    }

    public Boolean isEeiTemporalsend() {
        return (Boolean) get(PROPERTY_EEITEMPORALSEND);
    }

    public void setEeiTemporalsend(Boolean eeiTemporalsend) {
        set(PROPERTY_EEITEMPORALSEND, eeiTemporalsend);
    }

    public Boolean isEeiResendInvoice() {
        return (Boolean) get(PROPERTY_EEIRESENDINVOICE);
    }

    public void setEeiResendInvoice(Boolean eeiResendInvoice) {
        set(PROPERTY_EEIRESENDINVOICE, eeiResendInvoice);
    }

    public BigDecimal getSdinLawsuit() {
        return (BigDecimal) get(PROPERTY_SDINLAWSUIT);
    }

    public void setSdinLawsuit(BigDecimal sdinLawsuit) {
        set(PROPERTY_SDINLAWSUIT, sdinLawsuit);
    }

    public Boolean isEeiGenerateOffline() {
        return (Boolean) get(PROPERTY_EEIGENERATEOFFLINE);
    }

    public void setEeiGenerateOffline(Boolean eeiGenerateOffline) {
        set(PROPERTY_EEIGENERATEOFFLINE, eeiGenerateOffline);
    }

    public String getEeiDescription() {
        return (String) get(PROPERTY_EEIDESCRIPTION);
    }

    public void setEeiDescription(String eeiDescription) {
        set(PROPERTY_EEIDESCRIPTION, eeiDescription);
    }

    public Boolean isSstpcLiquidate() {
        return (Boolean) get(PROPERTY_SSTPCLIQUIDATE);
    }

    public void setSstpcLiquidate(Boolean sstpcLiquidate) {
        set(PROPERTY_SSTPCLIQUIDATE, sstpcLiquidate);
    }

    public Boolean isSstpcIsliquidation() {
        return (Boolean) get(PROPERTY_SSTPCISLIQUIDATION);
    }

    public void setSstpcIsliquidation(Boolean sstpcIsliquidation) {
        set(PROPERTY_SSTPCISLIQUIDATION, sstpcIsliquidation);
    }

    public String getSsreLockedby() {
        return (String) get(PROPERTY_SSRELOCKEDBY);
    }

    public void setSsreLockedby(String ssreLockedby) {
        set(PROPERTY_SSRELOCKEDBY, ssreLockedby);
    }

    public Boolean isSpevProcessed() {
        return (Boolean) get(PROPERTY_SPEVPROCESSED);
    }

    public void setSpevProcessed(Boolean spevProcessed) {
        set(PROPERTY_SPEVPROCESSED, spevProcessed);
    }

    public String getSpincoTaxid() {
        return (String) get(PROPERTY_SPINCOTAXID);
    }

    public void setSpincoTaxid(String spincoTaxid) {
        set(PROPERTY_SPINCOTAXID, spincoTaxid);
    }

    public String getEeiStatus2() {
        return (String) get(PROPERTY_EEISTATUS2);
    }

    public void setEeiStatus2(String eeiStatus2) {
        set(PROPERTY_EEISTATUS2, eeiStatus2);
    }

    public ShippingCompany getSlciShipper() {
        return (ShippingCompany) get(PROPERTY_SLCISHIPPER);
    }

    public void setSlciShipper(ShippingCompany slciShipper) {
        set(PROPERTY_SLCISHIPPER, slciShipper);
    }

    public String getEeiCodigo2() {
        return (String) get(PROPERTY_EEICODIGO2);
    }

    public void setEeiCodigo2(String eeiCodigo2) {
        set(PROPERTY_EEICODIGO2, eeiCodigo2);
    }

    public String getEeiUrlxml2() {
        return (String) get(PROPERTY_EEIURLXML2);
    }

    public void setEeiUrlxml2(String eeiUrlxml2) {
        set(PROPERTY_EEIURLXML2, eeiUrlxml2);
    }

    public String getEeiUrlride2() {
        return (String) get(PROPERTY_EEIURLRIDE2);
    }

    public void setEeiUrlride2(String eeiUrlride2) {
        set(PROPERTY_EEIURLRIDE2, eeiUrlride2);
    }

    public String getEeiNumauto2() {
        return (String) get(PROPERTY_EEINUMAUTO2);
    }

    public void setEeiNumauto2(String eeiNumauto2) {
        set(PROPERTY_EEINUMAUTO2, eeiNumauto2);
    }

    public String getEeiFechaautotext2() {
        return (String) get(PROPERTY_EEIFECHAAUTOTEXT2);
    }

    public void setEeiFechaautotext2(String eeiFechaautotext2) {
        set(PROPERTY_EEIFECHAAUTOTEXT2, eeiFechaautotext2);
    }

    public Boolean isEeiGenerateOffline2() {
        return (Boolean) get(PROPERTY_EEIGENERATEOFFLINE2);
    }

    public void setEeiGenerateOffline2(Boolean eeiGenerateOffline2) {
        set(PROPERTY_EEIGENERATEOFFLINE2, eeiGenerateOffline2);
    }

    public Boolean isEeiResendinvoice2() {
        return (Boolean) get(PROPERTY_EEIRESENDINVOICE2);
    }

    public void setEeiResendinvoice2(Boolean eeiResendinvoice2) {
        set(PROPERTY_EEIRESENDINVOICE2, eeiResendinvoice2);
    }

    public Boolean isImdlvLoadLinesAuth() {
        return (Boolean) get(PROPERTY_IMDLVLOADLINESAUTH);
    }

    public void setImdlvLoadLinesAuth(Boolean imdlvLoadLinesAuth) {
        set(PROPERTY_IMDLVLOADLINESAUTH, imdlvLoadLinesAuth);
    }

    public Boolean isSfpsiReconcile() {
        return (Boolean) get(PROPERTY_SFPSIRECONCILE);
    }

    public void setSfpsiReconcile(Boolean sfpsiReconcile) {
        set(PROPERTY_SFPSIRECONCILE, sfpsiReconcile);
    }

    public Boolean isSsorelRefinv() {
        return (Boolean) get(PROPERTY_SSORELREFINV);
    }

    public void setSsorelRefinv(Boolean ssorelRefinv) {
        set(PROPERTY_SSORELREFINV, ssorelRefinv);
    }

    public Boolean isSswonSentEmail() {
        return (Boolean) get(PROPERTY_SSWONSENTEMAIL);
    }

    public void setSswonSentEmail(Boolean sswonSentEmail) {
        set(PROPERTY_SSWONSENTEMAIL, sswonSentEmail);
    }

    public Boolean isSsorelIsreturn() {
        return (Boolean) get(PROPERTY_SSORELISRETURN);
    }

    public void setSsorelIsreturn(Boolean ssorelIsreturn) {
        set(PROPERTY_SSORELISRETURN, ssorelIsreturn);
    }

    public String getSpdnDocumentno() {
        return (String) get(PROPERTY_SPDNDOCUMENTNO);
    }

    public void setSpdnDocumentno(String spdnDocumentno) {
        set(PROPERTY_SPDNDOCUMENTNO, spdnDocumentno);
    }

    public Boolean isSsttdefDeferredCross() {
        return (Boolean) get(PROPERTY_SSTTDEFDEFERREDCROSS);
    }

    public void setSsttdefDeferredCross(Boolean ssttdefDeferredCross) {
        set(PROPERTY_SSTTDEFDEFERREDCROSS, ssttdefDeferredCross);
    }

    public Date getSsttdefCrossingDate() {
        return (Date) get(PROPERTY_SSTTDEFCROSSINGDATE);
    }

    public void setSsttdefCrossingDate(Date ssttdefCrossingDate) {
        set(PROPERTY_SSTTDEFCROSSINGDATE, ssttdefCrossingDate);
    }

    public Boolean isSsppinvPassSelected() {
        return (Boolean) get(COMPUTED_COLUMN_SSPPINVPASSSELECTED);
    }

    public void setSsppinvPassSelected(Boolean ssppinvPassSelected) {
        set(COMPUTED_COLUMN_SSPPINVPASSSELECTED, ssppinvPassSelected);
    }

    public String getEeiVoucherCode() {
        return (String) get(PROPERTY_EEIVOUCHERCODE);
    }

    public void setEeiVoucherCode(String eeiVoucherCode) {
        set(PROPERTY_EEIVOUCHERCODE, eeiVoucherCode);
    }

    public String getSswhDividendYear() {
        return (String) get(PROPERTY_SSWHDIVIDENDYEAR);
    }

    public void setSswhDividendYear(String sswhDividendYear) {
        set(PROPERTY_SSWHDIVIDENDYEAR, sswhDividendYear);
    }

    public Date getEeiVoucherDate() {
        return (Date) get(PROPERTY_EEIVOUCHERDATE);
    }

    public void setEeiVoucherDate(Date eeiVoucherDate) {
        set(PROPERTY_EEIVOUCHERDATE, eeiVoucherDate);
    }

    public Boolean isSsdccpDistcostcenter() {
        return (Boolean) get(PROPERTY_SSDCCPDISTCOSTCENTER);
    }

    public void setSsdccpDistcostcenter(Boolean ssdccpDistcostcenter) {
        set(PROPERTY_SSDCCPDISTCOSTCENTER, ssdccpDistcostcenter);
    }

    public String getEeiInvoiceNum() {
        return (String) get(PROPERTY_EEIINVOICENUM);
    }

    public void setEeiInvoiceNum(String eeiInvoiceNum) {
        set(PROPERTY_EEIINVOICENUM, eeiInvoiceNum);
    }

    public Date getSssoinCompleted() {
        return (Date) get(PROPERTY_SSSOINCOMPLETED);
    }

    public void setSssoinCompleted(Date sssoinCompleted) {
        set(PROPERTY_SSSOINCOMPLETED, sssoinCompleted);
    }

    public User getSssoinCompletedby() {
        return (User) get(PROPERTY_SSSOINCOMPLETEDBY);
    }

    public void setSssoinCompletedby(User sssoinCompletedby) {
        set(PROPERTY_SSSOINCOMPLETEDBY, sssoinCompletedby);
    }

    public Boolean isSlospcuUnlockPosted() {
        return (Boolean) get(PROPERTY_SLOSPCUUNLOCKPOSTED);
    }

    public void setSlospcuUnlockPosted(Boolean slospcuUnlockPosted) {
        set(PROPERTY_SLOSPCUUNLOCKPOSTED, slospcuUnlockPosted);
    }

    public String getScnsaGeneratenc() {
        return (String) get(PROPERTY_SCNSAGENERATENC);
    }

    public void setScnsaGeneratenc(String scnsaGeneratenc) {
        set(PROPERTY_SCNSAGENERATENC, scnsaGeneratenc);
    }

    public Boolean isCsdfbpDistcostcenter() {
        return (Boolean) get(PROPERTY_CSDFBPDISTCOSTCENTER);
    }

    public void setCsdfbpDistcostcenter(Boolean csdfbpDistcostcenter) {
        set(PROPERTY_CSDFBPDISTCOSTCENTER, csdfbpDistcostcenter);
    }

    public Invoice getSFPSICanceledDocument() {
        return (Invoice) get(COMPUTED_COLUMN_SFPSICANCELEDDOCUMENT);
    }

    public void setSFPSICanceledDocument(Invoice sFPSICanceledDocument) {
        set(COMPUTED_COLUMN_SFPSICANCELEDDOCUMENT, sFPSICanceledDocument);
    }

    public BigDecimal getSFPSIGrandTotal() {
        return (BigDecimal) get(COMPUTED_COLUMN_SFPSIGRANDTOTAL);
    }

    public void setSFPSIGrandTotal(BigDecimal sFPSIGrandTotal) {
        set(COMPUTED_COLUMN_SFPSIGRANDTOTAL, sFPSIGrandTotal);
    }

    public BigDecimal getSFPSIOutstandingAmt() {
        return (BigDecimal) get(COMPUTED_COLUMN_SFPSIOUTSTANDINGAMT);
    }

    public void setSFPSIOutstandingAmt(BigDecimal sFPSIOutstandingAmt) {
        set(COMPUTED_COLUMN_SFPSIOUTSTANDINGAMT, sFPSIOutstandingAmt);
    }

    public BigDecimal getSFPSITotalDiscount() {
        return (BigDecimal) get(COMPUTED_COLUMN_SFPSITOTALDISCOUNT);
    }

    public void setSFPSITotalDiscount(BigDecimal sFPSITotalDiscount) {
        set(COMPUTED_COLUMN_SFPSITOTALDISCOUNT, sFPSITotalDiscount);
    }

    public BigDecimal getSFPSITotalLines() {
        return (BigDecimal) get(COMPUTED_COLUMN_SFPSITOTALLINES);
    }

    public void setSFPSITotalLines(BigDecimal sFPSITotalLines) {
        set(COMPUTED_COLUMN_SFPSITOTALLINES, sFPSITotalLines);
    }

    public BigDecimal getSFPSITotalVAT() {
        return (BigDecimal) get(COMPUTED_COLUMN_SFPSITOTALVAT);
    }

    public void setSFPSITotalVAT(BigDecimal sFPSITotalVAT) {
        set(COMPUTED_COLUMN_SFPSITOTALVAT, sFPSITotalVAT);
    }

    public Invoice getSswhCreditnotereference() {
        return (Invoice) get(PROPERTY_SSWHCREDITNOTEREFERENCE);
    }

    public void setSswhCreditnotereference(Invoice sswhCreditnotereference) {
        set(PROPERTY_SSWHCREDITNOTEREFERENCE, sswhCreditnotereference);
    }

    public Invoice_ComputedColumns get_computedColumns() {
        return (Invoice_ComputedColumns) get(PROPERTY__COMPUTEDCOLUMNS);
    }

    public void set_computedColumns(Invoice_ComputedColumns _computedColumns) {
        set(PROPERTY__COMPUTEDCOLUMNS, _computedColumns);
    }

    @SuppressWarnings("unchecked")
    public List<APRMPendingPaymentFromInvoice> getAPRMPendingPaymentInvoiceList() {
      return (List<APRMPendingPaymentFromInvoice>) get(PROPERTY_APRMPENDINGPAYMENTINVOICELIST);
    }

    public void setAPRMPendingPaymentInvoiceList(List<APRMPendingPaymentFromInvoice> aPRMPendingPaymentInvoiceList) {
        set(PROPERTY_APRMPENDINGPAYMENTINVOICELIST, aPRMPendingPaymentInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceTaxCashVAT_V> getInvoiceTaxCashVATVList() {
      return (List<InvoiceTaxCashVAT_V>) get(PROPERTY_INVOICETAXCASHVATVLIST);
    }

    public void setInvoiceTaxCashVATVList(List<InvoiceTaxCashVAT_V> invoiceTaxCashVATVList) {
        set(PROPERTY_INVOICETAXCASHVATVLIST, invoiceTaxCashVATVList);
    }

    @SuppressWarnings("unchecked")
    public List<ConversionRateDoc> getCurrencyConversionRateDocList() {
      return (List<ConversionRateDoc>) get(PROPERTY_CURRENCYCONVERSIONRATEDOCLIST);
    }

    public void setCurrencyConversionRateDocList(List<ConversionRateDoc> currencyConversionRateDocList) {
        set(PROPERTY_CURRENCYCONVERSIONRATEDOCLIST, currencyConversionRateDocList);
    }

    @SuppressWarnings("unchecked")
    public List<eeirRefund> getEEIRRefundList() {
      return (List<eeirRefund>) get(PROPERTY_EEIRREFUNDLIST);
    }

    public void setEEIRRefundList(List<eeirRefund> eEIRRefundList) {
        set(PROPERTY_EEIRREFUNDLIST, eEIRRefundList);
    }

    @SuppressWarnings("unchecked")
    public List<eeirRefund> getEEIRRefundEeirInvoiceIDList() {
      return (List<eeirRefund>) get(PROPERTY_EEIRREFUNDEEIRINVOICEIDLIST);
    }

    public void setEEIRRefundEeirInvoiceIDList(List<eeirRefund> eEIRRefundEeirInvoiceIDList) {
        set(PROPERTY_EEIRREFUNDEEIRINVOICEIDLIST, eEIRRefundEeirInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Contingency> getEEIContingencyList() {
      return (List<Contingency>) get(PROPERTY_EEICONTINGENCYLIST);
    }

    public void setEEIContingencyList(List<Contingency> eEIContingencyList) {
        set(PROPERTY_EEICONTINGENCYLIST, eEIContingencyList);
    }

    @SuppressWarnings("unchecked")
    public List<EEIInvoiceLog> getEEIInvoicelogList() {
      return (List<EEIInvoiceLog>) get(PROPERTY_EEIINVOICELOGLIST);
    }

    public void setEEIInvoicelogList(List<EEIInvoiceLog> eEIInvoicelogList) {
        set(PROPERTY_EEIINVOICELOGLIST, eEIInvoicelogList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionEMSsccrCInvoiceIDList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONEMSSCCRCINVOICEIDLIST);
    }

    public void setFINFinaccTransactionEMSsccrCInvoiceIDList(List<FIN_FinaccTransaction> fINFinaccTransactionEMSsccrCInvoiceIDList) {
        set(PROPERTY_FINFINACCTRANSACTIONEMSSCCRCINVOICEIDLIST, fINFinaccTransactionEMSsccrCInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedInvV> getFINPaymentSchedInvVList() {
      return (List<FIN_PaymentSchedInvV>) get(PROPERTY_FINPAYMENTSCHEDINVVLIST);
    }

    public void setFINPaymentSchedInvVList(List<FIN_PaymentSchedInvV> fINPaymentSchedInvVList) {
        set(PROPERTY_FINPAYMENTSCHEDINVVLIST, fINPaymentSchedInvVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedOrdV> getFINPaymentSchedOrdVList() {
      return (List<FIN_PaymentSchedOrdV>) get(PROPERTY_FINPAYMENTSCHEDORDVLIST);
    }

    public void setFINPaymentSchedOrdVList(List<FIN_PaymentSchedOrdV> fINPaymentSchedOrdVList) {
        set(PROPERTY_FINPAYMENTSCHEDORDVLIST, fINPaymentSchedOrdVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentSchedule> getFINPaymentScheduleList() {
      return (List<FIN_PaymentSchedule>) get(PROPERTY_FINPAYMENTSCHEDULELIST);
    }

    public void setFINPaymentScheduleList(List<FIN_PaymentSchedule> fINPaymentScheduleList) {
        set(PROPERTY_FINPAYMENTSCHEDULELIST, fINPaymentScheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<Fin_OrigPaymentSchedule> getFinOrigPaymentScheduleList() {
      return (List<Fin_OrigPaymentSchedule>) get(PROPERTY_FINORIGPAYMENTSCHEDULELIST);
    }

    public void setFinOrigPaymentScheduleList(List<Fin_OrigPaymentSchedule> finOrigPaymentScheduleList) {
        set(PROPERTY_FINORIGPAYMENTSCHEDULELIST, finOrigPaymentScheduleList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsapiInvoiceIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSAPIINVOICEIDLIST);
    }

    public void setFinancialMgmtAssetEMSsapiInvoiceIDList(List<Asset> financialMgmtAssetEMSsapiInvoiceIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSAPIINVOICEIDLIST, financialMgmtAssetEMSsapiInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Asset> getFinancialMgmtAssetEMSsacInvoiceIDList() {
      return (List<Asset>) get(PROPERTY_FINANCIALMGMTASSETEMSSACINVOICEIDLIST);
    }

    public void setFinancialMgmtAssetEMSsacInvoiceIDList(List<Asset> financialMgmtAssetEMSsacInvoiceIDList) {
        set(PROPERTY_FINANCIALMGMTASSETEMSSACINVOICEIDLIST, financialMgmtAssetEMSsacInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
      return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentCancelV> getFinancialMgmtDebtPaymentCancelVList() {
      return (List<DebtPaymentCancelV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST);
    }

    public void setFinancialMgmtDebtPaymentCancelVList(List<DebtPaymentCancelV> financialMgmtDebtPaymentCancelVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTCANCELVLIST, financialMgmtDebtPaymentCancelVList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentGenerateV> getFinancialMgmtDebtPaymentGenerateVList() {
      return (List<DebtPaymentGenerateV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST);
    }

    public void setFinancialMgmtDebtPaymentGenerateVList(List<DebtPaymentGenerateV> financialMgmtDebtPaymentGenerateVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, financialMgmtDebtPaymentGenerateVList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMScnrInvoiceIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSCNRINVOICEIDLIST);
    }

    public void setInvoiceEMScnrInvoiceIDList(List<Invoice> invoiceEMScnrInvoiceIDList) {
        set(PROPERTY_INVOICEEMSCNRINVOICEIDLIST, invoiceEMScnrInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMSswhInvoiceRefList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSWHINVOICEREFLIST);
    }

    public void setInvoiceEMSswhInvoiceRefList(List<Invoice> invoiceEMSswhInvoiceRefList) {
        set(PROPERTY_INVOICEEMSSWHINVOICEREFLIST, invoiceEMSswhInvoiceRefList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEMEeiRefInvIDList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMEEIREFINVIDLIST);
    }

    public void setInvoiceEMEeiRefInvIDList(List<Invoice> invoiceEMEeiRefInvIDList) {
        set(PROPERTY_INVOICEEMEEIREFINVIDLIST, invoiceEMEeiRefInvIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceEmSswhCreditnotereferenceList() {
      return (List<Invoice>) get(PROPERTY_INVOICEEMSSWHCREDITNOTEREFERENCELIST);
    }

    public void setInvoiceEmSswhCreditnotereferenceList(List<Invoice> invoiceEmSswhCreditnotereferenceList) {
        set(PROPERTY_INVOICEEMSSWHCREDITNOTEREFERENCELIST, invoiceEmSswhCreditnotereferenceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceDiscount> getInvoiceDiscountList() {
      return (List<InvoiceDiscount>) get(PROPERTY_INVOICEDISCOUNTLIST);
    }

    public void setInvoiceDiscountList(List<InvoiceDiscount> invoiceDiscountList) {
        set(PROPERTY_INVOICEDISCOUNTLIST, invoiceDiscountList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsreRefundedinvoiceRefIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSREREFUNDEDINVOICEREFIDLIST);
    }

    public void setInvoiceLineEMSsreRefundedinvoiceRefIDList(List<InvoiceLine> invoiceLineEMSsreRefundedinvoiceRefIDList) {
        set(PROPERTY_INVOICELINEEMSSREREFUNDEDINVOICEREFIDLIST, invoiceLineEMSsreRefundedinvoiceRefIDList);
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
    public List<InvoiceTax> getInvoiceTaxList() {
      return (List<InvoiceTax>) get(PROPERTY_INVOICETAXLIST);
    }

    public void setInvoiceTaxList(List<InvoiceTax> invoiceTaxList) {
        set(PROPERTY_INVOICETAXLIST, invoiceTaxList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceV2> getInvoiceV2List() {
      return (List<InvoiceV2>) get(PROPERTY_INVOICEV2LIST);
    }

    public void setInvoiceV2List(List<InvoiceV2> invoiceV2List) {
        set(PROPERTY_INVOICEV2LIST, invoiceV2List);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionTransaction> getMaterialMgmtProductionTransactionEMSpinlCInvoiceIDList() {
      return (List<ProductionTransaction>) get(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPINLCINVOICEIDLIST);
    }

    public void setMaterialMgmtProductionTransactionEMSpinlCInvoiceIDList(List<ProductionTransaction> materialMgmtProductionTransactionEMSpinlCInvoiceIDList) {
        set(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONEMSPINLCINVOICEIDLIST, materialMgmtProductionTransactionEMSpinlCInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderEMSICUSInvoiceToReturnList() {
      return (List<Order>) get(PROPERTY_ORDEREMSICUSINVOICETORETURNLIST);
    }

    public void setOrderEMSICUSInvoiceToReturnList(List<Order> orderEMSICUSInvoiceToReturnList) {
        set(PROPERTY_ORDEREMSICUSINVOICETORETURNLIST, orderEMSICUSInvoiceToReturnList);
    }

    @SuppressWarnings("unchecked")
    public List<DiscountInvoice> getPricingVolumeDiscountInvoiceList() {
      return (List<DiscountInvoice>) get(PROPERTY_PRICINGVOLUMEDISCOUNTINVOICELIST);
    }

    public void setPricingVolumeDiscountInvoiceList(List<DiscountInvoice> pricingVolumeDiscountInvoiceList) {
        set(PROPERTY_PRICINGVOLUMEDISCOUNTINVOICELIST, pricingVolumeDiscountInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<ReversedInvoice> getReversedInvoicesList() {
      return (List<ReversedInvoice>) get(PROPERTY_REVERSEDINVOICESLIST);
    }

    public void setReversedInvoicesList(List<ReversedInvoice> reversedInvoicesList) {
        set(PROPERTY_REVERSEDINVOICESLIST, reversedInvoicesList);
    }

    @SuppressWarnings("unchecked")
    public List<ReversedInvoice> getReversedInvoicesReversedInvoiceList() {
      return (List<ReversedInvoice>) get(PROPERTY_REVERSEDINVOICESREVERSEDINVOICELIST);
    }

    public void setReversedInvoicesReversedInvoiceList(List<ReversedInvoice> reversedInvoicesReversedInvoiceList) {
        set(PROPERTY_REVERSEDINVOICESREVERSEDINVOICELIST, reversedInvoicesReversedInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SRSISalesInvoiceV> getSRSISalesInvoiceVList() {
      return (List<SRSISalesInvoiceV>) get(PROPERTY_SRSISALESINVOICEVLIST);
    }

    public void setSRSISalesInvoiceVList(List<SRSISalesInvoiceV> sRSISalesInvoiceVList) {
        set(PROPERTY_SRSISALESINVOICEVLIST, sRSISalesInvoiceVList);
    }

    @SuppressWarnings("unchecked")
    public List<QuotaDetailLine> getSSDQSIQuotaDetailLineList() {
      return (List<QuotaDetailLine>) get(PROPERTY_SSDQSIQUOTADETAILLINELIST);
    }

    public void setSSDQSIQuotaDetailLineList(List<QuotaDetailLine> sSDQSIQuotaDetailLineList) {
        set(PROPERTY_SSDQSIQUOTADETAILLINELIST, sSDQSIQuotaDetailLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SSPI_PaymentSchedOrdV> getSSPPIPaymentSchedOrdVList() {
      return (List<SSPI_PaymentSchedOrdV>) get(PROPERTY_SSPPIPAYMENTSCHEDORDVLIST);
    }

    public void setSSPPIPaymentSchedOrdVList(List<SSPI_PaymentSchedOrdV> sSPPIPaymentSchedOrdVList) {
        set(PROPERTY_SSPPIPAYMENTSCHEDORDVLIST, sSPPIPaymentSchedOrdVList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWHCheckbookposLine> getSSWHCheckbookposLineList() {
      return (List<SSWHCheckbookposLine>) get(PROPERTY_SSWHCHECKBOOKPOSLINELIST);
    }

    public void setSSWHCheckbookposLineList(List<SSWHCheckbookposLine> sSWHCheckbookposLineList) {
        set(PROPERTY_SSWHCHECKBOOKPOSLINELIST, sSWHCheckbookposLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Receipt> getSSWHReceiptList() {
      return (List<Receipt>) get(PROPERTY_SSWHRECEIPTLIST);
    }

    public void setSSWHReceiptList(List<Receipt> sSWHReceiptList) {
        set(PROPERTY_SSWHRECEIPTLIST, sSWHReceiptList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSale> getSSWSWithholdingSaleList() {
      return (List<SSWSWithholdingSale>) get(PROPERTY_SSWSWITHHOLDINGSALELIST);
    }

    public void setSSWSWithholdingSaleList(List<SSWSWithholdingSale> sSWSWithholdingSaleList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELIST, sSWSWithholdingSaleList);
    }

    @SuppressWarnings("unchecked")
    public List<CommissionRun> getSalesCommissionRunList() {
      return (List<CommissionRun>) get(PROPERTY_SALESCOMMISSIONRUNLIST);
    }

    public void setSalesCommissionRunList(List<CommissionRun> salesCommissionRunList) {
        set(PROPERTY_SALESCOMMISSIONRUNLIST, salesCommissionRunList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrFinaccTransV> getSsccrFinaccTransVList() {
      return (List<SsccrFinaccTransV>) get(PROPERTY_SSCCRFINACCTRANSVLIST);
    }

    public void setSsccrFinaccTransVList(List<SsccrFinaccTransV> ssccrFinaccTransVList) {
        set(PROPERTY_SSCCRFINACCTRANSVLIST, ssccrFinaccTransVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrPosCardRecLine> getSsccrPosCardRecLineList() {
      return (List<SsccrPosCardRecLine>) get(PROPERTY_SSCCRPOSCARDRECLINELIST);
    }

    public void setSsccrPosCardRecLineList(List<SsccrPosCardRecLine> ssccrPosCardRecLineList) {
        set(PROPERTY_SSCCRPOSCARDRECLINELIST, ssccrPosCardRecLineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsfiInvoiceSummaryV> getSsfiInvoiceSummaryVList() {
      return (List<SsfiInvoiceSummaryV>) get(PROPERTY_SSFIINVOICESUMMARYVLIST);
    }

    public void setSsfiInvoiceSummaryVList(List<SsfiInvoiceSummaryV> ssfiInvoiceSummaryVList) {
        set(PROPERTY_SSFIINVOICESUMMARYVLIST, ssfiInvoiceSummaryVList);
    }

    @SuppressWarnings("unchecked")
    public List<SsmaactModifyAcct> getSsmaactModifyAcctList() {
      return (List<SsmaactModifyAcct>) get(PROPERTY_SSMAACTMODIFYACCTLIST);
    }

    public void setSsmaactModifyAcctList(List<SsmaactModifyAcct> ssmaactModifyAcctList) {
        set(PROPERTY_SSMAACTMODIFYACCTLIST, ssmaactModifyAcctList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchInvoice> getSspchInvoiceList() {
      return (List<SspchInvoice>) get(PROPERTY_SSPCHINVOICELIST);
    }

    public void setSspchInvoiceList(List<SspchInvoice> sspchInvoiceList) {
        set(PROPERTY_SSPCHINVOICELIST, sspchInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SspchPaymentPlan> getSspchPaymentPlanList() {
      return (List<SspchPaymentPlan>) get(PROPERTY_SSPCHPAYMENTPLANLIST);
    }

    public void setSspchPaymentPlanList(List<SspchPaymentPlan> sspchPaymentPlanList) {
        set(PROPERTY_SSPCHPAYMENTPLANLIST, sspchPaymentPlanList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhRptcPurchaseDetail> getSswhRptcPurchaseDetList() {
      return (List<SswhRptcPurchaseDetail>) get(PROPERTY_SSWHRPTCPURCHASEDETLIST);
    }

    public void setSswhRptcPurchaseDetList(List<SswhRptcPurchaseDetail> sswhRptcPurchaseDetList) {
        set(PROPERTY_SSWHRPTCPURCHASEDETLIST, sswhRptcPurchaseDetList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhRptcSalesRefund> getSswhRptcSalesRefundList() {
      return (List<SswhRptcSalesRefund>) get(PROPERTY_SSWHRPTCSALESREFUNDLIST);
    }

    public void setSswhRptcSalesRefundList(List<SswhRptcSalesRefund> sswhRptcSalesRefundList) {
        set(PROPERTY_SSWHRPTCSALESREFUNDLIST, sswhRptcSalesRefundList);
    }

    @SuppressWarnings("unchecked")
    public List<SswosVehicle> getSswosVehicleEMSatmacInvoiceIDList() {
      return (List<SswosVehicle>) get(PROPERTY_SSWOSVEHICLEEMSATMACINVOICEIDLIST);
    }

    public void setSswosVehicleEMSatmacInvoiceIDList(List<SswosVehicle> sswosVehicleEMSatmacInvoiceIDList) {
        set(PROPERTY_SSWOSVEHICLEEMSATMACINVOICEIDLIST, sswosVehicleEMSatmacInvoiceIDList);
    }

    @SuppressWarnings("unchecked")
    public List<withholdingcancel> getEcswcWithholdingCancelList() {
      return (List<withholdingcancel>) get(PROPERTY_ECSWCWITHHOLDINGCANCELLIST);
    }

    public void setEcswcWithholdingCancelList(List<withholdingcancel> ecswcWithholdingCancelList) {
        set(PROPERTY_ECSWCWITHHOLDINGCANCELLIST, ecswcWithholdingCancelList);
    }

    @SuppressWarnings("unchecked")
    public List<EeiPaymentDetailV> getEeiPaymentDetailVList() {
      return (List<EeiPaymentDetailV>) get(PROPERTY_EEIPAYMENTDETAILVLIST);
    }

    public void setEeiPaymentDetailVList(List<EeiPaymentDetailV> eeiPaymentDetailVList) {
        set(PROPERTY_EEIPAYMENTDETAILVLIST, eeiPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<eeiviewinvoice> getEeiViewInvoiceList() {
      return (List<eeiviewinvoice>) get(PROPERTY_EEIVIEWINVOICELIST);
    }

    public void setEeiViewInvoiceList(List<eeiviewinvoice> eeiViewInvoiceList) {
        set(PROPERTY_EEIVIEWINVOICELIST, eeiViewInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<ProcessFETest> getFetsTestList() {
      return (List<ProcessFETest>) get(PROPERTY_FETSTESTLIST);
    }

    public void setFetsTestList(List<ProcessFETest> fetsTestList) {
        set(PROPERTY_FETSTESTLIST, fetsTestList);
    }

    @SuppressWarnings("unchecked")
    public List<Imdlv_Lines> getImdlvLinesList() {
      return (List<Imdlv_Lines>) get(PROPERTY_IMDLVLINESLIST);
    }

    public void setImdlvLinesList(List<Imdlv_Lines> imdlvLinesList) {
        set(PROPERTY_IMDLVLINESLIST, imdlvLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrminvoice> getOpcrmInvoiceList() {
      return (List<Opcrminvoice>) get(PROPERTY_OPCRMINVOICELIST);
    }

    public void setOpcrmInvoiceList(List<Opcrminvoice> opcrmInvoiceList) {
        set(PROPERTY_OPCRMINVOICELIST, opcrmInvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<Opcrmopportunities> getOpcrmOpportunitiesList() {
      return (List<Opcrmopportunities>) get(PROPERTY_OPCRMOPPORTUNITIESLIST);
    }

    public void setOpcrmOpportunitiesList(List<Opcrmopportunities> opcrmOpportunitiesList) {
        set(PROPERTY_OPCRMOPPORTUNITIESLIST, opcrmOpportunitiesList);
    }

    @SuppressWarnings("unchecked")
    public List<Sdcc_DailyClossingLine> getSdccDailyClossinglineList() {
      return (List<Sdcc_DailyClossingLine>) get(PROPERTY_SDCCDAILYCLOSSINGLINELIST);
    }

    public void setSdccDailyClossinglineList(List<Sdcc_DailyClossingLine> sdccDailyClossinglineList) {
        set(PROPERTY_SDCCDAILYCLOSSINGLINELIST, sdccDailyClossinglineList);
    }

    @SuppressWarnings("unchecked")
    public List<Simppys_PaymentDetail> getSimppysPaymentDetailList() {
      return (List<Simppys_PaymentDetail>) get(PROPERTY_SIMPPYSPAYMENTDETAILLIST);
    }

    public void setSimppysPaymentDetailList(List<Simppys_PaymentDetail> simppysPaymentDetailList) {
        set(PROPERTY_SIMPPYSPAYMENTDETAILLIST, simppysPaymentDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienateline> getSsamAlienatelineList() {
      return (List<ssamalienateline>) get(PROPERTY_SSAMALIENATELINELIST);
    }

    public void setSsamAlienatelineList(List<ssamalienateline> ssamAlienatelineList) {
        set(PROPERTY_SSAMALIENATELINELIST, ssamAlienatelineList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssccr_CardRecDetailV> getSsccrCardRecDetailVList() {
      return (List<Ssccr_CardRecDetailV>) get(PROPERTY_SSCCRCARDRECDETAILVLIST);
    }

    public void setSsccrCardRecDetailVList(List<Ssccr_CardRecDetailV> ssccrCardRecDetailVList) {
        set(PROPERTY_SSCCRCARDRECDETAILVLIST, ssccrCardRecDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<SscflwExpensivePayoutView> getSscflwExpensivePayoutVList() {
      return (List<SscflwExpensivePayoutView>) get(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST);
    }

    public void setSscflwExpensivePayoutVList(List<SscflwExpensivePayoutView> sscflwExpensivePayoutVList) {
        set(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, sscflwExpensivePayoutVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssctpayment> getSsctPaymentList() {
      return (List<ssctpayment>) get(PROPERTY_SSCTPAYMENTLIST);
    }

    public void setSsctPaymentList(List<ssctpayment> ssctPaymentList) {
        set(PROPERTY_SSCTPAYMENTLIST, ssctPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdccpDistributeCostCenter> getSsdccpDistcostcenterList() {
      return (List<SsdccpDistributeCostCenter>) get(PROPERTY_SSDCCPDISTCOSTCENTERLIST);
    }

    public void setSsdccpDistcostcenterList(List<SsdccpDistributeCostCenter> ssdccpDistcostcenterList) {
        set(PROPERTY_SSDCCPDISTCOSTCENTERLIST, ssdccpDistcostcenterList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidPendingInterest> getSsdnidPendinginterestList() {
      return (List<SsdnidPendingInterest>) get(PROPERTY_SSDNIDPENDINGINTERESTLIST);
    }

    public void setSsdnidPendinginterestList(List<SsdnidPendingInterest> ssdnidPendinginterestList) {
        set(PROPERTY_SSDNIDPENDINGINTERESTLIST, ssdnidPendinginterestList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdnidPendingInterest> getSsdnidPendinginterestDebitnoteIDList() {
      return (List<SsdnidPendingInterest>) get(PROPERTY_SSDNIDPENDINGINTERESTDEBITNOTEIDLIST);
    }

    public void setSsdnidPendinginterestDebitnoteIDList(List<SsdnidPendingInterest> ssdnidPendinginterestDebitnoteIDList) {
        set(PROPERTY_SSDNIDPENDINGINTERESTDEBITNOTEIDLIST, ssdnidPendinginterestDebitnoteIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssfiFin_payment_detail_v> getSsfiFinPaymentDetailVList() {
      return (List<ssfiFin_payment_detail_v>) get(PROPERTY_SSFIFINPAYMENTDETAILVLIST);
    }

    public void setSsfiFinPaymentDetailVList(List<ssfiFin_payment_detail_v> ssfiFinPaymentDetailVList) {
        set(PROPERTY_SSFIFINPAYMENTDETAILVLIST, ssfiFinPaymentDetailVList);
    }

    @SuppressWarnings("unchecked")
    public List<Ssipotm_PartialDispatch> getSsipotmPartialDispatchList() {
      return (List<Ssipotm_PartialDispatch>) get(PROPERTY_SSIPOTMPARTIALDISPATCHLIST);
    }

    public void setSsipotmPartialDispatchList(List<Ssipotm_PartialDispatch> ssipotmPartialDispatchList) {
        set(PROPERTY_SSIPOTMPARTIALDISPATCHLIST, ssipotmPartialDispatchList);
    }

    @SuppressWarnings("unchecked")
    public List<ssorel_invoiceorder_v> getSsorelInvoiceorderVList() {
      return (List<ssorel_invoiceorder_v>) get(PROPERTY_SSORELINVOICEORDERVLIST);
    }

    public void setSsorelInvoiceorderVList(List<ssorel_invoiceorder_v> ssorelInvoiceorderVList) {
        set(PROPERTY_SSORELINVOICEORDERVLIST, ssorelInvoiceorderVList);
    }

    @SuppressWarnings("unchecked")
    public List<SspitraCtDetail> getSspitraCtDetailList() {
      return (List<SspitraCtDetail>) get(PROPERTY_SSPITRACTDETAILLIST);
    }

    public void setSspitraCtDetailList(List<SspitraCtDetail> sspitraCtDetailList) {
        set(PROPERTY_SSPITRACTDETAILLIST, sspitraCtDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SsppinvSelectedInvoices> getSsppinvSelectedinvoicesList() {
      return (List<SsppinvSelectedInvoices>) get(PROPERTY_SSPPINVSELECTEDINVOICESLIST);
    }

    public void setSsppinvSelectedinvoicesList(List<SsppinvSelectedInvoices> ssppinvSelectedinvoicesList) {
        set(PROPERTY_SSPPINVSELECTEDINVOICESLIST, ssppinvSelectedinvoicesList);
    }

    @SuppressWarnings("unchecked")
    public List<ssrerefundinvoice> getSsreRefundinvoiceList() {
      return (List<ssrerefundinvoice>) get(PROPERTY_SSREREFUNDINVOICELIST);
    }

    public void setSsreRefundinvoiceList(List<ssrerefundinvoice> ssreRefundinvoiceList) {
        set(PROPERTY_SSREREFUNDINVOICELIST, ssreRefundinvoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcRelatedRevenue> getSstpcRelatedRevenueList() {
      return (List<SstpcRelatedRevenue>) get(PROPERTY_SSTPCRELATEDREVENUELIST);
    }

    public void setSstpcRelatedRevenueList(List<SstpcRelatedRevenue> sstpcRelatedRevenueList) {
        set(PROPERTY_SSTPCRELATEDREVENUELIST, sstpcRelatedRevenueList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhDcNote> getSswhDcNoteList() {
      return (List<SswhDcNote>) get(PROPERTY_SSWHDCNOTELIST);
    }

    public void setSswhDcNoteList(List<SswhDcNote> sswhDcNoteList) {
        set(PROPERTY_SSWHDCNOTELIST, sswhDcNoteList);
    }

    @SuppressWarnings("unchecked")
    public List<SswhInvoiceExportation> getSswhInvExportationList() {
      return (List<SswhInvoiceExportation>) get(PROPERTY_SSWHINVEXPORTATIONLIST);
    }

    public void setSswhInvExportationList(List<SswhInvoiceExportation> sswhInvExportationList) {
        set(PROPERTY_SSWHINVEXPORTATIONLIST, sswhInvExportationList);
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
    public List<SWSPCLogs> getSwspcLogsList() {
      return (List<SWSPCLogs>) get(PROPERTY_SWSPCLOGSLIST);
    }

    public void setSwspcLogsList(List<SWSPCLogs> swspcLogsList) {
        set(PROPERTY_SWSPCLOGSLIST, swspcLogsList);
    }


    @Override
    public Object get(String propName) {
      if (COMPUTED_COLUMN_SSPPINVPASSSELECTED.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().isSsppinvPassSelected();
      }
      if (COMPUTED_COLUMN_SFPSICANCELEDDOCUMENT.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSFPSICanceledDocument();
      }
      if (COMPUTED_COLUMN_SFPSIGRANDTOTAL.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSFPSIGrandTotal();
      }
      if (COMPUTED_COLUMN_SFPSIOUTSTANDINGAMT.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSFPSIOutstandingAmt();
      }
      if (COMPUTED_COLUMN_SFPSITOTALDISCOUNT.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSFPSITotalDiscount();
      }
      if (COMPUTED_COLUMN_SFPSITOTALLINES.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSFPSITotalLines();
      }
      if (COMPUTED_COLUMN_SFPSITOTALVAT.equals(propName)) {
        if (get_computedColumns() == null) {
          return null;
        }
        return get_computedColumns().getSFPSITotalVAT();
      }
    
      return super.get(propName);
    }
}
