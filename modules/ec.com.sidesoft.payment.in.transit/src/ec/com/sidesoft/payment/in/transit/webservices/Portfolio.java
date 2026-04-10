package ec.com.sidesoft.payment.in.transit.webservices;

import java.io.InputStreamReader;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Portfolio implements WebService {

	private static final Logger logger = Logger.getLogger(Portfolio.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	@Override
	public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String documentNo = request.getParameter("documentno");
		String taxId = request.getParameter("taxid");

		JsonObject res = new JsonObject();
		res.addProperty("status", "OK");
		res.add("data", null);
		res.addProperty("message", "");

		try {
			JsonArray data = getPortfolio(documentNo, taxId);
			res.add("data", data);
		} catch (Exception e) {
			res.addProperty("status", "ERROR");
			res.addProperty("message", e.getMessage());
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		Writer w = response.getWriter();
		w.write(res.toString());
		w.close();
	}

	@Override
	public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	@Override
	public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
	}

	private JsonArray getPortfolio(String documentNo, String taxId) {
		JsonArray data = new JsonArray();

		ConnectionProvider conn = new DalConnectionProvider(false);
		PreparedStatement st = null;

		try {
			String sql = " SELECT i.c_invoice_id " + "  , i.documentno " + "  , i.dateinvoiced::DATE dateinvoiced "
					+ "  , i.grandtotal " + "  , (i.outstandingamt - COALESCE(cti.amount,0)) i_outstandingamt "
					+ "  , i.em_eei_urlxml url_xml " + "  , i.em_eei_urlride url_ride " + "  , bp.c_bpartner_id "
					+ "  , bp.taxid " + "  , bp.name bp_name " + "  , pt.c_paymentterm_id " + "  , pt.name pt_name "
					+ "  , ps.fin_payment_schedule_id " + "  , ps.em_ssdnid_cutoff_date::DATE cutoff_date "
					+ "  , ps.amount " + "  , (ps.paidamt + COALESCE(ctps.amount,0)) paidamt "
					+ "  , (ps.outstandingamt - COALESCE(ctps.amount,0)) ps_outstandingamt "
					+ "  , COALESCE(ps.em_ssdnid_interestlatepayment,0) interestlatepayment "
					+ "  , COALESCE(ps.em_ssdnid_collectionexpenses,0) collectionexpenses " + "  , CASE "
					+ "   WHEN (ps.outstandingamt - COALESCE(ctps.amount,0)) = 0 THEN " + "   CASE "
					+ "    WHEN MAX(p.paymentdate)::DATE - ps.em_ssdnid_cutoff_date::DATE <= 0 THEN 0 "
					+ "    ELSE MAX(p.paymentdate)::DATE - ps.em_ssdnid_cutoff_date::DATE " + "   END "
					+ "   ELSE NOW()::DATE - ps.em_ssdnid_cutoff_date::DATE " + "  END daysoverdue "
					+ "  , cti.c_invoice_id " + "  , ctps.fin_payment_schedule_id " + " FROM c_invoice i "
					+ "  JOIN c_bpartner bp ON bp.c_bpartner_id = i.c_bpartner_id "
					+ "  JOIN c_paymentterm pt ON pt.c_paymentterm_id = i.c_paymentterm_id "
					+ "  JOIN fin_payment_schedule ps ON ps.c_invoice_id = i.c_invoice_id "
					+ "  LEFT JOIN fin_payment_scheduledetail psd ON psd.fin_payment_schedule_invoice = ps.fin_payment_schedule_id AND psd.isinvoicepaid = 'Y' "
					+ "  LEFT JOIN fin_payment_detail pd ON pd.fin_payment_detail_id = psd.fin_payment_detail_id "
					+ "  LEFT JOIN fin_payment p ON p.fin_payment_id = pd.fin_payment_id /*AND p.status='RDNC'*/ "
					+ "  LEFT JOIN ( " + "	SELECT ctd.c_invoice_id, SUM(ctd.amount) amount "
					+ "	FROM sspitra_collectiontransit ct "
					+ "	 JOIN sspitra_ct_detail ctd ON ctd.sspitra_collectiontransit_id = ct.sspitra_collectiontransit_id "
					+ "	WHERE ct.status = 'D' " + "	GROUP BY ctd.c_invoice_id "
					+ "  ) cti ON cti.c_invoice_id = i.c_invoice_id " + "  LEFT JOIN ( "
					+ "	SELECT ctd.fin_payment_schedule_id, SUM(ctd.amount) amount "
					+ "	FROM sspitra_collectiontransit ct "
					+ "	 JOIN sspitra_ct_detail ctd ON ctd.sspitra_collectiontransit_id = ct.sspitra_collectiontransit_id "
					+ "	WHERE ct.status = 'D' " + "	GROUP BY ctd.fin_payment_schedule_id "
					+ "  ) ctps ON ctps.fin_payment_schedule_id = ps.fin_payment_schedule_id "
					+ " WHERE i.issotrx = 'Y' ";

			if (documentNo != null) {
				sql += " AND i.documentno = '" + documentNo + "' ";
			}

			if (taxId != null) {
				sql += " AND bp.taxid = '" + taxId + "' ";
			}

			sql += " GROUP BY i.c_invoice_id, bp.c_bpartner_id, pt.c_paymentterm_id, ps.fin_payment_schedule_id "
					+ " , cti.c_invoice_id, cti.amount, ctps.fin_payment_schedule_id, ctps.amount "
					+ " ORDER BY ps.fin_payment_schedule_id, ps.em_ssdnid_cutoff_date ";

			st = conn.getPreparedStatement(sql);
			ResultSet rs = st.executeQuery();

			String invoiceId = null;
			JsonObject invoice = new JsonObject();
			JsonArray psArray = new JsonArray();
			while (rs.next()) {
				JsonObject ps = new JsonObject();

				ps.addProperty("fin_payment_schedule_id", rs.getString("fin_payment_schedule_id"));
				ps.addProperty("cutoff_date", rs.getString("cutoff_date"));
				ps.addProperty("amount", rs.getBigDecimal("amount"));
				ps.addProperty("paidamt", rs.getBigDecimal("paidamt"));
				ps.addProperty("outstandingamt", rs.getBigDecimal("ps_outstandingamt"));
				ps.addProperty("daysoverdue", rs.getInt("daysoverdue"));
				ps.addProperty("interestlatepayment", rs.getBigDecimal("interestlatepayment"));
				ps.addProperty("collectionexpenses", rs.getBigDecimal("collectionexpenses"));

				if (invoiceId == null || !invoiceId.equals(rs.getString("c_invoice_id"))) {
					if (invoiceId != null) {
						invoice.add("payment_schedules", psArray);
						data.add(invoice);
					}

					invoice = new JsonObject();
					psArray = new JsonArray();

					invoice.addProperty("c_invoice_id", rs.getString("c_invoice_id"));
					invoice.addProperty("documentno", rs.getString("documentno"));
					invoice.addProperty("dateinvoiced", rs.getString("dateinvoiced"));
					invoice.addProperty("grandtotal", rs.getBigDecimal("grandtotal"));
					invoice.addProperty("outstandingamt", rs.getBigDecimal("i_outstandingamt"));
					invoice.addProperty("url_xml", rs.getString("url_xml"));
					invoice.addProperty("url_ride", rs.getString("url_ride"));
					invoice.addProperty("c_bpartner_id", rs.getString("c_bpartner_id"));
					invoice.addProperty("taxid", rs.getString("taxid"));
					invoice.addProperty("bp_name", rs.getString("bp_name"));
					invoice.addProperty("c_paymentterm_id", rs.getString("c_paymentterm_id"));
					invoice.addProperty("pt_name", rs.getString("pt_name"));
				}

				psArray.add(ps);

				invoiceId = rs.getString("c_invoice_id");
			}

			if (invoiceId != null) {
				invoice.add("payment_schedules", psArray);
				data.add(invoice);
			}

			rs.close();
			st.close();
		} catch (Exception e) {
			throw new OBException(e.getMessage());
		} finally {
			try {
				conn.releasePreparedStatement(st);
				conn.destroy();
			} catch (Exception eF) {
				throw new OBException(eF.getMessage());
			}
		}

		return data;
	}
}
