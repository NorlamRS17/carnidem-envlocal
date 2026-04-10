package ec.com.sidesoft.projects.complement.ad_callouts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import org.hibernate.criterion.Restrictions;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.database.SessionInfo;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.model.common.hcm.SalaryCategoryCost;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.QueryTimeOutUtil;

public class SproctmTaskWorkforce extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    String strcSalaryCategoryId = info.getStringParameter("inpcSalaryCategoryId", null);
    // selecionar la unidad del ultimo costo registrado con la fecha mayot mas actual

    ConnectionProvider connectionProvider = new DalConnectionProvider(false);
    String strSql = "select MAX(datefrom) as datefrom from  C_Salary_Category_Cost "
        + "WHERE C_Salary_Category_ID = '" + strcSalaryCategoryId + "'";

    ResultSet result;
    ResultSet rs;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      result = st.executeQuery();
      while (result.next()) {
        String strSqlCategId = "select C_Salary_Category_Cost_ID from  C_Salary_Category_Cost "
            + "WHERE datefrom = '" + result.getString(1).toString()
            + "'::date AND C_Salary_Category_ID = '"
            + info.getStringParameter("inpcSalaryCategoryId", null) + "' ";
        st = connectionProvider.getPreparedStatement(strSqlCategId);
        QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
        rs = st.executeQuery();
        while (rs.next()) {
          OBContext.setAdminMode(true);

          OBCriteria<SalaryCategoryCost> obc = OBDal.getInstance()
              .createCriteria(SalaryCategoryCost.class);
          obc.add(Restrictions.eq(SalaryCategoryCost.PROPERTY_ID, rs.getString(1).toString()));
          obc.setMaxResults(1);
          OBContext.setAdminMode(false);

          SalaryCategoryCost salaricategoryLine = (SalaryCategoryCost) obc.uniqueResult();
          if (salaricategoryLine != null) {
            info.addResult("inpcostuom", salaricategoryLine.getCostUOM());
          }
        }

      }

      result.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}
