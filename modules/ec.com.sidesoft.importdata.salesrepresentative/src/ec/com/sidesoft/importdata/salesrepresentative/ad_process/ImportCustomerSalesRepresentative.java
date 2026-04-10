package ec.com.sidesoft.importdata.salesrepresentative.ad_process;

import org.apache.log4j.Logger;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.module.idljava.proc.IdlServiceJava;

public class ImportCustomerSalesRepresentative extends IdlServiceJava {
  private static Logger log = Logger.getLogger(ImportCustomerSalesRepresentative.class);

  @Override
  protected String getEntityName() {
    return "Customer Sales Representative";
  }

  public Parameter[] getParameters() {
    return new Parameter[] { new Parameter("IDENTIFICACION_CLIENTE", Parameter.STRING),
        new Parameter("RESPONSABLE", Parameter.STRING) };
  }

  @Override
  protected Object[] validateProcess(Validator validator, String... values) throws Exception {
    validator.checkNotNull(validator.checkString(values[0], 40), "IDENTIFICACION_CLIENTE");
    validator.checkNotNull(validator.checkString(values[1], 60), "RESPONSABLE");
    return values;
  }

  @Override
  protected BaseOBObject internalProcess(Object... values) throws Exception {
    return updateCustomerSalesRepresentative((String) values[0], (String) values[1]);
  }

  private BaseOBObject updateCustomerSalesRepresentative(String searchKey, String salesRepName) {
    // Customer
    BusinessPartner bPartner = findDALInstance(false, BusinessPartner.class,
        new Value("searchKey", searchKey), new Value("customer", true));
    if (bPartner == null) {
      throw new OBException(
          Utility.messageBD(conn, "SIDSREP_Customer_NotExists", vars.getLanguage()) + searchKey);
    }
    // Sales Representative
    BusinessPartner salesRep = findDALInstance(false, BusinessPartner.class,
        new Value("name", salesRepName), new Value("employee", true),
        new Value("isSalesRepresentative", true));
    if (salesRep == null) {
      throw new OBException(
          Utility.messageBD(conn, "SIDSREP_SalesRep_NotExists", vars.getLanguage()) + salesRepName);
    }

    try {
      bPartner.setSalesRepresentative(salesRep);
      OBDal.getInstance().save(bPartner);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      e.printStackTrace();
    }

    // End process
    OBDal.getInstance().commitAndClose();

    return salesRep;
  }

}
