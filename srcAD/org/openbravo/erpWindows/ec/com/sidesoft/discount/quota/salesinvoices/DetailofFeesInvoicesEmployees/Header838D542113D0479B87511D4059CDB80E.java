
package org.openbravo.erpWindows.ec.com.sidesoft.discount.quota.salesinvoices.DetailofFeesInvoicesEmployees;




import org.openbravo.erpCommon.utility.*;
import org.openbravo.data.FieldProvider;
import org.openbravo.utils.FormatUtilities;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.exception.OBException;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessRunner;
import org.openbravo.xmlEngine.XmlDocument;
import org.openbravo.database.SessionInfo;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Generated old code, not worth to make i.e. java imports perfect
@SuppressWarnings("unused")
public class Header838D542113D0479B87511D4059CDB80E extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "61F5EAF644094E518E27B7E6B2F65277";
  private static final String tabId = "838D542113D0479B87511D4059CDB80E";
  private static final int accesslevel = 3;
  private static final String moduleId = "8CC6059257244D7EA696A3F9F4055839";
  
  @Override
  public void init(ServletConfig config) {
    setClassInfo("W", tabId, moduleId);
    super.init(config);
  }
  
  
  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    String command = vars.getCommand();
    
    boolean securedProcess = false;
    if (command.contains("BUTTON")) {
     List<String> explicitAccess = Arrays.asList( "");
    
     SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
     SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
     SessionInfo.setQueryProfile("manualProcess");
     
      if (command.contains("C80B03ECDAE345F782E8A10493BCE2B8")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C80B03ECDAE345F782E8A10493BCE2B8");
        SessionInfo.setModuleId("8CC6059257244D7EA696A3F9F4055839");
      }
     
      if (command.contains("33FAB6B9C73240B6829D03908C6CA448")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("33FAB6B9C73240B6829D03908C6CA448");
        SessionInfo.setModuleId("8CC6059257244D7EA696A3F9F4055839");
      }
     
      if (command.contains("AF774550BCA74626ACBC6A9021EB1F88")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AF774550BCA74626ACBC6A9021EB1F88");
        SessionInfo.setModuleId("8CC6059257244D7EA696A3F9F4055839");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("C80B03ECDAE345F782E8A10493BCE2B8") || (securedProcess && command.contains("C80B03ECDAE345F782E8A10493BCE2B8"))) {
        classInfo.type = "P";
        classInfo.id = "C80B03ECDAE345F782E8A10493BCE2B8";
      }
     
      if (explicitAccess.contains("33FAB6B9C73240B6829D03908C6CA448") || (securedProcess && command.contains("33FAB6B9C73240B6829D03908C6CA448"))) {
        classInfo.type = "P";
        classInfo.id = "33FAB6B9C73240B6829D03908C6CA448";
      }
     
      if (explicitAccess.contains("AF774550BCA74626ACBC6A9021EB1F88") || (securedProcess && command.contains("AF774550BCA74626ACBC6A9021EB1F88"))) {
        classInfo.type = "P";
        classInfo.id = "AF774550BCA74626ACBC6A9021EB1F88";
      }
     
    }
    if (!securedProcess) {
      setClassInfo("W", tabId, moduleId);
    }
    super.service(request, response);
  }
  

  public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    Boolean saveRequest = (Boolean) request.getAttribute("autosave");
    
    if(saveRequest != null && saveRequest){
      throw new OBException("2.50 style request.autosave is no longer supported: " + vars.getCommand());
    }
    
    if (vars.commandIn("DEFAULT", "DIRECT", "TAB", "SEARCH", "RELATION", "NEW", "EDIT", "NEXT",
        "PREVIOUS", "FIRST_RELATION", "PREVIOUS_RELATION", "NEXT_RELATION", "LAST_RELATION",
        "LAST", "SAVE_NEW_RELATION", "SAVE_NEW_NEW", "SAVE_NEW_EDIT", "SAVE_EDIT_RELATION",
        "SAVE_EDIT_NEW", "SAVE_EDIT_EDIT", "SAVE_EDIT_NEXT", "DELETE", "SAVE_XHR")) {
      throw new OBException("2.50 style command is no longer supported: " + vars.getCommand());

    } else if (vars.commandIn("BUTTONLoad_LinesC80B03ECDAE345F782E8A10493BCE2B8")) {
        vars.setSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strloadLines", vars.getStringParameter("inploadLines"));
        vars.setSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC80B03ECDAE345F782E8A10493BCE2B8.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C80B03ECDAE345F782E8A10493BCE2B8", request.getServletPath());
      } else if (vars.commandIn("BUTTONC80B03ECDAE345F782E8A10493BCE2B8")) {
        String strSsdqsi_Quota_Detail_ID = vars.getGlobalVariable("inpssdqsiQuotaDetailId", windowId + "|Ssdqsi_Quota_Detail_ID", "");
        String strloadLines = vars.getSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strloadLines");
        String strProcessing = vars.getSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strProcessing");
        String strOrg = vars.getSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strOrg");
        String strClient = vars.getSessionValue("buttonC80B03ECDAE345F782E8A10493BCE2B8.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_LinesC80B03ECDAE345F782E8A10493BCE2B8(response, vars, strSsdqsi_Quota_Detail_ID, strloadLines, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcess33FAB6B9C73240B6829D03908C6CA448")) {
        vars.setSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button33FAB6B9C73240B6829D03908C6CA448.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "33FAB6B9C73240B6829D03908C6CA448", request.getServletPath());
      } else if (vars.commandIn("BUTTON33FAB6B9C73240B6829D03908C6CA448")) {
        String strSsdqsi_Quota_Detail_ID = vars.getGlobalVariable("inpssdqsiQuotaDetailId", windowId + "|Ssdqsi_Quota_Detail_ID", "");
        String strprocess = vars.getSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strprocess");
        String strProcessing = vars.getSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strProcessing");
        String strOrg = vars.getSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strOrg");
        String strClient = vars.getSessionValue("button33FAB6B9C73240B6829D03908C6CA448.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess33FAB6B9C73240B6829D03908C6CA448(response, vars, strSsdqsi_Quota_Detail_ID, strprocess, strProcessing);
        }
    } else if (vars.commandIn("BUTTONReactiveAF774550BCA74626ACBC6A9021EB1F88")) {
        vars.setSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strreactive", vars.getStringParameter("inpreactive"));
        vars.setSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAF774550BCA74626ACBC6A9021EB1F88.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AF774550BCA74626ACBC6A9021EB1F88", request.getServletPath());
      } else if (vars.commandIn("BUTTONAF774550BCA74626ACBC6A9021EB1F88")) {
        String strSsdqsi_Quota_Detail_ID = vars.getGlobalVariable("inpssdqsiQuotaDetailId", windowId + "|Ssdqsi_Quota_Detail_ID", "");
        String strreactive = vars.getSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strreactive");
        String strProcessing = vars.getSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strProcessing");
        String strOrg = vars.getSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strOrg");
        String strClient = vars.getSessionValue("buttonAF774550BCA74626ACBC6A9021EB1F88.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactiveAF774550BCA74626ACBC6A9021EB1F88(response, vars, strSsdqsi_Quota_Detail_ID, strreactive, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_LinesC80B03ECDAE345F782E8A10493BCE2B8")) {
        String strSsdqsi_Quota_Detail_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssdqsi_Quota_Detail_ID", "");
        
        ProcessBundle pb = new ProcessBundle("C80B03ECDAE345F782E8A10493BCE2B8", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssdqsi_Quota_Detail_ID", strSsdqsi_Quota_Detail_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONProcess33FAB6B9C73240B6829D03908C6CA448")) {
        String strSsdqsi_Quota_Detail_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssdqsi_Quota_Detail_ID", "");
        
        ProcessBundle pb = new ProcessBundle("33FAB6B9C73240B6829D03908C6CA448", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssdqsi_Quota_Detail_ID", strSsdqsi_Quota_Detail_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);
    } else if (vars.commandIn("SAVE_BUTTONReactiveAF774550BCA74626ACBC6A9021EB1F88")) {
        String strSsdqsi_Quota_Detail_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssdqsi_Quota_Detail_ID", "");
        
        ProcessBundle pb = new ProcessBundle("AF774550BCA74626ACBC6A9021EB1F88", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssdqsi_Quota_Detail_ID", strSsdqsi_Quota_Detail_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
          if (!myMessage.isConnectionAvailable()) {
            bdErrorConnection(response);
            return;
          } else vars.setMessage(tabId, myMessage);
        }
        //close popup
        if (myMessage!=null) {
          if (log4j.isDebugEnabled()) log4j.debug(myMessage.getMessage());
          vars.setMessage(tabId, myMessage);
        }
        printPageClosePopUp(response, vars);



    } else if (vars.getCommand().toUpperCase().startsWith("BUTTON") || vars.getCommand().toUpperCase().startsWith("SAVE_BUTTON")) {
      pageErrorPopUp(response);
    } else pageError(response);
  }

  private void printPageButtonFS(HttpServletResponse response, VariablesSecureApp vars, String strProcessId, String path) throws IOException, ServletException {
    log4j.debug("Output: Frames action button");
    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    XmlDocument xmlDocument = xmlEngine.readXmlTemplate(
        "org/openbravo/erpCommon/ad_actionButton/ActionButtonDefaultFrames").createXmlDocument();
    xmlDocument.ignoreTranslation = true;
    xmlDocument.setParameter("processId", strProcessId);
    xmlDocument.setParameter("trlFormType", "PROCESS");
    xmlDocument.setParameter("language", "defaultLang = \"" + vars.getLanguage() + "\";\n");
    xmlDocument.setParameter("type", strDireccion + path);
    out.println(xmlDocument.print());
    out.close();
  }



    void printPageButtonLoad_LinesC80B03ECDAE345F782E8A10493BCE2B8(HttpServletResponse response, VariablesSecureApp vars, String strSsdqsi_Quota_Detail_ID, String strloadLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C80B03ECDAE345F782E8A10493BCE2B8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_LinesC80B03ECDAE345F782E8A10493BCE2B8", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsdqsi_Quota_Detail_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header838D542113D0479B87511D4059CDB80E_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C80B03ECDAE345F782E8A10493BCE2B8");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C80B03ECDAE345F782E8A10493BCE2B8");
        vars.removeMessage("C80B03ECDAE345F782E8A10493BCE2B8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonProcess33FAB6B9C73240B6829D03908C6CA448(HttpServletResponse response, VariablesSecureApp vars, String strSsdqsi_Quota_Detail_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 33FAB6B9C73240B6829D03908C6CA448");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process33FAB6B9C73240B6829D03908C6CA448", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsdqsi_Quota_Detail_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header838D542113D0479B87511D4059CDB80E_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "33FAB6B9C73240B6829D03908C6CA448");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("33FAB6B9C73240B6829D03908C6CA448");
        vars.removeMessage("33FAB6B9C73240B6829D03908C6CA448");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonReactiveAF774550BCA74626ACBC6A9021EB1F88(HttpServletResponse response, VariablesSecureApp vars, String strSsdqsi_Quota_Detail_ID, String strreactive, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AF774550BCA74626ACBC6A9021EB1F88");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ReactiveAF774550BCA74626ACBC6A9021EB1F88", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsdqsi_Quota_Detail_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header838D542113D0479B87511D4059CDB80E_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AF774550BCA74626ACBC6A9021EB1F88");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AF774550BCA74626ACBC6A9021EB1F88");
        vars.removeMessage("AF774550BCA74626ACBC6A9021EB1F88");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
