
package org.openbravo.erpWindows.com.atrums.indumot.supervision.OrdendeServicioConsolidacion;


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
public class OrdendeServicioA6937F30089E4334BC396D882666C1AB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "DBB32F2F3D0140CB8450D968D518FC33";
  private static final String tabId = "A6937F30089E4334BC396D882666C1AB";
  private static final int accesslevel = 3;
  private static final String moduleId = "F68F73D87DF84E869BB9DCBD92494F28";
  
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
     
      if (command.contains("E74903303FE742EA93A4FA456DB444EC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E74903303FE742EA93A4FA456DB444EC");
        SessionInfo.setModuleId("E11971CC540A4FC2BB683491128F1307");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("120616B644BA4FF6A1C9711D400DCD73")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("120616B644BA4FF6A1C9711D400DCD73");
        SessionInfo.setModuleId("F68F73D87DF84E869BB9DCBD92494F28");
        if (securedProcess || explicitAccess.contains("120616B644BA4FF6A1C9711D400DCD73")) {
          classInfo.type = "P";
          classInfo.id = "120616B644BA4FF6A1C9711D400DCD73";
        }
      }
     
      if (command.contains("2424CF6568194D99937D42D4A22B2B73")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("2424CF6568194D99937D42D4A22B2B73");
        SessionInfo.setModuleId("E11971CC540A4FC2BB683491128F1307");
        if (securedProcess || explicitAccess.contains("2424CF6568194D99937D42D4A22B2B73")) {
          classInfo.type = "P";
          classInfo.id = "2424CF6568194D99937D42D4A22B2B73";
        }
      }
     

     
      if (explicitAccess.contains("E74903303FE742EA93A4FA456DB444EC") || (securedProcess && command.contains("E74903303FE742EA93A4FA456DB444EC"))) {
        classInfo.type = "P";
        classInfo.id = "E74903303FE742EA93A4FA456DB444EC";
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

     } else if (vars.commandIn("BUTTONEM_Indsup_Valida120616B644BA4FF6A1C9711D400DCD73")) {
        vars.setSessionValue("button120616B644BA4FF6A1C9711D400DCD73.stremIndsupValida", vars.getStringParameter("inpemIndsupValida"));
        vars.setSessionValue("button120616B644BA4FF6A1C9711D400DCD73.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button120616B644BA4FF6A1C9711D400DCD73.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button120616B644BA4FF6A1C9711D400DCD73.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button120616B644BA4FF6A1C9711D400DCD73.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "120616B644BA4FF6A1C9711D400DCD73", request.getServletPath());    
     } else if (vars.commandIn("BUTTON120616B644BA4FF6A1C9711D400DCD73")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremIndsupValida = vars.getSessionValue("button120616B644BA4FF6A1C9711D400DCD73.stremIndsupValida");
        String strProcessing = vars.getSessionValue("button120616B644BA4FF6A1C9711D400DCD73.strProcessing");
        String strOrg = vars.getSessionValue("button120616B644BA4FF6A1C9711D400DCD73.strOrg");
        String strClient = vars.getSessionValue("button120616B644BA4FF6A1C9711D400DCD73.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Indsup_Valida120616B644BA4FF6A1C9711D400DCD73(response, vars, strAtindpo_Postventa_ID, stremIndsupValida, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sswos_Createorders2424CF6568194D99937D42D4A22B2B73")) {
        vars.setSessionValue("button2424CF6568194D99937D42D4A22B2B73.stremSswosCreateorders", vars.getStringParameter("inpemSswosCreateorders"));
        vars.setSessionValue("button2424CF6568194D99937D42D4A22B2B73.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button2424CF6568194D99937D42D4A22B2B73.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button2424CF6568194D99937D42D4A22B2B73.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button2424CF6568194D99937D42D4A22B2B73.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "2424CF6568194D99937D42D4A22B2B73", request.getServletPath());    
     } else if (vars.commandIn("BUTTON2424CF6568194D99937D42D4A22B2B73")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosCreateorders = vars.getSessionValue("button2424CF6568194D99937D42D4A22B2B73.stremSswosCreateorders");
        String strProcessing = vars.getSessionValue("button2424CF6568194D99937D42D4A22B2B73.strProcessing");
        String strOrg = vars.getSessionValue("button2424CF6568194D99937D42D4A22B2B73.strOrg");
        String strClient = vars.getSessionValue("button2424CF6568194D99937D42D4A22B2B73.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswos_Createorders2424CF6568194D99937D42D4A22B2B73(response, vars, strAtindpo_Postventa_ID, stremSswosCreateorders, strProcessing);
        }

    } else if (vars.commandIn("BUTTONEM_Sswos_LoadconsolE74903303FE742EA93A4FA456DB444EC")) {
        vars.setSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.stremSswosLoadconsol", vars.getStringParameter("inpemSswosLoadconsol"));
        vars.setSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE74903303FE742EA93A4FA456DB444EC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E74903303FE742EA93A4FA456DB444EC", request.getServletPath());
      } else if (vars.commandIn("BUTTONE74903303FE742EA93A4FA456DB444EC")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosLoadconsol = vars.getSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.stremSswosLoadconsol");
        String strProcessing = vars.getSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.strProcessing");
        String strOrg = vars.getSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.strOrg");
        String strClient = vars.getSessionValue("buttonE74903303FE742EA93A4FA456DB444EC.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswos_LoadconsolE74903303FE742EA93A4FA456DB444EC(response, vars, strAtindpo_Postventa_ID, stremSswosLoadconsol, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONEM_Indsup_Valida120616B644BA4FF6A1C9711D400DCD73")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        String stremIndsupValida = vars.getStringParameter("inpemIndsupValida");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "120616B644BA4FF6A1C9711D400DCD73", (("Atindpo_Postventa_ID".equalsIgnoreCase("AD_Language"))?"0":strAtindpo_Postventa_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sswos_Createorders2424CF6568194D99937D42D4A22B2B73")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosCreateorders = vars.getStringParameter("inpemSswosCreateorders");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "2424CF6568194D99937D42D4A22B2B73", (("Atindpo_Postventa_ID".equalsIgnoreCase("AD_Language"))?"0":strAtindpo_Postventa_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONEM_Sswos_LoadconsolE74903303FE742EA93A4FA456DB444EC")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        
        ProcessBundle pb = new ProcessBundle("E74903303FE742EA93A4FA456DB444EC", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Atindpo_Postventa_ID", strAtindpo_Postventa_ID);
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

    private void printPageButtonEM_Indsup_Valida120616B644BA4FF6A1C9711D400DCD73(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremIndsupValida, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 120616B644BA4FF6A1C9711D400DCD73");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Indsup_Valida120616B644BA4FF6A1C9711D400DCD73", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicioA6937F30089E4334BC396D882666C1AB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "120616B644BA4FF6A1C9711D400DCD73");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("120616B644BA4FF6A1C9711D400DCD73");
        vars.removeMessage("120616B644BA4FF6A1C9711D400DCD73");
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
    private void printPageButtonEM_Sswos_Createorders2424CF6568194D99937D42D4A22B2B73(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremSswosCreateorders, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2424CF6568194D99937D42D4A22B2B73");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswos_Createorders2424CF6568194D99937D42D4A22B2B73", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicioA6937F30089E4334BC396D882666C1AB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "2424CF6568194D99937D42D4A22B2B73");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("2424CF6568194D99937D42D4A22B2B73");
        vars.removeMessage("2424CF6568194D99937D42D4A22B2B73");
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


    void printPageButtonEM_Sswos_LoadconsolE74903303FE742EA93A4FA456DB444EC(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremSswosLoadconsol, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E74903303FE742EA93A4FA456DB444EC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswos_LoadconsolE74903303FE742EA93A4FA456DB444EC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicioA6937F30089E4334BC396D882666C1AB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E74903303FE742EA93A4FA456DB444EC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E74903303FE742EA93A4FA456DB444EC");
        vars.removeMessage("E74903303FE742EA93A4FA456DB444EC");
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
