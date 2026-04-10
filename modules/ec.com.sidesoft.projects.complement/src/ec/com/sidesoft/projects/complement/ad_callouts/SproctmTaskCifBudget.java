package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SproctmTaskCifBudget extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    double strqtyBudget = Double.parseDouble(info.getStringParameter("inpqtyBudget", null));
    double strcostUnitStandar = Double
        .parseDouble(info.getStringParameter("inpcostUnitStandar", null));
    double strTotalCost = strqtyBudget * strcostUnitStandar;
    info.addResult("inptotalCostBudget", strTotalCost);

  }

}
