package ec.com.sidesoft.app.production.quality.webservices;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.ad.domain.List;
import org.openbravo.model.ad.domain.ListTrl;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

public class Ssapq_TakeTurns implements WebService {

    @Override
    public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Crear un objeto JSONObject para la respuesta
        JSONObject jsonResponse = new JSONObject();
        
        // Para almacenar los valores de la lista
        JSONArray listValuesArray = new JSONArray(); 
        
        ConnectionProvider conn = new DalConnectionProvider(false);
        
        // Id quemado de la lista a recuperar los valores solicitados 
        final String recordId = "800038";

        try {
            OBContext.setAdminMode(true);
            
            // Buscar el Reference por ID
            OBCriteria<Reference> queryref = OBDal.getInstance().createCriteria(Reference.class);
            queryref.add(Restrictions.eq(Reference.PROPERTY_ID, recordId));
            queryref.setMaxResults(1);
            Reference objref = (Reference) queryref.uniqueResult();

            // Verificar si el objeto Reference fue encontrado
            if (objref == null) {
                jsonResponse.put("status", "error");
                jsonResponse.put("message", "Reference no encontrado con ID: " + recordId);
            } else {
                // Buscar los valores asociados al Reference
                OBCriteria<List> querylist = OBDal.getInstance().createCriteria(List.class);
                querylist.add(Restrictions.eq(List.PROPERTY_REFERENCE, objref));
                // Obtener la lista completa
                java.util.List<List> listValues = querylist.list();

                // Recorrer la lista de valores y agregarlos al JSONArray
                for (List objlistvalue : listValues) {  
                	
                    OBCriteria<ListTrl> querylistEs = OBDal.getInstance().createCriteria(ListTrl.class);                    
                    querylistEs.add(Restrictions.eq(ListTrl.PROPERTY_LISTREFERENCE, objlistvalue));
                    java.util.List<ListTrl> listValuesEs = querylistEs.list();
                    
                    for (ListTrl objlistTrlValue : listValuesEs) {
                        JSONObject listValueJson = new JSONObject();
                        listValueJson.put("id", objlistTrlValue.getId());
                        listValueJson.put("name", objlistTrlValue.getName());  // Suponiendo que hay un campo "name"
                        listValuesArray.put(listValueJson);
                    }
                }

                // Agregar el array al objeto JSON de respuesta
                jsonResponse.put("status", "success");
                jsonResponse.put("listValues", listValuesArray);
            }
        } catch (Exception e) {
            // Manejo de excepciones
            jsonResponse.put("status", "error");
            jsonResponse.put("message", "Se ha producido un error: " + e.getMessage());

            // Registrar el error en los logs (opcional)
            e.printStackTrace();
        } finally {
            OBContext.restorePreviousMode();
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
        // TODO Auto-generated method stub
    }

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
    }
}
