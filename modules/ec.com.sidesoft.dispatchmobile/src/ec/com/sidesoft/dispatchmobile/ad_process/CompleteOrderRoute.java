package ec.com.sidesoft.dispatchmobile.ad_process;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBDateUtils;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.order.Order;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

public class CompleteOrderRoute extends DalBaseProcess {
  private static final Logger log4j = Logger.getLogger(CompleteOrderRoute.class);
  private ProcessLogger logger;
  String msgTitle = "";
  String msgMessage = "";
  String msgType = ""; // success, warning or error,Info
  public ConfigParameters cf;
  StringBuffer msg = new StringBuffer(); // default size 16

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {

    cf = bundle.getConfig();
    logger = bundle.getLogger();
    OBError result = new OBError();
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String dateTrxStr = (String) bundle.getParams().get("dateTrx");
    String route = (String) bundle.getParams().get("route");

    if (StringUtils.isBlank(dateTrxStr) || StringUtils.isBlank(route)) {
      throw new OBException("Fecha y Ruta son parametros obligatorios.");
    }

    try {
      OBContext.setAdminMode(false);
      Date dateTrx = OBDateUtils.getDate(dateTrxStr);
      OBCriteria<Order> orders = getOrders(route, dateTrx);
      if (orders.count() > 0) {
        for (Order order : orders.list()) {
          String resultCO = completeOrder(order);
          if (StringUtils.isNotBlank(resultCO)) {
            msg.append(resultCO + ".<br>");
          }
        }
      } else {
        msg.append("No hay pedidos por completar");
      }
      result.setType(StringUtils.isNotBlank(msg.toString()) ? "Info" : "Success");
      result.setTitle(
          OBMessageUtils.messageBD(StringUtils.isNotBlank(msg.toString()) ? "Error" : "Success"));
      result.setMessage(msg.toString());
    } catch (Exception e) {
      result.setTitle(Utility.messageBD(conn, "Error", language));
      result.setType("Error");
      result.setMessage(e.getMessage());
      log4j.error(result.getMessage(), e);
      logger.logln(result.getMessage());
      bundle.setResult(result);
      return;
    } finally {
      OBContext.restorePreviousMode();
      bundle.setResult(result);
      try {
        conn.destroy();
      } catch (Exception e) {

      }
    }

  }

  public static String completeOrder(Order order) {

    String message = "";
    try {
      OBContext.setAdminMode(true);
      org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
          .get(org.openbravo.model.ad.ui.Process.class, "104");
      Map<String, String> parameters = new HashMap<String, String>();
      parameters.put("C_Order_ID", order.getId());
      ProcessInstance pInstance = CallProcess.getInstance().call(process, order.getId(), null);
      if (pInstance.getResult() == 0) {
        OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
        message = oberror.getMessage();
      }

    } catch (Exception e) {
      // TODO: handle exception
      message = "error:" + e.getMessage().toString();
    } finally {
      OBContext.restorePreviousMode();
    }
    return StringUtils.isNotBlank(message) ? "Order [" + order.getDocumentNo() + "], " + message
        : "";
  }

  public OBCriteria<Order> getOrders(String route, Date dateTrx) {

    OBCriteria<Order> crtOrder = OBDal.getInstance().createCriteria(Order.class);
    crtOrder.add(Restrictions.eq(Order.PROPERTY_SALESTRANSACTION, true));
    crtOrder.add(Restrictions.eq(Order.PROPERTY_DOCUMENTSTATUS, "DR"));
    crtOrder.add(Restrictions.eq(Order.PROPERTY_ORDERDATE, dateTrx));
    crtOrder.add(Restrictions.eq(Order.PROPERTY_SSDPMDISPATCHERROUTE, route));
    crtOrder.setFilterOnReadableOrganization(false);

    return crtOrder;
  }

}
