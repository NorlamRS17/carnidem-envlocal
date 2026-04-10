package com.sidesoft.localization.ecuador.refunds.ad_callouts;

import java.math.BigDecimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;

import javax.servlet.ServletException;

import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.data.UtilSql;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.service.db.DalConnectionProvider;

public class UpdateTotalRefundLines extends SimpleCallout {
	private static final long serialVersionUID = 1L;

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		// TODO Auto-generated method stub
		// recupera el valor de la pagina web
		String strInvoiceID = info.getStringParameter("inpcInvoiceId", null);
		String strTaxId = info.getStringParameter("inpcTaxId", null);
		TaxRate taxrateoObj = OBDal.getInstance().get(TaxRate.class, strTaxId);

		BigDecimal strTaxBase = info.getBigDecimalParameter("inptaxbase");
		BigDecimal strTaxAmt = info.getBigDecimalParameter("inptaxamt");
		BigDecimal strTaxIce = info.getBigDecimalParameter("inptaxice");
		BigDecimal strGrantotal = info.getBigDecimalParameter("inpgrandtotal");

		/**
		 * Formula campo Monto IVA: Valor calculado automáticamente base imponible por
		 * el valor del índice configurado en el impuesto siempre y cuando sea mayor a 0
		 */
		BigDecimal strTaxAmtCal = BigDecimal.ZERO;
		BigDecimal rate = taxrateoObj.getRate();
		if (rate.compareTo(BigDecimal.ZERO) > 0) {
		    BigDecimal percentageRate = rate.divide(BigDecimal.valueOf(100));
		    strTaxAmtCal = strTaxBase.multiply(percentageRate);
		}

		/**
		 * Formula campo Importe Total: Valor calculado de la Base Imponible (+) Monto
		 * IVA (+) Monto ICE
		 */
		BigDecimal strTotal = BigDecimal.ZERO;
		strTotal = strTaxBase.add(strTaxIce.add(strTaxAmtCal));

		info.addResult("inptaxamt", strTaxAmtCal);
		info.addResult("inpgrandtotal", strTotal);

	}

}
