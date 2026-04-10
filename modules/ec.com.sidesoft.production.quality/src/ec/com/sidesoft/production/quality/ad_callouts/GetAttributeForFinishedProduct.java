package ec.com.sidesoft.production.quality.ad_callouts;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ProductionLine;
import org.openbravo.model.materialmgmt.transaction.ProductionTransaction;

public class GetAttributeForFinishedProduct extends SimpleCallout {
  private static final long serialVersionUID = 3653617759010780960L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String workPartId = info.getStringParameter("inpemSpqulyWorkeffortId", null);
    String finishedProductId = info.getStringParameter("inpemSpqulyFinishedprodId", null);
    ProductionTransaction workPart = OBDal.getInstance().get(ProductionTransaction.class,
        workPartId);
    Product product = OBDal.getInstance().get(Product.class, finishedProductId);
    ProductionLine productionLine = getFinishedProductLine(workPart, product);
    info.addResult("inpemSpqulyAttrsiId", (productionLine.getAttributeSetValue() == null ? "0"
        : productionLine.getAttributeSetValue().getId()));

  }

  private ProductionLine getFinishedProductLine(ProductionTransaction workPart, Product product) {
    OBCriteria<ProductionLine> iol = OBDal.getInstance().createCriteria(ProductionLine.class);
    iol.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCTIONPLAN,
        workPart.getMaterialMgmtProductionPlanList().get(0)));
    iol.add(Restrictions.eq(ProductionLine.PROPERTY_PRODUCT, product));
    iol.setMaxResults(1);

    return (ProductionLine) iol.uniqueResult();
  }

}
