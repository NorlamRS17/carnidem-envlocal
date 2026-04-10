package ec.com.sidesoft.carnidem.back.customizations.ad_events;

import java.sql.Timestamp;

import javax.enterprise.event.Observes;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.client.kernel.event.EntityDeleteEvent;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.client.kernel.event.EntityUpdateEvent;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.service.db.DalConnectionProvider;

public class CbckcInvoiceEventHandler extends EntityPersistenceEventObserver {
  private static Entity[] entities = { ModelProvider.getInstance().getEntity(Invoice.ENTITY_NAME) };

  ConnectionProvider conn = new DalConnectionProvider(false);
  String language = OBContext.getOBContext().getLanguage().getLanguage();

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onUpdate(@Observes EntityUpdateEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final Invoice head = (Invoice) event.getTargetInstance();

    if (!head.isSalesTransaction()) {
      checkReference(head);
    }
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
    final Invoice head = (Invoice) event.getTargetInstance();
    if (!head.isSalesTransaction()) {
      checkReference(head);
    }
  }

  public void onDelete(@Observes EntityDeleteEvent event) {
    if (!isValidEvent(event)) {
      return;
    }
  }

  // Method Duplicated to com.sidesoft.localization.ecuador.withholdings.event.InvoiceEventHandle
  private void checkReference(Invoice invoice) {
    String error_msg = "";
    String entrada = "2018-07-01 00:00:00";

    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    OBCriteria<Invoice> obcInvoice = OBDal.getInstance().createCriteria(Invoice.class, "invoice");
    obcInvoice.createAlias("invoice.transactionDocument", "doctype");
    obcInvoice.add(Restrictions.eq(Invoice.PROPERTY_CLIENT, invoice.getClient()));
    obcInvoice.add(Restrictions.eq(Invoice.PROPERTY_ORDERREFERENCE, invoice.getOrderReference()));
    obcInvoice.add(Restrictions.eq(Invoice.PROPERTY_BUSINESSPARTNER, invoice.getBusinessPartner()));
    obcInvoice.add(Restrictions.ge(Invoice.PROPERTY_CREATIONDATE, Timestamp.valueOf(entrada)));

    obcInvoice
        .add(Restrictions.eq(Invoice.PROPERTY_SALESTRANSACTION, invoice.isSalesTransaction()));
    obcInvoice.add(Restrictions.ne(Invoice.PROPERTY_ID, invoice.getId()));
    obcInvoice.add(Restrictions.eq(Invoice.PROPERTY_SALESTRANSACTION, false));
    obcInvoice.add(Restrictions.eq("doctype.return", false));
    obcInvoice.add(Restrictions.eq("doctype.documentCategory", "API"));

    obcInvoice.add(Restrictions.ne(Invoice.PROPERTY_DOCUMENTSTATUS, "VO"));
    obcInvoice.add(Restrictions.eq(Invoice.PROPERTY_SSWHLIVELIHOOD, invoice.getSswhLivelihood()));

    if (obcInvoice.count() > 0 && !invoice.getDocumentType().isReturn()) {

      error_msg = Utility.messageBD(conn, "SSWH_NoReferenceNo", language);
      throw new OBException(error_msg + " - " + invoice.getOrderReference());
    }
  }
}
