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
 * All portions are Copyright (C) 2001-2010 Openbravo SLU 
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package com.sidesoft.localization.ecuador.withholdings.ad_callouts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.service.db.DalConnectionProvider;

import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.xmlEngine.XmlDocument;

import org.openbravo.erpCommon.ad_callouts.SimpleCallout;

public class SS_Withholding_DocType extends SimpleCallout {
	private static final long serialVersionUID = 1L;
	
	@Override
	  protected void execute(CalloutInfo info) throws ServletException {
		String strWithholdingDocType = info.getStringParameter("inpemSswhCDoctypeId", null);
	    String strDateWithhold = info.getStringParameter("inpemSswhDatewithhold", null);
	    String strTabId = info.getStringParameter("inpTabId", null);
	    String strCInvoiceId = info.getStringParameter("inpcInvoiceId", null);
	    
	    ConnectionProvider conn = new DalConnectionProvider(true); 
	    
	    SSWithholdingDocTypeData[] data = SSWithholdingDocTypeData.select(conn, strWithholdingDocType, strDateWithhold);
	    String withholdingRef = "";
	    String authorization = "";
	    
	    if (data == null || data.length == 0) {
	    	withholdingRef = "";
	        authorization = "";
	    } else {
	    	String strWithholdingDoctypetinvoice = SSWithholdingDocTypeData
	    	          .selectWithholdingDoctypeinvoice(conn, strCInvoiceId);
	    	
	    	String strDocumentNo = null;
	    	
	    	if (strWithholdingDoctypetinvoice == null || strWithholdingDoctypetinvoice.equals("")
	    	          || !strWithholdingDoctypetinvoice.equals(strWithholdingDocType)) {
	    		if ("Y".equals(data[0].isdocnocontrolled)) {
	    	          strDocumentNo = data[0].currentnext;
	    	        }
	    	        withholdingRef = strDocumentNo != null ? "<" + strDocumentNo + ">" : "";
	    	        authorization = data[0].authorizationno;
	    	} else {
	    		withholdingRef = SSWithholdingDocTypeData.selectActualinvoicewithholding(conn, strCInvoiceId);
	            authorization = data[0].authorizationno;
	    	}
	    }
	    
	    info.addResult("inpemSswhWithholdingref", withholdingRef);
	    info.addResult("inpemSswhAuthorization", authorization);
	}
}