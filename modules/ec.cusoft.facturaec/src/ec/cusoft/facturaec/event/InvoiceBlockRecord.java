package ec.cusoft.facturaec.event;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.LocalDate;
import javax.enterprise.event.Observes;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.model.Property;
import org.openbravo.client.kernel.event.EntityNewEvent;
import org.openbravo.client.kernel.event.EntityPersistenceEventObserver;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.enterprise.DocumentType;

public class InvoiceBlockRecord extends EntityPersistenceEventObserver {

  private static Entity[] entities = { ModelProvider.getInstance().getEntity(Invoice.ENTITY_NAME) };

  @Override
  protected Entity[] getObservedEntities() {
    return entities;
  }

  public void onSave(@Observes EntityNewEvent event) {
    if (!isValidEvent(event)) {
      return;
    }



    try {
      final Invoice objInvoice = (Invoice) event.getTargetInstance();

      // 1. Validaciones de nulos para evitar NullPointerException
      if (objInvoice.getTransactionDocument() == null) {
        return;
      }

      // 2. Obtener booleanos correctamente
      DocumentType docType = objInvoice.getTransactionDocument();
      
      // 2. Accedemos a las propiedades DENTRO del tipo de documento
      boolean emSswhImplementautoriza = Boolean.TRUE.equals(docType.isSswhImplementautoriza());
      boolean isEdoc = Boolean.TRUE.equals(docType.isEeiIsEdoc());

      

      // 3. Lógica de validación
      if (emSswhImplementautoriza && isEdoc) {

        Date invoiceDate = objInvoice.getInvoiceDate(); // La fecha está en la Factura, no en el
                                                        // Tipo de Doc

        if (invoiceDate != null) {
          // Convertir Date (java.util) a LocalDate (java.time) para comparar solo fechas sin horas
          ZoneId zonaEcuador = ZoneId.of("America/Guayaquil");
          LocalDate fechaFactura = invoiceDate.toInstant()
              .atZone(zonaEcuador).toLocalDate();
          LocalDate fechaActual = LocalDate.now(zonaEcuador);
          
          // Si fechaFactura es POSTERIOR (After) a fechaActual
//          if (fechaFactura.isAfter(fechaActual) || fechaFactura.isBefore(fechaActual)) {
          if (!fechaFactura.isEqual(fechaActual)) {
            throw new OBException(
                "LA FECHA DE LA TRANSACCION NO PUEDE SER DIFERENTE A LA FECHA DE HOY YA QUE ES UN DOCUMENTO ELECTRONICO");
          }
        }
      }

    } catch (OBException obex) {
      // Si ya es una OBException, lánzala directamente para mantener el mensaje original
      throw obex;
    } catch (Exception e) {
      // Captura errores genéricos
      throw new OBException("Error en validación de fecha: " + e.getMessage());
    }
  }
}