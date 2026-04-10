package ec.com.sidesoft.web.services.order.route.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.materialmgmt.transaction.ProductionPlan;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.web.WebService;

import com.fasterxml.jackson.databind.ObjectMapper;

import ec.com.sidesoft.custom.ws.api.ScwsapLog;
import ec.com.sidesoft.production.ad_actionButton.CreateStandards;
import ec.com.sidesoft.web.services.order.route.service.utils.Response;
import ec.com.sidesoft.web.services.order.route.service.utils.Ssfor_Utils;

public class Ssfor_SalesOrderTrackingReport implements WebService {

    private final Logger logger;

    public Ssfor_SalesOrderTrackingReport() {
        this.logger = Logger.getLogger(Ssfor_SalesOrderTrackingReport.class);
    }

    @Override
    public void doGet(String path, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

    }

    /*
     * @Override
     * public void doPost(String path, HttpServletRequest request,
     * HttpServletResponse response) throws Exception {
     * final ConnectionProvider conn = (ConnectionProvider) new
     * DalConnectionProvider(false);
     * 
     * Response resp = new Response("", 0);
     * // Convertir el objeto a formato JSON
     * ObjectMapper objectMapper = new ObjectMapper();
     * String logId = null;
     * 
     * try {
     * OBContext.setAdminMode(true);
     * this.logger.info((Object) "Begin Ssfor_SalesOrderTrackingReport doGet");
     * final Date loggerDate = new Date();
     * final JSONObject body = Ssfor_Utils.readAllIntoJSONObject((InputStream)
     * request.getInputStream());
     * this.logger.info((Object) "JSON enviado");
     * this.logger.info((Object) loggerDate.toString());
     * this.logger.info((Object) body.toString());
     * final ScwsapLog log = OBProvider.getInstance().get(ScwsapLog.class);
     * log.setEndpoint("SalesOrderTrackingReport");
     * log.setJsonRequest(body.toString());
     * OBDal.getInstance().save((Object) log);
     * OBDal.getInstance().flush();
     * OBDal.getInstance().getConnection().commit();
     * logId = log.getId();
     * 
     * // ? Generar reporte
     * this.createSalesOrderTrackingReport(request, response, resp);
     * 
     * // log.setRecordID(mProductionPlanId);
     * log.setJsonResponse(objectMapper.writeValueAsString(resp));
     * log.setResult("OK");
     * OBDal.getInstance().save((Object) log);
     * OBDal.getInstance().flush();
     * OBDal.getInstance().commitAndClose();
     * 
     * } catch (Exception e) {
     * OBDal.getInstance().rollbackAndClose();
     * final ScwsapLog log2 = OBDal.getInstance().get(ScwsapLog.class, (Object)
     * logId);
     * if (log2 != null) {
     * log2.setResult("ERROR");
     * log2.setError(e.getMessage());
     * OBDal.getInstance().save((Object) log2);
     * OBDal.getInstance().flush();
     * OBDal.getInstance().getConnection().commit();
     * }
     * resp.setStatus(-1);
     * resp.setDescription(e.getMessage());
     * } finally {
     * try {
     * conn.getConnection().close();
     * conn.destroy();
     * } catch (Exception e2) {
     * e2.printStackTrace();
     * }
     * OBContext.restorePreviousMode();
     * this.logger.info((Object) "Finish Ssfor_SalesOrderTrackingReport doGet");
     * }
     * 
     * response.setContentType("application/json");
     * response.setCharacterEncoding("UTF-8");
     * 
     * String json = objectMapper.writeValueAsString(resp);
     * PrintWriter writer = response.getWriter();
     * writer.write(json);
     * writer.close();
     * }
     */

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {

        JSONObject jsonResponse = new JSONObject();

        try {
            final JSONObject body = Ssfor_Utils.readAllIntoJSONObject((InputStream) request.getInputStream());
            // Validar campos obligatorios
            Objects.requireNonNull(body.get("organizationIds"), "organizationId is required");
            Objects.requireNonNull(body.get("fromDeliveryDate"), "fromDeliveryDate is required");
            Objects.requireNonNull(body.get("untilDeliveryDate"), "untilDeliveryDate is required");
            Objects.requireNonNull(body.get("states"), "states is required");

            // Objeto para formater la fecha String en Date
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            // Obtener los parametros enviados en la solicitud
            String fromDeliveryDate = (String) body.get("fromDeliveryDate");
            String untilDeliveryDate = (String) body.get("untilDeliveryDate");
            JSONArray organizationIdsArray = (JSONArray) body.get("organizationIds");
            JSONArray statesArray = (JSONArray) body.get("states");
            JSONArray asignationArray = (JSONArray) body.get("asignationData");

            // Convertir las fechas en formato String a Date
            Date startDate = sdf.parse(fromDeliveryDate + " " + "00:00:00");
            Date startDateEnd = sdf.parse(untilDeliveryDate + " " + "23:59:59");

            // Obtener los ids de las organizaciones en un arreglo de Strings
            String[] organizationIds = new String[organizationIdsArray.length()];
            for (int i = 0; i < organizationIdsArray.length(); i++) {
                organizationIds[i] = organizationIdsArray.getString(i);
            }
            
            // Obtener los estaos en un arreglo de Strings
            String[] states = new String[statesArray.length()];
            for (int i = 0; i < statesArray.length(); i++) {
                states[i] = statesArray.getString(i);
            }
            
         // Obtener las asignaciones en un arreglo de Strings
            String[] asignations = new String[asignationArray.length()];
            for (int i = 0; i < asignationArray.length(); i++) {
                asignations[i] = asignationArray.getString(i);
            }

            // Obtener una lista de objetos organizacion
            List<Organization> organizations = new ArrayList<Organization>();
            for (String orgId : organizationIds) {
                organizations.add(OBDal.getInstance().get(Organization.class, orgId));
            }

            // Crerar un objeto de consulta
            OBCriteria<Order> queryOrder = OBDal.getInstance().createCriteria(Order.class);

            // Formar la consulta con las restricciones necesarias
            if(organizations.size() > 0){
            queryOrder.add(Restrictions.in(Order.PROPERTY_ORGANIZATION, organizations));
            }
            queryOrder.add(Restrictions.ge(Order.PROPERTY_SCHEDULEDDELIVERYDATE, startDate));
            queryOrder.add(Restrictions.le(Order.PROPERTY_SCHEDULEDDELIVERYDATE, startDateEnd));
            
            if(states.length > 0){
            queryOrder.add(Restrictions.in(Order.PROPERTY_DOCUMENTSTATUS, states));
            }
            
            if(asignations.length > 0){
            queryOrder.add(Restrictions.in(Order.PROPERTY_SSFORROUTE, asignations));
            }
            // Restricion para que siempre omita las ordenes en estado borrador
            queryOrder.add(Restrictions.not(Restrictions.eq(Order.PROPERTY_DOCUMENTSTATUS,"DR")));
            // Restrincion por tipo de documento
            queryOrder.createAlias(Order.PROPERTY_DOCUMENTTYPE,"ct");
            queryOrder.add(Restrictions.eq("ct.documentCategory", "SOO"));
            queryOrder.add(Restrictions.eq("ct.salesTransaction", true));
            queryOrder.add(Restrictions.eq("ct.return", false));


            // Ejecutar la consulta
            List<Order> orders = queryOrder.list();

            JSONArray jsonArray = new JSONArray();

            for (Order order : orders) {
                JSONObject jsonItem = new JSONObject();

                // Objeto de la organizacion
                JSONObject jsonOrganization = new JSONObject();
                Organization organization = order.getOrganization();
                if (organization != null) {
                    jsonOrganization.put("name", order.getOrganization().getName() != null ? order.getOrganization().getName() : JSONObject.NULL);
                    jsonOrganization.put("id", order.getOrganization().getId() != null ? order.getOrganization().getId() : JSONObject.NULL);
                }

                // Objeto del Cliente
                JSONObject jsonClient = new JSONObject();
                BusinessPartner client = order.getBusinessPartner();
                if (client != null) {
                    jsonClient.put("name", client.getName() != null ? client.getName() : JSONObject.NULL);
                    jsonClient.put("id", client.getId() != null ?  client.getId() : JSONObject.NULL);
                    jsonClient.put("email", client.getEEIEmail() != null ? client.getEEIEmail() : JSONObject.NULL);
                    if (order.getPartnerAddress() != null) { // sa la dirección asociada al pedido
                        JSONObject jsonLocation = new JSONObject();
                        Location orderAddress = order.getPartnerAddress(); // Obtiene la dirección del pedido
                        String addressName = orderAddress.getName();
                        String latitude = orderAddress.getSspsiLatitude();
                        String longitude = orderAddress.getSspsiLongitude();
                        String city = orderAddress.getLocationAddress().getCityName();
                        String phone = orderAddress.getPhone();

                        jsonLocation.put("address", addressName != null ? addressName : JSONObject.NULL);
                        jsonLocation.put("latitude", latitude != null ? latitude : JSONObject.NULL);
                        jsonLocation.put("longitude", longitude != null ? longitude : JSONObject.NULL);
                        jsonLocation.put("city", city != null ? city : JSONObject.NULL);
                        jsonLocation.put("phone", phone != null ? phone : JSONObject.NULL);

                        jsonClient.put("location", jsonLocation); // Guarda la dirección en el cliente
                    } else {
                        jsonClient.put("location", JSONObject.NULL); // Si no hay dirección en el pedido, devuelve NULL
                    }
                }
                // Objeto de la factura
                JSONObject jsonInvoice = new JSONObject();
                if (order.getInvoiceList().size() > 0) {
                    Invoice invoice = order.getInvoiceList().get(0);
                    jsonInvoice.put("date", invoice.getInvoiceDate() != null ? invoice.getInvoiceDate() : JSONObject.NULL);
                }

                // Objeto del producto
                // Lista de productos
                JSONArray jsonProducts = new JSONArray();
                if (order.getOrderLineList().size() > 0) {
                    for (OrderLine orderLine : order.getOrderLineList()) { // Recorrer todas las líneas del pedido
                        JSONObject jsonProduct = new JSONObject();
                        Product product = orderLine.getProduct();
                        jsonProduct.put("name", product.getName() != null ? product.getName() : JSONObject.NULL);
                        jsonProduct.put("identifier",
                                product.getSearchKey() != null ? product.getSearchKey() : JSONObject.NULL);
                        jsonProduct.put("quantity",
                                orderLine.getOrderedQuantity() != null ? orderLine.getOrderedQuantity()
                                        : JSONObject.NULL);
                        jsonProduct.put("price",
                                orderLine.getLineNetAmount() != null ? orderLine.getLineNetAmount() : JSONObject.NULL);
                        jsonProduct.put("weight", product.getWeight() != null ? product.getWeight() : JSONObject.NULL);
                        jsonProducts.put(jsonProduct); // Agregar producto al array
                    }
                }

                // Agregar la lista de productos al JSON del pedido
                jsonItem.put("products", jsonProducts);
                
                // Fecha de faturacion
                JSONObject jsonAlbaranCliente = new JSONObject();
                if (order.getMaterialMgmtShipmentInOutList().size() > 0) {
                	ShipmentInOut albaran = order.getMaterialMgmtShipmentInOutList().get(0);
                	jsonAlbaranCliente.put("creationDate", albaran.getCreationDate() != null ? albaran.getCreationDate() : JSONObject.NULL);
                }

                jsonItem.put("organization", organization != null ? jsonOrganization : JSONObject.NULL);
                jsonItem.put("client", client != null ? jsonClient : JSONObject.NULL);
                jsonItem.put("invoice", order.getInvoiceList().size() > 0 ?  jsonInvoice : JSONObject.NULL);
                jsonItem.put("products", order.getOrderLineList().size() > 0 ?  jsonProducts : JSONObject.NULL);
                jsonItem.put("orderDate", order.getOrderDate() != null ? order.getOrderDate() : JSONObject.NULL);
                jsonItem.put("state", order.getDocumentStatus() != null ? order.getDocumentStatus() : JSONObject.NULL);
                jsonItem.put("onRoute", order.isSsforOnroute());
                jsonItem.put("deliveryWeb", order.isSsforIsdeliverWeb());
                jsonItem.put("deliveryRoute", order.isSsforIsdeliverRoute()); 
                jsonItem.put("isDelivered",order.isDelivered());
                // Formatear deliveryTime con fecha y hora
                if (order.getSsforIsdeliverTime() != null) {
                    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    jsonItem.put("deliveryTime", dateTimeFormat.format(order.getSsforIsdeliverTime()));
                } else {
                    jsonItem.put("deliveryTime", JSONObject.NULL);
                }
                //razon de cierre
                if(order.getDocumentStatus().equals("CL")){
                    jsonItem.put("reasonClousure",order.getSsfpsReasonClousere().getCommercialName());               
                } else  {
                    jsonItem.put("reasonClousure","");               
                }
                jsonItem.put("route", order.getSSFORRoute() != null ? order.getSSFORRoute() : JSONObject.NULL);
                jsonItem.put("orderNo", order.getDocumentNo() != null ? order.getDocumentNo() : JSONObject.NULL);
                jsonItem.put("deliveryStatus", order.getDeliveryStatus() != null ? order.getDeliveryStatus() : JSONObject.NULL);
                jsonItem.put("instructions", order.getDescription() != null ? order.getDescription() :  JSONObject.NULL);
                jsonItem.put("albaranCliente", order.getMaterialMgmtShipmentInOutList().size() > 0 ? jsonAlbaranCliente : JSONObject.NULL);
                jsonItem.put("id", order.getId());

                jsonArray.put(jsonItem);
            }

            jsonResponse.put("data", jsonArray);
            jsonResponse.put("status", 0);

        } catch (Exception e) {
            // TODO: handle exception
            jsonResponse.put("message", e.getMessage());
            jsonResponse.put("status", -1);
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = jsonResponse.toString();
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.close();

    }

}
