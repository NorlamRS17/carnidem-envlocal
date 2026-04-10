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

import java.util.Date;
import java.util.List;

import org.openbravo.base.exception.OBException;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.dal.service.OBDal;
import org.openbravo.financial.recurringtransactions.cloner.Cloner;
import org.openbravo.financial.recurringtransactions.utility.DateUtility;
import org.openbravo.financial.recurringtransactions.utility.Utility;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.scheduling.ProcessLogger;
import org.openbravo.service.db.DalBaseProcess;

/**
 * This class implements the Recurring Transactions Processor
 */
public class RecurringTransactionsProcessor extends DalBaseProcess {


  private ProcessLogger logger;

  public void doExecute(ProcessBundle bundle) throws Exception {
    // This is the main processor logic that:
    //   1) Retrieves the rules to be processed based on date
    //   2) For each rule retrieves the template types
    //   3) For each template type retrieves the templates
    //   4) Attempts to clone each template
    //
    // Please notice that it is necessary to commit and close the session
    // both after processing each template and, within a template, between the
    // clone action and the complete action.
    // Since committing and closes can potentially flush DAL objects, all the 
    // lists of objects to be processed are retrieved as IDs and the DAL object
    // is retrieved on demand. This approach is marginally less efficient as
    // it creates additional queries but it is necessary for transactional
    // integrity.

    logger = bundle.getLogger();

    logger.logln("Starting Recurring Transactions Processor.");

    List<String> lTypes = Utility.getTemplateTypes();

    // retrieve rules where next execution date is greater or equal today
    List<String> lRules = Utility.getRules();
    for (String lRuleId : lRules) {
      
      RecurringRule lRule = Utility.getRule(lRuleId);
      logger.logln(".  Processing rule: " + lRule.getName());

      for (String lTypeId : lTypes) {
        
        TemplateType lType = Utility.getTemplateType(lTypeId);
        logger.logln("..    Processing template type: " + lType.getName());

        // retrieve the templates for this rule and for this type. In case the template is defined
        // with an invalid table, skip the type
        List<String> lTemplates = null;
        try {
          lTemplates = Utility.getTemplates(lType, lRule);
          logger.logln("..      Number of templates to be processed: " + lTemplates.size());
        } catch (ClassNotFoundException e) {
          logger.logln("..      Template type associated with invalid entity: "
              + Utility.getEntityForTable(lType));
          logger.logln("..      Skipping.");
          continue;
        }

        for (String lTemplateId : lTemplates) {
          BaseOBObject lTemplate = Utility.getTemplate(lType, lTemplateId);
          logger.logln("...      Processing template: " + lTemplate.getIdentifier());

          Cloner lCloner = (Cloner) Class.forName(lType.getClonerJavaClass()).newInstance();
          lCloner.setTemplate(lTemplateId);

          if (lCloner.cloneExists(lRule.getNextExecutionDate())) {
            logger.logln("....      Template has already been processed - Skipping");
            continue;
          }
          try {
            String lClonedObjId = lCloner.clone(lRule.getNextExecutionDate());
            logger.logln("....        Successfully cloned.");
            OBDal.getInstance().commitAndClose();
            if(lRule.isComplete()) {
              lCloner.complete(lClonedObjId);
              OBDal.getInstance().commitAndClose();
              logger.logln("....        Successfully completed.");
            }
            logger.logln("....        Successfully processed.");
          } catch (OBException e) {
            logger.logln("....        Exception - " + e.getMessage() + " - Skipping");
            continue;
          }
        }
      }

      Date lNextExecutionDate = DateUtility.nextExecutionDate(lRule.getPeriodicity(),
          lRule.getNextExecutionDate());
      logger.logln("Next execution date: " + lNextExecutionDate.toString());
      lRule.setNextExecutionDate(lNextExecutionDate);
      OBDal.getInstance().save(lRule);
      OBDal.getInstance().commitAndClose();

    }

    logger.logln("Recurring Transactions Processor completed.");
  }


}
