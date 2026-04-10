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
package ec.com.sidesoft.crm.visitplan;

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
 * Entity class for entity scrvro_route_week (stored in table scrvro_route_week).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Scrvro_RouteWeek extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scrvro_route_week";
    public static final String ENTITY_NAME = "scrvro_route_week";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SCRVROROUTEPERIOD = "scrvroRoutePeriod";
    public static final String PROPERTY_WEEK = "week";
    public static final String PROPERTY_WEEKDETAIL = "weekDetail";
    public static final String PROPERTY_DATEFROM = "dateFrom";
    public static final String PROPERTY_DATETO = "dateTo";
    public static final String PROPERTY_BUSINESSAGENT = "businessAgent";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_CREATEROUTEJS = "createRouteJs";
    public static final String PROPERTY_RECALCULATEROUTEJS = "recalculateRouteJs";
    public static final String PROPERTY_SCRVROROUTEDAYLIST = "scrvroRouteDayList";

    public Scrvro_RouteWeek() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_WEEK, (long) 1);
        setDefaultValue(PROPERTY_WEEKDETAIL, "MANUAL");
        setDefaultValue(PROPERTY_STATUS, "P");
        setDefaultValue(PROPERTY_CREATEROUTEJS, false);
        setDefaultValue(PROPERTY_RECALCULATEROUTEJS, false);
        setDefaultValue(PROPERTY_SCRVROROUTEDAYLIST, new ArrayList<Object>());
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

    public Scrvro_RoutePeriod getScrvroRoutePeriod() {
        return (Scrvro_RoutePeriod) get(PROPERTY_SCRVROROUTEPERIOD);
    }

    public void setScrvroRoutePeriod(Scrvro_RoutePeriod scrvroRoutePeriod) {
        set(PROPERTY_SCRVROROUTEPERIOD, scrvroRoutePeriod);
    }

    public Long getWeek() {
        return (Long) get(PROPERTY_WEEK);
    }

    public void setWeek(Long week) {
        set(PROPERTY_WEEK, week);
    }

    public String getWeekDetail() {
        return (String) get(PROPERTY_WEEKDETAIL);
    }

    public void setWeekDetail(String weekDetail) {
        set(PROPERTY_WEEKDETAIL, weekDetail);
    }

    public Date getDateFrom() {
        return (Date) get(PROPERTY_DATEFROM);
    }

    public void setDateFrom(Date dateFrom) {
        set(PROPERTY_DATEFROM, dateFrom);
    }

    public Date getDateTo() {
        return (Date) get(PROPERTY_DATETO);
    }

    public void setDateTo(Date dateTo) {
        set(PROPERTY_DATETO, dateTo);
    }

    public BusinessPartner getBusinessAgent() {
        return (BusinessPartner) get(PROPERTY_BUSINESSAGENT);
    }

    public void setBusinessAgent(BusinessPartner businessAgent) {
        set(PROPERTY_BUSINESSAGENT, businessAgent);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isCreateRouteJs() {
        return (Boolean) get(PROPERTY_CREATEROUTEJS);
    }

    public void setCreateRouteJs(Boolean createRouteJs) {
        set(PROPERTY_CREATEROUTEJS, createRouteJs);
    }

    public Boolean isRecalculateRouteJs() {
        return (Boolean) get(PROPERTY_RECALCULATEROUTEJS);
    }

    public void setRecalculateRouteJs(Boolean recalculateRouteJs) {
        set(PROPERTY_RECALCULATEROUTEJS, recalculateRouteJs);
    }

    @SuppressWarnings("unchecked")
    public List<Scrvro_RouteDay> getScrvroRouteDayList() {
      return (List<Scrvro_RouteDay>) get(PROPERTY_SCRVROROUTEDAYLIST);
    }

    public void setScrvroRouteDayList(List<Scrvro_RouteDay> scrvroRouteDayList) {
        set(PROPERTY_SCRVROROUTEDAYLIST, scrvroRouteDayList);
    }

}
