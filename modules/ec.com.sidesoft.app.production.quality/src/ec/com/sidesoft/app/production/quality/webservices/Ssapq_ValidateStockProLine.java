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
import org.openbravo.model.materialmgmt.onhandquantity.StorageDetail;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

public class Ssapq_ValidateStockProLine implements WebService {

    @Override
    public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonResponse = new JSONObject();
        JSONArray listValuesArray = new JSONArray();
        ConnectionProvider conn = new DalConnectionProvider(false);

        // Obtener parámetros de la solicitud
        String workEffortId = request.getParameter("M_WorkEffort_ID");
        String productionRunId = request.getParameter("M_ProductionRun_ID");
        String productId = request.getParameter("M_Product_ID");
        String storageBinId = request.getParameter("M_StorageBin_ID");
        String attributeSetInstanceId = request.getParameter("M_AttributeSetInstance_ID");

        try {
            if (workEffortId == null || workEffortId.isEmpty() || productId == null || productId.isEmpty()
                    || storageBinId == null || storageBinId.isEmpty()) {
                jsonResponse.put("status", -1);
                jsonResponse.put("message", "Parámetros obligatorios faltantes");
            } else {
                OBContext.setAdminMode(true);
                final ProductionTransaction objWork = OBDal.getInstance().get(ProductionTransaction.class,
                        workEffortId);

                if (objWork == null) {
                    jsonResponse.put("status", -1);
                    jsonResponse.put("message", "No se encontró la parte de trabajo solicitada");

                } else {
                    String orgId = objWork.getOrganization().getId(); // Obtener ad_org_id desde ProductionTransaction

                    OBCriteria<ProductionPlan> queryPlan = OBDal.getInstance().createCriteria(ProductionPlan.class);
                    queryPlan.add(Restrictions.eq(ProductionPlan.PROPERTY_PRODUCTION, objWork));

                    if (queryPlan.list().isEmpty()) {
                        jsonResponse.put("status", -1);
                        jsonResponse.put("message", "No se encontró una parte de fabricación asociada");
                    } else {
                        for (ProductionPlan productionPlan : queryPlan.list()) {
                            OBCriteria<StorageDetail> querySto = OBDal.getInstance()
                                    .createCriteria(StorageDetail.class);
                            querySto.add(Restrictions.eq(StorageDetail.PROPERTY_PRODUCT + ".id", productId));
                            querySto.add(Restrictions.eq(StorageDetail.PROPERTY_STORAGEBIN + ".id", storageBinId));
                            querySto.add(Restrictions.eq(StorageDetail.PROPERTY_ORGANIZATION + ".id", orgId));

                            if (attributeSetInstanceId != null && !attributeSetInstanceId.isEmpty()) {
                                querySto.add(Restrictions.eq(StorageDetail.PROPERTY_ATTRIBUTESETVALUE + ".id",
                                        attributeSetInstanceId));
                            }

                            if (!querySto.list().isEmpty()) {
                                StorageDetail stock = querySto.list().get(0);
                                JSONObject lineJson = new JSONObject();
                                lineJson.put("nombre", stock.getProduct().getName());
                                lineJson.put("cantidad", stock.getQuantityOnHand());
                                lineJson.put("attributeSetValue",
                                        stock.getAttributeSetValue() != null
                                                ? stock.getAttributeSetValue().getIdentifier()
                                                : "Sin atributo");

                                listValuesArray.put(lineJson);
                                jsonResponse.put("status", 1);
                                jsonResponse.put("Stock Disponible", listValuesArray);
                            } else {
                                jsonResponse.put("status", 0);
                                jsonResponse.put("message",
                                        "No hay stock disponible para el producto en la ubicación de origen.");
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse.put("status", -1);
            jsonResponse.put("message", "Error en la consulta de stock: " + e.getMessage());
        } finally {
            OBContext.restorePreviousMode();
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonResponse.toString());
        writer.close();
    }

    @Override
    public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
    }

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
    }
}
