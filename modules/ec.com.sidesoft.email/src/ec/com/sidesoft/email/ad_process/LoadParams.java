package ec.com.sidesoft.email.ad_process;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.scheduling.Process;
import org.openbravo.scheduling.ProcessBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.email.AemEmailQueue;
import ec.com.sidesoft.email.AemTemplate;
import ec.com.sidesoft.email.AemTemplateVariable;

public class LoadParams implements Process {

  private static final Pattern VARIABLE_PATTERN = Pattern.compile("@([a-zA-Z0-9_.]+)@");
  private static final Logger log = LoggerFactory.getLogger(LoadParams.class);

  @Override
  public void execute(ProcessBundle bundle) throws Exception {

    OBError result = new OBError();

    try {
      Map<String, Object> params = bundle.getParams();

      AemEmailQueue qu = OBDal.getInstance().get(AemEmailQueue.class,
          params.get("AEM_Email_Queue_ID"));

      scanAndCreateVariables(qu);

      result.setType("Success");
      result.setTitle("Éxito");
      bundle.setResult(result);

    } catch (Exception e) {

      OBDal.getInstance().rollbackAndClose();

      result.setType("Error");
      result.setTitle("Error");
      result.setMessage("Error en la generación: " + e.getLocalizedMessage());
      bundle.setResult(result);
    }
  }

  static public Date getDate(String value) throws Exception {
    try {
      SimpleDateFormat df = new SimpleDateFormat("dd-MM-YYYY");
      return df.parse(value.trim());
    } catch (Exception e) {
      throw new OBException("Wrong date format for" + value);
    }
  }

  private void scanAndCreateVariables(AemEmailQueue qu) {
    AemTemplate template = qu.getEmailTemplate();
    String body = template.getBodyContent();
    String subject = template.getSubject();

    String fullContent = (subject != null ? subject : "") + " " + (body != null ? body : "");

    Matcher matcher = VARIABLE_PATTERN.matcher(fullContent);

    while (matcher.find()) {
      String tokenFind = matcher.group(1);
      String tokenComplete = "@" + tokenFind + "@";

      if (!variableExists(template, tokenComplete)) {
        createNewVariableRow(qu, template, tokenComplete);
      }
    }

  }

  private boolean variableExists(AemTemplate template, String token) {
    OBCriteria<AemTemplateVariable> crit = OBDal.getInstance()
        .createCriteria(AemTemplateVariable.class);

    crit.add(Restrictions.eq(AemTemplateVariable.PROPERTY_EMAILTEMPLATE, template));
    crit.add(Restrictions.eq(AemTemplateVariable.PROPERTY_VARIABLENAME, token));

    return crit.count() > 0;
  }

  private void createNewVariableRow(AemEmailQueue qu, AemTemplate template, String token) {
    try {
      AemTemplateVariable newVar = OBProvider.getInstance().get(AemTemplateVariable.class);

      newVar.setEmailTemplate(template);
      newVar.setVariableName(token);
      newVar.setTable(qu.getTab().getTable());
      newVar.setAEMEmailQueue(qu);

      OBDal.getInstance().save(newVar);

    } catch (Exception e) {
      log.error("Error al crear variable: " + token, e);
    }
  }
}
