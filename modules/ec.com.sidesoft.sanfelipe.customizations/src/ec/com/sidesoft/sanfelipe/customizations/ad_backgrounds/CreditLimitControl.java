package ec.com.sidesoft.sanfelipe.customizations.ad_backgrounds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
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
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.CallStoredProcedure;
import org.openbravo.model.ad.process.ProcessInstance;

public class CreditLimitControl extends DalBaseProcess implements KillableProcess {

  private static final Logger log4j = Logger.getLogger(CreditLimitControl.class);
  private static ProcessLogger logger;
  private boolean killProcess = false;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    final OBError message = new OBError();
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
    logger.logln("kill process CreditLimitControl");
    this.killProcess = true;
  }

  private void getDepositToReconcilie(ProcessBundle bundle, OBError message) {
    ConnectionProvider conn = bundle.getConnection();
    try {
      // Process ssfc_credit_limit_control
      org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
          .get(org.openbravo.model.ad.ui.Process.class, "3C6EE8D28EFE470C8DAB7FC1CF9504D8");
//      logger.log("Llamo al procesoOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
//      final ProcessInstance pInstance = CallProcess.getInstance().call(process.getProcedure(), "", null);
      final List<Object> parameters = new ArrayList<Object>();
      parameters.add("12132131313213213131");
//      parameters.add(organization.getId().toString());
      final String procedureName = "ssfc_credit_limit_control";
      CallStoredProcedure.getInstance().call(procedureName, parameters, null, true,
              false);
      logger.log("PROCESO EJECUTADO CORRECTAMENTE");

    } catch (final Exception e) {
      e.printStackTrace(System.err);
      logger.log("PROCESO INCORRECTO");
    } finally {
      bundle.setResult(message);
    }
  }

}
