
package org.openbravo.erpWindows.ec.com.sidesoft.notifications.mobileandroid.RecordofDevicesMobile;




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
public class RecordofDevicesMobile8BA0E370CDEA4F70A94CE90BA2D1C66C extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "DE0D07B8E00B4CD6B1509F16E4B1497F";
  private static final String tabId = "8BA0E370CDEA4F70A94CE90BA2D1C66C";
  private static final int accesslevel = 3;
  private static final String moduleId = "C3C06CF3B88C460B984486931F9403C9";
  
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
     
      if (command.contains("F41B28D5D2294D9B930D6D2E0C38BAEF")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F41B28D5D2294D9B930D6D2E0C38BAEF");
        SessionInfo.setModuleId("C3C06CF3B88C460B984486931F9403C9");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("F41B28D5D2294D9B930D6D2E0C38BAEF") || (securedProcess && command.contains("F41B28D5D2294D9B930D6D2E0C38BAEF"))) {
        classInfo.type = "P";
        classInfo.id = "F41B28D5D2294D9B930D6D2E0C38BAEF";
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

    } else if (vars.commandIn("BUTTONTest_Push_NotifyF41B28D5D2294D9B930D6D2E0C38BAEF")) {
        vars.setSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strtestPushNotify", vars.getStringParameter("inptestPushNotify"));
        vars.setSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F41B28D5D2294D9B930D6D2E0C38BAEF", request.getServletPath());
      } else if (vars.commandIn("BUTTONF41B28D5D2294D9B930D6D2E0C38BAEF")) {
        String strSnma_Devices_ID = vars.getGlobalVariable("inpsnmaDevicesId", windowId + "|Snma_Devices_ID", "");
        String strtestPushNotify = vars.getSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strtestPushNotify");
        String strProcessing = vars.getSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strProcessing");
        String strOrg = vars.getSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strOrg");
        String strClient = vars.getSessionValue("buttonF41B28D5D2294D9B930D6D2E0C38BAEF.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonTest_Push_NotifyF41B28D5D2294D9B930D6D2E0C38BAEF(response, vars, strSnma_Devices_ID, strtestPushNotify, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONTest_Push_NotifyF41B28D5D2294D9B930D6D2E0C38BAEF")) {
        String strSnma_Devices_ID = vars.getGlobalVariable("inpKey", windowId + "|Snma_Devices_ID", "");
        
        ProcessBundle pb = new ProcessBundle("F41B28D5D2294D9B930D6D2E0C38BAEF", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Snma_Devices_ID", strSnma_Devices_ID);
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



    void printPageButtonTest_Push_NotifyF41B28D5D2294D9B930D6D2E0C38BAEF(HttpServletResponse response, VariablesSecureApp vars, String strSnma_Devices_ID, String strtestPushNotify, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F41B28D5D2294D9B930D6D2E0C38BAEF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Test_Push_NotifyF41B28D5D2294D9B930D6D2E0C38BAEF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSnma_Devices_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "RecordofDevicesMobile8BA0E370CDEA4F70A94CE90BA2D1C66C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F41B28D5D2294D9B930D6D2E0C38BAEF");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F41B28D5D2294D9B930D6D2E0C38BAEF");
        vars.removeMessage("F41B28D5D2294D9B930D6D2E0C38BAEF");
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
