package ec.com.sidesoft.projects.complement.event;

import javax.enterprise.event.Observes;

import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.project.Project;

public class SproctmProjectMultifaseEvent extends EntityPersistenceEventObserver {

  private static Entity[] entities = { ModelProvider.getInstance().getEntity(Project.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final Project projectMultifase = (Project) event.getTargetInstance();

    if (projectMultifase.getSproctmDocumentno() != null) {

      String seqnumber = projectMultifase.getSproctmDocumentno();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity settlementEntity = ModelProvider.getInstance().getEntity(Project.ENTITY_NAME);
        final Property valueProperty = settlementEntity
            .getProperty(Project.PROPERTY_SPROCTMDOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }

      Sequence sequence = projectMultifase.getSproctmDoctype().getDocumentSequence();
      sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    }

  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final Project projectMultifase = (Project) event.getTargetInstance();

    if (projectMultifase.getSproctmDocumentno() == null) {

      String seqnumber = projectMultifase.getSproctmDocumentno();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity settlementEntity = ModelProvider.getInstance().getEntity(Project.ENTITY_NAME);
        final Property valueProperty = settlementEntity
            .getProperty(Project.PROPERTY_SPROCTMDOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }

      Sequence sequence = projectMultifase.getSproctmDoctype().getDocumentSequence();
      sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    } else {
      String seqnumber = projectMultifase.getSproctmDocumentno();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity settlementEntity = ModelProvider.getInstance().getEntity(Project.ENTITY_NAME);
        final Property valueProperty = settlementEntity
            .getProperty(Project.PROPERTY_SPROCTMDOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }
    }
  }

}
