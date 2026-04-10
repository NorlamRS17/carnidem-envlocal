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
 * Entity class for entity sspr_actuarial_calc_study (stored in table sspr_actuarial_calc_study).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Sspr_ActuarialCalcStudy extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "sspr_actuarial_calc_study";
    public static final String ENTITY_NAME = "sspr_actuarial_calc_study";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_PERIOD = "period";
    public static final String PROPERTY_TAXID = "taxID";
    public static final String PROPERTY_NAME = "name";
    public static final String PROPERTY_DATEBIRTH = "dateBirth";
    public static final String PROPERTY_DATEADMISSION = "dateAdmission";
    public static final String PROPERTY_AGE = "age";
    public static final String PROPERTY_TS = "tS";
    public static final String PROPERTY_REMUNERATION = "remuneration";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_OBLIGATION = "obligation";
    public static final String PROPERTY_COST = "cost";
    public static final String PROPERTY_INTEREST = "interest";
    public static final String PROPERTY_TOTAL = "total";
    public static final String PROPERTY_SEX = "sex";
    public static final String PROPERTY_STATUSACTUARIAL = "statusActuarial";
    public static final String PROPERTY_DEFERREDTAXGENERATION = "deferredTaxGeneration";
    public static final String PROPERTY_DEFERREDTAXREVERSAL = "deferredTaxReversal";

    public Sspr_ActuarialCalcStudy() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_REMUNERATION, new BigDecimal(0));
        setDefaultValue(PROPERTY_OBLIGATION, new BigDecimal(0));
        setDefaultValue(PROPERTY_COST, new BigDecimal(0));
        setDefaultValue(PROPERTY_INTEREST, new BigDecimal(0));
        setDefaultValue(PROPERTY_TOTAL, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEFERREDTAXGENERATION, new BigDecimal(0));
        setDefaultValue(PROPERTY_DEFERREDTAXREVERSAL, new BigDecimal(0));
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

    public Period getPeriod() {
        return (Period) get(PROPERTY_PERIOD);
    }

    public void setPeriod(Period period) {
        set(PROPERTY_PERIOD, period);
    }

    public String getTaxID() {
        return (String) get(PROPERTY_TAXID);
    }

    public void setTaxID(String taxID) {
        set(PROPERTY_TAXID, taxID);
    }

    public String getName() {
        return (String) get(PROPERTY_NAME);
    }

    public void setName(String name) {
        set(PROPERTY_NAME, name);
    }

    public Date getDateBirth() {
        return (Date) get(PROPERTY_DATEBIRTH);
    }

    public void setDateBirth(Date dateBirth) {
        set(PROPERTY_DATEBIRTH, dateBirth);
    }

    public Date getDateAdmission() {
        return (Date) get(PROPERTY_DATEADMISSION);
    }

    public void setDateAdmission(Date dateAdmission) {
        set(PROPERTY_DATEADMISSION, dateAdmission);
    }

    public Long getAge() {
        return (Long) get(PROPERTY_AGE);
    }

    public void setAge(Long age) {
        set(PROPERTY_AGE, age);
    }

    public BigDecimal getTS() {
        return (BigDecimal) get(PROPERTY_TS);
    }

    public void setTS(BigDecimal tS) {
        set(PROPERTY_TS, tS);
    }

    public BigDecimal getRemuneration() {
        return (BigDecimal) get(PROPERTY_REMUNERATION);
    }

    public void setRemuneration(BigDecimal remuneration) {
        set(PROPERTY_REMUNERATION, remuneration);
    }

    public String getConcept() {
        return (String) get(PROPERTY_CONCEPT);
    }

    public void setConcept(String concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public BigDecimal getObligation() {
        return (BigDecimal) get(PROPERTY_OBLIGATION);
    }

    public void setObligation(BigDecimal obligation) {
        set(PROPERTY_OBLIGATION, obligation);
    }

    public BigDecimal getCost() {
        return (BigDecimal) get(PROPERTY_COST);
    }

    public void setCost(BigDecimal cost) {
        set(PROPERTY_COST, cost);
    }

    public BigDecimal getInterest() {
        return (BigDecimal) get(PROPERTY_INTEREST);
    }

    public void setInterest(BigDecimal interest) {
        set(PROPERTY_INTEREST, interest);
    }

    public BigDecimal getTotal() {
        return (BigDecimal) get(PROPERTY_TOTAL);
    }

    public void setTotal(BigDecimal total) {
        set(PROPERTY_TOTAL, total);
    }

    public String getSex() {
        return (String) get(PROPERTY_SEX);
    }

    public void setSex(String sex) {
        set(PROPERTY_SEX, sex);
    }

    public String getStatusActuarial() {
        return (String) get(PROPERTY_STATUSACTUARIAL);
    }

    public void setStatusActuarial(String statusActuarial) {
        set(PROPERTY_STATUSACTUARIAL, statusActuarial);
    }

    public BigDecimal getDeferredTaxGeneration() {
        return (BigDecimal) get(PROPERTY_DEFERREDTAXGENERATION);
    }

    public void setDeferredTaxGeneration(BigDecimal deferredTaxGeneration) {
        set(PROPERTY_DEFERREDTAXGENERATION, deferredTaxGeneration);
    }

    public BigDecimal getDeferredTaxReversal() {
        return (BigDecimal) get(PROPERTY_DEFERREDTAXREVERSAL);
    }

    public void setDeferredTaxReversal(BigDecimal deferredTaxReversal) {
        set(PROPERTY_DEFERREDTAXREVERSAL, deferredTaxReversal);
    }

}
