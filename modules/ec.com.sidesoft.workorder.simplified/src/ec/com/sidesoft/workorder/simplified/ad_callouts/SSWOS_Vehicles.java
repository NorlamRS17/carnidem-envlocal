package ec.com.sidesoft.workorder.simplified.ad_callouts;

import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

import ec.com.sidesoft.workorder.simplified.SswosVehicle;
import ec.com.sidesoft.workorder.simplified.SswosVehicleRecall;

public class SSWOS_Vehicles extends SimpleCallout {

  /**
   * 
   */

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strLastChanged = info.getLastFieldChanged();

    String strnumerochasis = info.getStringParameter("inpnumerochasis", null);
    String strplaca = info.getStringParameter("inpplaca", null);

    OBCriteria<SswosVehicle> LstObjSswosVehicle = OBDal.getInstance()
        .createCriteria(SswosVehicle.class);

    if (strLastChanged.equals("inpplaca")) {
      LstObjSswosVehicle.add(Restrictions.eq(SswosVehicle.PROPERTY_PLATE, strplaca));
    }

    if (strLastChanged.equals("inpnumerochasis")) {
      LstObjSswosVehicle.add(Restrictions.eq(SswosVehicle.PROPERTY_CHASSISNUMBER, strnumerochasis));

      OBCriteria<SswosVehicleRecall> LstObjSswosVehicleRecall = OBDal.getInstance()
          .createCriteria(SswosVehicleRecall.class);
      LstObjSswosVehicleRecall
          .add(Restrictions.eq(SswosVehicleRecall.PROPERTY_CHASSISNUMBER, strnumerochasis));
      if (LstObjSswosVehicleRecall.count() != 0) {
        info.addResult("WARNING", "Alerta: Vehículo con Recall pendiente.");
      }
    }

    List<SswosVehicle> LstSswosVehicle = LstObjSswosVehicle.list();

    for (SswosVehicle Vehicle : LstSswosVehicle) {
      info.addResult("inplstipovehiculo", Vehicle.getVehicleType());
      if (Vehicle.getBrand() != null) {
        info.addResult("inpmarca", Vehicle.getBrand().getName());
        info.addResult("inpemSswosMBrandId", Vehicle.getBrand().getId());
      } else {
        info.addResult("inpmarca", null);
        info.addResult("inpemSswosMBrandId", null);
      }
      if (Vehicle.getModel() != null) {
        info.addResult("inpmodelo", Vehicle.getModel().getName());
        info.addResult("inpemSswosSsfiModelProdId", Vehicle.getModel().getId());
      } else {
        info.addResult("inpmodelo", null);
        info.addResult("inpemSswosSsfiModelProdId", null);
      }
      if (Vehicle.getSswosYear() != null) {
        info.addResult("inpanio", Vehicle.getSswosYear().getName());
        info.addResult("inpemSswosYearId", Vehicle.getSswosYear().getId());
      } else {
        info.addResult("inpanio", null);
        info.addResult("inpemSswosYearId", null);
      }
      info.addResult("inpnumeromotor", Vehicle.getEngineNumber());
      info.addResult("inpnumerochasis", Vehicle.getChassisNumber());
      info.addResult("inpplaca", Vehicle.getPlate());
      if (Vehicle.getSswosColor() != null) {
        info.addResult("inplscolor", Vehicle.getSswosColor().getName());
        info.addResult("inpemSswosColorId", Vehicle.getSswosColor().getId());
      } else {
        info.addResult("inplscolor", null);
        info.addResult("inpemSswosColorId", null);
      }
      info.addResult("inpkmhoras", Vehicle.getKilometerHours());
      info.addResult("inpfechaventa", Vehicle.getSaleDate());
      if (Vehicle.getOrgSale() != null) {
        info.addResult("inpadOrgVentaId", Vehicle.getOrgSale().getId());
      } else {
        info.addResult("inpadOrgVentaId", null);
      }
    }
  }
}
