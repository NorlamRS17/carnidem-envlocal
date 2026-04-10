package ec.com.sidesoft.carnidem.production.ad_callouts;

import java.math.BigDecimal;
import javax.servlet.ServletException;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import ec.com.sidesoft.carnidem.production.crprodDimension;


public class GetDimensionalCounts extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    try {
      // Obtener el valor del campo CCP que dispara el callout
      final String ccpId = info.getStringParameter("inpemSpqulyCcpId", null);

      if (ccpId == null || ccpId.isEmpty()) {
        // No hay CCP seleccionado todavía, salir sin hacer nada
        return;
      }

      // Obtener el conteo de dimensiones asociadas al CCP
      Long count = getDimensionCountFromCcp(ccpId);

      // Si no hay registros, usar valor por defecto = 1
      if (count == null || count == 0L) {
        count = 1L;
      }

      // Enviar el resultado al formulario (actualiza campo EM_Spquly_Takes)
      info.addResult("inpemSpqulyTakes", new BigDecimal(count));

    } catch (Exception e) {
      log4j.error("Error en GetDimensionalCounts Callout: ", e);
      e.printStackTrace();
    }
  }

  private static Long getDimensionCountFromCcp(String ccpId) {
    Long count = 0L;
    try {
      // Crear criterio sobre crprod_dimension
    	OBCriteria<crprodDimension> crit = OBDal.getInstance().createCriteria(crprodDimension.class);
        crit.add(Restrictions.eq("qualityControlPointSet.id", ccpId));
        crit.setProjection(Projections.rowCount());

      count = (Long) crit.uniqueResult();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return (count == null ? 0L : count);
  }
}
