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
 * Contributor(s):  __________
 ************************************************************************
 */
package ec.com.sidesoft.email.onChange;

import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.client.kernel.BaseActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.ad.ui.Tab;

public class OnchangeQueue extends BaseActionHandler {

  @Override
  protected JSONObject execute(Map<String, Object> parameters, String data) {
    try {

      // get the data as json
      final JSONObject jsonData = new JSONObject(data);
      final String value = jsonData.getString("value");

      // create the result
      JSONObject json = new JSONObject();
      String tableId = "";
      try {
        OBContext.setAdminMode();
        Tab qu = OBDal.getInstance().get(Tab.class, value);
        tableId = qu.getTable().getId();
      } finally {
        OBContext.restorePreviousMode();
      }
      json.put("tableId", tableId);
      return json;
    } catch (Exception e) {
      throw new OBException(e);
    }
  }
}
