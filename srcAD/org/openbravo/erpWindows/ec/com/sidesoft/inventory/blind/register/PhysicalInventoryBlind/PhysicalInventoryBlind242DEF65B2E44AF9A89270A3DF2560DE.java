
package org.openbravo.erpWindows.ec.com.sidesoft.inventory.blind.register.PhysicalInventoryBlind;


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
public class PhysicalInventoryBlind242DEF65B2E44AF9A89270A3DF2560DE extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "2671D49BE8404D209A20D595BDC69679";
  private static final String tabId = "242DEF65B2E44AF9A89270A3DF2560DE";
  private static final int accesslevel = 3;
  private static final String moduleId = "AD7822F8C3124DF49150BFF1904CE131";
  
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
     
      if (command.contains("6BCC36C351F24D5F8ED72999F1C28220")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("6BCC36C351F24D5F8ED72999F1C28220");
        SessionInfo.setModuleId("AD7822F8C3124DF49150BFF1904CE131");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     
      if (command.contains("D3F703D445C04ED79A9B16B0ED6B9B9E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D3F703D445C04ED79A9B16B0ED6B9B9E");
        SessionInfo.setModuleId("AD7822F8C3124DF49150BFF1904CE131");
        if (securedProcess || explicitAccess.contains("D3F703D445C04ED79A9B16B0ED6B9B9E")) {
          classInfo.type = "P";
          classInfo.id = "D3F703D445C04ED79A9B16B0ED6B9B9E";
        }
      }
     

     
      if (explicitAccess.contains("6BCC36C351F24D5F8ED72999F1C28220") || (securedProcess && command.contains("6BCC36C351F24D5F8ED72999F1C28220"))) {
        classInfo.type = "P";
        classInfo.id = "6BCC36C351F24D5F8ED72999F1C28220";
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

     } else if (vars.commandIn("BUTTONActioncreatelinesD3F703D445C04ED79A9B16B0ED6B9B9E")) {
        vars.setSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.stractioncreatelines", vars.getStringParameter("inpactioncreatelines"));
        vars.setSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D3F703D445C04ED79A9B16B0ED6B9B9E", request.getServletPath());    
     } else if (vars.commandIn("BUTTOND3F703D445C04ED79A9B16B0ED6B9B9E")) {
        String strSiblr_Physical_Inventory_ID = vars.getGlobalVariable("inpsiblrPhysicalInventoryId", windowId + "|Siblr_Physical_Inventory_ID", "");
        String stractioncreatelines = vars.getSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.stractioncreatelines");
        String strProcessing = vars.getSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.strProcessing");
        String strOrg = vars.getSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.strOrg");
        String strClient = vars.getSessionValue("buttonD3F703D445C04ED79A9B16B0ED6B9B9E.strClient");
        
        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonActioncreatelinesD3F703D445C04ED79A9B16B0ED6B9B9E(response, vars, strSiblr_Physical_Inventory_ID, stractioncreatelines, strProcessing);
        }

    } else if (vars.commandIn("BUTTONNEW_Docaction6BCC36C351F24D5F8ED72999F1C28220")) {
        vars.setSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strnewDocaction", vars.getStringParameter("inpnewDocaction"));
        vars.setSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button6BCC36C351F24D5F8ED72999F1C28220.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "6BCC36C351F24D5F8ED72999F1C28220", request.getServletPath());
      } else if (vars.commandIn("BUTTON6BCC36C351F24D5F8ED72999F1C28220")) {
        String strSiblr_Physical_Inventory_ID = vars.getGlobalVariable("inpsiblrPhysicalInventoryId", windowId + "|Siblr_Physical_Inventory_ID", "");
        String strnewDocaction = vars.getSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strnewDocaction");
        String strProcessing = vars.getSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strProcessing");
        String strOrg = vars.getSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strOrg");
        String strClient = vars.getSessionValue("button6BCC36C351F24D5F8ED72999F1C28220.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonNEW_Docaction6BCC36C351F24D5F8ED72999F1C28220(response, vars, strSiblr_Physical_Inventory_ID, strnewDocaction, strProcessing);
        }

    } else if (vars.commandIn("SAVE_BUTTONActioncreatelinesD3F703D445C04ED79A9B16B0ED6B9B9E")) {
        String strSiblr_Physical_Inventory_ID = vars.getGlobalVariable("inpKey", windowId + "|Siblr_Physical_Inventory_ID", "");
        String stractioncreatelines = vars.getStringParameter("inpactioncreatelines");
        String strProcessing = vars.getStringParameter("inpprocessing");
        OBError myMessage = null;
        try {
          String pinstance = SequenceIdData.getUUID();
          PInstanceProcessData.insertPInstance(this, pinstance, "D3F703D445C04ED79A9B16B0ED6B9B9E", (("Siblr_Physical_Inventory_ID".equalsIgnoreCase("AD_Language"))?"0":strSiblr_Physical_Inventory_ID), strProcessing, vars.getUser(), vars.getClient(), vars.getOrg());
          
          
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

    } else if (vars.commandIn("SAVE_BUTTONNEW_Docaction6BCC36C351F24D5F8ED72999F1C28220")) {
        String strSiblr_Physical_Inventory_ID = vars.getGlobalVariable("inpKey", windowId + "|Siblr_Physical_Inventory_ID", "");
        
        ProcessBundle pb = new ProcessBundle("6BCC36C351F24D5F8ED72999F1C28220", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Siblr_Physical_Inventory_ID", strSiblr_Physical_Inventory_ID);
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

    private void printPageButtonActioncreatelinesD3F703D445C04ED79A9B16B0ED6B9B9E(HttpServletResponse response, VariablesSecureApp vars, String strSiblr_Physical_Inventory_ID, String stractioncreatelines, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D3F703D445C04ED79A9B16B0ED6B9B9E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/ActioncreatelinesD3F703D445C04ED79A9B16B0ED6B9B9E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSiblr_Physical_Inventory_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PhysicalInventoryBlind242DEF65B2E44AF9A89270A3DF2560DE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D3F703D445C04ED79A9B16B0ED6B9B9E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D3F703D445C04ED79A9B16B0ED6B9B9E");
        vars.removeMessage("D3F703D445C04ED79A9B16B0ED6B9B9E");
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


    void printPageButtonNEW_Docaction6BCC36C351F24D5F8ED72999F1C28220(HttpServletResponse response, VariablesSecureApp vars, String strSiblr_Physical_Inventory_ID, String strnewDocaction, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 6BCC36C351F24D5F8ED72999F1C28220");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/NEW_Docaction6BCC36C351F24D5F8ED72999F1C28220", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSiblr_Physical_Inventory_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PhysicalInventoryBlind242DEF65B2E44AF9A89270A3DF2560DE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "6BCC36C351F24D5F8ED72999F1C28220");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("6BCC36C351F24D5F8ED72999F1C28220");
        vars.removeMessage("6BCC36C351F24D5F8ED72999F1C28220");
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
