package ec.com.sidesoft.app.production.quality.webservices;

import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

import ec.com.sidesoft.app.production.quality.utils.Ssapq_Helper;

public class Ssapq_ManufacturingPart implements WebService {
  private final Logger logger = Logger.getLogger(Ssapq_ManufacturingPart.class);
  private static final Object lock = new Object();

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject json = new JSONObject();

    try {
      OBContext.setAdminMode(true);
      logger.info("Begin Ssapq_ManufacturingPart doGet");

      String orgId = request.getParameter("orgId");

      JSONObject body = new JSONObject();
      getManufacturing(StringUtils.trim(orgId), body);
      json = Ssapq_Helper.getResponse(body);
    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      String message = Ssapq_Helper.getErrorMessage(logger, e);
      logger.error(message);
      json = Ssapq_Helper.getErrorResponse(message);
    } finally {
      OBContext.restorePreviousMode();
      logger.info("Finish Ssapq_ManufacturingPart doGet");
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    Writer w = response.getWriter();
    w.write(json.toString());
    w.close();
  }

  @Override
  public void doPut(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
  }

  @Override
  public void doDelete(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
  }

  public void getManufacturing(String orgId, JSONObject body) throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(false);
    SsapqOrderProductionData data[] = SsapqOrderProductionData.allOrganization(conn, orgId);

    JSONArray dataList = new JSONArray();
    for (SsapqOrderProductionData line : data) {
      JSONObject ln = new JSONObject();
      ln.put("wrphaseId", line.maWrphaseId);
      ln.put("name", line.nameOrd);
      ln.put("OrganizationId", line.adOrgId);
      ln.put("OrganizationName", line.orgName);
      ln.put("CostcenterVersion", line.versionCc);
      ln.put("CostcenterVersionID", line.versionCcId);
      ln.put("Quantity", line.quantity);
      ln.put("ConversionRate", line.conversionrate);
      ln.put("Unit", line.secondaryunit);
      dataList.put(ln);
    }

    body.put("production", dataList);
  }

}
