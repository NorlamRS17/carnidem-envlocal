
package org.openbravo.erpWindows.ec.com.sidesoft.carnidem.breakdown.Breakdown;




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
public class Breakdown22474E6760B9421F86E14DD5391F4162 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "ED065E86DE074B63B7C85302AD4C0702";
  private static final String tabId = "22474E6760B9421F86E14DD5391F4162";
  private static final int accesslevel = 3;
  private static final String moduleId = "C4C14B99006C47D389A02F1E2D8603E9";
  
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
     
      if (command.contains("3D6ECD5657D645F4B82ABD5CC2A09BF3")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("3D6ECD5657D645F4B82ABD5CC2A09BF3");
        SessionInfo.setModuleId("C4C14B99006C47D389A02F1E2D8603E9");
      }
     
      if (command.contains("66C88DC622C14C8EA9272AFE367A01E6")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("66C88DC622C14C8EA9272AFE367A01E6");
        SessionInfo.setModuleId("C4C14B99006C47D389A02F1E2D8603E9");
      }
     
      if (command.contains("135AFAA691B4481D85C9D913E4331101")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("135AFAA691B4481D85C9D913E4331101");
        SessionInfo.setModuleId("C4C14B99006C47D389A02F1E2D8603E9");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("3D6ECD5657D645F4B82ABD5CC2A09BF3") || (securedProcess && command.contains("3D6ECD5657D645F4B82ABD5CC2A09BF3"))) {
        classInfo.type = "P";
        classInfo.id = "3D6ECD5657D645F4B82ABD5CC2A09BF3";
      }
     
      if (explicitAccess.contains("66C88DC622C14C8EA9272AFE367A01E6") || (securedProcess && command.contains("66C88DC622C14C8EA9272AFE367A01E6"))) {
        classInfo.type = "P";
        classInfo.id = "66C88DC622C14C8EA9272AFE367A01E6";
      }
     
      if (explicitAccess.contains("135AFAA691B4481D85C9D913E4331101") || (securedProcess && command.contains("135AFAA691B4481D85C9D913E4331101"))) {
        classInfo.type = "P";
        classInfo.id = "135AFAA691B4481D85C9D913E4331101";
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

    } else if (vars.commandIn("BUTTONBTN_Complete3D6ECD5657D645F4B82ABD5CC2A09BF3")) {
        vars.setSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strbtnComplete", vars.getStringParameter("inpbtnComplete"));
        vars.setSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button3D6ECD5657D645F4B82ABD5CC2A09BF3.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "3D6ECD5657D645F4B82ABD5CC2A09BF3", request.getServletPath());
      } else if (vars.commandIn("BUTTON3D6ECD5657D645F4B82ABD5CC2A09BF3")) {
        String strEcscb_Breakdown_ID = vars.getGlobalVariable("inpecscbBreakdownId", windowId + "|Ecscb_Breakdown_ID", "");
        String strbtnComplete = vars.getSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strbtnComplete");
        String strProcessing = vars.getSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strProcessing");
        String strOrg = vars.getSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strOrg");
        String strClient = vars.getSessionValue("button3D6ECD5657D645F4B82ABD5CC2A09BF3.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Complete3D6ECD5657D645F4B82ABD5CC2A09BF3(response, vars, strEcscb_Breakdown_ID, strbtnComplete, strProcessing);
        }
    } else if (vars.commandIn("BUTTONBTN_Type_Breakdown66C88DC622C14C8EA9272AFE367A01E6")) {
        vars.setSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strbtnTypeBreakdown", vars.getStringParameter("inpbtnTypeBreakdown"));
        vars.setSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button66C88DC622C14C8EA9272AFE367A01E6.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "66C88DC622C14C8EA9272AFE367A01E6", request.getServletPath());
      } else if (vars.commandIn("BUTTON66C88DC622C14C8EA9272AFE367A01E6")) {
        String strEcscb_Breakdown_ID = vars.getGlobalVariable("inpecscbBreakdownId", windowId + "|Ecscb_Breakdown_ID", "");
        String strbtnTypeBreakdown = vars.getSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strbtnTypeBreakdown");
        String strProcessing = vars.getSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strProcessing");
        String strOrg = vars.getSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strOrg");
        String strClient = vars.getSessionValue("button66C88DC622C14C8EA9272AFE367A01E6.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Type_Breakdown66C88DC622C14C8EA9272AFE367A01E6(response, vars, strEcscb_Breakdown_ID, strbtnTypeBreakdown, strProcessing);
        }
    } else if (vars.commandIn("BUTTONBTN_Create_Inventory135AFAA691B4481D85C9D913E4331101")) {
        vars.setSessionValue("button135AFAA691B4481D85C9D913E4331101.strbtnCreateInventory", vars.getStringParameter("inpbtnCreateInventory"));
        vars.setSessionValue("button135AFAA691B4481D85C9D913E4331101.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button135AFAA691B4481D85C9D913E4331101.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button135AFAA691B4481D85C9D913E4331101.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button135AFAA691B4481D85C9D913E4331101.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "135AFAA691B4481D85C9D913E4331101", request.getServletPath());
      } else if (vars.commandIn("BUTTON135AFAA691B4481D85C9D913E4331101")) {
        String strEcscb_Breakdown_ID = vars.getGlobalVariable("inpecscbBreakdownId", windowId + "|Ecscb_Breakdown_ID", "");
        String strbtnCreateInventory = vars.getSessionValue("button135AFAA691B4481D85C9D913E4331101.strbtnCreateInventory");
        String strProcessing = vars.getSessionValue("button135AFAA691B4481D85C9D913E4331101.strProcessing");
        String strOrg = vars.getSessionValue("button135AFAA691B4481D85C9D913E4331101.strOrg");
        String strClient = vars.getSessionValue("button135AFAA691B4481D85C9D913E4331101.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonBTN_Create_Inventory135AFAA691B4481D85C9D913E4331101(response, vars, strEcscb_Breakdown_ID, strbtnCreateInventory, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONBTN_Complete3D6ECD5657D645F4B82ABD5CC2A09BF3")) {
        String strEcscb_Breakdown_ID = vars.getGlobalVariable("inpKey", windowId + "|Ecscb_Breakdown_ID", "");
        
        ProcessBundle pb = new ProcessBundle("3D6ECD5657D645F4B82ABD5CC2A09BF3", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ecscb_Breakdown_ID", strEcscb_Breakdown_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_Type_Breakdown66C88DC622C14C8EA9272AFE367A01E6")) {
        String strEcscb_Breakdown_ID = vars.getGlobalVariable("inpKey", windowId + "|Ecscb_Breakdown_ID", "");
        
        ProcessBundle pb = new ProcessBundle("66C88DC622C14C8EA9272AFE367A01E6", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ecscb_Breakdown_ID", strEcscb_Breakdown_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strecscbTypeBreakdownId = vars.getStringParameter("inpecscbTypeBreakdownId");
params.put("ecscbTypeBreakdownId", strecscbTypeBreakdownId);

        
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
    } else if (vars.commandIn("SAVE_BUTTONBTN_Create_Inventory135AFAA691B4481D85C9D913E4331101")) {
        String strEcscb_Breakdown_ID = vars.getGlobalVariable("inpKey", windowId + "|Ecscb_Breakdown_ID", "");
        
        ProcessBundle pb = new ProcessBundle("135AFAA691B4481D85C9D913E4331101", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Ecscb_Breakdown_ID", strEcscb_Breakdown_ID);
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



    void printPageButtonBTN_Complete3D6ECD5657D645F4B82ABD5CC2A09BF3(HttpServletResponse response, VariablesSecureApp vars, String strEcscb_Breakdown_ID, String strbtnComplete, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 3D6ECD5657D645F4B82ABD5CC2A09BF3");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Complete3D6ECD5657D645F4B82ABD5CC2A09BF3", discard).createXmlDocument();
      xmlDocument.setParameter("key", strEcscb_Breakdown_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Breakdown22474E6760B9421F86E14DD5391F4162_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "3D6ECD5657D645F4B82ABD5CC2A09BF3");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("3D6ECD5657D645F4B82ABD5CC2A09BF3");
        vars.removeMessage("3D6ECD5657D645F4B82ABD5CC2A09BF3");
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
    void printPageButtonBTN_Type_Breakdown66C88DC622C14C8EA9272AFE367A01E6(HttpServletResponse response, VariablesSecureApp vars, String strEcscb_Breakdown_ID, String strbtnTypeBreakdown, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 66C88DC622C14C8EA9272AFE367A01E6");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Type_Breakdown66C88DC622C14C8EA9272AFE367A01E6", discard).createXmlDocument();
      xmlDocument.setParameter("key", strEcscb_Breakdown_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Breakdown22474E6760B9421F86E14DD5391F4162_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "66C88DC622C14C8EA9272AFE367A01E6");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("66C88DC622C14C8EA9272AFE367A01E6");
        vars.removeMessage("66C88DC622C14C8EA9272AFE367A01E6");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    ComboTableData comboTableData = null;
    xmlDocument.setParameter("ecscb_type_breakdown_id", "");
    comboTableData = new ComboTableData(vars, this, "18", "ecscb_type_breakdown_id", "A3F625F6F2674D0FB4C74B44B342D217", "", Utility.getContext(this, vars, "#AccessibleOrgTree", ""), Utility.getContext(this, vars, "#User_Client", ""), 0);
    Utility.fillSQLParameters(this, vars, (FieldProvider) vars.getSessionObject("button66C88DC622C14C8EA9272AFE367A01E6.originalParams"), comboTableData, windowId, "");
    xmlDocument.setData("reportecscb_type_breakdown_id", "liststructure", comboTableData.select(false));
comboTableData = null;
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }
    void printPageButtonBTN_Create_Inventory135AFAA691B4481D85C9D913E4331101(HttpServletResponse response, VariablesSecureApp vars, String strEcscb_Breakdown_ID, String strbtnCreateInventory, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 135AFAA691B4481D85C9D913E4331101");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/BTN_Create_Inventory135AFAA691B4481D85C9D913E4331101", discard).createXmlDocument();
      xmlDocument.setParameter("key", strEcscb_Breakdown_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Breakdown22474E6760B9421F86E14DD5391F4162_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "135AFAA691B4481D85C9D913E4331101");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("135AFAA691B4481D85C9D913E4331101");
        vars.removeMessage("135AFAA691B4481D85C9D913E4331101");
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
