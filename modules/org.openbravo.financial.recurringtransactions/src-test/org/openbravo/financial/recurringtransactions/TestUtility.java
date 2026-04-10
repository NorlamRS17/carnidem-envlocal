package org.openbravo.financial.recurringtransactions;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.base.secureApp.VariablesSecureApp;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.financial.recurringtransactions.utility.Utility;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.currency.Currency;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.coa.AccountingCombination;
import org.openbravo.model.financialmgmt.accounting.coa.AcctSchema;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.financialmgmt.gl.GLBatch;
import org.openbravo.model.financialmgmt.gl.GLCategory;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;

public class TestUtility {

	private static final String STANDARD_DESCRIPTION = "JUnit Test";
	private static final BigDecimal DR_AMOUNT = new BigDecimal("100");
	private static final BigDecimal CR_AMOUNT = new BigDecimal("100");
	private static final long LINE_10 = 10L;
	private static final long LINE_20 = 20L;

	public static void resetDatabase() {
		clearClones();
		clearTemplates();
		removeRecurringRules();
		resetJournals();
		removeDocumentType();
		removeSequence();
		OBDal.getInstance().commitAndClose();
	}

	static void removeRecurringRules() {
		OBCriteria<RecurringRule> ruleCrit = OBDal.getInstance()
				.createCriteria(RecurringRule.class);
		ruleCrit.add(Restrictions.eq(RecurringRule.PROPERTY_DESCRIPTION,
				STANDARD_DESCRIPTION));
		for (RecurringRule rate : ruleCrit.list()) {
			OBDal.getInstance().remove(rate);
		}
	}

	static void clearClones() {
		OBCriteria<GLJournal> jCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		jCrit.add(Restrictions.isNotNull(GLJournal.PROPERTY_OBRECTXGLJOURNAL));
		for (GLJournal j : jCrit.list()) {
			j.setObrectxGlJournal(null);
			OBDal.getInstance().save(j);
		}
	}

	static void clearTemplates() {
		OBCriteria<GLJournal> jCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		jCrit.add(Restrictions.eq(GLJournal.PROPERTY_OBRECTXRECURRING, true));
		jCrit.add(Restrictions.isNotNull(GLJournal.PROPERTY_OBRECTXRULE));
		for (GLJournal j : jCrit.list()) {
			j.setObrectxRule(null);
			j.setObrectxRecurring(null);
			OBDal.getInstance().save(j);
		}
	}

	static void resetJournals() {

		OBCriteria<GLJournalLine> lLineCrit = OBDal.getInstance()
				.createCriteria(GLJournalLine.class);
		lLineCrit.add(Restrictions.eq(GLJournalLine.PROPERTY_DESCRIPTION,
				STANDARD_DESCRIPTION));
		for (GLJournalLine line : lLineCrit.list()) {
			OBDal.getInstance().remove(line);
		}

		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_DESCRIPTION,
				STANDARD_DESCRIPTION));
		for (GLJournal hdr : lHdrCrit.list()) {
			OBDal.getInstance().remove(hdr);
		}

		OBCriteria<GLBatch> lBatchCrit = OBDal.getInstance().createCriteria(
				GLBatch.class);
		lBatchCrit.add(Restrictions.eq(GLBatch.PROPERTY_DESCRIPTION,
				STANDARD_DESCRIPTION));
		for (GLBatch batch : lBatchCrit.list()) {
			OBDal.getInstance().remove(batch);
		}

	}

	static void removeDocumentType() {
		OBCriteria<DocumentType> docCrit = OBDal.getInstance().createCriteria(
				DocumentType.class);
		docCrit.add(Restrictions.eq(DocumentType.PROPERTY_NAME,
				STANDARD_DESCRIPTION));
		for (DocumentType dt : docCrit.list()) {
			OBDal.getInstance().remove(dt);
		}
	}

	static void removeSequence() {
		OBCriteria<Sequence> seqCrit = OBDal.getInstance().createCriteria(
				Sequence.class);
		seqCrit.add(Restrictions.eq(Sequence.PROPERTY_NAME,
				STANDARD_DESCRIPTION));
		for (Sequence seq : seqCrit.list()) {
			OBDal.getInstance().remove(seq);
		}
	}

	static ProcessBundle getBundle() {
		OBContext obContext = OBContext.getOBContext();
		VariablesSecureApp vars = new VariablesSecureApp(obContext.getUser()
				.getId(), obContext.getCurrentClient().getId(), obContext
				.getCurrentOrganization().getId(), obContext.getRole().getId(),
				obContext.getLanguage().getLanguage());
		ProcessBundle bundle = new ProcessBundle(STANDARD_DESCRIPTION, vars);
		bundle.setProcessClass(RecurringTransactionsProcessor.class);
		bundle.setLog(new ProcessLogger(bundle.getConnection()));
		return bundle;
	}

	private static Client getClient() {
		OBCriteria<Client> lCrit = OBDal.getInstance().createCriteria(
				Client.class);
		lCrit.add(Restrictions.eq(Client.PROPERTY_NAME,
				"F&B International Group"));
		return lCrit.list().get(0);
	}

	private static Organization getOrganization() {
		OBCriteria<Organization> lCrit = OBDal.getInstance().createCriteria(
				Organization.class);
		lCrit.add(Restrictions.eq(Organization.PROPERTY_NAME, "F&B US, Inc."));
		return lCrit.list().get(0);
	}

	private static Organization getOrganization(String pName) {
		OBCriteria<Organization> lCrit = OBDal.getInstance().createCriteria(
				Organization.class);
		lCrit.add(Restrictions.eq(Organization.PROPERTY_NAME, pName));
		return lCrit.list().get(0);
	}

	private static Table getTable(String pName) {
		OBCriteria<Table> lCrit = OBDal.getInstance().createCriteria(
				Table.class);
		lCrit.add(Restrictions.eq(Table.PROPERTY_DBTABLENAME, pName));
		return lCrit.list().get(0);
	}

	public static RecurringRule getRule(String pName) {
		OBCriteria<RecurringRule> lCrit = OBDal.getInstance().createCriteria(
				RecurringRule.class);
		lCrit.add(Restrictions.eq(RecurringRule.PROPERTY_NAME, pName));
		return lCrit.list().get(0);
	}

	private static Organization getStarOrganization() {
		OBCriteria<Organization> lCrit = OBDal.getInstance().createCriteria(
				Organization.class);
		lCrit.add(Restrictions.eq(Organization.PROPERTY_ID, "0"));
		return lCrit.list().get(0);
	}

	private static AcctSchema getAccountingSchema() {
		OBCriteria<AcctSchema> lCrit = OBDal.getInstance().createCriteria(
				AcctSchema.class);
		lCrit.add(Restrictions.eq(AcctSchema.PROPERTY_NAME,
				"F&B International Group US/A/US Dollar"));
		return lCrit.list().get(0);
	}

	private static GLCategory getGLCategory() {
		OBCriteria<GLCategory> lCrit = OBDal.getInstance().createCriteria(
				GLCategory.class);
		lCrit.add(Restrictions.eq(GLCategory.PROPERTY_ID,
				"EDA7B85AF9A5486D9B00CAFFD3B86FC2"));
		return lCrit.list().get(0);
	}

	private static Currency getCurrency() {
		OBCriteria<Currency> lCrit = OBDal.getInstance().createCriteria(
				Currency.class);
		lCrit.add(Restrictions.eq(Currency.PROPERTY_ISOCODE, "USD"));
		return lCrit.list().get(0);
	}

	private static Calendar getCalendar() {
		OBCriteria<Calendar> lCrit = OBDal.getInstance().createCriteria(
				Calendar.class);
		lCrit.add(Restrictions.eq(Calendar.PROPERTY_ID,
				"2EDC8590A1AA42169A2E1AA22BCD2F6E"));
		return lCrit.list().get(0);
	}

	private static DocumentType getDocumentType() {
		OBCriteria<DocumentType> lCrit = OBDal.getInstance().createCriteria(
				DocumentType.class);
		lCrit.add(Restrictions.eq(DocumentType.PROPERTY_ID,
				"14D9C21B80A2423385064813AF413D3B"));
		return lCrit.list().get(0);
	}

	public static DocumentType getDocumentType(String pOrgName, String pDocName) {
		Organization lOrg = getOrganization(pOrgName);
		OBCriteria<DocumentType> lCrit = OBDal.getInstance().createCriteria(
				DocumentType.class);
		lCrit.add(Restrictions.eq(DocumentType.PROPERTY_ORGANIZATION, lOrg));
		lCrit.add(Restrictions.eq(DocumentType.PROPERTY_NAME, pDocName));
		return lCrit.list().get(0);
	}

	private static AccountingCombination getDRAccount() {
		OBCriteria<AccountingCombination> lCrit = OBDal.getInstance()
				.createCriteria(AccountingCombination.class);
		lCrit.add(Restrictions.eq(AccountingCombination.PROPERTY_ID,
				"0F60EA2FA3BC4A3E8E496C44D0F4ED9D"));
		return lCrit.list().get(0);
	}

	private static AccountingCombination getCRAccount() {
		OBCriteria<AccountingCombination> lCrit = OBDal.getInstance()
				.createCriteria(AccountingCombination.class);
		lCrit.add(Restrictions.eq(AccountingCombination.PROPERTY_ID,
				"3FFEE9F6E6A544E9BE219BDDD5AC55FB"));
		return lCrit.list().get(0);
	}

	private static Sequence getBatchSequence() {
		OBCriteria<Sequence> lCrit = OBDal.getInstance().createCriteria(
				Sequence.class);
		lCrit.add(Restrictions.eq(Sequence.PROPERTY_NAME,
				"DocumentNo_GL_JournalBatch"));
		return lCrit.list().get(0);
	}

	public static Sequence createDocumentSequence(boolean pAutoNumbering,
			String pPrefix, String pSuffix) {
		Sequence lSeq = OBProvider.getInstance().get(Sequence.class);
		lSeq.setClient(getClient());
		lSeq.setOrganization(getStarOrganization());
		lSeq.setName(STANDARD_DESCRIPTION);
		lSeq.setIncrementBy(1L);
		lSeq.setNextAssignedNumber(1000L);
		lSeq.setAutoNumbering(pAutoNumbering);
		lSeq.setPrefix(pPrefix);
		lSeq.setSuffix(pSuffix);
		OBDal.getInstance().save(lSeq);
		return lSeq;
	}

	public static DocumentType createDocumentType(String pOrgName,
			Sequence pSeq, String pTableName) {
		DocumentType lType = OBProvider.getInstance().get(DocumentType.class);
		lType.setClient(getClient());
		lType.setOrganization(getOrganization(pOrgName));
		lType.setName(STANDARD_DESCRIPTION);
		lType.setPrintText(STANDARD_DESCRIPTION);
		lType.setDocumentCategory("ARI");
		lType.setSequencedDocument(pSeq != null);
		lType.setDocumentSequence(pSeq);
		lType.setGLCategory(getGLCategory());
		lType.setTable(pTableName != null ? getTable(pTableName) : null);
		OBDal.getInstance().save(lType);
		return lType;
	}

	private static GLBatch createBatch(String pDesc) {
		GLBatch lBatch = OBProvider.getInstance().get(GLBatch.class);
		lBatch.setClient(getClient());
		lBatch.setOrganization(getOrganization());
		lBatch.setDocumentNo(Utility.getDocumentNo(getBatchSequence()));
		lBatch.setDescription((pDesc != null) ? pDesc : STANDARD_DESCRIPTION);
		lBatch.setGLCategory(getGLCategory());
		lBatch.setCurrency(getCurrency());
		lBatch.setDocumentDate(getDate("2013-09-25"));
		lBatch.setAccountingDate(lBatch.getDocumentDate());
		lBatch.setPeriod(Utility.getPeriod(getCalendar(),
				lBatch.getDocumentDate()));
		lBatch.setTotalDebitAmount(DR_AMOUNT);
		lBatch.setTotalDebitAmount(CR_AMOUNT);
		OBDal.getInstance().save(lBatch);
		return lBatch;
	}

	private static GLJournal createHeader(GLBatch pBatch, String pDesc,
			RecurringRule pRule) {
		GLJournal lHdr = OBProvider.getInstance().get(GLJournal.class);
		lHdr.setClient(pBatch.getClient());
		lHdr.setOrganization(pBatch.getOrganization());
		lHdr.setDocumentNo(Utility.getDocumentNo(getDocumentType(), null));
		lHdr.setJournalBatch(pBatch);
		lHdr.setAccountingSchema(getAccountingSchema());
		lHdr.setDocumentType(getDocumentType());
		lHdr.setDescription((pDesc != null) ? pDesc : STANDARD_DESCRIPTION);
		lHdr.setGLCategory(pBatch.getGLCategory());
		lHdr.setCurrency(pBatch.getCurrency());
		lHdr.setDocumentDate(pBatch.getDocumentDate());
		lHdr.setAccountingDate(pBatch.getDocumentDate());
		lHdr.setPeriod(Utility.getPeriod(getCalendar(),
				pBatch.getDocumentDate()));
		lHdr.setTotalDebitAmount(BigDecimal.ZERO);
		lHdr.setTotalDebitAmount(BigDecimal.ZERO);
		lHdr.setPostingType("A");
		lHdr.setObrectxRecurring(pRule != null);
		lHdr.setObrectxRule(pRule);
		OBDal.getInstance().save(lHdr);
		return lHdr;
	}

	private static void createLines(GLJournal pHeader) {

		GLJournalLine lLine10 = OBProvider.getInstance().get(
				GLJournalLine.class);
		lLine10.setClient(pHeader.getClient());
		lLine10.setOrganization(pHeader.getOrganization());
		lLine10.setJournalEntry(pHeader);
		lLine10.setLineNo(LINE_10);
		lLine10.setDescription(pHeader.getDescription());
		lLine10.setForeignCurrencyDebit(DR_AMOUNT);
		lLine10.setForeignCurrencyCredit(BigDecimal.ZERO);
		lLine10.setCurrency(pHeader.getCurrency());
		lLine10.setCurrencyRateType(pHeader.getCurrencyRateType());
		lLine10.setRate(pHeader.getRate());
		lLine10.setAccountingDate(pHeader.getAccountingDate());
		lLine10.setDebit(DR_AMOUNT);
		lLine10.setCredit(BigDecimal.ZERO);
		lLine10.setAccountingCombination(getDRAccount());
		OBDal.getInstance().save(lLine10);

		GLJournalLine lLine20 = OBProvider.getInstance().get(
				GLJournalLine.class);
		lLine20.setClient(pHeader.getClient());
		lLine20.setOrganization(pHeader.getOrganization());
		lLine20.setJournalEntry(pHeader);
		lLine20.setLineNo(LINE_20);
		lLine20.setDescription(pHeader.getDescription());
		lLine20.setForeignCurrencyDebit(BigDecimal.ZERO);
		lLine20.setForeignCurrencyCredit(CR_AMOUNT);
		lLine20.setCurrency(pHeader.getCurrency());
		lLine20.setCurrencyRateType(pHeader.getCurrencyRateType());
		lLine20.setRate(pHeader.getRate());
		lLine20.setAccountingDate(pHeader.getAccountingDate());
		lLine20.setDebit(BigDecimal.ZERO);
		lLine20.setCredit(CR_AMOUNT);
		lLine20.setAccountingCombination(getCRAccount());
		OBDal.getInstance().save(lLine20);

	}

	public static RecurringRule createRule(String pName, String pPeriodicity,
			Date pNextExecutionDate) {
		return createRule(pName, pPeriodicity, pNextExecutionDate, false);
	}

	public static RecurringRule createRule(String pName, String pPeriodicity,
			Date pNextExecutionDate, boolean pComplete) {
		RecurringRule lRule = OBProvider.getInstance().get(RecurringRule.class);
		lRule.setOrganization(getStarOrganization());
		lRule.setName(pName);
		lRule.setDescription(STANDARD_DESCRIPTION);
		lRule.setPeriodicity(pPeriodicity);
		lRule.setNextExecutionDate(pNextExecutionDate);
		lRule.setComplete(pComplete);
		OBDal.getInstance().save(lRule);
		return lRule;
	}

	public static RecurringRule createRule(String pName, Date pNextExecutionDate) {
		return createRule(pName, "MONTH", pNextExecutionDate);
	}

	public static void updateRule(String pName, Date pNextExecutionDate) {
		OBCriteria<RecurringRule> lCrit = OBDal.getInstance().createCriteria(
				RecurringRule.class);
		lCrit.add(Restrictions.eq(RecurringRule.PROPERTY_NAME, pName));
		RecurringRule lRule = lCrit.list().get(0);
		lRule.setNextExecutionDate(pNextExecutionDate);
		OBDal.getInstance().save(lRule);
	}

	public static GLJournal createTemplate(String pDesc) {
		GLBatch lBatch = createBatch(pDesc);
		GLJournal lHeader = createHeader(lBatch, pDesc, null);
		createLines(lHeader);
		return lHeader;
	}

	public static GLJournal createTemplate(String pDesc, RecurringRule pRule) {
		GLBatch lBatch = createBatch(pDesc);
		GLJournal lHeader = createHeader(lBatch, pDesc, pRule);
		createLines(lHeader);
		return lHeader;
	}

	public static GLJournal createTemplate(RecurringRule pRule) {
		GLBatch lBatch = createBatch(null);
		GLJournal lHeader = createHeader(lBatch, null, pRule);
		createLines(lHeader);
		return lHeader;
	}

	public static GLJournal useExistingTemplate(String pOrgName,
			boolean pComplete, RecurringRule pRule) {

		Organization lOrg = getOrganization(pOrgName);

		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_ORGANIZATION, lOrg));
		if (pComplete) {
			lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_DOCUMENTSTATUS,
					"CO"));
		} else {
			lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_DOCUMENTSTATUS,
					"DR"));
		}

		GLJournal lHdr = null;
		if (lHdrCrit.list().size() > 0) {
			lHdr = lHdrCrit.list().get(0);
		}

		lHdr.setObrectxRecurring(pRule != null);
		lHdr.setObrectxRule(pRule);
		OBDal.getInstance().save(lHdr);

		return lHdr;

	}

	public static GLJournal createTemplate() {
		return createTemplate(STANDARD_DESCRIPTION);
	}

	public static GLJournal getTemplate() {
		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_DESCRIPTION,
				STANDARD_DESCRIPTION));
		return lHdrCrit.list().get(0);
	}

	public static GLJournal getJournal(String pID) {
		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_ID, pID));
		return lHdrCrit.list().get(0);
	}

	public static int countClones(GLJournal pTemplate) {
		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_OBRECTXGLJOURNAL,
				pTemplate));
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_JOURNALBATCH,
				pTemplate.getJournalBatch()));
		return lHdrCrit.count();
	}

	public static GLJournal getJournalClone(String pTemplateID) {

		GLJournal lTemplate = getJournal(pTemplateID);

		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_OBRECTXGLJOURNAL,
				lTemplate));
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_JOURNALBATCH,
				lTemplate.getJournalBatch()));

		GLJournal lRes = null;
		if (lHdrCrit.count() > 0) {
			lRes = lHdrCrit.list().get(0);
		}

		return lRes;
	}

	public static boolean validateJournalClonesStatus(GLJournal pTemplate,
			boolean pComplete) {
		OBCriteria<GLJournal> lHdrCrit = OBDal.getInstance().createCriteria(
				GLJournal.class);
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_OBRECTXGLJOURNAL,
				pTemplate));
		lHdrCrit.add(Restrictions.eq(GLJournal.PROPERTY_JOURNALBATCH,
				pTemplate.getJournalBatch()));
		if (pComplete) {
			lHdrCrit.add(Restrictions.ne(GLJournal.PROPERTY_DOCUMENTSTATUS,
					"CO"));
		} else {
			lHdrCrit.add(Restrictions.ne(GLJournal.PROPERTY_DOCUMENTSTATUS,
					"DR"));
		}

		return (lHdrCrit.count() == 0);

	}

	public static TemplateType getTemplateType(String pName) {
		TemplateType lRes = null;
		try {
			OBContext.setAdminMode();
			OBCriteria<TemplateType> lCrit = OBDal.getInstance()
					.createCriteria(TemplateType.class);
			lCrit.add(Restrictions.eq(TemplateType.PROPERTY_NAME, pName));
			lRes = lCrit.list().get(0);
		} finally {
			OBContext.restorePreviousMode();
		}
		return lRes;
	}

	public static Date getDate(String dateStr) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
