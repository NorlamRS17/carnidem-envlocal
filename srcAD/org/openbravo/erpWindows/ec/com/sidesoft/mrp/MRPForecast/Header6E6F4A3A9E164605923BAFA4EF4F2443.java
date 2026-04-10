
package org.openbravo.erpWindows.ec.com.sidesoft.mrp.MRPForecast;


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
public class Header6E6F4A3A9E164605923BAFA4EF4F2443 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "B70C60CE6A834548892F8677A02372F1";
  private static final String tabId = "6E6F4A3A9E164605923BAFA4EF4F2443";
  private static final int accesslevel = 3;
  private static final String moduleId = "BCDA989719C148D782867D738F70DA8D";
  
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
     
      if (command.contains("940272ED78B04340938C529D6C02D162")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("940272ED78B04340938C529D6C02D162");
        SessionInfo.setModuleId("A48E76A5BE664C7E9FDC21C9A8FC4F90");
        if (securedProcess || explicitAccess.contains("940272ED78B04340938C529D6C02D162")) {
          classInfo.type = "P";
          classInfo.id = "940272ED78B04340938C529D6C02D162";
        }
      }
     
      if (command.contains("BD4DD303E4BA4FF789612D37876B479F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("BD4DD303E4BA4FF789612D37876B479F");
        SessionInfo.setModuleId("B567A8EB1BF7419F94D4C2891BA72378");
        if (securedProcess || explicitAccess.contains("BD4DD303E4BA4FF789612D37876B479F")) {
          classInfo.type = "P";
          classInfo.id = "BD4DD303E4BA4FF789612D37876B479F";
        }
      }
     
      if (command.contains("A1FB2F43434F4D78AB303281B87E5A59")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A1FB2F43434F4D78AB303281B87E5A59");
        SessionInfo.setModuleId("BCDA989719C148D782867D738F70DA8D");
        if (securedProcess || explicitAccess.contains("A1FB2F43434F4D78AB303281B87E5A59")) {
          classInfo.type = "P";
          classInfo.id = "A1FB2F43434F4D78AB303281B87E5A59";
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

     } else if (vars.commandIn("BUTTONEM_Scmf_Processforecast940272ED78B04340938C529D6C02D162")) {
        vars.setSessionValue("button940272ED78B04340938C529D6C02D162.stremScmfProcessforecast", vars.getStringParameter("inpemScmfProcessforecast"));
        vars.setSessionValue("button940272ED78B04340938C529D6C02D162.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button940272ED78B04340938C529D6C02D162.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button940272ED78B04340938C529D6C02D162.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button940272ED78B04340938C529D6C02D162.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "940272ED78B04340938C529D6C02D162", request.getServletPath());    
     } else if (vars.commandIn("BUTTON940272ED78B04340938C529D6C02D162")) {
        String strMRP_Salesforecast_ID = vars.getGlobalVariable("inpmrpSalesforecastId", windowId + "|MRP_Salesforecast_ID", "");
        String stremScmfProcessforecast = vars.getSessionValue("button940272ED78B04340938C529D6C02D162.stremScmfProcessforecast");
        String strProcessing = vars.getSessionValue("button940272ED78B04340938C529D6C02D162.strProcessing");
        String strOrg = vars.getSessionValue("button940272ED78B04340938C529D6C02D162.strOrg");
        String strClient = vars.getSessionValue("button940272ED78B04340938C529D6C02D162.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Scmf_Processforecast940272ED78B04340938C529D6C02D162(response, vars, strMRP_Salesforecast_ID, stremScmfProcessforecast, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Cscm_DeletelinesBD4DD303E4BA4FF789612D37876B479F")) {
        vars.setSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.stremCscmDeletelines", vars.getStringParameter("inpemCscmDeletelines"));
        vars.setSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonBD4DD303E4BA4FF789612D37876B479F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "BD4DD303E4BA4FF789612D37876B479F", request.getServletPath());    
     } else if (vars.commandIn("BUTTONBD4DD303E4BA4FF789612D37876B479F")) {
        String strMRP_Salesforecast_ID = vars.getGlobalVariable("inpmrpSalesforecastId", windowId + "|MRP_Salesforecast_ID", "");
        String stremCscmDeletelines = vars.getSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.stremCscmDeletelines");
        String strProcessing = vars.getSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.strProcessing");
        String strOrg = vars.getSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.strOrg");
        String strClient = vars.getSessionValue("buttonBD4DD303E4BA4FF789612D37876B479F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Cscm_DeletelinesBD4DD303E4BA4FF789612D37876B479F(response, vars, strMRP_Salesforecast_ID, stremCscmDeletelines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssmrp_ApproveforecastsA1FB2F43434F4D78AB303281B87E5A59")) {
        vars.setSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.stremSsmrpApproveforecasts", vars.getStringParameter("inpemSsmrpApproveforecasts"));
        vars.setSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA1FB2F43434F4D78AB303281B87E5A59.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A1FB2F43434F4D78AB303281B87E5A59", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA1FB2F43434F4D78AB303281B87E5A59")) {
        String strMRP_Salesforecast_ID = vars.getGlobalVariable("inpmrpSalesforecastId", windowId + "|MRP_Salesforecast_ID", "");
        String stremSsmrpApproveforecasts = vars.getSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.stremSsmrpApproveforecasts");
        String strProcessing = vars.getSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.strProcessing");
        String strOrg = vars.getSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.strOrg");
        String strClient = vars.getSessionValue("buttonA1FB2F43434F4D78AB303281B87E5A59.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssmrp_ApproveforecastsA1FB2F43434F4D78AB303281B87E5A59(response, vars, strMRP_Salesforecast_ID, stremSsmrpApproveforecasts, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Scmf_Processforecast940272ED78B04340938C529D6C02D162")) {
        String strMRP_Salesforecast_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Salesforecast_ID", "");
        String stremScmfProcessforecast = vars.getStringParameter("inpemScmfProcessforecast");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "940272ED78B04340938C529D6C02D162", (("MRP_Salesforecast_ID".equalsIgnoreCase("AD_Language"))?"0":strMRP_Salesforecast_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Cscm_DeletelinesBD4DD303E4BA4FF789612D37876B479F")) {
        String strMRP_Salesforecast_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Salesforecast_ID", "");
        String stremCscmDeletelines = vars.getStringParameter("inpemCscmDeletelines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "BD4DD303E4BA4FF789612D37876B479F", (("MRP_Salesforecast_ID".equalsIgnoreCase("AD_Language"))?"0":strMRP_Salesforecast_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssmrp_ApproveforecastsA1FB2F43434F4D78AB303281B87E5A59")) {
        String strMRP_Salesforecast_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Salesforecast_ID", "");
        String stremSsmrpApproveforecasts = vars.getStringParameter("inpemSsmrpApproveforecasts");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A1FB2F43434F4D78AB303281B87E5A59", (("MRP_Salesforecast_ID".equalsIgnoreCase("AD_Language"))?"0":strMRP_Salesforecast_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonEM_Scmf_Processforecast940272ED78B04340938C529D6C02D162(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Salesforecast_ID, String stremScmfProcessforecast, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 940272ED78B04340938C529D6C02D162");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Scmf_Processforecast940272ED78B04340938C529D6C02D162", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Salesforecast_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6E6F4A3A9E164605923BAFA4EF4F2443_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "940272ED78B04340938C529D6C02D162");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("940272ED78B04340938C529D6C02D162");
        vars.removeMessage("940272ED78B04340938C529D6C02D162");
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
    private void printPageButtonEM_Cscm_DeletelinesBD4DD303E4BA4FF789612D37876B479F(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Salesforecast_ID, String stremCscmDeletelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BD4DD303E4BA4FF789612D37876B479F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Cscm_DeletelinesBD4DD303E4BA4FF789612D37876B479F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Salesforecast_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6E6F4A3A9E164605923BAFA4EF4F2443_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "BD4DD303E4BA4FF789612D37876B479F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("BD4DD303E4BA4FF789612D37876B479F");
        vars.removeMessage("BD4DD303E4BA4FF789612D37876B479F");
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
    private void printPageButtonEM_Ssmrp_ApproveforecastsA1FB2F43434F4D78AB303281B87E5A59(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Salesforecast_ID, String stremSsmrpApproveforecasts, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A1FB2F43434F4D78AB303281B87E5A59");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssmrp_ApproveforecastsA1FB2F43434F4D78AB303281B87E5A59", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Salesforecast_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header6E6F4A3A9E164605923BAFA4EF4F2443_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A1FB2F43434F4D78AB303281B87E5A59");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A1FB2F43434F4D78AB303281B87E5A59");
        vars.removeMessage("A1FB2F43434F4D78AB303281B87E5A59");
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
