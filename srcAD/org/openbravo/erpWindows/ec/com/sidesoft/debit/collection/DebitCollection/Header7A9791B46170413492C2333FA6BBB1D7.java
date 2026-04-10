
package org.openbravo.erpWindows.ec.com.sidesoft.debit.collection.DebitCollection;


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
public class Header7A9791B46170413492C2333FA6BBB1D7 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "448F744C9DC544B7ADEB3F70E78C458D";
  private static final String tabId = "7A9791B46170413492C2333FA6BBB1D7";
  private static final int accesslevel = 3;
  private static final String moduleId = "225C05AF2BF6454795344AA0ECC32E61";
  
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
     
      if (command.contains("A3D36D357A9F48DDB7507FCADC8465F3")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A3D36D357A9F48DDB7507FCADC8465F3");
        SessionInfo.setModuleId("225C05AF2BF6454795344AA0ECC32E61");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("F89D98E2478B4FF6856678A9D76AE645")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F89D98E2478B4FF6856678A9D76AE645");
        SessionInfo.setModuleId("225C05AF2BF6454795344AA0ECC32E61");
        if (securedProcess || explicitAccess.contains("F89D98E2478B4FF6856678A9D76AE645")) {
          classInfo.type = "P";
          classInfo.id = "F89D98E2478B4FF6856678A9D76AE645";
        }
      }
     
      if (command.contains("05B38539B3A74EF3B3F40F625862E807")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("05B38539B3A74EF3B3F40F625862E807");
        SessionInfo.setModuleId("225C05AF2BF6454795344AA0ECC32E61");
        if (securedProcess || explicitAccess.contains("05B38539B3A74EF3B3F40F625862E807")) {
          classInfo.type = "P";
          classInfo.id = "05B38539B3A74EF3B3F40F625862E807";
        }
      }
     
      if (command.contains("A43E4972B01443BE903852BD9C5AE26C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A43E4972B01443BE903852BD9C5AE26C");
        SessionInfo.setModuleId("225C05AF2BF6454795344AA0ECC32E61");
        if (securedProcess || explicitAccess.contains("A43E4972B01443BE903852BD9C5AE26C")) {
          classInfo.type = "P";
          classInfo.id = "A43E4972B01443BE903852BD9C5AE26C";
        }
      }
     

     
      if (explicitAccess.contains("A3D36D357A9F48DDB7507FCADC8465F3") || (securedProcess && command.contains("A3D36D357A9F48DDB7507FCADC8465F3"))) {
        classInfo.type = "P";
        classInfo.id = "A3D36D357A9F48DDB7507FCADC8465F3";
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

     } else if (vars.commandIn("BUTTONRemove_LinesF89D98E2478B4FF6856678A9D76AE645")) {
        vars.setSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strremoveLines", vars.getStringParameter("inpremoveLines"));
        vars.setSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF89D98E2478B4FF6856678A9D76AE645.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F89D98E2478B4FF6856678A9D76AE645", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF89D98E2478B4FF6856678A9D76AE645")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpsdcDebitcollectId", windowId + "|SDC_Debitcollect_ID", "");
        String strremoveLines = vars.getSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strremoveLines");
        String strProcessing = vars.getSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strProcessing");
        String strOrg = vars.getSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strOrg");
        String strClient = vars.getSessionValue("buttonF89D98E2478B4FF6856678A9D76AE645.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonRemove_LinesF89D98E2478B4FF6856678A9D76AE645(response, vars, strSDC_Debitcollect_ID, strremoveLines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReconcile05B38539B3A74EF3B3F40F625862E807")) {
        vars.setSessionValue("button05B38539B3A74EF3B3F40F625862E807.strreconcile", vars.getStringParameter("inpreconcile"));
        vars.setSessionValue("button05B38539B3A74EF3B3F40F625862E807.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button05B38539B3A74EF3B3F40F625862E807.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button05B38539B3A74EF3B3F40F625862E807.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button05B38539B3A74EF3B3F40F625862E807.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "05B38539B3A74EF3B3F40F625862E807", request.getServletPath());    
     } else if (vars.commandIn("BUTTON05B38539B3A74EF3B3F40F625862E807")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpsdcDebitcollectId", windowId + "|SDC_Debitcollect_ID", "");
        String strreconcile = vars.getSessionValue("button05B38539B3A74EF3B3F40F625862E807.strreconcile");
        String strProcessing = vars.getSessionValue("button05B38539B3A74EF3B3F40F625862E807.strProcessing");
        String strOrg = vars.getSessionValue("button05B38539B3A74EF3B3F40F625862E807.strOrg");
        String strClient = vars.getSessionValue("button05B38539B3A74EF3B3F40F625862E807.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReconcile05B38539B3A74EF3B3F40F625862E807(response, vars, strSDC_Debitcollect_ID, strreconcile, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessA43E4972B01443BE903852BD9C5AE26C")) {
        vars.setSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA43E4972B01443BE903852BD9C5AE26C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A43E4972B01443BE903852BD9C5AE26C", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA43E4972B01443BE903852BD9C5AE26C")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpsdcDebitcollectId", windowId + "|SDC_Debitcollect_ID", "");
        String strprocess = vars.getSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strprocess");
        String strProcessing = vars.getSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strProcessing");
        String strOrg = vars.getSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strOrg");
        String strClient = vars.getSessionValue("buttonA43E4972B01443BE903852BD9C5AE26C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessA43E4972B01443BE903852BD9C5AE26C(response, vars, strSDC_Debitcollect_ID, strprocess, strProcessing);
        }

    } else if (vars.commandIn("BUTTONCreatecollectionA3D36D357A9F48DDB7507FCADC8465F3")) {
        vars.setSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strcreatecollection", vars.getStringParameter("inpcreatecollection"));
        vars.setSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA3D36D357A9F48DDB7507FCADC8465F3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A3D36D357A9F48DDB7507FCADC8465F3", request.getServletPath());
      } else if (vars.commandIn("BUTTONA3D36D357A9F48DDB7507FCADC8465F3")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpsdcDebitcollectId", windowId + "|SDC_Debitcollect_ID", "");
        String strcreatecollection = vars.getSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strcreatecollection");
        String strProcessing = vars.getSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strProcessing");
        String strOrg = vars.getSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strOrg");
        String strClient = vars.getSessionValue("buttonA3D36D357A9F48DDB7507FCADC8465F3.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreatecollectionA3D36D357A9F48DDB7507FCADC8465F3(response, vars, strSDC_Debitcollect_ID, strcreatecollection, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONRemove_LinesF89D98E2478B4FF6856678A9D76AE645")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpKey", windowId + "|SDC_Debitcollect_ID", "");
        String strremoveLines = vars.getStringParameter("inpremoveLines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F89D98E2478B4FF6856678A9D76AE645", (("SDC_Debitcollect_ID".equalsIgnoreCase("AD_Language"))?"0":strSDC_Debitcollect_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReconcile05B38539B3A74EF3B3F40F625862E807")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpKey", windowId + "|SDC_Debitcollect_ID", "");
        String strreconcile = vars.getStringParameter("inpreconcile");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "05B38539B3A74EF3B3F40F625862E807", (("SDC_Debitcollect_ID".equalsIgnoreCase("AD_Language"))?"0":strSDC_Debitcollect_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessA43E4972B01443BE903852BD9C5AE26C")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpKey", windowId + "|SDC_Debitcollect_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A43E4972B01443BE903852BD9C5AE26C", (("SDC_Debitcollect_ID".equalsIgnoreCase("AD_Language"))?"0":strSDC_Debitcollect_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONCreatecollectionA3D36D357A9F48DDB7507FCADC8465F3")) {
        String strSDC_Debitcollect_ID = vars.getGlobalVariable("inpKey", windowId + "|SDC_Debitcollect_ID", "");
        
        ProcessBundle pb = new ProcessBundle("A3D36D357A9F48DDB7507FCADC8465F3", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("SDC_Debitcollect_ID", strSDC_Debitcollect_ID);
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

    private void printPageButtonRemove_LinesF89D98E2478B4FF6856678A9D76AE645(HttpServletResponse response, VariablesSecureApp vars, String strSDC_Debitcollect_ID, String strremoveLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F89D98E2478B4FF6856678A9D76AE645");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Remove_LinesF89D98E2478B4FF6856678A9D76AE645", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSDC_Debitcollect_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header7A9791B46170413492C2333FA6BBB1D7_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F89D98E2478B4FF6856678A9D76AE645");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F89D98E2478B4FF6856678A9D76AE645");
        vars.removeMessage("F89D98E2478B4FF6856678A9D76AE645");
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
    private void printPageButtonReconcile05B38539B3A74EF3B3F40F625862E807(HttpServletResponse response, VariablesSecureApp vars, String strSDC_Debitcollect_ID, String strreconcile, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 05B38539B3A74EF3B3F40F625862E807");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reconcile05B38539B3A74EF3B3F40F625862E807", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSDC_Debitcollect_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header7A9791B46170413492C2333FA6BBB1D7_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "05B38539B3A74EF3B3F40F625862E807");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("05B38539B3A74EF3B3F40F625862E807");
        vars.removeMessage("05B38539B3A74EF3B3F40F625862E807");
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
    private void printPageButtonProcessA43E4972B01443BE903852BD9C5AE26C(HttpServletResponse response, VariablesSecureApp vars, String strSDC_Debitcollect_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A43E4972B01443BE903852BD9C5AE26C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessA43E4972B01443BE903852BD9C5AE26C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSDC_Debitcollect_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header7A9791B46170413492C2333FA6BBB1D7_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A43E4972B01443BE903852BD9C5AE26C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A43E4972B01443BE903852BD9C5AE26C");
        vars.removeMessage("A43E4972B01443BE903852BD9C5AE26C");
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


    void printPageButtonCreatecollectionA3D36D357A9F48DDB7507FCADC8465F3(HttpServletResponse response, VariablesSecureApp vars, String strSDC_Debitcollect_ID, String strcreatecollection, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A3D36D357A9F48DDB7507FCADC8465F3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/CreatecollectionA3D36D357A9F48DDB7507FCADC8465F3", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSDC_Debitcollect_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header7A9791B46170413492C2333FA6BBB1D7_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A3D36D357A9F48DDB7507FCADC8465F3");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A3D36D357A9F48DDB7507FCADC8465F3");
        vars.removeMessage("A3D36D357A9F48DDB7507FCADC8465F3");
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
