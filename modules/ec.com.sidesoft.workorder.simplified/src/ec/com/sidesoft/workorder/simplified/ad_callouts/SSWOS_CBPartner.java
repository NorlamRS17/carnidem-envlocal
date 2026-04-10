package ec.com.sidesoft.workorder.simplified.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.businesspartner.BusinessPartner;

public class SSWOS_CBPartner extends SimpleCallout {

  /**
   * 
   */

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strLastChanged = info.getLastFieldChanged();

    String strnumerochasis = info.getStringParameter("inpnumerochasis", null);
    String strplaca = info.getStringParameter("inpplaca", null);

    String strBPartnerId = info.getStringParameter("inpcBpartnerId", null);
    String strOrgId = info.getStringParameter("inpadOrgId", null);

    BusinessPartner ObjPartner = OBDal.getInstance().get(BusinessPartner.class, strBPartnerId);

    // Entrega las direcciones de facturación
    SSWOSDirClienteData[] data = SSWOSDirClienteData.select(this, strBPartnerId);
    SSWOSBPartnerMiscData[] data1 = SSWOSBPartnerMiscData.select(this, strBPartnerId);

    if (ObjPartner.getEEIEmail() != null) {
      info.addResult("inpemail", ObjPartner.getEEIEmail());
    }
    if (data != null && data.length > 0) {
      for (int i = 0; i < data.length; i++) {
        info.addResult("inpcBpartnerLocationId", data[i].getField("cBpartnerLocationId"));
      }
    } else {
      info.addResult("inpcBpartnerLocationId", null);
    }
    String strFinPaymentMethodId = "";
    String strPriceList = "";
    String PaymentTerm = "";

    if (data1 != null && data1.length > 0) {
      strFinPaymentMethodId = data1[0].finPaymentmethodId;
      strPriceList = data1[0].mPricelistId;
      PaymentTerm = data1[0].cPaymenttermId;
      info.addResult("inpfinPaymentmethodId", strFinPaymentMethodId);
      info.addResult("inpcPaymenttermId", PaymentTerm);
      if (strPriceList.equals("")) {
        info.addResult("ERROR", "El cliente no tiene configurada una lista de precios.");
      } else {
        info.addResult("inpmPricelistId", strPriceList);
      }
    }
  }
}
