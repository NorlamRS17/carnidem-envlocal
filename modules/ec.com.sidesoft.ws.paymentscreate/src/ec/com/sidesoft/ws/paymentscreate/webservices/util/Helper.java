package ec.com.sidesoft.ws.paymentscreate.webservices.util;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.service.db.DalConnectionProvider;

import com.sidesoft.localization.ecuador.finances.ssfiBanktransfer;

import ec.com.sidesoft.payment.in.transit.SspitraCollectionTransit;
import ec.com.sidesoft.payment.in.transit.SspitraCtDetail;
import ec.com.sidesoft.ws.paymentscreate.SWSPCConfig;
import ec.com.sidesoft.ws.paymentscreate.SWSPCTransaction;

abstract public class Helper {

  static public User user = null;
  static public SWSPCConfig config = null;
  static public SspitraCollectionTransit payment = null;

  static public void getConfig() {
    config = null;
    try {
      OBCriteria<SWSPCConfig> query = OBDal.getInstance().createCriteria(SWSPCConfig.class);
      query.add(Restrictions.eq(SWSPCConfig.PROPERTY_ACTIVE, true));
      query.uniqueResult();
      if (query.list().size() == 0) {
        throw new OBException("No existe configuracion para el WS");
      }
      config = query.list().get(0);
    } catch (Exception e) {
      System.out.println("getConfig: " + e.getMessage());
      throw new OBException(e.getMessage());
    }
  }

  static public SspitraCollectionTransit createPayment(Organization org, BusinessPartner bPartner,
      FIN_PaymentMethod paymentMethod, ssfiBanktransfer bank, BusinessPartner seller,
      String reference, String check, String documentNo, String deposit, String description, Date paymentDate) {
    payment = null;
    try {
      payment = OBProvider.getInstance().get(SspitraCollectionTransit.class);
      payment.setNewOBObject(true);
      payment.setOrganization(org);
      payment.setClient(org.getClient());
      payment.setCreatedBy(user);
      payment.setUpdatedBy(user);
      payment.setPaymentDocumentno(documentNo);
      payment.setReferenceNo(reference);
      payment.setPaymentDate(paymentDate);
      payment.setBusinessPartner(bPartner);
      payment.setChargedBy(seller);
      payment.setSsfiBanktransfer(bank);
      payment.setDeposit(deposit);
      payment.setPaymentMethod(paymentMethod);
      payment.setFinancialAccount(config.getFinancialAccount());
      payment.setCurrency(config.getCurrency());
      payment.setDescription(description);
      payment.setCheckAccount(check);

      OBDal.getInstance().save(payment);
      return payment;
      // OBDal.getInstance().flush();
    } catch (Exception e) {
      System.out.println("createPayment: " + e.getMessage());
      throw new OBException(e.getMessage());
    }
  }

  static public void createDetail(String documentNo, BusinessPartner bPartner, BigDecimal amount,String payment_schedule_id) {
    SspitraCtDetail detail = null;
    try {
      if (amount.compareTo(BigDecimal.ZERO) <= 0) {
        throw new OBException("El monto debe ser mayor a 0");
      }

      OBCriteria<Invoice> query = OBDal.getInstance().createCriteria(Invoice.class);
      query.add(Restrictions.eq(Invoice.PROPERTY_DOCUMENTNO, documentNo));
      query.add(Restrictions.eq(Invoice.PROPERTY_BUSINESSPARTNER, bPartner));
      if (query.list().size() == 0) {
        throw new OBException("La factura " + documentNo + " no existe o no pertenece al tercero"
            + bPartner.getName());
      }
      Invoice invoice = query.list().get(0);

      if (invoice.getOutstandingAmount().compareTo(BigDecimal.ZERO) <= 0) {
        throw new OBException("La factura " + documentNo + " no tiene monto pendiente");
      }

      if (invoice.getOutstandingAmount().compareTo(amount) < 0) {
        throw new OBException("El monto (" + amount.toString() + ") supera el total pendiente ("
            + invoice.getOutstandingAmount().toString() + ") de la factura " + documentNo);
      }
      FIN_PaymentSchedule  paymentSchedule = OBDal.getInstance().get(FIN_PaymentSchedule.class,
          payment_schedule_id);
      
      detail = OBProvider.getInstance().get(SspitraCtDetail.class);
      detail.setNewOBObject(true);
      detail.setOrganization(payment.getOrganization());
      detail.setClient(payment.getOrganization().getClient());
      detail.setCreatedBy(user);
      detail.setUpdatedBy(user);
      detail.setSspitraCollectiontransit(payment);
      detail.setInvoice(invoice);
      detail.setGrandTotalAmount(invoice.getGrandTotalAmount());
      detail.setTotalPaid(invoice.getTotalPaid());
      detail.setOutstandingAmount(invoice.getOutstandingAmount());
      detail.setAmount(amount);
      if(paymentSchedule != null) {
        detail.setFinPaymentSchedule(paymentSchedule);
      }
      OBDal.getInstance().save(detail);

      payment.setAmount(payment.getAmount().add(amount));

      OBDal.getInstance().save(payment);
    } catch (Exception e) {
      System.out.println("createDetail: " + e.getMessage());
      throw new OBException(e.getMessage());
    }
  }

  static public BigDecimal getAmountPendingInvoice(String invoiceId) {
    ConnectionProvider conn = new DalConnectionProvider(false);
    String result = null;
    BigDecimal pending = new BigDecimal(0);

    try {
      String sql = "SELECT (ps.amount - COALESCE(SUM(psd.amount),0)) AS pending "
          + " FROM c_invoice AS i"
          + " JOIN fin_payment_schedule AS ps ON ps.c_invoice_id=i.c_invoice_id"
          + " LEFT JOIN fin_payment_scheduledetail AS psd ON (psd.fin_payment_schedule_invoice=ps.fin_payment_schedule_id AND psd.isinvoicepaid='Y')"
          + " WHERE i.c_invoice_id=?" + " GROUP BY ps.amount";
      PreparedStatement st = null;
      st = conn.getPreparedStatement(sql);
      st.setString(1, invoiceId);
      ResultSet resultSet = st.executeQuery();

      while (resultSet.next()) {
        result = resultSet.getString("pending");
      }
      pending = new BigDecimal(result);
    } catch (Exception e) {
      System.out.println("getInvoicePendingAmount: " + e.getMessage());
    }
    return pending;
  }

  static public List<JSONObject> getInvoicesWithOutstandingAmount(String businessPartnerId)
      throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(false);
    List<JSONObject> invoices = new ArrayList<JSONObject>();

    String sql = "SELECT a.c_invoice_id, a.documentno, a.dateinvoiced, a.duedate, a.amount, a.paid,"
        + " (a.amount - a.paid) AS pending, p.c_bpartner_id, p.name FROM ("
        + " SELECT i.c_invoice_id, i.documentno, i.dateinvoiced, ps.duedate, ps.amount,"
        + " COALESCE(SUM(psd.amount),0) AS paid, i.c_bpartner_id FROM c_invoice AS i"
        + " JOIN fin_payment_schedule AS ps ON ps.c_invoice_id=i.c_invoice_id"
        + " LEFT JOIN fin_payment_scheduledetail AS psd ON (psd.fin_payment_schedule_invoice=ps.fin_payment_schedule_id AND psd.isinvoicepaid='Y')"
        + " GROUP BY i.c_invoice_id, i.dateinvoiced, i.documentno, ps.duedate, ps.amount"
        + " ) AS a"
        + " JOIN c_bpartner AS p ON p.c_bpartner_id=a.c_bpartner_id WHERE (a.amount - a.paid) > 0";
    if (businessPartnerId != null && !businessPartnerId.isEmpty()) {
      sql += " AND p.c_bpartner_id=?";
    }
    PreparedStatement ps = null;
    ps = conn.getPreparedStatement(sql);
    if (businessPartnerId != null && !businessPartnerId.isEmpty()) {
      ps.setString(1, businessPartnerId);
    }
    ResultSet rs = ps.executeQuery();

    JSONObject invoice = null;
    while (rs.next()) {
      invoice = new JSONObject();
      invoice.put("invoiceId", rs.getString("c_invoice_id"));
      invoice.put("invoiceDate", rs.getString("dateinvoiced"));
      invoice.put("invoiceDueDate", rs.getString("duedate"));
      invoice.put("businessPartnerId", rs.getString("c_bpartner_id"));
      invoice.put("businessPartner", rs.getString("name"));
      invoice.put("documentno", rs.getString("documentno"));
      invoice.put("amount", rs.getBigDecimal("amount"));
      invoice.put("paid", rs.getBigDecimal("paid"));
      invoice.put("pending", rs.getBigDecimal("pending"));
      invoices.add(invoice);
    }
    return invoices;
  }

  static public boolean createTransaction(String id, String transactionId, String reference,
      String authorizationCode, String carrierCode, BigDecimal amount) {
    boolean result = true;

    try {
      OBCriteria<FIN_PaymentScheduleDetail> psdList = OBDal.getInstance()
          .createCriteria(FIN_PaymentScheduleDetail.class);
      psdList.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAID, true));
      psdList.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_AMOUNT, amount));
      psdList.addOrder(Order.desc(FIN_PaymentScheduleDetail.PROPERTY_CREATIONDATE));
      if (psdList.list().size() == 0) {
        throw new OBException("paymentScheduleDetailId no existe.");
      }
      FIN_PaymentScheduleDetail psd = psdList.list().get(0);

      SWSPCTransaction transaction = OBProvider.getInstance().get(SWSPCTransaction.class);
      transaction.setNewOBObject(true);
      transaction.setId(id);
      transaction.setTransaction(transactionId);
      transaction.setOrganization(psd.getOrganization());
      transaction.setClient(psd.getClient());
      transaction.setCreatedBy(psd.getCreatedBy());
      transaction.setCreationDate(psd.getCreationDate());
      transaction.setUpdatedBy(psd.getUpdatedBy());
      transaction.setUpdated(psd.getUpdated());
      transaction.setPaymentScheduleDetail(psd);
      transaction.setReference(reference);
      transaction.setAuthorizationCode(authorizationCode);
      transaction.setCarrierCode(carrierCode);
      OBDal.getInstance().save(transaction);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      result = false;
      System.out.println("createTransaction: " + e.getMessage());
    }
    return result;
  }

}
