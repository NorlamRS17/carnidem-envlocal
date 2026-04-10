package ec.com.sidesoft.projects.complement.ad_callouts;
import javax.servlet.ServletException;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SproctmTotalCostHoursMachine extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    float strhours = Float.parseFloat(info.getStringParameter("inphours", null));
    float strcost = Float.parseFloat(info.getStringParameter("inpcost", null));
    
    info.addResult("inptotalCost", ( strhours * strcost ));
    }

}
