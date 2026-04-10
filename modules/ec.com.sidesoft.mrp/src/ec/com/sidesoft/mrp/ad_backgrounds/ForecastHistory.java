package ec.com.sidesoft.mrp.ad_backgrounds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.erpCommon.utility.*;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductCategory;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.utils.CryptoUtility;

import ec.com.sidesoft.mrp.SsmrpConfigForecast;
import ec.com.sidesoft.mrp.SsmrpSalesForecast;

import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProvider;

public class ForecastHistory extends DalBaseProcess implements KillableProcess {

  private static final Logger log4j = Logger.getLogger(ForecastHistory.class);
  private static ProcessLogger logger;
  private boolean killProcess = false;
  protected ConnectionProvider conn;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {

    VariablesSecureApp vars = bundle.getContext().toVars();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    this.conn = conn;

    try {
      OBContext.setAdminMode(true);
      logger = bundle.getLogger();
      OBCriteria<SsmrpConfigForecast> configQuery = OBDal.getInstance()
          .createCriteria(SsmrpConfigForecast.class);
      configQuery.setMaxResults(1);

      // Validacion configuracion existente
      if (configQuery.count() <= 0) {
        throw new Exception(
            Utility.messageBD(conn, "Se requiere una configuracion valida", language));
      }

      SsmrpConfigForecast config = (SsmrpConfigForecast) configQuery.uniqueResult();

      OBCriteria<ProductCategory> catcrt = OBDal.getInstance()
          .createCriteria(ProductCategory.class);
      HttpCookie cookie = getSession(config);
      List<ProductCategory> listcat = catcrt.list();
      System.out.println(bundle.getContext().getOrganization());

      Organization org = OBDal.getInstance().get(Organization.class,
          bundle.getContext().getOrganization().toString());

      String allOrg = org.getOrganizationType().isLegalEntity().equals(true) ? "Y" : "N";
      for (ProductCategory productCategory : listcat) {

        ProductHistoryData data[] = ProductHistoryData.select(this.conn, productCategory.getId(),
            allOrg, org.getId());
        List<JSONObject> products = new ArrayList<JSONObject>();

        for (ProductHistoryData productData : data) {
          JSONObject product = new JSONObject();
          product.put("id", productData.id);
          product.put("key", productData.key);
          product.put("value", productData.qty);
          product.put("date", productData.date);
          products.add(product);
        }

        if (products.size() > 0) {
          StringBuilder response = sendHistory(cookie, config, products, org.getName());
          JSONObject json = new JSONObject(response.toString());
          JSONObject resultobj = null;
          // logger.logln("doExecute: " + "generate history to: " + productCategory.getName().trim()
          // + ", # " + products.size());
          if (json.has("result")) {
            resultobj = json.getJSONObject("result");
            if (resultobj.has("message") && resultobj.get("status").equals("error")) {
              throw new OBException(resultobj.get("message").toString());
            }
          }
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
      logger.logln("doExecute: " + e.getMessage());
      log4j.info("doExecute: " + e.getMessage());
      // throw new OBException(e.getMessage());
    } finally {
      OBContext.setAdminMode(false);
    }
  }

  @Override
  public void kill(ProcessBundle processBundle) throws Exception {
    log4j.info("kill process ForecastHistory");
    logger.logln("kill process ForecastHistory");
    OBDal.getInstance().flush();
    this.killProcess = true;
  }

  private HttpCookie getSession(SsmrpConfigForecast config) {

    try {
      CookieManager cookieManager = new CookieManager();
      CookieHandler.setDefault(cookieManager);

      JSONObject params = new JSONObject();
      params.put("db", config.getForecast());
      params.put("login", config.getUserForecast());
      params.put("password", CryptoUtility.decrypt(config.getPasswordForecast()));
      JSONObject data = new JSONObject();
      data.put("jsonrpc", "2.0");
      data.put("params", params);

      // data.put("products", products);
      URL url = new URL(config.getHostForecast() + "/web/session/authenticate");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("Accept", "application/json");
      con.setDoOutput(true);
      String jsonInputString = data.toString();
      // System.out.println(jsonInputString);
      try (OutputStream os = con.getOutputStream()) {
        byte[] input = jsonInputString.getBytes("utf-8");
        os.write(input, 0, input.length);
      }

      try (BufferedReader br = new BufferedReader(
          new InputStreamReader(con.getInputStream(), "utf-8"))) {
        StringBuilder response = new StringBuilder();
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
          response.append(responseLine.trim());
        }
      }
      List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
      for (HttpCookie cookie : cookies) {
        cookie.getName();
        cookie.getValue();
        if (cookie.getName().equals("session_id")) {
          return cookie;
        }
      }

    } catch (Exception e) {
      throw new OBException("getSession: " + e.getMessage());
    }

    return null;
  }

  private StringBuilder sendProducts(HttpCookie cookie, SsmrpConfigForecast config,
      List<JSONObject> products) {

    try {
      JSONObject data = new JSONObject();
      JSONObject params = new JSONObject();
      params.put("lines", products);

      data.put("params", params);

      URL url = new URL(config.getHostForecast() + "/api_products");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("Accept", "application/json");
      con.setRequestProperty("Cookie", cookie.toString());
      con.setDoOutput(true);
      String jsonInputString = data.toString();

      try (OutputStream os = con.getOutputStream()) {
        byte[] input = jsonInputString.getBytes("utf-8");
        os.write(input, 0, input.length);
      }

      StringBuilder response = new StringBuilder();

      try (BufferedReader br = new BufferedReader(
          new InputStreamReader(con.getInputStream(), "utf-8"))) {
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
          response.append(responseLine.trim());
        }
      }
      return response;

    } catch (Exception e) {
      throw new OBException("sendProducts: " + e.getMessage());
    }
  }

  private StringBuilder sendHistory(HttpCookie cookie, SsmrpConfigForecast config,
      List<JSONObject> products, String Org) {

    try {
      JSONObject data = new JSONObject();
      JSONObject params = new JSONObject();
      params.put("lines", products);
      params.put("company", Org);

      data.put("params", params);

      URL url = new URL(config.getHostForecast() + "/api_history");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("Content-Type", "application/json");
      con.setRequestProperty("Accept", "application/json");
      con.setRequestProperty("Cookie", cookie.toString());
      con.setDoOutput(true);
      String jsonInputString = data.toString();

      try (OutputStream os = con.getOutputStream()) {
        byte[] input = jsonInputString.getBytes("utf-8");
        os.write(input, 0, input.length);
      }

      StringBuilder response = new StringBuilder();

      try (BufferedReader br = new BufferedReader(
          new InputStreamReader(con.getInputStream(), "utf-8"))) {
        String responseLine = null;
        while ((responseLine = br.readLine()) != null) {
          response.append(responseLine.trim());
        }
      }
      return response;

    } catch (Exception e) {
      throw new OBException("sendProducts: " + e.getMessage());
    }
  }

}
