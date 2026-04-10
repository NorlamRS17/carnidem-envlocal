package ec.com.sidesoft.email.utils;

import java.util.Calendar;
import java.util.Date;

import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.model.common.enterprise.Organization;

public class CalendarHelper {

  /**
   * Determina si una fecha es laborable para una organización específica respetando la herencia del
   * árbol de organizaciones.
   */
  public static boolean isBusinessDay(Organization org, Date dateToCheck) {
    Calendar calendar = getInheritedCalendar(org);

    if (calendar == null) {
      // Fallback: Si no hay calendario, asumimos
      // Sábados y Domingos como NO laborables por defecto.
      Calendar cal = Calendar.getInstance();
      cal.setTime(dateToCheck);
      int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
      return (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY);
    }

    // 2. Chequear fines de semana standard definidos en el calendario (si aplica lógica custom)
    // Por defecto Openbravo usa NonBusinessDay para todo, pero a veces se valida fin de semana
    // estándar.
    Calendar cal = Calendar.getInstance();
    cal.setTime(dateToCheck);
    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    // Asumimos Sab/Dom como no laborables a menos que se defina lo contrario en tu lógica de
    // negocio
    return (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY);
  }

  private static Calendar getInheritedCalendar(Organization org) {
    Organization currentOrg = org;
    while (currentOrg != null) {
      // Subir al padre
      currentOrg = new OrganizationStructureProvider().getParentOrg(currentOrg);
    }
    return null; // No se encontró calendario en la rama
  }

}
