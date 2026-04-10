package ec.com.sidesoft.stock.reserve.ad_callouts;

import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;

import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.database.ConnectionProvider;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.openbravo.database.SessionInfo;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.materialmgmt.ReservationUtils;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.AttributeSetInstance;
import org.openbravo.model.materialmgmt.onhandquantity.Reservation;
import org.openbravo.model.materialmgmt.onhandquantity.ReservationStock;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.data.UtilSql;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.common.datasource.StockReservationPickAndEditDataSource;
import org.apache.commons.lang.StringUtils;

public class ReserveStock extends DalBaseProcess implements KillableProcess {

	private final Logger logger = Logger.getLogger(ReserveStock.class);
	private boolean killProcess = false;
	private static ProcessLogger Processlogger;

	private static final String strOrderLineTableId = "260";
	private static final String strReservationsTableId = "77264B07BB0E4FA483A07FB40C2E0FE0";
	private static final String strResStockTableId = "7BDAC914CA60418795E453BC0E8C89DC";
	private static final String strResStockOrderTableId = "8A36D18D1D164189B7C3AE892F310E11";
	private static final String strTabResStockOrderTableId = "D6079A4A6C2542678D9A50114367B967";

	@Override
	public void kill(ProcessBundle processBundle) throws Exception {
		OBDal.getInstance().flush();
		this.killProcess = true;

	}

	@Override
	protected void doExecute(ProcessBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		Processlogger = bundle.getLogger();
		ConnectionProvider conn = bundle.getConnection();
		getOrderLines(Processlogger, conn);

	}

	public void getOrderLines(ProcessLogger Processlogger, ConnectionProvider conn) {
		String strSql = "";
		strSql = strSql + " Select Distinct l.c_orderline_ID, o.created From c_orderline l "
				+ " Left Join c_order o ON o.c_order_id = l.c_order_id "
				+ " where o.em_obpos_islayaway = 'Y' AND processed = 'Y' AND (l.qtyordered != l.qtydelivered) AND O.DocStatus != 'CL'  "
				+ " AND l.em_ecssr_execReserveBackgrd = 'N' " + " order by o.created ASC";

		ResultSet result;
		PreparedStatement st = null;

		JSONArray dataColumns = new JSONArray();

		try {
			st = conn.getPreparedStatement(strSql);
			QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
			result = st.executeQuery();

			while (result.next()) {
				String c_orderline_ID = UtilSql.getValue(result, "c_orderline_ID");
				getDataSource(c_orderline_ID);
			}
			result.close();
		} catch (Exception e) {
			logger.debug("Error al obtener los IDs de las lineas del pedido: " + e.getMessage(), e);
			Processlogger.logln(e.getMessage());
		} finally {
			Processlogger.logln("Proceso completado con exito.");
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					logger.debug("Error al cerrar la conexion para consulta de lineas del pedido: " + e.getMessage(), e);
				}
			}
		}
	}

	public void getDataSource(String c_orderline_ID) throws JSONException {
		try {
			StockReservationPickAndEditDataSource reserve = new StockReservationPickAndEditDataSource();
			OrderLine orderLine = OBDal.getInstance().get(OrderLine.class, c_orderline_ID);
			if (orderLine != null && orderLine.getSalesOrder() != null) {
				Order order = orderLine.getSalesOrder();
				Processlogger.logln("Document:"+ order.getDocumentNo());
				Map<String, String> parameters = new HashMap<>();
				parameters.put("tabId", "DAA5BFA2BF2B475E9BFEFF9CF721F09A");
				parameters.put("whereAndFilterClause", "");
				parameters.put("Constants_IDENTIFIER", "_identifier");
				parameters.put("_org", orderLine.getOrganization().getId()); // "E58139BE9D6845949E151DA294385B09"
				parameters.put("@Order.documentType@", order.getDocumentType().getId());// "6B9A7B59B63445039BDD784443BBE170"
				parameters.put("@Order.posted@", order.getPosted());// "N"
				parameters.put("_operationType", "fetch");
				parameters.put("_className", "OBPickAndExecuteDataSource");
				parameters.put("_componentId", "isc_OBPickAndExecuteGrid_0");
				parameters.put("@Order.deliveryMethod@", order.getDeliveryMethod()); // "P"
				parameters.put("_startRow", "0");
				parameters.put("@OrderLine.product@", orderLine.getProduct().getId());// C53C178D7B0F402F84C4237214036B31
				parameters.put("_endRow", "100");
				parameters.put("@OrderLine.partnerAddress@", "null");
				parameters.put("@OrderLine.scheduledDeliveryDate@", "null");
				parameters.put("@Order.organization@", order.getOrganization().getId());// E58139BE9D6845949E151DA294385B09
				parameters.put("@Order.documentStatus@", order.getDocumentStatus());// CO
				parameters.put("isc_metaDataPrefix", "_");
				parameters.put("@OrderLine.client@", orderLine.getClient().getId());// C8B2F3C65E7547E5835C910E4039C86F
				parameters.put("_dataSource", "isc_OBPickAndExecuteDataSource_11");
				parameters.put("isImplicitFilterApplied", "false");
				parameters.put("@OrderLine.attributeSetValue@", "null");
				parameters.put("@OrderLine.orderDate@", orderLine.getOrderDate().toString());// 2025-07-14
				parameters.put("@Order.currency@", order.getCurrency().getId());// 100
				parameters.put("_textMatchStyle", "substring");
				parameters.put("_noCount", "true");
				parameters.put("@OrderLine.currency@", orderLine.getCurrency().getId());// 100
				parameters.put("_isPickAndEdit", "true");
				parameters.put("isc_dataFormat", "json");
				parameters.put("@Order.partnerAddress@", order.getPartnerAddress().getId());// 5F65EC9293714416BCC4F689B18E28CE
				parameters.put("@OrderLine.shippingCompany@", "null");
				parameters.put("@Order.shippingCompany@", "null");
				parameters.put("@Order.processed@", order.isProcessed() ? "true" : "false");// true
				parameters.put("@OrderLine.salesOrder@", orderLine.getSalesOrder().getId());// 42B6432BB6DD15D85528445ECEB54EF4
				parameters.put("@Order.client@", order.getClient().getId());// C8B2F3C65E7547E5835C910E4039C86F
				parameters.put("@OrderLine.uOM@", orderLine.getUOM().getId());// 100
				parameters.put("@OrderLine.warehouse@", orderLine.getWarehouse().getId());// 521E39580474497AA48C15AE6753A848
				parameters.put("buttonOwnerViewTabId", "187");
				parameters.put("@Order.freightCostRule@", order.getFreightCostRule());// I
				parameters.put("@Order.id@", order.getId());// 42B6432BB6DD15D85528445ECEB54EF4
				parameters.put("@Order.priceList@", order.getPriceList().getId());// 7022F8CA61B9450DBCAD458804EE4498
				parameters.put("_sqlWhere", "null");
				parameters.put("@Order.orderDate@", order.getOrderDate().toString());// 2025-07-14
				parameters.put("@Order.scheduledDeliveryDate@", order.getScheduledDeliveryDate().toString());// 2025-07-14
				parameters.put("@Order.warehouse@", order.getWarehouse().getId());// 521E39580474497AA48C15AE6753A848
				parameters.put("dataSourceName", "2F5B70D7F12E4F5C8FE20D6F17D69ECF");
				parameters.put("@Order.businessPartner@", order.getBusinessPartner().getId());// 5C95EE9785A94BE8894F9A67707E4268
				parameters.put("@OrderLine.id@", orderLine.getId());// 832429839DD54DED8D2DD701C49CE659
				parameters.put("whereClauseHasBeenChecked", "false");
				parameters.put("@Order.salesTransaction@", order.isSalesTransaction() ? "true" : "false");// true
				parameters.put("@Order.grandTotalAmount@", order.getGrandTotalAmount().toString());// 4.63
				parameters.put("Constants_FIELDSEPARATOR", "$");

				String result = reserve.fetch(parameters);
				logger.info(result);

				JSONObject jsonResponse = new JSONObject(result);
				prepareReservation(orderLine, jsonResponse);
			}
		}catch(Exception e){
			Processlogger.logln("Error al procesar la linea:"+ c_orderline_ID+" : "+e.getMessage());
		}
	}

	public void prepareReservation(OrderLine orderLine, JSONObject jsonResponse) throws JSONException {
		orderLine.setEcssrExecreservebackgrd(true);
		OBDal.getInstance().save(orderLine);
		OBDal.getInstance().flush();
		JSONObject jsonRequest = new JSONObject();
		jsonRequest.put("inpTableId", "260");
		jsonRequest.put("C_OrderLine_ID", orderLine.getId()); // orderLine.getId()
		jsonRequest.put("selectedLines", jsonResponse.getJSONObject("response").getJSONArray("data"));
		executeReserveStock(jsonRequest);
	}

	public void executeReserveStock(JSONObject jsonRequest) {
		try {
			logger.debug(jsonRequest);
			final String strTableId = jsonRequest.getString("inpTableId");
			boolean processReservation = false;

			Reservation reservation = null;
			if (strTableId.equals(strReservationsTableId) || strTableId.equals(strResStockTableId)
					|| strTableId.equals(strTabResStockOrderTableId)) {
				final String strReservationId = jsonRequest.getString("inpmReservationId");
				reservation = OBDal.getInstance().get(Reservation.class, strReservationId);
			} else if (strTableId.equals(strOrderLineTableId) || strTableId.equals(strResStockOrderTableId)) {
				final String strOrderLineId = jsonRequest.getString("C_OrderLine_ID");
				final OrderLine sol = OBDal.getInstance().get(OrderLine.class, strOrderLineId);
				reservation = ReservationUtils.getReservationFromOrder(sol);
				processReservation = reservation.getRESStatus().equals("DR");
			}

			if (StringUtils.equals(reservation.getRESStatus(), "CL")) {
				throw new OBException(OBMessageUtils.messageBD("ClosedReservation"));
			}

			// Process reservation before managing stock reservations to avoid reserve all
			// available stock
			// Issue 28051: https://issues.openbravo.com/view.php?id=28051
			if (processReservation) {
				OBError result = ReservationUtils.processReserve(reservation, "PR");
				if (result.getType().equals("Error")) {
					JSONObject errorMessage = new JSONObject();
					errorMessage.put("severity", result.getType().toLowerCase());
					errorMessage.put("text", result.getMessage());
					jsonRequest.put("message", errorMessage);
				} else {
					// Force status to completed in case it was kept as draft because no stock
					// reservation was
					// created when processing reservation
					reservation.setRESStatus("CO");
					reservation.setRESProcess("HO");
				}
			}
			if (reservation != null) {
				// FIXME: Replace with OBDao method when handler is merged with latest pi.
				// List<String> idList = OBDao.getIDListFromOBObject(reservation
				// .getMaterialMgmtReservationStockList());
				List<String> idList = new ArrayList<String>();
				for (ReservationStock resStock : reservation.getMaterialMgmtReservationStockList()) {
					idList.add(resStock.getId());
				}
				manageReservedStockLines(jsonRequest, reservation, idList);
				// Remove reservation in case reservation has no lines
				if (reservation.getMaterialMgmtReservationStockList().isEmpty()) {
					reservation.setRESStatus("DR");
					reservation.setRESProcess("PR");
					OBDal.getInstance().flush();
					OBDal.getInstance().remove(reservation);
					OBDal.getInstance().getConnection().commit();
				}
			}

		} catch (Exception e) {
			logger.error("Error in Manage Reservation Action Handler", e);

			try {
				jsonRequest = new JSONObject();
				Throwable ex = DbUtility.getUnderlyingSQLException(e);
				String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
				JSONObject errorMessage = new JSONObject();
				errorMessage.put("severity", "error");
				errorMessage.put("text", message);
				jsonRequest.put("message", errorMessage);

			} catch (Exception e2) {
				logger.error(e.getMessage(), e2);
				// do nothing, give up
			}
		} finally {
			OBContext.restorePreviousMode();
		}
	}

	private void manageReservedStockLines(JSONObject jsonRequest, Reservation reservation, List<String> idList)
			throws JSONException {
		JSONArray selectedLines = jsonRequest.getJSONArray("selectedLines");
		// if no lines selected don't do anything.
		if (selectedLines.length() == 0) {
			// removeNonSelectedLines(idList, reservation);
			return;
		}

		for (int i = 0; i < selectedLines.length(); i++) {
			JSONObject selectedLine = selectedLines.getJSONObject(i);
			logger.debug(selectedLine);
			ReservationStock resStock = null;
			String strReservationStockId = selectedLine.get("reservationStock").equals(null) ? ""
					: selectedLine.getString("reservationStock");
			boolean existsReservationStock = StringUtils.isNotBlank(strReservationStockId);
			if (!existsReservationStock) {
				String released = selectedLine.get("released").equals(null) ? "" : selectedLine.getString("released");
				if (StringUtils.isNotBlank(released)) {
					BigDecimal qtyReleased = new BigDecimal(released);
					if (qtyReleased.compareTo(BigDecimal.ZERO) != 0) {
						strReservationStockId = selectedLine.getString("id");
						existsReservationStock = true;
					}
				}
			}
			if (existsReservationStock) {
				resStock = OBDal.getInstance().get(ReservationStock.class, strReservationStockId);
				idList.remove(strReservationStockId);
			} else {
				resStock = OBProvider.getInstance().get(ReservationStock.class);
				resStock.setReservation(reservation);
				resStock.setOrganization(reservation.getOrganization());

				final String strLocator = selectedLine.get("storageBin").equals(null) ? ""
						: selectedLine.getString("storageBin");
				if (StringUtils.isNotBlank(strLocator)) {
					resStock.setStorageBin((Locator) OBDal.getInstance().getProxy(Locator.ENTITY_NAME, strLocator));
				}
				final String strASIId = selectedLine.get("attributeSetValue").equals(null) ? ""
						: selectedLine.getString("attributeSetValue");
				if (StringUtils.isNotBlank(strASIId)) {
					resStock.setAttributeSetValue((AttributeSetInstance) OBDal.getInstance()
							.getProxy(AttributeSetInstance.ENTITY_NAME, strASIId));
				}
				final String strOrderLineId = selectedLine.get("purchaseOrderLine").equals(null) ? ""
						: selectedLine.getString("purchaseOrderLine");
				if (StringUtils.isNotBlank(strOrderLineId)) {
					resStock.setSalesOrderLine(
							(OrderLine) OBDal.getInstance().getProxy(OrderLine.ENTITY_NAME, strOrderLineId));
				}
				resStock.setReleased(BigDecimal.ZERO);

				List<ReservationStock> resStocks = reservation.getMaterialMgmtReservationStockList();
				resStocks.add(resStock);
				reservation.setMaterialMgmtReservationStockList(resStocks);
			}

			final Boolean isAllocated = selectedLine.getString("allocated").equals(null) ? false
					: selectedLine.getBoolean("allocated");
			resStock.setAllocated(isAllocated == true);

			final BigDecimal qty = new BigDecimal(selectedLine.getString("quantity"));
			resStock.setQuantity(qty);

			try {
				OBDal.getInstance().save(resStock);
				OBDal.getInstance().save(reservation);
				OBDal.getInstance().flush();
				OBDal.getInstance().getConnection().commit();
			} catch (Exception e) {
				logger.debug(e);
			}

		}

		removeNonSelectedLines(idList, reservation);
	}

	private void removeNonSelectedLines(List<String> idList, Reservation reservation) {
		if (idList.size() > 0) {
			for (String id : idList) {
				ReservationStock resStock = OBDal.getInstance().get(ReservationStock.class, id);
				if (resStock.getReleased() == null || resStock.getReleased().compareTo(BigDecimal.ZERO) == 0) {
					reservation.getMaterialMgmtReservationStockList().remove(resStock);
					OBDal.getInstance().remove(resStock);
				}
			}
			try {
				OBDal.getInstance().save(reservation);
				OBDal.getInstance().flush();
				OBDal.getInstance().getConnection().commit();
			} catch (Exception e) {
				logger.debug(e);
			}

		}
	}

}
