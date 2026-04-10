package ec.com.sidesoft.web.services.order.route.service;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.exception.OBException;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.access.OrderLineTax;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.invoice.Invoice;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderDiscount;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.order.OrderLineOffer;
import org.openbravo.model.common.order.OrderTax;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentDetailV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedOrdV;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentSchedule;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentScheduleDetail;
import org.openbravo.model.materialmgmt.onhandquantity.SOLReservedStock;
import org.openbravo.model.materialmgmt.transaction.ShipmentInOut;
import org.openbravo.retail.posterminal.OrderApproval;
import org.openbravo.service.web.WebService;
import org.openbravo.dal.core.TriggerHandler;

import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.database.ConnectionProvider;
import ec.com.sidesoft.payment.plan.info.SSPI_PaymentSchedOrdV;
import ec.com.sidesoft.web.services.order.route.service.utils.Ssfor_Utils;
import ec.com.sidesoft.backoffice.discount.SsbodGiftOrder;
import ec.com.sidesoft.custom.order.verifystock.SOVSLdmProd;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.text.SimpleDateFormat;

public class orderoute implements WebService {
    private final Logger logger = Logger.getLogger(orderoute.class);
    
    @Override
    public void doGet(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        JSONObject JSONOrders = new JSONObject();
        JSONArray jsonArray = new JSONArray();
      //  JSONObject JSONOrder = new JSONObject(); 

        try {
            String fromDeliveryDate = (request.getParameter("fromDeliveryDate") != null)
                    ? request.getParameter("fromDeliveryDate")
                    : null;
            String untilDeliveryDate = (request.getParameter("untilDeliveryDate") != null)
                    ? request.getParameter("untilDeliveryDate")
                    : null;
            String onroute = (request.getParameter("onroute") != null) ? request.getParameter("onroute") : null;
            String dispatched = (request.getParameter("dispatched") != null) ? request.getParameter("dispatched")
                    : null;
            String status = (request.getParameter("status") != null) ? request.getParameter("status") : null;
            String clients = (request.getParameter("clients") != null) ? request.getParameter("clients") : null;
            String orders = (request.getParameter("orders") != null) ? request.getParameter("orders") : null;
            String transactionRoute = (request.getParameter("transactionRoute") != null) ? request.getParameter("transactionRoute").replaceAll("%20", " ") : null;

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dsql = new SimpleDateFormat("yyyy-MM-dd");    
            
            // parametros de fechas
            Date startDate = null;
            Date startDateEnd = null;
            if(fromDeliveryDate !=  null) {
            	 startDate = sdf.parse(fromDeliveryDate);
                 startDateEnd = sdf.parse(fromDeliveryDate);
            }
            if(untilDeliveryDate !=  null) {
                startDateEnd = sdf.parse(untilDeliveryDate);
           }
            
            String vOnRoute = "N";
            String vDispatch = "N";
            String vDispatchOp = "DN";
            String vStatus = "N";
            String vOrders = "N";
            String vTransRoute = "N";
            String limit  = "";
            Boolean onRouteBool = false;
            if (onroute != null) {
            	//parametro onroute
            	onRouteBool = Boolean.parseBoolean(onroute);
                vOnRoute = "Y";
            }
            Boolean onBoolDispatch = false; 
            if (dispatched != null) {
            	vDispatch = "Y";
            	onBoolDispatch  = Boolean.parseBoolean(dispatched);

                if (onBoolDispatch) {
                    vDispatchOp = "DY"; // despachados
                } else {
                    vDispatchOp = "DN"; // no despachados
                }
            }

            if (status != null) {
                vStatus = "Y";
            }
            if(Boolean.parseBoolean(orders)) {
            	if(startDate ==  null && startDateEnd == null) {
            		limit = "true";
            	}
            	vOrders = "Y";
            }
            if(transactionRoute != null) {
            	vTransRoute = "Y";
            }
           String date1 = startDate != null ? dsql.format(startDate) : "1999-01-01"; //fecha aleatoria para que no rebote un error de sql
           String date2 = startDateEnd != null ? dsql.format(startDateEnd) : "1999-01-01";
           String isDate =  startDate != null && startDateEnd != null ? "Y" : "N";
           transactionRoute = transactionRoute != null ? transactionRoute : "";
    	   ConnectionProvider conn = new DalConnectionProvider(false);
    	   OrderouteData[] listOrders = null;
    	   logger.info(vTransRoute);
    	   logger.info(transactionRoute);
    	   if(Boolean.parseBoolean(clients)) {
    		   listOrders = OrderouteData.getClients(conn,vTransRoute,transactionRoute);
    	   }else {
    		   listOrders = OrderouteData.selectOrders(conn,isDate,date1,date2,vOnRoute,
    				   onRouteBool ? "Y" : "N",vDispatch,vDispatchOp,vStatus,status,vOrders,vTransRoute,transactionRoute,limit,0,0
    				   );
    		   
    	   }
           

            if (listOrders.length > 0) {
                for (OrderouteData objOrder : listOrders) {
                    JSONObject JSONOrder = new JSONObject();
                    JSONOrder.put("orderId", objOrder.orderid);
                    JSONOrder.put("documentNo", objOrder.documentno);
                    JSONOrder.put("route", objOrder.route);
                    JSONOrder.put("isDelivered", objOrder.isdelivered.equals("N") ? false : true);
                    JSONOrder.put("createdAt", objOrder.created);
                    JSONOrder.put("deliveryDate", objOrder.deliverydate);// fecha max de entrega
                    JSONOrder.put("deliveryTime", (objOrder.deliverytime != null && !objOrder.deliverytime.equals("")) ? objOrder.deliverytime : null);
                    JSONOrder.put("total",  Double.parseDouble(objOrder.total.equals("") ? "0.00" : objOrder.total));
                    JSONOrder.put("status", objOrder.status);
                    JSONOrder.put("onroute", objOrder.onroute.equals("N") ? false : true );
                    JSONOrder.put("dispatched", (objOrder.shipmentinout.equals("") || objOrder.shipmentinout == null ) ? false : true );
                    JSONOrder.put("description", objOrder.description);
                    JSONOrder.put("deliveryRoute",objOrder.deliveryroute.equals("N") ? false : true);
                    JSONOrder.put("deliveryWeb",objOrder.deliveryweb.equals("N") ? false : true);
                    String delyStatus = OrderouteData.getdeliveryStatus(conn, objOrder.orderid);
                    JSONOrder.put("deliveryStatus", Integer.parseInt(delyStatus.equals("") ? "0" : delyStatus ));
                    String invoiceStatus = OrderouteData.getInvoiceStatus(conn, objOrder.orderid);
                    JSONOrder.put("invoiceStatus", Integer.parseInt(invoiceStatus.equals("") ? "0" : invoiceStatus ));

                    
                    if (objOrder.partnerid != null &&  !objOrder.partnerid.equals("") ) {
                        JSONObject JSONPartner = new JSONObject();
                        JSONPartner.put("originalId", objOrder.partnerid);	
                        JSONPartner.put("fullname", objOrder.partnername);
                        OrderouteData[] bParnertLoc = OrderouteData.getAddress(conn,objOrder.orderid);
                        
                        OrderouteData location = bParnertLoc[0];
                        String nameAddress = "";
                        String lat = "";
                        String lng = "";
                        String phone = "";
                        String phone2 = "";
                        if(!location.address.equals("")) {
                        	nameAddress = location.address.split("\\|\\|")[0];
                        }
						if(!location.latitude.equals("")) {
							lat = location.latitude.split("\\|\\|")[0];
                        }
						if(!location.longitude.equals("")) {
                        	lng = location.longitude.split("\\|\\|")[0];
                        }
                        if(!location.phone.equals("")) {
                        phone = location.phone.split("\\|\\|")[0];
                        }
                        if(!location.phone2.equals("")) {
                         	phone2 = location.phone2.split("\\|\\|")[0];
                         }
                        
                        JSONPartner.put("address", nameAddress);
                        JSONPartner.put("lat", lat);
                        JSONPartner.put("lng",lng); 
                        JSONPartner.put("phone",phone); 
                        JSONPartner.put("phone2",phone2); 
                        JSONPartner.put("identification", objOrder.taxid);
                        JSONOrder.put("client", JSONPartner);
                    }

                   
                    if (objOrder.user1 != null && !objOrder.user1.equals("")) {
                        JSONObject JSONUserDimension1 = new JSONObject();
                        JSONUserDimension1.put("originalId", objOrder.user1);
                        JSONUserDimension1.put("name", objOrder.user1name);
                        JSONOrder.put("userDimension", JSONUserDimension1);
                    }
                    
                    JSONObject JSONOrg = new JSONObject();
                    JSONOrg.put("orgId", objOrder.orgid);
                    JSONOrg.put("name", objOrder.nameorg);
                    JSONOrg.put("description", objOrder.descriptionorg);
                    JSONOrder.put("org", JSONOrg);
                    
                    //JSONOrg.put(path, objOrder);
                    if(objOrder.bpartnerorigin != null && !objOrder.bpartnerorigin.equals("")) {
                    	JSONOrder.put("origin", objOrder.bpartnerorigin);	
                    } else {
                    	JSONOrder.put("origin", JSONObject.NULL);
                    }
                    
                    JSONArray jsonArrayline = new JSONArray();
                    OrderouteData[] listOrderLine = OrderouteData.getOrderLines(conn, objOrder.orderid);
                    if (listOrderLine.length > 0) {
                    	for (OrderouteData objOrderLine : listOrderLine) {
                		JSONObject JSONOrderLine = new JSONObject();
                		JSONOrderLine.put("nameproduct", objOrderLine.product);
                		JSONOrderLine.put("aom", objOrderLine.aum);
                		JSONOrderLine.put("operativeqty", objOrderLine.operativeqty);
                		JSONOrderLine.put("qtyordered", objOrderLine.qtyordered);
                		jsonArrayline.put(JSONOrderLine);	
                	}
			JSONOrder.put("line", jsonArrayline);
		     }
                    jsonArray.put(JSONOrder);
                }
            }
                
            
        } catch (Exception e) {
            //JSONOrders.put("message", e.getMessage());
        	//String helper = Ssfor_Utils.getErrorMessage(e);
        	JSONOrders.put("message", "Error");
        }

        JSONOrders.put("interface data", jsonArray);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = JSONOrders.toString();
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.close();
    }

    @Override
    public void doPost(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        }

        // String id = requestJSON.getString("id");
        JSONObject JSONResponse = new JSONObject();
        try {
            // JSON Recovery
            JSONObject requestJSON = new JSONObject(requestBody.toString());
            String OrgID = requestJSON.getString("OrgID");
            JSONArray Orders = requestJSON.getJSONArray("Orders");

            // Organization objOrganization =
            // OBDal.getInstance().getProxy(Organization.class,OrgID);
            Organization objOrganization = OBDal.getInstance().get(Organization.class, OrgID);
            DocumentType DocTransaction = objOrganization.getSsforCDoctypetarget();
            Warehouse wareHouse = objOrganization.getSsforMWarehouse();
            Costcenter costCenter = DocTransaction.getSsfcCostcenter();
            if (objOrganization != null) {
                if (DocTransaction != null || wareHouse != null) {
                    if (costCenter != null) {
                        for (int i = 0; i < Orders.length(); i++) {
                            JSONObject dataOrder = Orders.getJSONObject(i);
                            String id = dataOrder.getString("OrderID");

                            if (id != null) {
                                OBCriteria<Order> queryobjOrder = OBDal.getInstance().createCriteria(Order.class);
                                queryobjOrder.add(Restrictions.eq(Order.PROPERTY_ID, id));
                                queryobjOrder.setMaxResults(1);
                                Order objOrder = (Order) queryobjOrder.uniqueResult();
                                if (objOrder != null) {
                                    Boolean relationInvoice = validateRelationInvoice(objOrder);// despachado
                                	if(relationInvoice) {
                                		updateRouteDispatcher(objOrganization, objOrder);
                                	}else {
                                		updateRouteOrganization(objOrganization, objOrder, DocTransaction, wareHouse,
                                                costCenter);
                                        updateRouteDispatcher(objOrganization, objOrder);
                                	}
                                    
                                    objOrder.setSsforOnroute(true);
                                    OBDal.getInstance().save(objOrder);
                                    OBDal.getInstance().flush();

                                    JSONResponse.put("response", 0);
                                    JSONResponse.put("message", "Succes");
                                } else {
                                    throw new OBException(id + " The order does not exist or could not be recovered");
                                }
                            } else {
                                throw new OBException("idOrder value was null");
                            }
                        }
                    } else {
                        throw new OBException("CostCenter could not be recovered or was null.");
                    }

                } else {
                    throw new OBException("DocTransaction or WareHouse could not be recovered or was null.");
                }
            } else {
                throw new OBException("The Organization does not exist");
            }

        } catch (Exception e) {
            //String helper = Ssfor_Utils.getErrorMessage(e);
            OBDal.getInstance().rollbackAndClose();
            JSONResponse.put("response", -1);
            JSONResponse.put("message", "error");
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String json = JSONResponse.toString();
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.close();

    }

    @Override
    public void doDelete(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPut(String path, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub

    }

    public Boolean validateRelationInvoice(Order objOrder) {
        OBCriteria<Invoice> queryInvoices = OBDal.getInstance().createCriteria(Invoice.class);
        queryInvoices.add(Restrictions.eq(Invoice.PROPERTY_SALESORDER, objOrder));
        List<Invoice> listInvoices = queryInvoices.list();
        if (listInvoices.size() > 0) {
            return true;
        }
        
        return false;
    }

    public Boolean validateRelationInvoice2(Order objOrder) {

        OBCriteria<ShipmentInOut> queryShipments = OBDal.getInstance().createCriteria(ShipmentInOut.class);
        queryShipments.add(Restrictions.eq(ShipmentInOut.PROPERTY_SALESORDER, objOrder));
        List<ShipmentInOut> listShipment = queryShipments.list();
        if (listShipment.size() > 0) {
            return true;
        } else {
            return false;
        }

        // OBCriteria<Invoice> queryInvoices =
        // OBDal.getInstance().createCriteria(Invoice.class);
        // queryInvoices.add(Restrictions.eq(Invoice.PROPERTY_SALESORDER, objOrder));
        // List<Invoice> listInvoices = queryInvoices.list();
        // if(listInvoices.size()>0) {
        // return true;
        // }else {
        // return false;
        // }

    }

    public void updateRouteOrganization(Organization objOrganization, Order objOrder, DocumentType DocTransaction,
            Warehouse wareHouse, Costcenter costCenter) {
        try {

            TriggerHandler.getInstance().disable();
            // Recovery original order processed
            Boolean processedOriginal = objOrder.isProcessed();
            // Set processed temporal
            objOrder.setProcessed(false);
            OBDal.getInstance().save(objOrder);
            OBDal.getInstance().getConnection().commit();
            OBDal.getInstance().flush();

            // set Main Organization
            objOrder.setOrganization(objOrganization);
            objOrder.setTransactionDocument(DocTransaction);
            objOrder.setDocumentType(DocTransaction);
            objOrder.setWarehouse(wareHouse);
            objOrder.setCostcenter(costCenter);
            OBDal.getInstance().save(objOrder);
            OBDal.getInstance().flush();

            // 1.- Descuentos
            OBCriteria<OrderDiscount> queryOrderDiscount = OBDal.getInstance().createCriteria(OrderDiscount.class);
            queryOrderDiscount.add(Restrictions.eq(OrderDiscount.PROPERTY_SALESORDER, objOrder));
            List<OrderDiscount> listOrderDiscount = queryOrderDiscount.list();
            if (listOrderDiscount.size() > 0) {
                for (OrderDiscount objOrderDiscount : listOrderDiscount) {
                    objOrderDiscount.setOrganization(objOrganization);
                    OBDal.getInstance().save(objOrderDiscount);
                    OBDal.getInstance().flush();
                }
            }

            // 2.- Lineas
            OBCriteria<OrderLine> queryOrderLine = OBDal.getInstance().createCriteria(OrderLine.class);
            queryOrderLine.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, objOrder));
            List<OrderLine> listOrderLine = queryOrderLine.list();
            if (listOrderLine.size() > 0) {
                for (OrderLine objOrderLine : listOrderLine) {

                    objOrderLine.setOrganization(objOrganization);
                    objOrderLine.setWarehouse(wareHouse);
                    OBDal.getInstance().save(objOrderLine);
                    OBDal.getInstance().flush();

                    // 1.-Modificacion precios
                    OBCriteria<OrderLineOffer> queryOrderLineOffer = OBDal.getInstance()
                            .createCriteria(OrderLineOffer.class);
                    queryOrderLineOffer.add(Restrictions.eq(OrderLineOffer.PROPERTY_SALESORDERLINE, objOrderLine));
                    List<OrderLineOffer> listOrderLineOffer = queryOrderLineOffer.list();
                    if (listOrderLineOffer.size() > 0) {
                        for (OrderLineOffer objOrderLineOffer : listOrderLineOffer) {
                            objOrderLineOffer.setOrganization(objOrganization);
                            OBDal.getInstance().save(objOrderLineOffer);
                            OBDal.getInstance().flush();
                        }
                    }

                    // 2.-Linea de impuesto
                    OBCriteria<OrderLineTax> queryOrderLineTax = OBDal.getInstance().createCriteria(OrderLineTax.class);
                    queryOrderLineTax.add(Restrictions.eq(OrderLineTax.PROPERTY_SALESORDERLINE, objOrderLine));
                    List<OrderLineTax> listOrderLineTax = queryOrderLineTax.list();
                    if (listOrderLineTax.size() > 0) {
                        for (OrderLineTax objOrderLineTax : listOrderLineTax) {
                            objOrderLineTax.setOrganization(objOrganization);
                            OBDal.getInstance().save(objOrderLineTax);
                            OBDal.getInstance().flush();
                        }
                    }

                    // 3.-stock reservado
                    OBCriteria<SOLReservedStock> querySOLReservedStock = OBDal.getInstance()
                            .createCriteria(SOLReservedStock.class);
                    querySOLReservedStock.add(Restrictions.eq(SOLReservedStock.PROPERTY_SALESORDERLINE, objOrderLine));
                    List<SOLReservedStock> listSOLReservedStock = querySOLReservedStock.list();
                    if (listSOLReservedStock.size() > 0) {
                        for (SOLReservedStock objSOLReservedStock : listSOLReservedStock) {
                            objSOLReservedStock.setOrganization(objOrganization);
                            OBDal.getInstance().save(objSOLReservedStock);
                            OBDal.getInstance().flush();
                        }
                    }

                    // 4.-Regalos
                    OBCriteria<SsbodGiftOrder> querySsbodGiftOrder = OBDal.getInstance()
                            .createCriteria(SsbodGiftOrder.class);
                    querySsbodGiftOrder.add(Restrictions.eq(SsbodGiftOrder.PROPERTY_ORDERLINE, objOrderLine));
                    List<SsbodGiftOrder> listSsbodGiftOrder = querySsbodGiftOrder.list();
                    if (listSsbodGiftOrder.size() > 0) {
                        for (SsbodGiftOrder objSsbodGiftOrder : listSsbodGiftOrder) {
                            objSsbodGiftOrder.setOrganization(objOrganization);
                            OBDal.getInstance().save(objSsbodGiftOrder);
                            OBDal.getInstance().flush();
                        }
                    }

                }
            }

            // 3.- Impuesto
            OBCriteria<OrderTax> queryOrderTax = OBDal.getInstance().createCriteria(OrderTax.class);
            queryOrderTax.add(Restrictions.eq(OrderTax.PROPERTY_SALESORDER, objOrder));
            List<OrderTax> listOrderTax = queryOrderTax.list();
            if (listOrderTax.size() > 0) {
                for (OrderTax objOrderTax : listOrderTax) {
                    objOrderTax.setOrganization(objOrganization);
                    OBDal.getInstance().save(objOrderTax);
                    OBDal.getInstance().flush();
                }
            }
            // 4.- Plan de cobro
            List<FIN_PaymentSchedule> listFIN_PaymentSchedule = objOrder.getFINPaymentScheduleList();
            for (FIN_PaymentSchedule objFIN_PaymentSchedule : listFIN_PaymentSchedule) {

                objFIN_PaymentSchedule.setOrganization(objOrganization);
                OBDal.getInstance().save(objFIN_PaymentSchedule);
                OBDal.getInstance().flush();

                List<FIN_PaymentScheduleDetail> listFIN_PaymentDetail = objFIN_PaymentSchedule.getFINPaymentScheduleDetailOrderPaymentScheduleList();
                if (listFIN_PaymentDetail.size() > 0) {
                    for (FIN_PaymentScheduleDetail objFIN_PaymentDetail : listFIN_PaymentDetail) {
                        objFIN_PaymentDetail.setOrganization(objOrganization);
                        OBDal.getInstance().save(objFIN_PaymentDetail);
                        OBDal.getInstance().flush();
                    }
                }

            }

            // 5.- autorizaciones
            OBCriteria<OrderApproval> queryOrderApproval = OBDal.getInstance().createCriteria(OrderApproval.class);
            queryOrderApproval.add(Restrictions.eq(OrderApproval.PROPERTY_SALESORDER, objOrder));
            List<OrderApproval> listOrderApproval = queryOrderApproval.list();
            if (listOrderApproval.size() > 0) {
                for (OrderApproval objOrderApproval : listOrderApproval) {
                    objOrderApproval.setOrganization(objOrganization);
                    OBDal.getInstance().save(objOrderApproval);
                    OBDal.getInstance().flush();
                }
            }

            // 6.- Disponiblidad de Stock
            OBCriteria<SOVSLdmProd> querySOVSLdmProd = OBDal.getInstance().createCriteria(SOVSLdmProd.class);
            querySOVSLdmProd.add(Restrictions.eq(SOVSLdmProd.PROPERTY_ORDER, objOrder));
            List<SOVSLdmProd> listSOVSLdmProd = querySOVSLdmProd.list();
            if (listSOVSLdmProd.size() > 0) {
                for (SOVSLdmProd objSOVSLdmProd : listSOVSLdmProd) {
                    objSOVSLdmProd.setOrganization(objOrganization);
                    OBDal.getInstance().save(objSOVSLdmProd);
                    OBDal.getInstance().flush();
                }
            }

            // Set Original value for Processed field
            objOrder.setProcessed(processedOriginal);
            ;
            OBDal.getInstance().save(objOrder);
            OBDal.getInstance().flush();

        } catch (Exception e) {
            throw new OBException("Error when updating the organization. " + e.getMessage());
        } finally {
            if (TriggerHandler.getInstance().isDisabled()) {
                TriggerHandler.getInstance().enable();
            }
        }

    }

    public void updateRouteDispatcher(Organization objOrganization, Order objOrder) {
        try {

            String route = objOrganization.getSsforRoute();
            BusinessPartner bPartner = objOrganization.getSsforCBpartner();

            // Validate fields
            Objects.requireNonNull(route, "La Organización no tiene una ruta definida");
            Objects.requireNonNull(bPartner, "La Organización no tiene un despachador definido");

            TriggerHandler.getInstance().disable();
            // Recovery original order processed
            Boolean processedOriginal = objOrder.isProcessed();
            // Set processed temporal
            objOrder.setProcessed(false);
            OBDal.getInstance().save(objOrder);
            OBDal.getInstance().getConnection().commit();
            OBDal.getInstance().flush();

            // Update dispatcher section in Order
            objOrder.setSSFORRoute(route);
            objOrder.setSSFORDispatcher(bPartner);
            OBDal.getInstance().save(objOrder);
            OBDal.getInstance().flush();

            // Set Original value for Processed field
            objOrder.setProcessed(processedOriginal);
            OBDal.getInstance().save(objOrder);
            OBDal.getInstance().flush();
        } catch (Exception e) {
            //String helper = Ssfor_Utils.getErrorMessage(logger,e);
            throw new OBException("Error");
        } finally {
            if (TriggerHandler.getInstance().isDisabled()) {
                TriggerHandler.getInstance().enable();
            }
        }

    }
}
