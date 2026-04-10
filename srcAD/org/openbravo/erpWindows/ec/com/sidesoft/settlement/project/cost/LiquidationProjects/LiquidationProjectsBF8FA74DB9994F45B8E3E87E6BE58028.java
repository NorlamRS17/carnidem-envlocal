
package org.openbravo.erpWindows.ec.com.sidesoft.settlement.project.cost.LiquidationProjects;


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
public class LiquidationProjectsBF8FA74DB9994F45B8E3E87E6BE58028 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "4CDE774BC4F04C01BF40B1F1C2468C81";
  private static final String tabId = "BF8FA74DB9994F45B8E3E87E6BE58028";
  private static final int accesslevel = 3;
  private static final String moduleId = "04A26F113A89463B87BFC6D1C22D8E97";
  
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
     
      if (command.contains("8D9C5703D2BE46A6BF86660EF72CC09F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("8D9C5703D2BE46A6BF86660EF72CC09F");
        SessionInfo.setModuleId("04A26F113A89463B87BFC6D1C22D8E97");
        if (securedProcess || explicitAccess.contains("8D9C5703D2BE46A6BF86660EF72CC09F")) {
          classInfo.type = "P";
          classInfo.id = "8D9C5703D2BE46A6BF86660EF72CC09F";
        }
      }
     
      if (command.contains("2500E020BC8B488890B979A835960469")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("2500E020BC8B488890B979A835960469");
        SessionInfo.setModuleId("04A26F113A89463B87BFC6D1C22D8E97");
        if (securedProcess || explicitAccess.contains("2500E020BC8B488890B979A835960469")) {
          classInfo.type = "P";
          classInfo.id = "2500E020BC8B488890B979A835960469";
        }
      }
     
      if (command.contains("4EA2E6B1AFF1414BA63BF49574C44C76")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4EA2E6B1AFF1414BA63BF49574C44C76");
        SessionInfo.setModuleId("04A26F113A89463B87BFC6D1C22D8E97");
        if (securedProcess || explicitAccess.contains("4EA2E6B1AFF1414BA63BF49574C44C76")) {
          classInfo.type = "P";
          classInfo.id = "4EA2E6B1AFF1414BA63BF49574C44C76";
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

     } else if (vars.commandIn("BUTTONPRE_Liquidation8D9C5703D2BE46A6BF86660EF72CC09F")) {
        vars.setSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strpreLiquidation", vars.getStringParameter("inppreLiquidation"));
        vars.setSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button8D9C5703D2BE46A6BF86660EF72CC09F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "8D9C5703D2BE46A6BF86660EF72CC09F", request.getServletPath());    
     } else if (vars.commandIn("BUTTON8D9C5703D2BE46A6BF86660EF72CC09F")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpsstpcLiquidationProjectsId", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strpreLiquidation = vars.getSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strpreLiquidation");
        String strProcessing = vars.getSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strProcessing");
        String strOrg = vars.getSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strOrg");
        String strClient = vars.getSessionValue("button8D9C5703D2BE46A6BF86660EF72CC09F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonPRE_Liquidation8D9C5703D2BE46A6BF86660EF72CC09F(response, vars, strSstpc_Liquidation_Projects_ID, strpreLiquidation, strProcessing);
        }

     } else if (vars.commandIn("BUTTONLiquidate2500E020BC8B488890B979A835960469")) {
        vars.setSessionValue("button2500E020BC8B488890B979A835960469.strliquidate", vars.getStringParameter("inpliquidate"));
        vars.setSessionValue("button2500E020BC8B488890B979A835960469.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button2500E020BC8B488890B979A835960469.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button2500E020BC8B488890B979A835960469.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button2500E020BC8B488890B979A835960469.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "2500E020BC8B488890B979A835960469", request.getServletPath());    
     } else if (vars.commandIn("BUTTON2500E020BC8B488890B979A835960469")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpsstpcLiquidationProjectsId", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strliquidate = vars.getSessionValue("button2500E020BC8B488890B979A835960469.strliquidate");
        String strProcessing = vars.getSessionValue("button2500E020BC8B488890B979A835960469.strProcessing");
        String strOrg = vars.getSessionValue("button2500E020BC8B488890B979A835960469.strOrg");
        String strClient = vars.getSessionValue("button2500E020BC8B488890B979A835960469.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLiquidate2500E020BC8B488890B979A835960469(response, vars, strSstpc_Liquidation_Projects_ID, strliquidate, strProcessing);
        }

     } else if (vars.commandIn("BUTTONDesprocessed4EA2E6B1AFF1414BA63BF49574C44C76")) {
        vars.setSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strdesprocessed", vars.getStringParameter("inpdesprocessed"));
        vars.setSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4EA2E6B1AFF1414BA63BF49574C44C76.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4EA2E6B1AFF1414BA63BF49574C44C76", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4EA2E6B1AFF1414BA63BF49574C44C76")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpsstpcLiquidationProjectsId", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strdesprocessed = vars.getSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strdesprocessed");
        String strProcessing = vars.getSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strProcessing");
        String strOrg = vars.getSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strOrg");
        String strClient = vars.getSessionValue("button4EA2E6B1AFF1414BA63BF49574C44C76.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDesprocessed4EA2E6B1AFF1414BA63BF49574C44C76(response, vars, strSstpc_Liquidation_Projects_ID, strdesprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONPRE_Liquidation8D9C5703D2BE46A6BF86660EF72CC09F")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpKey", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strpreLiquidation = vars.getStringParameter("inppreLiquidation");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "8D9C5703D2BE46A6BF86660EF72CC09F", (("Sstpc_Liquidation_Projects_ID".equalsIgnoreCase("AD_Language"))?"0":strSstpc_Liquidation_Projects_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONLiquidate2500E020BC8B488890B979A835960469")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpKey", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strliquidate = vars.getStringParameter("inpliquidate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "2500E020BC8B488890B979A835960469", (("Sstpc_Liquidation_Projects_ID".equalsIgnoreCase("AD_Language"))?"0":strSstpc_Liquidation_Projects_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONDesprocessed4EA2E6B1AFF1414BA63BF49574C44C76")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpKey", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strdesprocessed = vars.getStringParameter("inpdesprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4EA2E6B1AFF1414BA63BF49574C44C76", (("Sstpc_Liquidation_Projects_ID".equalsIgnoreCase("AD_Language"))?"0":strSstpc_Liquidation_Projects_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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



    } else if (vars.commandIn("BUTTONPosted")) {
        String strSstpc_Liquidation_Projects_ID = vars.getGlobalVariable("inpsstpcLiquidationProjectsId", windowId + "|Sstpc_Liquidation_Projects_ID", "");
        String strTableId = "5727E9E5DC604711AC27D3C5F5982E8F";
        String strPosted = vars.getStringParameter("inpposted");
        String strProcessId = "";
        log4j.debug("Loading Posted button in table: " + strTableId);
        String strOrg = vars.getStringParameter("inpadOrgId");
        String strClient = vars.getStringParameter("inpadClientId");
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{
          vars.setSessionValue("Posted|key", strSstpc_Liquidation_Projects_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "LiquidationProjectsBF8FA74DB9994F45B8E3E87E6BE58028");
          response.sendRedirect(strDireccion + "/ad_actionButton/Posted.html");
        }

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

    private void printPageButtonPRE_Liquidation8D9C5703D2BE46A6BF86660EF72CC09F(HttpServletResponse response, VariablesSecureApp vars, String strSstpc_Liquidation_Projects_ID, String strpreLiquidation, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8D9C5703D2BE46A6BF86660EF72CC09F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/PRE_Liquidation8D9C5703D2BE46A6BF86660EF72CC09F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSstpc_Liquidation_Projects_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "LiquidationProjectsBF8FA74DB9994F45B8E3E87E6BE58028_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "8D9C5703D2BE46A6BF86660EF72CC09F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("8D9C5703D2BE46A6BF86660EF72CC09F");
        vars.removeMessage("8D9C5703D2BE46A6BF86660EF72CC09F");
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
    private void printPageButtonLiquidate2500E020BC8B488890B979A835960469(HttpServletResponse response, VariablesSecureApp vars, String strSstpc_Liquidation_Projects_ID, String strliquidate, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2500E020BC8B488890B979A835960469");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Liquidate2500E020BC8B488890B979A835960469", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSstpc_Liquidation_Projects_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "LiquidationProjectsBF8FA74DB9994F45B8E3E87E6BE58028_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "2500E020BC8B488890B979A835960469");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("2500E020BC8B488890B979A835960469");
        vars.removeMessage("2500E020BC8B488890B979A835960469");
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
    private void printPageButtonDesprocessed4EA2E6B1AFF1414BA63BF49574C44C76(HttpServletResponse response, VariablesSecureApp vars, String strSstpc_Liquidation_Projects_ID, String strdesprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4EA2E6B1AFF1414BA63BF49574C44C76");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Desprocessed4EA2E6B1AFF1414BA63BF49574C44C76", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSstpc_Liquidation_Projects_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "LiquidationProjectsBF8FA74DB9994F45B8E3E87E6BE58028_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4EA2E6B1AFF1414BA63BF49574C44C76");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4EA2E6B1AFF1414BA63BF49574C44C76");
        vars.removeMessage("4EA2E6B1AFF1414BA63BF49574C44C76");
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
