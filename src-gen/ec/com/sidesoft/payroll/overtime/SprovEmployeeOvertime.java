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
 * All portions are Copyright (C) 2008-2014 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
*/
package ec.com.sidesoft.payroll.overtime;

import com.sidesoft.hrm.payroll.Shift;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SPROV_Employee_Overtime (stored in table Sprov_Employee_Overtime).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SprovEmployeeOvertime extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "Sprov_Employee_Overtime";
    public static final String ENTITY_NAME = "SPROV_Employee_Overtime";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_IDENTIFY = "identify";
    public static final String PROPERTY_BOSS = "boss";
    public static final String PROPERTY_DATEMOVEMENT = "datemovement";
    public static final String PROPERTY_ENTRY1 = "entry1";
    public static final String PROPERTY_EXIT1 = "exit1";
    public static final String PROPERTY_ENTRYDIAL1 = "entryDial1";
    public static final String PROPERTY_CHEKOUT1 = "chekOut1";
    public static final String PROPERTY_AUTHORIZEDTIME = "authorizedTime";
    public static final String PROPERTY_REASONGENERATIONTIME = "reasonGenerationTime";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SSPRSHIFT = "ssprShift";
    public static final String PROPERTY_INSERTSHIFT = "insertShift";
    public static final String PROPERTY_ENTRYTIMEPROCESSED = "entryTimeProcessed";
    public static final String PROPERTY_OUTPUTTIMEPROCESSED = "outputTimeProcessed";
    public static final String PROPERTY_FEEDVALUE = "feedValue";
    public static final String PROPERTY_WORKEDHOUR = "workedHour";
    public static final String PROPERTY_EARLYDISMISSALHOURS = "earlyDismissalHours";
    public static final String PROPERTY_VALIDATED = "validated";
    public static final String PROPERTY_PROCESSEDCHECK = "processedCheck";
    public static final String PROPERTY_TIMEVALUE25 = "timeValue25";
    public static final String PROPERTY_TIMEVALUE50 = "timeValue50";
    public static final String PROPERTY_TIMEVALUE100 = "timeValue100";
    public static final String PROPERTY_DELAY1 = "delay1";
    public static final String PROPERTY_GENERATEDTIME = "generatedTime";
    public static final String PROPERTY_TIME25 = "time25";
    public static final String PROPERTY_TIME50 = "time50";
    public static final String PROPERTY_TIME100 = "time100";
    public static final String PROPERTY_NONATTENDANCE = "nONAttendance";
    public static final String PROPERTY_SPROVNEWNESSLIST = "sprovNewnessList";

    public SprovEmployeeOvertime() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, "N");
        setDefaultValue(PROPERTY_INSERTSHIFT, false);
        setDefaultValue(PROPERTY_FEEDVALUE, new BigDecimal(0.00));
        setDefaultValue(PROPERTY_VALIDATED, false);
        setDefaultValue(PROPERTY_PROCESSEDCHECK, false);
        setDefaultValue(PROPERTY_NONATTENDANCE, false);
        setDefaultValue(PROPERTY_SPROVNEWNESSLIST, new ArrayList<Object>());
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getId() {
        return (String) get(PROPERTY_ID);
    }

    public void setId(String id) {
        set(PROPERTY_ID, id);
    }

    public Client getClient() {
        return (Client) get(PROPERTY_CLIENT);
    }

    public void setClient(Client client) {
        set(PROPERTY_CLIENT, client);
    }

    public Organization getOrganization() {
        return (Organization) get(PROPERTY_ORGANIZATION);
    }

    public void setOrganization(Organization organization) {
        set(PROPERTY_ORGANIZATION, organization);
    }

    public Boolean isActive() {
        return (Boolean) get(PROPERTY_ACTIVE);
    }

    public void setActive(Boolean active) {
        set(PROPERTY_ACTIVE, active);
    }

    public Date getCreationDate() {
        return (Date) get(PROPERTY_CREATIONDATE);
    }

    public void setCreationDate(Date creationDate) {
        set(PROPERTY_CREATIONDATE, creationDate);
    }

    public User getCreatedBy() {
        return (User) get(PROPERTY_CREATEDBY);
    }

    public void setCreatedBy(User createdBy) {
        set(PROPERTY_CREATEDBY, createdBy);
    }

    public Date getUpdated() {
        return (Date) get(PROPERTY_UPDATED);
    }

    public void setUpdated(Date updated) {
        set(PROPERTY_UPDATED, updated);
    }

    public User getUpdatedBy() {
        return (User) get(PROPERTY_UPDATEDBY);
    }

    public void setUpdatedBy(User updatedBy) {
        set(PROPERTY_UPDATEDBY, updatedBy);
    }

    public String getIdentify() {
        return (String) get(PROPERTY_IDENTIFY);
    }

    public void setIdentify(String identify) {
        set(PROPERTY_IDENTIFY, identify);
    }

    public BusinessPartner getBoss() {
        return (BusinessPartner) get(PROPERTY_BOSS);
    }

    public void setBoss(BusinessPartner boss) {
        set(PROPERTY_BOSS, boss);
    }

    public Date getDatemovement() {
        return (Date) get(PROPERTY_DATEMOVEMENT);
    }

    public void setDatemovement(Date datemovement) {
        set(PROPERTY_DATEMOVEMENT, datemovement);
    }

    public Timestamp getEntry1() {
        return (Timestamp) get(PROPERTY_ENTRY1);
    }

    public void setEntry1(Timestamp entry1) {
        set(PROPERTY_ENTRY1, entry1);
    }

    public Timestamp getExit1() {
        return (Timestamp) get(PROPERTY_EXIT1);
    }

    public void setExit1(Timestamp exit1) {
        set(PROPERTY_EXIT1, exit1);
    }

    public Timestamp getEntryDial1() {
        return (Timestamp) get(PROPERTY_ENTRYDIAL1);
    }

    public void setEntryDial1(Timestamp entryDial1) {
        set(PROPERTY_ENTRYDIAL1, entryDial1);
    }

    public Timestamp getChekOut1() {
        return (Timestamp) get(PROPERTY_CHEKOUT1);
    }

    public void setChekOut1(Timestamp chekOut1) {
        set(PROPERTY_CHEKOUT1, chekOut1);
    }

    public Timestamp getAuthorizedTime() {
        return (Timestamp) get(PROPERTY_AUTHORIZEDTIME);
    }

    public void setAuthorizedTime(Timestamp authorizedTime) {
        set(PROPERTY_AUTHORIZEDTIME, authorizedTime);
    }

    public SPROVExtraReasonMaint getReasonGenerationTime() {
        return (SPROVExtraReasonMaint) get(PROPERTY_REASONGENERATIONTIME);
    }

    public void setReasonGenerationTime(SPROVExtraReasonMaint reasonGenerationTime) {
        set(PROPERTY_REASONGENERATIONTIME, reasonGenerationTime);
    }

    public String getProcessed() {
        return (String) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(String processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    public Shift getSsprShift() {
        return (Shift) get(PROPERTY_SSPRSHIFT);
    }

    public void setSsprShift(Shift ssprShift) {
        set(PROPERTY_SSPRSHIFT, ssprShift);
    }

    public Boolean isInsertShift() {
        return (Boolean) get(PROPERTY_INSERTSHIFT);
    }

    public void setInsertShift(Boolean insertShift) {
        set(PROPERTY_INSERTSHIFT, insertShift);
    }

    public Timestamp getEntryTimeProcessed() {
        return (Timestamp) get(PROPERTY_ENTRYTIMEPROCESSED);
    }

    public void setEntryTimeProcessed(Timestamp entryTimeProcessed) {
        set(PROPERTY_ENTRYTIMEPROCESSED, entryTimeProcessed);
    }

    public Timestamp getOutputTimeProcessed() {
        return (Timestamp) get(PROPERTY_OUTPUTTIMEPROCESSED);
    }

    public void setOutputTimeProcessed(Timestamp outputTimeProcessed) {
        set(PROPERTY_OUTPUTTIMEPROCESSED, outputTimeProcessed);
    }

    public BigDecimal getFeedValue() {
        return (BigDecimal) get(PROPERTY_FEEDVALUE);
    }

    public void setFeedValue(BigDecimal feedValue) {
        set(PROPERTY_FEEDVALUE, feedValue);
    }

    public Timestamp getWorkedHour() {
        return (Timestamp) get(PROPERTY_WORKEDHOUR);
    }

    public void setWorkedHour(Timestamp workedHour) {
        set(PROPERTY_WORKEDHOUR, workedHour);
    }

    public Timestamp getEarlyDismissalHours() {
        return (Timestamp) get(PROPERTY_EARLYDISMISSALHOURS);
    }

    public void setEarlyDismissalHours(Timestamp earlyDismissalHours) {
        set(PROPERTY_EARLYDISMISSALHOURS, earlyDismissalHours);
    }

    public Boolean isValidated() {
        return (Boolean) get(PROPERTY_VALIDATED);
    }

    public void setValidated(Boolean validated) {
        set(PROPERTY_VALIDATED, validated);
    }

    public Boolean isProcessedCheck() {
        return (Boolean) get(PROPERTY_PROCESSEDCHECK);
    }

    public void setProcessedCheck(Boolean processedCheck) {
        set(PROPERTY_PROCESSEDCHECK, processedCheck);
    }

    public BigDecimal getTimeValue25() {
        return (BigDecimal) get(PROPERTY_TIMEVALUE25);
    }

    public void setTimeValue25(BigDecimal timeValue25) {
        set(PROPERTY_TIMEVALUE25, timeValue25);
    }

    public BigDecimal getTimeValue50() {
        return (BigDecimal) get(PROPERTY_TIMEVALUE50);
    }

    public void setTimeValue50(BigDecimal timeValue50) {
        set(PROPERTY_TIMEVALUE50, timeValue50);
    }

    public BigDecimal getTimeValue100() {
        return (BigDecimal) get(PROPERTY_TIMEVALUE100);
    }

    public void setTimeValue100(BigDecimal timeValue100) {
        set(PROPERTY_TIMEVALUE100, timeValue100);
    }

    public Timestamp getDelay1() {
        return (Timestamp) get(PROPERTY_DELAY1);
    }

    public void setDelay1(Timestamp delay1) {
        set(PROPERTY_DELAY1, delay1);
    }

    public Timestamp getGeneratedTime() {
        return (Timestamp) get(PROPERTY_GENERATEDTIME);
    }

    public void setGeneratedTime(Timestamp generatedTime) {
        set(PROPERTY_GENERATEDTIME, generatedTime);
    }

    public Timestamp getTime25() {
        return (Timestamp) get(PROPERTY_TIME25);
    }

    public void setTime25(Timestamp time25) {
        set(PROPERTY_TIME25, time25);
    }

    public Timestamp getTime50() {
        return (Timestamp) get(PROPERTY_TIME50);
    }

    public void setTime50(Timestamp time50) {
        set(PROPERTY_TIME50, time50);
    }

    public Timestamp getTime100() {
        return (Timestamp) get(PROPERTY_TIME100);
    }

    public void setTime100(Timestamp time100) {
        set(PROPERTY_TIME100, time100);
    }

    public Boolean isNONAttendance() {
        return (Boolean) get(PROPERTY_NONATTENDANCE);
    }

    public void setNONAttendance(Boolean nONAttendance) {
        set(PROPERTY_NONATTENDANCE, nONAttendance);
    }

    @SuppressWarnings("unchecked")
    public List<sprovnewness> getSprovNewnessList() {
      return (List<sprovnewness>) get(PROPERTY_SPROVNEWNESSLIST);
    }

    public void setSprovNewnessList(List<sprovnewness> sprovNewnessList) {
        set(PROPERTY_SPROVNEWNESSLIST, sprovNewnessList);
    }

}
