
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.AutomaticPayroll;


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
public class AutomaticPayroll2F7E5E4DC88F4F44995243DAE0EA4664 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "9014CCFBDDB6435797D2D1DA812EBFE5";
  private static final String tabId = "2F7E5E4DC88F4F44995243DAE0EA4664";
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
     
      if (command.contains("DF4E2B745B914942866105844E4ECFFC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DF4E2B745B914942866105844E4ECFFC");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("DF4E2B745B914942866105844E4ECFFC") || (securedProcess && command.contains("DF4E2B745B914942866105844E4ECFFC"))) {
        classInfo.type = "P";
        classInfo.id = "DF4E2B745B914942866105844E4ECFFC";
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

    } else if (vars.commandIn("BUTTONProcessedDF4E2B745B914942866105844E4ECFFC")) {
        vars.setSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDF4E2B745B914942866105844E4ECFFC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DF4E2B745B914942866105844E4ECFFC", request.getServletPath());
      } else if (vars.commandIn("BUTTONDF4E2B745B914942866105844E4ECFFC")) {
        String strSspr_Payroll_Aut_ID = vars.getGlobalVariable("inpssprPayrollAutId", windowId + "|Sspr_Payroll_Aut_ID", "");
        String strprocessed = vars.getSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strprocessed");
        String strProcessing = vars.getSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strProcessing");
        String strOrg = vars.getSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strOrg");
        String strClient = vars.getSessionValue("buttonDF4E2B745B914942866105844E4ECFFC.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedDF4E2B745B914942866105844E4ECFFC(response, vars, strSspr_Payroll_Aut_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessedDF4E2B745B914942866105844E4ECFFC")) {
        String strSspr_Payroll_Aut_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Payroll_Aut_ID", "");
        
        ProcessBundle pb = new ProcessBundle("DF4E2B745B914942866105844E4ECFFC", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sspr_Payroll_Aut_ID", strSspr_Payroll_Aut_ID);
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



    void printPageButtonProcessedDF4E2B745B914942866105844E4ECFFC(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Payroll_Aut_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DF4E2B745B914942866105844E4ECFFC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedDF4E2B745B914942866105844E4ECFFC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Payroll_Aut_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AutomaticPayroll2F7E5E4DC88F4F44995243DAE0EA4664_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DF4E2B745B914942866105844E4ECFFC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DF4E2B745B914942866105844E4ECFFC");
        vars.removeMessage("DF4E2B745B914942866105844E4ECFFC");
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
