package com.sidesoft.localization.ecuador.withholdings.event;

import javax.enterprise.event.Observes;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.dal.service.OBDal;

public class CreditNoteReference extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(Invoice.ENTITY_NAME) };
  protected Logger logger = Logger.getLogger(this.getClass());

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    checkReference((Invoice) event.getTargetInstance());
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    checkReference((Invoice) event.getTargetInstance());
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
  }

  private void checkReference(Invoice invoice) {
	//NUEVO DESARROLLO TKT 11278
	DocumentType docInvoice = OBDal.getInstance().get(DocumentType.class, invoice.getTransactionDocument().getId());
	if (!docInvoice.isEeiNoReferenceInvoice())
	{
		if (invoice.getTransactionDocument().isReversal() && (!invoice.isScnrIsrefInv()
				|| invoice.getScnrInvoice() == null)) {
			throw new OBException("El documento no tiene una factura referenciada.");
		}
	}
	else
	{
		if(invoice.getEeiVoucherCode() == null || invoice.getEeiVoucherDate() == null || invoice.getEeiInvoiceNum() == null)
		{
			if(invoice.getEeiVoucherCode() == null)
				throw new OBException("El documento no tiene el código de comprobante referenciado.");
			if(invoice.getEeiVoucherDate() == null)
				throw new OBException("El documento no tiene la fecha de comprobante referenciado.");
			if(invoice.getEeiInvoiceNum() == null)
				throw new OBException("El documento no tiene un número de factura referenciado.");
				
		}
	}
  }
}
