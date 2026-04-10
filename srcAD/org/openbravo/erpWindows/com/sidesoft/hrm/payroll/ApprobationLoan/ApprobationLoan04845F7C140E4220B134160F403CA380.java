
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.ApprobationLoan;


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
public class ApprobationLoan04845F7C140E4220B134160F403CA380 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "46823D326B7044E58ABA3B846E703527";
  private static final String tabId = "04845F7C140E4220B134160F403CA380";
  private static final int accesslevel = 3;
  private static final String moduleId = "169A6DDBFEB948C98F0617CE3B4CABD5";
  
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
     
      if (command.contains("CE0E3EF21BCA4722A74D03F3E2AFC5FD")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CE0E3EF21BCA4722A74D03F3E2AFC5FD");
        SessionInfo.setModuleId("6F81D9B62FD64A419913B3907E646684");
        if (securedProcess || explicitAccess.contains("CE0E3EF21BCA4722A74D03F3E2AFC5FD")) {
          classInfo.type = "P";
          classInfo.id = "CE0E3EF21BCA4722A74D03F3E2AFC5FD";
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

     } else if (vars.commandIn("BUTTONEM_Sspi_Approved_LoanCE0E3EF21BCA4722A74D03F3E2AFC5FD")) {
        vars.setSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.stremSspiApprovedLoan", vars.getStringParameter("inpemSspiApprovedLoan"));
        vars.setSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CE0E3EF21BCA4722A74D03F3E2AFC5FD", request.getServletPath());    
     } else if (vars.commandIn("BUTTONCE0E3EF21BCA4722A74D03F3E2AFC5FD")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpssprLoansId", windowId + "|Sspr_Loans_ID", "");
        String stremSspiApprovedLoan = vars.getSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.stremSspiApprovedLoan");
        String strProcessing = vars.getSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.strProcessing");
        String strOrg = vars.getSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.strOrg");
        String strClient = vars.getSessionValue("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sspi_Approved_LoanCE0E3EF21BCA4722A74D03F3E2AFC5FD(response, vars, strSspr_Loans_ID, stremSspiApprovedLoan, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Sspi_Approved_LoanCE0E3EF21BCA4722A74D03F3E2AFC5FD")) {
        String strSspr_Loans_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Loans_ID", "");
        String stremSspiApprovedLoan = vars.getStringParameter("inpemSspiApprovedLoan");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "CE0E3EF21BCA4722A74D03F3E2AFC5FD", (("Sspr_Loans_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Loans_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstatusdoc = vars.getStringParameter("inpstatusdoc");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "statusdoc", strstatusdoc, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonEM_Sspi_Approved_LoanCE0E3EF21BCA4722A74D03F3E2AFC5FD(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Loans_ID, String stremSspiApprovedLoan, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CE0E3EF21BCA4722A74D03F3E2AFC5FD");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sspi_Approved_LoanCE0E3EF21BCA4722A74D03F3E2AFC5FD", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Loans_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ApprobationLoan04845F7C140E4220B134160F403CA380_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CE0E3EF21BCA4722A74D03F3E2AFC5FD");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CE0E3EF21BCA4722A74D03F3E2AFC5FD");
        vars.removeMessage("CE0E3EF21BCA4722A74D03F3E2AFC5FD");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("statusdoc", "");
    comboTableData = new ComboTableData(vars, this, "17", "statusdoc", "C26EF961F35449E4B116955B9C29C1C2", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonCE0E3EF21BCA4722A74D03F3E2AFC5FD.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportstatusdoc", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
