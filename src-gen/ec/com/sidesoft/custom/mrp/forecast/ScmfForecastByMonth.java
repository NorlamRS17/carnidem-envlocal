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
package ec.com.sidesoft.custom.mrp.forecast;

import java.util.Date;

import org.openbravo.base.structure.ActiveEnabled;
import org.openbravo.base.structure.BaseOBObject;
import org.openbravo.base.structure.ClientEnabled;
import org.openbravo.base.structure.OrganizationEnabled;
import org.openbravo.base.structure.Traceable;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.system.Client;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.common.plm.Product;
/**
 * Entity class for entity scmf_forecastbymonth (stored in table scmf_forecastbymonth).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class ScmfForecastByMonth extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scmf_forecastbymonth";
    public static final String ENTITY_NAME = "scmf_forecastbymonth";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_MONDAY = "monday";
    public static final String PROPERTY_TUESDAY = "tuesday";
    public static final String PROPERTY_WEDNESDAY = "wednesday";
    public static final String PROPERTY_THURSDAY = "thursday";
    public static final String PROPERTY_FRIDAY = "friday";
    public static final String PROPERTY_SATURDAY = "saturday";
    public static final String PROPERTY_SUNDAY = "sunday";
    public static final String PROPERTY_DAYFORECAST = "dayforecast";
    public static final String PROPERTY_MONTHFORECAST = "monthforecast";
    public static final String PROPERTY_YEARFORECAST = "yearforecast";
    public static final String PROPERTY_PRODUCT = "product";
    public static final String PROPERTY_WEEKNUMBER = "weeknumber";
    public static final String PROPERTY_STARTINGDATE = "startingDate";
    public static final String PROPERTY_ENDINGDATE = "endingDate";

    public ScmfForecastByMonth() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_WEEKNUMBER, (long) 0);
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

    public Long getMonday() {
        return (Long) get(PROPERTY_MONDAY);
    }

    public void setMonday(Long monday) {
        set(PROPERTY_MONDAY, monday);
    }

    public Long getTuesday() {
        return (Long) get(PROPERTY_TUESDAY);
    }

    public void setTuesday(Long tuesday) {
        set(PROPERTY_TUESDAY, tuesday);
    }

    public Long getWednesday() {
        return (Long) get(PROPERTY_WEDNESDAY);
    }

    public void setWednesday(Long wednesday) {
        set(PROPERTY_WEDNESDAY, wednesday);
    }

    public Long getThursday() {
        return (Long) get(PROPERTY_THURSDAY);
    }

    public void setThursday(Long thursday) {
        set(PROPERTY_THURSDAY, thursday);
    }

    public Long getFriday() {
        return (Long) get(PROPERTY_FRIDAY);
    }

    public void setFriday(Long friday) {
        set(PROPERTY_FRIDAY, friday);
    }

    public Long getSaturday() {
        return (Long) get(PROPERTY_SATURDAY);
    }

    public void setSaturday(Long saturday) {
        set(PROPERTY_SATURDAY, saturday);
    }

    public Long getSunday() {
        return (Long) get(PROPERTY_SUNDAY);
    }

    public void setSunday(Long sunday) {
        set(PROPERTY_SUNDAY, sunday);
    }

    public Long getDayforecast() {
        return (Long) get(PROPERTY_DAYFORECAST);
    }

    public void setDayforecast(Long dayforecast) {
        set(PROPERTY_DAYFORECAST, dayforecast);
    }

    public Long getMonthforecast() {
        return (Long) get(PROPERTY_MONTHFORECAST);
    }

    public void setMonthforecast(Long monthforecast) {
        set(PROPERTY_MONTHFORECAST, monthforecast);
    }

    public Long getYearforecast() {
        return (Long) get(PROPERTY_YEARFORECAST);
    }

    public void setYearforecast(Long yearforecast) {
        set(PROPERTY_YEARFORECAST, yearforecast);
    }

    public Product getProduct() {
        return (Product) get(PROPERTY_PRODUCT);
    }

    public void setProduct(Product product) {
        set(PROPERTY_PRODUCT, product);
    }

    public Long getWeeknumber() {
        return (Long) get(PROPERTY_WEEKNUMBER);
    }

    public void setWeeknumber(Long weeknumber) {
        set(PROPERTY_WEEKNUMBER, weeknumber);
    }

    public Date getStartingDate() {
        return (Date) get(PROPERTY_STARTINGDATE);
    }

    public void setStartingDate(Date startingDate) {
        set(PROPERTY_STARTINGDATE, startingDate);
    }

    public Date getEndingDate() {
        return (Date) get(PROPERTY_ENDINGDATE);
    }

    public void setEndingDate(Date endingDate) {
        set(PROPERTY_ENDINGDATE, endingDate);
    }

}
