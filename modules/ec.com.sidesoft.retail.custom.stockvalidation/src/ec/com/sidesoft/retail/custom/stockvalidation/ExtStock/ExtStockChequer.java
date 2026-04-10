package ec.com.sidesoft.retail.custom.stockvalidation.ExtStock;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.plm.Product;
import org.openbravo.retail.stockvalidation.StockChecker;

import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.erpCommon.businessUtility.Preferences;
import org.openbravo.erpCommon.utility.PropertyException;

public class ExtStockChequer extends StockChecker {

  private static final Logger log = Logger.getLogger(ExtStockChequer.class);

  public JSONObject exec(JSONObject jsonData) throws JSONException, ServletException {

    boolean allowSell = false;
    BigDecimal unitsFound = new BigDecimal(0);
    BigDecimal qtyToBuy = new BigDecimal(0);
    OBContext.setAdminMode(true);
    try {
      Boolean validatestock = PreferenceToValidateStock();
      String orgId;
      JSONObject jsonOrderLine, jsonProduct;
      Boolean isLayaway = jsonData.getBoolean("isLayaway");
      int orderType =  jsonData.getInt("orderType");
      isLayaway = (isLayaway) || (orderType == 2);
      orgId = jsonData.getString("organization");

      jsonOrderLine = jsonData.getJSONObject("orderLine");

      qtyToBuy = new BigDecimal(jsonOrderLine.getString("qty"));
      jsonProduct = jsonOrderLine.getJSONObject("product");
      String StrBillOfMaterials = jsonProduct.getString("isboom");
      Product product = OBDal.getInstance().get(Product.class, jsonProduct.getString("id"));
      String productType = product.getProductType();
      boolean autoGenerateBom = product.isObbomAutogeneratebom();
      if (!productType.equals("S") && !autoGenerateBom && validatestock && !isLayaway ) {
        if (!StrBillOfMaterials.equals("true")) {
          String hqlQuery = "select sum(ms.quantityOnHand) as qtyonhand "
              + "from MaterialMgmtStorageDetail ms " + "where ms.storageBin.warehouse.id in ("
              + "SELECT ow.warehouse.id " + "FROM OrganizationWarehouse as ow " + "WHERE "
              + "ow.organization.id = '" + orgId + "') " + "and ms.product.id = '"
              + jsonProduct.getString("id") + "'";

          final Session session = OBDal.getInstance().getSession();
          final Query query = session.createQuery(hqlQuery);

          if (query.uniqueResult() != null) {
            unitsFound = new BigDecimal(query.uniqueResult().toString());
          } else {
            unitsFound = BigDecimal.ZERO;
          }

          double dunitsFound = unitsFound.doubleValue();
          double dqtyToBuy = qtyToBuy.doubleValue();
          // if (unitsFound.compareTo(qtyToBuy) >= 0) {

          // Verified Unit Alternative --CC

          String hqlQueryValidateUA = "select count(*) from  ProductAUM paum "
              + " where  paum.product.id = '" + jsonProduct.getString("id") + "'";

          final Query queryValidateProductUA = session.createQuery(hqlQueryValidateUA);
          int CountRowProduct = 0;

          if (queryValidateProductUA.uniqueResult() != null) {
            CountRowProduct = Integer.parseInt(queryValidateProductUA.uniqueResult().toString());
          }
          String strValidateTag = getUnitAlternative(jsonOrderLine.toString());

          if (strValidateTag.equals("UnitAlternative") && CountRowProduct > 0) {

            String strUnitAlternativeId = jsonOrderLine.getString("unitId");

            String hqlQueryConverionUA = "select (conversionRate * " + dqtyToBuy + ") from "
                + " ProductAUM " + " where id = '" + strUnitAlternativeId + "'";
            final Query queryConverionProductUA = session.createQuery(hqlQueryConverionUA);

            if (queryConverionProductUA.uniqueResult() != null) {
              qtyToBuy = new BigDecimal(queryConverionProductUA.uniqueResult().toString());

              float flqtyToBuy = qtyToBuy.floatValue();
              float flunitsfound = unitsFound.floatValue();
              if (flunitsfound >= flqtyToBuy) {
                qtyToBuy = new BigDecimal(flqtyToBuy);
                allowSell = true;
              }
            }
            if (queryConverionProductUA.uniqueResult() == null
                && strValidateTag.equals("UnitAlternative") && CountRowProduct > 0) {
              if (dunitsFound >= dqtyToBuy) {

                allowSell = true;
              }
            }

          } else {

            if (strValidateTag.equals("Error") && CountRowProduct > 0) {

              if (dunitsFound >= dqtyToBuy) {

                allowSell = true;
              }
            } else {

              if (strValidateTag.equals("Error") && CountRowProduct == 0) {

                if (dunitsFound >= dqtyToBuy) {

                  allowSell = true;
                }
              }
            }

          }

        } else {

          String hqlQuery = "select sum(ms.quantityOnHand) as qtyonhand "
              + "from MaterialMgmtStorageDetail ms " + "where ms.storageBin.warehouse.id in ("
              + "SELECT ow.warehouse.id " + "FROM OrganizationWarehouse as ow " + "WHERE "
              + "ow.organization.id = '" + orgId + "') " + "and ms.product.id = '"
              + jsonProduct.getString("id") + "'";

          final Session session = OBDal.getInstance().getSession();
          final Query query = session.createQuery(hqlQuery);

          if (query.uniqueResult() != null) {
            unitsFound = new BigDecimal(query.uniqueResult().toString());
          } else {
            unitsFound = BigDecimal.ZERO;
          }

          double dunitsFound = unitsFound.doubleValue();
          double dqtyToBuy = qtyToBuy.doubleValue();
          if (dunitsFound < 0) {
            dunitsFound = 0;
          }

          if (dqtyToBuy > dunitsFound) {
            allowSell = false;
          } else {
            allowSell = true;
          }
          // unitsFound = qtyToBuy;
        }
      } else {
        allowSell = true;
      }
    } catch (

    Exception e) {
      throw new OBException();
    } finally {
      OBContext.restorePreviousMode();
    }

    JSONObject preFinalResult = new JSONObject();
    preFinalResult.put("allowSell", allowSell);
    if (allowSell == false) {
      preFinalResult.put("qty", unitsFound);
    }
    if (allowSell) {
      preFinalResult.put("qty", qtyToBuy);
    }

    JSONObject finalResult = new JSONObject();
    finalResult.put("data", preFinalResult);
    finalResult.put("status", 0);
    return finalResult;
  }

  public String getUnitAlternative(String strValue) {
    String strFind = "Error";
    String strSearhWord = "unitId";
    int idxSearchTagUnitAlternative = strValue.indexOf(strSearhWord);
    if (idxSearchTagUnitAlternative > -1) {
      strFind = "UnitAlternative";
    }
    return strFind;
  }

  public boolean PreferenceToValidateStock() {
    boolean PreferenceToValidateStock = false;
    try {
	PreferenceToValidateStock = "Y".equals(Preferences.getPreferenceValue(
			"OBPOSSV_EnableStockValidation", true, OBContext.getOBContext().getCurrentClient(),
			OBContext.getOBContext().getCurrentOrganization(), OBContext.getOBContext().getUser(),
			OBContext.getOBContext().getRole(), null));
    } catch (PropertyException e1) {
	log.debug("Error getting OBPOSSV_EnableStockValidation preference: " + e1.getMessage(), e1);
    }
    return PreferenceToValidateStock;
  }
}
