
package org.openbravo.erpWindows.ec.com.sidesoft.production.auto.transfer.mp.Transfer;


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
public class TransferFB3524E8DFC340D6A679A083D150E884 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "B9FDE66302BA4CC5B2779CB9F2086CAE";
  private static final String tabId = "FB3524E8DFC340D6A679A083D150E884";
  private static final int accesslevel = 3;
  private static final String moduleId = "CC9D91872AFE473E93D9D6A5A643DE75";
  
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
     
      if (command.contains("E5F83B279855489F8D32BB6AA4F79A7C")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E5F83B279855489F8D32BB6AA4F79A7C");
        SessionInfo.setModuleId("CC9D91872AFE473E93D9D6A5A643DE75");
        if (securedProcess || explicitAccess.contains("E5F83B279855489F8D32BB6AA4F79A7C")) {
          classInfo.type = "P";
          classInfo.id = "E5F83B279855489F8D32BB6AA4F79A7C";
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

     } else if (vars.commandIn("BUTTONGenerate_TransferE5F83B279855489F8D32BB6AA4F79A7C")) {
        vars.setSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strgenerateTransfer", vars.getStringParameter("inpgenerateTransfer"));
        vars.setSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE5F83B279855489F8D32BB6AA4F79A7C.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E5F83B279855489F8D32BB6AA4F79A7C", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE5F83B279855489F8D32BB6AA4F79A7C")) {
        String strSpatmp_Transfer_ID = vars.getGlobalVariable("inpspatmpTransferId", windowId + "|Spatmp_Transfer_ID", "");
        String strgenerateTransfer = vars.getSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strgenerateTransfer");
        String strProcessing = vars.getSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strProcessing");
        String strOrg = vars.getSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strOrg");
        String strClient = vars.getSessionValue("buttonE5F83B279855489F8D32BB6AA4F79A7C.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGenerate_TransferE5F83B279855489F8D32BB6AA4F79A7C(response, vars, strSpatmp_Transfer_ID, strgenerateTransfer, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONGenerate_TransferE5F83B279855489F8D32BB6AA4F79A7C")) {
        String strSpatmp_Transfer_ID = vars.getGlobalVariable("inpKey", windowId + "|Spatmp_Transfer_ID", "");
        String strgenerateTransfer = vars.getStringParameter("inpgenerateTransfer");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E5F83B279855489F8D32BB6AA4F79A7C", (("Spatmp_Transfer_ID".equalsIgnoreCase("AD_Language"))?"0":strSpatmp_Transfer_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          String strcDoctypeId = vars.getStringParameter("inpcDoctypeId");
PInstanceProcessData.insertPInstanceParam(this, pinstance, "10", "C_DocType_ID", strcDoctypeId, vars.getClient(), vars.getOrg(), vars.getUser());

          
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

    private void printPageButtonGenerate_TransferE5F83B279855489F8D32BB6AA4F79A7C(HttpServletResponse response, VariablesSecureApp vars, String strSpatmp_Transfer_ID, String strgenerateTransfer, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E5F83B279855489F8D32BB6AA4F79A7C");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Generate_TransferE5F83B279855489F8D32BB6AA4F79A7C", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSpatmp_Transfer_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "TransferFB3524E8DFC340D6A679A083D150E884_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E5F83B279855489F8D32BB6AA4F79A7C");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E5F83B279855489F8D32BB6AA4F79A7C");
        vars.removeMessage("E5F83B279855489F8D32BB6AA4F79A7C");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("C_DocType_ID", "");
    comboTableData = new ComboTableData(vars, this, "18", "C_DocType_ID", "170", "BD708473F372400BB0DA80D3BB3AD510", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("buttonE5F83B279855489F8D32BB6AA4F79A7C.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportC_DocType_ID", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }



}
