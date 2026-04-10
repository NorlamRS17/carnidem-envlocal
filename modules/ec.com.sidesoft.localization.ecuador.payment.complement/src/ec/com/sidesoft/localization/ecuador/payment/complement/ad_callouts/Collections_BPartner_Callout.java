package ec.com.sidesoft.localization.ecuador.payment.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SE_Payment_BPartner;
import org.openbravo.model.common.businesspartner.BusinessPartner;

/**
 * Callout de Cobros (Collections): al elegir el Tercero (Received From), rellena
 * automáticamente el Cobrador (Charger For) desde el campo Cobrador del BP o, en su defecto,
 * desde el Agente Comercial del BP. Extiende el callout estándar SE_Payment_BPartner.
 */
public class Collections_BPartner_Callout extends SE_Payment_BPartner {

  private static final long serialVersionUID = 1L;

  /** Nombre del campo en ventana: Cobrado por (Charger For). Prefijo "inp" por convención callout. */
  private static final String TARGET_FIELD = "inpemSspacCBpartnerId";

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    // Parámetro que dispara el callout: Tercero / Received From. Usamos info (no vars) para
    // respetar valores ya modificados por callouts previos en la misma cadena.
    String strBPartnerId = info.getStringParameter("inpcBpartnerId", null);

    // Validar vacío ANTES de llamar al padre: SE_Payment_BPartner no comprueba inpcBpartnerId
    // vacío y haría get(BusinessPartner.class, "") → null → NPE en getPaymentMethod().
    if (strBPartnerId == null || strBPartnerId.isEmpty()) {
      info.addResult(TARGET_FIELD, "");
      return;
    }

    // Ejecutar lógica estándar: método de pago, cuenta financiera, aviso de BP bloqueado.
    super.execute(info);

    BusinessPartner bpartner = OBDal.getInstance().get(BusinessPartner.class, strBPartnerId);
    String resultId = null;

    if (bpartner != null) {
      // Prioridad 1: Cobrador definido en el tercero (campo de localización Ecuador).
      BusinessPartner cobrador = bpartner.getAtimdmCobrador();
      if (cobrador != null) {
        resultId = cobrador.getId();
      } else {
        // Prioridad 2: Si no hay cobrador, usar Agente Comercial del BP (también es BPartner).
        BusinessPartner salesRep = bpartner.getSalesRepresentative();
        if (salesRep != null) {
          resultId = salesRep.getId();
        } else {
          info.addResult("WARNING",
              "El campo Agente Comercial está VACÍO en la base de datos.");
        }
      }
    }

    // Escribir en el campo Cobrador de la ventana (vacío, ID de cobrador o de agente).
    info.addResult(TARGET_FIELD, resultId);
  }
}