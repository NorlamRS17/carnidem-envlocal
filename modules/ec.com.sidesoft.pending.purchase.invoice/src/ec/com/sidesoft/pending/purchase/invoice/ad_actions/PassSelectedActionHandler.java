package ec.com.sidesoft.pending.purchase.invoice.ad_actions;

import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.invoice.Invoice;

import ec.com.sidesoft.pending.purchase.invoice.SsppinvSelectedInvoices;

public class PassSelectedActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject response = new JSONObject();

    try {
      final JSONObject jsonData = new JSONObject(data);
      final JSONArray rows = jsonData.getJSONArray("rows");

      for (int i = 0; i < rows.length(); i++) {
        Invoice invoice = OBDal.getInstance().get(Invoice.class, rows.getString(i));
        OBCriteria<SsppinvSelectedInvoices> selectedInvoices = OBDal.getInstance()
            .createCriteria(SsppinvSelectedInvoices.class);
        selectedInvoices.add(Restrictions.eq(SsppinvSelectedInvoices.PROPERTY_INVOICE, invoice));
        if (selectedInvoices.list().size() == 0) {
          SsppinvSelectedInvoices selectedInvoice = OBProvider.getInstance()
              .get(SsppinvSelectedInvoices.class);
          selectedInvoice.setInvoice(invoice);
          selectedInvoice.setBusinessPartner(invoice.getBusinessPartner());
          selectedInvoice.setGrandTotalAmount(invoice.getGrandTotalAmount());
          selectedInvoice.setTotalPaid(invoice.getTotalPaid());
          selectedInvoice.setOutstandingAmount(invoice.getOutstandingAmount());
          selectedInvoice.setAmount(invoice.getOutstandingAmount());
          OBDal.getInstance().save(selectedInvoice);
        }
      }

      OBDal.getInstance().flush();
      response.put("status", "OK");
    } catch (Exception e) {
      System.out.println("PassSelectedActionHandler: " + e.getMessage());
      try {
        response.put("status", "ERROR");
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    }
    OBContext.setAdminMode(false);
    return response;
  }
}
