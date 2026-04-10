
package org.openbravo.erpWindows.ec.com.sidesoft.payment.in.transit.CollectionsinTransit;


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
public class Header34BAD5BD317D416AA1AF7567390AD7CE extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "0E6EE63BF58B4FACBFCA56E41C6164D8";
  private static final String tabId = "34BAD5BD317D416AA1AF7567390AD7CE";
  private static final int accesslevel = 7;
  private static final String moduleId = "76392D37250B4FEAAC7487BB1FAFDC45";
  
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
     
      if (command.contains("EFB77C124D6B422EA9D4BF423F880892")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("EFB77C124D6B422EA9D4BF423F880892");
        SessionInfo.setModuleId("76392D37250B4FEAAC7487BB1FAFDC45");
        if (securedProcess || explicitAccess.contains("EFB77C124D6B422EA9D4BF423F880892")) {
          classInfo.type = "P";
          classInfo.id = "EFB77C124D6B422EA9D4BF423F880892";
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

     } else if (vars.commandIn("BUTTONSspitra_Collection_UnlinkEFB77C124D6B422EA9D4BF423F880892")) {
        vars.setSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strsspitraCollectionUnlink", vars.getStringParameter("inpsspitraCollectionUnlink"));
        vars.setSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEFB77C124D6B422EA9D4BF423F880892.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EFB77C124D6B422EA9D4BF423F880892", request.getServletPath());    
     } else if (vars.commandIn("BUTTONEFB77C124D6B422EA9D4BF423F880892")) {
        String strSspitra_Collectiontransit_ID = vars.getGlobalVariable("inpsspitraCollectiontransitId", windowId + "|Sspitra_Collectiontransit_ID", "");
        String strsspitraCollectionUnlink = vars.getSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strsspitraCollectionUnlink");
        String strProcessing = vars.getSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strProcessing");
        String strOrg = vars.getSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strOrg");
        String strClient = vars.getSessionValue("buttonEFB77C124D6B422EA9D4BF423F880892.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSspitra_Collection_UnlinkEFB77C124D6B422EA9D4BF423F880892(response, vars, strSspitra_Collectiontransit_ID, strsspitraCollectionUnlink, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONSspitra_Collection_UnlinkEFB77C124D6B422EA9D4BF423F880892")) {
        String strSspitra_Collectiontransit_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspitra_Collectiontransit_ID", "");
        String strsspitraCollectionUnlink = vars.getStringParameter("inpsspitraCollectionUnlink");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "EFB77C124D6B422EA9D4BF423F880892", (("Sspitra_Collectiontransit_ID".equalsIgnoreCase("AD_Language"))?"0":strSspitra_Collectiontransit_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonSspitra_Collection_UnlinkEFB77C124D6B422EA9D4BF423F880892(HttpServletResponse response, VariablesSecureApp vars, String strSspitra_Collectiontransit_ID, String strsspitraCollectionUnlink, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EFB77C124D6B422EA9D4BF423F880892");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Sspitra_Collection_UnlinkEFB77C124D6B422EA9D4BF423F880892", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspitra_Collectiontransit_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header34BAD5BD317D416AA1AF7567390AD7CE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "EFB77C124D6B422EA9D4BF423F880892");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("EFB77C124D6B422EA9D4BF423F880892");
        vars.removeMessage("EFB77C124D6B422EA9D4BF423F880892");
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
