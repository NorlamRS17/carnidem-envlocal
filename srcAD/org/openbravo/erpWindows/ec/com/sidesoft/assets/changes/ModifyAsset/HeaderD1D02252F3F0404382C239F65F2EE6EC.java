
package org.openbravo.erpWindows.ec.com.sidesoft.assets.changes.ModifyAsset;




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
public class HeaderD1D02252F3F0404382C239F65F2EE6EC extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "03F4F8A399C040CB9ED7F7B96306A7AB";
  private static final String tabId = "D1D02252F3F0404382C239F65F2EE6EC";
  private static final int accesslevel = 7;
  private static final String moduleId = "B956FD2E533745498FDEC2037A1087BB";
  
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
     
      if (command.contains("1BBCF97310864568BE34873F36850CC9")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1BBCF97310864568BE34873F36850CC9");
        SessionInfo.setModuleId("B956FD2E533745498FDEC2037A1087BB");
      }
     
      if (command.contains("364164C3FDC54156936DD179969F46B6")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("364164C3FDC54156936DD179969F46B6");
        SessionInfo.setModuleId("B956FD2E533745498FDEC2037A1087BB");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("1BBCF97310864568BE34873F36850CC9") || (securedProcess && command.contains("1BBCF97310864568BE34873F36850CC9"))) {
        classInfo.type = "P";
        classInfo.id = "1BBCF97310864568BE34873F36850CC9";
      }
     
      if (explicitAccess.contains("364164C3FDC54156936DD179969F46B6") || (securedProcess && command.contains("364164C3FDC54156936DD179969F46B6"))) {
        classInfo.type = "P";
        classInfo.id = "364164C3FDC54156936DD179969F46B6";
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

    } else if (vars.commandIn("BUTTONLoad_Fields1BBCF97310864568BE34873F36850CC9")) {
        vars.setSessionValue("button1BBCF97310864568BE34873F36850CC9.strloadFields", vars.getStringParameter("inploadFields"));
        vars.setSessionValue("button1BBCF97310864568BE34873F36850CC9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1BBCF97310864568BE34873F36850CC9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1BBCF97310864568BE34873F36850CC9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1BBCF97310864568BE34873F36850CC9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1BBCF97310864568BE34873F36850CC9", request.getServletPath());
      } else if (vars.commandIn("BUTTON1BBCF97310864568BE34873F36850CC9")) {
        String strSsach_Modify_Asset_ID = vars.getGlobalVariable("inpssachModifyAssetId", windowId + "|Ssach_Modify_Asset_ID", "");
        String strloadFields = vars.getSessionValue("button1BBCF97310864568BE34873F36850CC9.strloadFields");
        String strProcessing = vars.getSessionValue("button1BBCF97310864568BE34873F36850CC9.strProcessing");
        String strOrg = vars.getSessionValue("button1BBCF97310864568BE34873F36850CC9.strOrg");
        String strClient = vars.getSessionValue("button1BBCF97310864568BE34873F36850CC9.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Fields1BBCF97310864568BE34873F36850CC9(response, vars, strSsach_Modify_Asset_ID, strloadFields, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcess364164C3FDC54156936DD179969F46B6")) {
        vars.setSessionValue("button364164C3FDC54156936DD179969F46B6.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button364164C3FDC54156936DD179969F46B6.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button364164C3FDC54156936DD179969F46B6.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button364164C3FDC54156936DD179969F46B6.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button364164C3FDC54156936DD179969F46B6.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "364164C3FDC54156936DD179969F46B6", request.getServletPath());
      } else if (vars.commandIn("BUTTON364164C3FDC54156936DD179969F46B6")) {
        String strSsach_Modify_Asset_ID = vars.getGlobalVariable("inpssachModifyAssetId", windowId + "|Ssach_Modify_Asset_ID", "");
        String strprocess = vars.getSessionValue("button364164C3FDC54156936DD179969F46B6.strprocess");
        String strProcessing = vars.getSessionValue("button364164C3FDC54156936DD179969F46B6.strProcessing");
        String strOrg = vars.getSessionValue("button364164C3FDC54156936DD179969F46B6.strOrg");
        String strClient = vars.getSessionValue("button364164C3FDC54156936DD179969F46B6.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess364164C3FDC54156936DD179969F46B6(response, vars, strSsach_Modify_Asset_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_Fields1BBCF97310864568BE34873F36850CC9")) {
        String strSsach_Modify_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssach_Modify_Asset_ID", "");
        
        ProcessBundle pb = new ProcessBundle("1BBCF97310864568BE34873F36850CC9", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssach_Modify_Asset_ID", strSsach_Modify_Asset_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONProcess364164C3FDC54156936DD179969F46B6")) {
        String strSsach_Modify_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssach_Modify_Asset_ID", "");
        
        ProcessBundle pb = new ProcessBundle("364164C3FDC54156936DD179969F46B6", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssach_Modify_Asset_ID", strSsach_Modify_Asset_ID);
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



    void printPageButtonLoad_Fields1BBCF97310864568BE34873F36850CC9(HttpServletResponse response, VariablesSecureApp vars, String strSsach_Modify_Asset_ID, String strloadFields, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1BBCF97310864568BE34873F36850CC9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Fields1BBCF97310864568BE34873F36850CC9", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsach_Modify_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderD1D02252F3F0404382C239F65F2EE6EC_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1BBCF97310864568BE34873F36850CC9");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1BBCF97310864568BE34873F36850CC9");
        vars.removeMessage("1BBCF97310864568BE34873F36850CC9");
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
    void printPageButtonProcess364164C3FDC54156936DD179969F46B6(HttpServletResponse response, VariablesSecureApp vars, String strSsach_Modify_Asset_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 364164C3FDC54156936DD179969F46B6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process364164C3FDC54156936DD179969F46B6", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsach_Modify_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderD1D02252F3F0404382C239F65F2EE6EC_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "364164C3FDC54156936DD179969F46B6");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("364164C3FDC54156936DD179969F46B6");
        vars.removeMessage("364164C3FDC54156936DD179969F46B6");
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
