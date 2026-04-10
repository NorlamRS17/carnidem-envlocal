package ec.com.sidesoft.crm.visitplan.ad_process;

import org.apache.log4j.Logger;
import org.openbravo.dal.core.OBContext;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import ec.com.sidesoft.crm.visitplan.Scrvro_RouteWeek;

public class Scrvro_CreateRoute extends DalBaseProcess {
  private final Logger log4j = Logger.getLogger(Scrvro_RouteWeek.class);

  @Override
  public void doExecute(ProcessBundle bundle) throws Exception {
    OBContext.setAdminMode(true);

    try {
      // Parametros
      final String recordId = (String) bundle.getParams().get("Scrvro_Route_Week_ID");
      System.out.println(recordId);
    } catch (final Exception e) {
      // OBDal.getInstance().rollbackAndClose();
      log4j.error("Exception found in Scrvro_CreateRoute process: ", e);
    } finally {
      OBContext.setAdminMode(false);
    }
  }

}
