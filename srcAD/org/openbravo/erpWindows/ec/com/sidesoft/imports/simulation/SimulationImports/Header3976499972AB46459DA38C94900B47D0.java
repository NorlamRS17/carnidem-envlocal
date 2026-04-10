
package org.openbravo.erpWindows.ec.com.sidesoft.imports.simulation.SimulationImports;


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
public class Header3976499972AB46459DA38C94900B47D0 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "86CCE32BE8CA4E1CB84A32C48AA6FAEC";
  private static final String tabId = "3976499972AB46459DA38C94900B47D0";
  private static final int accesslevel = 3;
  private static final String moduleId = "B0CA33B0BA9048889AFCF51C545EE6C0";
  
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
     
      if (command.contains("C6628A20B8C446C8A338C4BE4518DF61")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C6628A20B8C446C8A338C4BE4518DF61");
        SessionInfo.setModuleId("B0CA33B0BA9048889AFCF51C545EE6C0");
        if (securedProcess || explicitAccess.contains("C6628A20B8C446C8A338C4BE4518DF61")) {
          classInfo.type = "P";
          classInfo.id = "C6628A20B8C446C8A338C4BE4518DF61";
        }
      }
     
      if (command.contains("5A4B6053329947F6AEC84DBF4A315894")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5A4B6053329947F6AEC84DBF4A315894");
        SessionInfo.setModuleId("B0CA33B0BA9048889AFCF51C545EE6C0");
        if (securedProcess || explicitAccess.contains("5A4B6053329947F6AEC84DBF4A315894")) {
          classInfo.type = "P";
          classInfo.id = "5A4B6053329947F6AEC84DBF4A315894";
        }
      }
     
      if (command.contains("307503AE0B02489994E97490CBAD226B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("307503AE0B02489994E97490CBAD226B");
        SessionInfo.setModuleId("B0CA33B0BA9048889AFCF51C545EE6C0");
        if (securedProcess || explicitAccess.contains("307503AE0B02489994E97490CBAD226B")) {
          classInfo.type = "P";
          classInfo.id = "307503AE0B02489994E97490CBAD226B";
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

     } else if (vars.commandIn("BUTTONBTN_Pre_SettleC6628A20B8C446C8A338C4BE4518DF61")) {
        vars.setSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strbtnPreSettle", vars.getStringParameter("inpbtnPreSettle"));
        vars.setSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC6628A20B8C446C8A338C4BE4518DF61.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C6628A20B8C446C8A338C4BE4518DF61", request.getServletPath());    
     } else if (vars.commandIn("BUTTONC6628A20B8C446C8A338C4BE4518DF61")) {
        String strSimpsim_Import_Simulation_ID = vars.getGlobalVariable("inpsimpsimImportSimulationId", windowId + "|Simpsim_Import_Simulation_ID", "");
        String strbtnPreSettle = vars.getSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strbtnPreSettle");
        String strProcessing = vars.getSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strProcessing");
        String strOrg = vars.getSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strOrg");
        String strClient = vars.getSessionValue("buttonC6628A20B8C446C8A338C4BE4518DF61.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Pre_SettleC6628A20B8C446C8A338C4BE4518DF61(response, vars, strSimpsim_Import_Simulation_ID, strbtnPreSettle, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBTN_Process5A4B6053329947F6AEC84DBF4A315894")) {
        vars.setSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strbtnProcess", vars.getStringParameter("inpbtnProcess"));
        vars.setSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5A4B6053329947F6AEC84DBF4A315894.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5A4B6053329947F6AEC84DBF4A315894", request.getServletPath());    
     } else if (vars.commandIn("BUTTON5A4B6053329947F6AEC84DBF4A315894")) {
        String strSimpsim_Import_Simulation_ID = vars.getGlobalVariable("inpsimpsimImportSimulationId", windowId + "|Simpsim_Import_Simulation_ID", "");
        String strbtnProcess = vars.getSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strbtnProcess");
        String strProcessing = vars.getSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strProcessing");
        String strOrg = vars.getSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strOrg");
        String strClient = vars.getSessionValue("button5A4B6053329947F6AEC84DBF4A315894.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Process5A4B6053329947F6AEC84DBF4A315894(response, vars, strSimpsim_Import_Simulation_ID, strbtnProcess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBTN_Create_Order307503AE0B02489994E97490CBAD226B")) {
        vars.setSessionValue("button307503AE0B02489994E97490CBAD226B.strbtnCreateOrder", vars.getStringParameter("inpbtnCreateOrder"));
        vars.setSessionValue("button307503AE0B02489994E97490CBAD226B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button307503AE0B02489994E97490CBAD226B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button307503AE0B02489994E97490CBAD226B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button307503AE0B02489994E97490CBAD226B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "307503AE0B02489994E97490CBAD226B", request.getServletPath());    
     } else if (vars.commandIn("BUTTON307503AE0B02489994E97490CBAD226B")) {
        String strSimpsim_Import_Simulation_ID = vars.getGlobalVariable("inpsimpsimImportSimulationId", windowId + "|Simpsim_Import_Simulation_ID", "");
        String strbtnCreateOrder = vars.getSessionValue("button307503AE0B02489994E97490CBAD226B.strbtnCreateOrder");
        String strProcessing = vars.getSessionValue("button307503AE0B02489994E97490CBAD226B.strProcessing");
        String strOrg = vars.getSessionValue("button307503AE0B02489994E97490CBAD226B.strOrg");
        String strClient = vars.getSessionValue("button307503AE0B02489994E97490CBAD226B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Create_Order307503AE0B02489994E97490CBAD226B(response, vars, strSimpsim_Import_Simulation_ID, strbtnCreateOrder, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBTN_Pre_SettleC6628A20B8C446C8A338C4BE4518DF61")) {
        String strSimpsim_Import_Simulation_ID = vars.getGlobalVariable("inpKey", windowId + "|Simpsim_Import_Simulation_ID", "");
        String strbtnPreSettle = vars.getStringParameter("inpbtnPreSettle");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "C6628A20B8C446C8A338C4BE4518DF61", (("Simpsim_Import_Simulation_ID".equalsIgnoreCase("AD_Language"))?"0":strSimpsim_Import_Simulation_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_Process5A4B6053329947F6AEC84DBF4A315894")) {
        String strSimpsim_Import_Simulation_ID = vars.getGlobalVariable("inpKey", windowId + "|Simpsim_Import_Simulation_ID", "");
        String strbtnProcess = vars.getStringParameter("inpbtnProcess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "5A4B6053329947F6AEC84DBF4A315894", (("Simpsim_Import_Simulation_ID".equalsIgnoreCase("AD_Language"))?"0":strSimpsim_Import_Simulation_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_Create_Order307503AE0B02489994E97490CBAD226B")) {
        String strSimpsim_Import_Simulation_ID = vars.getGlobalVariable("inpKey", windowId + "|Simpsim_Import_Simulation_ID", "");
        String strbtnCreateOrder = vars.getStringParameter("inpbtnCreateOrder");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "307503AE0B02489994E97490CBAD226B", (("Simpsim_Import_Simulation_ID".equalsIgnoreCase("AD_Language"))?"0":strSimpsim_Import_Simulation_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String stradOrgId = vars.getStringParameter("inpadOrgId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "AD_Org_ID", stradOrgId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcDoctypeId = vars.getStringParameter("inpcDoctypeId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "C_DocType_ID", strcDoctypeId, vars.getClient(), vars.getOrg(), vars.getUser());
String strdateordered = vars.getStringParameter("inpdateordered");
PInstanceProcessData.insertPInstanceParamDate(this, pinstance, "30", "DateOrdered", strdateordered, vars.getClient(), vars.getOrg(), vars.getUser());
String strcBpartnerId = vars.getStringParameter("inpcBpartnerId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "40", "C_BPartner_ID", strcBpartnerId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmPricelistId = vars.getStringParameter("inpmPricelistId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "50", "M_PriceList_ID", strmPricelistId, vars.getClient(), vars.getOrg(), vars.getUser());
String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "60", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonBTN_Pre_SettleC6628A20B8C446C8A338C4BE4518DF61(HttpServletResponse response, VariablesSecureApp vars, String strSimpsim_Import_Simulation_ID, String strbtnPreSettle, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C6628A20B8C446C8A338C4BE4518DF61");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Pre_SettleC6628A20B8C446C8A338C4BE4518DF61", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSimpsim_Import_Simulation_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header3976499972AB46459DA38C94900B47D0_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C6628A20B8C446C8A338C4BE4518DF61");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C6628A20B8C446C8A338C4BE4518DF61");
        vars.removeMessage("C6628A20B8C446C8A338C4BE4518DF61");
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
    private void printPageButtonBTN_Process5A4B6053329947F6AEC84DBF4A315894(HttpServletResponse response, VariablesSecureApp vars, String strSimpsim_Import_Simulation_ID, String strbtnProcess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5A4B6053329947F6AEC84DBF4A315894");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Process5A4B6053329947F6AEC84DBF4A315894", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSimpsim_Import_Simulation_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header3976499972AB46459DA38C94900B47D0_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5A4B6053329947F6AEC84DBF4A315894");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5A4B6053329947F6AEC84DBF4A315894");
        vars.removeMessage("5A4B6053329947F6AEC84DBF4A315894");
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
    private void printPageButtonBTN_Create_Order307503AE0B02489994E97490CBAD226B(HttpServletResponse response, VariablesSecureApp vars, String strSimpsim_Import_Simulation_ID, String strbtnCreateOrder, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 307503AE0B02489994E97490CBAD226B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Create_Order307503AE0B02489994E97490CBAD226B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSimpsim_Import_Simulation_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header3976499972AB46459DA38C94900B47D0_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "307503AE0B02489994E97490CBAD226B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("307503AE0B02489994E97490CBAD226B");
        vars.removeMessage("307503AE0B02489994E97490CBAD226B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("AD_Org_ID", Utility.getContext(this, vars, "#AD_Org_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "AD_Org_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button307503AE0B02489994E97490CBAD226B.originalParams"), comboTableData, windowId, Utility.getContext(this, vars, "#AD_Org_ID", windowId));
    xmlDocument.setData("reportAD_Org_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_DocType_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_DocType_ID", "", "4AB605BA7A124636A7EB493172B1EF04", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button307503AE0B02489994E97490CBAD226B.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportC_DocType_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("DateOrdered", DateTimeData.today(this));
    xmlDocument.setParameter("DateOrdered_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("C_BPartner_ID", "");
    xmlDocument.setParameter("M_PriceList_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "M_PriceList_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button307503AE0B02489994E97490CBAD226B.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportM_PriceList_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("M_Warehouse_ID", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
