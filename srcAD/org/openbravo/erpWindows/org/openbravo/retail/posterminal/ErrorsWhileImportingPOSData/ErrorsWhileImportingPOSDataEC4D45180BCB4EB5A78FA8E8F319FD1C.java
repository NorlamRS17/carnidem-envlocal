
package org.openbravo.erpWindows.org.openbravo.retail.posterminal.ErrorsWhileImportingPOSData;


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
public class ErrorsWhileImportingPOSDataEC4D45180BCB4EB5A78FA8E8F319FD1C extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "B2738FA83B494AD08AE1660859C014A6";
  private static final String tabId = "EC4D45180BCB4EB5A78FA8E8F319FD1C";
  private static final int accesslevel = 3;
  private static final String moduleId = "FF808181326CC34901326D53DBCF0018";
  
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
     
      if (command.contains("3CFFB371836C4A2483CB5EA5A8B2CDC0")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("3CFFB371836C4A2483CB5EA5A8B2CDC0");
        SessionInfo.setModuleId("BF0C014A56FC47E5BB01AFAFCA666E22");
        if (securedProcess || explicitAccess.contains("3CFFB371836C4A2483CB5EA5A8B2CDC0")) {
          classInfo.type = "P";
          classInfo.id = "3CFFB371836C4A2483CB5EA5A8B2CDC0";
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

     } else if (vars.commandIn("BUTTONem_spobe_process_error3CFFB371836C4A2483CB5EA5A8B2CDC0")) {
        vars.setSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.stremSpobeProcessError", vars.getStringParameter("inpemSpobeProcessError"));
        vars.setSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button3CFFB371836C4A2483CB5EA5A8B2CDC0.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "3CFFB371836C4A2483CB5EA5A8B2CDC0", request.getServletPath());    
     } else if (vars.commandIn("BUTTON3CFFB371836C4A2483CB5EA5A8B2CDC0")) {
        String strObpos_Errors_ID = vars.getGlobalVariable("inpobposErrorsId", windowId + "|Obpos_Errors_ID", "");
        String stremSpobeProcessError = vars.getSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.stremSpobeProcessError");
        String strProcessing = vars.getSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.strProcessing");
        String strOrg = vars.getSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.strOrg");
        String strClient = vars.getSessionValue("button3CFFB371836C4A2483CB5EA5A8B2CDC0.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonem_spobe_process_error3CFFB371836C4A2483CB5EA5A8B2CDC0(response, vars, strObpos_Errors_ID, stremSpobeProcessError, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONem_spobe_process_error3CFFB371836C4A2483CB5EA5A8B2CDC0")) {
        String strObpos_Errors_ID = vars.getGlobalVariable("inpKey", windowId + "|Obpos_Errors_ID", "");
        String stremSpobeProcessError = vars.getStringParameter("inpemSpobeProcessError");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "3CFFB371836C4A2483CB5EA5A8B2CDC0", (("Obpos_Errors_ID".equalsIgnoreCase("AD_Language"))?"0":strObpos_Errors_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonem_spobe_process_error3CFFB371836C4A2483CB5EA5A8B2CDC0(HttpServletResponse response, VariablesSecureApp vars, String strObpos_Errors_ID, String stremSpobeProcessError, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3CFFB371836C4A2483CB5EA5A8B2CDC0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/em_spobe_process_error3CFFB371836C4A2483CB5EA5A8B2CDC0", discard).createXmlDocument();
      xmlDocument.setParameter("key", strObpos_Errors_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ErrorsWhileImportingPOSDataEC4D45180BCB4EB5A78FA8E8F319FD1C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "3CFFB371836C4A2483CB5EA5A8B2CDC0");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("3CFFB371836C4A2483CB5EA5A8B2CDC0");
        vars.removeMessage("3CFFB371836C4A2483CB5EA5A8B2CDC0");
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
