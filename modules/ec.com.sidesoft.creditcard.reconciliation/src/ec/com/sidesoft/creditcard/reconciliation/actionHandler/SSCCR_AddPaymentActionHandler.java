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
 * All portions are Copyright (C) 2014-2016 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.creditcard.reconciliation.actionHandler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.actionHandler.AddPaymentActionHandler;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.advpaymentmngt.process.FIN_PaymentProcess;
import org.openbravo.advpaymentmngt.utility.APRMConstants;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBDao;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBDateUtils;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.FIN_FinancialAccountAccounting;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.gl.GLItem;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetail;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.financialmgmt.payment.FinAccPaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.marketing.Campaign;
import org.openbravo.model.materialmgmt.cost.ABCActivity;
import org.openbravo.model.project.Project;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.service.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.creditcard.reconciliation.SsccrCardsTypes;
import ec.com.sidesoft.creditcard.reconciliation.SsccrProcessorBanck;
import ec.com.sidesoft.creditcard.reconciliation.SsccrTypesOfCredit;

public class SSCCR_AddPaymentActionHandler extends AddPaymentActionHandler {
  final private static Logger log = LoggerFactory.getLogger(SSCCR_AddPaymentActionHandler.class);

  @Override
  protected JSONObject doExecute(Map<String, Object> parameters, String content) {
    // super.execute(info);
    JSONObject jsonResponse = new JSONObject();
    
    boolean openedFromMenu = false;
    String comingFrom = null;
    try {
      OBContext.setAdminMode(true);
      VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
      // Get Params
      JSONObject jsonRequest = new JSONObject(content);
      JSONObject jsonparams = jsonRequest.getJSONObject("_params");

      if (jsonRequest.has("inpwindowId") && jsonRequest.get("inpwindowId") != JSONObject.NULL) {
        openedFromMenu = false;
        if (APRMConstants.TRANSACTION_WINDOW_ID.equals(jsonRequest.getString("inpwindowId"))) {
          comingFrom = "TRANSACTION";
        }
      } else {
        openedFromMenu = "null".equals(parameters.get("windowId").toString()) ? true : false;
      }
      String strOrgId = null;
      if (jsonparams.has("ad_org_id") && jsonparams.get("ad_org_id") != JSONObject.NULL) {
        strOrgId = jsonparams.getString("ad_org_id");
      } else if (jsonRequest.has("inpadOrgId")
          && jsonRequest.get("inpadOrgId") != JSONObject.NULL) {
        strOrgId = jsonRequest.getString("inpadOrgId");
      }
      Organization org = OBDal.getInstance().get(Organization.class, strOrgId);
      boolean isReceipt = jsonparams.getBoolean("issotrx");

      // Action to do
      final String strActionId = jsonparams.getString("document_action");
      final org.openbravo.model.ad.domain.List actionList = OBDal.getInstance()
          .get(org.openbravo.model.ad.domain.List.class, strActionId);
      final String strAction = actionList.getSearchKey();

      final String strCurrencyId = jsonparams.getString("c_currency_id");
      Currency currency = OBDal.getInstance().get(Currency.class, strCurrencyId);
      final String strBPartnerID = jsonparams.getString("received_from");
      BusinessPartner businessPartner = OBDal.getInstance().get(BusinessPartner.class,
          strBPartnerID);
      String strActualPayment = jsonparams.getString("actual_payment");

      // Format Date
      String strPaymentDate = jsonparams.getString("payment_date");
      Date paymentDate = JsonUtils.createDateFormat().parse(strPaymentDate);

      // OverPayment action
      String strDifferenceAction = "";
      BigDecimal differenceAmount = BigDecimal.ZERO;

      if (jsonparams.get("difference") != JSONObject.NULL) {
        differenceAmount = new BigDecimal(jsonparams.getString("difference"));
        strDifferenceAction = jsonparams.getString("overpayment_action");
        if ("RE".equals(strDifferenceAction)) {
          strDifferenceAction = "refund";
        } else {
          strDifferenceAction = "credit";
        }
      }

      BigDecimal exchangeRate = BigDecimal.ZERO;
      BigDecimal convertedAmount = BigDecimal.ZERO;
      if (jsonparams.get("conversion_rate") != JSONObject.NULL) {
        exchangeRate = new BigDecimal(jsonparams.getString("conversion_rate"));
      }
      if (jsonparams.get("converted_amount") != JSONObject.NULL) {
        convertedAmount = new BigDecimal(jsonparams.getString("converted_amount"));
      }

      List<String> pdToRemove = new ArrayList<String>();
      FIN_Payment payment = null;
      if (jsonparams.get("reference_no") == JSONObject.NULL) {
        String strfin_paymentmethod_id = jsonparams.getString("fin_paymentmethod_id");

        FIN_PaymentMethod paymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
            strfin_paymentmethod_id);
        if (paymentMethod != null && paymentMethod.getSccaTypePayment() != null
            && paymentMethod.getSccaTypePayment().equals("CA")) {
          OBDal.getInstance().rollbackAndClose();
          JSONObject errorMessage = new JSONObject();
          errorMessage.put("severity", "error");
          errorMessage.put("text", "El número de referencia no puede estar vacío.");
          jsonResponse.put("retryExecution", openedFromMenu);
          jsonResponse.put("message", errorMessage);
          return jsonResponse;
        }
      }

      if (jsonparams.get("fin_payment_id") != JSONObject.NULL) {
        // Payment is already created. Load it.
        final String strFinPaymentID = jsonparams.getString("fin_payment_id");
        payment = OBDal.getInstance().get(FIN_Payment.class, strFinPaymentID);
        String strReferenceNo = "";
        if (jsonparams.get("reference_no") != JSONObject.NULL) {
          strReferenceNo = jsonparams.getString("reference_no");
        }
        payment.setReferenceNo(strReferenceNo);
        // Load existing lines to be deleted.
        pdToRemove = OBDao.getIDListFromOBObject(payment.getFINPaymentDetailList());
      } else {
        try {
          payment = createNewPayment(jsonparams, isReceipt, org, businessPartner, paymentDate,
              currency, exchangeRate, convertedAmount, strActualPayment);
        } catch (OBException e) {
          JSONObject errorMessage = new JSONObject();
          errorMessage.put("severity", "error");
          errorMessage.put("text", e.getMessage());
          jsonResponse.put("retryExecution", openedFromMenu);
          jsonResponse.put("message", errorMessage);
          return jsonResponse;
        }
      }
      payment.setAmount(new BigDecimal(strActualPayment));
      FIN_AddPayment.setFinancialTransactionAmountAndRate(vars, payment, exchangeRate,
          convertedAmount);
      OBDal.getInstance().save(payment);

      addCredit(payment, jsonparams, differenceAmount, strDifferenceAction);
      addSelectedPSDs(payment, jsonparams, pdToRemove);
      addGLItems(payment, jsonparams);

      removeNotSelectedPaymentDetails(payment, pdToRemove);

      if (strAction.equals("PRP") || strAction.equals("PPP") || strAction.equals("PRD")
          || strAction.equals("PPW")) {

        OBError message = processPayment(payment, strAction, strDifferenceAction, differenceAmount,
            exchangeRate, jsonparams, comingFrom);

        // SE VALIDAN LOS PARAMETROS CUANDO ES METODO DE PAGO TARJETA
        if (jsonparams.has("ssccr_types_of_credit_id")
            && jsonparams.has("Ssccr_Processor_Banck_ID")) {

          String strSsccrTypesOfCreditId = jsonparams.getString("ssccr_types_of_credit_id");
          String strSsccrProcessorBanckId = jsonparams.getString("Ssccr_Processor_Banck_ID");

          if (!strSsccrTypesOfCreditId.equals("null") && !strSsccrProcessorBanckId.equals("null")) {

            if (strAction.equals("PRD")) {

              String strFinancialAccountId = jsonparams.getString("fin_financial_account_id");
              FIN_FinancialAccount finAccount = OBDal.getInstance().get(FIN_FinancialAccount.class,
                  strFinancialAccountId);

              final OBCriteria<FIN_FinaccTransaction> obc = OBDal.getInstance()
                  .createCriteria(FIN_FinaccTransaction.class);
              obc.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_FINPAYMENT, payment));
              obc.add(Restrictions.eq(FIN_FinaccTransaction.PROPERTY_ACCOUNT, finAccount));

              String strbanktransferId = jsonparams.getString("ssfi_banktransfer_id");
              ssfiBanktransfer objSsfiBanktransfer = OBDal.getInstance().get(ssfiBanktransfer.class,
                  strbanktransferId);

              SsccrTypesOfCredit objSsccrTypesOfCredit = OBDal.getInstance()
                  .get(SsccrTypesOfCredit.class, strSsccrTypesOfCreditId);

              SsccrProcessorBanck objSsccrProcessorBanck = OBDal.getInstance()
                  .get(SsccrProcessorBanck.class, strSsccrProcessorBanckId);

              String strC_Order_ID = jsonparams.getString("c_order_id");

              String strSsccrCardsTypesId = jsonparams.getString("Ssccr_Cards_Types_ID");
              SsccrCardsTypes objSsccrCardsTypes = OBDal.getInstance().get(SsccrCardsTypes.class,
                  strSsccrCardsTypesId);

              String strInvoiceNo = "";
              String strSalesOrderNo = "";
              Order objOrder = null;
              Invoice objInvoice = null;
              JSONObject orderInvoiceGrid = jsonparams.getJSONObject("order_invoice");
              JSONArray selectedPSDs = orderInvoiceGrid.getJSONArray("_selection");
              final OBCriteria<Invoice> objInvoiceLst = OBDal.getInstance()
                  .createCriteria(Invoice.class);

              if (strC_Order_ID == null || strC_Order_ID.equals("")
                  || strC_Order_ID.equals("null")) {
                for (int i = 0; i < selectedPSDs.length(); i++) {

                  JSONObject psdRow = selectedPSDs.getJSONObject(i);
                  strInvoiceNo = psdRow.getString("invoiceNo");
                  strSalesOrderNo = psdRow.getString("salesOrderNo");

                  if (strSalesOrderNo == null || strSalesOrderNo.equals("")) {
                    objInvoiceLst.add(Restrictions.eq(Invoice.PROPERTY_DOCUMENTNO, strInvoiceNo));
                  } else if (strInvoiceNo != null || !strInvoiceNo.equals("")) {
                    final OBCriteria<Order> objOrderLst = OBDal.getInstance()
                        .createCriteria(Order.class);
                    objOrderLst.add(Restrictions.eq(Order.PROPERTY_DOCUMENTNO, strSalesOrderNo));
                    objOrder = objOrderLst.list().get(0);
                    objInvoiceLst.add(Restrictions.eq(Invoice.PROPERTY_SALESORDER, objOrder));

                  }
                }
              } else {
                objOrder = OBDal.getInstance().get(Order.class, strC_Order_ID);
                objInvoiceLst.add(Restrictions.eq(Invoice.PROPERTY_SALESORDER, objOrder));
              }

              if (objInvoiceLst != null && !objInvoiceLst.equals("")) {
                if (selectedPSDs.length() > 0) {
                  for (Invoice invoiceobj : objInvoiceLst.list()) {
                    objInvoice = invoiceobj;
                    objOrder = invoiceobj.getSalesOrder();
                  }
                }
              }

              Calendar c = Calendar.getInstance();
              c.setTime(paymentDate);

              // Busqueda de Configuración conciliación de tarjetas
              if (objSsccrCardsTypes != null) {
                String value = new SimpleDateFormat("yyyy-MM-dd").format(paymentDate);
                ConnectionProvider conn = null;
                try {
                  conn = new DalConnectionProvider(true);
                  String strPaymentTermId = SSCCRPaymentTermData.paymentterm(conn,
                      objSsccrCardsTypes.getId(), objSsccrTypesOfCredit.getId(), value);
                  if (strPaymentTermId != null && !strPaymentTermId.equals("")) {
                    PaymentTerm objPaymentTerm = OBDal.getInstance().get(PaymentTerm.class,
                        strPaymentTermId);
                    c.add(Calendar.DAY_OF_YEAR,
                        objPaymentTerm.getOverduePaymentDaysRule().intValue());
                  } else {
                    OBDal.getInstance().rollbackAndClose();
                    JSONObject errorMessage = new JSONObject();
                    errorMessage.put("severity", "error");
                    errorMessage.put("text",
                        "No existe configuración de condición de pago para los parámetros dados.");
                    jsonResponse.put("retryExecution", openedFromMenu);
                    jsonResponse.put("message", errorMessage);
                    return jsonResponse;
                  }
                } catch (Exception ex) {
                  ex.printStackTrace();
                } finally {
                  conn.destroy();
                }
              }
              String lot = jsonparams.getString("Lote");

              for (FIN_FinaccTransaction financialAccount : obc.list()) {
                financialAccount.setSsccrSsfiBanktransfer(objSsfiBanktransfer);
                financialAccount.setSsccrTypesOfCredit(objSsccrTypesOfCredit);
                financialAccount.setSsccrProcessorBanck(objSsccrProcessorBanck);
                financialAccount.setSsccrCardsTypes(objSsccrCardsTypes);
                financialAccount.setSsccrCInvoice(objInvoice);
                financialAccount.setSsccrCOrder(objOrder);
                financialAccount.setSsccrFinPayment(payment);
                financialAccount.setSsccrLot(lot);
                if (objSsccrProcessorBanck != null) {
                  financialAccount.setSsccrExpirationDate(c.getTime());
                }
                if (jsonparams.get("reference_no") != JSONObject.NULL) {
                  financialAccount.setSsccrRecapno(jsonparams.getString("reference_no"));
                }
                try {
                  OBDal.getInstance().save(financialAccount);
                  OBDal.getInstance().flush();
                } finally {
                }
              }
            }

          }

        }

        JSONObject errorMessage = new JSONObject();
        if (!"TRANSACTION".equals(comingFrom)) {
          errorMessage.put("severity", message.getType().toLowerCase());
          errorMessage.put("title", message.getTitle());
          errorMessage.put("text", message.getMessage());
          jsonResponse.put("retryExecution", openedFromMenu);
          jsonResponse.put("message", errorMessage);
          jsonResponse.put("refreshParent", true);
        } else {
          jsonResponse.put("refreshParent", false);
        }
        JSONObject setSelectorValueFromRecord = new JSONObject();
        JSONObject record = new JSONObject();
        JSONObject responseActions = new JSONObject();
        record.put("value", payment.getId());
        record.put("map", payment.getIdentifier());
        setSelectorValueFromRecord.put("record", record);
        responseActions.put("setSelectorValueFromRecord", setSelectorValueFromRecord);
        if (openedFromMenu) {
          responseActions.put("reloadParameters", setSelectorValueFromRecord);
        }
        jsonResponse.put("responseActions", responseActions);

      }

    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      log.error("Exception handling the new payment", e);

      try {
        jsonResponse = new JSONObject();
        Throwable ex = DbUtility.getUnderlyingSQLException(e);
        String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("severity", "error");
        errorMessage.put("text", message);
        jsonResponse.put("retryExecution", openedFromMenu);
        jsonResponse.put("message", errorMessage);

      } catch (Exception ignore) {
      }
    } finally {
      OBContext.restorePreviousMode();
      // super.execute(info);
    }
    return jsonResponse;
  }

  private FIN_Payment createNewPayment(JSONObject jsonparams, boolean isReceipt, Organization org,
      BusinessPartner bPartner, Date paymentDate, Currency currency, BigDecimal conversionRate,
      BigDecimal convertedAmt, String strActualPayment)
      throws OBException, JSONException, SQLException {

    String strPaymentDocumentNo = jsonparams.getString("payment_documentno");
    String strPaymentDocumentType = jsonparams.getString("payment_document_type");

    String strReferenceNo = "";
    if (jsonparams.get("reference_no") != JSONObject.NULL) {
      strReferenceNo = jsonparams.getString("reference_no");
    }
    String strFinancialAccountId = jsonparams.getString("fin_financial_account_id");
    FIN_FinancialAccount finAccount = OBDal.getInstance().get(FIN_FinancialAccount.class,
        strFinancialAccountId);
    String strPaymentMethodId = jsonparams.getString("fin_paymentmethod_id");
    FIN_PaymentMethod paymentMethod = OBDal.getInstance().get(FIN_PaymentMethod.class,
        strPaymentMethodId);

    boolean paymentDocumentEnabled = getDocumentConfirmation(finAccount, paymentMethod, isReceipt,
        strActualPayment, true);
    String strAction = (isReceipt ? "PRP" : "PPP");
    boolean documentEnabled = true;
    if ((strAction.equals("PRD") || strAction.equals("PPW")
        || FIN_Utility.isAutomaticDepositWithdrawn(finAccount, paymentMethod, isReceipt))
        && new BigDecimal(strActualPayment).signum() != 0) {
      documentEnabled = paymentDocumentEnabled
          || getDocumentConfirmation(finAccount, paymentMethod, isReceipt, strActualPayment, false);
    } else {
      documentEnabled = paymentDocumentEnabled;
    }

    DocumentType documentType = FIN_Utility.getDocumentType(org, isReceipt ? "ARR" : "APP");
    if (strPaymentDocumentType != null && !strPaymentDocumentType.trim().equals("") && !strPaymentDocumentType.trim().equals("null") ) {
      documentType = OBDal.getInstance().get(DocumentType.class, strPaymentDocumentType.trim());
    }
    if (documentType == null) {
	String messag = "Tipo de Documento no encontrado para esta operacion.";
	throw new OBException(messag, false);
    }
    String strDocBaseType = documentType.getDocumentCategory();

    OrganizationStructureProvider osp = OBContext.getOBContext()
        .getOrganizationStructureProvider(OBContext.getOBContext().getCurrentClient().getId());
    boolean orgLegalWithAccounting = osp.getLegalEntityOrBusinessUnit(org).getOrganizationType()
        .isLegalEntityWithAccounting();
    if (documentEnabled
        && !FIN_Utility.isPeriodOpen(OBContext.getOBContext().getCurrentClient().getId(),
            strDocBaseType, org.getId(), OBDateUtils.formatDate(paymentDate))
        && orgLegalWithAccounting) {
      String messag = OBMessageUtils.messageBD("PeriodNotAvailable");
      log.debug(messag);
      throw new OBException(messag, false);
    }

    String strPaymentAmount = "0";
    if (strPaymentDocumentNo.startsWith("<")) {
      // get DocumentNo
      strPaymentDocumentNo = FIN_Utility.getDocumentNo(documentType, "FIN_Payment");
    }

    try {
      FIN_Payment payment = (new AdvPaymentMngtDao()).getNewPayment(isReceipt, org, documentType,
          strPaymentDocumentNo, bPartner, paymentMethod, finAccount, strPaymentAmount, paymentDate,
          strReferenceNo, currency, conversionRate, convertedAmt);
      OBDal.getInstance().getConnection(true).commit();
      return payment;
    } finally {
    }
  }

  private void addSelectedPSDs(FIN_Payment payment, JSONObject jsonparams, List<String> pdToRemove)
      throws JSONException {
    JSONObject orderInvoiceGrid = jsonparams.getJSONObject("order_invoice");
    JSONArray selectedPSDs = orderInvoiceGrid.getJSONArray("_selection");
    for (int i = 0; i < selectedPSDs.length(); i++) {
      JSONObject psdRow = selectedPSDs.getJSONObject(i);
      String strPSDIds = psdRow.getString("id");
      String strPaidAmount = psdRow.getString("amount");
      BigDecimal paidAmount = new BigDecimal(strPaidAmount);

      boolean isWriteOff = psdRow.getBoolean("writeoff");
      // psdIds can be grouped
      List<String> psdIds = Arrays.asList(strPSDIds.replaceAll(" ", "").split(","));
      List<FIN_PaymentScheduleDetail> psds = getOrderedPaymentScheduleDetails(psdIds);
      BigDecimal outstandingAmount = BigDecimal.ZERO;
      BigDecimal remainingAmount = paidAmount;
      for (FIN_PaymentScheduleDetail psd : psds) {
        BigDecimal assignAmount = BigDecimal.ZERO;

        if (psd.getPaymentDetails() != null) {
          // This schedule detail comes from an edited payment so outstanding amount needs to be
          // properly calculated
          List<FIN_PaymentScheduleDetail> outStandingPSDs = FIN_AddPayment.getOutstandingPSDs(psd);
          if (outStandingPSDs.size() > 0) {
            outstandingAmount = psd.getAmount().add(outStandingPSDs.get(0).getAmount());
          } else {
            outstandingAmount = psd.getAmount();
          }
          pdToRemove.remove(psd.getPaymentDetails().getId());
        } else {
          outstandingAmount = psd.getAmount();
        }
        // Manage negative amounts
        if ((remainingAmount.signum() > 0 && remainingAmount.compareTo(outstandingAmount) >= 0)
            || (remainingAmount.signum() < 0
                && remainingAmount.compareTo(outstandingAmount) <= 0)) {
          assignAmount = outstandingAmount;
          remainingAmount = remainingAmount.subtract(outstandingAmount);
        } else {
          assignAmount = remainingAmount;
          remainingAmount = BigDecimal.ZERO;
        }
        FIN_AddPayment.updatePaymentDetail(psd, payment, assignAmount, isWriteOff);
      }
    }
  }

  private void addCredit(FIN_Payment payment, JSONObject jsonparams, BigDecimal differenceAmount,
      String strDifferenceAction) throws JSONException {
    // Credit to Use Grid
    JSONObject creditToUseGrid = jsonparams.getJSONObject("credit_to_use");
    JSONArray selectedCreditLines = creditToUseGrid.getJSONArray("_selection");
    BigDecimal remainingRefundAmt = differenceAmount;
    String strSelectedCreditLinesIds = null;
    if (selectedCreditLines.length() > 0) {
      strSelectedCreditLinesIds = getSelectedCreditLinesIds(selectedCreditLines);
      List<FIN_Payment> selectedCreditPayment = FIN_Utility.getOBObjectList(FIN_Payment.class,
          strSelectedCreditLinesIds);
      HashMap<String, BigDecimal> selectedCreditPaymentAmounts = getSelectedCreditLinesAndAmount(
          selectedCreditLines, selectedCreditPayment);

      for (final FIN_Payment creditPayment : selectedCreditPayment) {
        BusinessPartner businessPartner = creditPayment.getBusinessPartner();
        if (businessPartner == null) {
          throw new OBException(OBMessageUtils.messageBD("APRM_CreditWithoutBPartner"));
        }
        String currency = null;
        if (businessPartner.getCurrency() == null) {
          currency = creditPayment.getCurrency().getId();
          businessPartner.setCurrency(creditPayment.getCurrency());
        } else {
          currency = businessPartner.getCurrency().getId();
        }
        if (!creditPayment.getCurrency().getId().equals(currency)) {
          throw new OBException(String.format(OBMessageUtils.messageBD("APRM_CreditCurrency"),
              businessPartner.getCurrency().getISOCode()));
        }
        BigDecimal usedCreditAmt = selectedCreditPaymentAmounts.get(creditPayment.getId());

        // Reset usedCredit by traversing through each credit payment
        if (remainingRefundAmt.compareTo(usedCreditAmt) > 0) {
          remainingRefundAmt = remainingRefundAmt.subtract(usedCreditAmt);
          usedCreditAmt = BigDecimal.ZERO;
        } else {
          usedCreditAmt = usedCreditAmt.subtract(remainingRefundAmt);
          remainingRefundAmt = BigDecimal.ZERO;
        }

        // Set Used Credit = Amount + Previous used credit introduced by the user
        creditPayment.setUsedCredit(usedCreditAmt.add(creditPayment.getUsedCredit()));

        if (usedCreditAmt.compareTo(BigDecimal.ZERO) > 0) {
          // Set Credit description only when it is actually used
          final StringBuffer description = new StringBuffer();
          if (creditPayment.getDescription() != null
              && !creditPayment.getDescription().equals("")) {
            description.append(creditPayment.getDescription()).append("\n");
          }
          description.append(String.format(OBMessageUtils.messageBD("APRM_CreditUsedPayment"),
              payment.getDocumentNo()));
          String truncateDescription = (description.length() > 255)
              ? description.substring(0, 251).concat("...").toString()
              : description.toString();
          creditPayment.setDescription(truncateDescription);
          FIN_PaymentProcess.linkCreditPayment(payment, usedCreditAmt, creditPayment);
        }
        OBDal.getInstance().save(creditPayment);
      }
    }
  }

  private void addGLItems(FIN_Payment payment, JSONObject jsonparams)
      throws JSONException, ServletException {
    // Add GL Item lines
    JSONObject gLItemsGrid = jsonparams.getJSONObject("glitem");
    JSONArray addedGLITemsArray = gLItemsGrid.getJSONArray("_allRows");
    boolean isReceipt = payment.isReceipt();
    for (int i = 0; i < addedGLITemsArray.length(); i++) {
      JSONObject glItem = addedGLITemsArray.getJSONObject(i);
      BigDecimal glItemOutAmt = BigDecimal.ZERO;
      BigDecimal glItemInAmt = BigDecimal.ZERO;

      if (glItem.has("paidOut") && glItem.get("paidOut") != JSONObject.NULL) {
        glItemOutAmt = new BigDecimal(glItem.getString("paidOut"));
      }
      if (glItem.has("receivedIn") && glItem.get("receivedIn") != JSONObject.NULL) {
        glItemInAmt = new BigDecimal(glItem.getString("receivedIn"));
      }

      BigDecimal glItemAmt = BigDecimal.ZERO;
      if (isReceipt) {
        glItemAmt = glItemInAmt.subtract(glItemOutAmt);
      } else {
        glItemAmt = glItemOutAmt.subtract(glItemInAmt);
      }
      String strGLItemId = null;
      if (glItem.has("gLItem") && glItem.get("gLItem") != JSONObject.NULL) {
        strGLItemId = glItem.getString("gLItem");
        checkID(strGLItemId);
      }

      // Accounting Dimensions
      BusinessPartner businessPartnerGLItem = null;
      if (glItem.has("businessPartner") && glItem.get("businessPartner") != JSONObject.NULL) {
        final String strElement_BP = glItem.getString("businessPartner");
        checkID(strElement_BP);
        businessPartnerGLItem = OBDal.getInstance().get(BusinessPartner.class, strElement_BP);
      }
      Product product = null;
      if (glItem.has("product") && glItem.get("product") != JSONObject.NULL) {
        final String strElement_PR = glItem.getString("product");
        checkID(strElement_PR);
        product = OBDal.getInstance().get(Product.class, strElement_PR);
      }
      Project project = null;
      if (glItem.has("project") && glItem.get("project") != JSONObject.NULL) {
        final String strElement_PJ = glItem.getString("project");
        checkID(strElement_PJ);
        project = OBDal.getInstance().get(Project.class, strElement_PJ);
      }
      ABCActivity activity = null;
      if (glItem.has("cActivityDim") && glItem.get("cActivityDim") != JSONObject.NULL) {
        final String strElement_AY = glItem.getString("cActivityDim");
        checkID(strElement_AY);
        activity = OBDal.getInstance().get(ABCActivity.class, strElement_AY);
      }
      Costcenter costCenter = null;
      if (glItem.has("costCenter") && glItem.get("costCenter") != JSONObject.NULL) {
        final String strElement_CC = glItem.getString("costCenter");
        checkID(strElement_CC);
        costCenter = OBDal.getInstance().get(Costcenter.class, strElement_CC);
      }
      Campaign campaign = null;
      if (glItem.has("cCampaignDim") && glItem.get("cCampaignDim") != JSONObject.NULL) {
        final String strElement_MC = glItem.getString("cCampaignDim");
        checkID(strElement_MC);
        campaign = OBDal.getInstance().get(Campaign.class, strElement_MC);
      }
      UserDimension1 user1 = null;
      if (glItem.has("stDimension") && glItem.get("stDimension") != JSONObject.NULL) {
        final String strElement_U1 = glItem.getString("stDimension");
        checkID(strElement_U1);
        user1 = OBDal.getInstance().get(UserDimension1.class, strElement_U1);
      }
      UserDimension2 user2 = null;
      if (glItem.has("ndDimension") && glItem.get("ndDimension") != JSONObject.NULL) {
        final String strElement_U2 = glItem.getString("ndDimension");
        checkID(strElement_U2);
        user2 = OBDal.getInstance().get(UserDimension2.class, strElement_U2);
      }
      FIN_AddPayment.saveGLItem(payment, glItemAmt,
          OBDal.getInstance().get(GLItem.class, strGLItemId), businessPartnerGLItem, product,
          project, campaign, activity, null, costCenter, user1, user2);
    }
  }

  private void removeNotSelectedPaymentDetails(FIN_Payment payment, List<String> pdToRemove) {
    for (String pdId : pdToRemove) {
      FIN_PaymentDetail pd = OBDal.getInstance().get(FIN_PaymentDetail.class, pdId);

      List<String> pdsIds = OBDao.getIDListFromOBObject(pd.getFINPaymentScheduleDetailList());
      for (String strPDSId : pdsIds) {
        FIN_PaymentScheduleDetail psd = OBDal.getInstance().get(FIN_PaymentScheduleDetail.class,
            strPDSId);

        if (pd.getGLItem() == null) {
          List<FIN_PaymentScheduleDetail> outStandingPSDs = FIN_AddPayment.getOutstandingPSDs(psd);
          if (outStandingPSDs.size() == 0) {
            FIN_PaymentScheduleDetail newOutstanding = (FIN_PaymentScheduleDetail) DalUtil.copy(psd,
                false);
            newOutstanding.setPaymentDetails(null);
            newOutstanding.setWriteoffAmount(BigDecimal.ZERO);
            newOutstanding.setAmount(psd.getAmount().add(psd.getWriteoffAmount()));
            OBDal.getInstance().save(newOutstanding);
          } else {
            FIN_PaymentScheduleDetail outStandingPSD = outStandingPSDs.get(0);
            // First make sure outstanding amount is not equal zero
            if (outStandingPSD.getAmount().add(psd.getAmount()).add(psd.getWriteoffAmount())
                .signum() == 0) {
              OBDal.getInstance().remove(outStandingPSD);
            } else {
              // update existing PD with difference
              outStandingPSD.setAmount(
                  outStandingPSD.getAmount().add(psd.getAmount()).add(psd.getWriteoffAmount()));
              outStandingPSD.setDoubtfulDebtAmount(
                  outStandingPSD.getDoubtfulDebtAmount().add(psd.getDoubtfulDebtAmount()));
              OBDal.getInstance().save(outStandingPSD);
            }
          }
        }

        FIN_PaymentProcess.removePaymentProposalLines(psd);

        pd.getFINPaymentScheduleDetailList().remove(psd);
        OBDal.getInstance().save(pd);
        OBDal.getInstance().remove(psd);
      }
      payment.getFINPaymentDetailList().remove(pd);
      OBDal.getInstance().save(payment);
      OBDal.getInstance().remove(pd);
      OBDal.getInstance().flush();
      OBDal.getInstance().refresh(payment);
    }
  }

  private OBError processPayment(FIN_Payment payment, String strAction, String strDifferenceAction,
      BigDecimal refundAmount, BigDecimal exchangeRate, JSONObject jsonparams, String comingFrom)
      throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(true);
    VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();

    AdvPaymentMngtDao dao = new AdvPaymentMngtDao();
    BigDecimal assignedAmount = BigDecimal.ZERO;
    for (FIN_PaymentDetail paymentDetail : payment.getFINPaymentDetailList()) {
      assignedAmount = assignedAmount.add(paymentDetail.getAmount());
    }

    if (assignedAmount.compareTo(payment.getAmount()) == -1) {
      FIN_PaymentScheduleDetail refundScheduleDetail = dao.getNewPaymentScheduleDetail(
          payment.getOrganization(), payment.getAmount().subtract(assignedAmount));
      dao.getNewPaymentDetail(payment, refundScheduleDetail,
          payment.getAmount().subtract(assignedAmount), BigDecimal.ZERO, false, null);
    }

    OBError message = FIN_AddPayment.processPayment(vars, conn,
        (strAction.equals("PRP") || strAction.equals("PPP")) ? "P" : "D", payment, comingFrom);
    String strNewPaymentMessage = OBMessageUtils
        .parseTranslation("@PaymentCreated@" + " " + payment.getDocumentNo()) + ".";
    if (!"Error".equalsIgnoreCase(message.getType())) {
      message.setMessage(strNewPaymentMessage + " " + message.getMessage());
      message.setType(message.getType().toLowerCase());
    }
    if (!strDifferenceAction.equals("refund")) {
      return message;
    }
    boolean newPayment = !payment.getFINPaymentDetailList().isEmpty();
    JSONObject creditToUseGrid = jsonparams.getJSONObject("credit_to_use");
    JSONArray selectedCreditLines = creditToUseGrid.getJSONArray("_selection");
    String strSelectedCreditLinesIds = null;
    if (selectedCreditLines.length() > 0) {
      strSelectedCreditLinesIds = getSelectedCreditLinesIds(selectedCreditLines);
    }
    FIN_Payment refundPayment = FIN_AddPayment.createRefundPayment(conn, vars, payment,
        refundAmount.negate(), exchangeRate);

    // If refunded credit is generated in the same payment, add payment id to
    // strSelectedCreditLinesIds
    BigDecimal actualPayment = new BigDecimal(jsonparams.getString("actual_payment"));
    if (actualPayment.compareTo(BigDecimal.ZERO) != 0) {
      if (!StringUtils.isEmpty(strSelectedCreditLinesIds)) {
        strSelectedCreditLinesIds = "(" + payment.getId() + ", "
            + strSelectedCreditLinesIds.substring(1);
      } else {
        strSelectedCreditLinesIds = "(" + payment.getId() + ")";
      }
    }

    OBError auxMessage = FIN_AddPayment.processPayment(vars, conn,
        (strAction.equals("PRP") || strAction.equals("PPP")) ? "P" : "D", refundPayment, comingFrom,
        strSelectedCreditLinesIds);
    if (newPayment && !"Error".equalsIgnoreCase(auxMessage.getType())) {
      final String strNewRefundPaymentMessage = OBMessageUtils
          .parseTranslation("@APRM_RefundPayment@" + ": " + refundPayment.getDocumentNo()) + ".";
      message.setMessage(strNewRefundPaymentMessage + " " + message.getMessage());
      if (payment.getGeneratedCredit().compareTo(BigDecimal.ZERO) != 0) {
        payment.setDescription(payment.getDescription() + strNewRefundPaymentMessage + "\n");
        OBDal.getInstance().save(payment);
        OBDal.getInstance().flush();
      }
    } else {
      message = auxMessage;
    }

    return message;
  }

  private List<FIN_PaymentScheduleDetail> getOrderedPaymentScheduleDetails(List<String> psdSet) {
    StringBuffer where = new StringBuffer();
    where.append(" as psd");
    where.append(" where psd." + FIN_PaymentScheduleDetail.PROPERTY_ID + " in (:psdSet)");
    where.append(" order by psd." + FIN_PaymentScheduleDetail.PROPERTY_PAYMENTDETAILS);
    where.append(", abs(psd." + FIN_PaymentScheduleDetail.PROPERTY_AMOUNT + ")");
    OBQuery<FIN_PaymentScheduleDetail> orderedPSDs = OBDal.getInstance()
        .createQuery(FIN_PaymentScheduleDetail.class, where.toString());
    orderedPSDs.setNamedParameter("psdSet", psdSet);
    return orderedPSDs.list();
  }

  private void checkID(final String id) throws ServletException {
    if (!IsIDFilter.instance.accept(id)) {
      log.error("Input: " + id + " not accepted by filter: IsIDFilter");
      throw new ServletException("Input: " + id + " is not an accepted input");
    }
  }

  /**
   * @param allselection
   *          Selected Rows in Credit to use grid
   * @return a String with the concatenation of the selected rows ids
   */
  private String getSelectedCreditLinesIds(JSONArray allselection) throws JSONException {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    for (int i = 0; i < allselection.length(); i++) {
      JSONObject selectedRow = allselection.getJSONObject(i);
      sb.append(selectedRow.getString("id") + ",");
    }
    sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, ")");
    return sb.toString();
  }

  private HashMap<String, BigDecimal> getSelectedCreditLinesAndAmount(JSONArray allselection,
      List<FIN_Payment> _selectedCreditPayments) throws JSONException {
    HashMap<String, BigDecimal> selectedCreditLinesAmounts = new HashMap<String, BigDecimal>();

    for (FIN_Payment creditPayment : _selectedCreditPayments) {
      for (int i = 0; i < allselection.length(); i++) {
        JSONObject selectedRow = allselection.getJSONObject(i);
        if (selectedRow.getString("id").equals(creditPayment.getId())) {
          selectedCreditLinesAmounts.put(creditPayment.getId(),
              new BigDecimal(selectedRow.getString("paymentAmount")));
        }
      }
    }
    return selectedCreditLinesAmounts;
  }

  private boolean getDocumentConfirmation(FIN_FinancialAccount finAccount,
      FIN_PaymentMethod finPaymentMethod, boolean isReceipt, String strPaymentAmount,
      boolean isPayment) {
    // Checks if this step is configured to generate accounting for the selected financial account
    boolean confirmation = false;
    try {
      OBCriteria<FinAccPaymentMethod> obCriteria = OBDal.getInstance()
          .createCriteria(FinAccPaymentMethod.class);
      obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_ACCOUNT, finAccount));
      obCriteria.add(Restrictions.eq(FinAccPaymentMethod.PROPERTY_PAYMENTMETHOD, finPaymentMethod));
      obCriteria.setFilterOnReadableClients(false);
      obCriteria.setFilterOnReadableOrganization(false);
      obCriteria.setMaxResults(1);
      FinAccPaymentMethod finAccPayMethod = (FinAccPaymentMethod) obCriteria.uniqueResult();
      String uponUse = "";
      if (isPayment) {
        if (isReceipt) {
          uponUse = finAccPayMethod.getUponReceiptUse();
        } else {
          uponUse = finAccPayMethod.getUponPaymentUse();
        }
      } else {
        if (isReceipt) {
          uponUse = finAccPayMethod.getUponDepositUse();
        } else {
          uponUse = finAccPayMethod.getUponWithdrawalUse();
        }
      }
      for (FIN_FinancialAccountAccounting account : finAccount.getFINFinancialAccountAcctList()) {
        if (confirmation) {
          return confirmation;
        }
        if (isReceipt) {
          if ("INT".equals(uponUse) && account.getInTransitPaymentAccountIN() != null) {
            confirmation = true;
          } else if ("DEP".equals(uponUse) && account.getDepositAccount() != null) {
            confirmation = true;
          } else if ("CLE".equals(uponUse) && account.getClearedPaymentAccount() != null) {
            confirmation = true;
          }
        } else {
          if ("INT".equals(uponUse) && account.getFINOutIntransitAcct() != null) {
            confirmation = true;
          } else if ("WIT".equals(uponUse) && account.getWithdrawalAccount() != null) {
            confirmation = true;
          } else if ("CLE".equals(uponUse) && account.getClearedPaymentAccountOUT() != null) {
            confirmation = true;
          }
        }
        // For payments with Amount ZERO always create an entry as no transaction will be created
        if (isPayment) {
          BigDecimal amount = new BigDecimal(strPaymentAmount);
          if (amount.signum() == 0) {
            confirmation = true;
          }
        }
      }
    } catch (Exception e) {
      return confirmation;
    } finally {
    }
    return confirmation;
  }
}
