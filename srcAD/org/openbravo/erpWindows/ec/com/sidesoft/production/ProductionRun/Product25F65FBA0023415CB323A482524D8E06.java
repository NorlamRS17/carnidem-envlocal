
package org.openbravo.erpWindows.ec.com.sidesoft.production.ProductionRun;


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
public class Product25F65FBA0023415CB323A482524D8E06 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "359556B79F7A41069A987D4DDD00EB33";
  private static final String tabId = "25F65FBA0023415CB323A482524D8E06";
  private static final int accesslevel = 1;
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
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("045F42BBD5A941698172C4D688B0BE85")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("045F42BBD5A941698172C4D688B0BE85");
        SessionInfo.setModuleId("2D942B4080A6495C908A691EB3231923");
        if (securedProcess || explicitAccess.contains("045F42BBD5A941698172C4D688B0BE85")) {
          classInfo.type = "P";
          classInfo.id = "045F42BBD5A941698172C4D688B0BE85";
        }
      }
     
      if (command.contains("E9608F7A292C45E5AF845B2FEFD42712")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E9608F7A292C45E5AF845B2FEFD42712");
        SessionInfo.setModuleId("2D942B4080A6495C908A691EB3231923");
        if (securedProcess || explicitAccess.contains("E9608F7A292C45E5AF845B2FEFD42712")) {
          classInfo.type = "P";
          classInfo.id = "E9608F7A292C45E5AF845B2FEFD42712";
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

     } else if (vars.commandIn("BUTTONEM_Ssapq_Mconfirm045F42BBD5A941698172C4D688B0BE85")) {
        vars.setSessionValue("button045F42BBD5A941698172C4D688B0BE85.stremSsapqMconfirm", vars.getStringParameter("inpemSsapqMconfirm"));
        vars.setSessionValue("button045F42BBD5A941698172C4D688B0BE85.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button045F42BBD5A941698172C4D688B0BE85.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button045F42BBD5A941698172C4D688B0BE85.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button045F42BBD5A941698172C4D688B0BE85.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "045F42BBD5A941698172C4D688B0BE85", request.getServletPath());    
     } else if (vars.commandIn("BUTTON045F42BBD5A941698172C4D688B0BE85")) {
        String strM_ProductionLine_ID = vars.getGlobalVariable("inpmProductionlineId", windowId + "|M_ProductionLine_ID", "");
        String stremSsapqMconfirm = vars.getSessionValue("button045F42BBD5A941698172C4D688B0BE85.stremSsapqMconfirm");
        String strProcessing = vars.getSessionValue("button045F42BBD5A941698172C4D688B0BE85.strProcessing");
        String strOrg = vars.getSessionValue("button045F42BBD5A941698172C4D688B0BE85.strOrg");
        String strClient = vars.getSessionValue("button045F42BBD5A941698172C4D688B0BE85.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssapq_Mconfirm045F42BBD5A941698172C4D688B0BE85(response, vars, strM_ProductionLine_ID, stremSsapqMconfirm, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssapq_MunconfirmE9608F7A292C45E5AF845B2FEFD42712")) {
        vars.setSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.stremSsapqMunconfirm", vars.getStringParameter("inpemSsapqMunconfirm"));
        vars.setSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE9608F7A292C45E5AF845B2FEFD42712.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E9608F7A292C45E5AF845B2FEFD42712", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE9608F7A292C45E5AF845B2FEFD42712")) {
        String strM_ProductionLine_ID = vars.getGlobalVariable("inpmProductionlineId", windowId + "|M_ProductionLine_ID", "");
        String stremSsapqMunconfirm = vars.getSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.stremSsapqMunconfirm");
        String strProcessing = vars.getSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.strProcessing");
        String strOrg = vars.getSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.strOrg");
        String strClient = vars.getSessionValue("buttonE9608F7A292C45E5AF845B2FEFD42712.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssapq_MunconfirmE9608F7A292C45E5AF845B2FEFD42712(response, vars, strM_ProductionLine_ID, stremSsapqMunconfirm, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Ssapq_Mconfirm045F42BBD5A941698172C4D688B0BE85")) {
        String strM_ProductionLine_ID = vars.getGlobalVariable("inpKey", windowId + "|M_ProductionLine_ID", "");
        String stremSsapqMconfirm = vars.getStringParameter("inpemSsapqMconfirm");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "045F42BBD5A941698172C4D688B0BE85", (("M_ProductionLine_ID".equalsIgnoreCase("AD_Language"))?"0":strM_ProductionLine_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssapq_MunconfirmE9608F7A292C45E5AF845B2FEFD42712")) {
        String strM_ProductionLine_ID = vars.getGlobalVariable("inpKey", windowId + "|M_ProductionLine_ID", "");
        String stremSsapqMunconfirm = vars.getStringParameter("inpemSsapqMunconfirm");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E9608F7A292C45E5AF845B2FEFD42712", (("M_ProductionLine_ID".equalsIgnoreCase("AD_Language"))?"0":strM_ProductionLine_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonEM_Ssapq_Mconfirm045F42BBD5A941698172C4D688B0BE85(HttpServletResponse response, VariablesSecureApp vars, String strM_ProductionLine_ID, String stremSsapqMconfirm, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 045F42BBD5A941698172C4D688B0BE85");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssapq_Mconfirm045F42BBD5A941698172C4D688B0BE85", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_ProductionLine_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Product25F65FBA0023415CB323A482524D8E06_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "045F42BBD5A941698172C4D688B0BE85");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("045F42BBD5A941698172C4D688B0BE85");
        vars.removeMessage("045F42BBD5A941698172C4D688B0BE85");
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
    private void printPageButtonEM_Ssapq_MunconfirmE9608F7A292C45E5AF845B2FEFD42712(HttpServletResponse response, VariablesSecureApp vars, String strM_ProductionLine_ID, String stremSsapqMunconfirm, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E9608F7A292C45E5AF845B2FEFD42712");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssapq_MunconfirmE9608F7A292C45E5AF845B2FEFD42712", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_ProductionLine_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Product25F65FBA0023415CB323A482524D8E06_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E9608F7A292C45E5AF845B2FEFD42712");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E9608F7A292C45E5AF845B2FEFD42712");
        vars.removeMessage("E9608F7A292C45E5AF845B2FEFD42712");
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
