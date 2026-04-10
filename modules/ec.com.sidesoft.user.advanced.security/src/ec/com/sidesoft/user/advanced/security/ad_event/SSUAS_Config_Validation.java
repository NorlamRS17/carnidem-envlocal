package ec.com.sidesoft.user.advanced.security.ad_event;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;

import ec.com.sidesoft.user.advanced.security.SsuasExcludedUsers;
import ec.com.sidesoft.user.advanced.security.SsuasSecurityConfig;

public class SSUAS_Config_Validation extends EntityPersistenceEventObserver {

	private static final Logger logger = Logger.getLogger(SSUAS_Config_Validation.class.getName());

	private static final Entity[] entities = { ModelProvider.getInstance().getEntity(User.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(SsuasSecurityConfig.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(SsuasExcludedUsers.ENTITY_NAME) };

	@Override
	protected Entity[] getObservedEntities() {
		return entities;
	}

	public void onSave(@Observes EntityNewEvent event) {
		if (!isValidEvent(event)) {
			return;
		}

		if (event.getTargetInstance() instanceof SsuasSecurityConfig) {
			List<SsuasSecurityConfig> configList = OBDal.getInstance().createCriteria(SsuasSecurityConfig.class).list();
			if (configList.size() >= 1) {
				throw new OBException(OBMessageUtils.messageBD("SSUAS_Only_One_Config"));
			}
			validateFields((SsuasSecurityConfig) event.getTargetInstance());
		}

		if (event.getTargetInstance() instanceof SsuasExcludedUsers) {
			validateExcludedUser((SsuasExcludedUsers) event.getTargetInstance());
		}
	}

	public void onUpdate(@Observes EntityUpdateEvent event) {
		if (!isValidEvent(event)) {
			return;
		}

		if (event.getTargetInstance() instanceof SsuasSecurityConfig) {
			validateFields((SsuasSecurityConfig) event.getTargetInstance());
		}
	}

	private void validateFields(SsuasSecurityConfig securityConfig) {
		Long validity = securityConfig.getValidity();
		if (validity != null && validity > 0 && String.valueOf(validity).length() > 3) {
			throw new OBException(OBMessageUtils.messageBD("SSUAS_Val_MinLength"));
		}
		Client client = securityConfig.getClient();
		client.setDaysToPasswordExpiration(validity);

		Long passwordLength = securityConfig.getPasswordLength();
		if (passwordLength != null && passwordLength > 0 && String.valueOf(passwordLength).length() > 3) {
			throw new OBException(OBMessageUtils.messageBD("SSUAS_Val_MinLength"));
		}

		Long inactivitydays = securityConfig.getInactivityDays();
		if (inactivitydays != null && inactivitydays > 0 && String.valueOf(inactivitydays).length() > 3) {
			throw new OBException(OBMessageUtils.messageBD("SSUAS_Val_MinLength"));
		}

		Long loginAttempts = securityConfig.getAttempts();
		if (loginAttempts != null && loginAttempts > 0 && String.valueOf(loginAttempts).length() > 3) {
			throw new OBException(OBMessageUtils.messageBD("SSUAS_Val_MinLength"));
		}
	}

	private void validateExcludedUser(SsuasExcludedUsers excludedUser) {
		User user = excludedUser.getUserContact();
		SsuasSecurityConfig config = excludedUser.getSsuasSecurityConfig();

		List<SsuasExcludedUsers> existing = OBDal.getInstance().createCriteria(SsuasExcludedUsers.class)
				.add(Restrictions.eq("userContact", user)).add(Restrictions.eq("ssuasSecurityConfig", config)).list();

		if (!existing.isEmpty()) {
			throw new OBException(
					OBMessageUtils.messageBD("El usuario ya se encuentra en la lista de usuarios excluidos"));
		}
	}
}
