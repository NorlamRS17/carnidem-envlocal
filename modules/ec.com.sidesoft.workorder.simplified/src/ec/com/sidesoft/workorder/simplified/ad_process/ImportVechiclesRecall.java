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
import org.openbravo.model.common.plm.Brand;
import org.openbravo.module.idljava.proc.IdlServiceJava;

import com.sidesoft.localization.ecuador.finances.SsfiModelProduct;

import ec.com.sidesoft.workorder.simplified.SswosVehicleRecall;
import ec.com.sidesoft.workorder.simplified.SswosYear;

/**
 *
 * @author RARC
 */
public class ImportVechiclesRecall extends IdlServiceJava {

  // private static Logger log = Logger.getLogger(ImportVechiclesRecall.class);

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
        new Parameter("Recall Realizado", Parameter.STRING) };
  }

  @Override
  protected Object[] validateProcess(Validator validator, String... values) throws Exception {
    // Variables

    validator.checkLong(values[0], "Linea");// Linea
    /********************** VALIDACIÓN PARA Tipo de Vehiculo[1] ************************/
    validator.checkString(values[1], 200, "Tipo Vehículo");// MARCA

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
        System.out.println("Tipo de vehpiculo no encontrado: " + values[1]
            + "\n Valores permitidos: " + LstTiposVehiculos);
        validator.checkNotNull(null, "Tipo de vehículo");
      }
    }
    /******************** FIN - VALIDACIÓN PARA Tipo de Vehiculo[1] ********************/

    validator.checkString(values[2], 200, "Marca");
    /************************ VALIDACIÓN PARA Modelo [3] ***********************/
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
    validator.checkBoolean(values[7], "Recall Realizado");
    return values;
  }

  @Override
  public BaseOBObject internalProcess(Object... values) throws Exception {
    return create((String) values[0], (String) values[1], (String) values[2], (String) values[3],
        (String) values[4], (String) values[5], (String) values[6], (String) values[7]);
  }

  public BaseOBObject create(final String Linea, final String TipoVehiculo, final String Marca,
      final String Modelo, final String anio, final String NumMotor, final String NumChasis,
      final String RecallRealizado) throws Exception {
    String LstTipoVehiculo = null;
    SswosVehicleRecall ObjSswosVehicle = null;
    String LstTiposVehiculos = "";
    Brand ObjBrandNew = null;
    SsfiModelProduct ObjSsfiModelProductNew = null;
    SswosYear ObjSswosYearNew = null;
    Boolean isRecallRealizado = RecallRealizado == null || RecallRealizado.equals("")
        || RecallRealizado.toUpperCase().equals("FALSE") ? false : true;

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
        throw new OBException("Tipo de vehpiculo no encontrado: " + TipoVehiculo
            + "\n Valores permitidos: " + LstTiposVehiculos + ".");
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

    SswosVehicleRecall ObjSswosVehicleLst = findDALInstance(false, SswosVehicleRecall.class,
        new Value(SswosVehicleRecall.PROPERTY_CHASSISNUMBER, NumChasis));
    if (!(ObjSswosVehicleLst == null || ObjSswosVehicleLst.equals(""))) {
      ObjSswosVehicle = ObjSswosVehicleLst;
    } else {
      ObjSswosVehicle = OBProvider.getInstance().get(SswosVehicleRecall.class);
    }
    // Create Vehicle
    try {
      ObjSswosVehicle.setVehicleType(LstTipoVehiculo);
      ObjSswosVehicle.setBrand(ObjBrand);
      ObjSswosVehicle.setModel(ObjSsfiModelProduct);
      ObjSswosVehicle.setYear(ObjSswosYear);
      ObjSswosVehicle.setEngineNumber(NumMotor);
      ObjSswosVehicle.setChassisNumber(NumChasis);
      ObjSswosVehicle.setRecalldone(isRecallRealizado);

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
