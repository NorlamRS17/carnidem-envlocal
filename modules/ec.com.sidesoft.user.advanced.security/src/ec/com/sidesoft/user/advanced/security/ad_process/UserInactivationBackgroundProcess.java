package ec.com.sidesoft.user.advanced.security.ad_process;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.utils.FormatUtilities;
import ec.com.sidesoft.user.advanced.security.SsuasSecurityConfig;
import ec.com.sidesoft.user.advanced.security.SsuasExcludedUsers;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.model.ad.access.Session;
import org.openbravo.erpCommon.utility.poc.EmailManager;

public class UserInactivationBackgroundProcess extends DalBaseProcess implements KillableProcess {

	private static final Logger log4j = Logger.getLogger(UserInactivationBackgroundProcess.class);
	private boolean KillProcess = false;
	private static ProcessLogger logger;

	@Override
	public void doExecute(ProcessBundle bundle) throws Exception {

		log4j.debug("Inicio del proceso background UserInactivationBackgroundProcess");
		ConfigParameters cf = bundle.getConfig();
		logger = bundle.getLogger();
		OBError result = new OBError();
		String language = OBContext.getOBContext().getLanguage().getLanguage();

		OBContext.setAdminMode(true);

		List<String> deactivatedUsers = new ArrayList<>();

		try {
			OBCriteria<SsuasSecurityConfig> querySC = OBDal.getInstance().createCriteria(SsuasSecurityConfig.class);
			querySC.add(Restrictions.eq(SsuasSecurityConfig.PROPERTY_ACTIVE, true));
			List<SsuasSecurityConfig> securityConfig = querySC.list();

			if (securityConfig.isEmpty()) {
				logger.logln("No existe ninguna configuración de seguridad activa.");
				return;
			}

			SsuasSecurityConfig config = securityConfig.get(0);
			int daysAllowed = config.getInactivityDays().intValue();
			String emails = config.getNotificationEmail();

			if (daysAllowed == 0) {
				logger.logln("No se han configurado dias de inactividad permitidos.");
				return;
			}

			OBCriteria<SsuasExcludedUsers> queryEU = OBDal.getInstance().createCriteria(SsuasExcludedUsers.class);
			queryEU.add(Restrictions.eq(SsuasExcludedUsers.PROPERTY_ACTIVE, true));
			List<SsuasExcludedUsers> excludedUsers = queryEU.list();
			List<String> excludedUsernames = excludedUsers.stream().map(e -> e.getUserContact().getUsername())
					.collect(Collectors.toList());

			OBCriteria<Session> sessionCriteria = OBDal.getInstance().createCriteria(Session.class);
			List<Session> allSessions = sessionCriteria.list();

			Map<String, Session> latestSessionByUser = new HashMap<>();
			for (Session session : allSessions) {
				String username = session.getUsername();
				Date lastPing = session.getLastPing();

				if (username == null || lastPing == null) {
					continue;
				}

				Session existing = latestSessionByUser.get(username);
				if (existing == null || (existing.getLastPing() != null && lastPing.after(existing.getLastPing()))) {
					latestSessionByUser.put(username, session);
				}
			}

			Calendar now = Calendar.getInstance();

			for (Map.Entry<String, Session> entry : latestSessionByUser.entrySet()) {
				if (KillProcess) {
					throw new OBException("Proceso detenido por el usuario");
				}

				String username = entry.getKey();
				Session session = entry.getValue();

				if (session.getLastPing() == null || excludedUsernames.contains(username)) {
					continue;
				}

				Calendar lastPingCal = Calendar.getInstance();
				lastPingCal.setTime(session.getLastPing());

				long diffMillis = now.getTimeInMillis() - lastPingCal.getTimeInMillis();
				long diffDays = diffMillis / (24 * 60 * 60 * 1000);

				if (diffDays > daysAllowed) {
					OBCriteria<User> userCriteria = OBDal.getInstance().createCriteria(User.class);
					userCriteria.add(Restrictions.eq(User.PROPERTY_USERNAME, username));
					userCriteria.add(Restrictions.eq(User.PROPERTY_ACTIVE, true));
					List<User> users = userCriteria.list();

					if (!users.isEmpty()) {
						User user = users.get(0);
						if (user.isActive()) {
							user.setActive(false);
							OBDal.getInstance().save(user);
							deactivatedUsers.add(user.getUsername());
						}
					}
				}
			}

			if (!deactivatedUsers.isEmpty()) {
				if (emails != null && !emails.isEmpty()) {
					sendDeactivationEmail(deactivatedUsers, config, emails);

				}
				logger.logln("Usuarios desactivados: " + String.join(", ", deactivatedUsers));
			} else {
				logger.logln("No se desactivaron usuarios.");
			}

			result.setType("Success");
			result.setTitle("Success");

			OBDal.getInstance().flush();
			log4j.debug("Proceso background UserInactivationBackgroundProcess finalizado correctamente.");

		} catch (Exception e) {
			result.setType("Error");
			result.setMessage(e.getMessage());
			log4j.error(result.getMessage(), e);
			logger.logln(e.getMessage());
			bundle.setResult(result);
			return;
		} finally {
			bundle.setResult(result);
			OBContext.restorePreviousMode();
		}
	}

	private void sendDeactivationEmail(List<String> deactivatedUsers, SsuasSecurityConfig config, String emails) {

		try {
			OBCriteria<EmailServerConfiguration> emailConfigCriteria = OBDal.getInstance()
					.createCriteria(EmailServerConfiguration.class);
			emailConfigCriteria.add(Restrictions.eq(EmailServerConfiguration.PROPERTY_ACTIVE, true));
			emailConfigCriteria.setMaxResults(1);

			List<EmailServerConfiguration> emailConfigList = emailConfigCriteria.list();
			EmailServerConfiguration mailConfig = emailConfigList.isEmpty() ? null : emailConfigList.get(0);

			if (mailConfig == null) {
				logger.logln("No se encontro una configuración de correo activa.");
				return;
			}

			String host = mailConfig.getSmtpServer();
			boolean auth = mailConfig.isSMTPAuthentification();
			String username = mailConfig.getSmtpServerAccount();
			String password = FormatUtilities.encryptDecrypt(mailConfig.getSmtpServerPassword(), false);
			String connSecurity = mailConfig.getSmtpConnectionSecurity();
			int port = mailConfig.getSmtpPort().intValue();
			String senderAddress = mailConfig.getSmtpServerAccount();

//			javax.mail.Session mailSession = EmailManager.sendEmail(host, auth, username, password, connSecurity,
//					port);

			String recipientTO = emails;
			String subject = "ALERTA INACTIVIDAD SISTEMA";
			String body = "Los siguientes usuarios han sido desactivados del sistema Openbravo por superar los días de inactividad permitidos:\n\n";
			body += String.join("\n", deactivatedUsers);
			body += "\nDías inactivos: " + config.getInactivityDays() + " \nSolicitar la verificación del administrador al correo " + config.getNotificationEmail();

			EmailManager.sendEmail(host, auth, username, password, connSecurity, port, senderAddress, recipientTO,
					recipientTO, recipientTO, recipientTO, subject, body, "text/plain; charset=utf-8", null, new Date(),
					null);
			log4j.debug("Correo enviado a: " + recipientTO);
		} catch (Exception e) {
			log4j.error("Error al enviar el correo: ", e);
		}
	}

	@Override
	public void kill(ProcessBundle processBundle) throws Exception {
		OBDal.getInstance().flush();
		this.KillProcess = true;
	}
}
