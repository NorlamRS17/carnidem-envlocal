package ec.com.sidesoft.app.production.quality.webservices;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.erpCommon.reference.PInstanceProcessData;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.ad.ui.MessageTrl;
import org.openbravo.model.materialmgmt.transaction.InternalMovement;
import org.openbravo.model.ad.ui.Message;


public class Ssapg_postMovement implements org.openbravo.scheduling.Process {

	private static final String lotSearchKey = "LOT";
	private static final String serialNoSearchKey = "SNO";
	private static final String expirationDateSearchKey = "EXD";
	private static final Logger log4j = Logger.getLogger(Ssapg_postMovement.class);

	@Override
	public void execute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		final String mMovementID = (String) bundle.getParams().get("m_movement_id");
		final ConnectionProvider conn = bundle.getConnection();
		final VariablesSecureApp vars = bundle.getContext().toVars();

		try {
			InternalMovement movement = OBDal.getInstance().get(InternalMovement.class, mMovementID);
			createStandards(movement, conn, vars);
			OBDal.getInstance().save(movement);
			OBDal.getInstance().flush();

			final OBError msg = new OBError();
			msg.setType("Success");
			msg.setTitle(Utility.messageBD(conn, "Success", bundle.getContext().getLanguage()));
			msg.setMessage(Utility.messageBD(conn, "Success", bundle.getContext().getLanguage()));
			bundle.setResult(msg);
		} catch (final Exception e) {
			OBDal.getInstance().rollbackAndClose();
			log4j.error("Error creating standards", e);

			final OBError msg = new OBError();
			msg.setType("Error");

			if (e instanceof OBException) {
				// Extraer el mensaje traducido desde la excepción
				String errorMessage = ((OBException) e).getMessage(); // Asumiendo que el mensaje ya está en un formato
																		// adecuado
				// Aquí puedes procesar el errorMessage para obtener un mensaje traducido si es
				// necesario
				msg.setMessage(errorMessage);
				msg.setTitle("Error");
			} else {
				msg.setMessage(e.getMessage() != null ? e.getMessage() : e.toString());
				msg.setTitle(Utility.messageBD(conn, "Error", bundle.getContext().getLanguage()));
			}

			bundle.setResult(msg);
		}
	}

	private void createStandards(InternalMovement movement, ConnectionProvider conn, VariablesSecureApp vars) throws ServletException {
		// TODO Auto-generated method stub
		try {
	        OBContext.setAdminMode(true);

	        org.openbravo.model.ad.ui.Process process = OBDal.getInstance().get(
	            org.openbravo.model.ad.ui.Process.class, "122");

	        final ProcessInstance pInstance = CallProcess.getInstance().call(process,
	        		movement.getId(), null);

	        if (pInstance.getResult() == 0) {		        	
	            String errorMessage = pInstance.getErrorMsg();
	            String extractedMessage = extractValueBetweenAt(errorMessage);
	            
	            OBCriteria<Message> objMessageCriteria = OBDal.getInstance().createCriteria(Message.class);
	            objMessageCriteria.add(Restrictions.eq(Message.PROPERTY_SEARCHKEY, extractedMessage));
	            Message objMessage = (Message) objMessageCriteria.uniqueResult();
	            
	            if (objMessage == null) {
	                throw new OBException("No se encontró un mensaje con la clave proporcionada: " + extractedMessage);
	            }
	            
	            OBCriteria<MessageTrl> objMessageCriteriaTranslate = OBDal.getInstance().createCriteria(MessageTrl.class);
	            objMessageCriteriaTranslate.add(Restrictions.eq(MessageTrl.PROPERTY_MESSAGE, objMessage));
	            MessageTrl objMessageTranslate = (MessageTrl) objMessageCriteriaTranslate.uniqueResult();
	          
	            if (objMessageTranslate != null) {
	                throw new OBException("Error: " + objMessageTranslate.getMessageText());
	            }
	        }
	      } finally {
	        OBContext.restorePreviousMode();
	      }
	
	}

	private String extractValueBetweenAt(String message) {
	    if (message != null && !message.isEmpty()) {
	        String[] parts = message.split("@");
	        if (parts.length > 2) {
	            return parts[2]; 
	        }
	    }
	    return "Unknown error"; 
	}

}
