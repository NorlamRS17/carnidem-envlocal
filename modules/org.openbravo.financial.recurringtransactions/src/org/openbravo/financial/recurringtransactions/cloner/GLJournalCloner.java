/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo.
 * The Initial Developer of the Original Code is Openbravo SLU
 * All portions are Copyright (C) 2013 Openbravo SLU
 * All Rights Reserved.
 ************************************************************************
 */
package org.openbravo.financial.recurringtransactions.cloner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.financial.recurringtransactions.exception.FailToComplete;
import org.openbravo.financial.recurringtransactions.utility.DateUtility;
import org.openbravo.financial.recurringtransactions.utility.Utility;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.model.financialmgmt.gl.GLJournalLine;
import org.openbravo.service.db.CallStoredProcedure;

public class GLJournalCloner extends Cloner {

  private final static String JOURNAL_COMPLETE_PROCESS = "GL_Journal_Post";

  public GLJournalCloner() {
    super();
  }

  public GLJournalCloner(String pTemplateId) {
    super(pTemplateId);
  }

  public String clone(Date pNewDate) {
    
    GLJournal lTemplate = getTemplateJournal();
    GLJournal lTarget = cloneHeader(lTemplate);

    // change attributes that need to be modified
    lTarget.setDocumentDate(pNewDate);
    lTarget.setAccountingDate(pNewDate);
    lTarget.setPeriod(Utility
        .getPeriod(lTemplate.getPeriod().getYear().getCalendar(), pNewDate));

    OBDal.getInstance().save(lTarget);

    List<GLJournalLine> lTemplateLines = lTemplate.getFinancialMgmtGLJournalLineList();
    for (GLJournalLine lTemplateLine : lTemplateLines) {
      GLJournalLine lTargetLine = cloneLine(lTemplateLine);
      lTargetLine.setJournalEntry(lTarget);
      OBDal.getInstance().save(lTargetLine);
    }

    return lTarget.getId();

  }

  public void complete(String pCloneObjId) {

    try {
      // Call GL_Journal_Post method from the database.
      final List<Object> parameters = new ArrayList<Object>();
      parameters.add(null);
      parameters.add(pCloneObjId);
      final String procedureName = JOURNAL_COMPLETE_PROCESS;
      CallStoredProcedure mm = CallStoredProcedure.getInstance();
      mm.call(procedureName, parameters, null, false, false);
    } catch (Exception e) {
      throw new FailToComplete(e.getCause().getMessage());
    }

  }

  public boolean cloneExists(Date pDate) {
    OBCriteria<GLJournal> lCrit = OBDal.getInstance().createCriteria(GLJournal.class);
    lCrit.add(Restrictions.eq(GLJournal.PROPERTY_OBRECTXGLJOURNAL, getTemplateJournal()));
    lCrit.add(Restrictions.between(GLJournal.PROPERTY_DOCUMENTDATE, DateUtility.dateBegin(pDate),
        DateUtility.dateEnd(pDate)));
    return lCrit.count() > 0;
  }

  GLJournal cloneHeader(GLJournal pTemplate) {
    GLJournal lTarget = OBProvider.getInstance().get(GLJournal.class);

    lTarget.setOrganization(pTemplate.getOrganization());
    lTarget.setDocumentNo(Utility.getDocumentNo(pTemplate.getDocumentType(), "GL_Journal"));
    lTarget.setStDimension(pTemplate.getStDimension());
    lTarget.setNdDimension(pTemplate.getNdDimension());
    lTarget.setSalesCampaign(pTemplate.getSalesCampaign());
    lTarget.setProduct(pTemplate.getProduct());
    lTarget.setBusinessPartner(pTemplate.getBusinessPartner());
    lTarget.setProject(pTemplate.getProject());
    lTarget.setCostCenter(pTemplate.getCostCenter());
    lTarget.setAsset(pTemplate.getAsset());
    lTarget.setAccountingSchema(pTemplate.getAccountingSchema());
    lTarget.setDocumentType(pTemplate.getDocumentType());
    lTarget.setApproved(pTemplate.isApproved());
    lTarget.setPrint(pTemplate.isPrint());
    lTarget.setDescription(pTemplate.getDescription());
    lTarget.setPostingType(pTemplate.getPostingType());
    lTarget.setGLCategory(pTemplate.getGLCategory());
    lTarget.setCurrency(pTemplate.getCurrency());
    lTarget.setCurrencyRateType(pTemplate.getCurrencyRateType());
    lTarget.setRate(pTemplate.getRate());
    lTarget.setJournalBatch(pTemplate.getJournalBatch());
    lTarget.setTotalDebitAmount(BigDecimal.ZERO);
    lTarget.setTotalCreditAmount(BigDecimal.ZERO);
    lTarget.setControlAmount(pTemplate.getControlAmount());
    lTarget.setOpening(pTemplate.isOpening());
    lTarget.setObrectxGlJournal(pTemplate);

    return lTarget;
  }

  GLJournalLine cloneLine(GLJournalLine lSource) {

    GLJournalLine lTarget = OBProvider.getInstance().get(GLJournalLine.class);

    lTarget.setOrganization(lSource.getOrganization());
    lTarget.setStDimension(lSource.getStDimension());
    lTarget.setNdDimension(lSource.getNdDimension());
    lTarget.setSalesCampaign(lSource.getSalesCampaign());
    lTarget.setActivity(lSource.getActivity());
    lTarget.setProduct(lSource.getProduct());
    lTarget.setBusinessPartner(lSource.getBusinessPartner());
    lTarget.setProject(lSource.getProject());
    lTarget.setCostCenter(lSource.getCostCenter());
    lTarget.setAsset(lSource.getAsset());
    lTarget.setLineNo(lSource.getLineNo());
    lTarget.setGenerated(lSource.isGenerated());
    lTarget.setDescription(lSource.getDescription());
    lTarget.setForeignCurrencyDebit(lSource.getForeignCurrencyDebit());
    lTarget.setForeignCurrencyCredit(lSource.getForeignCurrencyCredit());
    lTarget.setCurrency(lSource.getCurrency());
    lTarget.setCurrencyRateType(lSource.getCurrencyRateType());
    lTarget.setRate(lSource.getRate());
    lTarget.setAccountingDate(lSource.getAccountingDate());
    lTarget.setDebit(lSource.getDebit());
    lTarget.setCredit(lSource.getCredit());
    lTarget.setUOM(lSource.getUOM());
    lTarget.setQuantity(lSource.getQuantity());
    lTarget.setAccountingCombination(lSource.getAccountingCombination());
    lTarget.setPayment(lSource.getPayment());
    lTarget.setWithholding(lSource.getWithholding());
    lTarget.setTax(lSource.getTax());

    return lTarget;
  }

  private GLJournal getTemplateJournal() {
    OBCriteria<GLJournal> lCrit = OBDal.getInstance().createCriteria(GLJournal.class);
    lCrit.add(Restrictions.eq(GLJournal.PROPERTY_ID, this.mTemplateId));
    return lCrit.list().get(0);
  }

}
