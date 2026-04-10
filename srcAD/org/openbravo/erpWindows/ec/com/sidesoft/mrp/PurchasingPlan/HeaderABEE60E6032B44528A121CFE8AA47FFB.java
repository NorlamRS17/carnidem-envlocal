
package org.openbravo.erpWindows.ec.com.sidesoft.mrp.PurchasingPlan;


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
public class HeaderABEE60E6032B44528A121CFE8AA47FFB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E8670310C7C14C7E939A35BEA4A56FDB";
  private static final String tabId = "ABEE60E6032B44528A121CFE8AA47FFB";
  private static final int accesslevel = 1;
  private static final String moduleId = "BCDA989719C148D782867D738F70DA8D";
  
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
     
      if (command.contains("7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        SessionInfo.setModuleId("0");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("800164")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("800164");
        SessionInfo.setModuleId("0");
        if (securedProcess || explicitAccess.contains("800164")) {
          classInfo.type = "P";
          classInfo.id = "800164";
        }
      }
     
      if (command.contains("4DEA4E15C0EE42B3B94FBA5A95E3D426")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("4DEA4E15C0EE42B3B94FBA5A95E3D426");
        SessionInfo.setModuleId("A48E76A5BE664C7E9FDC21C9A8FC4F90");
        if (securedProcess || explicitAccess.contains("4DEA4E15C0EE42B3B94FBA5A95E3D426")) {
          classInfo.type = "P";
          classInfo.id = "4DEA4E15C0EE42B3B94FBA5A95E3D426";
        }
      }
     
      if (command.contains("0C247FB01A1C4EE7931869ACB4127BCA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("0C247FB01A1C4EE7931869ACB4127BCA");
        SessionInfo.setModuleId("B567A8EB1BF7419F94D4C2891BA72378");
        if (securedProcess || explicitAccess.contains("0C247FB01A1C4EE7931869ACB4127BCA")) {
          classInfo.type = "P";
          classInfo.id = "0C247FB01A1C4EE7931869ACB4127BCA";
        }
      }
     

     
      if (explicitAccess.contains("7CB6B4D1ECCF4036B3F111D2CF11AADE") || (securedProcess && command.contains("7CB6B4D1ECCF4036B3F111D2CF11AADE"))) {
        classInfo.type = "P";
        classInfo.id = "7CB6B4D1ECCF4036B3F111D2CF11AADE";
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

     } else if (vars.commandIn("BUTTONSimulate800164")) {
        vars.setSessionValue("button800164.strsimulate", vars.getStringParameter("inpsimulate"));
        vars.setSessionValue("button800164.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button800164.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button800164.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button800164.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "800164", request.getServletPath());    
     } else if (vars.commandIn("BUTTON800164")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID", "");
        String strsimulate = vars.getSessionValue("button800164.strsimulate");
        String strProcessing = vars.getSessionValue("button800164.strProcessing");
        String strOrg = vars.getSessionValue("button800164.strOrg");
        String strClient = vars.getSessionValue("button800164.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonSimulate800164(response, vars, strMRP_Run_Purchase_ID, strsimulate, strProcessing);
        }

     } else if (vars.commandIn("BUTTONLaunchpo4DEA4E15C0EE42B3B94FBA5A95E3D426")) {
        vars.setSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strlaunchpo", vars.getStringParameter("inplaunchpo"));
        vars.setSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        p.put("AD_ORG_ID", vars.getStringParameter("inpadOrgId"));

        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button4DEA4E15C0EE42B3B94FBA5A95E3D426.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "4DEA4E15C0EE42B3B94FBA5A95E3D426", request.getServletPath());    
     } else if (vars.commandIn("BUTTON4DEA4E15C0EE42B3B94FBA5A95E3D426")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID", "");
        String strlaunchpo = vars.getSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strlaunchpo");
        String strProcessing = vars.getSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strProcessing");
        String strOrg = vars.getSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strOrg");
        String strClient = vars.getSessionValue("button4DEA4E15C0EE42B3B94FBA5A95E3D426.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLaunchpo4DEA4E15C0EE42B3B94FBA5A95E3D426(response, vars, strMRP_Run_Purchase_ID, strlaunchpo, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Cscm_Deletelines0C247FB01A1C4EE7931869ACB4127BCA")) {
        vars.setSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.stremCscmDeletelines", vars.getStringParameter("inpemCscmDeletelines"));
        vars.setSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button0C247FB01A1C4EE7931869ACB4127BCA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "0C247FB01A1C4EE7931869ACB4127BCA", request.getServletPath());    
     } else if (vars.commandIn("BUTTON0C247FB01A1C4EE7931869ACB4127BCA")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID", "");
        String stremCscmDeletelines = vars.getSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.stremCscmDeletelines");
        String strProcessing = vars.getSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.strProcessing");
        String strOrg = vars.getSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.strOrg");
        String strClient = vars.getSessionValue("button0C247FB01A1C4EE7931869ACB4127BCA.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Cscm_Deletelines0C247FB01A1C4EE7931869ACB4127BCA(response, vars, strMRP_Run_Purchase_ID, stremCscmDeletelines, strProcessing);
        }

    } else if (vars.commandIn("BUTTONCreate_Reservations7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        vars.setSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strcreateReservations", vars.getStringParameter("inpcreateReservations"));
        vars.setSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7CB6B4D1ECCF4036B3F111D2CF11AADE.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7CB6B4D1ECCF4036B3F111D2CF11AADE", request.getServletPath());
      } else if (vars.commandIn("BUTTON7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpmrpRunPurchaseId", windowId + "|MRP_Run_Purchase_ID", "");
        String strcreateReservations = vars.getSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strcreateReservations");
        String strProcessing = vars.getSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strProcessing");
        String strOrg = vars.getSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strOrg");
        String strClient = vars.getSessionValue("button7CB6B4D1ECCF4036B3F111D2CF11AADE.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonCreate_Reservations7CB6B4D1ECCF4036B3F111D2CF11AADE(response, vars, strMRP_Run_Purchase_ID, strcreateReservations, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONSimulate800164")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Run_Purchase_ID", "");
        String strsimulate = vars.getStringParameter("inpsimulate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "800164", (("MRP_Run_Purchase_ID".equalsIgnoreCase("AD_Language"))?"0":strMRP_Run_Purchase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONLaunchpo4DEA4E15C0EE42B3B94FBA5A95E3D426")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Run_Purchase_ID", "");
        String strlaunchpo = vars.getStringParameter("inplaunchpo");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "4DEA4E15C0EE42B3B94FBA5A95E3D426", (("MRP_Run_Purchase_ID".equalsIgnoreCase("AD_Language"))?"0":strMRP_Run_Purchase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "M_Warehouse_ID", strmWarehouseId, vars.getClient(), vars.getOrg(), vars.getUser());
String strgroupinglines = vars.getStringParameter("inpgroupinglines", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "GROUPINGLINES", strgroupinglines, vars.getClient(), vars.getOrg(), vars.getUser());

          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Cscm_Deletelines0C247FB01A1C4EE7931869ACB4127BCA")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Run_Purchase_ID", "");
        String stremCscmDeletelines = vars.getStringParameter("inpemCscmDeletelines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "0C247FB01A1C4EE7931869ACB4127BCA", (("MRP_Run_Purchase_ID".equalsIgnoreCase("AD_Language"))?"0":strMRP_Run_Purchase_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcOrderlineId = vars.getStringParameter("inpcOrderlineId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_OrderLine_ID", strcOrderlineId, vars.getClient(), vars.getOrg(), vars.getUser());
String strcscmDelforecastrel = vars.getStringParameter("inpcscmDelforecastrel", "N");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "20", "cscm_delforecastrel", strcscmDelforecastrel, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    } else if (vars.commandIn("SAVE_BUTTONCreate_Reservations7CB6B4D1ECCF4036B3F111D2CF11AADE")) {
        String strMRP_Run_Purchase_ID = vars.getGlobalVariable("inpKey", windowId + "|MRP_Run_Purchase_ID", "");
        
        ProcessBundle pb = new ProcessBundle("7CB6B4D1ECCF4036B3F111D2CF11AADE", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("MRP_Run_Purchase_ID", strMRP_Run_Purchase_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strmWarehouseId = vars.getStringParameter("inpmWarehouseId");
params.put("mWarehouseId", strmWarehouseId);

        
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

    private void printPageButtonSimulate800164(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Run_Purchase_ID, String strsimulate, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 800164");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Simulate800164", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Run_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderABEE60E6032B44528A121CFE8AA47FFB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "800164");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("800164");
        vars.removeMessage("800164");
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
    private void printPageButtonLaunchpo4DEA4E15C0EE42B3B94FBA5A95E3D426(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Run_Purchase_ID, String strlaunchpo, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 4DEA4E15C0EE42B3B94FBA5A95E3D426");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Launchpo4DEA4E15C0EE42B3B94FBA5A95E3D426", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Run_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderABEE60E6032B44528A121CFE8AA47FFB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "4DEA4E15C0EE42B3B94FBA5A95E3D426");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("4DEA4E15C0EE42B3B94FBA5A95E3D426");
        vars.removeMessage("4DEA4E15C0EE42B3B94FBA5A95E3D426");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Warehouse_ID", Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "71188F0005494DA08311B4FFB2C5A993", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button4DEA4E15C0EE42B3B94FBA5A95E3D426.originalParams"), comboTableData, windowId, Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    xmlDocument.setParameter("GROUPINGLINES", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    private void printPageButtonEM_Cscm_Deletelines0C247FB01A1C4EE7931869ACB4127BCA(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Run_Purchase_ID, String stremCscmDeletelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 0C247FB01A1C4EE7931869ACB4127BCA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Cscm_Deletelines0C247FB01A1C4EE7931869ACB4127BCA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Run_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderABEE60E6032B44528A121CFE8AA47FFB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "0C247FB01A1C4EE7931869ACB4127BCA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("0C247FB01A1C4EE7931869ACB4127BCA");
        vars.removeMessage("0C247FB01A1C4EE7931869ACB4127BCA");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("C_OrderLine_ID", "");
    xmlDocument.setParameter("cscm_delforecastrel", "");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }


    void printPageButtonCreate_Reservations7CB6B4D1ECCF4036B3F111D2CF11AADE(HttpServletResponse response, VariablesSecureApp vars, String strMRP_Run_Purchase_ID, String strcreateReservations, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7CB6B4D1ECCF4036B3F111D2CF11AADE");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Create_Reservations7CB6B4D1ECCF4036B3F111D2CF11AADE", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMRP_Run_Purchase_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderABEE60E6032B44528A121CFE8AA47FFB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7CB6B4D1ECCF4036B3F111D2CF11AADE");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        vars.removeMessage("7CB6B4D1ECCF4036B3F111D2CF11AADE");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("M_Warehouse_ID", Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    comboTableData = new ComboTableData(vars, this, "19", "M_Warehouse_ID", "", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button7CB6B4D1ECCF4036B3F111D2CF11AADE.originalParams"), comboTableData, windowId, Utility.getContext(this, vars, "#M_Warehouse_ID", windowId));
    xmlDocument.setData("reportM_Warehouse_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
