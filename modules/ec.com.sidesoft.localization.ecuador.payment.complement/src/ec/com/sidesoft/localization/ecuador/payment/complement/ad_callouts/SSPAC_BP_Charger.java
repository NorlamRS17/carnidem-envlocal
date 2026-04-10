package ec.com.sidesoft.localization.ecuador.payment.complement.ad_callouts;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SE_Payment_BPartner;
import org.openbravo.model.common.businesspartner.BusinessPartner;

/**
 * Callout: al elegir Tercero (Received From), rellena Cobrador (Charger For)
 * desde Cobrador del BP o Agente Comercial. Extiende SE_Payment_BPartner.
 */
public class SSPAC_BP_Charger extends SE_Payment_BPartner {

  private static final long serialVersionUID = 1L;
  private static final Logger log = Logger.getLogger(SSPAC_BP_Charger.class);

  private static final String TARGET_FIELD = "inpemSspacCBpartnerId";

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String strBPartnerId = info.getStringParameter("inpcBpartnerId", IsIDFilter.instance);

    if (StringUtils.isEmpty(strBPartnerId)) {
      info.addResult(TARGET_FIELD, null);
      return;
    }

    super.execute(info);

    BusinessPartner bpartner = OBDal.getInstance().get(BusinessPartner.class, strBPartnerId);
    String resultId = null;

    if (bpartner != null) {
      BusinessPartner cobrador = bpartner.getAtimdmCobrador();
      if (cobrador != null) {
        resultId = cobrador.getId();
      } else {
        BusinessPartner salesRep = bpartner.getSalesRepresentative();
        if (salesRep != null) {
          resultId = salesRep.getId();
        } else {
          log.debug("BP sin cobrador ni agente: " + bpartner.getIdentifier());
          info.addResult("WARNING",
              "El campo Agente Comercial está VACÍO en la base de datos.");
        }
      }
    }

    info.addResult(TARGET_FIELD, resultId);
  }
}
