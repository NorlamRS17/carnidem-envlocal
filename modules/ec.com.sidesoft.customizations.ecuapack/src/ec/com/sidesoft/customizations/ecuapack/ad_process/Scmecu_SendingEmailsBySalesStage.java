package ec.com.sidesoft.customizations.ecuapack.ad_process;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.poc.EmailManager;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.utils.FormatUtilities;

public class Scmecu_SendingEmailsBySalesStage extends DalBaseProcess implements KillableProcess {

	private static final Logger log4j = Logger.getLogger(Scmecu_SendingEmailsBySalesStage.class);
	private static ProcessLogger logger;
	private boolean killProcess = false;

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		ConnectionProvider conn = new DalConnectionProvider(false);
		try {
			OBContext.setAdminMode(true);
			logger = bundle.getLogger();
			log4j.info("Begin SendingEmailsBySalesStage");

			EmailServerConfiguration emailServerConfig = getEmailServerConfig();
			if (emailServerConfig == null) {
				throw new OBException("No existe configuracion del servidor para envio de email");
			}
			ScmecuPendingEmailData[] pendingEmail = ScmecuPendingEmailData.select(conn);
			for (ScmecuPendingEmailData record : pendingEmail) {
				if (killProcess) {
					throw new OBException("Process killed");
				}

				try {
					if (!record.email.isEmpty()) {
						List<File> attachments = new ArrayList<File>();
						String addressee = record.email;
						String subject = "Oportunidad " + record.documentNo + " actualizada";
						String body = "Se ha modificado la oportunidad <b>" + record.opportunityName
								+ "</b> de numero <b>" + record.documentNo + "</b>, el estado de la venta es <b>"
								+ record.salesStage + "</b>, realizar las gestiones respectivas.";
						String footer = "";

						String result = null;
						try {
							sendEmail(emailServerConfig, subject, body, footer, attachments, addressee);
						} catch (Exception e) {
							result = getErrorMessage(e);
							logger.logln(result);
						}

						ScmecuPendingEmailData.update(conn, result == null ? "Y" : "N", result, record.id);
						conn.getConnection().commit();
					}
				} catch (Exception e) {
					conn.getConnection().rollback();
					String message = getErrorMessage(e);
					logger.logln(message);
				}
			}
		} catch (Exception e) {
			String message = getErrorMessage(e);
			logger.logln(message);
		} finally {
			try {
				conn.getConnection().close();
				conn.destroy();
			} catch (Exception e) {
				String message = getErrorMessage(e);
				logger.logln(message);
			}
			OBContext.restorePreviousMode();
			log4j.info("Finish SendingEmailsBySalesStage");
		}
	}

	@Override
	public void kill(ProcessBundle processBundle) throws Exception {
		System.out.println("kill");
		OBDal.getInstance().flush();
		this.killProcess = true;
	}

	private EmailServerConfiguration getEmailServerConfig() {
		EmailServerConfiguration config = null;

		OBCriteria<EmailServerConfiguration> configList = OBDal.getInstance()
				.createCriteria(EmailServerConfiguration.class);
		configList.add(Restrictions.eq(EmailServerConfiguration.PROPERTY_ACTIVE, true));
		configList.uniqueResult();

		if (configList.list().size() > 0) {
			config = configList.list().get(0);
		}

		return config;
	}

	private void sendEmail(EmailServerConfiguration emailServerConfig, String subject, String body, String footer,
			List<File> attachments, String addressee) throws Exception {

		String host = emailServerConfig.getSmtpServer();
		boolean auth = true;
		String username = emailServerConfig.getSmtpServerAccount();
		String password = FormatUtilities.encryptDecrypt(emailServerConfig.getSmtpServerPassword(), false);
		String connSecurity = emailServerConfig.getSmtpConnectionSecurity();
		int port = emailServerConfig.getSmtpPort().intValue();
		String senderAddress = emailServerConfig.getSmtpServerSenderAddress();

		String contentType = "text/html; charset=utf-8";
		String content = "<html> \n" + "<head> \n" + "<meta charset=\"UTF-8\">  \n" + "</head> \n" + "<body> \n" + body
				+ footer + "<br><br> \n" + "</body> \n" + "</html> \n";

		EmailManager.sendEmail(host, auth, username, password, connSecurity, port, senderAddress, addressee, addressee,
				addressee, addressee, subject, content, contentType, attachments, new Date(), null);

	}

	private String getErrorMessage(Exception e) {
		Throwable throwable = DbUtility.getUnderlyingSQLException(e);
		String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
		log4j.error(message);
		return message;
	}

}
