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
import org.openbravo.model.common.businesspartner.BusinessPartner;
import org.openbravo.model.common.enterprise.Organization;
import org.openbravo.model.financialmgmt.accounting.Costcenter;
import org.openbravo.model.financialmgmt.calendar.Period;
import org.openbravo.model.financialmgmt.gl.GLItem;
/**
 * Entity class for entity SPEV_Detail_News (stored in table SPEV_Detail_News).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SPEVDetailNews extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SPEV_Detail_News";
    public static final String ENTITY_NAME = "SPEV_Detail_News";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DATEDETAIL = "dateDetail";
    public static final String PROPERTY_DOUMENTNO = "doumentno";
    public static final String PROPERTY_BPARTNER = "bpartner";
    public static final String PROPERTY_SPEVCONFIGNEWS = "spevConfigNews";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_SSPRCONCEPT = "ssprConcept";
    public static final String PROPERTY_CONCEPTTYPE = "conceptType";
    public static final String PROPERTY_TYPE = "type";
    public static final String PROPERTY_PROCESS = "process";
    public static final String PROPERTY_SPEVMAINTENANCENEWS = "spevMaintenanceNews";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_ORDERNUMBER = "orderNumber";
    public static final String PROPERTY_GLITEM = "glitem";
    public static final String PROPERTY_COSTCENTER = "costcenter";
    public static final String PROPERTY_SPEVAUDITDETAILLIST = "sPEVAuditDetailList";

    public SPEVDetailNews() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_SPEVAUDITDETAILLIST, new ArrayList<Object>());
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

    public Date getDateDetail() {
        return (Date) get(PROPERTY_DATEDETAIL);
    }

    public void setDateDetail(Date dateDetail) {
        set(PROPERTY_DATEDETAIL, dateDetail);
    }

    public String getDoumentno() {
        return (String) get(PROPERTY_DOUMENTNO);
    }

    public void setDoumentno(String doumentno) {
        set(PROPERTY_DOUMENTNO, doumentno);
    }

    public BusinessPartner getBpartner() {
        return (BusinessPartner) get(PROPERTY_BPARTNER);
    }

    public void setBpartner(BusinessPartner bpartner) {
        set(PROPERTY_BPARTNER, bpartner);
    }

    public SPEVConfigNews getSpevConfigNews() {
        return (SPEVConfigNews) get(PROPERTY_SPEVCONFIGNEWS);
    }

    public void setSpevConfigNews(SPEVConfigNews spevConfigNews) {
        set(PROPERTY_SPEVCONFIGNEWS, spevConfigNews);
    }

    public BigDecimal getValue() {
        return (BigDecimal) get(PROPERTY_VALUE);
    }

    public void setValue(BigDecimal value) {
        set(PROPERTY_VALUE, value);
    }

    public Concept getSsprConcept() {
        return (Concept) get(PROPERTY_SSPRCONCEPT);
    }

    public void setSsprConcept(Concept ssprConcept) {
        set(PROPERTY_SSPRCONCEPT, ssprConcept);
    }

    public String getConceptType() {
        return (String) get(PROPERTY_CONCEPTTYPE);
    }

    public void setConceptType(String conceptType) {
        set(PROPERTY_CONCEPTTYPE, conceptType);
    }

    public String getType() {
        return (String) get(PROPERTY_TYPE);
    }

    public void setType(String type) {
        set(PROPERTY_TYPE, type);
    }

    public String getProcess() {
        return (String) get(PROPERTY_PROCESS);
    }

    public void setProcess(String process) {
        set(PROPERTY_PROCESS, process);
    }

    public SPEVMaintenanceNews getSpevMaintenanceNews() {
        return (SPEVMaintenanceNews) get(PROPERTY_SPEVMAINTENANCENEWS);
    }

    public void setSpevMaintenanceNews(SPEVMaintenanceNews spevMaintenanceNews) {
        set(PROPERTY_SPEVMAINTENANCENEWS, spevMaintenanceNews);
    }

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public String getOrderNumber() {
        return (String) get(PROPERTY_ORDERNUMBER);
    }

    public void setOrderNumber(String orderNumber) {
        set(PROPERTY_ORDERNUMBER, orderNumber);
    }

    public GLItem getGlitem() {
        return (GLItem) get(PROPERTY_GLITEM);
    }

    public void setGlitem(GLItem glitem) {
        set(PROPERTY_GLITEM, glitem);
    }

    public Costcenter getCostcenter() {
        return (Costcenter) get(PROPERTY_COSTCENTER);
    }

    public void setCostcenter(Costcenter costcenter) {
        set(PROPERTY_COSTCENTER, costcenter);
    }

    @SuppressWarnings("unchecked")
    public List<SPEVAuditDetail> getSPEVAuditDetailList() {
      return (List<SPEVAuditDetail>) get(PROPERTY_SPEVAUDITDETAILLIST);
    }

    public void setSPEVAuditDetailList(List<SPEVAuditDetail> sPEVAuditDetailList) {
        set(PROPERTY_SPEVAUDITDETAILLIST, sPEVAuditDetailList);
    }

}
