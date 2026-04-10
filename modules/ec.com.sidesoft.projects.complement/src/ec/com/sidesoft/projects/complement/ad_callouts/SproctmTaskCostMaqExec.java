package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SproctmTaskCostMaqExec extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    double strqtyExecuted = Double
        .parseDouble(info.getStringParameter("inpunitsCostExecuted", null));
    double strcostUnitStandar = Double
        .parseDouble(info.getStringParameter("inpcostUnitExecuted", null));
    double strTotalCost = strqtyExecuted * strcostUnitStandar;
    info.addResult("inptotalCostExecuted", strTotalCost);

  }

}