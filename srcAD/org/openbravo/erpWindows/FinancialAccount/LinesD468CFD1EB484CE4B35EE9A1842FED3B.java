
package org.openbravo.erpWindows.FinancialAccount;


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
public class LinesD468CFD1EB484CE4B35EE9A1842FED3B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "94EAA455D2644E04AB25D93BE5157B6D";
  private static final String tabId = "D468CFD1EB484CE4B35EE9A1842FED3B";
  private static final int accesslevel = 3;
  private static final String moduleId = "63A731ECC8BD42B78352B4D2F7B1C31F";
  
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
     
      if (command.contains("C0FAC7FF73544432A5658C6F2EEC4339")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C0FAC7FF73544432A5658C6F2EEC4339");
        SessionInfo.setModuleId("63A731ECC8BD42B78352B4D2F7B1C31F");
        if (securedProcess || explicitAccess.contains("C0FAC7FF73544432A5658C6F2EEC4339")) {
          classInfo.type = "P";
          classInfo.id = "C0FAC7FF73544432A5658C6F2EEC4339";
        }
      }
     
      if (command.contains("002AF5FACD3C4C4383762804B8294339")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("002AF5FACD3C4C4383762804B8294339");
        SessionInfo.setModuleId("63A731ECC8BD42B78352B4D2F7B1C31F");
        if (securedProcess || explicitAccess.contains("002AF5FACD3C4C4383762804B8294339")) {
          classInfo.type = "P";
          classInfo.id = "002AF5FACD3C4C4383762804B8294339";
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

     } else if (vars.commandIn("BUTTONVoided_CheckbookC0FAC7FF73544432A5658C6F2EEC4339")) {
        vars.setSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strvoidedCheckbook", vars.getStringParameter("inpvoidedCheckbook"));
        vars.setSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC0FAC7FF73544432A5658C6F2EEC4339.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C0FAC7FF73544432A5658C6F2EEC4339", request.getServletPath());    
     } else if (vars.commandIn("BUTTONC0FAC7FF73544432A5658C6F2EEC4339")) {
        String strSlcb_Checkbookline_ID = vars.getGlobalVariable("inpslcbCheckbooklineId", windowId + "|Slcb_Checkbookline_ID", "");
        String strvoidedCheckbook = vars.getSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strvoidedCheckbook");
        String strProcessing = vars.getSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strProcessing");
        String strOrg = vars.getSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strOrg");
        String strClient = vars.getSessionValue("buttonC0FAC7FF73544432A5658C6F2EEC4339.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonVoided_CheckbookC0FAC7FF73544432A5658C6F2EEC4339(response, vars, strSlcb_Checkbookline_ID, strvoidedCheckbook, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactive_Check002AF5FACD3C4C4383762804B8294339")) {
        vars.setSessionValue("button002AF5FACD3C4C4383762804B8294339.strreactiveCheck", vars.getStringParameter("inpreactiveCheck"));
        vars.setSessionValue("button002AF5FACD3C4C4383762804B8294339.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button002AF5FACD3C4C4383762804B8294339.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button002AF5FACD3C4C4383762804B8294339.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button002AF5FACD3C4C4383762804B8294339.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "002AF5FACD3C4C4383762804B8294339", request.getServletPath());    
     } else if (vars.commandIn("BUTTON002AF5FACD3C4C4383762804B8294339")) {
        String strSlcb_Checkbookline_ID = vars.getGlobalVariable("inpslcbCheckbooklineId", windowId + "|Slcb_Checkbookline_ID", "");
        String strreactiveCheck = vars.getSessionValue("button002AF5FACD3C4C4383762804B8294339.strreactiveCheck");
        String strProcessing = vars.getSessionValue("button002AF5FACD3C4C4383762804B8294339.strProcessing");
        String strOrg = vars.getSessionValue("button002AF5FACD3C4C4383762804B8294339.strOrg");
        String strClient = vars.getSessionValue("button002AF5FACD3C4C4383762804B8294339.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactive_Check002AF5FACD3C4C4383762804B8294339(response, vars, strSlcb_Checkbookline_ID, strreactiveCheck, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONVoided_CheckbookC0FAC7FF73544432A5658C6F2EEC4339")) {
        String strSlcb_Checkbookline_ID = vars.getGlobalVariable("inpKey", windowId + "|Slcb_Checkbookline_ID", "");
        String strvoidedCheckbook = vars.getStringParameter("inpvoidedCheckbook");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "C0FAC7FF73544432A5658C6F2EEC4339", (("Slcb_Checkbookline_ID".equalsIgnoreCase("AD_Language"))?"0":strSlcb_Checkbookline_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReactive_Check002AF5FACD3C4C4383762804B8294339")) {
        String strSlcb_Checkbookline_ID = vars.getGlobalVariable("inpKey", windowId + "|Slcb_Checkbookline_ID", "");
        String strreactiveCheck = vars.getStringParameter("inpreactiveCheck");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "002AF5FACD3C4C4383762804B8294339", (("Slcb_Checkbookline_ID".equalsIgnoreCase("AD_Language"))?"0":strSlcb_Checkbookline_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonVoided_CheckbookC0FAC7FF73544432A5658C6F2EEC4339(HttpServletResponse response, VariablesSecureApp vars, String strSlcb_Checkbookline_ID, String strvoidedCheckbook, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C0FAC7FF73544432A5658C6F2EEC4339");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Voided_CheckbookC0FAC7FF73544432A5658C6F2EEC4339", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSlcb_Checkbookline_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "LinesD468CFD1EB484CE4B35EE9A1842FED3B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C0FAC7FF73544432A5658C6F2EEC4339");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C0FAC7FF73544432A5658C6F2EEC4339");
        vars.removeMessage("C0FAC7FF73544432A5658C6F2EEC4339");
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
    private void printPageButtonReactive_Check002AF5FACD3C4C4383762804B8294339(HttpServletResponse response, VariablesSecureApp vars, String strSlcb_Checkbookline_ID, String strreactiveCheck, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 002AF5FACD3C4C4383762804B8294339");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reactive_Check002AF5FACD3C4C4383762804B8294339", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSlcb_Checkbookline_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "LinesD468CFD1EB484CE4B35EE9A1842FED3B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "002AF5FACD3C4C4383762804B8294339");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("002AF5FACD3C4C4383762804B8294339");
        vars.removeMessage("002AF5FACD3C4C4383762804B8294339");
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
