package ec.com.sidesoft.production.quality.events;

import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.manufacturing.quality.MeasureGroup;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.model.manufacturing.quality.MeasureTime;
import org.openbravo.model.manufacturing.quality.MeasureValues;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;


public class Ssprod_BlockLines extends EntityPersistenceEventObserver{
	private static final Logger logger = LoggerFactory.getLogger(Ssprod_BlockLines.class); 
	private static Entity[] entities = { ModelProvider.getInstance().getEntity(MeasureGroup.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(MeasureTime.ENTITY_NAME),
			ModelProvider.getInstance().getEntity(MeasureValues.ENTITY_NAME)};

	 
	  @Override
	  protected Entity[] getObservedEntities() {
	    return entities;
	  }
	 
	  public void onUpdate(@Observes EntityUpdateEvent event) {
	    if (!isValidEvent(event)) {
	      return;
	    }
	    
	    MeasureShift measureShift = null;
	    switch (event.getTargetInstance().getEntityName()) {
	    case MeasureGroup.ENTITY_NAME:
	    	 MeasureGroup measureGroup = (MeasureGroup)  event.getTargetInstance();
	 	    measureShift = measureGroup.getMeasurementShift();	
	 	    break;
	    case MeasureTime.ENTITY_NAME:
	    	MeasureTime measureTime = (MeasureTime) event.getTargetInstance();
	    	measureGroup = measureTime.getMeasurementSet();
	    	measureShift = measureGroup.getMeasurementShift();	
	    	break;
	    case MeasureValues.ENTITY_NAME:
	    	MeasureValues measureValues = (MeasureValues) event.getTargetInstance();
	    	measureTime = measureValues.getMeasurementTime();
	    	measureGroup = measureTime.getMeasurementSet();
	    	measureShift = measureGroup.getMeasurementShift();	
	    	break;
	    default:
	    	return;
	    	}
	    
	    if(measureShift != null && ! measureShift.getSsfdcStatus().equals("DR") ) {
    		String message = OBMessageUtils.messageBD("No se puede editar");
	    	logger.error(message);
	    	throw new OBException(message);
    	}
	 }
}
	 