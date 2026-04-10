
package org.openbravo.erpWindows.ec.com.sidesoft.payroll.overtime.AuthorizationOvertime;


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
public class AuthorizationOvertime518984C8DF7F4242BDF8EA3304B04247 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "C8D98A47570C4C98B235C7A74EAED0B5";
  private static final String tabId = "518984C8DF7F4242BDF8EA3304B04247";
  private static final int accesslevel = 3;
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
     
      if (command.contains("E34823D59A9E421FA1202276FA4441A4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E34823D59A9E421FA1202276FA4441A4");
        SessionInfo.setModuleId("7AE924E93FD044AEBF69D6D5F6C87F27");
        if (securedProcess || explicitAccess.contains("E34823D59A9E421FA1202276FA4441A4")) {
          classInfo.type = "P";
          classInfo.id = "E34823D59A9E421FA1202276FA4441A4";
        }
      }
     
      if (command.contains("8E4A34C060A14629B999848B9CBA124A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("8E4A34C060A14629B999848B9CBA124A");
        SessionInfo.setModuleId("7AE924E93FD044AEBF69D6D5F6C87F27");
        if (securedProcess || explicitAccess.contains("8E4A34C060A14629B999848B9CBA124A")) {
          classInfo.type = "P";
          classInfo.id = "8E4A34C060A14629B999848B9CBA124A";
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

     } else if (vars.commandIn("BUTTONLoad_BiometricE34823D59A9E421FA1202276FA4441A4")) {
        vars.setSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strloadBiometric", vars.getStringParameter("inploadBiometric"));
        vars.setSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE34823D59A9E421FA1202276FA4441A4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E34823D59A9E421FA1202276FA4441A4", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE34823D59A9E421FA1202276FA4441A4")) {
        String strSprov_Overtime_ID = vars.getGlobalVariable("inpsprovOvertimeId", windowId + "|Sprov_Overtime_ID", "");
        String strloadBiometric = vars.getSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strloadBiometric");
        String strProcessing = vars.getSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strProcessing");
        String strOrg = vars.getSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strOrg");
        String strClient = vars.getSessionValue("buttonE34823D59A9E421FA1202276FA4441A4.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_BiometricE34823D59A9E421FA1202276FA4441A4(response, vars, strSprov_Overtime_ID, strloadBiometric, strProcessing);
        }

     } else if (vars.commandIn("BUTTONAuthorization_Process8E4A34C060A14629B999848B9CBA124A")) {
        vars.setSessionValue("button8E4A34C060A14629B999848B9CBA124A.strauthorizationProcess", vars.getStringParameter("inpauthorizationProcess"));
        vars.setSessionValue("button8E4A34C060A14629B999848B9CBA124A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button8E4A34C060A14629B999848B9CBA124A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button8E4A34C060A14629B999848B9CBA124A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button8E4A34C060A14629B999848B9CBA124A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "8E4A34C060A14629B999848B9CBA124A", request.getServletPath());    
     } else if (vars.commandIn("BUTTON8E4A34C060A14629B999848B9CBA124A")) {
        String strSprov_Overtime_ID = vars.getGlobalVariable("inpsprovOvertimeId", windowId + "|Sprov_Overtime_ID", "");
        String strauthorizationProcess = vars.getSessionValue("button8E4A34C060A14629B999848B9CBA124A.strauthorizationProcess");
        String strProcessing = vars.getSessionValue("button8E4A34C060A14629B999848B9CBA124A.strProcessing");
        String strOrg = vars.getSessionValue("button8E4A34C060A14629B999848B9CBA124A.strOrg");
        String strClient = vars.getSessionValue("button8E4A34C060A14629B999848B9CBA124A.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonAuthorization_Process8E4A34C060A14629B999848B9CBA124A(response, vars, strSprov_Overtime_ID, strauthorizationProcess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_BiometricE34823D59A9E421FA1202276FA4441A4")) {
        String strSprov_Overtime_ID = vars.getGlobalVariable("inpKey", windowId + "|Sprov_Overtime_ID", "");
        String strloadBiometric = vars.getStringParameter("inploadBiometric");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E34823D59A9E421FA1202276FA4441A4", (("Sprov_Overtime_ID".equalsIgnoreCase("AD_Language"))?"0":strSprov_Overtime_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONAuthorization_Process8E4A34C060A14629B999848B9CBA124A")) {
        String strSprov_Overtime_ID = vars.getGlobalVariable("inpKey", windowId + "|Sprov_Overtime_ID", "");
        String strauthorizationProcess = vars.getStringParameter("inpauthorizationProcess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "8E4A34C060A14629B999848B9CBA124A", (("Sprov_Overtime_ID".equalsIgnoreCase("AD_Language"))?"0":strSprov_Overtime_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonLoad_BiometricE34823D59A9E421FA1202276FA4441A4(HttpServletResponse response, VariablesSecureApp vars, String strSprov_Overtime_ID, String strloadBiometric, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E34823D59A9E421FA1202276FA4441A4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_BiometricE34823D59A9E421FA1202276FA4441A4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSprov_Overtime_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AuthorizationOvertime518984C8DF7F4242BDF8EA3304B04247_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E34823D59A9E421FA1202276FA4441A4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E34823D59A9E421FA1202276FA4441A4");
        vars.removeMessage("E34823D59A9E421FA1202276FA4441A4");
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
    private void printPageButtonAuthorization_Process8E4A34C060A14629B999848B9CBA124A(HttpServletResponse response, VariablesSecureApp vars, String strSprov_Overtime_ID, String strauthorizationProcess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8E4A34C060A14629B999848B9CBA124A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Authorization_Process8E4A34C060A14629B999848B9CBA124A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSprov_Overtime_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AuthorizationOvertime518984C8DF7F4242BDF8EA3304B04247_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "8E4A34C060A14629B999848B9CBA124A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("8E4A34C060A14629B999848B9CBA124A");
        vars.removeMessage("8E4A34C060A14629B999848B9CBA124A");
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
