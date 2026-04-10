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
 * The Original Code is Openbravo ERP. 
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2001-2018 Openbravo SLU
 * All Rights Reserved. 
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package ec.com.sidesoft.report.utility;

import org.apache.log4j.Logger;
import org.openbravo.dal.core.OBContext;

public class Utility {
  static Logger log4j = Logger.getLogger(Utility.class);

  public static String getUserIdLogin() {
    try {
      OBContext.setAdminMode();
      return OBContext.getOBContext().getUser().getId();
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  public static String getUserNameLogin() {
    try {
      OBContext.setAdminMode();
      return OBContext.getOBContext().getUser().getUsername();
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  public static String getOrgIdLogin() {
    try {
      OBContext.setAdminMode();
      return OBContext.getOBContext().getCurrentOrganization().getId();
    } finally {
      OBContext.restorePreviousMode();
    }
  }

  public static String getOrgNameLogin() {
    try {
      OBContext.setAdminMode();
      return OBContext.getOBContext().getCurrentOrganization().getName();
    } finally {
      OBContext.restorePreviousMode();
    }
  }
}
