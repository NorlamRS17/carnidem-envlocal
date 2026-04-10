
package org.openbravo.erpWindows.ec.com.sidesoft.localization.importdata.loadvouchers.LoadVoucherInvoice;


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
public class Voucherpurchase13BBF55F24F348338B077C723B74C42F extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "AB6447D2F0424300B2DC95205B0B631A";
  private static final String tabId = "13BBF55F24F348338B077C723B74C42F";
  private static final int accesslevel = 3;
  private static final String moduleId = "F44F4C3B807A442BB18347B9182B6CDE";
  
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
     
      if (command.contains("0C26D138283A4702AE8657D0B2755511")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("0C26D138283A4702AE8657D0B2755511");
        SessionInfo.setModuleId("F44F4C3B807A442BB18347B9182B6CDE");
      }
     
      if (command.contains("D244C9919E6747AD9DF9B43D1E1C6233")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D244C9919E6747AD9DF9B43D1E1C6233");
        SessionInfo.setModuleId("F44F4C3B807A442BB18347B9182B6CDE");
      }
     
      if (command.contains("29604C7EF05B44C0AA36ACF4CF48528A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("29604C7EF05B44C0AA36ACF4CF48528A");
        SessionInfo.setModuleId("F44F4C3B807A442BB18347B9182B6CDE");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("0C26D138283A4702AE8657D0B2755511") || (securedProcess && command.contains("0C26D138283A4702AE8657D0B2755511"))) {
        classInfo.type = "P";
        classInfo.id = "0C26D138283A4702AE8657D0B2755511";
      }
     
      if (explicitAccess.contains("D244C9919E6747AD9DF9B43D1E1C6233") || (securedProcess && command.contains("D244C9919E6747AD9DF9B43D1E1C6233"))) {
        classInfo.type = "P";
        classInfo.id = "D244C9919E6747AD9DF9B43D1E1C6233";
      }
     
      if (explicitAccess.contains("29604C7EF05B44C0AA36ACF4CF48528A") || (securedProcess && command.contains("29604C7EF05B44C0AA36ACF4CF48528A"))) {
        classInfo.type = "P";
        classInfo.id = "29604C7EF05B44C0AA36ACF4CF48528A";
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

    } else if (vars.commandIn("BUTTONDataload0C26D138283A4702AE8657D0B2755511")) {
        vars.setSessionValue("button0C26D138283A4702AE8657D0B2755511.strdataload", vars.getStringParameter("inpdataload"));
        vars.setSessionValue("button0C26D138283A4702AE8657D0B2755511.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0C26D138283A4702AE8657D0B2755511.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0C26D138283A4702AE8657D0B2755511.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0C26D138283A4702AE8657D0B2755511.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0C26D138283A4702AE8657D0B2755511", request.getServletPath());
      } else if (vars.commandIn("BUTTON0C26D138283A4702AE8657D0B2755511")) {
        String strImdlv_Voucher_Purchase_ID = vars.getGlobalVariable("inpimdlvVoucherPurchaseId", windowId + "|Imdlv_Voucher_Purchase_ID", "");
        String strdataload = vars.getSessionValue("button0C26D138283A4702AE8657D0B2755511.strdataload");
        String strProcessing = vars.getSessionValue("button0C26D138283A4702AE8657D0B2755511.strProcessing");
        String strOrg = vars.getSessionValue("button0C26D138283A4702AE8657D0B2755511.strOrg");
        String strClient = vars.getSessionValue("button0C26D138283A4702AE8657D0B2755511.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDataload0C26D138283A4702AE8657D0B2755511(response, vars, strImdlv_Voucher_Purchase_ID, strdataload, strProcessing);
        }
    } else if (vars.commandIn("BUTTONCreatelinesD244C9919E6747AD9DF9B43D1E1C6233")) {
        vars.setSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strcreatelines", vars.getStringParameter("inpcreatelines"));
        vars.setSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD244C9919E6747AD9DF9B43D1E1C6233.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D244C9919E6747AD9DF9B43D1E1C6233", request.getServletPath());
      } else if (vars.commandIn("BUTTOND244C9919E6747AD9DF9B43D1E1C6233")) {
        String strImdlv_Voucher_Purchase_ID = vars.getGlobalVariable("inpimdlvVoucherPurchaseId", windowId + "|Imdlv_Voucher_Purchase_ID", "");
        String strcreatelines = vars.getSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strcreatelines");
        String strProcessing = vars.getSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strProcessing");
        String strOrg = vars.getSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strOrg");
        String strClient = vars.getSessionValue("buttonD244C9919E6747AD9DF9B43D1E1C6233.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatelinesD244C9919E6747AD9DF9B43D1E1C6233(response, vars, strImdlv_Voucher_Purchase_ID, strcreatelines, strProcessing);
        }
    } else if (vars.commandIn("BUTTONCreatetrx229604C7EF05B44C0AA36ACF4CF48528A")) {
        vars.setSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strcreatetrx2", vars.getStringParameter("inpcreatetrx2"));
        vars.setSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button29604C7EF05B44C0AA36ACF4CF48528A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "29604C7EF05B44C0AA36ACF4CF48528A", request.getServletPath());
      } else if (vars.commandIn("BUTTON29604C7EF05B44C0AA36ACF4CF48528A")) {
        String strImdlv_Voucher_Purchase_ID = vars.getGlobalVariable("inpimdlvVoucherPurchaseId", windowId + "|Imdlv_Voucher_Purchase_ID", "");
        String strcreatetrx2 = vars.getSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strcreatetrx2");
        String strProcessing = vars.getSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strProcessing");
        String strOrg = vars.getSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strOrg");
        String strClient = vars.getSessionValue("button29604C7EF05B44C0AA36ACF4CF48528A.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatetrx229604C7EF05B44C0AA36ACF4CF48528A(response, vars, strImdlv_Voucher_Purchase_ID, strcreatetrx2, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONDataload0C26D138283A4702AE8657D0B2755511")) {
        String strImdlv_Voucher_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|Imdlv_Voucher_Purchase_ID", "");
        
        ProcessBundle pb = new ProcessBundle("0C26D138283A4702AE8657D0B2755511", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Imdlv_Voucher_Purchase_ID", strImdlv_Voucher_Purchase_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONCreatelinesD244C9919E6747AD9DF9B43D1E1C6233")) {
        String strImdlv_Voucher_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|Imdlv_Voucher_Purchase_ID", "");
        
        ProcessBundle pb = new ProcessBundle("D244C9919E6747AD9DF9B43D1E1C6233", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Imdlv_Voucher_Purchase_ID", strImdlv_Voucher_Purchase_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONCreatetrx229604C7EF05B44C0AA36ACF4CF48528A")) {
        String strImdlv_Voucher_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|Imdlv_Voucher_Purchase_ID", "");
        
        ProcessBundle pb = new ProcessBundle("29604C7EF05B44C0AA36ACF4CF48528A", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Imdlv_Voucher_Purchase_ID", strImdlv_Voucher_Purchase_ID);
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



    void printPageButtonDataload0C26D138283A4702AE8657D0B2755511(HttpServletResponse response, VariablesSecureApp vars, String strImdlv_Voucher_Purchase_ID, String strdataload, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0C26D138283A4702AE8657D0B2755511");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Dataload0C26D138283A4702AE8657D0B2755511", discard).createXmlDocument();
      xmlDocument.setParameter("key", strImdlv_Voucher_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Voucherpurchase13BBF55F24F348338B077C723B74C42F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "0C26D138283A4702AE8657D0B2755511");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("0C26D138283A4702AE8657D0B2755511");
        vars.removeMessage("0C26D138283A4702AE8657D0B2755511");
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
    void printPageButtonCreatelinesD244C9919E6747AD9DF9B43D1E1C6233(HttpServletResponse response, VariablesSecureApp vars, String strImdlv_Voucher_Purchase_ID, String strcreatelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D244C9919E6747AD9DF9B43D1E1C6233");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreatelinesD244C9919E6747AD9DF9B43D1E1C6233", discard).createXmlDocument();
      xmlDocument.setParameter("key", strImdlv_Voucher_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Voucherpurchase13BBF55F24F348338B077C723B74C42F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D244C9919E6747AD9DF9B43D1E1C6233");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D244C9919E6747AD9DF9B43D1E1C6233");
        vars.removeMessage("D244C9919E6747AD9DF9B43D1E1C6233");
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
    void printPageButtonCreatetrx229604C7EF05B44C0AA36ACF4CF48528A(HttpServletResponse response, VariablesSecureApp vars, String strImdlv_Voucher_Purchase_ID, String strcreatetrx2, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 29604C7EF05B44C0AA36ACF4CF48528A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Createtrx229604C7EF05B44C0AA36ACF4CF48528A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strImdlv_Voucher_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Voucherpurchase13BBF55F24F348338B077C723B74C42F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "29604C7EF05B44C0AA36ACF4CF48528A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("29604C7EF05B44C0AA36ACF4CF48528A");
        vars.removeMessage("29604C7EF05B44C0AA36ACF4CF48528A");
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
