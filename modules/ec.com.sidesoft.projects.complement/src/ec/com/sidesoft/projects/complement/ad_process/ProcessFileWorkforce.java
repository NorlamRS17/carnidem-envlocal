package ec.com.sidesoft.projects.complement.ad_process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import au.com.bytecode.opencsv.CSVReader;
import ec.com.sidesoft.projects.complement.SproctmImpWforceLine;
import ec.com.sidesoft.projects.complement.SproctmImpWorkforce;

public class ProcessFileWorkforce extends DalBaseProcess {

  OBError message;
  protected ConnectionProvider conn;
  protected VariablesSecureApp vars;
  protected String language;

  final String attachmentFolderPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
      .getProperty("attach.path");

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception {
    VariablesSecureApp vars = bundle.getContext().toVars();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    this.conn = conn;
    this.vars = vars;
    this.language = language;
    // TODO Auto-generated method stub
    try {
      message = new OBError();
      processRequest(bundle);

    } catch (Exception e) {
      System.out.println(e);
      // log4j1.info("exeption" + e);
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    } finally {
      bundle.setResult(message);
    }
  }

  public void processRequest(ProcessBundle bundle) throws Exception {

    String messageT = "";
    String typeM = "";
    String titleM = "";
    String recordId = (String) bundle.getParams().get("Sproctm_Imp_Workforce_ID");
    String pathFile = getLocationFileCSV(recordId);
    message.setMessage(pathFile);
    if (pathFile == "") {
      typeM = "Error";
      titleM = "Error";
      messageT = "No se encontro ningún archivo de tipo <b>csv</b> en los adjuntos.";
      message.setMessage(messageT);
      message.setTitle(Utility.messageBD(conn, titleM, language));
      message.setType(typeM);
    } else {

      System.out.println("IMPORTACION DE MANO DE OBRA");

      SproctmImpWorkforce record = OBDal.getInstance().get(SproctmImpWorkforce.class, recordId);

      validateDataToInsert(pathFile, record);

      if (ValidateData.getLineLogWforce(record) > 0) {

        typeM = "Error";
        titleM = "Error";
        messageT = "No se pudo finalizar la importación revisar las lineas de la <b>Bitácora</b>.";
        record.setAlertStatus("DR");

        message.setMessage(messageT);
        message.setTitle(Utility.messageBD(conn, titleM, language));
        message.setType(typeM);

      } else {

        typeM = "Success";
        titleM = "ProcessOK";

        messageT = "El proceso de importación de mano de obra en tarea se realizó correctamente.";
        record.setAlertStatus("PR");
        message.setMessage(messageT);
        message.setTitle(Utility.messageBD(conn, titleM, language));
        message.setType(typeM);

      }

    }

  }

  public void validateDataToInsert(String filename, SproctmImpWorkforce head)
      throws Exception, IOException {
    StringBuffer buffer = new StringBuffer(); // default size 9

    try {
      CSVReader reader = new CSVReader(
          new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '\"', '\\', 0, false,
          true);

      // read line by line
      String[] record = null;
      String[] columnFile = null;

      // skip header row
      columnFile = reader.readNext();
      // Validacion del numero de columnas de la plantilla
      if (columnFile.length >= 8) {
        PreparedStatement st = null;
        String deleteQsl = "DELETE FROM sproctm_task_workforce WHERE c_projecttask_id = '"
            + head.getProjectTask().getId() + "'";
        st = conn.getPreparedStatement(deleteQsl);
        st.execute();
        st.close();

        while ((record = reader.readNext()) != null) {
          if (record.length > 1 || record[0].length() > 0) {
            // organization*
            Organization organization = ValidateData.getorganizationF(record[0]);
            // Categoria salarial
            SalaryCategory categSalary = ValidateData.getcategSalaryF(record[1]);
            // Cantidad_presupuestada
            String qtyBudgeted = record[2];
            // Unidad_medida_costo
            String UOMCost = ValidateData.getUOMCostF(record[3].trim());
            // UOM UOMCost = ValidateData.getUOMCostF(record[3].trim());
            // Costo_unitario_estandar
            double unit_cost_standard = Double.parseDouble(record[4]);
            // costo_total_presupuetado
            double total_cost_budgeted = Double.parseDouble(record[5]);

            double qyt_executed = Double.parseDouble(record[6]);

            String uomTmp = null;
            if (UOMCost != null) {
              uomTmp = UOMCost; // UOMCost.getId();
            }

            if (organization.equals("") && organization.toString().isEmpty()) {
              buffer.append("No existe la organización " + record[0] + "\n");
            }
            if (categSalary.equals("") && categSalary.toString().isEmpty()) {
              buffer.append("No existe la categoria salarial" + record[1] + ".\n");
            }

            if (qtyBudgeted.toString().isEmpty() /* && action.equals("A") */) {
              buffer.append(
                  "La cantidad para la linea de organización " + record[0] + " es obligatorio.\\n");
            }

            if (uomTmp == null || uomTmp.toString().isEmpty()) {
              buffer.append("No existe la unidad medida de costo " + record[3] + ".\n");
            }

            // Validacion costo unitario estandar
            if (String.valueOf(unit_cost_standard) == null
                && !String.valueOf(record[4]).isEmpty()) {
              buffer.append("El costo unitario estandar " + record[4] + "  no existe.\n");
            }
            // Validacion costo total presupuestado
            if (String.valueOf(total_cost_budgeted) == null
                && !String.valueOf(record[5]).isEmpty()) {
              buffer.append("El costo total presupuestado " + record[4] + "  no existe.\n");
            }

            if (!buffer.toString().isEmpty()) {
              createLineLog(head, buffer.toString());
              buffer.setLength(0);
            } else {

              System.out.println("LISTO PARA AGREGAR LA IMPORTACION INSERT");

              createWorkforce(head, organization.getId(), categSalary.getId(),
                  Double.parseDouble(qtyBudgeted), /* UOMCost.getId() */ UOMCost,
                  unit_cost_standard, qyt_executed, total_cost_budgeted);
            }
          }
        }

        reader.close();
      } else {
        buffer.append(
            "El contenido del archivo CSV no es válido revise que las columnas esten completas.\n");
        createLineLog(head, buffer.toString());
        buffer.setLength(0);
      }

    } catch (Exception e) {
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
      buffer.append(e.getMessage());
      createLineLog(head, buffer.toString());
      buffer.setLength(0);
    }
  }

  public void createWorkforce(SproctmImpWorkforce head, String organization_id,
      String categSalary_id, double qtyBudgeted, String UOMCost_id, double unit_cost_standard,
      double qyt_executed, double total_cost_budgeted) throws Exception {

    try {
      StringBuffer buffer = new StringBuffer();

      OBContext.setAdminMode(true);
      // Valida si existe el prod
      if (organization_id.isEmpty()) {
        buffer.append("No se ha encontrado la organización asignada a la linea de importación.\n");
      } else {
        deleteLineImport(head);

        PreparedStatement st = null;
        // CREATE THE NEW ROW - Multifase Task - Product
        // Obtener las configuracuones de importacion para identificar las pestañas agregar los
        // prodcutos
        String c_project_id = head.getProject().getId().toString();
        String c_projectphase_id = head.getProjectPhase().getId().toString();
        String c_projecttask_id = head.getProjectTask().getId().toString();

        String ad_cliente_id = head.getClient().getId().toString();

        if (c_project_id == null || c_projectphase_id == null || c_projecttask_id == null) {
          buffer.append(
              "No se ha especificado la tarea donde se importará los datos del archivo csv. \n");
        } else {

          String sql = "INSERT INTO public.sproctm_task_workforce( "
              + "  sproctm_task_workforce_id, ad_client_id, ad_org_id, isactive, created, "
              + " createdby, updated, updatedby, c_projecttask_id, c_salary_category_id, qty_budget, "
              + " costuom, cost_unit_standar, total_cost_budget, qty_executed, total_cost) "
              + " VALUES (get_uuid(), '" + ad_cliente_id + "', '" + organization_id + "', "
              + " 'Y', now(), 100, now(), 100, '" + c_projecttask_id + "', '" + categSalary_id
              + "', " + "  " + qtyBudgeted + ", '" + UOMCost_id + "', '" + unit_cost_standard
              + "' , '" + total_cost_budgeted + "', " + " " + qyt_executed + ", " + " "
              + (unit_cost_standard * qyt_executed) + " ) ";

          st = conn.getPreparedStatement(sql);
          st.execute();
          st.close();

        }

      }

      OBDal.getInstance().flush();
      OBContext.setAdminMode(false);
      conn.destroy();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // LocationFile
  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "739449BC05D14E71B75EB13412AB6A25"); // sproctm_imp_products
    obc.add(Restrictions.eq(Attachment.PROPERTY_RECORD, recordId));
    obc.add(Restrictions.eq(Attachment.PROPERTY_TABLE, table));
    obc.add(Restrictions.eq(Attachment.PROPERTY_DATATYPE, "text/csv"));
    obc.addOrderBy(Attachment.PROPERTY_SEQUENCENUMBER, false);
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    OBContext.setAdminMode(false);
    Attachment attach = (Attachment) obc.uniqueResult();
    if (attach == null) {
      return "";
    }
    return attachmentFolderPath + "/" + attach.getPath() + '/' + attach.getName();
  }

  public void createLineLog(SproctmImpWorkforce head, String msg) throws Exception {
    try {
      SproctmImpWforceLine lineLog = OBProvider.getInstance().get(SproctmImpWforceLine.class);
      lineLog.setSproctmImpWorkforce(head);
      lineLog.setLOGProcess(truncate(msg, 4000));
      lineLog.setLineNo(getSequenceLI(head));

      OBDal.getInstance().save(lineLog);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void deleteLineImport(SproctmImpWorkforce record) throws Exception {

    try {
      OBCriteria<SproctmImpWforceLine> obc = OBDal.getInstance()
          .createCriteria(SproctmImpWforceLine.class);
      obc.add(Restrictions.eq(SproctmImpWforceLine.PROPERTY_SPROCTMIMPWORKFORCE, record));
      if (obc.count() > 0) {
        for (SproctmImpWforceLine dataLine : obc.list()) {
          OBDal.getInstance().remove(dataLine);
        }
        OBDal.getInstance().flush();
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // ************************* HELPERS **********************************//
  public String truncate(String value, int length) {

    if (value == null || value.equals("")) {
      return null;
    } else {
      if (value.length() > length) {
        return value.substring(0, length);
      } else {
        return value;
      }
    }
  }

  public Long getSequenceLI(SproctmImpWorkforce importData) throws OBException {
    OBCriteria<SproctmImpWforceLine> obc = OBDal.getInstance()
        .createCriteria(SproctmImpWforceLine.class);
    obc.add(Restrictions.eq(SproctmImpWforceLine.PROPERTY_SPROCTMIMPWORKFORCE, importData));
    obc.addOrderBy(SproctmImpWforceLine.PROPERTY_LINENO, false);
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    SproctmImpWforceLine attach = (SproctmImpWforceLine) obc.uniqueResult();
    if (attach == null) {
      return 10L;
    }
    return attach.getLineNo() + 10L;
  }

}
