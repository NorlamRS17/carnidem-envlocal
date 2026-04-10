package ec.com.sidesoft.dinardap.advanced.ad_process;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.businessUtility.TabAttachments;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;
import org.openbravo.service.db.DbUtility;

import ec.com.sidesoft.dinardap.advanced.Sdindp_Dinardap;
import ec.com.sidesoft.dinardap.advanced.Sdindp_DinardapConfig;
import ec.com.sidesoft.dinardap.advanced.Sdindp_DinardapLine;
import org.openbravo.client.application.attachment.CoreAttachImplementation;

public class GenerateTXT extends DalBaseProcess {
  private final Logger log4j = Logger.getLogger(GenerateTXT.class);

  final String tableId = "2CE2952C624C42DFA430B96C9D6F649C"; // opcrm_activity
  final String fileName = "reporte.txt";
  final String dataType = "text/plain";
  private Table table;

  private String recordId;
  private Sdindp_Dinardap record;
  private Sdindp_DinardapConfig config;

  private static SimpleDateFormat inSDF = new SimpleDateFormat("dd/mm/yyyy");
  private static SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");

  @Override
  public void doExecute(ProcessBundle bundle) throws Exception {
    OBError msg = new OBError();

    try {
      OBContext.setAdminMode(true);
      msg.setTitle(OBMessageUtils.messageBD("Success"));
      msg.setType("Success");
      msg.setMessage("TXT generado con éxito");

      table = OBDal.getInstance().get(Table.class, tableId);

      recordId = (String) bundle.getParams().get("Sdindp_Dinardap_ID");
      record = OBDal.getInstance().get(Sdindp_Dinardap.class, recordId);

      OBCriteria<Sdindp_DinardapConfig> configList = OBDal.getInstance()
          .createCriteria(Sdindp_DinardapConfig.class);
      configList.add(Restrictions.eq(Attachment.PROPERTY_ACTIVE, true));
      configList.uniqueResult();
      List<Sdindp_DinardapConfig> configs = configList.list();
      if (configs.size() == 0) {
        throw new OBException("No se encontro configuración de parámetros generales Dinardap");
      }
      config = configs.get(0);

      process();
    } catch (final Exception e) {
      log4j.error("Exception found in GenerateTXT process: ", e);
      Throwable exception = DbUtility.getUnderlyingSQLException(e);
      String message = OBMessageUtils.translateError(exception.getMessage()).getMessage();
      msg.setTitle(OBMessageUtils.messageBD("Error"));
      msg.setType("Error");
      msg.setMessage(message);
    } finally {
      OBContext.restorePreviousMode();
      bundle.setResult(msg);
    }
  }

  public void process() throws Exception {
    OBCriteria<Attachment> attachmentList = OBDal.getInstance().createCriteria(Attachment.class);
    attachmentList.add(Restrictions.eq(Attachment.PROPERTY_TABLE, table));
    attachmentList.add(Restrictions.eq(Attachment.PROPERTY_RECORD, recordId));
    attachmentList.add(Restrictions.eq(Attachment.PROPERTY_NAME, fileName));
    attachmentList.add(Restrictions.eq(Attachment.PROPERTY_DATATYPE, dataType));
    attachmentList.uniqueResult();

    String path;
    List<Attachment> attachments = attachmentList.list();
    if (attachments.size() == 0) {
      path = CoreAttachImplementation.getAttachmentDirectoryForNewAttachments(tableId, recordId);
    } else {
      path = attachments.get(0).getPath();
    }
    final boolean result = createXML(path);
    if (attachments.size() == 0 && result) {
      insertAttachment(path);
    }
  }

  private boolean createXML(String path) {
    boolean result = false;
    String txt = "";
    try {
      final String attachPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
          .getProperty("attach.path");
      File filePath = new File(attachPath + File.separator + path);
      if (!filePath.exists()) {
        filePath.mkdirs();
      }
      File file = new File(filePath.getAbsolutePath() + File.separator + fileName);
      if (!file.exists()) {
        if (!file.createNewFile()) {
          throw new OBException("Error al intentar crear el TXT");
        }
      }

      final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

      OBCriteria<Sdindp_DinardapLine> lineList = OBDal.getInstance()
          .createCriteria(Sdindp_DinardapLine.class);
      lineList.add(Restrictions.eq(Sdindp_DinardapLine.PROPERTY_SDINDPDINARDAP, record));
      List<Sdindp_DinardapLine> lines = lineList.list();

      for (Sdindp_DinardapLine line : lines) {
        float saldoOperacion = 0;
        saldoOperacion = ((line.getValorXVencer1A30() != null ? line.getValorXVencer1A30() : 0)
            .floatValue()
            + (line.getValorXVencer31A90() != null ? line.getValorXVencer31A90() : 0).floatValue()
            + (line.getValorXVencer91A180() != null ? line.getValorXVencer91A180() : 0).floatValue()
            + (line.getValorXVencer181A360() != null ? line.getValorXVencer181A360() : 0)
                .floatValue()
            + (line.getValorXVencerMas360() != null ? line.getValorXVencerMas360() : 0).floatValue()
            + (line.getValorVencido1A30() != null ? line.getValorVencido1A30() : 0).floatValue()
            + (line.getValorVencidoG31A90() != null ? line.getValorVencidoG31A90() : 0).floatValue()
            + (line.getValorVencido91A180() != null ? line.getValorVencido91A180() : 0).floatValue()
            + (line.getValorVencido181A360() != null ? line.getValorVencido181A360() : 0)
                .floatValue()
            + (line.getValorVencidoMas360() != null ? line.getValorVencidoMas360() : 0).floatValue()
            + (line.getCarteraCastigada() != null ? line.getCarteraCastigada() : 0).floatValue());

        float valorOperacion = (line.getValorOperacion() != null ? line.getValorOperacion() : 0)
            .floatValue();
        if (valorOperacion < saldoOperacion) {
          valorOperacion = saldoOperacion;
        }
        String fechaConcesion = (line.getFechaConcesion() != null
            ? df.format(line.getFechaConcesion())
            : "").toString();
        // String fechaVencimiento = (line.getFechaVencimiento() != null
        // ? df.format(line.getFechaVencimiento())
        // : "").toString();
        String fechaExigible = (line.getFechaExigible() != null ? df.format(line.getFechaExigible())
            : "").toString();
        long diasDiferencia = 0;
        if (fechaConcesion != "") {
          String fecha1 = formatDate(fechaConcesion);
          String fecha2 = formatDate(fechaExigible);
          // Parsing the date
          LocalDate dateBefore = LocalDate.parse(fecha1);
          LocalDate dateAfter = LocalDate.parse(fecha2);

          // calculating number of days in between
          long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
          // displaying the number of days
          diasDiferencia = noOfDaysBetween;
        }

        txt += txt.isEmpty() ? "" : "\r\n";
        txt += line.getCodigoEntidad() != null ? line.getCodigoEntidad() : "";
        txt += "|" + (line.getFecha() != null ? df.format(line.getFecha()) : "");
        txt += "|" + (line.getTipoIdentificacion() != null ? line.getTipoIdentificacion() : "");
        txt += "|" + (line.getIdentificacionSujeto() != null ? line.getIdentificacionSujeto() : "");
        txt += "|" + (line.getNombreSujeto() != null ? line.getNombreSujeto().trim() : "");
        txt += "|" + (line.getClaseSujeto() != null ? line.getClaseSujeto() : "");
        txt += "|" + (line.getProvincia() != null ? line.getProvincia() : "");
        txt += "|" + (line.getCanton() != null ? line.getCanton() : "");
        txt += "|" + (line.getParroquia() != null ? line.getParroquia() : "");
        txt += "|" + (line.getSexo() != null ? line.getSexo() : "");
        txt += "|" + (line.getEstadoCivil() != null ? line.getEstadoCivil() : "");
        txt += "|" + (line.getOrigenIngresos() != null ? line.getOrigenIngresos() : "");
        txt += "|" + (line.getNumeroOperacion() != null ? line.getNumeroOperacion() : "");
        txt += "|" + (new BigDecimal(valorOperacion).setScale(2, RoundingMode.HALF_UP));
        // txt += "|" + (line.getValorOperacion() != null ?
        // line.getValorOperacion() : "0.00");
        txt += "|" + (new BigDecimal(saldoOperacion).setScale(2, RoundingMode.HALF_UP));
        // txt += "|" + (line.getSaldoOperacion() != null ?
        // line.getSaldoOperacion() : "0.00");
        txt += "|" + (line.getFechaConcesion() != null ? df.format(line.getFechaConcesion()) : "");
        txt += "|"
            + (line.getFechaVencimiento() != null ? df.format(line.getFechaVencimiento()) : "");
        txt += "|" + (line.getFechaExigible() != null ? df.format(line.getFechaExigible()) : "");
        txt += "|" + (line.getPlazoOperacion() != null ? line.getPlazoOperacion().intValue() : "0");
        txt += "|"
            + (line.getPeriodicidadPagos() != null ? line.getPeriodicidadPagos().intValue() : "0");
        txt += "|" + (line.getDiasMorosidad() != null ? line.getDiasMorosidad().intValue() : "0");
        txt += "|" + (line.getMontoMorosidad() != null
            ? line.getMontoMorosidad().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getMontoInteresEnMora() != null
            ? line.getMontoInteresEnMora().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorXVencer1A30() != null
            ? line.getValorXVencer1A30().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorXVencer31A90() != null
            ? line.getValorXVencer31A90().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorXVencer91A180() != null
            ? line.getValorXVencer91A180().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorXVencer181A360() != null
            ? line.getValorXVencer181A360().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorXVencerMas360() != null
            ? line.getValorXVencerMas360().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorVencido1A30() != null
            ? line.getValorVencido1A30().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorVencidoG31A90() != null
            ? line.getValorVencidoG31A90().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorVencido91A180() != null
            ? line.getValorVencido91A180().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorVencido181A360() != null
            ? line.getValorVencido181A360().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorVencidoMas360() != null
            ? line.getValorVencidoMas360().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getValorEnDemandaJudicial() != null ? line.getValorEnDemandaJudicial()
            : "0.00");
        txt += "|" + (line.getCarteraCastigada() != null
            ? line.getCarteraCastigada().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|" + (line.getCuotaCredito() != null
            ? line.getCuotaCredito().setScale(2, RoundingMode.HALF_UP)
            : "0.00");
        txt += "|"
            + (line.getFechaCancelacion() != null ? df.format(line.getFechaCancelacion()) : "");
        txt += "|" + (line.getFormaCancelacion() != null ? line.getFormaCancelacion() : "");

      }

      FileWriter myWriter = new FileWriter(filePath.getAbsolutePath() + File.separator + fileName);
      myWriter.write(txt);
      myWriter.close();

      result = true;
    } catch (Exception e) {
      throw new OBException(e.getMessage());
    }
    return result;
  }

  public static String formatDate(String inDate) {
    String outDate = "";
    if (inDate != null) {
      try {
        Date date = inSDF.parse(inDate);
        outDate = outSDF.format(date);
      } catch (Exception e) {
        throw new OBException(e.getMessage());
      }
    }
    return outDate;
  }

  private boolean insertAttachment(String path) throws Exception {
    boolean result = false;

    ConnectionProvider conn = new DalConnectionProvider(false);
    PreparedStatement st = null;

    try {
      String sql = "INSERT INTO c_file (c_file_id,ad_org_id,ad_client_id,"
          + "createdby,updatedby,name,c_datatype_id,seqno,ad_table_id,"
          + "ad_record_id,path) VALUES (get_uuid(),?,?,?,?,?,?,"
          + "(SELECT COALESCE(MAX(seqno),0)+10 FROM c_file WHERE ad_table_id=? AND ad_record_id=?),"
          + "?,?,?)";
      st = conn.getPreparedStatement(sql);
      st.setString(1, record.getOrganization().getId());
      st.setString(2, record.getClient().getId());
      st.setString(3, record.getCreatedBy().getId());
      st.setString(4, record.getUpdatedBy().getId());
      st.setString(5, fileName);
      st.setString(6, dataType);
      st.setString(7, tableId);
      st.setString(8, record.getId());
      st.setString(9, tableId);
      st.setString(10, record.getId());
      st.setString(11, path);

      result = st.execute();

      st.close();
    } catch (Exception e) {
      throw new OBException(e.getMessage());
    } finally {
      try {
        conn.releasePreparedStatement(st);
        conn.destroy();
      } catch (Exception ignore) {
        ignore.printStackTrace();
        throw new OBException(ignore.getMessage());
      }
    }
    return result;
  }
}
