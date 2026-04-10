package ec.com.sidesoft.projects.complement.ad_process;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.common.hcm.SalaryCategoryCost;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.common.uom.UOMTrl;
import org.openbravo.model.materialmgmt.cost.Costing;
import org.openbravo.model.pricing.pricelist.PriceListVersion;
import org.openbravo.model.pricing.pricelist.ProductPrice;

import ec.com.sidesoft.projects.complement.SproctmImpDetails;
import ec.com.sidesoft.projects.complement.SproctmImpDetailsLn;
import ec.com.sidesoft.projects.complement.SproctmImpProdLine;
import ec.com.sidesoft.projects.complement.SproctmImpProducts;
import ec.com.sidesoft.projects.complement.SproctmImpWforceLine;
import ec.com.sidesoft.projects.complement.SproctmImpWorkforce;

public class ValidateData {

  public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public static Product getProductF(String productV) throws Exception {

    OBContext.setAdminMode(true);
    OBCriteria<Product> obc = OBDal.getInstance().createCriteria(Product.class);
    String prod = Product.PROPERTY_NAME.toString();
    System.out.println(prod + " -- " + productV.trim());
    obc.add(Restrictions.eq(Product.PROPERTY_NAME.toString().trim(), productV.trim()));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);
    Product productS = (Product) obc.uniqueResult();

    if (productS == null) {
      String conditional = " to_char(name) like '%" + productV.trim() + "%' ";
      OBContext.setAdminMode(true);
      OBCriteria<Product> criteria = OBDal.getInstance().createCriteria(Product.class);
      criteria.add(Restrictions.sqlRestriction(conditional));
      OBContext.setAdminMode(false);
      Product productL = (Product) criteria.uniqueResult();
      return productL;

    }
    return productS;
  }

  public static Double getCostProduct(String product_id) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<Product> obc = OBDal.getInstance().createCriteria(Product.class);
    obc.add(Restrictions.eq(Product.PROPERTY_ID, product_id));
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
          return Double.parseDouble(costing.getCost().toString());
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
            return Double.parseDouble(productPrice.getStandardPrice().toString());
          }
        }
        OBContext.setAdminMode(false);
      }
    }
    return 0.00;

  }

  public static UOM getUOM(String value) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<UOMTrl> obc = OBDal.getInstance().createCriteria(UOMTrl.class);
    obc.add(Restrictions.eq(UOMTrl.PROPERTY_SYMBOL.toString().trim(), value.trim()));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);

    UOMTrl uomTrl = (UOMTrl) obc.uniqueResult();
    if (uomTrl != null) {
      return uomTrl.getUOM();
    } else {
      return null;
    }
  }

  public static String getUOMCostF(String value) throws Exception {

    OBContext.setAdminMode(true);
    String val = SalaryCategoryCost.PROPERTY_COSTUOM;

    OBCriteria<SalaryCategoryCost> obc = OBDal.getInstance()
        .createCriteria(SalaryCategoryCost.class);
    obc.add(Restrictions.eq(SalaryCategoryCost.PROPERTY_COSTUOM.toString().trim(), value.trim()));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);

    SalaryCategoryCost uomTrl = (SalaryCategoryCost) obc.uniqueResult();
    if (uomTrl != null) {
      return uomTrl.getCostUOM();
    } else {
      return null;
    }
  }

  public static Organization getorganizationF(String organizationV) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<Organization> obc = OBDal.getInstance().createCriteria(Organization.class);
    obc.add(Restrictions.eq(Organization.PROPERTY_NAME.toString().trim(), organizationV.trim()));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);

    Organization organizationS = (Organization) obc.uniqueResult();

    return organizationS;
  }

  public static int getLineLog(SproctmImpProducts head) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<SproctmImpProdLine> obc = OBDal.getInstance()
        .createCriteria(SproctmImpProdLine.class);
    obc.add(Restrictions.eq(SproctmImpProdLine.PROPERTY_SPROCTMIMPPRODUCTS, head));
    OBContext.setAdminMode(false);

    return obc.count();
  }

  public static int getLineLogWforce(SproctmImpWorkforce head) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<SproctmImpWforceLine> obc = OBDal.getInstance()
        .createCriteria(SproctmImpWforceLine.class);
    obc.add(Restrictions.eq(SproctmImpWforceLine.PROPERTY_SPROCTMIMPWORKFORCE, head));
    OBContext.setAdminMode(false);

    return obc.count();
  }

  public static int getDetailsLineLog(SproctmImpDetails head) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<SproctmImpDetailsLn> obc = OBDal.getInstance()
        .createCriteria(SproctmImpDetailsLn.class);
    obc.add(Restrictions.eq(SproctmImpDetailsLn.PROPERTY_SPROCTMIMPDETAILS, head));
    OBContext.setAdminMode(false);

    return obc.count();
  }

  public static SalaryCategory getcategSalaryF(String categSalaryV) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<SalaryCategory> obc = OBDal.getInstance().createCriteria(SalaryCategory.class);
    obc.add(Restrictions.eq(SalaryCategory.PROPERTY_NAME.toString().trim(),
        categSalaryV.toString().trim()));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);

    SalaryCategory categSalary = (SalaryCategory) obc.uniqueResult();

    return categSalary;
  }

  public static BusinessPartner getPartnerF(String partnerName) throws Exception {

    OBContext.setAdminMode(true);

    OBCriteria<BusinessPartner> obc = OBDal.getInstance().createCriteria(BusinessPartner.class);
    obc.add(Restrictions.eq(BusinessPartner.PROPERTY_NAME.toString().trim(),
        partnerName.toString().trim()));
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);

    BusinessPartner partner = (BusinessPartner) obc.uniqueResult();

    return partner;
  }
}
