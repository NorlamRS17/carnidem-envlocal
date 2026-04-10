
package org.openbravo.erpWindows.ec.com.sidesoft.localization.quality.assurement.ProductSafetyinProcess;


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
public class ProductSafetyinProcess3C53F2E59C9D4A59B785EC29FF81AAC1 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "8A5C7525F2054E8D81CFB86F0A93DDD0";
  private static final String tabId = "3C53F2E59C9D4A59B785EC29FF81AAC1";
  private static final int accesslevel = 3;
  private static final String moduleId = "E1CEC33B43934CE390EDDF0F6EA1CCA3";
  
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
     
      if (command.contains("07E58E016DF94D02B1955E1FBC5A9BCA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("07E58E016DF94D02B1955E1FBC5A9BCA");
        SessionInfo.setModuleId("E1CEC33B43934CE390EDDF0F6EA1CCA3");
        if (securedProcess || explicitAccess.contains("07E58E016DF94D02B1955E1FBC5A9BCA")) {
          classInfo.type = "P";
          classInfo.id = "07E58E016DF94D02B1955E1FBC5A9BCA";
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

     } else if (vars.commandIn("BUTTONBTN_Gen_Ctrl07E58E016DF94D02B1955E1FBC5A9BCA")) {
        vars.setSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strbtnGenCtrl", vars.getStringParameter("inpbtnGenCtrl"));
        vars.setSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button07E58E016DF94D02B1955E1FBC5A9BCA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "07E58E016DF94D02B1955E1FBC5A9BCA", request.getServletPath());    
     } else if (vars.commandIn("BUTTON07E58E016DF94D02B1955E1FBC5A9BCA")) {
        String strSlqs_Prd_Safety_V_ID = vars.getGlobalVariable("inpslqsPrdSafetyVId", windowId + "|Slqs_Prd_Safety_V_ID", "");
        String strbtnGenCtrl = vars.getSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strbtnGenCtrl");
        String strProcessing = vars.getSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strProcessing");
        String strOrg = vars.getSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strOrg");
        String strClient = vars.getSessionValue("button07E58E016DF94D02B1955E1FBC5A9BCA.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Gen_Ctrl07E58E016DF94D02B1955E1FBC5A9BCA(response, vars, strSlqs_Prd_Safety_V_ID, strbtnGenCtrl, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBTN_Gen_Ctrl07E58E016DF94D02B1955E1FBC5A9BCA")) {
        String strSlqs_Prd_Safety_V_ID = vars.getGlobalVariable("inpKey", windowId + "|Slqs_Prd_Safety_V_ID", "");
        String strbtnGenCtrl = vars.getStringParameter("inpbtnGenCtrl");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "07E58E016DF94D02B1955E1FBC5A9BCA", (("Slqs_Prd_Safety_V_ID".equalsIgnoreCase("AD_Language"))?"0":strSlqs_Prd_Safety_V_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonBTN_Gen_Ctrl07E58E016DF94D02B1955E1FBC5A9BCA(HttpServletResponse response, VariablesSecureApp vars, String strSlqs_Prd_Safety_V_ID, String strbtnGenCtrl, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 07E58E016DF94D02B1955E1FBC5A9BCA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Gen_Ctrl07E58E016DF94D02B1955E1FBC5A9BCA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSlqs_Prd_Safety_V_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProductSafetyinProcess3C53F2E59C9D4A59B785EC29FF81AAC1_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "07E58E016DF94D02B1955E1FBC5A9BCA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("07E58E016DF94D02B1955E1FBC5A9BCA");
        vars.removeMessage("07E58E016DF94D02B1955E1FBC5A9BCA");
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
