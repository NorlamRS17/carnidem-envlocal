
package org.openbravo.erpWindows.Assets;


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
public class Assets extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "800027";
  private static final String tabId = "800078";
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
     
      if (command.contains("177A8D600E334A188E193EC8C647AED0")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("177A8D600E334A188E193EC8C647AED0");
        SessionInfo.setModuleId("109FD67312E942D78B0202B3DD4C1E81");
      }
     
      if (command.contains("60B20166BD984E8EBCB9ABCA90329BCA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("60B20166BD984E8EBCB9ABCA90329BCA");
        SessionInfo.setModuleId("3938F3512D0743AA9F096291358071CA");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("EDF5D535DCAC41B2B96607CEF881C333")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("EDF5D535DCAC41B2B96607CEF881C333");
        SessionInfo.setModuleId("278A9C04469044089FED34602292B70C");
        if (securedProcess || explicitAccess.contains("EDF5D535DCAC41B2B96607CEF881C333")) {
          classInfo.type = "P";
          classInfo.id = "EDF5D535DCAC41B2B96607CEF881C333";
        }
      }
     
      if (command.contains("800125")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("800125");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("800125")) {
          classInfo.type = "P";
          classInfo.id = "800125";
        }
      }
     
      if (command.contains("DB650BA1E0944A32A99435E0EAA1139E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("DB650BA1E0944A32A99435E0EAA1139E");
        SessionInfo.setModuleId("BF92C932D8134C16BF54C604B978DEB0");
        if (securedProcess || explicitAccess.contains("DB650BA1E0944A32A99435E0EAA1139E")) {
          classInfo.type = "P";
          classInfo.id = "DB650BA1E0944A32A99435E0EAA1139E";
        }
      }
     
      if (command.contains("19FDDAD4EA7A4746AF8F06985D22F989")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("19FDDAD4EA7A4746AF8F06985D22F989");
        SessionInfo.setModuleId("BF92C932D8134C16BF54C604B978DEB0");
        if (securedProcess || explicitAccess.contains("19FDDAD4EA7A4746AF8F06985D22F989")) {
          classInfo.type = "P";
          classInfo.id = "19FDDAD4EA7A4746AF8F06985D22F989";
        }
      }
     

     
      if (explicitAccess.contains("177A8D600E334A188E193EC8C647AED0") || (securedProcess && command.contains("177A8D600E334A188E193EC8C647AED0"))) {
        classInfo.type = "P";
        classInfo.id = "177A8D600E334A188E193EC8C647AED0";
      }
     
      if (explicitAccess.contains("60B20166BD984E8EBCB9ABCA90329BCA") || (securedProcess && command.contains("60B20166BD984E8EBCB9ABCA90329BCA"))) {
        classInfo.type = "P";
        classInfo.id = "60B20166BD984E8EBCB9ABCA90329BCA";
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

     } else if (vars.commandIn("BUTTONEM_Sda_DerecognitionEDF5D535DCAC41B2B96607CEF881C333")) {
        vars.setSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.stremSdaDerecognition", vars.getStringParameter("inpemSdaDerecognition"));
        vars.setSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonEDF5D535DCAC41B2B96607CEF881C333.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "EDF5D535DCAC41B2B96607CEF881C333", request.getServletPath());    
     } else if (vars.commandIn("BUTTONEDF5D535DCAC41B2B96607CEF881C333")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String stremSdaDerecognition = vars.getSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.stremSdaDerecognition");
        String strProcessing = vars.getSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.strProcessing");
        String strOrg = vars.getSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.strOrg");
        String strClient = vars.getSessionValue("buttonEDF5D535DCAC41B2B96607CEF881C333.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sda_DerecognitionEDF5D535DCAC41B2B96607CEF881C333(response, vars, strA_Asset_ID, stremSdaDerecognition, strProcessing);
        }

     } else if (vars.commandIn("BUTTONProcessed800125")) {
        vars.setSessionValue("button800125.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button800125.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button800125.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button800125.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button800125.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "800125", request.getServletPath());    
     } else if (vars.commandIn("BUTTON800125")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String strprocessed = vars.getSessionValue("button800125.strprocessed");
        String strProcessing = vars.getSessionValue("button800125.strProcessing");
        String strOrg = vars.getSessionValue("button800125.strOrg");
        String strClient = vars.getSessionValue("button800125.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed800125(response, vars, strA_Asset_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONem_seact_abreactivateDB650BA1E0944A32A99435E0EAA1139E")) {
        vars.setSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.stremSeactAbreactivate", vars.getStringParameter("inpemSeactAbreactivate"));
        vars.setSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonDB650BA1E0944A32A99435E0EAA1139E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "DB650BA1E0944A32A99435E0EAA1139E", request.getServletPath());    
     } else if (vars.commandIn("BUTTONDB650BA1E0944A32A99435E0EAA1139E")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String stremSeactAbreactivate = vars.getSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.stremSeactAbreactivate");
        String strProcessing = vars.getSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.strProcessing");
        String strOrg = vars.getSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.strOrg");
        String strClient = vars.getSessionValue("buttonDB650BA1E0944A32A99435E0EAA1139E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonem_seact_abreactivateDB650BA1E0944A32A99435E0EAA1139E(response, vars, strA_Asset_ID, stremSeactAbreactivate, strProcessing);
        }

     } else if (vars.commandIn("BUTTONem_seact_abprocess19FDDAD4EA7A4746AF8F06985D22F989")) {
        vars.setSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.stremSeactAbprocess", vars.getStringParameter("inpemSeactAbprocess"));
        vars.setSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button19FDDAD4EA7A4746AF8F06985D22F989.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "19FDDAD4EA7A4746AF8F06985D22F989", request.getServletPath());    
     } else if (vars.commandIn("BUTTON19FDDAD4EA7A4746AF8F06985D22F989")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String stremSeactAbprocess = vars.getSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.stremSeactAbprocess");
        String strProcessing = vars.getSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.strProcessing");
        String strOrg = vars.getSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.strOrg");
        String strClient = vars.getSessionValue("button19FDDAD4EA7A4746AF8F06985D22F989.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonem_seact_abprocess19FDDAD4EA7A4746AF8F06985D22F989(response, vars, strA_Asset_ID, stremSeactAbprocess, strProcessing);
        }

    } else if (vars.commandIn("BUTTONProcess_Asset177A8D600E334A188E193EC8C647AED0")) {
        vars.setSessionValue("button177A8D600E334A188E193EC8C647AED0.strprocessAsset", vars.getStringParameter("inpprocessAsset"));
        vars.setSessionValue("button177A8D600E334A188E193EC8C647AED0.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button177A8D600E334A188E193EC8C647AED0.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button177A8D600E334A188E193EC8C647AED0.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button177A8D600E334A188E193EC8C647AED0.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "177A8D600E334A188E193EC8C647AED0", request.getServletPath());
      } else if (vars.commandIn("BUTTON177A8D600E334A188E193EC8C647AED0")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String strprocessAsset = vars.getSessionValue("button177A8D600E334A188E193EC8C647AED0.strprocessAsset");
        String strProcessing = vars.getSessionValue("button177A8D600E334A188E193EC8C647AED0.strProcessing");
        String strOrg = vars.getSessionValue("button177A8D600E334A188E193EC8C647AED0.strOrg");
        String strClient = vars.getSessionValue("button177A8D600E334A188E193EC8C647AED0.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess_Asset177A8D600E334A188E193EC8C647AED0(response, vars, strA_Asset_ID, strprocessAsset, strProcessing);
        }
    } else if (vars.commandIn("BUTTONEM_Ssarv_Depreciation_Plan60B20166BD984E8EBCB9ABCA90329BCA")) {
        vars.setSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.stremSsarvDepreciationPlan", vars.getStringParameter("inpemSsarvDepreciationPlan"));
        vars.setSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button60B20166BD984E8EBCB9ABCA90329BCA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "60B20166BD984E8EBCB9ABCA90329BCA", request.getServletPath());
      } else if (vars.commandIn("BUTTON60B20166BD984E8EBCB9ABCA90329BCA")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpaAssetId", windowId + "|A_Asset_ID", "");
        String stremSsarvDepreciationPlan = vars.getSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.stremSsarvDepreciationPlan");
        String strProcessing = vars.getSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.strProcessing");
        String strOrg = vars.getSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.strOrg");
        String strClient = vars.getSessionValue("button60B20166BD984E8EBCB9ABCA90329BCA.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssarv_Depreciation_Plan60B20166BD984E8EBCB9ABCA90329BCA(response, vars, strA_Asset_ID, stremSsarvDepreciationPlan, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONEM_Sda_DerecognitionEDF5D535DCAC41B2B96607CEF881C333")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        String stremSdaDerecognition = vars.getStringParameter("inpemSdaDerecognition");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "EDF5D535DCAC41B2B96607CEF881C333", (("A_Asset_ID".equalsIgnoreCase("AD_Language"))?"0":strA_Asset_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONProcessed800125")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "800125", (("A_Asset_ID".equalsIgnoreCase("AD_Language"))?"0":strA_Asset_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONem_seact_abreactivateDB650BA1E0944A32A99435E0EAA1139E")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        String stremSeactAbreactivate = vars.getStringParameter("inpemSeactAbreactivate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "DB650BA1E0944A32A99435E0EAA1139E", (("A_Asset_ID".equalsIgnoreCase("AD_Language"))?"0":strA_Asset_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONem_seact_abprocess19FDDAD4EA7A4746AF8F06985D22F989")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        String stremSeactAbprocess = vars.getStringParameter("inpemSeactAbprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "19FDDAD4EA7A4746AF8F06985D22F989", (("A_Asset_ID".equalsIgnoreCase("AD_Language"))?"0":strA_Asset_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONProcess_Asset177A8D600E334A188E193EC8C647AED0")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        
        ProcessBundle pb = new ProcessBundle("177A8D600E334A188E193EC8C647AED0", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("A_Asset_ID", strA_Asset_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssarv_Depreciation_Plan60B20166BD984E8EBCB9ABCA90329BCA")) {
        String strA_Asset_ID = vars.getGlobalVariable("inpKey", windowId + "|A_Asset_ID", "");
        
        ProcessBundle pb = new ProcessBundle("60B20166BD984E8EBCB9ABCA90329BCA", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("A_Asset_ID", strA_Asset_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strchangedate = vars.getStringParameter("inpchangedate");
params.put("changedate", strchangedate);
String strstartdate = vars.getStringParameter("inpstartdate");
params.put("startdate", strstartdate);
String strnewassetvalue = vars.getNumericParameter("inpnewassetvalue");
params.put("newassetvalue", strnewassetvalue);
String strusefullife = vars.getNumericParameter("inpusefullife");
params.put("usefullife", strusefullife);
String strdescription = vars.getStringParameter("inpdescription");
params.put("description", strdescription);

        
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

    private void printPageButtonEM_Sda_DerecognitionEDF5D535DCAC41B2B96607CEF881C333(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String stremSdaDerecognition, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process EDF5D535DCAC41B2B96607CEF881C333");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sda_DerecognitionEDF5D535DCAC41B2B96607CEF881C333", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assets_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "EDF5D535DCAC41B2B96607CEF881C333");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("EDF5D535DCAC41B2B96607CEF881C333");
        vars.removeMessage("EDF5D535DCAC41B2B96607CEF881C333");
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
    private void printPageButtonProcessed800125(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800125");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Processed800125", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assets_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "800125");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("800125");
        vars.removeMessage("800125");
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
    private void printPageButtonem_seact_abreactivateDB650BA1E0944A32A99435E0EAA1139E(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String stremSeactAbreactivate, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process DB650BA1E0944A32A99435E0EAA1139E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/em_seact_abreactivateDB650BA1E0944A32A99435E0EAA1139E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assets_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "DB650BA1E0944A32A99435E0EAA1139E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("DB650BA1E0944A32A99435E0EAA1139E");
        vars.removeMessage("DB650BA1E0944A32A99435E0EAA1139E");
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
    private void printPageButtonem_seact_abprocess19FDDAD4EA7A4746AF8F06985D22F989(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String stremSeactAbprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 19FDDAD4EA7A4746AF8F06985D22F989");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/em_seact_abprocess19FDDAD4EA7A4746AF8F06985D22F989", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assets_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "19FDDAD4EA7A4746AF8F06985D22F989");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("19FDDAD4EA7A4746AF8F06985D22F989");
        vars.removeMessage("19FDDAD4EA7A4746AF8F06985D22F989");
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


    void printPageButtonProcess_Asset177A8D600E334A188E193EC8C647AED0(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String strprocessAsset, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 177A8D600E334A188E193EC8C647AED0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process_Asset177A8D600E334A188E193EC8C647AED0", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assets_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "177A8D600E334A188E193EC8C647AED0");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("177A8D600E334A188E193EC8C647AED0");
        vars.removeMessage("177A8D600E334A188E193EC8C647AED0");
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
    void printPageButtonEM_Ssarv_Depreciation_Plan60B20166BD984E8EBCB9ABCA90329BCA(HttpServletResponse response, VariablesSecureApp vars, String strA_Asset_ID, String stremSsarvDepreciationPlan, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 60B20166BD984E8EBCB9ABCA90329BCA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssarv_Depreciation_Plan60B20166BD984E8EBCB9ABCA90329BCA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strA_Asset_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assets_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "60B20166BD984E8EBCB9ABCA90329BCA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("60B20166BD984E8EBCB9ABCA90329BCA");
        vars.removeMessage("60B20166BD984E8EBCB9ABCA90329BCA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("ChangeDate", "");
    xmlDocument.setParameter("ChangeDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("StartDate", "");
    xmlDocument.setParameter("StartDate_Format", vars.getSessionValue("#AD_SqlDateFormat"));
    xmlDocument.setParameter("NewAssetValue", "");
    xmlDocument.setParameter("UsefulLife", "");
    xmlDocument.setParameter("Description", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
