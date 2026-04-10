package ec.com.sidesoft.assets.taxes.ad_callouts;

import java.math.BigDecimal;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;

import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;

public class SSATAX_TaxCategory extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    
    BigDecimal assetValueAmt = info.getBigDecimalParameter("inpassetvalueamt");
    String taxCategoryId = info.getStringParameter("inpemSsataxCTaxcategoryId", null);
    
    try {
      if((assetValueAmt.compareTo(BigDecimal.ZERO) != 0) && !taxCategoryId.isEmpty()) {
        
        TaxCategory taxCategory = OBDal.getInstance().get(TaxCategory.class, taxCategoryId);
        OBCriteria<TaxRate> taxRateC = OBDal.getInstance().createCriteria(TaxRate.class);
        taxRateC.add(Restrictions.eq(TaxRate.PROPERTY_TAXCATEGORY, taxCategory));

        info.addResult("inpemSsataxTaxamt", 0.00);
        info.addResult("inpemSsataxTotalpurchaseamt", assetValueAmt);
        
        if(taxRateC.count() != 0) {
          TaxRate taxRate = taxRateC.list().get(0);
          if(taxRate.getRate().compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal tax = taxRate.getRate().divide(new BigDecimal(100));
            BigDecimal taxAmt = assetValueAmt.multiply(tax);
            BigDecimal totalPurchaseAmt = assetValueAmt.add(taxAmt);
            info.addResult("inpemSsataxTaxamt", taxAmt);
            info.addResult("inpemSsataxTotalpurchaseamt", totalPurchaseAmt);
          }
        }
      } else {
        info.addResult("inpemSsataxTaxamt", null);
        info.addResult("inpemSsataxTotalpurchaseamt", null);
      }
    } catch (Exception e) {
      System.out.println("Fallo: "+e.getMessage());
    }
    
  }

}
