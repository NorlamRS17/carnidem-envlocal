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
package org.openbravo.financial.recurringtransactions;

import org.openbravo.base.provider.OBProvider;
import org.openbravo.dal.service.OBDal;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.test.base.BaseTest;

@SuppressWarnings("deprecation")
public class Issues extends BaseTest {

  protected void setUp() throws Exception {
    super.setUp();
    TestUtility.resetDatabase();
  }

  public void tearDown() throws Exception {
    TestUtility.resetDatabase();
    super.tearDown();
  }

  public void testIssue0002() {

    RecurringRule lRule = TestUtility.createRule("Issue0002", "MONTH",
        TestUtility.getDate("2013-09-25"), false);
    GLJournal lTemplate = TestUtility.useExistingTemplate("F&B US, Inc.", true, lRule);
    String lTemplateID = lTemplate.getId();
    OBDal.getInstance().commitAndClose();

    RecurringTransactionsProcessor proc = OBProvider.getInstance().get(
        RecurringTransactionsProcessor.class);
    ProcessBundle bundle = TestUtility.getBundle();
    try {
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();

    assertTrue(TestUtility.countClones(TestUtility.getJournal(lTemplateID)) == 1);
    assertTrue(TestUtility.validateJournalClonesStatus(TestUtility.getJournal(lTemplateID), false));

  }

  public void testIssue0003() {

    RecurringRule lRule = TestUtility.createRule("Issue0003", "MONTH",
        TestUtility.getDate("2013-09-25"), false);
    GLJournal lTemplate = TestUtility.createTemplate(lRule);
    String lTemplateID = lTemplate.getId();
    OBDal.getInstance().commitAndClose();

    RecurringTransactionsProcessor proc = OBProvider.getInstance().get(
        RecurringTransactionsProcessor.class);
    ProcessBundle bundle = TestUtility.getBundle();
    try {
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();

    assertTrue(TestUtility.countClones(TestUtility.getJournal(lTemplateID)) == 1);

    lTemplate = TestUtility.getJournal(lTemplateID);
    GLJournal lClone = TestUtility.getJournalClone(lTemplateID);

    assertTrue(lTemplate.getTotalCreditAmount().equals(lClone.getTotalCreditAmount()));
    assertTrue(lTemplate.getTotalDebitAmount().equals(lClone.getTotalDebitAmount()));

  }

  public void testIssue0004() {

    // setup rule with one template
    RecurringRule lRule = TestUtility.createRule("Issue0004", "MONTH",
        TestUtility.getDate("2015-05-30"), false);
    GLJournal lTemplateA = TestUtility.createTemplate("Issue0004-A", lRule);
    String lTemplateAID = lTemplateA.getId();
    OBDal.getInstance().commitAndClose();

    // process it
    RecurringTransactionsProcessor proc = OBProvider.getInstance().get(
        RecurringTransactionsProcessor.class);
    ProcessBundle bundle = TestUtility.getBundle();
    try {
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();

    // reset the date of the next execution rule
    TestUtility.updateRule("Issue0004", TestUtility.getDate("2015-05-30"));
    OBDal.getInstance().commitAndClose();

    // add another template to the rule
    lRule = TestUtility.getRule("Issue0004");
    GLJournal lTemplateB = TestUtility.createTemplate("Issue0004-B", lRule);
    String lTemplateBID = lTemplateB.getId();
    OBDal.getInstance().commitAndClose();

    // process rule - it is expected to skip the first template and process
    // the second
    proc = OBProvider.getInstance().get(RecurringTransactionsProcessor.class);
    bundle = TestUtility.getBundle();
    try {
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();

    // validate success by counting clones of A and B
    assertTrue(TestUtility.countClones(TestUtility.getJournal(lTemplateAID)) == 1);
    assertTrue(TestUtility.countClones(TestUtility.getJournal(lTemplateBID)) == 1);

  }

}
