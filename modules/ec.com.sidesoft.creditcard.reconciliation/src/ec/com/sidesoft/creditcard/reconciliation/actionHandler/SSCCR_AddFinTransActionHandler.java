
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
 * All portions are Copyright (C) 2014-2016 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.creditcard.reconciliation.actionHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.advpaymentmngt.actionHandler.AddPaymentActionHandler;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSCCR_AddFinTransActionHandler extends AddPaymentActionHandler {
  final private static Logger log = LoggerFactory.getLogger(SSCCR_AddFinTransActionHandler.class);

  @Override
  public JSONObject doExecute(Map<String, Object> parameters, String content) {
    // super.execute(info);

    JSONObject jsonResponse = new JSONObject();
    OBContext.setAdminMode(true);
    boolean openedFromMenu = false;
    String comingFrom = null;
    try {
      VariablesSecureApp vars = RequestContext.get().getVariablesSecureApp();
      // Get Params
      JSONObject jsonRequest = new JSONObject(content);
      JSONObject jsonparams = jsonRequest.getJSONObject("_params");
      JSONObject orderInvoiceGrid = jsonparams.getJSONObject("finnancial_transaction");
      JSONArray selectedPSDs = orderInvoiceGrid.getJSONArray("_selection");
      String strSql = "";
      String strResult = "";
      String strProcessorBank = "";
      ResultSet result = null;
      PreparedStatement st = null;
      String strSsccrPosCardRecId = jsonRequest.getString("Ssccr_Pos_Card_Rec_ID");
      ConnectionProvider conn = new DalConnectionProvider(false);

      strSql = "  DELETE FROM ssccr_pos_card_rec_sum WHERE ssccr_pos_card_rec_id = ?";
      st = conn.getPreparedStatement(strSql);
      st.setString(1, strSsccrPosCardRecId);
      st.execute();

      strSql = "  DELETE FROM ssccr_pos_card_rec_line WHERE ssccr_pos_card_rec_id = ?";
      st = null;
      result = null;
      st = conn.getPreparedStatement(strSql);
      st.setString(1, strSsccrPosCardRecId);
      st.execute();

      strSql = "   SELECT SSCCR_LOAD_LINES_ONE(?, ?) as result";
      for (int i = 0; i < selectedPSDs.length(); i++) {
        JSONObject psdRow = selectedPSDs.getJSONObject(i);

        if (strProcessorBank != null & !strProcessorBank.equals("")
            & !strProcessorBank.equals(psdRow.getString("procesorBank"))) {
          throw new OBException("Linea con banco procesador diferente");
        }
        strProcessorBank = psdRow.getString("procesorBank");

        st = null;
        result = null;
        st = conn.getPreparedStatement(strSql);
        st.setString(1, strSsccrPosCardRecId);
        st.setString(2, psdRow.getString("id"));
        result = st.executeQuery();

        while (result.next()) {
          if (!result.getString("result").equals("OK")) {
            throw new OBException(result.getString("result"));
          }
        }
      }
      strSql = "  INSERT INTO public.ssccr_pos_card_rec_sum(\n"
          + "        ssccr_pos_card_rec_sum_id, ad_client_id, ad_org_id, createdby, updatedby\n"
          + "        , ssccr_pos_card_rec_id, lot, amount, deposit_amount, type      \n"
          + "        , reconciled, ssccr_processor_banck_id, confirmation_no\n" + ") (Select \n"
          + "        get_uuid(), spcr.ad_client_id, spcr.ad_org_id, spcr.createdby, spcr.updatedby\n"
          + "        , spcrl.ssccr_pos_card_rec_id, spcrl.lot, sum(spcrl.amount), sum(spcrl.deposit_amount), spcrl.type\n"
          + "        , spcrl.reconciled, spcrl.ssccr_processor_banck_id, spcrl.confirmation_no\n"
          + "From ssccr_pos_card_rec_line  spcrl\n"
          + "        Join ssccr_pos_card_rec spcr on spcrl.ssccr_pos_card_rec_id = spcr.ssccr_pos_card_rec_id\n"
          + "Where spcrl.ssccr_pos_card_rec_id = ? \n"
          + "Group By spcr.ad_client_id, spcr.ad_org_id, spcr.createdby, spcr.updatedby, spcrl.ssccr_pos_card_rec_id, spcrl.lot, spcrl.type, spcrl.reconciled, spcrl.ssccr_processor_banck_id, spcrl.confirmation_no)";
      st = null;
      result = null;
      st = conn.getPreparedStatement(strSql);
      st.setString(1, strSsccrPosCardRecId);
      st.execute();

    } catch (Exception e) {
      OBDal.getInstance().rollbackAndClose();
      log.error("Exception handling the new payment", e);

      try {
        jsonResponse = new JSONObject();
        Throwable ex = DbUtility.getUnderlyingSQLException(e);
        String message = OBMessageUtils.translateError(ex.getMessage()).getMessage();
        JSONObject errorMessage = new JSONObject();
        errorMessage.put("severity", "error");
        errorMessage.put("text", message);
        jsonResponse.put("retryExecution", openedFromMenu);
        jsonResponse.put("message", errorMessage);

      } catch (Exception ignore) {
      }
    } finally {
      OBContext.restorePreviousMode();
      // super.execute(info);
    }
    return jsonResponse;
  }
}
