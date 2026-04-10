package ec.com.sidesoft.debit.collection.ad_backgrounds;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;

import ec.com.sidesoft.debit.collection.actionHandler.Sdc_ProcessActionHandler;

public class ProcessCollectionProposals extends DalBaseProcess implements KillableProcess {

  private static final Logger log4j = Logger.getLogger(ProcessCollectionProposals.class);
  private static ProcessLogger logger;
  private boolean killProcess = false;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {

    try {
      OBContext.setAdminMode(true);
      logger = bundle.getLogger();

      if (killProcess) {
        throw new OBException("Process killed");
      }
      JSONArray headlst = getHeadList();

      if (headlst.length() == 0) {
        logger.logln("doExecute: No se encontraron lineas para procesar");
      } else {
        for (int i = 0; i < headlst.length(); i++) {
          JSONObject head = headlst.getJSONObject(i);

          logger.logln("id: " + head.getString("id"));
          log4j.info("id: " + head.getString("id"));
          if (killProcess) {
            throw new OBException("Process killed");
          }
          HashMap<String, Object> parameters = new HashMap<String, Object>();
          JSONObject params = new JSONObject();
          JSONObject paramsObj = new JSONObject();
          paramsObj.put("condition",
              StringUtils.isNotBlank(head.getString("condition")) ? head.getString("condition")
                  : "ALL");
          paramsObj.put("fin_financial_account_id", head.getString("financial_account_id"));
          params.put("SDC_Debitcollect_ID", head.getString("id"));
          params.put("_params", paramsObj);

          JSONObject result = new Sdc_ProcessActionHandler().doExecute(parameters,
              params.toString());
          logger.logln("result: " + result.toString());
          log4j.info("id: " + result.toString());
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      logger.logln("doExecute: " + e.getMessage());
      log4j.info("doExecute: " + e.getMessage());
      throw new OBException(e.getMessage());
    } finally {
      OBContext.setAdminMode(false);
    }
  }

  @Override
  public void kill(ProcessBundle processBundle) throws Exception {
    log4j.info("kill process ProcessCollectionProposals");
    logger.logln("kill process ProcessCollectionProposals");
    OBDal.getInstance().flush();
    this.killProcess = true;
  }

  private JSONArray getHeadList() throws JSONException {
    final StringBuilder hqlString = new StringBuilder();
    JSONArray result = new JSONArray();

    hqlString.append(" SELECT h.id, fINFinancialAccountFile.id,h.condition");
    hqlString.append(" FROM sdc_debitcollect h");
    hqlString.append(" WHERE isbulkupload='Y'");
    hqlString.append(" AND h.active='Y'");
    hqlString.append(" AND h.status='DR'");
    hqlString.append(" AND NOT EXISTS (");
    hqlString.append(" SELECT 1 FROM sdc_dc_propocollect WHERE sDCDebitcollect.id = h.id");
    hqlString.append(" )");

    final Session session = OBDal.getInstance().getSession();
    final Query query = session.createQuery(hqlString.toString());

    for (Object resultObject : query.list()) {
      if (resultObject != null && resultObject.getClass().isArray()) {
        final Object[] values = (Object[]) resultObject;
        JSONObject empty = new JSONObject();
        empty.put("id", (String) values[0]);
        empty.put("financial_account_id", (String) values[1]);
        empty.put("condition", (String) values[2]);
        result.put(empty);
      }
    }
    return result;
  }

}
