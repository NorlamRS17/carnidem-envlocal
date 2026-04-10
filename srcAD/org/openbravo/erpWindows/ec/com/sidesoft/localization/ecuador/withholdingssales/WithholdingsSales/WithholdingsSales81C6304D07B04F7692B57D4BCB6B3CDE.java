
package org.openbravo.erpWindows.ec.com.sidesoft.localization.ecuador.withholdingssales.WithholdingsSales;


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
public class WithholdingsSales81C6304D07B04F7692B57D4BCB6B3CDE extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "C68EABB208CB4D9FB99A8ACDC66ECFA1";
  private static final String tabId = "81C6304D07B04F7692B57D4BCB6B3CDE";
  private static final int accesslevel = 3;
  private static final String moduleId = "436706DE965C4C0C8501EBC805C956DF";
  
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
     
      if (command.contains("00052E7428F8477CAACCE14830F8F43E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("00052E7428F8477CAACCE14830F8F43E");
        SessionInfo.setModuleId("436706DE965C4C0C8501EBC805C956DF");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("4E70057243C447169ADD1397D992B189")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4E70057243C447169ADD1397D992B189");
        SessionInfo.setModuleId("436706DE965C4C0C8501EBC805C956DF");
        if (securedProcess || explicitAccess.contains("4E70057243C447169ADD1397D992B189")) {
          classInfo.type = "P";
          classInfo.id = "4E70057243C447169ADD1397D992B189";
        }
      }
     

     
      if (explicitAccess.contains("00052E7428F8477CAACCE14830F8F43E") || (securedProcess && command.contains("00052E7428F8477CAACCE14830F8F43E"))) {
        classInfo.type = "P";
        classInfo.id = "00052E7428F8477CAACCE14830F8F43E";
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

     } else if (vars.commandIn("BUTTONGetlines4E70057243C447169ADD1397D992B189")) {
        vars.setSessionValue("button4E70057243C447169ADD1397D992B189.strgetlines", vars.getStringParameter("inpgetlines"));
        vars.setSessionValue("button4E70057243C447169ADD1397D992B189.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4E70057243C447169ADD1397D992B189.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4E70057243C447169ADD1397D992B189.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4E70057243C447169ADD1397D992B189.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4E70057243C447169ADD1397D992B189", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4E70057243C447169ADD1397D992B189")) {
        String strSsws_Withholdingsale_ID = vars.getGlobalVariable("inpsswsWithholdingsaleId", windowId + "|Ssws_Withholdingsale_ID", "");
        String strgetlines = vars.getSessionValue("button4E70057243C447169ADD1397D992B189.strgetlines");
        String strProcessing = vars.getSessionValue("button4E70057243C447169ADD1397D992B189.strProcessing");
        String strOrg = vars.getSessionValue("button4E70057243C447169ADD1397D992B189.strOrg");
        String strClient = vars.getSessionValue("button4E70057243C447169ADD1397D992B189.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGetlines4E70057243C447169ADD1397D992B189(response, vars, strSsws_Withholdingsale_ID, strgetlines, strProcessing);
        }

    } else if (vars.commandIn("BUTTONProcessed00052E7428F8477CAACCE14830F8F43E")) {
        vars.setSessionValue("button00052E7428F8477CAACCE14830F8F43E.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button00052E7428F8477CAACCE14830F8F43E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button00052E7428F8477CAACCE14830F8F43E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button00052E7428F8477CAACCE14830F8F43E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button00052E7428F8477CAACCE14830F8F43E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "00052E7428F8477CAACCE14830F8F43E", request.getServletPath());
      } else if (vars.commandIn("BUTTON00052E7428F8477CAACCE14830F8F43E")) {
        String strSsws_Withholdingsale_ID = vars.getGlobalVariable("inpsswsWithholdingsaleId", windowId + "|Ssws_Withholdingsale_ID", "");
        String strprocessed = vars.getSessionValue("button00052E7428F8477CAACCE14830F8F43E.strprocessed");
        String strProcessing = vars.getSessionValue("button00052E7428F8477CAACCE14830F8F43E.strProcessing");
        String strOrg = vars.getSessionValue("button00052E7428F8477CAACCE14830F8F43E.strOrg");
        String strClient = vars.getSessionValue("button00052E7428F8477CAACCE14830F8F43E.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed00052E7428F8477CAACCE14830F8F43E(response, vars, strSsws_Withholdingsale_ID, strprocessed, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONGetlines4E70057243C447169ADD1397D992B189")) {
        String strSsws_Withholdingsale_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssws_Withholdingsale_ID", "");
        String strgetlines = vars.getStringParameter("inpgetlines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4E70057243C447169ADD1397D992B189", (("Ssws_Withholdingsale_ID".equalsIgnoreCase("AD_Language"))?"0":strSsws_Withholdingsale_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONProcessed00052E7428F8477CAACCE14830F8F43E")) {
        String strSsws_Withholdingsale_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssws_Withholdingsale_ID", "");
        
        ProcessBundle pb = new ProcessBundle("00052E7428F8477CAACCE14830F8F43E", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssws_Withholdingsale_ID", strSsws_Withholdingsale_ID);
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


    } else if (vars.commandIn("BUTTONPosted")) {
        String strSsws_Withholdingsale_ID = vars.getGlobalVariable("inpsswsWithholdingsaleId", windowId + "|Ssws_Withholdingsale_ID", "");
        String strTableId = "211492B753264EAEBE328BA4FED1F066";
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
          vars.setSessionValue("Posted|key", strSsws_Withholdingsale_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "WithholdingsSales81C6304D07B04F7692B57D4BCB6B3CDE");
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

    private void printPageButtonGetlines4E70057243C447169ADD1397D992B189(HttpServletResponse response, VariablesSecureApp vars, String strSsws_Withholdingsale_ID, String strgetlines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4E70057243C447169ADD1397D992B189");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Getlines4E70057243C447169ADD1397D992B189", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsws_Withholdingsale_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "WithholdingsSales81C6304D07B04F7692B57D4BCB6B3CDE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4E70057243C447169ADD1397D992B189");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4E70057243C447169ADD1397D992B189");
        vars.removeMessage("4E70057243C447169ADD1397D992B189");
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


    void printPageButtonProcessed00052E7428F8477CAACCE14830F8F43E(HttpServletResponse response, VariablesSecureApp vars, String strSsws_Withholdingsale_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 00052E7428F8477CAACCE14830F8F43E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Processed00052E7428F8477CAACCE14830F8F43E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsws_Withholdingsale_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "WithholdingsSales81C6304D07B04F7692B57D4BCB6B3CDE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "00052E7428F8477CAACCE14830F8F43E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("00052E7428F8477CAACCE14830F8F43E");
        vars.removeMessage("00052E7428F8477CAACCE14830F8F43E");
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
