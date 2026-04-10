/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.0  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.creditcard.reconciliation.transaction.ad_actionbutton;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.base.weld.WeldUtils;
import org.openbravo.client.application.attachment.AttachImplementationManager;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.financialmgmt.payment.FIN_FinaccTransaction;
import org.openbravo.service.db.CallProcess;

import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadLine;
import ec.com.sidesoft.creditcard.reconciliation.transaction.SccrtCardLoadTransaction;

public class UploadFileProcess extends HttpSecureAppServlet {
  private static final Logger log = Logger.getLogger(UploadFileProcess.class);
  private static final long serialVersionUID = 1L;
  private String strSessionValue = "";
  private String strFilePath = "/uploads_reconciliation";
  private String strTabId = "4A64347952334735A8076E5C23E0A94E";

  public void init(ServletConfig config) {
    super.init(config);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    // Windows_id | Column PK
    strSessionValue = "3E3001887190467F99B0080CB5BF9521|Sccrt_Card_Load_Transaction_ID";
    String result = "";
    if (vars.commandIn("DEFAULT")) {
      String strDocumentId = vars.getSessionValue(strSessionValue);
      FileItem item = vars.getMultiFile("inpFile");
      boolean res = createFile(item);

      if (res) {
        // Import Data File
        try {
          ImportDataFile.loadFileLinesTmpxls(
              getAttachmentsDirectoryPath() + strFilePath + "/" + item.getName(), strDocumentId);
          saveAttachment(getAttachmentsDirectoryPath() + strFilePath + "/", item.getName(),
              strDocumentId);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          res = false;
          e.printStackTrace();
          log.error(item.getSize());
	} finally {
		// Save attachments
		result = matchLines(strDocumentId);
		if (!result.equals("OK")) {
			res = false;
		}
          
        }
      }

      //closePopUp(response.getWriter(), res, item.getName());
      closePopUp(response.getWriter(), res, result);
    } else {
      pageError(response);
    }
  }

  private boolean createFile(FileItem item) {
    try {
      String fileName = item.getName();
      File path = new File(getAttachmentsDirectoryPath() + strFilePath);
      if (!path.exists()) {
        path.mkdir();
      }
      File uploadedFile = new File(path + "/" + fileName);
      item.write(uploadedFile);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  private void closePopUp(Writer writer, boolean res, String filename) {
    try {
      String p = (res) ? "true" : "false";
      writer.write("<HTML><BODY><SCRIPT type=\"text/javascript\">");
      writer.write("top.OB.SCCRT.closePopUp(" + p + ",'" + filename + "');");
      writer.write("</SCRIPT></BODY></HTML>");
    } catch (IOException ioex) {
    }
  }

  private static String matchLines(String documentId) {

    // Ad_Process: sccrt_match_lines
    org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
        .get(org.openbravo.model.ad.ui.Process.class, "1D720732938543B7ADD91B688F5A2505");

    final ProcessInstance pInstance = CallProcess.getInstance().call(process, documentId, null);

    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
    String msg = oberror.getMessage();

    return StringUtils.isBlank(msg) ? "OK" : msg;
  }

  private String getAttachmentsDirectoryPath() {
    return OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
  }

  public void saveAttachment(String path, String fileName, String recordId) {

    AttachImplementationManager aim = WeldUtils
        .getInstanceFromStaticBeanManager(AttachImplementationManager.class);
    final File fileTmp = new File(path + fileName);
    Map<String, String> requestParams = new HashMap<String, String>();
    requestParams.put("E22E8E3B737D4A47A691A073951BBF16", fileName);
    aim.upload(requestParams, strTabId, recordId,
        OBContext.getOBContext().getCurrentOrganization().getId(), fileTmp);
  }

  public String getServletInfo() {
    return "Servlet that creates a file sent by the client in the server";
  }
}
