package ec.com.sidesoft.web.services.order.route.service;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

import com.fasterxml.jackson.databind.ObjectMapper;

import ec.com.sidesoft.custom.ws.api.ScwsapLog;
import ec.com.sidesoft.production.ad_actionButton.CreateStandards;
import ec.com.sidesoft.web.services.order.route.service.utils.Response;
import ec.com.sidesoft.web.services.order.route.service.utils.Ssfor_Utils;

public class Ssfor_ManageStandars implements WebService {

  private final Logger logger;

  public Ssfor_ManageStandars() {
    this.logger = Logger.getLogger(Ssfor_ManageStandars.class);
  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    final ConnectionProvider conn = new DalConnectionProvider(false);

    Response resp = new Response("", 0);
    // Convertir el objeto a formato JSON
    ObjectMapper objectMapper = new ObjectMapper();
    String logId = null;

    try {
      OBContext.setAdminMode(true);
      this.logger.info((Object) "Begin Ssfor_ManageStandars doGet");
      final Date loggerDate = new Date();
      final String mProductionPlanId = Objects
          .requireNonNull(request.getParameter("M_ProductionPlan_ID"), "-");
      this.logger.info((Object) "Parametro enviado");
      this.logger.info((Object) loggerDate.toString());
      this.logger.info((Object) "M_ProductionPlan_ID: " + mProductionPlanId);
      final ScwsapLog log = OBProvider.getInstance().get(ScwsapLog.class);
      log.setEndpoint("CreateStandars");
      log.setJsonRequest("M_ProductionPlan_ID: " + mProductionPlanId);
      OBDal.getInstance().save((Object) log);
      OBDal.getInstance().flush();
      OBDal.getInstance().getConnection().commit();
      logId = log.getId();

      // ? CREATE STANDARS
      this.createStandars(request, response, resp);

      log.setRecordID(mProductionPlanId);
      log.setJsonResponse(objectMapper.writeValueAsString(resp));
      log.setResult("OK");
      OBDal.getInstance().save((Object) log);
      OBDal.getInstance().flush();
      OBDal.getInstance().commitAndClose();

    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      // final ScwsapLog log2 = OBDal.getInstance().get(ScwsapLog.class, (Object) logId);
      // if (log2 != null) {
      // log2.setResult("ERROR");
      // log2.setError(e.getMessage());
      // OBDal.getInstance().save((Object) log2);
      // OBDal.getInstance().flush();
      // OBDal.getInstance().getConnection().commit();
      // }
      resp.setStatus(-1);
      resp.setDescription(e.getMessage());
    } finally {
      try {
        conn.getConnection().close();
        conn.destroy();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
      OBContext.restorePreviousMode();
      this.logger.info((Object) "Finish Ssfor_ManageStandars doGet");
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    String json = objectMapper.writeValueAsString(resp);
    PrintWriter writer = response.getWriter();
    writer.write(json);
    writer.close();
  }

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub
  }

  @Override
  public void doDelete(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void doPut(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  private void createStandars(HttpServletRequest request, HttpServletResponse response,
      Response resp) throws Exception {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    try {
      String strMProductionPlanID = Objects.requireNonNull(
          request.getParameter("M_ProductionPlan_ID"), "M_ProductionPlan_ID is required");
      ProductionPlan objProductionPlan = OBDal.getInstance().get(ProductionPlan.class,
          strMProductionPlanID);
      ConnectionProvider conn = new DalConnectionProvider(false);
      if (objProductionPlan == null) {
        throw new OBException("Parte de Fabricación no encontrado");
      }

      if (objProductionPlan.getProductionQuantity().compareTo(BigDecimal.ZERO) <= 0) {
        throw new OBException("La cantidad de produccón no puede ser 0");
      }

      ProcessBundle pb = new ProcessBundle("CE81B27EADC74667A59506719E70349A", vars).init(conn);

      HashMap<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("M_ProductionPlan_ID", strMProductionPlanID);
      pb.setParams(parameters);

      // Ejecuta el proceso
      try {
        new CreateStandards().execute(pb);
      } catch (Exception e) {
        String errorResult = e.getMessage();
        throw new OBException(errorResult);
      }
      // Guarda y vacía el buffer de la sesión de Hibernate
      OBDal.getInstance().flush();

      // Refresca el objeto objProductionPlan

      OBError myMessage = (OBError) pb.getResult();
      String msg = OBMessageUtils.translateError(myMessage.getMessage()).getMessage();
      if (myMessage.getType().equals("Error")) {
        throw new OBException(msg);
      }

      resp.setDescription(msg);

    } catch (Exception e) {
      // TODO: handle exception
      String helper = Ssfor_Utils.getErrorMessage(logger, e);
      throw new OBException(helper);

    }

  }

}
