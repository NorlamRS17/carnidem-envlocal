
package org.openbravo.erpWindows.ec.com.sidesoft.workorder.update.price.UpdatepricesinOServicefromCSVfile;




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
public class HeaderE4FBA885398B4165A86D8F8329049722 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E380F1A8A5174B06B614E68A343DF69F";
  private static final String tabId = "E4FBA885398B4165A86D8F8329049722";
  private static final int accesslevel = 7;
  private static final String moduleId = "F5F4EA7AAEEF45D9ADB5EBDDE4225B52";
  
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
     
      if (command.contains("5DBC17C8408D4F878C4BD37962A7F9F8")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("5DBC17C8408D4F878C4BD37962A7F9F8");
        SessionInfo.setModuleId("F5F4EA7AAEEF45D9ADB5EBDDE4225B52");
      }
     
      if (command.contains("87FCB47E59564ED8AB7B2F927205A912")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("87FCB47E59564ED8AB7B2F927205A912");
        SessionInfo.setModuleId("F5F4EA7AAEEF45D9ADB5EBDDE4225B52");
      }
     
      if (command.contains("E0B23E3E8CEB4CD19E5EBC059E59ECBA")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("E0B23E3E8CEB4CD19E5EBC059E59ECBA");
        SessionInfo.setModuleId("F5F4EA7AAEEF45D9ADB5EBDDE4225B52");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("5DBC17C8408D4F878C4BD37962A7F9F8") || (securedProcess && command.contains("5DBC17C8408D4F878C4BD37962A7F9F8"))) {
        classInfo.type = "P";
        classInfo.id = "5DBC17C8408D4F878C4BD37962A7F9F8";
      }
     
      if (explicitAccess.contains("87FCB47E59564ED8AB7B2F927205A912") || (securedProcess && command.contains("87FCB47E59564ED8AB7B2F927205A912"))) {
        classInfo.type = "P";
        classInfo.id = "87FCB47E59564ED8AB7B2F927205A912";
      }
     
      if (explicitAccess.contains("E0B23E3E8CEB4CD19E5EBC059E59ECBA") || (securedProcess && command.contains("E0B23E3E8CEB4CD19E5EBC059E59ECBA"))) {
        classInfo.type = "P";
        classInfo.id = "E0B23E3E8CEB4CD19E5EBC059E59ECBA";
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

    } else if (vars.commandIn("BUTTONUpload5DBC17C8408D4F878C4BD37962A7F9F8")) {
        vars.setSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strupload", vars.getStringParameter("inpupload"));
        vars.setSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button5DBC17C8408D4F878C4BD37962A7F9F8.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "5DBC17C8408D4F878C4BD37962A7F9F8", request.getServletPath());
      } else if (vars.commandIn("BUTTON5DBC17C8408D4F878C4BD37962A7F9F8")) {
        String strSswoup_Update_Price_Wo_ID = vars.getGlobalVariable("inpsswoupUpdatePriceWoId", windowId + "|Sswoup_Update_Price_Wo_ID", "");
        String strupload = vars.getSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strupload");
        String strProcessing = vars.getSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strProcessing");
        String strOrg = vars.getSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strOrg");
        String strClient = vars.getSessionValue("button5DBC17C8408D4F878C4BD37962A7F9F8.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUpload5DBC17C8408D4F878C4BD37962A7F9F8(response, vars, strSswoup_Update_Price_Wo_ID, strupload, strProcessing);
        }
    } else if (vars.commandIn("BUTTONProcess87FCB47E59564ED8AB7B2F927205A912")) {
        vars.setSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button87FCB47E59564ED8AB7B2F927205A912.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "87FCB47E59564ED8AB7B2F927205A912", request.getServletPath());
      } else if (vars.commandIn("BUTTON87FCB47E59564ED8AB7B2F927205A912")) {
        String strSswoup_Update_Price_Wo_ID = vars.getGlobalVariable("inpsswoupUpdatePriceWoId", windowId + "|Sswoup_Update_Price_Wo_ID", "");
        String strprocess = vars.getSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strprocess");
        String strProcessing = vars.getSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strProcessing");
        String strOrg = vars.getSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strOrg");
        String strClient = vars.getSessionValue("button87FCB47E59564ED8AB7B2F927205A912.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess87FCB47E59564ED8AB7B2F927205A912(response, vars, strSswoup_Update_Price_Wo_ID, strprocess, strProcessing);
        }
    } else if (vars.commandIn("BUTTONValidate_LineE0B23E3E8CEB4CD19E5EBC059E59ECBA")) {
        vars.setSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strvalidateLine", vars.getStringParameter("inpvalidateLine"));
        vars.setSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "E0B23E3E8CEB4CD19E5EBC059E59ECBA", request.getServletPath());
      } else if (vars.commandIn("BUTTONE0B23E3E8CEB4CD19E5EBC059E59ECBA")) {
        String strSswoup_Update_Price_Wo_ID = vars.getGlobalVariable("inpsswoupUpdatePriceWoId", windowId + "|Sswoup_Update_Price_Wo_ID", "");
        String strvalidateLine = vars.getSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strvalidateLine");
        String strProcessing = vars.getSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strProcessing");
        String strOrg = vars.getSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strOrg");
        String strClient = vars.getSessionValue("buttonE0B23E3E8CEB4CD19E5EBC059E59ECBA.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonValidate_LineE0B23E3E8CEB4CD19E5EBC059E59ECBA(response, vars, strSswoup_Update_Price_Wo_ID, strvalidateLine, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONUpload5DBC17C8408D4F878C4BD37962A7F9F8")) {
        String strSswoup_Update_Price_Wo_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswoup_Update_Price_Wo_ID", "");
        
        ProcessBundle pb = new ProcessBundle("5DBC17C8408D4F878C4BD37962A7F9F8", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sswoup_Update_Price_Wo_ID", strSswoup_Update_Price_Wo_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONProcess87FCB47E59564ED8AB7B2F927205A912")) {
        String strSswoup_Update_Price_Wo_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswoup_Update_Price_Wo_ID", "");
        
        ProcessBundle pb = new ProcessBundle("87FCB47E59564ED8AB7B2F927205A912", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sswoup_Update_Price_Wo_ID", strSswoup_Update_Price_Wo_ID);
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
    } else if (vars.commandIn("SAVE_BUTTONValidate_LineE0B23E3E8CEB4CD19E5EBC059E59ECBA")) {
        String strSswoup_Update_Price_Wo_ID = vars.getGlobalVariable("inpKey", windowId + "|Sswoup_Update_Price_Wo_ID", "");
        
        ProcessBundle pb = new ProcessBundle("E0B23E3E8CEB4CD19E5EBC059E59ECBA", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sswoup_Update_Price_Wo_ID", strSswoup_Update_Price_Wo_ID);
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



    void printPageButtonUpload5DBC17C8408D4F878C4BD37962A7F9F8(HttpServletResponse response, VariablesSecureApp vars, String strSswoup_Update_Price_Wo_ID, String strupload, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 5DBC17C8408D4F878C4BD37962A7F9F8");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Upload5DBC17C8408D4F878C4BD37962A7F9F8", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswoup_Update_Price_Wo_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderE4FBA885398B4165A86D8F8329049722_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "5DBC17C8408D4F878C4BD37962A7F9F8");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("5DBC17C8408D4F878C4BD37962A7F9F8");
        vars.removeMessage("5DBC17C8408D4F878C4BD37962A7F9F8");
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
    void printPageButtonProcess87FCB47E59564ED8AB7B2F927205A912(HttpServletResponse response, VariablesSecureApp vars, String strSswoup_Update_Price_Wo_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 87FCB47E59564ED8AB7B2F927205A912");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process87FCB47E59564ED8AB7B2F927205A912", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswoup_Update_Price_Wo_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderE4FBA885398B4165A86D8F8329049722_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "87FCB47E59564ED8AB7B2F927205A912");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("87FCB47E59564ED8AB7B2F927205A912");
        vars.removeMessage("87FCB47E59564ED8AB7B2F927205A912");
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
    void printPageButtonValidate_LineE0B23E3E8CEB4CD19E5EBC059E59ECBA(HttpServletResponse response, VariablesSecureApp vars, String strSswoup_Update_Price_Wo_ID, String strvalidateLine, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process E0B23E3E8CEB4CD19E5EBC059E59ECBA");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Validate_LineE0B23E3E8CEB4CD19E5EBC059E59ECBA", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSswoup_Update_Price_Wo_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "HeaderE4FBA885398B4165A86D8F8329049722_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "E0B23E3E8CEB4CD19E5EBC059E59ECBA");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("E0B23E3E8CEB4CD19E5EBC059E59ECBA");
        vars.removeMessage("E0B23E3E8CEB4CD19E5EBC059E59ECBA");
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
