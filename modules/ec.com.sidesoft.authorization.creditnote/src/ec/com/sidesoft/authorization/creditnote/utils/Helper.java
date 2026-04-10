package ec.com.sidesoft.authorization.creditnote.utils;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.poc.EmailManager;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.utils.FormatUtilities;

abstract public class Helper {

	static public EmailServerConfiguration getEmailServerConfig() {
		EmailServerConfiguration config = null;
		try {
			OBCriteria<EmailServerConfiguration> configList = OBDal.getInstance()
					.createCriteria(EmailServerConfiguration.class);
			configList.add(Restrictions.eq(EmailServerConfiguration.PROPERTY_ACTIVE, true));
			configList.uniqueResult();

			if (configList.list().size() > 0) {
				config = configList.list().get(0);
			}
		} catch (Exception e) {
			System.out.println("getEmailServerConfig: " + e.getMessage());
		}
		return config;
	}

	static public void sendEmail(EmailServerConfiguration emailServerConfig, String subject, String body, String footer,
			List<File> attachments, String addressee) {
		try {
			String host = emailServerConfig.getSmtpServer();
			boolean auth = true;
			String username = emailServerConfig.getSmtpServerAccount();
			String password = FormatUtilities.encryptDecrypt(emailServerConfig.getSmtpServerPassword(), false);
			String connSecurity = emailServerConfig.getSmtpConnectionSecurity();
			int port = emailServerConfig.getSmtpPort().intValue();
			String senderAddress = emailServerConfig.getSmtpServerSenderAddress();

			String contentType = "text/html; charset=utf-8";
			String content = "<html> \n" + "<head> \n" + "<meta charset=\"UTF-8\">  \n" + "</head> \n" + "<body> \n"
					+ body + footer + "<br><br> \n" + "</body> \n" + "</html> \n";

			EmailManager.sendEmail(host, auth, username, password, connSecurity, port, senderAddress, addressee,
					addressee, addressee, addressee, subject, content, contentType, attachments, new Date(), null);
		} catch (Exception e) {
			throw new OBException("sendEmail: " + e.getMessage());
		}
	}
	
	static public String generateCode() {
	    Random random = new Random();
	    String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String code = "";
	    int m = 0, pos = 0, num;
	    while (m < 1) {
	      pos = (int) (random.nextDouble() * seed.length() - 1 + 0);
	      num = (int) (random.nextDouble() * 9999 + 100);
	      code = code + seed.charAt(pos) + num;
	      pos = (int) (random.nextDouble() * seed.length() - 1 + 0);
	      code = code + seed.charAt(pos);
	      m++;
	    }
	    return code;
	  }

}
