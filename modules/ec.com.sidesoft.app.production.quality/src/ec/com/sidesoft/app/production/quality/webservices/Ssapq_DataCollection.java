package ec.com.sidesoft.app.production.quality.webservices;

import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.manufacturing.quality.MeasureShift;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

import ec.com.sidesoft.app.production.quality.utils.Ssapq_Helper;
import ec.com.sidesoft.custom.ws.api.ScwsapLog;

public class Ssapq_DataCollection implements WebService {
  private final Logger logger = Logger.getLogger(Ssapq_DataCollection.class);

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject json = new JSONObject();
    String logId = null;
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      OBContext.setAdminMode(true);
      logger.info("Begin Ssapq_RawMaterial doGet");

      JSONObject body = Ssapq_Helper.readAllIntoJSONObject(request.getInputStream());

      ScwsapLog log = Ssapq_Helper.createLog(body, "createRawMaterial", "IN");
      logId = log.getId();

      createDataCollectionMaterial(conn, body);
      json = Ssapq_Helper.getResponse(body);

      log.setJsonResponse(json.toString());
      log.setRecordID(body.getString("id"));
      log.setResult("OK");
      OBDal.getInstance().save(log);
      OBDal.getInstance().flush();
      OBDal.getInstance().commitAndClose();
    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      String message = Ssapq_Helper.getErrorMessage(logger, e);
      logger.error(message);
      ScwsapLog log = OBDal.getInstance().get(ScwsapLog.class, logId);
      if (log != null) {
        log.setResult("ERROR");
        log.setError(message);
        OBDal.getInstance().save(log);
        OBDal.getInstance().flush();
        OBDal.getInstance().getConnection().commit();
      }
      json = Ssapq_Helper.getErrorResponse(message);
    } finally {
      try {
        conn.getConnection().close();
        conn.destroy();
      } catch (Exception e) {
        Ssapq_Helper.getErrorMessage(logger, e);
      }
      OBContext.restorePreviousMode();
      logger.info("Finish Ssapq_RawMaterial doPost");
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    Writer w = response.getWriter();
    w.write(json.toString());
    w.close();

  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject json = new JSONObject();

    try {
      OBContext.setAdminMode(true);
      logger.info("Begin Ssapq_DataCollection doGet");

      JSONObject body = new JSONObject();
      getDataCollection(body);
      json = Ssapq_Helper.getResponse(body);
    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      String message = Ssapq_Helper.getErrorMessage(logger, e);
      logger.error(message);
      json = Ssapq_Helper.getErrorResponse(message);
    } finally {
      OBContext.restorePreviousMode();
      logger.info("Finish Ssapq_DataCollection doGet");
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

  public void getDataCollection(JSONObject body) throws Exception {
    ConnectionProvider conn = new DalConnectionProvider(false);
    SsapqDataCollectionData data[] = SsapqDataCollectionData.dataCollection(conn);

    JSONArray dataList = new JSONArray();

    for (SsapqDataCollectionData line : data) {
      JSONObject ln = new JSONObject();
      ln.put("status", line.status);
      ln.put("turn", line.turn);
      ln.put("qualityControl", line.qualityControl);
      ln.put("typeControl", line.typeControl);
      ln.put("supplier", line.supplier);
      ln.put("supplierInout", line.supplierInout);
      ln.put("material", line.material);
      ln.put("deliveryDate", line.deliveryDate);
      ln.put("totalMaterial", line.totalMaterial);
      ln.put("lote", line.lote);
      ln.put("exteriorCleaning", line.exteriorCleaning);
      ln.put("interiorCleaning", line.interiorCleaning);
      ln.put("protectContamination", line.protectContamination);
      dataList.put(ln);
    }

    body.put("material", dataList);

  }

  public MeasureShift createDataCollectionMaterial(ConnectionProvider conn, JSONObject body)
      throws Exception {
    Date measurementDate = Ssapq_Helper.getDate(body, "measurementDate", true);
    String plate = Ssapq_Helper.getString(body, "plate", true);
    String arrivalTime = Ssapq_Helper.getString(body, "arrivalTime", true);
    String sampleSize = Ssapq_Helper.getString(body, "sampleSize", true);
    Long numberTakes = Ssapq_Helper.getLong(body, "numberTakes", true);
    String observation = Ssapq_Helper.getString(body, "observation", true);

    MeasureShift material = OBProvider.getInstance().get(MeasureShift.class);
    material.setMeasurementDate(measurementDate);
    material.setSpqulyLicenseplate(plate);
    material.setSpqulyCheckin(arrivalTime);
    material.setSpqulySamplesize(sampleSize);
    material.setSpqulyTakes(numberTakes);
    material.setComments(StringUtils.substring(observation, 0, 250));
    material.setSpqulyQualitycontroltype("RMQ");
    material.setShift("M");

    OBDal.getInstance().save(material);
    OBDal.getInstance().flush();
    body.put("id", material.getId());

    return material;
  }

}
