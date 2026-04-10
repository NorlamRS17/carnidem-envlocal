
package org.openbravo.erpWindows.ec.com.sidesoft.postdated.check.PostDatedChecks;


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
public class PostDatedChecks0514EA863E6D418681CE6123F0CB95FB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E6621E62BF854C10ABF9849CAACEEDF8";
  private static final String tabId = "0514EA863E6D418681CE6123F0CB95FB";
  private static final int accesslevel = 3;
  private static final String moduleId = "67D274287CA74CD096E9B89F01C8B5BB";
  
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
     
      if (command.contains("D0DD912AAAE647D5979499456374BEB2")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D0DD912AAAE647D5979499456374BEB2");
        SessionInfo.setModuleId("67D274287CA74CD096E9B89F01C8B5BB");
        if (securedProcess || explicitAccess.contains("D0DD912AAAE647D5979499456374BEB2")) {
          classInfo.type = "P";
          classInfo.id = "D0DD912AAAE647D5979499456374BEB2";
        }
      }
     
      if (command.contains("EA663B9AE4E340ECBBD1307940BC2C00")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("EA663B9AE4E340ECBBD1307940BC2C00");
        SessionInfo.setModuleId("67D274287CA74CD096E9B89F01C8B5BB");
        if (securedProcess || explicitAccess.contains("EA663B9AE4E340ECBBD1307940BC2C00")) {
          classInfo.type = "P";
          classInfo.id = "EA663B9AE4E340ECBBD1307940BC2C00";
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

     } else if (vars.commandIn("BUTTONLoad_LinesD0DD912AAAE647D5979499456374BEB2")) {
        vars.setSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strloadLines", vars.getStringParameter("inploadLines"));
        vars.setSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD0DD912AAAE647D5979499456374BEB2.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D0DD912AAAE647D5979499456374BEB2", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND0DD912AAAE647D5979499456374BEB2")) {
        String strSspch_Postdated_Checks_ID = vars.getGlobalVariable("inpsspchPostdatedChecksId", windowId + "|Sspch_Postdated_Checks_ID", "");
        String strloadLines = vars.getSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strloadLines");
        String strProcessing = vars.getSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strProcessing");
        String strOrg = vars.getSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strOrg");
        String strClient = vars.getSessionValue("buttonD0DD912AAAE647D5979499456374BEB2.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_LinesD0DD912AAAE647D5979499456374BEB2(response, vars, strSspch_Postdated_Checks_ID, strloadLines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessEA663B9AE4E340ECBBD1307940BC2C00")) {
        vars.setSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEA663B9AE4E340ECBBD1307940BC2C00.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EA663B9AE4E340ECBBD1307940BC2C00", request.getServletPath());    
     } else if (vars.commandIn("BUTTONEA663B9AE4E340ECBBD1307940BC2C00")) {
        String strSspch_Postdated_Checks_ID = vars.getGlobalVariable("inpsspchPostdatedChecksId", windowId + "|Sspch_Postdated_Checks_ID", "");
        String strprocess = vars.getSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strprocess");
        String strProcessing = vars.getSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strProcessing");
        String strOrg = vars.getSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strOrg");
        String strClient = vars.getSessionValue("buttonEA663B9AE4E340ECBBD1307940BC2C00.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessEA663B9AE4E340ECBBD1307940BC2C00(response, vars, strSspch_Postdated_Checks_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_LinesD0DD912AAAE647D5979499456374BEB2")) {
        String strSspch_Postdated_Checks_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspch_Postdated_Checks_ID", "");
        String strloadLines = vars.getStringParameter("inploadLines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D0DD912AAAE647D5979499456374BEB2", (("Sspch_Postdated_Checks_ID".equalsIgnoreCase("AD_Language"))?"0":strSspch_Postdated_Checks_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessEA663B9AE4E340ECBBD1307940BC2C00")) {
        String strSspch_Postdated_Checks_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspch_Postdated_Checks_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "EA663B9AE4E340ECBBD1307940BC2C00", (("Sspch_Postdated_Checks_ID".equalsIgnoreCase("AD_Language"))?"0":strSspch_Postdated_Checks_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonLoad_LinesD0DD912AAAE647D5979499456374BEB2(HttpServletResponse response, VariablesSecureApp vars, String strSspch_Postdated_Checks_ID, String strloadLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D0DD912AAAE647D5979499456374BEB2");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_LinesD0DD912AAAE647D5979499456374BEB2", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspch_Postdated_Checks_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PostDatedChecks0514EA863E6D418681CE6123F0CB95FB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D0DD912AAAE647D5979499456374BEB2");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D0DD912AAAE647D5979499456374BEB2");
        vars.removeMessage("D0DD912AAAE647D5979499456374BEB2");
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
    private void printPageButtonProcessEA663B9AE4E340ECBBD1307940BC2C00(HttpServletResponse response, VariablesSecureApp vars, String strSspch_Postdated_Checks_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EA663B9AE4E340ECBBD1307940BC2C00");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessEA663B9AE4E340ECBBD1307940BC2C00", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspch_Postdated_Checks_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PostDatedChecks0514EA863E6D418681CE6123F0CB95FB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "EA663B9AE4E340ECBBD1307940BC2C00");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("EA663B9AE4E340ECBBD1307940BC2C00");
        vars.removeMessage("EA663B9AE4E340ECBBD1307940BC2C00");
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
