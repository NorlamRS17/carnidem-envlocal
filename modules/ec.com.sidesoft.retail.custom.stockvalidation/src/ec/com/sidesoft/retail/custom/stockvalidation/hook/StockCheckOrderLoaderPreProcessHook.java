package ec.com.sidesoft.retail.custom.stockvalidation.hook;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.businessUtility.Preferences;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.PropertyException;
import org.openbravo.model.common.plm.Product;
import org.openbravo.retail.posterminal.OrderLoaderPreProcessHook;

public class StockCheckOrderLoaderPreProcessHook implements OrderLoaderPreProcessHook {

	private static final Logger log = Logger.getLogger(StockCheckOrderLoaderPreProcessHook.class);

	@Override
	public void exec(JSONObject jsonorder) throws Exception {
		JSONArray lines = jsonorder.getJSONArray("lines");
		Boolean validatestock = PreferenceToValidateStock();
		Boolean isLayaway = jsonorder.getBoolean("isLayaway");
		int orderType =  jsonorder.getInt("orderType");
		isLayaway = (isLayaway) || (orderType == 2);
		
		if (validatestock && !isLayaway) {
			for (int i = 0; i < lines.length(); i++) {
				JSONObject line = (JSONObject) lines.get(i);
				String productId = line.getJSONObject("product").getString("id");
				Product product = OBDal.getInstance().get(Product.class, productId);
				BigDecimal qty = new BigDecimal(line.getString("qty"));
				BigDecimal qtyOnHand = BigDecimal.ZERO;
				if (!product.getProductType().equals("S") && !product.isObbomAutogeneratebom()) {
					String hqlQuery = "select sum(ms.quantityOnHand) as qtyonhand "
							+ "from MaterialMgmtStorageDetail ms " + "where ms.storageBin.warehouse.id in ("
							+ "SELECT ow.warehouse.id " + "FROM OrganizationWarehouse as ow " + "WHERE "
							+ "ow.organization.id = '" + jsonorder.getString("organization") + "') "
							+ "and ms.product.id = '" + productId + "'";

					final Session session = OBDal.getInstance().getSession();
					final Query query = session.createQuery(hqlQuery);

					if (query.uniqueResult() != null) {
						qtyOnHand = new BigDecimal(query.uniqueResult().toString());
					}
					if (qtyOnHand.compareTo(BigDecimal.ZERO) == 0 || qtyOnHand.compareTo(qty) < 0) {
						throw new OBException(OBMessageUtils.messageBD("NotEnoughStocked") + " " + product.getName());
					}
				}
			}
		}
	}

	public boolean PreferenceToValidateStock() {
		boolean PreferenceToValidateStock = false;
		try {
			PreferenceToValidateStock = "Y".equals(Preferences.getPreferenceValue("OBPOSSV_EnableStockValidation", true,
					OBContext.getOBContext().getCurrentClient(), OBContext.getOBContext().getCurrentOrganization(),
					OBContext.getOBContext().getUser(), OBContext.getOBContext().getRole(), null));
		} catch (PropertyException e1) {
			log.debug("Error getting OBPOSSV_EnableStockValidation preference: " + e1.getMessage(), e1);
		}
		return PreferenceToValidateStock;
	}

}
