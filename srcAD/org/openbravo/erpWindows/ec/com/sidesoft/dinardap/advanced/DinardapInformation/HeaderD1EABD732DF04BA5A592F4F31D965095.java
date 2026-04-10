
package org.openbravo.erpWindows.ec.com.sidesoft.dinardap.advanced.DinardapInformation;


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
public class HeaderD1EABD732DF04BA5A592F4F31D965095 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D4C47212972C49B98E99FEC511F4B52D";
  private static final String tabId = "D1EABD732DF04BA5A592F4F31D965095";
  private static final int accesslevel = 3;
  private static final String moduleId = "E5391C48407548348FABFF4E1BDC6F0D";
  
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
     
      if (command.contains("75BDBA6366F349EB84D46C0443F8B398")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("75BDBA6366F349EB84D46C0443F8B398");
        SessionInfo.setModuleId("E5391C48407548348FABFF4E1BDC6F0D");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("17A0268862214035AB232AFFD6FD050B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("17A0268862214035AB232AFFD6FD050B");
        SessionInfo.setModuleId("E5391C48407548348FABFF4E1BDC6F0D");
        if (securedProcess || explicitAccess.contains("17A0268862214035AB232AFFD6FD050B")) {
          classInfo.type = "P";
          classInfo.id = "17A0268862214035AB232AFFD6FD050B";
        }
      }
     
      if (command.contains("7DEEFF79E0CD43AEB624DBDBA9F8AE29")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7DEEFF79E0CD43AEB624DBDBA9F8AE29");
        SessionInfo.setModuleId("E5391C48407548348FABFF4E1BDC6F0D");
        if (securedProcess || explicitAccess.contains("7DEEFF79E0CD43AEB624DBDBA9F8AE29")) {
          classInfo.type = "P";
          classInfo.id = "7DEEFF79E0CD43AEB624DBDBA9F8AE29";
        }
      }
     

     
      if (explicitAccess.contains("75BDBA6366F349EB84D46C0443F8B398") || (securedProcess && command.contains("75BDBA6366F349EB84D46C0443F8B398"))) {
        classInfo.type = "P";
        classInfo.id = "75BDBA6366F349EB84D46C0443F8B398";
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

     } else if (vars.commandIn("BUTTONBTN_Load_Lines17A0268862214035AB232AFFD6FD050B")) {
        vars.setSessionValue("button17A0268862214035AB232AFFD6FD050B.strbtnLoadLines", vars.getStringParameter("inpbtnLoadLines"));
        vars.setSessionValue("button17A0268862214035AB232AFFD6FD050B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button17A0268862214035AB232AFFD6FD050B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button17A0268862214035AB232AFFD6FD050B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button17A0268862214035AB232AFFD6FD050B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "17A0268862214035AB232AFFD6FD050B", request.getServletPath());    
     } else if (vars.commandIn("BUTTON17A0268862214035AB232AFFD6FD050B")) {
        String strSdindp_Dinardap_ID = vars.getGlobalVariable("inpsdindpDinardapId", windowId + "|Sdindp_Dinardap_ID", "");
        String strbtnLoadLines = vars.getSessionValue("button17A0268862214035AB232AFFD6FD050B.strbtnLoadLines");
        String strProcessing = vars.getSessionValue("button17A0268862214035AB232AFFD6FD050B.strProcessing");
        String strOrg = vars.getSessionValue("button17A0268862214035AB232AFFD6FD050B.strOrg");
        String strClient = vars.getSessionValue("button17A0268862214035AB232AFFD6FD050B.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Load_Lines17A0268862214035AB232AFFD6FD050B(response, vars, strSdindp_Dinardap_ID, strbtnLoadLines, strProcessing);
        }

     } else if (vars.commandIn("BUTTONBTN_Debug_Info7DEEFF79E0CD43AEB624DBDBA9F8AE29")) {
        vars.setSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strbtnDebugInfo", vars.getStringParameter("inpbtnDebugInfo"));
        vars.setSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7DEEFF79E0CD43AEB624DBDBA9F8AE29", request.getServletPath());    
     } else if (vars.commandIn("BUTTON7DEEFF79E0CD43AEB624DBDBA9F8AE29")) {
        String strSdindp_Dinardap_ID = vars.getGlobalVariable("inpsdindpDinardapId", windowId + "|Sdindp_Dinardap_ID", "");
        String strbtnDebugInfo = vars.getSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strbtnDebugInfo");
        String strProcessing = vars.getSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strProcessing");
        String strOrg = vars.getSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strOrg");
        String strClient = vars.getSessionValue("button7DEEFF79E0CD43AEB624DBDBA9F8AE29.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Debug_Info7DEEFF79E0CD43AEB624DBDBA9F8AE29(response, vars, strSdindp_Dinardap_ID, strbtnDebugInfo, strProcessing);
        }

    } else if (vars.commandIn("BUTTONBTN_Gen_TXT75BDBA6366F349EB84D46C0443F8B398")) {
        vars.setSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strbtnGenTxt", vars.getStringParameter("inpbtnGenTxt"));
        vars.setSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button75BDBA6366F349EB84D46C0443F8B398.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "75BDBA6366F349EB84D46C0443F8B398", request.getServletPath());
      } else if (vars.commandIn("BUTTON75BDBA6366F349EB84D46C0443F8B398")) {
        String strSdindp_Dinardap_ID = vars.getGlobalVariable("inpsdindpDinardapId", windowId + "|Sdindp_Dinardap_ID", "");
        String strbtnGenTxt = vars.getSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strbtnGenTxt");
        String strProcessing = vars.getSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strProcessing");
        String strOrg = vars.getSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strOrg");
        String strClient = vars.getSessionValue("button75BDBA6366F349EB84D46C0443F8B398.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Gen_TXT75BDBA6366F349EB84D46C0443F8B398(response, vars, strSdindp_Dinardap_ID, strbtnGenTxt, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONBTN_Load_Lines17A0268862214035AB232AFFD6FD050B")) {
        String strSdindp_Dinardap_ID = vars.getGlobalVariable("inpKey", windowId + "|Sdindp_Dinardap_ID", "");
        String strbtnLoadLines = vars.getStringParameter("inpbtnLoadLines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "17A0268862214035AB232AFFD6FD050B", (("Sdindp_Dinardap_ID".equalsIgnoreCase("AD_Language"))?"0":strSdindp_Dinardap_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_Debug_Info7DEEFF79E0CD43AEB624DBDBA9F8AE29")) {
        String strSdindp_Dinardap_ID = vars.getGlobalVariable("inpKey", windowId + "|Sdindp_Dinardap_ID", "");
        String strbtnDebugInfo = vars.getStringParameter("inpbtnDebugInfo");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "7DEEFF79E0CD43AEB624DBDBA9F8AE29", (("Sdindp_Dinardap_ID".equalsIgnoreCase("AD_Language"))?"0":strSdindp_Dinardap_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONBTN_Gen_TXT75BDBA6366F349EB84D46C0443F8B398")) {
        String strSdindp_Dinardap_ID = vars.getGlobalVariable("inpKey", windowId + "|Sdindp_Dinardap_ID", "");
        
        ProcessBundle pb = new ProcessBundle("75BDBA6366F349EB84D46C0443F8B398", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sdindp_Dinardap_ID", strSdindp_Dinardap_ID);
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

    private void printPageButtonBTN_Load_Lines17A0268862214035AB232AFFD6FD050B(HttpServletResponse response, VariablesSecureApp vars, String strSdindp_Dinardap_ID, String strbtnLoadLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 17A0268862214035AB232AFFD6FD050B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Load_Lines17A0268862214035AB232AFFD6FD050B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSdindp_Dinardap_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderD1EABD732DF04BA5A592F4F31D965095_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "17A0268862214035AB232AFFD6FD050B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("17A0268862214035AB232AFFD6FD050B");
        vars.removeMessage("17A0268862214035AB232AFFD6FD050B");
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
    private void printPageButtonBTN_Debug_Info7DEEFF79E0CD43AEB624DBDBA9F8AE29(HttpServletResponse response, VariablesSecureApp vars, String strSdindp_Dinardap_ID, String strbtnDebugInfo, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7DEEFF79E0CD43AEB624DBDBA9F8AE29");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Debug_Info7DEEFF79E0CD43AEB624DBDBA9F8AE29", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSdindp_Dinardap_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderD1EABD732DF04BA5A592F4F31D965095_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7DEEFF79E0CD43AEB624DBDBA9F8AE29");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7DEEFF79E0CD43AEB624DBDBA9F8AE29");
        vars.removeMessage("7DEEFF79E0CD43AEB624DBDBA9F8AE29");
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


    void printPageButtonBTN_Gen_TXT75BDBA6366F349EB84D46C0443F8B398(HttpServletResponse response, VariablesSecureApp vars, String strSdindp_Dinardap_ID, String strbtnGenTxt, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 75BDBA6366F349EB84D46C0443F8B398");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Gen_TXT75BDBA6366F349EB84D46C0443F8B398", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSdindp_Dinardap_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderD1EABD732DF04BA5A592F4F31D965095_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "75BDBA6366F349EB84D46C0443F8B398");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("75BDBA6366F349EB84D46C0443F8B398");
        vars.removeMessage("75BDBA6366F349EB84D46C0443F8B398");
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
