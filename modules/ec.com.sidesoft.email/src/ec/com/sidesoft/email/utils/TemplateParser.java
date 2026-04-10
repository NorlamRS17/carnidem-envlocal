package ec.com.sidesoft.email.utils;

import java.util.Date;

import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.DalUtil;
import org.openbravo.erpCommon.utility.OBDateUtils;

import ec.com.sidesoft.email.AemEmailQueue;
import ec.com.sidesoft.email.AemTemplate;
import ec.com.sidesoft.email.AemTemplateVariable;

public class TemplateParser {

  public static String parse(AemTemplate template, AemEmailQueue que, BaseOBObject targetObject) {
    if (template == null || targetObject == null)
      return "";
    String body = template.getBodyContent();
    // Iterar sobre los parámetros configurados (Las líneas de tu config)
    for (AemTemplateVariable param : que.getAemTemplateVariableList()) {
      String tag = param.getVariableName(); // ej: @fechafactura@
      // Column targetColumn = param.getColumn(); // La columna AD_Column seleccionada

      Object value = targetObject.get(param.getPropertyName());
      String valueStr = "";

      if (value != null) {
        if (value instanceof BaseOBObject) {
          // Si es una FK (ej: Tercero), obtenemos el Identificador, no el ID
          valueStr = ((BaseOBObject) value).getIdentifier();
        } else if (value instanceof Date) {
          // Aquí puedes formatear la fecha según preferencias
          valueStr = OBDateUtils.formatDate((Date) value, "dd-MM-YYYY");
        } else {
          valueStr = value.toString();
        }
      }

      // 5. Reemplazar en el texto
      body = body.replace(tag, valueStr);
      // subject = subject.replace(tag, valueStr);
    }

    return body;
  }

  public static String getParamsEntityMail(String PropertyName, BaseOBObject targetObject) {

    Object value = DalUtil.getValueFromPath(targetObject, PropertyName);

    return (String) value;
  }

}
