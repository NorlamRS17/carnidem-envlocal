package ec.com.sidesoft.discount.quota.salesinvoices.ad_process;

import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.math.BigDecimal;

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

public class Reactive extends DalBaseProcess {
  OBError message;
  public FIN_Payment payment = null;
  public FIN_PaymentScheduleDetail paymentScheduleDetail = null;
  public FIN_PaymentDetail paymentDetail = null;
  public SPEVDetailNews detailNews = null;
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
    String msg ="";
    String type_msg ="";
    String tittle_msg ="";
System.out.println(quotaDetailId);

    if(quotaDetail!= null){
    boolean status = loadLines(quotaDetail);
      if(status){  
        msg ="Proceso Exitoso";
        type_msg ="Success";
        tittle_msg ="ProcessOK";
      }
      else{      
        msg ="No existen Facturas";
        type_msg ="Info";
        tittle_msg ="Info";}}
      message.setMessage(Utility.messageBD(conn, msg, language));
      message.setType(type_msg);
      message.setTitle(Utility.messageBD(conn, type_msg, language));
  }

    private boolean loadLines (QuotaDetail quotaDetail) throws Exception {

        quotaDetail.setState("DR");
        return true;
    }
}
