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

import org.openbravo.dal.service.OBDal;
import org.openbravo.financial.recurringtransactions.TemplateType;
import org.openbravo.financial.recurringtransactions.TestUtility;
import org.openbravo.financial.recurringtransactions.utility.Utility;
import org.openbravo.model.financialmgmt.gl.GLJournal;
import org.openbravo.test.base.BaseTest;

@SuppressWarnings("deprecation")
public class GLJournalClonerWB01 extends BaseTest {

  protected void setUp() throws Exception {
    super.setUp();
    TestUtility.resetDatabase();
  }

  public void tearDown() throws Exception {
    TestUtility.resetDatabase();
    super.tearDown();
  }

  public void testConstructor01() {
    GLJournalCloner t = new GLJournalCloner(null);
    assertTrue(t != null);
  }

  public void testConstructor02() {
    String lTemplateId = TestUtility.createTemplate().getId();
    OBDal.getInstance().commitAndClose();
    GLJournalCloner t = new GLJournalCloner(lTemplateId);
    assertTrue(t != null);
  }

  public void testClone01() {
    String lTemplateId = TestUtility.createTemplate().getId();
    OBDal.getInstance().commitAndClose();
    GLJournalCloner t = new GLJournalCloner(lTemplateId);
    t.clone(TestUtility.getDate("2013-10-25"));
    OBDal.getInstance().commitAndClose();
    GLJournal lTemplate = (GLJournal) Utility.getTemplate(
        TestUtility.getTemplateType("G/L Journal Header"), lTemplateId);
    assertTrue(TestUtility.countClones(lTemplate) == 1);
  }

  public void testCloneExists01() {
    String lTemplateId = TestUtility.createTemplate().getId();
    OBDal.getInstance().commitAndClose();
    GLJournalCloner t = new GLJournalCloner(lTemplateId);
    t.clone(TestUtility.getDate("2013-10-25"));
    OBDal.getInstance().commitAndClose();
    lTemplateId = TestUtility.getTemplate().getId();
    t = new GLJournalCloner(lTemplateId);
    assertTrue(t.cloneExists(TestUtility.getDate("2013-10-25")));
  }

  public void testCloneExists02() {
    String lTemplateId = TestUtility.createTemplate().getId();
    OBDal.getInstance().commitAndClose();
    GLJournalCloner t = new GLJournalCloner(lTemplateId);
    t.clone(TestUtility.getDate("2013-10-25"));
    OBDal.getInstance().commitAndClose();
    lTemplateId = TestUtility.getTemplate().getId();
    t = new GLJournalCloner(lTemplateId);
    assertTrue(!t.cloneExists(TestUtility.getDate("2013-11-25")));
  }

  /**
   * Test the dynamic creation of the cloner class given a type
   */
  public void testDynamicCloner01() {
    TemplateType lType = TestUtility.getTemplateType("G/L Journal Header");
    Cloner lCloner = null;
    try {
      String lClassName = lType.getClonerJavaClass();
      lCloner = (Cloner) Class.forName(lClassName).newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      assertTrue(false);
      return;
    }
    assertTrue(lCloner != null);
  }

  /**
   * Test the dynamic creation of the cloner class given a type and assign it a template
   */
  public void testDynamicCloner02() {
    GLJournal template = TestUtility.createTemplate();
    OBDal.getInstance().commitAndClose();
    template = TestUtility.getTemplate();
    TemplateType lType = TestUtility.getTemplateType("G/L Journal Header");
    Cloner lCloner = null;
    try {
      String lClassName = lType.getClonerJavaClass();
      lCloner = (Cloner) Class.forName(lClassName).newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      assertTrue(false);
      return;
    }
    lCloner.setTemplate(template.getId());
    assertTrue(lCloner != null);
  }

  public void testComplete01() {
    GLJournal lTemplate = TestUtility.createTemplate("testComplete01"); // this is not going to be
                                                                        // reset
    String lTemplateID = lTemplate.getId();
    OBDal.getInstance().commitAndClose();
    lTemplate = TestUtility.getJournal(lTemplateID);
    GLJournalCloner t = new GLJournalCloner();
    assertTrue(lTemplate.getDocumentStatus().equals("DR"));
    t.complete(lTemplate.getId());
    OBDal.getInstance().commitAndClose();
    lTemplate = TestUtility.getJournal(lTemplateID);
    assertTrue(lTemplate.getDocumentStatus().equals("CO"));
  }

}
