package ec.com.sidesoft.postsale.movement.authorization.ad_process;

import java.io.File;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.EmailServerConfiguration;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;

import com.atrums.indumoto.postventa.data.atindpo_postventa;
import com.atrums.indumoto.postventa.data.atindpo_postventalinea;

import ec.com.sidesoft.postsale.movement.authorization.utils.Helper;
import ec.com.sidesoft.workorder.simplified.SswosSOTransfer;

public class TotalReturn extends DalBaseProcess {
	private static final Logger log4j = Logger.getLogger(TotalReturn.class);
	private static ProcessLogger logger;

	@Override
	public void doExecute(ProcessBundle bundle) throws Exception {
		OBError msg = new OBError();
		try {
			OBContext.setAdminMode(true);
			logger = bundle.getLogger();

			EmailServerConfiguration emailServerConfig = Helper.getEmailServerConfig();
			if (emailServerConfig == null) {
				throw new OBException("No existe configuracion del servidor para envio de email");
			}

			final String recordId = (String) bundle.getParams().get("Atindpo_Postventa_ID");
			atindpo_postventa record = OBDal.getInstance().get(atindpo_postventa.class, recordId);

			Organization org = record.getOrganization();

			OBCriteria<SswosSOTransfer> sosQuery = OBDal.getInstance().createCriteria(SswosSOTransfer.class);
			sosQuery.add(Restrictions.eq(User.PROPERTY_ACTIVE, true));
			sosQuery.add(Restrictions.eq(User.PROPERTY_ORGANIZATION, org));

			List<SswosSOTransfer> sosList = sosQuery.list();
			if (sosList.size() == 0) {
				throw new OBException(
						"No se encontró ningún registro en la configuración de orden de servicio para la organización "
								+ org.getName());
			}
			SswosSOTransfer sos = sosList.get(0);

			User whUser = sos.getSpsmvatWharehouseUser();
			if (whUser == null) {
				throw new OBException(
						"No se encontró ningún bodeguero en la configuración de orden de servicio para la organización "
								+ org.getName());
			}

			if (whUser.getEmail() == null || whUser.getEmail().trim().isEmpty()) {
				throw new OBException("El usuario " + whUser.getUsername() + " no tiene configurado ningún email");
			}
			String addressee = whUser.getEmail().trim();

			List<atindpo_postventalinea> recordLines = record.getAtindpoPostventalineaList();
			if (recordLines.size() == 0) {
				throw new OBException("No se encontraron líneas");
			}

			String result = Helper.executeSql("spsmvat_goodsmovement", recordId, "TR", null);
			String[] res = result.split(":");

			if (!res[0].equals("0")) {
				InternalMovement movement = OBDal.getInstance().get(InternalMovement.class, res[1]);

				String subject = "Solicitud de aprobación de movimiento";
				String body = "<html><body>" + "<p>Estimado Colaborador. <br><br> " + "El técnico <strong>"
						+ record.getMecnicoAsignado().getName() + "</strong> del local <strong>" + org.getName()
						+ "</strong>" + " ha solicitado la aprobación del movimiento "
						+ " con número de documento <strong>" + movement.getDocumentNo() + "</strong>.</p>";
				body += "<p>Los productos son:</p>";
				body += "<table border=\"1\" style=\"width:100%\">";
				body += "<thead><tr>";
				body += "<th>CODIGO</th>";
				body += "<th>PRODUCTO</th>";
				body += "<th>CANTIDAD</th>";
				body += "</tr></thead>";
				body += "<tbody>";
				for (atindpo_postventalinea line : recordLines) {
					if (line.getProduct().getProductType().equals("I") && line.getSpsmvatTransferStatus() == null) {
						body += "<tr>";
						body += "<td width=\"20%\">" + line.getProduct().getSearchKey().trim() + "</td>";
						body += "<td width=\"60%\">" + line.getProduct().getName().trim() + "</td>";
						body += "<td width=\"20%\" align=\"center\">" + line.getCantidad() + "</td>";
						body += "</tr>";
					}
				}
				body += "</tbody>";
				body += "</table>";
				body += "  </body></html>";
				String footer = "";

				try {
					Helper.sendEmail(emailServerConfig, subject, body, footer, new ArrayList<File>(), addressee);
				} catch (Exception e) {
					throw new OBException("Error al enviar el email (" + addressee + "). " + e.getMessage());
				}
			}

			if (res.length == 3 && res[2] != null && !res[2].isEmpty()) {
				msg.setType("Warning");
				msg.setTitle(OBMessageUtils.messageBD(res[2]));
			} else {
				msg.setType("Success");
				msg.setTitle(OBMessageUtils.messageBD("@Success@"));
			}
		} catch (final Exception e) {
			log4j.error(e);
			Throwable ex = DbUtility.getUnderlyingSQLException(e);
			String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			msg.setMessage(message);
		} finally {
			OBContext.setAdminMode(false);
			bundle.setResult(msg);
		}
	}

}
