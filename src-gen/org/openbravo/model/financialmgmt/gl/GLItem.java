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
package org.openbravo.model.financialmgmt.gl;

import com.sidesoft.hrm.payroll.Concept;
import com.sidesoft.hrm.payroll.ssprpayrollpayment;

import ec.com.sidesoft.cash.flow.SscflwExpensivePayoutView;
import ec.com.sidesoft.closecash.financial.account.SscccfaFinAccConcept;
import ec.com.sidesoft.closecash.sales.order.SsccsoAccountingConcept;
import ec.com.sidesoft.closecash.sales.order.SsccsoCashIncExp;
import ec.com.sidesoft.creditcard.reconciliation.SsccrWithholdings;
import ec.com.sidesoft.creditcard.reconciliation.transaction.sccrt_concepts;
import ec.com.sidesoft.custom.closecash.ScccSetup;
import ec.com.sidesoft.daily.closing.charge.SdccDailyClossing;
import ec.com.sidesoft.discount.quota.salesinvoices.QuotaDetail;
import ec.com.sidesoft.importdata.payments.Simppys_PaymentDetail;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SSWSWithholdingSale;
import ec.com.sidesoft.localization.ecuador.withholdingssales.SswsAdvancePayment;
import ec.com.sidesoft.payroll.events.SPEVConfigNews;
import ec.com.sidesoft.payroll.events.SPEVDetailNews;
import ec.com.sidesoft.projects.complement.SproctmTaskContract;
import ec.com.sidesoft.settlement.project.cost.SstpcPaymentLiqView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.advpaymentmngt.APRM_FinaccTransactionV;
import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.cashmgmt.BankStatementLine;
import org.openbravo.model.financialmgmt.cashmgmt.CashJournalLine;
import org.openbravo.model.financialmgmt.payment.DebtPayment;
import org.openbravo.model.financialmgmt.payment.DebtPaymentBalReplace;
import org.openbravo.model.financialmgmt.payment.DebtPaymentBalancing;
import org.openbravo.model.financialmgmt.payment.DebtPaymentGenerateV;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatementLine;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentPropDetail;
import org.openbravo.model.financialmgmt.payment.FIN_ReconciliationLine_v;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.tax.TaxRegisterType;
import org.openbravo.model.financialmgmt.tax.Withholding;
import org.openbravo.model.materialmgmt.cost.LandedCostType;
import org.openbravo.retail.copystore.OBPOSCS_Defaults;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftCardInst;
import org.openbravo.retail.giftcards.org.openbravo.retail.giftcards.GiftcardReason;
import org.openbravo.retail.posterminal.OBPOSAppPayment;
import org.openbravo.retail.posterminal.TerminalTypePaymentMethod;
/**
 * Entity class for entity FinancialMgmtGLItem (stored in table C_Glitem).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class GLItem extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "C_Glitem";
    public static final String ENTITY_NAME = "FinancialMgmtGLItem";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_ENABLEINCASH = "enableInCash";
    public static final String PROPERTY_ENABLEINFINANCIALINVOICES = "enableInFinancialInvoices";
    public static final String PROPERTY_TAXCATEGORY = "taxCategory";
    public static final String PROPERTY_TAX = "tax";
    public static final String PROPERTY_WITHHOLDING = "withholding";
    public static final String PROPERTY_SSPHADVPAYTHIRTEENTH = "ssphAdvPayThirteenth";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_APRMFINACCTRANSACTIONVLIST = "aPRMFinaccTransactionVList";
    public static final String PROPERTY_FINBANKSTATEMENTLINELIST = "fINBankStatementLineList";
    public static final String PROPERTY_FINFINACCTRANSACTIONLIST = "fINFinaccTransactionList";
    public static final String PROPERTY_FINPAYMENTDETAILLIST = "fINPaymentDetailList";
    public static final String PROPERTY_FINPAYMENTPROPDETAILLIST = "fINPaymentPropDetailList";
    public static final String PROPERTY_FINRECONCILIATIONLINEVLIST = "fINReconciliationLineVList";
    public static final String PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST = "financialMgmtBankStatementLineList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST = "financialMgmtDebtPaymentList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST = "financialMgmtDebtPaymentBalReplaceList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST = "financialMgmtDebtPaymentBalancingList";
    public static final String PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST = "financialMgmtDebtPaymentGenerateVList";
    public static final String PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST = "financialMgmtGLItemAccountsList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINELIST = "financialMgmtGLJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST = "financialMgmtGLJournalLineGLItemsList";
    public static final String PROPERTY_FINANCIALMGMTJOURNALLINELIST = "financialMgmtJournalLineList";
    public static final String PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST = "financialMgmtTaxRegisterTypeList";
    public static final String PROPERTY_GCNVGIFTCARDINSTLIST = "gCNVGiftCardInstList";
    public static final String PROPERTY_GCNVGIFTCARDREASONLIST = "gCNVGiftcardReasonList";
    public static final String PROPERTY_INVOICELINEACCOUNTLIST = "invoiceLineAccountList";
    public static final String PROPERTY_LANDEDCOSTTYPEACCOUNTLIST = "landedCostTypeAccountList";
    public static final String PROPERTY_OBPOSCSDEFAULTSGLITEMFORWRITEOFFLIST = "oBPOSCSDefaultsGLItemForWriteoffList";
    public static final String PROPERTY_OBPOSCSDEFAULTSCASHDIFFERENCESLIST = "oBPOSCSDefaultsCashDifferencesList";
    public static final String PROPERTY_OBPOSCSDEFAULTSGLITEMFORWITHDRAWALSLIST = "oBPOSCSDefaultsGLItemForWithdrawalsList";
    public static final String PROPERTY_OBPOSCSDEFAULTSGLITEMFORDEPOSITSLIST = "oBPOSCSDefaultsGLItemForDepositsList";
    public static final String PROPERTY_OBPOSCSDEFAULTSGLITEMFORCASHDROPDEPOSITLIST = "oBPOSCSDefaultsGLItemForCashDropDepositList";
    public static final String PROPERTY_OBPOSAPPPAYMENTCASHDIFFERENCESLIST = "oBPOSAppPaymentCashDifferencesList";
    public static final String PROPERTY_OBPOSAPPPAYMENTGLITEMFORCASHDROPDEPOSITLIST = "oBPOSAppPaymentGLItemForCashDropDepositList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPECASHDIFFERENCESLIST = "oBPOSAppPaymentTypeCashDifferencesList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDROPSLIST = "oBPOSAppPaymentTypeGLItemForDropsList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDEPOSITSLIST = "oBPOSAppPaymentTypeGLItemForDepositsList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMDROPDEPIDLIST = "oBPOSAppPaymentTypeCGlitemDropdepIDList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMWRITEOFFIDLIST = "oBPOSAppPaymentTypeCGlitemWriteoffIDList";
    public static final String PROPERTY_OBPOSAPPPAYMENTTYPEEMGCNVREIMBURSEGLITEMIDLIST = "oBPOSAppPaymentTypeEMGcnvReimburseGlitemIDList";
    public static final String PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST = "organizationEMAPRMGlitemIDList";
    public static final String PROPERTY_SPEVCONFIGNEWSLIST = "sPEVConfigNewsList";
    public static final String PROPERTY_SPEVDETAILNEWSLIST = "sPEVDetailNewsList";
    public static final String PROPERTY_SSDQSIQUOTADETAILLIST = "sSDQSIQuotaDetailList";
    public static final String PROPERTY_SSWSWITHHOLDINGSALELIST = "sSWSWithholdingSaleList";
    public static final String PROPERTY_SCCCSETUPLIST = "scccSetupList";
    public static final String PROPERTY_SSCCRWITHHOLDINGSLIST = "ssccrWithholdingsList";
    public static final String PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST = "ssccsoAccountingConceptList";
    public static final String PROPERTY_SSCCSOCASHINCEXPLIST = "ssccsoCashIncExpList";
    public static final String PROPERTY_SCCRTCONCEPTSLIST = "sccrtConceptsList";
    public static final String PROPERTY_SDCCDAILYCLOSSINGLIST = "sdccDailyClossingList";
    public static final String PROPERTY_SIMPPYSPAYMENTDETAILLIST = "simppysPaymentDetailList";
    public static final String PROPERTY_SPROCTMTASKCONTRACTLIST = "sproctmTaskContractList";
    public static final String PROPERTY_SSCCCFAFINACCCONCEPTLIST = "sscccfaFinAccConceptList";
    public static final String PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST = "sscflwExpensivePayoutVList";
    public static final String PROPERTY_SSPRPAYROLLPAYMENTLIST = "ssprPayrollpaymentList";
    public static final String PROPERTY_SSTPCPAYMENTLIQVCONCEPTOCONTABLELIST = "sstpcPaymentLiqVConceptoContableList";
    public static final String PROPERTY_SSWSADVANCEPAYMENTLIST = "sswsAdvancePaymentList";

    public GLItem() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ENABLEINCASH, false);
        setDefaultValue(PROPERTY_ENABLEINFINANCIALINVOICES, false);
        setDefaultValue(PROPERTY_SSPHADVPAYTHIRTEENTH, false);
        setDefaultValue(PROPERTY_APRMFINACCTRANSACTIONVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINBANKSTATEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINFINACCTRANSACTIONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINPAYMENTPROPDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINRECONCILIATIONLINEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTJOURNALLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDINSTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_GCNVGIFTCARDREASONLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_INVOICELINEACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_LANDEDCOSTTYPEACCOUNTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSCSDEFAULTSGLITEMFORWRITEOFFLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSCSDEFAULTSCASHDIFFERENCESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSCSDEFAULTSGLITEMFORWITHDRAWALSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSCSDEFAULTSGLITEMFORDEPOSITSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSCSDEFAULTSGLITEMFORCASHDROPDEPOSITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTCASHDIFFERENCESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTGLITEMFORCASHDROPDEPOSITLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPECASHDIFFERENCESLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDROPSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDEPOSITSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMDROPDEPIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMWRITEOFFIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_OBPOSAPPPAYMENTTYPEEMGCNVREIMBURSEGLITEMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEVCONFIGNEWSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEVDETAILNEWSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSDQSIQUOTADETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSWITHHOLDINGSALELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCCSETUPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCRWITHHOLDINGSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCSOCASHINCEXPLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SCCRTCONCEPTSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SDCCDAILYCLOSSINGLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SIMPPYSPAYMENTDETAILLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPROCTMTASKCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCCCFAFINACCCONCEPTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRPAYROLLPAYMENTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSTPCPAYMENTLIQVCONCEPTOCONTABLELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSWSADVANCEPAYMENTLIST, new ArrayList<Object>());
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Boolean isEnableInCash() {
        return (Boolean) get(PROPERTY_ENABLEINCASH);
    }

    public void setEnableInCash(Boolean enableInCash) {
        set(PROPERTY_ENABLEINCASH, enableInCash);
    }

    public Boolean isEnableInFinancialInvoices() {
        return (Boolean) get(PROPERTY_ENABLEINFINANCIALINVOICES);
    }

    public void setEnableInFinancialInvoices(Boolean enableInFinancialInvoices) {
        set(PROPERTY_ENABLEINFINANCIALINVOICES, enableInFinancialInvoices);
    }

    public TaxCategory getTaxCategory() {
        return (TaxCategory) get(PROPERTY_TAXCATEGORY);
    }

    public void setTaxCategory(TaxCategory taxCategory) {
        set(PROPERTY_TAXCATEGORY, taxCategory);
    }

    public TaxRate getTax() {
        return (TaxRate) get(PROPERTY_TAX);
    }

    public void setTax(TaxRate tax) {
        set(PROPERTY_TAX, tax);
    }

    public Withholding getWithholding() {
        return (Withholding) get(PROPERTY_WITHHOLDING);
    }

    public void setWithholding(Withholding withholding) {
        set(PROPERTY_WITHHOLDING, withholding);
    }

    public Boolean isSsphAdvPayThirteenth() {
        return (Boolean) get(PROPERTY_SSPHADVPAYTHIRTEENTH);
    }

    public void setSsphAdvPayThirteenth(Boolean ssphAdvPayThirteenth) {
        set(PROPERTY_SSPHADVPAYTHIRTEENTH, ssphAdvPayThirteenth);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    @SuppressWarnings("unchecked")
    public List<APRM_FinaccTransactionV> getAPRMFinaccTransactionVList() {
      return (List<APRM_FinaccTransactionV>) get(PROPERTY_APRMFINACCTRANSACTIONVLIST);
    }

    public void setAPRMFinaccTransactionVList(List<APRM_FinaccTransactionV> aPRMFinaccTransactionVList) {
        set(PROPERTY_APRMFINACCTRANSACTIONVLIST, aPRMFinaccTransactionVList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_BankStatementLine> getFINBankStatementLineList() {
      return (List<FIN_BankStatementLine>) get(PROPERTY_FINBANKSTATEMENTLINELIST);
    }

    public void setFINBankStatementLineList(List<FIN_BankStatementLine> fINBankStatementLineList) {
        set(PROPERTY_FINBANKSTATEMENTLINELIST, fINBankStatementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_FinaccTransaction> getFINFinaccTransactionList() {
      return (List<FIN_FinaccTransaction>) get(PROPERTY_FINFINACCTRANSACTIONLIST);
    }

    public void setFINFinaccTransactionList(List<FIN_FinaccTransaction> fINFinaccTransactionList) {
        set(PROPERTY_FINFINACCTRANSACTIONLIST, fINFinaccTransactionList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentDetail> getFINPaymentDetailList() {
      return (List<FIN_PaymentDetail>) get(PROPERTY_FINPAYMENTDETAILLIST);
    }

    public void setFINPaymentDetailList(List<FIN_PaymentDetail> fINPaymentDetailList) {
        set(PROPERTY_FINPAYMENTDETAILLIST, fINPaymentDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_PaymentPropDetail> getFINPaymentPropDetailList() {
      return (List<FIN_PaymentPropDetail>) get(PROPERTY_FINPAYMENTPROPDETAILLIST);
    }

    public void setFINPaymentPropDetailList(List<FIN_PaymentPropDetail> fINPaymentPropDetailList) {
        set(PROPERTY_FINPAYMENTPROPDETAILLIST, fINPaymentPropDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<FIN_ReconciliationLine_v> getFINReconciliationLineVList() {
      return (List<FIN_ReconciliationLine_v>) get(PROPERTY_FINRECONCILIATIONLINEVLIST);
    }

    public void setFINReconciliationLineVList(List<FIN_ReconciliationLine_v> fINReconciliationLineVList) {
        set(PROPERTY_FINRECONCILIATIONLINEVLIST, fINReconciliationLineVList);
    }

    @SuppressWarnings("unchecked")
    public List<BankStatementLine> getFinancialMgmtBankStatementLineList() {
      return (List<BankStatementLine>) get(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST);
    }

    public void setFinancialMgmtBankStatementLineList(List<BankStatementLine> financialMgmtBankStatementLineList) {
        set(PROPERTY_FINANCIALMGMTBANKSTATEMENTLINELIST, financialMgmtBankStatementLineList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPayment> getFinancialMgmtDebtPaymentList() {
      return (List<DebtPayment>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST);
    }

    public void setFinancialMgmtDebtPaymentList(List<DebtPayment> financialMgmtDebtPaymentList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTLIST, financialMgmtDebtPaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentBalReplace> getFinancialMgmtDebtPaymentBalReplaceList() {
      return (List<DebtPaymentBalReplace>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST);
    }

    public void setFinancialMgmtDebtPaymentBalReplaceList(List<DebtPaymentBalReplace> financialMgmtDebtPaymentBalReplaceList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALREPLACELIST, financialMgmtDebtPaymentBalReplaceList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentBalancing> getFinancialMgmtDebtPaymentBalancingList() {
      return (List<DebtPaymentBalancing>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST);
    }

    public void setFinancialMgmtDebtPaymentBalancingList(List<DebtPaymentBalancing> financialMgmtDebtPaymentBalancingList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTBALANCINGLIST, financialMgmtDebtPaymentBalancingList);
    }

    @SuppressWarnings("unchecked")
    public List<DebtPaymentGenerateV> getFinancialMgmtDebtPaymentGenerateVList() {
      return (List<DebtPaymentGenerateV>) get(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST);
    }

    public void setFinancialMgmtDebtPaymentGenerateVList(List<DebtPaymentGenerateV> financialMgmtDebtPaymentGenerateVList) {
        set(PROPERTY_FINANCIALMGMTDEBTPAYMENTGENERATEVLIST, financialMgmtDebtPaymentGenerateVList);
    }

    @SuppressWarnings("unchecked")
    public List<GLItemAccounts> getFinancialMgmtGLItemAccountsList() {
      return (List<GLItemAccounts>) get(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST);
    }

    public void setFinancialMgmtGLItemAccountsList(List<GLItemAccounts> financialMgmtGLItemAccountsList) {
        set(PROPERTY_FINANCIALMGMTGLITEMACCOUNTSLIST, financialMgmtGLItemAccountsList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST);
    }

    public void setFinancialMgmtGLJournalLineList(List<GLJournalLine> financialMgmtGLJournalLineList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINELIST, financialMgmtGLJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<GLJournalLine> getFinancialMgmtGLJournalLineGLItemsList() {
      return (List<GLJournalLine>) get(PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST);
    }

    public void setFinancialMgmtGLJournalLineGLItemsList(List<GLJournalLine> financialMgmtGLJournalLineGLItemsList) {
        set(PROPERTY_FINANCIALMGMTGLJOURNALLINEGLITEMSLIST, financialMgmtGLJournalLineGLItemsList);
    }

    @SuppressWarnings("unchecked")
    public List<CashJournalLine> getFinancialMgmtJournalLineList() {
      return (List<CashJournalLine>) get(PROPERTY_FINANCIALMGMTJOURNALLINELIST);
    }

    public void setFinancialMgmtJournalLineList(List<CashJournalLine> financialMgmtJournalLineList) {
        set(PROPERTY_FINANCIALMGMTJOURNALLINELIST, financialMgmtJournalLineList);
    }

    @SuppressWarnings("unchecked")
    public List<TaxRegisterType> getFinancialMgmtTaxRegisterTypeList() {
      return (List<TaxRegisterType>) get(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST);
    }

    public void setFinancialMgmtTaxRegisterTypeList(List<TaxRegisterType> financialMgmtTaxRegisterTypeList) {
        set(PROPERTY_FINANCIALMGMTTAXREGISTERTYPELIST, financialMgmtTaxRegisterTypeList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftCardInst> getGCNVGiftCardInstList() {
      return (List<GiftCardInst>) get(PROPERTY_GCNVGIFTCARDINSTLIST);
    }

    public void setGCNVGiftCardInstList(List<GiftCardInst> gCNVGiftCardInstList) {
        set(PROPERTY_GCNVGIFTCARDINSTLIST, gCNVGiftCardInstList);
    }

    @SuppressWarnings("unchecked")
    public List<GiftcardReason> getGCNVGiftcardReasonList() {
      return (List<GiftcardReason>) get(PROPERTY_GCNVGIFTCARDREASONLIST);
    }

    public void setGCNVGiftcardReasonList(List<GiftcardReason> gCNVGiftcardReasonList) {
        set(PROPERTY_GCNVGIFTCARDREASONLIST, gCNVGiftcardReasonList);
    }

    @SuppressWarnings("unchecked")
    public List<InvoiceLine> getInvoiceLineAccountList() {
      return (List<InvoiceLine>) get(PROPERTY_INVOICELINEACCOUNTLIST);
    }

    public void setInvoiceLineAccountList(List<InvoiceLine> invoiceLineAccountList) {
        set(PROPERTY_INVOICELINEACCOUNTLIST, invoiceLineAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<LandedCostType> getLandedCostTypeAccountList() {
      return (List<LandedCostType>) get(PROPERTY_LANDEDCOSTTYPEACCOUNTLIST);
    }

    public void setLandedCostTypeAccountList(List<LandedCostType> landedCostTypeAccountList) {
        set(PROPERTY_LANDEDCOSTTYPEACCOUNTLIST, landedCostTypeAccountList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSCS_Defaults> getOBPOSCSDefaultsGLItemForWriteoffList() {
      return (List<OBPOSCS_Defaults>) get(PROPERTY_OBPOSCSDEFAULTSGLITEMFORWRITEOFFLIST);
    }

    public void setOBPOSCSDefaultsGLItemForWriteoffList(List<OBPOSCS_Defaults> oBPOSCSDefaultsGLItemForWriteoffList) {
        set(PROPERTY_OBPOSCSDEFAULTSGLITEMFORWRITEOFFLIST, oBPOSCSDefaultsGLItemForWriteoffList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSCS_Defaults> getOBPOSCSDefaultsCashDifferencesList() {
      return (List<OBPOSCS_Defaults>) get(PROPERTY_OBPOSCSDEFAULTSCASHDIFFERENCESLIST);
    }

    public void setOBPOSCSDefaultsCashDifferencesList(List<OBPOSCS_Defaults> oBPOSCSDefaultsCashDifferencesList) {
        set(PROPERTY_OBPOSCSDEFAULTSCASHDIFFERENCESLIST, oBPOSCSDefaultsCashDifferencesList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSCS_Defaults> getOBPOSCSDefaultsGLItemForWithdrawalsList() {
      return (List<OBPOSCS_Defaults>) get(PROPERTY_OBPOSCSDEFAULTSGLITEMFORWITHDRAWALSLIST);
    }

    public void setOBPOSCSDefaultsGLItemForWithdrawalsList(List<OBPOSCS_Defaults> oBPOSCSDefaultsGLItemForWithdrawalsList) {
        set(PROPERTY_OBPOSCSDEFAULTSGLITEMFORWITHDRAWALSLIST, oBPOSCSDefaultsGLItemForWithdrawalsList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSCS_Defaults> getOBPOSCSDefaultsGLItemForDepositsList() {
      return (List<OBPOSCS_Defaults>) get(PROPERTY_OBPOSCSDEFAULTSGLITEMFORDEPOSITSLIST);
    }

    public void setOBPOSCSDefaultsGLItemForDepositsList(List<OBPOSCS_Defaults> oBPOSCSDefaultsGLItemForDepositsList) {
        set(PROPERTY_OBPOSCSDEFAULTSGLITEMFORDEPOSITSLIST, oBPOSCSDefaultsGLItemForDepositsList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSCS_Defaults> getOBPOSCSDefaultsGLItemForCashDropDepositList() {
      return (List<OBPOSCS_Defaults>) get(PROPERTY_OBPOSCSDEFAULTSGLITEMFORCASHDROPDEPOSITLIST);
    }

    public void setOBPOSCSDefaultsGLItemForCashDropDepositList(List<OBPOSCS_Defaults> oBPOSCSDefaultsGLItemForCashDropDepositList) {
        set(PROPERTY_OBPOSCSDEFAULTSGLITEMFORCASHDROPDEPOSITLIST, oBPOSCSDefaultsGLItemForCashDropDepositList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSAppPayment> getOBPOSAppPaymentCashDifferencesList() {
      return (List<OBPOSAppPayment>) get(PROPERTY_OBPOSAPPPAYMENTCASHDIFFERENCESLIST);
    }

    public void setOBPOSAppPaymentCashDifferencesList(List<OBPOSAppPayment> oBPOSAppPaymentCashDifferencesList) {
        set(PROPERTY_OBPOSAPPPAYMENTCASHDIFFERENCESLIST, oBPOSAppPaymentCashDifferencesList);
    }

    @SuppressWarnings("unchecked")
    public List<OBPOSAppPayment> getOBPOSAppPaymentGLItemForCashDropDepositList() {
      return (List<OBPOSAppPayment>) get(PROPERTY_OBPOSAPPPAYMENTGLITEMFORCASHDROPDEPOSITLIST);
    }

    public void setOBPOSAppPaymentGLItemForCashDropDepositList(List<OBPOSAppPayment> oBPOSAppPaymentGLItemForCashDropDepositList) {
        set(PROPERTY_OBPOSAPPPAYMENTGLITEMFORCASHDROPDEPOSITLIST, oBPOSAppPaymentGLItemForCashDropDepositList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeCashDifferencesList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPECASHDIFFERENCESLIST);
    }

    public void setOBPOSAppPaymentTypeCashDifferencesList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeCashDifferencesList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPECASHDIFFERENCESLIST, oBPOSAppPaymentTypeCashDifferencesList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeGLItemForDropsList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDROPSLIST);
    }

    public void setOBPOSAppPaymentTypeGLItemForDropsList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeGLItemForDropsList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDROPSLIST, oBPOSAppPaymentTypeGLItemForDropsList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeGLItemForDepositsList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDEPOSITSLIST);
    }

    public void setOBPOSAppPaymentTypeGLItemForDepositsList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeGLItemForDepositsList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPEGLITEMFORDEPOSITSLIST, oBPOSAppPaymentTypeGLItemForDepositsList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeCGlitemDropdepIDList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMDROPDEPIDLIST);
    }

    public void setOBPOSAppPaymentTypeCGlitemDropdepIDList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeCGlitemDropdepIDList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMDROPDEPIDLIST, oBPOSAppPaymentTypeCGlitemDropdepIDList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeCGlitemWriteoffIDList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMWRITEOFFIDLIST);
    }

    public void setOBPOSAppPaymentTypeCGlitemWriteoffIDList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeCGlitemWriteoffIDList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPECGLITEMWRITEOFFIDLIST, oBPOSAppPaymentTypeCGlitemWriteoffIDList);
    }

    @SuppressWarnings("unchecked")
    public List<TerminalTypePaymentMethod> getOBPOSAppPaymentTypeEMGcnvReimburseGlitemIDList() {
      return (List<TerminalTypePaymentMethod>) get(PROPERTY_OBPOSAPPPAYMENTTYPEEMGCNVREIMBURSEGLITEMIDLIST);
    }

    public void setOBPOSAppPaymentTypeEMGcnvReimburseGlitemIDList(List<TerminalTypePaymentMethod> oBPOSAppPaymentTypeEMGcnvReimburseGlitemIDList) {
        set(PROPERTY_OBPOSAPPPAYMENTTYPEEMGCNVREIMBURSEGLITEMIDLIST, oBPOSAppPaymentTypeEMGcnvReimburseGlitemIDList);
    }

    @SuppressWarnings("unchecked")
    public List<Organization> getOrganizationEMAPRMGlitemIDList() {
      return (List<Organization>) get(PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST);
    }

    public void setOrganizationEMAPRMGlitemIDList(List<Organization> organizationEMAPRMGlitemIDList) {
        set(PROPERTY_ORGANIZATIONEMAPRMGLITEMIDLIST, organizationEMAPRMGlitemIDList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVConfigNews> getSPEVConfigNewsList() {
      return (List<SPEVConfigNews>) get(PROPERTY_SPEVCONFIGNEWSLIST);
    }

    public void setSPEVConfigNewsList(List<SPEVConfigNews> sPEVConfigNewsList) {
        set(PROPERTY_SPEVCONFIGNEWSLIST, sPEVConfigNewsList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVDetailNews> getSPEVDetailNewsList() {
      return (List<SPEVDetailNews>) get(PROPERTY_SPEVDETAILNEWSLIST);
    }

    public void setSPEVDetailNewsList(List<SPEVDetailNews> sPEVDetailNewsList) {
        set(PROPERTY_SPEVDETAILNEWSLIST, sPEVDetailNewsList);
    }

    @SuppressWarnings("unchecked")
    public List<QuotaDetail> getSSDQSIQuotaDetailList() {
      return (List<QuotaDetail>) get(PROPERTY_SSDQSIQUOTADETAILLIST);
    }

    public void setSSDQSIQuotaDetailList(List<QuotaDetail> sSDQSIQuotaDetailList) {
        set(PROPERTY_SSDQSIQUOTADETAILLIST, sSDQSIQuotaDetailList);
    }

    @SuppressWarnings("unchecked")
    public List<SSWSWithholdingSale> getSSWSWithholdingSaleList() {
      return (List<SSWSWithholdingSale>) get(PROPERTY_SSWSWITHHOLDINGSALELIST);
    }

    public void setSSWSWithholdingSaleList(List<SSWSWithholdingSale> sSWSWithholdingSaleList) {
        set(PROPERTY_SSWSWITHHOLDINGSALELIST, sSWSWithholdingSaleList);
    }

    @SuppressWarnings("unchecked")
    public List<ScccSetup> getScccSetupList() {
      return (List<ScccSetup>) get(PROPERTY_SCCCSETUPLIST);
    }

    public void setScccSetupList(List<ScccSetup> scccSetupList) {
        set(PROPERTY_SCCCSETUPLIST, scccSetupList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccrWithholdings> getSsccrWithholdingsList() {
      return (List<SsccrWithholdings>) get(PROPERTY_SSCCRWITHHOLDINGSLIST);
    }

    public void setSsccrWithholdingsList(List<SsccrWithholdings> ssccrWithholdingsList) {
        set(PROPERTY_SSCCRWITHHOLDINGSLIST, ssccrWithholdingsList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoAccountingConcept> getSsccsoAccountingConceptList() {
      return (List<SsccsoAccountingConcept>) get(PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST);
    }

    public void setSsccsoAccountingConceptList(List<SsccsoAccountingConcept> ssccsoAccountingConceptList) {
        set(PROPERTY_SSCCSOACCOUNTINGCONCEPTLIST, ssccsoAccountingConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SsccsoCashIncExp> getSsccsoCashIncExpList() {
      return (List<SsccsoCashIncExp>) get(PROPERTY_SSCCSOCASHINCEXPLIST);
    }

    public void setSsccsoCashIncExpList(List<SsccsoCashIncExp> ssccsoCashIncExpList) {
        set(PROPERTY_SSCCSOCASHINCEXPLIST, ssccsoCashIncExpList);
    }

    @SuppressWarnings("unchecked")
    public List<sccrt_concepts> getSccrtConceptsList() {
      return (List<sccrt_concepts>) get(PROPERTY_SCCRTCONCEPTSLIST);
    }

    public void setSccrtConceptsList(List<sccrt_concepts> sccrtConceptsList) {
        set(PROPERTY_SCCRTCONCEPTSLIST, sccrtConceptsList);
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
    public List<SproctmTaskContract> getSproctmTaskContractList() {
      return (List<SproctmTaskContract>) get(PROPERTY_SPROCTMTASKCONTRACTLIST);
    }

    public void setSproctmTaskContractList(List<SproctmTaskContract> sproctmTaskContractList) {
        set(PROPERTY_SPROCTMTASKCONTRACTLIST, sproctmTaskContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SscccfaFinAccConcept> getSscccfaFinAccConceptList() {
      return (List<SscccfaFinAccConcept>) get(PROPERTY_SSCCCFAFINACCCONCEPTLIST);
    }

    public void setSscccfaFinAccConceptList(List<SscccfaFinAccConcept> sscccfaFinAccConceptList) {
        set(PROPERTY_SSCCCFAFINACCCONCEPTLIST, sscccfaFinAccConceptList);
    }

    @SuppressWarnings("unchecked")
    public List<SscflwExpensivePayoutView> getSscflwExpensivePayoutVList() {
      return (List<SscflwExpensivePayoutView>) get(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST);
    }

    public void setSscflwExpensivePayoutVList(List<SscflwExpensivePayoutView> sscflwExpensivePayoutVList) {
        set(PROPERTY_SSCFLWEXPENSIVEPAYOUTVLIST, sscflwExpensivePayoutVList);
    }

    @SuppressWarnings("unchecked")
    public List<ssprpayrollpayment> getSsprPayrollpaymentList() {
      return (List<ssprpayrollpayment>) get(PROPERTY_SSPRPAYROLLPAYMENTLIST);
    }

    public void setSsprPayrollpaymentList(List<ssprpayrollpayment> ssprPayrollpaymentList) {
        set(PROPERTY_SSPRPAYROLLPAYMENTLIST, ssprPayrollpaymentList);
    }

    @SuppressWarnings("unchecked")
    public List<SstpcPaymentLiqView> getSstpcPaymentLiqVConceptoContableList() {
      return (List<SstpcPaymentLiqView>) get(PROPERTY_SSTPCPAYMENTLIQVCONCEPTOCONTABLELIST);
    }

    public void setSstpcPaymentLiqVConceptoContableList(List<SstpcPaymentLiqView> sstpcPaymentLiqVConceptoContableList) {
        set(PROPERTY_SSTPCPAYMENTLIQVCONCEPTOCONTABLELIST, sstpcPaymentLiqVConceptoContableList);
    }

    @SuppressWarnings("unchecked")
    public List<SswsAdvancePayment> getSswsAdvancePaymentList() {
      return (List<SswsAdvancePayment>) get(PROPERTY_SSWSADVANCEPAYMENTLIST);
    }

    public void setSswsAdvancePaymentList(List<SswsAdvancePayment> sswsAdvancePaymentList) {
        set(PROPERTY_SSWSADVANCEPAYMENTLIST, sswsAdvancePaymentList);
    }

}
