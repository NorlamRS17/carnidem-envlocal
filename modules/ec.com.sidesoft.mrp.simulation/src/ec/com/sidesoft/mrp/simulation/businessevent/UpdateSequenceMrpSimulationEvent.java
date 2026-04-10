package ec.com.sidesoft.mrp.simulation.businessevent;

import javax.enterprise.event.Observes;

import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.model.ad.utility.Sequence;

import ec.com.sidesoft.mrp.simulation.SsmrpsAsimulationProd;

public class UpdateSequenceMrpSimulationEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(SsmrpsAsimulationProd.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final SsmrpsAsimulationProd MrpSimulation = (SsmrpsAsimulationProd) event.getTargetInstance();

    if (MrpSimulation.getDocumentno() != null) {

      String seqnumber = MrpSimulation.getDocumentno();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity settlementEntity = ModelProvider.getInstance()
            .getEntity(SsmrpsAsimulationProd.ENTITY_NAME);
        final Property valueProperty = settlementEntity
            .getProperty(SsmrpsAsimulationProd.PROPERTY_DOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }

      Sequence sequence = MrpSimulation.getDoctype().getDocumentSequence();
      sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    }

  }

}
