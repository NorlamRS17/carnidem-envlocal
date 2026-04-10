
package org.openbravo.erpWindows.com.sidesoft.hrm.payroll.OtherIncomeIncomeTax;


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
public class HeaderA038E9F044D9485BB711C6D8D6FA6AD2 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "291FF6CC2B994B60B41829F78F656E2B";
  private static final String tabId = "A038E9F044D9485BB711C6D8D6FA6AD2";
  private static final int accesslevel = 3;
  private static final String moduleId = "169A6DDBFEB948C98F0617CE3B4CABD5";
  
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
     
      if (command.contains("AF99C0A0D75D490D80FEA24430E819FB")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("AF99C0A0D75D490D80FEA24430E819FB");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("657152C3359B4F2A81D531491B01ECCC")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("657152C3359B4F2A81D531491B01ECCC");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("657152C3359B4F2A81D531491B01ECCC")) {
          classInfo.type = "P";
          classInfo.id = "657152C3359B4F2A81D531491B01ECCC";
        }
      }
     
      if (command.contains("86C4E087F95848C7ABD26B0EAFB6D485")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("86C4E087F95848C7ABD26B0EAFB6D485");
        SessionInfo.setModuleId("169A6DDBFEB948C98F0617CE3B4CABD5");
        if (securedProcess || explicitAccess.contains("86C4E087F95848C7ABD26B0EAFB6D485")) {
          classInfo.type = "P";
          classInfo.id = "86C4E087F95848C7ABD26B0EAFB6D485";
        }
      }
     

     
      if (explicitAccess.contains("AF99C0A0D75D490D80FEA24430E819FB") || (securedProcess && command.contains("AF99C0A0D75D490D80FEA24430E819FB"))) {
        classInfo.type = "P";
        classInfo.id = "AF99C0A0D75D490D80FEA24430E819FB";
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

     } else if (vars.commandIn("BUTTONProcess657152C3359B4F2A81D531491B01ECCC")) {
        vars.setSessionValue("button657152C3359B4F2A81D531491B01ECCC.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button657152C3359B4F2A81D531491B01ECCC.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button657152C3359B4F2A81D531491B01ECCC.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button657152C3359B4F2A81D531491B01ECCC.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button657152C3359B4F2A81D531491B01ECCC.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "657152C3359B4F2A81D531491B01ECCC", request.getServletPath());    
     } else if (vars.commandIn("BUTTON657152C3359B4F2A81D531491B01ECCC")) {
        String strSspr_Other_Tax_Income_ID = vars.getGlobalVariable("inpssprOtherTaxIncomeId", windowId + "|Sspr_Other_Tax_Income_ID", "");
        String strprocess = vars.getSessionValue("button657152C3359B4F2A81D531491B01ECCC.strprocess");
        String strProcessing = vars.getSessionValue("button657152C3359B4F2A81D531491B01ECCC.strProcessing");
        String strOrg = vars.getSessionValue("button657152C3359B4F2A81D531491B01ECCC.strOrg");
        String strClient = vars.getSessionValue("button657152C3359B4F2A81D531491B01ECCC.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess657152C3359B4F2A81D531491B01ECCC(response, vars, strSspr_Other_Tax_Income_ID, strprocess, strProcessing);
        }

     } else if (vars.commandIn("BUTTONReactivate86C4E087F95848C7ABD26B0EAFB6D485")) {
        vars.setSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strreactivate", vars.getStringParameter("inpreactivate"));
        vars.setSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button86C4E087F95848C7ABD26B0EAFB6D485.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "86C4E087F95848C7ABD26B0EAFB6D485", request.getServletPath());    
     } else if (vars.commandIn("BUTTON86C4E087F95848C7ABD26B0EAFB6D485")) {
        String strSspr_Other_Tax_Income_ID = vars.getGlobalVariable("inpssprOtherTaxIncomeId", windowId + "|Sspr_Other_Tax_Income_ID", "");
        String strreactivate = vars.getSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strreactivate");
        String strProcessing = vars.getSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strProcessing");
        String strOrg = vars.getSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strOrg");
        String strClient = vars.getSessionValue("button86C4E087F95848C7ABD26B0EAFB6D485.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonReactivate86C4E087F95848C7ABD26B0EAFB6D485(response, vars, strSspr_Other_Tax_Income_ID, strreactivate, strProcessing);
        }

    } else if (vars.commandIn("BUTTONLoad_LinesAF99C0A0D75D490D80FEA24430E819FB")) {
        vars.setSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strloadLines", vars.getStringParameter("inploadLines"));
        vars.setSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonAF99C0A0D75D490D80FEA24430E819FB.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "AF99C0A0D75D490D80FEA24430E819FB", request.getServletPath());
      } else if (vars.commandIn("BUTTONAF99C0A0D75D490D80FEA24430E819FB")) {
        String strSspr_Other_Tax_Income_ID = vars.getGlobalVariable("inpssprOtherTaxIncomeId", windowId + "|Sspr_Other_Tax_Income_ID", "");
        String strloadLines = vars.getSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strloadLines");
        String strProcessing = vars.getSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strProcessing");
        String strOrg = vars.getSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strOrg");
        String strClient = vars.getSessionValue("buttonAF99C0A0D75D490D80FEA24430E819FB.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonLoad_LinesAF99C0A0D75D490D80FEA24430E819FB(response, vars, strSspr_Other_Tax_Income_ID, strloadLines, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONProcess657152C3359B4F2A81D531491B01ECCC")) {
        String strSspr_Other_Tax_Income_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Other_Tax_Income_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "657152C3359B4F2A81D531491B01ECCC", (("Sspr_Other_Tax_Income_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Other_Tax_Income_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONReactivate86C4E087F95848C7ABD26B0EAFB6D485")) {
        String strSspr_Other_Tax_Income_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Other_Tax_Income_ID", "");
        String strreactivate = vars.getStringParameter("inpreactivate");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "86C4E087F95848C7ABD26B0EAFB6D485", (("Sspr_Other_Tax_Income_ID".equalsIgnoreCase("AD_Language"))?"0":strSspr_Other_Tax_Income_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONLoad_LinesAF99C0A0D75D490D80FEA24430E819FB")) {
        String strSspr_Other_Tax_Income_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspr_Other_Tax_Income_ID", "");
        
        ProcessBundle pb = new ProcessBundle("AF99C0A0D75D490D80FEA24430E819FB", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sspr_Other_Tax_Income_ID", strSspr_Other_Tax_Income_ID);
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

    private void printPageButtonProcess657152C3359B4F2A81D531491B01ECCC(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Other_Tax_Income_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 657152C3359B4F2A81D531491B01ECCC");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process657152C3359B4F2A81D531491B01ECCC", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Other_Tax_Income_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderA038E9F044D9485BB711C6D8D6FA6AD2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "657152C3359B4F2A81D531491B01ECCC");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("657152C3359B4F2A81D531491B01ECCC");
        vars.removeMessage("657152C3359B4F2A81D531491B01ECCC");
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
    private void printPageButtonReactivate86C4E087F95848C7ABD26B0EAFB6D485(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Other_Tax_Income_ID, String strreactivate, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 86C4E087F95848C7ABD26B0EAFB6D485");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Reactivate86C4E087F95848C7ABD26B0EAFB6D485", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Other_Tax_Income_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderA038E9F044D9485BB711C6D8D6FA6AD2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "86C4E087F95848C7ABD26B0EAFB6D485");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("86C4E087F95848C7ABD26B0EAFB6D485");
        vars.removeMessage("86C4E087F95848C7ABD26B0EAFB6D485");
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


    void printPageButtonLoad_LinesAF99C0A0D75D490D80FEA24430E819FB(HttpServletResponse response, VariablesSecureApp vars, String strSspr_Other_Tax_Income_ID, String strloadLines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process AF99C0A0D75D490D80FEA24430E819FB");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Load_LinesAF99C0A0D75D490D80FEA24430E819FB", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspr_Other_Tax_Income_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderA038E9F044D9485BB711C6D8D6FA6AD2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "AF99C0A0D75D490D80FEA24430E819FB");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("AF99C0A0D75D490D80FEA24430E819FB");
        vars.removeMessage("AF99C0A0D75D490D80FEA24430E819FB");
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
