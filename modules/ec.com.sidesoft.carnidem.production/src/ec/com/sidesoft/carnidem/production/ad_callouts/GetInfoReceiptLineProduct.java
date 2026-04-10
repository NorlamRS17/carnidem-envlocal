package ec.com.sidesoft.carnidem.production.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;
import org.hibernate.criterion.Restrictions;



public class GetInfoReceiptLineProduct extends SimpleCallout{

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// TODO Auto-generated method stub
		String inOutId = info.getStringParameter("inpemSpqulyInoutId", null);
		ShipmentInOut inout = OBDal.getInstance().get(ShipmentInOut.class, inOutId);
		String productId = info.getStringParameter("inpemSpqulyProductId", null);
		if (inout != null) {
			info.addResult("inpemSpqulyDeliverdate", inout.getMovementDate());
			if (productId != null || !productId.equals("")) {
				ShipmentInOutLine inoutLine = getReceiptLine(inOutId, productId);
				if (inoutLine != null) {
					info.addResult("inpemSpqulyTotalqty", inoutLine.getMovementQuantity().toPlainString());
					info.addResult("inpemSpqulyUomId", inoutLine.getUOM().getId());
					info.addResult("inpemSpqulyAttrsiId", (inoutLine.getAttributeSetValue() == null ? "0"
							: inoutLine.getAttributeSetValue().getId()));
					if (inoutLine.getSalesOrderLine() != null) {
						OrderLine line = inoutLine.getSalesOrderLine();
						info.addResult("inpemCrprodOrderlineId", line.getId());
						if (line.getUnitPrice() != null && line.getTax() != null) {
							BigDecimal lineUnitPrice = line.getUnitPrice();
							BigDecimal rate = line.getTax().getRate();
							BigDecimal taxMultiplier = rate.divide(BigDecimal.valueOf(100));
							BigDecimal taxAmount = lineUnitPrice.multiply(taxMultiplier);
							BigDecimal total = lineUnitPrice.add(taxAmount);
							info.addResult("inpemCrprodUnitprice", total);
						}
					}
				}
			}
		}
	}
	
	private ShipmentInOutLine getReceiptLine(String inOutId, String productId) {
	    OBCriteria<ShipmentInOutLine> iol = OBDal.getInstance().createCriteria(ShipmentInOutLine.class);
	    iol.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_SHIPMENTRECEIPT,
	        OBDal.getInstance().get(ShipmentInOut.class, inOutId)));
	    iol.add(Restrictions.eq(ShipmentInOutLine.PROPERTY_PRODUCT,
	        OBDal.getInstance().get(Product.class, productId)));
	    iol.setMaxResults(1);

	    return (ShipmentInOutLine) iol.uniqueResult();
	  }

}
