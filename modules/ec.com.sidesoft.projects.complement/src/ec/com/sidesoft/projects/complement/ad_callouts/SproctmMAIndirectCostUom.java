package ec.com.sidesoft.projects.complement.ad_callouts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;

import org.openbravo.database.ConnectionProvider;
import org.openbravo.database.SessionInfo;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.QueryTimeOutUtil;

public class SproctmMAIndirectCostUom extends SimpleCallout {

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    String strmaIndirectCostId = info.getStringParameter("inpmaIndirectCostId", null);

    ConnectionProvider connectionProvider = new DalConnectionProvider(false);
    String strSql = "select cost_uom from MA_Indirect_Cost_Value WHERE MA_Indirect_Cost_ID = '"
        + strmaIndirectCostId
        + "' AND datefrom = (select MAX(datefrom) from MA_Indirect_Cost_Value WHERE MA_Indirect_Cost_ID = '"
        + strmaIndirectCostId + "')";

    ResultSet result;
    ResultSet rs;
    PreparedStatement st = null;

    try {
      st = connectionProvider.getPreparedStatement(strSql);
      QueryTimeOutUtil.getInstance().setQueryTimeOut(st, SessionInfo.getQueryProfile());
      result = st.executeQuery();
      while (result.next()) {
        info.addResult("inpcostuom", result.getString(1).toString());
      }

      result.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
