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
 * All portions are Copyright (C) 2001-2017 Openbravo SLU 
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.erpCommon.ad_reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.businessUtility.WindowTabs;
import org.openbravo.erpCommon.utility.ComboTableData;
import org.openbravo.erpCommon.utility.DateTimeData;
import org.openbravo.erpCommon.utility.LeftTabsBar;
import org.openbravo.erpCommon.utility.NavigationBar;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.ToolBar;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.erpCommon.ad_reports.OrganizationData;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.security.OrganizationStructureProvider;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.erpCommon.reference.ListData;

public class ReportOrderNotInvoiceJR extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);

    // Get user Client's base currency
    ConnectionProvider readOnlyCP = DalConnectionProvider.getReadOnlyConnectionProvider();
    String strUserCurrencyId = Utility.stringBaseCurrencyId(readOnlyCP, vars.getClient());
    if (vars.commandIn("DEFAULT")) {
      String strdateFrom = vars.getGlobalVariable("inpDateFrom",
          "ReportOrderNotInvoiceJR|dateFrom", "");
      String strdateTo = vars.getGlobalVariable("inpDateTo", "ReportOrderNotInvoiceJR|dateTo", "");
      String strcBpartnetId = vars.getGlobalVariable("inpcBPartnerId",
          "ReportOrderNotInvoiceJR|bpartner", "");
      String strCOrgId = vars.getGlobalVariable("inpOrg", "ReportOrderNotInvoiceJR|Org", "");
      String strInvoiceRule = vars.getGlobalVariable("inpInvoiceRule",
          "ReportOrderNotInvoiceJR|invoiceRule", "");
      String strDetail = vars.getStringParameter("inpDetail", "0");
      String strCurrencyId = vars.getGlobalVariable("inpCurrencyId",
          "ReportOrderNotInvoiceJR|currency", strUserCurrencyId);
      String strDeliveryDateFrom = vars.getGlobalVariable("inpDeliveryDateFrom",
          "ReportOrderNotInvoiceJR|deliveryDateFrom", "");
      String strDeliveryDateTo = vars.getGlobalVariable("inpDeliveryDateTo",
          "ReportOrderNotInvoiceJR|deliveryDateTo", "");
      String strInvoicePercent = vars.getGlobalVariable("inpInvoicePercent",
          "ReportOrderNotInvoiceJR|invoicePercent", "");
      printPageDataSheet(response, vars, strdateFrom, strdateTo, strcBpartnetId, strCOrgId,
          strInvoiceRule, strDetail, strCurrencyId, strDeliveryDateFrom, strDeliveryDateTo, strInvoicePercent);
    } else if (vars.commandIn("FIND")) {
      String strdateFrom = vars.getRequestGlobalVariable("inpDateFrom",
          "ReportOrderNotInvoiceJR|dateFrom");
      String strdateTo = vars.getRequestGlobalVariable("inpDateTo",
          "ReportOrderNotInvoiceJR|dateTo");
      String strcBpartnetId = vars.getRequestGlobalVariable("inpcBPartnerId",
          "ReportOrderNotInvoiceJR|bpartner");
      String strCOrgId = vars.getRequestGlobalVariable("inpOrg", "ReportOrderNotInvoiceJR|Org");
      String strInvoiceRule = vars.getRequestGlobalVariable("inpInvoiceRule",
          "ReportOrderNotInvoiceJR|invoiceRule");
      String strDetail = vars.getStringParameter("inpDetail", "0");
      String strCurrencyId = vars.getGlobalVariable("inpCurrencyId",
          "ReportOrderNotInvoiceJR|currency", strUserCurrencyId);
      String strDeliveryDateFrom = vars.getRequestGlobalVariable("inpDeliveryDateFrom",
          "ReportOrderNotInvoiceJR|deliveryDateFrom");
      String strDeliveryDateTo = vars.getRequestGlobalVariable("inpDeliveryDateTo",
          "ReportOrderNotInvoiceJR|deliveryDateTo");
      String strInvoicePercent = vars.getRequestGlobalVariable("inpInvoicePercent",
          "ReportOrderNotInvoiceJR|invoicePercent");
      printPageHtml(request, response, vars, strdateFrom, strdateTo, strcBpartnetId, strCOrgId,
          strInvoiceRule, strDetail, strCurrencyId, strDeliveryDateFrom, strDeliveryDateTo, strInvoicePercent, "html");
    } else if (vars.commandIn("EDIT_XLS")) {
      String strdateFrom = vars.getRequestGlobalVariable("inpDateFrom",
          "ReportOrderNotInvoiceJR|dateFrom");
      String strdateTo = vars.getRequestGlobalVariable("inpDateTo",
          "ReportOrderNotInvoiceJR|dateTo");
      String strcBpartnetId = vars.getRequestGlobalVariable("inpcBPartnerId",
          "ReportOrderNotInvoiceJR|bpartner");
      String strCOrgId = vars.getRequestGlobalVariable("inpOrg", "ReportOrderNotInvoiceJR|Org");
      String strInvoiceRule = vars.getRequestGlobalVariable("inpInvoiceRule",
          "ReportOrderNotInvoiceJR|invoiceRule");
      String strDetail = vars.getStringParameter("inpDetail", "0");
      String strCurrencyId = vars.getGlobalVariable("inpCurrencyId",
          "ReportOrderNotInvoiceJR|currency", strUserCurrencyId);
      String strDeliveryDateFrom = vars.getRequestGlobalVariable("inpDeliveryDateFrom",
          "ReportOrderNotInvoiceJR|deliveryDateFrom");
      String strDeliveryDateTo = vars.getRequestGlobalVariable("inpDeliveryDateTo",
          "ReportOrderNotInvoiceJR|deliveryDateTo");
      String strInvoicePercent = vars.getRequestGlobalVariable("inpInvoicePercent",
          "ReportOrderNotInvoiceJR|invoicePercent");
      printPageHtml(request, response, vars, strdateFrom, strdateTo, strcBpartnetId, strCOrgId,
          strInvoiceRule, strDetail, strCurrencyId, strDeliveryDateFrom, strDeliveryDateTo, strInvoicePercent, "xls");
    } else if (vars.commandIn("EDIT_PDF")) {
      String strdateFrom = vars.getRequestGlobalVariable("inpDateFrom",
          "ReportOrderNotInvoiceJR|dateFrom");
      String strdateTo = vars.getRequestGlobalVariable("inpDateTo",
          "ReportOrderNotInvoiceJR|dateTo");
      String strcBpartnetId = vars.getRequestGlobalVariable("inpcBPartnerId",
          "ReportOrderNotInvoiceJR|bpartner");
      String strCOrgId = vars.getRequestGlobalVariable("inpOrg", "ReportOrderNotInvoiceJR|Org");
      String strInvoiceRule = vars.getRequestGlobalVariable("inpInvoiceRule",
          "ReportOrderNotInvoiceJR|invoiceRule");
      String strDetail = vars.getStringParameter("inpDetail", "0");
      String strCurrencyId = vars.getGlobalVariable("inpCurrencyId",
          "ReportOrderNotInvoiceJR|currency", strUserCurrencyId);
      String strDeliveryDateFrom = vars.getRequestGlobalVariable("inpDeliveryDateFrom",
          "ReportOrderNotInvoiceJR|deliveryDateFrom");
      String strDeliveryDateTo = vars.getRequestGlobalVariable("inpDeliveryDateTo",
          "ReportOrderNotInvoiceJR|deliveryDateTo");
      String strInvoicePercent = vars.getRequestGlobalVariable("inpInvoicePercent",
          "ReportOrderNotInvoiceJR|invoicePercent");
      printPageHtml(request, response, vars, strdateFrom, strdateTo, strcBpartnetId, strCOrgId,
          strInvoiceRule, strDetail, strCurrencyId, strDeliveryDateFrom, strDeliveryDateTo, strInvoicePercent, "pdf");
    } else {
      pageError(response);
    }
  }

  private void printPageDataSheet(HttpServletResponse response, VariablesSecureApp vars,
      String strdateFrom, String strdateTo, String strcBpartnetId, String strCOrgId,
      String strInvoiceRule, String strDetail, String strCurrencyId, String strDeliveryDateFrom,
      String strDeliveryDateTo, String strInvoicePercent) throws IOException, ServletException {
    if (log4j.isDebugEnabled()) {
      log4j.debug("Output: dataSheet");
    }
    XmlDocument xmlDocument = null;
    xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_reports/ReportOrderNotInvoiceFilterJR").createXmlDocument();

    ConnectionProvider readOnlyCP = DalConnectionProvider.getReadOnlyConnectionProvider();
    ToolBar toolbar = new ToolBar(readOnlyCP, vars.getLanguage(), "ReportOrderNotInvoiceJR", false,
        "", "", "", false, "ad_reports", strReplaceWith, false, true);
    toolbar.prepareSimpleToolBarTemplate();
    xmlDocument.setParameter("toolbar", toolbar.toString());

    try {
      WindowTabs tabs = new WindowTabs(readOnlyCP, vars,
          "org.openbravo.erpCommon.ad_reports.ReportOrderNotInvoiceJR");
      xmlDocument.setParameter("parentTabContainer", tabs.parentTabs());
      xmlDocument.setParameter("mainTabContainer", tabs.mainTabs());
      xmlDocument.setParameter("childTabContainer", tabs.childTabs());
      xmlDocument.setParameter("theme", vars.getTheme());
      NavigationBar nav = new NavigationBar(readOnlyCP, vars.getLanguage(),
          "ReportOrderNotInvoiceJR.html", classInfo.id, classInfo.type, strReplaceWith,
          tabs.breadcrumb());
      xmlDocument.setParameter("navigationBar", nav.toString());
      LeftTabsBar lBar = new LeftTabsBar(readOnlyCP, vars.getLanguage(),
          "ReportOrderNotInvoiceJR.html", strReplaceWith);
      xmlDocument.setParameter("leftTabs", lBar.manualTemplate());
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    {
      OBError myMessage = vars.getMessage("ReportOrderNotInvoiceJR");
      vars.removeMessage("ReportOrderNotInvoiceJR");
      if (myMessage != null) {
        xmlDocument.setParameter("messageType", myMessage.getType());
        xmlDocument.setParameter("messageTitle", myMessage.getTitle());
        xmlDocument.setParameter("messageMessage", myMessage.getMessage());
      }
    }

    xmlDocument.setParameter("calendar", vars.getLanguage().substring(0, 2));
    xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
    xmlDocument.setParameter("paramLanguage", "defaultLang=\"" + vars.getLanguage() + "\";");
    xmlDocument.setParameter("dateFrom", strdateFrom);
    xmlDocument.setParameter("dateFromdisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateFromsaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateTo", strdateTo);
    xmlDocument.setParameter("dateTodisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("dateTosaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("deliveryDateFrom", strDeliveryDateFrom);
    xmlDocument.setParameter("deliveryDateFromdisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("deliveryDateFromsaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("deliveryDateTo", strDeliveryDateTo);
    xmlDocument.setParameter("deliveryDateTodisplayFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("deliveryDateTosaveFormat", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("detail", strDetail);
    xmlDocument.setParameter("paramBPartnerId", strcBpartnetId);
    xmlDocument.setParameter("paramBPartnerDescription",
        ReportOrderNotInvoiceData.bPartnerDescription(readOnlyCP, strcBpartnetId));
    xmlDocument.setParameter("invoiceRule", strInvoiceRule);
    xmlDocument.setParameter("invoicePercent", strInvoicePercent);
    xmlDocument.setParameter("adOrgId", strCOrgId);
    try {
      ComboTableData comboTableData = new ComboTableData(vars, readOnlyCP, "LIST", "",
          "C_Order InvoiceRule", "Invoice Terms used in Orders Awaiting Invoice report",
          Utility.getContext(readOnlyCP, vars, "#AccessibleOrgTree",
              "ReportOrderNotInvoiceFilterJR"), Utility.getContext(readOnlyCP, vars,
              "#User_Client", "ReportOrderNotInvoiceJR"), 0);
      Utility.fillSQLParameters(readOnlyCP, vars, null, comboTableData, "ReportOrderNotInvoiceJR",
          strInvoiceRule);
      xmlDocument.setData("reportInvoiceRule", "liststructure", comboTableData.select(false));
      comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

    xmlDocument.setParameter("ccurrencyid", strCurrencyId);
    try {
      ComboTableData comboTableData = new ComboTableData(vars, readOnlyCP, "TABLEDIR",
          "C_Currency_ID", "", "", Utility.getContext(readOnlyCP, vars, "#AccessibleOrgTree",
              "ReportOrderNotInvoiceJR"), Utility.getContext(readOnlyCP, vars, "#User_Client",
              "ReportOrderNotInvoiceJR"), 0);
      Utility.fillSQLParameters(readOnlyCP, vars, null, comboTableData, "ReportOrderNotInvoiceJR",
          strCurrencyId);
      xmlDocument.setData("reportC_Currency_ID", "liststructure", comboTableData.select(false));
      comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    try {
      ComboTableData comboTableData = new ComboTableData(vars, readOnlyCP, "TABLEDIR", "AD_Org_ID",
          "", "", Utility.getContext(readOnlyCP, vars, "#User_Org", "ReportOrderNotInvoiceJR"),
          Utility.getContext(readOnlyCP, vars, "#User_Client", "ReportOrderNotInvoiceJR"), 0);
      Utility.fillSQLParameters(readOnlyCP, vars, null, comboTableData, "ReportOrderNotInvoiceJR",
          strCOrgId);
      xmlDocument.setData("reportAD_ORGID", "liststructure", comboTableData.select(false));
      comboTableData = null;

    } catch (Exception ex) {
      throw new ServletException(ex);
    }
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(xmlDocument.print());
    out.close();
  }

  private void printPageHtml(HttpServletRequest request, HttpServletResponse response,
      VariablesSecureApp vars, String strdateFrom, String strdateTo, String strcBpartnetId,
      String strCOrgId, String strInvoiceRule, String strDetail, String strCurrencyId,
      String strDeliveryDateFrom, String strDeliveryDateTo, String strInvoicePercent, String strOutput)
      throws IOException, ServletException {
    if (log4j.isDebugEnabled()) {
      log4j.debug("Output: " + strOutput);
    }

    // Checks if there is a conversion rate for each of the transactions of
    // the report
    ReportOrderNotInvoiceData[] data = null;
    String strConvRateErrorMsg = "";
    OBError myMessage = new OBError();
    ConnectionProvider readOnlyCP = DalConnectionProvider.getReadOnlyConnectionProvider();
    try {
      data = ReportOrderNotInvoiceData.select(readOnlyCP, strCurrencyId, Utility.getContext(readOnlyCP, vars, "#User_Client", "ReportOrderNotInvoiceJR"),
          Utility.getContext(readOnlyCP, vars, "#AccessibleOrgTree", "ReportOrderNotInvoiceJR"),
          strcBpartnetId, strCOrgId, strInvoiceRule, strdateFrom,
          DateTimeData.nDaysAfter(readOnlyCP, strdateTo, "1"), strDeliveryDateFrom,
          DateTimeData.nDaysAfter(readOnlyCP, strDeliveryDateTo, "1"), vars.getLanguage(), strInvoicePercent);
    } catch (ServletException ex) {
      myMessage = Utility.translateError(readOnlyCP, vars, vars.getLanguage(), ex.getMessage());
    }
    strConvRateErrorMsg = myMessage.getMessage();
    // If a conversion rate is missing for a certain transaction, an error
    // message window pops-up.
    if (StringUtils.isNotEmpty(strConvRateErrorMsg)) {
      advisePopUp(request, response, "ERROR",
          Utility.messageBD(readOnlyCP, "NoConversionRateHeader", vars.getLanguage()),
          strConvRateErrorMsg);
    } else { // Launch the report as usual, calling the JRXML file
      String strReportName = "@basedesign@/org/openbravo/erpCommon/ad_reports/ReportOrderNotInvoiceJR.jrxml";

      String strSubTitle = "";
      strSubTitle = Utility.messageBD(readOnlyCP, "From", vars.getLanguage()) + " " + strdateFrom
          + " " + Utility.messageBD(readOnlyCP, "To", vars.getLanguage()) + " " + strdateTo;

      HashMap<String, Object> parameters = new HashMap<String, Object>();
      parameters.put("REPORT_SUBTITLE", strSubTitle);
      parameters.put("Detail", StringUtils.equals(strDetail, "-1"));
      
      // Parámetros de filtros - usando los nombres exactos del JRXML
      parameters.put("dateFrom", strdateFrom != null ? strdateFrom : "");
      parameters.put("dateTo", strdateTo != null ? strdateTo : "");
      parameters.put("deliveryDateFrom", strDeliveryDateFrom != null ? strDeliveryDateFrom : "");
      parameters.put("deliveryDateTo", strDeliveryDateTo != null ? strDeliveryDateTo : "");
      
      // Obtener nombre traducido de InvoiceRule
      String strInvoiceRuleName = "";
      if (StringUtils.isNotEmpty(strInvoiceRule)) {
        try {
          // AD_REFERENCE_ID = '150' para InvoiceRule
          strInvoiceRuleName = ListData.selectNameTrl(readOnlyCP, vars.getLanguage(), "150", strInvoiceRule);
          if (strInvoiceRuleName == null || strInvoiceRuleName.isEmpty()) {
            // Fallback: usar el valor original si no se encuentra traducción
            strInvoiceRuleName = strInvoiceRule;
          }
        } catch (Exception e) {
          // En caso de error, usar el valor original
          strInvoiceRuleName = strInvoiceRule;
        }
      }
      parameters.put("invoiceRule", strInvoiceRuleName);
      
      // Formatear invoicePercent: V=vacío, C=0%, U=1%-99%
      String strInvoicePercentFormatted = "";
      if (StringUtils.isNotEmpty(strInvoicePercent)) {
        if (strInvoicePercent.equals("C")) {
          strInvoicePercentFormatted = "0%";
        } else if (strInvoicePercent.equals("U")) {
          strInvoicePercentFormatted = "1% - 99%";
        }
        // Si es "V" o vacío, se deja vacío
      }
      parameters.put("invoicePercent", strInvoicePercentFormatted);
      
      // Obtener nombre de organización
      String strOrgName = "";
      if (StringUtils.isNotEmpty(strCOrgId)) {
        try {
          strOrgName = OrganizationData.selectOrgName(readOnlyCP, strCOrgId);
        } catch (Exception e) {
          strOrgName = "";
        }
      }
      parameters.put("cOrgId", strOrgName);
      
      // Organization ID para el logo - obtener la entidad legal
      String strOrgId = "0"; // Default
      try {
        Organization org = null;
        // Si hay una organización seleccionada en el filtro, usar esa
        if (StringUtils.isNotEmpty(strCOrgId)) {
          OBContext.setAdminMode(true);
          try {
            org = OBDal.getReadOnlyInstance().get(Organization.class, strCOrgId);
          } finally {
            OBContext.restorePreviousMode();
          }
        } else {
          // Si no hay organización seleccionada, usar la organización actual del usuario
          org = OBContext.getOBContext().getCurrentOrganization();
        }
        
        // Obtener la entidad legal de la organización
        if (org != null) {
          OBContext.setAdminMode(true);
          try {
            OrganizationStructureProvider orgProvider = OBContext.getOBContext()
                .getOrganizationStructureProvider(org.getClient().getId());
            Organization legalEntity = orgProvider.getLegalEntity(org);
            if (legalEntity != null) {
              strOrgId = legalEntity.getId();
            } else {
              // Si no hay entidad legal, usar la organización misma
              strOrgId = org.getId();
            }
          } finally {
            OBContext.restorePreviousMode();
          }
        }
      } catch (Exception e) {
        // En caso de error, usar "0" como fallback
        strOrgId = "0";
      }
      parameters.put("ad_org_id", strOrgId);
      
      // Fecha de impresión y usuario - se obtienen desde el JRXML con OBContext
      java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm");
      parameters.put("fecha_impresion", dateFormat.format(new java.util.Date()));
      // adUserOrg se obtiene desde OBContext en el JRXML
      
      renderJR(vars, response, strReportName, strOutput, parameters, data, null);
    }
  }

  public String getServletInfo() {
    return "Servlet ReportOrderNotInvoiceFilter. This Servlet was made by Pablo Sarobe";
  } // end of getServletInfo() method
}
