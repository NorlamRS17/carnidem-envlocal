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

import java.math.BigDecimal;
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
 * Entity class for entity scrvro_route (stored in table scrvro_route).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Scrvro_Route extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scrvro_route";
    public static final String ENTITY_NAME = "scrvro_route";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SCRVROROUTEDAY = "scrvroRouteDay";
    public static final String PROPERTY_VISITORDER = "visitOrder";
    public static final String PROPERTY_BUSINESSPARTNER = "businessPartner";
    public static final String PROPERTY_DEBT = "debt";
    public static final String PROPERTY_LOCATIONLINK = "locationLink";
    public static final String PROPERTY_LATITUDE = "latitude";
    public static final String PROPERTY_LONGITUDE = "longitude";
    public static final String PROPERTY_DISTANCE = "distance";
    public static final String PROPERTY_DURATION = "duration";
    public static final String PROPERTY_STATUS = "status";
    public static final String PROPERTY_PROCESSED = "processed";
    public static final String PROPERTY_SCRVROVISITLIST = "scrvroVisitList";

    public Scrvro_Route() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PROCESSED, false);
        setDefaultValue(PROPERTY_SCRVROVISITLIST, new ArrayList<Object>());
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

    public Scrvro_RouteDay getScrvroRouteDay() {
        return (Scrvro_RouteDay) get(PROPERTY_SCRVROROUTEDAY);
    }

    public void setScrvroRouteDay(Scrvro_RouteDay scrvroRouteDay) {
        set(PROPERTY_SCRVROROUTEDAY, scrvroRouteDay);
    }

    public Long getVisitOrder() {
        return (Long) get(PROPERTY_VISITORDER);
    }

    public void setVisitOrder(Long visitOrder) {
        set(PROPERTY_VISITORDER, visitOrder);
    }

    public BusinessPartner getBusinessPartner() {
        return (BusinessPartner) get(PROPERTY_BUSINESSPARTNER);
    }

    public void setBusinessPartner(BusinessPartner businessPartner) {
        set(PROPERTY_BUSINESSPARTNER, businessPartner);
    }

    public BigDecimal getDebt() {
        return (BigDecimal) get(PROPERTY_DEBT);
    }

    public void setDebt(BigDecimal debt) {
        set(PROPERTY_DEBT, debt);
    }

    public String getLocationLink() {
        return (String) get(PROPERTY_LOCATIONLINK);
    }

    public void setLocationLink(String locationLink) {
        set(PROPERTY_LOCATIONLINK, locationLink);
    }

    public String getLatitude() {
        return (String) get(PROPERTY_LATITUDE);
    }

    public void setLatitude(String latitude) {
        set(PROPERTY_LATITUDE, latitude);
    }

    public String getLongitude() {
        return (String) get(PROPERTY_LONGITUDE);
    }

    public void setLongitude(String longitude) {
        set(PROPERTY_LONGITUDE, longitude);
    }

    public BigDecimal getDistance() {
        return (BigDecimal) get(PROPERTY_DISTANCE);
    }

    public void setDistance(BigDecimal distance) {
        set(PROPERTY_DISTANCE, distance);
    }

    public BigDecimal getDuration() {
        return (BigDecimal) get(PROPERTY_DURATION);
    }

    public void setDuration(BigDecimal duration) {
        set(PROPERTY_DURATION, duration);
    }

    public String getStatus() {
        return (String) get(PROPERTY_STATUS);
    }

    public void setStatus(String status) {
        set(PROPERTY_STATUS, status);
    }

    public Boolean isProcessed() {
        return (Boolean) get(PROPERTY_PROCESSED);
    }

    public void setProcessed(Boolean processed) {
        set(PROPERTY_PROCESSED, processed);
    }

    @SuppressWarnings("unchecked")
    public List<Scrvro_Visit> getScrvroVisitList() {
      return (List<Scrvro_Visit>) get(PROPERTY_SCRVROVISITLIST);
    }

    public void setScrvroVisitList(List<Scrvro_Visit> scrvroVisitList) {
        set(PROPERTY_SCRVROVISITLIST, scrvroVisitList);
    }

}
