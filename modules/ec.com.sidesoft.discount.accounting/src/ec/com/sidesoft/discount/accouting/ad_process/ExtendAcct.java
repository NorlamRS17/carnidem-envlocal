package ec.com.sidesoft.discount.accouting.ad_process;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.Account;
import org.openbravo.erpCommon.ad_forms.AcctProcessTemplate;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocInvoice;
import org.openbravo.erpCommon.ad_forms.DocLine_FinPaymentSchedule;
import org.openbravo.erpCommon.ad_forms.DocLine_Invoice;
import org.openbravo.erpCommon.ad_forms.FactLine;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.invoice.InvoiceLine;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;

public class ExtendAcct implements AcctProcessTemplate {

	static Logger log4j = Logger.getLogger(AcctServer.class);

	@Override
	public boolean execute(AcctServer acctServer, AcctSchema as, ConnectionProvider conn, Connection con,
			VariablesSecureApp vars) throws ServletException {
		try {
			OBContext.setAdminMode();
			if (acctServer.AD_Table_ID.equals("318")) {
				Invoice objInvoice = OBDal.getInstance().get(Invoice.class, acctServer.Record_ID);
				if (objInvoice.isSalesTransaction() && !objInvoice.getDocumentType().isReturn()
						&& !objInvoice.getDocumentType().isReversal()) {
					BigDecimal bdTotalAmt = BigDecimal.ZERO;
					int seq = 0;
					for (InvoiceLine objLine : objInvoice.getInvoiceLineList()) {
						BigDecimal listPrice = objLine.getListPrice();
						BigDecimal unitPrice = objLine.getUnitPrice();
						if (listPrice.compareTo(unitPrice) > 0) {
							BigDecimal bdDiscount = (listPrice.subtract(unitPrice))
									.multiply(objLine.getInvoicedQuantity());
							if (bdDiscount.compareTo(BigDecimal.ZERO) > 0) {
								AccountingCombination objAcct = objLine.getProduct().getProductCategory()
										.getProductCategoryAccountsList().get(0).getSsdacctDiscount();
								if (objAcct == null) {
									throw new OBException(
											"Cuenta contable de descuentos no configurada en la categoría del producto: "
													+ objLine.getProduct().getName() + ".");
								}

								bdTotalAmt = bdTotalAmt.add(bdDiscount);
								AccountingCombination objElementValue = objLine.getProduct().getProductAccountsList()
										.get(0).getProductRevenue();

								for (int i = 0; i < acctServer.m_fact.length; i++) {
									for (FactLine line : acctServer.m_fact[i].getLines()) {
										Field f = line.getClass().getDeclaredField("m_SeqNo");
										f.setAccessible(true);
										if (Integer.valueOf((String) f.get(line)) > seq) {
											seq = Integer.valueOf((String) f.get(line));
										}
									}
									for (FactLine line : acctServer.m_fact[i].getLines()) {

										Field f = line.getClass().getDeclaredField("m_Line_ID");
										f.setAccessible(true);
										Field f1 = line.getClass().getDeclaredField("m_acct");
										f1.setAccessible(true);
										Account act = (Account) f1.get(line);

										if (f.get(line).equals(objLine.getId())
												&& act.Account_ID.equals(objElementValue.getAccount().getId())) {
											seq = seq + 10;
											newLine(line, i, bdDiscount.toString(), "0.00", objInvoice, objLine.getId(),
													objAcct, acctServer, as, conn, String.valueOf(seq));
											seq = seq + 10;
											newLine(line, i, "0.00", bdDiscount.toString(), objInvoice, objLine.getId(),
													objElementValue, acctServer, as, conn, String.valueOf(seq));
										}

									}
								}

							}
						}

					}
				}

			}
		} catch (Exception e) {
			OBError er = new OBError();
			er.setMessage("Error en contabilidad de descuentos. " + e.getMessage());
			er.setType("Error");
			acctServer.setMessageResult(er);
			acctServer.setStatus("N");
			log4j.error(e);
			return false;
		}
		return true;
	}

	public void newLine(FactLine line, int i, String debit, String credit, Invoice objInvoice, String strLine,
			AccountingCombination objAcct, AcctServer acctServer, AcctSchema as, ConnectionProvider conn, String strSeq)
			throws Exception {

		Field f2 = line.getClass().getDeclaredField("m_docLine");
		f2.setAccessible(true);
		Field f3 = line.getClass().getDeclaredField("m_docVO");
		f3.setAccessible(true);
		Field f4 = line.getClass().getDeclaredField("m_Fact_Acct_Group_ID");
		f4.setAccessible(true);
		Field f6 = line.getClass().getDeclaredField("m_DocBaseType");
		f6.setAccessible(true);
		Field f7 = line.getClass().getDeclaredField("m_acct");
		f7.setAccessible(true);
		Field fa = line.getClass().getDeclaredField("m_docVO");
		fa.setAccessible(true);
		Field fb = line.getClass().getDeclaredField("m_C_LocFrom_ID");
		fb.setAccessible(true);
		Field fc = line.getClass().getDeclaredField("m_GL_Category_ID");
		fc.setAccessible(true);
		Field fd = line.getClass().getDeclaredField("m_M_Locator_ID");
		fd.setAccessible(true);
		Field fe = line.getClass().getDeclaredField("m_PostingType");
		fe.setAccessible(true);

		FactLine newline = new FactLine("318", acctServer.Record_ID, strLine, (String) f4.get(line), strSeq,
				(String) f6.get(line));

		newline.m_SeqNo = strSeq;
		newline.setAmtAcct(debit, credit);
		newline.setAmtSource(objInvoice.getCurrency().getId(), debit, credit);
		newline.setAD_Org_ID(objInvoice.getOrganization().getId());

		DocLine_Invoice doclineInvoce = null;
		DocLine_FinPaymentSchedule doclineInvocePayment = null;
		if (objAcct != null) {
			Account acct = Account.getAccount(conn, objAcct.getId());
			newline.setAccount(as, acct);
			doclineInvoce = (DocLine_Invoice) f2.get(line);
			doclineInvoce.setAmount(debit, credit);
		}

		Field f9 = newline.getClass().getDeclaredField("m_docLine");
		f9.setAccessible(true);
		f9.set(newline, doclineInvoce == null ? doclineInvocePayment : doclineInvoce);
		Field f10 = newline.getClass().getDeclaredField("m_docVO");
		f10.setAccessible(true);
		f10.set(newline, (DocInvoice) fa.get(line));
		Field f11 = newline.getClass().getDeclaredField("m_C_LocFrom_ID");
		f11.setAccessible(true);
		f11.set(newline, fb.get(line));
		Field f12 = newline.getClass().getDeclaredField("m_GL_Category_ID");
		f12.setAccessible(true);
		f12.set(newline, fc.get(line));
		Field f13 = newline.getClass().getDeclaredField("m_M_Locator_ID");
		f13.setAccessible(true);
		f13.set(newline, fd.get(line));
		Field f14 = newline.getClass().getDeclaredField("m_PostingType");
		f14.setAccessible(true);
		f14.set(newline, fe.get(line));

		Field f8 = acctServer.m_fact[i].getClass().getDeclaredField("m_lines");
		f8.setAccessible(true);
		ArrayList<Object> arrayList = (ArrayList<Object>) f8.get(acctServer.m_fact[i]);
		arrayList.add(newline);
		f8.set(acctServer.m_fact[i], arrayList);

	}

}