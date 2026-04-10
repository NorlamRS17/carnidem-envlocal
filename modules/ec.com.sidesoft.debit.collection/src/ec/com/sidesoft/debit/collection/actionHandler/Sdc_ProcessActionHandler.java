
package ec.com.sidesoft.debit.collection.actionHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.base.weld.WeldUtils;
import org.openbravo.client.application.attachment.AttachImplementationManager;
import org.openbravo.client.application.process.BaseProcessActionHandler;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.process.ProcessInstance;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.service.db.CallProcess;
import org.openbravo.service.db.DalConnectionProvider;

import ec.com.sidesoft.debit.collection.SdcDebitcollect;
import ec.com.sidesoft.debit.collection.utils.SDC_Helper;

public class Sdc_ProcessActionHandler extends BaseProcessActionHandler {
  private static final Logger log = Logger.getLogger(Sdc_ProcessActionHandler.class);
  private static final String file1 = "Recaudaciones.txt";
  private static final String file2 = "DebitosPH.txt";
  private static final String file3 = "Debitos.txt";
  private static final String tabId = "7A9791B46170413492C2333FA6BBB1D7";

  private static final String attachmentFolderPath = OBPropertiesProvider.getInstance()
      .getOpenbravoProperties().getProperty("attach.path");

  @Override
  public JSONObject doExecute(Map<String, Object> parameters, String content) {
    try {
      JSONObject result = new JSONObject();
      JSONObject request = new JSONObject(content);
      JSONObject params = request.getJSONObject("_params");
      // Execute process and prepare an array with actions to be executed after execution
      JSONArray actions = new JSONArray();

      String msgType, msgTitle = "";
      // Do validations on param values
      String condition = params.getString("condition");
      String finFinancialAccountId = params.getString("fin_financial_account_id");
      // Get Record object
      SdcDebitcollect head = OBDal.getInstance().get(SdcDebitcollect.class,
          request.getString("SDC_Debitcollect_ID"));
      FIN_FinancialAccount financialAccount = OBDal.getInstance().get(FIN_FinancialAccount.class,
          finFinancialAccountId);
      try {
        OBContext.setAdminMode();
        head.setCondition(condition);
        OBDal.getInstance().save(head);
        OBDal.getInstance().flush();
      } finally {
        OBContext.restorePreviousMode();
      }
      // Load Lines to generate files
      String resultPr = loadLines(head.getTypeload(), request.getString("SDC_Debitcollect_ID"),
          head.getAcreditDateFrom(), head.getAcreditDate());
      String msg = OBMessageUtils.messageBD(resultPr);

      if (resultPr.equals("OK")) {
        log.info("Lines generated");
        msgType = "success";
        msgTitle = "Success";
      } else {
        msgType = "info";
        msgTitle = "Info";
      }

      // Generate file type load
      if (head.getTypeload().equals("RPH")) {
        generateFileCollections(head.getId(), head.getOrganization().getId(), finFinancialAccountId,
            condition);
      } else if (head.getTypeload().equals("DOPH")) {
        generateFileOtherDebits(head.getId(), head.getOrganization().getId(),
            financialAccount.getGenericAccountNo(), condition);
      } else if (head.getTypeload().equals("DPH")) {
        generateFileDebits(head.getId(), head.getOrganization().getId(),
            financialAccount.getGenericAccountNo(), condition);
      }

      JSONObject msgVw = new JSONObject();
      msgVw.put("msgType", msgType);
      msgVw.put("msgTitle", OBMessageUtils.messageBD(msgTitle));
      msgVw.put("msgText", msg);

      JSONObject msgTotalAction = new JSONObject();
      msgTotalAction.put("showMsgInProcessView", msgVw);

      actions.put(msgTotalAction);

      result.put("responseActions", actions);
      log.info("Finish process");
      return result;
    } catch (JSONException e) {
      log.error("Error in process", e);
      return new JSONObject();
    } catch (Exception e) {
      log.error("Error in process", e);
      return new JSONObject();
    }
  }

  public static String loadLines(String type, String documentId, Date date_from, Date date_to)
      throws JSONException {

    // Ad_Process: Sdc_load_lines
    org.openbravo.model.ad.ui.Process process = OBDal.getInstance()
        .get(org.openbravo.model.ad.ui.Process.class, "95A03FFAC99144738D3FAC63A4C84750");

    final ProcessInstance pInstance = CallProcess.getInstance().call(process, documentId, null);

    OBError oberror = OBMessageUtils.getProcessInstanceMessage(pInstance);
    String msg = oberror.getMessage();

    return StringUtils.isBlank(msg) ? "OK" : msg;

  }

  public void generateFileCollections(String recordID, String orgID, String financialAccountId,
      String typedata) throws Exception {
    String filename = attachmentFolderPath + "/" + SDC_Helper.getDateString(new Date()) + "_"
        + file1;

    try {
      File newTxt = new File(filename);
      FileWriter fileWriter = new FileWriter(newTxt);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      ConnectionProvider conn = new DalConnectionProvider(false);
      SdcBankTXTData data[] = null;
      if (typedata.equals("ALL") || typedata.equals("MO")) {
        data = SdcBankTXTData.selectdetaill(conn, recordID);
      } else if (typedata.equals("AC")) {
        data = SdcBankTXTData.selectsummary(conn, recordID);
      }
      log.info("File generate with " + data.length + " lines");
      StringBuilder sb = new StringBuilder();
      for (SdcBankTXTData sdcBankTXTData : data) {
        // Nota: sdcBankTXTData.c.. son columnas tipo constantes
        sb.setLength(0);
        // Identificador
        sb.append(sdcBankTXTData.c1).append("\t");
        // Cedula
        sb.append(sdcBankTXTData.taxid).append("\t");
        // Tipo de moneda
        sb.append(sdcBankTXTData.c3).append("\t");
        // Monto
        sb.append(StringUtils.replace(sdcBankTXTData.amount, ".", "")).append("\t");
        // Tipo trx
        sb.append(sdcBankTXTData.c5).append("\t").append("\t").append("\t");
        // Nombre base
        sb.append(sdcBankTXTData.c6).append("\t");
        // Tipo de identificacion
        sb.append(sdcBankTXTData.c7).append("\t");
        // cedula Cliente
        sb.append(sdcBankTXTData.taxidbank).append("\t");
        // Nombre cliente
        sb.append(sdcBankTXTData.partnername);
        bufferedWriter.write(sb.toString());
        bufferedWriter.newLine();
      }
      log.info("Finish File generate");
      bufferedWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    uploadFile(filename, recordID, orgID, file1 + " PH");
  }

  public void generateFileDebits(String recordID, String orgID, String bankCode, String typedata)
      throws Exception {
    String filename = attachmentFolderPath + "/" + SDC_Helper.getDateString(new Date()) + "_"
        + file2;
    try {
      File newTxt = new File(filename);
      FileWriterWithEncoding fileWriter = new FileWriterWithEncoding(newTxt,
          Charset.forName("UTF8"));
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      ConnectionProvider conn = new DalConnectionProvider(false);
      SdcBankTXTDPHData data[] = null;
      if (typedata.equals("ALL") || typedata.equals("MO")) {
        data = SdcBankTXTDPHData.selectdetaill(conn, recordID);
      } else if (typedata.equals("AC")) {
        data = SdcBankTXTDPHData.selectsummary(conn, recordID);
      }
      Integer numLine = 1;
      log.info("File generate with " + data.length + " lines");
      StringBuilder sb = new StringBuilder();

      // Write lines to txt file
      for (SdcBankTXTDPHData sdcBankTXTData : data) {
        // Nota: SdcBankTXTDPHData.c.. son columnas tipo constantes
        sb.setLength(0);
        // Identificador
        sb.append(sdcBankTXTData.c1).append("\t");
        // Cuenta Banco
        sb.append(bankCode).append("\t");
        // No. Linea
        sb.append(numLine.toString()).append("\t");
        // Numero de factura
        sb.append(sdcBankTXTData.documentno).append("\t");
        // Cedula
        sb.append(sdcBankTXTData.taxid).append("\t");
        // Moneda
        sb.append(sdcBankTXTData.c6).append("\t");
        // Monto
        sb.append(StringUtils.replace(sdcBankTXTData.amount, ".", "")).append("\t");
        // Tipo de transaccion
        sb.append(sdcBankTXTData.c8).append("\t");
        // Tipo de cuenta
        sb.append(sdcBankTXTData.codebank).append("\t");
        // Tipo de cuenta
        sb.append(sdcBankTXTData.tipocuenta).append("\t");
        // No.cuenta
        sb.append(sdcBankTXTData.accountno).append("\t");
        // Tipo identificacion
        sb.append(sdcBankTXTData.c12).append("\t");
        // Cedula
        sb.append(sdcBankTXTData.taxidbank).append("\t");
        // Nombre cliente
        sb.append(sdcBankTXTData.partnername).append("\t");
        // Direccion
        sb.append(sdcBankTXTData.address).append("\t");
        // Ciudad
        sb.append(sdcBankTXTData.ciudad).append("\t");
        // Telefono
        sb.append(sdcBankTXTData.phone).append("\t");
        // Localididad Cobro
        sb.append(sdcBankTXTData.c18).append("\t");
        // Referencia
        sb.append(sdcBankTXTData.c19).append("\t");
        // Fecha generacion reporte
        sb.append(sdcBankTXTData.fecha).append("\t");
        // Factura No.
        sb.append(sdcBankTXTData.factura);

        int numberOfTrees = 11;

        while (numberOfTrees >= 0) {
          numberOfTrees -= 1;
          sb.append("0");
          sb.append("\t");
        }

        sb.append("8");
        bufferedWriter.write(sb.toString());
        bufferedWriter.newLine();
        numLine++;
      }
      log.info("Finish File generate");
      bufferedWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    uploadFile(filename, recordID, orgID, file2 + " PH");
  }

  public void generateFileOtherDebits(String recordID, String orgID, String bankCode,
      String typedata) throws Exception {
    String filename = attachmentFolderPath + "/" + SDC_Helper.getDateString(new Date()) + "_"
        + file3;
    try {
      File newTxt = new File(filename);
      FileWriterWithEncoding fileWriter = new FileWriterWithEncoding(newTxt,
          Charset.forName("UTF8"));
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      ConnectionProvider conn = new DalConnectionProvider(false);
      SdcBankTXTODPHData data[] = null;
      if (typedata.equals("ALL") || typedata.equals("MO")) {
        data = SdcBankTXTODPHData.selectdetaill(conn, recordID);
      } else if (typedata.equals("AC")) {
        data = SdcBankTXTODPHData.selectsummary(conn, recordID);
      }
      Integer numLine = 1;
      log.info("File generate with " + data.length + " lines");
      StringBuilder sb = new StringBuilder();

      // Write lines to txt file
      for (SdcBankTXTODPHData sdcBankTXTData : data) {
        // Nota: SdcBankTXTDPHData.c.. son columnas tipo constantes
        sb.setLength(0);
        // Identificador
        sb.append(sdcBankTXTData.c1).append("\t");
        // Cuenta Banco
        sb.append(bankCode).append("\t");
        // No. Linea
        sb.append(numLine.toString()).append("\t");
        // Numero de factura
        sb.append(sdcBankTXTData.documentno).append("\t");
        // Cedula
        sb.append(sdcBankTXTData.taxid).append("\t");
        // Moneda
        sb.append(sdcBankTXTData.c6).append("\t");
        // Monto
        sb.append(StringUtils.replace(sdcBankTXTData.amount, ".", "")).append("\t");
        // Tipo de transaccion
        sb.append(sdcBankTXTData.c8).append("\t");
        // Tipo de cuenta
        sb.append(sdcBankTXTData.codebank).append("\t");
        // Tipo de cuenta
        sb.append(sdcBankTXTData.tipocuenta).append("\t");
        // No.cuenta
        sb.append(sdcBankTXTData.accountno).append("\t");
        // Tipo identificacion
        sb.append(sdcBankTXTData.c12).append("\t");
        // Cedula
        sb.append(sdcBankTXTData.taxidbank).append("\t");
        // Nombre cliente
        sb.append(sdcBankTXTData.partnername).append("\t");
        // Direccion
        sb.append(sdcBankTXTData.address).append("\t");
        // Ciudad
        sb.append(sdcBankTXTData.ciudad).append("\t");
        // Telefono
        sb.append(sdcBankTXTData.phone).append("\t");
        // Localididad Cobro
        sb.append(sdcBankTXTData.c18).append("\t");
        // Referencia
        sb.append(sdcBankTXTData.c19).append("\t");
        // Fecha generacion reporte
        sb.append(sdcBankTXTData.fecha).append("\t");
        // Factura No.
        sb.append(sdcBankTXTData.factura).append("\t");
        // Valor Base Retencion
        sb.append("0").append("\t");
        // Porcentaje Retencion Bien
        sb.append("0").append("\t");
        // Concepto Retencion
        sb.append("332").append("\t");
        // Base Imponible
        sb.append("0").append("\t");
        // Porcentaje Retencion Servicio
        sb.append("0").append("\t");
        // Concepto Retencion Servicio
        sb.append("0").append("\t");
        // Base Retencion IVA
        sb.append("0").append("\t");
        // Porcentaje Retencion IVA Bien
        sb.append("0").append("\t");
        // Concepto Retencion IVA Bien
        sb.append("7").append("\t");
        // Base Retencion IVA Servicio
        sb.append("0").append("\t");
        // Porcentaje Retencion IVA Servicio
        sb.append("0").append("\t");
        // Concepto Retencion IVA Servicio
        sb.append("0");
        // int numberOfTrees = 11;
        //
        // while (numberOfTrees >= 0) {
        // numberOfTrees -= 1;
        // sb.append("0");
        // sb.append("\t");
        // }
        //
        // sb.append("0");
        bufferedWriter.write(sb.toString());
        bufferedWriter.newLine();

        numLine++;
      }
      log.info("Finish File generate");
      bufferedWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    uploadFile(filename, recordID, orgID, file3 + " PH");
  }

  public void uploadFile(String fileName, String recordID, String orgID, String description)
      throws Exception {

    try {
      final File fileTmp = new File(fileName);
      AttachImplementationManager aim = WeldUtils
          .getInstanceFromStaticBeanManager(AttachImplementationManager.class);
      // Description to Attachment file record
      Map<String, String> requestParams = new HashMap<String, String>();
      requestParams.put("E22E8E3B737D4A47A691A073951BBF16", description.replaceAll(".txt", ""));
      aim.upload(requestParams, tabId, recordID, orgID, fileTmp);
    } catch (Exception e) {
      log.info(e);
      throw new OBException(e);
    }
  }

}
