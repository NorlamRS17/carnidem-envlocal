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
package org.openbravo.model.financialmgmt.assetmgmt;

import com.sidesoft.ecuador.asset.allocation.SsalActiveMain;
import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.ssal_unit;
import com.sidesoft.ecuador.asset.allocation.ssalassetcom;
import com.sidesoft.ecuador.asset.allocation.ssalassetreturnline;
import com.sidesoft.ecuador.asset.allocation.ssalbuilding;
import com.sidesoft.ecuador.asset.allocation.ssaldepartment;
import com.sidesoft.ecuador.asset.allocation.ssalmark;
import com.sidesoft.ecuador.asset.allocation.ssalmodel;
import com.sidesoft.ecuador.asset.allocation.ssalstateasset;
import com.sidesoft.ecuador.asset.move.ssamalienate;
import com.sidesoft.ecuador.asset.move.ssamalienateline;
import com.sidesoft.ecuador.asset.subcategory.level.SSASLSubcategory;

import ec.com.sidesoft.asset.revaluation.SsarvValueChange;
import ec.com.sidesoft.asset.transfer.SsatrAssetDetail;
import ec.com.sidesoft.asset.transfer.SsatrAssetTransfer;
import ec.com.sidesoft.assets.changes.SSACHModifyAsset;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaCustodianLine;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaInventoryTakingLine;
import ec.com.sidesoft.ecuador.asset.purchase.info.SSAPIDocumenttype;
import ec.com.sidesoft.ecuador.asset.purchase.info.SSAPITrasactiontype;
import ec.com.sidesoft.localization.importdata.loadvouchers.Imdlv_Lines;
import ec.com.sidesoft.modify.accounting.SsmaactAccounting;
import ec.com.sidesoft.modify.accounting.SsmaactAudit;
import ec.com.sidesoft.saleorder.relations.ssorel_invoiceorder_v;
import ec.com.sidesoft.transaction.reversal.AccountingReversal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_Finacc_Trx_Full_Acct_V;
import org.openbravo.advpaymentmngt.FinAccTransactionAccounting;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceLineAccountingDimension;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineAccountingDimension;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.AccountingFact;
import org.openbravo.model.financialmgmt.accounting.BudgetLine;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
import org.openbravo.model.materialmgmt.transaction.InOutLineAccountingDimension;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.project.Project;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
/**
 * Entity class for entity FinancialMgmtAsset (stored in table A_Asset).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Asset extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "A_Asset";
    public static final String ENTITY_NAME = "FinancialMgmtAsset";
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
    public static final String PROPERTY_HELPCOMMENT = "helpComment";
    public static final String PROPERTY_ASSETCATEGORY = "assetCategory";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_SERIALNO = "serialNo";
    public static final String PROPERTY_LOTNAME = "lotName";
    public static final String PROPERTY_VERSIONNO = "versionNo";
    public static final String PROPERTY_EXPIRATIONDATE = "expirationDate";
    public static final String PROPERTY_INSERVICEDATE = "inServiceDate";
    public static final String PROPERTY_OWNED = "owned";
    public static final String PROPERTY_ASSETDEPRECIATIONDATE = "assetDepreciationDate";
    public static final String PROPERTY_USABLELIFEYEARS = "usableLifeYears";
    public static final String PROPERTY_USABLELIFEMONTHS = "usableLifeMonths";
    public static final String PROPERTY_LIFEUSE = "lifeUse";
    public static final String PROPERTY_USEUNITS = "useUnits";
    public static final String PROPERTY_DISPOSED = "disposed";
    public static final String PROPERTY_ASSETDISPOSALDATE = "assetDisposalDate";
    public static final String PROPERTY_INPOSSESSION = "inPossession";
    public static final String PROPERTY_LOCATIONCOMMENT = "locationComment";
    public static final String PROPERTY_STORAGEBIN = "storageBin";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_PARTNERADDRESS = "partnerAddress";
    public static final String PROPERTY_LOCATIONADDRESS = "locationAddress";
    public static final String PROPERTY_PROCESSNOW = "processNow";
    public static final String PROPERTY_DEPRECIATE = "depreciate";
    public static final String PROPERTY_FULLYDEPRECIATED = "fullyDepreciated";
    public static final String PROPERTY_USERCONTACT = "userContact";
    public static final String PROPERTY_DEPRECIATIONENDDATE = "depreciationEndDate";
    public static final String PROPERTY_DEPRECIATIONSTARTDATE = "depreciationStartDate";
    public static final String PROPERTY_ANNUALDEPRECIATION = "annualDepreciation";
    public static final String PROPERTY_ASSETVALUE = "assetValue";
    public static final String PROPERTY_CURRENCY = "currency";
    public static final String PROPERTY_CANCELLATIONDATE = "cancellationDate";
    public static final String PROPERTY_PURCHASEDATE = "purchaseDate";
    public static final String PROPERTY_ATTRIBUTESETVALUE = "attributeSetValue";
    public static final String PROPERTY_RESIDUALASSETVALUE = "residualAssetValue";
    public static final String PROPERTY_ACCTVALUEAMT = "acctvalueamt";
    public static final String PROPERTY_DEPRECIATIONTYPE = "depreciationType";
    public static final String PROPERTY_DEPRECIATIONAMT = "depreciationAmt";
    public static final String PROPERTY_AMORTIZE = "amortize";
    public static final String PROPERTY_DOCUMENTNO = "documentNo";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_PROFIT = "profit";
    public static final String PROPERTY_QUANTITY = "quantity";
    public static final String PROPERTY_CALCULATETYPE = "calculateType";
    public static final String PROPERTY_DEPRECIATEDPLAN = "depreciatedPlan";
    public static final String PROPERTY_PREVIOUSLYDEPRECIATEDAMT = "previouslyDepreciatedAmt";
    public static final String PROPERTY_DEPRECIATEDVALUE = "depreciatedValue";
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_PROJECT = "project";
    public static final String PROPERTY_STATIC = "static";
    public static final String PROPERTY_EVERYMONTHIS30DAYS = "everyMonthIs30Days";
    public static final String PROPERTY_SSALCDOCTYPE = "ssalCDoctype";
    public static final String PROPERTY_SSALDESCRIPTIONCH = "ssalDescriptionCh";
    public static final String PROPERTY_SSALVESSEL = "sSALVessel";
    public static final String PROPERTY_PROCESSASSET = "processAsset";
    public static final String PROPERTY_SSALMARK = "ssalMark";
    public static final String PROPERTY_SSALMODEL = "ssalModel";
    public static final String PROPERTY_SSALISAVAILABLE = "ssalIsavailable";
    public static final String PROPERTY_SSALSERIES = "ssalSeries";
    public static final String PROPERTY_SSALCUSTODIO = "ssalCustodio";
    public static final String PROPERTY_SSALBARCODE = "ssalBarCode";
    public static final String PROPERTY_SSALSTATEASSET = "ssalStateAsset";
    public static final String PROPERTY_SSAMALIENATED = "ssamAlienated";
    public static final String PROPERTY_SSAMSTATUS = "ssamStatus";
    public static final String PROPERTY_SSAMINVOICED = "ssamInvoiced";
    public static final String PROPERTY_SSALLOWREASON = "ssalLowreason";
    public static final String PROPERTY_SSAMCBPARTNER = "ssamCBpartner";
    public static final String PROPERTY_SSALLOWDATE = "ssalLowdate";
    public static final String PROPERTY_SSAMTAXID = "ssamTaxid";
    public static final String PROPERTY_SSALLOWPROCESS = "ssalLowprocess";
    public static final String PROPERTY_SSAMNETWORTH = "ssamNetWorth";
    public static final String PROPERTY_SSALLOWSTATUS = "ssalLowstatus";
    public static final String PROPERTY_SSAMMODEL = "ssamModel";
    public static final String PROPERTY_SSAMSERIE = "ssamSerie";
    public static final String PROPERTY_SDADERECOGNITION = "sdaDerecognition";
    public static final String PROPERTY_SSAMBRAND = "ssamBrand";
    public static final String PROPERTY_SSAMREPLACEMENTVALUE = "ssamReplacementValue";
    public static final String PROPERTY_SSAMCONDITION = "ssamCondition";
    public static final String PROPERTY_SSAMASSETTYPE = "ssamAssettype";
    public static final String PROPERTY_SSAMALIENATELINE = "ssamAlienateline";
    public static final String PROPERTY_SSAMSTATUSDEP = "ssamStatusdep";
    public static final String PROPERTY_SSAMCHANGEOFVALUE = "ssamChangeofvalue";
    public static final String PROPERTY_SSAMTYPEOFCHANGE = "ssamTypeofchange";
    public static final String PROPERTY_SSASLSUBCATEGORY = "ssaslSubcategory";
    public static final String PROPERTY_SSAMOBSERVATIONS = "ssamObservations";
    public static final String PROPERTY_SSAPIPROVIDER = "ssapiProvider";
    public static final String PROPERTY_SSAPIINVOICENO = "ssapiInvoiceno";
    public static final String PROPERTY_SSAPITRASACTIONTYPE = "ssapiTrasactiontype";
    public static final String PROPERTY_SSAPIDOCUMENTTYPE = "ssapiDocumenttype";
    public static final String PROPERTY_SSALBUILDING = "ssalBuilding";
    public static final String PROPERTY_SSALUNIT = "ssalUnit";
    public static final String PROPERTY_SSALDEPARTMENT = "ssalDepartment";
    public static final String PROPERTY_SSAPIINVOICE = "ssapiInvoice";
    public static final String PROPERTY_SSAPIBPARTNER = "ssapiBpartner";
    public static final String PROPERTY_SSAMADDDESCRIPTION = "ssamAddDescription";
    public static final String PROPERTY_SSAMREFERENCE = "ssamReference";
    public static final String PROPERTY_SSARCOLOR = "ssarColor";
    public static final String PROPERTY_SSARMEASUREMENTS = "ssarMeasurements";
    public static final String PROPERTY_SSAROTHERATTRIBUTES = "ssarOtherAttributes";
    public static final String PROPERTY_SSARWARRANTYDATE = "ssarWarrantyDate";
    public static final String PROPERTY_SSACINVOICE = "ssacInvoice";
    public static final String PROPERTY_SSAMVALUEINBOOKS = "ssamValueInBooks";
    public static final String PROPERTY_SSARVDEPRECIATIONPLAN = "ssarvDepreciationPlan";
    public static final String PROPERTY_STDIMENSION = "stDimension";
    public static final String PROPERTY_NDDIMENSION = "ndDimension";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_SEACTABPROCESS = "seactAbprocess";
    public static final String PROPERTY_SEACTABREACTIVATE = "seactAbreactivate";
    public static final String PROPERTY_SSATAXCTAXCATEGORY = "ssataxCTaxcategory";
    public static final String PROPERTY_SSATAXTAXAMT = "ssataxTaxamt";
    public static final String PROPERTY_SSATAXTOTALPURCHASEAMT = "ssataxTotalpurchaseamt";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST = "amortizationLineAccountingDimensionList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST = "financialMgmtAmortizationLineList";
    public static final String PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST = "financialMgmtAssetAccountsList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST = "inOutLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEEMSSAMAASSETIDLIST = "invoiceLineEMSsamAAssetIDList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST = "materialMgmtInternalMovementList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST = "materialMgmtInventoryCountList";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST = "materialMgmtProductionTransactionList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_STXREVFINANCIALLACCOUNTINGLIST = "sTXREVFinanciallAccountingList";
    public static final String PROPERTY_SSMAACTACCOUNTINGLIST = "ssmaactAccountingList";
    public static final String PROPERTY_SSMAACTAUDITLIST = "ssmaactAuditList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLIST = "timeAndExpenseSheetList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_CSAAACUSTODIANLINELIST = "csaaaCustodianlineList";
    public static final String PROPERTY_CSAAACUSTODIANLINEBARCODEIDLIST = "csaaaCustodianlineBarcodeIDList";
    public static final String PROPERTY_CSAAAINVTTKGLINELIST = "csaaaInvtTkgLineList";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";
    public static final String PROPERTY_SSACHMODIFYASSETLIST = "ssachModifyAssetList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALACTIVEMAINCDIGOACTIVOLIST = "ssalActiveMainCdigoActivoList";
    public static final String PROPERTY_SSALACTIVEMAINUPCEANLIST = "ssalActiveMainUPCEANList";
    public static final String PROPERTY_SSALACTIVEMAINDESCRIPTIONACTIVELIST = "ssalActiveMainDescriptionActiveList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST = "ssalApplActiveAAssetCodIDList";
    public static final String PROPERTY_SSALAPPLACTIVEUPCEANLIST = "ssalApplActiveUPCEANList";
    public static final String PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST = "ssalApplActiveDescriptionActiveList";
    public static final String PROPERTY_SSALASSETCOMLIST = "ssalAssetComList";
    public static final String PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST = "ssalAssetReturnlineCdigoActivoList";
    public static final String PROPERTY_SSALASSETRETURNLINEUPCEANLIST = "ssalAssetReturnlineUPCEANList";
    public static final String PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST = "ssalAssetReturnlineDescriptionActiveList";
    public static final String PROPERTY_SSAMALIENATEAASSETSTARTIDLIST = "ssamAlienateAAssetstartIDList";
    public static final String PROPERTY_SSAMALIENATEAASSETENDIDLIST = "ssamAlienateAAssetendIDList";
    public static final String PROPERTY_SSAMALIENATELINELIST = "ssamAlienatelineList";
    public static final String PROPERTY_SSARVVALUECHANGELIST = "ssarvValueChangeList";
    public static final String PROPERTY_SSATRASSETDETAILLIST = "ssatrAssetDetailList";
    public static final String PROPERTY_SSATRASSETTRANSFERLIST = "ssatrAssetTransferList";
    public static final String PROPERTY_SSORELINVOICEORDERVLIST = "ssorelInvoiceorderVList";

    public Asset() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_OWNED, false);
        setDefaultValue(PROPERTY_DISPOSED, false);
        setDefaultValue(PROPERTY_INPOSSESSION, false);
        setDefaultValue(PROPERTY_PROCESSNOW, false);
        setDefaultValue(PROPERTY_DEPRECIATE, false);
        setDefaultValue(PROPERTY_FULLYDEPRECIATED, false);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_DEPRECIATEDPLAN, new BigDecimal(0));
        setDefaultValue(PROPERTY_PREVIOUSLYDEPRECIATEDAMT, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEPRECIATEDVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_STATIC, false);
        setDefaultValue(PROPERTY_EVERYMONTHIS30DAYS, true);
        setDefaultValue(PROPERTY_SSALVESSEL, false);
        setDefaultValue(PROPERTY_PROCESSASSET, "N");
        setDefaultValue(PROPERTY_SSALISAVAILABLE, true);
        setDefaultValue(PROPERTY_SSAMALIENATED, false);
        setDefaultValue(PROPERTY_SSAMINVOICED, "N");
        setDefaultValue(PROPERTY_SSALLOWPROCESS, false);
        setDefaultValue(PROPERTY_SSAMNETWORTH, new BigDecimal(0));
        setDefaultValue(PROPERTY_SDADERECOGNITION, false);
        setDefaultValue(PROPERTY_SSAMREPLACEMENTVALUE, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSAMCHANGEOFVALUE, false);
        setDefaultValue(PROPERTY_SSAMVALUEINBOOKS, new BigDecimal(0));
        setDefaultValue(PROPERTY_SSARVDEPRECIATIONPLAN, false);
        setDefaultValue(PROPERTY_SEACTABPROCESS, false);
        setDefaultValue(PROPERTY_SEACTABREACTIVATE, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEEMSSAMAASSETIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTAUDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEBARCODEIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAAINVTTKGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSACHMODIFYASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINCDIGOACTIVOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINUPCEANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINDESCRIPTIONACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVEUPCEANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETCOMLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINEUPCEANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATEAASSETSTARTIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATEAASSETENDIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSAMALIENATELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSARVVALUECHANGELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSATRASSETTRANSFERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSORELINVOICEORDERVLIST, new ArrayList<Object>());
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

    public String getHelpComment() {
        return (String) get(PROPERTY_HELPCOMMENT);
    }

    public void setHelpComment(String helpComment) {
        set(PROPERTY_HELPCOMMENT, helpComment);
    }

    public AssetGroup getAssetCategory() {
        return (AssetGroup) get(PROPERTY_ASSETCATEGORY);
    }

    public void setAssetCategory(AssetGroup assetCategory) {
        set(PROPERTY_ASSETCATEGORY, assetCategory);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public String getSerialNo() {
        return (String) get(PROPERTY_SERIALNO);
    }

    public void setSerialNo(String serialNo) {
        set(PROPERTY_SERIALNO, serialNo);
    }

    public String getLotName() {
        return (String) get(PROPERTY_LOTNAME);
    }

    public void setLotName(String lotName) {
        set(PROPERTY_LOTNAME, lotName);
    }

    public String getVersionNo() {
        return (String) get(PROPERTY_VERSIONNO);
    }

    public void setVersionNo(String versionNo) {
        set(PROPERTY_VERSIONNO, versionNo);
    }

    public Date getExpirationDate() {
        return (Date) get(PROPERTY_EXPIRATIONDATE);
    }

    public void setExpirationDate(Date expirationDate) {
        set(PROPERTY_EXPIRATIONDATE, expirationDate);
    }

    public Date getInServiceDate() {
        return (Date) get(PROPERTY_INSERVICEDATE);
    }

    public void setInServiceDate(Date inServiceDate) {
        set(PROPERTY_INSERVICEDATE, inServiceDate);
    }

    public Boolean isOwned() {
        return (Boolean) get(PROPERTY_OWNED);
    }

    public void setOwned(Boolean owned) {
        set(PROPERTY_OWNED, owned);
    }

    public Date getAssetDepreciationDate() {
        return (Date) get(PROPERTY_ASSETDEPRECIATIONDATE);
    }

    public void setAssetDepreciationDate(Date assetDepreciationDate) {
        set(PROPERTY_ASSETDEPRECIATIONDATE, assetDepreciationDate);
    }

    public Long getUsableLifeYears() {
        return (Long) get(PROPERTY_USABLELIFEYEARS);
    }

    public void setUsableLifeYears(Long usableLifeYears) {
        set(PROPERTY_USABLELIFEYEARS, usableLifeYears);
    }

    public Long getUsableLifeMonths() {
        return (Long) get(PROPERTY_USABLELIFEMONTHS);
    }

    public void setUsableLifeMonths(Long usableLifeMonths) {
        set(PROPERTY_USABLELIFEMONTHS, usableLifeMonths);
    }

    public Long getLifeUse() {
        return (Long) get(PROPERTY_LIFEUSE);
    }

    public void setLifeUse(Long lifeUse) {
        set(PROPERTY_LIFEUSE, lifeUse);
    }

    public Long getUseUnits() {
        return (Long) get(PROPERTY_USEUNITS);
    }

    public void setUseUnits(Long useUnits) {
        set(PROPERTY_USEUNITS, useUnits);
    }

    public Boolean isDisposed() {
        return (Boolean) get(PROPERTY_DISPOSED);
    }

    public void setDisposed(Boolean disposed) {
        set(PROPERTY_DISPOSED, disposed);
    }

    public Date getAssetDisposalDate() {
        return (Date) get(PROPERTY_ASSETDISPOSALDATE);
    }

    public void setAssetDisposalDate(Date assetDisposalDate) {
        set(PROPERTY_ASSETDISPOSALDATE, assetDisposalDate);
    }

    public Boolean isInPossession() {
        return (Boolean) get(PROPERTY_INPOSSESSION);
    }

    public void setInPossession(Boolean inPossession) {
        set(PROPERTY_INPOSSESSION, inPossession);
    }

    public String getLocationComment() {
        return (String) get(PROPERTY_LOCATIONCOMMENT);
    }

    public void setLocationComment(String locationComment) {
        set(PROPERTY_LOCATIONCOMMENT, locationComment);
    }

    public Locator getStorageBin() {
        return (Locator) get(PROPERTY_STORAGEBIN);
    }

    public void setStorageBin(Locator storageBin) {
        set(PROPERTY_STORAGEBIN, storageBin);
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

    public org.openbravo.model.common.geography.Location getLocationAddress() {
        return (org.openbravo.model.common.geography.Location) get(PROPERTY_LOCATIONADDRESS);
    }

    public void setLocationAddress(org.openbravo.model.common.geography.Location locationAddress) {
        set(PROPERTY_LOCATIONADDRESS, locationAddress);
    }

    public Boolean isProcessNow() {
        return (Boolean) get(PROPERTY_PROCESSNOW);
    }

    public void setProcessNow(Boolean processNow) {
        set(PROPERTY_PROCESSNOW, processNow);
    }

    public Boolean isDepreciate() {
        return (Boolean) get(PROPERTY_DEPRECIATE);
    }

    public void setDepreciate(Boolean depreciate) {
        set(PROPERTY_DEPRECIATE, depreciate);
    }

    public Boolean isFullyDepreciated() {
        return (Boolean) get(PROPERTY_FULLYDEPRECIATED);
    }

    public void setFullyDepreciated(Boolean fullyDepreciated) {
        set(PROPERTY_FULLYDEPRECIATED, fullyDepreciated);
    }

    public User getUserContact() {
        return (User) get(PROPERTY_USERCONTACT);
    }

    public void setUserContact(User userContact) {
        set(PROPERTY_USERCONTACT, userContact);
    }

    public Date getDepreciationEndDate() {
        return (Date) get(PROPERTY_DEPRECIATIONENDDATE);
    }

    public void setDepreciationEndDate(Date depreciationEndDate) {
        set(PROPERTY_DEPRECIATIONENDDATE, depreciationEndDate);
    }

    public Date getDepreciationStartDate() {
        return (Date) get(PROPERTY_DEPRECIATIONSTARTDATE);
    }

    public void setDepreciationStartDate(Date depreciationStartDate) {
        set(PROPERTY_DEPRECIATIONSTARTDATE, depreciationStartDate);
    }

    public BigDecimal getAnnualDepreciation() {
        return (BigDecimal) get(PROPERTY_ANNUALDEPRECIATION);
    }

    public void setAnnualDepreciation(BigDecimal annualDepreciation) {
        set(PROPERTY_ANNUALDEPRECIATION, annualDepreciation);
    }

    public BigDecimal getAssetValue() {
        return (BigDecimal) get(PROPERTY_ASSETVALUE);
    }

    public void setAssetValue(BigDecimal assetValue) {
        set(PROPERTY_ASSETVALUE, assetValue);
    }

    public Currency getCurrency() {
        return (Currency) get(PROPERTY_CURRENCY);
    }

    public void setCurrency(Currency currency) {
        set(PROPERTY_CURRENCY, currency);
    }

    public Date getCancellationDate() {
        return (Date) get(PROPERTY_CANCELLATIONDATE);
    }

    public void setCancellationDate(Date cancellationDate) {
        set(PROPERTY_CANCELLATIONDATE, cancellationDate);
    }

    public Date getPurchaseDate() {
        return (Date) get(PROPERTY_PURCHASEDATE);
    }

    public void setPurchaseDate(Date purchaseDate) {
        set(PROPERTY_PURCHASEDATE, purchaseDate);
    }

    public AttributeSetInstance getAttributeSetValue() {
        return (AttributeSetInstance) get(PROPERTY_ATTRIBUTESETVALUE);
    }

    public void setAttributeSetValue(AttributeSetInstance attributeSetValue) {
        set(PROPERTY_ATTRIBUTESETVALUE, attributeSetValue);
    }

    public BigDecimal getResidualAssetValue() {
        return (BigDecimal) get(PROPERTY_RESIDUALASSETVALUE);
    }

    public void setResidualAssetValue(BigDecimal residualAssetValue) {
        set(PROPERTY_RESIDUALASSETVALUE, residualAssetValue);
    }

    public BigDecimal getAcctvalueamt() {
        return (BigDecimal) get(PROPERTY_ACCTVALUEAMT);
    }

    public void setAcctvalueamt(BigDecimal acctvalueamt) {
        set(PROPERTY_ACCTVALUEAMT, acctvalueamt);
    }

    public String getDepreciationType() {
        return (String) get(PROPERTY_DEPRECIATIONTYPE);
    }

    public void setDepreciationType(String depreciationType) {
        set(PROPERTY_DEPRECIATIONTYPE, depreciationType);
    }

    public BigDecimal getDepreciationAmt() {
        return (BigDecimal) get(PROPERTY_DEPRECIATIONAMT);
    }

    public void setDepreciationAmt(BigDecimal depreciationAmt) {
        set(PROPERTY_DEPRECIATIONAMT, depreciationAmt);
    }

    public String getAmortize() {
        return (String) get(PROPERTY_AMORTIZE);
    }

    public void setAmortize(String amortize) {
        set(PROPERTY_AMORTIZE, amortize);
    }

    public String getDocumentNo() {
        return (String) get(PROPERTY_DOCUMENTNO);
    }

    public void setDocumentNo(String documentNo) {
        set(PROPERTY_DOCUMENTNO, documentNo);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public BigDecimal getProfit() {
        return (BigDecimal) get(PROPERTY_PROFIT);
    }

    public void setProfit(BigDecimal profit) {
        set(PROPERTY_PROFIT, profit);
    }

    public BigDecimal getQuantity() {
        return (BigDecimal) get(PROPERTY_QUANTITY);
    }

    public void setQuantity(BigDecimal quantity) {
        set(PROPERTY_QUANTITY, quantity);
    }

    public String getCalculateType() {
        return (String) get(PROPERTY_CALCULATETYPE);
    }

    public void setCalculateType(String calculateType) {
        set(PROPERTY_CALCULATETYPE, calculateType);
    }

    public BigDecimal getDepreciatedPlan() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDPLAN);
    }

    public void setDepreciatedPlan(BigDecimal depreciatedPlan) {
        set(PROPERTY_DEPRECIATEDPLAN, depreciatedPlan);
    }

    public BigDecimal getPreviouslyDepreciatedAmt() {
        return (BigDecimal) get(PROPERTY_PREVIOUSLYDEPRECIATEDAMT);
    }

    public void setPreviouslyDepreciatedAmt(BigDecimal previouslyDepreciatedAmt) {
        set(PROPERTY_PREVIOUSLYDEPRECIATEDAMT, previouslyDepreciatedAmt);
    }

    public BigDecimal getDepreciatedValue() {
        return (BigDecimal) get(PROPERTY_DEPRECIATEDVALUE);
    }

    public void setDepreciatedValue(BigDecimal depreciatedValue) {
        set(PROPERTY_DEPRECIATEDVALUE, depreciatedValue);
    }

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Project getProject() {
        return (Project) get(PROPERTY_PROJECT);
    }

    public void setProject(Project project) {
        set(PROPERTY_PROJECT, project);
    }

    public Boolean isStatic() {
        return (Boolean) get(PROPERTY_STATIC);
    }

    public void setStatic(Boolean statc) {
        set(PROPERTY_STATIC, statc);
    }

    public Boolean isEveryMonthIs30Days() {
        return (Boolean) get(PROPERTY_EVERYMONTHIS30DAYS);
    }

    public void setEveryMonthIs30Days(Boolean everyMonthIs30Days) {
        set(PROPERTY_EVERYMONTHIS30DAYS, everyMonthIs30Days);
    }

    public DocumentType getSsalCDoctype() {
        return (DocumentType) get(PROPERTY_SSALCDOCTYPE);
    }

    public void setSsalCDoctype(DocumentType ssalCDoctype) {
        set(PROPERTY_SSALCDOCTYPE, ssalCDoctype);
    }

    public String getSsalDescriptionCh() {
        return (String) get(PROPERTY_SSALDESCRIPTIONCH);
    }

    public void setSsalDescriptionCh(String ssalDescriptionCh) {
        set(PROPERTY_SSALDESCRIPTIONCH, ssalDescriptionCh);
    }

    public Boolean isSSALVessel() {
        return (Boolean) get(PROPERTY_SSALVESSEL);
    }

    public void setSSALVessel(Boolean sSALVessel) {
        set(PROPERTY_SSALVESSEL, sSALVessel);
    }

    public String getProcessAsset() {
        return (String) get(PROPERTY_PROCESSASSET);
    }

    public void setProcessAsset(String processAsset) {
        set(PROPERTY_PROCESSASSET, processAsset);
    }

    public ssalmark getSsalMark() {
        return (ssalmark) get(PROPERTY_SSALMARK);
    }

    public void setSsalMark(ssalmark ssalMark) {
        set(PROPERTY_SSALMARK, ssalMark);
    }

    public ssalmodel getSsalModel() {
        return (ssalmodel) get(PROPERTY_SSALMODEL);
    }

    public void setSsalModel(ssalmodel ssalModel) {
        set(PROPERTY_SSALMODEL, ssalModel);
    }

    public Boolean isSsalIsavailable() {
        return (Boolean) get(PROPERTY_SSALISAVAILABLE);
    }

    public void setSsalIsavailable(Boolean ssalIsavailable) {
        set(PROPERTY_SSALISAVAILABLE, ssalIsavailable);
    }

    public String getSsalSeries() {
        return (String) get(PROPERTY_SSALSERIES);
    }

    public void setSsalSeries(String ssalSeries) {
        set(PROPERTY_SSALSERIES, ssalSeries);
    }

    public BusinessPartner getSsalCustodio() {
        return (BusinessPartner) get(PROPERTY_SSALCUSTODIO);
    }

    public void setSsalCustodio(BusinessPartner ssalCustodio) {
        set(PROPERTY_SSALCUSTODIO, ssalCustodio);
    }

    public String getSsalBarCode() {
        return (String) get(PROPERTY_SSALBARCODE);
    }

    public void setSsalBarCode(String ssalBarCode) {
        set(PROPERTY_SSALBARCODE, ssalBarCode);
    }

    public ssalstateasset getSsalStateAsset() {
        return (ssalstateasset) get(PROPERTY_SSALSTATEASSET);
    }

    public void setSsalStateAsset(ssalstateasset ssalStateAsset) {
        set(PROPERTY_SSALSTATEASSET, ssalStateAsset);
    }

    public Boolean isSsamAlienated() {
        return (Boolean) get(PROPERTY_SSAMALIENATED);
    }

    public void setSsamAlienated(Boolean ssamAlienated) {
        set(PROPERTY_SSAMALIENATED, ssamAlienated);
    }

    public String getSsamStatus() {
        return (String) get(PROPERTY_SSAMSTATUS);
    }

    public void setSsamStatus(String ssamStatus) {
        set(PROPERTY_SSAMSTATUS, ssamStatus);
    }

    public String getSsamInvoiced() {
        return (String) get(PROPERTY_SSAMINVOICED);
    }

    public void setSsamInvoiced(String ssamInvoiced) {
        set(PROPERTY_SSAMINVOICED, ssamInvoiced);
    }

    public String getSsalLowreason() {
        return (String) get(PROPERTY_SSALLOWREASON);
    }

    public void setSsalLowreason(String ssalLowreason) {
        set(PROPERTY_SSALLOWREASON, ssalLowreason);
    }

    public BusinessPartner getSsamCBpartner() {
        return (BusinessPartner) get(PROPERTY_SSAMCBPARTNER);
    }

    public void setSsamCBpartner(BusinessPartner ssamCBpartner) {
        set(PROPERTY_SSAMCBPARTNER, ssamCBpartner);
    }

    public Date getSsalLowdate() {
        return (Date) get(PROPERTY_SSALLOWDATE);
    }

    public void setSsalLowdate(Date ssalLowdate) {
        set(PROPERTY_SSALLOWDATE, ssalLowdate);
    }

    public String getSsamTaxid() {
        return (String) get(PROPERTY_SSAMTAXID);
    }

    public void setSsamTaxid(String ssamTaxid) {
        set(PROPERTY_SSAMTAXID, ssamTaxid);
    }

    public Boolean isSsalLowprocess() {
        return (Boolean) get(PROPERTY_SSALLOWPROCESS);
    }

    public void setSsalLowprocess(Boolean ssalLowprocess) {
        set(PROPERTY_SSALLOWPROCESS, ssalLowprocess);
    }

    public BigDecimal getSsamNetWorth() {
        return (BigDecimal) get(PROPERTY_SSAMNETWORTH);
    }

    public void setSsamNetWorth(BigDecimal ssamNetWorth) {
        set(PROPERTY_SSAMNETWORTH, ssamNetWorth);
    }

    public String getSsalLowstatus() {
        return (String) get(PROPERTY_SSALLOWSTATUS);
    }

    public void setSsalLowstatus(String ssalLowstatus) {
        set(PROPERTY_SSALLOWSTATUS, ssalLowstatus);
    }

    public String getSsamModel() {
        return (String) get(PROPERTY_SSAMMODEL);
    }

    public void setSsamModel(String ssamModel) {
        set(PROPERTY_SSAMMODEL, ssamModel);
    }

    public String getSsamSerie() {
        return (String) get(PROPERTY_SSAMSERIE);
    }

    public void setSsamSerie(String ssamSerie) {
        set(PROPERTY_SSAMSERIE, ssamSerie);
    }

    public Boolean isSdaDerecognition() {
        return (Boolean) get(PROPERTY_SDADERECOGNITION);
    }

    public void setSdaDerecognition(Boolean sdaDerecognition) {
        set(PROPERTY_SDADERECOGNITION, sdaDerecognition);
    }

    public String getSsamBrand() {
        return (String) get(PROPERTY_SSAMBRAND);
    }

    public void setSsamBrand(String ssamBrand) {
        set(PROPERTY_SSAMBRAND, ssamBrand);
    }

    public BigDecimal getSsamReplacementValue() {
        return (BigDecimal) get(PROPERTY_SSAMREPLACEMENTVALUE);
    }

    public void setSsamReplacementValue(BigDecimal ssamReplacementValue) {
        set(PROPERTY_SSAMREPLACEMENTVALUE, ssamReplacementValue);
    }

    public String getSsamCondition() {
        return (String) get(PROPERTY_SSAMCONDITION);
    }

    public void setSsamCondition(String ssamCondition) {
        set(PROPERTY_SSAMCONDITION, ssamCondition);
    }

    public String getSsamAssettype() {
        return (String) get(PROPERTY_SSAMASSETTYPE);
    }

    public void setSsamAssettype(String ssamAssettype) {
        set(PROPERTY_SSAMASSETTYPE, ssamAssettype);
    }

    public ssamalienateline getSsamAlienateline() {
        return (ssamalienateline) get(PROPERTY_SSAMALIENATELINE);
    }

    public void setSsamAlienateline(ssamalienateline ssamAlienateline) {
        set(PROPERTY_SSAMALIENATELINE, ssamAlienateline);
    }

    public String getSsamStatusdep() {
        return (String) get(PROPERTY_SSAMSTATUSDEP);
    }

    public void setSsamStatusdep(String ssamStatusdep) {
        set(PROPERTY_SSAMSTATUSDEP, ssamStatusdep);
    }

    public Boolean isSsamChangeofvalue() {
        return (Boolean) get(PROPERTY_SSAMCHANGEOFVALUE);
    }

    public void setSsamChangeofvalue(Boolean ssamChangeofvalue) {
        set(PROPERTY_SSAMCHANGEOFVALUE, ssamChangeofvalue);
    }

    public String getSsamTypeofchange() {
        return (String) get(PROPERTY_SSAMTYPEOFCHANGE);
    }

    public void setSsamTypeofchange(String ssamTypeofchange) {
        set(PROPERTY_SSAMTYPEOFCHANGE, ssamTypeofchange);
    }

    public SSASLSubcategory getSsaslSubcategory() {
        return (SSASLSubcategory) get(PROPERTY_SSASLSUBCATEGORY);
    }

    public void setSsaslSubcategory(SSASLSubcategory ssaslSubcategory) {
        set(PROPERTY_SSASLSUBCATEGORY, ssaslSubcategory);
    }

    public String getSsamObservations() {
        return (String) get(PROPERTY_SSAMOBSERVATIONS);
    }

    public void setSsamObservations(String ssamObservations) {
        set(PROPERTY_SSAMOBSERVATIONS, ssamObservations);
    }

    public String getSsapiProvider() {
        return (String) get(PROPERTY_SSAPIPROVIDER);
    }

    public void setSsapiProvider(String ssapiProvider) {
        set(PROPERTY_SSAPIPROVIDER, ssapiProvider);
    }

    public String getSsapiInvoiceno() {
        return (String) get(PROPERTY_SSAPIINVOICENO);
    }

    public void setSsapiInvoiceno(String ssapiInvoiceno) {
        set(PROPERTY_SSAPIINVOICENO, ssapiInvoiceno);
    }

    public SSAPITrasactiontype getSsapiTrasactiontype() {
        return (SSAPITrasactiontype) get(PROPERTY_SSAPITRASACTIONTYPE);
    }

    public void setSsapiTrasactiontype(SSAPITrasactiontype ssapiTrasactiontype) {
        set(PROPERTY_SSAPITRASACTIONTYPE, ssapiTrasactiontype);
    }

    public SSAPIDocumenttype getSsapiDocumenttype() {
        return (SSAPIDocumenttype) get(PROPERTY_SSAPIDOCUMENTTYPE);
    }

    public void setSsapiDocumenttype(SSAPIDocumenttype ssapiDocumenttype) {
        set(PROPERTY_SSAPIDOCUMENTTYPE, ssapiDocumenttype);
    }

    public ssalbuilding getSsalBuilding() {
        return (ssalbuilding) get(PROPERTY_SSALBUILDING);
    }

    public void setSsalBuilding(ssalbuilding ssalBuilding) {
        set(PROPERTY_SSALBUILDING, ssalBuilding);
    }

    public ssal_unit getSsalUnit() {
        return (ssal_unit) get(PROPERTY_SSALUNIT);
    }

    public void setSsalUnit(ssal_unit ssalUnit) {
        set(PROPERTY_SSALUNIT, ssalUnit);
    }

    public ssaldepartment getSsalDepartment() {
        return (ssaldepartment) get(PROPERTY_SSALDEPARTMENT);
    }

    public void setSsalDepartment(ssaldepartment ssalDepartment) {
        set(PROPERTY_SSALDEPARTMENT, ssalDepartment);
    }

    public Invoice getSsapiInvoice() {
        return (Invoice) get(PROPERTY_SSAPIINVOICE);
    }

    public void setSsapiInvoice(Invoice ssapiInvoice) {
        set(PROPERTY_SSAPIINVOICE, ssapiInvoice);
    }

    public BusinessPartner getSsapiBpartner() {
        return (BusinessPartner) get(PROPERTY_SSAPIBPARTNER);
    }

    public void setSsapiBpartner(BusinessPartner ssapiBpartner) {
        set(PROPERTY_SSAPIBPARTNER, ssapiBpartner);
    }

    public String getSsamAddDescription() {
        return (String) get(PROPERTY_SSAMADDDESCRIPTION);
    }

    public void setSsamAddDescription(String ssamAddDescription) {
        set(PROPERTY_SSAMADDDESCRIPTION, ssamAddDescription);
    }

    public String getSsamReference() {
        return (String) get(PROPERTY_SSAMREFERENCE);
    }

    public void setSsamReference(String ssamReference) {
        set(PROPERTY_SSAMREFERENCE, ssamReference);
    }

    public String getSsarColor() {
        return (String) get(PROPERTY_SSARCOLOR);
    }

    public void setSsarColor(String ssarColor) {
        set(PROPERTY_SSARCOLOR, ssarColor);
    }

    public String getSsarMeasurements() {
        return (String) get(PROPERTY_SSARMEASUREMENTS);
    }

    public void setSsarMeasurements(String ssarMeasurements) {
        set(PROPERTY_SSARMEASUREMENTS, ssarMeasurements);
    }

    public String getSsarOtherAttributes() {
        return (String) get(PROPERTY_SSAROTHERATTRIBUTES);
    }

    public void setSsarOtherAttributes(String ssarOtherAttributes) {
        set(PROPERTY_SSAROTHERATTRIBUTES, ssarOtherAttributes);
    }

    public Date getSsarWarrantyDate() {
        return (Date) get(PROPERTY_SSARWARRANTYDATE);
    }

    public void setSsarWarrantyDate(Date ssarWarrantyDate) {
        set(PROPERTY_SSARWARRANTYDATE, ssarWarrantyDate);
    }

    public Invoice getSsacInvoice() {
        return (Invoice) get(PROPERTY_SSACINVOICE);
    }

    public void setSsacInvoice(Invoice ssacInvoice) {
        set(PROPERTY_SSACINVOICE, ssacInvoice);
    }

    public BigDecimal getSsamValueInBooks() {
        return (BigDecimal) get(PROPERTY_SSAMVALUEINBOOKS);
    }

    public void setSsamValueInBooks(BigDecimal ssamValueInBooks) {
        set(PROPERTY_SSAMVALUEINBOOKS, ssamValueInBooks);
    }

    public Boolean isSsarvDepreciationPlan() {
        return (Boolean) get(PROPERTY_SSARVDEPRECIATIONPLAN);
    }

    public void setSsarvDepreciationPlan(Boolean ssarvDepreciationPlan) {
        set(PROPERTY_SSARVDEPRECIATIONPLAN, ssarvDepreciationPlan);
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

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    public Boolean isSeactAbprocess() {
        return (Boolean) get(PROPERTY_SEACTABPROCESS);
    }

    public void setSeactAbprocess(Boolean seactAbprocess) {
        set(PROPERTY_SEACTABPROCESS, seactAbprocess);
    }

    public Boolean isSeactAbreactivate() {
        return (Boolean) get(PROPERTY_SEACTABREACTIVATE);
    }

    public void setSeactAbreactivate(Boolean seactAbreactivate) {
        set(PROPERTY_SEACTABREACTIVATE, seactAbreactivate);
    }

    public TaxCategory getSsataxCTaxcategory() {
        return (TaxCategory) get(PROPERTY_SSATAXCTAXCATEGORY);
    }

    public void setSsataxCTaxcategory(TaxCategory ssataxCTaxcategory) {
        set(PROPERTY_SSATAXCTAXCATEGORY, ssataxCTaxcategory);
    }

    public BigDecimal getSsataxTaxamt() {
        return (BigDecimal) get(PROPERTY_SSATAXTAXAMT);
    }

    public void setSsataxTaxamt(BigDecimal ssataxTaxamt) {
        set(PROPERTY_SSATAXTAXAMT, ssataxTaxamt);
    }

    public BigDecimal getSsataxTotalpurchaseamt() {
        return (BigDecimal) get(PROPERTY_SSATAXTOTALPURCHASEAMT);
    }

    public void setSsataxTotalpurchaseamt(BigDecimal ssataxTotalpurchaseamt) {
        set(PROPERTY_SSATAXTOTALPURCHASEAMT, ssataxTotalpurchaseamt);
    }

    @SuppressWarnings("unchecked")
    public List<FinAccTransactionAccounting> getAPRMFinAccTransactionAcctVList() {
      return (List<FinAccTransactionAccounting>) get(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST);
    }

    public void setAPRMFinAccTransactionAcctVList(List<FinAccTransactionAccounting> aPRMFinAccTransactionAcctVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, aPRMFinAccTransactionAcctVList);
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
    public List<DoubtfulDebt> getFINDoubtfulDebtList() {
      return (List<DoubtfulDebt>) get(PROPERTY_FINDOUBTFULDEBTLIST);
    }

    public void setFINDoubtfulDebtList(List<DoubtfulDebt> fINDoubtfulDebtList) {
        set(PROPERTY_FINDOUBTFULDEBTLIST, fINDoubtfulDebtList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingFact> getFinancialMgmtAccountingFactList() {
      return (List<AccountingFact>) get(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST);
    }

    public void setFinancialMgmtAccountingFactList(List<AccountingFact> financialMgmtAccountingFactList) {
        set(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, financialMgmtAccountingFactList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLine> getFinancialMgmtAmortizationLineList() {
      return (List<AmortizationLine>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST);
    }

    public void setFinancialMgmtAmortizationLineList(List<AmortizationLine> financialMgmtAmortizationLineList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, financialMgmtAmortizationLineList);
    }

    @SuppressWarnings("unchecked")
    public List<AssetAccounts> getFinancialMgmtAssetAccountsList() {
      return (List<AssetAccounts>) get(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST);
    }

    public void setFinancialMgmtAssetAccountsList(List<AssetAccounts> financialMgmtAssetAccountsList) {
        set(PROPERTY_FINANCIALMGMTASSETACCOUNTSLIST, financialMgmtAssetAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<BudgetLine> getFinancialMgmtBudgetLineList() {
      return (List<BudgetLine>) get(PROPERTY_FINANCIALMGMTBUDGETLINELIST);
    }

    public void setFinancialMgmtBudgetLineList(List<BudgetLine> financialMgmtBudgetLineList) {
        set(PROPERTY_FINANCIALMGMTBUDGETLINELIST, financialMgmtBudgetLineList);
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
    public List<InOutLineAccountingDimension> getInOutLineAccountingDimensionList() {
      return (List<InOutLineAccountingDimension>) get(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInOutLineAccountingDimensionList(List<InOutLineAccountingDimension> inOutLineAccountingDimensionList) {
        set(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, inOutLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<Invoice> getInvoiceList() {
      return (List<Invoice>) get(PROPERTY_INVOICELIST);
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        set(PROPERTY_INVOICELIST, invoiceList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINELIST);
    }

    public void setInvoiceLineList(List<InvoiceLine> invoiceLineList) {
        set(PROPERTY_INVOICELINELIST, invoiceLineList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineEMSsamAAssetIDList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEEMSSAMAASSETIDLIST);
    }

    public void setInvoiceLineEMSsamAAssetIDList(List<InvoiceLine> invoiceLineEMSsamAAssetIDList) {
        set(PROPERTY_INVOICELINEEMSSAMAASSETIDLIST, invoiceLineEMSsamAAssetIDList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalMovement> getMaterialMgmtInternalMovementList() {
      return (List<InternalMovement>) get(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST);
    }

    public void setMaterialMgmtInternalMovementList(List<InternalMovement> materialMgmtInternalMovementList) {
        set(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, materialMgmtInternalMovementList);
    }

    @SuppressWarnings("unchecked")
    public List<InventoryCount> getMaterialMgmtInventoryCountList() {
      return (List<InventoryCount>) get(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST);
    }

    public void setMaterialMgmtInventoryCountList(List<InventoryCount> materialMgmtInventoryCountList) {
        set(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, materialMgmtInventoryCountList);
    }

    @SuppressWarnings("unchecked")
    public List<ProductionTransaction> getMaterialMgmtProductionTransactionList() {
      return (List<ProductionTransaction>) get(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST);
    }

    public void setMaterialMgmtProductionTransactionList(List<ProductionTransaction> materialMgmtProductionTransactionList) {
        set(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, materialMgmtProductionTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOut> getMaterialMgmtShipmentInOutList() {
      return (List<ShipmentInOut>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST);
    }

    public void setMaterialMgmtShipmentInOutList(List<ShipmentInOut> materialMgmtShipmentInOutList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, materialMgmtShipmentInOutList);
    }

    @SuppressWarnings("unchecked")
    public List<ShipmentInOutLine> getMaterialMgmtShipmentInOutLineList() {
      return (List<ShipmentInOutLine>) get(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST);
    }

    public void setMaterialMgmtShipmentInOutLineList(List<ShipmentInOutLine> materialMgmtShipmentInOutLineList) {
        set(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, materialMgmtShipmentInOutLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Order> getOrderList() {
      return (List<Order>) get(PROPERTY_ORDERLIST);
    }

    public void setOrderList(List<Order> orderList) {
        set(PROPERTY_ORDERLIST, orderList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLine> getOrderLineList() {
      return (List<OrderLine>) get(PROPERTY_ORDERLINELIST);
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        set(PROPERTY_ORDERLINELIST, orderLineList);
    }

    @SuppressWarnings("unchecked")
    public List<OrderLineAccountingDimension> getOrderLineAccountingDimensionList() {
      return (List<OrderLineAccountingDimension>) get(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST);
    }

    public void setOrderLineAccountingDimensionList(List<OrderLineAccountingDimension> orderLineAccountingDimensionList) {
        set(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, orderLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<AccountingReversal> getSTXREVFinanciallAccountingList() {
      return (List<AccountingReversal>) get(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST);
    }

    public void setSTXREVFinanciallAccountingList(List<AccountingReversal> sTXREVFinanciallAccountingList) {
        set(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, sTXREVFinanciallAccountingList);
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
    public List<Sheet> getTimeAndExpenseSheetList() {
      return (List<Sheet>) get(PROPERTY_TIMEANDEXPENSESHEETLIST);
    }

    public void setTimeAndExpenseSheetList(List<Sheet> timeAndExpenseSheetList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLIST, timeAndExpenseSheetList);
    }

    @SuppressWarnings("unchecked")
    public List<SheetLine> getTimeAndExpenseSheetLineList() {
      return (List<SheetLine>) get(PROPERTY_TIMEANDEXPENSESHEETLINELIST);
    }

    public void setTimeAndExpenseSheetLineList(List<SheetLine> timeAndExpenseSheetLineList) {
        set(PROPERTY_TIMEANDEXPENSESHEETLINELIST, timeAndExpenseSheetLineList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINELIST);
    }

    public void setCsaaaCustodianlineList(List<CsaaaCustodianLine> csaaaCustodianlineList) {
        set(PROPERTY_CSAAACUSTODIANLINELIST, csaaaCustodianlineList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineBarcodeIDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEBARCODEIDLIST);
    }

    public void setCsaaaCustodianlineBarcodeIDList(List<CsaaaCustodianLine> csaaaCustodianlineBarcodeIDList) {
        set(PROPERTY_CSAAACUSTODIANLINEBARCODEIDLIST, csaaaCustodianlineBarcodeIDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTakingLine> getCsaaaInvtTkgLineList() {
      return (List<CsaaaInventoryTakingLine>) get(PROPERTY_CSAAAINVTTKGLINELIST);
    }

    public void setCsaaaInvtTkgLineList(List<CsaaaInventoryTakingLine> csaaaInvtTkgLineList) {
        set(PROPERTY_CSAAAINVTTKGLINELIST, csaaaInvtTkgLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Imdlv_Lines> getImdlvLinesList() {
      return (List<Imdlv_Lines>) get(PROPERTY_IMDLVLINESLIST);
    }

    public void setImdlvLinesList(List<Imdlv_Lines> imdlvLinesList) {
        set(PROPERTY_IMDLVLINESLIST, imdlvLinesList);
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
    public List<SsalActiveMain> getSsalActiveMainCdigoActivoList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINCDIGOACTIVOLIST);
    }

    public void setSsalActiveMainCdigoActivoList(List<SsalActiveMain> ssalActiveMainCdigoActivoList) {
        set(PROPERTY_SSALACTIVEMAINCDIGOACTIVOLIST, ssalActiveMainCdigoActivoList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalActiveMain> getSsalActiveMainUPCEANList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINUPCEANLIST);
    }

    public void setSsalActiveMainUPCEANList(List<SsalActiveMain> ssalActiveMainUPCEANList) {
        set(PROPERTY_SSALACTIVEMAINUPCEANLIST, ssalActiveMainUPCEANList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalActiveMain> getSsalActiveMainDescriptionActiveList() {
      return (List<SsalActiveMain>) get(PROPERTY_SSALACTIVEMAINDESCRIPTIONACTIVELIST);
    }

    public void setSsalActiveMainDescriptionActiveList(List<SsalActiveMain> ssalActiveMainDescriptionActiveList) {
        set(PROPERTY_SSALACTIVEMAINDESCRIPTIONACTIVELIST, ssalActiveMainDescriptionActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVELIST);
    }

    public void setSsalApplActiveList(List<SsalApplActive> ssalApplActiveList) {
        set(PROPERTY_SSALAPPLACTIVELIST, ssalApplActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveAAssetCodIDList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST);
    }

    public void setSsalApplActiveAAssetCodIDList(List<SsalApplActive> ssalApplActiveAAssetCodIDList) {
        set(PROPERTY_SSALAPPLACTIVEAASSETCODIDLIST, ssalApplActiveAAssetCodIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveUPCEANList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVEUPCEANLIST);
    }

    public void setSsalApplActiveUPCEANList(List<SsalApplActive> ssalApplActiveUPCEANList) {
        set(PROPERTY_SSALAPPLACTIVEUPCEANLIST, ssalApplActiveUPCEANList);
    }

    @SuppressWarnings("unchecked")
    public List<SsalApplActive> getSsalApplActiveDescriptionActiveList() {
      return (List<SsalApplActive>) get(PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST);
    }

    public void setSsalApplActiveDescriptionActiveList(List<SsalApplActive> ssalApplActiveDescriptionActiveList) {
        set(PROPERTY_SSALAPPLACTIVEDESCRIPTIONACTIVELIST, ssalApplActiveDescriptionActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetcom> getSsalAssetComList() {
      return (List<ssalassetcom>) get(PROPERTY_SSALASSETCOMLIST);
    }

    public void setSsalAssetComList(List<ssalassetcom> ssalAssetComList) {
        set(PROPERTY_SSALASSETCOMLIST, ssalAssetComList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineCdigoActivoList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST);
    }

    public void setSsalAssetReturnlineCdigoActivoList(List<ssalassetreturnline> ssalAssetReturnlineCdigoActivoList) {
        set(PROPERTY_SSALASSETRETURNLINECDIGOACTIVOLIST, ssalAssetReturnlineCdigoActivoList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineUPCEANList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINEUPCEANLIST);
    }

    public void setSsalAssetReturnlineUPCEANList(List<ssalassetreturnline> ssalAssetReturnlineUPCEANList) {
        set(PROPERTY_SSALASSETRETURNLINEUPCEANLIST, ssalAssetReturnlineUPCEANList);
    }

    @SuppressWarnings("unchecked")
    public List<ssalassetreturnline> getSsalAssetReturnlineDescriptionActiveList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST);
    }

    public void setSsalAssetReturnlineDescriptionActiveList(List<ssalassetreturnline> ssalAssetReturnlineDescriptionActiveList) {
        set(PROPERTY_SSALASSETRETURNLINEDESCRIPTIONACTIVELIST, ssalAssetReturnlineDescriptionActiveList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateAAssetstartIDList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATEAASSETSTARTIDLIST);
    }

    public void setSsamAlienateAAssetstartIDList(List<ssamalienate> ssamAlienateAAssetstartIDList) {
        set(PROPERTY_SSAMALIENATEAASSETSTARTIDLIST, ssamAlienateAAssetstartIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienate> getSsamAlienateAAssetendIDList() {
      return (List<ssamalienate>) get(PROPERTY_SSAMALIENATEAASSETENDIDLIST);
    }

    public void setSsamAlienateAAssetendIDList(List<ssamalienate> ssamAlienateAAssetendIDList) {
        set(PROPERTY_SSAMALIENATEAASSETENDIDLIST, ssamAlienateAAssetendIDList);
    }

    @SuppressWarnings("unchecked")
    public List<ssamalienateline> getSsamAlienatelineList() {
      return (List<ssamalienateline>) get(PROPERTY_SSAMALIENATELINELIST);
    }

    public void setSsamAlienatelineList(List<ssamalienateline> ssamAlienatelineList) {
        set(PROPERTY_SSAMALIENATELINELIST, ssamAlienatelineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsarvValueChange> getSsarvValueChangeList() {
      return (List<SsarvValueChange>) get(PROPERTY_SSARVVALUECHANGELIST);
    }

    public void setSsarvValueChangeList(List<SsarvValueChange> ssarvValueChangeList) {
        set(PROPERTY_SSARVVALUECHANGELIST, ssarvValueChangeList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetDetail> getSsatrAssetDetailList() {
      return (List<SsatrAssetDetail>) get(PROPERTY_SSATRASSETDETAILLIST);
    }

    public void setSsatrAssetDetailList(List<SsatrAssetDetail> ssatrAssetDetailList) {
        set(PROPERTY_SSATRASSETDETAILLIST, ssatrAssetDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SsatrAssetTransfer> getSsatrAssetTransferList() {
      return (List<SsatrAssetTransfer>) get(PROPERTY_SSATRASSETTRANSFERLIST);
    }

    public void setSsatrAssetTransferList(List<SsatrAssetTransfer> ssatrAssetTransferList) {
        set(PROPERTY_SSATRASSETTRANSFERLIST, ssatrAssetTransferList);
    }

    @SuppressWarnings("unchecked")
    public List<ssorel_invoiceorder_v> getSsorelInvoiceorderVList() {
      return (List<ssorel_invoiceorder_v>) get(PROPERTY_SSORELINVOICEORDERVLIST);
    }

    public void setSsorelInvoiceorderVList(List<ssorel_invoiceorder_v> ssorelInvoiceorderVList) {
        set(PROPERTY_SSORELINVOICEORDERVLIST, ssorelInvoiceorderVList);
    }

}
