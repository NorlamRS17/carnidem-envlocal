
package org.openbravo.erpWindows.ec.com.sidesoft.imports.pricelist.Importmultiplepricelistbyproduct;




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
public class Head98EF722B1AD54C79894820F95F1D68CE extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "E10BCF6E6F064DA6BAC15F8991085A62";
  private static final String tabId = "98EF722B1AD54C79894820F95F1D68CE";
  private static final int accesslevel = 7;
  private static final String moduleId = "EDC67FCFF1394BFA91FE9337081602ED";
  
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
     
      if (command.contains("864EAE677EE747ABB219FC888F16B44E")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("864EAE677EE747ABB219FC888F16B44E");
        SessionInfo.setModuleId("EDC67FCFF1394BFA91FE9337081602ED");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("864EAE677EE747ABB219FC888F16B44E") || (securedProcess && command.contains("864EAE677EE747ABB219FC888F16B44E"))) {
        classInfo.type = "P";
        classInfo.id = "864EAE677EE747ABB219FC888F16B44E";
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

    } else if (vars.commandIn("BUTTONProcess864EAE677EE747ABB219FC888F16B44E")) {
        vars.setSessionValue("button864EAE677EE747ABB219FC888F16B44E.strprocess", vars.getStringParameter("inpprocess"));
        vars.setSessionValue("button864EAE677EE747ABB219FC888F16B44E.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("button864EAE677EE747ABB219FC888F16B44E.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("button864EAE677EE747ABB219FC888F16B44E.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("button864EAE677EE747ABB219FC888F16B44E.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "864EAE677EE747ABB219FC888F16B44E", request.getServletPath());
      } else if (vars.commandIn("BUTTON864EAE677EE747ABB219FC888F16B44E")) {
        String strSspimpl_Import_Product_Pl_ID = vars.getGlobalVariable("inpsspimplImportProductPlId", windowId + "|Sspimpl_Import_Product_Pl_ID", "");
        String strprocess = vars.getSessionValue("button864EAE677EE747ABB219FC888F16B44E.strprocess");
        String strProcessing = vars.getSessionValue("button864EAE677EE747ABB219FC888F16B44E.strProcessing");
        String strOrg = vars.getSessionValue("button864EAE677EE747ABB219FC888F16B44E.strOrg");
        String strClient = vars.getSessionValue("button864EAE677EE747ABB219FC888F16B44E.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonProcess864EAE677EE747ABB219FC888F16B44E(response, vars, strSspimpl_Import_Product_Pl_ID, strprocess, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONProcess864EAE677EE747ABB219FC888F16B44E")) {
        String strSspimpl_Import_Product_Pl_ID = vars.getGlobalVariable("inpKey", windowId + "|Sspimpl_Import_Product_Pl_ID", "");
        
        ProcessBundle pb = new ProcessBundle("864EAE677EE747ABB219FC888F16B44E", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Sspimpl_Import_Product_Pl_ID", strSspimpl_Import_Product_Pl_ID);
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



    void printPageButtonProcess864EAE677EE747ABB219FC888F16B44E(HttpServletResponse response, VariablesSecureApp vars, String strSspimpl_Import_Product_Pl_ID, String strprocess, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process 864EAE677EE747ABB219FC888F16B44E");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Process864EAE677EE747ABB219FC888F16B44E", discard).createXmlDocument();
      xmlDocument.setParameter("key", strSspimpl_Import_Product_Pl_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Head98EF722B1AD54C79894820F95F1D68CE_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "864EAE677EE747ABB219FC888F16B44E");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("864EAE677EE747ABB219FC888F16B44E");
        vars.removeMessage("864EAE677EE747ABB219FC888F16B44E");
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
