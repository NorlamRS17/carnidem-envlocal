package ec.com.sidesoft.pos.custom.print.models;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.retail.posterminal.JSONProcessSimple;

public class GetBusinessPartnerEmail extends JSONProcessSimple {

  private static final Logger log = Logger.getLogger(GetBusinessPartnerEmail.class);

  @Override
  public JSONObject exec(JSONObject jsonData) throws JSONException, ServletException {

    String email = null;
    
    try {
      if (!jsonData.has("bpId")) {
        throw new OBException("Missing parameter: bpId");
      }
      
      String businessPartnerId = jsonData.getString("bpId");
      
      if (businessPartnerId == null || businessPartnerId.trim().isEmpty()) {
        throw new OBException("Invalid bpId: empty or null");
      }

      // Obtener el BusinessPartner respetando los filtros de seguridad de cliente/organización
      BusinessPartner businessPartner = OBDal.getInstance().get(BusinessPartner.class,
          businessPartnerId);
      if (businessPartner == null) {
        throw new OBException("BusinessPartner not found");
      }

      // Obtener el email del campo eEIEmail
      email = businessPartner.getEEIEmail();
      
      if (email == null) {
        email = "";
      }

    } catch (OBException e) {
      log.error("Error in GetBusinessPartnerEmail.exec: " + e.getMessage(), e);
      throw e;
    } catch (Exception e) {
      log.error("Unexpected error in GetBusinessPartnerEmail.exec", e);
      throw new OBException("Error getting business partner email");
    }

    JSONObject preFinalResult = new JSONObject();
    preFinalResult.put("email", email);

    JSONObject finalResult = new JSONObject();
    finalResult.put("data", preFinalResult);
    finalResult.put("status", 0);
    return finalResult;
  }
}