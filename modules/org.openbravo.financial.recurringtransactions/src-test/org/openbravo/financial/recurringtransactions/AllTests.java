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

import junit.framework.Test;
import junit.framework.TestSuite;

import org.openbravo.financial.recurringtransactions.cloner.GLJournalClonerWB01;
import org.openbravo.financial.recurringtransactions.exception.FailToCompleteWB01;
import org.openbravo.financial.recurringtransactions.exception.PeriodNotFoundWB01;
import org.openbravo.financial.recurringtransactions.exception.SequenceNotAvailableWB01;
import org.openbravo.financial.recurringtransactions.utility.DateUtilityWB01;
import org.openbravo.financial.recurringtransactions.utility.UtilityWB01;

public class AllTests {

  public static Test suite() {
    final TestSuite suite = new TestSuite("Test for org.openbravo.financial.recurringtransactions");
    // $JUnit-BEGIN$

    // White box testing
    suite.addTestSuite(PeriodNotFoundWB01.class);
    suite.addTestSuite(SequenceNotAvailableWB01.class);
    suite.addTestSuite(FailToCompleteWB01.class);
    suite.addTestSuite(DateUtilityWB01.class);
    suite.addTestSuite(UtilityWB01.class);
    suite.addTestSuite(GLJournalClonerWB01.class);

    // Functional testing
    suite.addTestSuite(RecurringTransactionsProcessorFT01.class);

    // Issue resolution verification
    suite.addTestSuite(Issues.class);

    // $JUnit-END$
    return suite;
  }

}
