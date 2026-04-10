package ec.com.sidesoft.workorder.notifications.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.poc.EmailManager;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.FormatUtilities;

import com.atrums.indumoto.postventa.data.atindpo_postventa;

import ec.com.sidesoft.hrm.payroll.payment.rol.SSPRPRConfig;
import ec.com.sidesoft.workorder.notifications.SSWONConfig;
import ec.com.sidesoft.workorder.notifications.SSWONStatusReport;
import ec.com.sidesoft.workorder.simplified.SswosBinnacle;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

abstract public class Helper {

	static public SSWONConfig getEmailConfig() {
		SSWONConfig config = null;
		try {
			OBCriteria<SSWONConfig> configList = OBDal.getInstance().createCriteria(SSWONConfig.class);
			configList.add(Restrictions.eq(SSPRPRConfig.PROPERTY_ACTIVE, true));
			configList.uniqueResult();

			if (configList.list().size() > 0) {
				config = configList.list().get(0);
			}
		} catch (Exception e) {
			System.out.println("getConfig: " + e.getMessage());
		}
		return config;
	}

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

	static public List<atindpo_postventa> getServiceOrders(String dateFrom) {
		List<atindpo_postventa> serviceOrders = new ArrayList<atindpo_postventa>();
		
		ConnectionProvider conn = new DalConnectionProvider(false);
		PreparedStatement st = null;

		try {
			String sql = " SELECT pv.atindpo_postventa_id " + 
					" FROM atindpo_postventa pv " + 
					" JOIN sswon_status_report sr ON sr.docstatus = pv.docstatus AND sr.isactive='Y'" + 
					" LEFT JOIN sswos_binnacle b ON b.atindpo_postventa_id = pv.atindpo_postventa_id AND b.em_sswon_emailsent = 'Y' AND COALESCE(b.status_to, b.status_from) = pv.docstatus " + 
					" WHERE pv.fecha >= ?::DATE AND COALESCE(pv.email,'') != '' " + 
					" GROUP BY pv.atindpo_postventa_id " + 
					" HAVING COUNT(b.sswos_binnacle_id) = 0; ";

			st = conn.getPreparedStatement(sql);
			st.setString(1, dateFrom);
			ResultSet rs = st.executeQuery();

			String id = null;
			atindpo_postventa pv = null;
			while (rs.next()) {
				id = rs.getString("atindpo_postventa_id");
				pv = OBDal.getInstance().get(atindpo_postventa.class, id);
				serviceOrders.add(pv);
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println("getServiceOrders: " + e.getMessage());
		} finally {
			try {
				conn.releasePreparedStatement(st);
				conn.destroy();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		
		return serviceOrders;
	}

	static public boolean updateBinnacle(atindpo_postventa serviceOrder) {
		boolean result = true;
		try {
			OBCriteria<SswosBinnacle> binnacles = OBDal.getInstance().createCriteria(SswosBinnacle.class);
			binnacles.add(Restrictions.eq(SswosBinnacle.PROPERTY_ATINDPOPOSTVENTA, serviceOrder));
			binnacles.add(Restrictions.eq(SswosBinnacle.PROPERTY_FINALSTATUS, serviceOrder.getDocumentStatus()));
			if (binnacles.list().size() > 0) {
				SswosBinnacle binnacle;
				for (int i = 0; i < binnacles.list().size(); i++) {
					binnacle = binnacles.list().get(i);
					binnacle.setSswonEmailSent(true);
					OBDal.getInstance().save(binnacle);
				}
				OBDal.getInstance().flush();
			}
		} catch (Exception e) {
			System.out.println("updateBinnacle: " + e.getMessage());
			result = false;
		}
		return result;
	}

	static public List<Invoice> getInvoices(String dateFrom) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		
		ConnectionProvider conn = new DalConnectionProvider(false);
		PreparedStatement st = null;

		try {
			String sql = " SELECT i.c_invoice_id " + 
					" FROM c_invoice i " + 
					" JOIN c_order o ON o.c_order_id = i.c_order_id " + 
					" JOIN c_bpartner bp ON bp.c_bpartner_id = i.c_bpartner_id " + 
					" JOIN atindpo_postventa pv ON pv.em_sswos_c_order_id = o.c_order_id AND pv.fecha >= ?::DATE " + 
					" WHERE i.docstatus = 'CO' AND i.em_sswon_sent_email = 'N' AND COALESCE(bp.em_eei_email,'') != ''; ";

			st = conn.getPreparedStatement(sql);
			st.setString(1, dateFrom);
			ResultSet rs = st.executeQuery();

			String id = null;
			Invoice i = null;
			while (rs.next()) {
				id = rs.getString("c_invoice_id");
				i = OBDal.getInstance().get(Invoice.class, id);
				invoices.add(i);
			}
			
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println("getInvoices: " + e.getMessage());
		} finally {
			try {
				conn.releasePreparedStatement(st);
				conn.destroy();
			} catch (Exception ignore) {
				ignore.printStackTrace();
			}
		}
		
		return invoices;
	}

	static public List<SSWONStatusReport> getStatusReport(SSWONConfig emailConfig, String status) {
		List<SSWONStatusReport> statusReport = new ArrayList<SSWONStatusReport>();
		try {
			OBCriteria<SSWONStatusReport> statusReportList = OBDal.getInstance()
					.createCriteria(SSWONStatusReport.class);
			statusReportList.add(Restrictions.eq(SSWONStatusReport.PROPERTY_ACTIVE, true));
			statusReportList.add(Restrictions.eq(SSWONStatusReport.PROPERTY_SSWONCONFIG, emailConfig));

			if (statusReportList.list().size() > 0) {
				statusReport = statusReportList.list();
			}
		} catch (Exception e) {
			System.out.println("getStatusReport: " + e.getMessage());
		}
		return statusReport;
	}

	static public File createReport(String recordId, String sourcePath, String attachPath, String filePath,
			SSWONStatusReport setting) {
		File fileReport = null;
		try {
			final ConnectionProvider conn = new DalConnectionProvider(false);
			final Connection connDB = conn.getTransactionConnection();
			User user = OBContext.getOBContext().getUser();
			final String baseDesign = sourcePath + "/modules/" + setting.getModuleName() + "/src";
			final String baseWeb = sourcePath + "/modules/" + setting.getModuleName() + "/web";

			// Path del attachment
			final String path = attachPath + File.separator + filePath;
			final String outputFile = path + File.separator + setting.getName() + ".pdf";

			File file = new File(path);
			if (!file.exists()) {
				if (!file.mkdirs()) {
					throw new OBException("Error al intentar crear el directorio " + file.getAbsolutePath());
				}
			}

			String templateFullPath = baseDesign + setting.getTemplatePath() + setting.getTemplateName();

			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("DOCUMENT_ID", recordId);
			parameters.put("AD_USER_ID", user.getId());
			parameters.put("BASE_DESIGN", baseDesign);
			parameters.put("BASE_WEB", baseWeb);
			parameters.put("SOURCE_PATH", attachPath);
			parameters.put("REPORT_CONNECTION", connDB);
			parameters.put("PREFIX", "SSWON");

			JasperReport report = JasperCompileManager.compileReport(templateFullPath);
			JasperPrint print = JasperFillManager.fillReport(report, parameters, connDB);
			JasperExportManager.exportReportToPdfFile(print, outputFile);

			fileReport = new File(outputFile);

			connDB.close();
			conn.destroy();
		} catch (Exception e) {
			throw new OBException("createReport: " + e.getMessage());
		}

		return fileReport;
	}

}
