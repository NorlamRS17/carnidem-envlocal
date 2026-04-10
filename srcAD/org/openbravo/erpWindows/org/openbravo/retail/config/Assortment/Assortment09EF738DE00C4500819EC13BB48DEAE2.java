
package org.openbravo.erpWindows.org.openbravo.retail.config.Assortment;




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
public class Assortment09EF738DE00C4500819EC13BB48DEAE2 extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "7D98C37437B44E76AF2501704915AF82";
  private static final String tabId = "09EF738DE00C4500819EC13BB48DEAE2";
  private static final int accesslevel = 3;
  private static final String moduleId = "50BF0CEB5D7E438CBBE80688EDB68039";
  
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
     
      if (command.contains("BBF5C85870774F0C89D1DCF8F7767F76")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("BBF5C85870774F0C89D1DCF8F7767F76");
        SessionInfo.setModuleId("50BF0CEB5D7E438CBBE80688EDB68039");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("BBF5C85870774F0C89D1DCF8F7767F76") || (securedProcess && command.contains("BBF5C85870774F0C89D1DCF8F7767F76"))) {
        classInfo.type = "P";
        classInfo.id = "BBF5C85870774F0C89D1DCF8F7767F76";
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

    } else if (vars.commandIn("BUTTONIncludeall_ProductBBF5C85870774F0C89D1DCF8F7767F76")) {
        vars.setSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strincludeallProduct", vars.getStringParameter("inpincludeallProduct"));
        vars.setSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonBBF5C85870774F0C89D1DCF8F7767F76.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "BBF5C85870774F0C89D1DCF8F7767F76", request.getServletPath());
      } else if (vars.commandIn("BUTTONBBF5C85870774F0C89D1DCF8F7767F76")) {
        String strObretco_Productlist_ID = vars.getGlobalVariable("inpobretcoProductlistId", windowId + "|Obretco_Productlist_ID", "");
        String strincludeallProduct = vars.getSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strincludeallProduct");
        String strProcessing = vars.getSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strProcessing");
        String strOrg = vars.getSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strOrg");
        String strClient = vars.getSessionValue("buttonBBF5C85870774F0C89D1DCF8F7767F76.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonIncludeall_ProductBBF5C85870774F0C89D1DCF8F7767F76(response, vars, strObretco_Productlist_ID, strincludeallProduct, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONIncludeall_ProductBBF5C85870774F0C89D1DCF8F7767F76")) {
        String strObretco_Productlist_ID = vars.getGlobalVariable("inpKey", windowId + "|Obretco_Productlist_ID", "");
        
        ProcessBundle pb = new ProcessBundle("BBF5C85870774F0C89D1DCF8F7767F76", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Obretco_Productlist_ID", strObretco_Productlist_ID);
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



    void printPageButtonIncludeall_ProductBBF5C85870774F0C89D1DCF8F7767F76(HttpServletResponse response, VariablesSecureApp vars, String strObretco_Productlist_ID, String strincludeallProduct, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process BBF5C85870774F0C89D1DCF8F7767F76");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/Includeall_ProductBBF5C85870774F0C89D1DCF8F7767F76", discard).createXmlDocument();
      xmlDocument.setParameter("key", strObretco_Productlist_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "Assortment09EF738DE00C4500819EC13BB48DEAE2_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "BBF5C85870774F0C89D1DCF8F7767F76");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("BBF5C85870774F0C89D1DCF8F7767F76");
        vars.removeMessage("BBF5C85870774F0C89D1DCF8F7767F76");
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
