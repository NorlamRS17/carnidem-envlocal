package ec.com.sidesoft.workorder.simplified.ad_actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;
import com.atrums.indumoto.postventa.data.atindpo_postventalinea;

public class TransferpartsreturnActionHandler extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject response = new JSONObject();
    ConnectionProvider conn = new DalConnectionProvider(false);
    try {
      final JSONObject jsonData = new JSONObject(data);
      final JSONArray rows = jsonData.getJSONArray("rows");
      ArrayList<String> arrayUpdateNomina = new ArrayList<String>();

      for (int i = 0; i < rows.length(); i++) {
        arrayUpdateNomina.add(rows.getString(i));
        atindpo_postventalinea Objln = OBDal.getInstance().get(atindpo_postventalinea.class,
            rows.getString(i));
        Objln.setUpdatedBy(OBContext.getOBContext().getUser());
        Objln.setUpdated(new Date());
      }
      String line = arrayUpdateNomina.get(0);
      atindpo_postventalinea Objline = OBDal.getInstance().get(atindpo_postventalinea.class, line);
      Objline.getAtindpoPostventa().setUpdatedBy(OBContext.getOBContext().getUser());
      Objline.getAtindpoPostventa().setUpdated(new Date());
      OBDal.getInstance().flush();

      String strNominas = StringUtils.join(arrayUpdateNomina, ",");
      String dataas = TransferpartsreturnData.sswosGoodsMovementReturn(conn, strNominas);

      if (!dataas.equals("OK")) {
        response.put("status", "ERROR");
        response.put("message", dataas);
        OBContext.setAdminMode(false);
        return response;
      }
      OBDal.getInstance().flush();
      response.put("status", "OK");
    } catch (Exception e) {
      System.out.println("TransferpartsreturnActionHandler: " + e.getMessage());
      try {
        response.put("status", "ERROR");
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    }
    OBContext.setAdminMode(false);
    return response;
  }
}
