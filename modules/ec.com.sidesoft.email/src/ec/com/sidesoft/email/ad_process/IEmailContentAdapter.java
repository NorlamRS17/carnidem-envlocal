package ec.com.sidesoft.email.ad_process;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IEmailContentAdapter {

  List<Map<String, Object>> generateEmailRecords(String tableId, String templateId, Date dateFrom,
      Date dateTo);

  String getDateFilterColumnName();

  class TemplateRenderer {
    public String render(String templateContent, Map<String, Object> dataContext) {
      return templateContent;
    }
  }
}