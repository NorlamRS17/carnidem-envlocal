package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SproctmPhasePrhasetype extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String stremSproctmPrhasetype = info.getStringParameter("inpemSproctmPrhasetype", null);
    if (stremSproctmPrhasetype.equals("E")) {
      info.addResult("inpemSproctmMaCostcenterId", null);
    }
  }
}
