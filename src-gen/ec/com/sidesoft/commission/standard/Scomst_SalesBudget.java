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
package ec.com.sidesoft.commission.standard;

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
import org.openbravo.model.sales.CommissionRun;
/**
 * Entity class for entity scomst_sales_budget (stored in table scomst_sales_budget).
 *
 * NOTE: This class should not be instantiated directly. To instantiate this
 * class the {@link org.openbravo.base.provider.OBProvider} should be used.
 */
public class Scomst_SalesBudget extends BaseOBObject implements Traceable, ClientEnabled, OrganizationEnabled, ActiveEnabled {
    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "scomst_sales_budget";
    public static final String ENTITY_NAME = "scomst_sales_budget";
    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_CLIENT = "client";
    public static final String PROPERTY_ORGANIZATION = "organization";
    public static final String PROPERTY_ACTIVE = "active";
    public static final String PROPERTY_CREATIONDATE = "creationDate";
    public static final String PROPERTY_CREATEDBY = "createdBy";
    public static final String PROPERTY_UPDATED = "updated";
    public static final String PROPERTY_UPDATEDBY = "updatedBy";
    public static final String PROPERTY_COMMISSIONRUN = "commissionRun";
    public static final String PROPERTY_AMOUNT = "amount";
    public static final String PROPERTY_ACTUALAMOUNT = "actualAmount";
    public static final String PROPERTY_SALESBUDGET = "salesBudget";
    public static final String PROPERTY_SALESBUDGETEXPECTED = "salesBudgetExpected";
    public static final String PROPERTY_SALEPERCENTAGEPAID = "salePercentagePaid";
    public static final String PROPERTY_ISFULFILLED = "isFulfilled";

    public Scomst_SalesBudget() {
        setDefaultValue(PROPERTY_ACTIVE, true);
        setDefaultValue(PROPERTY_AMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_ACTUALAMOUNT, new BigDecimal(0));
        setDefaultValue(PROPERTY_SALESBUDGET, new BigDecimal(0));
        setDefaultValue(PROPERTY_SALESBUDGETEXPECTED, new BigDecimal(0));
        setDefaultValue(PROPERTY_SALEPERCENTAGEPAID, new BigDecimal(0));
        setDefaultValue(PROPERTY_ISFULFILLED, false);
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

    public CommissionRun getCommissionRun() {
        return (CommissionRun) get(PROPERTY_COMMISSIONRUN);
    }

    public void setCommissionRun(CommissionRun commissionRun) {
        set(PROPERTY_COMMISSIONRUN, commissionRun);
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(PROPERTY_AMOUNT);
    }

    public void setAmount(BigDecimal amount) {
        set(PROPERTY_AMOUNT, amount);
    }

    public BigDecimal getActualAmount() {
        return (BigDecimal) get(PROPERTY_ACTUALAMOUNT);
    }

    public void setActualAmount(BigDecimal actualAmount) {
        set(PROPERTY_ACTUALAMOUNT, actualAmount);
    }

    public BigDecimal getSalesBudget() {
        return (BigDecimal) get(PROPERTY_SALESBUDGET);
    }

    public void setSalesBudget(BigDecimal salesBudget) {
        set(PROPERTY_SALESBUDGET, salesBudget);
    }

    public BigDecimal getSalesBudgetExpected() {
        return (BigDecimal) get(PROPERTY_SALESBUDGETEXPECTED);
    }

    public void setSalesBudgetExpected(BigDecimal salesBudgetExpected) {
        set(PROPERTY_SALESBUDGETEXPECTED, salesBudgetExpected);
    }

    public BigDecimal getSalePercentagePaid() {
        return (BigDecimal) get(PROPERTY_SALEPERCENTAGEPAID);
    }

    public void setSalePercentagePaid(BigDecimal salePercentagePaid) {
        set(PROPERTY_SALEPERCENTAGEPAID, salePercentagePaid);
    }

    public Boolean isFulfilled() {
        return (Boolean) get(PROPERTY_ISFULFILLED);
    }

    public void setFulfilled(Boolean isFulfilled) {
        set(PROPERTY_ISFULFILLED, isFulfilled);
    }

}
