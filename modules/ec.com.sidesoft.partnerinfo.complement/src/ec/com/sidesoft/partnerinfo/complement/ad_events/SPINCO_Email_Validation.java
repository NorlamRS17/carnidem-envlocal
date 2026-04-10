package ec.com.sidesoft.partnerinfo.complement.ad_events;

import java.util.logging.Logger;
import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.common.businesspartner.BusinessPartner;

public class SPINCO_Email_Validation extends EntityPersistenceEventObserver {

	private static final Logger logger = Logger.getLogger(SPINCO_Email_Validation.class.getName());

	private static Entity[] entities = { ModelProvider.getInstance().getEntity(BusinessPartner.ENTITY_NAME), };

	@Override
	protected Entity[] getObservedEntities() {
		return entities;
	}

	private static final String EMAIL_REGEX = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

	private void validateEmails(String emailList) {
		for (String email : emailList.split(";")) {
			email = email.trim();
			if (!email.matches(EMAIL_REGEX)) {
				throw new OBException(OBMessageUtils.messageBD("El correo ingresado no tiene el formato correcto"));
			}
		}
	}

	public void onUpdate(@Observes EntityUpdateEvent event) {
		if (event.getTargetInstance() instanceof BusinessPartner) {
			BusinessPartner bp = (BusinessPartner) event.getTargetInstance();
			if (bp.getEEIEmail() != null) {
				validateEmails(bp.getEEIEmail());
			}
		}
	}

	public void onSave(@Observes EntityNewEvent event) {
		if (event.getTargetInstance() instanceof BusinessPartner) {
			BusinessPartner bp = (BusinessPartner) event.getTargetInstance();
			if (bp.getEEIEmail() != null) {
				validateEmails(bp.getEEIEmail());
			}
		}
	}
}
