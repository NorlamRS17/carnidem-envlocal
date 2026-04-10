
package org.openbravo.erpWindows.ec.com.sidesoft.production.WorkEffort;




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
public class ProductionRun4E55C1D60FA54F508AEE18CCDCD25885 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "0D49D788605449178F19CBB42B5335EA";
  private static final String tabId = "4E55C1D60FA54F508AEE18CCDCD25885";
  private static final int accesslevel = 1;
  private static final String moduleId = "5E14FED226704A078CA8F5B5A9F0B6CA";
  
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
     
      if (command.contains("CE81B27EADC74667A59506719E70349A")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("CE81B27EADC74667A59506719E70349A");
        SessionInfo.setModuleId("5E14FED226704A078CA8F5B5A9F0B6CA");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("CE81B27EADC74667A59506719E70349A") || (securedProcess && command.contains("CE81B27EADC74667A59506719E70349A"))) {
        classInfo.type = "P";
        classInfo.id = "CE81B27EADC74667A59506719E70349A";
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

    } else if (vars.commandIn("BUTTONUsedmaterialCE81B27EADC74667A59506719E70349A")) {
        vars.setSessionValue("buttonCE81B27EADC74667A59506719E70349A.strusedmaterial", vars.getStringParameter("inpusedmaterial"));
        vars.setSessionValue("buttonCE81B27EADC74667A59506719E70349A.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonCE81B27EADC74667A59506719E70349A.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonCE81B27EADC74667A59506719E70349A.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonCE81B27EADC74667A59506719E70349A.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "CE81B27EADC74667A59506719E70349A", request.getServletPath());
      } else if (vars.commandIn("BUTTONCE81B27EADC74667A59506719E70349A")) {
        String strM_ProductionPlan_ID = vars.getGlobalVariable("inpmProductionplanId", windowId + "|M_ProductionPlan_ID", "");
        String strusedmaterial = vars.getSessionValue("buttonCE81B27EADC74667A59506719E70349A.strusedmaterial");
        String strProcessing = vars.getSessionValue("buttonCE81B27EADC74667A59506719E70349A.strProcessing");
        String strOrg = vars.getSessionValue("buttonCE81B27EADC74667A59506719E70349A.strOrg");
        String strClient = vars.getSessionValue("buttonCE81B27EADC74667A59506719E70349A.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonUsedmaterialCE81B27EADC74667A59506719E70349A(response, vars, strM_ProductionPlan_ID, strusedmaterial, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONUsedmaterialCE81B27EADC74667A59506719E70349A")) {
        String strM_ProductionPlan_ID = vars.getGlobalVariable("inpKey", windowId + "|M_ProductionPlan_ID", "");
        
        ProcessBundle pb = new ProcessBundle("CE81B27EADC74667A59506719E70349A", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("M_ProductionPlan_ID", strM_ProductionPlan_ID);
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



    void printPageButtonUsedmaterialCE81B27EADC74667A59506719E70349A(HttpServletResponse response, VariablesSecureApp vars, String strM_ProductionPlan_ID, String strusedmaterial, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process CE81B27EADC74667A59506719E70349A");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/UsedmaterialCE81B27EADC74667A59506719E70349A", discard).createXmlDocument();
      xmlDocument.setParameter("key", strM_ProductionPlan_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "ProductionRun4E55C1D60FA54F508AEE18CCDCD25885_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "CE81B27EADC74667A59506719E70349A");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("CE81B27EADC74667A59506719E70349A");
        vars.removeMessage("CE81B27EADC74667A59506719E70349A");
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
