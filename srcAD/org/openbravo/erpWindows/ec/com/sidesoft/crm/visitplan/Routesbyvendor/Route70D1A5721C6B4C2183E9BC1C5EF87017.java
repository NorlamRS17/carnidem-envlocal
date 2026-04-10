
package org.openbravo.erpWindows.ec.com.sidesoft.crm.visitplan.Routesbyvendor;


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
public class Route70D1A5721C6B4C2183E9BC1C5EF87017 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "9D3B4435A7554AB88FD3A293998A7316";
  private static final String tabId = "70D1A5721C6B4C2183E9BC1C5EF87017";
  private static final int accesslevel = 3;
  private static final String moduleId = "C25456A12940481D84C1A19F8DD8B2D7";
  
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
     
      if (command.contains("E3D9A0B57AAC49EA811961A4074F5D0F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E3D9A0B57AAC49EA811961A4074F5D0F");
        SessionInfo.setModuleId("C25456A12940481D84C1A19F8DD8B2D7");
        if (securedProcess || explicitAccess.contains("E3D9A0B57AAC49EA811961A4074F5D0F")) {
          classInfo.type = "P";
          classInfo.id = "E3D9A0B57AAC49EA811961A4074F5D0F";
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

     } else if (vars.commandIn("BUTTONProcessedE3D9A0B57AAC49EA811961A4074F5D0F")) {
        vars.setSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE3D9A0B57AAC49EA811961A4074F5D0F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E3D9A0B57AAC49EA811961A4074F5D0F", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE3D9A0B57AAC49EA811961A4074F5D0F")) {
        String strScrvro_Route_ID = vars.getGlobalVariable("inpscrvroRouteId", windowId + "|Scrvro_Route_ID", "");
        String strprocessed = vars.getSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strprocessed");
        String strProcessing = vars.getSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strProcessing");
        String strOrg = vars.getSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strOrg");
        String strClient = vars.getSessionValue("buttonE3D9A0B57AAC49EA811961A4074F5D0F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessedE3D9A0B57AAC49EA811961A4074F5D0F(response, vars, strScrvro_Route_ID, strprocessed, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcessedE3D9A0B57AAC49EA811961A4074F5D0F")) {
        String strScrvro_Route_ID = vars.getGlobalVariable("inpKey", windowId + "|Scrvro_Route_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E3D9A0B57AAC49EA811961A4074F5D0F", (("Scrvro_Route_ID".equalsIgnoreCase("AD_Language"))?"0":strScrvro_Route_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonProcessedE3D9A0B57AAC49EA811961A4074F5D0F(HttpServletResponse response, VariablesSecureApp vars, String strScrvro_Route_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E3D9A0B57AAC49EA811961A4074F5D0F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessedE3D9A0B57AAC49EA811961A4074F5D0F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strScrvro_Route_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Route70D1A5721C6B4C2183E9BC1C5EF87017_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E3D9A0B57AAC49EA811961A4074F5D0F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E3D9A0B57AAC49EA811961A4074F5D0F");
        vars.removeMessage("E3D9A0B57AAC49EA811961A4074F5D0F");
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
