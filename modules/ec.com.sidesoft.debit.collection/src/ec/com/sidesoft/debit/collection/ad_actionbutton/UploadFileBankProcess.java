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
package ec.com.sidesoft.debit.collection.ad_actionbutton;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.openbravo.base.secureApp.HttpSecureAppServlet;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;

public class UploadFileBankProcess extends HttpSecureAppServlet {
  private static final Logger log = Logger.getLogger(UploadFileBankProcess.class);
  private static final long serialVersionUID = 1L;
  private String strSessionValue = "";

  public void init(ServletConfig config) {
    super.init(config);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    VariablesSecureApp vars = new VariablesSecureApp(request);
    strSessionValue = "448F744C9DC544B7ADEB3F70E78C458D|SDC_Debitcollect_ID";
    if (vars.commandIn("DEFAULT")) {
      String strDocumentId = vars.getSessionValue(strSessionValue);
      FileItem item = vars.getMultiFile("inpFile");
      boolean res = createFile(item);

      if (res) {
        try {
          ImportDataFile.loadFileLinesTmpxls(
              getAttachmentsDirectoryPath() + "/uploads/" + item.getName(), strDocumentId);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          res = false;
          e.printStackTrace();
          log.error(item.getSize());
        }
      }

      closePopUp(response.getWriter(), res, item.getName());
    } else {
      pageError(response);
    }
  }

  private boolean createFile(FileItem item) {
    try {
      String fileName = item.getName();
      File path = new File(getAttachmentsDirectoryPath() + "/uploads");
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
      writer.write("top.OB.SDC.closePopUp(" + p + ",'" + filename + "');");
      writer.write("</SCRIPT></BODY></HTML>");
    } catch (IOException ioex) {
    }
  }

  private String getAttachmentsDirectoryPath() {
    return OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
  }

  public String getServletInfo() {
    return "Servlet that creates a file sent by the client in the server";
  }
}
