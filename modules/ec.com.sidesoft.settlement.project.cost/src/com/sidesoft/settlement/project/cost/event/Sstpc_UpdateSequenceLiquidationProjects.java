package com.sidesoft.settlement.project.cost.event;

import javax.enterprise.event.Observes;

import org.openbravo.base.ConfigParameters;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.financialmgmt.tax.TaxRate;

import ec.com.sidesoft.settlement.project.cost.LiquidationProjects;

public class Sstpc_UpdateSequenceLiquidationProjects extends EntityPersistenceEventObserver {

  public static String dateTimeFormat;
  public static String sqlDateTimeFormat;
  public TaxRate taxRate;
  public String successMessage = null;
  public ConfigParameters cf;
  public String language;
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(
      LiquidationProjects.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }

    final LiquidationProjects SstpcLiqProj = (LiquidationProjects) event.getTargetInstance();

    if (SstpcLiqProj.getDocumentno() != null) {

      String seqnumber = SstpcLiqProj.getDocumentno();

      if (seqnumber.matches("^<.+>$")) {

        String subseqnumber = seqnumber.substring(1, seqnumber.length() - 1);

        final Entity loansEntity = ModelProvider.getInstance().getEntity(
            LiquidationProjects.ENTITY_NAME);
        final Property valueProperty = loansEntity
            .getProperty(LiquidationProjects.PROPERTY_DOCUMENTNO);

        event.setCurrentState(valueProperty, subseqnumber);

      }

      Sequence sequence = SstpcLiqProj.getDoctype().getDocumentSequence();
      sequence.setNextAssignedNumber(sequence.getNextAssignedNumber() + sequence.getIncrementBy());
    }
  }

}
