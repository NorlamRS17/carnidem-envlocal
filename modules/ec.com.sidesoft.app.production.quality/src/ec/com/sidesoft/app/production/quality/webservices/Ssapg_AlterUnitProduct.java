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
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.plm.ProductAUM;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.common.uom.UOMTrl;
import org.openbravo.service.web.WebService;	
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.database.ConnectionProvider;
import ec.com.sidesoft.app.production.quality.utils.Ssapq_Helper;

public class Ssapg_AlterUnitProduct implements WebService {

	@Override
	public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ConnectionProvider con = new DalConnectionProvider(false);
		JSONObject jsonResponse = new JSONObject();
		JSONArray jsonArray = new JSONArray();

		try {
			OBContext.setAdminMode(true);

// 			Leer el cuerpo del request
//			JSONObject body = Ssapq_Helper.readAllIntoJSONObject(request.getInputStream());
//			String productId = Ssapq_Helper.getString(body, "productId", true);

			String productId = request.getParameter("productId");

			// Obtener el producto
			final Product objPro = OBDal.getInstance().get(Product.class, productId);
			// Obtener la unidad principal del producto
			UOM principalUOM = objPro.getUOM(); // Unidad principal del producto
			Language language = OBDal.getInstance().get(Language.class, "140");

			// Obtener las unidades alternativas del producto
			OBCriteria<ProductAUM> ObjProAum = OBDal.getInstance().createCriteria(ProductAUM.class);
			ObjProAum.add(Restrictions.eq(ProductAUM.PROPERTY_PRODUCT, objPro));

			// Obtener la traducción de la unidad principal
			OBCriteria<UOMTrl> uomTrlCriteria = OBDal.getInstance().createCriteria(UOMTrl.class);
			uomTrlCriteria.add(Restrictions.eq(UOMTrl.PROPERTY_UOM, principalUOM));
			uomTrlCriteria.add(Restrictions.eq(UOMTrl.PROPERTY_LANGUAGE, language));

			if (!uomTrlCriteria.list().isEmpty()) {
				UOMTrl uomTrl = uomTrlCriteria.list().get(0);
				JSONObject mainUnitJson = new JSONObject();
				mainUnitJson.put("Id", principalUOM.getId().toString());
				mainUnitJson.put("Unidad", uomTrl.getName()); // Traducción del nombre
				mainUnitJson.put("Ratio", 1); // La unidad principal siempre tiene un ratio de 1
				jsonArray.put(mainUnitJson);
			}

			// Obtener las unidades alternativas del producto
			OBCriteria<ProductAUM> objProAum = OBDal.getInstance().createCriteria(ProductAUM.class);
			objProAum.add(Restrictions.eq(ProductAUM.PROPERTY_PRODUCT, objPro));

			for (ProductAUM payMethod : ObjProAum.list()) {

				UOM objUOM = payMethod.getUOM();

				// Consultar las traducciones asociadas al UOM
				OBCriteria<UOMTrl> objUOMTrlCriteria = OBDal.getInstance().createCriteria(UOMTrl.class);
				objUOMTrlCriteria.add(Restrictions.eq(UOMTrl.PROPERTY_UOM, objUOM));
				objUOMTrlCriteria.add(Restrictions.eq(UOMTrl.PROPERTY_LANGUAGE, language));

				// Iterar sobre las traducciones y agregarlas al JSON
				for (UOMTrl objUOMTrl : objUOMTrlCriteria.list()) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("Id", objUOM.getId().toString());
					jsonObject.put("Unidad", objUOMTrl.getName()); // Traducción del nombre
					jsonObject.put("Ratio", payMethod.getConversionRate()); // Traducción del nombre
					jsonArray.put(jsonObject);
				}
			}

			jsonResponse.put("data", jsonArray);
			jsonResponse.put("success", true);

		} catch (Exception e) {
			jsonResponse.put("success", false);
			jsonResponse.put("error", e.getMessage());
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
