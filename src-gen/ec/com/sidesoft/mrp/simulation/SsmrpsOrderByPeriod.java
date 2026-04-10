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
package ec.com.sidesoft.mrp.simulation;

import java.math.BigDecimal;
import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.calendar.Period;
/**
 * Entity class for entity SSMRPS_ORDERBYPERIOD (stored in table SSMRPS_ORDERBYPERIOD).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SsmrpsOrderByPeriod extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SSMRPS_ORDERBYPERIOD";
    public static final String ENTITY_NAME = "SSMRPS_ORDERBYPERIOD";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_LINE = "line";
    public static final String PROPERTY_YEARPURCHASE = "yearpurchase";
    public static final String PROPERTY_MONTHPURCHASE = "monthpurchase";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_ISCLUDEDMONTH = "iscludedmonth";
    public static final String PROPERTY_PROCESSID = "processid";

    public SsmrpsOrderByPeriod() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_ISCLUDEDMONTH, true);
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

    public BigDecimal getLine() {
        return (BigDecimal) get(PROPERTY_LINE);
    }

    public void setLine(BigDecimal line) {
        set(PROPERTY_LINE, line);
    }

    public BigDecimal getYearpurchase() {
        return (BigDecimal) get(PROPERTY_YEARPURCHASE);
    }

    public void setYearpurchase(BigDecimal yearpurchase) {
        set(PROPERTY_YEARPURCHASE, yearpurchase);
    }

    public BigDecimal getMonthpurchase() {
        return (BigDecimal) get(PROPERTY_MONTHPURCHASE);
    }

    public void setMonthpurchase(BigDecimal monthpurchase) {
        set(PROPERTY_MONTHPURCHASE, monthpurchase);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public Boolean isCludedmonth() {
        return (Boolean) get(PROPERTY_ISCLUDEDMONTH);
    }

    public void setCludedmonth(Boolean iscludedmonth) {
        set(PROPERTY_ISCLUDEDMONTH, iscludedmonth);
    }

    public String getProcessid() {
        return (String) get(PROPERTY_PROCESSID);
    }

    public void setProcessid(String processid) {
        set(PROPERTY_PROCESSID, processid);
    }

}
