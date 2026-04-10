package ec.com.sidesoft.production.process.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringUtils;
import org.openbravo.dal.service.OBDal;
import org.openbravo.base.filter.IsIDFilter;
import org.openbravo.erpCommon.ad_callouts.SL_WorkRequirement_ProcessPlan;
import org.openbravo.model.manufacturing.processplan.Operation;
import org.openbravo.model.manufacturing.processplan.OperationProduct;
import org.openbravo.model.manufacturing.processplan.ProcessPlan;
import org.openbravo.model.manufacturing.processplan.Version;



public class SsprodpWorkRequirement extends SL_WorkRequirement_ProcessPlan {

    @Override
    protected void execute(CalloutInfo info) throws ServletException {
        super.execute(info);

        final String planId = info.getStringParameter("inpmaProcessplanId", IsIDFilter.instance);
        if (StringUtils.isEmpty(planId)) {
            info.addResult("inpemSsprodpStop", BigDecimal.ZERO);
            return;
          }
        ProcessPlan plan = OBDal.getInstance().get(ProcessPlan.class, planId);
        for (Version version : plan.getManufacturingVersionList()) {
          if (!version.isActive()) continue;

          for (Operation sequence : version.getManufacturingOperationList()) {

            for (OperationProduct product : sequence.getManufacturingOperationProductList()) {

              if ("+".equals(product.getProductionType())) {
                BigDecimal qty = product.getQuantity();
                info.addResult("inpemSsprodpStop", qty != null ? qty : BigDecimal.ZERO);
                return; 
              }
            }
          }
        }
        info.addResult("inpemSsprodpStop", BigDecimal.ZERO);
    }

}
