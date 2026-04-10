package ec.com.sidesoft.web.services.sales.webservices;

import org.codehaus.jettison.json.JSONException;
import org.openbravo.advpaymentmngt.process.FIN_PaymentProcess;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.advpaymentmngt.utility.FIN_Utility;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.invoice.InvoiceLine;
import java.math.RoundingMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.common.enterprise.DocumentType;
import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.service.db.CallStoredProcedure;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.codehaus.jettison.json.JSONArray;
import java.util.HashMap;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import java.util.ArrayList;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.model.common.enterprise.Organization;
import java.util.List;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.base.exception.OBException;
import java.math.BigDecimal;
import java.io.Writer;
import org.openbravo.database.ConnectionProvider;
import org.apache.commons.lang.StringUtils;
import org.openbravo.dal.service.OBDal;
import org.openbravo.base.provider.OBProvider;
import java.io.InputStream;

import ec.com.sidesoft.web.services.log.swblConfig;
import ec.com.sidesoft.web.services.log.swblLog;
import ec.com.sidesoft.web.services.sales.utils.Swssl_Helper;
import java.util.Date;
import org.openbravo.dal.core.OBContext;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.json.JsonUtils;
import org.codehaus.jettison.json.JSONObject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.openbravo.service.web.WebService;
import ec.com.sidesoft.custom.ws.api.ScwsapLog;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.erpCommon.utility.OBDateUtils;

public class Swssl_CreatePaymentInvoice implements WebService
{
    private final Logger logger;
    
    public Swssl_CreatePaymentInvoice() {
        this.logger = Logger.getLogger((Class)Swssl_CreatePaymentInvoice.class);
    }
    
    public void doPost(final String path, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        JSONObject json = new JSONObject();
        String logId = null;
        final ConnectionProvider conn = (ConnectionProvider)new DalConnectionProvider(false);
        Label_0508: {
            try {
                OBContext.setAdminMode(true);
                this.logger.info((Object)"Begin Swssl_CreatePaymentInvoice doPost");
                final Date loggerDate = new Date();
                final JSONObject body = Swssl_Helper.readAllIntoJSONObject((InputStream)request.getInputStream());
                this.logger.info((Object)"Json enviado");
                this.logger.info((Object)loggerDate.toString());
                this.logger.info((Object)body.toString());
                final ScwsapLog log = (ScwsapLog)OBProvider.getInstance().get((Class)ScwsapLog.class);
                log.setEndpoint("createPaymentInvoice");
                log.setJsonRequest(body.toString());
                OBDal.getInstance().save((Object)log);
                OBDal.getInstance().flush();
                OBDal.getInstance().getConnection().commit();
                logId = log.getId();
                this.create(conn, body);
                json = Swssl_Helper.getResponse(body);
                log.setJsonResponse(json.toString());
                log.setRecordID(body.getString("paymentId"));
                log.setReferenceNo(body.getString("paymentNo"));
                log.setResult("OK");
                OBDal.getInstance().save((Object)log);
                OBDal.getInstance().flush();
                OBDal.getInstance().commitAndClose();
                json.remove("data");
            }
            catch (Exception e) {
                OBDal.getInstance().rollbackAndClose();
                final String message = Swssl_Helper.getErrorMessage(this.logger, e);
                this.logger.error((Object)message);
                final String[] data = StringUtils.split(e.getMessage().toString(), ",");
                final ScwsapLog log2 = (ScwsapLog)OBDal.getInstance().get((Class)ScwsapLog.class, (Object)logId);
                if (log2 != null) {
                    log2.setResult("ERROR");
                    log2.setError(message);
                    OBDal.getInstance().save((Object)log2);
                    OBDal.getInstance().flush();
                    OBDal.getInstance().getConnection().commit();
                }
                json = Swssl_Helper.getErrorResponse(message);
                if (data.length > 1) {
                    json.put("code", (Object)data[0]);
                    json.put("Message", (Object)data[1]);
                }
                break Label_0508;
            }
            finally {
                try {
                    conn.getConnection().close();
                    conn.destroy();
                }
                catch (Exception e2) {
                    e2.printStackTrace();
                }
                OBContext.restorePreviousMode();
                this.logger.info((Object)"Finish Swssl_CreatePaymentInvoice doPost");
            }
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        final Writer w = response.getWriter();
        w.write(json.toString());
        w.close();
    }
    
    public void doGet(final String path, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    }
    
    public void doPut(final String path, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    }
    
    public void doDelete(final String path, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    }
    
    private void create(final ConnectionProvider conn, final JSONObject body) throws Exception {
        StringBuilder whereClause = new StringBuilder();
        final Date paymentDate = new Date();
        this.logger.info((Object)paymentDate);
        final BigDecimal amountToPay = Swssl_Helper.getBigDecimal(body, "amountToPay", true);
        if (amountToPay.compareTo(BigDecimal.ZERO) == 0) {
            throw new OBException("104, INGRESO DE DATOS ERRONEO");
        }
        final String invoiceId = Swssl_Helper.getString(body, "creditOperationId", true);
        final String paymentMethodId = Swssl_Helper.getString(body, "paymentMethod", true);
        final String depositdate = Swssl_Helper.getString(body, "depositdate", true);
        final String referenceno = Swssl_Helper.getString(body, "referenceno", true);
        final String bankId = Swssl_Helper.getString(body, "bank", true);
        
        whereClause = new StringBuilder();
        whereClause.append(" WHERE ");
        whereClause.append(" TRIM('" + invoiceId + "') IN (" + "id" + ", " + "documentNo" + ")");
        final OBQuery<Invoice> qInvoice = (OBQuery<Invoice>)OBDal.getInstance().createQuery((Class)Invoice.class, whereClause.toString());
        if (qInvoice.list().size() == 0) {
            throw new OBException("103, Operacion de Credito no existe ");
        }
        
        FIN_PaymentMethod payObj = OBDal.getInstance().get(FIN_PaymentMethod.class, paymentMethodId);
        if (payObj == null) {
        	throw new OBException("103, Metodo de Pago no existe");
        }
        
        final Invoice invoice = qInvoice.list().get(0);
        
        whereClause = new StringBuilder();
        whereClause.append(" WHERE ");
        whereClause.append("active = 'Y' ");
        whereClause.append(" AND organization.id = '" + invoice.getOrganization().getId() + "'");
        whereClause.append(" AND paymentMethod.id = '" + payObj.getId() + "'");
        final OBQuery<swblConfig> qConfig = (OBQuery<swblConfig>)OBDal.getInstance().createQuery((Class)swblConfig.class, whereClause.toString());
        if (qConfig.list().size() == 0) {
            throw new OBException("104,Configuration not found for organization [" + invoice.getOrganization().getName() + "]");
        }
                
        
        final swblConfig config = qConfig.list().get(0);
        
        if (payObj.getName().equalsIgnoreCase("DEPÓSITO") ||
    	    payObj.getName().equalsIgnoreCase("TRANSFERENCIA") ||
    	    payObj.getName().equalsIgnoreCase("CHEQUE")
    	    ) {
        	FIN_FinancialAccount bankObj = OBDal.getInstance().get(FIN_FinancialAccount.class, bankId);
        	if (bankObj == null) {
            	throw new OBException("103,El Banco no existe");
            }
        	
        	if (config.getDocumentType() == null) {
                throw new OBException("104, Document Type not found for organization [" + invoice.getOrganization().getName() + "]");
            }
        	
        	final int precision = invoice.getCurrency().getPricePrecision().intValue();
            this.paymentInCase2(conn, body, invoice.getOrganization(), invoice, precision, paymentDate, config.getDocumentType(), payObj, bankObj, depositdate, referenceno);
        	
        	
        } else {
        
            
            if (config.getDocumentType() == null) {
                throw new OBException("104, Document Type not found for organization [" + invoice.getOrganization().getName() + "]");
            }
            if (config.getPaymentMethod() == null) {
                throw new OBException("104, Payment Method not found for organization [" + invoice.getOrganization().getName() + "]");
            }
            if (config.getFinancialAccount() == null) {
                throw new OBException("104, Financial Account not found for organization [" + invoice.getOrganization().getName() + "]");
            }
            
            final int precision = invoice.getCurrency().getPricePrecision().intValue();
            this.paymentIn(conn, body, invoice.getOrganization(), invoice, precision, paymentDate, config);
        }
        
    }
    
    private JSONObject paymentIn(final ConnectionProvider conn, final JSONObject body, final Organization org, final Invoice invoice, final int precision, final Date paymentDate, final swblConfig config) throws Exception {
        final JSONObject jsonAttServ = new JSONObject();
        final String paymenchannel = Swssl_Helper.getString(body, "paymenchannel", true);
        final BigDecimal amountToPay = Swssl_Helper.getBigDecimal(body, "amountToPay", true);
        final boolean isWriteOff = false;
        
        final VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
        StringBuilder whereClause = new StringBuilder();
        whereClause.append(" WHERE ");
        whereClause.append(" TRIM('" + invoice.getBusinessPartner().getId() + "') IN (" + "id" + ", " + "taxID" + ")");
        final OBQuery<BusinessPartner> qCustomer = (OBQuery<BusinessPartner>)OBDal.getInstance().createQuery((Class)BusinessPartner.class, whereClause.toString());
        if (qCustomer.list().size() == 0) {
            throw new OBException("104,customer for paymen not found");
        }
        final BusinessPartner customer = qCustomer.list().get(0);
        final AdvPaymentMngtDao dao = new AdvPaymentMngtDao();
        List<FIN_PaymentScheduleDetail> scheduleDetails = (List<FIN_PaymentScheduleDetail>)dao.getInvoicePendingScheduledPaymentDetails(invoice);
        if (scheduleDetails.size() == 0) {
            throw new OBException("102,Sin creditos vigentes");
        }
        
        final List<FIN_PaymentScheduleDetail> details = new ArrayList<FIN_PaymentScheduleDetail>();
        final HashMap<String, BigDecimal> paidAmounts = new HashMap<String, BigDecimal>();
        BigDecimal paidAmount = new BigDecimal(amountToPay.toString());

        for (FIN_PaymentScheduleDetail item : scheduleDetails) {
            if (item.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                details.add(item);
                paidAmounts.put(item.getId(), item.getAmount());
                paidAmount = paidAmount.subtract(item.getAmount());
            }
        }

        for (FIN_PaymentScheduleDetail item : scheduleDetails) {
            if (item.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                if (paidAmount.compareTo(BigDecimal.ZERO) <= 0) {
                    break;
                }
                if (paidAmount.compareTo(item.getAmount()) <= 0) {
                    paidAmounts.put(item.getId(), paidAmount);
                    paidAmount = BigDecimal.ZERO;
                } else {
                    paidAmounts.put(item.getId(), item.getAmount());
                    paidAmount = paidAmount.subtract(item.getAmount());
                }
                details.add(item);
            }
        }

		if (paidAmount.compareTo(BigDecimal.ZERO) > 0) {
			throw new OBException("Amount of the payment (" + amountToPay
					+ ") exceeds the total pending of the sales invoice (" + invoice.getOutstandingAmount() + ")");
		}
        
        final DocumentType documentType2 = config.getDocumentType();
        //config.getSwsslCDoctypePay();
        if (documentType2 == null) {
            throw new OBException("104,Document Type for Payment no found");
        }
        
        final String paymentNo3 = Utility.getDocumentNo(conn.getConnection(), conn, vars, "", "FIN_Payment", documentType2.getId(), documentType2.getId(), false, true);
        final FIN_Payment newPayment3 = FIN_AddPayment.savePayment((FIN_Payment)null, (boolean)invoice.isSalesTransaction(), 
        		documentType2, paymentNo3, customer, config.getPaymentMethod(), config.getFinancialAccount(), 
        		amountToPay.toString(),
        		paymentDate, org, (String)null, (List)details, (HashMap)paidAmounts, isWriteOff, false);
        
        // Obtener el SalesRep_ID del tercero y asignarlo al campo em_sspac_c_bpartner_id
        this.logger.info("Customer ID: " + customer.getId());
        this.logger.info("Customer SalesRep: " + (customer.getSalesRepresentative() != null ? customer.getSalesRepresentative().getId() : "NULL"));
        if (customer.getSalesRepresentative() != null) {
            newPayment3.setSspacCBpartner(customer.getSalesRepresentative());
            OBDal.getInstance().save(newPayment3);
            this.logger.info("SalesRep assigned to payment: " + newPayment3.getSspacCBpartner().getId());
        } else {
            this.logger.warn("Customer has no SalesRepresentative assigned");
        }
        
        final String strDocAction = "P";
        OBError message2 = null;
        // Dejar que el proceso estándar cree automáticamente la transacción si tiene depósito automático
        message2 = FIN_AddPayment.processPayment(vars, conn, strDocAction, newPayment3, null);
        
        if ("Error".equals(message2.getType())) {
            throw new OBException(message2.getMessage());
        }
        
        OBDal.getInstance().refresh((Object)newPayment3);
      
        body.put("paymentId", (Object)newPayment3.getId());
        body.put("paymentNo", (Object)newPayment3.getDocumentNo());
        return jsonAttServ;
    }
    
    private JSONObject paymentInCase2(final ConnectionProvider conn, final JSONObject body, final Organization org, final Invoice invoice, final int precision, final Date paymentDate, final DocumentType documentType, final FIN_PaymentMethod paymentMethod, final FIN_FinancialAccount bank, final String depositdate, final String referenceno) throws Exception {
        final JSONObject jsonAttServ = new JSONObject();
        final String paymenchannel = Swssl_Helper.getString(body, "paymenchannel", true);
        final BigDecimal amountToPay = Swssl_Helper.getBigDecimal(body, "amountToPay", true);
        final boolean isWriteOff = false;
                
        final VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
        StringBuilder whereClause = new StringBuilder();
        whereClause.append(" WHERE ");
        whereClause.append(" TRIM('" + invoice.getBusinessPartner().getId() + "') IN (" + "id" + ", " + "taxID" + ")");
        final OBQuery<BusinessPartner> qCustomer = (OBQuery<BusinessPartner>)OBDal.getInstance().createQuery((Class)BusinessPartner.class, whereClause.toString());
        if (qCustomer.list().size() == 0) {
            throw new OBException("104,customer for paymen not found");
        }
        final BusinessPartner customer = qCustomer.list().get(0);
        final AdvPaymentMngtDao dao = new AdvPaymentMngtDao();
        List<FIN_PaymentScheduleDetail> scheduleDetails = (List<FIN_PaymentScheduleDetail>)dao.getInvoicePendingScheduledPaymentDetails(invoice);
        if (scheduleDetails.size() == 0) {
            throw new OBException("102,Sin creditos vigentes");
        }
        
        final List<FIN_PaymentScheduleDetail> details = new ArrayList<FIN_PaymentScheduleDetail>();
        final HashMap<String, BigDecimal> paidAmounts = new HashMap<String, BigDecimal>();
        BigDecimal paidAmount = new BigDecimal(amountToPay.toString());

        for (FIN_PaymentScheduleDetail item : scheduleDetails) {
            if (item.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                details.add(item);
                paidAmounts.put(item.getId(), item.getAmount());
                paidAmount = paidAmount.subtract(item.getAmount());
            }
        }

        for (FIN_PaymentScheduleDetail item : scheduleDetails) {
            if (item.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                if (paidAmount.compareTo(BigDecimal.ZERO) <= 0) {
                    break;
                }
                if (paidAmount.compareTo(item.getAmount()) <= 0) {
                    paidAmounts.put(item.getId(), paidAmount);
                    paidAmount = BigDecimal.ZERO;
                } else {
                    paidAmounts.put(item.getId(), item.getAmount());
                    paidAmount = paidAmount.subtract(item.getAmount());
                }
                details.add(item);
            }
        }

		if (paidAmount.compareTo(BigDecimal.ZERO) > 0) {
			throw new OBException("Amount of the payment (" + amountToPay
					+ ") exceeds the total pending of the sales invoice (" + invoice.getOutstandingAmount() + ")");
		}
        
        final String paymentNo3 = Utility.getDocumentNo(conn.getConnection(), conn, vars, "", "FIN_Payment", documentType.getId(), documentType.getId(), false, true);
        final FIN_Payment newPayment3 = FIN_AddPayment.savePayment((FIN_Payment)null, (boolean)invoice.isSalesTransaction(), 
        		documentType, paymentNo3, customer, paymentMethod, bank, 
        		amountToPay.toString(),
        		paymentDate, org, referenceno, (List)details, (HashMap)paidAmounts, isWriteOff, false);
        
        // Obtener el SalesRep_ID del tercero y asignarlo al campo em_sspac_c_bpartner_id
        this.logger.info("Customer ID: " + customer.getId());
        this.logger.info("Customer SalesRep: " + (customer.getSalesRepresentative() != null ? customer.getSalesRepresentative().getId() : "NULL"));
        if (customer.getSalesRepresentative() != null) {
            newPayment3.setSspacCBpartner(customer.getSalesRepresentative());
            this.logger.info("SalesRep assigned to payment: " + newPayment3.getSspacCBpartner().getId());
        } else {
            this.logger.warn("Customer has no SalesRepresentative assigned");
        }
        
        //Fecha de cobro igual a la fecha de deposito
        if (paymentMethod.getName().equalsIgnoreCase("CHEQUE")) {
            Date depositDateObj = JsonUtils.createDateFormat().parse(depositdate);
            newPayment3.setPaymentDate(depositDateObj);
        }
        
        newPayment3.setSsdrDatedeposit(JsonUtils.createDateFormat().parse(depositdate));
        OBDal.getInstance().save(newPayment3);
        OBDal.getInstance().flush();

        final String strDocAction = "P";
        OBError message2 = null;
        // Dejar que el proceso estándar cree automáticamente la transacción si tiene depósito automático
        message2 = FIN_AddPayment.processPayment(vars, conn, strDocAction, newPayment3, null);
        
        if ("Error".equals(message2.getType())) {
            throw new OBException(message2.getMessage());
        }
        
        OBDal.getInstance().refresh((Object)newPayment3);
      
        body.put("paymentId", (Object)newPayment3.getId());
        body.put("paymentNo", (Object)newPayment3.getDocumentNo());
        return jsonAttServ;
    }
}
