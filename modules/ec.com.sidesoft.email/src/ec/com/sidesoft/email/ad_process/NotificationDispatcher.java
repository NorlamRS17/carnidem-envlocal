package ec.com.sidesoft.email.ad_process;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.email.AemEmailQueue;
import ec.com.sidesoft.email.utils.CalendarHelper;

public class NotificationDispatcher extends DalBaseProcess {

  private static final Logger log = LoggerFactory.getLogger(NotificationDispatcher.class);

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    try {
      // 1. Recuperar reglas activas que NO se han ejecutado hoy
      List<AemEmailQueue> schedules = getPendingSchedules();

      int emailsSent = 0;

      for (AemEmailQueue schedule : schedules) {
        // Hacemos un try-catch DENTRO del loop para aislar fallos
        try {
          if (shouldExecuteNow(schedule)) {
            // sendEmail(schedule);

            // Actualizar registro
            schedule.setLastrundate(new Date());
            OBDal.getInstance().save(schedule);

            // Commit parcial o flush para asegurar que si el siguiente falla, este ya quedó marcado
            OBDal.getInstance().flush();
            emailsSent++;
          }
        } catch (Exception e) {
          // log.error("Error procesando regla: " + schedule.getName(), e);
          // Opcional: Marcar un campo "LastError" en el registro
          OBDal.getInstance().rollbackAndClose(); // Rollback solo de esta transacción si usas
          // transacciones
          // manuales,
          // pero en DalBaseProcess todo es una gran transacción.
          // TRUCO SENIOR: Para evitar rollback total, usa una nueva
          // transacción o session si es muy crítico,
          // o simplemente loggea y deja que el commit final ocurra
          // para los exitosos.
        }
      }

      // bundle.setResult(new OBError("Success", "OK", "Procesadas: "));

    } catch (Exception e) {
      throw e;
    }
  }

  private boolean shouldExecuteNow(AemEmailQueue schedule) {
    Calendar now = Calendar.getInstance();

    // 1. Chequeo de Hora (Parsing HH:mm)
    // String[] timeParts = schedule.getScheduleProcess().split(":");
    String[] timeParts = null;
    int targetHour = Integer.parseInt(timeParts[0]);
    int targetMin = Integer.parseInt(timeParts[1]);

    int currentHour = now.get(Calendar.HOUR_OF_DAY);
    int currentMin = now.get(Calendar.MINUTE);

    // Tolerancia simple: Misma hora, y diferencia de minutos < 15 (asumiendo cron cada 15m)
    if (targetHour != currentHour || Math.abs(currentMin - targetMin) > 15) {
      return false;
    }

    // 2. Chequeo Día Semana
    // Implementar parseo de schedule.getDaysOfWeek() ("MON,WED") vs now.get(DAY_OF_WEEK)

    // 3. Chequeo Día Laborable
    if (schedule.isWorkingday()) {
      if (!CalendarHelper.isBusinessDay(schedule.getOrganization(), now.getTime())) {
        return false;
      }
    }

    return true;
  }

  private List<AemEmailQueue> getPendingSchedules() {
    String lastRunDate = AemEmailQueue.PROPERTY_LASTRUNDATE;
    final String hqlString = " where active = true " + "and (" + lastRunDate + " is null or "
        + lastRunDate + " < :today)";
    OBQuery<AemEmailQueue> query = OBDal.getInstance().createQuery(AemEmailQueue.class,
        hqlString.toString());

    query.setNamedParameter("today", new Date());
    return query.list();
  }
}
