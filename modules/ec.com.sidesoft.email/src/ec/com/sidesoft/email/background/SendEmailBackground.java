package ec.com.sidesoft.email.background;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.scheduling.KillableProcess;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.email.AemEmailQueue;
import ec.com.sidesoft.email.AemNotificationLog;
import ec.com.sidesoft.email.AemSmtpConfig;
import ec.com.sidesoft.email.utils.EmailConnectionUtils;
import ec.com.sidesoft.email.utils.EmailParserUtils;
import ec.com.sidesoft.email.utils.TemplateParser;

public class SendEmailBackground extends DalBaseProcess implements KillableProcess {
  private static final Logger log = LoggerFactory.getLogger(SendEmailBackground.class);
  private boolean killProcess = false;

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    OBCriteria<AemEmailQueue> criteria = OBDal.getInstance().createCriteria(AemEmailQueue.class);
    criteria.add(Restrictions.eq("alertStatus", "CO"));

    List<AemEmailQueue> queueList = criteria.list();

    for (AemEmailQueue mail : queueList) {
      try {
        AemSmtpConfig config = mail.getSMTPConfiguration();

        if (config == null || !config.isActive()) {
          throw new Exception("Configuración SMTP inactiva o no encontrada");
        }
        processAlert(mail);

        // mail.setAlertStatus("SENT");
        // mail.setSentDate(new Date());

      } catch (Exception e) {
        // mail.setAlertStatus("ERROR");
        mail.setErrorMsg(e.getMessage());
        mail.setAttempts(mail.getAttempts() + 1);
      }
      OBDal.getInstance().save(mail);
    }
    OBDal.getInstance().flush();
  }

  private void processAlert(AemEmailQueue config) {
    Table table = config.getTab().getTable();
    // String entityName = table.ENTITY_NAME;
    String hqlWhere = config.getAemConditionList().isEmpty() ? ""
        : config.getAemConditionList().get(0).getSQLCondition();
    String dbTableName = table.getDBTableName();
    Boolean result = false;
    // 4. Usa el ModelProvider para resolver la Entidad DAL correcta
    Entity entity = ModelProvider.getInstance().getEntityByTableName(dbTableName);

    // 5. Validar que exista (por seguridad)
    if (entity == null) {
      throw new OBException("No se encontró una entidad DAL para la tabla: " + dbTableName);
    }

    String entityName = entity.getName();
    // 1. Preparar las constantes para limpieza visual
    final String LOG_ENTITY = AemNotificationLog.ENTITY_NAME;
    final String PROP_RECORD_ID = AemNotificationLog.PROPERTY_RECORDID;
    final String PROP_QUEUE = AemNotificationLog.PROPERTY_AEMEMAILQUEUE;

    // 2. Construir el HQL usando StringBuilder
    StringBuilder whereClause = new StringBuilder();

    // Truco de Openbravo: Definimos un alias 'e' para la entidad principal
    // Esto permite correlacionar inequívocamente: log.recordID = e.id
    whereClause.append(" as e where ");

    // Agregar filtro previo si existe
    if (StringUtils.isNotBlank(hqlWhere)) {
      whereClause.append("(").append(hqlWhere).append(") AND ");
    }

    // 3. Agregar la cláusula NOT EXISTS (Mucho más performante que NOT IN)
    whereClause.append(" not exists (");
    whereClause.append("    select 1 from ").append(LOG_ENTITY).append(" log");
    whereClause.append("    where log.").append(PROP_RECORD_ID).append(" = e.id"); // Correlación
    whereClause.append("    and log.").append(PROP_QUEUE).append(".id = :configId");
    whereClause.append(" )");

    // 4. Crear y ejecutar la query
    OBQuery<BaseOBObject> query = OBDal.getInstance().createQuery(entityName,
        whereClause.toString());
    query.setNamedParameter("configId", config.getId());
    query.setFilterOnReadableClients(false);
    query.setFilterOnReadableOrganization(false);
    // query.setMaxResult(3);

    List<BaseOBObject> results = query.list();
    String groupingProperty = config.getGroupby(); // Ca
    // 3. Lógica de bifurcación: Agrupado vs Individual
    if (StringUtils.isNotBlank(groupingProperty)) {
      processGroupedRecords(config, results, groupingProperty);
    } else {
      processIndividualRecords(config, results);
    }
    if (result) {
      config.setLastrundate(new Date());
      OBDal.getInstance().save(config);
    }

  }

  /**
   * Lógica antigua 1:1
   */
  private void processIndividualRecords(AemEmailQueue config, List<BaseOBObject> records) {
    for (BaseOBObject record : records) {
      try {
        String detail = sendEmail(config, record, null); // null = no list
        logSuccess(config, record, detail);
      } catch (Exception e) {
        log.error("Error enviando email individual ID " + record.getId(), e);
      }
    }
  }

  /**
   * NUEVA Lógica 1:N (Agrupación Dinámica)
   */
  private void processGroupedRecords(AemEmailQueue config, List<BaseOBObject> records,
      String groupingProperty) {
    // A. Agrupar
    Map<String, List<BaseOBObject>> groups = new HashMap<>();

    for (BaseOBObject record : records) {
      try {
        // Obtener valor dinámico del campo de agrupación (ej: ID del Tercero)
        Object groupValueObj = EmailParserUtils.resolvePropertyObject(record, groupingProperty);
        String groupKey = (groupValueObj instanceof BaseOBObject)
            ? ((BaseOBObject) groupValueObj).getId().toString()
            : (groupValueObj != null ? groupValueObj.toString() : "UNKNOWN");

        groups.computeIfAbsent(groupKey, k -> new ArrayList<>()).add(record);
      } catch (Exception e) {
        log.warn("Error obteniendo llave de agrupación para registro " + record.getId(), e);
      }
    }

    // B. Procesar Grupos
    for (Map.Entry<String, List<BaseOBObject>> entry : groups.entrySet()) {
      List<BaseOBObject> groupList = entry.getValue();
      if (groupList.isEmpty())
        continue;

      // Usamos el primer registro para resolver variables de cabecera (Tercero, Org, etc.)
      BaseOBObject headRecord = groupList.get(0);

      try {
        // Enviamos la lista completa al método de envío
        String detail = sendEmail(config, headRecord, groupList);

        // C. LOGGING: Debemos marcar TODOS los registros del grupo como enviados
        for (BaseOBObject processedRecord : groupList) {
          logSuccess(config, processedRecord, "Agrupado en envío: <br>" + detail);
        }

      } catch (Exception e) {
        log.error("Error enviando email agrupado Key: " + entry.getKey(), e);
      }
    }
  }

  private String sendEmail(AemEmailQueue config, BaseOBObject record, List<BaseOBObject> groupList)
      throws Exception {
    String body = EmailParserUtils.parseWithGroup(config.getEmailTemplate().getBodyContent(),
        config.getEmailTemplate(), record, groupList);
    String replytoMail = TemplateParser.getParamsEntityMail(config.getIssuingEntity(), record);
    String fromMail = TemplateParser.getParamsEntityMail(config.getReceivingEntity(), record);
    String footer = config.getEmailTemplate().getFooterContent();
    body = body.concat("<br>").concat(footer);
    EmailConnectionUtils.send(config.getSMTPConfiguration(), fromMail, replytoMail,
        config.getEmailTemplate().getSubject(), body, config.getEmailTemplate().getLogoImage());

    return "".concat("Enviado a: " + fromMail).concat("<br>Responder a: " + replytoMail)
        .concat("<br>" + body);
  }

  private void logSuccess(AemEmailQueue config, BaseOBObject record, String detail) {
    AemNotificationLog obCr = OBProvider.getInstance().get(AemNotificationLog.class);
    obCr.setAEMEmailQueue(config);
    obCr.setRecordid((String) record.getId());
    obCr.setSentdate(new Date());
    obCr.setSearchKey((String) record.getIdentifier());
    obCr.setResultTrx(detail);
    OBDal.getInstance().save(obCr);
    OBDal.getInstance().flush();
  }

  @Override
  public void kill(ProcessBundle processBundle) throws Exception {
    this.killProcess = true;
  }

}