package ec.com.sidesoft.dispatchmobile.ad_process_data;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.businesspartner.Location;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Locator;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.geography.Country;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.module.idljava.proc.IdlServiceJava;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.crm.visitplan.Scrvro_VendorRoute;
import ec.com.sidesoft.crm.visitplan.Scrvro_VendorRouteLine;

public class ImportOrderData extends IdlServiceJava {
  int fila = 1;

  public String getEntityName() {
    return "ImportOrderData";
  }

  public Parameter[] getParameters() {
    fila = 1;
    return new Parameter[] { new Parameter("Chofer", Parameter.STRING), // 0
        new Parameter("Ruta", Parameter.STRING), // 1
        new Parameter("Direccion", Parameter.STRING), // 2
        new Parameter("Pedido", Parameter.STRING), // 3
        new Parameter("Tipo Documento", Parameter.STRING), // 4
        new Parameter("Hueco", Parameter.STRING), // 5
        new Parameter("Organizacion", Parameter.STRING) // 6
    };

  }

  protected Object[] validateProcess(Validator validator, String... values) throws Exception {

    validator.checkString(values[0], 60);
    validator.checkString(values[1], 60);
    validator.checkString(values[2], 60);
    validator.checkString(values[3], 30);
    validator.checkString(values[4], 60);
    validator.checkString(values[5], 40);
    validator.checkString(values[6], 60);

    // Validar Pedido de venta existente
    Order objOrder = findDALInstance(false, Order.class,
        new Value(Order.PROPERTY_DOCUMENTNO, values[3]),
        new Value(Order.PROPERTY_SALESTRANSACTION, true));
    if (objOrder == null) {
      throw new OBException(
          "Fila [" + fila + "], Pedido con el número de documento: " + values[3] + " no existe.");
    }
    if (!objOrder.getDocumentStatus().equals("DR") && objOrder.getInvoiceList().size() > 0) {
      throw new OBException("Fila [" + fila + "], Pedido con el número de documento: " + values[3]
          + " se encuentra facturado.");
    }
    // Validar Pedido de venta existente
    BusinessPartner objSeller = findDALInstance(false, BusinessPartner.class,
        new Value(BusinessPartner.PROPERTY_NAME, values[0]));
    if (objSeller == null) {
      throw new OBException("Fila [" + fila + "], El Chofer : " + values[0] + " no existe.");
    }
    if (objSeller.getADUserList().isEmpty()) {
      throw new OBException(
          "Fila [" + fila + "], El Chofer : " + values[1] + " no esta asociado a un Usuario.");
    }
    // Validar Tipo de documento
    if (StringUtils.isNotBlank(values[4]) && getDocumentType(values[4]) == null) {
      throw new OBException(
          "Fila [" + fila + "], El Tipo de documento : " + values[4] + " no existe.");
    }

    // Validar Hueco
    if (StringUtils.isNotBlank(values[5]) && getLocation(values[5]) == null) {
      throw new OBException(
          "Fila [" + fila + "], El Hueco : " + values[5] + " no corresponde a ningun almacen.");
    }

    // Validar Organizacion
    if (StringUtils.isNotBlank(values[6]) && getOrg(values[6]) == null) {
      throw new OBException("Fila [" + fila + "], La Organizacion : " + values[6] + " no existe.");
    }
    fila++;

    return values;
  }

  public BaseOBObject internalProcess(Object... values) throws Exception {

    return updateDataOrder((String) values[0], (String) values[1], (String) values[2],
        (String) values[3], (String) values[4], (String) values[5], (String) values[6]);
  }

  public BaseOBObject updateDataOrder(final String Chofer, final String Ruta,
      final String Direccion, final String NoPedido, final String TipoDocumento,
      final String Almacen, final String Organizacion) throws Exception {
    // Validar Pedido de venta existente
    Order objOrder = findDALInstance(false, Order.class,
        new Value(Order.PROPERTY_DOCUMENTNO, NoPedido),
        new Value(Order.PROPERTY_SALESTRANSACTION, true));
    if (objOrder == null) {
      throw new OBException("Pedido con el número de documento: " + NoPedido + " no existe.");
    }

    if (!objOrder.getDocumentStatus().equals("DR") && objOrder.getInvoiceList().size() > 0) {
      throw new OBException(
          "Pedido con el número de documento: " + NoPedido + " se encuentra facturado.");
    }

    String msg = " ";

    if (!objOrder.getDocumentStatus().equals("DR")) {

      try {
        if (!objOrder.getDocumentStatus().equals("DR") && objOrder.isProcessed().equals(true)) {
          objOrder.setProcessed(false);
          OBDal.getInstance().save(objOrder);
          OBDal.getInstance().flush();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      try {
        if (!objOrder.getDocumentStatus().equals("DR")) {
          objOrder.setDocumentAction("RE");
          OBDal.getInstance().save(objOrder);
          OBDal.getInstance().flush();
        }
      } catch (Exception e) {
        throw new OBException(e.getMessage().toString());
      }

      try {
        if (!objOrder.getDocumentStatus().equals("DR") && objOrder.isProcessed().equals(false)) {
          objOrder.setProcessed(true);
          OBDal.getInstance().save(objOrder);
          OBDal.getInstance().flush();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }

      msg = processOrder(objOrder, NoPedido);
      if (StringUtils.containsIgnoreCase(msg, "error")) {
        throw new OBException("Pedido con el número de documento: " + NoPedido + " no existe.");
      }

    }

    // Validar Pedido de venta existente
    BusinessPartner objSeller = findDALInstance(false, BusinessPartner.class,
        new Value(BusinessPartner.PROPERTY_NAME, Chofer));
    if (objSeller == null) {
      throw new OBException("El Chofer : " + Chofer + " no existe.");
    }
    if (objSeller.getADUserList().isEmpty()) {
      throw new OBException("El Chofer : " + Chofer + " no esta asociado a un Usuario.");
    }
    getRoute(Ruta.trim(), objSeller);

    Location bpAddress = getBpAddress(Direccion, objOrder.getBusinessPartner());

    // Validar Tipo de documento
    DocumentType doctype = null;
    String docNo = null;
    if (StringUtils.isNotBlank(TipoDocumento)) {
      if (getDocumentType(TipoDocumento) == null) {
        throw new OBException(
            "Fila [" + fila + "], El Tipo de documento : " + TipoDocumento + " no existe.");
      }

      doctype = getDocumentType(TipoDocumento);
      docNo = getDocumentNoOrder(doctype);
    }

    // Validar Hueco
    Locator loc = null;
    if (StringUtils.isNotBlank(Almacen)) {
      if (getLocation(Almacen) == null) {
        throw new OBException(
            "Fila [" + fila + "], El Hueco : " + Almacen + " no corresponde a ningun almacen.");
      }
      loc = getLocation(Almacen);
    }
    // Validar Hueco
    Organization org = null;
    if (StringUtils.isNotBlank(Organizacion)) {
      if (getOrg(Organizacion) == null) {
        throw new OBException(
            "Fila [" + fila + "], La Organizacion : " + Organizacion + " no existe.");
      }
      org = getOrg(Organizacion);
    }
    try {
      objOrder.setSsdpmDispatcherUser(objSeller.getADUserList().get(0));
      objOrder.setSsdpmDispatcherRoute(Ruta.trim());
      objOrder.setPartnerAddress(bpAddress);
      objOrder.setInvoiceAddress(bpAddress);

      // Reasignamos el Tipo de documentos
      if (StringUtils.isNotBlank(docNo)
          && !objOrder.getDocumentType().getId().equals(doctype.getId())) {
        objOrder.setDocumentType(doctype);
        objOrder.setTransactionDocument(doctype);
        objOrder.setDocumentNo(docNo);
      }

      // Reasignamos la Organizacion a la cabecera y Lineas
      if (org != null) {
        objOrder.setOrganization(org);
        if (objOrder.getOrderLineList().size() > 0) {
          for (OrderLine line : objOrder.getOrderLineList()) {
            line.setOrganization(org);
          }
        }
      }

      // Reasignamos el Almacen a la Cabecera y Lineas
      if (loc != null) {
        objOrder.setWarehouse(loc.getWarehouse());
        if (objOrder.getOrderLineList().size() > 0) {
          for (OrderLine line : objOrder.getOrderLineList()) {
            line.setWarehouse(loc.getWarehouse());
          }
        }
      }

      OBDal.getInstance().save(objOrder);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Inicio cambio de estado
    try {
      if (!objOrder.getDocumentStatus().equals("DR") && objOrder.isProcessed().equals(true)) {
        objOrder.setDocumentAction("CO");
        OBDal.getInstance().save(objOrder);
        OBDal.getInstance().flush();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    msg = processOrder(objOrder, NoPedido);

    OBDal.getInstance().commitAndClose();
    return objOrder;
  };

  private void getRoute(String route, BusinessPartner seller) throws Exception {

    OBCriteria<Scrvro_VendorRoute> crtVendor = OBDal.getInstance()
        .createCriteria(Scrvro_VendorRoute.class);
    crtVendor.add(Restrictions.eq(Scrvro_VendorRoute.PROPERTY_BUSINESSAGENT, seller));
    crtVendor.setMaxResults(1);

    Scrvro_VendorRoute vendor = null;
    if (crtVendor.count() == 0) {
      // Get Organization *
      Organization objOrg = OBDal.getInstance().get(Organization.class, "0");

      // Create new record
      vendor = OBProvider.getInstance().get(Scrvro_VendorRoute.class);
      vendor.setBusinessAgent(seller);
      vendor.setOrganization(objOrg);
      OBDal.getInstance().save(vendor);
      OBDal.getInstance().flush();
    } else {
      vendor = (Scrvro_VendorRoute) crtVendor.uniqueResult();
    }
    getVendorRoute(route, vendor);
  }

  private void getVendorRoute(String route, Scrvro_VendorRoute vendor) throws Exception {
    Boolean existRoute = false;
    for (Scrvro_VendorRouteLine routeLine : vendor.getScrvroVendorRouteLineList()) {
      if (routeLine.getRoute().equals(route)) {
        existRoute = true;
      }
    }

    if (vendor.getScrvroVendorRouteLineList().isEmpty() || !existRoute) {
      createVendorRouteLine(route, vendor);
    }
  }

  private void createVendorRouteLine(String route, Scrvro_VendorRoute vendor) throws Exception {
    // Create new record
    Scrvro_VendorRouteLine line = OBProvider.getInstance().get(Scrvro_VendorRouteLine.class);
    line.setScrvroVendorRoute(vendor);
    line.setOrganization(vendor.getOrganization());
    line.setRoute(route);
    line.setNumberWeeks(1L);
    line.setTypeRoute("E");
    OBDal.getInstance().save(line);
    OBDal.getInstance().flush();
  }

  private Location getBpAddress(String address, BusinessPartner businessPartner) throws Exception {
    Location lbp = null;
    Boolean existLocation = false;

    if (businessPartner.getBusinessPartnerLocationList().isEmpty()) {
      lbp = createBusinessPartnerLocation(address, businessPartner);
    } else {
      for (Location locbp : businessPartner.getBusinessPartnerLocationList()) {
        if (locbp.getLocationAddress() != null
            && locbp.getLocationAddress().getAddressLine1().equals(address)) {
          existLocation = true;
          lbp = locbp;
        }
      }
      if (!existLocation) {
        lbp = createBusinessPartnerLocation(address, businessPartner);
      }
    }
    return lbp;
  }

  private Location createBusinessPartnerLocation(String address, BusinessPartner businessPartner)
      throws Exception {
    // Get Organization *
    Organization objOrg = OBDal.getInstance().get(Organization.class, "0");

    org.openbravo.model.common.geography.Location location = OBProvider.getInstance()
        .get(org.openbravo.model.common.geography.Location.class);
    location.setAddressLine1(address);
    location.setOrganization(objOrg);
    OBCriteria<Country> qCountry = OBDal.getInstance().createCriteria(Country.class);
    qCountry.add(Restrictions.eq(Country.PROPERTY_ACTIVE, true));
    qCountry.add(Restrictions.eq(Country.PROPERTY_ISOCOUNTRYCODE, "EC"));
    qCountry.setMaxResults(1);
    if (qCountry.list().size() == 0) {
      throw new OBException("countryCode [EC] not found");
    }
    location.setCountry(qCountry.list().get(0));

    OBDal.getInstance().save(location);
    OBDal.getInstance().flush();

    Location businessPartnerLocation = OBProvider.getInstance().get(Location.class);
    businessPartnerLocation.setBusinessPartner(businessPartner);
    businessPartnerLocation.setLocationAddress(location);
    businessPartnerLocation.setOrganization(objOrg);
    businessPartnerLocation.setName(address);
    businessPartnerLocation.setShipToAddress(true);
    businessPartnerLocation.setInvoiceToAddress(true);
    OBDal.getInstance().save(businessPartnerLocation);
    OBDal.getInstance().flush();

    return businessPartnerLocation;
  }

  public Locator getLocation(String locator) {

    OBCriteria<Locator> crtLoc = OBDal.getInstance().createCriteria(Locator.class);
    crtLoc.add(Restrictions.eq(Locator.PROPERTY_SEARCHKEY, locator));
    crtLoc.setMaxResults(1);

    return (Locator) crtLoc.uniqueResult();
  }

  public DocumentType getDocumentType(String doc) {
    String whereStr = " trim(name)='" + doc.trim() + "' and ad_table_id='259' ";

    OBCriteria<DocumentType> crtDoc = OBDal.getInstance().createCriteria(DocumentType.class);
    crtDoc.add(Restrictions.sqlRestriction(whereStr));
    crtDoc.setFilterOnReadableOrganization(false);
    crtDoc.setMaxResults(1);

    return (DocumentType) crtDoc.uniqueResult();
  }

  public Organization getOrg(String org) {
    String whereStr = " trim(name)='" + org.trim() + "' ";

    OBCriteria<Organization> crtDoc = OBDal.getInstance().createCriteria(Organization.class);
    crtDoc.add(Restrictions.sqlRestriction(whereStr));
    crtDoc.setFilterOnReadableOrganization(false);
    crtDoc.setMaxResults(1);

    return (Organization) crtDoc.uniqueResult();
  }

  public String getDocumentNoOrder(DocumentType doctype) {
    String documentNo = null;
    // Numero de documento
    documentNo = Utility.getDocumentNo(OBDal.getInstance().getConnection(false),
        new DalConnectionProvider(), RequestContext.get().getVariablesSecureApp(), "",
        Order.TABLE_NAME, doctype.getId(), doctype.getId(), false, true);
    return documentNo;
  }

  public static String processOrder(Order order, String orderNo) {

    String message = "";

    org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
        .get(org.openbravo.model.ad.ui.Process.class, "104");
    Map<String, String> parameters = new HashMap<String, String>();
    parameters.put("C_Order_ID", order.getId());
    ProcessInstance pInstance = CallProcess.getInstance().call(process, order.getId(), null);

    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);

    String msg = oberror.getMessage();
    if (pInstance.getResult() == 0) {
      throw new OBException("Pedido [" + orderNo + "] : " + msg);
    }

    message = oberror.getMessage();

    return message;
  }
}
