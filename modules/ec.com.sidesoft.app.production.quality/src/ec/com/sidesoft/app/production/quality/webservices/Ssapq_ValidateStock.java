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

public class Ssapq_ValidateStock implements WebService {

	@Override
	public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject jsonResponse = new JSONObject();
		JSONArray listValuesArray = new JSONArray();
		ConnectionProvider conn = new DalConnectionProvider(false);

		String workEfforId = request.getParameter("M_WorkEffor_ID");

		try {
			if (workEfforId == null || workEfforId.isEmpty()) {
				jsonResponse.put("status", -1);
				jsonResponse.put("message", "Enviar el parámetro M_WorkEffor_ID");
			} else {
				OBContext.setAdminMode(true);
				final ProductionTransaction objWork = OBDal.getInstance().get(ProductionTransaction.class, workEfforId);

				if (objWork == null) {
					jsonResponse.put("status", -1);
					jsonResponse.put("message", "No se encontró la parte de trabajo solicitada");

				} else {
					// Obtener la parte de fabricacion asociada a la parte de trabajo
					OBCriteria<ProductionPlan> queryPlan = OBDal.getInstance().createCriteria(ProductionPlan.class);
					queryPlan.add(Restrictions.eq(ProductionPlan.PROPERTY_PRODUCTION, objWork));

					if (queryPlan.list().isEmpty()) {
						jsonResponse.put("status", -1);
						jsonResponse.put("message", "No se encontró una parte de fabricación asociada");

					} else {
						// Obtener las líneas de producción asociadas al plan de fabricación
						for (ProductionPlan productionPlan : queryPlan.list()) {
							OBCriteria<ProductionLine> queryProl = OBDal.getInstance()
									.createCriteria(ProductionLine.class);
							queryProl.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONPLAN, productionPlan));

							boolean hasStock = false;

							for (ProductionLine proline : queryProl.list()) {
								if ("+".equals(proline.getProductionType().toString())) {
									// Consultar el stock relacionado
									OBCriteria<StorageDetail> querySto = OBDal.getInstance()
											.createCriteria(StorageDetail.class);
									querySto.add(Restrictions.eq(StorageDetail.PROPERTY_PRODUCT, proline.getProduct()));
									querySto.add(Restrictions.eq(StorageDetail.PROPERTY_STORAGEBIN,
											proline.getStorageBin()));
									querySto.add(Restrictions.eq(StorageDetail.PROPERTY_ATTRIBUTESETVALUE,
											proline.getAttributeSetValue()));

									if (!querySto.list().isEmpty()) {
										// Encotro coincidencias
										StorageDetail stock = querySto.list().get(0);
										JSONObject lineJson = new JSONObject();
										lineJson.put("nombre", stock.getProduct().getName());
										lineJson.put("cantidad", stock.getQuantityOnHand());

										listValuesArray.put(lineJson);
										hasStock = true;
									}
								}
							}
							if (hasStock) {
								// Al menos una línea tiene stock disponible
								jsonResponse.put("status", 1);
								jsonResponse.put("Stock Disponible", listValuesArray);
							} else {
								// Ninguna línea tiene stock disponible
								jsonResponse.put("status", 0);
								jsonResponse.put("message",
										"No hay stock disponible del producto en la ubicación de origen.");
							}
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonResponse.put("status", -1);
			jsonResponse.put("message", "Ocurrió un problema al procesar la solicitud: " + e.getMessage());
		} finally {
			OBContext.restorePreviousMode(); // Restaurar el contexto previo para evitar problemas
		}

		// Configurar la respuesta HTTP
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
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
