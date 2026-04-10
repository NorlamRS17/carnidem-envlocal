package ec.com.sidesoft.app.production.quality.webservices;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

public class Ssfor_ValidateWorkEffort implements WebService {

    @Override
    public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // Obtener el parámetro de la URL
        String paramValue = request.getParameter("M_ProductionPlan_ID");

        // Si el parámetro no está en la URL, leer el cuerpo de la solicitud
        if (paramValue == null) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            
            try (BufferedReader reader = request.getReader()) {
                while ((line = reader.readLine()) != null) {
                    jsonBuilder.append(line);
                }
            }
            
            // Convertir el cuerpo de la solicitud en un objeto JSONObject
            JSONObject jsonRequest = new JSONObject(jsonBuilder.toString());
            paramValue = jsonRequest.optString("M_ProductionPlan_ID", null);
        }

        OBCriteria<ProductionPlan> queryproductplan = OBDal.getInstance().createCriteria(ProductionPlan.class);
        queryproductplan.add(Restrictions.eq(ProductionPlan.PROPERTY_ID, paramValue));
        queryproductplan.setMaxResults(1);
        ProductionPlan listaproductpla = (ProductionPlan) queryproductplan.uniqueResult();

/* 
        // Buscar registro con el campo ID
        OBCriteria<ProductionTransaction> queryproductrans = OBDal.getInstance().createCriteria(ProductionTransaction.class);
        queryproductrans.add(Restrictions.eq(ProductionTransaction.PROPERTY_ID, paramValue));
        queryproductrans.setMaxResults(1);
        ProductionTransaction listaproductrans = (ProductionTransaction) queryproductrans.uniqueResult();
*/     
        // Crear un objeto JSONObject para la respuesta
        JSONObject jsonResponse = new JSONObject();

        // Verificar si el parámetro "value" es null o vacío
        if (paramValue == null || paramValue.trim().isEmpty()) {
            jsonResponse.put("status", -1);
            jsonResponse.put("description", "Parámetro 'M_ProductionPlan_ID' no proporcionado o vacío");
        } else if (listaproductpla != null) {
            if (!listaproductpla.isProcessed()) {
                jsonResponse.put("status", -1);
                jsonResponse.put("description", "El parte de de fabricación aún no ha sido procesado, No se pudo procesar la solicitud");
            } else {
                jsonResponse.put("status", 1);
                jsonResponse.put("description", "Aprobado");
            }
        } else {
            jsonResponse.put("status", -1);
            jsonResponse.put("description", "ID no encontrado");
        }

        // Configurar la respuesta HTTP
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Escribir el JSON en la respuesta
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse.toString());
        writer.close();
    }

    @Override
    public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // No se implementa en este ejemplo
    }

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // No se implementa en este ejemplo
    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // No se implementa en este ejemplo
    }
}
