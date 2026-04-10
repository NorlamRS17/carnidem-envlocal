
package org.openbravo.erpWindows.PurchaseOrder;


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
public class Header extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "181";
  private static final String tabId = "294";
  private static final int accesslevel = 1;
  private static final String moduleId = "0";
  
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
     
      if (command.contains("23D1B163EC0B41F790CE39BF01DA320E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("23D1B163EC0B41F790CE39BF01DA320E");
        SessionInfo.setModuleId("0");
      }
     
      if (command.contains("A3FE1F9892394386A49FB707AA50A0FA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A3FE1F9892394386A49FB707AA50A0FA");
        SessionInfo.setModuleId("0");
      }
     
      if (command.contains("9EB2228A60684C0DBEC12D5CD8D85218")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9EB2228A60684C0DBEC12D5CD8D85218");
        SessionInfo.setModuleId("0");
      }
     
      if (command.contains("364900DC81134D3FBF819F85AFF5E7EA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("364900DC81134D3FBF819F85AFF5E7EA");
        SessionInfo.setModuleId("F1D2B1CD862A42498DD48618546E9F9B");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("104")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("104");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("104")) {
          classInfo.type = "P";
          classInfo.id = "104";
        }
      }
     
      if (command.contains("CC2BC57DAC474C20AEA147A5486FBBFB")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CC2BC57DAC474C20AEA147A5486FBBFB");
        SessionInfo.setModuleId("4A76BC771D824599A58C147CD3457BDA");
        if (securedProcess || explicitAccess.contains("CC2BC57DAC474C20AEA147A5486FBBFB")) {
          classInfo.type = "P";
          classInfo.id = "CC2BC57DAC474C20AEA147A5486FBBFB";
        }
      }
     
      if (command.contains("4E8E7B1290BD4B5798ACD75A83DCC65D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4E8E7B1290BD4B5798ACD75A83DCC65D");
        SessionInfo.setModuleId("F1D2B1CD862A42498DD48618546E9F9B");
        if (securedProcess || explicitAccess.contains("4E8E7B1290BD4B5798ACD75A83DCC65D")) {
          classInfo.type = "P";
          classInfo.id = "4E8E7B1290BD4B5798ACD75A83DCC65D";
        }
      }
     
      if (command.contains("1284537672494355ADB600498D10B9C1")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("1284537672494355ADB600498D10B9C1");
        SessionInfo.setModuleId("F1D2B1CD862A42498DD48618546E9F9B");
        if (securedProcess || explicitAccess.contains("1284537672494355ADB600498D10B9C1")) {
          classInfo.type = "P";
          classInfo.id = "1284537672494355ADB600498D10B9C1";
        }
      }
     
      if (command.contains("010E4034BCDA4904A8DF52708722F041")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("010E4034BCDA4904A8DF52708722F041");
        SessionInfo.setModuleId("F1D2B1CD862A42498DD48618546E9F9B");
        if (securedProcess || explicitAccess.contains("010E4034BCDA4904A8DF52708722F041")) {
          classInfo.type = "P";
          classInfo.id = "010E4034BCDA4904A8DF52708722F041";
        }
      }
     
      if (command.contains("5665A8727B414C6AA48A68AF66ACF13C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5665A8727B414C6AA48A68AF66ACF13C");
        SessionInfo.setModuleId("F1D2B1CD862A42498DD48618546E9F9B");
        if (securedProcess || explicitAccess.contains("5665A8727B414C6AA48A68AF66ACF13C")) {
          classInfo.type = "P";
          classInfo.id = "5665A8727B414C6AA48A68AF66ACF13C";
        }
      }
     
      if (command.contains("A6D78DC97B4E437D8693D96FC65690C1")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("A6D78DC97B4E437D8693D96FC65690C1");
        SessionInfo.setModuleId("4A76BC771D824599A58C147CD3457BDA");
        if (securedProcess || explicitAccess.contains("A6D78DC97B4E437D8693D96FC65690C1")) {
          classInfo.type = "P";
          classInfo.id = "A6D78DC97B4E437D8693D96FC65690C1";
        }
      }
     

     
      if (explicitAccess.contains("23D1B163EC0B41F790CE39BF01DA320E") || (securedProcess && command.contains("23D1B163EC0B41F790CE39BF01DA320E"))) {
        classInfo.type = "P";
        classInfo.id = "23D1B163EC0B41F790CE39BF01DA320E";
      }
     
      if (explicitAccess.contains("A3FE1F9892394386A49FB707AA50A0FA") || (securedProcess && command.contains("A3FE1F9892394386A49FB707AA50A0FA"))) {
        classInfo.type = "P";
        classInfo.id = "A3FE1F9892394386A49FB707AA50A0FA";
      }
     
      if (explicitAccess.contains("9EB2228A60684C0DBEC12D5CD8D85218") || (securedProcess && command.contains("9EB2228A60684C0DBEC12D5CD8D85218"))) {
        classInfo.type = "P";
        classInfo.id = "9EB2228A60684C0DBEC12D5CD8D85218";
      }
     
      if (explicitAccess.contains("364900DC81134D3FBF819F85AFF5E7EA") || (securedProcess && command.contains("364900DC81134D3FBF819F85AFF5E7EA"))) {
        classInfo.type = "P";
        classInfo.id = "364900DC81134D3FBF819F85AFF5E7EA";
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

     } else if (vars.commandIn("BUTTONDocAction104")) {
        vars.setSessionValue("button104.strdocaction", vars.getStringParameter("inpdocaction"));
        vars.setSessionValue("button104.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button104.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button104.strClient", vars.getStringParameter("inpadClientId"));
        vars.setSessionValue("button104.inpdocstatus", vars.getRequiredStringParameter("inpdocstatus"));

        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button104.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "104", request.getServletPath());    
     } else if (vars.commandIn("BUTTON104")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strdocaction = vars.getSessionValue("button104.strdocaction");
        String strProcessing = vars.getSessionValue("button104.strProcessing");
        String strOrg = vars.getSessionValue("button104.strOrg");
        String strClient = vars.getSessionValue("button104.strClient");
        
        String strdocstatus = vars.getSessionValue("button104.inpdocstatus");
String stradTableId = "259";

        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonDocAction104(response, vars, strC_Order_ID, strdocaction, strProcessing, strdocstatus, stradTableId);
        }

     } else if (vars.commandIn("BUTTONEM_Ssip_PreliquidarCC2BC57DAC474C20AEA147A5486FBBFB")) {
        vars.setSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.stremSsipPreliquidar", vars.getStringParameter("inpemSsipPreliquidar"));
        vars.setSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCC2BC57DAC474C20AEA147A5486FBBFB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CC2BC57DAC474C20AEA147A5486FBBFB", request.getServletPath());    
     } else if (vars.commandIn("BUTTONCC2BC57DAC474C20AEA147A5486FBBFB")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipPreliquidar = vars.getSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.stremSsipPreliquidar");
        String strProcessing = vars.getSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.strProcessing");
        String strOrg = vars.getSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.strOrg");
        String strClient = vars.getSessionValue("buttonCC2BC57DAC474C20AEA147A5486FBBFB.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssip_PreliquidarCC2BC57DAC474C20AEA147A5486FBBFB(response, vars, strC_Order_ID, stremSsipPreliquidar, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssip_Loadcosts4E8E7B1290BD4B5798ACD75A83DCC65D")) {
        vars.setSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.stremSsipLoadcosts", vars.getStringParameter("inpemSsipLoadcosts"));
        vars.setSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4E8E7B1290BD4B5798ACD75A83DCC65D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4E8E7B1290BD4B5798ACD75A83DCC65D", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4E8E7B1290BD4B5798ACD75A83DCC65D")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipLoadcosts = vars.getSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.stremSsipLoadcosts");
        String strProcessing = vars.getSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.strProcessing");
        String strOrg = vars.getSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.strOrg");
        String strClient = vars.getSessionValue("button4E8E7B1290BD4B5798ACD75A83DCC65D.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssip_Loadcosts4E8E7B1290BD4B5798ACD75A83DCC65D(response, vars, strC_Order_ID, stremSsipLoadcosts, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssip_Liquidar1284537672494355ADB600498D10B9C1")) {
        vars.setSessionValue("button1284537672494355ADB600498D10B9C1.stremSsipLiquidar", vars.getStringParameter("inpemSsipLiquidar"));
        vars.setSessionValue("button1284537672494355ADB600498D10B9C1.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button1284537672494355ADB600498D10B9C1.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button1284537672494355ADB600498D10B9C1.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button1284537672494355ADB600498D10B9C1.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "1284537672494355ADB600498D10B9C1", request.getServletPath());    
     } else if (vars.commandIn("BUTTON1284537672494355ADB600498D10B9C1")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipLiquidar = vars.getSessionValue("button1284537672494355ADB600498D10B9C1.stremSsipLiquidar");
        String strProcessing = vars.getSessionValue("button1284537672494355ADB600498D10B9C1.strProcessing");
        String strOrg = vars.getSessionValue("button1284537672494355ADB600498D10B9C1.strOrg");
        String strClient = vars.getSessionValue("button1284537672494355ADB600498D10B9C1.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssip_Liquidar1284537672494355ADB600498D10B9C1(response, vars, strC_Order_ID, stremSsipLiquidar, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssip_Action_Tax010E4034BCDA4904A8DF52708722F041")) {
        vars.setSessionValue("button010E4034BCDA4904A8DF52708722F041.stremSsipActionTax", vars.getStringParameter("inpemSsipActionTax"));
        vars.setSessionValue("button010E4034BCDA4904A8DF52708722F041.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button010E4034BCDA4904A8DF52708722F041.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button010E4034BCDA4904A8DF52708722F041.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button010E4034BCDA4904A8DF52708722F041.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "010E4034BCDA4904A8DF52708722F041", request.getServletPath());    
     } else if (vars.commandIn("BUTTON010E4034BCDA4904A8DF52708722F041")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipActionTax = vars.getSessionValue("button010E4034BCDA4904A8DF52708722F041.stremSsipActionTax");
        String strProcessing = vars.getSessionValue("button010E4034BCDA4904A8DF52708722F041.strProcessing");
        String strOrg = vars.getSessionValue("button010E4034BCDA4904A8DF52708722F041.strOrg");
        String strClient = vars.getSessionValue("button010E4034BCDA4904A8DF52708722F041.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssip_Action_Tax010E4034BCDA4904A8DF52708722F041(response, vars, strC_Order_ID, stremSsipActionTax, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssip_Emptyfields5665A8727B414C6AA48A68AF66ACF13C")) {
        vars.setSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.stremSsipEmptyfields", vars.getStringParameter("inpemSsipEmptyfields"));
        vars.setSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5665A8727B414C6AA48A68AF66ACF13C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5665A8727B414C6AA48A68AF66ACF13C", request.getServletPath());    
     } else if (vars.commandIn("BUTTON5665A8727B414C6AA48A68AF66ACF13C")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipEmptyfields = vars.getSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.stremSsipEmptyfields");
        String strProcessing = vars.getSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.strProcessing");
        String strOrg = vars.getSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.strOrg");
        String strClient = vars.getSessionValue("button5665A8727B414C6AA48A68AF66ACF13C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssip_Emptyfields5665A8727B414C6AA48A68AF66ACF13C(response, vars, strC_Order_ID, stremSsipEmptyfields, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssipice_Load_IceA6D78DC97B4E437D8693D96FC65690C1")) {
        vars.setSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.stremSsipiceLoadIce", vars.getStringParameter("inpemSsipiceLoadIce"));
        vars.setSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA6D78DC97B4E437D8693D96FC65690C1.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A6D78DC97B4E437D8693D96FC65690C1", request.getServletPath());    
     } else if (vars.commandIn("BUTTONA6D78DC97B4E437D8693D96FC65690C1")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipiceLoadIce = vars.getSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.stremSsipiceLoadIce");
        String strProcessing = vars.getSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.strProcessing");
        String strOrg = vars.getSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.strOrg");
        String strClient = vars.getSessionValue("buttonA6D78DC97B4E437D8693D96FC65690C1.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssipice_Load_IceA6D78DC97B4E437D8693D96FC65690C1(response, vars, strC_Order_ID, stremSsipiceLoadIce, strProcessing);
        }

    } else if (vars.commandIn("BUTTONRM_AddOrphanLine23D1B163EC0B41F790CE39BF01DA320E")) {
        vars.setSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strrmAddorphanline", vars.getStringParameter("inprmAddorphanline"));
        vars.setSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("IsSOTrx", vars.getStringParameter("inpissotrx"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button23D1B163EC0B41F790CE39BF01DA320E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "23D1B163EC0B41F790CE39BF01DA320E", request.getServletPath());
      } else if (vars.commandIn("BUTTON23D1B163EC0B41F790CE39BF01DA320E")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strrmAddorphanline = vars.getSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strrmAddorphanline");
        String strProcessing = vars.getSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strProcessing");
        String strOrg = vars.getSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strOrg");
        String strClient = vars.getSessionValue("button23D1B163EC0B41F790CE39BF01DA320E.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonRM_AddOrphanLine23D1B163EC0B41F790CE39BF01DA320E(response, vars, strC_Order_ID, strrmAddorphanline, strProcessing);
        }
    } else if (vars.commandIn("BUTTONConvertquotationA3FE1F9892394386A49FB707AA50A0FA")) {
        vars.setSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strconvertquotation", vars.getStringParameter("inpconvertquotation"));
        vars.setSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonA3FE1F9892394386A49FB707AA50A0FA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "A3FE1F9892394386A49FB707AA50A0FA", request.getServletPath());
      } else if (vars.commandIn("BUTTONA3FE1F9892394386A49FB707AA50A0FA")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strconvertquotation = vars.getSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strconvertquotation");
        String strProcessing = vars.getSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strProcessing");
        String strOrg = vars.getSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strOrg");
        String strClient = vars.getSessionValue("buttonA3FE1F9892394386A49FB707AA50A0FA.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonConvertquotationA3FE1F9892394386A49FB707AA50A0FA(response, vars, strC_Order_ID, strconvertquotation, strProcessing);
        }
    } else if (vars.commandIn("BUTTONCalculate_Promotions9EB2228A60684C0DBEC12D5CD8D85218")) {
        vars.setSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strcalculatePromotions", vars.getStringParameter("inpcalculatePromotions"));
        vars.setSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9EB2228A60684C0DBEC12D5CD8D85218.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9EB2228A60684C0DBEC12D5CD8D85218", request.getServletPath());
      } else if (vars.commandIn("BUTTON9EB2228A60684C0DBEC12D5CD8D85218")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String strcalculatePromotions = vars.getSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strcalculatePromotions");
        String strProcessing = vars.getSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strProcessing");
        String strOrg = vars.getSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strOrg");
        String strClient = vars.getSessionValue("button9EB2228A60684C0DBEC12D5CD8D85218.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCalculate_Promotions9EB2228A60684C0DBEC12D5CD8D85218(response, vars, strC_Order_ID, strcalculatePromotions, strProcessing);
        }
    } else if (vars.commandIn("BUTTONEM_Ssip_Update_FOB364900DC81134D3FBF819F85AFF5E7EA")) {
        vars.setSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.stremSsipUpdateFob", vars.getStringParameter("inpemSsipUpdateFob"));
        vars.setSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button364900DC81134D3FBF819F85AFF5E7EA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "364900DC81134D3FBF819F85AFF5E7EA", request.getServletPath());
      } else if (vars.commandIn("BUTTON364900DC81134D3FBF819F85AFF5E7EA")) {
        String strC_Order_ID = vars.getGlobalVariable("inpcOrderId", windowId + "|C_Order_ID", "");
        String stremSsipUpdateFob = vars.getSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.stremSsipUpdateFob");
        String strProcessing = vars.getSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.strProcessing");
        String strOrg = vars.getSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.strOrg");
        String strClient = vars.getSessionValue("button364900DC81134D3FBF819F85AFF5E7EA.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssip_Update_FOB364900DC81134D3FBF819F85AFF5E7EA(response, vars, strC_Order_ID, stremSsipUpdateFob, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONDocAction104")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String strdocaction = vars.getStringParameter("inpdocaction");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "104", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          HeaderData.updateDocAction(this, strdocaction, strC_Order_ID);

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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssip_PreliquidarCC2BC57DAC474C20AEA147A5486FBBFB")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsipPreliquidar = vars.getStringParameter("inpemSsipPreliquidar");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "CC2BC57DAC474C20AEA147A5486FBBFB", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssip_Loadcosts4E8E7B1290BD4B5798ACD75A83DCC65D")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsipLoadcosts = vars.getStringParameter("inpemSsipLoadcosts");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4E8E7B1290BD4B5798ACD75A83DCC65D", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssip_Liquidar1284537672494355ADB600498D10B9C1")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsipLiquidar = vars.getStringParameter("inpemSsipLiquidar");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "1284537672494355ADB600498D10B9C1", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssip_Action_Tax010E4034BCDA4904A8DF52708722F041")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsipActionTax = vars.getStringParameter("inpemSsipActionTax");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "010E4034BCDA4904A8DF52708722F041", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssip_Emptyfields5665A8727B414C6AA48A68AF66ACF13C")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsipEmptyfields = vars.getStringParameter("inpemSsipEmptyfields");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "5665A8727B414C6AA48A68AF66ACF13C", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssipice_Load_IceA6D78DC97B4E437D8693D96FC65690C1")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        String stremSsipiceLoadIce = vars.getStringParameter("inpemSsipiceLoadIce");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "A6D78DC97B4E437D8693D96FC65690C1", (("C_Order_ID".equalsIgnoreCase("AD_Language"))?"0":strC_Order_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONRM_AddOrphanLine23D1B163EC0B41F790CE39BF01DA320E")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        
        ProcessBundle pb = new ProcessBundle("23D1B163EC0B41F790CE39BF01DA320E", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("C_Order_ID", strC_Order_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strmProductId = vars.getStringParameter("inpmProductId");
params.put("mProductId", strmProductId);
String strmAttributesetinstanceId = vars.getStringParameter("inpmAttributesetinstanceId");
params.put("mAttributesetinstanceId", strmAttributesetinstanceId);
String strreturned = vars.getNumericParameter("inpreturned");
params.put("returned", strreturned);
String strpricestd = vars.getNumericParameter("inppricestd");
params.put("pricestd", strpricestd);
String strcTaxId = vars.getStringParameter("inpcTaxId");
params.put("cTaxId", strcTaxId);
String strcReturnReasonId = vars.getStringParameter("inpcReturnReasonId");
params.put("cReturnReasonId", strcReturnReasonId);

        
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
    } else if (vars.commandIn("SAVE_BUTTONConvertquotationA3FE1F9892394386A49FB707AA50A0FA")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        
        ProcessBundle pb = new ProcessBundle("A3FE1F9892394386A49FB707AA50A0FA", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("C_Order_ID", strC_Order_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strrecalculateprices = vars.getStringParameter("inprecalculateprices", "N");
params.put("recalculateprices", strrecalculateprices);

        
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
    } else if (vars.commandIn("SAVE_BUTTONCalculate_Promotions9EB2228A60684C0DBEC12D5CD8D85218")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        
        ProcessBundle pb = new ProcessBundle("9EB2228A60684C0DBEC12D5CD8D85218", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("C_Order_ID", strC_Order_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssip_Update_FOB364900DC81134D3FBF819F85AFF5E7EA")) {
        String strC_Order_ID = vars.getGlobalVariable("inpKey", windowId + "|C_Order_ID", "");
        
        ProcessBundle pb = new ProcessBundle("364900DC81134D3FBF819F85AFF5E7EA", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("C_Order_ID", strC_Order_ID);
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

    private void printPageButtonDocAction104(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strdocaction, String strProcessing, String strdocstatus, String stradTableId)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 104");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/DocAction", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "104");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("104");
        vars.removeMessage("104");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

      xmlDocument.setParameter("docstatus", strdocstatus);
xmlDocument.setParameter("adTableId", stradTableId);
    try {
    } catch (Exception ex) {
      throw new ServletException(ex);
    }
xmlDocument.setParameter("processId", "104");
xmlDocument.setParameter("processDescription", "Process Order");
xmlDocument.setParameter("docaction", (strdocaction.equals("--")?"CL":strdocaction));
FieldProvider[] dataDocAction = ActionButtonUtility.docAction(this, vars, strdocaction, "FF80818130217A35013021A672400035", strdocstatus, strProcessing, stradTableId, tabId);
xmlDocument.setData("reportdocaction", "liststructure", dataDocAction);
StringBuffer dact = new StringBuffer();
if (dataDocAction!=null) {
  dact.append("var arrDocAction = new Array(\n");
  for (int i=0;i<dataDocAction.length;i++) {
    dact.append("new Array(\"" + dataDocAction[i].getField("id") + "\", \"" + dataDocAction[i].getField("name") + "\", \"" + dataDocAction[i].getField("description") + "\")\n");
    if (i<dataDocAction.length-1) dact.append(",\n");
  }
  dact.append(");");
} else dact.append("var arrDocAction = null");
xmlDocument.setParameter("array", dact.toString());

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Ssip_PreliquidarCC2BC57DAC474C20AEA147A5486FBBFB(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipPreliquidar, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CC2BC57DAC474C20AEA147A5486FBBFB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssip_PreliquidarCC2BC57DAC474C20AEA147A5486FBBFB", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CC2BC57DAC474C20AEA147A5486FBBFB");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CC2BC57DAC474C20AEA147A5486FBBFB");
        vars.removeMessage("CC2BC57DAC474C20AEA147A5486FBBFB");
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
    private void printPageButtonEM_Ssip_Loadcosts4E8E7B1290BD4B5798ACD75A83DCC65D(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipLoadcosts, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4E8E7B1290BD4B5798ACD75A83DCC65D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssip_Loadcosts4E8E7B1290BD4B5798ACD75A83DCC65D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4E8E7B1290BD4B5798ACD75A83DCC65D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4E8E7B1290BD4B5798ACD75A83DCC65D");
        vars.removeMessage("4E8E7B1290BD4B5798ACD75A83DCC65D");
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
    private void printPageButtonEM_Ssip_Liquidar1284537672494355ADB600498D10B9C1(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipLiquidar, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 1284537672494355ADB600498D10B9C1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssip_Liquidar1284537672494355ADB600498D10B9C1", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "1284537672494355ADB600498D10B9C1");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("1284537672494355ADB600498D10B9C1");
        vars.removeMessage("1284537672494355ADB600498D10B9C1");
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
    private void printPageButtonEM_Ssip_Action_Tax010E4034BCDA4904A8DF52708722F041(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipActionTax, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 010E4034BCDA4904A8DF52708722F041");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssip_Action_Tax010E4034BCDA4904A8DF52708722F041", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "010E4034BCDA4904A8DF52708722F041");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("010E4034BCDA4904A8DF52708722F041");
        vars.removeMessage("010E4034BCDA4904A8DF52708722F041");
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
    private void printPageButtonEM_Ssip_Emptyfields5665A8727B414C6AA48A68AF66ACF13C(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipEmptyfields, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5665A8727B414C6AA48A68AF66ACF13C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssip_Emptyfields5665A8727B414C6AA48A68AF66ACF13C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5665A8727B414C6AA48A68AF66ACF13C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5665A8727B414C6AA48A68AF66ACF13C");
        vars.removeMessage("5665A8727B414C6AA48A68AF66ACF13C");
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
    private void printPageButtonEM_Ssipice_Load_IceA6D78DC97B4E437D8693D96FC65690C1(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipiceLoadIce, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A6D78DC97B4E437D8693D96FC65690C1");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssipice_Load_IceA6D78DC97B4E437D8693D96FC65690C1", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A6D78DC97B4E437D8693D96FC65690C1");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A6D78DC97B4E437D8693D96FC65690C1");
        vars.removeMessage("A6D78DC97B4E437D8693D96FC65690C1");
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


    void printPageButtonRM_AddOrphanLine23D1B163EC0B41F790CE39BF01DA320E(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strrmAddorphanline, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 23D1B163EC0B41F790CE39BF01DA320E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/RM_AddOrphanLine23D1B163EC0B41F790CE39BF01DA320E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "23D1B163EC0B41F790CE39BF01DA320E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("23D1B163EC0B41F790CE39BF01DA320E");
        vars.removeMessage("23D1B163EC0B41F790CE39BF01DA320E");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Product_ID", "");
    xmlDocument.setParameter("M_AttributeSetInstance_ID", "");
    xmlDocument.setParameter("M_AttributeSetInstance_IDR", HeaderData.selectActDefM_AttributeSetInstance_ID(this, ""));
    xmlDocument.setParameter("Returned", "");
    xmlDocument.setParameter("PriceStd", "");
    xmlDocument.setParameter("C_Tax_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Tax_ID", "", "299FA667CF374AC5ACC74739C3251134", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button23D1B163EC0B41F790CE39BF01DA320E.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportC_Tax_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("C_Return_Reason_ID", "");
    comboTableData = new ComboTableData(vars, this, "19", "C_Return_Reason_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button23D1B163EC0B41F790CE39BF01DA320E.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportC_Return_Reason_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonConvertquotationA3FE1F9892394386A49FB707AA50A0FA(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strconvertquotation, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process A3FE1F9892394386A49FB707AA50A0FA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ConvertquotationA3FE1F9892394386A49FB707AA50A0FA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "A3FE1F9892394386A49FB707AA50A0FA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("A3FE1F9892394386A49FB707AA50A0FA");
        vars.removeMessage("A3FE1F9892394386A49FB707AA50A0FA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("RecalculatePrices", "Y");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonCalculate_Promotions9EB2228A60684C0DBEC12D5CD8D85218(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String strcalculatePromotions, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9EB2228A60684C0DBEC12D5CD8D85218");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Calculate_Promotions9EB2228A60684C0DBEC12D5CD8D85218", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "9EB2228A60684C0DBEC12D5CD8D85218");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("9EB2228A60684C0DBEC12D5CD8D85218");
        vars.removeMessage("9EB2228A60684C0DBEC12D5CD8D85218");
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
    void printPageButtonEM_Ssip_Update_FOB364900DC81134D3FBF819F85AFF5E7EA(HttpServletResponse response, VariablesSecureApp vars, String strC_Order_ID, String stremSsipUpdateFob, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 364900DC81134D3FBF819F85AFF5E7EA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssip_Update_FOB364900DC81134D3FBF819F85AFF5E7EA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strC_Order_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "364900DC81134D3FBF819F85AFF5E7EA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("364900DC81134D3FBF819F85AFF5E7EA");
        vars.removeMessage("364900DC81134D3FBF819F85AFF5E7EA");
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
