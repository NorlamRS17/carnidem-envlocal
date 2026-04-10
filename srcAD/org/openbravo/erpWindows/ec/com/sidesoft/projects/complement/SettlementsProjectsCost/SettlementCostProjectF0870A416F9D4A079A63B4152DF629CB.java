
package org.openbravo.erpWindows.ec.com.sidesoft.projects.complement.SettlementsProjectsCost;


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
public class SettlementCostProjectF0870A416F9D4A079A63B4152DF629CB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "BCE36036A2514E22817111C6B6C31E60";
  private static final String tabId = "F0870A416F9D4A079A63B4152DF629CB";
  private static final int accesslevel = 7;
  private static final String moduleId = "45A649284EB240D7995BCEBC0010A4B1";
  
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
     
      if (command.contains("AF8EE510E85944D3B2AF4A458A2B8227")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AF8EE510E85944D3B2AF4A458A2B8227");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("AF8EE510E85944D3B2AF4A458A2B8227")) {
          classInfo.type = "P";
          classInfo.id = "AF8EE510E85944D3B2AF4A458A2B8227";
        }
      }
     
      if (command.contains("8C6FF434ADCC4677AEAA537FC3B284B4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("8C6FF434ADCC4677AEAA537FC3B284B4");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
        if (securedProcess || explicitAccess.contains("8C6FF434ADCC4677AEAA537FC3B284B4")) {
          classInfo.type = "P";
          classInfo.id = "8C6FF434ADCC4677AEAA537FC3B284B4";
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

     } else if (vars.commandIn("BUTTONLoad_LinesAF8EE510E85944D3B2AF4A458A2B8227")) {
        vars.setSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strloadLines", vars.getStringParameter("inploadLines"));
        vars.setSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAF8EE510E85944D3B2AF4A458A2B8227.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AF8EE510E85944D3B2AF4A458A2B8227", request.getServletPath());    
     } else if (vars.commandIn("BUTTONAF8EE510E85944D3B2AF4A458A2B8227")) {
        String strSproctm_Settlement_Cost_ID = vars.getGlobalVariable("inpsproctmSettlementCostId", windowId + "|Sproctm_Settlement_Cost_ID", "");
        String strloadLines = vars.getSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strloadLines");
        String strProcessing = vars.getSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strProcessing");
        String strOrg = vars.getSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strOrg");
        String strClient = vars.getSessionValue("buttonAF8EE510E85944D3B2AF4A458A2B8227.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_LinesAF8EE510E85944D3B2AF4A458A2B8227(response, vars, strSproctm_Settlement_Cost_ID, strloadLines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONLiquidate8C6FF434ADCC4677AEAA537FC3B284B4")) {
        vars.setSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strliquidate", vars.getStringParameter("inpliquidate"));
        vars.setSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button8C6FF434ADCC4677AEAA537FC3B284B4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "8C6FF434ADCC4677AEAA537FC3B284B4", request.getServletPath());    
     } else if (vars.commandIn("BUTTON8C6FF434ADCC4677AEAA537FC3B284B4")) {
        String strSproctm_Settlement_Cost_ID = vars.getGlobalVariable("inpsproctmSettlementCostId", windowId + "|Sproctm_Settlement_Cost_ID", "");
        String strliquidate = vars.getSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strliquidate");
        String strProcessing = vars.getSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strProcessing");
        String strOrg = vars.getSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strOrg");
        String strClient = vars.getSessionValue("button8C6FF434ADCC4677AEAA537FC3B284B4.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLiquidate8C6FF434ADCC4677AEAA537FC3B284B4(response, vars, strSproctm_Settlement_Cost_ID, strliquidate, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_LinesAF8EE510E85944D3B2AF4A458A2B8227")) {
        String strSproctm_Settlement_Cost_ID = vars.getGlobalVariable("inpKey", windowId + "|Sproctm_Settlement_Cost_ID", "");
        String strloadLines = vars.getStringParameter("inploadLines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "AF8EE510E85944D3B2AF4A458A2B8227", (("Sproctm_Settlement_Cost_ID".equalsIgnoreCase("AD_Language"))?"0":strSproctm_Settlement_Cost_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONLiquidate8C6FF434ADCC4677AEAA537FC3B284B4")) {
        String strSproctm_Settlement_Cost_ID = vars.getGlobalVariable("inpKey", windowId + "|Sproctm_Settlement_Cost_ID", "");
        String strliquidate = vars.getStringParameter("inpliquidate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "8C6FF434ADCC4677AEAA537FC3B284B4", (("Sproctm_Settlement_Cost_ID".equalsIgnoreCase("AD_Language"))?"0":strSproctm_Settlement_Cost_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
        String strSproctm_Settlement_Cost_ID = vars.getGlobalVariable("inpsproctmSettlementCostId", windowId + "|Sproctm_Settlement_Cost_ID", "");
        String strTableId = "B008F71C52F941978FA6D594B8872020";
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
          vars.setSessionValue("Posted|key", strSproctm_Settlement_Cost_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "SettlementCostProjectF0870A416F9D4A079A63B4152DF629CB");
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

    private void printPageButtonLoad_LinesAF8EE510E85944D3B2AF4A458A2B8227(HttpServletResponse response, VariablesSecureApp vars, String strSproctm_Settlement_Cost_ID, String strloadLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AF8EE510E85944D3B2AF4A458A2B8227");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_LinesAF8EE510E85944D3B2AF4A458A2B8227", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSproctm_Settlement_Cost_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SettlementCostProjectF0870A416F9D4A079A63B4152DF629CB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AF8EE510E85944D3B2AF4A458A2B8227");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AF8EE510E85944D3B2AF4A458A2B8227");
        vars.removeMessage("AF8EE510E85944D3B2AF4A458A2B8227");
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
    private void printPageButtonLiquidate8C6FF434ADCC4677AEAA537FC3B284B4(HttpServletResponse response, VariablesSecureApp vars, String strSproctm_Settlement_Cost_ID, String strliquidate, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8C6FF434ADCC4677AEAA537FC3B284B4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Liquidate8C6FF434ADCC4677AEAA537FC3B284B4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSproctm_Settlement_Cost_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SettlementCostProjectF0870A416F9D4A079A63B4152DF629CB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "8C6FF434ADCC4677AEAA537FC3B284B4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("8C6FF434ADCC4677AEAA537FC3B284B4");
        vars.removeMessage("8C6FF434ADCC4677AEAA537FC3B284B4");
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
