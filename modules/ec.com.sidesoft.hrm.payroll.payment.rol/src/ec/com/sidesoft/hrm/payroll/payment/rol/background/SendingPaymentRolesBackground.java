package ec.com.sidesoft.hrm.payroll.payment.rol.background;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.FormatUtilities;
import javax.mail.Session;

import ec.com.sidesoft.hrm.payroll.payment.rol.ad_process.SSPRPR_PrintReportPaymentRol;
import ec.com.sidesoft.hrm.payroll.payment.rol.SSPRPRConfig;
import ec.com.sidesoft.hrm.payroll.payment.rol.utility.EmailManager;

public class SendingPaymentRolesBackground extends DalBaseProcess implements KillableProcess {

	private static final Logger log4j = Logger.getLogger(SendingPaymentRolesBackground.class);
	private static ProcessLogger loggerbg;
	private VariablesSecureApp vars;
	String msgTitle = "";
	String msgMessage = "";
	String msgType = ""; // success, warning or error
	public ConfigParameters cf;
	private static String strAttachment;
	private static String strFTP;
	private static Connection connectionDB = null;
	private String configBody = "";
	private String configFooter = "";
	private String configSubject = "";
	private String reportFormat = "";
	private String routeReport = "";
	private boolean killProcess = false;
	private String nombreArchivo = "";
	private String cedulaEmpleado = "";
	private String nombreEmpleado = "";
	private String fechanomina = "";
	private String IDEmpleado = "";
	private String documentno = "";
	private String strADUSerID;

	// Pool de sesión SMTP
	private static Session mailSession;

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		loggerbg = bundle.getLogger();

		ConnectionProvider conn = new DalConnectionProvider(false);
		String language = OBContext.getOBContext().getLanguage().getLanguage();
		OBError result = new OBError();

		JSONArray mounthlyPayrollList = null;

		try {
			OBContext.setAdminMode(true);

			// Obtenemos la configuracion de OB
			cf = bundle.getConfig();
			result.setType("Error");
			result.setTitle(OBMessageUtils.messageBD("Error"));

			try {
				connectionDB = conn.getTransactionConnection();
			} catch (Exception e) {
				log4j.error("Error obteniendo conexión de transacción", e);
				throw new OBException("Error:", e);
			}

			// Se verifica que exista una configuracion para el envio de roles de pago
			OBCriteria<SSPRPRConfig> config = OBDal.getInstance().createCriteria(SSPRPRConfig.class);
			config.add(Restrictions.eq(SSPRPRConfig.PROPERTY_ACTIVE, true));
			config.addOrderBy(SSPRPRConfig.PROPERTY_CREATIONDATE, false);
			config.setMaxResults(1);

			if (config.list() != null && config.list().size() > 0) {
				vars = bundle.getContext().toVars();
				// Creamos variables para el envio del mensaje
				String host , username, password, connSecurity, senderAddress;
				Boolean auth = true;
				int port;

				// Obtenemos el correo configurado para el envio
				EmailServerConfiguration mailConfig = null;
				try {
					OBCriteria<EmailServerConfiguration> EmailServerConfiguration2 = OBDal.getInstance()
							.createCriteria(EmailServerConfiguration.class);

					EmailServerConfiguration2.add(Restrictions.eq(EmailServerConfiguration.PROPERTY_ACTIVE, true));
					EmailServerConfiguration2.setMaxResults(1);

					if (EmailServerConfiguration2.list().size() == 0) {
						throw new OBException(
								"Error Configuración correo electrónico - No esta configurado el correo electrónico para la entidad.");
					} else {
						mailConfig = (EmailServerConfiguration) EmailServerConfiguration2.uniqueResult();
					}

				} catch (Exception exception) {
					throw new OBException("Error Recuperando datos para correo de la entidad.");
				}

				host = mailConfig.getSmtpServer();
				if (!mailConfig.isSMTPAuthentification()) {
					auth = false;
				}

				username = mailConfig.getSmtpServerAccount();
				password = FormatUtilities.encryptDecrypt(mailConfig.getSmtpServerPassword(), false);
				connSecurity = mailConfig.getSmtpConnectionSecurity();
				port = mailConfig.getSmtpPort().intValue();
				senderAddress = mailConfig.getSmtpServerAccount();

				// Inicialización del pool de sesión SMTP solo una vez
				mailSession = EmailManager.getSessionMail(host, auth, username, password, connSecurity, port);

				if (mailSession == null) {
					throw new OBException("No logro hacer el pool para la sesion SMTP.");
				}

				strAttachment = cf.getBaseDesignPath() + "/design/";
				strFTP = cf.strFTPDirectory;

				configBody = config.list().get(0).getBody().trim();
				configFooter = config.list().get(0).getFooter().trim();
				configSubject = config.list().get(0).getSubject();
				reportFormat = config.list().get(0).getReportformat().trim();

				// Se obtienen las nominas mensuales para el proceso de envio
				mounthlyPayrollList = getMonthlyPayroll(conn);
				ArrayList<String> arrayUpdateNomina = new ArrayList<String>();
				ArrayList<String> arrayDetNomina = new ArrayList<String>();

				if (mounthlyPayrollList != null && mounthlyPayrollList.length() != 0) {
					JSONObject data = new JSONObject();
					int countPayroll = 0;
					int countPayrollTicket = 0;
					int countPayrollTicketEr = 0;
					String strDetNomina = "";

					// Se comienza el proceso para el envio de los roles de pago
					for (int i = 0; i < mounthlyPayrollList.length(); i++) {
						if (killProcess) {
							arrayUpdateNomina.clear();
							throw new OBException("Process killed");
						}
						
						data = (JSONObject) mounthlyPayrollList.get(i);
						arrayUpdateNomina.add(data.getString("nominaid"));
						arrayDetNomina.add(data.getString("documentno"));
						
						try {
							generatePDFAndSendMail(data, mailSession, senderAddress);

							//Envio exitoso
							updateFieldPayrollTicket(data.getString("boletaid"), "Y", null, conn);
							countPayrollTicket = countPayrollTicket + 1;
						} catch (Exception e) {
							//Error al enviar
							String log_msg = "Error - No se logró enviar el rol de pago del empleado "
									+ data.getString("empleadonombre") + " con correo " + data.getString("correo")
									+ " por el siguiente motivo: " + e.getMessage() + ".";			
							updateFieldPayrollTicket(data.getString("boletaid"), "N", log_msg, conn);
							countPayrollTicketEr = countPayrollTicketEr + 1;
							continue;
						}
					}
					
					//Se hace las actualizaciones a nominas
					ArrayList<String> newList = new ArrayList<String>();
					if (arrayUpdateNomina.size() > 0) {
						  newList = removeDuplicates(arrayUpdateNomina);
			              String strNominas = StringUtils.join(newList, "' , '");
			              strNominas = "'" + strNominas + "'";
			              updateFieldSendMaildPayroll(strNominas, conn);
			            }
					
					ArrayList<String> newListDet = new ArrayList<String>();
					if(arrayDetNomina.size() > 0) {
						newListDet = removeDuplicates(arrayDetNomina);
						strDetNomina = StringUtils.join(newListDet, " , ");
					}
					
					loggerbg.logln("Proceso ejecutado exitosamente. Correos enviados: " + countPayrollTicket + ".");
					loggerbg.logln("Proceso ejecutado exitosamente. Correos No enviados: " + countPayrollTicketEr + ".");
					loggerbg.logln("Proceso ejecutado exitosamente. Nominas procesadas: " + newList.size() + " (" + strDetNomina + ").");

				} else {
					arrayUpdateNomina.clear();
					loggerbg.logln("No existen nominas mensuales para enviar.");
				}

			} else {
				throw new OBException("No existe Configuracion para el proceso de Envío de roles de pago.");
			}
			
			connectionDB.close();
		    OBDal.getInstance().commitAndClose();
		} catch (Exception e) {
			result.setTitle(Utility.messageBD(conn, "Error", language));
			result.setType("Error");
			result.setMessage(e.getMessage());
			log4j.error(result.getMessage(), e);
			bundle.setResult(result);
			return;
		} finally {
			OBContext.restorePreviousMode();
			try {
				conn.destroy();
			} catch (Exception e) {

			}
		}
	}

	private void generatePDFAndSendMail(JSONObject data, Session mailSession, String senderAddres)
			throws Exception {

		cedulaEmpleado = data.getString("empleado");
		IDEmpleado = data.getString("empleadoid");
		nombreEmpleado = data.getString("empleadonombre");
		nombreArchivo = data.getString("nombrearchivo");
		documentno = data.getString("documentno");
		fechanomina = data.getString("fechanomina");
		routeReport = printReport();

		if (!routeReport.equals("")) {

			// Variables de Envio mensaje
			String contentType = "";
			String recipientTO = "";
			String emailSubject = null, emailBody = null;
			List<File> attachments = new ArrayList<File>();
			Boolean isFailed = true;

			// CORREO DEL EMPLEADO
			recipientTO = data.getString("correo");

			// RUTA DEL REPORTE GENERADO EN LOS ATTACHMENTS
			File file = new File(routeReport);
			attachments.add(file);

			// OBTENER EL MES EN LETRAS DE LA FECHA
			String[] mesAnioFechaNomina = fechanomina.split("/");
			String mesLetrasNomina = getMonthInLetters(mesAnioFechaNomina[0]);
			String formatoFechaNomina = mesLetrasNomina + " " + mesAnioFechaNomina[1];

			// SE GENERA EL DETALLE DEL CORREO
			emailSubject = configSubject;
			emailBody = "<html> \n" + "<head> \n" + "<meta charset=\"UTF-8\">  \n" + "</head> \n" + "<body> \n"
					+ configBody + " " + " ( <strong> " + formatoFechaNomina + " </strong> para <strong> "
					+ nombreEmpleado + " </strong>)</p>" + configFooter + "<br><br> \n" + "</body> \n" + "</html> \n";
			contentType = "text/html; charset=utf-8";

			try {
				EmailManager.sendEmail(senderAddres, recipientTO, recipientTO, recipientTO, recipientTO, emailSubject,
						emailBody, contentType, attachments, new Date(), null, mailSession);
				Thread.sleep(2000);
			} catch (Exception exception) {
				msgMessage = exception.toString();
				throw new OBException(msgMessage);
			} finally {
				// Delete the temporary files generated for the email attachments
				for (File attachment : attachments) {
					if (attachment.exists() && !attachment.isDirectory()) {
						attachment.delete();
					}
				}
			}

		} else {
			throw new OBException("No se genero el reporte para adjuntarlo en el correo.");
		}
	}

	private static void updateFieldSendMaildPayroll(String arrayIds, ConnectionProvider conn) {

		String strSql = "UPDATE SSPR_Payroll SET em_sspm_sentmail = 'Y' WHERE sspr_payroll_id IN(" + arrayIds + ")";

		int updateCount = 0;
		PreparedStatement st = null;

		try {
			st = conn.getPreparedStatement(strSql);
			updateCount = st.executeUpdate();
			st.close();
		} catch (Exception e) {
			loggerbg.logln("Error al acualizar el campo email enviado - Nominas Mensuales - " + e.getMessage());
			throw new OBException("Error al acualizar el campo email enviado - Nominas Mensuales - " + e.getMessage());
		} finally {
			try {
				conn.destroy();
			} catch (Exception e) {
			}
		}
	}
	
	private static void updateFieldPayrollTicket(String payrollTicketID, String emailSended, String error, ConnectionProvider conn) {

		String strSql = "UPDATE sspr_payroll_ticket SET em_ssprpr_issended = '" + emailSended + "', em_ssprpr_emaillog = '" + error + "' WHERE sspr_payroll_ticket_id = '" + payrollTicketID + "'";

		int updateCount = 0;
		PreparedStatement st = null;

		try {
			st = conn.getPreparedStatement(strSql);
			updateCount = st.executeUpdate();
			st.close();
		} catch (Exception e) {
			loggerbg.logln("Error al actualizar la Boleta de Nomina - Error:" + e.getMessage());
			throw new OBException("Error al actualizar la Boleta de Nomina - Error:" + e.getMessage());
		} finally {
			try {
				conn.destroy();
			} catch (Exception e) {
			}
		}
	}

	private static JSONArray getMonthlyPayroll(ConnectionProvider conn) {

		try {

			String strSql = null;
			strSql = "SELECT cb.value AS empleado, \n" + " cb.c_bpartner_id AS empleadoid, \n"
					+ " cb.name AS empleadonombre,  \n" + " TRIM(cb.em_sspr_email) AS correo, \n"
					+ " sp.documentno,  \n" + " TO_CHAR(p.startdate, 'MM/YYYY') AS fechanomina,  \n"
					+ " to_char(p.startdate,'MMYYYY') || '_' || cb.value || '.pdf' AS nombrearchivo, \n"
					+ " sp.sspr_payroll_id AS nominaid, \n" + " spt.sspr_payroll_ticket_id AS boletaid \n"
					+ " FROM sspr_payroll_ticket spt \n"
					+ " LEFT JOIN sspr_payroll sp ON sp.sspr_payroll_id = spt.sspr_payroll_id \n"
					+ " LEFT JOIN c_bpartner cb ON cb.c_bpartner_id = spt.c_bpartner_id \n"
					+ " LEFT JOIN c_period p ON p.c_period_id = sp.c_period_id \n" + " WHERE sp.ispayroll = 'Y' \n"
					+ " AND sp.em_sspm_sendmail = 'Y' \n" + " AND sp.em_sspm_sentmail = 'N' \n"
					+ " AND spt.em_ssprpr_issended = 'N' \n" + " AND cb.em_sspr_email IS NOT NULL \n";

			PreparedStatement st = null;

			st = conn.getPreparedStatement(strSql);
			ResultSet rsConsulta = st.executeQuery();
			ArrayList<String> strResult = new ArrayList<String>();
			strResult.clear();
			JSONArray array = new JSONArray();

			while (rsConsulta.next()) {

				array.put(new JSONObject().put("empleado", rsConsulta.getString("empleado"))
						.put("empleadoid", rsConsulta.getString("empleadoid"))
						.put("empleadonombre", rsConsulta.getString("empleadonombre"))
						.put("correo", rsConsulta.getString("correo"))
						.put("documentno", rsConsulta.getString("documentno"))
						.put("nombrearchivo", rsConsulta.getString("nombrearchivo"))
						.put("nominaid", rsConsulta.getString("nominaid"))
						.put("boletaid", rsConsulta.getString("boletaid"))
						.put("fechanomina", rsConsulta.getString("fechanomina")));

			}
			return array;

		} catch (Exception e) {
			throw new OBException("Error al buscar nominas mensuales - " + e.getMessage());
		}
	}

	public String printReport() {

		final HttpServletRequest request = RequestContext.get().getRequest();
		final HttpServletResponse response = RequestContext.get().getResponse();

		String strReport = "";
		strADUSerID = vars.getUser().toString();

		SSPRPR_PrintReportPaymentRol printReport = new SSPRPR_PrintReportPaymentRol();

		try {
			strReport = printReport.doPost(request, response, strAttachment, strFTP, connectionDB, reportFormat,
					nombreArchivo, cedulaEmpleado, IDEmpleado, documentno, strADUSerID);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

		return strReport;

	}

	public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

		ArrayList<T> newList = new ArrayList<T>();
		for (T element : list) {
			if (!newList.contains(element)) {
				newList.add(element);
			}
		}

		return newList;
	}

	private String getMonthInLetters(String numeroMes) {

		String mesLetras = "";
		int num = Integer.parseInt(numeroMes);
		String[] mes = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre",
				"Octubre", "Noviembre", "Diciembre" };
		mesLetras = mes[num - 1];

		return mesLetras;

	}

	@Override
	public void kill(ProcessBundle processBundle) throws Exception {
		OBDal.getInstance().flush();
		this.killProcess = true;
	}

}