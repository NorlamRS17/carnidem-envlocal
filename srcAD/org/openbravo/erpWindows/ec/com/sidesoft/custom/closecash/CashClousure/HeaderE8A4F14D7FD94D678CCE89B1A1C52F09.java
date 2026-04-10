
package org.openbravo.erpWindows.ec.com.sidesoft.custom.closecash.CashClousure;


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
public class HeaderE8A4F14D7FD94D678CCE89B1A1C52F09 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "67C3F5060FE3451681828B742B3715A2";
  private static final String tabId = "E8A4F14D7FD94D678CCE89B1A1C52F09";
  private static final int accesslevel = 3;
  private static final String moduleId = "33CB6D19B98240F287A577849270CF71";
  
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
     
      if (command.contains("D4A48C4B587C4555B8D2293C1B7FB218")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D4A48C4B587C4555B8D2293C1B7FB218");
        SessionInfo.setModuleId("C2ED8668825D460B9B6F38BD42FA4806");
        if (securedProcess || explicitAccess.contains("D4A48C4B587C4555B8D2293C1B7FB218")) {
          classInfo.type = "P";
          classInfo.id = "D4A48C4B587C4555B8D2293C1B7FB218";
        }
      }
     
      if (command.contains("C3E415F0DCDC4792AAC46C6F74883190")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C3E415F0DCDC4792AAC46C6F74883190");
        SessionInfo.setModuleId("C2ED8668825D460B9B6F38BD42FA4806");
        if (securedProcess || explicitAccess.contains("C3E415F0DCDC4792AAC46C6F74883190")) {
          classInfo.type = "P";
          classInfo.id = "C3E415F0DCDC4792AAC46C6F74883190";
        }
      }
     
      if (command.contains("5BA898DDB64D455D8656C0F60E445E43")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5BA898DDB64D455D8656C0F60E445E43");
        SessionInfo.setModuleId("C2ED8668825D460B9B6F38BD42FA4806");
        if (securedProcess || explicitAccess.contains("5BA898DDB64D455D8656C0F60E445E43")) {
          classInfo.type = "P";
          classInfo.id = "5BA898DDB64D455D8656C0F60E445E43";
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

     } else if (vars.commandIn("BUTTONLoadlinesD4A48C4B587C4555B8D2293C1B7FB218")) {
        vars.setSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strloadlines", vars.getStringParameter("inploadlines"));
        vars.setSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD4A48C4B587C4555B8D2293C1B7FB218.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D4A48C4B587C4555B8D2293C1B7FB218", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND4A48C4B587C4555B8D2293C1B7FB218")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpscccCashClousureId", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strloadlines = vars.getSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strloadlines");
        String strProcessing = vars.getSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strProcessing");
        String strOrg = vars.getSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strOrg");
        String strClient = vars.getSessionValue("buttonD4A48C4B587C4555B8D2293C1B7FB218.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoadlinesD4A48C4B587C4555B8D2293C1B7FB218(response, vars, strSccc_Cash_Clousure_ID, strloadlines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONRecordC3E415F0DCDC4792AAC46C6F74883190")) {
        vars.setSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strrecord", vars.getStringParameter("inprecord"));
        vars.setSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC3E415F0DCDC4792AAC46C6F74883190.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C3E415F0DCDC4792AAC46C6F74883190", request.getServletPath());    
     } else if (vars.commandIn("BUTTONC3E415F0DCDC4792AAC46C6F74883190")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpscccCashClousureId", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strrecord = vars.getSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strrecord");
        String strProcessing = vars.getSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strProcessing");
        String strOrg = vars.getSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strOrg");
        String strClient = vars.getSessionValue("buttonC3E415F0DCDC4792AAC46C6F74883190.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonRecordC3E415F0DCDC4792AAC46C6F74883190(response, vars, strSccc_Cash_Clousure_ID, strrecord, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sscccin_Toggledocstatus5BA898DDB64D455D8656C0F60E445E43")) {
        vars.setSessionValue("button5BA898DDB64D455D8656C0F60E445E43.stremSscccinToggledocstatus", vars.getStringParameter("inpemSscccinToggledocstatus"));
        vars.setSessionValue("button5BA898DDB64D455D8656C0F60E445E43.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5BA898DDB64D455D8656C0F60E445E43.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5BA898DDB64D455D8656C0F60E445E43.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5BA898DDB64D455D8656C0F60E445E43.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5BA898DDB64D455D8656C0F60E445E43", request.getServletPath());    
     } else if (vars.commandIn("BUTTON5BA898DDB64D455D8656C0F60E445E43")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpscccCashClousureId", windowId + "|Sccc_Cash_Clousure_ID", "");
        String stremSscccinToggledocstatus = vars.getSessionValue("button5BA898DDB64D455D8656C0F60E445E43.stremSscccinToggledocstatus");
        String strProcessing = vars.getSessionValue("button5BA898DDB64D455D8656C0F60E445E43.strProcessing");
        String strOrg = vars.getSessionValue("button5BA898DDB64D455D8656C0F60E445E43.strOrg");
        String strClient = vars.getSessionValue("button5BA898DDB64D455D8656C0F60E445E43.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sscccin_Toggledocstatus5BA898DDB64D455D8656C0F60E445E43(response, vars, strSccc_Cash_Clousure_ID, stremSscccinToggledocstatus, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoadlinesD4A48C4B587C4555B8D2293C1B7FB218")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpKey", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strloadlines = vars.getStringParameter("inploadlines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D4A48C4B587C4555B8D2293C1B7FB218", (("Sccc_Cash_Clousure_ID".equalsIgnoreCase("AD_Language"))?"0":strSccc_Cash_Clousure_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONRecordC3E415F0DCDC4792AAC46C6F74883190")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpKey", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strrecord = vars.getStringParameter("inprecord");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "C3E415F0DCDC4792AAC46C6F74883190", (("Sccc_Cash_Clousure_ID".equalsIgnoreCase("AD_Language"))?"0":strSccc_Cash_Clousure_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sscccin_Toggledocstatus5BA898DDB64D455D8656C0F60E445E43")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpKey", windowId + "|Sccc_Cash_Clousure_ID", "");
        String stremSscccinToggledocstatus = vars.getStringParameter("inpemSscccinToggledocstatus");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "5BA898DDB64D455D8656C0F60E445E43", (("Sccc_Cash_Clousure_ID".equalsIgnoreCase("AD_Language"))?"0":strSccc_Cash_Clousure_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonLoadlinesD4A48C4B587C4555B8D2293C1B7FB218(HttpServletResponse response, VariablesSecureApp vars, String strSccc_Cash_Clousure_ID, String strloadlines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D4A48C4B587C4555B8D2293C1B7FB218");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/LoadlinesD4A48C4B587C4555B8D2293C1B7FB218", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSccc_Cash_Clousure_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderE8A4F14D7FD94D678CCE89B1A1C52F09_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D4A48C4B587C4555B8D2293C1B7FB218");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D4A48C4B587C4555B8D2293C1B7FB218");
        vars.removeMessage("D4A48C4B587C4555B8D2293C1B7FB218");
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
    private void printPageButtonRecordC3E415F0DCDC4792AAC46C6F74883190(HttpServletResponse response, VariablesSecureApp vars, String strSccc_Cash_Clousure_ID, String strrecord, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C3E415F0DCDC4792AAC46C6F74883190");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/RecordC3E415F0DCDC4792AAC46C6F74883190", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSccc_Cash_Clousure_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderE8A4F14D7FD94D678CCE89B1A1C52F09_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C3E415F0DCDC4792AAC46C6F74883190");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C3E415F0DCDC4792AAC46C6F74883190");
        vars.removeMessage("C3E415F0DCDC4792AAC46C6F74883190");
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
    private void printPageButtonEM_Sscccin_Toggledocstatus5BA898DDB64D455D8656C0F60E445E43(HttpServletResponse response, VariablesSecureApp vars, String strSccc_Cash_Clousure_ID, String stremSscccinToggledocstatus, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5BA898DDB64D455D8656C0F60E445E43");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sscccin_Toggledocstatus5BA898DDB64D455D8656C0F60E445E43", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSccc_Cash_Clousure_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderE8A4F14D7FD94D678CCE89B1A1C52F09_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5BA898DDB64D455D8656C0F60E445E43");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5BA898DDB64D455D8656C0F60E445E43");
        vars.removeMessage("5BA898DDB64D455D8656C0F60E445E43");
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
