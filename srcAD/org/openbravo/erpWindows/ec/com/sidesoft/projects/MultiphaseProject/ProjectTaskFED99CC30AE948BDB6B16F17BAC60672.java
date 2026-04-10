
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
public class ProjectTaskFED99CC30AE948BDB6B16F17BAC60672 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "AA0CC8D6014F439398795B49346E246C";
  private static final String tabId = "FED99CC30AE948BDB6B16F17BAC60672";
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
     
      if (command.contains("9C5952A764B54278877B6EC5C009743C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9C5952A764B54278877B6EC5C009743C");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("9C5952A764B54278877B6EC5C009743C")) {
          classInfo.type = "P";
          classInfo.id = "9C5952A764B54278877B6EC5C009743C";
        }
      }
     
      if (command.contains("1B97880F332644EA9FF171D736E65077")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1B97880F332644EA9FF171D736E65077");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("1B97880F332644EA9FF171D736E65077")) {
          classInfo.type = "P";
          classInfo.id = "1B97880F332644EA9FF171D736E65077";
        }
      }
     
      if (command.contains("F6B37A9B36A14F8ABF2D07515E2CEB99")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F6B37A9B36A14F8ABF2D07515E2CEB99");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("F6B37A9B36A14F8ABF2D07515E2CEB99")) {
          classInfo.type = "P";
          classInfo.id = "F6B37A9B36A14F8ABF2D07515E2CEB99";
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

     } else if (vars.commandIn("BUTTONEM_Sproctm_Create_Quotation9C5952A764B54278877B6EC5C009743C")) {
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.stremSproctmCreateQuotation", vars.getStringParameter("inpemSproctmCreateQuotation"));
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9C5952A764B54278877B6EC5C009743C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9C5952A764B54278877B6EC5C009743C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9C5952A764B54278877B6EC5C009743C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON9C5952A764B54278877B6EC5C009743C")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String stremSproctmCreateQuotation = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.stremSproctmCreateQuotation");
        String strProcessing = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.strProcessing");
        String strOrg = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.strOrg");
        String strClient = vars.getSessionValue("button9C5952A764B54278877B6EC5C009743C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sproctm_Create_Quotation9C5952A764B54278877B6EC5C009743C(response, vars, strC_ProjectTask_ID, stremSproctmCreateQuotation, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sproctm_Add_Requisition1B97880F332644EA9FF171D736E65077")) {
        vars.setSessionValue("button1B97880F332644EA9FF171D736E65077.stremSproctmAddRequisition", vars.getStringParameter("inpemSproctmAddRequisition"));
        vars.setSessionValue("button1B97880F332644EA9FF171D736E65077.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1B97880F332644EA9FF171D736E65077.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1B97880F332644EA9FF171D736E65077.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1B97880F332644EA9FF171D736E65077.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1B97880F332644EA9FF171D736E65077", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1B97880F332644EA9FF171D736E65077")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String stremSproctmAddRequisition = vars.getSessionValue("button1B97880F332644EA9FF171D736E65077.stremSproctmAddRequisition");
        String strProcessing = vars.getSessionValue("button1B97880F332644EA9FF171D736E65077.strProcessing");
        String strOrg = vars.getSessionValue("button1B97880F332644EA9FF171D736E65077.strOrg");
        String strClient = vars.getSessionValue("button1B97880F332644EA9FF171D736E65077.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sproctm_Add_Requisition1B97880F332644EA9FF171D736E65077(response, vars, strC_ProjectTask_ID, stremSproctmAddRequisition, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sproctm_Co_DetailsF6B37A9B36A14F8ABF2D07515E2CEB99")) {
        vars.setSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.stremSproctmCoDetails", vars.getStringParameter("inpemSproctmCoDetails"));
        vars.setSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F6B37A9B36A14F8ABF2D07515E2CEB99", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF6B37A9B36A14F8ABF2D07515E2CEB99")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpcProjecttaskId", windowId + "|C_ProjectTask_ID", "");
        String stremSproctmCoDetails = vars.getSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.stremSproctmCoDetails");
        String strProcessing = vars.getSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.strProcessing");
        String strOrg = vars.getSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.strOrg");
        String strClient = vars.getSessionValue("buttonF6B37A9B36A14F8ABF2D07515E2CEB99.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sproctm_Co_DetailsF6B37A9B36A14F8ABF2D07515E2CEB99(response, vars, strC_ProjectTask_ID, stremSproctmCoDetails, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Sproctm_Create_Quotation9C5952A764B54278877B6EC5C009743C")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        String stremSproctmCreateQuotation = vars.getStringParameter("inpemSproctmCreateQuotation");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "9C5952A764B54278877B6EC5C009743C", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sproctm_Add_Requisition1B97880F332644EA9FF171D736E65077")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        String stremSproctmAddRequisition = vars.getStringParameter("inpemSproctmAddRequisition");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1B97880F332644EA9FF171D736E65077", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strsproctmIncludeStock = vars.getStringParameter("inpsproctmIncludeStock", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "sproctm_include_stock", strsproctmIncludeStock, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sproctm_Co_DetailsF6B37A9B36A14F8ABF2D07515E2CEB99")) {
        String strC_ProjectTask_ID = vars.getGlobalVariable("inpKey", windowId + "|C_ProjectTask_ID", "");
        String stremSproctmCoDetails = vars.getStringParameter("inpemSproctmCoDetails");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F6B37A9B36A14F8ABF2D07515E2CEB99", (("C_ProjectTask_ID".equalsIgnoreCase("AD_Language"))?"0":strC_ProjectTask_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonEM_Sproctm_Create_Quotation9C5952A764B54278877B6EC5C009743C(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String stremSproctmCreateQuotation, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9C5952A764B54278877B6EC5C009743C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sproctm_Create_Quotation9C5952A764B54278877B6EC5C009743C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectTask_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectTaskFED99CC30AE948BDB6B16F17BAC60672_Edition.html");
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
    private void printPageButtonEM_Sproctm_Add_Requisition1B97880F332644EA9FF171D736E65077(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String stremSproctmAddRequisition, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1B97880F332644EA9FF171D736E65077");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sproctm_Add_Requisition1B97880F332644EA9FF171D736E65077", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectTask_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectTaskFED99CC30AE948BDB6B16F17BAC60672_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1B97880F332644EA9FF171D736E65077");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1B97880F332644EA9FF171D736E65077");
        vars.removeMessage("1B97880F332644EA9FF171D736E65077");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("sproctm_include_stock", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Sproctm_Co_DetailsF6B37A9B36A14F8ABF2D07515E2CEB99(HttpServletResponse response, VariablesSecureApp vars, String strC_ProjectTask_ID, String stremSproctmCoDetails, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F6B37A9B36A14F8ABF2D07515E2CEB99");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sproctm_Co_DetailsF6B37A9B36A14F8ABF2D07515E2CEB99", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_ProjectTask_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProjectTaskFED99CC30AE948BDB6B16F17BAC60672_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F6B37A9B36A14F8ABF2D07515E2CEB99");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F6B37A9B36A14F8ABF2D07515E2CEB99");
        vars.removeMessage("F6B37A9B36A14F8ABF2D07515E2CEB99");
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
