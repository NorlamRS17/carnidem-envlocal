package ec.com.sidesoft.deposit.reconciliation.ad_backgrounds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.advpaymentmngt.APRMPendingPaymentFromInvoice;
import org.openbravo.advpaymentmngt.dao.AdvPaymentMngtDao;
import org.openbravo.advpaymentmngt.process.FIN_AddPayment;
import org.openbravo.advpaymentmngt.process.FIN_ExecutePayment;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.financialmgmt.payment.FIN_BankStatementLine;
import org.openbravo.model.financialmgmt.payment.FIN_Payment;
import org.openbravo.model.financialmgmt.payment.PaymentExecutionProcess;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.ad.ui.Process;
import org.openbravo.erpCommon.utility.SequenceIdData;
import org.openbravo.erpCommon.utility.Utility;

public class DepositReconciliation extends DalBaseProcess implements KillableProcess {

  private static final Logger log4j = Logger.getLogger(DepositReconciliation.class);
  private static ProcessLogger logger;
  private boolean killProcess = false;
  private AdvPaymentMngtDao dao;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {

    final OBError message = new OBError();
    dao = new AdvPaymentMngtDao();
    try {
      OBContext.setAdminMode(true);
      logger = bundle.getLogger();
      getDepositToReconcilie(bundle, message);
    } catch (Exception e) {
      e.printStackTrace();
      throw new OBException(e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
      ;
    }
  }

  @Override
  public void kill(ProcessBundle processBundle) throws Exception {
    logger.logln("kill process DepositReconciliation");
    this.killProcess = true;
  }

  private void getDepositToReconcilie(ProcessBundle bundle, OBError message) {
    final ConnectionProvider conn = bundle.getConnection();
    final VariablesSecureApp vars = bundle.getContext().toVars();
    try {

      Process process = OBDal.getInstance().get(Process.class, "15B423B6AA6F46A583C4F6A2692F8BE6");

      final ProcessInstance pInstance = CallProcess.getInstance().call(process,
          SequenceIdData.getUUID(), null);

      OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
      String msg = oberror.getMessage();
      if (pInstance.getResult() == 0) {
        logger.logln(msg);
      }

    } catch (final Exception e) {
      e.printStackTrace(System.err);
    } finally {
      bundle.setResult(message);
    }
  }

}
