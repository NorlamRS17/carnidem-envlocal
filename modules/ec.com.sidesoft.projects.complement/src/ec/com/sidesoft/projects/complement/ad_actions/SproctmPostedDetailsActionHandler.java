package ec.com.sidesoft.projects.complement.ad_actions;

import java.sql.Connection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.hibernate.Query;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.ad_forms.AcctSchema;
import org.openbravo.erpCommon.ad_forms.AcctServer;
import org.openbravo.erpCommon.ad_forms.DocLine;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.service.db.DalConnectionProvider;

public class SproctmPostedDetailsActionHandler extends BaseActionHandler {
  public ConnectionProvider connection;
  public static final String DOCTYPE_TaskProject = "SPROCTM_TP";
  public Client client;
  public Organization org;
  OBError messageResult = null;
  public DocLine[] p_lines = new DocLine[0];
  public static final String ACCTTYPE_C_Debit = "1";
  /** Concept C_Credit Acct */
  public static final String ACCTTYPE_C_Credit = "2";
  /** Concept C_Closing Acct */
  public static final String ACCTTYPE_C_Closing = "3";
  private String SeqNo = "0";
  public String strMessage = "";

  public Logger log4jDocProjectTask = Logger.getLogger(SproctmPostedDetailsActionHandler.class);;

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    OBContext.setAdminMode(true);
    JSONObject response = new JSONObject();
    System.out.print(parameters);
    String msg = null;
    try {
      final JSONObject jsonData = new JSONObject(data);
      final String row_id = jsonData.getString("row_id");

      User user = OBContext.getOBContext().getUser();
      client = OBContext.getOBContext().getCurrentClient();
      org = OBContext.getOBContext().getCurrentOrganization();

      ConnectionProvider connProvider = new DalConnectionProvider(false);
      connection = connProvider;
      // Clase de contabilidad para la transaccion - detalle bajo MO -CIF -MAQ
      // AccountingDetailsProject newPosted = new AccountingDetailsProject(client.getId(),
      // org.getId(),
      // connection);

      final AcctSchema[] as = AcctSchema.getAcctSchemaArray(connection, client.getId(),
          org.getId());

      final VariablesSecureApp vars = new VariablesSecureApp(
          OBContext.getOBContext().getUser().getId(), client.getId(),
          OBContext.getOBContext().getCurrentOrganization().getId());
      Connection conn = OBDal.getInstance().getConnection(false);

      DocInfoTableData dataTable[] = DocInfoTableData.selectRecord(connProvider, row_id);

      String strTableID = "";
      String strTableName = "";
      String strPosted = "";
      if (dataTable.length > 0) {
        strTableID = "103AC5056B734DA291A6E9113774CC45";// dataTable[0].adTableId;
        strTableName = "sproctm_detail_cost";// dataTable[0].tablename;
        strPosted = dataTable[0].posted;
      }
      if (strPosted.equals("N")) {
        AcctServer acct = (AcctServer) Class
            .forName("ec.com.sidesoft.projects.complement.accounting.AccountingDetailsProject")
            .newInstance();
        acct.set(strTableID, client.getId(), org.getId(), connProvider, strTableName, "dateacct");
        acct.reloadAcctSchemaArray();
        if (acct == null) {
          throw new OBException("Accounting process failed for the financial account transaction");
        } else if (!acct.post(row_id, false, vars, connProvider, connProvider.getConnection())
            || acct.errors != 0) {
          connProvider.releaseRollbackConnection(connProvider.getConnection());
          throw new OBException(acct.getMessageResult().getMessage());
        }
        // newPosted.customFactAcct(row_id, as[0], connection, conn, vars);
        msg = "Proceso de contabilidad Ejecutado";
      } else {

        AcctServerData.delete(connProvider, strTableID, row_id);

        String strUpdate = "update " + strTableName
            + " set posted='N', processing='N' where (posted<>'N' or posted is null or processing='N') and "
            + strTableName + "_Id" + " = :recordID ";
        final Query update = OBDal.getInstance().getSession().createSQLQuery(strUpdate);
        update.setParameter("recordID", row_id);
        int updated = update.executeUpdate();
        msg = "Transacción descontabilizado";
      }

      OBDal.getInstance().flush();
      response.put("status", msg);
    } catch (Exception e) {
      try {
        msg = "Error al ejecutar el proceso de contabilidad.";
        response.put("status", msg);
        response.put("message", e.getMessage());
      } catch (Exception e2) {
      }
    }
    OBContext.setAdminMode(false);
    return response;
  }

}
