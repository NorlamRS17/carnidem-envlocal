
package org.openbravo.erpWindows.ec.com.sidesoft.projects.complement.ImportProductsTask;




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
public class SproctmImpProducts4F9ABD99F4CF4621887116B78370D579 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E8F75B13FAA047299555277BC62A8167";
  private static final String tabId = "4F9ABD99F4CF4621887116B78370D579";
  private static final int accesslevel = 7;
  private static final String moduleId = "45A649284EB240D7995BCEBC0010A4B1";
  
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
     
      if (command.contains("7901FF7DF9444013904A03D8F86E1B7E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("7901FF7DF9444013904A03D8F86E1B7E");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("7901FF7DF9444013904A03D8F86E1B7E") || (securedProcess && command.contains("7901FF7DF9444013904A03D8F86E1B7E"))) {
        classInfo.type = "P";
        classInfo.id = "7901FF7DF9444013904A03D8F86E1B7E";
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

    } else if (vars.commandIn("BUTTONProcess7901FF7DF9444013904A03D8F86E1B7E")) {
        vars.setSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button7901FF7DF9444013904A03D8F86E1B7E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "7901FF7DF9444013904A03D8F86E1B7E", request.getServletPath());
      } else if (vars.commandIn("BUTTON7901FF7DF9444013904A03D8F86E1B7E")) {
        String strSproctm_Imp_Products_ID = vars.getGlobalVariable("inpsproctmImpProductsId", windowId + "|Sproctm_Imp_Products_ID", "");
        String strprocess = vars.getSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strprocess");
        String strProcessing = vars.getSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strProcessing");
        String strOrg = vars.getSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strOrg");
        String strClient = vars.getSessionValue("button7901FF7DF9444013904A03D8F86E1B7E.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess7901FF7DF9444013904A03D8F86E1B7E(response, vars, strSproctm_Imp_Products_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess7901FF7DF9444013904A03D8F86E1B7E")) {
        String strSproctm_Imp_Products_ID = vars.getGlobalVariable("inpKey", windowId + "|Sproctm_Imp_Products_ID", "");
        
        ProcessBundle pb = new ProcessBundle("7901FF7DF9444013904A03D8F86E1B7E", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sproctm_Imp_Products_ID", strSproctm_Imp_Products_ID);
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



    void printPageButtonProcess7901FF7DF9444013904A03D8F86E1B7E(HttpServletResponse response, VariablesSecureApp vars, String strSproctm_Imp_Products_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 7901FF7DF9444013904A03D8F86E1B7E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process7901FF7DF9444013904A03D8F86E1B7E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSproctm_Imp_Products_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "SproctmImpProducts4F9ABD99F4CF4621887116B78370D579_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "7901FF7DF9444013904A03D8F86E1B7E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("7901FF7DF9444013904A03D8F86E1B7E");
        vars.removeMessage("7901FF7DF9444013904A03D8F86E1B7E");
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
