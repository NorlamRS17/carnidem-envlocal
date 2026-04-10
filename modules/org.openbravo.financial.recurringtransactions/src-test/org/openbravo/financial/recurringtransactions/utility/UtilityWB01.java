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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.financial.recurringtransactions.RecurringRule;
import org.openbravo.financial.recurringtransactions.TemplateType;
import org.openbravo.financial.recurringtransactions.TestUtility;
import org.openbravo.financial.recurringtransactions.exception.PeriodNotFound;
import org.openbravo.financial.recurringtransactions.exception.SequenceNotAvailable;
import org.openbravo.model.ad.utility.Sequence;
import org.openbravo.model.common.enterprise.DocumentType;
import org.openbravo.model.financialmgmt.calendar.Calendar;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.test.base.BaseTest;

@SuppressWarnings("deprecation")
public class UtilityWB01 extends BaseTest {

  private static final String STANDARD_DESCRIPTION = "JUnit Test";

  public void setUp() throws Exception {
    super.setUp();
    TestUtility.resetDatabase();
  }

  public void tearDown() throws Exception {
    TestUtility.resetDatabase();
  }

  public void testGetPeriod01() {
    Calendar lCal = getCalendar();
    Period lPer = Utility.getPeriod(lCal, getDate("2013-09-25"));
    assertTrue(lPer.getName().equals("Sep-13"));
  }

  public void testGetPeriod02() {
    Calendar lCal = getCalendar();
    try {
      Utility.getPeriod(lCal, getDate("2999-09-25"));
    } catch (PeriodNotFound e) {
      assertTrue(true);
      return;
    }
    assertTrue(false);
  }

  public void testGetDocumentNo01() {
    TestUtility.createDocumentSequence(true, null, null);
    OBDal.getInstance().commitAndClose();
    OBCriteria<Sequence> lCrit = OBDal.getInstance().createCriteria(Sequence.class);
    lCrit.add(Restrictions.eq(Sequence.PROPERTY_NAME, STANDARD_DESCRIPTION));
    String lRes = Utility.getDocumentNo(lCrit.list().get(0));
    assertTrue(lRes.length() > 0);
  }

  public void testGetDocumentNo02() {
    try {
      Utility.getDocumentNo(null);
    } catch (SequenceNotAvailable e) {
      assertTrue(true);
      return;
    }
    assertTrue(false);
  }

  public void testGetDocumentNo03() {
    TestUtility.createDocumentSequence(false, null, null);
    OBDal.getInstance().commitAndClose();
    OBCriteria<Sequence> lCrit = OBDal.getInstance().createCriteria(Sequence.class);
    lCrit.add(Restrictions.eq(Sequence.PROPERTY_NAME, STANDARD_DESCRIPTION));
    try {
      Utility.getDocumentNo(lCrit.list().get(0));
    } catch (SequenceNotAvailable e) {
      assertTrue(true);
      return;
    }
    assertTrue(false);
  }

  public void testGetDocumentNo04() {
    TestUtility.createDocumentSequence(true, "A", "Z");
    OBDal.getInstance().commitAndClose();
    OBCriteria<Sequence> lCrit = OBDal.getInstance().createCriteria(Sequence.class);
    lCrit.add(Restrictions.eq(Sequence.PROPERTY_NAME, STANDARD_DESCRIPTION));
    String lRes = Utility.getDocumentNo(lCrit.list().get(0));
    assertTrue(lRes.length() > 0);
    assertTrue(lRes.startsWith("A"));
    assertTrue(lRes.endsWith("Z"));
  }

  /**
   * A document type that is not associated with a sequence raises the SequenceNotAvailalbe
   * exception
   */
  public void testGetDocumentNo05() {
    DocumentType lDocType = TestUtility.getDocumentType("F&B US, Inc.", "AP Invoice");
    try {
      Utility.getDocumentNo(lDocType, null);
    } catch (SequenceNotAvailable e) {
      assertTrue(true);
      return;
    }
    assertTrue(false);
  }

  public void testGetDocumentNo06() {
    DocumentType lDocType = TestUtility.getDocumentType("F&B US, Inc.", "AR Invoice");
    String lRes = Utility.getDocumentNo(lDocType, null);
    assertTrue(lRes.length() > 0);
  }

  public void testGetDocumentNo07() {
    TestUtility.createDocumentType("F&B US, Inc.", null, null);
    OBDal.getInstance().commitAndClose();
    DocumentType lDocType = TestUtility.getDocumentType("F&B US, Inc.", STANDARD_DESCRIPTION);
    String lRes = Utility.getDocumentNo(lDocType, "AR Invoice");
    assertTrue(lRes.length() > 0);
  }
  
  public void testGetTemplateTypes01() {
    List<String> lTypes = Utility.getTemplateTypes();
    assertTrue(lTypes != null && lTypes.size() > 0);
  }

  public void testGetTemplateType01() {
    List<String> lTypes = Utility.getTemplateTypes();
    TemplateType lType = Utility.getTemplateType(lTypes.get(0));
    assertTrue(lType != null);
  }

  public void testGetRule01() {
    String lRuleId = TestUtility.createRule("TestGetRule01", getDate("2015-05-30")).getId();
    OBDal.getInstance().commitAndClose();
    RecurringRule lRule = Utility.getRule(lRuleId);
    assertTrue(lRule != null);
  }

  public void testGetRules01() {
    TestUtility.createRule("TestGetRules01", TestUtility.getDate("2013-09-25"));
    OBDal.getInstance().commitAndClose();
    List<String> lRules = Utility.getRules();
    int lCount = 0;
    for (String lRuleId : lRules) {
      if (Utility.getRule(lRuleId).getDescription().equals(STANDARD_DESCRIPTION)) {
        lCount++;
      }
    }
    assertTrue(lCount > 0);
  }

  public void testGetRules02() {
    TestUtility.createRule("TestGetRules02",
        DateUtility.nextExecutionDate("YEAR", DateUtility.today()));
    OBDal.getInstance().commitAndClose();
    List<String> lRules = Utility.getRules();
    int lCount = 0;
    for (String lRuleId : lRules) {
      if (Utility.getRule(lRuleId).getDescription().equals(STANDARD_DESCRIPTION)) {
        lCount++;
      }
    }
    assertTrue(lCount == 0);
  }

  public void testGetEntityForTable01() {
    TemplateType t = TestUtility.getTemplateType("G/L Journal Header");
    String entity = Utility.getEntityForTable(t);
    assertTrue(entity.equals("FinancialMgmtGLJournal"));
  }

  public void testGetTemplates01() {
    RecurringRule lRule = TestUtility.createRule("TestGetTemplates01",
        TestUtility.getDate("2013-09-25"));
    TestUtility.createTemplate(lRule);
    OBDal.getInstance().commitAndClose();

    TemplateType lType = TestUtility.getTemplateType("G/L Journal Header");

    lRule = null;
    for (String iRuleId : Utility.getRules()) {
      RecurringRule iRule = Utility.getRule(iRuleId);
      if (iRule.getDescription().equals(STANDARD_DESCRIPTION)) {
        lRule = iRule;
        break;
      }
    }
    assertTrue(lRule != null);
    try {
      List<String> lTemplates = Utility.getTemplates(lType, lRule);
      assertTrue(lTemplates.size() == 1);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  public void testGetTemplate01() {
    RecurringRule lRule = TestUtility.createRule("TestGetTemplates01",
        TestUtility.getDate("2013-09-25"));
    String lTemplateId = TestUtility.createTemplate(lRule).getId();
    OBDal.getInstance().commitAndClose();

    TemplateType lType = TestUtility.getTemplateType("G/L Journal Header");
    
    BaseOBObject lTemplate = Utility.getTemplate(lType, lTemplateId);
    assertTrue(lTemplate.getEntityName().equals("FinancialMgmtGLJournal"));
  }
  //
  
  private static Calendar getCalendar() {
    OBCriteria<Calendar> lCrit = OBDal.getInstance().createCriteria(Calendar.class);
    lCrit.add(Restrictions.eq(Calendar.PROPERTY_ID, "2EDC8590A1AA42169A2E1AA22BCD2F6E"));
    return lCrit.list().get(0);
  }

  static Date getDate(String dateStr) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    try {
      return df.parse(dateStr);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
