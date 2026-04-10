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
 * All portions are Copyright (C) 2001-2012 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package com.atrums.ventas.factores.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.data.FieldProvider;
import org.openbravo.erpCommon.ad_callouts.SimpleCallout;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.Utility;

public class ATVEF_Contado_Credito extends SimpleCallout {
  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {

    // General data

    String strBPartner = info.vars.getStringParameter("inpcBpartnerId");
    String strIsSOTrx = Utility.getContext(this, info.vars, "isSOTrx", info.getWindowId());
    String strOrgId = info.vars.getStringParameter("inpadOrgId");
    String strFinPaymentMethodId = "";
    String strPaymentterm = info.vars.getStringParameter("inpcPaymenttermId");
    String strDocTypeTarget = info.vars.getStringParameter("inpcDoctypetargetId");

    ATVEFPaymenttermData[] data = ATVEFPaymenttermData.select(this, strPaymentterm);

    String Strdias = data[0].netdays;

    int dias = Integer.parseInt(Strdias);

    FieldProvider[] tld = null;
    try {
      ComboTableData comboTableData = new ComboTableData(info.vars, this, "TABLE",
          "ATVEF_Metodos_Contado", "A288233644264376BB21CB4EC16D6318", "", Utility.getContext(this,
              info.vars, "#AccessibleOrgTree", "SEOrderBPartner"), Utility.getContext(this,
              info.vars, "#User_Client", "SEOrderBPartner"), 0);
      Utility.fillSQLParameters(this, info.vars, null, comboTableData, "SEOrderBPartner", "");
      tld = comboTableData.select(false);
      comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

    if (tld != null && tld.length > 0) {
      info.addSelect("inpfinPaymentmethodId");
      for (int i = 0; i < tld.length; i++) {
        info.addSelectResult(tld[i].getField("id"), tld[i].getField("name"), tld[i].getField("id")
            .equalsIgnoreCase(strFinPaymentMethodId));
      }

      info.endSelect();

    }

    if (dias > 0) {
      FieldProvider[] tld1 = null;
      try {
        ComboTableData comboTableData = new ComboTableData(info.vars, this, "TABLE",
            "ATVEF_Metodos_Credito", "F9B00A39966445B7B4792D157D04788A", "", Utility.getContext(
                this, info.vars, "#AccessibleOrgTree", "SEOrderBPartner"), Utility.getContext(this,
                info.vars, "#User_Client", "SEOrderBPartner"), 0);
        Utility.fillSQLParameters(this, info.vars, null, comboTableData, "SEOrderBPartner", "");
        tld1 = comboTableData.select(false);
        comboTableData = null;
      } catch (Exception ex) {
        throw new ServletException(ex);
      }

      if (tld1 != null && tld1.length > 0) {
        info.addSelect("inpfinPaymentmethodId");
        for (int i = 0; i < tld1.length; i++) {
          info.addSelectResult(tld1[i].getField("id"), tld1[i].getField("name"),
              tld1[i].getField("id").equalsIgnoreCase(strFinPaymentMethodId));
        }

        info.endSelect();

      }
    }

  }
}
