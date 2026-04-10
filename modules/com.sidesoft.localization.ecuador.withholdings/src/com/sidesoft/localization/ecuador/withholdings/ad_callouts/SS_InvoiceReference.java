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
 * All portions are Copyright (C) 2001-2009 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ___Santos- 15112011-1310_______.
 ************************************************************************
 */
//package org.openbravo.erpCommon.ad_callouts;
package com.sidesoft.localization.ecuador.withholdings.ad_callouts;

import javax.servlet.ServletException;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;


public class SS_InvoiceReference extends SimpleCallout {

  private static final long serialVersionUID = 1L;

  @Override
  protected void execute(CalloutInfo info) throws ServletException {
    try {

      String strDateEnd = info.getStringParameter("inpemSswhDateendinvoice", null);
      String strPartner = info.getStringParameter("inpcBpartnerId", null);


      if (strDateEnd == null || strPartner == null) {
        return;
      }

      SSInvoiceReferenceData[] data = SSInvoiceReferenceData.select(null, strDateEnd, strPartner);


      if (data != null && data.length > 0) {
        info.addResult("inpemSswhInvoiceRef", data[0].noreferencia);
      }

    } catch (Exception e) {
      log4j.error("Error en SS_InvoiceReference SimpleCallout", e);
      throw new ServletException(e);
    }
  }
}
