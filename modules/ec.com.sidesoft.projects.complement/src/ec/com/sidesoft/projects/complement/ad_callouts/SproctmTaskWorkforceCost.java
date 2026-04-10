package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SproctmTaskWorkforceCost extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    double strqtyBudget = Double.parseDouble(info.getStringParameter("inpqtyBudget", null));
    double strcostUnitStandar = Double
        .parseDouble(info.getStringParameter("inpcostUnitStandar", null));
    double strTotalCostBudget = strqtyBudget * strcostUnitStandar;
    info.addResult("inptotalCostBudget", strTotalCostBudget);

  }

}
