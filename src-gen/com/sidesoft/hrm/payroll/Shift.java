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
package com.sidesoft.hrm.payroll;

import com.sidesoft.ecuador.humanResources.sshrJob;
import com.sidesoft.hrm.payroll.biometrical.SPRBIArea;
import com.sidesoft.hrm.payroll.biometrical.SprbiDays;

import ec.com.sidesoft.payroll.overtime.SprovEmployeeOvertime;

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
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity SSPR_Shift (stored in table SSPR_Shift).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Shift extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSPR_Shift";
    public static final String ENTITY_NAME = "SSPR_Shift";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_STARTTIME = "starttime";
    public static final String PROPERTY_ENDTIME = "endtime";
    public static final String PROPERTY_ISLUNCH = "islunch";
    public static final String PROPERTY_LUNCHTIMEMIN = "lunchtimemin";
    public static final String PROPERTY_LUNCHTIMEMAX = "lunchtimemax";
    public static final String PROPERTY_SHIFTTYPE = "shifttype";
    public static final String PROPERTY_POSITION = "position";
    public static final String PROPERTY_SSHRHOURSTART = "sshrHourstart";
    public static final String PROPERTY_SSHRHOUREND = "sshrHourend";
    public static final String PROPERTY_ENTRY = "entry";
    public static final String PROPERTY_EXIT = "exit";
    public static final String PROPERTY_NAMEMOVEMENT = "nameMovement";
    public static final String PROPERTY_SPRBIAREA = "sPRBIArea";
    public static final String PROPERTY_SPRBIENTRYFROM = "sprbiEntryFrom";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_SPRBIENTRYUNTIL = "sprbiEntryUntil";
    public static final String PROPERTY_SPRBIEXITFROM = "sprbiExitFrom";
    public static final String PROPERTY_SPRBIEXITUNTIL = "sprbiExitUntil";
    public static final String PROPERTY_SPRBIMINUTEDELAYPARAMETER = "sprbiMinuteDelayParameter";
    public static final String PROPERTY_SPRBIOVERTIMEPARAMETER = "sprbiOvertimeParameter";
    public static final String PROPERTY_SPRBIFEEDPARAM = "sprbiFeedParam";
    public static final String PROPERTY_SPRBIFEEDVALUE = "sprbiFeedValue";
    public static final String PROPERTY_SPRBIHOURSMAXDAY = "sprbiHoursMaxDay";
    public static final String PROPERTY_SPRBIHOURSMAXWEEK = "sprbiHoursMaxWeek";
    public static final String PROPERTY_SPRBIHOURSMINWORKED = "sprbiHoursMinWorked";
    public static final String PROPERTY_SPRBIHOURSMAXMONTH = "sprbiHoursMaxMonth";
    public static final String PROPERTY_SPROVMINIMUMOVERTIME = "sprovMinimumOvertime";
    public static final String PROPERTY_SPROVWORKINGHOURS = "sprovWorkingHours";
    public static final String PROPERTY_SPRBICONFIGURATIONLINES = "sprbiConfigurationLines";
    public static final String PROPERTY_SPROVEMPLOYEEOVERTIMELIST = "sPROVEmployeeOvertimeList";
    public static final String PROPERTY_SSPRCONTRACTLIST = "sSPRContractList";
    public static final String PROPERTY_SPRBIDAYSLIST = "sprbiDaysList";
    public static final String PROPERTY_SSHRJOBLIST = "sshrJobList";

    public Shift() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISLUNCH, false);
        setDefaultValue(PROPERTY_SPRBICONFIGURATIONLINES, false);
        setDefaultValue(PROPERTY_SPROVEMPLOYEEOVERTIMELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSPRCONTRACTLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPRBIDAYSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SSHRJOBLIST, new ArrayList<Object>());
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

    public Timestamp getStarttime() {
        return (Timestamp) get(PROPERTY_STARTTIME);
    }

    public void setStarttime(Timestamp starttime) {
        set(PROPERTY_STARTTIME, starttime);
    }

    public Timestamp getEndtime() {
        return (Timestamp) get(PROPERTY_ENDTIME);
    }

    public void setEndtime(Timestamp endtime) {
        set(PROPERTY_ENDTIME, endtime);
    }

    public Boolean isLunch() {
        return (Boolean) get(PROPERTY_ISLUNCH);
    }

    public void setLunch(Boolean islunch) {
        set(PROPERTY_ISLUNCH, islunch);
    }

    public BigDecimal getLunchtimemin() {
        return (BigDecimal) get(PROPERTY_LUNCHTIMEMIN);
    }

    public void setLunchtimemin(BigDecimal lunchtimemin) {
        set(PROPERTY_LUNCHTIMEMIN, lunchtimemin);
    }

    public BigDecimal getLunchtimemax() {
        return (BigDecimal) get(PROPERTY_LUNCHTIMEMAX);
    }

    public void setLunchtimemax(BigDecimal lunchtimemax) {
        set(PROPERTY_LUNCHTIMEMAX, lunchtimemax);
    }

    public String getShifttype() {
        return (String) get(PROPERTY_SHIFTTYPE);
    }

    public void setShifttype(String shifttype) {
        set(PROPERTY_SHIFTTYPE, shifttype);
    }

    public Position getPosition() {
        return (Position) get(PROPERTY_POSITION);
    }

    public void setPosition(Position position) {
        set(PROPERTY_POSITION, position);
    }

    public Timestamp getSshrHourstart() {
        return (Timestamp) get(PROPERTY_SSHRHOURSTART);
    }

    public void setSshrHourstart(Timestamp sshrHourstart) {
        set(PROPERTY_SSHRHOURSTART, sshrHourstart);
    }

    public Timestamp getSshrHourend() {
        return (Timestamp) get(PROPERTY_SSHRHOUREND);
    }

    public void setSshrHourend(Timestamp sshrHourend) {
        set(PROPERTY_SSHRHOUREND, sshrHourend);
    }

    public Timestamp getEntry() {
        return (Timestamp) get(PROPERTY_ENTRY);
    }

    public void setEntry(Timestamp entry) {
        set(PROPERTY_ENTRY, entry);
    }

    public Timestamp getExit() {
        return (Timestamp) get(PROPERTY_EXIT);
    }

    public void setExit(Timestamp exit) {
        set(PROPERTY_EXIT, exit);
    }

    public String getNameMovement() {
        return (String) get(PROPERTY_NAMEMOVEMENT);
    }

    public void setNameMovement(String nameMovement) {
        set(PROPERTY_NAMEMOVEMENT, nameMovement);
    }

    public SPRBIArea getSPRBIArea() {
        return (SPRBIArea) get(PROPERTY_SPRBIAREA);
    }

    public void setSPRBIArea(SPRBIArea sPRBIArea) {
        set(PROPERTY_SPRBIAREA, sPRBIArea);
    }

    public Timestamp getSprbiEntryFrom() {
        return (Timestamp) get(PROPERTY_SPRBIENTRYFROM);
    }

    public void setSprbiEntryFrom(Timestamp sprbiEntryFrom) {
        set(PROPERTY_SPRBIENTRYFROM, sprbiEntryFrom);
    }

    public String getValue() {
        return (String) get(PROPERTY_VALUE);
    }

    public void setValue(String value) {
        set(PROPERTY_VALUE, value);
    }

    public Timestamp getSprbiEntryUntil() {
        return (Timestamp) get(PROPERTY_SPRBIENTRYUNTIL);
    }

    public void setSprbiEntryUntil(Timestamp sprbiEntryUntil) {
        set(PROPERTY_SPRBIENTRYUNTIL, sprbiEntryUntil);
    }

    public Timestamp getSprbiExitFrom() {
        return (Timestamp) get(PROPERTY_SPRBIEXITFROM);
    }

    public void setSprbiExitFrom(Timestamp sprbiExitFrom) {
        set(PROPERTY_SPRBIEXITFROM, sprbiExitFrom);
    }

    public Timestamp getSprbiExitUntil() {
        return (Timestamp) get(PROPERTY_SPRBIEXITUNTIL);
    }

    public void setSprbiExitUntil(Timestamp sprbiExitUntil) {
        set(PROPERTY_SPRBIEXITUNTIL, sprbiExitUntil);
    }

    public Timestamp getSprbiMinuteDelayParameter() {
        return (Timestamp) get(PROPERTY_SPRBIMINUTEDELAYPARAMETER);
    }

    public void setSprbiMinuteDelayParameter(Timestamp sprbiMinuteDelayParameter) {
        set(PROPERTY_SPRBIMINUTEDELAYPARAMETER, sprbiMinuteDelayParameter);
    }

    public Timestamp getSprbiOvertimeParameter() {
        return (Timestamp) get(PROPERTY_SPRBIOVERTIMEPARAMETER);
    }

    public void setSprbiOvertimeParameter(Timestamp sprbiOvertimeParameter) {
        set(PROPERTY_SPRBIOVERTIMEPARAMETER, sprbiOvertimeParameter);
    }

    public Timestamp getSprbiFeedParam() {
        return (Timestamp) get(PROPERTY_SPRBIFEEDPARAM);
    }

    public void setSprbiFeedParam(Timestamp sprbiFeedParam) {
        set(PROPERTY_SPRBIFEEDPARAM, sprbiFeedParam);
    }

    public BigDecimal getSprbiFeedValue() {
        return (BigDecimal) get(PROPERTY_SPRBIFEEDVALUE);
    }

    public void setSprbiFeedValue(BigDecimal sprbiFeedValue) {
        set(PROPERTY_SPRBIFEEDVALUE, sprbiFeedValue);
    }

    public Timestamp getSprbiHoursMaxDay() {
        return (Timestamp) get(PROPERTY_SPRBIHOURSMAXDAY);
    }

    public void setSprbiHoursMaxDay(Timestamp sprbiHoursMaxDay) {
        set(PROPERTY_SPRBIHOURSMAXDAY, sprbiHoursMaxDay);
    }

    public Timestamp getSprbiHoursMaxWeek() {
        return (Timestamp) get(PROPERTY_SPRBIHOURSMAXWEEK);
    }

    public void setSprbiHoursMaxWeek(Timestamp sprbiHoursMaxWeek) {
        set(PROPERTY_SPRBIHOURSMAXWEEK, sprbiHoursMaxWeek);
    }

    public Timestamp getSprbiHoursMinWorked() {
        return (Timestamp) get(PROPERTY_SPRBIHOURSMINWORKED);
    }

    public void setSprbiHoursMinWorked(Timestamp sprbiHoursMinWorked) {
        set(PROPERTY_SPRBIHOURSMINWORKED, sprbiHoursMinWorked);
    }

    public BigDecimal getSprbiHoursMaxMonth() {
        return (BigDecimal) get(PROPERTY_SPRBIHOURSMAXMONTH);
    }

    public void setSprbiHoursMaxMonth(BigDecimal sprbiHoursMaxMonth) {
        set(PROPERTY_SPRBIHOURSMAXMONTH, sprbiHoursMaxMonth);
    }

    public Timestamp getSprovMinimumOvertime() {
        return (Timestamp) get(PROPERTY_SPROVMINIMUMOVERTIME);
    }

    public void setSprovMinimumOvertime(Timestamp sprovMinimumOvertime) {
        set(PROPERTY_SPROVMINIMUMOVERTIME, sprovMinimumOvertime);
    }

    public Timestamp getSprovWorkingHours() {
        return (Timestamp) get(PROPERTY_SPROVWORKINGHOURS);
    }

    public void setSprovWorkingHours(Timestamp sprovWorkingHours) {
        set(PROPERTY_SPROVWORKINGHOURS, sprovWorkingHours);
    }

    public Boolean isSprbiConfigurationLines() {
        return (Boolean) get(PROPERTY_SPRBICONFIGURATIONLINES);
    }

    public void setSprbiConfigurationLines(Boolean sprbiConfigurationLines) {
        set(PROPERTY_SPRBICONFIGURATIONLINES, sprbiConfigurationLines);
    }

    @SuppressWarnings("unchecked")
    public List<SprovEmployeeOvertime> getSPROVEmployeeOvertimeList() {
      return (List<SprovEmployeeOvertime>) get(PROPERTY_SPROVEMPLOYEEOVERTIMELIST);
    }

    public void setSPROVEmployeeOvertimeList(List<SprovEmployeeOvertime> sPROVEmployeeOvertimeList) {
        set(PROPERTY_SPROVEMPLOYEEOVERTIMELIST, sPROVEmployeeOvertimeList);
    }

    @SuppressWarnings("unchecked")
    public List<Contract> getSSPRContractList() {
      return (List<Contract>) get(PROPERTY_SSPRCONTRACTLIST);
    }

    public void setSSPRContractList(List<Contract> sSPRContractList) {
        set(PROPERTY_SSPRCONTRACTLIST, sSPRContractList);
    }

    @SuppressWarnings("unchecked")
    public List<SprbiDays> getSprbiDaysList() {
      return (List<SprbiDays>) get(PROPERTY_SPRBIDAYSLIST);
    }

    public void setSprbiDaysList(List<SprbiDays> sprbiDaysList) {
        set(PROPERTY_SPRBIDAYSLIST, sprbiDaysList);
    }

    @SuppressWarnings("unchecked")
    public List<sshrJob> getSshrJobList() {
      return (List<sshrJob>) get(PROPERTY_SSHRJOBLIST);
    }

    public void setSshrJobList(List<sshrJob> sshrJobList) {
        set(PROPERTY_SSHRJOBLIST, sshrJobList);
    }

}
