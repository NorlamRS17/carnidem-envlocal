
package org.openbravo.erpWindows.ec.com.sidesoft.modify.accounting.Modifyaccounting;


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
public class Header6945679594C24EFCA9CF4B52497A211B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D2B495DA0BD44182972765FFB47E469D";
  private static final String tabId = "6945679594C24EFCA9CF4B52497A211B";
  private static final int accesslevel = 3;
  private static final String moduleId = "074B02D5A9E0401BA1F5A060DDFCBAC2";
  
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
     
      if (command.contains("0EE943D0383E4212839AC55BBD2CFDCB")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("0EE943D0383E4212839AC55BBD2CFDCB");
        SessionInfo.setModuleId("074B02D5A9E0401BA1F5A060DDFCBAC2");
        if (securedProcess || explicitAccess.contains("0EE943D0383E4212839AC55BBD2CFDCB")) {
          classInfo.type = "P";
          classInfo.id = "0EE943D0383E4212839AC55BBD2CFDCB";
        }
      }
     
      if (command.contains("6790CE9EFB2C4438AF3904536DDA5EC6")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6790CE9EFB2C4438AF3904536DDA5EC6");
        SessionInfo.setModuleId("074B02D5A9E0401BA1F5A060DDFCBAC2");
        if (securedProcess || explicitAccess.contains("6790CE9EFB2C4438AF3904536DDA5EC6")) {
          classInfo.type = "P";
          classInfo.id = "6790CE9EFB2C4438AF3904536DDA5EC6";
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

     } else if (vars.commandIn("BUTTONLoad_Seat0EE943D0383E4212839AC55BBD2CFDCB")) {
        vars.setSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strloadSeat", vars.getStringParameter("inploadSeat"));
        vars.setSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0EE943D0383E4212839AC55BBD2CFDCB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0EE943D0383E4212839AC55BBD2CFDCB", request.getServletPath());    
     } else if (vars.commandIn("BUTTON0EE943D0383E4212839AC55BBD2CFDCB")) {
        String strSsmaact_Modify_Acct_ID = vars.getGlobalVariable("inpssmaactModifyAcctId", windowId + "|Ssmaact_Modify_Acct_ID", "");
        String strloadSeat = vars.getSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strloadSeat");
        String strProcessing = vars.getSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strProcessing");
        String strOrg = vars.getSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strOrg");
        String strClient = vars.getSessionValue("button0EE943D0383E4212839AC55BBD2CFDCB.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Seat0EE943D0383E4212839AC55BBD2CFDCB(response, vars, strSsmaact_Modify_Acct_ID, strloadSeat, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcess6790CE9EFB2C4438AF3904536DDA5EC6")) {
        vars.setSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6790CE9EFB2C4438AF3904536DDA5EC6.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6790CE9EFB2C4438AF3904536DDA5EC6", request.getServletPath());    
     } else if (vars.commandIn("BUTTON6790CE9EFB2C4438AF3904536DDA5EC6")) {
        String strSsmaact_Modify_Acct_ID = vars.getGlobalVariable("inpssmaactModifyAcctId", windowId + "|Ssmaact_Modify_Acct_ID", "");
        String strprocess = vars.getSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strprocess");
        String strProcessing = vars.getSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strProcessing");
        String strOrg = vars.getSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strOrg");
        String strClient = vars.getSessionValue("button6790CE9EFB2C4438AF3904536DDA5EC6.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess6790CE9EFB2C4438AF3904536DDA5EC6(response, vars, strSsmaact_Modify_Acct_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_Seat0EE943D0383E4212839AC55BBD2CFDCB")) {
        String strSsmaact_Modify_Acct_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssmaact_Modify_Acct_ID", "");
        String strloadSeat = vars.getStringParameter("inploadSeat");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "0EE943D0383E4212839AC55BBD2CFDCB", (("Ssmaact_Modify_Acct_ID".equalsIgnoreCase("AD_Language"))?"0":strSsmaact_Modify_Acct_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcess6790CE9EFB2C4438AF3904536DDA5EC6")) {
        String strSsmaact_Modify_Acct_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssmaact_Modify_Acct_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "6790CE9EFB2C4438AF3904536DDA5EC6", (("Ssmaact_Modify_Acct_ID".equalsIgnoreCase("AD_Language"))?"0":strSsmaact_Modify_Acct_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonLoad_Seat0EE943D0383E4212839AC55BBD2CFDCB(HttpServletResponse response, VariablesSecureApp vars, String strSsmaact_Modify_Acct_ID, String strloadSeat, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0EE943D0383E4212839AC55BBD2CFDCB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Seat0EE943D0383E4212839AC55BBD2CFDCB", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsmaact_Modify_Acct_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6945679594C24EFCA9CF4B52497A211B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "0EE943D0383E4212839AC55BBD2CFDCB");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("0EE943D0383E4212839AC55BBD2CFDCB");
        vars.removeMessage("0EE943D0383E4212839AC55BBD2CFDCB");
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
    private void printPageButtonProcess6790CE9EFB2C4438AF3904536DDA5EC6(HttpServletResponse response, VariablesSecureApp vars, String strSsmaact_Modify_Acct_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6790CE9EFB2C4438AF3904536DDA5EC6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process6790CE9EFB2C4438AF3904536DDA5EC6", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsmaact_Modify_Acct_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6945679594C24EFCA9CF4B52497A211B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6790CE9EFB2C4438AF3904536DDA5EC6");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6790CE9EFB2C4438AF3904536DDA5EC6");
        vars.removeMessage("6790CE9EFB2C4438AF3904536DDA5EC6");
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
