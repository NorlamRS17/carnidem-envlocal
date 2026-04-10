package ec.com.sidesoft.dinardap.create_txt;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openbravo.client.kernel.RequestContext;
import org.openbravo.dal.core.OBContext;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.xmlEngine.XmlEngine;

public class ArchDinardapTXT extends DalBaseProcess {

  public XmlEngine xmlEngine = null;
  public static String strDireccion;

  @SuppressWarnings({ "deprecation", "null" })
  public void doExecute(ProcessBundle bundle) throws Exception {

    final OBError message = new OBError();

    String language = OBContext.getOBContext().getLanguage().getLanguage();
    // ConnectionProvider conn = new DalConnectionProvider(false);

    ConnectionProvider conn = bundle.getConnection();

    // VariablesSecureApp varsAux = bundle.getContext().toVars();
    HttpServletResponse response = RequestContext.get().getResponse();
    HttpServletRequest request = RequestContext.get().getRequest();

    try {

      // retrieve the parameters from the bundle
      // Recupera los parametros de la sesión

      // final String strYearID = (String) bundle.getParams().get("cYearId");

      // Get the Payroll Ticket data
      // Obtener los datos de la Boleta de Nomina

      final String strDate = (String) bundle.getParams().get("dateTo");
      final String strStartDate = (String) bundle.getParams().get("dateFrom");

      ArchDinardapData data[] = ArchDinardapData.select(conn, strDate, strDate, strDate, strDate,
          strDate, strDate, strDate, strDate, strDate, strDate, strDate, strDate, strDate, strDate,
          strDate, strDate, strDate, strDate, strDate, strDate, strDate, strDate, strStartDate,
          strStartDate, strDate);
      if (data != null && data.length > 0) {
        bundle.setResult(message);

        // Prepar browser to receive file
        // Preparar el navegador para recibir el archivo

        final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final Date date = new Date();
        String filename = null;
        for (ArchDinardapData archDinardapDataRUC : data) {
          filename = archDinardapDataRUC.rucorg;
        }
        SimpleDateFormat dateGenerate = new SimpleDateFormat("dd-MM-yyyy");
        Date dtGenerate = dateGenerate.parse(String.valueOf(strDate));

        SimpleDateFormat dateGenerateArch = new SimpleDateFormat("dd/MM/yyyy");
        String dtGenerateArch = dateGenerateArch.format(dtGenerate);

        SimpleDateFormat dateGenerateName = new SimpleDateFormat("ddMMyyyy");
        String strGenerateFileName = dateGenerateName.format(dtGenerate);

        filename = filename.trim() + strGenerateFileName.trim();
        response.setCharacterEncoding("Cp1252");
        response.setContentType("application/txt");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename + ".txt");
        // Build txt file
        // Consrtuir el archivo txt
        PrintWriter out = response.getWriter();

        try {
          // out.write((Utility.fileToString(file.getAbsolutePath())));
          int countLine = 0;
          for (ArchDinardapData archDinardapData : data) {

            Double dblVarlorOperacion = Double.parseDouble(archDinardapData.valoroperacion);
            Double dblSaldoOperacion = Double.parseDouble(archDinardapData.saldooperacion);
            String strTipoTercero = archDinardapData.clasesujeto;

            if (countLine > 0 && dblVarlorOperacion >= 60 && dblSaldoOperacion > 0
                && strTipoTercero.equals("J"))
              out.println();

            if (dblVarlorOperacion >= 60 && dblSaldoOperacion > 0 && strTipoTercero.equals("J")) {

              out.write("SR04441");
              out.write("|");
              out.write(dtGenerateArch);
              out.write("|");
              // out.write(archDinardapData.codigoentidad);
              // out.write("|");
              out.write(archDinardapData.tipoidentificacion);

              out.write("|");
              out.write(archDinardapData.identificacionsujeto);
              out.write("|");

              String strNombreSujeto = "";
              if (archDinardapData.nombresujeto.length() > 100) {
                strNombreSujeto = removeCharactersSpecial(
                    archDinardapData.nombresujeto.substring(0, 100));
              } else {
                strNombreSujeto = removeCharactersSpecial(archDinardapData.nombresujeto);
              }
              out.write(strNombreSujeto.trim());
              out.write("|");
              out.write(archDinardapData.clasesujeto);
              out.write("|");
              out.write(archDinardapData.provincia);
              out.write("|");
              out.write(archDinardapData.canton);
              out.write("|");
              out.write(archDinardapData.parroquia);
              out.write("|");
              out.write(archDinardapData.sexo);
              out.write("|");
              out.write(archDinardapData.estadocivil);
              out.write("|");
              out.write(archDinardapData.origeningresos);
              out.write("|");
              out.write(archDinardapData.numerooperacion);
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valoroperacion));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.saldooperacion));
              out.write("|");
              out.write(returnDate(archDinardapData.fechaconcesion));
              out.write("|");
              out.write(returnDate(archDinardapData.fechaexigible));
              out.write("|");
              out.write(returnDate(archDinardapData.fechavencimiento));
              out.write("|");
              out.write(archDinardapData.plazooperacion);
              out.write("|");
              out.write(archDinardapData.periodicidadpagos);
              out.write("|");
              out.write(archDinardapData.diasmorosidad);
              out.write("|");
              out.write(strReturnFormat(archDinardapData.montomorosidad));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.montointeresenmora));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorxvencer1a30));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorxvencer31a90));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorxvencer91a180));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorxvencer181a360));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorxvencermas360));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorvencido1a30));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorvencido31a90));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorvencido91a180));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorvencido181a360));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorvencidomas360));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.valorendemandajudicial));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.carteracastigada));
              out.write("|");
              out.write(strReturnFormat(archDinardapData.cuotacredito));
              out.write("|");
              // out.write(archDinardapData.fechacancelacion);
              // out.write("|");
              // out.write(archDinardapData.formacancelacion);
              out.write("|");
              countLine++;
            }

          }
          // Send file to browser
          // Enviar el archivo al navegador
          out.close();

          // TODO: Restore previous headers
          // if (!headers.isEmpty()) {
          // response.setHeader(headers.get(0).nextElement().toString(), headers.get(0)
          // .nextElement().toString());
          // }
          // for (int i = 1; i < headers.size(); i++) {
          // response.addHeader(headers.get(i), headers.get(i)
          // .nextElement().toString());
          // }
          // response.setCharacterEncoding(oldCharacterEncoding);
          // response.setContentType(oldContentType);

        } catch (final Exception e) {
          e.printStackTrace(System.err);
          message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
          message.setType("Error");
          message.setMessage(e.getMessage() + e.fillInStackTrace());
        } finally {
          bundle.setResult(message);
        }
      } else {
        message.setTitle(Utility.messageBD(conn, "Error", language));
        message.setType("Error");
        message.setMessage("No se encontró información en la consulta");
      }
    } finally {
      bundle.setResult(message);
    }
  }

  /**
   * Función que elimina acentos y caracteres especiales de una cadena de texto.
   * 
   * @param input
   * @return cadena de texto limpia de acentos y caracteres especiales.
   */

  public String strReturnFormat(String strValor) {

    // formateador
    DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    simbolos.setDecimalSeparator('.');
    DecimalFormat formateador = new DecimalFormat("#########0.00", simbolos);

    double dblResult = 0;
    if (strValor == null || strValor.trim().equals("")) {
      strValor = "0";
    }

    dblResult = Double.parseDouble(strValor);

    return formateador.format(dblResult);

  }

  public static String removeAcute(String input) {
    // Cadena de caracteres original a sustituir.
    String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
    // Cadena de caracteres ASCII que reemplazarán los originales.
    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
    String output = input;
    for (int i = 0; i < original.length(); i++) {
      // Reemplazamos los caracteres especiales.
      output = output.replace(original.charAt(i), ascii.charAt(i));
    } // for i
    return output;
  }// removeAcute

  public static String removeCharactersSpecial(String strinput) {
    String strRemove = "";

    if (strinput.length() > 0) {
      strRemove = strinput.replace(",", "").replace(".", "").replace("\"", "").replace("'", "");
    }
    return strRemove;
  }

  public static String returnDate(String strDate) {

    String strReturnDate = "";
    Object[] obj = strDate.split("/");
    strReturnDate = obj[0].toString() + "/"
        + (Double.parseDouble(obj[1].toString()) > 0 & Double.parseDouble(obj[1].toString()) <= 9
            ? "0" + String.valueOf(Integer.parseInt(obj[1].toString()))
            : obj[1].toString())
        + "/" + obj[2].toString();
    return strReturnDate.trim();
  }
}
