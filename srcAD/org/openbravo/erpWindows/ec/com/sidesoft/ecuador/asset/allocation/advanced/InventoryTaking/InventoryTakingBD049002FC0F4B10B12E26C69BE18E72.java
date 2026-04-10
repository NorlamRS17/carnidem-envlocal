
package org.openbravo.erpWindows.ec.com.sidesoft.ecuador.asset.allocation.advanced.InventoryTaking;


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
public class InventoryTakingBD049002FC0F4B10B12E26C69BE18E72 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E3DAB07DAF724DACAC6D21B2B018C9C8";
  private static final String tabId = "BD049002FC0F4B10B12E26C69BE18E72";
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
     
      if (command.contains("BD3E529180454E6FAEC68F644CFF068A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("BD3E529180454E6FAEC68F644CFF068A");
        SessionInfo.setModuleId("7F0DB9796E67424FA7B0256FC0FDEC87");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("9739A7E528F7490F9EAAB09D7CA941D9")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9739A7E528F7490F9EAAB09D7CA941D9");
        SessionInfo.setModuleId("7F0DB9796E67424FA7B0256FC0FDEC87");
        if (securedProcess || explicitAccess.contains("9739A7E528F7490F9EAAB09D7CA941D9")) {
          classInfo.type = "P";
          classInfo.id = "9739A7E528F7490F9EAAB09D7CA941D9";
        }
      }
     
      if (command.contains("B88D1B1A41CD4D708A252AA2366E93B6")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B88D1B1A41CD4D708A252AA2366E93B6");
        SessionInfo.setModuleId("7F0DB9796E67424FA7B0256FC0FDEC87");
        if (securedProcess || explicitAccess.contains("B88D1B1A41CD4D708A252AA2366E93B6")) {
          classInfo.type = "P";
          classInfo.id = "B88D1B1A41CD4D708A252AA2366E93B6";
        }
      }
     

     
      if (explicitAccess.contains("BD3E529180454E6FAEC68F644CFF068A") || (securedProcess && command.contains("BD3E529180454E6FAEC68F644CFF068A"))) {
        classInfo.type = "P";
        classInfo.id = "BD3E529180454E6FAEC68F644CFF068A";
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

     } else if (vars.commandIn("BUTTONLoad_Actives9739A7E528F7490F9EAAB09D7CA941D9")) {
        vars.setSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strloadActives", vars.getStringParameter("inploadActives"));
        vars.setSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9739A7E528F7490F9EAAB09D7CA941D9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9739A7E528F7490F9EAAB09D7CA941D9", request.getServletPath());    
     } else if (vars.commandIn("BUTTON9739A7E528F7490F9EAAB09D7CA941D9")) {
        String strCsaaa_Inventory_Taking_ID = vars.getGlobalVariable("inpcsaaaInventoryTakingId", windowId + "|Csaaa_Inventory_Taking_ID", "");
        String strloadActives = vars.getSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strloadActives");
        String strProcessing = vars.getSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strProcessing");
        String strOrg = vars.getSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strOrg");
        String strClient = vars.getSessionValue("button9739A7E528F7490F9EAAB09D7CA941D9.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Actives9739A7E528F7490F9EAAB09D7CA941D9(response, vars, strCsaaa_Inventory_Taking_ID, strloadActives, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessedB88D1B1A41CD4D708A252AA2366E93B6")) {
        vars.setSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB88D1B1A41CD4D708A252AA2366E93B6.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B88D1B1A41CD4D708A252AA2366E93B6", request.getServletPath());    
     } else if (vars.commandIn("BUTTONB88D1B1A41CD4D708A252AA2366E93B6")) {
        String strCsaaa_Inventory_Taking_ID = vars.getGlobalVariable("inpcsaaaInventoryTakingId", windowId + "|Csaaa_Inventory_Taking_ID", "");
        String strprocessed = vars.getSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strprocessed");
        String strProcessing = vars.getSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strProcessing");
        String strOrg = vars.getSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strOrg");
        String strClient = vars.getSessionValue("buttonB88D1B1A41CD4D708A252AA2366E93B6.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedB88D1B1A41CD4D708A252AA2366E93B6(response, vars, strCsaaa_Inventory_Taking_ID, strprocessed, strProcessing);
        }

    } else if (vars.commandIn("BUTTONReconcileBD3E529180454E6FAEC68F644CFF068A")) {
        vars.setSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strreconcile", vars.getStringParameter("inpreconcile"));
        vars.setSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonBD3E529180454E6FAEC68F644CFF068A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "BD3E529180454E6FAEC68F644CFF068A", request.getServletPath());
      } else if (vars.commandIn("BUTTONBD3E529180454E6FAEC68F644CFF068A")) {
        String strCsaaa_Inventory_Taking_ID = vars.getGlobalVariable("inpcsaaaInventoryTakingId", windowId + "|Csaaa_Inventory_Taking_ID", "");
        String strreconcile = vars.getSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strreconcile");
        String strProcessing = vars.getSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strProcessing");
        String strOrg = vars.getSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strOrg");
        String strClient = vars.getSessionValue("buttonBD3E529180454E6FAEC68F644CFF068A.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReconcileBD3E529180454E6FAEC68F644CFF068A(response, vars, strCsaaa_Inventory_Taking_ID, strreconcile, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONLoad_Actives9739A7E528F7490F9EAAB09D7CA941D9")) {
        String strCsaaa_Inventory_Taking_ID = vars.getGlobalVariable("inpKey", windowId + "|Csaaa_Inventory_Taking_ID", "");
        String strloadActives = vars.getStringParameter("inploadActives");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "9739A7E528F7490F9EAAB09D7CA941D9", (("Csaaa_Inventory_Taking_ID".equalsIgnoreCase("AD_Language"))?"0":strCsaaa_Inventory_Taking_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessedB88D1B1A41CD4D708A252AA2366E93B6")) {
        String strCsaaa_Inventory_Taking_ID = vars.getGlobalVariable("inpKey", windowId + "|Csaaa_Inventory_Taking_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "B88D1B1A41CD4D708A252AA2366E93B6", (("Csaaa_Inventory_Taking_ID".equalsIgnoreCase("AD_Language"))?"0":strCsaaa_Inventory_Taking_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONReconcileBD3E529180454E6FAEC68F644CFF068A")) {
        String strCsaaa_Inventory_Taking_ID = vars.getGlobalVariable("inpKey", windowId + "|Csaaa_Inventory_Taking_ID", "");
        
        ProcessBundle pb = new ProcessBundle("BD3E529180454E6FAEC68F644CFF068A", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Csaaa_Inventory_Taking_ID", strCsaaa_Inventory_Taking_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        
        
        pb.setParams(params);
        OBError myMessage = null;
        try {
          new ProcessRunner(pb).execute(this);
          myMessage = (OBError) pb.getResult();
          myMessage.setMessage(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getMessage()));
          myMessage.setTitle(Utility.parseTranslation(this, vars, vars.getLanguage(), myMessage.getTitle()));
        } catch (Exception ex) {
          myMessage = Utility.translateError(this, vars, vars.getLanguage(), ex.getMessage());
          log4j.error(ex);
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

    private void printPageButtonLoad_Actives9739A7E528F7490F9EAAB09D7CA941D9(HttpServletResponse response, VariablesSecureApp vars, String strCsaaa_Inventory_Taking_ID, String strloadActives, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9739A7E528F7490F9EAAB09D7CA941D9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Actives9739A7E528F7490F9EAAB09D7CA941D9", discard).createXmlDocument();
      xmlDocument.setParameter("key", strCsaaa_Inventory_Taking_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "InventoryTakingBD049002FC0F4B10B12E26C69BE18E72_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "9739A7E528F7490F9EAAB09D7CA941D9");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("9739A7E528F7490F9EAAB09D7CA941D9");
        vars.removeMessage("9739A7E528F7490F9EAAB09D7CA941D9");
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
    private void printPageButtonProcessedB88D1B1A41CD4D708A252AA2366E93B6(HttpServletResponse response, VariablesSecureApp vars, String strCsaaa_Inventory_Taking_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B88D1B1A41CD4D708A252AA2366E93B6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedB88D1B1A41CD4D708A252AA2366E93B6", discard).createXmlDocument();
      xmlDocument.setParameter("key", strCsaaa_Inventory_Taking_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "InventoryTakingBD049002FC0F4B10B12E26C69BE18E72_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B88D1B1A41CD4D708A252AA2366E93B6");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B88D1B1A41CD4D708A252AA2366E93B6");
        vars.removeMessage("B88D1B1A41CD4D708A252AA2366E93B6");
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


    void printPageButtonReconcileBD3E529180454E6FAEC68F644CFF068A(HttpServletResponse response, VariablesSecureApp vars, String strCsaaa_Inventory_Taking_ID, String strreconcile, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BD3E529180454E6FAEC68F644CFF068A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ReconcileBD3E529180454E6FAEC68F644CFF068A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strCsaaa_Inventory_Taking_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "InventoryTakingBD049002FC0F4B10B12E26C69BE18E72_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "BD3E529180454E6FAEC68F644CFF068A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("BD3E529180454E6FAEC68F644CFF068A");
        vars.removeMessage("BD3E529180454E6FAEC68F644CFF068A");
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
