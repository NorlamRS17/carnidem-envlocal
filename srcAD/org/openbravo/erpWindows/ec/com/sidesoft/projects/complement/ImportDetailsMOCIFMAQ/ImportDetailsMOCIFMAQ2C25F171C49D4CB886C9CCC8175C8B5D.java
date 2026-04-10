
package org.openbravo.erpWindows.ec.com.sidesoft.projects.complement.ImportDetailsMOCIFMAQ;




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
public class ImportDetailsMOCIFMAQ2C25F171C49D4CB886C9CCC8175C8B5D extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "D41306FE2E35441C86282D419BE9212A";
  private static final String tabId = "2C25F171C49D4CB886C9CCC8175C8B5D";
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
     
      if (command.contains("943C8F5BEAAE44298C2572C727CF5614")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("943C8F5BEAAE44298C2572C727CF5614");
        SessionInfo.setModuleId("45A649284EB240D7995BCEBC0010A4B1");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("943C8F5BEAAE44298C2572C727CF5614") || (securedProcess && command.contains("943C8F5BEAAE44298C2572C727CF5614"))) {
        classInfo.type = "P";
        classInfo.id = "943C8F5BEAAE44298C2572C727CF5614";
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

    } else if (vars.commandIn("BUTTONProcess943C8F5BEAAE44298C2572C727CF5614")) {
        vars.setSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button943C8F5BEAAE44298C2572C727CF5614.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "943C8F5BEAAE44298C2572C727CF5614", request.getServletPath());
      } else if (vars.commandIn("BUTTON943C8F5BEAAE44298C2572C727CF5614")) {
        String strSproctm_Imp_Details_ID = vars.getGlobalVariable("inpsproctmImpDetailsId", windowId + "|Sproctm_Imp_Details_ID", "");
        String strprocess = vars.getSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strprocess");
        String strProcessing = vars.getSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strProcessing");
        String strOrg = vars.getSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strOrg");
        String strClient = vars.getSessionValue("button943C8F5BEAAE44298C2572C727CF5614.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess943C8F5BEAAE44298C2572C727CF5614(response, vars, strSproctm_Imp_Details_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess943C8F5BEAAE44298C2572C727CF5614")) {
        String strSproctm_Imp_Details_ID = vars.getGlobalVariable("inpKey", windowId + "|Sproctm_Imp_Details_ID", "");
        
        ProcessBundle pb = new ProcessBundle("943C8F5BEAAE44298C2572C727CF5614", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sproctm_Imp_Details_ID", strSproctm_Imp_Details_ID);
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



    void printPageButtonProcess943C8F5BEAAE44298C2572C727CF5614(HttpServletResponse response, VariablesSecureApp vars, String strSproctm_Imp_Details_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 943C8F5BEAAE44298C2572C727CF5614");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process943C8F5BEAAE44298C2572C727CF5614", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSproctm_Imp_Details_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ImportDetailsMOCIFMAQ2C25F171C49D4CB886C9CCC8175C8B5D_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "943C8F5BEAAE44298C2572C727CF5614");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("943C8F5BEAAE44298C2572C727CF5614");
        vars.removeMessage("943C8F5BEAAE44298C2572C727CF5614");
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
