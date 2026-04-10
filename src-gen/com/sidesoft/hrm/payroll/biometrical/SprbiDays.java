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
package com.sidesoft.hrm.payroll.biometrical;

import com.sidesoft.hrm.payroll.Shift;

import java.sql.Timestamp;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
/**
 * Entity class for entity sprbi_days (stored in table sprbi_days).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SprbiDays extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sprbi_days";
    public static final String ENTITY_NAME = "sprbi_days";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINENO = "lineNo";
    public static final String PROPERTY_DAY = "day";
    public static final String PROPERTY_NAMEIESSRATE = "nameIESSRate";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SHIFT = "shift";
    public static final String PROPERTY_STARTINGTIME = "startingTime";
    public static final String PROPERTY_ENTRY = "entry";
    public static final String PROPERTY_ENTRYFROM = "entryFrom";
    public static final String PROPERTY_ENTRYUNTIL = "entryUntil";
    public static final String PROPERTY_MINUTEDELAYPARAM = "minuteDelayParam";
    public static final String PROPERTY_ENDINGTIME = "endingTime";
    public static final String PROPERTY_EXIT = "exit";
    public static final String PROPERTY_EXITFROM = "exitFrom";
    public static final String PROPERTY_EXITUNTIL = "exitUntil";
    public static final String PROPERTY_OVERTIMEPARAM = "overtimeParam";

    public SprbiDays() {
        setDefaultValue(PROPERTY_ACTIVE, true);
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

    public Long getLineNo() {
        return (Long) get(PROPERTY_LINENO);
    }

    public void setLineNo(Long lineNo) {
        set(PROPERTY_LINENO, lineNo);
    }

    public String getDay() {
        return (String) get(PROPERTY_DAY);
    }

    public void setDay(String day) {
        set(PROPERTY_DAY, day);
    }

    public String getNameIESSRate() {
        return (String) get(PROPERTY_NAMEIESSRATE);
    }

    public void setNameIESSRate(String nameIESSRate) {
        set(PROPERTY_NAMEIESSRATE, nameIESSRate);
    }

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public Shift getShift() {
        return (Shift) get(PROPERTY_SHIFT);
    }

    public void setShift(Shift shift) {
        set(PROPERTY_SHIFT, shift);
    }

    public Timestamp getStartingTime() {
        return (Timestamp) get(PROPERTY_STARTINGTIME);
    }

    public void setStartingTime(Timestamp startingTime) {
        set(PROPERTY_STARTINGTIME, startingTime);
    }

    public Timestamp getEntry() {
        return (Timestamp) get(PROPERTY_ENTRY);
    }

    public void setEntry(Timestamp entry) {
        set(PROPERTY_ENTRY, entry);
    }

    public Timestamp getEntryFrom() {
        return (Timestamp) get(PROPERTY_ENTRYFROM);
    }

    public void setEntryFrom(Timestamp entryFrom) {
        set(PROPERTY_ENTRYFROM, entryFrom);
    }

    public Timestamp getEntryUntil() {
        return (Timestamp) get(PROPERTY_ENTRYUNTIL);
    }

    public void setEntryUntil(Timestamp entryUntil) {
        set(PROPERTY_ENTRYUNTIL, entryUntil);
    }

    public Timestamp getMinuteDelayParam() {
        return (Timestamp) get(PROPERTY_MINUTEDELAYPARAM);
    }

    public void setMinuteDelayParam(Timestamp minuteDelayParam) {
        set(PROPERTY_MINUTEDELAYPARAM, minuteDelayParam);
    }

    public Timestamp getEndingTime() {
        return (Timestamp) get(PROPERTY_ENDINGTIME);
    }

    public void setEndingTime(Timestamp endingTime) {
        set(PROPERTY_ENDINGTIME, endingTime);
    }

    public Timestamp getExit() {
        return (Timestamp) get(PROPERTY_EXIT);
    }

    public void setExit(Timestamp exit) {
        set(PROPERTY_EXIT, exit);
    }

    public Timestamp getExitFrom() {
        return (Timestamp) get(PROPERTY_EXITFROM);
    }

    public void setExitFrom(Timestamp exitFrom) {
        set(PROPERTY_EXITFROM, exitFrom);
    }

    public Timestamp getExitUntil() {
        return (Timestamp) get(PROPERTY_EXITUNTIL);
    }

    public void setExitUntil(Timestamp exitUntil) {
        set(PROPERTY_EXITUNTIL, exitUntil);
    }

    public Timestamp getOvertimeParam() {
        return (Timestamp) get(PROPERTY_OVERTIMEPARAM);
    }

    public void setOvertimeParam(Timestamp overtimeParam) {
        set(PROPERTY_OVERTIMEPARAM, overtimeParam);
    }

}
