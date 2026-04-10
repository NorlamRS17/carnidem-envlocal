package ec.com.sidesoft.email.ad_process;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.datamodel.Table; // Import CORREGIDO

import ec.com.sidesoft.email.AemTemplate;

public class DefaultEmailAdapter implements IEmailContentAdapter {

  private TemplateRenderer templateRenderer = new TemplateRenderer();
  private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  public List<Map<String, Object>> generateEmailRecords(String tableId, String templateId,
      Date dateFrom, Date dateTo) {
    List<Map<String, Object>> recordsToInsert = new ArrayList<>();

    AemTemplate template = OBDal.getInstance().get(AemTemplate.class, templateId);
    Table adTable = OBDal.getInstance().get(Table.class, tableId);

    if (template == null || adTable == null) {
      throw new IllegalArgumentException("Plantilla o Tabla de Origen no encontrada.");
    }

    String entityName = adTable.getEntityName();
    String hql = "FROM " + entityName + " e WHERE e." + getDateFilterColumnName() + " BETWEEN '"
        + DATE_FORMAT.format(dateFrom) + "' AND '" + DATE_FORMAT.format(dateTo) + "'";

    List<?> results = OBDal.getInstance().getSession().createQuery(hql).list();

    for (Object result : results) {
      try {
        BaseOBObject obObject = (BaseOBObject) result;

        String emailAddress = getGenericEmailField(obObject);

        if (emailAddress == null || emailAddress.isEmpty())
          continue;

        Map<String, Object> dataContext = createDataContext(obObject);
        String renderedBody = templateRenderer.render(template.getBodyContent(), dataContext);
        String renderedSubject = templateRenderer.render(template.getSubject(), dataContext);

        Map<String, Object> recordData = new HashMap<>();
        recordData.put("emailTo", emailAddress);
        recordData.put("subject", renderedSubject);
        recordData.put("bodyContent", renderedBody);
        recordData.put("table", adTable);
        recordData.put("template", template);
        // recordData.put("smtpConfig", template.getAEMSmtpConfig());

        recordsToInsert.add(recordData);

      } catch (Exception e) {
        System.out.println("ERROR en DefaultAdapter al procesar un registro: " + e.getMessage());
      }
    }
    return recordsToInsert;
  }

  private String getGenericEmailField(BaseOBObject obObject) {
    String[] possibleFields = { "emailAddress", "businessPartner.emailAddress", "user.email",
        "emailTo" };
    for (String field : possibleFields) {
      try {
        Object value = PropertyUtils.getProperty(obObject, field);
        if (value != null && value instanceof String && !((String) value).isEmpty()) {
          return (String) value;
        }
      } catch (Exception ignore) {
      }
    }
    return null;
  }

  private Map<String, Object> createDataContext(BaseOBObject obObject) {
    Map<String, Object> context = new HashMap<>();
    context.put("record", obObject);
    return context;
  }

  @Override
  public String getDateFilterColumnName() {
    return "creationDate";
  }
}