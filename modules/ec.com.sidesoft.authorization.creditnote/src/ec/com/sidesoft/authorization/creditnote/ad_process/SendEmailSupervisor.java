package ec.com.sidesoft.authorization.creditnote.ad_process;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DbUtility;

import ec.com.sidesoft.authorization.creditnote.utils.Helper;

public class SendEmailSupervisor extends DalBaseProcess {
	private static final Logger log4j = Logger.getLogger(SendEmailSupervisor.class);
	private static ProcessLogger logger;

	@Override
	public void doExecute(ProcessBundle bundle) throws Exception {
		OBError msg = new OBError();
		try {
			OBContext.setAdminMode(true);
			logger = bundle.getLogger();

			// Consultamos si existe configuracion para enviar correos
			EmailServerConfiguration emailServerConfig = Helper.getEmailServerConfig();
			if (emailServerConfig == null) {
				throw new OBException("No existe configuracion del servidor para envio de email");
			}

			final String orderId = (String) bundle.getParams().get("C_Order_ID");
			Order order = OBDal.getInstance().get(Order.class, orderId);

			DocumentType docType = order.getTransactionDocument();
			if (!docType.isSathncAuthRequired()) {
				throw new OBException("La transacción no requiere autorización");
			}

			List<OrderLine> orderLines = order.getOrderLineList();
			if (orderLines.size() == 0) {
				throw new OBException("No se encontraron líneas");
			}

			Organization org = order.getOrganization();
			BusinessPartner supervisor = org.getSathncSupervisor();
			if (supervisor == null) {
				throw new OBException("No se encontró supervisor configurado para la organización " + org.getName());
			}

			OBCriteria<User> userQuery = OBDal.getInstance().createCriteria(User.class);
			userQuery.add(Restrictions.eq(User.PROPERTY_ACTIVE, true));
			userQuery.add(Restrictions.eq(User.PROPERTY_BUSINESSPARTNER, supervisor));

			List<User> users = userQuery.list();
			List<String> addresseeList = new ArrayList<String>();
			for (User user : users) {
				if (user.getEmail() != null && !user.getEmail().trim().isEmpty()) {
					addresseeList.add(user.getEmail().trim());
				}
			}

			if (addresseeList.size() == 0) {
				throw new OBException("No se encontraron supervisores con correo configurado");
			}

			String code = Helper.generateCode();

			// Preparamos el correo
			String subject = "Código de autorización para generar nota de crédito";
			String body = "<html><body>" + "<p>Estimado Colaborador. <br><br> " + "El local <strong>" + org.getName()
					+ "</strong>" + " ha solicitado autorización para generar una nota de crédito "
					+ "con número de documento <strong>" + order.getDocumentNo() + "</strong>. <br><br>"
					+ "El código de autorización es: <strong>" + code + "</strong></p>";
			// body += "<p>Su clave caducará en el transcurso de 6 minutos.";
			body += "<p>Los productos son:</p>";
			body += "<table border=\"1\" style=\"width:100%\">";
			body += "<thead><tr>";
			body += "<th>CODIGO</th>";
			body += "<th>PRODUCTO</th>";
			body += "<th>CANTIDAD</th>";
			body += "</tr></thead>";
			body += "<tbody>";
			for (OrderLine orderLine : orderLines) {
				body += "<tr>";
				body += "<td width=\"20%\">" + orderLine.getProduct().getSearchKey().trim() + "</td>";
				body += "<td width=\"60%\">" + orderLine.getProduct().getName().trim() + "</td>";
				body += "<td width=\"20%\" align=\"center\">"
						+ orderLine.getOrderedQuantity().setScale(2, BigDecimal.ROUND_HALF_UP) + "</td>";
				body += "</tr>";
			}
			body += "</tbody>";
			body += "</table>";
			body += "  </body></html>";
			String footer = "";

			for (String addressee : addresseeList) {
				try {
					Helper.sendEmail(emailServerConfig, subject, body, footer, new ArrayList<File>(), addressee);
				} catch (Exception e) {
					throw new OBException("Error al enviar el email al correo " + addressee + ". " + e.getMessage());
				}
			}

			order.setSathncCode(code);
			order.setSathncCodeDate(new Date());
			OBDal.getInstance().save(order);
			OBDal.getInstance().flush();

			msg.setType("Success");
			msg.setTitle(OBMessageUtils.messageBD("@Success@"));
		} catch (final Exception e) {
			log4j.error("SendPrefecture: ", e);
			Throwable ex = DbUtility.getUnderlyingSQLException(e);
			String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage(message);
		} finally {
			bundle.setResult(msg);
		}
	}

}
