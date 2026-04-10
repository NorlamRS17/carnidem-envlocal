/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2010-2013 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 *************************************************************************
 */

package com.atrums.indumot.postventa.erpCommon.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.erpCommon.utility.OBObjectFieldProvider;
import org.openbravo.model.ad.ui.Tab;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;

public class OrdenesServicioDao {

  public static List<Tab> getWindowData(String className) {

    final List<Object> parameters = new ArrayList<Object>();
    final StringBuilder whereClause = new StringBuilder();
    whereClause.append(" as td");
    whereClause.append(" left outer join td.window as win");
    whereClause.append(" left outer join td.masterDetailForm as mdf");
    whereClause.append(" where UPPER(mdf.javaClassName) = UPPER(?)");
    parameters.add(className);

    final OBQuery<Tab> obQuery = OBDal.getInstance().createQuery(Tab.class, whereClause.toString());
    obQuery.setParameters(parameters);
    return obQuery.list();
  }

  public static OBObjectFieldProvider[] getOrdenesServicio(String stringBpartnerId) {
    final List<Object> parameters = new ArrayList<Object>();
    final StringBuilder whereClause = new StringBuilder();
    /*
     * select pv.atindpo_postventa_id, pv.documentno as docnoOrderSrv, pv.fechaventa as
     * fechaOrdersvr, pvl.line, p.name as producto, a.description, u.name as unidad, pvl.cantidad,
     * io.documentno as docnoGuia from atindpo_postventa pv left join atindpo_postventalinea pvl on
     * pv.atindpo_postventa_id = pvl.atindpo_postventa_id left join m_product p on pvl.m_product_id
     * = p.m_product_id left join c_uom u on p.c_uom_id = u.c_uom_id left join m_inoutline iol on
     * pvl.m_inoutline_id = iol.m_inoutline_id left join m_inout io on iol.m_inout_id =
     * io.m_inout_id left join m_attributesetinstance a on pvl.m_attributesetinstance_id =
     * a.m_attributesetinstance_id where pv.docstatus in ('TL','ET') and pvl.c_invoiceline_id is
     * null and pv.c_bpartner_id = ?
     */
    whereClause.append(" as osl");
    whereClause.append(" left join osl.atindpoPostventa as os");
    whereClause.append(" left join osl.product as pr");
    whereClause.append(" left join pr.uOM as u");
    whereClause.append(" left join osl.goodsShipmentLine as iol");
    whereClause.append(" left join iol.shipmentReceipt as io");
    whereClause.append(" left join osl.attributeSetValue as asv");
    whereClause.append(" where os.documentStatus in ('TL','ET')");
    whereClause.append(" and osl.invoiceLineEMAtindpoOslIDList is null");
    whereClause.append(" and os. = ?");
    parameters.add(stringBpartnerId);
    OBContext.setAdminMode();
    try {
      final OBQuery<FIN_FinaccTransaction> obQuery = OBDal.getInstance().createQuery(
          FIN_FinaccTransaction.class, whereClause.toString());
      obQuery.setParameters(parameters);
      OBObjectFieldProvider[] objectFieldProvider = null;
      if (obQuery != null && obQuery.list().size() > 0) {
        objectFieldProvider = OBObjectFieldProvider.createOBObjectFieldProvider(obQuery.list());
      }
      return objectFieldProvider;
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  public static FIN_FinaccTransaction createFinAccTransaction(FIN_Payment payment) {
    final FIN_FinaccTransaction newTransaction = OBProvider.getInstance().get(
        FIN_FinaccTransaction.class);
    OBContext.setAdminMode();
    try {
      newTransaction.setFinPayment(payment);
      newTransaction.setOrganization(payment.getOrganization());
      newTransaction.setAccount(payment.getAccount());
      newTransaction.setDateAcct(payment.getPaymentDate());
      newTransaction.setTransactionDate(payment.getPaymentDate());
      newTransaction.setActivity(payment.getActivity());
      newTransaction.setProject(payment.getProject());
      newTransaction.setCostCenter(payment.getCostCenter());
      newTransaction.setStDimension(payment.getStDimension());
      newTransaction.setNdDimension(payment.getNdDimension());
      newTransaction.setCurrency(payment.getAccount().getCurrency());
      newTransaction.setDescription(payment
          .getDescription()
          .replace("\n", ". ")
          .substring(0,
              payment.getDescription().length() > 254 ? 254 : payment.getDescription().length()));
      newTransaction.setClient(payment.getClient());
      newTransaction.setLineNo(getTransactionMaxLineNo(payment.getAccount()) + 10);

      BigDecimal depositAmt = FIN_Utility.getDepositAmount(payment.getDocumentType()
          .getDocumentCategory().equals("ARR"), payment.getFinancialTransactionAmount());
      BigDecimal paymentAmt = FIN_Utility.getPaymentAmount(payment.getDocumentType()
          .getDocumentCategory().equals("ARR"), payment.getFinancialTransactionAmount());

      newTransaction.setDepositAmount(depositAmt);
      newTransaction.setPaymentAmount(paymentAmt);
      newTransaction.setStatus(newTransaction.getDepositAmount().compareTo(
          newTransaction.getPaymentAmount()) > 0 ? "RPR" : "PPM");
      if (!newTransaction.getCurrency().equals(payment.getCurrency())) {
        newTransaction.setForeignCurrency(payment.getCurrency());
        newTransaction.setForeignConversionRate(payment.getFinancialTransactionConvertRate());
        newTransaction.setForeignAmount(payment.getAmount());
      }
      OBDal.getInstance().save(newTransaction);
      OBDal.getInstance().flush();
    } finally {
      OBContext.restorePreviousMode();
    }
    return newTransaction;
  }

  public static Long getTransactionMaxLineNo(FIN_FinancialAccount financialAccount) {
    Query query = OBDal
        .getInstance()
        .getSession()
        .createQuery(
            "select max(f.lineNo) as maxLineno from FIN_Finacc_Transaction as f where account.id=?");
    query.setString(0, (String) DalUtil.getId(financialAccount));
    for (Object obj : query.list()) {
      if (obj != null) {
        return (Long) obj;
      }
    }
    return 0l;
  }

  public static List<FIN_FinaccTransaction> getTransactionsToReconciled(
      FIN_FinancialAccount account, Date statementDate, boolean hideAfterDate) {

    OBContext.setAdminMode();
    try {

      final List<Object> parameters = new ArrayList<Object>();
      final StringBuilder whereClause = new StringBuilder();
      whereClause.append(" as ft");
      whereClause.append(" left outer join ft.reconciliation as rec");
      whereClause.append(" where ft.account.id = ?");
      whereClause.append(" and (rec is null or rec.processed = 'N')");
      whereClause.append(" and ft.processed = 'Y'");
      parameters.add(account.getId());
      if (hideAfterDate) {
        whereClause.append(" and ft.transactionDate < ?");
        parameters.add(statementDate);
      }
      whereClause.append(" order by ft.transactionDate, ft.lineNo");

      final OBQuery<FIN_FinaccTransaction> obQuery = OBDal.getInstance().createQuery(
          FIN_FinaccTransaction.class, whereClause.toString(), parameters);

      return obQuery.list();

    } catch (Exception e) {
      throw new OBException(e);

    } finally {
      OBContext.restorePreviousMode();
    }
  }
}
