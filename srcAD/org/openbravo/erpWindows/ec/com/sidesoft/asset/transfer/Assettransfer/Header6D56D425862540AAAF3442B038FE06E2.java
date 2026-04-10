
package org.openbravo.erpWindows.ec.com.sidesoft.asset.transfer.Assettransfer;


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
public class Header6D56D425862540AAAF3442B038FE06E2 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D3340A4CA0F449EEA0B52EF85D30A5CA";
  private static final String tabId = "6D56D425862540AAAF3442B038FE06E2";
  private static final int accesslevel = 3;
  private static final String moduleId = "80A9904D8A6F43B2A104906409C6B275";
  
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
     List<String> explicitAccess = Arrays.asList("E9381AB016084FADA10B79D43F33ABEC", "F95B664F1EB94336B6D1EE967D780196",  "");
    
     SessionInfo.setUserId(vars.getSessionValue("#AD_User_ID"));
     SessionInfo.setSessionId(vars.getSessionValue("#AD_Session_ID"));
     SessionInfo.setQueryProfile("manualProcess");
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("F95B664F1EB94336B6D1EE967D780196")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F95B664F1EB94336B6D1EE967D780196");
        SessionInfo.setModuleId("80A9904D8A6F43B2A104906409C6B275");
        if (securedProcess || explicitAccess.contains("F95B664F1EB94336B6D1EE967D780196")) {
          classInfo.type = "P";
          classInfo.id = "F95B664F1EB94336B6D1EE967D780196";
        }
      }
     
      if (command.contains("E9381AB016084FADA10B79D43F33ABEC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E9381AB016084FADA10B79D43F33ABEC");
        SessionInfo.setModuleId("80A9904D8A6F43B2A104906409C6B275");
        if (securedProcess || explicitAccess.contains("E9381AB016084FADA10B79D43F33ABEC")) {
          classInfo.type = "P";
          classInfo.id = "E9381AB016084FADA10B79D43F33ABEC";
        }
      }
     
      if (command.contains("F91FAFD33F7C420BB78BBEE85E2E9AF9")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F91FAFD33F7C420BB78BBEE85E2E9AF9");
        SessionInfo.setModuleId("80A9904D8A6F43B2A104906409C6B275");
        if (securedProcess || explicitAccess.contains("F91FAFD33F7C420BB78BBEE85E2E9AF9")) {
          classInfo.type = "P";
          classInfo.id = "F91FAFD33F7C420BB78BBEE85E2E9AF9";
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

     } else if (vars.commandIn("BUTTONLoadassetsF95B664F1EB94336B6D1EE967D780196")) {
        vars.setSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strloadassets", vars.getStringParameter("inploadassets"));
        vars.setSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF95B664F1EB94336B6D1EE967D780196.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F95B664F1EB94336B6D1EE967D780196", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF95B664F1EB94336B6D1EE967D780196")) {
        String strSsatr_Asset_Transfer_ID = vars.getGlobalVariable("inpssatrAssetTransferId", windowId + "|Ssatr_Asset_Transfer_ID", "");
        String strloadassets = vars.getSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strloadassets");
        String strProcessing = vars.getSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strProcessing");
        String strOrg = vars.getSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strOrg");
        String strClient = vars.getSessionValue("buttonF95B664F1EB94336B6D1EE967D780196.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoadassetsF95B664F1EB94336B6D1EE967D780196(response, vars, strSsatr_Asset_Transfer_ID, strloadassets, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessE9381AB016084FADA10B79D43F33ABEC")) {
        vars.setSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE9381AB016084FADA10B79D43F33ABEC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E9381AB016084FADA10B79D43F33ABEC", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE9381AB016084FADA10B79D43F33ABEC")) {
        String strSsatr_Asset_Transfer_ID = vars.getGlobalVariable("inpssatrAssetTransferId", windowId + "|Ssatr_Asset_Transfer_ID", "");
        String strprocess = vars.getSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strprocess");
        String strProcessing = vars.getSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strProcessing");
        String strOrg = vars.getSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strOrg");
        String strClient = vars.getSessionValue("buttonE9381AB016084FADA10B79D43F33ABEC.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessE9381AB016084FADA10B79D43F33ABEC(response, vars, strSsatr_Asset_Transfer_ID, strprocess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONSelect_AllF91FAFD33F7C420BB78BBEE85E2E9AF9")) {
        vars.setSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strselectAll", vars.getStringParameter("inpselectAll"));
        vars.setSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F91FAFD33F7C420BB78BBEE85E2E9AF9", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF91FAFD33F7C420BB78BBEE85E2E9AF9")) {
        String strSsatr_Asset_Transfer_ID = vars.getGlobalVariable("inpssatrAssetTransferId", windowId + "|Ssatr_Asset_Transfer_ID", "");
        String strselectAll = vars.getSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strselectAll");
        String strProcessing = vars.getSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strProcessing");
        String strOrg = vars.getSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strOrg");
        String strClient = vars.getSessionValue("buttonF91FAFD33F7C420BB78BBEE85E2E9AF9.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSelect_AllF91FAFD33F7C420BB78BBEE85E2E9AF9(response, vars, strSsatr_Asset_Transfer_ID, strselectAll, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoadassetsF95B664F1EB94336B6D1EE967D780196")) {
        String strSsatr_Asset_Transfer_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssatr_Asset_Transfer_ID", "");
        String strloadassets = vars.getStringParameter("inploadassets");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F95B664F1EB94336B6D1EE967D780196", (("Ssatr_Asset_Transfer_ID".equalsIgnoreCase("AD_Language"))?"0":strSsatr_Asset_Transfer_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessE9381AB016084FADA10B79D43F33ABEC")) {
        String strSsatr_Asset_Transfer_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssatr_Asset_Transfer_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E9381AB016084FADA10B79D43F33ABEC", (("Ssatr_Asset_Transfer_ID".equalsIgnoreCase("AD_Language"))?"0":strSsatr_Asset_Transfer_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONSelect_AllF91FAFD33F7C420BB78BBEE85E2E9AF9")) {
        String strSsatr_Asset_Transfer_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssatr_Asset_Transfer_ID", "");
        String strselectAll = vars.getStringParameter("inpselectAll");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F91FAFD33F7C420BB78BBEE85E2E9AF9", (("Ssatr_Asset_Transfer_ID".equalsIgnoreCase("AD_Language"))?"0":strSsatr_Asset_Transfer_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonLoadassetsF95B664F1EB94336B6D1EE967D780196(HttpServletResponse response, VariablesSecureApp vars, String strSsatr_Asset_Transfer_ID, String strloadassets, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F95B664F1EB94336B6D1EE967D780196");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/LoadassetsF95B664F1EB94336B6D1EE967D780196", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsatr_Asset_Transfer_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6D56D425862540AAAF3442B038FE06E2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F95B664F1EB94336B6D1EE967D780196");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F95B664F1EB94336B6D1EE967D780196");
        vars.removeMessage("F95B664F1EB94336B6D1EE967D780196");
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
    private void printPageButtonProcessE9381AB016084FADA10B79D43F33ABEC(HttpServletResponse response, VariablesSecureApp vars, String strSsatr_Asset_Transfer_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E9381AB016084FADA10B79D43F33ABEC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessE9381AB016084FADA10B79D43F33ABEC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsatr_Asset_Transfer_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6D56D425862540AAAF3442B038FE06E2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E9381AB016084FADA10B79D43F33ABEC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E9381AB016084FADA10B79D43F33ABEC");
        vars.removeMessage("E9381AB016084FADA10B79D43F33ABEC");
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
    private void printPageButtonSelect_AllF91FAFD33F7C420BB78BBEE85E2E9AF9(HttpServletResponse response, VariablesSecureApp vars, String strSsatr_Asset_Transfer_ID, String strselectAll, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F91FAFD33F7C420BB78BBEE85E2E9AF9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Select_AllF91FAFD33F7C420BB78BBEE85E2E9AF9", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsatr_Asset_Transfer_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6D56D425862540AAAF3442B038FE06E2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F91FAFD33F7C420BB78BBEE85E2E9AF9");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F91FAFD33F7C420BB78BBEE85E2E9AF9");
        vars.removeMessage("F91FAFD33F7C420BB78BBEE85E2E9AF9");
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
