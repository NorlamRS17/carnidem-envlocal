
package org.openbravo.erpWindows.ec.com.sidesoft.projects.MultiphaseProject;


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
public class ProjectPhase64D8B587C12849CAA8003181F27C4D8D extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "AA0CC8D6014F439398795B49346E246C";
  private static final String tabId = "64D8B587C12849CAA8003181F27C4D8D";
  private static final int accesslevel = 1;
  private static final String moduleId = "1729A89A48434A0893CCC71135984121";
  
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
     
      if (command.contains("216")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("216");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("216")) {
          classInfo.type = "P";
          classInfo.id = "216";
        }
      }
     
      if (command.contains("9C5952A764B54278877B6EC5C009743C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9C5952A764B54278877B6EC5C009743C");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("9C5952A764B54278877B6EC5C009743C")) {
          classInfo.type = "P";
          classInfo.id = "9C5952A764B54278877B6EC5C009743C";
        }
      }
     
      if (command.contains("30DA204D11ED4D129FE2956C5799FECB")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("30DA204D11ED4D129FE2956C5799FECB");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("30DA204D11ED4D129FE2956C5799FECB")) {
          classInfo.type = "P";
          classInfo.id = "30DA204D11ED4D129FE2956C5799FECB";
        }
      }
     
      if (command.contains("6400AD0123EA4FD8A8108CB4F26FEF02")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6400AD0123EA4FD8A8108CB4F26FEF02");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("6400AD0123EA4FD8A8108CB4F26FEF02")) {
          classInfo.type = "P";
          classInfo.id = "6400AD0123EA4FD8A8108CB4F26FEF02";
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

     } else if (vars.commandIn("BUTTONGenerateOrder216")) {
        vars.setSessionValue("button216.strgenerateorder", vars.getStringParameter("inpgenerateorder"));
        vars.setSessionValue("button216.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button216.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button216.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button216.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "216", request.getServletPath());    
     } else if (vars.commandIn("BUTTON216")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpcProjectphaseId", windowId + "|C_ProjectPhase_ID", "");
        String strgenerateorder = vars.getSessionValue("button216.strgenerateorder");
        String strProcessing = vars.getSessionValue("button216.strProcessing");
        String strOrg = vars.getSessionValue("button216.strOrg");
        String strClient = vars.getSessionValue("button216.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGenerateOrder216(response, vars, strC_ProjectPhase_ID, strgenerateorder, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sproctm_Create_Quot9C5952A764B54278877B6EC5C009743C")) {
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.stremSproctmCreateQuot", vars.getStringParameter("inpemSproctmCreateQuot"));
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9C5952A764B54278877B6EC5C009743C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9C5952A764B54278877B6EC5C009743C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON9C5952A764B54278877B6EC5C009743C")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpcProjectphaseId", windowId + "|C_ProjectPhase_ID", "");
        String stremSproctmCreateQuot = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.stremSproctmCreateQuot");
        String strProcessing = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.strProcessing");
        String strOrg = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.strOrg");
        String strClient = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sproctm_Create_Quot9C5952A764B54278877B6EC5C009743C(response, vars, strC_ProjectPhase_ID, stremSproctmCreateQuot, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sproctm_Asigned_Ce30DA204D11ED4D129FE2956C5799FECB")) {
        vars.setSessionValue("button30DA204D11ED4D129FE2956C5799FECB.stremSproctmAsignedCe", vars.getStringParameter("inpemSproctmAsignedCe"));
        vars.setSessionValue("button30DA204D11ED4D129FE2956C5799FECB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button30DA204D11ED4D129FE2956C5799FECB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button30DA204D11ED4D129FE2956C5799FECB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button30DA204D11ED4D129FE2956C5799FECB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "30DA204D11ED4D129FE2956C5799FECB", request.getServletPath());    
     } else if (vars.commandIn("BUTTON30DA204D11ED4D129FE2956C5799FECB")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpcProjectphaseId", windowId + "|C_ProjectPhase_ID", "");
        String stremSproctmAsignedCe = vars.getSessionValue("button30DA204D11ED4D129FE2956C5799FECB.stremSproctmAsignedCe");
        String strProcessing = vars.getSessionValue("button30DA204D11ED4D129FE2956C5799FECB.strProcessing");
        String strOrg = vars.getSessionValue("button30DA204D11ED4D129FE2956C5799FECB.strOrg");
        String strClient = vars.getSessionValue("button30DA204D11ED4D129FE2956C5799FECB.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sproctm_Asigned_Ce30DA204D11ED4D129FE2956C5799FECB(response, vars, strC_ProjectPhase_ID, stremSproctmAsignedCe, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sproctm_Phase_Execute6400AD0123EA4FD8A8108CB4F26FEF02")) {
        vars.setSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.stremSproctmPhaseExecute", vars.getStringParameter("inpemSproctmPhaseExecute"));
        vars.setSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6400AD0123EA4FD8A8108CB4F26FEF02.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6400AD0123EA4FD8A8108CB4F26FEF02", request.getServletPath());    
     } else if (vars.commandIn("BUTTON6400AD0123EA4FD8A8108CB4F26FEF02")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpcProjectphaseId", windowId + "|C_ProjectPhase_ID", "");
        String stremSproctmPhaseExecute = vars.getSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.stremSproctmPhaseExecute");
        String strProcessing = vars.getSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.strProcessing");
        String strOrg = vars.getSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.strOrg");
        String strClient = vars.getSessionValue("button6400AD0123EA4FD8A8108CB4F26FEF02.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sproctm_Phase_Execute6400AD0123EA4FD8A8108CB4F26FEF02(response, vars, strC_ProjectPhase_ID, stremSproctmPhaseExecute, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONGenerateOrder216")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectPhase_ID", "");
        String strgenerateorder = vars.getStringParameter("inpgenerateorder");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "216", (("C_ProjectPhase_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectPhase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sproctm_Create_Quot9C5952A764B54278877B6EC5C009743C")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectPhase_ID", "");
        String stremSproctmCreateQuot = vars.getStringParameter("inpemSproctmCreateQuot");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "9C5952A764B54278877B6EC5C009743C", (("C_ProjectPhase_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectPhase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsproctmUpdateQuotation = vars.getStringParameter("inpsproctmUpdateQuotation", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "sproctm_update_quotation", strsproctmUpdateQuotation, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sproctm_Asigned_Ce30DA204D11ED4D129FE2956C5799FECB")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectPhase_ID", "");
        String stremSproctmAsignedCe = vars.getStringParameter("inpemSproctmAsignedCe");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "30DA204D11ED4D129FE2956C5799FECB", (("C_ProjectPhase_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectPhase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sproctm_Phase_Execute6400AD0123EA4FD8A8108CB4F26FEF02")) {
        String strC_ProjectPhase_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectPhase_ID", "");
        String stremSproctmPhaseExecute = vars.getStringParameter("inpemSproctmPhaseExecute");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "6400AD0123EA4FD8A8108CB4F26FEF02", (("C_ProjectPhase_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectPhase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonGenerateOrder216(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectPhase_ID, String strgenerateorder, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 216");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/GenerateOrder216", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectPhase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectPhase64D8B587C12849CAA8003181F27C4D8D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "216");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("216");
        vars.removeMessage("216");
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
    private void printPageButtonEM_Sproctm_Create_Quot9C5952A764B54278877B6EC5C009743C(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectPhase_ID, String stremSproctmCreateQuot, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9C5952A764B54278877B6EC5C009743C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sproctm_Create_Quot9C5952A764B54278877B6EC5C009743C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectPhase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectPhase64D8B587C12849CAA8003181F27C4D8D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "9C5952A764B54278877B6EC5C009743C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("9C5952A764B54278877B6EC5C009743C");
        vars.removeMessage("9C5952A764B54278877B6EC5C009743C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("sproctm_update_quotation", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Sproctm_Asigned_Ce30DA204D11ED4D129FE2956C5799FECB(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectPhase_ID, String stremSproctmAsignedCe, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 30DA204D11ED4D129FE2956C5799FECB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sproctm_Asigned_Ce30DA204D11ED4D129FE2956C5799FECB", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectPhase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectPhase64D8B587C12849CAA8003181F27C4D8D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "30DA204D11ED4D129FE2956C5799FECB");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("30DA204D11ED4D129FE2956C5799FECB");
        vars.removeMessage("30DA204D11ED4D129FE2956C5799FECB");
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
    private void printPageButtonEM_Sproctm_Phase_Execute6400AD0123EA4FD8A8108CB4F26FEF02(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectPhase_ID, String stremSproctmPhaseExecute, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6400AD0123EA4FD8A8108CB4F26FEF02");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sproctm_Phase_Execute6400AD0123EA4FD8A8108CB4F26FEF02", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectPhase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectPhase64D8B587C12849CAA8003181F27C4D8D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6400AD0123EA4FD8A8108CB4F26FEF02");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6400AD0123EA4FD8A8108CB4F26FEF02");
        vars.removeMessage("6400AD0123EA4FD8A8108CB4F26FEF02");
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
