package ec.com.sidesoft.workorder.simplified.ad_callouts;

import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;

public class SSWOS_OrganizationWarehouse extends SimpleCallout {

  /**
   * 
   */

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strLastChanged = info.getLastFieldChanged();

    String stradOrgId = info.getStringParameter("inpadOrgId", null);
    String strIsconsol = info.getStringParameter("inpsswosIsconsol", null);
    Organization ObjOrganization = OBDal.getInstance().get(Organization.class, stradOrgId);

    OBCriteria<Warehouse> LstObjSswosVehicle = OBDal.getInstance().createCriteria(Warehouse.class);
    LstObjSswosVehicle.add(Restrictions.eq(Warehouse.PROPERTY_ORGANIZATION, ObjOrganization));
    if (strIsconsol.equals("N")) {
      List<Warehouse> LstSswosVehicle = LstObjSswosVehicle.list();
      if (LstObjSswosVehicle.list().size() > 0) {
        for (Warehouse objwarehouse : LstSswosVehicle) {
          info.addResult("inpmWarehouseId", objwarehouse.getId());
          break;
        }
      } else {
        info.addResult("inpmWarehouseId", "");
      }
    }
  }
}
