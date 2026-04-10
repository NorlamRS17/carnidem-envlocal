package ec.com.sidesoft.discount.quota.salesinvoices.ad_process;

import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.math.BigDecimal;
import java.util.Calendar;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.currency.Currency;

import ec.com.sidesoft.discount.quota.salesinvoices.*;
import org.openbravo.model.financialmgmt.payment.*;
import ec.com.sidesoft.payroll.events.*;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.dao.TransactionsDao;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.apache.log4j.Logger;

public class ProcessLines extends DalBaseProcess {
  OBError message;
  public FIN_Payment payment = null;
  public FIN_PaymentScheduleDetail paymentScheduleDetail = null;
  public FIN_PaymentDetail paymentDetail = null;
  public FIN_FinaccTransaction finTrans = null;
  public SPEVDetailNews detailNews = null;
  protected Logger logger = Logger.getLogger(this.getClass());

  List<String> paymentSchedules = new ArrayList<String>();

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      ConnectionProvider conn = new DalConnectionProvider(false);
      String language = OBContext.getOBContext().getLanguage().getLanguage();
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
    
    if (logger.isDebugEnabled()) {
    	logger.debug("DEBUG - ProcessLines - quotaDetailId: " + quotaDetailId);
    }

    if (quotaDetail != null) {
      boolean status = loadLines(quotaDetail);
      if (status) {
        msg = "Proceso Exitoso";
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
	  if (logger.isDebugEnabled()) {
	    	logger.debug("DEBUG - Inicio Proceso - Generación de Cobros");
	    }
	  try {
		  OBCriteria<QuotaDetailLine> quotaDetailLineList = OBDal.getInstance()
			        .createCriteria(QuotaDetailLine.class);
			    quotaDetailLineList
			        .add(Restrictions.eq(QuotaDetailLine.PROPERTY_SSDQSIQUOTADETAIL, quotaDetail));
			    if (quotaDetailLineList.count() > 0) {

			        for (QuotaDetailLine quotaDetailLine : quotaDetailLineList.list()) {
			        	if (logger.isDebugEnabled()) {
			    	    	logger.debug("DEBUG - Generando Cobro para la Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
			    	    }
			          String noDoc = noDocument(quotaDetailLine.getSsdqsiQuotaDetail());

			          payment = OBProvider.getInstance().get(FIN_Payment.class);
			          payment.setDocumentNo(noDoc);
			          payment
			              .setDocumentType(quotaDetailLine.getSsdqsiQuotaDetail().getTipeDocumentCollections());
			          payment.setPaymentMethod(quotaDetailLine.getSsdqsiQuotaDetail().getPaymentMethod());
			          payment.setPaymentDate(quotaDetailLine.getSsdqsiQuotaDetail().getPaymentDate());
			          payment.setReceipt(true);
			          payment.setCurrency(quotaDetailLine.getInvoice().getCurrency());
			          payment.setBusinessPartner(quotaDetailLine.getBusinessPartner());
			          payment.setFinancialTransactionAmount(quotaDetailLine.getPendingAmount());
			          payment.setDescription("Factura Nº : " + quotaDetailLine.getInvoice().getDocumentNo()
			              + "\nConceptos Contables: "
			              + quotaDetailLine.getSsdqsiQuotaDetail().getGLItem().getName());
			          payment.setAccount(quotaDetailLine.getSsdqsiQuotaDetail().getFinancialAccount());
			          payment.setSsiorDetailreport(true);

			          OBDal.getInstance().save(payment);
			          OBDal.getInstance().flush();

			          AddPaymentLine(payment, quotaDetailLine);
			          AddPaymentLineGLI(payment, quotaDetailLine);
			          AddDetailEvents(quotaDetailLine);

			          payment.setProcessed(true);
			          payment.setStatus("RPR");
			          payment.setAPRMProcessPayment("RE");
			          if (logger.isDebugEnabled()) {
			    	    	logger.debug("DEBUG - Cobro Generado para la Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
			    	  }
			        }
			      } else {
			        return false;
			      }
			    return true;
	  } catch (Exception e) {
		if (logger.isDebugEnabled()) {
		    logger.debug("DEBUG - Error ProcessLines :" + e.getMessage());
		}
		e.printStackTrace();
		OBDal.getInstance().rollbackAndClose();
		throw new OBException("Error: " + e.getMessage());
	}
  }

  private String noDocument(QuotaDetail transfer) throws Exception { 
    Sequence sequence = transfer.getTipeDocumentCollections().getDocumentSequence();
    String value = String.valueOf(sequence.getNextAssignedNumber());
    sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    if (logger.isDebugEnabled()) {
 	   logger.debug("DEBUG - Nuevo Número de Documento: " + value);
 	} 
    return value;
  }

  private void AddPaymentLine(FIN_Payment payment, QuotaDetailLine quotaDetailLine)
      throws Exception {
	  if (logger.isDebugEnabled()) {
	 	   logger.debug("DEBUG - Comienzo Nueva Línea de Pago - Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
	 	}

    AdvPaymentMngtDao dao = new AdvPaymentMngtDao();

    OBContext.setAdminMode(true);
    OBCriteria<FIN_PaymentSchedule> paymentSchedulList = OBDal.getInstance()
        .createCriteria(FIN_PaymentSchedule.class);
    paymentSchedulList
        .add(Restrictions.eq(FIN_PaymentSchedule.PROPERTY_INVOICE, quotaDetailLine.getInvoice()));
    paymentSchedulList.add(Restrictions.eq(FIN_PaymentSchedule.PROPERTY_OUTSTANDINGAMOUNT,
        quotaDetailLine.getPendingAmount()));
    paymentSchedulList
        .add(Restrictions.eq(FIN_PaymentSchedule.PROPERTY_DUEDATE, quotaDetailLine.getDUEDate()));
    // paymentSchedulList.add(Restrictions.eq(FIN_PaymentSchedule.PROPERTY_SSPPISHARENO,
    // quotaDetailLine.getFee()));

    paymentDetail = OBProvider.getInstance().get(FIN_PaymentDetail.class);
    paymentDetail.setFinPayment(payment);
    // paymentDetail.setGLItem(quotaDetailLine.getSsdqsiQuotaDetail().getGLItem());
    paymentDetail.setAmount(quotaDetailLine.getPendingAmount());
    OBDal.getInstance().save(paymentDetail);
    OBDal.getInstance().flush();

    if (paymentSchedulList.list().size() == 0) {
      throw new OBException("Plan de pago no encontrado para la Factura: "
          + quotaDetailLine.getInvoice().getDocumentNo() + " con valor pendiente de: "
          + quotaDetailLine.getPendingAmount() + " y fecha: " + quotaDetailLine.getDUEDate());
    }

    OBCriteria<FIN_PaymentScheduleDetail> pymScheduleDetail = OBDal.getInstance()
        .createCriteria(FIN_PaymentScheduleDetail.class);
    pymScheduleDetail.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAYMENTSCHEDULE,
        paymentSchedulList.list().get(0)));
    pymScheduleDetail.add(Restrictions.isNull(FIN_PaymentScheduleDetail.PROPERTY_PAYMENTDETAILS));
    pymScheduleDetail.setMaxResults(1);

    FIN_PaymentScheduleDetail pd = (FIN_PaymentScheduleDetail) pymScheduleDetail.uniqueResult();

    // paymentSchedulList.add(Restrictions.eq(FIN_PaymentScheduleDetail.PROPERTY_INVOICEPAYMENTSCHEDULE,
    // paymentSchedulList.list().get(0)));
    // paymentScheduleDetail = OBProvider.getInstance().get(FIN_PaymentScheduleDetail.class);
    // paymentScheduleDetail.setInvoicePaymentSchedule(paymentSchedulList.list().get(0));
    if (pd == null) {
        throw new OBException("Detalles de pago no encontrado para la Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
     }
    
    pd.setPaymentDetails(paymentDetail);
    pd.setInvoicePaid(true);
    // // paymentScheduleDetail.setInvoicePaid(true);
    // paymentScheduleDetail.setAPRMPaymentMethod(quotaDetailLine.getSsdqsiQuotaDetail().getPaymentMethod());
    // paymentScheduleDetail.setAPRMFinancialAccount(quotaDetailLine.getSsdqsiQuotaDetail().getFinancialAccount());
    // paymentScheduleDetail.setBusinessPartner(quotaDetailLine.getBusinessPartner());
    // paymentScheduleDetail.setAmount(quotaDetailLine.getPendingAmount());

    // OBDal.getInstance().save(paymentScheduleDetail);
    // OBDal.getInstance().flush();

    BigDecimal paymentValue = paymentSchedulList.list().get(0).getOutstandingAmount()
        .subtract(quotaDetailLine.getPendingAmount());
    BigDecimal paidValue = paymentSchedulList.list().get(0).getPaidAmount()
        .add(quotaDetailLine.getPendingAmount());
    paymentSchedulList.list().get(0).setOutstandingAmount(paymentValue);
    paymentSchedulList.list().get(0).setPaidAmount(paidValue);

    paymentValue = quotaDetailLine.getInvoice().getOutstandingAmount()
        .subtract(quotaDetailLine.getPendingAmount());
    paidValue = quotaDetailLine.getInvoice().getTotalPaid().add(quotaDetailLine.getPendingAmount());
    quotaDetailLine.getInvoice().setOutstandingAmount(paymentValue);
    quotaDetailLine.getInvoice().setTotalPaid(paidValue);
    
    if (logger.isDebugEnabled()) {
	 	   logger.debug("DEBUG - Nueva Línea de Pago Generada - Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
	 	}
  }

  private void AddPaymentLineGLI(FIN_Payment payment, QuotaDetailLine quotaDetailLine)
      throws Exception {
	  
	  if (logger.isDebugEnabled()) {
	 	   logger.debug("DEBUG - Nuevo Detalle de Pago - Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
	 	}
	  
    AdvPaymentMngtDao dao = new AdvPaymentMngtDao();

    OBContext.setAdminMode(true);

    paymentDetail = OBProvider.getInstance().get(FIN_PaymentDetail.class);
    paymentDetail.setFinPayment(payment);
    paymentDetail.setAmount(quotaDetailLine.getPendingAmount().multiply(new BigDecimal("-1")));
    paymentDetail.setGLItem(quotaDetailLine.getSsdqsiQuotaDetail().getGLItem());
    OBDal.getInstance().save(paymentDetail);
    OBDal.getInstance().flush();

    paymentScheduleDetail = OBProvider.getInstance().get(FIN_PaymentScheduleDetail.class);
    paymentScheduleDetail.setPaymentDetails(paymentDetail);
    paymentScheduleDetail
        .setAmount(quotaDetailLine.getPendingAmount().multiply(new BigDecimal("-1")));
    // paymentScheduleDetail.setBusinessPartner(quotaDetailLine.getBusinessPartner());

    OBDal.getInstance().save(paymentScheduleDetail);
    OBDal.getInstance().flush();
  }

  private void AddDetailEvents(QuotaDetailLine quotaDetailLine) throws Exception {
    OBCriteria<SPEVConfigNews> configNewsList = OBDal.getInstance()
        .createCriteria(SPEVConfigNews.class);
    configNewsList.add(Restrictions.eq(SPEVConfigNews.PROPERTY_SSPRCONCEPT,
        quotaDetailLine.getSsdqsiQuotaDetail().getSsprConcept()));

    Calendar date = Calendar.getInstance();
    date.setTime(quotaDetailLine.getSsdqsiQuotaDetail().getPaymentDate());
    date.set(Calendar.DAY_OF_MONTH, 1);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String f_date = format.format(date.getTime());
    // Date periodo = format.parse(f_date);
    Date periodo = date.getTime();

    OBCriteria<Period> periodList = OBDal.getInstance().createCriteria(Period.class);
    periodList.add(Restrictions.eq(Period.PROPERTY_STARTINGDATE, periodo));

    detailNews = OBProvider.getInstance().get(SPEVDetailNews.class);
    detailNews.setDateDetail(quotaDetailLine.getDUEDate());
    detailNews.setDoumentno(quotaDetailLine.getInvoice().getDocumentNo());
    detailNews.setBpartner(quotaDetailLine.getBusinessPartner());
    detailNews.setValue(quotaDetailLine.getPendingAmount());
    detailNews.setSsprConcept(quotaDetailLine.getSsdqsiQuotaDetail().getSsprConcept());
    detailNews.setConceptType(
        quotaDetailLine.getSsdqsiQuotaDetail().getSsprConcept().getConceptsubtype());
    detailNews.setProcess("AU");
    detailNews.setType("BR");
    detailNews.setPeriod((periodList.count() > 0) ? periodList.list().get(0) : null);
    detailNews.setSpevMaintenanceNews(
        (configNewsList.count() > 0) ? configNewsList.list().get(0).getSpevMaintenanceNews()
            : null);

    OBDal.getInstance().save(detailNews);
    OBDal.getInstance().flush();
    
    if (logger.isDebugEnabled()) {
	 	   logger.debug("DEBUG - Detalle de Pago Procesado - Factura: " + quotaDetailLine.getInvoice().getDocumentNo());
	 	}

    quotaDetailLine.getSsdqsiQuotaDetail().setState("SSDQSI_PR");

  }
}