package ec.com.sidesoft.pos.custom.sanfelipe.hooks;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.core.TriggerHandler;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.retail.posterminal.OBPOSApplications;
import org.openbravo.retail.posterminal.OrderLoaderHook;
import org.openbravo.retail.posterminal.TerminalType;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;

public class HookOrderLoader implements OrderLoaderHook {

	private static final Logger log = Logger.getLogger(HookOrderLoader.class);

	/***
	 * 12960-ESB - GLPI 5888 -  CONFIGURACION PARA EMITIR GUIAS DE VENTAS REALIZADAS EN EL POS
	 * Se recupera del TPV la configuracion del tipo de documento correspondiente al albaran cliente
	 */
	@Override
	public void exec(JSONObject jsonorder, Order order, ShipmentInOut shipment, Invoice invoice) throws Exception {
		// TODO Auto-generated method stub
		if (jsonorder.has("posTerminal") && order != null && shipment != null && invoice != null) {
			try {
				OBPOSApplications objTerminal = OBDal.getInstance().get(OBPOSApplications.class,
						jsonorder.getString("posTerminal"));
				TerminalType typeOfTerminal = objTerminal.getObposTerminaltype();
				if (typeOfTerminal != null) {
					DocumentType documentTypeShipment = typeOfTerminal.getDocumentType() != null
							&& typeOfTerminal.getDocumentType().getDocumentTypeForShipment() != null
									? typeOfTerminal.getDocumentType().getDocumentTypeForShipment()
									: null;
					if (documentTypeShipment != null) {
						ConnectionProvider conn = new DalConnectionProvider(false);
						VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
						String docNo = Utility.getDocumentNo(conn.getConnection(), conn, vars, "",
								ShipmentInOut.ENTITY_NAME, documentTypeShipment.getId(), documentTypeShipment.getId(),
								false, true);
						log.info(docNo);

						// Format 000-000-000000000
						docNo = formatDocNo(docNo);
						log.info("Se ha asignado el siguiente num de Doc " + docNo + " en albaran cliente.");

						if (!TriggerHandler.getInstance().isDisabled()) {
							TriggerHandler.getInstance().disable();
						}
						try {
							shipment.setDocumentType(documentTypeShipment);
							shipment.setDocumentNo(docNo);
							OBDal.getInstance().save(invoice);
							OBDal.getInstance().flush();
						} finally {
							if (TriggerHandler.getInstance().isDisabled()) {
								TriggerHandler.getInstance().enable();
							}
						}

					}
				}
			} catch (Exception e) {
				log.info("No se ha podido actualizar el No de documento en albaran cliente." + order.getDocumentNo());
			}

		}

	}

	private String formatDocNo(String docNo) {
		String[] parts = docNo.split("-");
		String part1 = String.format("%03d", Integer.parseInt(parts[0]));
		String part2 = String.format("%03d", Integer.parseInt(parts[1]));
		String part3 = String.format("%09d", Integer.parseInt(parts[2]));
		return part1 + "-" + part2 + "-" + part3;
	}

}
