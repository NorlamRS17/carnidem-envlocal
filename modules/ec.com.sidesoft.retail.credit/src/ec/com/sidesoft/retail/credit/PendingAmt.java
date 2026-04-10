package ec.com.sidesoft.retail.credit;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.retail.posterminal.JSONProcessSimple;

public class PendingAmt extends JSONProcessSimple {

  private static final Logger log = Logger.getLogger(PendingAmt.class);

  public JSONObject exec(JSONObject jsonData) throws JSONException, ServletException {

    BigDecimal actualCredit = new BigDecimal(0);
    OBContext.setAdminMode(true);
    try {
      if (!jsonData.has("bpId")) {
        throw new OBException("Missing parameter: bpId");
      }
      
      String businessPartnerId = jsonData.getString("bpId");
      
      if (businessPartnerId == null || businessPartnerId.trim().isEmpty()) {
        throw new OBException("Invalid bpId: empty or null");
      }

      BusinessPartner businessPartner = OBDal.getInstance().get(BusinessPartner.class,
          businessPartnerId);
      if (businessPartner == null) {
        throw new OBException("BusinessPartner not found: " + businessPartnerId);
      }

      BigDecimal creditLimit = businessPartner.getCreditLimit();
      BigDecimal creditUsed = businessPartner.getCreditUsed();
      
      if (creditLimit == null) {
        creditLimit = BigDecimal.ZERO;
      }
      
      if (creditUsed == null) {
        creditUsed = BigDecimal.ZERO;
      }
      
      actualCredit = creditLimit.subtract(creditUsed);

    } catch (OBException e) {
      log.error("Error in PendingAmt.exec: " + e.getMessage(), e);
      throw e;
    } catch (JSONException e) {
      log.error("JSON error in PendingAmt.exec: " + e.getMessage(), e);
      throw new OBException("Invalid JSON parameters: " + e.getMessage());
    } catch (Exception e) {
      log.error("Unexpected error in PendingAmt.exec: " + e.getMessage(), e);
      throw new OBException("Error calculating pending amount: " + e.getMessage());
    } finally {
      OBContext.restorePreviousMode();
    }

    JSONObject preFinalResult = new JSONObject();
    preFinalResult.put("pendingAmt", actualCredit);

    JSONObject finalResult = new JSONObject();
    finalResult.put("data", preFinalResult);
    finalResult.put("status", 0);
    return finalResult;
  }
}
