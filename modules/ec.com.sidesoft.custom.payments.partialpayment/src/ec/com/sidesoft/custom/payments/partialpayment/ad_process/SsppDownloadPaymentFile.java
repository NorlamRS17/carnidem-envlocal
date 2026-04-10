package ec.com.sidesoft.custom.payments.partialpayment.ad_process;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.ConfigParameters;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.secureApp.ClassInfoData;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.client.kernel.KernelConstants;
import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.financialmgmt.payment.FIN_FinancialAccount;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.xmlEngine.XmlEngine;
import org.openbravo.xmlEngine.XmlDocument;

import au.com.bytecode.opencsv.CSVReader;
import ec.com.sidesoft.custom.payments.partialpayment.SSPPPAYMENTS;
import ec.com.sidesoft.localization.ecuador.financial.account.SfiacPaymentLotFile;

public class SsppDownloadPaymentFile extends DalBaseProcess {

  public XmlEngine xmlEngine = null;
  public static String strDireccion;
  protected Logger log4j = Logger.getLogger(this.getClass());
  protected ConfigParameters globalParameters;
  protected ClassInfoData classInfo;

  public String getLocationTemplate(FIN_FinancialAccount financialAccount) throws OBException {

    OBContext.setAdminMode(true);
    OBCriteria<SfiacPaymentLotFile> obc = OBDal.getInstance()
        .createCriteria(SfiacPaymentLotFile.class);
    obc.add(Restrictions.eq(SfiacPaymentLotFile.PROPERTY_FINANCIALACCOUNT, financialAccount));
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    OBContext.restorePreviousMode();
    SfiacPaymentLotFile configTempalteFinnnAccount = (SfiacPaymentLotFile) obc.uniqueResult();
    if (configTempalteFinnnAccount == null) {
      return null;
    }
    return configTempalteFinnnAccount.getTemplateLocation().toString()
        + configTempalteFinnnAccount.getTemplateFilename().toString();
  }

  public void doExecute(ProcessBundle bundle) throws Exception {
    final OBError message = new OBError();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    // ConnectionProvider conn = new DalConnectionProvider(false);

    ConnectionProvider conn = bundle.getConnection();

    // VariablesSecureApp varsAux = bundle.getContext().toVars();
    HttpServletResponse response = RequestContext.get().getResponse();
    HttpServletRequest request = RequestContext.get().getRequest();
    VariablesSecureApp vars = new VariablesSecureApp(request);

    try {

      final String strYearID = (String) bundle.getParams().get("cYearId");
      final String strOutputType = (String) bundle.getParams().get("outputtype");

      try {
        // Recupera el ID del registro
        final String StrPaymentID = (String) bundle.getParams().get("Sspp_Payments_ID");

        // Declara un objeto de este registro
        SSPPPAYMENTS SsppPayment = OBDal.getInstance().get(SSPPPAYMENTS.class, StrPaymentID);

        // DETERMINAR SI LA EXPORTACION ES EN CSV O TXT SEGUN LA CONFIGURACION DE LA CUENTA
        // FINANCIERA
        FIN_FinancialAccount financialAccount = SsppPayment.getFinancialAccount();
        SfiacPaymentLotFile configFile = financialAccount.getSfiacPaymentLotFileList().size() > 0
            ? financialAccount.getSfiacPaymentLotFileList().get(0)
            : null;

        if (financialAccount != null) {
          if (financialAccount.isSfiacPaymentLot()) {
            // Determinar de que tipo es la exportacion y configuracion de plantilla
            String typeFormat = (financialAccount.getSfiacPaymentLotFormat() != null)
                ? financialAccount.getSfiacPaymentLotFormat().toString()
                : null;
            String nameFile = configFile != null ? configFile.getName() : "";
            String formatDate = StringUtils.substringBetween(nameFile, "#");

            nameFile = nameFile.replaceAll("#" + formatDate + "#",
                Matcher.quoteReplacement(
                    StringUtils.isNotBlank(formatDate) && isValidPatternDate(formatDate)
                        ? Utility.formatDate(new Date(), formatDate)
                        : ""));

            String sourcePath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
                .getProperty("source.path");
            String locationConfigFile = getLocationTemplate(financialAccount);
            if (locationConfigFile == null) {
              throw new OBException(
                  "No existe configuración en la cuenta financiera (Archivo Lote de Pago) para generar el archivo.");
            }

            sourcePath = sourcePath + locationConfigFile;

            if (typeFormat.equals("") || typeFormat == null) {
              throw new OBException(
                  "No se ha establecido el formato para la generación del archivo, verifique la configuración en la cuenta financiera.");
            }

            // Verificar si existe el template
            File archivo = new File(sourcePath);
            if (!archivo.exists()) {
              throw new OBException(
                  "No se encuentra el template (fichero de la plantilla) configurado en la cuenta financiera.");
            }

            formatToPrintDownload(sourcePath,
                (SsppPayment.getDocumentType() != null) ? SsppPayment.getDocumentType().getId()
                    : null,
                StrPaymentID, typeFormat, conn, bundle, message, nameFile);
          }
        }
        log4j.info("Documento TXT Generado");

      } catch (final Exception e) {
        e.printStackTrace(System.err);
        message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
        message.setType("Error");
        message.setMessage(e.getMessage() + e.fillInStackTrace());
      } finally {
        bundle.setResult(message);
      }

    } finally {
      bundle.setResult(message);
    }
  }

  public void formatToPrintDownload(String sourcePath, String documentTypeId, String StrPaymentID,
      String formatToPrint, ConnectionProvider conn, ProcessBundle bundle, OBError message,
      String nameFile) throws ServletException {
    HttpServletResponse response = RequestContext.get().getResponse();

    try {
      File filename = new File(sourcePath);
      String[] columnFile = null;
      // Columna Header de l cvs )template), debe ser el mismo nombe del alias de la
      // consulta SsppDownloadPaymentFileData
      CSVReader reader = new CSVReader(
          new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '\"', '\\', 0, false,
          true);
      // catch header column. this is the most important names in fields because this is
      // the alias of xsql
      columnFile = reader.readNext();

      if (columnFile == null) {
        throw new OBException(
            "El archivo de configuración (Template) no presenta las columnas base.");
      }

      if (!documentTypeId.isEmpty()) {
        // bundle.setResult(message);

        java.util.Date fecha_actual = new java.util.Date();
        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd/MM/yyyy");

        String new_fecha = formato_fecha.format(fecha_actual);
        String nameFileOut = StringUtils.isNotBlank(nameFile) ? nameFile
            : "LoteDePagos_" + formatToPrint + "_" + new_fecha;

        // Prepar browser to receive file
        // Preparar el navegador para recibir el archivo
        response.setCharacterEncoding("Cp1252");
        response.setContentType("application/" + formatToPrint);
        response.setHeader("Content-Disposition",
            "attachment; filename=" + nameFileOut + "." + formatToPrint);
        // Build txt file
        // Consrtuir el archivo txt
        PrintWriter out = response.getWriter();

        SsppDownloadPaymentFileData data[] = null;
        if (sourcePath.contains("detail")) {
          data = SsppDownloadPaymentFileData.selectDetailled(conn, StrPaymentID);

        } else {
          data = SsppDownloadPaymentFileData.select(conn, StrPaymentID);

        }
        if (data != null && data.length > 0) {
          for (SsppDownloadPaymentFileData CollSsppPaymentLine : data) {
            for (int i = 0; i < columnFile.length; i++) {
              String value = CollSsppPaymentLine.getField(columnFile[i]);
              out.write(value);
              if (formatToPrint.equals("csv")) {
                out.write(",");
              } else {
                out.write("\t");
              }
            }
            out.println();
          }
          out.close();
        }
      }

    } catch (IOException e) {
      throw new ServletException(e.getMessage().toString());

    } catch (ServletException e) {
      throw new ServletException(e.getMessage().toString());

    }

  }

  protected String formatDate(java.util.Date date) {
    return new SimpleDateFormat((String) OBPropertiesProvider.getInstance().getOpenbravoProperties()
        .get(KernelConstants.DATE_FORMAT_PROPERTY)).format(date);
  }

  public boolean isValidPatternDate(String pattern) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
      try {
        String date = simpleDateFormat.format(new Date());
      } catch (Exception e) {
        return false;
      }
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  public String getServletInfo() {
    return "Servlet PaymentReport.";
  } // end of getServletInfo() method

}
