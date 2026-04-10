
package org.openbravo.erpWindows.ec.com.sidesoft.inventory.adjustment.PhysicalInventoryPDV;


import org.openbravo.erpCommon.reference.*;


import org.openbravo.erpCommon.ad_actionButton.*;


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
public class PhysicalInventoryPDV4F429EA8B2704BB186DB6BE838DD483E extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "67B2A7C7F2204725A82D13C88576DDA8";
  private static final String tabId = "4F429EA8B2704BB186DB6BE838DD483E";
  private static final int accesslevel = 3;
  private static final String moduleId = "CD2EFE4D02CF46DF90EB7CCBF2C63C86";
  
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
     
      if (command.contains("164D2FFC9D184D7DA75085943AB657A5")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("164D2FFC9D184D7DA75085943AB657A5");
        SessionInfo.setModuleId("CD2EFE4D02CF46DF90EB7CCBF2C63C86");
      }
     
      if (command.contains("C2D00205D53E4D2290EB232FE78F3667")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C2D00205D53E4D2290EB232FE78F3667");
        SessionInfo.setModuleId("CD2EFE4D02CF46DF90EB7CCBF2C63C86");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("164D2FFC9D184D7DA75085943AB657A5") || (securedProcess && command.contains("164D2FFC9D184D7DA75085943AB657A5"))) {
        classInfo.type = "P";
        classInfo.id = "164D2FFC9D184D7DA75085943AB657A5";
      }
     
      if (explicitAccess.contains("C2D00205D53E4D2290EB232FE78F3667") || (securedProcess && command.contains("C2D00205D53E4D2290EB232FE78F3667"))) {
        classInfo.type = "P";
        classInfo.id = "C2D00205D53E4D2290EB232FE78F3667";
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

    } else if (vars.commandIn("BUTTONGeneratecode164D2FFC9D184D7DA75085943AB657A5")) {
        vars.setSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strgeneratecode", vars.getStringParameter("inpgeneratecode"));
        vars.setSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button164D2FFC9D184D7DA75085943AB657A5.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "164D2FFC9D184D7DA75085943AB657A5", request.getServletPath());
      } else if (vars.commandIn("BUTTON164D2FFC9D184D7DA75085943AB657A5")) {
        String strSiva_Physical_Inventory_ID = vars.getGlobalVariable("inpsivaPhysicalInventoryId", windowId + "|Siva_Physical_Inventory_ID", "");
        String strgeneratecode = vars.getSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strgeneratecode");
        String strProcessing = vars.getSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strProcessing");
        String strOrg = vars.getSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strOrg");
        String strClient = vars.getSessionValue("button164D2FFC9D184D7DA75085943AB657A5.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGeneratecode164D2FFC9D184D7DA75085943AB657A5(response, vars, strSiva_Physical_Inventory_ID, strgeneratecode, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcessC2D00205D53E4D2290EB232FE78F3667")) {
        vars.setSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC2D00205D53E4D2290EB232FE78F3667.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C2D00205D53E4D2290EB232FE78F3667", request.getServletPath());
      } else if (vars.commandIn("BUTTONC2D00205D53E4D2290EB232FE78F3667")) {
        String strSiva_Physical_Inventory_ID = vars.getGlobalVariable("inpsivaPhysicalInventoryId", windowId + "|Siva_Physical_Inventory_ID", "");
        String strprocess = vars.getSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strprocess");
        String strProcessing = vars.getSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strProcessing");
        String strOrg = vars.getSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strOrg");
        String strClient = vars.getSessionValue("buttonC2D00205D53E4D2290EB232FE78F3667.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessC2D00205D53E4D2290EB232FE78F3667(response, vars, strSiva_Physical_Inventory_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONGeneratecode164D2FFC9D184D7DA75085943AB657A5")) {
        String strSiva_Physical_Inventory_ID = vars.getGlobalVariable("inpKey", windowId + "|Siva_Physical_Inventory_ID", "");
        
        ProcessBundle pb = new ProcessBundle("164D2FFC9D184D7DA75085943AB657A5", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Siva_Physical_Inventory_ID", strSiva_Physical_Inventory_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONProcessC2D00205D53E4D2290EB232FE78F3667")) {
        String strSiva_Physical_Inventory_ID = vars.getGlobalVariable("inpKey", windowId + "|Siva_Physical_Inventory_ID", "");
        
        ProcessBundle pb = new ProcessBundle("C2D00205D53E4D2290EB232FE78F3667", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Siva_Physical_Inventory_ID", strSiva_Physical_Inventory_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strauthorizationcode = vars.getStringParameter("inpauthorizationcode");
params.put("authorizationcode", strauthorizationcode);

        
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



    void printPageButtonGeneratecode164D2FFC9D184D7DA75085943AB657A5(HttpServletResponse response, VariablesSecureApp vars, String strSiva_Physical_Inventory_ID, String strgeneratecode, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 164D2FFC9D184D7DA75085943AB657A5");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Generatecode164D2FFC9D184D7DA75085943AB657A5", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSiva_Physical_Inventory_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PhysicalInventoryPDV4F429EA8B2704BB186DB6BE838DD483E_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "164D2FFC9D184D7DA75085943AB657A5");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("164D2FFC9D184D7DA75085943AB657A5");
        vars.removeMessage("164D2FFC9D184D7DA75085943AB657A5");
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
    void printPageButtonProcessC2D00205D53E4D2290EB232FE78F3667(HttpServletResponse response, VariablesSecureApp vars, String strSiva_Physical_Inventory_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C2D00205D53E4D2290EB232FE78F3667");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessC2D00205D53E4D2290EB232FE78F3667", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSiva_Physical_Inventory_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PhysicalInventoryPDV4F429EA8B2704BB186DB6BE838DD483E_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C2D00205D53E4D2290EB232FE78F3667");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C2D00205D53E4D2290EB232FE78F3667");
        vars.removeMessage("C2D00205D53E4D2290EB232FE78F3667");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("authorizationcode", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
