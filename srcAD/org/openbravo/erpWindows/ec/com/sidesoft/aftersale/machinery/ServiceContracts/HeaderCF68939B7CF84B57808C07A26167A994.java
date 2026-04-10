
package org.openbravo.erpWindows.ec.com.sidesoft.aftersale.machinery.ServiceContracts;


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
public class HeaderCF68939B7CF84B57808C07A26167A994 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "097517DE986A49D1BDD4A1BE8DB81CC7";
  private static final String tabId = "CF68939B7CF84B57808C07A26167A994";
  private static final int accesslevel = 3;
  private static final String moduleId = "6A094B939D7B493CA32FCD93E4BD7EB8";
  
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
     
      if (command.contains("AFD8699DD65F4359B84542B7C6FF0C44")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AFD8699DD65F4359B84542B7C6FF0C44");
        SessionInfo.setModuleId("6A094B939D7B493CA32FCD93E4BD7EB8");
        if (securedProcess || explicitAccess.contains("AFD8699DD65F4359B84542B7C6FF0C44")) {
          classInfo.type = "P";
          classInfo.id = "AFD8699DD65F4359B84542B7C6FF0C44";
        }
      }
     
      if (command.contains("CE116F763A264D1186AD4F767A28F71D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CE116F763A264D1186AD4F767A28F71D");
        SessionInfo.setModuleId("6A094B939D7B493CA32FCD93E4BD7EB8");
        if (securedProcess || explicitAccess.contains("CE116F763A264D1186AD4F767A28F71D")) {
          classInfo.type = "P";
          classInfo.id = "CE116F763A264D1186AD4F767A28F71D";
        }
      }
     
      if (command.contains("D2F93E8A05714944BCF6E713A83A7392")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D2F93E8A05714944BCF6E713A83A7392");
        SessionInfo.setModuleId("6A094B939D7B493CA32FCD93E4BD7EB8");
        if (securedProcess || explicitAccess.contains("D2F93E8A05714944BCF6E713A83A7392")) {
          classInfo.type = "P";
          classInfo.id = "D2F93E8A05714944BCF6E713A83A7392";
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

     } else if (vars.commandIn("BUTTONBTN_ProcessAFD8699DD65F4359B84542B7C6FF0C44")) {
        vars.setSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strbtnProcess", vars.getStringParameter("inpbtnProcess"));
        vars.setSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAFD8699DD65F4359B84542B7C6FF0C44.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AFD8699DD65F4359B84542B7C6FF0C44", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAFD8699DD65F4359B84542B7C6FF0C44")) {
        String strSatmac_Contract_ID = vars.getGlobalVariable("inpsatmacContractId", windowId + "|Satmac_Contract_ID", "");
        String strbtnProcess = vars.getSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strbtnProcess");
        String strProcessing = vars.getSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strProcessing");
        String strOrg = vars.getSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strOrg");
        String strClient = vars.getSessionValue("buttonAFD8699DD65F4359B84542B7C6FF0C44.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_ProcessAFD8699DD65F4359B84542B7C6FF0C44(response, vars, strSatmac_Contract_ID, strbtnProcess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBTN_ReactivateCE116F763A264D1186AD4F767A28F71D")) {
        vars.setSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strbtnReactivate", vars.getStringParameter("inpbtnReactivate"));
        vars.setSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCE116F763A264D1186AD4F767A28F71D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CE116F763A264D1186AD4F767A28F71D", request.getServletPath());    
     } else if (vars.commandIn("BUTTONCE116F763A264D1186AD4F767A28F71D")) {
        String strSatmac_Contract_ID = vars.getGlobalVariable("inpsatmacContractId", windowId + "|Satmac_Contract_ID", "");
        String strbtnReactivate = vars.getSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strbtnReactivate");
        String strProcessing = vars.getSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strProcessing");
        String strOrg = vars.getSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strOrg");
        String strClient = vars.getSessionValue("buttonCE116F763A264D1186AD4F767A28F71D.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_ReactivateCE116F763A264D1186AD4F767A28F71D(response, vars, strSatmac_Contract_ID, strbtnReactivate, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBTN_Load_MachinesD2F93E8A05714944BCF6E713A83A7392")) {
        vars.setSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strbtnLoadMachines", vars.getStringParameter("inpbtnLoadMachines"));
        vars.setSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD2F93E8A05714944BCF6E713A83A7392.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D2F93E8A05714944BCF6E713A83A7392", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND2F93E8A05714944BCF6E713A83A7392")) {
        String strSatmac_Contract_ID = vars.getGlobalVariable("inpsatmacContractId", windowId + "|Satmac_Contract_ID", "");
        String strbtnLoadMachines = vars.getSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strbtnLoadMachines");
        String strProcessing = vars.getSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strProcessing");
        String strOrg = vars.getSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strOrg");
        String strClient = vars.getSessionValue("buttonD2F93E8A05714944BCF6E713A83A7392.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Load_MachinesD2F93E8A05714944BCF6E713A83A7392(response, vars, strSatmac_Contract_ID, strbtnLoadMachines, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBTN_ProcessAFD8699DD65F4359B84542B7C6FF0C44")) {
        String strSatmac_Contract_ID = vars.getGlobalVariable("inpKey", windowId + "|Satmac_Contract_ID", "");
        String strbtnProcess = vars.getStringParameter("inpbtnProcess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AFD8699DD65F4359B84542B7C6FF0C44", (("Satmac_Contract_ID".equalsIgnoreCase("AD_Language"))?"0":strSatmac_Contract_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_ReactivateCE116F763A264D1186AD4F767A28F71D")) {
        String strSatmac_Contract_ID = vars.getGlobalVariable("inpKey", windowId + "|Satmac_Contract_ID", "");
        String strbtnReactivate = vars.getStringParameter("inpbtnReactivate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "CE116F763A264D1186AD4F767A28F71D", (("Satmac_Contract_ID".equalsIgnoreCase("AD_Language"))?"0":strSatmac_Contract_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_Load_MachinesD2F93E8A05714944BCF6E713A83A7392")) {
        String strSatmac_Contract_ID = vars.getGlobalVariable("inpKey", windowId + "|Satmac_Contract_ID", "");
        String strbtnLoadMachines = vars.getStringParameter("inpbtnLoadMachines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D2F93E8A05714944BCF6E713A83A7392", (("Satmac_Contract_ID".equalsIgnoreCase("AD_Language"))?"0":strSatmac_Contract_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonBTN_ProcessAFD8699DD65F4359B84542B7C6FF0C44(HttpServletResponse response, VariablesSecureApp vars, String strSatmac_Contract_ID, String strbtnProcess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AFD8699DD65F4359B84542B7C6FF0C44");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_ProcessAFD8699DD65F4359B84542B7C6FF0C44", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSatmac_Contract_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderCF68939B7CF84B57808C07A26167A994_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AFD8699DD65F4359B84542B7C6FF0C44");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AFD8699DD65F4359B84542B7C6FF0C44");
        vars.removeMessage("AFD8699DD65F4359B84542B7C6FF0C44");
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
    private void printPageButtonBTN_ReactivateCE116F763A264D1186AD4F767A28F71D(HttpServletResponse response, VariablesSecureApp vars, String strSatmac_Contract_ID, String strbtnReactivate, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CE116F763A264D1186AD4F767A28F71D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_ReactivateCE116F763A264D1186AD4F767A28F71D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSatmac_Contract_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderCF68939B7CF84B57808C07A26167A994_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CE116F763A264D1186AD4F767A28F71D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CE116F763A264D1186AD4F767A28F71D");
        vars.removeMessage("CE116F763A264D1186AD4F767A28F71D");
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
    private void printPageButtonBTN_Load_MachinesD2F93E8A05714944BCF6E713A83A7392(HttpServletResponse response, VariablesSecureApp vars, String strSatmac_Contract_ID, String strbtnLoadMachines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D2F93E8A05714944BCF6E713A83A7392");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Load_MachinesD2F93E8A05714944BCF6E713A83A7392", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSatmac_Contract_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderCF68939B7CF84B57808C07A26167A994_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D2F93E8A05714944BCF6E713A83A7392");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D2F93E8A05714944BCF6E713A83A7392");
        vars.removeMessage("D2F93E8A05714944BCF6E713A83A7392");
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
