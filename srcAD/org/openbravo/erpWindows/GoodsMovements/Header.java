
package org.openbravo.erpWindows.GoodsMovements;


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
  
  private static final String windowId = "170";
  private static final String tabId = "259";
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
     
      if (command.contains("7CC8083871A2456BAC7B948F3510BC3C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7CC8083871A2456BAC7B948F3510BC3C");
        SessionInfo.setModuleId("8204FEBE1A0B4C36B45C4F662A44CB1B");
      }
     
      if (command.contains("B0DCB2771D744EAA8F75B2B6530CABF8")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B0DCB2771D744EAA8F75B2B6530CABF8");
        SessionInfo.setModuleId("BEE9E7698A8E4D3DB991392F9FF2D62E");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("800048")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("800048");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("800048")) {
          classInfo.type = "P";
          classInfo.id = "800048";
        }
      }
     
      if (command.contains("D3ED058DE3444DAFB49DB442919A980B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D3ED058DE3444DAFB49DB442919A980B");
        SessionInfo.setModuleId("BEE9E7698A8E4D3DB991392F9FF2D62E");
        if (securedProcess || explicitAccess.contains("D3ED058DE3444DAFB49DB442919A980B")) {
          classInfo.type = "P";
          classInfo.id = "D3ED058DE3444DAFB49DB442919A980B";
        }
      }
     
      if (command.contains("122")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("122");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("122")) {
          classInfo.type = "P";
          classInfo.id = "122";
        }
      }
     
      if (command.contains("DB2C50639DA742E6890ED59EFC808554")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DB2C50639DA742E6890ED59EFC808554");
        SessionInfo.setModuleId("DFE0DD3106FF487FA3BAA680D68B317E");
        if (securedProcess || explicitAccess.contains("DB2C50639DA742E6890ED59EFC808554")) {
          classInfo.type = "P";
          classInfo.id = "DB2C50639DA742E6890ED59EFC808554";
        }
      }
     
      if (command.contains("F608BCACA3EE4649A448F3D8075A6978")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("F608BCACA3EE4649A448F3D8075A6978");
        SessionInfo.setModuleId("1C22CAE943024E1B8730F33D0B6E87DD");
        if (securedProcess || explicitAccess.contains("F608BCACA3EE4649A448F3D8075A6978")) {
          classInfo.type = "P";
          classInfo.id = "F608BCACA3EE4649A448F3D8075A6978";
        }
      }
     
      if (command.contains("D3BA849A76B44C739D4503A1238C6645")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D3BA849A76B44C739D4503A1238C6645");
        SessionInfo.setModuleId("80196198DD274FA0AB51AD7CDD1F2893");
        if (securedProcess || explicitAccess.contains("D3BA849A76B44C739D4503A1238C6645")) {
          classInfo.type = "P";
          classInfo.id = "D3BA849A76B44C739D4503A1238C6645";
        }
      }
     

     
      if (explicitAccess.contains("7CC8083871A2456BAC7B948F3510BC3C") || (securedProcess && command.contains("7CC8083871A2456BAC7B948F3510BC3C"))) {
        classInfo.type = "P";
        classInfo.id = "7CC8083871A2456BAC7B948F3510BC3C";
      }
     
      if (explicitAccess.contains("B0DCB2771D744EAA8F75B2B6530CABF8") || (securedProcess && command.contains("B0DCB2771D744EAA8F75B2B6530CABF8"))) {
        classInfo.type = "P";
        classInfo.id = "B0DCB2771D744EAA8F75B2B6530CABF8";
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

     } else if (vars.commandIn("BUTTONMove_FromTo_Locator800048")) {
        vars.setSessionValue("button800048.strmoveFromtoLocator", vars.getStringParameter("inpmoveFromtoLocator"));
        vars.setSessionValue("button800048.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button800048.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button800048.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button800048.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "800048", request.getServletPath());    
     } else if (vars.commandIn("BUTTON800048")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String strmoveFromtoLocator = vars.getSessionValue("button800048.strmoveFromtoLocator");
        String strProcessing = vars.getSessionValue("button800048.strProcessing");
        String strOrg = vars.getSessionValue("button800048.strOrg");
        String strClient = vars.getSessionValue("button800048.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonMove_FromTo_Locator800048(response, vars, strM_Movement_ID, strmoveFromtoLocator, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessingD3ED058DE3444DAFB49DB442919A980B")) {
        vars.setSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strprocessing", vars.getStringParameter("inpprocessing"));
        vars.setSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD3ED058DE3444DAFB49DB442919A980B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D3ED058DE3444DAFB49DB442919A980B", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND3ED058DE3444DAFB49DB442919A980B")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String strprocessing = vars.getSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strprocessing");
        String strProcessing = vars.getSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strProcessing");
        String strOrg = vars.getSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strOrg");
        String strClient = vars.getSessionValue("buttonD3ED058DE3444DAFB49DB442919A980B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessingD3ED058DE3444DAFB49DB442919A980B(response, vars, strM_Movement_ID, strprocessing, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Stat_Processing122")) {
        vars.setSessionValue("button122.stremStatProcessing", vars.getStringParameter("inpemStatProcessing"));
        vars.setSessionValue("button122.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button122.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button122.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button122.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "122", request.getServletPath());    
     } else if (vars.commandIn("BUTTON122")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String stremStatProcessing = vars.getSessionValue("button122.stremStatProcessing");
        String strProcessing = vars.getSessionValue("button122.strProcessing");
        String strOrg = vars.getSessionValue("button122.strOrg");
        String strClient = vars.getSessionValue("button122.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Stat_Processing122(response, vars, strM_Movement_ID, stremStatProcessing, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Smvwh_CreatelinesDB2C50639DA742E6890ED59EFC808554")) {
        vars.setSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.stremSmvwhCreatelines", vars.getStringParameter("inpemSmvwhCreatelines"));
        vars.setSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDB2C50639DA742E6890ED59EFC808554.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DB2C50639DA742E6890ED59EFC808554", request.getServletPath());    
     } else if (vars.commandIn("BUTTONDB2C50639DA742E6890ED59EFC808554")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String stremSmvwhCreatelines = vars.getSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.stremSmvwhCreatelines");
        String strProcessing = vars.getSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.strProcessing");
        String strOrg = vars.getSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.strOrg");
        String strClient = vars.getSessionValue("buttonDB2C50639DA742E6890ED59EFC808554.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Smvwh_CreatelinesDB2C50639DA742E6890ED59EFC808554(response, vars, strM_Movement_ID, stremSmvwhCreatelines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Swhp_UbicaciongeneralF608BCACA3EE4649A448F3D8075A6978")) {
        vars.setSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.stremSwhpUbicaciongeneral", vars.getStringParameter("inpemSwhpUbicaciongeneral"));
        vars.setSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonF608BCACA3EE4649A448F3D8075A6978.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "F608BCACA3EE4649A448F3D8075A6978", request.getServletPath());    
     } else if (vars.commandIn("BUTTONF608BCACA3EE4649A448F3D8075A6978")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String stremSwhpUbicaciongeneral = vars.getSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.stremSwhpUbicaciongeneral");
        String strProcessing = vars.getSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.strProcessing");
        String strOrg = vars.getSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.strOrg");
        String strClient = vars.getSessionValue("buttonF608BCACA3EE4649A448F3D8075A6978.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Swhp_UbicaciongeneralF608BCACA3EE4649A448F3D8075A6978(response, vars, strM_Movement_ID, stremSwhpUbicaciongeneral, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssvs_BprepositionD3BA849A76B44C739D4503A1238C6645")) {
        vars.setSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.stremSsvsBpreposition", vars.getStringParameter("inpemSsvsBpreposition"));
        vars.setSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD3BA849A76B44C739D4503A1238C6645.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D3BA849A76B44C739D4503A1238C6645", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND3BA849A76B44C739D4503A1238C6645")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String stremSsvsBpreposition = vars.getSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.stremSsvsBpreposition");
        String strProcessing = vars.getSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.strProcessing");
        String strOrg = vars.getSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.strOrg");
        String strClient = vars.getSessionValue("buttonD3BA849A76B44C739D4503A1238C6645.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssvs_BprepositionD3BA849A76B44C739D4503A1238C6645(response, vars, strM_Movement_ID, stremSsvsBpreposition, strProcessing);
        }

    } else if (vars.commandIn("BUTTONEM_Eei_Send_To_Sri7CC8083871A2456BAC7B948F3510BC3C")) {
        vars.setSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.stremEeiSendToSri", vars.getStringParameter("inpemEeiSendToSri"));
        vars.setSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7CC8083871A2456BAC7B948F3510BC3C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7CC8083871A2456BAC7B948F3510BC3C", request.getServletPath());
      } else if (vars.commandIn("BUTTON7CC8083871A2456BAC7B948F3510BC3C")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String stremEeiSendToSri = vars.getSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.stremEeiSendToSri");
        String strProcessing = vars.getSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.strProcessing");
        String strOrg = vars.getSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.strOrg");
        String strClient = vars.getSessionValue("button7CC8083871A2456BAC7B948F3510BC3C.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Eei_Send_To_Sri7CC8083871A2456BAC7B948F3510BC3C(response, vars, strM_Movement_ID, stremEeiSendToSri, strProcessing);
        }
    } else if (vars.commandIn("BUTTONEM_Stat_Generate_CodeB0DCB2771D744EAA8F75B2B6530CABF8")) {
        vars.setSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.stremStatGenerateCode", vars.getStringParameter("inpemStatGenerateCode"));
        vars.setSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB0DCB2771D744EAA8F75B2B6530CABF8.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B0DCB2771D744EAA8F75B2B6530CABF8", request.getServletPath());
      } else if (vars.commandIn("BUTTONB0DCB2771D744EAA8F75B2B6530CABF8")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String stremStatGenerateCode = vars.getSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.stremStatGenerateCode");
        String strProcessing = vars.getSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.strProcessing");
        String strOrg = vars.getSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.strOrg");
        String strClient = vars.getSessionValue("buttonB0DCB2771D744EAA8F75B2B6530CABF8.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Stat_Generate_CodeB0DCB2771D744EAA8F75B2B6530CABF8(response, vars, strM_Movement_ID, stremStatGenerateCode, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONMove_FromTo_Locator800048")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        String strmoveFromtoLocator = vars.getStringParameter("inpmoveFromtoLocator");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "800048", (("M_Movement_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Movement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strmLocatorfrom = vars.getStringParameter("inpmLocatorfrom");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "M_LocatorFrom", strmLocatorfrom, vars.getClient(), vars.getOrg(), vars.getUser());
String strmLocatorto = vars.getStringParameter("inpmLocatorto");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "M_LocatorTo", strmLocatorto, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessingD3ED058DE3444DAFB49DB442919A980B")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        String strprocessing = vars.getStringParameter("inpprocessing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D3ED058DE3444DAFB49DB442919A980B", (("M_Movement_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Movement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strstatCode = vars.getStringParameter("inpstatCode");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "Stat_Code", strstatCode, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Stat_Processing122")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        String stremStatProcessing = vars.getStringParameter("inpemStatProcessing");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "122", (("M_Movement_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Movement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Smvwh_CreatelinesDB2C50639DA742E6890ED59EFC808554")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        String stremSmvwhCreatelines = vars.getStringParameter("inpemSmvwhCreatelines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "DB2C50639DA742E6890ED59EFC808554", (("M_Movement_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Movement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Swhp_UbicaciongeneralF608BCACA3EE4649A448F3D8075A6978")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        String stremSwhpUbicaciongeneral = vars.getStringParameter("inpemSwhpUbicaciongeneral");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "F608BCACA3EE4649A448F3D8075A6978", (("M_Movement_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Movement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssvs_BprepositionD3BA849A76B44C739D4503A1238C6645")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        String stremSsvsBpreposition = vars.getStringParameter("inpemSsvsBpreposition");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D3BA849A76B44C739D4503A1238C6645", (("M_Movement_ID".equalsIgnoreCase("AD_Language"))?"0":strM_Movement_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strmProductCategoryId = vars.getStringParameter("inpmProductCategoryId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "M_Product_Category_ID", strmProductCategoryId, vars.getClient(), vars.getOrg(), vars.getUser());
String strssvsReposition = vars.getNumericParameter("inpssvsReposition");
PInstanceProcessData.insertPInstanceParamNumber(this, pinstance, "20", "ssvs_reposition", strssvsReposition, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    } else if (vars.commandIn("SAVE_BUTTONEM_Eei_Send_To_Sri7CC8083871A2456BAC7B948F3510BC3C")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        
        ProcessBundle pb = new ProcessBundle("7CC8083871A2456BAC7B948F3510BC3C", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("M_Movement_ID", strM_Movement_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Stat_Generate_CodeB0DCB2771D744EAA8F75B2B6530CABF8")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpKey", windowId + "|M_Movement_ID", "");
        
        ProcessBundle pb = new ProcessBundle("B0DCB2771D744EAA8F75B2B6530CABF8", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("M_Movement_ID", strM_Movement_ID);
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


    } else if (vars.commandIn("BUTTONPosted")) {
        String strM_Movement_ID = vars.getGlobalVariable("inpmMovementId", windowId + "|M_Movement_ID", "");
        String strTableId = "323";
        String strPosted = vars.getStringParameter("inpposted");
        String strProcessId = "";
        log4j.debug("Loading Posted button in table: " + strTableId);
        String strOrg = vars.getStringParameter("inpadOrgId");
        String strClient = vars.getStringParameter("inpadClientId");
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{
          vars.setSessionValue("Posted|key", strM_Movement_ID);
          vars.setSessionValue("Posted|tableId", strTableId);
          vars.setSessionValue("Posted|tabId", tabId);
          vars.setSessionValue("Posted|posted", strPosted);
          vars.setSessionValue("Posted|processId", strProcessId);
          vars.setSessionValue("Posted|path", strDireccion + request.getServletPath());
          vars.setSessionValue("Posted|windowId", windowId);
          vars.setSessionValue("Posted|tabName", "Header");
          response.sendRedirect(strDireccion + "/ad_actionButton/Posted.html");
        }

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

    private void printPageButtonMove_FromTo_Locator800048(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String strmoveFromtoLocator, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800048");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Move_FromTo_Locator800048", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "800048");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("800048");
        vars.removeMessage("800048");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("M_LocatorFrom", "");
    xmlDocument.setParameter("M_LocatorFromR", HeaderData.selectActDefM_LocatorFrom(this, ""));
    xmlDocument.setParameter("M_LocatorTo", "");
    xmlDocument.setParameter("M_LocatorToR", HeaderData.selectActDefM_LocatorTo(this, ""));
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonProcessingD3ED058DE3444DAFB49DB442919A980B(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String strprocessing, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D3ED058DE3444DAFB49DB442919A980B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessingD3ED058DE3444DAFB49DB442919A980B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D3ED058DE3444DAFB49DB442919A980B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D3ED058DE3444DAFB49DB442919A980B");
        vars.removeMessage("D3ED058DE3444DAFB49DB442919A980B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Stat_Code", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Stat_Processing122(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String stremStatProcessing, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 122");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Stat_Processing122", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "122");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("122");
        vars.removeMessage("122");
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
    private void printPageButtonEM_Smvwh_CreatelinesDB2C50639DA742E6890ED59EFC808554(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String stremSmvwhCreatelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DB2C50639DA742E6890ED59EFC808554");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Smvwh_CreatelinesDB2C50639DA742E6890ED59EFC808554", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DB2C50639DA742E6890ED59EFC808554");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DB2C50639DA742E6890ED59EFC808554");
        vars.removeMessage("DB2C50639DA742E6890ED59EFC808554");
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
    private void printPageButtonEM_Swhp_UbicaciongeneralF608BCACA3EE4649A448F3D8075A6978(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String stremSwhpUbicaciongeneral, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process F608BCACA3EE4649A448F3D8075A6978");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Swhp_UbicaciongeneralF608BCACA3EE4649A448F3D8075A6978", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "F608BCACA3EE4649A448F3D8075A6978");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("F608BCACA3EE4649A448F3D8075A6978");
        vars.removeMessage("F608BCACA3EE4649A448F3D8075A6978");
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
    private void printPageButtonEM_Ssvs_BprepositionD3BA849A76B44C739D4503A1238C6645(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String stremSsvsBpreposition, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D3BA849A76B44C739D4503A1238C6645");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssvs_BprepositionD3BA849A76B44C739D4503A1238C6645", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D3BA849A76B44C739D4503A1238C6645");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D3BA849A76B44C739D4503A1238C6645");
        vars.removeMessage("D3BA849A76B44C739D4503A1238C6645");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Product_Category_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "M_Product_Category_ID", "163", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonD3BA849A76B44C739D4503A1238C6645.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportM_Product_Category_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("ssvs_reposition", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }


    void printPageButtonEM_Eei_Send_To_Sri7CC8083871A2456BAC7B948F3510BC3C(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String stremEeiSendToSri, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7CC8083871A2456BAC7B948F3510BC3C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Eei_Send_To_Sri7CC8083871A2456BAC7B948F3510BC3C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7CC8083871A2456BAC7B948F3510BC3C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7CC8083871A2456BAC7B948F3510BC3C");
        vars.removeMessage("7CC8083871A2456BAC7B948F3510BC3C");
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
    void printPageButtonEM_Stat_Generate_CodeB0DCB2771D744EAA8F75B2B6530CABF8(HttpServletResponse response, VariablesSecureApp vars, String strM_Movement_ID, String stremStatGenerateCode, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B0DCB2771D744EAA8F75B2B6530CABF8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Stat_Generate_CodeB0DCB2771D744EAA8F75B2B6530CABF8", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_Movement_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Header_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B0DCB2771D744EAA8F75B2B6530CABF8");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B0DCB2771D744EAA8F75B2B6530CABF8");
        vars.removeMessage("B0DCB2771D744EAA8F75B2B6530CABF8");
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
