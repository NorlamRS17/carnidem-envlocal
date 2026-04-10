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
 * Contributor(s):  ___Santos- 22022012_______.
 ************************************************************************
 */
//package org.openbravo.erpCommon.ad_callouts;
package com.sidesoft.localization.ecuador.refunds.ad_callouts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.xmlEngine.XmlDocument;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class Add_Refund extends SimpleCallout {
	private static final long serialVersionUID = 1L;
	
	@Override
	  protected void execute(CalloutInfo info) throws ServletException {
		String strChanged = info.getStringParameter("inpemSsreRefundedId", null);
	    String strCodelivelihood = info.getStringParameter("inpemSswhCodelivelihood", null);
	    String strLivelihood = info.getStringParameter("inpemSswhLivelihood", null);
	    
	    AddRefundData[] data = AddRefundData.select(this, strChanged);
	    
	    if (data != null && data.length > 0) {
	    	if (data[0].sswhCodelivelihoodtId != null) {
	            info.addResult("inpemSswhCodelivelihood", data[0].sswhCodelivelihoodtId);
	          }
	    	
	    	if (data[0].sswhLivelihoodtId != null) {
	            info.addResult("inpemSswhLivelihood", data[0].sswhLivelihoodtId);
	          }
	    }
	}
}