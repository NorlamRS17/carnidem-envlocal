package ec.com.sidesoft.app.production.quality.webservices;

import java.io.Writer;
import java.math.BigDecimal;
import java.sql.Timestamp;
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

public class Ssapq_DataCollectionProduct implements WebService {
  private final Logger logger = Logger.getLogger(Ssapq_DataCollectionProduct.class);

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    JSONObject json = new JSONObject();
    String logId = null;
    ConnectionProvider conn = new DalConnectionProvider(false);

    try {
      OBContext.setAdminMode(true);
      logger.info("Begin Ssapq_FinishingProduct doGet");

      JSONObject body = Ssapq_Helper.readAllIntoJSONObject(request.getInputStream());

      ScwsapLog log = Ssapq_Helper.createLog(body, "createFinishingProduct", "IN");
      logId = log.getId();

      createDataCollectionProduct(conn, body);
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
      logger.info("Finish Ssapq_FinishingProduct doPost");
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
      logger.info("Begin Ssapq_DataCollectionProduct doGet");

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
      logger.info("Finish Ssapq_DataCollectionProduct doGet");
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
    SsapqDataCollectionProductData data[] = SsapqDataCollectionProductData.dataProduct(conn);

    JSONArray dataList = new JSONArray();

    for (SsapqDataCollectionProductData line : data) {
      JSONObject ln = new JSONObject();
      ln.put("turn", line.turn);
      ln.put("qualityControl", line.qualityControl);
      ln.put("typeControl", line.typeControl);
      ln.put("manufacturingOrder", line.manufacturingOrder);
      ln.put("documentno", line.documentno);
      ln.put("finishingProduct", line.finishingProduct);
      ln.put("prodStarttime", line.prodStarttime);
      ln.put("productionLeader", line.productionLeader);
      ln.put("qualityAnalyst", line.qualityAnalyst);
      dataList.put(ln);
    }

    body.put("product", dataList);

  }

  public MeasureShift createDataCollectionProduct(ConnectionProvider conn, JSONObject body)
      throws Exception {
    String nowStr = Ssapq_Helper.getDateString(new Date());
    Date measurementDate = Ssapq_Helper.getDate(body, "measurementDate", true);
    String prodEndTime = Ssapq_Helper.getString(body, "prodEndtime", true);
    String frequency = Ssapq_Helper.getString(body, "frequency", true);
    BigDecimal salesprice = Ssapq_Helper.getBigDecimal(body, "salesprice", true);
    BigDecimal irbp = Ssapq_Helper.getBigDecimal(body, "irbp", true);
    String observation = Ssapq_Helper.getString(body, "observation", true);
    body.put("prodEndTimeFinal", nowStr + " " + prodEndTime);
    body.put("frequencyFinal", nowStr + " " + frequency);
    Date prodEndTimeFinal = Ssapq_Helper.getDate(body, "prodEndTimeFinal", true);
    Date frequencyFinal = Ssapq_Helper.getDate(body, "frequencyFinal", true);

    Timestamp prodEndTimeTmp = new Timestamp(prodEndTimeFinal.getTime());
    Timestamp frequencyTmp = new Timestamp(frequencyFinal.getTime());

    MeasureShift material = OBProvider.getInstance().get(MeasureShift.class);
    material.setMeasurementDate(measurementDate);
    material.setSpqulyEndtime(prodEndTimeTmp);
    material.setSpqulyFrequency(frequencyTmp);
    material.setSpqulySalesprice(salesprice);
    material.setSpqulyIrbp(irbp);
    material.setComments(StringUtils.substring(observation, 0, 250));
    material.setSpqulyQualitycontroltype("FPQ");
    material.setShift("M");

    OBDal.getInstance().save(material);
    OBDal.getInstance().flush();
    body.put("id", material.getId());

    return material;
  }

}
