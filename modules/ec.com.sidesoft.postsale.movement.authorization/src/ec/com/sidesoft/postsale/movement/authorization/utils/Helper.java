package ec.com.sidesoft.postsale.movement.authorization.utils;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.poc.EmailManager;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.service.db.DalConnectionProvider;
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

	static public String executeSql(String functionName, String recordId, String type, BigDecimal qty) {
		String result = null;
		ConnectionProvider conn = new DalConnectionProvider(false);
		PreparedStatement st = null;
		try {
			User user = OBContext.getOBContext().getUser();
			String userId = user.getId();
			String sql = "SELECT " + functionName + "(?,?,?,?) result";
			st = conn.getPreparedStatement(sql);
			st.setString(1, recordId);
			st.setString(2, userId);
			st.setString(3, type);
			st.setBigDecimal(4, qty);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				result = rs.getString("result");
			}

			rs.close();
			st.close();
		} catch (Exception e) {
			throw new OBException(e);
		} finally {
			try {
				conn.releasePreparedStatement(st);
				conn.destroy();
			} catch (Exception ex) {
				throw new OBException(ex);
			}
		}
		return result;
	}
}
