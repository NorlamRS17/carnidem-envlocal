
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.early.payment.AdvancePayment;


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
public class AdvancePaymentAEEEB8CBBE3E4665A6EA3CED390E25FD extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "2051044732DC473D8D9802953120CD54";
  private static final String tabId = "AEEEB8CBBE3E4665A6EA3CED390E25FD";
  private static final int accesslevel = 3;
  private static final String moduleId = "6F883593A27A4C6DA4D61CCC178A1F64";
  
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
     
      if (command.contains("C4EBF9C94C8F4180B9A0053F8A642ACE")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("C4EBF9C94C8F4180B9A0053F8A642ACE");
        SessionInfo.setModuleId("6F883593A27A4C6DA4D61CCC178A1F64");
        if (securedProcess || explicitAccess.contains("C4EBF9C94C8F4180B9A0053F8A642ACE")) {
          classInfo.type = "P";
          classInfo.id = "C4EBF9C94C8F4180B9A0053F8A642ACE";
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

     } else if (vars.commandIn("BUTTONProcessedC4EBF9C94C8F4180B9A0053F8A642ACE")) {
        vars.setSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "C4EBF9C94C8F4180B9A0053F8A642ACE", request.getServletPath());    
     } else if (vars.commandIn("BUTTONC4EBF9C94C8F4180B9A0053F8A642ACE")) {
        String strSpep_Advance_Payment_ID = vars.getGlobalVariable("inpspepAdvancePaymentId", windowId + "|Spep_Advance_Payment_ID", "");
        String strprocessed = vars.getSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strprocessed");
        String strProcessing = vars.getSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strProcessing");
        String strOrg = vars.getSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strOrg");
        String strClient = vars.getSessionValue("buttonC4EBF9C94C8F4180B9A0053F8A642ACE.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedC4EBF9C94C8F4180B9A0053F8A642ACE(response, vars, strSpep_Advance_Payment_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessedC4EBF9C94C8F4180B9A0053F8A642ACE")) {
        String strSpep_Advance_Payment_ID = vars.getGlobalVariable("inpKey", windowId + "|Spep_Advance_Payment_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "C4EBF9C94C8F4180B9A0053F8A642ACE", (("Spep_Advance_Payment_ID".equalsIgnoreCase("AD_Language"))?"0":strSpep_Advance_Payment_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcessedC4EBF9C94C8F4180B9A0053F8A642ACE(HttpServletResponse response, VariablesSecureApp vars, String strSpep_Advance_Payment_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process C4EBF9C94C8F4180B9A0053F8A642ACE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedC4EBF9C94C8F4180B9A0053F8A642ACE", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSpep_Advance_Payment_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AdvancePaymentAEEEB8CBBE3E4665A6EA3CED390E25FD_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "C4EBF9C94C8F4180B9A0053F8A642ACE");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("C4EBF9C94C8F4180B9A0053F8A642ACE");
        vars.removeMessage("C4EBF9C94C8F4180B9A0053F8A642ACE");
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
