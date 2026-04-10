package com.sidesoft.localization.ecuador.withholdings.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.utils.FormatUtilities;

import org.openbravo.erpCommon.ad_callouts.SE_Invoice_AccountingDate;

public class Sswh_Invoice_WithholdingDate extends SE_Invoice_AccountingDate {

	@Override
	protected void execute(CalloutInfo info) throws ServletException {
		super.execute(info);
		String strInvoiceDate = info.vars.getStringParameter("inpdateinvoiced");
		try {
			info.addResult("inpemSswhDatewithhold", FormatUtilities.replaceJS(strInvoiceDate));
		} catch (Exception e) {
			log4j.error("Error setting withholding date from invoice date", e);
		}
	}
}
