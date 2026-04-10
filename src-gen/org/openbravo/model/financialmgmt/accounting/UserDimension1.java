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
package org.openbravo.model.financialmgmt.accounting;

import com.sidesoft.ecuador.asset.allocation.SsalActiveMain;
import com.sidesoft.ecuador.asset.allocation.SsalApplActive;
import com.sidesoft.ecuador.asset.allocation.ssalassetreturnline;
import com.sidesoft.hrm.payroll.Contract;
import com.sidesoft.hrm.payroll.PayrollTicket;
import com.sidesoft.hrm.payroll.disaccounting.sspdpctdistcostcenter;

import ec.com.sidesoft.balance.performance.SbprfFactAcctAggd;
import ec.com.sidesoft.balance.performance.SbprfFactAcctAggdDoc;
import ec.com.sidesoft.daily.closing.charge.SdccDailyClossing;
import ec.com.sidesoft.debit.collection.SdcDebitcollect;
import ec.com.sidesoft.distribute.costcenter.SsdccpDistributeCostCenter;
import ec.com.sidesoft.distribute.costcenter.partner.CSDFBP_CostcenterDistributionForBP;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaCustodian;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaCustodianLine;
import ec.com.sidesoft.ecuador.asset.allocation.advanced.CsaaaInventoryTakingLine;
import ec.com.sidesoft.importdata.payments.Simppys_PaymentDetail;
import ec.com.sidesoft.localization.importdata.loadvouchers.Imdlv_Lines;
import ec.com.sidesoft.modify.accounting.SsmaactAccounting;
import ec.com.sidesoft.modify.accounting.SsmaactAudit;
import ec.com.sidesoft.saleorder.relations.ssorel_invoiceorder_v;
import ec.com.sidesoft.transaction.reversal.AccountingReversal;
import ec.com.sidesoft.ws.paymentscreate.SWSPCConfig;

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
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.common.invoice.InvoiceLineAccountingDimension;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineAccountingDimension;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.assetmgmt.Amortization;
import org.openbravo.model.financialmgmt.assetmgmt.AmortizationLine;
import org.openbravo.model.financialmgmt.assetmgmt.AmortizationLineAccountingDimension;
import org.openbravo.model.financialmgmt.assetmgmt.Asset;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournal;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.financialmgmt.payment.DPManagement;
import org.openbravo.model.financialmgmt.payment.DoubtfulDebt;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.FIN_ReconciliationLine_v;
import org.openbravo.model.financialmgmt.payment.Settlement;
import org.openbravo.model.materialmgmt.transaction.InOutLineAccountingDimension;
import org.openbravo.model.materialmgmt.transaction.InternalConsumption;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.materialmgmt.transaction.InventoryCount;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.openbravo.model.timeandexpense.Sheet;
import org.openbravo.model.timeandexpense.SheetLine;
/**
 * Entity class for entity UserDimension1 (stored in table User1).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class UserDimension1 extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "User1";
    public static final String ENTITY_NAME = "UserDimension1";
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
    public static final String PROPERTY_SUMMARYLEVEL = "summaryLevel";
    public static final String PROPERTY_SSDCCPISDISTCOSTCENTER = "ssdccpIsdistcostcenter";
    public static final String PROPERTY_SSDCCPDISTPORTJE = "ssdccpDistportje";
    public static final String PROPERTY_APRMFINACCTRANSACTIONACCTVLIST = "aPRMFinAccTransactionAcctVList";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_APRMFINACCTRXFULLACCTVLIST = "aPRMFinaccTrxFullAcctVList";
    public static final String PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST = "amortizationLineAccountingDimensionList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSPRUSER1IDLIST = "businessPartnerEMSsprUser1IDList";
    public static final String PROPERTY_BUSINESSPARTNEREMSSFCUSER1IDLIST = "businessPartnerEMSsfcUser1IDList";
    public static final String PROPERTY_FINDOUBTFULDEBTLIST = "fINDoubtfulDebtList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINPAYMENTLIST = "fINPaymentList";
    public static final String PROPERTY_FINPAYMENTSCHEDULEDETAILLIST = "fINPaymentScheduleDetailList";
    public static final String PROPERTY_FINRECONCILIATIONLINEVLIST = "fINReconciliationLineVList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST = "financialMgmtAccountingCombinationList";
    public static final String PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST = "financialMgmtAccountingFactList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLIST = "financialMgmtAmortizationList";
    public static final String PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST = "financialMgmtAmortizationLineList";
    public static final String PROPERTY_FINANCIALMGMTASSETLIST = "financialMgmtAssetList";
    public static final String PROPERTY_FINANCIALMGMTBUDGETLINELIST = "financialMgmtBudgetLineList";
    public static final String PROPERTY_FINANCIALMGMTCASHJOURNALLIST = "financialMgmtCashJournalList";
    public static final String PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST = "financialMgmtDPManagementList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLIST = "financialMgmtGLJournalList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTSETTLEMENTLIST = "financialMgmtSettlementList";
    public static final String PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST = "inOutLineAccountingDimensionList";
    public static final String PROPERTY_INVOICELIST = "invoiceList";
    public static final String PROPERTY_INVOICELINELIST = "invoiceLineList";
    public static final String PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST = "invoiceLineAccountingDimensionList";
    public static final String PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST = "materialMgmtInternalConsumptionList";
    public static final String PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST = "materialMgmtInternalMovementList";
    public static final String PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST = "materialMgmtInventoryCountList";
    public static final String PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST = "materialMgmtProductionTransactionList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST = "materialMgmtShipmentInOutList";
    public static final String PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST = "materialMgmtShipmentInOutLineList";
    public static final String PROPERTY_ORDERLIST = "orderList";
    public static final String PROPERTY_ORDERLINELIST = "orderLineList";
    public static final String PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST = "orderLineAccountingDimensionList";
    public static final String PROPERTY_ORGANIZATIONEMSSOPOSUSER1IDLIST = "organizationEMSsoposUser1IDList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SSPRPAYROLLTICKETEMSPRCUSER1IDLIST = "sSPRPayrollTicketEMSprcUser1IDList";
    public static final String PROPERTY_STXREVFINANCIALLACCOUNTINGLIST = "sTXREVFinanciallAccountingList";
    public static final String PROPERTY_SSMAACTACCOUNTINGLIST = "ssmaactAccountingList";
    public static final String PROPERTY_SSMAACTAUDITLIST = "ssmaactAuditList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLIST = "timeAndExpenseSheetList";
    public static final String PROPERTY_TIMEANDEXPENSESHEETLINELIST = "timeAndExpenseSheetLineList";
    public static final String PROPERTY_CSAAACUSTODIANLIST = "csaaaCustodianList";
    public static final String PROPERTY_CSAAACUSTODIANLINELIST = "csaaaCustodianlineList";
    public static final String PROPERTY_CSAAACUSTODIANLINEUSER12IDLIST = "csaaaCustodianlineUser12IDList";
    public static final String PROPERTY_CSAAAINVTTKGLINELIST = "csaaaInvtTkgLineList";
    public static final String PROPERTY_CSDFBPCOSTCENTERDBPLIST = "csdfbpCostcenterDBpList";
    public static final String PROPERTY_IMDLVLINESLIST = "imdlvLinesList";
    public static final String PROPERTY_SBPRFFACTACCTAGGDLIST = "sbprfFactAcctAggdList";
    public static final String PROPERTY_SBPRFFACTACCTAGGDDOCLIST = "sbprfFactAcctAggdDocList";
    public static final String PROPERTY_SDCDEBITCOLLECTLIST = "sdcDebitcollectList";
    public static final String PROPERTY_SDCCDAILYCLOSSINGLIST = "sdccDailyClossingList";
    public static final String PROPERTY_SIMPPYSPAYMENTDETAILLIST = "simppysPaymentDetailList";
    public static final String PROPERTY_SSALACTIVEMAINLIST = "ssalActiveMainList";
    public static final String PROPERTY_SSALAPPLACTIVELIST = "ssalApplActiveList";
    public static final String PROPERTY_SSALASSETRETURNLINELIST = "ssalAssetReturnlineList";
    public static final String PROPERTY_SSDCCPDISTCOSTCENTERLIST = "ssdccpDistcostcenterList";
    public static final String PROPERTY_SSORELINVOICEORDERVLIST = "ssorelInvoiceorderVList";
    public static final String PROPERTY_SSPDPCTDISTCOSTCENTERLIST = "sspdPctdistCostcenterList";
    public static final String PROPERTY_SWSPCCONFIGLIST = "swspcConfigList";

    public UserDimension1() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SUMMARYLEVEL, false);
        setDefaultValue(PROPERTY_SSDCCPISDISTCOSTCENTER, false);
        setDefaultValue(PROPERTY_SSDCCPDISTPORTJE, new BigDecimal(0));
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_APRMFINACCTRXFULLACCTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_AMORTIZATIONLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSPRUSER1IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_BUSINESSPARTNEREMSSFCUSER1IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINDOUBTFULDEBTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGCOMBINATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTACCOUNTINGFACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTASSETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBUDGETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTCASHJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDPMANAGEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INOUTLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINTERNALMOVEMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTINVENTORYCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTPRODUCTIONTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_MATERIALMGMTSHIPMENTINOUTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORDERLINEACCOUNTINGDIMENSIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMSSOPOSUSER1IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLTICKETEMSPRCUSER1IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_STXREVFINANCIALLACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTACCOUNTINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSMAACTAUDITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_TIMEANDEXPENSESHEETLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAACUSTODIANLINEUSER12IDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSAAAINVTTKGLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_CSDFBPCOSTCENTERDBPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_IMDLVLINESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPRFFACTACCTAGGDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SBPRFFACTACCTAGGDDOCLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCDEBITCOLLECTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPPYSPAYMENTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALACTIVEMAINLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALAPPLACTIVELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSALASSETRETURNLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDCCPDISTCOSTCENTERLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSORELINVOICEORDERVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPDPCTDISTCOSTCENTERLIST, new ArrayList<Object>());
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

    public Boolean isSummaryLevel() {
        return (Boolean) get(PROPERTY_SUMMARYLEVEL);
    }

    public void setSummaryLevel(Boolean summaryLevel) {
        set(PROPERTY_SUMMARYLEVEL, summaryLevel);
    }

    public Boolean isSsdccpIsdistcostcenter() {
        return (Boolean) get(PROPERTY_SSDCCPISDISTCOSTCENTER);
    }

    public void setSsdccpIsdistcostcenter(Boolean ssdccpIsdistcostcenter) {
        set(PROPERTY_SSDCCPISDISTCOSTCENTER, ssdccpIsdistcostcenter);
    }

    public BigDecimal getSsdccpDistportje() {
        return (BigDecimal) get(PROPERTY_SSDCCPDISTPORTJE);
    }

    public void setSsdccpDistportje(BigDecimal ssdccpDistportje) {
        set(PROPERTY_SSDCCPDISTPORTJE, ssdccpDistportje);
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
    public List<BusinessPartner> getBusinessPartnerEMSsprUser1IDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSPRUSER1IDLIST);
    }

    public void setBusinessPartnerEMSsprUser1IDList(List<BusinessPartner> businessPartnerEMSsprUser1IDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSPRUSER1IDLIST, businessPartnerEMSsprUser1IDList);
    }

    @SuppressWarnings("unchecked")
    public List<BusinessPartner> getBusinessPartnerEMSsfcUser1IDList() {
      return (List<BusinessPartner>) get(PROPERTY_BUSINESSPARTNEREMSSFCUSER1IDLIST);
    }

    public void setBusinessPartnerEMSsfcUser1IDList(List<BusinessPartner> businessPartnerEMSsfcUser1IDList) {
        set(PROPERTY_BUSINESSPARTNEREMSSFCUSER1IDLIST, businessPartnerEMSsfcUser1IDList);
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
    public List<FIN_Payment> getFINPaymentList() {
      return (List<FIN_Payment>) get(PROPERTY_FINPAYMENTLIST);
    }

    public void setFINPaymentList(List<FIN_Payment> fINPaymentList) {
        set(PROPERTY_FINPAYMENTLIST, fINPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentScheduleDetail> getFINPaymentScheduleDetailList() {
      return (List<FIN_PaymentScheduleDetail>) get(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST);
    }

    public void setFINPaymentScheduleDetailList(List<FIN_PaymentScheduleDetail> fINPaymentScheduleDetailList) {
        set(PROPERTY_FINPAYMENTSCHEDULEDETAILLIST, fINPaymentScheduleDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_ReconciliationLine_v> getFINReconciliationLineVList() {
      return (List<FIN_ReconciliationLine_v>) get(PROPERTY_FINRECONCILIATIONLINEVLIST);
    }

    public void setFINReconciliationLineVList(List<FIN_ReconciliationLine_v> fINReconciliationLineVList) {
        set(PROPERTY_FINRECONCILIATIONLINEVLIST, fINReconciliationLineVList);
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
    public List<Amortization> getFinancialMgmtAmortizationList() {
      return (List<Amortization>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST);
    }

    public void setFinancialMgmtAmortizationList(List<Amortization> financialMgmtAmortizationList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLIST, financialMgmtAmortizationList);
    }

    @SuppressWarnings("unchecked")
    public List<AmortizationLine> getFinancialMgmtAmortizationLineList() {
      return (List<AmortizationLine>) get(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST);
    }

    public void setFinancialMgmtAmortizationLineList(List<AmortizationLine> financialMgmtAmortizationLineList) {
        set(PROPERTY_FINANCIALMGMTAMORTIZATIONLINELIST, financialMgmtAmortizationLineList);
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
    public List<CashJournal> getFinancialMgmtCashJournalList() {
      return (List<CashJournal>) get(PROPERTY_FINANCIALMGMTCASHJOURNALLIST);
    }

    public void setFinancialMgmtCashJournalList(List<CashJournal> financialMgmtCashJournalList) {
        set(PROPERTY_FINANCIALMGMTCASHJOURNALLIST, financialMgmtCashJournalList);
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
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<Settlement> getFinancialMgmtSettlementList() {
      return (List<Settlement>) get(PROPERTY_FINANCIALMGMTSETTLEMENTLIST);
    }

    public void setFinancialMgmtSettlementList(List<Settlement> financialMgmtSettlementList) {
        set(PROPERTY_FINANCIALMGMTSETTLEMENTLIST, financialMgmtSettlementList);
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
    public List<InvoiceLineAccountingDimension> getInvoiceLineAccountingDimensionList() {
      return (List<InvoiceLineAccountingDimension>) get(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST);
    }

    public void setInvoiceLineAccountingDimensionList(List<InvoiceLineAccountingDimension> invoiceLineAccountingDimensionList) {
        set(PROPERTY_INVOICELINEACCOUNTINGDIMENSIONLIST, invoiceLineAccountingDimensionList);
    }

    @SuppressWarnings("unchecked")
    public List<InternalConsumption> getMaterialMgmtInternalConsumptionList() {
      return (List<InternalConsumption>) get(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST);
    }

    public void setMaterialMgmtInternalConsumptionList(List<InternalConsumption> materialMgmtInternalConsumptionList) {
        set(PROPERTY_MATERIALMGMTINTERNALCONSUMPTIONLIST, materialMgmtInternalConsumptionList);
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
    public List<Organization> getOrganizationEMSsoposUser1IDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMSSOPOSUSER1IDLIST);
    }

    public void setOrganizationEMSsoposUser1IDList(List<Organization> organizationEMSsoposUser1IDList) {
        set(PROPERTY_ORGANIZATIONEMSSOPOSUSER1IDLIST, organizationEMSsoposUser1IDList);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<PayrollTicket> getSSPRPayrollTicketEMSprcUser1IDList() {
      return (List<PayrollTicket>) get(PROPERTY_SSPRPAYROLLTICKETEMSPRCUSER1IDLIST);
    }

    public void setSSPRPayrollTicketEMSprcUser1IDList(List<PayrollTicket> sSPRPayrollTicketEMSprcUser1IDList) {
        set(PROPERTY_SSPRPAYROLLTICKETEMSPRCUSER1IDLIST, sSPRPayrollTicketEMSprcUser1IDList);
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
    public List<CsaaaCustodian> getCsaaaCustodianList() {
      return (List<CsaaaCustodian>) get(PROPERTY_CSAAACUSTODIANLIST);
    }

    public void setCsaaaCustodianList(List<CsaaaCustodian> csaaaCustodianList) {
        set(PROPERTY_CSAAACUSTODIANLIST, csaaaCustodianList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINELIST);
    }

    public void setCsaaaCustodianlineList(List<CsaaaCustodianLine> csaaaCustodianlineList) {
        set(PROPERTY_CSAAACUSTODIANLINELIST, csaaaCustodianlineList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaCustodianLine> getCsaaaCustodianlineUser12IDList() {
      return (List<CsaaaCustodianLine>) get(PROPERTY_CSAAACUSTODIANLINEUSER12IDLIST);
    }

    public void setCsaaaCustodianlineUser12IDList(List<CsaaaCustodianLine> csaaaCustodianlineUser12IDList) {
        set(PROPERTY_CSAAACUSTODIANLINEUSER12IDLIST, csaaaCustodianlineUser12IDList);
    }

    @SuppressWarnings("unchecked")
    public List<CsaaaInventoryTakingLine> getCsaaaInvtTkgLineList() {
      return (List<CsaaaInventoryTakingLine>) get(PROPERTY_CSAAAINVTTKGLINELIST);
    }

    public void setCsaaaInvtTkgLineList(List<CsaaaInventoryTakingLine> csaaaInvtTkgLineList) {
        set(PROPERTY_CSAAAINVTTKGLINELIST, csaaaInvtTkgLineList);
    }

    @SuppressWarnings("unchecked")
    public List<CSDFBP_CostcenterDistributionForBP> getCsdfbpCostcenterDBpList() {
      return (List<CSDFBP_CostcenterDistributionForBP>) get(PROPERTY_CSDFBPCOSTCENTERDBPLIST);
    }

    public void setCsdfbpCostcenterDBpList(List<CSDFBP_CostcenterDistributionForBP> csdfbpCostcenterDBpList) {
        set(PROPERTY_CSDFBPCOSTCENTERDBPLIST, csdfbpCostcenterDBpList);
    }

    @SuppressWarnings("unchecked")
    public List<Imdlv_Lines> getImdlvLinesList() {
      return (List<Imdlv_Lines>) get(PROPERTY_IMDLVLINESLIST);
    }

    public void setImdlvLinesList(List<Imdlv_Lines> imdlvLinesList) {
        set(PROPERTY_IMDLVLINESLIST, imdlvLinesList);
    }

    @SuppressWarnings("unchecked")
    public List<SbprfFactAcctAggd> getSbprfFactAcctAggdList() {
      return (List<SbprfFactAcctAggd>) get(PROPERTY_SBPRFFACTACCTAGGDLIST);
    }

    public void setSbprfFactAcctAggdList(List<SbprfFactAcctAggd> sbprfFactAcctAggdList) {
        set(PROPERTY_SBPRFFACTACCTAGGDLIST, sbprfFactAcctAggdList);
    }

    @SuppressWarnings("unchecked")
    public List<SbprfFactAcctAggdDoc> getSbprfFactAcctAggdDocList() {
      return (List<SbprfFactAcctAggdDoc>) get(PROPERTY_SBPRFFACTACCTAGGDDOCLIST);
    }

    public void setSbprfFactAcctAggdDocList(List<SbprfFactAcctAggdDoc> sbprfFactAcctAggdDocList) {
        set(PROPERTY_SBPRFFACTACCTAGGDDOCLIST, sbprfFactAcctAggdDocList);
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
    public List<Simppys_PaymentDetail> getSimppysPaymentDetailList() {
      return (List<Simppys_PaymentDetail>) get(PROPERTY_SIMPPYSPAYMENTDETAILLIST);
    }

    public void setSimppysPaymentDetailList(List<Simppys_PaymentDetail> simppysPaymentDetailList) {
        set(PROPERTY_SIMPPYSPAYMENTDETAILLIST, simppysPaymentDetailList);
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
    public List<ssalassetreturnline> getSsalAssetReturnlineList() {
      return (List<ssalassetreturnline>) get(PROPERTY_SSALASSETRETURNLINELIST);
    }

    public void setSsalAssetReturnlineList(List<ssalassetreturnline> ssalAssetReturnlineList) {
        set(PROPERTY_SSALASSETRETURNLINELIST, ssalAssetReturnlineList);
    }

    @SuppressWarnings("unchecked")
    public List<SsdccpDistributeCostCenter> getSsdccpDistcostcenterList() {
      return (List<SsdccpDistributeCostCenter>) get(PROPERTY_SSDCCPDISTCOSTCENTERLIST);
    }

    public void setSsdccpDistcostcenterList(List<SsdccpDistributeCostCenter> ssdccpDistcostcenterList) {
        set(PROPERTY_SSDCCPDISTCOSTCENTERLIST, ssdccpDistcostcenterList);
    }

    @SuppressWarnings("unchecked")
    public List<ssorel_invoiceorder_v> getSsorelInvoiceorderVList() {
      return (List<ssorel_invoiceorder_v>) get(PROPERTY_SSORELINVOICEORDERVLIST);
    }

    public void setSsorelInvoiceorderVList(List<ssorel_invoiceorder_v> ssorelInvoiceorderVList) {
        set(PROPERTY_SSORELINVOICEORDERVLIST, ssorelInvoiceorderVList);
    }

    @SuppressWarnings("unchecked")
    public List<sspdpctdistcostcenter> getSspdPctdistCostcenterList() {
      return (List<sspdpctdistcostcenter>) get(PROPERTY_SSPDPCTDISTCOSTCENTERLIST);
    }

    public void setSspdPctdistCostcenterList(List<sspdpctdistcostcenter> sspdPctdistCostcenterList) {
        set(PROPERTY_SSPDPCTDISTCOSTCENTERLIST, sspdPctdistCostcenterList);
    }

    @SuppressWarnings("unchecked")
    public List<SWSPCConfig> getSwspcConfigList() {
      return (List<SWSPCConfig>) get(PROPERTY_SWSPCCONFIGLIST);
    }

    public void setSwspcConfigList(List<SWSPCConfig> swspcConfigList) {
        set(PROPERTY_SWSPCCONFIGLIST, swspcConfigList);
    }

}
