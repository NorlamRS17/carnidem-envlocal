package ec.com.sidesoft.carnidem.production.maintenance.ad_process;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.manufacturing.maintenance.MainteanceOrder;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;


public class scma_processmaintenace extends DalBaseProcess {
  OBError message;
  protected void doExecute(ProcessBundle bundle) throws Exception {
    String recordId = (String) bundle.getParams().get("MA_Maint_Part_ID"); // cambia por tu ID real

    // Obtiene el objeto
    MainteanceOrder entidad = OBDal.getInstance().get(MainteanceOrder.class, recordId);
    if (entidad != null) {
      entidad.setScmaDocstatus("AP");
      OBDal.getInstance().save(entidad);
      OBDal.getInstance().flush();
    }
  }
}
