
package org.openbravo.erpWindows.ec.com.sidesoft.custom.closecash.CashClousureAdmin;


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
public class HeaderC894BC783AEF4272810459B4DA0B5D3D extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "F9352E711BD144A2BF4021CDCC28945C";
  private static final String tabId = "C894BC783AEF4272810459B4DA0B5D3D";
  private static final int accesslevel = 3;
  private static final String moduleId = "33CB6D19B98240F287A577849270CF71";
  
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
     
      if (command.contains("2F09CAACE6E14C8FA56CE0ED4C7582B4")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("2F09CAACE6E14C8FA56CE0ED4C7582B4");
        SessionInfo.setModuleId("33CB6D19B98240F287A577849270CF71");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("E0A5E2AF4A0143E1A282DDF8E6C20C0D")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E0A5E2AF4A0143E1A282DDF8E6C20C0D");
        SessionInfo.setModuleId("C2ED8668825D460B9B6F38BD42FA4806");
        if (securedProcess || explicitAccess.contains("E0A5E2AF4A0143E1A282DDF8E6C20C0D")) {
          classInfo.type = "P";
          classInfo.id = "E0A5E2AF4A0143E1A282DDF8E6C20C0D";
        }
      }
     

     
      if (explicitAccess.contains("2F09CAACE6E14C8FA56CE0ED4C7582B4") || (securedProcess && command.contains("2F09CAACE6E14C8FA56CE0ED4C7582B4"))) {
        classInfo.type = "P";
        classInfo.id = "2F09CAACE6E14C8FA56CE0ED4C7582B4";
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

     } else if (vars.commandIn("BUTTONProcessE0A5E2AF4A0143E1A282DDF8E6C20C0D")) {
        vars.setSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E0A5E2AF4A0143E1A282DDF8E6C20C0D", request.getServletPath());    
     } else if (vars.commandIn("BUTTONE0A5E2AF4A0143E1A282DDF8E6C20C0D")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpscccCashClousureId", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strprocess = vars.getSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strprocess");
        String strProcessing = vars.getSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strProcessing");
        String strOrg = vars.getSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strOrg");
        String strClient = vars.getSessionValue("buttonE0A5E2AF4A0143E1A282DDF8E6C20C0D.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessE0A5E2AF4A0143E1A282DDF8E6C20C0D(response, vars, strSccc_Cash_Clousure_ID, strprocess, strProcessing);
        }

    } else if (vars.commandIn("BUTTONUnprocess2F09CAACE6E14C8FA56CE0ED4C7582B4")) {
        vars.setSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strunprocess", vars.getStringParameter("inpunprocess"));
        vars.setSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button2F09CAACE6E14C8FA56CE0ED4C7582B4.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "2F09CAACE6E14C8FA56CE0ED4C7582B4", request.getServletPath());
      } else if (vars.commandIn("BUTTON2F09CAACE6E14C8FA56CE0ED4C7582B4")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpscccCashClousureId", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strunprocess = vars.getSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strunprocess");
        String strProcessing = vars.getSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strProcessing");
        String strOrg = vars.getSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strOrg");
        String strClient = vars.getSessionValue("button2F09CAACE6E14C8FA56CE0ED4C7582B4.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUnprocess2F09CAACE6E14C8FA56CE0ED4C7582B4(response, vars, strSccc_Cash_Clousure_ID, strunprocess, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONProcessE0A5E2AF4A0143E1A282DDF8E6C20C0D")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpKey", windowId + "|Sccc_Cash_Clousure_ID", "");
        String strprocess = vars.getStringParameter("inpprocess");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "E0A5E2AF4A0143E1A282DDF8E6C20C0D", (("Sccc_Cash_Clousure_ID".equalsIgnoreCase("AD_Language"))?"0":strSccc_Cash_Clousure_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONUnprocess2F09CAACE6E14C8FA56CE0ED4C7582B4")) {
        String strSccc_Cash_Clousure_ID = vars.getGlobalVariable("inpKey", windowId + "|Sccc_Cash_Clousure_ID", "");
        
        ProcessBundle pb = new ProcessBundle("2F09CAACE6E14C8FA56CE0ED4C7582B4", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sccc_Cash_Clousure_ID", strSccc_Cash_Clousure_ID);
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

    private void printPageButtonProcessE0A5E2AF4A0143E1A282DDF8E6C20C0D(HttpServletResponse response, VariablesSecureApp vars, String strSccc_Cash_Clousure_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E0A5E2AF4A0143E1A282DDF8E6C20C0D");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ProcessE0A5E2AF4A0143E1A282DDF8E6C20C0D", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSccc_Cash_Clousure_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderC894BC783AEF4272810459B4DA0B5D3D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E0A5E2AF4A0143E1A282DDF8E6C20C0D");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E0A5E2AF4A0143E1A282DDF8E6C20C0D");
        vars.removeMessage("E0A5E2AF4A0143E1A282DDF8E6C20C0D");
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


    void printPageButtonUnprocess2F09CAACE6E14C8FA56CE0ED4C7582B4(HttpServletResponse response, VariablesSecureApp vars, String strSccc_Cash_Clousure_ID, String strunprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 2F09CAACE6E14C8FA56CE0ED4C7582B4");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Unprocess2F09CAACE6E14C8FA56CE0ED4C7582B4", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSccc_Cash_Clousure_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderC894BC783AEF4272810459B4DA0B5D3D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "2F09CAACE6E14C8FA56CE0ED4C7582B4");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("2F09CAACE6E14C8FA56CE0ED4C7582B4");
        vars.removeMessage("2F09CAACE6E14C8FA56CE0ED4C7582B4");
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
