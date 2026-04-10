
package org.openbravo.erpWindows.ec.com.sidesoft.payroll.telecommuting.dialing.TelecommDialing;


import org.openbravo.erpCommon.reference.*;



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
public class TelecommDialing8205626509AA4DEFA8F2E48A16525F06 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "AEB31D22CBC34951B6769589EE0BA059";
  private static final String tabId = "8205626509AA4DEFA8F2E48A16525F06";
  private static final int accesslevel = 3;
  private static final String moduleId = "5BE5E955B6C44EAE8BBAA65824BE6A9A";
  
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
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("D23C4EA2228C48A3A0E5C79C05AAEC69")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D23C4EA2228C48A3A0E5C79C05AAEC69");
        SessionInfo.setModuleId("5BE5E955B6C44EAE8BBAA65824BE6A9A");
        if (securedProcess || explicitAccess.contains("D23C4EA2228C48A3A0E5C79C05AAEC69")) {
          classInfo.type = "P";
          classInfo.id = "D23C4EA2228C48A3A0E5C79C05AAEC69";
        }
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

     } else if (vars.commandIn("BUTTONProcess_DialingD23C4EA2228C48A3A0E5C79C05AAEC69")) {
        vars.setSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strprocessDialing", vars.getStringParameter("inpprocessDialing"));
        vars.setSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D23C4EA2228C48A3A0E5C79C05AAEC69", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND23C4EA2228C48A3A0E5C79C05AAEC69")) {
        String strSsptdl_Telecomm_Dialing_ID = vars.getGlobalVariable("inpssptdlTelecommDialingId", windowId + "|Ssptdl_Telecomm_Dialing_ID", "");
        String strprocessDialing = vars.getSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strprocessDialing");
        String strProcessing = vars.getSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strProcessing");
        String strOrg = vars.getSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strOrg");
        String strClient = vars.getSessionValue("buttonD23C4EA2228C48A3A0E5C79C05AAEC69.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess_DialingD23C4EA2228C48A3A0E5C79C05AAEC69(response, vars, strSsptdl_Telecomm_Dialing_ID, strprocessDialing, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess_DialingD23C4EA2228C48A3A0E5C79C05AAEC69")) {
        String strSsptdl_Telecomm_Dialing_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssptdl_Telecomm_Dialing_ID", "");
        String strprocessDialing = vars.getStringParameter("inpprocessDialing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D23C4EA2228C48A3A0E5C79C05AAEC69", (("Ssptdl_Telecomm_Dialing_ID".equalsIgnoreCase("AD_Language"))?"0":strSsptdl_Telecomm_Dialing_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
          ProcessBundle bundle = ProcessBundle.pinstance(pinstance, vars, this);
          new ProcessRunner(bundle).execute(this);
          
          PInstanceProcessData[] pinstanceData = PInstanceProcessData.select(this, pinstance);
          myMessage = Utility.getProcessInstanceMessage(this, vars, pinstanceData);
        } catch (ServletException ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
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

    private void printPageButtonProcess_DialingD23C4EA2228C48A3A0E5C79C05AAEC69(HttpServletResponse response, VariablesSecureApp vars, String strSsptdl_Telecomm_Dialing_ID, String strprocessDialing, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D23C4EA2228C48A3A0E5C79C05AAEC69");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process_DialingD23C4EA2228C48A3A0E5C79C05AAEC69", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsptdl_Telecomm_Dialing_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "TelecommDialing8205626509AA4DEFA8F2E48A16525F06_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D23C4EA2228C48A3A0E5C79C05AAEC69");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D23C4EA2228C48A3A0E5C79C05AAEC69");
        vars.removeMessage("D23C4EA2228C48A3A0E5C79C05AAEC69");
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
