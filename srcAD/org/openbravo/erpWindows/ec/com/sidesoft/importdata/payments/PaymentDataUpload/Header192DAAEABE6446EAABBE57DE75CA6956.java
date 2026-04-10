
package org.openbravo.erpWindows.ec.com.sidesoft.importdata.payments.PaymentDataUpload;




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
public class Header192DAAEABE6446EAABBE57DE75CA6956 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "4449C1F0BBF04ECA96345ACAF5DE2E9F";
  private static final String tabId = "192DAAEABE6446EAABBE57DE75CA6956";
  private static final int accesslevel = 7;
  private static final String moduleId = "789FFE6975084F6AA13282D62778050D";
  
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
     
      if (command.contains("00AB8AD197244C8EAA90B9D7A79ABCE4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("00AB8AD197244C8EAA90B9D7A79ABCE4");
        SessionInfo.setModuleId("789FFE6975084F6AA13282D62778050D");
      }
     
      if (command.contains("F873EC6D50E44F878E9505AF20394AC0")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F873EC6D50E44F878E9505AF20394AC0");
        SessionInfo.setModuleId("789FFE6975084F6AA13282D62778050D");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("00AB8AD197244C8EAA90B9D7A79ABCE4") || (securedProcess && command.contains("00AB8AD197244C8EAA90B9D7A79ABCE4"))) {
        classInfo.type = "P";
        classInfo.id = "00AB8AD197244C8EAA90B9D7A79ABCE4";
      }
     
      if (explicitAccess.contains("F873EC6D50E44F878E9505AF20394AC0") || (securedProcess && command.contains("F873EC6D50E44F878E9505AF20394AC0"))) {
        classInfo.type = "P";
        classInfo.id = "F873EC6D50E44F878E9505AF20394AC0";
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

    } else if (vars.commandIn("BUTTONLoad_Lines00AB8AD197244C8EAA90B9D7A79ABCE4")) {
        vars.setSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strloadLines", vars.getStringParameter("inploadLines"));
        vars.setSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button00AB8AD197244C8EAA90B9D7A79ABCE4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "00AB8AD197244C8EAA90B9D7A79ABCE4", request.getServletPath());
      } else if (vars.commandIn("BUTTON00AB8AD197244C8EAA90B9D7A79ABCE4")) {
        String strSimppys_PaymentDataUpload_ID = vars.getGlobalVariable("inpsimppysPaymentdatauploadId", windowId + "|Simppys_PaymentDataUpload_ID", "");
        String strloadLines = vars.getSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strloadLines");
        String strProcessing = vars.getSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strProcessing");
        String strOrg = vars.getSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strOrg");
        String strClient = vars.getSessionValue("button00AB8AD197244C8EAA90B9D7A79ABCE4.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_Lines00AB8AD197244C8EAA90B9D7A79ABCE4(response, vars, strSimppys_PaymentDataUpload_ID, strloadLines, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcessF873EC6D50E44F878E9505AF20394AC0")) {
        vars.setSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF873EC6D50E44F878E9505AF20394AC0.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F873EC6D50E44F878E9505AF20394AC0", request.getServletPath());
      } else if (vars.commandIn("BUTTONF873EC6D50E44F878E9505AF20394AC0")) {
        String strSimppys_PaymentDataUpload_ID = vars.getGlobalVariable("inpsimppysPaymentdatauploadId", windowId + "|Simppys_PaymentDataUpload_ID", "");
        String strprocess = vars.getSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strprocess");
        String strProcessing = vars.getSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strProcessing");
        String strOrg = vars.getSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strOrg");
        String strClient = vars.getSessionValue("buttonF873EC6D50E44F878E9505AF20394AC0.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessF873EC6D50E44F878E9505AF20394AC0(response, vars, strSimppys_PaymentDataUpload_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONLoad_Lines00AB8AD197244C8EAA90B9D7A79ABCE4")) {
        String strSimppys_PaymentDataUpload_ID = vars.getGlobalVariable("inpKey", windowId + "|Simppys_PaymentDataUpload_ID", "");
        
        ProcessBundle pb = new ProcessBundle("00AB8AD197244C8EAA90B9D7A79ABCE4", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Simppys_PaymentDataUpload_ID", strSimppys_PaymentDataUpload_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONProcessF873EC6D50E44F878E9505AF20394AC0")) {
        String strSimppys_PaymentDataUpload_ID = vars.getGlobalVariable("inpKey", windowId + "|Simppys_PaymentDataUpload_ID", "");
        
        ProcessBundle pb = new ProcessBundle("F873EC6D50E44F878E9505AF20394AC0", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Simppys_PaymentDataUpload_ID", strSimppys_PaymentDataUpload_ID);
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



    void printPageButtonLoad_Lines00AB8AD197244C8EAA90B9D7A79ABCE4(HttpServletResponse response, VariablesSecureApp vars, String strSimppys_PaymentDataUpload_ID, String strloadLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 00AB8AD197244C8EAA90B9D7A79ABCE4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_Lines00AB8AD197244C8EAA90B9D7A79ABCE4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSimppys_PaymentDataUpload_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header192DAAEABE6446EAABBE57DE75CA6956_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "00AB8AD197244C8EAA90B9D7A79ABCE4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("00AB8AD197244C8EAA90B9D7A79ABCE4");
        vars.removeMessage("00AB8AD197244C8EAA90B9D7A79ABCE4");
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
    void printPageButtonProcessF873EC6D50E44F878E9505AF20394AC0(HttpServletResponse response, VariablesSecureApp vars, String strSimppys_PaymentDataUpload_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F873EC6D50E44F878E9505AF20394AC0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessF873EC6D50E44F878E9505AF20394AC0", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSimppys_PaymentDataUpload_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header192DAAEABE6446EAABBE57DE75CA6956_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F873EC6D50E44F878E9505AF20394AC0");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F873EC6D50E44F878E9505AF20394AC0");
        vars.removeMessage("F873EC6D50E44F878E9505AF20394AC0");
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
