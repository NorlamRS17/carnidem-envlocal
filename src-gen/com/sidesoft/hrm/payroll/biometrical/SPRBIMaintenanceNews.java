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

import com.sidesoft.hrm.payroll.Concept;

import ec.com.sidesoft.payroll.overtime.sprovnewness;

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
/**
 * Entity class for entity SPRBI_Maintenance_News (stored in table SPRBI_Maintenance_News).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class SPRBIMaintenanceNews extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "SPRBI_Maintenance_News";
    public static final String ENTITY_NAME = "SPRBI_Maintenance_News";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_DESCRIPTION = "description";
    public static final String PROPERTY_SEARCHKEY = "searchKey";
    public static final String PROPERTY_CONCEPT = "concept";
    public static final String PROPERTY_VALID = "valid";
    public static final String PROPERTY_FORMULA = "formula";
    public static final String PROPERTY_FORMULATES = "formulates";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_SPROVNEWNESSLIST = "sprovNewnessList";

    public SPRBIMaintenanceNews() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_VALID, true);
        setDefaultValue(PROPERTY_FORMULA, true);
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

    public String getDescription() {
        return (String) get(PROPERTY_DESCRIPTION);
    }

    public void setDescription(String description) {
        set(PROPERTY_DESCRIPTION, description);
    }

    public String getSearchKey() {
        return (String) get(PROPERTY_SEARCHKEY);
    }

    public void setSearchKey(String searchKey) {
        set(PROPERTY_SEARCHKEY, searchKey);
    }

    public Concept getConcept() {
        return (Concept) get(PROPERTY_CONCEPT);
    }

    public void setConcept(Concept concept) {
        set(PROPERTY_CONCEPT, concept);
    }

    public Boolean isValid() {
        return (Boolean) get(PROPERTY_VALID);
    }

    public void setValid(Boolean valid) {
        set(PROPERTY_VALID, valid);
    }

    public Boolean isFormula() {
        return (Boolean) get(PROPERTY_FORMULA);
    }

    public void setFormula(Boolean formula) {
        set(PROPERTY_FORMULA, formula);
    }

    public String getFormulates() {
        return (String) get(PROPERTY_FORMULATES);
    }

    public void setFormulates(String formulates) {
        set(PROPERTY_FORMULATES, formulates);
    }

    public BigDecimal getValue() {
        return (BigDecimal) get(PROPERTY_VALUE);
    }

    public void setValue(BigDecimal value) {
        set(PROPERTY_VALUE, value);
    }

    @SuppressWarnings("unchecked")
    public List<sprovnewness> getSprovNewnessList() {
      return (List<sprovnewness>) get(PROPERTY_SPROVNEWNESSLIST);
    }

    public void setSprovNewnessList(List<sprovnewness> sprovNewnessList) {
        set(PROPERTY_SPROVNEWNESSLIST, sprovNewnessList);
    }

}
