package ec.com.sidesoft.app.order.ws;

import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.service.web.WebService;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import ec.com.sidesoft.app.order.SsapporLog;
import ec.com.sidesoft.app.order.util.ResponseUser;
import ec.com.sidesoft.app.order.util.ResponseWS;

public class SsapporOrder implements WebService {
  private static final Logger logger = Logger.getLogger(SsapporOrder.class);
  private static final long serialVersionUID = 1L;

  @Override
  public void doPost(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String jsoninfo = null;
    try {
      JsonElement element = new JsonParser().parse(new InputStreamReader(request.getInputStream()));
      jsoninfo = element.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    switch (path) {
    case "/SalesOrder":
      SsapporLog log = OBProvider.getInstance().get(SsapporLog.class);
      log.setJsoninfo(jsoninfo);
      log.setType("Ssappor_sales_order");
      OBDal.getInstance().save(log);
      OBDal.getInstance().flush();
      OBDal.getInstance().commitAndClose();
      ResponseWS responseWS = new ResponseWS("Correct", log.getId());
      final String json = getResponse(responseWS);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      final Writer w = response.getWriter();
      w.write(json);
      w.close();
      break;
    case "/PaymentIn":
      SsapporLog log1 = OBProvider.getInstance().get(SsapporLog.class);
      log1.setJsoninfo(jsoninfo);
      log1.setType("Ssappor_payment_in");
      OBDal.getInstance().save(log1);
      OBDal.getInstance().flush();
      OBDal.getInstance().commitAndClose();
      ResponseWS responseWS1 = new ResponseWS("Correct", log1.getId());
      final String json1 = getResponse(responseWS1);
      response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
      final Writer w1 = response.getWriter();
      w1.write(json1);
      w1.close();
      break;
    case "/LoggedIn":
      User user = OBContext.getOBContext().getUser();
      BusinessPartner partner = user.getBusinessPartner();
      String partnerEmail = partner != null ? partner.getEEIEmail() : "";
      String partnerId = partner != null ? partner.getId() : "";

      try {
        ResponseUser responseUser = new ResponseUser("Successs", user.getName(), partnerEmail, "",
            "", "$", "12", user.getId(), partnerId, user.getSsdpmTypUser(), organizationList(user),
            user.isSsapqIsproductionappuser());
        final String json2 = getResponse(responseUser);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        final Writer w2 = response.getWriter();
        w2.write(json2);
        w2.close();
      } catch (Exception e) {
        e.printStackTrace();
        OBDal.getInstance().rollbackAndClose();
      }
      return;
    default:
      try {
        ResponseWS responseWS3 = new ResponseWS("Error", "BAD URL");
        final String json3 = getResponse(responseWS3);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        final Writer w3 = response.getWriter();
        w3.write(json3);
        w3.close();
      } catch (Exception e) {
        e.printStackTrace();
        OBDal.getInstance().rollbackAndClose();
      }
      return;
    }
  }

  @Override
  public void doDelete(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void doPut(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  @Override
  public void doGet(String path, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    // TODO Auto-generated method stub

  }

  private String getResponse(ResponseWS response) {
    Gson gson = new Gson();
    String json = gson.toJson(response);
    return json;
  }

  private String getResponse(ResponseUser response) {
    Gson gson = new Gson();
    String json = gson.toJson(response);
    return json;
  }

  private Set<String> organizationList(User user) {

    Set<String> result = new HashSet<String>();

    try {

      OBContext.setAdminMode();
      List<String> userRoleIds = new ArrayList<>();
      final Session session = OBDal.getInstance().getSession();
      // Consulta roles por usuiaro
      final StringBuilder hqlRoleIds = new StringBuilder();
      hqlRoleIds.append(" SELECT ru.role.id");
      hqlRoleIds.append(" FROM ADUserRoles ru");
      hqlRoleIds.append(" WHERE ru.userContact.id in (:recordId) ");
      hqlRoleIds.append(" AND ru.active = 'Y' ");
      hqlRoleIds.append(" AND ru.role.active = 'Y' ");
      hqlRoleIds.append(" GROUP BY 1");

      final Query queryRole = session.createQuery(hqlRoleIds.toString());
      queryRole.setParameter("recordId", user.getId());
      for (Object resultObject : queryRole.list()) {
        if (resultObject != null) {
          result.add(resultObject.toString());
        }
      }
      // Consulta Organizaciones por Rol
      final StringBuilder hqlString = new StringBuilder();
      hqlString.append(" SELECT ro.organization.id");
      hqlString.append(" FROM ADRoleOrganization ro");
      hqlString.append(" JOIN ro.role as ru");
      hqlString.append(" WHERE ro.role.id in (:recordId)");
      hqlString.append(" AND ro.active='Y'");
      hqlString.append(" AND ro.role.active='Y'");
      hqlString.append(" AND ro.organization.active='Y'");
      hqlString.append(" GROUP BY 1");

      final Query query = session.createQuery(hqlString.toString());
      query.setParameterList("recordId", result);
      result = new HashSet<String>();

      for (Object resultObject : query.list()) {
        if (resultObject != null) {
          result.add(resultObject.toString());
        }
      }

    } finally {
      OBContext.restorePreviousMode();
    }

    return result;

  }

}
