package ec.com.sidesoft.custom.ws.api.webservices;

import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.service.web.WebService;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.sidesoft.custom.ws.api.webservices.util.SCWSAP_Utility;

public class ApiWS implements WebService {
  // private static final Logger logger = Logger.getLogger(ApiWS.class);
  // private static final long serialVersionUID = 1L;

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject json = new JSONObject();
    String action = request.getParameter("action");
    switch (action) {
    case "setCoordinates":
      JsonElement element = new JsonParser().parse(new InputStreamReader(request.getInputStream()));
      JsonObject jsonData = element.getAsJsonObject();
      json = SCWSAP_Utility.setCoordinates(jsonData);
      break;
    case "setDataPartner":
      JsonElement element1 = new JsonParser()
          .parse(new InputStreamReader(request.getInputStream()));
      JsonObject jsonData1 = element1.getAsJsonObject();
      json = SCWSAP_Utility.setDataPartner(jsonData1);
      break;
    }
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    final Writer w = response.getWriter();
    w.write(json.toString());
    w.close();
  }

  @Override
  public void doDelete(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    response.sendError(405);
  }

  @Override
  public void doPut(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    response.sendError(405);
  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<JSONObject> json = new ArrayList<JSONObject>();

    // JSONObject json = new JSONObject();
    // json.put("status", "OK");
    // json.put("message", "");

    try {
      String action = request.getParameter("action");
      switch (action) {
      case "getProducts":
        // json = SCWSAP_Utility.getProducts(request.getParameter("updated"),
        // request.getParameter("created"));
        json = SCWSAP_Utility.getProductsOrgWh(request.getParameter("updated"),
            request.getParameter("created"), request.getParameter("orgid"),
            request.getParameter("whid"));
        break;
      case "getProductsCategory":
        json = SCWSAP_Utility.getProductsCategory(request.getParameter("updated"),
            request.getParameter("created"));
        break;
      case "getPartners":
        json = SCWSAP_Utility.getPartners(request.getParameter("updated"),
            request.getParameter("created"));
        break;
      case "getPartnersPT":
        json = SCWSAP_Utility.getPartnersPT(request.getParameter("updated"),
            request.getParameter("created"), request.getParameter("paymentterm"));
        break;
      case "getPartnersCategory":
        json = SCWSAP_Utility.getPartnersCategory(request.getParameter("updated"),
            request.getParameter("created"));
        break;
      case "getPriceList":
        json = SCWSAP_Utility.getPriceList(request.getParameter("updated"),
            request.getParameter("created"));
        break;
      case "getProductsOrgWh":
        json = SCWSAP_Utility.getProductsOrgWh(request.getParameter("updated"),
            request.getParameter("created"), request.getParameter("orgid"),
            request.getParameter("whid"));
        break;
      default:
        throw new OBException("Accion no encontrada");
      }
    } catch (Exception e) {
      System.out.println("doGet: " + e.getMessage());
      // json.put("status", "ERROR");
      // json.put("message", e.getMessage());
    }
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    final Writer w = response.getWriter();
    w.write(json.toString());
    w.close();
  }

}
