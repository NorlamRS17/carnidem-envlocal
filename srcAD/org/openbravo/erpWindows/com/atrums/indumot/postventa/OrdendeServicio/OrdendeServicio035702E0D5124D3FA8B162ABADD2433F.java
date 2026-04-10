
package org.openbravo.erpWindows.com.atrums.indumot.postventa.OrdendeServicio;


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
public class OrdendeServicio035702E0D5124D3FA8B162ABADD2433F extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "94CD1D04743C404CBA5AF1BCFF0BC353";
  private static final String tabId = "035702E0D5124D3FA8B162ABADD2433F";
  private static final int accesslevel = 3;
  private static final String moduleId = "AD576C2C137343C585BB0D9012B9329F";
  
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
     
      if (command.contains("A37402A9673B4048A245E413D60263B9")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A37402A9673B4048A245E413D60263B9");
        SessionInfo.setModuleId("C1B65D57CF86408DA404728DD155E3BC");
      }
     
      if (command.contains("0483599196D442B0B7C4032DF3CD1496")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("0483599196D442B0B7C4032DF3CD1496");
        SessionInfo.setModuleId("C1B65D57CF86408DA404728DD155E3BC");
      }
     
      if (command.contains("9EB67D7B8AFA4BD9BBA09BDA63EAA271")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9EB67D7B8AFA4BD9BBA09BDA63EAA271");
        SessionInfo.setModuleId("8670CF53424D4027933C6FCC38689197");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("159713CC430A4AAC98FADA0234E3758C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("159713CC430A4AAC98FADA0234E3758C");
        SessionInfo.setModuleId("AD576C2C137343C585BB0D9012B9329F");
        if (securedProcess || explicitAccess.contains("159713CC430A4AAC98FADA0234E3758C")) {
          classInfo.type = "P";
          classInfo.id = "159713CC430A4AAC98FADA0234E3758C";
        }
      }
     
      if (command.contains("983BA6DDDBE347F39F05EE77F512127F")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("983BA6DDDBE347F39F05EE77F512127F");
        SessionInfo.setModuleId("E11971CC540A4FC2BB683491128F1307");
        if (securedProcess || explicitAccess.contains("983BA6DDDBE347F39F05EE77F512127F")) {
          classInfo.type = "P";
          classInfo.id = "983BA6DDDBE347F39F05EE77F512127F";
        }
      }
     

     
      if (explicitAccess.contains("A37402A9673B4048A245E413D60263B9") || (securedProcess && command.contains("A37402A9673B4048A245E413D60263B9"))) {
        classInfo.type = "P";
        classInfo.id = "A37402A9673B4048A245E413D60263B9";
      }
     
      if (explicitAccess.contains("0483599196D442B0B7C4032DF3CD1496") || (securedProcess && command.contains("0483599196D442B0B7C4032DF3CD1496"))) {
        classInfo.type = "P";
        classInfo.id = "0483599196D442B0B7C4032DF3CD1496";
      }
     
      if (explicitAccess.contains("9EB67D7B8AFA4BD9BBA09BDA63EAA271") || (securedProcess && command.contains("9EB67D7B8AFA4BD9BBA09BDA63EAA271"))) {
        classInfo.type = "P";
        classInfo.id = "9EB67D7B8AFA4BD9BBA09BDA63EAA271";
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

     } else if (vars.commandIn("BUTTONDocactionpv159713CC430A4AAC98FADA0234E3758C")) {
        vars.setSessionValue("button159713CC430A4AAC98FADA0234E3758C.strdocactionpv", vars.getStringParameter("inpdocactionpv"));
        vars.setSessionValue("button159713CC430A4AAC98FADA0234E3758C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button159713CC430A4AAC98FADA0234E3758C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button159713CC430A4AAC98FADA0234E3758C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("docstatus", vars.getStringParameter("inpdocstatus"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button159713CC430A4AAC98FADA0234E3758C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "159713CC430A4AAC98FADA0234E3758C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON159713CC430A4AAC98FADA0234E3758C")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String strdocactionpv = vars.getSessionValue("button159713CC430A4AAC98FADA0234E3758C.strdocactionpv");
        String strProcessing = vars.getSessionValue("button159713CC430A4AAC98FADA0234E3758C.strProcessing");
        String strOrg = vars.getSessionValue("button159713CC430A4AAC98FADA0234E3758C.strOrg");
        String strClient = vars.getSessionValue("button159713CC430A4AAC98FADA0234E3758C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDocactionpv159713CC430A4AAC98FADA0234E3758C(response, vars, strAtindpo_Postventa_ID, strdocactionpv, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Sswos_Createorder983BA6DDDBE347F39F05EE77F512127F")) {
        vars.setSessionValue("button983BA6DDDBE347F39F05EE77F512127F.stremSswosCreateorder", vars.getStringParameter("inpemSswosCreateorder"));
        vars.setSessionValue("button983BA6DDDBE347F39F05EE77F512127F.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button983BA6DDDBE347F39F05EE77F512127F.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button983BA6DDDBE347F39F05EE77F512127F.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button983BA6DDDBE347F39F05EE77F512127F.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "983BA6DDDBE347F39F05EE77F512127F", request.getServletPath());    
     } else if (vars.commandIn("BUTTON983BA6DDDBE347F39F05EE77F512127F")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosCreateorder = vars.getSessionValue("button983BA6DDDBE347F39F05EE77F512127F.stremSswosCreateorder");
        String strProcessing = vars.getSessionValue("button983BA6DDDBE347F39F05EE77F512127F.strProcessing");
        String strOrg = vars.getSessionValue("button983BA6DDDBE347F39F05EE77F512127F.strOrg");
        String strClient = vars.getSessionValue("button983BA6DDDBE347F39F05EE77F512127F.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswos_Createorder983BA6DDDBE347F39F05EE77F512127F(response, vars, strAtindpo_Postventa_ID, stremSswosCreateorder, strProcessing);
        }

    } else if (vars.commandIn("BUTTONEM_Sswos_TransferpartsA37402A9673B4048A245E413D60263B9")) {
        vars.setSessionValue("buttonA37402A9673B4048A245E413D60263B9.stremSswosTransferparts", vars.getStringParameter("inpemSswosTransferparts"));
        vars.setSessionValue("buttonA37402A9673B4048A245E413D60263B9.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA37402A9673B4048A245E413D60263B9.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA37402A9673B4048A245E413D60263B9.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA37402A9673B4048A245E413D60263B9.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A37402A9673B4048A245E413D60263B9", request.getServletPath());
      } else if (vars.commandIn("BUTTONA37402A9673B4048A245E413D60263B9")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosTransferparts = vars.getSessionValue("buttonA37402A9673B4048A245E413D60263B9.stremSswosTransferparts");
        String strProcessing = vars.getSessionValue("buttonA37402A9673B4048A245E413D60263B9.strProcessing");
        String strOrg = vars.getSessionValue("buttonA37402A9673B4048A245E413D60263B9.strOrg");
        String strClient = vars.getSessionValue("buttonA37402A9673B4048A245E413D60263B9.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswos_TransferpartsA37402A9673B4048A245E413D60263B9(response, vars, strAtindpo_Postventa_ID, stremSswosTransferparts, strProcessing);
        }
    } else if (vars.commandIn("BUTTONEM_Sswos_Transferpartsreturn0483599196D442B0B7C4032DF3CD1496")) {
        vars.setSessionValue("button0483599196D442B0B7C4032DF3CD1496.stremSswosTransferpartsreturn", vars.getStringParameter("inpemSswosTransferpartsreturn"));
        vars.setSessionValue("button0483599196D442B0B7C4032DF3CD1496.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0483599196D442B0B7C4032DF3CD1496.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0483599196D442B0B7C4032DF3CD1496.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0483599196D442B0B7C4032DF3CD1496.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0483599196D442B0B7C4032DF3CD1496", request.getServletPath());
      } else if (vars.commandIn("BUTTON0483599196D442B0B7C4032DF3CD1496")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosTransferpartsreturn = vars.getSessionValue("button0483599196D442B0B7C4032DF3CD1496.stremSswosTransferpartsreturn");
        String strProcessing = vars.getSessionValue("button0483599196D442B0B7C4032DF3CD1496.strProcessing");
        String strOrg = vars.getSessionValue("button0483599196D442B0B7C4032DF3CD1496.strOrg");
        String strClient = vars.getSessionValue("button0483599196D442B0B7C4032DF3CD1496.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswos_Transferpartsreturn0483599196D442B0B7C4032DF3CD1496(response, vars, strAtindpo_Postventa_ID, stremSswosTransferpartsreturn, strProcessing);
        }
    } else if (vars.commandIn("BUTTONEM_Sswon_Sendprefecture9EB67D7B8AFA4BD9BBA09BDA63EAA271")) {
        vars.setSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.stremSswonSendprefecture", vars.getStringParameter("inpemSswonSendprefecture"));
        vars.setSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9EB67D7B8AFA4BD9BBA09BDA63EAA271", request.getServletPath());
      } else if (vars.commandIn("BUTTON9EB67D7B8AFA4BD9BBA09BDA63EAA271")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpatindpoPostventaId", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswonSendprefecture = vars.getSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.stremSswonSendprefecture");
        String strProcessing = vars.getSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.strProcessing");
        String strOrg = vars.getSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.strOrg");
        String strClient = vars.getSessionValue("button9EB67D7B8AFA4BD9BBA09BDA63EAA271.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswon_Sendprefecture9EB67D7B8AFA4BD9BBA09BDA63EAA271(response, vars, strAtindpo_Postventa_ID, stremSswonSendprefecture, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONDocactionpv159713CC430A4AAC98FADA0234E3758C")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        String strdocactionpv = vars.getStringParameter("inpdocactionpv");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "159713CC430A4AAC98FADA0234E3758C", (("Atindpo_Postventa_ID".equalsIgnoreCase("AD_Language"))?"0":strAtindpo_Postventa_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strdocstatus = vars.getStringParameter("inpdocstatus");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "docstatus", strdocstatus, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sswos_Createorder983BA6DDDBE347F39F05EE77F512127F")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        String stremSswosCreateorder = vars.getStringParameter("inpemSswosCreateorder");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "983BA6DDDBE347F39F05EE77F512127F", (("Atindpo_Postventa_ID".equalsIgnoreCase("AD_Language"))?"0":strAtindpo_Postventa_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONEM_Sswos_TransferpartsA37402A9673B4048A245E413D60263B9")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        
        ProcessBundle pb = new ProcessBundle("A37402A9673B4048A245E413D60263B9", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Atindpo_Postventa_ID", strAtindpo_Postventa_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sswos_Transferpartsreturn0483599196D442B0B7C4032DF3CD1496")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        
        ProcessBundle pb = new ProcessBundle("0483599196D442B0B7C4032DF3CD1496", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Atindpo_Postventa_ID", strAtindpo_Postventa_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Sswon_Sendprefecture9EB67D7B8AFA4BD9BBA09BDA63EAA271")) {
        String strAtindpo_Postventa_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventa_ID", "");
        
        ProcessBundle pb = new ProcessBundle("9EB67D7B8AFA4BD9BBA09BDA63EAA271", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Atindpo_Postventa_ID", strAtindpo_Postventa_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strsend = vars.getStringParameter("inpsend", "N");
params.put("send", strsend);

        
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

    private void printPageButtonDocactionpv159713CC430A4AAC98FADA0234E3758C(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String strdocactionpv, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 159713CC430A4AAC98FADA0234E3758C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Docactionpv159713CC430A4AAC98FADA0234E3758C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicio035702E0D5124D3FA8B162ABADD2433F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "159713CC430A4AAC98FADA0234E3758C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("159713CC430A4AAC98FADA0234E3758C");
        vars.removeMessage("159713CC430A4AAC98FADA0234E3758C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("docstatus", "");
    comboTableData = new ComboTableData(vars, this, "17", "docstatus", "A59EA6E20C0D4F92BB96158C78BFA6FF", "07D8B925FC8B4383B6849027895E55B5", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button159713CC430A4AAC98FADA0234E3758C.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportdocstatus", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Sswos_Createorder983BA6DDDBE347F39F05EE77F512127F(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremSswosCreateorder, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 983BA6DDDBE347F39F05EE77F512127F");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswos_Createorder983BA6DDDBE347F39F05EE77F512127F", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicio035702E0D5124D3FA8B162ABADD2433F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "983BA6DDDBE347F39F05EE77F512127F");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("983BA6DDDBE347F39F05EE77F512127F");
        vars.removeMessage("983BA6DDDBE347F39F05EE77F512127F");
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


    void printPageButtonEM_Sswos_TransferpartsA37402A9673B4048A245E413D60263B9(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremSswosTransferparts, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A37402A9673B4048A245E413D60263B9");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswos_TransferpartsA37402A9673B4048A245E413D60263B9", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicio035702E0D5124D3FA8B162ABADD2433F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A37402A9673B4048A245E413D60263B9");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A37402A9673B4048A245E413D60263B9");
        vars.removeMessage("A37402A9673B4048A245E413D60263B9");
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
    void printPageButtonEM_Sswos_Transferpartsreturn0483599196D442B0B7C4032DF3CD1496(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremSswosTransferpartsreturn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0483599196D442B0B7C4032DF3CD1496");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswos_Transferpartsreturn0483599196D442B0B7C4032DF3CD1496", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicio035702E0D5124D3FA8B162ABADD2433F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "0483599196D442B0B7C4032DF3CD1496");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("0483599196D442B0B7C4032DF3CD1496");
        vars.removeMessage("0483599196D442B0B7C4032DF3CD1496");
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
    void printPageButtonEM_Sswon_Sendprefecture9EB67D7B8AFA4BD9BBA09BDA63EAA271(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventa_ID, String stremSswonSendprefecture, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9EB67D7B8AFA4BD9BBA09BDA63EAA271");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswon_Sendprefecture9EB67D7B8AFA4BD9BBA09BDA63EAA271", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventa_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "OrdendeServicio035702E0D5124D3FA8B162ABADD2433F_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "9EB67D7B8AFA4BD9BBA09BDA63EAA271");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("9EB67D7B8AFA4BD9BBA09BDA63EAA271");
        vars.removeMessage("9EB67D7B8AFA4BD9BBA09BDA63EAA271");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Send", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
