/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html 
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License. 
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2011 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */

package ec.com.sidesoft.email.actionHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.model.Entity;
import org.openbravo.base.model.ModelProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.service.OBDal;

import ec.com.sidesoft.email.AemEmailQueue;
import ec.com.sidesoft.email.utils.EmailParserUtils;
import ec.com.sidesoft.email.utils.TemplateParser;

public class PreviewEmailHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    try {
      final JSONObject jsonData = new JSONObject(data);
      final String recordId = new JSONObject(jsonData.getString("reccorId")).getString("id");
      AemEmailQueue config = OBDal.getInstance().get(AemEmailQueue.class, recordId);
      BaseOBObject sampleRecord = getSingleSampleRecord(config);
      JSONObject result = new JSONObject();
      if (sampleRecord == null) {
        result.put("preview", "Without Data");
      } else {

        String toMail = TemplateParser.getParamsEntityMail(config.getReceivingEntity(),
            sampleRecord);
        String fromMail = TemplateParser.getParamsEntityMail(config.getIssuingEntity(),
            sampleRecord);

        String subject = config.getEmailTemplate().getSubject();
        String footer = config.getEmailTemplate().getFooterContent();

        List<BaseOBObject> mockGroupList = Collections.singletonList(sampleRecord);

        String finalBody = EmailParserUtils.parseWithGroup(
            config.getEmailTemplate().getBodyContent(), config.getEmailTemplate(), sampleRecord,
            mockGroupList // Reutilizamos el parser completo con lógica de agrupación
        );

        // 4. Construir Respuesta Visual (HTML)
        String htmlReport = buildHtmlReport(sampleRecord, toMail, fromMail, subject, finalBody,
            footer);
        result.put("preview", htmlReport);

      }

      return result;
    } catch (Exception e) {
      throw new OBException(e);
    }
  }

  /**
   * Replica la lógica de construcción de Query de SendEmailBackground para asegurar que el preview
   * ve lo mismo que el proceso real.
   */
  private BaseOBObject getSingleSampleRecord(AemEmailQueue config) {
    String tableName = config.getTab().getTable().getDBTableName();
    // Uso de ModelProvider como en tu clase original
    Entity entity = ModelProvider.getInstance().getEntityByTableName(tableName);

    if (entity == null)
      return null;

    String hqlWhere = config.getAemConditionList().isEmpty() ? ""
        : config.getAemConditionList().get(0).getSQLCondition();

    StringBuilder hql = new StringBuilder();
    hql.append("select e from ").append(entity.getName()).append(" as e ");

    if (StringUtils.isNotBlank(hqlWhere)) {
      hql.append(" where ").append(hqlWhere);
    }

    // Ejecución optimizada para traer solo 1
    final Query query = OBDal.getInstance().getSession().createQuery(hql.toString());
    query.setMaxResults(1);

    List<?> list = query.list();
    return list.isEmpty() ? null : (BaseOBObject) list.get(0);
  }

  private String buildHtmlReport(BaseOBObject record, String to, String from, String sub,
      String body, String footer) {
    StringBuilder sb = new StringBuilder();
    sb.append("<b>Registro ID:</b> ").append(record.getIdentifier()).append("<br/>");
    sb.append("<b>From:</b> ").append(from).append("<br/>");
    sb.append("<b>To:</b> ").append(to).append("<br/><br/>");

    sb.append("<b>[Asunto]:</b> ").append(StringEscapeUtils.escapeHtml(sub)).append("<br/>");

    sb.append("<b>[Cuerpo Generado]:</b><br/>");
    sb.append(
        "<div style='border:1px solid #999; padding:10px; background:white; color:black; max-height:400px; overflow:auto;'>");
    sb.append(body);
    sb.append("<br/>" + footer);

    sb.append("</div>");

    return sb.toString();
  }
}
