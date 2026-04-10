
package org.openbravo.erpWindows.ec.com.sidesoft.carnidem.production.QualityControlReport2;


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
public class DateandShift7E43E189AA504DAFA73E6061FAD3FA10 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "A62660F0C9D942F58E848A1712D78BA6";
  private static final String tabId = "7E43E189AA504DAFA73E6061FAD3FA10";
  private static final int accesslevel = 1;
  private static final String moduleId = "14F37E1BF8DF4FA38F64F2E7E86701B7";
  
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
     
      if (command.contains("9C4187630C0A44B3829B2A9120B3EBC8")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("9C4187630C0A44B3829B2A9120B3EBC8");
        SessionInfo.setModuleId("14F37E1BF8DF4FA38F64F2E7E86701B7");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("46F37B699C3A41559E774EF74706B4BF")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("46F37B699C3A41559E774EF74706B4BF");
        SessionInfo.setModuleId("F3161764DBAA4021AD37FC93F9E18A4E");
        if (securedProcess || explicitAccess.contains("46F37B699C3A41559E774EF74706B4BF")) {
          classInfo.type = "P";
          classInfo.id = "46F37B699C3A41559E774EF74706B4BF";
        }
      }
     
      if (command.contains("BF4BE774FC1A42408517BB2C189CD4D0")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("BF4BE774FC1A42408517BB2C189CD4D0");
        SessionInfo.setModuleId("164B9227F5CF407AB45F26C293E15595");
        if (securedProcess || explicitAccess.contains("BF4BE774FC1A42408517BB2C189CD4D0")) {
          classInfo.type = "P";
          classInfo.id = "BF4BE774FC1A42408517BB2C189CD4D0";
        }
      }
     

     
      if (explicitAccess.contains("9C4187630C0A44B3829B2A9120B3EBC8") || (securedProcess && command.contains("9C4187630C0A44B3829B2A9120B3EBC8"))) {
        classInfo.type = "P";
        classInfo.id = "9C4187630C0A44B3829B2A9120B3EBC8";
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

     } else if (vars.commandIn("BUTTONProcessed46F37B699C3A41559E774EF74706B4BF")) {
        vars.setSessionValue("button46F37B699C3A41559E774EF74706B4BF.strprocessed", vars.getStringParameter("inpprocessed"));
        vars.setSessionValue("button46F37B699C3A41559E774EF74706B4BF.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button46F37B699C3A41559E774EF74706B4BF.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button46F37B699C3A41559E774EF74706B4BF.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button46F37B699C3A41559E774EF74706B4BF.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "46F37B699C3A41559E774EF74706B4BF", request.getServletPath());    
     } else if (vars.commandIn("BUTTON46F37B699C3A41559E774EF74706B4BF")) {
        String strMA_Measure_Shift_ID = vars.getGlobalVariable("inpmaMeasureShiftId", windowId + "|MA_Measure_Shift_ID", "");
        String strprocessed = vars.getSessionValue("button46F37B699C3A41559E774EF74706B4BF.strprocessed");
        String strProcessing = vars.getSessionValue("button46F37B699C3A41559E774EF74706B4BF.strProcessing");
        String strOrg = vars.getSessionValue("button46F37B699C3A41559E774EF74706B4BF.strOrg");
        String strClient = vars.getSessionValue("button46F37B699C3A41559E774EF74706B4BF.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcessed46F37B699C3A41559E774EF74706B4BF(response, vars, strMA_Measure_Shift_ID, strprocessed, strProcessing);
        }

     } else if (vars.commandIn("BUTTONEM_Ssfdc_CancelledBF4BE774FC1A42408517BB2C189CD4D0")) {
        vars.setSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.stremSsfdcCancelled", vars.getStringParameter("inpemSsfdcCancelled"));
        vars.setSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonBF4BE774FC1A42408517BB2C189CD4D0.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "BF4BE774FC1A42408517BB2C189CD4D0", request.getServletPath());    
     } else if (vars.commandIn("BUTTONBF4BE774FC1A42408517BB2C189CD4D0")) {
        String strMA_Measure_Shift_ID = vars.getGlobalVariable("inpmaMeasureShiftId", windowId + "|MA_Measure_Shift_ID", "");
        String stremSsfdcCancelled = vars.getSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.stremSsfdcCancelled");
        String strProcessing = vars.getSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.strProcessing");
        String strOrg = vars.getSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.strOrg");
        String strClient = vars.getSessionValue("buttonBF4BE774FC1A42408517BB2C189CD4D0.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Ssfdc_CancelledBF4BE774FC1A42408517BB2C189CD4D0(response, vars, strMA_Measure_Shift_ID, stremSsfdcCancelled, strProcessing);
        }

    } else if (vars.commandIn("BUTTONEM_Crprod_Completed9C4187630C0A44B3829B2A9120B3EBC8")) {
        vars.setSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.stremCrprodCompleted", vars.getStringParameter("inpemCrprodCompleted"));
        vars.setSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button9C4187630C0A44B3829B2A9120B3EBC8.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "9C4187630C0A44B3829B2A9120B3EBC8", request.getServletPath());
      } else if (vars.commandIn("BUTTON9C4187630C0A44B3829B2A9120B3EBC8")) {
        String strMA_Measure_Shift_ID = vars.getGlobalVariable("inpmaMeasureShiftId", windowId + "|MA_Measure_Shift_ID", "");
        String stremCrprodCompleted = vars.getSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.stremCrprodCompleted");
        String strProcessing = vars.getSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.strProcessing");
        String strOrg = vars.getSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.strOrg");
        String strClient = vars.getSessionValue("button9C4187630C0A44B3829B2A9120B3EBC8.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Crprod_Completed9C4187630C0A44B3829B2A9120B3EBC8(response, vars, strMA_Measure_Shift_ID, stremCrprodCompleted, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONProcessed46F37B699C3A41559E774EF74706B4BF")) {
        String strMA_Measure_Shift_ID = vars.getGlobalVariable("inpKey", windowId + "|MA_Measure_Shift_ID", "");
        String strprocessed = vars.getStringParameter("inpprocessed");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "46F37B699C3A41559E774EF74706B4BF", (("MA_Measure_Shift_ID".equalsIgnoreCase("AD_Language"))?"0":strMA_Measure_Shift_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONEM_Ssfdc_CancelledBF4BE774FC1A42408517BB2C189CD4D0")) {
        String strMA_Measure_Shift_ID = vars.getGlobalVariable("inpKey", windowId + "|MA_Measure_Shift_ID", "");
        String stremSsfdcCancelled = vars.getStringParameter("inpemSsfdcCancelled");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "BF4BE774FC1A42408517BB2C189CD4D0", (("MA_Measure_Shift_ID".equalsIgnoreCase("AD_Language"))?"0":strMA_Measure_Shift_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONEM_Crprod_Completed9C4187630C0A44B3829B2A9120B3EBC8")) {
        String strMA_Measure_Shift_ID = vars.getGlobalVariable("inpKey", windowId + "|MA_Measure_Shift_ID", "");
        
        ProcessBundle pb = new ProcessBundle("9C4187630C0A44B3829B2A9120B3EBC8", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("MA_Measure_Shift_ID", strMA_Measure_Shift_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String stremCrprodParamstatus = vars.getStringParameter("inpemCrprodParamstatus");
params.put("emCrprodParamstatus", stremCrprodParamstatus);
String stremCrprodMovemennoclose = vars.getStringParameter("inpemCrprodMovemennoclose", "N");
params.put("emCrprodMovemennoclose", stremCrprodMovemennoclose);
String stremCrprodMovemennogen = vars.getStringParameter("inpemCrprodMovemennogen", "N");
params.put("emCrprodMovemennogen", stremCrprodMovemennogen);

        
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

    private void printPageButtonProcessed46F37B699C3A41559E774EF74706B4BF(HttpServletResponse response, VariablesSecureApp vars, String strMA_Measure_Shift_ID, String strprocessed, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 46F37B699C3A41559E774EF74706B4BF");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Processed46F37B699C3A41559E774EF74706B4BF", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMA_Measure_Shift_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "DateandShift7E43E189AA504DAFA73E6061FAD3FA10_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "46F37B699C3A41559E774EF74706B4BF");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("46F37B699C3A41559E774EF74706B4BF");
        vars.removeMessage("46F37B699C3A41559E774EF74706B4BF");
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
    private void printPageButtonEM_Ssfdc_CancelledBF4BE774FC1A42408517BB2C189CD4D0(HttpServletResponse response, VariablesSecureApp vars, String strMA_Measure_Shift_ID, String stremSsfdcCancelled, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BF4BE774FC1A42408517BB2C189CD4D0");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Ssfdc_CancelledBF4BE774FC1A42408517BB2C189CD4D0", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMA_Measure_Shift_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "DateandShift7E43E189AA504DAFA73E6061FAD3FA10_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "BF4BE774FC1A42408517BB2C189CD4D0");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("BF4BE774FC1A42408517BB2C189CD4D0");
        vars.removeMessage("BF4BE774FC1A42408517BB2C189CD4D0");
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


    void printPageButtonEM_Crprod_Completed9C4187630C0A44B3829B2A9120B3EBC8(HttpServletResponse response, VariablesSecureApp vars, String strMA_Measure_Shift_ID, String stremCrprodCompleted, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 9C4187630C0A44B3829B2A9120B3EBC8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Crprod_Completed9C4187630C0A44B3829B2A9120B3EBC8", discard).createXmlDocument();
      xmlDocument.setParameter("key", strMA_Measure_Shift_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "DateandShift7E43E189AA504DAFA73E6061FAD3FA10_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "9C4187630C0A44B3829B2A9120B3EBC8");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("9C4187630C0A44B3829B2A9120B3EBC8");
        vars.removeMessage("9C4187630C0A44B3829B2A9120B3EBC8");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("em_crprod_paramStatus", "");
    xmlDocument.setParameter("em_crprod_MovemenNoClose", "");
    xmlDocument.setParameter("em_crprod_MovemenNoGen", "N");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
