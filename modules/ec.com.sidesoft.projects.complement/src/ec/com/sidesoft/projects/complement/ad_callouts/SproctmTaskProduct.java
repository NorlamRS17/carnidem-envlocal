package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SproctmTaskProduct extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    double strqty = Double.parseDouble(info.getStringParameter("inpqty", null));
    double strCost = Double.parseDouble(info.getStringParameter("inpcost", null));
    double strCostTotal = strqty * strCost;
    info.addResult("inpcostTotal", strCostTotal);

  }

}
