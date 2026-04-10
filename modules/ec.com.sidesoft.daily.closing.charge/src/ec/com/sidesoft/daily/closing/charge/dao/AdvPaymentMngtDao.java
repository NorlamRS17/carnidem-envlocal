package ec.com.sidesoft.daily.closing.charge.dao;
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
 * All portions are Copyright (C) 2010-2018 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  Enterprise Intelligence Systems (http://www.eintel.com.au).
 *************************************************************************
 */

import java.util.List;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;

public class AdvPaymentMngtDao {

  public enum PaymentDirection {
    IN, OUT, EITHER
  }

  public final String PAYMENT_STATUS_AWAITING_EXECUTION = "RPAE";
  public final String PAYMENT_STATUS_CANCELED = "RPVOID";
  public final String PAYMENT_STATUS_PAYMENT_CLEARED = "RPPC";
  public final String PAYMENT_STATUS_DEPOSIT_NOT_CLEARED = "RDNC";
  public final String PAYMENT_STATUS_PAYMENT_MADE = "PPM";
  public final String PAYMENT_STATUS_AWAITING_PAYMENT = "RPAP";
  public final String PAYMENT_STATUS_WITHDRAWAL_NOT_CLEARED = "PWNC";
  public final String PAYMENT_STATUS_PAYMENT_RECEIVED = "RPR";

  public AdvPaymentMngtDao() {
  }

  public <T extends BaseOBObject> T getObject(Class<T> t, String strId) {
    return OBDal.getInstance().get(t, strId);
  }

  public List<FIN_PaymentScheduleDetail> getInvoicePendingScheduledPaymentDetails(Invoice invoice) {
    final StringBuilder whereClause = new StringBuilder();

    // FIXME: added to access the FIN_PaymentSchedule and FIN_PaymentScheduleDetail tables to be
    // removed when new security implementation is done
    OBContext.setAdminMode();
    try {

      whereClause.append(" as psd ");
      whereClause.append(" where psd.");
      whereClause.append(FIN_PaymentScheduleDetail.PROPERTY_PAYMENTDETAILS);
      whereClause.append(" is null");
      whereClause.append("   and psd.");
      whereClause.append(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAYMENTSCHEDULE);
      whereClause.append(".");
      whereClause.append(FIN_PaymentSchedule.PROPERTY_INVOICE);
      whereClause.append(".id = '");
      whereClause.append(invoice.getId());
      whereClause.append("'");
      whereClause.append(" order by psd.");
      whereClause.append(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAYMENTSCHEDULE);
      whereClause.append(".");
      whereClause.append(FIN_PaymentSchedule.PROPERTY_EXPECTEDDATE);
      whereClause.append(", psd.");
      whereClause.append(FIN_PaymentScheduleDetail.PROPERTY_AMOUNT);
      final OBQuery<FIN_PaymentScheduleDetail> obqPSD = OBDal.getInstance()
          .createQuery(FIN_PaymentScheduleDetail.class, whereClause.toString());

      return obqPSD.list();

    } finally {
      OBContext.restorePreviousMode();
    }
  }
}
