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
package org.openbravo.financial.recurringtransactions.exception;

import org.openbravo.base.exception.OBException;
import org.openbravo.erpCommon.utility.OBMessageUtils;

public class SequenceNotAvailable extends OBException {

  private static final long serialVersionUID = 1L;
  private static final String SEQUENCE_NOT_AVAILABLE = "NextSequenceNoError";

  public SequenceNotAvailable() {
    super(OBMessageUtils.messageBD(SEQUENCE_NOT_AVAILABLE));
  }

}
