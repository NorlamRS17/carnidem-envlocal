package ec.com.sidesoft.projects.complement.ad_callouts;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.pricing.pricelist.PriceListVersion;
import org.openbravo.model.pricing.pricelist.ProductPrice;

public class SproctmTaskProdUOM extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strProdId = info.getStringParameter("inpmProductId", null);

    OBContext.setAdminMode(true);

    OBCriteria<Product> obc = OBDal.getInstance().createCriteria(Product.class);
    obc.add(Restrictions.eq(Product.PROPERTY_ID, strProdId));
    obc.setMaxResults(1);
    Product product = (Product) obc.uniqueResult();

    if (product != null) {
      // Verificar el costo del producto
      OBCriteria<Costing> obcc = OBDal.getInstance().createCriteria(Costing.class);
      obcc.add(Restrictions.eq(Costing.PROPERTY_PRODUCT, product));
      // obcc.add(Restrictions.ne(Costing.PROPERTY_COST, "0"));
      obcc.setMaxResults(1);

      boolean checkPriceList = false;

      if (obcc.list().size() > 0) {
        Costing costing = (Costing) obcc.uniqueResult();
        double val = Double.parseDouble(costing.getCost().toString());
        if (costing != null && val > 0) {
          checkPriceList = false;
          info.addResult("inpcost", costing.getCost().toString());
        } else {
          checkPriceList = true;
        }
      } else {
        checkPriceList = true;
      }

      if (checkPriceList) {
        // Determinar costo segun la tarifa precio COMPRA-DOLARES
        OBCriteria<PriceListVersion> obcpv = OBDal.getInstance()
            .createCriteria(PriceListVersion.class);
        obcpv.add(Restrictions.eq(PriceListVersion.PROPERTY_NAME, "COMPRA-DOLARES"));
        obcpv.setMaxResults(1);

        PriceListVersion priceListVersion = (PriceListVersion) obcpv.uniqueResult();

        if (priceListVersion != null) {
          OBCriteria<ProductPrice> obccp = OBDal.getInstance().createCriteria(ProductPrice.class);
          obccp.add(Restrictions.eq(ProductPrice.PROPERTY_PRODUCT, product));
          obccp.add(Restrictions.eq(ProductPrice.PROPERTY_PRICELISTVERSION, priceListVersion));
          obccp.setMaxResults(1);

          ProductPrice productPrice = (ProductPrice) obccp.uniqueResult();
          if (productPrice != null) {
            info.addResult("inpcost", productPrice.getStandardPrice().toString());
          }
        }
      }

      info.addResult("inpcUomId", product.getUOM().getId());

      OBContext.setAdminMode(false);
    }
  }

}
