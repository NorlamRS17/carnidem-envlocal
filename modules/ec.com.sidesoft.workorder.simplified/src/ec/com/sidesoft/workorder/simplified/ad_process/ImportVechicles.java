package ec.com.sidesoft.workorder.simplified.ad_process;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.model.ad.domain.ListTrl;
import org.openbravo.model.ad.domain.Reference;
import org.openbravo.model.ad.system.Language;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Brand;
import org.openbravo.module.idljava.proc.IdlServiceJava;

import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;

import ec.com.sidesoft.workorder.simplified.SswosColor;
import ec.com.sidesoft.workorder.simplified.SswosVehicle;
import ec.com.sidesoft.workorder.simplified.SswosYear;

/**
 *
 * @author RARC
 */
public class ImportVechicles extends IdlServiceJava {

  // private static Logger log = Logger.getLogger(ImportVechicles.class);

  @Override
  public String getEntityName() {
    return "Vehicles";
  }

  @Override
  public Parameter[] getParameters() {
    return new Parameter[] { new Parameter("Linea", Parameter.STRING),
        new Parameter("Tipo Vehículo", Parameter.STRING), new Parameter("Marca", Parameter.STRING),
        new Parameter("Modelo", Parameter.STRING), new Parameter("Año", Parameter.STRING),
        new Parameter("No. Motor", Parameter.STRING), new Parameter("No. Chasis", Parameter.STRING),
        new Parameter("Placa", Parameter.STRING), new Parameter("Color", Parameter.STRING),
        new Parameter("Km / Horas", Parameter.STRING),
        new Parameter("Fecha venta", Parameter.STRING),
        new Parameter("Local Venta", Parameter.STRING),
        new Parameter("Tercero", Parameter.STRING) };
  }

  @Override
  protected Object[] validateProcess(Validator validator, String... values) throws Exception {
    // Variables

    validator.checkLong(values[0]);// Linea
    /********************** VALIDACIÓN PARA Tipo de Vehiculo[1] ************************/
    validator.checkString(values[1], 200, "Tipo de vehículo");// Tipo Vehículo

    if (!(values[1] == null || values[1].equals(""))) {
      String LstTipoVehiculo = null;
      String LstTiposVehiculos = "";

      // ReFERENCIA
      final OBCriteria<Reference> statRef = OBDal.getInstance().createCriteria(Reference.class);
      statRef.add(Restrictions.eq(Reference.PROPERTY_NAME, "Tipo Vehículo"));
      // LENGUAJE
      Language language = findDALInstance(false, Language.class,
          new Value(Language.PROPERTY_LANGUAGE, "es_ES"));
      OBCriteria<ListTrl> refListTrl;

      // LISTA
      final OBCriteria<org.openbravo.model.ad.domain.List> statRefList = OBDal.getInstance()
          .createCriteria(org.openbravo.model.ad.domain.List.class);
      statRefList.add(Restrictions.eq(org.openbravo.model.ad.domain.List.PROPERTY_REFERENCE,
          statRef.list().get(0)));
      statRefList.addOrderBy(org.openbravo.model.ad.domain.List.PROPERTY_SEQUENCENUMBER, true);

      for (org.openbravo.model.ad.domain.List l : statRefList.list()) {
        refListTrl = OBDal.getInstance().createCriteria(ListTrl.class);
        refListTrl.add(Restrictions.eq(ListTrl.PROPERTY_LISTREFERENCE, l));
        refListTrl.add(Restrictions.eq(ListTrl.PROPERTY_LANGUAGE, language));
        LstTiposVehiculos += ", " + refListTrl.list().get(0).getName();
        if (refListTrl.list().get(0).getName().equals(values[1])) {
          LstTipoVehiculo = l.getSearchKey();
        }
      }

      if (LstTipoVehiculo == null) {
        System.out.println("Tipo de vehículo no encontrado: " + values[1]
            + "\n Valores permitidos: " + LstTiposVehiculos);
        validator.checkNotNull(null, "Tipo de vehículo");
      }
    }
    /******************** FIN - VALIDACIÓN PARA Tipo de Vehiculo[1] ********************/

    validator.checkString(values[2], 200, "Marca");
    /************************ VALIDACIÓN PARA Modelo[3] ***********************/
    validator.checkString(values[3], 200, "Modelo");
    if (!(values[3] == null || values[3].equals(""))) {
      if (values[2] == null || values[2].equals("")) {
        System.out.println("No se puede crear Modelo sin una marca relacionada: " + values[3]);
        validator.checkNotNull(null, "Modelo");
      }
    }
    /******************** FIN - VALIDACIÓN PARA Modelo[3] ********************/
    validator.checkString(values[4], 200, "Año");
    validator.checkString(values[5], 40, "No. Motor");
    validator.checkString(values[6], 40, "No. Chasis");
    validator.checkString(values[7], 10, "Placa");
    validator.checkString(values[8], 200, "Color");
    validator.checkLong(values[9], "Km / Horas");
    validator.checkDate(values[10], "Fecha venta");
    /******************** VALIDACIÓN PARA LOCAL VENTA(Organización)[11] ********************/
    validator.checkString(values[11], 200, "Local Venta");
    if (!(values[11] == null || values[11].equals(""))) {
      OBCriteria<Organization> ObjOrganizationLst = OBDal.getInstance()
          .createCriteria(Organization.class);
      ObjOrganizationLst.add(Restrictions.eq(Organization.PROPERTY_NAME, values[11]));
      Organization ObjOrganization = null;

      if (ObjOrganizationLst.count() != 0) {
        ObjOrganization = ObjOrganizationLst.list().get(0);
        if (ObjOrganization == null || ObjOrganization.equals("")) {
          System.out.println("Nombre de local venta no encontrado: " + values[11]);
          validator.checkNotNull(null, "Local Venta");
        }
      }
    }
    /******************** FIN - VALIDACIÓN PARA LOCAL VENTA(Organización)[11] ***************/
    /**************************** VALIDACIÓN PARA Tercero[12] *******************************/
    validator.checkString(values[12], 200, "Tercero");
    if (!(values[12] == null || values[12].equals(""))) {
      BusinessPartner ObjBPartner = findDALInstance(false, BusinessPartner.class,
          new Value(BusinessPartner.PROPERTY_TAXID, values[12]));
      if (ObjBPartner == null || ObjBPartner.equals("")) {
        System.out.println("No se encontró un tercero con el identificador: " + values[12] + ".");
        validator.checkNotNull(null, "Tercero");
      }
    }
    /**************************** VALIDACIÓN PARA Tercero[12] *******************************/
    return values;
  }

  @Override
  public BaseOBObject internalProcess(Object... values) throws Exception {
    return create((String) values[0], (String) values[1], (String) values[2], (String) values[3],
        (String) values[4], (String) values[5], (String) values[6], (String) values[7],
        (String) values[8], (String) values[9], (String) values[10], (String) values[11],
        (String) values[12]);
  }

  public BaseOBObject create(final String Linea, final String TipoVehiculo, final String Marca,
      final String Modelo, final String anio, final String NumMotor, final String NumChasis,
      final String Placa, final String Color, final String Km_Horas, final String FechaVenta,
      final String LocalVenta, final String Tercero) throws Exception {

    String LstTipoVehiculo = null;
    SswosVehicle ObjSswosVehicle = null;
    String LstTiposVehiculos = "";
    Brand ObjBrandNew = null;
    SsfiModelProduct ObjSsfiModelProductNew = null;
    SswosYear ObjSswosYearNew = null;
    SswosColor ObjSswosColorNew = null;

    if (!(TipoVehiculo == null || TipoVehiculo.equals(""))) {
      // ReFERENCIA
      final OBCriteria<Reference> statRef = OBDal.getInstance().createCriteria(Reference.class);
      statRef.add(Restrictions.eq(Reference.PROPERTY_NAME, "Tipo Vehículo"));
      // LENGUAJE
      Language language = findDALInstance(false, Language.class,
          new Value(Language.PROPERTY_LANGUAGE, "es_ES"));
      OBCriteria<ListTrl> refListTrl;

      // LISTA
      final OBCriteria<org.openbravo.model.ad.domain.List> statRefList = OBDal.getInstance()
          .createCriteria(org.openbravo.model.ad.domain.List.class);
      statRefList.add(Restrictions.eq(org.openbravo.model.ad.domain.List.PROPERTY_REFERENCE,
          statRef.list().get(0)));
      statRefList.addOrderBy(org.openbravo.model.ad.domain.List.PROPERTY_SEQUENCENUMBER, true);

      for (org.openbravo.model.ad.domain.List l : statRefList.list()) {
        refListTrl = OBDal.getInstance().createCriteria(ListTrl.class);
        refListTrl.add(Restrictions.eq(ListTrl.PROPERTY_LISTREFERENCE, l));
        refListTrl.add(Restrictions.eq(ListTrl.PROPERTY_LANGUAGE, language));

        LstTiposVehiculos += ", " + refListTrl.list().get(0).getName();
        if (refListTrl.list().get(0).getName().equals(TipoVehiculo)) {
          LstTipoVehiculo = l.getSearchKey();
        }
      }

      if (LstTipoVehiculo == null) {
        throw new OBException("Tipo de vehículo no encontrado: " + TipoVehiculo
            + "\n Valores permitidos: " + LstTiposVehiculos + ".");
      }
    }

    BusinessPartner ObjBPartner = findDALInstance(false, BusinessPartner.class,
        new Value(BusinessPartner.PROPERTY_TAXID, Tercero));
    if (ObjBPartner == null || ObjBPartner.equals("")) {
      if (!(Tercero == null || Tercero.equals(""))) {
        throw new OBException("No se encontró un tercero con el identificador: " + Tercero + ".");
      }
    }
    OBCriteria<Organization> ObjOrganizationLst = OBDal.getInstance()
        .createCriteria(Organization.class);
    ObjOrganizationLst.add(Restrictions.eq(Organization.PROPERTY_NAME, LocalVenta));
    Organization ObjOrganization = null;
    if (ObjOrganizationLst.count() != 0) {
      ObjOrganization = ObjOrganizationLst.list().get(0);
      if (ObjOrganization == null || ObjOrganization.equals("")) {
        if (!(LocalVenta == null || LocalVenta.equals(""))) {
          throw new OBException(
              "No se encontro una organización con el nombre: " + LocalVenta + ".");
        }
      }
    }

    Brand ObjBrand = findDALInstance(false, Brand.class, new Value(Brand.PROPERTY_NAME, Marca));
    if (ObjBrand == null || ObjBrand.equals("")) {
      if (!(Marca == null || Marca.equals(""))) {
        ObjBrandNew = OBProvider.getInstance().get(Brand.class);
        ObjBrandNew.setName(Marca);
        ObjBrandNew.setDescription(Marca);
        OBDal.getInstance().save(ObjBrandNew);
        OBDal.getInstance().flush();
        ObjBrand = ObjBrandNew;
      }
    }

    SsfiModelProduct ObjSsfiModelProduct = findDALInstance(false, SsfiModelProduct.class,
        new Value(SsfiModelProduct.PROPERTY_NAME, Modelo));
    if (ObjSsfiModelProduct == null || ObjSsfiModelProduct.equals("")) {
      if (!(Modelo == null || Modelo.equals(""))) {
        if (!(ObjBrand == null || ObjBrand.equals(""))) {
          ObjSsfiModelProductNew = OBProvider.getInstance().get(SsfiModelProduct.class);
          ObjSsfiModelProductNew.setBrand(ObjBrand);
          ObjSsfiModelProductNew.setName(Modelo);
          //ObjSsfiModelProductNew.setValue(Modelo);
          OBDal.getInstance().save(ObjSsfiModelProductNew);
          OBDal.getInstance().flush();

          ObjSsfiModelProduct = ObjSsfiModelProductNew;
        } else {
          throw new OBException("No se puede crear el modelo sin marca: " + Modelo);
        }
      }
    }

    SswosYear ObjSswosYear = findDALInstance(false, SswosYear.class,
        new Value(SswosYear.PROPERTY_NAME, anio));
    if (ObjSswosYear == null || ObjSswosYear.equals("")) {
      if (!(anio == null || anio.equals(""))) {
        ObjSswosYearNew = OBProvider.getInstance().get(SswosYear.class);
        ObjSswosYearNew.setName(anio);
        ObjSswosYearNew.setDescription(anio);
        OBDal.getInstance().save(ObjSswosYearNew);
        OBDal.getInstance().flush();
        ObjSswosYear = ObjSswosYearNew;
      }
    }

    SswosColor ObjSswosColor = findDALInstance(false, SswosColor.class,
        new Value(SswosColor.PROPERTY_NAME, Color));
    if (ObjSswosColor == null || ObjSswosColor.equals("")) {
      if (!(Color == null || Color.equals(""))) {
        ObjSswosColorNew = OBProvider.getInstance().get(SswosColor.class);
        ObjSswosColorNew.setName(Color);
        ObjSswosColorNew.setDescription(Color);
        OBDal.getInstance().save(ObjSswosColorNew);
        OBDal.getInstance().flush();

        ObjSswosColor = ObjSswosColorNew;
      }
    }

    SswosVehicle ObjSswosVehicleLst = findDALInstance(false, SswosVehicle.class,
        new Value(SswosVehicle.PROPERTY_PLATE, Placa),
        new Value(SswosVehicle.PROPERTY_CHASSISNUMBER, NumChasis));
    if (!(ObjSswosVehicleLst == null || ObjSswosVehicleLst.equals(""))) {
      ObjSswosVehicle = ObjSswosVehicleLst;
    } else {
      ObjSswosVehicle = OBProvider.getInstance().get(SswosVehicle.class);
    }
    // Create Vehicle
    try {
      ObjSswosVehicle.setVehicleType(LstTipoVehiculo);
      ObjSswosVehicle.setBrand(ObjBrand);
      ObjSswosVehicle.setModel(ObjSsfiModelProduct);
      ObjSswosVehicle.setSswosYear(ObjSswosYear);
      ObjSswosVehicle.setEngineNumber(NumMotor);
      ObjSswosVehicle.setChassisNumber(NumChasis);
      ObjSswosVehicle.setPlate(Placa);
      ObjSswosVehicle.setSswosColor(ObjSswosColor);
      ObjSswosVehicle
          .setKilometerHours((Km_Horas == null || Km_Horas.equals("")) ? null : new Long(Km_Horas));
      ObjSswosVehicle.setSaleDate(Parameter.DATE.parse(FechaVenta));
      ObjSswosVehicle.setOrgSale(ObjOrganization);
      ObjSswosVehicle.setProvider(ObjBPartner);

      OBDal.getInstance().save(ObjSswosVehicle);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      throw new OBException(Utility.messageBD(conn, e.getMessage(), vars.getLanguage()));
    }

    // End process
    OBDal.getInstance().commitAndClose();

    return ObjSswosVehicle;
  }
}
