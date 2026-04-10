package ec.com.sidesoft.workorder.simplified.ad_process;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.idl.proc.Parameter;
import org.openbravo.idl.proc.Validator;
import org.openbravo.idl.proc.Value;
import org.openbravo.module.idljava.proc.IdlServiceJava;

import com.atrums.indumot.supervision.data.indsupConsol;
import com.atrums.indumot.supervision.data.oindsuprg;
import com.atrums.indumoto.postventa.data.atindpo_postventa;

/**
 *
 * @author RARC
 */
public class ImportOrderConsolidation extends IdlServiceJava {

  // private static Logger log = Logger.getLogger(ImportOrderConsolidation.class);

  @Override
  public String getEntityName() {
    return "Vehicles";
  }

  @Override
  public Parameter[] getParameters() {
    return new Parameter[] { new Parameter("No. Orden", Parameter.STRING),
        new Parameter("Organización", Parameter.STRING), new Parameter("Orden", Parameter.STRING) };
  }

  @Override
  protected Object[] validateProcess(Validator validator, String... values) throws Exception {

    /********************** VALIDACIÓN PARA Numero Orden de Servicio[0] ************************/
    validator.checkNotNull(values[0], "No. Orden");
    atindpo_postventa OBjatindpo_postventa = findDALInstance(false, atindpo_postventa.class,
        new Value(atindpo_postventa.PROPERTY_DOCUMENTNO, values[0]),
        new Value(atindpo_postventa.PROPERTY_INDSUPISCONSOL, true));

    if (OBjatindpo_postventa == null || OBjatindpo_postventa.equals("")
        || OBjatindpo_postventa.getIndsupEstConsol().equals("GE")) {
      System.out.println(
          "No existe un registro sin procesar en la ventana de Ordene de servicio (Consolidación) con el número de documento: "
              + values[0]);
      validator.checkNotNull(null, "No. Orden");
    }

    /********************** VALIDACIÓN PARA Numero Orden de Servicio[0] ************************/

    /********************** VALIDACIÓN PARA Organizacion[1] ************************/
    validator.checkNotNull(values[1], "No. Orden");
    oindsuprg OBjoindsuprg = findDALInstance(false, oindsuprg.class,
        new Value(oindsuprg.PROPERTY_CODIGO, values[1]));
    if (OBjoindsuprg == null || OBjoindsuprg.equals("")) {
      OBjoindsuprg = findDALInstance(false, oindsuprg.class,
          new Value(oindsuprg.PROPERTY_NOMBRE, values[1]));
      if (OBjoindsuprg == null || OBjoindsuprg.equals("")) {
        System.out.println(
            "No existe en la ventana Organizacion Ordenes de servicio un registro con el codigo o con el nombre : "
                + values[1]);
        validator.checkNotNull(null, "Organización");
      }
    }
    /********************** VALIDACIÓN PARA Organizacion[1] ************************/
    /********************** VALIDACIÓN PARA ORDEN SERIVIO[2] ************************/
    validator.checkNotNull(values[2], "Orden");
    validator.checkString(values[2], 30, "Orden");
    /********************** FIN VALIDACIÓN PARA ORDEN SERIVIO[2] ************************/
    return values;
  }

  @Override
  public BaseOBObject internalProcess(Object... values) throws Exception {
    return create((String) values[0], (String) values[1], (String) values[2]);
  }

  public BaseOBObject create(final String NumOrden, final String Organizacion, final String Orden)
      throws Exception {

    indsupConsol ObjindsupConsol = null;
    atindpo_postventa OBjatindpo_postventa = null;
    oindsuprg Objoindsuprg = null;
    Boolean isValidado = false;

    OBjatindpo_postventa = findDALInstance(false, atindpo_postventa.class,
        new Value(atindpo_postventa.PROPERTY_DOCUMENTNO, NumOrden),
        new Value(atindpo_postventa.PROPERTY_INDSUPISCONSOL, true));
    if (OBjatindpo_postventa == null || OBjatindpo_postventa.equals("")
        || OBjatindpo_postventa.getIndsupEstConsol().equals("GE")) {
      throw new OBException(
          "No existe un registro  sin procesar en la ventana de Ordene de servicio (Consolidación) con el número de documento: "
              + NumOrden);
    }

    Objoindsuprg = findDALInstance(false, oindsuprg.class,
        new Value(oindsuprg.PROPERTY_CODIGO, Organizacion));
    if (Objoindsuprg == null || Objoindsuprg.equals("")) {
      Objoindsuprg = findDALInstance(false, oindsuprg.class,
          new Value(oindsuprg.PROPERTY_NOMBRE, Organizacion));
      if (Objoindsuprg == null || Objoindsuprg.equals("")) {
        throw new OBException(
            "No existe en la ventana 'Organizacion Ordenes de servicio' un registro con el código o con el nombre : "
                + Organizacion);
      }
    }

    try {
      ObjindsupConsol = OBProvider.getInstance().get(indsupConsol.class);
      ObjindsupConsol.setOrganizacion(Objoindsuprg);
      ObjindsupConsol.setAtindpoPostventa(OBjatindpo_postventa);
      ObjindsupConsol.setOrden(Orden);
      ObjindsupConsol.setValidado(isValidado);

      OBDal.getInstance().save(ObjindsupConsol);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      throw new OBException(Utility.messageBD(conn, e.getMessage(), vars.getLanguage()));
    }

    // End process
    OBDal.getInstance().commitAndClose();

    return ObjindsupConsol;
  }
}