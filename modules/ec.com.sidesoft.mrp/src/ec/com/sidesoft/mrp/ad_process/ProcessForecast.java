package ec.com.sidesoft.mrp.ad_process;

import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.InputStreamReader;
import org.openbravo.utils.CryptoUtility;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;

import java.sql.BatchUpdateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import org.openbravo.base.secureApp.VariablesSecureApp;

import org.openbravo.client.kernel.RequestContext;
import org.openbravo.client.application.attachment.AttachImplementationManager;
import org.openbravo.client.application.attachment.AttachmentAH;
import org.openbravo.client.application.attachment.AttachmentUtils;
import org.openbravo.client.application.attachment.CoreAttachImplementation;
import org.openbravo.client.application.event.RemoveImagesEventHandler;
import org.openbravo.base.session.OBPropertiesProvider;

import org.openbravo.xmlEngine.XmlDocument;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.sidesoft.mrp.SsmrpConfigForecast;
import ec.com.sidesoft.mrp.SsmrpSalesForecast;
import ec.com.sidesoft.mrp.SsmrpForecastLog;
import com.google.gson.JsonParser;

import org.openbravo.model.mrp.SalesForecast;
import org.openbravo.model.mrp.SalesForecastLine;

import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.domain.Reference;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ProcessForecast extends DalBaseProcess implements KillableProcess {

  OBError message;
  private boolean insert = false;
  private int processed;
  private int notprocessed;
  private int rejected;
  private boolean cancelled;
  protected ConnectionProvider conn;
  protected VariablesSecureApp vars;
  protected String language;
  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  private boolean stop = false;
  // private static Logger log4j1 = Logger.getLogger(ProcessFile.class);

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception, IOException {

    VariablesSecureApp vars = bundle.getContext().toVars();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    this.conn = conn;
    this.vars = vars;
    this.language = language;

    try {
      message = new OBError();
      processRequest(bundle);
    } catch (Exception e) {
      // log4j1.info("exeption" + e);
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      kill(bundle);
      // bundle.setResult(message);
      System.out.println(message.toString());
    }
  }

  @Override
  public void kill(ProcessBundle processBundle) throws Exception {
    this.stop = true;
  }

  public void processRequest(ProcessBundle bundle) throws Exception {

    String messageT = "";
    String typeM = "";
    String titleM = "";
    String processType = "";
    String recordId = (String) bundle.getParams().get("Ssmrp_Sales_Forecast_ID");
    ProductData data[] = null;
    OBCriteria<SsmrpConfigForecast> configQuery = OBDal.getInstance()
        .createCriteria(SsmrpConfigForecast.class);
    configQuery.setMaxResults(1);

    // Validacion configuracion existente
    if (configQuery.count() <= 0) {
      throw new Exception(
          Utility.messageBD(conn, "Se requiere una configuracion valida", language));
    }
    SsmrpConfigForecast config = (SsmrpConfigForecast) configQuery.uniqueResult();

    SsmrpSalesForecast record = OBDal.getInstance().get(SsmrpSalesForecast.class, recordId);

    String allOrg = record.getOrganization().getOrganizationType().isLegalEntity().equals(true)
        ? "Y"
        : "N";

    // Get only product
    if (record.getProduct() != null && record.getProductCategory() == null) {
      data = ProductData.select(this.conn, dateFormat.format(record.getDateFrom()),
          dateFormat.format(record.getDateTo()), record.getProduct().getId(), allOrg,
          record.getOrganization().getId());
    }
    // get by category
    if (record.getProduct() == null && record.getProductCategory() != null) {
      data = ProductData.selectcat(this.conn, dateFormat.format(record.getDateFrom()),
          dateFormat.format(record.getDateTo()), record.getProductCategory().getId(), allOrg,
          record.getOrganization().getId());
    }
    // get by category and product
    if (record.getProduct() != null && record.getProductCategory() != null) {
      data = ProductData.selectprodcat(this.conn, dateFormat.format(record.getDateFrom()),
          dateFormat.format(record.getDateTo()), record.getProduct().getId(),
          record.getProductCategory().getId(), allOrg, record.getOrganization().getId());
    }
    // get all
    if (record.getProduct() == null && record.getProductCategory() == null) {
      data = ProductData.selectall(this.conn, dateFormat.format(record.getDateFrom()),
          dateFormat.format(record.getDateTo()), allOrg, record.getOrganization().getId());
    }

    List<JSONObject> products = new ArrayList<JSONObject>();
    for (ProductData productData : data) {
      JSONObject product = new JSONObject();
      product.put("id", productData.id);
      product.put("key", productData.key);
      products.add(product);
    }

    // Validacion lineas existentes validas
    if (products.size() <= 0) {
      throw new Exception(Utility.messageBD(conn,
          "No se encontraron transacciones en el rango de fechas establecida.", language));
    }

    HttpCookie cookie = getSession(config);
    StringBuilder response = getvalues(cookie, config, record, products);
    JSONObject json = new JSONObject(response.toString());
    JSONObject resultobj = null;
    JSONObject data_forecast = null;
    JSONArray log_forecast = null;
    JSONArray data_forecastr = null;
    StringBuilder responseResult = null;

    if (json.has("result")) {
      resultobj = json.getJSONObject("result");
      data_forecast = resultobj.getJSONObject("data");
      log_forecast = resultobj.getJSONArray("log");
    }

    if (log_forecast.length() > 0) {
      generateLog(record, log_forecast);
      System.out.println("printlog" + log_forecast.length());
      log_forecast = null;
    }

    if (data_forecast.has("ks_forecast") && data_forecast.has("ks_name")
        && !resultobj.get("status").equals("error")) {
      responseResult = getvaluesResult(cookie, config, record, data_forecast);
      JSONObject json_result = new JSONObject(responseResult.toString());
      if (json_result.has("result")) {
        resultobj = json_result.getJSONObject("result");
        System.out.println(resultobj.toString());
        data_forecastr = resultobj.getJSONArray("data");
      }
    }

    if (resultobj.has("message") && resultobj.get("status").equals("error")) {

      typeM = "Error";
      titleM = "Error";
      message.setMessage(resultobj.get("message").toString());
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);

    } else {
      if (data_forecastr.length() > 0) {
        generateResult(config, data_forecastr);
        System.out.println("printres" + data_forecastr.length());
        data_forecastr = null;
      }
      System.out.println("printres" + data_forecastr.length());

      typeM = "Success";
      titleM = "ProcessOK";
      messageT = "El proceso de se realizó correctamente.";
      // record.setAlertStatus(recordId);("PR");
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
      record.setStatus("CO");
      OBDal.getInstance().flush();

    }

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

  private StringBuilder getvalues(HttpCookie cookie, SsmrpConfigForecast config,
      SsmrpSalesForecast record, List<JSONObject> products) {

    try {
      JSONObject data = new JSONObject();
      JSONObject params = new JSONObject();
      params.put("company", record.getOrganization().getName().trim());
      params.put("start_date", dateFormat.format(record.getDateFrom()));
      params.put("end_date", dateFormat.format(record.getDateTo()));
      params.put("forecast_method", record.getForecastMethod().trim());
      params.put("forecast_period", record.getForecastPeriod().trim());
      params.put("forecast_unit", record.getQTYPeriod());
      params.put("lines", products);

      data.put("params", params);

      URL url = new URL(config.getHostForecast() + "/api_external");
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
      throw new OBException("getvalues: " + e.getMessage());
    }
  }

  private StringBuilder getvaluesResult(HttpCookie cookie, SsmrpConfigForecast config,
      SsmrpSalesForecast record, JSONObject vals) {

    try {
      JSONObject data = new JSONObject();
      JSONObject params = new JSONObject();
      params.put("end_date", dateFormat.format(record.getDateTo()));
      params.put("forecast_id", vals.get("ks_forecast"));
      params.put("forecast_name", vals.get("ks_name"));
      data.put("params", params);

      URL url = new URL(config.getHostForecast() + "/api_results");
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
      throw new OBException("getvalues: " + e.getMessage());
    }
  }

  private void generateResult(SsmrpConfigForecast config, JSONArray data)
      throws JSONException, ParseException {

    SalesForecast forect = OBProvider.getInstance().get(SalesForecast.class);
    forect.setDocumentDate(new Date());
    forect.setBusinessPartner(config.getBusinessPartner());
    OBDal.getInstance().save(forect);
    OBDal.getInstance().flush();
    String documentno = "";

    for (int i = 0; i < data.length(); i++) {
      JSONObject json = new JSONObject(data.getJSONObject(i).toString());

      SalesForecastLine line = OBProvider.getInstance().get(SalesForecastLine.class);
      documentno = json.get("ks_document").toString().toUpperCase();

      Product product = OBDal.getInstance().get(Product.class, json.get("ks_product").toString());

      if (product != null) {
        line.setProduct(product);
      }

      line.setSalesForecast(forect);
      line.setPlannedDate(dateFormat.parse(json.get("ks_date").toString()));
      line.setQuantity(new BigDecimal(json.get("ks_value").toString()));
      OBDal.getInstance().save(line);
      OBDal.getInstance().flush();

    }
    forect.setDescription(documentno);

  }

  private void generateLog(SsmrpSalesForecast forecast, JSONArray data)
      throws JSONException, ParseException {

    for (int i = 0; i < data.length(); i++) {
      JSONObject json = new JSONObject(data.getJSONObject(i).toString());

      try {
        SsmrpForecastLog line = OBProvider.getInstance().get(SsmrpForecastLog.class);

        Product product = OBDal.getInstance().get(Product.class, json.get("ks_product").toString());

        if (product != null) {
          line.setProduct(product);
        }
        line.setSsmrpSalesForecast(forecast);
        OBDal.getInstance().save(line);
        OBDal.getInstance().flush();
      } catch (Exception e) {
        throw new OBException("generateLog: " + e.getMessage());
      }
    }
  }

  public String truncate(String value, int length) {

    if (value == null || value.equals("")) {
      return null;
    } else {
      if (value.length() > length) {
        return value.substring(0, length);
      } else {
        return value;
      }
    }
  }
}
