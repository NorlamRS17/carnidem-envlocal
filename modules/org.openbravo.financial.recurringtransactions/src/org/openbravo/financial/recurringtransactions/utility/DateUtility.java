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

import java.util.Calendar;
import java.util.Date;

public class DateUtility {

  private enum Periodicity {
    DAY, MONTH, QUARTER, YEAR
  }

  public static Date nextExecutionDate(String pPeriodicity, Date pPrevDate) {

    Date lResult = null;
    Periodicity lPeriodicity = Periodicity.valueOf(pPeriodicity);

    switch (lPeriodicity) {
    case DAY:
      lResult = addDay(pPrevDate);
      break;
    case MONTH:
      lResult = addMonth(pPrevDate);
      break;
    case QUARTER:
      lResult = addQuarter(pPrevDate);
      break;
    case YEAR:
      lResult = addYear(pPrevDate);
      break;
    }

    return lResult;
  }

  static Calendar getCalendar() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal;
  }

  static Calendar getCalendar(Date pDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(pDate);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal;
  }

  static public Date dateBegin(Date pDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(pDate);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTime();
  }

  static public Date dateEnd(Date pDate) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(pDate);
    cal.set(Calendar.HOUR_OF_DAY, 23);
    cal.set(Calendar.MINUTE, 59);
    cal.set(Calendar.SECOND, 59);
    cal.set(Calendar.MILLISECOND, 999);
    return cal.getTime();
  }

  static public Date today() {
    Calendar cal = getCalendar();
    return cal.getTime();
  }

  static Date addDay(Date pDate) {
    Calendar cal = getCalendar(pDate);
    cal.add(Calendar.DATE, 1);
    return cal.getTime();
  }

  static Date addMonth(Date pDate) {
    Calendar cal = getCalendar(pDate);
    cal.add(Calendar.MONTH, 1);
    if (isLastDayOfMonth(pDate)) {
      cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
    }
    return cal.getTime();
  }

  static Date addQuarter(Date pDate) {
    Calendar cal = getCalendar(pDate);
    cal.add(Calendar.MONTH, 3);
    if (isLastDayOfMonth(pDate)) {
      cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
    }
    return cal.getTime();
  }

  static Date addYear(Date pDate) {
    Calendar cal = getCalendar(pDate);
    cal.add(Calendar.YEAR, 1);
    if (isLastDayOfMonth(pDate)) {
      cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
    }
    return cal.getTime();
  }

  static boolean isLastDayOfMonth(Date pDate) {
    boolean lResult = false;
    Calendar cal = getCalendar(pDate);
    if (cal.get(Calendar.DATE) >= cal.getActualMaximum(Calendar.DATE)) {
      lResult = true;
    }
    return lResult;
  }

}
