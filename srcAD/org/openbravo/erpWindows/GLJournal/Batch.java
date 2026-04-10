
package org.openbravo.erpWindows.GLJournal;


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
public class Batch extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "132";
  private static final String tabId = "159";
  private static final int accesslevel = 1;
  private static final String moduleId = "0";
  
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
     
      if (command.contains("CD7283DF804B449C97DA09446669EEEF")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CD7283DF804B449C97DA09446669EEEF");
        SessionInfo.setModuleId("0");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("263E1E26870C4AFEB42E770BE40B2AA2")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("263E1E26870C4AFEB42E770BE40B2AA2");
        SessionInfo.setModuleId("6D15E27E14F34A13A21B1B84304B912E");
        if (securedProcess || explicitAccess.contains("263E1E26870C4AFEB42E770BE40B2AA2")) {
          classInfo.type = "P";
          classInfo.id = "263E1E26870C4AFEB42E770BE40B2AA2";
        }
      }
     

     
      if (explicitAccess.contains("CD7283DF804B449C97DA09446669EEEF") || (securedProcess && command.contains("CD7283DF804B449C97DA09446669EEEF"))) {
        classInfo.type = "P";
        classInfo.id = "CD7283DF804B449C97DA09446669EEEF";
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

     } else if (vars.commandIn("BUTTONEM_Ssttdef_Settle_Deferred263E1E26870C4AFEB42E770BE40B2AA2")) {
        vars.setSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.stremSsttdefSettleDeferred", vars.getStringParameter("inpemSsttdefSettleDeferred"));
        vars.setSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("AD_Org_ID", vars.getStringParameter("inpadOrgId"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button263E1E26870C4AFEB42E770BE40B2AA2.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "263E1E26870C4AFEB42E770BE40B2AA2", request.getServletPath());    
     } else if (vars.commandIn("BUTTON263E1E26870C4AFEB42E770BE40B2AA2")) {
        String strGL_JournalBatch_ID = vars.getGlobalVariable("inpglJournalbatchId", windowId + "|GL_JournalBatch_ID", "");
        String stremSsttdefSettleDeferred = vars.getSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.stremSsttdefSettleDeferred");
        String strProcessing = vars.getSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.strProcessing");
        String strOrg = vars.getSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.strOrg");
        String strClient = vars.getSessionValue("button263E1E26870C4AFEB42E770BE40B2AA2.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssttdef_Settle_Deferred263E1E26870C4AFEB42E770BE40B2AA2(response, vars, strGL_JournalBatch_ID, stremSsttdefSettleDeferred, strProcessing);
        }

    } else if (vars.commandIn("BUTTONProcessingCD7283DF804B449C97DA09446669EEEF")) {
        vars.setSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strprocessing", vars.getStringParameter("inpprocessing"));
        vars.setSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCD7283DF804B449C97DA09446669EEEF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CD7283DF804B449C97DA09446669EEEF", request.getServletPath());
      } else if (vars.commandIn("BUTTONCD7283DF804B449C97DA09446669EEEF")) {
        String strGL_JournalBatch_ID = vars.getGlobalVariable("inpglJournalbatchId", windowId + "|GL_JournalBatch_ID", "");
        String strprocessing = vars.getSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strprocessing");
        String strProcessing = vars.getSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strProcessing");
        String strOrg = vars.getSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strOrg");
        String strClient = vars.getSessionValue("buttonCD7283DF804B449C97DA09446669EEEF.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessingCD7283DF804B449C97DA09446669EEEF(response, vars, strGL_JournalBatch_ID, strprocessing, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONEM_Ssttdef_Settle_Deferred263E1E26870C4AFEB42E770BE40B2AA2")) {
        String strGL_JournalBatch_ID = vars.getGlobalVariable("inpKey", windowId + "|GL_JournalBatch_ID", "");
        String stremSsttdefSettleDeferred = vars.getStringParameter("inpemSsttdefSettleDeferred");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "263E1E26870C4AFEB42E770BE40B2AA2", (("GL_JournalBatch_ID".equalsIgnoreCase("AD_Language"))?"0":strGL_JournalBatch_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcAcctschemaId = vars.getStringParameter("inpcAcctschemaId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "100", "C_AcctSchema_ID", strcAcctschemaId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcDoctypeId = vars.getStringParameter("inpcDoctypeId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "110", "C_DocType_ID", strcDoctypeId, vars.getClient(), vars.getOrg(), vars.getUser());
String strglCategoryId = vars.getStringParameter("inpglCategoryId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "120", "GL_Category_ID", strglCategoryId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    } else if (vars.commandIn("SAVE_BUTTONProcessingCD7283DF804B449C97DA09446669EEEF")) {
        String strGL_JournalBatch_ID = vars.getGlobalVariable("inpKey", windowId + "|GL_JournalBatch_ID", "");
        
        ProcessBundle pb = new ProcessBundle("CD7283DF804B449C97DA09446669EEEF", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("GL_JournalBatch_ID", strGL_JournalBatch_ID);
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

    private void printPageButtonEM_Ssttdef_Settle_Deferred263E1E26870C4AFEB42E770BE40B2AA2(HttpServletResponse response, VariablesSecureApp vars, String strGL_JournalBatch_ID, String stremSsttdefSettleDeferred, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 263E1E26870C4AFEB42E770BE40B2AA2");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssttdef_Settle_Deferred263E1E26870C4AFEB42E770BE40B2AA2", discard).createXmlDocument();
      xmlDocument.setParameter("key", strGL_JournalBatch_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Batch_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "263E1E26870C4AFEB42E770BE40B2AA2");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("263E1E26870C4AFEB42E770BE40B2AA2");
        vars.removeMessage("263E1E26870C4AFEB42E770BE40B2AA2");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_AcctSchema_ID", Utility.getContext(this, vars, "$C_AcctSchema_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "C_AcctSchema_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button263E1E26870C4AFEB42E770BE40B2AA2.originalParams"), comboTableData, windowId, Utility.getContext(this, vars, "$C_AcctSchema_ID", windowId));
    xmlDocument.setData("reportC_AcctSchema_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_DocType_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_DocType_ID", "", "102", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button263E1E26870C4AFEB42E770BE40B2AA2.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportC_DocType_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("GL_Category_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "GL_Category_ID", "", "118", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button263E1E26870C4AFEB42E770BE40B2AA2.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportGL_Category_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }


    void printPageButtonProcessingCD7283DF804B449C97DA09446669EEEF(HttpServletResponse response, VariablesSecureApp vars, String strGL_JournalBatch_ID, String strprocessing, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CD7283DF804B449C97DA09446669EEEF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessingCD7283DF804B449C97DA09446669EEEF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strGL_JournalBatch_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Batch_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CD7283DF804B449C97DA09446669EEEF");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CD7283DF804B449C97DA09446669EEEF");
        vars.removeMessage("CD7283DF804B449C97DA09446669EEEF");
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
