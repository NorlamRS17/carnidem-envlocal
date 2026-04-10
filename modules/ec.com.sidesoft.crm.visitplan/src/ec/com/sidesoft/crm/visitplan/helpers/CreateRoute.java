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

public class CreateRoute {

  private Scrvro_VendorRouteConfig config;
  private String base;
  public String recordId;
  private Scrvro_RouteWeek record;
  private Scrvro_RoutePeriod period;
  private BusinessPartner salesRep;

  public void createRoute() {
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

      if (period.isGenerated()) {
        throw new OBException("Las rutas ya fueron generedas para este periodo");
      }

      salesRep = record.getBusinessAgent();
      if (salesRep.getScrvroLatitude() == null || salesRep.getScrvroLatitude().isEmpty()
          || salesRep.getScrvroLongitude() == null || salesRep.getScrvroLongitude().isEmpty()) {
        throw new OBException("Latitud y/o Longitud no encontrada para el representante de venta");
      }

      // Limpiamos las tablas temporales
      String sql = "DELETE FROM scrvro_distance_matrix WHERE salesrep_id='" + salesRep.getId()
          + "' RETURNING 1 AS result;";
      runQuery(sql);
      sql = "DELETE FROM scrvro_optimized_route WHERE salesrep_id='" + salesRep.getId()
          + "' RETURNING 1 AS result;";
      runQuery(sql);

      OBCriteria<Scrvro_RouteWeek> weeks = OBDal.getInstance()
          .createCriteria(Scrvro_RouteWeek.class);
      weeks.add(Restrictions.eq(Scrvro_RouteWeek.PROPERTY_BUSINESSAGENT, salesRep));
      weeks.add(Restrictions.eq(Scrvro_RouteWeek.PROPERTY_TYPE, "L"));
      if (weeks.list().size() > 0) {
        // System.out.println("Local: " + weeks.list().size());
        getOptimizedRoute("L");
      }

      weeks = OBDal.getInstance().createCriteria(Scrvro_RouteWeek.class);
      weeks.add(Restrictions.eq(Scrvro_RouteWeek.PROPERTY_BUSINESSAGENT, salesRep));
      weeks.add(Restrictions.eq(Scrvro_RouteWeek.PROPERTY_TYPE, "E"));
      if (weeks.list().size() > 0) {
        // System.out.println("External: " + weeks.list().size());
        getOptimizedRoute("E");
      }

      period.setGenerated(true);
      OBDal.getInstance().save(period);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      System.out.println("createRoute: " + e.getMessage());
      throw new OBException(e);
    }
  }

  private void getOptimizedRoute(String typeRoute) {
    try {
      List<BusinessPartner> bPartners = getClientList(typeRoute);
      BusinessPartner origin = salesRep;
      while (bPartners.size() > 0) {
        String uri = "&origins=" + origin.getScrvroLatitude() + "%2C" + origin.getScrvroLongitude()
            + "&destinations=";
        String destinations = "";
        int count = 0, from = -1, to, last = bPartners.size();

        for (int i = 0; i < last; i++) {
          // Determina el inicio de un bloque de 25 clientes
          if (from == -1) {
            from = i;
          }

          BusinessPartner bPartner = bPartners.get(i);
          if (count < 25) {
            if (destinations.isEmpty()) {
              destinations = destinations + bPartner.getScrvroLatitude() + "%2C"
                  + bPartner.getScrvroLongitude();
            } else {
              destinations = destinations + "|" + bPartner.getScrvroLatitude() + "%2C"
                  + bPartner.getScrvroLongitude();
            }
            count++;
          }

          if (count >= 25 || i == last - 1) {
            to = i;
            // System.out.println("from: " + from + " | to: " + to);

            String endpoint = base + uri + destinations;
            JSONObject json = getRequest(endpoint);
            JSONArray destinationAddresses = json.getJSONArray("destination_addresses");
            JSONArray rows = json.getJSONArray("rows");
            JSONArray elements = rows.getJSONObject(0).getJSONArray("elements");

            for (int j = 0; j < elements.length(); j++) {
              JSONObject element = elements.getJSONObject(j);
              JSONObject distance = element.getJSONObject("distance");
              JSONObject duration = element.getJSONObject("duration");
              BusinessPartner bPartnerTmp = bPartners.get(from + j);

              Scrvro_DistanceMatrix distanceMatrix = OBProvider.getInstance()
                  .get(Scrvro_DistanceMatrix.class);
              distanceMatrix.setNewOBObject(true);
              distanceMatrix.setSalesRepresentative(salesRep);
              distanceMatrix.setBpartnerFrom(origin);
              distanceMatrix.setBpartnerTo(bPartnerTmp);
              distanceMatrix.setLatitude(bPartnerTmp.getScrvroLatitude());
              distanceMatrix.setLongitude(bPartnerTmp.getScrvroLongitude());
              distanceMatrix.setDestinationAddresses(destinationAddresses.getString(j));
              distanceMatrix.setDistance(new BigDecimal(distance.getDouble("value")));
              distanceMatrix.setDuration(new BigDecimal(duration.getDouble("value")));
              distanceMatrix.setType(typeRoute);

              OBDal.getInstance().save(distanceMatrix);
              OBDal.getInstance().flush();
            }

            count = 0;
            from = -1;
            destinations = "";
          }
        }

        String sql = "SELECT scrvro_nearest_point('" + salesRep.getId() + "','" + origin.getId()
            + "','" + typeRoute + "') AS result";
        String originId = runQuery(sql);
        System.out.println(originId);

        origin = OBDal.getInstance().get(BusinessPartner.class, originId);
        bPartners = getClientList(typeRoute);
      }

      // Dividir en semanas
      String sql = "SELECT scrvro_divide_by_week('" + salesRep.getId() + "','" + record.getId()
          + "','" + typeRoute + "') AS result";
      runQuery(sql);
    } catch (Exception e) {
      System.out.println("getOptimizedRoute: " + e.getMessage());
      throw new OBException(e);
    }
  }

  private List<BusinessPartner> getClientList(String typeRoute) {
    Exception ex = null;
    List<BusinessPartner> bPartners = new ArrayList<BusinessPartner>();
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    try {
      String sql = "";
      if (typeRoute.equals("L")) {
        sql = "SELECT bp.c_bpartner_id FROM c_bpartner AS bp "
            + "JOIN c_bpartner_location AS bpl ON bpl.c_bpartner_id=bp.c_bpartner_id "
            + "JOIN c_location AS l ON l.c_location_id=bpl.c_location_id "
            + "JOIN (SELECT bp.c_bpartner_id, l.c_region_id FROM c_bpartner AS bp "
            + " JOIN c_bpartner_location AS bpl ON bpl.c_bpartner_id=bp.c_bpartner_id "
            + " JOIN c_location AS l ON l.c_location_id=bpl.c_location_id "
            + " WHERE bp.c_bpartner_id='" + salesRep.getId() + "' "
            + ") AS sr ON sr.c_region_id=l.c_region_id "
            + "LEFT JOIN scrvro_optimized_route AS op ON op.salesrep_id='" + salesRep.getId()
            + "' AND op.c_bpartner_id=bp.c_bpartner_id AND op.type_route='L' "
            + "WHERE bp.salesrep_id='" + salesRep.getId()
            + "' AND bp.em_scrvro_latitude IS NOT NULL AND bp.em_scrvro_longitude IS NOT NULL AND op.scrvro_optimized_route_id IS NULL "
            + "ORDER BY bp.c_bpartner_id";
      } else {
        sql = "SELECT bp.c_bpartner_id FROM c_bpartner AS bp "
            + "JOIN c_bpartner_location AS bpl ON bpl.c_bpartner_id=bp.c_bpartner_id "
            + "JOIN c_location AS l ON l.c_location_id=bpl.c_location_id "
            + "JOIN (SELECT DISTINCT pr.c_region_id FROM scrvro_province AS pr "
            + " JOIN scrvro_vendor_route_line AS vrl ON vrl.scrvro_vendor_route_line_id=pr.scrvro_vendor_route_line_id "
            + " JOIN scrvro_vendor_route AS vr ON vr.scrvro_vendor_route_id=vrl.scrvro_vendor_route_id "
            + " WHERE vr.isactive='Y' AND vr.c_bpartner_id='" + salesRep.getId()
            + "' AND vrl.isactive='Y' AND vrl.type_route='E' "
            + ") AS sr ON sr.c_region_id=l.c_region_id "
            + "LEFT JOIN scrvro_optimized_route AS op ON op.salesrep_id='" + salesRep.getId()
            + "' AND op.c_bpartner_id=bp.c_bpartner_id AND op.type_route='E' "
            + "WHERE bp.salesrep_id='" + salesRep.getId()
            + "' AND bp.em_scrvro_latitude IS NOT NULL AND bp.em_scrvro_longitude IS NOT NULL AND op.scrvro_optimized_route_id IS NULL "
            + "ORDER BY bp.c_bpartner_id";
      }
      st = conn.getPreparedStatement(sql);
      ResultSet resultSet = st.executeQuery();

      while (resultSet.next()) {
        BusinessPartner bPartner = OBDal.getInstance().get(BusinessPartner.class,
            resultSet.getString("c_bpartner_id"));
        bPartners.add(bPartner);
      }
    } catch (Exception e) {
      System.out.println("getClientList: " + e.getMessage());
      ex = e;
    } finally {
      try {
        conn.releasePreparedStatement(st);
        if (ex != null) {
          throw new OBException(ex);
        }
      } catch (Exception e2) {
        e2.printStackTrace();
        throw new OBException(e2);
      }
    }
    return bPartners;
  }

  public String runQuery(String sql) {
    Exception ex = null;
    String result = "";
    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;
    try {
      st = conn.getPreparedStatement(sql);
      ResultSet resultSet = st.executeQuery();
      while (resultSet.next()) {
        result = resultSet.getString("result");
      }
    } catch (Exception e) {
      System.out.println("getClientList: " + e.getMessage());
      ex = e;
    } finally {
      try {
        conn.releasePreparedStatement(st);
        if (ex != null) {
          throw new OBException(ex);
        }
      } catch (Exception e2) {
        e2.printStackTrace();
        throw new OBException(e2);
      }
    }
    return result;
  }

  private JSONObject getRequest(String endpoint) {
    JSONObject json = null;
    try {
      URL url = new URL(endpoint);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("Accept", "application/json");
      con.setDoOutput(true);

      try (BufferedReader br = new BufferedReader(
          new InputStreamReader(con.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
          response.append(responseLine.trim());
        }
        json = new JSONObject(response.toString());
      }
    } catch (Exception e) {
      System.out.println("getRequest: " + e.getMessage());
      throw new OBException(e);
    }
    return json;
  }

}
