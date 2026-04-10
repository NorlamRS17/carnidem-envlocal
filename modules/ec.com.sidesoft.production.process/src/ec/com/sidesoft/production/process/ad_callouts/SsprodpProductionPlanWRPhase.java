package ec.com.sidesoft.production.process.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;
import org.apache.commons.lang.StringUtils;
import org.openbravo.erpCommon.ad_callouts.SL_ProductionPlan_WRPhase;
import org.openbravo.model.manufacturing.transaction.WorkRequirementOperation;
import org.openbravo.dal.service.OBDal;
import org.openbravo.base.filter.IsIDFilter;

public class SsprodpProductionPlanWRPhase extends SL_ProductionPlan_WRPhase{
    @Override
    protected void execute(CalloutInfo info) throws ServletException {
        super.execute(info);
        
        String strWRPhaseId = info.getStringParameter("inpmaWrphaseId", IsIDFilter.instance);
        if (StringUtils.isNotEmpty(strWRPhaseId)) {
            WorkRequirementOperation phase = OBDal.getInstance().get(WorkRequirementOperation.class, strWRPhaseId);
            if (phase != null && phase.getWorkRequirement() != null
                && phase.getWorkRequirement().getSsprodpStop() != null) {
                info.addResult("inpemSsprodpStop", phase.getWorkRequirement().getSsprodpStop());
            }else {
                // Limpiar campo si no tiene valor
                info.addResult("inpemSsprodpStop", "");
            }
        }    
    }
}
