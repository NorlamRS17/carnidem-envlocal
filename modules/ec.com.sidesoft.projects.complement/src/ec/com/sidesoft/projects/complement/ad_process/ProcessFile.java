package ec.com.sidesoft.projects.complement.ad_process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import org.openbravo.model.common.plm.Product;
import org.openbravo.model.common.uom.UOM;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import au.com.bytecode.opencsv.CSVReader;
import ec.com.sidesoft.projects.complement.SproctmImpProdLine;
import ec.com.sidesoft.projects.complement.SproctmImpProducts;

public class ProcessFile extends DalBaseProcess {

  OBError message;
  protected ConnectionProvider conn;
  protected VariablesSecureApp vars;
  protected String language;

  // private static Logger log4j1 = Logger.getLogger(ProcessFile.class);

  final String attachmentFolderPath = OBPropertiesProvider.getInstance().getOpenbravoProperties()
      .getProperty("attach.path");

  @Override
  protected void doExecute(ProcessBundle bundle) throws Exception, IOException {
    VariablesSecureApp vars = bundle.getContext().toVars();
    ConnectionProvider conn = new DalConnectionProvider(false);
    String language = OBContext.getOBContext().getLanguage().getLanguage();
    this.conn = conn;
    this.vars = vars;
    this.language = language;

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
    String recordId = (String) bundle.getParams().get("Sproctm_Imp_Products_ID");
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

      SproctmImpProducts record = OBDal.getInstance().get(SproctmImpProducts.class, recordId);
      validateDataProduct(pathFile, record);

      if (ValidateData.getLineLog(record) > 0) {

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

        messageT = "El proceso de importación de productos en tarea se realizó correctamente.";
        record.setAlertStatus("PR");
        message.setMessage(messageT);
        message.setTitle(Utility.messageBD(conn, titleM, language));
        message.setType(typeM);

      }

    }
  }

  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "3BB93F7778E74A558A4CA389DD376310"); // sproctm_imp_products
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

  public void validateDataProduct(String filename, SproctmImpProducts head)
      throws Exception, IOException {

    try {
      CSVReader reader = new CSVReader(
          new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '\"', '\\', 0, false,
          true);

      // read line by line
      String[] record = null;
      String[] columnFile = null;

      StringBuffer buffer = new StringBuffer(); // default size 9
      // skip header row
      columnFile = reader.readNext();
      int icount = 1;
      // Validacion del numero de columnas de la plantilla
      if (columnFile.length >= 8) {

        while ((record = reader.readNext()) != null) {

          if (record.length > 1 || record[0].length() > 0) {
            // Proyecto
            OBContext.setAdminMode(true);

            OBCriteria<Project> obc = OBDal.getInstance().createCriteria(Project.class);
            Organization org = head.getOrganization(); // .getId().toString();
            obc.add(Restrictions.eq(Project.PROPERTY_NAME, record[0].toString()));
            obc.add(Restrictions.eq(Project.PROPERTY_ORGANIZATION, org));
            obc.setMaxResults(1);
            OBContext.setAdminMode(false);

            Project projectS = (Project) obc.uniqueResult();

            if (projectS == null) {
              buffer
                  .append("No existe el proyecto " + record[0].toString() + " para la organización "
                      + org.getName().toString() + " ingresado en el archivo csv.\n");
            }

            // Fase
            OBContext.setAdminMode(true);

            OBCriteria<ProjectPhase> pp = OBDal.getInstance().createCriteria(ProjectPhase.class);
            pp.add(Restrictions.eq(ProjectPhase.PROPERTY_PROJECT, projectS));
            pp.add(Restrictions.eq(ProjectPhase.PROPERTY_NAME, record[1].toString()));
            pp.setMaxResults(1);
            OBContext.setAdminMode(false);

            ProjectPhase phase = (ProjectPhase) pp.uniqueResult();

            if (phase == null) {
              buffer.append(
                  "No existe la fase " + record[1].toString() + " ingresado en el archivo csv.\n");
            }
            // Tarea
            OBContext.setAdminMode(true);

            OBCriteria<ProjectTask> ppt = OBDal.getInstance().createCriteria(ProjectTask.class);
            ppt.add(Restrictions.eq(ProjectTask.PROPERTY_PROJECTPHASE, phase));
            ppt.add(Restrictions.eq(ProjectTask.PROPERTY_NAME, record[2].toString()));
            ppt.setMaxResults(1);
            OBContext.setAdminMode(false);

            ProjectTask task = (ProjectTask) ppt.uniqueResult();

            if (task == null) {
              buffer.append(
                  "No existe la tarea " + record[2].toString() + " ingresado en el archivo csv.\n");
            }

            // Producto
            Product product = ValidateData.getProductF(record[3].toString());
            // Fecha Necesidad
            String fechaNedP = record[4];
            // Cantidad
            Double qtyP = Double.parseDouble(record[5]);
            // Unidad*
            UOM uom = ValidateData.getUOM(record[6]);
            // Costo
            double row_costo = (record[7].equals(null)) ? Double.parseDouble(record[7]) : 0.00;
            Double costP = (row_costo > 0) ? row_costo
                : ValidateData.getCostProduct(product.getId());
            // COSTO_TOTAL_PRESUPUESTAOD
            Double costTotalP = costP * qtyP;
            // MAQUINA
            String maquinaP = record[8];
            // IMPORTADO
            String importadoP = record[9];

            if (product == null) {
              buffer.append("No existe el producto  " + record[0] + ".\n");
            }

            if (qtyP.toString().isEmpty() /* && action.equals("A") */) {
              buffer.append("La cantidad para el producto " + record[0] + " es obligatorio.\\n");
            }

            // Validacion para la Unidad
            if (uom == null && !record[4].isEmpty()) {
              buffer.append("La unidad " + record[4] + " del producto con el código " + record[0]
                  + " no existe.\n");
            }

            // Validacion para costo
            if (costP == null && !record[7].isEmpty()) {
              buffer.append("El costo del producto " + record[0] + " no existe.\n");
            }

            if (!buffer.toString().isEmpty()) {
              createLineLog(head, buffer.toString());
              buffer.setLength(0);
            } else {
              if (icount == 1) {
                PreparedStatement st = null;
                String deleteQsl = "DELETE FROM sproctm_task_prod WHERE c_projecttask_id = '"
                    + task.getId() + "' ";
                /*
                 * String deleteQsl = "DELETE FROM sproctm_task_prod WHERE c_projecttask_id = '" +
                 * task.getId() + "' AND m_product_id =  '" + product.getId() + "' " +
                 * " AND requirements_date = '" + fechaNedP + "' AND qty = " + qtyP + " AND cost = "
                 * + costP + " AND uom_id = '" + uom + "' ";
                 */
                st = conn.getPreparedStatement(deleteQsl);
                st.execute();
              }
              createorupdateProduct(head, projectS, phase, task, product, fechaNedP, qtyP, uom,
                  costP, costTotalP, maquinaP, importadoP);
            }
          }
          icount++;
        }

        reader.close();
      } else {
        buffer.append(
            "El contenido del archivo CSV no es válido revise que las columnas esten completas.\n");
        createLineLog(head, buffer.toString());
        buffer.setLength(0);
      }

    } catch (Exception e) {
      createLineLog(head, e.toString());
      message.setMessage(e.getMessage());
      message.setTitle(Utility.messageBD(conn, "Error", language));
      message.setType("Error");
    }
  }

  public void createorupdateProduct(SproctmImpProducts headImpor, Project project,
      ProjectPhase phase, ProjectTask task, Product product, String fechaNedP, Double qtyP, UOM uom,
      double costP, double costTotalP, String maquinaP, String importadoP) throws Exception {

    try {
      StringBuffer buffer = new StringBuffer();

      OBContext.setAdminMode(true);

      deleteLineImport(headImpor);

      PreparedStatement st = null;
      // CREATE THE NEW ROW - Multifase Task - Product
      // Obtener las configuracuones de importacion para identificar las pestañas agregar los
      // prodcutos
      String c_project_id = project.getId().toString();
      String c_projectphase_id = phase.getId().toString();
      String c_projecttask_id = task.getId().toString();

      String ad_cliente_id = product.getClient().getId().toString();
      String m_product_id = product.getId().toString();

      String ad_org_id = task.getOrganization().getId().toString();

      if (c_project_id == null || c_projectphase_id == null || c_projecttask_id == null) {
        buffer.append(
            "No se ha especificado la tarea donde se importará los datos del archivo csv. \n");
        createLineLog(headImpor, "No se encontró la tarea " + task.PROPERTY_NAME);
      } else {

        String sql_currency_cost = "select c_currency_round(" + Double.toString((costP)) + ",'"
            + OBContext.getOBContext().getCurrentOrganization().getCurrency().getId()
            + "', 'Y') as total_convert";
        st = conn.getPreparedStatement(sql_currency_cost);

        ResultSet resultSet = st.executeQuery();

        while (resultSet.next()) {
          costP = resultSet.getDouble("total_convert");
        }

        String sql_currency_costT = "select c_currency_round(" + Double.toString((costTotalP))
            + ", '" + OBContext.getOBContext().getCurrentOrganization().getCurrency().getId()
            + "' , 'Y') as total_convert";
        st = conn.getPreparedStatement(sql_currency_costT);

        while (resultSet.next()) {
          costTotalP = resultSet.getDouble("total_convert");
        }

        String sql = "INSERT INTO sproctm_task_prod( "
            + "sproctm_task_prod_id, ad_client_id, ad_org_id, isactive, created, createdby, updated, updatedby, "
            + "c_projecttask_id, m_product_id, requirements_date, qty, c_uom_id "
            + ", cost, cost_total, ismachine, isimported)" + "VALUES (get_uuid(), '" + ad_cliente_id
            + "', '" + ad_org_id + "', 'Y', now(), 100, now(), 100 " + ", '" + c_projecttask_id
            + "', '" + m_product_id + "', '" + fechaNedP + "', " + qtyP + ", '"
            + uom.getId().toString() + "' " + ", " + costP + ", " + costTotalP + ", '"
            + ((maquinaP.equals("SI")) ? "Y" : "N") + "', '"
            + ((importadoP.equals("SI")) ? "Y" : "N") + "')";

        st = conn.getPreparedStatement(sql);
        st.execute();
        st.close();

      }

      OBDal.getInstance().flush();
      OBContext.setAdminMode(false);
      conn.destroy();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void createLineLog(SproctmImpProducts head, String msg) throws Exception {
    try {
      SproctmImpProdLine lineLog = OBProvider.getInstance().get(SproctmImpProdLine.class);
      lineLog.setSproctmImpProducts(head); // setSproctmImpProducts(head);
      lineLog.setLOGProcess(truncate(msg, 4000));
      lineLog.setLineNo(getSequenceLI(head));

      OBDal.getInstance().save(lineLog);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void deleteLineImport(SproctmImpProducts record) throws Exception {

    try {
      OBCriteria<SproctmImpProdLine> obc = OBDal.getInstance()
          .createCriteria(SproctmImpProdLine.class);
      obc.add(Restrictions.eq(SproctmImpProdLine.PROPERTY_SPROCTMIMPPRODUCTS, record));
      if (obc.count() > 0) {
        for (SproctmImpProdLine dataLine : obc.list()) {
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

  public Long getSequenceLI(SproctmImpProducts importProduct) throws OBException {
    OBCriteria<SproctmImpProdLine> obc = OBDal.getInstance()
        .createCriteria(SproctmImpProdLine.class);
    obc.add(Restrictions.eq(SproctmImpProdLine.PROPERTY_SPROCTMIMPPRODUCTS, importProduct));
    obc.addOrderBy(SproctmImpProdLine.PROPERTY_LINENO, false);
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    SproctmImpProdLine attach = (SproctmImpProdLine) obc.uniqueResult();
    if (attach == null) {
      return 10L;
    }
    return attach.getLineNo() + 10L;
  }

}
