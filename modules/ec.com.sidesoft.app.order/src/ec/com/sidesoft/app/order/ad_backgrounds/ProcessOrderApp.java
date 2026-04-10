package ec.com.sidesoft.app.order.ad_backgrounds;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.app.order.SsapporLog;

public class ProcessOrderApp extends DalBaseProcess implements KillableProcess {

	private static final Logger log4j = Logger.getLogger(ProcessOrderApp.class);
	private static ProcessLogger logger;
	private boolean killProcess = false;

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {

		VariablesSecureApp vars = bundle.getContext().toVars();
		ConnectionProvider conn = new DalConnectionProvider(false);
		String language = OBContext.getOBContext().getLanguage().getLanguage();

		try {
			OBContext.setAdminMode(true);
			logger = bundle.getLogger();

			OBCriteria<SsapporLog> crtlines = OBDal.getInstance().createCriteria(SsapporLog.class);
			crtlines.add(Restrictions.eq(SsapporLog.PROPERTY_ISGENERATE, false));

			if (crtlines.count() == 0) {
				logger.logln("doExecute: " + "No se encontraron lineas para procesar");
			} else {
				for (SsapporLog ssapporLog : crtlines.list()) {
					if (killProcess) {
						throw new OBException("Process killed");
					}

					ProcessBundle pb = new ProcessBundle("B88EEB979B6E4F92BAE22165681CA4AA",
							RequestContext.get().getVariablesSecureApp()).init(conn);
					HashMap<String, Object> params = new HashMap<String, Object>();

					params.put("Ssappor_Log_ID", ssapporLog.getId().toString());
					pb.setParams(params);
					OBError myMessage = null;
					try {
						new ProcessRunner(pb).execute(conn);
						myMessage = (OBError) pb.getResult();
						String msg = Utility.parseTranslation(conn, vars, language, myMessage.getMessage());
						if (!msg.isEmpty()) {
							logger.logln("doExecute: " + msg);
						}
					} catch (Exception ex) {
						log4j.error(ex);
					}
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
		log4j.info("kill process ProcessOrderApp");
		logger.logln("kill process ProcessOrderApp");
		OBDal.getInstance().flush();
		this.killProcess = true;
	}

}
