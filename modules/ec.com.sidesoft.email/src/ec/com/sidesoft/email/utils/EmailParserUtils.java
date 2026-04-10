package ec.com.sidesoft.email.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.BaseOBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.email.AemTemplate;
import ec.com.sidesoft.email.AemTemplateVariable;

public class EmailParserUtils {

  private static final Logger log = LoggerFactory.getLogger(EmailParserUtils.class);

  // Tus marcadores solicitados
  private static final String LOOP_START = "[line]";
  private static final String LOOP_END = "[/line]";
  private static final String PLACEHOLDER = "###LOOP_SECTION_PLACEHOLDER###";

  /**
   * Método principal ROBUSTO para agrupación.
   */
  public static String parseWithGroup(String content, AemTemplate template,
      BaseOBObject headerObject, List<BaseOBObject> groupList) {
    if (content == null || content.isEmpty())
      return "";

    // PASO 1: Proteger la sección del loop para que el parseo de cabecera no la dañe.
    String loopTemplate = "";
    String contentProtected = content;
    boolean hasLoop = content.contains(LOOP_START) && content.contains(LOOP_END);

    if (hasLoop) {
      int start = content.indexOf(LOOP_START);
      int end = content.indexOf(LOOP_END) + LOOP_END.length();

      if (start < end) {
        // Extraemos todo el bloque [line]...[/line]
        String fullLoopBlock = content.substring(start, end);
        // Extraemos solo el interior para usarlo de plantilla luego
        loopTemplate = content.substring(start + LOOP_START.length(), content.indexOf(LOOP_END));

        // Reemplazamos el bloque entero por un marcador temporal
        contentProtected = content.replace(fullLoopBlock, PLACEHOLDER);
      }
    }

    // PASO 2: Procesar variables de Cabecera (Header) sobre el contenido protegido
    // Aquí @Cliente@ se reemplaza, pero [doc] (que está guardado en loopTemplate) NO se toca.
    String processedHeader = parse(contentProtected, template, headerObject);

    // Si no había loop o lista, devolvemos el header procesado (quitando el placeholder si quedó)
    if (!hasLoop || groupList == null || groupList.isEmpty()) {
      return processedHeader.replace(PLACEHOLDER, "");
    }

    // PASO 3: Generar las filas repetitivas
    StringBuilder rowsBuilder = new StringBuilder();
    for (BaseOBObject rowObj : groupList) {
      // Parseamos la plantilla de fila con el objeto específico de esa fila
      rowsBuilder.append(parseRow(loopTemplate, template, rowObj));
    }

    // PASO 4: Reinsertar las filas en el lugar del placeholder
    return processedHeader.replace(PLACEHOLDER, rowsBuilder.toString());
  }

  // Se mantiene igual, pero es crucial para el funcionamiento interno
  private static String parseRow(String rawRow, AemTemplate template, BaseOBObject rowData) {
    String current = rawRow;
    List<AemTemplateVariable> variablesConfig = template.getAemTemplateVariableList();

    for (AemTemplateVariable varConfig : variablesConfig) {
      String token = varConfig.getVariableName(); // ej: [doc]
      String mapping = varConfig.getPropertyName(); // ej: documentNo

      if (token != null && mapping != null) {
        // Optimización: Solo intentamos resolver si el token existe en la fila actual
        if (current.contains(token)) {
          String val = resolveProperty(rowData, mapping.trim());
          if (val != null) {
            current = current.replace(token, val);
          }
        }
      }
    }
    return current;
  }

  public static String parse(String content, AemTemplate template, BaseOBObject dataObject) {
    if (content == null || content.isEmpty())
      return "";
    if (template == null)
      return content;

    List<AemTemplateVariable> variablesConfig = template.getAemTemplateVariableList();
    if (variablesConfig == null || variablesConfig.isEmpty())
      return content;

    String processedContent = content;

    for (AemTemplateVariable varConfig : variablesConfig) {
      String token = varConfig.getVariableName();
      String mapping = varConfig.getPropertyName();

      if (token != null && mapping != null && !mapping.trim().isEmpty()) {
        // Optimización: check contains antes de resolver (ahorra queries DAL innecesarias)
        if (processedContent.contains(token)) {
          String realValue = resolveProperty(dataObject, mapping.trim());
          if (realValue != null) {
            processedContent = processedContent.replace(token, realValue);
          }
        }
      }
    }
    return processedContent;
  }

  public static Object resolvePropertyObject(BaseOBObject object, String propertyPath) {
    if (object == null)
      return null;
    try {
      // Soporte para propiedades directas "documentNo" o complejas "businessPartner.name"
      String[] parts = propertyPath.split("\\.");
      BaseOBObject currentObj = object;
      Object finalValue = null;

      for (int i = 0; i < parts.length; i++) {
        String prop = parts[i];
        if (currentObj == null)
          return null;

        // Validación de seguridad de entidad
        if (!currentObj.getEntity().hasProperty(prop))
          return null;

        if (i == parts.length - 1) {
          finalValue = currentObj.get(prop);
        } else {
          Object nextObj = currentObj.get(prop);
          if (nextObj instanceof BaseOBObject) {
            currentObj = (BaseOBObject) nextObj;
          } else {
            return null;
          }
        }
      }
      return finalValue;
    } catch (Exception e) {
      log.error("Error resolviendo path: " + propertyPath, e);
      return null;
    }
  }

  private static String resolveProperty(BaseOBObject object, String propertyPath) {
    try {
      Object val = resolvePropertyObject(object, propertyPath);
      return formatValue(val);
    } catch (Exception e) {
      return "";
    }
  }

  private static String formatValue(Object value) {
    if (value == null)
      return "";
    if (value instanceof Date) {
      return new SimpleDateFormat("dd/MM/yyyy").format((Date) value);
    }
    if (value instanceof Boolean) {
      return ((Boolean) value) ? "Sí" : "No";
    }
    if (value instanceof BaseOBObject) {
      return ((BaseOBObject) value).getIdentifier();
    }
    return value.toString();
  }
}