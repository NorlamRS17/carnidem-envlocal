
package org.openbravo.erpWindows.ec.com.sidesoft.payroll.overtime.OvertimePlanning;


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
public class Period0F86C42912C54E8FBECBC9BAC2594C3B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "FD82225C38D84C4DAB3DC03AFE671CD0";
  private static final String tabId = "0F86C42912C54E8FBECBC9BAC2594C3B";
  private static final int accesslevel = 7;
  private static final String moduleId = "7AE924E93FD044AEBF69D6D5F6C87F27";
  
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
     
      if (command.contains("3A3D89005EA946D2BF826B87131A9179")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("3A3D89005EA946D2BF826B87131A9179");
        SessionInfo.setModuleId("7AE924E93FD044AEBF69D6D5F6C87F27");
        if (securedProcess || explicitAccess.contains("3A3D89005EA946D2BF826B87131A9179")) {
          classInfo.type = "P";
          classInfo.id = "3A3D89005EA946D2BF826B87131A9179";
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

     } else if (vars.commandIn("BUTTONAB_Process3A3D89005EA946D2BF826B87131A9179")) {
        vars.setSessionValue("button3A3D89005EA946D2BF826B87131A9179.strabProcess", vars.getStringParameter("inpabProcess"));
        vars.setSessionValue("button3A3D89005EA946D2BF826B87131A9179.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button3A3D89005EA946D2BF826B87131A9179.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button3A3D89005EA946D2BF826B87131A9179.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button3A3D89005EA946D2BF826B87131A9179.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "3A3D89005EA946D2BF826B87131A9179", request.getServletPath());    
     } else if (vars.commandIn("BUTTON3A3D89005EA946D2BF826B87131A9179")) {
        String strSprov_Period_ID = vars.getGlobalVariable("inpsprovPeriodId", windowId + "|Sprov_Period_ID", "");
        String strabProcess = vars.getSessionValue("button3A3D89005EA946D2BF826B87131A9179.strabProcess");
        String strProcessing = vars.getSessionValue("button3A3D89005EA946D2BF826B87131A9179.strProcessing");
        String strOrg = vars.getSessionValue("button3A3D89005EA946D2BF826B87131A9179.strOrg");
        String strClient = vars.getSessionValue("button3A3D89005EA946D2BF826B87131A9179.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonAB_Process3A3D89005EA946D2BF826B87131A9179(response, vars, strSprov_Period_ID, strabProcess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONAB_Process3A3D89005EA946D2BF826B87131A9179")) {
        String strSprov_Period_ID = vars.getGlobalVariable("inpKey", windowId + "|Sprov_Period_ID", "");
        String strabProcess = vars.getStringParameter("inpabProcess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "3A3D89005EA946D2BF826B87131A9179", (("Sprov_Period_ID".equalsIgnoreCase("AD_Language"))?"0":strSprov_Period_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonAB_Process3A3D89005EA946D2BF826B87131A9179(HttpServletResponse response, VariablesSecureApp vars, String strSprov_Period_ID, String strabProcess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3A3D89005EA946D2BF826B87131A9179");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/AB_Process3A3D89005EA946D2BF826B87131A9179", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSprov_Period_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Period0F86C42912C54E8FBECBC9BAC2594C3B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "3A3D89005EA946D2BF826B87131A9179");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("3A3D89005EA946D2BF826B87131A9179");
        vars.removeMessage("3A3D89005EA946D2BF826B87131A9179");
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
