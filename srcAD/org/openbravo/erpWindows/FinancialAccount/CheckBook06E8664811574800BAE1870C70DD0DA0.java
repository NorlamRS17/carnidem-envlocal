
package org.openbravo.erpWindows.FinancialAccount;


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
public class CheckBook06E8664811574800BAE1870C70DD0DA0 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "94EAA455D2644E04AB25D93BE5157B6D";
  private static final String tabId = "06E8664811574800BAE1870C70DD0DA0";
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
     
      if (command.contains("18492B172B4A49B4A20DAB85FE2AB82C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("18492B172B4A49B4A20DAB85FE2AB82C");
        SessionInfo.setModuleId("63A731ECC8BD42B78352B4D2F7B1C31F");
        if (securedProcess || explicitAccess.contains("18492B172B4A49B4A20DAB85FE2AB82C")) {
          classInfo.type = "P";
          classInfo.id = "18492B172B4A49B4A20DAB85FE2AB82C";
        }
      }
     
      if (command.contains("06F05C512CA74DE99C87E85CD6B4F2AB")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("06F05C512CA74DE99C87E85CD6B4F2AB");
        SessionInfo.setModuleId("63A731ECC8BD42B78352B4D2F7B1C31F");
        if (securedProcess || explicitAccess.contains("06F05C512CA74DE99C87E85CD6B4F2AB")) {
          classInfo.type = "P";
          classInfo.id = "06F05C512CA74DE99C87E85CD6B4F2AB";
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

     } else if (vars.commandIn("BUTTONCreated_Checkbook18492B172B4A49B4A20DAB85FE2AB82C")) {
        vars.setSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strcreatedCheckbook", vars.getStringParameter("inpcreatedCheckbook"));
        vars.setSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button18492B172B4A49B4A20DAB85FE2AB82C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "18492B172B4A49B4A20DAB85FE2AB82C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON18492B172B4A49B4A20DAB85FE2AB82C")) {
        String strSlcb_Checkbook_ID = vars.getGlobalVariable("inpslcbCheckbookId", windowId + "|Slcb_Checkbook_ID", "");
        String strcreatedCheckbook = vars.getSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strcreatedCheckbook");
        String strProcessing = vars.getSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strProcessing");
        String strOrg = vars.getSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strOrg");
        String strClient = vars.getSessionValue("button18492B172B4A49B4A20DAB85FE2AB82C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreated_Checkbook18492B172B4A49B4A20DAB85FE2AB82C(response, vars, strSlcb_Checkbook_ID, strcreatedCheckbook, strProcessing);
        }

     } else if (vars.commandIn("BUTTONVoid_Checkbook06F05C512CA74DE99C87E85CD6B4F2AB")) {
        vars.setSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strvoidCheckbook", vars.getStringParameter("inpvoidCheckbook"));
        vars.setSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button06F05C512CA74DE99C87E85CD6B4F2AB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "06F05C512CA74DE99C87E85CD6B4F2AB", request.getServletPath());    
     } else if (vars.commandIn("BUTTON06F05C512CA74DE99C87E85CD6B4F2AB")) {
        String strSlcb_Checkbook_ID = vars.getGlobalVariable("inpslcbCheckbookId", windowId + "|Slcb_Checkbook_ID", "");
        String strvoidCheckbook = vars.getSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strvoidCheckbook");
        String strProcessing = vars.getSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strProcessing");
        String strOrg = vars.getSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strOrg");
        String strClient = vars.getSessionValue("button06F05C512CA74DE99C87E85CD6B4F2AB.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonVoid_Checkbook06F05C512CA74DE99C87E85CD6B4F2AB(response, vars, strSlcb_Checkbook_ID, strvoidCheckbook, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONCreated_Checkbook18492B172B4A49B4A20DAB85FE2AB82C")) {
        String strSlcb_Checkbook_ID = vars.getGlobalVariable("inpKey", windowId + "|Slcb_Checkbook_ID", "");
        String strcreatedCheckbook = vars.getStringParameter("inpcreatedCheckbook");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "18492B172B4A49B4A20DAB85FE2AB82C", (("Slcb_Checkbook_ID".equalsIgnoreCase("AD_Language"))?"0":strSlcb_Checkbook_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONVoid_Checkbook06F05C512CA74DE99C87E85CD6B4F2AB")) {
        String strSlcb_Checkbook_ID = vars.getGlobalVariable("inpKey", windowId + "|Slcb_Checkbook_ID", "");
        String strvoidCheckbook = vars.getStringParameter("inpvoidCheckbook");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "06F05C512CA74DE99C87E85CD6B4F2AB", (("Slcb_Checkbook_ID".equalsIgnoreCase("AD_Language"))?"0":strSlcb_Checkbook_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonCreated_Checkbook18492B172B4A49B4A20DAB85FE2AB82C(HttpServletResponse response, VariablesSecureApp vars, String strSlcb_Checkbook_ID, String strcreatedCheckbook, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 18492B172B4A49B4A20DAB85FE2AB82C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Created_Checkbook18492B172B4A49B4A20DAB85FE2AB82C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSlcb_Checkbook_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "CheckBook06E8664811574800BAE1870C70DD0DA0_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "18492B172B4A49B4A20DAB85FE2AB82C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("18492B172B4A49B4A20DAB85FE2AB82C");
        vars.removeMessage("18492B172B4A49B4A20DAB85FE2AB82C");
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
    private void printPageButtonVoid_Checkbook06F05C512CA74DE99C87E85CD6B4F2AB(HttpServletResponse response, VariablesSecureApp vars, String strSlcb_Checkbook_ID, String strvoidCheckbook, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 06F05C512CA74DE99C87E85CD6B4F2AB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Void_Checkbook06F05C512CA74DE99C87E85CD6B4F2AB", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSlcb_Checkbook_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "CheckBook06E8664811574800BAE1870C70DD0DA0_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "06F05C512CA74DE99C87E85CD6B4F2AB");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("06F05C512CA74DE99C87E85CD6B4F2AB");
        vars.removeMessage("06F05C512CA74DE99C87E85CD6B4F2AB");
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
