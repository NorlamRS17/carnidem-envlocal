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
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class DateUtilityWB01 extends TestCase {

  public void testGetCalendar01() {
    Calendar cal = DateUtility.getCalendar();
    Calendar ref = Calendar.getInstance();
    assertTrue(cal.get(Calendar.DATE) == ref.get(Calendar.DATE));
  }

  public void testGetCalendar02() {
    Calendar cal = DateUtility.getCalendar(getDate("2013-09-30"));
    assertTrue(cal.get(Calendar.MONTH) == Calendar.SEPTEMBER);
  }

  public void testToday() {
    Date res = DateUtility.today();
    assertTrue(daysDifference(res, DateUtility.getCalendar().getTime()) == 0);
  }

  public void testIsLastDayOfTheMonth01() {
    assertTrue(!DateUtility.isLastDayOfMonth(getDate("2013-09-05")));
  }

  public void testIsLastDayOfTheMonth02() {
    assertTrue(DateUtility.isLastDayOfMonth(getDate("2013-02-28")));
  }

  public void testAddDay() {
    Date res = DateUtility.addDay(getDate("2013-09-30"));
    assertTrue(daysDifference(res, getDate("2013-09-30")) == 1);
  }

  public void testAddMonth01() {
    Date res = DateUtility.addMonth(getDate("2013-09-04"));
    assertTrue(daysDifference(res, getDate("2013-10-04")) == 0);
  }

  public void testAddMonth02() {
    Date res = DateUtility.addMonth(getDate("2013-09-30"));
    assertTrue(daysDifference(res, getDate("2013-10-31")) == 0);
  }

  public void testAddQuarter01() {
    Date res = DateUtility.addQuarter(getDate("2013-01-05"));
    assertTrue(daysDifference(res, getDate("2013-04-05")) == 0);
  }

  public void testAddQuarter02() {
    Date res = DateUtility.addQuarter(getDate("2013-03-31"));
    assertTrue(daysDifference(res, getDate("2013-06-30")) == 0);
  }

  public void testAddQuarter03() {
    Date res = DateUtility.addQuarter(getDate("2013-02-28"));
    assertTrue(daysDifference(res, getDate("2013-05-31")) == 0);
  }

  public void testAddQuarter04() {
    Date res = DateUtility.addQuarter(getDate("2013-12-28"));
    assertTrue(daysDifference(res, getDate("2014-03-28")) == 0);
  }

  public void testAddYear01() {
    Date res = DateUtility.addYear(getDate("2013-05-28"));
    assertTrue(daysDifference(res, getDate("2014-05-28")) == 0);
  }

  public void testAddYear02() {
    Date res = DateUtility.addYear(getDate("2015-12-31"));
    assertTrue(daysDifference(res, getDate("2016-12-31")) == 0);
  }

  public void testNextExecutionDate01() {
    Date res = DateUtility.nextExecutionDate("DAY", getDate("2013-09-04"));
    assertTrue(daysDifference(res, getDate("2013-09-05")) == 0);
  }

  public void testNextExecutionDate02() {
    Date res = DateUtility.nextExecutionDate("MONTH", getDate("2013-09-04"));
    assertTrue(daysDifference(res, getDate("2013-10-04")) == 0);
  }

  public void testNextExecutionDate03() {
    Date res = DateUtility.nextExecutionDate("QUARTER", getDate("2013-09-04"));
    assertTrue(daysDifference(res, getDate("2013-12-04")) == 0);
  }

  public void testNextExecutionDate04() {
    Date res = DateUtility.nextExecutionDate("YEAR", getDate("2013-09-04"));
    assertTrue(daysDifference(res, getDate("2014-09-04")) == 0);
  }

  private int daysDifference(Date a, Date b) {
    long diff = a.getTime() - b.getTime(); // in milliseconds
    long diffDays = diff / (24 * 60 * 60 * 1000); // in days
    return (int) diffDays;
  }

  private static Date getDate(String dateStr) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    try {
      return df.parse(dateStr);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
