package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.invoice.InvoiceLine;

public class SproctmTaskSubContract extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strcInvoicelineId = info.getStringParameter("inpcInvoicelineId", null);
    // selecionar la unidad del ultimo costo registrado con la fecha mayot mas actual
    OBContext.setAdminMode(true);

    OBCriteria<InvoiceLine> obc = OBDal.getInstance().createCriteria(InvoiceLine.class);
    obc.add(Restrictions.eq(InvoiceLine.PROPERTY_ID, strcInvoicelineId));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);

    InvoiceLine invoiceLine = (InvoiceLine) obc.uniqueResult();
    if (invoiceLine != null) {
      info.addResult("inpcost", invoiceLine.getLineNetAmount()); // PROPERTY_LINENETAMOUNT
    }

  }

}
