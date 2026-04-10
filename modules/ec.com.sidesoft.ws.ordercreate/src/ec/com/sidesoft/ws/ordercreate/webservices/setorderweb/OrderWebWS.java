package ec.com.sidesoft.ws.ordercreate.webservices.setorderweb;

import java.io.InputStreamReader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.enterprise.Warehouse;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.financialmgmt.payment.FIN_PaymentMethod;
import org.openbravo.model.financialmgmt.payment.PaymentTerm;
import org.openbravo.model.financialmgmt.tax.TaxCategory;
import org.openbravo.model.financialmgmt.tax.TaxRate;
import org.openbravo.model.pricing.pricelist.PriceList;
import org.openbravo.model.pricing.pricelist.ProductPrice;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.openbravo.service.web.WebService;
import org.openbravo.model.ad.access.User;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ec.com.sidesoft.ws.ordercreate.data.SWSOCConfig;
import ec.com.sidesoft.ws.ordercreate.webservices.util.ResponseWS;

public class OrderWebWS implements WebService {
  private static final Logger logger = Logger.getLogger(OrderWebWS.class);
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    JsonElement element = new JsonParser().parse(new InputStreamReader(request.getInputStream()));
    JsonObject jsonOrder = element.getAsJsonObject();
    JsonObject dataPedido = jsonOrder.getAsJsonObject("data");
    ResponseWS responseWS = insertSalesOrder(dataPedido);

    final String json = getResponse(responseWS);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    final Writer w = response.getWriter();
    w.write(json);
    w.close();
  }

  @Override
  public void doDelete(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void doPut(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  public ResponseWS insertSalesOrder(JsonObject dataPedido) {
    String documentNo = null;
    ResponseWS responseWS = new ResponseWS();

    try {

      // CREANDO INSTANCIA DEL PEDIDO A INSERTAR
      Order ordOB = OBProvider.getInstance().get(Order.class);
      ordOB.setActive(true);
      ordOB.setSalesTransaction(true);

      // ORGANIZACION DEL PEDIDO
      String strOrgId = dataPedido.get("ORG_OB").getAsString();
      if (strOrgId == null || strOrgId.equals("")) {
        throw new OBException("El campo organizacion no debe estar vacio");
      }
      final Organization org = OBDal.getInstance().get(Organization.class, strOrgId);
      SWSOCConfig utilConfig = getConfig(org);
      if (utilConfig == null) {
        throw new OBException(
            "No existe una configuracion definida para la organizacion " + org.getName());
      }
      ordOB.setClient(org.getClient());
      ordOB.setOrganization(org);
      logger.info("Org " + org.getName());

      // USUARIO QUE CREA Y MODIFICA EL PEDIDO
      User usr =  null; //utilConfig.getUser();
      ordOB.setCreatedBy(usr);
      ordOB.setUpdatedBy(usr);
      logger.info("Usr " + usr.getName());

      // TIPO DE DOCUMENTO DEL PEDIDO
      DocumentType docType = utilConfig.getDoctype();
      ordOB.setDocumentType(docType);
      ordOB.setTransactionDocument(docType);
      logger.info("Doc " + docType.getName());

      // FECHA REGISTRO - FECHA CONTABLE
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String strDate = dataPedido.get("created_at").getAsString();
      if (strDate == null || strDate.equals("")) {
        throw new OBException("El campo fecha no debe estar vacio");
      }
      Date invoiceDate = formatter.parse(strDate);
      ordOB.setOrderDate(invoiceDate);
      ordOB.setAccountingDate(invoiceDate);
      ordOB.setScheduledDeliveryDate(invoiceDate);

      // NUMERO DE DOCUMENTO DEL PEDIDO
      documentNo = Utility.getDocumentNo(OBDal.getInstance().getConnection(false),
          new DalConnectionProvider(), RequestContext.get().getVariablesSecureApp(), "",
          Order.TABLE_NAME, docType.getId(), docType.getId(), false, true);
      ordOB.setDocumentNo(documentNo);
      logger.info("Doc No " + documentNo);

      // ESTATUS DEL PEDIDO POR DEFECTO
      ordOB.setDocumentStatus("DR");
      ordOB.setDocumentAction("CO");
      ordOB.setProcessed(false);
      ordOB.setProcessNow(false);

      // TERCERO
      BusinessPartner bp = null;
      String strIdCustomer = dataPedido.get("ID_CLIENTE_FACTURA").getAsString();
      if (strIdCustomer == null || strIdCustomer.equals("")) {
        throw new OBException("El campo Id del cliente no puede estar vacio");
      }
      bp = getBpartner(strIdCustomer);
      if (bp == null) {
        throw new OBException("No existe un tercero con el codigo tax id: " + strIdCustomer);
      }
      ordOB.setBusinessPartner(bp);
      logger.info("Tercero " + bp.getName());
      
      // AGENTE COMERIAL
      if(bp.getSalesRepresentative() != null) {
        User salesRep = null;
        salesRep = getSalesRepresentative(bp.getSalesRepresentative());
        if (salesRep != null) {
          ordOB.setSalesRepresentative(salesRep);
        }              
      }
      
      // METODO DE PAGO DEL PEDIDO
      FIN_PaymentMethod payMet = null;
      String strPayMet = dataPedido.get("payment_method").getAsString();
      if (strPayMet == null || strPayMet.equals("")) {
        throw new OBException("El campo metodo de pago no puede estar vacio");
      }
      payMet = OBDal.getInstance().get(FIN_PaymentMethod.class, strPayMet);
      if (payMet == null) {
        throw new OBException("No existe un metodo de pago con el codigo: " + strPayMet);
      }
      ordOB.setPaymentMethod(payMet);
      logger.info("Metpago " + payMet.getName());

      // DESCRIPCION DEL PEDIDO
      String strDescripcion = dataPedido.get("notes").getAsString();
      if (strDescripcion == null || strDescripcion.equals("")) {
        strDescripcion = "Pedido Venta No " + documentNo + ", creado por WS Web ";
      }
      ordOB.setDescription(strDescripcion);

      // DIRECCION DEL TERCERO
      Location bpAddress = getBpAddress(bp.getBusinessPartnerLocationList());
      if (bpAddress == null) {
        throw new OBException("El terceror " + bp.getName() + "no tiene definida una direccion");
      }
      ordOB.setPartnerAddress(bpAddress);
      ordOB.setInvoiceAddress(bpAddress);

      // MONEDA DEL PEDIDO
      Currency currency = null;
      currency = utilConfig.getCurrency();
      ordOB.setCurrency(currency);
      logger.info("Moneda " + currency.getISOCode());

      // TERMINO DE PAGO
      PaymentTerm payTerms = utilConfig.getPaymentterm();
      if (payTerms == null) {
        throw new OBException("Debe agregar el termino de pago en la configuracion");
      }
      ordOB.setPaymentTerms(payTerms);
      logger.info("Con pago " + payTerms.getName());

      // LISTA DE PRECIOS
      if(bp.getPriceList() != null) {
          ordOB.setPriceList(bp.getPriceList());
      }else {
        PriceList priceList = utilConfig.getPricelist();
        if (priceList == null) {
          throw new OBException("Debe configurar una price list");
        }
        ordOB.setPriceList(priceList);
        logger.info("Precio Lista" + priceList.getName());
      }

      // AlMACEN
      Warehouse warehouse =  null; //utilConfig.getWarehouse();
      if (warehouse == null) {
        throw new OBException("Debe agregar en la configuracion el almacen por defecto");
      }
      ordOB.setWarehouse(warehouse);

//      // FUENTE
//      String strSource = dataPedido.get("source").getAsString();
//      if (strSource == null || strSource.equals("")) {
//        throw new OBException("El campo source no debe estar vacio");
//      }
//      ordOB.setSaqbSource(strSource);

      logger.info("************************************ ");
      logger.info("************************************ ");

      // GUARDANDO EL PEDIDO
      OBDal.getInstance().save(ordOB);

      // GUARDANDO LINEAS
      JsonArray lineasPedido = dataPedido.get("line_items").getAsJsonArray();
      
      boolean flagLineas = true;
      long numLine = 10;
      for (JsonElement eleLinea : lineasPedido) {
        JsonObject lineaObj = eleLinea.getAsJsonObject();
        insertLineSalesOrder(numLine, lineaObj, ordOB);
        numLine = numLine + 10;
      }

      OBDal.getInstance().flush();
      responseWS.setDocumentNo(documentNo);
      responseWS.setStatus("OK");
      responseWS.setMessage("El pedido de venta fue creado exitosamente");

    } catch (OBException e) {
      String errorMsg = null;
      logger.error("Error al procesar transaccion" + e.getMessage(), e);
      OBDal.getInstance().rollbackAndClose();
      Throwable ex = DbUtility.getUnderlyingSQLException(e);
      if (ex.getMessage() != null) {
        errorMsg = "Error al insertar cabecera del pedido, " + ex.getMessage();
      } else if (e.getMessage() != null) {
        errorMsg = "Error al insertar cabecera del pedido, " + e.getMessage();
      } else {
        errorMsg = "Error al insertar cabecera del pedido, Error no tipificado por el sistema, revise la data enviada.";
      }

      responseWS.setDocumentNo("N/A");
      responseWS.setStatus("ERROR");
      responseWS.setMessage(errorMsg);

      return responseWS;
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return responseWS;
  }

  public void insertLineSalesOrder(long numLinea, JsonObject lineaObj, Order ordOB)
      throws OBException {

    // INSTANCIANDO OBJETO LINEA Y SETEANDO VALORES FIJOS DE LA CABECERA
    Organization org = ordOB.getOrganization();
    OrderLine ordLineOB = OBProvider.getInstance().get(OrderLine.class);
    ordLineOB.setClient(ordOB.getClient());
    ordLineOB.setOrganization(org);
    ordLineOB.setActive(true);
    ordLineOB.setCreatedBy(ordOB.getCreatedBy());
    ordLineOB.setUpdatedBy(ordOB.getUpdatedBy());
    ordLineOB.setSalesOrder(ordOB);
    ordLineOB.setLineNo(numLinea);

    // FECHA PEDIDO
    ordLineOB.setOrderDate(ordOB.getOrderDate());

    // PRODUCTO
    Product product = null;
    String strProduct = lineaObj.get("product_id").getAsString();
    if (strProduct == null || strProduct.equals("")) {
      throw new OBException("El campo producto no puede estar vacio");
    }
    logger.info("ID producto " + strProduct);
    product = getProduct(strProduct);
    if (product == null) {
      throw new OBException(
          "El producto con ID " + strProduct + ", no esta creado en la ventana de homologacion");
    }
    ordLineOB.setProduct(product);

    // CANTIDAD VENDIDA
    BigDecimal qty = null;
    String strQty = lineaObj.get("quantity").getAsString();
    if (strQty == null || strQty.equals("")) {
      throw new OBException("El campo cantidad no puede estar vacio");
    } else {
      qty = new BigDecimal(strQty);
    }
    ordLineOB.setOrderedQuantity(qty);

    // UNIDAD DE MEDIDA
    ordLineOB.setUOM(product.getUOM());

    // MONEDA
    ordLineOB.setCurrency(ordOB.getCurrency());

    // OBTENIENDO EL PRECIO DEL PRODUCTO
    List<ProductPrice> ListProPrice = product.getPricingProductPriceList();
    ProductPrice pPrice = ListProPrice.get(0);
    BigDecimal priceList = pPrice.getListPrice();
    ordLineOB.setListPrice(priceList);

    // PRECIO POR UNIDAD
    BigDecimal price = null;
    String strUnitPrice = lineaObj.get("price").getAsString();
//    if (strUnitPrice == null || strUnitPrice.equals("")) {
//      price = priceList;
//      ordLineOB.setGrossUnitPrice(priceList);
//      ordLineOB.setUnitPrice(priceList);
//    } else {
//      price = new BigDecimal(strUnitPrice);
//      ordLineOB.setGrossUnitPrice(price);
//      ordLineOB.setUnitPrice(price);
//    }
    
    price = new BigDecimal(strUnitPrice);

    // PRECIO LIMITE
    ordLineOB.setPriceLimit(price);
    ordLineOB.setListPrice(price);
    ordLineOB.setGrossUnitPrice(price);
    ordLineOB.setBaseGrossUnitPrice(price);
    ordLineOB.setGrossListPrice(price);
    ordLineOB.setUnitPrice(price);
    ordLineOB.setStandardPrice(price);

    BigDecimal zero = new BigDecimal("0");
    ordLineOB.setDiscount(zero);
    
    // MONTO NETO DE LA LINEA
    int stdPrecision = ordOB.getCurrency().getStandardPrecision().intValue();
    BigDecimal lineNetAmount = qty.multiply(price).setScale(stdPrecision, RoundingMode.HALF_UP);
    ordLineOB.setLineNetAmount(lineNetAmount);
    ordLineOB.setTaxableAmount(lineNetAmount);

    // TOTAL NETO DE LA ORDEN
    /*if (ordOB.getSummedLineAmount() != null) {
      BigDecimal newLineNetAmt = lineNetAmount.add(ordOB.getSummedLineAmount());
      ordOB.setSummedLineAmount(newLineNetAmt);
    } else {
      ordOB.setSummedLineAmount(lineNetAmount);
    } */

    // TERCERO
    ordLineOB.setBusinessPartner(ordOB.getBusinessPartner());

    // AlMACEN
    ordLineOB.setWarehouse(ordOB.getWarehouse());

    // DESCRIPCION DE LA LINEA
//    String descLinea = null;
//    JsonArray opcionesProducto = lineaObj.get("line_items_options").getAsJsonArray();
//    for (JsonElement eleOpcion : opcionesProducto) {
//      JsonObject opcionObj = eleOpcion.getAsJsonObject();
//      String feature = opcionObj.get("feature_name").getAsString();
//      String option = opcionObj.get("option_name").getAsString();
//      if (descLinea == null) {
//        descLinea = feature + " - " + option;
//      } else {
//        descLinea += "; " + feature + " - " + option;
//      }
//    }
//    ordLineOB.setDescription(descLinea);

    // IMPUESTO
//    TaxRate taxRate = null;
//    String strTax = lineaObj.get("tax_id").getAsString();
//    if (strTax == null || strTax.equals("")) {
//      throw new OBException("El campo impuesto no puede estar vacio");
//    }
//  taxRate = OBDal.getInstance().get(TaxRate.class, strTax);
//  ordLineOB.setTax(taxRate);    
    
    // IMPUESTO
    TaxRate taxRate = null;
    String strTax = lineaObj.get("tax_id").getAsString();
    if (strTax == null || strTax.equals("strTax")) {
      throw new OBException("El campo impuesto no puede estar vacio");
    }

    // taxRate = OBDal.getInstance().get(TaxRate.class, strTax);
    taxRate = getTax(product);
    ordLineOB.setTax(taxRate);  
    
    // AGRENDADO LA LINEA DEL PEDIDO
    ordOB.getOrderLineList().add(ordLineOB);
    OBDal.getInstance().save(ordLineOB);

  }

  private SWSOCConfig getConfig(Organization org) {
    SWSOCConfig config = null;

    OBCriteria<SWSOCConfig> cfgCrt = OBDal.getInstance().createCriteria(SWSOCConfig.class);
    cfgCrt.add(Restrictions.eq(SWSOCConfig.PROPERTY_ORGANIZATION, org));
    config = (SWSOCConfig) cfgCrt.uniqueResult();

    return config;
  }

  private BusinessPartner getBpartner(String taxID) {
    BusinessPartner bp = null;

    OBCriteria<BusinessPartner> cfgCrt = OBDal.getInstance().createCriteria(BusinessPartner.class);
    cfgCrt.add(Restrictions.eq(BusinessPartner.PROPERTY_TAXID, taxID));
    bp = (BusinessPartner) cfgCrt.uniqueResult();

    return bp;
  }
  
  private User getSalesRepresentative(BusinessPartner salesRepBP) {
    User salesRep = null;
    OBCriteria<User> cfgCrt = OBDal.getInstance().createCriteria(User.class);
    cfgCrt.add(Restrictions.eq(User.PROPERTY_BUSINESSPARTNER, salesRepBP));
    salesRep = (User) cfgCrt.uniqueResult();

    return salesRep;
  }  
  
  private Location getBpAddress(List<Location> addressBp) {
    Location billaddress = null;

    for (Location location : addressBp) {
      if (location.isInvoiceToAddress()) {
        billaddress = location;
      }
    }

    if (billaddress == null && addressBp.size() > 0) {
      billaddress = (Location) addressBp.get(0);
    }

    return billaddress;
  }

  private TaxRate getTax(Product product) {
    TaxCategory taxCat = product.getTaxCategory();
    OBCriteria<TaxRate> taxCrt = OBDal.getInstance().createCriteria(TaxRate.class);
    taxCrt.add(Restrictions.eq(TaxRate.PROPERTY_TAXCATEGORY, taxCat));
    TaxRate tax = (TaxRate) taxCrt.uniqueResult();

    return tax;
  }
  
  private Product getProduct(String idProduct) {
    Product product = null;

    OBCriteria<Product> proCrt = OBDal.getInstance().createCriteria(Product.class);
    proCrt.add(Restrictions.eq(Product.PROPERTY_ID, idProduct));
    product = (Product) proCrt.uniqueResult();
    
    if (product == null) {
      ////NO SE ENCONTRO EL PRODUCTO
    }
    
    return product;
  }
  
  private String getResponse(ResponseWS response) {
    Gson gson = new Gson();
    String json = gson.toJson(response);
    return json;
  }

}
