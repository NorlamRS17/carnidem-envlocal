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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.hcm.SalaryCategory;
import org.openbravo.model.project.Project;
import org.openbravo.model.project.ProjectPhase;
import org.openbravo.model.project.ProjectTask;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import au.com.bytecode.opencsv.CSVReader;
import ec.com.sidesoft.projects.complement.SproctmImpDetails;
import ec.com.sidesoft.projects.complement.SproctmImpDetailsLn;
import ec.com.sidesoft.projects.complement.SproctmTaskCif;
import ec.com.sidesoft.projects.complement.SproctmTaskMachine;
import ec.com.sidesoft.projects.complement.SproctmTaskWorkforce;

public class ProcessFileDetails extends DalBaseProcess {

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
    String recordId = (String) bundle.getParams().get("Sproctm_Imp_Details_ID");
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

      SproctmImpDetails record = OBDal.getInstance().get(SproctmImpDetails.class, recordId);

      // validateData(pathFile, record);
      try {
        CSVReader reader = new CSVReader(
            new InputStreamReader(new FileInputStream(pathFile), "UTF-8"), ',', '\"', '\\', 0,
            false, true);

        // read line by line
        String[] rec = null;
        String[] columnFile = null;

        StringBuffer buffer = new StringBuffer(); // default size 9
        // skip header row
        columnFile = reader.readNext();
        int icount = 1;
        // Validacion del numero de columnas de la plantilla
        if (columnFile.length >= 8) {
          while ((rec = reader.readNext()) != null) {
            String msgValidation = null;
            if (rec.length > 1 || rec[0].length() > 0) {
              // Proyecto
              OBContext.setAdminMode(true);

              OBCriteria<Project> obc = OBDal.getInstance().createCriteria(Project.class);
              Organization org = record.getOrganization(); // .getId().toString();
              obc.add(Restrictions.eq(Project.PROPERTY_NAME, rec[0].toString()));
              obc.add(Restrictions.eq(Project.PROPERTY_ORGANIZATION, org));
              obc.setMaxResults(1);
              OBContext.setAdminMode(false);

              Project projectS = (Project) obc.uniqueResult();

              if (projectS == null) {
                msgValidation = "No existe el proyecto " + rec[0].toString()
                    + " para la organización " + org.getName().toString()
                    + " ingresado en el archivo csv.\n";

                createLineLog(record, msgValidation);
                throw new OBException(msgValidation);

              }

              // Fase
              OBContext.setAdminMode(true);

              OBCriteria<ProjectPhase> pp = OBDal.getInstance().createCriteria(ProjectPhase.class);
              pp.add(Restrictions.eq(ProjectPhase.PROPERTY_PROJECT, projectS));
              pp.add(Restrictions.eq(ProjectPhase.PROPERTY_NAME, rec[1].toString()));
              pp.setMaxResults(1);
              OBContext.setAdminMode(false);

              ProjectPhase phase = (ProjectPhase) pp.uniqueResult();

              if (phase == null) {
                msgValidation = "No existe la fase " + rec[1].toString()
                    + " ingresado en el archivo csv.\n";
                createLineLog(record, msgValidation);
                throw new OBException(msgValidation);

              }
              // Tarea
              OBContext.setAdminMode(true);

              OBCriteria<ProjectTask> ppt = OBDal.getInstance().createCriteria(ProjectTask.class);
              ppt.add(Restrictions.eq(ProjectTask.PROPERTY_PROJECTPHASE, phase));
              ppt.add(Restrictions.eq(ProjectTask.PROPERTY_NAME, rec[2].toString()));
              ppt.setMaxResults(1);
              OBContext.setAdminMode(false);

              ProjectTask task = (ProjectTask) ppt.uniqueResult();

              if (task == null) {
                msgValidation = "No existe la tarea " + rec[2].toString()
                    + " ingresado en el archivo csv.\n";
                createLineLog(record, msgValidation);
                throw new OBException(msgValidation);
              }

              // SalaryCategory - verificar si la categoria salarial
              SalaryCategory vSalaryCategory = ValidateData.getcategSalaryF(rec[3].toString());
              if (vSalaryCategory == null) {

                msgValidation = "No existe la categoria salarial  " + rec[3]
                    + ", verifique el nombre en la ventana de mantenimiento.\n";
                createLineLog(record, msgValidation);
                throw new OBException(msgValidation);
              }
              // verificar si existe en el tab Mano de obra la categoria salarial.
              OBContext.setAdminMode(true);

              OBCriteria<SproctmTaskWorkforce> wf = OBDal.getInstance()
                  .createCriteria(SproctmTaskWorkforce.class);
              wf.add(Restrictions.eq(SproctmTaskWorkforce.PROPERTY_PROJECTTASK, task));
              wf.add(
                  Restrictions.eq(SproctmTaskWorkforce.PROPERTY_SALARYCATEGORY, vSalaryCategory));
              wf.setMaxResults(1);
              OBContext.setAdminMode(false);

              SproctmTaskWorkforce mo = (SproctmTaskWorkforce) wf.uniqueResult();

              if (mo == null) {
                msgValidation = "No existe la categoria salarial " + rec[3].toString()
                    + " en las linea " + icount + ".\n";
                createLineLog(record, msgValidation);
                throw new OBException(msgValidation);

              }
              // Verificar si existe el tercero
              BusinessPartner partner = ValidateData.getPartnerF(rec[4].toString());
              if (partner == null) {
                msgValidation = "No existe el tercero  " + rec[4]
                    + ", por favor verifique el nombre del tercero.\n";
                createLineLog(record, msgValidation);
                throw new OBException(msgValidation);
              }
              // Numero Horas
              Double hoursP = Double.parseDouble(rec[5]);
              // Fecha
              String fechaP = rec[6];
              // Import in tab CIF
              Boolean cifP = ((rec[7].toUpperCase()).equals("SI")) ? true : false;
              // Import in tab MAQ
              Boolean maqP = ((rec[8].toUpperCase()).equals("SI")) ? true : false;

              if (!buffer.toString().isEmpty()) {
                createLineLog(record, buffer.toString());
                buffer.setLength(0);
              } else {

              /*  if (icount == 1) {
                  if (task == null) {
                    icount = 0;
                  } else {
                    PreparedStatement st = null;
                    String mo_tab = "83F24776D39D4610B7EF526595637FB8";
                    String cif_tab = "A90091007133407B9B18313ADA90129D";
                    String maq_tab = "B42A0EDE7ADF407A9A4BF59C7B480A14";

                    // ELIMINAR POR LOS TRES TABS MO -CIF - MAQ
                    String deleteDetailsMO = "DELETE FROM sproctm_detail_cost WHERE record_id in "
                        + " (select Sproctm_Task_Workforce_ID FROM Sproctm_Task_Workforce Where c_projecttask_id = '"
                        + task.getId() + "' AND ad_tab_id  = '" + mo_tab + "'  ) "
                        + " AND sproctm_detail_cost_id not in (select c.sproctm_detail_cost_id from sproctm_settl_cost_ln c "
                        + " WHERE c.sproctm_detail_cost_id = sproctm_detail_cost_id ) ";
                    st = conn.getPreparedStatement(deleteDetailsMO);
                    st.execute();
                    String deleteDetailsCIF = "DELETE FROM sproctm_detail_cost WHERE record_id in "
                        + " (select Sproctm_Task_cif_ID FROM Sproctm_Task_cif Where c_projecttask_id = '"
                        + task.getId() + "' AND ad_tab_id  = '" + cif_tab + "'  ) "
                        + " AND sproctm_detail_cost_id not in (select c.sproctm_detail_cost_id from sproctm_settl_cost_ln c "
                        + " WHERE c.sproctm_detail_cost_id = sproctm_detail_cost_id ) ";
                    st = conn.getPreparedStatement(deleteDetailsCIF);
                    st.execute();
                    String deleteDetailsMAQ = "DELETE FROM sproctm_detail_cost WHERE record_id in "
                        + " (select Sproctm_Task_machine_ID FROM Sproctm_Task_machine Where c_projecttask_id = '"
                        + task.getId() + "' AND ad_tab_id  = '" + maq_tab + "'  ) "
                        + " AND sproctm_detail_cost_id not in (select c.sproctm_detail_cost_id from sproctm_settl_cost_ln c "
                        + " WHERE c.sproctm_detail_cost_id = sproctm_detail_cost_id ) ";
                    st = conn.getPreparedStatement(deleteDetailsMAQ);
                    st.execute();
                    st.close();
                  }
                }
                */
                if (task != null) {
                  createDetail(record, projectS, phase, task, vSalaryCategory, partner, hoursP,
                      fechaP, cifP, maqP, mo.getId());
                  if (cifP) {
                    createDetailCif(record, projectS, phase, task, vSalaryCategory, partner, hoursP,
                        fechaP, cifP, maqP, mo.getId());
                  }
                  if (maqP) {
                    createDetailMaq(record, projectS, phase, task, vSalaryCategory, partner, hoursP,
                        fechaP, cifP, maqP, mo.getId());
                  }
                }

              }
            }
            icount++;
          }

          reader.close();
        } else {
          buffer.append(
              "El contenido del archivo CSV no es válido revise que las columnas esten completas.\n");
          createLineLog(record, buffer.toString());
          buffer.setLength(0);
        }
        record.setStatus("PR");
        typeM = "Success";
        titleM = "ProcessOK";

        message.setMessage(messageT);
        message.setTitle(Utility.messageBD(conn, titleM, language));
        message.setType(typeM);

      } catch (Exception e) {
        createLineLog(record, e.toString());
        message.setMessage(e.getMessage());
        message.setTitle(Utility.messageBD(conn, "Error", language));
        message.setType("Error");
      }

    }

    return;

  }

  public String getLocationFileCSV(String recordId) throws OBException {
    OBContext.setAdminMode(true);
    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
    final Table table = OBDal.getInstance().get(Table.class, "3D653C58DBAB44ADB3F16C7DE2C6C80D"); // sproctm_imp_details
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

  public void createDetail(SproctmImpDetails headImpor, Project project, ProjectPhase phase,
      ProjectTask task, SalaryCategory salaryCategory, BusinessPartner partner, double hours_p,
      String date_p, boolean importInCif_p, boolean importInMaq_p, String rec_id) throws Exception {

    try {
      StringBuffer buffer = new StringBuffer();

      OBContext.setAdminMode(true);

      // deleteLineImport(headImpor);

      PreparedStatement st = null;
      // CREATE NEW DETAIL IN MO - CIF OR MAQ
      String c_project_id = project.getId().toString();
      String c_projectphase_id = phase.getId().toString();
      String c_projecttask_id = task.getId().toString();

      String categSalary_id = (salaryCategory != null) ? salaryCategory.getId().toString() : null;
      String partner_id = (partner != null) ? partner.getId().toString() : null;
      String strAD_UserID = vars.getUser().toString();
      String strAD_OrgID = vars.getOrg().toString();
      String strAD_ClientID = vars.getClient().toString();

      String record_id = rec_id != null ? rec_id : null;

      String mo_tab = "83F24776D39D4610B7EF526595637FB8";

      if (categSalary_id == null) {
        buffer
            .append("No se encontró la categoria salarial " + salaryCategory.PROPERTY_NAME + " \n");
        createLineLog(headImpor,
            "No se encontró la categoria salarial " + salaryCategory.PROPERTY_NAME);
      }

      if (c_project_id == null || c_projectphase_id == null || c_projecttask_id == null) {
        buffer.append(
            "No se ha especificado la tarea donde se importará los datos del archivo csv. \n");
        createLineLog(headImpor, "No se encontró la tarea " + task.PROPERTY_NAME);
      } else {

        String sql = "INSERT INTO sproctm_detail_cost( "
            + " sproctm_detail_cost_id, ad_client_id, ad_org_id, isactive, created, createdby, "
            + " updated, updatedby, " + " record_id, c_bpartner_id, hours, date, cost, total_cost, "
            + " status, posted, settlement, complete, " + " ad_tab_id) " + " VALUES (get_uuid(), '"
            + strAD_ClientID + "' , '" + strAD_OrgID + "', 'Y', " + " now(), '" + strAD_UserID
            + "', now(), '" + strAD_UserID + "', " + " '" + record_id + "','" + partner_id + "' , "
            + hours_p + ", '" + date_p + "'::date , 0, 0, 'DR', 'N', 'N', 'DR' " + " , '" + mo_tab
            + "' ) ";

        st = conn.getPreparedStatement(sql);
        st.execute();
        String v_sum_sql = "select sum(hours) from sproctm_detail_cost WHERE record_id = '"
            + record_id + "'";
        String sql_update_mo = " UPDATE sproctm_task_workforce SET  QTY_Budget = (" + v_sum_sql
            + ") , Total_Cost_Budget = (cost_unit_standar * (" + v_sum_sql
            + "))  WHERE sproctm_task_workforce_id = '" + record_id + "'  ";

        st = conn.getPreparedStatement(sql_update_mo);
        st.execute();

        st.close();

      }

      OBDal.getInstance().flush();
      OBContext.setAdminMode(false);
    } catch (Exception e) {

      createLineLog(headImpor, e.toString());
      conn.destroy();
      throw new OBException(Utility.messageBD(conn, e.getMessage(), language));

    }
  }

  public void createDetailCif(SproctmImpDetails headImpor, Project project, ProjectPhase phase,
      ProjectTask task, SalaryCategory salaryCategory, BusinessPartner partner, double hours_p,
      String date_p, boolean importInCif_p, boolean importInMaq_p, String rec_id) throws Exception {

    String strAD_UserID = vars.getUser().toString();
    String strAD_OrgID = vars.getOrg().toString();
    String strAD_ClientID = vars.getClient().toString();
    String c_project_id = project.getId().toString();
    String c_projectphase_id = phase.getId().toString();
    String c_projecttask_id = task.getId().toString();

    String partner_id = (partner != null) ? partner.getId().toString() : null;

    String cif_tab = "A90091007133407B9B18313ADA90129D";

    for (SproctmTaskCif cif : task.getSproctmTaskCifList()) {
      try {
        StringBuffer buffer = new StringBuffer();

        OBContext.setAdminMode(true);

        //deleteLineImport(headImpor);

        PreparedStatement st = null;
        // CREATE NEW DETAIL IN MO - CIF OR MAQ
        if (c_project_id == null || c_projectphase_id == null || c_projecttask_id == null) {
          buffer.append(
              "No se ha especificado la tarea donde se importará los datos del archivo csv. \n");
          createLineLog(headImpor, "No se encontró la tarea " + task.PROPERTY_NAME);
        } else {

          String sql = "INSERT INTO sproctm_detail_cost( "
              + " sproctm_detail_cost_id, ad_client_id, ad_org_id, isactive, created, createdby, "
              + " updated, updatedby, "
              + " record_id, c_bpartner_id, hours, date, cost, total_cost, "
              + " status, posted, settlement, complete, " + " ad_tab_id) "
              + " VALUES (get_uuid(), '" + strAD_ClientID + "' , '" + strAD_OrgID + "', 'Y', "
              + " now(), '" + strAD_UserID + "', now(), '" + strAD_UserID + "', " + " '"
              + cif.getId() + "','" + partner_id + "' , " + hours_p + ", '" + date_p
              + "'::date , 0, 0, 'DR', 'N', 'N', 'DR' " + " , '" + cif_tab + "' ) ";

          st = conn.getPreparedStatement(sql);
          st.execute();
          st.close();

        }

        OBDal.getInstance().flush();
        OBContext.setAdminMode(false);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        createLineLog(headImpor, e.toString());
        conn.destroy();

      }

    }

  }

  public void createDetailMaq(SproctmImpDetails headImpor, Project project, ProjectPhase phase,
      ProjectTask task, SalaryCategory salaryCategory, BusinessPartner partner, double hours_p,
      String date_p, boolean importInCif_p, boolean importInMaq_p, String rec_id) throws Exception {

    String strAD_UserID = vars.getUser().toString();
    String strAD_OrgID = vars.getOrg().toString();
    String strAD_ClientID = vars.getClient().toString();
    String c_project_id = project.getId().toString();
    String c_projectphase_id = phase.getId().toString();
    String c_projecttask_id = task.getId().toString();

    String partner_id = (partner != null) ? partner.getId().toString() : null;

    String maq_tab = "B42A0EDE7ADF407A9A4BF59C7B480A14";

    for (SproctmTaskMachine maq : task.getSproctmTaskMachineList()) {
      try {
        StringBuffer buffer = new StringBuffer();

        OBContext.setAdminMode(true);

        //deleteLineImport(headImpor);

        PreparedStatement st = null;
        // CREATE NEW DETAIL IN MO - CIF OR MAQ
        if (c_project_id == null || c_projectphase_id == null || c_projecttask_id == null) {
          buffer.append(
              "No se ha especificado la tarea donde se importará los datos del archivo csv. \n");
          createLineLog(headImpor, "No se encontró la tarea " + task.PROPERTY_NAME);
        } else {

          String sql = "INSERT INTO sproctm_detail_cost( "
              + " sproctm_detail_cost_id, ad_client_id, ad_org_id, isactive, created, createdby, "
              + " updated, updatedby, "
              + " record_id, c_bpartner_id, hours, date, cost, total_cost, "
              + " status, posted, settlement, complete, " + " ad_tab_id) "
              + " VALUES (get_uuid(), '" + strAD_ClientID + "' , '" + strAD_OrgID + "', 'Y', "
              + " now(), '" + strAD_UserID + "', now(), '" + strAD_UserID + "', " + " '"
              + maq.getId() + "','" + partner_id + "' , " + hours_p + ", '" + date_p
              + "'::date , 0, 0, 'DR', 'N', 'N', 'DR' " + " , '" + maq_tab + "' ) ";

          st = conn.getPreparedStatement(sql);
          st.execute();
          st.close();

        }

        OBDal.getInstance().flush();
        OBContext.setAdminMode(false);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        createLineLog(headImpor, e.toString());
        conn.destroy();

      }

    }

  }

  public void createLineLog(SproctmImpDetails head, String msg) throws Exception {
    try {
      SproctmImpDetailsLn lineLog = OBProvider.getInstance().get(SproctmImpDetailsLn.class);
      lineLog.setSproctmImpDetails(head); // setSproctmImpProducts(head);
      lineLog.setLOGProcess(truncate(msg, 4000));
      lineLog.setLine(getSequenceLI(head));

      OBDal.getInstance().save(lineLog);
      OBDal.getInstance().flush();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void deleteLineImport(SproctmImpDetails record) throws Exception {

    try {
      OBCriteria<SproctmImpDetailsLn> obc = OBDal.getInstance()
          .createCriteria(SproctmImpDetailsLn.class);
      obc.add(Restrictions.eq(SproctmImpDetailsLn.PROPERTY_SPROCTMIMPDETAILS, record));
      if (obc.count() > 0) {
        for (SproctmImpDetailsLn dataLine : obc.list()) {
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

  public Long getSequenceLI(SproctmImpDetails head) throws OBException {
    OBCriteria<SproctmImpDetailsLn> obc = OBDal.getInstance()
        .createCriteria(SproctmImpDetailsLn.class);
    obc.add(Restrictions.eq(SproctmImpDetailsLn.PROPERTY_SPROCTMIMPDETAILS, head));
    obc.addOrderBy(SproctmImpDetailsLn.PROPERTY_LINE, false);
    obc.setFilterOnReadableOrganization(false);
    obc.setMaxResults(1);
    SproctmImpDetailsLn attach = (SproctmImpDetailsLn) obc.uniqueResult();
    if (attach == null) {
      return 10L;
    }
    return attach.getLine() + 10L;
  }

}
