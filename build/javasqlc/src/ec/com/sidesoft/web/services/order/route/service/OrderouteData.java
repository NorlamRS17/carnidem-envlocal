//Sqlc generated V1.O00-1
package ec.com.sidesoft.web.services.order.route.service;

import java.sql.*;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.data.UtilSql;
import org.openbravo.service.db.QueryTimeOutUtil;
import org.openbravo.database.SessionInfo;
import java.util.*;

class OrderouteData implements FieldProvider {
static Logger log4j = Logger.getLogger(OrderouteData.class);
  private String InitRecordNumber="0";
  public String orderid;
  public String documentno;
  public String created;
  public String deliverydate;
  public String deliveryroute;
  public String deliveryweb;
  public String deliverytime;
  public String isdelivered;
  public String total;
  public String status;
  public String onroute;
  public String description;
  public String route;
  public String nameorg;
  public String orgid;
  public String descriptionorg;
  public String shipmentinout;
  public String partnerid;
  public String partnername;
  public String taxid;
  public String bpartnerorigin;
  public String user1;
  public String user1name;
  public String invoice;
  public String deliverystatus;
  public String address;
  public String latitude;
  public String longitude;
  public String phone;
  public String phone2;
  public String product;
  public String aum;
  public String operativeqty;
  public String qtyordered;

  public String getInitRecordNumber() {
    return InitRecordNumber;
  }

  public String getField(String fieldName) {
    if (fieldName.equalsIgnoreCase("orderid"))
      return orderid;
    else if (fieldName.equalsIgnoreCase("documentno"))
      return documentno;
    else if (fieldName.equalsIgnoreCase("created"))
      return created;
    else if (fieldName.equalsIgnoreCase("deliverydate"))
      return deliverydate;
    else if (fieldName.equalsIgnoreCase("deliveryroute"))
      return deliveryroute;
    else if (fieldName.equalsIgnoreCase("deliveryweb"))
      return deliveryweb;
    else if (fieldName.equalsIgnoreCase("deliverytime"))
      return deliverytime;
    else if (fieldName.equalsIgnoreCase("isdelivered"))
      return isdelivered;
    else if (fieldName.equalsIgnoreCase("total"))
      return total;
    else if (fieldName.equalsIgnoreCase("status"))
      return status;
    else if (fieldName.equalsIgnoreCase("onroute"))
      return onroute;
    else if (fieldName.equalsIgnoreCase("description"))
      return description;
    else if (fieldName.equalsIgnoreCase("route"))
      return route;
    else if (fieldName.equalsIgnoreCase("nameorg"))
      return nameorg;
    else if (fieldName.equalsIgnoreCase("orgid"))
      return orgid;
    else if (fieldName.equalsIgnoreCase("descriptionorg"))
      return descriptionorg;
    else if (fieldName.equalsIgnoreCase("shipmentinout"))
      return shipmentinout;
    else if (fieldName.equalsIgnoreCase("partnerid"))
      return partnerid;
    else if (fieldName.equalsIgnoreCase("partnername"))
      return partnername;
    else if (fieldName.equalsIgnoreCase("taxid"))
      return taxid;
    else if (fieldName.equalsIgnoreCase("bpartnerorigin"))
      return bpartnerorigin;
    else if (fieldName.equalsIgnoreCase("user1"))
      return user1;
    else if (fieldName.equalsIgnoreCase("user1name"))
      return user1name;
    else if (fieldName.equalsIgnoreCase("invoice"))
      return invoice;
    else if (fieldName.equalsIgnoreCase("deliverystatus"))
      return deliverystatus;
    else if (fieldName.equalsIgnoreCase("address"))
      return address;
    else if (fieldName.equalsIgnoreCase("latitude"))
      return latitude;
    else if (fieldName.equalsIgnoreCase("longitude"))
      return longitude;
    else if (fieldName.equalsIgnoreCase("phone"))
      return phone;
    else if (fieldName.equalsIgnoreCase("phone2"))
      return phone2;
    else if (fieldName.equalsIgnoreCase("product"))
      return product;
    else if (fieldName.equalsIgnoreCase("aum"))
      return aum;
    else if (fieldName.equalsIgnoreCase("operativeqty"))
      return operativeqty;
    else if (fieldName.equalsIgnoreCase("qtyordered"))
      return qtyordered;
   else {
     log4j.debug("Field does not exist: " + fieldName);
     return null;
   }
 }

  public static OrderouteData[] selectOrders(ConnectionProvider connectionProvider, String is_date, String date_from, String date_to, String is_onroute, String on_route, String is_dispatch, String is_dispatch_op, String is_status, String status, String orders, String is_route, String route, String limit)    throws ServletException {
    return selectOrders(connectionProvider, is_date, date_from, date_to, is_onroute, on_route, is_dispatch, is_dispatch_op, is_status, status, orders, is_route, route, limit, 0, 0);
  }

  public static OrderouteData[] selectOrders(ConnectionProvider connectionProvider, String is_date, String date_from, String date_to, String is_onroute, String on_route, String is_dispatch, String is_dispatch_op, String is_status, String status, String orders, String is_route, String route, String limit, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "     SELECT " +
      "	    co.c_order_id AS orderid," +
      "	    co.documentno AS documentno," +
      "	    co.dateordered AS created," +
      "	    co.datepromised AS deliverydate," +
      "	    co.em_ssfor_isdeliver_route as deliveryroute," +
      "		co.em_ssfor_isdeliver_web as deliveryweb," +
      "	    TO_CHAR(co.em_ssfor_isdeliver_time, 'DD-MM-YYYY HH24:MI:SS') as deliverytime," +
      "	    co.isdelivered  as isdelivered," +
      "	    co.grandtotal AS total," +
      "	    co.docstatus AS status," +
      "	    co.em_ssfor_onroute AS onroute," +
      "	    co.description AS description," +
      "	    co.em_ssfor_route AS route," +
      "	    ao.name as nameorg," +
      "	    ao.ad_org_id as orgid," +
      "	    ao.description as descriptionorg," +
      "	    mi.m_inout_id AS shipmentinout," +
      "	    cb.c_bpartner_id AS partnerid," +
      "	    cb.name AS partnername," +
      "	    cb.taxid AS taxid," +
      "	    cb.em_sspsi_origin as bpartnerorigin," +
      "	    us.user1_id AS user1," +
      "	    us.name AS user1name," +
      "	    ci.c_invoice_id AS invoice," +
      "	    ''::text as deliverystatus," +
      "	    ''::text as address," +
      "	    ''::text as latitude," +
      "	    ''::text as longitude," +
      "	    ''::text as phone," +
      "	    ''::text as phone2," +
      "	    ''::text as product," +
      "	    ''::text as aum," +
      "	    ''::text as operativeqty," +
      "	    ''::text as qtyordered" +
      "	FROM " +
      "	    c_order co " +
      "	    LEFT JOIN" +
      "    	ad_org ao ON ao.ad_org_id = co.ad_org_id" +
      "	    LEFT JOIN" +
      "    	c_doctype ct ON ct.c_doctype_id = co.c_doctype_id" +
      "		LEFT JOIN " +
      "		    c_bpartner cb ON co.c_bpartner_id = cb.c_bpartner_id" +
      "		LEFT JOIN " +
      "		    user1 us ON us.user1_id = co.user1_id " +
      "		LEFT JOIN " +
      "		    m_inout mi ON mi.c_order_id = co.c_order_id" +
      "		LEFT JOIN " +
      "		    c_invoice ci ON ci.c_order_id = co.c_order_id" +
      "		WHERE " +
      "		ct.docbasetype = 'SOO'" +
      "		AND" +
      "		ct.issotrx = 'Y'" +
      "		AND " +
      "		ct.isreturn = 'N' " +
      "		AND" +
      "		(" +
      "			CASE " +
      "				WHEN ? = 'Y' then co.datepromised::date BETWEEN ?::date AND ?::date" +
      "				ELSE TRUE" +
      "			END" +
      "		)" +
      "		    AND (" +
      "		        CASE " +
      "		            WHEN ? = 'Y' THEN co.em_ssfor_onroute = ?" +
      "		            ELSE TRUE" +
      "		        END" +
      "		    )" +
      "		    AND (" +
      "		        CASE" +
      "		            WHEN ? = 'Y' THEN " +
      "		                CASE " +
      "		                    WHEN ? = 'DY' THEN ci.c_invoice_id IS NOT NULL" +
      "		                    ELSE ci.c_invoice_id IS NULL" +
      "		                END" +
      "		            ELSE TRUE" +
      "		        END" +
      "		    )" +
      "		    AND (" +
      "		        CASE" +
      "		            WHEN ? = 'Y' THEN co.docstatus = ?" +
      "		            ELSE TRUE" +
      "		        END" +
      "		    )" +
      "		    AND" +
      "		    (" +
      "		        CASE" +
      "		            WHEN ? = 'Y' THEN co.docstatus in('CO','CL')" +
      "		            ELSE TRUE" +
      "		        END" +
      "		    )" +
      "		    AND" +
      "		    (" +
      "		        CASE" +
      "		            WHEN ? = 'Y' THEN co.em_ssfor_route = ?" +
      "		            ELSE TRUE" +
      "		        END" +
      "		    )" +
      "		    AND 1=1";
    strSql = strSql + ((limit==null || limit.equals(""))?"":"  order by co.datepromised desc limit 1000  ");

    ResultSet result;
    Vector<OrderouteData> vector = new Vector<OrderouteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_date);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date_from);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, date_to);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_onroute);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, on_route);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_dispatch);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_dispatch_op);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, status);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, orders);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_route);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, route);
      if (limit != null && !(limit.equals(""))) {
        iParameter++; UtilSql.setValue(st, iParameter, 12, null, limit);
      }

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        OrderouteData objectOrderouteData = new OrderouteData();
        objectOrderouteData.orderid = UtilSql.getValue(result, "orderid");
        objectOrderouteData.documentno = UtilSql.getValue(result, "documentno");
        objectOrderouteData.created = UtilSql.getDateValue(result, "created", "dd-MM-yyyy");
        objectOrderouteData.deliverydate = UtilSql.getDateValue(result, "deliverydate", "dd-MM-yyyy");
        objectOrderouteData.deliveryroute = UtilSql.getValue(result, "deliveryroute");
        objectOrderouteData.deliveryweb = UtilSql.getValue(result, "deliveryweb");
        objectOrderouteData.deliverytime = UtilSql.getValue(result, "deliverytime");
        objectOrderouteData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectOrderouteData.total = UtilSql.getValue(result, "total");
        objectOrderouteData.status = UtilSql.getValue(result, "status");
        objectOrderouteData.onroute = UtilSql.getValue(result, "onroute");
        objectOrderouteData.description = UtilSql.getValue(result, "description");
        objectOrderouteData.route = UtilSql.getValue(result, "route");
        objectOrderouteData.nameorg = UtilSql.getValue(result, "nameorg");
        objectOrderouteData.orgid = UtilSql.getValue(result, "orgid");
        objectOrderouteData.descriptionorg = UtilSql.getValue(result, "descriptionorg");
        objectOrderouteData.shipmentinout = UtilSql.getValue(result, "shipmentinout");
        objectOrderouteData.partnerid = UtilSql.getValue(result, "partnerid");
        objectOrderouteData.partnername = UtilSql.getValue(result, "partnername");
        objectOrderouteData.taxid = UtilSql.getValue(result, "taxid");
        objectOrderouteData.bpartnerorigin = UtilSql.getValue(result, "bpartnerorigin");
        objectOrderouteData.user1 = UtilSql.getValue(result, "user1");
        objectOrderouteData.user1name = UtilSql.getValue(result, "user1name");
        objectOrderouteData.invoice = UtilSql.getValue(result, "invoice");
        objectOrderouteData.deliverystatus = UtilSql.getValue(result, "deliverystatus");
        objectOrderouteData.address = UtilSql.getValue(result, "address");
        objectOrderouteData.latitude = UtilSql.getValue(result, "latitude");
        objectOrderouteData.longitude = UtilSql.getValue(result, "longitude");
        objectOrderouteData.phone = UtilSql.getValue(result, "phone");
        objectOrderouteData.phone2 = UtilSql.getValue(result, "phone2");
        objectOrderouteData.product = UtilSql.getValue(result, "product");
        objectOrderouteData.aum = UtilSql.getValue(result, "aum");
        objectOrderouteData.operativeqty = UtilSql.getValue(result, "operativeqty");
        objectOrderouteData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectOrderouteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderouteData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    OrderouteData objectOrderouteData[] = new OrderouteData[vector.size()];
    vector.copyInto(objectOrderouteData);
    return(objectOrderouteData);
  }

  public static String getdeliveryStatus(ConnectionProvider connectionProvider, String c_order_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select case when sum(abs(ol.qtyordered)) = 0 or co.iscancelled = 'Y' or co.cancelledorder_id is not null then 0 else " +
      "		round(coalesce(sum(abs(ol.qtydelivered)), 0)/sum(abs(ol.qtyordered)) * 100, 0) end  as deliverystatus " +
      "		from c_orderline ol " +
      "		left join c_order co on ol.c_order_id = co.c_order_id " +
      "		where ol.c_order_id= ? " +
      "		and ol.c_order_discount_id is null " +
      "		group by co.c_order_id";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "deliverystatus");
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static String getInvoiceStatus(ConnectionProvider connectionProvider, String c_order_id)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "        select case when sum(abs(ol.qtyordered)) = 0 or iscancelled = 'Y' or cancelledorder_id is not null then 0 else " +
      "		round(coalesce(sum(abs(ol.qtyinvoiced)), 0)/sum(abs(ol.qtyordered)) * 100, 0)  end as invoicestatus" +
      "		from c_orderline ol" +
      "		left join c_order co on ol.c_order_id = co.c_order_id" +
      "		where ol.c_order_id= ?" +
      "		and  ol.c_order_discount_id is null" +
      "		group by co.c_order_id";

    ResultSet result;
    String strReturn = "";
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_id);

      result = st.executeQuery();
      if(result.next()) {
        strReturn = UtilSql.getValue(result, "invoicestatus");
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    return(strReturn);
  }

  public static OrderouteData[] getAddress(ConnectionProvider connectionProvider, String c_bpartner_id)    throws ServletException {
    return getAddress(connectionProvider, c_bpartner_id, 0, 0);
  }

  public static OrderouteData[] getAddress(ConnectionProvider connectionProvider, String c_bpartner_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "       	select " +
      "		 COALESCE(string_agg(cbl.name,'||'),'')  as address," +
      "		 COALESCE(string_agg(cbl.em_sspsi_latitude,'||'),'') as latitude," +
      "		 COALESCE(string_agg(cbl.em_sspsi_longitude,'||'),'') as longitude," +
      "		 COALESCE(string_agg(cbl.phone,'||'),'') as phone," +
      "		 COALESCE(string_agg(cbl.phone2,'||'),'') as phone2" +
      "		from c_bpartner_location cbl " +
      "		left join c_order co on cbl.c_bpartner_location_id = co.c_bpartner_location_id" +
      "		where co.c_order_id=? and co.issotrx='Y'" +
      "		group by cbl.c_bpartner_id";

    ResultSet result;
    Vector<OrderouteData> vector = new Vector<OrderouteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_bpartner_id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        OrderouteData objectOrderouteData = new OrderouteData();
        objectOrderouteData.address = UtilSql.getValue(result, "address");
        objectOrderouteData.latitude = UtilSql.getValue(result, "latitude");
        objectOrderouteData.longitude = UtilSql.getValue(result, "longitude");
        objectOrderouteData.phone = UtilSql.getValue(result, "phone");
        objectOrderouteData.phone2 = UtilSql.getValue(result, "phone2");
        objectOrderouteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderouteData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    OrderouteData objectOrderouteData[] = new OrderouteData[vector.size()];
    vector.copyInto(objectOrderouteData);
    return(objectOrderouteData);
  }

  public static OrderouteData[] getClients(ConnectionProvider connectionProvider, String is_route, String route)    throws ServletException {
    return getClients(connectionProvider, is_route, route, 0, 0);
  }

  public static OrderouteData[] getClients(ConnectionProvider connectionProvider, String is_route, String route, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "    SELECT" +
      "    count(co.c_order_id) AS orderid," +
      "    count(co.documentno) AS documentno," +
      "    count(co.dateordered) AS created," +
      "    count(co.isdelivered)  as isdelivered," +
      "    count(co.em_ssfor_isdeliver_route) as deliveryroute," +
      "	count(co.em_ssfor_isdeliver_web) as deliveryweb," +
      "    count(co.datepromised) AS deliverydate," +
      "    count(co.grandtotal) AS total," +
      "    count(co.docstatus) AS status," +
      "    count(co.em_ssfor_onroute) AS onroute," +
      "    count(co.description) AS description," +
      "    count(co.em_ssfor_route) AS route," +
      "    count(ao.name) as nameorg," +
      "	count(ao.ad_org_id) as orgid," +
      "	count(ao.description) as descriptionorg," +
      "    count(mi.m_inout_id) AS shipmentinout," +
      "    cb.c_bpartner_id AS partnerid," +
      "    cb.name AS partnername," +
      "    cb.taxid AS taxid," +
      "    cb.em_sspsi_origin as bpartnerorigin," +
      "    count(us.user1_id) AS user1," +
      "    count(us.name) AS user1name," +
      "    count(ci.c_invoice_id) AS invoice," +
      "    ''::text AS deliverystatus," +
      "    ''::text AS address," +
      "    ''::text AS latitude," +
      "    ''::text AS longitude," +
      "    ''::text as phone," +
      "	''::text as phone2" +
      "	FROM" +
      "	    c_order co" +
      "	LEFT JOIN" +
      "    	ad_org ao ON ao.ad_org_id = co.ad_org_id" +
      "	LEFT JOIN" +
      "	    c_bpartner cb ON co.c_bpartner_id = cb.c_bpartner_id" +
      "	LEFT JOIN" +
      "	    user1 us ON us.user1_id = co.user1_id" +
      "	LEFT JOIN" +
      "	    m_inout mi ON mi.c_order_id = co.c_order_id" +
      "	LEFT JOIN" +
      "	    c_invoice ci ON ci.c_order_id = co.c_order_id" +
      "	    WHERE" +
      "		    (" +
      "		        CASE" +
      "		            WHEN ? = 'Y' THEN co.em_ssfor_route = ?" +
      "		            ELSE TRUE" +
      "		        END" +
      "		    )" +
      "		group by cb.c_bpartner_id,cb.name,cb.taxid";

    ResultSet result;
    Vector<OrderouteData> vector = new Vector<OrderouteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, is_route);
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, route);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        OrderouteData objectOrderouteData = new OrderouteData();
        objectOrderouteData.orderid = UtilSql.getValue(result, "orderid");
        objectOrderouteData.documentno = UtilSql.getValue(result, "documentno");
        objectOrderouteData.created = UtilSql.getValue(result, "created");
        objectOrderouteData.isdelivered = UtilSql.getValue(result, "isdelivered");
        objectOrderouteData.deliveryroute = UtilSql.getValue(result, "deliveryroute");
        objectOrderouteData.deliveryweb = UtilSql.getValue(result, "deliveryweb");
        objectOrderouteData.deliverydate = UtilSql.getValue(result, "deliverydate");
        objectOrderouteData.total = UtilSql.getValue(result, "total");
        objectOrderouteData.status = UtilSql.getValue(result, "status");
        objectOrderouteData.onroute = UtilSql.getValue(result, "onroute");
        objectOrderouteData.description = UtilSql.getValue(result, "description");
        objectOrderouteData.route = UtilSql.getValue(result, "route");
        objectOrderouteData.nameorg = UtilSql.getValue(result, "nameorg");
        objectOrderouteData.orgid = UtilSql.getValue(result, "orgid");
        objectOrderouteData.descriptionorg = UtilSql.getValue(result, "descriptionorg");
        objectOrderouteData.shipmentinout = UtilSql.getValue(result, "shipmentinout");
        objectOrderouteData.partnerid = UtilSql.getValue(result, "partnerid");
        objectOrderouteData.partnername = UtilSql.getValue(result, "partnername");
        objectOrderouteData.taxid = UtilSql.getValue(result, "taxid");
        objectOrderouteData.bpartnerorigin = UtilSql.getValue(result, "bpartnerorigin");
        objectOrderouteData.user1 = UtilSql.getValue(result, "user1");
        objectOrderouteData.user1name = UtilSql.getValue(result, "user1name");
        objectOrderouteData.invoice = UtilSql.getValue(result, "invoice");
        objectOrderouteData.deliverystatus = UtilSql.getValue(result, "deliverystatus");
        objectOrderouteData.address = UtilSql.getValue(result, "address");
        objectOrderouteData.latitude = UtilSql.getValue(result, "latitude");
        objectOrderouteData.longitude = UtilSql.getValue(result, "longitude");
        objectOrderouteData.phone = UtilSql.getValue(result, "phone");
        objectOrderouteData.phone2 = UtilSql.getValue(result, "phone2");
        objectOrderouteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderouteData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    OrderouteData objectOrderouteData[] = new OrderouteData[vector.size()];
    vector.copyInto(objectOrderouteData);
    return(objectOrderouteData);
  }

  public static OrderouteData[] getOrderLines(ConnectionProvider connectionProvider, String c_order_id)    throws ServletException {
    return getOrderLines(connectionProvider, c_order_id, 0, 0);
  }

  public static OrderouteData[] getOrderLines(ConnectionProvider connectionProvider, String c_order_id, int firstRegister, int numberRegisters)    throws ServletException {
    String strSql = "";
    strSql = strSql + 
      "	select p.name as product, " +
      "	u.name as aum, " +
      "	ol.aumqty as operativeqty, " +
      "	ol.qtyordered as qtyordered " +
      "	from c_orderline ol " +
      "	left join m_product p on p.m_product_id = ol.m_product_id " +
      "	left join c_uom u on u.c_uom_id = ol.C_Aum " +
      "	where ol.c_order_id = ?";

    ResultSet result;
    Vector<OrderouteData> vector = new Vector<OrderouteData>(0);
    PreparedStatement st = null;

    int iParameter = 0;
    try {
    st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      iParameter++; UtilSql.setValue(st, iParameter, 12, null, c_order_id);

      result = st.executeQuery();
      long countRecord = 0;
      long countRecordSkip = 1;
      boolean continueResult = true;
      while(countRecordSkip < firstRegister && continueResult) {
        continueResult = result.next();
        countRecordSkip++;
      }
      while(continueResult && result.next()) {
        countRecord++;
        OrderouteData objectOrderouteData = new OrderouteData();
        objectOrderouteData.product = UtilSql.getValue(result, "product");
        objectOrderouteData.aum = UtilSql.getValue(result, "aum");
        objectOrderouteData.operativeqty = UtilSql.getValue(result, "operativeqty");
        objectOrderouteData.qtyordered = UtilSql.getValue(result, "qtyordered");
        objectOrderouteData.InitRecordNumber = Integer.toString(firstRegister);
        vector.addElement(objectOrderouteData);
        if (countRecord >= numberRegisters && numberRegisters != 0) {
          continueResult = false;
        }
      }
      result.close();
    } catch(SQLException e){
      if (log4j.isDebugEnabled()) {
        log4j.error("SQL error in query: " + strSql, e);
      } else {
        log4j.error("SQL error in query: " + strSql + " :" + e);
      }
      throw new ServletException("@CODE=" + Integer.toString(e.getErrorCode()) + "@" + e.getMessage());
    } catch(Exception ex){
      if (log4j.isDebugEnabled()) {
        log4j.error("Exception in query: " + strSql, ex);
      } else {
        log4j.error("Exception in query: " + strSql + " :" + ex);
      }
      throw new ServletException("@CODE=@" + ex.getMessage());
    } finally {
      try {
        connectionProvider.releasePreparedStatement(st);
      } catch(Exception e){
        log4j.error("Error during release*Statement of query: " + strSql, e);
      }
    }
    OrderouteData objectOrderouteData[] = new OrderouteData[vector.size()];
    vector.copyInto(objectOrderouteData);
    return(objectOrderouteData);
  }
}
