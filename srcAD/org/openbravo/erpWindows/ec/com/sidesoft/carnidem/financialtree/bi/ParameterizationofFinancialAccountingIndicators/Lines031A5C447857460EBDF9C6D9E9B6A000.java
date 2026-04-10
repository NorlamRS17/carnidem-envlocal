
package org.openbravo.erpWindows.ec.com.sidesoft.carnidem.financialtree.bi.ParameterizationofFinancialAccountingIndicators;


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
public class Lines031A5C447857460EBDF9C6D9E9B6A000 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "1CB6E4B9F2524B9198B1B50DD201F0D0";
  private static final String tabId = "031A5C447857460EBDF9C6D9E9B6A000";
  private static final int accesslevel = 7;
  private static final String moduleId = "9CED5287F172470A850CF24DF9940E4E";
  
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
     
      if (command.contains("F5AC444D850A4348AA3C70F170842E7D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F5AC444D850A4348AA3C70F170842E7D");
        SessionInfo.setModuleId("9CED5287F172470A850CF24DF9940E4E");
        if (securedProcess || explicitAccess.contains("F5AC444D850A4348AA3C70F170842E7D")) {
          classInfo.type = "P";
          classInfo.id = "F5AC444D850A4348AA3C70F170842E7D";
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

     } else if (vars.commandIn("BUTTONBulk_Upload_AcctaccountF5AC444D850A4348AA3C70F170842E7D")) {
        vars.setSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strbulkUploadAcctaccount", vars.getStringParameter("inpbulkUploadAcctaccount"));
        vars.setSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF5AC444D850A4348AA3C70F170842E7D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F5AC444D850A4348AA3C70F170842E7D", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF5AC444D850A4348AA3C70F170842E7D")) {
        String strScft_Finan_Acct_Ind_ID = vars.getGlobalVariable("inpscftFinanAcctIndId", windowId + "|Scft_Finan_Acct_Ind_ID", "");
        String strbulkUploadAcctaccount = vars.getSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strbulkUploadAcctaccount");
        String strProcessing = vars.getSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strProcessing");
        String strOrg = vars.getSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strOrg");
        String strClient = vars.getSessionValue("buttonF5AC444D850A4348AA3C70F170842E7D.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBulk_Upload_AcctaccountF5AC444D850A4348AA3C70F170842E7D(response, vars, strScft_Finan_Acct_Ind_ID, strbulkUploadAcctaccount, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBulk_Upload_AcctaccountF5AC444D850A4348AA3C70F170842E7D")) {
        String strScft_Finan_Acct_Ind_ID = vars.getGlobalVariable("inpKey", windowId + "|Scft_Finan_Acct_Ind_ID", "");
        String strbulkUploadAcctaccount = vars.getStringParameter("inpbulkUploadAcctaccount");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F5AC444D850A4348AA3C70F170842E7D", (("Scft_Finan_Acct_Ind_ID".equalsIgnoreCase("AD_Language"))?"0":strScft_Finan_Acct_Ind_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcElementvalueId = vars.getStringParameter("inpcElementvalueId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_ElementValue_ID", strcElementvalueId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonBulk_Upload_AcctaccountF5AC444D850A4348AA3C70F170842E7D(HttpServletResponse response, VariablesSecureApp vars, String strScft_Finan_Acct_Ind_ID, String strbulkUploadAcctaccount, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F5AC444D850A4348AA3C70F170842E7D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Bulk_Upload_AcctaccountF5AC444D850A4348AA3C70F170842E7D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScft_Finan_Acct_Ind_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Lines031A5C447857460EBDF9C6D9E9B6A000_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F5AC444D850A4348AA3C70F170842E7D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F5AC444D850A4348AA3C70F170842E7D");
        vars.removeMessage("F5AC444D850A4348AA3C70F170842E7D");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("C_ElementValue_ID", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
