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
package org.openbravo.financial.recurringtransactions.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.dal.service.OBQuery;
import org.openbravo.financial.recurringtransactions.RecurringRule;
import org.openbravo.financial.recurringtransactions.TemplateType;
import org.openbravo.financial.recurringtransactions.exception.PeriodNotFound;
import org.openbravo.financial.recurringtransactions.exception.SequenceNotAvailable;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.financialmgmt.calendar.Period;

public class Utility {
  
  private static final String PROPERTY_OBRECTXRULE = "obrectxRule";
  private static final String OBJ_PROPERTY_ID = "id";

  public static Period getPeriod(Calendar pCal, Date pDate) {

    final StringBuilder lWhereClause = new StringBuilder();
    lWhereClause.append(" as p");
    lWhereClause.append(" where p.year.calendar.id = ?");
    lWhereClause.append("   and p.periodType = 'S'");
    lWhereClause.append("   and ? between p.startingDate and p.endingDate");

    final List<Object> lParams = new ArrayList<Object>();
    lParams.add(pCal.getId());
    lParams.add(pDate);

    final OBQuery<Period> lQuery = OBDal.getInstance().createQuery(Period.class,
        lWhereClause.toString());
    lQuery.setParameters(lParams);

    if (lQuery.count() == 0) {
      throw new PeriodNotFound();
    }

    return lQuery.list().get(0);
  }

  public static String getDocumentNo(Sequence pSeq) {
    String lNextDocNumber = "";

    if (pSeq != null && pSeq.isAutoNumbering()) {
      if (pSeq.getPrefix() != null)
        lNextDocNumber = pSeq.getPrefix();
      lNextDocNumber += pSeq.getNextAssignedNumber().toString();
      if (pSeq.getSuffix() != null)
        lNextDocNumber += pSeq.getSuffix();
      pSeq.setNextAssignedNumber(pSeq.getNextAssignedNumber() + pSeq.getIncrementBy());
      OBDal.getInstance().save(pSeq);
    }

    if (lNextDocNumber.equals(""))
      throw new SequenceNotAvailable();

    return lNextDocNumber;
  }

  public static String getDocumentNo(DocumentType pDocType, String pTableName) {
    Sequence lSeq = null;
    if (pDocType != null) {
      lSeq = pDocType.getDocumentSequence();
      if (lSeq == null && (pDocType.getTable() != null || pTableName != null)) {
        OBCriteria<Sequence> obcSeq = OBDal.getInstance().createCriteria(Sequence.class);
        String lTableName = (pDocType.getTable() != null) ? pDocType.getTable().toString()
            : pTableName;
        obcSeq.add(Restrictions.eq(Sequence.PROPERTY_NAME, lTableName));
        if (obcSeq != null && obcSeq.list().size() > 0) {
          lSeq = obcSeq.list().get(0);
        }
      }
    }
    return getDocumentNo(lSeq);
  }

  
  /**
   * Get the lists of template types defined in AD. Needs to run in admin mode
   * 
   * @return template types defined in AD
   */
  public static List<String> getTemplateTypes() {
    List<String> lRes = new ArrayList<String>();
    try {
      OBContext.setAdminMode();
      OBCriteria<TemplateType> lCrit = OBDal.getInstance().createCriteria(TemplateType.class);
      for (TemplateType type: lCrit.list()) {
        lRes.add(type.getId());
      }
    } finally {
      OBContext.restorePreviousMode();
    }
    return lRes;
  }

  public static TemplateType getTemplateType(String pTypeId) {
    TemplateType lRes = null;
    try {
      OBContext.setAdminMode();  
      OBCriteria<TemplateType> lCrit = OBDal.getInstance().createCriteria(
        TemplateType.class);
      lCrit.add(Restrictions.eq(TemplateType.PROPERTY_ID, pTypeId));
      lRes = lCrit.list().get(0);
    } finally {
      OBContext.restorePreviousMode();
    }
    return lRes;
  }
  

  public static RecurringRule getRule(String pRuleId) {
    OBCriteria<RecurringRule> lCrit = OBDal.getInstance().createCriteria(
        RecurringRule.class);
    lCrit.add(Restrictions.eq(RecurringRule.PROPERTY_ID, pRuleId));
    return lCrit.list().get(0);
  }
  
  /**
   * Get the list of rules that are ready to be processed, which is the list with the next execution
   * date in the past
   * 
   * @return Rules to be processed
   */
  public static List<String> getRules() {
    List<String> lRes = new ArrayList<String>();
    OBCriteria<RecurringRule> lCrit = OBDal.getInstance().createCriteria(RecurringRule.class);
    lCrit.add(Restrictions.le(RecurringRule.PROPERTY_NEXTEXECUTIONDATE, DateUtility.today()));
    for (RecurringRule rule: lCrit.list()) {
      lRes.add(rule.getId());
    }
    return lRes;
  }

  /**
   * Get the templates for the given template type and recurring rule
   * 
   * @param pType
   * @param pRule
   * @return
   * @throws ClassNotFoundException
   */
  public static List<String> getTemplates(TemplateType pType, RecurringRule pRule)
      throws ClassNotFoundException {
    List<String> lRes = new ArrayList<String>();
    OBCriteria<BaseOBObject> lCrit = OBDal.getInstance().createCriteria(Utility.getEntityForTable(pType));
    lCrit.add(Restrictions.eq(PROPERTY_OBRECTXRULE, pRule));
    for (BaseOBObject obj: lCrit.list()) {
      lRes.add((String)obj.getId());
    }
    return lRes;
  }

  
  public static BaseOBObject getTemplate(TemplateType pType, String pTemplateId) {
    OBCriteria<BaseOBObject> lCrit = OBDal.getInstance().createCriteria(getEntityForTable(pType));
    lCrit.add(Restrictions.eq(OBJ_PROPERTY_ID, pTemplateId));
    return lCrit.list().get(0);
  }
  
  /**
   * Returns the entity associated with the table of the Template Type. Needs to run in admin mode
   * 
   * @param pType
   * @return Entity
   */
  public static String getEntityForTable(TemplateType pType) {
    String lRes = null;
    try {
      OBContext.setAdminMode();
      lRes = pType.getTable().getName();
    } finally {
      OBContext.restorePreviousMode();
    }
    return lRes;
  }

}
