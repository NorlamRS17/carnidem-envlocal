package ec.com.sidesoft.crm.visitplan.helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.crm.visitplan.Scrvro_DistanceMatrix;
import ec.com.sidesoft.crm.visitplan.Scrvro_RoutePeriod;
import ec.com.sidesoft.crm.visitplan.Scrvro_RouteWeek;
import ec.com.sidesoft.crm.visitplan.Scrvro_VendorRouteConfig;

public class RecalculateRoute {

  private Scrvro_VendorRouteConfig config;
  private String base;
  public String recordId;
  private Scrvro_RouteWeek record;
  private Scrvro_RoutePeriod period;
  private BusinessPartner salesRep;

  public void recalculateRoute() {
    try {
      OBCriteria<Scrvro_VendorRouteConfig> configs = OBDal.getInstance()
          .createCriteria(Scrvro_VendorRouteConfig.class);
      configs.add(Restrictions.eq(Scrvro_VendorRouteConfig.PROPERTY_ACTIVE, true));
      if (configs.list().size() == 0) {
        throw new OBException("Configuracion general de rutas por vendedor no encontrada");
      }
      config = configs.list().get(0);

      base = config.getEndpoint() + "distancematrix/json?key=" + config.getGMapKey();

      record = OBDal.getInstance().get(Scrvro_RouteWeek.class, recordId);

      period = record.getScrvroRoutePeriod();

      salesRep = record.getBusinessAgent();
      if (salesRep.getScrvroLatitude() == null || salesRep.getScrvroLatitude().isEmpty()
          || salesRep.getScrvroLongitude() == null || salesRep.getScrvroLongitude().isEmpty()) {
        throw new OBException("Latitud y/o Longitud no encontrada para el representante de venta");
      }

      CreateRoute createRoute = new CreateRoute();

      // Limpiamos las tablas temporales
      String sql = "DELETE FROM scrvro_distance_matrix WHERE salesrep_id='" + salesRep.getId()
          + "' RETURNING 1 AS result;";
      createRoute.runQuery(sql);
      sql = "DELETE FROM scrvro_optimized_route WHERE salesrep_id='" + salesRep.getId()
          + "' RETURNING 1 AS result;";
      createRoute.runQuery(sql);

    } catch (Exception e) {
      System.out.println("createRoute: " + e.getMessage());
      throw new OBException(e);
    }
  }
}
