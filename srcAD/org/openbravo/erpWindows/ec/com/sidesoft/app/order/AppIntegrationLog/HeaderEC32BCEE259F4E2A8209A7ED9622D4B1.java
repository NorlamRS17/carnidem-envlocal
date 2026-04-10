
package org.openbravo.erpWindows.ec.com.sidesoft.app.order.AppIntegrationLog;




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
public class HeaderEC32BCEE259F4E2A8209A7ED9622D4B1 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "F26E9DF624944711BAB84EF0E1F9735C";
  private static final String tabId = "EC32BCEE259F4E2A8209A7ED9622D4B1";
  private static final int accesslevel = 3;
  private static final String moduleId = "B9A67675820C44FC860CC48FA8169276";
  
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
     
      if (command.contains("B88EEB979B6E4F92BAE22165681CA4AA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B88EEB979B6E4F92BAE22165681CA4AA");
        SessionInfo.setModuleId("B9A67675820C44FC860CC48FA8169276");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("B88EEB979B6E4F92BAE22165681CA4AA") || (securedProcess && command.contains("B88EEB979B6E4F92BAE22165681CA4AA"))) {
        classInfo.type = "P";
        classInfo.id = "B88EEB979B6E4F92BAE22165681CA4AA";
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

    } else if (vars.commandIn("BUTTONProcessB88EEB979B6E4F92BAE22165681CA4AA")) {
        vars.setSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB88EEB979B6E4F92BAE22165681CA4AA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B88EEB979B6E4F92BAE22165681CA4AA", request.getServletPath());
      } else if (vars.commandIn("BUTTONB88EEB979B6E4F92BAE22165681CA4AA")) {
        String strSsappor_Log_ID = vars.getGlobalVariable("inpssapporLogId", windowId + "|Ssappor_Log_ID", "");
        String strprocess = vars.getSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strprocess");
        String strProcessing = vars.getSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strProcessing");
        String strOrg = vars.getSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strOrg");
        String strClient = vars.getSessionValue("buttonB88EEB979B6E4F92BAE22165681CA4AA.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessB88EEB979B6E4F92BAE22165681CA4AA(response, vars, strSsappor_Log_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessB88EEB979B6E4F92BAE22165681CA4AA")) {
        String strSsappor_Log_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssappor_Log_ID", "");
        
        ProcessBundle pb = new ProcessBundle("B88EEB979B6E4F92BAE22165681CA4AA", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ssappor_Log_ID", strSsappor_Log_ID);
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



    void printPageButtonProcessB88EEB979B6E4F92BAE22165681CA4AA(HttpServletResponse response, VariablesSecureApp vars, String strSsappor_Log_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B88EEB979B6E4F92BAE22165681CA4AA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessB88EEB979B6E4F92BAE22165681CA4AA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsappor_Log_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderEC32BCEE259F4E2A8209A7ED9622D4B1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B88EEB979B6E4F92BAE22165681CA4AA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B88EEB979B6E4F92BAE22165681CA4AA");
        vars.removeMessage("B88EEB979B6E4F92BAE22165681CA4AA");
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
