package ec.com.sidesoft.production.quality.ad_callouts;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOutLine;

public class GetReceiptLineProductInfo extends SimpleCallout {
  private static final long serialVersionUID = 3653617759010780960L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
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
