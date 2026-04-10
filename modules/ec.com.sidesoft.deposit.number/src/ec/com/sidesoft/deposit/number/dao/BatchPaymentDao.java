package ec.com.sidesoft.deposit.number.dao;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.openbravo.erpCommon.utility.Utility;

import org.openbravo.base.exception.OBException;
import org.openbravo.dal.core.OBContext;
import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.utility.FieldProviderFactory;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.idl.proc.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import org.openbravo.model.financialmgmt.payment.FIN_Payment;

public class BatchPaymentDao {

	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static FieldProvider[] getTransactionsFiltered(List<FIN_Payment> payment) {

		OBContext.setAdminMode();
		DecimalFormat df = new DecimalFormat("###,##0.00;-###,##0.00", new DecimalFormatSymbols());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {
			if (payment.size() <= 0) {
				FieldProvider[] dataT = FieldProviderFactory.getFieldProviderArray(getList());
				FieldProviderFactory.setField(dataT[0], "idpayment", " ");
				FieldProviderFactory.setField(dataT[0], "rowkey", "");
				FieldProviderFactory.setField(dataT[0], "documentno", "");
				FieldProviderFactory.setField(dataT[0], "businesspartner", "");
				FieldProviderFactory.setField(dataT[0], "description", "");
				FieldProviderFactory.setField(dataT[0], "duedate", "");
				FieldProviderFactory.setField(dataT[0], "amount", "");
				return dataT;
			}

			FieldProvider[] data = FieldProviderFactory.getFieldProviderArray(payment);

			for (int i = 0; i < data.length; i++) {

				FieldProviderFactory.setField(data[i], "idpayment", payment.get(i).getId().toString());
				FieldProviderFactory.setField(data[i], "rowkey", "" + (i + 1));
				FieldProviderFactory.setField(data[i], "documentno", payment.get(i).getDocumentNo());
				FieldProviderFactory.setField(data[i], "businesspartner",
						payment.get(i).getBusinessPartner().getName());
				FieldProviderFactory.setField(data[i], "description",
						(payment.get(i).getDescription().length() > 50)
								? payment.get(i).getDescription().substring(0, 50)
								: payment.get(i).getDescription());
				FieldProviderFactory.setField(data[i], "duedate", format.format(payment.get(i).getPaymentDate()));
				FieldProviderFactory.setField(data[i], "amount", payment.get(i).getAmount().toString());
				// FieldProviderFactory.setField(data[i], "amount",
				// df.format(payment.get(i).getAmount()));
			}
			return data;

		} catch (Exception e) {
			throw new OBException(e);
		} finally {
			OBContext.restorePreviousMode();
		}
	}

	public static List getList() {
		List<String> firstOBList = new ArrayList<String>();
		firstOBList.add("");
		return firstOBList;
	}
}