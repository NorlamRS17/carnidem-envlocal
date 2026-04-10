
package org.openbravo.erpWindows.com.atrums.indumot.postventa.OrdendeServicio;




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
public class PedidodeRepuestosFDE24DD34BF64F02B4EF0570D16728EB extends HttpSecureAppServlet {
  private static final long serialVersionUID = 1L;
  
  private static final String windowId = "94CD1D04743C404CBA5AF1BCFF0BC353";
  private static final String tabId = "FDE24DD34BF64F02B4EF0570D16728EB";
  private static final int accesslevel = 3;
  private static final String moduleId = "AD576C2C137343C585BB0D9012B9329F";
  
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
     
      if (command.contains("D76FECE66C5748B1A30275734FFAFD5B")) {
        SessionInfo.setProcessType("P");
        SessionInfo.setProcessId("D76FECE66C5748B1A30275734FFAFD5B");
        SessionInfo.setModuleId("C1B65D57CF86408DA404728DD155E3BC");
      }
     
      try {
        securedProcess = "Y".equals(org.openbravo.erpCommon.businessUtility.Preferences
            .getPreferenceValue("SecuredProcess", true, vars.getClient(), vars.getOrg(), vars
                .getUser(), vars.getRole(), windowId));
      } catch (PropertyException e) {
      }
     

     
      if (explicitAccess.contains("D76FECE66C5748B1A30275734FFAFD5B") || (securedProcess && command.contains("D76FECE66C5748B1A30275734FFAFD5B"))) {
        classInfo.type = "P";
        classInfo.id = "D76FECE66C5748B1A30275734FFAFD5B";
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

    } else if (vars.commandIn("BUTTONEM_Sswos_TransferpartsreturnD76FECE66C5748B1A30275734FFAFD5B")) {
        vars.setSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.stremSswosTransferpartsreturn", vars.getStringParameter("inpemSswosTransferpartsreturn"));
        vars.setSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.strProcessing", vars.getStringParameter("inpprocessing", "Y"));
        vars.setSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.strOrg", vars.getStringParameter("inpadOrgId"));
        vars.setSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.strClient", vars.getStringParameter("inpadClientId"));
        
        
        HashMap<String, String> p = new HashMap<String, String>();
        
        
        //Save in session needed params for combos if needed
        vars.setSessionObject("buttonD76FECE66C5748B1A30275734FFAFD5B.originalParams", FieldProviderFactory.getFieldProvider(p));
        printPageButtonFS(response, vars, "D76FECE66C5748B1A30275734FFAFD5B", request.getServletPath());
      } else if (vars.commandIn("BUTTOND76FECE66C5748B1A30275734FFAFD5B")) {
        String strAtindpo_Postventalinea_ID = vars.getGlobalVariable("inpatindpoPostventalineaId", windowId + "|Atindpo_Postventalinea_ID", "");
        String stremSswosTransferpartsreturn = vars.getSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.stremSswosTransferpartsreturn");
        String strProcessing = vars.getSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.strProcessing");
        String strOrg = vars.getSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.strOrg");
        String strClient = vars.getSessionValue("buttonD76FECE66C5748B1A30275734FFAFD5B.strClient");

        
        if ((org.openbravo.erpCommon.utility.WindowAccessData.hasReadOnlyAccess(this, vars.getRole(), tabId)) || !(Utility.isElementInList(Utility.getContext(this, vars, "#User_Client", windowId, accesslevel),strClient)  && Utility.isElementInList(Utility.getContext(this, vars, "#User_Org", windowId, accesslevel),strOrg))){
          OBError myError = Utility.translateError(this, vars, vars.getLanguage(), Utility.messageBD(this, "NoWriteAccess", vars.getLanguage()));
          vars.setMessage(tabId, myError);
          printPageClosePopUp(response, vars);
        }else{       
          printPageButtonEM_Sswos_TransferpartsreturnD76FECE66C5748B1A30275734FFAFD5B(response, vars, strAtindpo_Postventalinea_ID, stremSswosTransferpartsreturn, strProcessing);
        }


    } else if (vars.commandIn("SAVE_BUTTONEM_Sswos_TransferpartsreturnD76FECE66C5748B1A30275734FFAFD5B")) {
        String strAtindpo_Postventalinea_ID = vars.getGlobalVariable("inpKey", windowId + "|Atindpo_Postventalinea_ID", "");
        
        ProcessBundle pb = new ProcessBundle("D76FECE66C5748B1A30275734FFAFD5B", vars).init(this);
        HashMap<String, Object> params= new HashMap<String, Object>();
       
        params.put("Atindpo_Postventalinea_ID", strAtindpo_Postventalinea_ID);
        params.put("adOrgId", vars.getStringParameter("inpadOrgId"));
        params.put("adClientId", vars.getStringParameter("inpadClientId"));
        params.put("tabId", tabId);
        
        String strquantity = vars.getNumericParameter("inpquantity");
params.put("quantity", strquantity);

        
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



    void printPageButtonEM_Sswos_TransferpartsreturnD76FECE66C5748B1A30275734FFAFD5B(HttpServletResponse response, VariablesSecureApp vars, String strAtindpo_Postventalinea_ID, String stremSswosTransferpartsreturn, String strProcessing)
    throws IOException, ServletException {
      log4j.debug("Output: Button process D76FECE66C5748B1A30275734FFAFD5B");
      String[] discard = {"newDiscard"};
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      XmlDocument xmlDocument = xmlEngine.readXmlTemplate("org/openbravo/erpCommon/ad_actionButton/EM_Sswos_TransferpartsreturnD76FECE66C5748B1A30275734FFAFD5B", discard).createXmlDocument();
      xmlDocument.setParameter("key", strAtindpo_Postventalinea_ID);
      xmlDocument.setParameter("processing", strProcessing);
      xmlDocument.setParameter("form", "PedidodeRepuestosFDE24DD34BF64F02B4EF0570D16728EB_Edition.html");
      xmlDocument.setParameter("window", windowId);
      xmlDocument.setParameter("css", vars.getTheme());
      xmlDocument.setParameter("language", "defaultLang=\"" + vars.getLanguage() + "\";");
      xmlDocument.setParameter("directory", "var baseDirectory = \"" + strReplaceWith + "/\";\n");
      xmlDocument.setParameter("processId", "D76FECE66C5748B1A30275734FFAFD5B");
      xmlDocument.setParameter("cancel", Utility.messageBD(this, "Cancel", vars.getLanguage()));
      xmlDocument.setParameter("ok", Utility.messageBD(this, "OK", vars.getLanguage()));
      
      {
        OBError myMessage = vars.getMessage("D76FECE66C5748B1A30275734FFAFD5B");
        vars.removeMessage("D76FECE66C5748B1A30275734FFAFD5B");
        if (myMessage!=null) {
          xmlDocument.setParameter("messageType", myMessage.getType());
          xmlDocument.setParameter("messageTitle", myMessage.getTitle());
          xmlDocument.setParameter("messageMessage", myMessage.getMessage());
        }
      }

          try {
    xmlDocument.setParameter("Quantity", "1");
    } catch (Exception ex) {
      throw new ServletException(ex);
    }

      
      out.println(xmlDocument.print());
      out.close();
    }

}
