package ec.com.sidesoft.loaddata.into.accounting.entries.ad_process;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.database.ConnectionProvider;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.project.Project;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;
import org.openbravo.service.db.DalConnectionProvider;

import au.com.bytecode.opencsv.CSVReader;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.accounting.UserDimension1;
import org.openbravo.model.financialmgmt.accounting.UserDimension2;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.ElementValue;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.model.marketing.Campaign;
import org.apache.log4j.Logger;

@SuppressWarnings("unchecked")
public class ProcessFileManualEntries extends DalBaseProcess {

	  private static final Logger log = Logger.getLogger(ProcessFileManualEntries.class);
	  private static final String ATTACHMENT_TABLE_ID = "224"; // sproctm_imp_details

	  private OBError message;
	  private ConnectionProvider conn;
	  private VariablesSecureApp vars;
	  private String language;
	  private final String attachmentFolderPath =
	      OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");

	  @Override
	  protected void doExecute(ProcessBundle bundle) throws Exception {
	    vars = bundle.getContext().toVars();
	    conn = new DalConnectionProvider(false);
	    language = OBContext.getOBContext().getLanguage().getLanguage();
	    String recordId = (String) bundle.getParams().get("GL_Journal_ID");

	    try {
	      OBContext.setAdminMode(true);
	      message = new OBError();
	      processRequest(recordId);
	    } catch (Exception e) {
	      log.error("Error en ejecución de proceso", e);
	      message.setMessage(e.getMessage());
	      message.setTitle(Utility.messageBD(conn, "Error", language));
	      message.setType("Error");
	    } finally {
	      OBContext.restorePreviousMode();
	      bundle.setResult(message);
	    }
	  }

	  private void processRequest(String recordId) throws Exception {
	    String pathFile = getLocationFileCSV(recordId);
	    if (pathFile.isEmpty()) {
	      message.setMessage("No se encontró ningún archivo de tipo <b>CSV</b> en los adjuntos.");
	      message.setTitle(Utility.messageBD(conn, "Error", language));
	      message.setType("Error");
	      return;
	    }

	    GLJournal journal = OBDal.getInstance().get(GLJournal.class, recordId);

	    try (CSVReader reader = new CSVReader(
	        new InputStreamReader(new FileInputStream(pathFile), "UTF-8"),
	        ',', '\"', '\\', 0, false, true)) {

	      String[] header = reader.readNext();
	      if (header == null || header.length != 9) {
	        throw new OBException("El archivo CSV no tiene el número correcto de columnas (9).");
	      }

	      validateAndProcess(reader, journal);

	      message.setMessage("Proceso ejecutado correctamente");
	      message.setTitle(Utility.messageBD(conn, "ProcessOK", language));
	      message.setType("Success");

	    } catch (Exception e) {
	      log.error("Error procesando archivo CSV", e);
	      message.setMessage(e.getMessage());
	      message.setTitle(Utility.messageBD(conn, "Error", language));
	      message.setType("Error");
	    }
	  }

	  private void validateAndProcess(CSVReader reader, GLJournal journal) throws Exception {
	    long lineNo = 1;
	    long linetrx = 1; 
	    List<GLJournalLine> newLines = new ArrayList<>();

	    // Borrar líneas previas
	    journal.getFinancialMgmtGLJournalLineList().clear();
	    OBDal.getInstance().flush();

	    String[] rec;
	    while ((rec = reader.readNext()) != null) {
	      lineNo++;
	      if (rec.length < 9) continue;

	      // Validaciones
	      ElementValue account = findUnique(ElementValue.class, ElementValue.PROPERTY_SEARCHKEY, rec[0], lineNo, "Cuenta contable");
	      AccountingCombination acc = findUnique(AccountingCombination.class, AccountingCombination.PROPERTY_ACCOUNT, account, lineNo, "Combinacion Contable");
	      Costcenter cost = findOptional(Costcenter.class, Costcenter.PROPERTY_NAME, rec[4], lineNo, "Centro de Costo");
	      UserDimension1 dim1 = findOptional(UserDimension1.class, UserDimension1.PROPERTY_NAME, rec[5], lineNo, "Usuario");
	      UserDimension2 dim2 = findOptional(UserDimension2.class, UserDimension2.PROPERTY_NAME, rec[6], lineNo, "Usuario2");
	      BusinessPartner bp = findOptional(BusinessPartner.class, BusinessPartner.PROPERTY_TAXID, rec[7], lineNo, "Tercero");
	      Project project = findOptional(Project.class, Project.PROPERTY_NAME, rec[8], lineNo, "Proyecto");

	      Currency currency = journal.getOrganization().getCurrency();
	      validateDecimals(rec[1], rec[2], currency.getStandardPrecision().intValue(), lineNo);

	      // Construir línea
	      GLJournalLine line = OBProvider.getInstance().get(GLJournalLine.class);
	      line.setJournalEntry(journal);
	      line.setOrganization(journal.getOrganization());
	      line.setClient(journal.getClient());
	      line.setLineNo(linetrx * 10L);
	      line.setDescription(rec[3]);
	      line.setAccountingCombination(acc);
	      line.setCostCenter(cost);
	      line.setStDimension(dim1);
	      line.setNdDimension(dim2);
	      line.setProject(project);
	      line.setCurrency(currency);
	      line.setBusinessPartner(bp);

	      if (StringUtils.isNotBlank(rec[1])) {
	        BigDecimal debit = new BigDecimal(rec[1]);
	        line.setDebit(debit);
	        line.setForeignCurrencyDebit(debit);
	        line.setCredit(BigDecimal.ZERO);
	      } else if (StringUtils.isNotBlank(rec[2])) {
	        BigDecimal credit = new BigDecimal(rec[2]);
	        line.setCredit(credit);
	        line.setForeignCurrencyCredit(credit);
	        line.setDebit(BigDecimal.ZERO);
	      }

	      newLines.add(line);
	    }

	    // Guardar en batch
	    for (GLJournalLine l : newLines) {
	      OBDal.getInstance().save(l);
	    }
	    OBDal.getInstance().flush();
	  }

	  @SuppressWarnings("unchecked")
	  private <T extends BaseOBObject> T findUnique(Class<T> clazz, String property, Object value, long line, String msgval) {
	    if (StringUtils.isBlank(ObjectUtils.toString(value))) return null;
	    OBCriteria<T> criteria = OBDal.getInstance().createCriteria(clazz);
	    criteria.add(Restrictions.eq(property, value));
	    criteria.setMaxResults(1);
	    T result = (T) criteria.uniqueResult();
	    if (result == null) {
	      throw new OBException("Línea " + line + ": Valor no válido en " + msgval + " → " + value);
	    }
	    return result;
	  }
	  
	  @SuppressWarnings("unchecked")
	  private <T extends BaseOBObject> T findOptional(Class<T> clazz, String property, String value, long line, String msgval) {
	    //if (StringUtils.isBlank(value)) return null;
	    OBCriteria<T> criteria = OBDal.getInstance().createCriteria(clazz);
	    criteria.add(Restrictions.eq(property, value));
	    criteria.setMaxResults(1);
	    T result = (T) criteria.uniqueResult();
	    if (result == null && !(StringUtils.isBlank(value))) {
	      throw new OBException("Línea " + line + ": Valor no válido en " + msgval + " → " + value);
	    }
	    return result;
	  }

	  private void validateDecimals(String debit, String credit, int precision, long line) {
	    if (StringUtils.isNotBlank(debit) && hasTooManyDecimals(new BigDecimal(debit), precision)) {
	      throw new OBException("Línea " + line + ": Debe excede precisión máxima de decimales: " + precision);
	    }
	    if (StringUtils.isNotBlank(credit) && hasTooManyDecimals(new BigDecimal(credit), precision)) {
	      throw new OBException("Línea " + line + ": Haber excede precisión máxima de decimales: " + precision);
	    }
	  }

	  private String getLocationFileCSV(String recordId) {
	    OBCriteria<Attachment> obc = OBDal.getInstance().createCriteria(Attachment.class);
	    Table table = OBDal.getInstance().get(Table.class, ATTACHMENT_TABLE_ID);
	    obc.add(Restrictions.eq(Attachment.PROPERTY_RECORD, recordId));
	    obc.add(Restrictions.eq(Attachment.PROPERTY_TABLE, table));
	    obc.add(Restrictions.eq(Attachment.PROPERTY_DATATYPE, "text/csv"));
	    obc.setFilterOnReadableOrganization(false);

	    List<Attachment> attachments = obc.list();
	    if (attachments.size() > 1) {
	      throw new OBException("Existe más de un archivo CSV en adjuntos.");
	    }
	    if (attachments.isEmpty()) return "";
	    Attachment attach = attachments.get(0);
	    return attachmentFolderPath + "/" + attach.getPath() + '/' + attach.getName();
	  }

	  private static boolean hasTooManyDecimals(BigDecimal value, int maxDecimals) {
	    return value.stripTrailingZeros().scale() > maxDecimals;
	  }
	}
