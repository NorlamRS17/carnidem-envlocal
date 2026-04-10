
package org.openbravo.erpWindows.ec.com.sidesoft.production.MaintenanceOrder;




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
public class Order965B2EE3597041BF9E815EA4E0683B6B extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E052C86CC62E42C19CE097A03E178558";
  private static final String tabId = "965B2EE3597041BF9E815EA4E0683B6B";
  private static final int accesslevel = 3;
  private static final String moduleId = "5E14FED226704A078CA8F5B5A9F0B6CA";
  
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
     
      if (command.contains("B8E6E808CF5645669553E79F67936C5A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B8E6E808CF5645669553E79F67936C5A");
        SessionInfo.setModuleId("9EC24C30D2754E3E9819C1C0A336B53D");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("B8E6E808CF5645669553E79F67936C5A") || (securedProcess && command.contains("B8E6E808CF5645669553E79F67936C5A"))) {
        classInfo.type = "P";
        classInfo.id = "B8E6E808CF5645669553E79F67936C5A";
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

    } else if (vars.commandIn("BUTTONEM_Scma_BtnapproveB8E6E808CF5645669553E79F67936C5A")) {
        vars.setSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.stremScmaBtnapprove", vars.getStringParameter("inpemScmaBtnapprove"));
        vars.setSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB8E6E808CF5645669553E79F67936C5A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B8E6E808CF5645669553E79F67936C5A", request.getServletPath());
      } else if (vars.commandIn("BUTTONB8E6E808CF5645669553E79F67936C5A")) {
        String strMA_Maint_Part_ID = vars.getGlobalVariable("inpmaMaintPartId", windowId + "|MA_Maint_Part_ID", "");
        String stremScmaBtnapprove = vars.getSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.stremScmaBtnapprove");
        String strProcessing = vars.getSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.strProcessing");
        String strOrg = vars.getSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.strOrg");
        String strClient = vars.getSessionValue("buttonB8E6E808CF5645669553E79F67936C5A.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Scma_BtnapproveB8E6E808CF5645669553E79F67936C5A(response, vars, strMA_Maint_Part_ID, stremScmaBtnapprove, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Scma_BtnapproveB8E6E808CF5645669553E79F67936C5A")) {
        String strMA_Maint_Part_ID = vars.getGlobalVariable("inpKey", windowId + "|MA_Maint_Part_ID", "");
        
        ProcessBundle pb = new ProcessBundle("B8E6E808CF5645669553E79F67936C5A", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("MA_Maint_Part_ID", strMA_Maint_Part_ID);
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



    void printPageButtonEM_Scma_BtnapproveB8E6E808CF5645669553E79F67936C5A(HttpServletResponse response, VariablesSecureApp vars, String strMA_Maint_Part_ID, String stremScmaBtnapprove, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B8E6E808CF5645669553E79F67936C5A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Scma_BtnapproveB8E6E808CF5645669553E79F67936C5A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMA_Maint_Part_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Order965B2EE3597041BF9E815EA4E0683B6B_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B8E6E808CF5645669553E79F67936C5A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B8E6E808CF5645669553E79F67936C5A");
        vars.removeMessage("B8E6E808CF5645669553E79F67936C5A");
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
