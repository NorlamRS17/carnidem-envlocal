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
package ec.com.sidesoft.payroll.events;

import com.sidesoft.hrm.payroll.Concept;

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
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.gl.GLItem;
/**
 * Entity class for entity SPEV_Config_News (stored in table SPEV_Config_News).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SPEVConfigNews extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SPEV_Config_News";
    public static final String ENTITY_NAME = "SPEV_Config_News";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_SPEVMAINTENANCENEWS = "spevMaintenanceNews";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_PERCENTAGE = "percentage";
    public static final String PROPERTY_BOSS = "boss";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_STARTDATE = "startDate";
    public static final String PROPERTY_ENDDATE = "eNDDate";
    public static final String PROPERTY_FUNCTION = "function";
    public static final String PROPERTY_UTILITIES = "utilities";
    public static final String PROPERTY_STARTDAY = "startDay";
    public static final String PROPERTY_ENDDAY = "eNDDay";
    public static final String PROPERTY_SPEVCONFIGNEWSLINELIST = "sPEVConfigNewslineList";
    public static final String PROPERTY_SPEVDETAILNEWSLIST = "sPEVDetailNewsList";
    public static final String PROPERTY_SPEVPRODUCTCATEGORYLIST = "sPEVProductCategoryList";

    public SPEVConfigNews() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_PERCENTAGE, new BigDecimal(0));
        setDefaultValue(PROPERTY_BOSS, false);
        setDefaultValue(PROPERTY_SPEVCONFIGNEWSLINELIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEVDETAILNEWSLIST, new ArrayList<Object>());
        setDefaultValue(PROPERTY_SPEVPRODUCTCATEGORYLIST, new ArrayList<Object>());
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

    public SPEVMaintenanceNews getSpevMaintenanceNews() {
        return (SPEVMaintenanceNews) get(PROPERTY_SPEVMAINTENANCENEWS);
    }

    public void setSpevMaintenanceNews(SPEVMaintenanceNews spevMaintenanceNews) {
        set(PROPERTY_SPEVMAINTENANCENEWS, spevMaintenanceNews);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    public BigDecimal getPercentage() {
        return (BigDecimal) get(PROPERTY_PERCENTAGE);
    }

    public void setPercentage(BigDecimal percentage) {
        set(PROPERTY_PERCENTAGE, percentage);
    }

    public Boolean isBoss() {
        return (Boolean) get(PROPERTY_BOSS);
    }

    public void setBoss(Boolean boss) {
        set(PROPERTY_BOSS, boss);
    }

    public BigDecimal getValue() {
        return (BigDecimal) get(PROPERTY_VALUE);
    }

    public void setValue(BigDecimal value) {
        set(PROPERTY_VALUE, value);
    }

    public Date getStartDate() {
        return (Date) get(PROPERTY_STARTDATE);
    }

    public void setStartDate(Date startDate) {
        set(PROPERTY_STARTDATE, startDate);
    }

    public Date getENDDate() {
        return (Date) get(PROPERTY_ENDDATE);
    }

    public void setENDDate(Date eNDDate) {
        set(PROPERTY_ENDDATE, eNDDate);
    }

    public String getFunction() {
        return (String) get(PROPERTY_FUNCTION);
    }

    public void setFunction(String function) {
        set(PROPERTY_FUNCTION, function);
    }

    public BigDecimal getUtilities() {
        return (BigDecimal) get(PROPERTY_UTILITIES);
    }

    public void setUtilities(BigDecimal utilities) {
        set(PROPERTY_UTILITIES, utilities);
    }

    public Long getStartDay() {
        return (Long) get(PROPERTY_STARTDAY);
    }

    public void setStartDay(Long startDay) {
        set(PROPERTY_STARTDAY, startDay);
    }

    public Long getENDDay() {
        return (Long) get(PROPERTY_ENDDAY);
    }

    public void setENDDay(Long eNDDay) {
        set(PROPERTY_ENDDAY, eNDDay);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVConfigNewsline> getSPEVConfigNewslineList() {
      return (List<SPEVConfigNewsline>) get(PROPERTY_SPEVCONFIGNEWSLINELIST);
    }

    public void setSPEVConfigNewslineList(List<SPEVConfigNewsline> sPEVConfigNewslineList) {
        set(PROPERTY_SPEVCONFIGNEWSLINELIST, sPEVConfigNewslineList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVDetailNews> getSPEVDetailNewsList() {
      return (List<SPEVDetailNews>) get(PROPERTY_SPEVDETAILNEWSLIST);
    }

    public void setSPEVDetailNewsList(List<SPEVDetailNews> sPEVDetailNewsList) {
        set(PROPERTY_SPEVDETAILNEWSLIST, sPEVDetailNewsList);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVProductCategory> getSPEVProductCategoryList() {
      return (List<SPEVProductCategory>) get(PROPERTY_SPEVPRODUCTCATEGORYLIST);
    }

    public void setSPEVProductCategoryList(List<SPEVProductCategory> sPEVProductCategoryList) {
        set(PROPERTY_SPEVPRODUCTCATEGORYLIST, sPEVProductCategoryList);
    }

}
