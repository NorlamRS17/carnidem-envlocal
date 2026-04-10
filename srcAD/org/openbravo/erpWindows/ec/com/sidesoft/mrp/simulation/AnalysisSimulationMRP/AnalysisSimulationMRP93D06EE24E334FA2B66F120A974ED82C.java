
package org.openbravo.erpWindows.ec.com.sidesoft.mrp.simulation.AnalysisSimulationMRP;


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
public class AnalysisSimulationMRP93D06EE24E334FA2B66F120A974ED82C extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "4345864D57CE4B30A0BC0CD65C431306";
  private static final String tabId = "93D06EE24E334FA2B66F120A974ED82C";
  private static final int accesslevel = 3;
  private static final String moduleId = "D0FE9F24F4AF4DA9B8392C1E9101B24D";
  
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
     
      if (command.contains("B111AB2270AA4BFC92202AB7D3AD562E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("B111AB2270AA4BFC92202AB7D3AD562E");
        SessionInfo.setModuleId("D0FE9F24F4AF4DA9B8392C1E9101B24D");
        if (securedProcess || explicitAccess.contains("B111AB2270AA4BFC92202AB7D3AD562E")) {
          classInfo.type = "P";
          classInfo.id = "B111AB2270AA4BFC92202AB7D3AD562E";
        }
      }
     
      if (command.contains("8CC4617192D54C69A4AE57BE1C3DE85E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("8CC4617192D54C69A4AE57BE1C3DE85E");
        SessionInfo.setModuleId("D0FE9F24F4AF4DA9B8392C1E9101B24D");
        if (securedProcess || explicitAccess.contains("8CC4617192D54C69A4AE57BE1C3DE85E")) {
          classInfo.type = "P";
          classInfo.id = "8CC4617192D54C69A4AE57BE1C3DE85E";
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

     } else if (vars.commandIn("BUTTONGenerate_SimB111AB2270AA4BFC92202AB7D3AD562E")) {
        vars.setSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strgenerateSim", vars.getStringParameter("inpgenerateSim"));
        vars.setSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonB111AB2270AA4BFC92202AB7D3AD562E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "B111AB2270AA4BFC92202AB7D3AD562E", request.getServletPath());    
     } else if (vars.commandIn("BUTTONB111AB2270AA4BFC92202AB7D3AD562E")) {
        String strSsmrps_Asimulation_Prod_ID = vars.getGlobalVariable("inpssmrpsAsimulationProdId", windowId + "|Ssmrps_Asimulation_Prod_ID", "");
        String strgenerateSim = vars.getSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strgenerateSim");
        String strProcessing = vars.getSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strProcessing");
        String strOrg = vars.getSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strOrg");
        String strClient = vars.getSessionValue("buttonB111AB2270AA4BFC92202AB7D3AD562E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGenerate_SimB111AB2270AA4BFC92202AB7D3AD562E(response, vars, strSsmrps_Asimulation_Prod_ID, strgenerateSim, strProcessing);
        }

     } else if (vars.commandIn("BUTTONGenerate_Orders8CC4617192D54C69A4AE57BE1C3DE85E")) {
        vars.setSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strgenerateOrders", vars.getStringParameter("inpgenerateOrders"));
        vars.setSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button8CC4617192D54C69A4AE57BE1C3DE85E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "8CC4617192D54C69A4AE57BE1C3DE85E", request.getServletPath());    
     } else if (vars.commandIn("BUTTON8CC4617192D54C69A4AE57BE1C3DE85E")) {
        String strSsmrps_Asimulation_Prod_ID = vars.getGlobalVariable("inpssmrpsAsimulationProdId", windowId + "|Ssmrps_Asimulation_Prod_ID", "");
        String strgenerateOrders = vars.getSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strgenerateOrders");
        String strProcessing = vars.getSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strProcessing");
        String strOrg = vars.getSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strOrg");
        String strClient = vars.getSessionValue("button8CC4617192D54C69A4AE57BE1C3DE85E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonGenerate_Orders8CC4617192D54C69A4AE57BE1C3DE85E(response, vars, strSsmrps_Asimulation_Prod_ID, strgenerateOrders, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONGenerate_SimB111AB2270AA4BFC92202AB7D3AD562E")) {
        String strSsmrps_Asimulation_Prod_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssmrps_Asimulation_Prod_ID", "");
        String strgenerateSim = vars.getStringParameter("inpgenerateSim");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "B111AB2270AA4BFC92202AB7D3AD562E", (("Ssmrps_Asimulation_Prod_ID".equalsIgnoreCase("AD_Language"))?"0":strSsmrps_Asimulation_Prod_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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
    } else if (vars.commandIn("SAVE_BUTTONGenerate_Orders8CC4617192D54C69A4AE57BE1C3DE85E")) {
        String strSsmrps_Asimulation_Prod_ID = vars.getGlobalVariable("inpKey", windowId + "|Ssmrps_Asimulation_Prod_ID", "");
        String strgenerateOrders = vars.getStringParameter("inpgenerateOrders");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "8CC4617192D54C69A4AE57BE1C3DE85E", (("Ssmrps_Asimulation_Prod_ID".equalsIgnoreCase("AD_Language"))?"0":strSsmrps_Asimulation_Prod_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    private void printPageButtonGenerate_SimB111AB2270AA4BFC92202AB7D3AD562E(HttpServletResponse response, VariablesSecureApp vars, String strSsmrps_Asimulation_Prod_ID, String strgenerateSim, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process B111AB2270AA4BFC92202AB7D3AD562E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Generate_SimB111AB2270AA4BFC92202AB7D3AD562E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsmrps_Asimulation_Prod_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AnalysisSimulationMRP93D06EE24E334FA2B66F120A974ED82C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "B111AB2270AA4BFC92202AB7D3AD562E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("B111AB2270AA4BFC92202AB7D3AD562E");
        vars.removeMessage("B111AB2270AA4BFC92202AB7D3AD562E");
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
    private void printPageButtonGenerate_Orders8CC4617192D54C69A4AE57BE1C3DE85E(HttpServletResponse response, VariablesSecureApp vars, String strSsmrps_Asimulation_Prod_ID, String strgenerateOrders, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 8CC4617192D54C69A4AE57BE1C3DE85E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Generate_Orders8CC4617192D54C69A4AE57BE1C3DE85E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSsmrps_Asimulation_Prod_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "AnalysisSimulationMRP93D06EE24E334FA2B66F120A974ED82C_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "8CC4617192D54C69A4AE57BE1C3DE85E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("8CC4617192D54C69A4AE57BE1C3DE85E");
        vars.removeMessage("8CC4617192D54C69A4AE57BE1C3DE85E");
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
