package ec.cusoft.refund.ad_callouts;

import java.math.BigDecimal;
import javax.servlet.ServletException;

import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.ad.access.InvoiceLineTax;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.tax.TaxRate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Eeir_callValue extends SimpleCallout{

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// TODO Auto-generated method stub
	       String invoiceId = info.getStringParameter("inpeeirInvoiceId");

	        BigDecimal taxBaseAmt = BigDecimal.ZERO;
	        BigDecimal taxAmt = BigDecimal.ZERO;
	        
	        Invoice invoice = OBDal.getInstance().get(Invoice.class, invoiceId);

	        if (invoice != null) {

	        	for (InvoiceLineTax taxLine : invoice.getInvoiceLineTaxList()) {
	                TaxRate taxRate = taxLine.getTax(); 

	                if (taxRate.isActive() && taxRate.isTaxdeductable()) {

	                	taxBaseAmt = taxBaseAmt.add(taxLine.getTaxableAmount());
	                    taxAmt = taxAmt.add(taxLine.getTaxAmount());
	                }
	            }
	        }
	        
	        BigDecimal total = taxBaseAmt.add(taxAmt);
	        
	        info.addResult("inpeeirBase", taxBaseAmt);
	        info.addResult("inpeeirTax", taxAmt);
	        info.addResult("inpeeirTotal", total);
		
	}

}
