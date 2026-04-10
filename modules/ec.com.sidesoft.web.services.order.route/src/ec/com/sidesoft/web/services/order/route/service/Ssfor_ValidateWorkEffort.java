package ec.com.sidesoft.web.services.order.route.service;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_actionButton.ValidateWorkEffort_ProductionRun;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

import com.fasterxml.jackson.databind.ObjectMapper;

import ec.com.sidesoft.custom.ws.api.ScwsapLog;
import ec.com.sidesoft.web.services.order.route.service.utils.Response;
import ec.com.sidesoft.web.services.order.route.service.utils.Ssfor_Utils;

public class Ssfor_ValidateWorkEffort implements WebService {

    private final Logger logger;

    public Ssfor_ValidateWorkEffort() {
        this.logger = Logger.getLogger(Ssfor_ValidateWorkEffort.class);
    }

    @Override
    public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        final ConnectionProvider conn = (ConnectionProvider) new DalConnectionProvider(false);

        Response resp = new Response("", 0);
        // Convertir el objeto a formato JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String logId = null;

        try {
            OBContext.setAdminMode(true);
            this.logger.info((Object) "Begin Ssfor_ValidateWorkEffort doGet");
            final Date loggerDate = new Date();
            final String mProductionPlanId = Objects.requireNonNull(request.getParameter("M_ProductionPlan_ID"), "'");
            this.logger.info((Object) "Parametro enviado");
            this.logger.info((Object) loggerDate.toString());
            this.logger.info((Object) "M_ProductionPlan_ID: " + mProductionPlanId);
            final ScwsapLog log = OBProvider.getInstance().get(ScwsapLog.class);
            log.setEndpoint("ValidateWorkEffort");
            log.setJsonRequest("M_ProductionPlan_ID: " + mProductionPlanId);
            OBDal.getInstance().save((Object) log);
            OBDal.getInstance().flush();
            OBDal.getInstance().getConnection().commit();
            logId = log.getId();

            // ? VALIDAR PARTE DE TRABAJO
            this.validateWorkEffort(conn, request, response, resp);

            log.setRecordID(mProductionPlanId);
            log.setJsonResponse(objectMapper.writeValueAsString(resp));
            log.setResult("OK");
            OBDal.getInstance().save((Object) log);
            OBDal.getInstance().flush();
            OBDal.getInstance().commitAndClose();

        } catch (Exception e) {
            OBDal.getInstance().rollbackAndClose();
            final ScwsapLog log2 = OBDal.getInstance().get(ScwsapLog.class, (Object) logId);
            if (log2 != null) {
                log2.setResult("ERROR");
                log2.setError(e.getMessage());
                OBDal.getInstance().save((Object) log2);
                OBDal.getInstance().flush();
                OBDal.getInstance().getConnection().commit();
            }
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
            this.logger.info((Object) "Finish Ssfor_ValidateWorkEffort doGet");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = objectMapper.writeValueAsString(resp);
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.close();
    }

    @Override
    public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    private void validateWorkEffort(ConnectionProvider conn, HttpServletRequest request, HttpServletResponse response,
            Response resp) throws Exception {

        VariablesSecureApp vars = new VariablesSecureApp(request);

        try {
            String strMProductionPlanID = Objects.requireNonNull(request.getParameter("M_ProductionPlan_ID"),
                    "M_ProductionPlan_ID is required");

            OBContext.setAdminMode(true);
            ProductionPlan objProductionPlan = OBDal.getInstance().get(ProductionPlan.class, strMProductionPlanID);
            OBContext.restorePreviousMode();

            if (objProductionPlan == null) {
                throw new OBException("Parte de Fabricación no encontrado");
            }

            if (!objProductionPlan.isProcessed()) {
                throw new OBException("El parte de fabricación aún no ha sido procesado, no puede ser validado");
            }

            ProcessBundle bundle = new ProcessBundle("800106", RequestContext.get().getVariablesSecureApp()).init(conn);

            // Crea un mapa inmutable con los parámetros
            Map<String, Object> params = Collections.singletonMap("M_ProductionPlan_ID", (Object) strMProductionPlanID);
            bundle.setParams(params);

            // Ejecutar el proceso
            ValidateWorkEffort_ProductionRun process = new ValidateWorkEffort_ProductionRun();
            process.execute(bundle);

            // Obtener mensaje de resultado del proceso
            OBError processError = (OBError) bundle.getResult();

            if (processError != null) {
                String messageKey = processError.getMessage(); // Obtener la clave del mensaje desde el error
                String translatedMessage = Utility.messageBD(conn, messageKey, vars.getLanguage(), false);

                // this.logger.info("Mensaje original: " + processError.getMessage());
                // this.logger.info("Mensaje traducido: " + translatedMessage);

                if ("Error".equals(processError.getType())) {
                    throw new OBException(translatedMessage);
                }
                resp.setDescription(translatedMessage);
            } else {
                throw new OBException("No se obtuvo una respuesta del proceso de validación.");
            }
            // Guarda y vacía el buffer de la sesión de Hibernate
            OBDal.getInstance().flush();
            // Refresca el objeto objProductionPlan para verificar si se procesó
            // correctamente
            OBDal.getInstance().getSession().refresh(objProductionPlan);

            if (!objProductionPlan.isProcessed()) {
                throw new OBException(
                        "No se pudo procesar la solicitud, el parte de fabricación sigue sin procesarse.");
            } else {
                resp.setDescription("Aprobado");
            }
        } catch (Exception e) {
            // TODO: handle exception     
            String helper = Ssfor_Utils.getErrorMessage(logger,e);
            throw new OBException(helper);

        }

    }

}
