package ec.com.sidesoft.discount.quota.salesinvoices.ad_process;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.discount.quota.salesinvoices.QuotaDetail;
import ec.com.sidesoft.discount.quota.salesinvoices.QuotaDetailLine;

public class LoadLines extends DalBaseProcess {
  OBError message;
  public QuotaDetailLine quotaDetailLine = null;
  List<String> paymentSchedules = new ArrayList<String>();

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      String language = OBContext.getOBContext().getLanguage().getLanguage();
      ConnectionProvider conn = new DalConnectionProvider(false);

      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      bundle.setResult(message);
    }
  }

  private void processRequest(ProcessBundle bundle) throws Exception {

    String quotaDetailId = (String) bundle.getParams().get("Ssdqsi_Quota_Detail_ID");
    QuotaDetail quotaDetail = OBDal.getInstance().get(QuotaDetail.class, quotaDetailId);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String msg = "";
    String type_msg = "";
    String tittle_msg = "";

    if (quotaDetail != null) {
      boolean status = loadLines(quotaDetail);
      if (status) {
        msg = "Facturas cargadas";
        type_msg = "Success";
        tittle_msg = "ProcessOK";
      } else {
        msg = "No existen Facturas";
        type_msg = "Info";
        tittle_msg = "Info";
      }
    }
    message.setMessage(Utility.messageBD(conn, msg, language));
    message.setType(type_msg);
    message.setTitle(Utility.messageBD(conn, type_msg, language));
  }

  private boolean loadLines(QuotaDetail quotaDetail) throws Exception {

    boolean partner = false;
    OBCriteria<Invoice> invoiceList = OBDal.getInstance().createCriteria(Invoice.class);

    invoiceList.add(Restrictions.eq(Invoice.PROPERTY_SALESTRANSACTION, true));
    invoiceList.add(Restrictions.ne(Invoice.PROPERTY_DOCUMENTSTATUS, "TEMP"));
    invoiceList.add(Restrictions.ne(Invoice.PROPERTY_OUTSTANDINGAMOUNT, new BigDecimal("0")));
    // Validacion Tercero
    if (quotaDetail.getBusinessPartner() != null) {
      // Condiciones principales para Factura (Cliente)
      invoiceList.add(Restrictions.eq(Invoice.PROPERTY_SALESTRANSACTION, true));
      invoiceList.add(Restrictions.ne(Invoice.PROPERTY_DOCUMENTSTATUS, "TEMP"));
      invoiceList.add(Restrictions.ne(Invoice.PROPERTY_OUTSTANDINGAMOUNT, new BigDecimal("0")));
      // invoiceList.add(Restrictions.isNull(Invoice.PROPERTY_SSPICSDETINVC));
      invoiceList
          .add(Restrictions.eq(Invoice.PROPERTY_BUSINESSPARTNER, quotaDetail.getBusinessPartner()));
      if (invoiceList.count() > 0) {
        partner = true;
      }
    } else {
      // TErceros q sean solo empleados
      OBCriteria<BusinessPartner> bpartner = OBDal.getInstance()
          .createCriteria(BusinessPartner.class);
      bpartner.add(Restrictions.eq(BusinessPartner.PROPERTY_EMPLOYEE, true));
      invoiceList.add(Restrictions.in(Invoice.PROPERTY_BUSINESSPARTNER, bpartner.list()));
    }

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(quotaDetail.getPaymentDate());
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    Date paymentDate = calendar.getTime();

    OBCriteria<FIN_PaymentSchedule> paymentSchedulList = OBDal.getInstance()
        .createCriteria(FIN_PaymentSchedule.class);
    paymentSchedulList.add(Restrictions.lt(FIN_PaymentSchedule.PROPERTY_DUEDATE, paymentDate));
    paymentSchedulList
        .add(Restrictions.ne(FIN_PaymentSchedule.PROPERTY_OUTSTANDINGAMOUNT, new BigDecimal("0")));
    paymentSchedulList.add(Restrictions.isNull(FIN_PaymentSchedule.PROPERTY_ORDER));
    if (partner == true) {
      paymentSchedulList
          .add(Restrictions.in(FIN_PaymentSchedule.PROPERTY_INVOICE, invoiceList.list()));
    } else {
    }

    if (paymentSchedulList.count() > 0) {

      for (FIN_PaymentSchedule paymentSchedule : paymentSchedulList.list()) {

        boolean isempl = (paymentSchedule.getInvoice().getBusinessPartner().isEmployee() != null)
            ? paymentSchedule.getInvoice().getBusinessPartner().isEmployee()
            : false;
        boolean iscredit = (paymentSchedule.getInvoice().getDocumentType().isReversal() != null)
            ? paymentSchedule.getInvoice().getDocumentType().isReversal()
            : false;
        if (paymentSchedule.getInvoice().isSalesTransaction() == true && isempl == true
            && iscredit == false
            && getNumberPayment(paymentSchedule, paymentSchedule.getOutstandingAmount()) == true) {
          quotaDetailLine = OBProvider.getInstance().get(QuotaDetailLine.class);
          quotaDetailLine.setSsdqsiQuotaDetail(quotaDetail);
          quotaDetailLine.setDUEDate(paymentSchedule.getDueDate());
          quotaDetailLine.setPendingAmount(paymentSchedule.getOutstandingAmount());
          quotaDetailLine.setFee((paymentSchedule.getSsppiShareno() != null)
              ? new BigDecimal(paymentSchedule.getSsppiShareno())
              : new BigDecimal("0"));
          quotaDetailLine.setBusinessPartner(paymentSchedule.getInvoice().getBusinessPartner());
          quotaDetailLine.setInvoice(paymentSchedule.getInvoice());

          OBDal.getInstance().save(quotaDetailLine);
          OBDal.getInstance().flush();
        }
      }
    } else {
      return false;
    }
    return true;
  }

  public boolean getNumberPayment(FIN_PaymentSchedule paymentSchedule, BigDecimal outstandingamt)
      throws OBException {
    OBCriteria<FIN_PaymentScheduleDetail> obc = OBDal.getInstance()
        .createCriteria(FIN_PaymentScheduleDetail.class);
    obc.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAYMENTSCHEDULE,
        paymentSchedule));
    // obc.add(Restrictions.isNotNull(FIN_PaymentScheduleDetail.PROPERTY_PAYMENTDETAILS));
    obc.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAID, true));
    obc.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_AMOUNT, outstandingamt));
    if (obc.list().size() > 0) {
      return false;
    }
    return true;
  }

}
