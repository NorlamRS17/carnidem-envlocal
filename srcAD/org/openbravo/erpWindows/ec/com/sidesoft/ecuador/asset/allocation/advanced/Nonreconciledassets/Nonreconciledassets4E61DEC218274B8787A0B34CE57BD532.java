
package org.openbravo.erpWindows.ec.com.sidesoft.ecuador.asset.allocation.advanced.Nonreconciledassets;


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
public class Nonreconciledassets4E61DEC218274B8787A0B34CE57BD532 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "2A1F25A6D07E4938891F9872132AFB0B";
  private static final String tabId = "4E61DEC218274B8787A0B34CE57BD532";
  private static final int accesslevel = 3;
  private static final String moduleId = "7F0DB9796E67424FA7B0256FC0FDEC87";
  
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
     
      if (command.contains("B4747157613C4A15A25752C3F21D4181")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B4747157613C4A15A25752C3F21D4181");
        SessionInfo.setModuleId("7F0DB9796E67424FA7B0256FC0FDEC87");
        if (securedProcess || explicitAccess.contains("B4747157613C4A15A25752C3F21D4181")) {
          classInfo.type = "P";
          classInfo.id = "B4747157613C4A15A25752C3F21D4181";
        }
      }
     
      if (command.contains("260BCA892062442687CEDF0825616F44")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("260BCA892062442687CEDF0825616F44");
        SessionInfo.setModuleId("7F0DB9796E67424FA7B0256FC0FDEC87");
        if (securedProcess || explicitAccess.contains("260BCA892062442687CEDF0825616F44")) {
          classInfo.type = "P";
          classInfo.id = "260BCA892062442687CEDF0825616F44";
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

     } else if (vars.commandIn("BUTTONProcessedB4747157613C4A15A25752C3F21D4181")) {
        vars.setSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB4747157613C4A15A25752C3F21D4181.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B4747157613C4A15A25752C3F21D4181", request.getServletPath());    
     } else if (vars.commandIn("BUTTONB4747157613C4A15A25752C3F21D4181")) {
        String strCsaaa_Custodian_ID = vars.getGlobalVariable("inpcsaaaCustodianId", windowId + "|Csaaa_Custodian_ID", "");
        String strprocessed = vars.getSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strprocessed");
        String strProcessing = vars.getSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strProcessing");
        String strOrg = vars.getSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strOrg");
        String strClient = vars.getSessionValue("buttonB4747157613C4A15A25752C3F21D4181.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedB4747157613C4A15A25752C3F21D4181(response, vars, strCsaaa_Custodian_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONLoadlines260BCA892062442687CEDF0825616F44")) {
        vars.setSessionValue("button260BCA892062442687CEDF0825616F44.strloadlines", vars.getStringParameter("inploadlines"));
        vars.setSessionValue("button260BCA892062442687CEDF0825616F44.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button260BCA892062442687CEDF0825616F44.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button260BCA892062442687CEDF0825616F44.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button260BCA892062442687CEDF0825616F44.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "260BCA892062442687CEDF0825616F44", request.getServletPath());    
     } else if (vars.commandIn("BUTTON260BCA892062442687CEDF0825616F44")) {
        String strCsaaa_Custodian_ID = vars.getGlobalVariable("inpcsaaaCustodianId", windowId + "|Csaaa_Custodian_ID", "");
        String strloadlines = vars.getSessionValue("button260BCA892062442687CEDF0825616F44.strloadlines");
        String strProcessing = vars.getSessionValue("button260BCA892062442687CEDF0825616F44.strProcessing");
        String strOrg = vars.getSessionValue("button260BCA892062442687CEDF0825616F44.strOrg");
        String strClient = vars.getSessionValue("button260BCA892062442687CEDF0825616F44.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoadlines260BCA892062442687CEDF0825616F44(response, vars, strCsaaa_Custodian_ID, strloadlines, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessedB4747157613C4A15A25752C3F21D4181")) {
        String strCsaaa_Custodian_ID = vars.getGlobalVariable("inpKey", windowId + "|Csaaa_Custodian_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "B4747157613C4A15A25752C3F21D4181", (("Csaaa_Custodian_ID".equalsIgnoreCase("AD_Language"))?"0":strCsaaa_Custodian_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONLoadlines260BCA892062442687CEDF0825616F44")) {
        String strCsaaa_Custodian_ID = vars.getGlobalVariable("inpKey", windowId + "|Csaaa_Custodian_ID", "");
        String strloadlines = vars.getStringParameter("inploadlines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "260BCA892062442687CEDF0825616F44", (("Csaaa_Custodian_ID".equalsIgnoreCase("AD_Language"))?"0":strCsaaa_Custodian_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcessedB4747157613C4A15A25752C3F21D4181(HttpServletResponse response, VariablesSecureApp vars, String strCsaaa_Custodian_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B4747157613C4A15A25752C3F21D4181");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedB4747157613C4A15A25752C3F21D4181", discard).createXmlDocument();
      xmlDocument.setParameter("key", strCsaaa_Custodian_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Nonreconciledassets4E61DEC218274B8787A0B34CE57BD532_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B4747157613C4A15A25752C3F21D4181");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B4747157613C4A15A25752C3F21D4181");
        vars.removeMessage("B4747157613C4A15A25752C3F21D4181");
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
    private void printPageButtonLoadlines260BCA892062442687CEDF0825616F44(HttpServletResponse response, VariablesSecureApp vars, String strCsaaa_Custodian_ID, String strloadlines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 260BCA892062442687CEDF0825616F44");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Loadlines260BCA892062442687CEDF0825616F44", discard).createXmlDocument();
      xmlDocument.setParameter("key", strCsaaa_Custodian_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Nonreconciledassets4E61DEC218274B8787A0B34CE57BD532_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "260BCA892062442687CEDF0825616F44");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("260BCA892062442687CEDF0825616F44");
        vars.removeMessage("260BCA892062442687CEDF0825616F44");
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
