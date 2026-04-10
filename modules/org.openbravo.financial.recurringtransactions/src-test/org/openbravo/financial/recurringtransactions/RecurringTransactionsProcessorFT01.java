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
public class RecurringTransactionsProcessorFT01 extends BaseTest {

  protected void setUp() throws Exception {
    super.setUp();
    TestUtility.resetDatabase();
  }

  public void tearDown() throws Exception {
    TestUtility.resetDatabase();
    super.tearDown();
  }

  /**
   * Test no recurring rules
   */
  public void testFT01() {
    RecurringTransactionsProcessor proc = OBProvider.getInstance().get(
        RecurringTransactionsProcessor.class);
    ProcessBundle bundle = TestUtility.getBundle();
    try {
      System.out.print("01----\n");
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();
    assertTrue(true);
  }

  /**
   * Test one recurring rule and no templates
   */
  public void testFT02() {

    TestUtility.createRule("TestFT02", "MONTH", TestUtility.getDate("2013-09-25"));
    OBDal.getInstance().commitAndClose();

    RecurringTransactionsProcessor proc = OBProvider.getInstance().get(
        RecurringTransactionsProcessor.class);
    ProcessBundle bundle = TestUtility.getBundle();
    try {
      System.out.print("02----\n");
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();

    RecurringRule lRule = TestUtility.getRule("TestFT02");
    assertTrue(lRule.getNextExecutionDate().compareTo(TestUtility.getDate("2013-10-25")) == 0);
  }

  /**
   * Test one recurring rule and one template
   */
  public void testFT03() {

    RecurringRule lRule = TestUtility.createRule("TestFT03", TestUtility.getDate("2013-09-25"));
    GLJournal lTemplate = TestUtility.createTemplate(lRule);
    OBDal.getInstance().commitAndClose();

    RecurringTransactionsProcessor proc = OBProvider.getInstance().get(
        RecurringTransactionsProcessor.class);
    ProcessBundle bundle = TestUtility.getBundle();
    try {
      System.out.print("03----\n");
      proc.doExecute(bundle);
      System.out.print(bundle.getLogger().getLog());
    } catch (Exception e) {
      e.printStackTrace();
    }
    OBDal.getInstance().commitAndClose();

    assertTrue(TestUtility.countClones(lTemplate) == 1);
  }

}
