package ec.com.sidesoft.retail.discountsandpromotions.advanced.hook;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.enterprise.context.ApplicationScoped;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.mobile.core.process.JSONPropertyToEntity;
import org.openbravo.mobile.core.utils.OBMOBCUtils;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLineOffer;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineOffer;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.retail.posterminal.OrderLoaderHook;

@ApplicationScoped
public class ExtDaPOrderLoaderHook implements OrderLoaderHook {

  @Override
  public void exec(JSONObject jsonorder, Order order, ShipmentInOut shipment, Invoice invoice)
      throws Exception {

    // JSONArray jsonReceiptTables = jsonorder;
    // JSONArray jsonReceiptPersons = jsonorder.get("SLRRT_numberPerson");
    Entity promotionLineEntity = ModelProvider.getInstance().getEntity(InvoiceLineOffer.class);

    int pricePrecision = order.getCurrency().getObposPosprecision() == null
        ? order.getCurrency().getPricePrecision().intValue()
        : order.getCurrency().getObposPosprecision().intValue();

    int lineNo = 0;
    /*
     * for (InvoiceLine line : invoice.getInvoiceLineList()) { // InvoiceLine line =
     * OBProvider.getInstance().get(InvoiceLine.class); Entity inlineEntity =
     * ModelProvider.getInstance().getEntity(InvoiceLine.class); BigDecimal ratio = new
     * BigDecimal("1");
     * 
     * JSONArray jsonLines = jsonorder.getJSONArray("lines"); List<OrderLine> orderLines =
     * order.getOrderLineList(); for (int i = 0; i < jsonLines.length(); i++) { OrderLine orderlines
     * = orderLines.get(i); lineNo = lineNo + 10; // Discounts & Promotions if
     * (jsonLines.getJSONObject(i).has("promotions") &&
     * !jsonLines.getJSONObject(i).isNull("promotions") &&
     * !jsonLines.getJSONObject(i).getString("promotions").equals("null")) { JSONArray
     * jsonPromotions = jsonLines.getJSONObject(i).getJSONArray("promotions"); for (int p = 0; p <
     * jsonPromotions.length(); p++) { JSONObject jsonPromotion = jsonPromotions.getJSONObject(p);
     * boolean hasActualAmt = jsonPromotion.has("actualAmt"); // if (hasActualAmt &&
     * jsonPromotion.getDouble("actualAmt") == 0) { // - continue; // }
     * 
     * InvoiceLineOffer promotion = OBProvider.getInstance().get(InvoiceLineOffer.class);
     * JSONPropertyToEntity.fillBobFromJSON(promotionLineEntity, promotion, jsonPromotion,
     * jsonorder.getLong("timezoneOffset"));
     * 
     * if (hasActualAmt) {
     * promotion.setTotalAmount(BigDecimal.valueOf(jsonPromotion.getDouble("actualAmt"))
     * .multiply(ratio).setScale(pricePrecision, RoundingMode.HALF_UP)); } else {
     * promotion.setTotalAmount(BigDecimal.valueOf(jsonPromotion.getDouble("amt"))
     * .multiply(ratio).setScale(pricePrecision, RoundingMode.HALF_UP)); }
     * promotion.setLineNo((long) ((p + 1) * 10));
     * promotion.setId(OBMOBCUtils.getUUIDbyString(line.getId() + p));
     * promotion.setNewOBObject(true); promotion.setInvoiceLine(line); //
     * line.getInvoiceLineOfferList().add(promotion); } } } }
     */

    JSONArray orderlines = jsonorder.getJSONArray("lines");

    for (OrderLine orderline : order.getOrderLineList()) {
      for (int i = 0; i < orderlines.length(); i++) {

        JSONObject jsonOrderLine = orderlines.getJSONObject(i);

        if (orderline.getProduct().getId() == jsonOrderLine.getJSONObject("product").get("id")) {
          OrderLine orderlinesDiscounts = orderline;
          // Discounts & Promotions
          if (jsonOrderLine.has("promotions") && !jsonOrderLine.isNull("promotions")
              && !jsonOrderLine.getString("promotions").equals("null")) {

            /*
             * if (!orderline.isNewOBObject()) { // updating order - delete old promotions to create
             * again String deleteStr = "delete " + OrderLineOffer.ENTITY_NAME // + " where " +
             * OrderLineOffer.PROPERTY_SALESORDERLINE + ".id = :id"; Query deleteQuery =
             * OBDal.getInstance().getSession().createQuery(deleteStr);
             * deleteQuery.setParameter("id", orderline.getId()); deleteQuery.executeUpdate(); }
             */

            JSONArray jsonPromotions = jsonOrderLine.getJSONArray("promotions");
            for (int p = 0; p < jsonPromotions.length(); p++) {
              JSONObject jsonPromotion = jsonPromotions.getJSONObject(p);
              boolean hasActualAmt = jsonPromotion.has("actualAmt");
              if ((jsonPromotion.getDouble("amt") == 0)) {

                OrderLineOffer promotion = OBProvider.getInstance().get(OrderLineOffer.class);
                JSONPropertyToEntity.fillBobFromJSON(promotionLineEntity, promotion, jsonPromotion,
                    jsonorder.getLong("timezoneOffset"));

                if (hasActualAmt) {
                  promotion.setTotalAmount(BigDecimal.valueOf(jsonPromotion.getDouble("actualAmt"))
                      .setScale(pricePrecision, RoundingMode.HALF_UP));
                } else {
                  promotion.setTotalAmount(BigDecimal.valueOf(jsonPromotion.getDouble("amt"))
                      .setScale(pricePrecision, RoundingMode.HALF_UP));
                }
                promotion.setLineNo((long) ((p + 1) * 10));
                promotion.setSalesOrderLine(orderline);
                if (jsonPromotion.has("identifier") && !jsonPromotion.isNull("identifier")) {
                  String identifier = jsonPromotion.getString("identifier");
                  if (identifier.length() > 100) {
                    identifier = identifier.substring(identifier.length() - 100);
                  }
                  promotion.setObdiscIdentifier(identifier);
                }
                promotion.setId(OBMOBCUtils.getUUIDbyString(orderline.getId() + p));
                promotion.setNewOBObject(true);
                orderlinesDiscounts.getOrderLineOfferList().add(promotion);
              }
            }
          }
        }
      }
    }

  }
}
