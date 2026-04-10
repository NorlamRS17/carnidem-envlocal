package ec.com.sidesoft.discount.quota.salesinvoices.ad_callouts;

import javax.enterprise.event.Observes;

import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.model.ad.utility.Sequence;

import ec.com.sidesoft.discount.quota.salesinvoices.QuotaDetail;

public class SL_UpdateDocNumber extends EntityPersistenceEventObserver {

  private static Entity[] entities = {
      ModelProvider.getInstance().getEntity(QuotaDetail.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final QuotaDetail transfer = (QuotaDetail) event.getTargetInstance();

    if (transfer.getDocumentNo() != null) {

      String seqnumber = transfer.getDocumentNo();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity transferEntity = ModelProvider.getInstance()
            .getEntity(QuotaDetail.ENTITY_NAME);
        final Property valueProperty = transferEntity
            .getProperty(QuotaDetail.PROPERTY_DOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }
      Sequence sequence = transfer.getDocumentType().getDocumentSequence();
      // sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    }

  }

}
